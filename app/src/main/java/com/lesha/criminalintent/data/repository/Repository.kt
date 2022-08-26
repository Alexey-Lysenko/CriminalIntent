package com.lesha.criminalintent.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.lesha.criminalintent.data.database.Database
import com.lesha.criminalintent.data.model.Crime
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "crime-database"

class Repository private constructor(context: Context) {

    private val executor = Executors.newSingleThreadExecutor()

    private val database: Database = Room.databaseBuilder(
        context.applicationContext,
        Database::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    fun updateCrime(crime: Crime) {
        executor.execute {
            crimeDao.updateCrime(crime)
        }
    }

    fun addCrime(crime: Crime) {
        executor.execute {
            crimeDao.addCrime(crime)
        }
    }

    companion object {
        private var INSTANCE: Repository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
        }

        fun get(): Repository {
            return INSTANCE ?: throw IllegalStateException("Repository must be initialized")
        }
    }
}