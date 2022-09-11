package com.lesha.criminalintent.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lesha.criminalintent.data.model.CrimeEntity
import com.lesha.criminalintent.domain.model.Crime
import java.util.*

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime_entity")
    fun getAll(): LiveData<List<CrimeEntity>>

    @Query("SELECT * FROM crime_entity WHERE id=(:id)")
    fun getCrime(id: UUID): LiveData<CrimeEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCrime(crimeEntity: CrimeEntity)

    @Insert
    fun addCrime(crimeEntity: CrimeEntity)

    @Delete
    fun deleteCrime(crimeEntity: CrimeEntity)

}


