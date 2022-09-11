package com.lesha.criminalintent.domain.repository

import androidx.lifecycle.LiveData
import com.lesha.criminalintent.domain.model.Crime
import java.util.*

interface CrimeRepository {

    fun add(crime: Crime)

    fun delete(crime: Crime)

    fun update(crime: Crime)

    fun get(crimeId: UUID): LiveData<Crime>

    fun getAll(): LiveData<List<Crime>>
}