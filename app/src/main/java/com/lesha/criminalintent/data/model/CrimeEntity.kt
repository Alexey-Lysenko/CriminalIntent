package com.lesha.criminalintent.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "crime_entity")
data class CrimeEntity(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val date: Date = Date(),
    var isSolved: Boolean = false
)