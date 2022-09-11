package com.lesha.criminalintent.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lesha.criminalintent.data.dao.CrimeDao
import com.lesha.criminalintent.data.model.CrimeEntity
import com.lesha.criminalintent.data.typeconverter.DateTypeConverter
import com.lesha.criminalintent.data.typeconverter.UUIDTypeConverter

@Database(entities = [CrimeEntity::class], version = 1)
@TypeConverters(DateTypeConverter::class, UUIDTypeConverter::class)
abstract class CrimeDatabase : RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}

