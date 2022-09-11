package com.lesha.criminalintent.domain.usecase

import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.repository.CrimeRepository

class AddCrimeUseCase(private val crimeRepository: CrimeRepository) {
    fun addCrime(crime: Crime){
        crimeRepository.add(crime)
    }
}