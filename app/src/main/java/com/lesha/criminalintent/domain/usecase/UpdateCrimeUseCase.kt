package com.lesha.criminalintent.domain.usecase

import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.repository.CrimeRepository

class UpdateCrimeUseCase(private val crimeRepository: CrimeRepository) {
    fun editCrime(crime: Crime){
        crimeRepository.update(crime)
    }
}