package com.lesha.criminalintent.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.room.Room
import com.lesha.criminalintent.data.database.CrimeDatabase
import com.lesha.criminalintent.data.mapper.CrimeEntityMapper
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.repository.CrimeRepository
import java.util.*
import java.util.concurrent.Executors

class CrimeRepositoryImpl private constructor(
    context: Context,
    private val mapper: CrimeEntityMapper
) : CrimeRepository {

    private val executor = Executors.newSingleThreadExecutor()

    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()


    override fun add(crime: Crime) {
        executor.execute {
            crimeDao.addCrime(mapper.toCrimeEntity(crime))
        }
    }

    override fun delete(crime: Crime) {
        executor.execute {
            crimeDao.deleteCrime(mapper.toCrimeEntity(crime))
        }
    }

    override fun update(crime: Crime) {
        executor.execute {
            crimeDao.updateCrime(mapper.toCrimeEntity(crime))
        }
    }

    override fun get(crimeId: UUID): LiveData<Crime> {
        return Transformations.map(crimeDao.getCrime(crimeId)) { crimeEntity ->
            mapper.toCrime(crimeEntity)
        }
    }

    override fun getAll(): LiveData<List<Crime>> {
        return Transformations.map(crimeDao.getAll()) { crimeEntities ->
            crimeEntities.map {
                mapper.toCrime(it)
            }
        }
    }

    companion object {
        private const val DATABASE_NAME = "CrimeDatabase"

        private var INSTANCE: CrimeRepositoryImpl? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepositoryImpl(context, CrimeEntityMapper())
            }
        }

        fun get(): CrimeRepositoryImpl {
            return INSTANCE ?: throw IllegalStateException("Repository must be initialized")
        }
    }
}