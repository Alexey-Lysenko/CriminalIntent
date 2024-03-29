package com.lesha.criminalintent.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lesha.criminalintent.data.model.Crime

@Database(entities = [Crime::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun crimeDao(): Dao

}

