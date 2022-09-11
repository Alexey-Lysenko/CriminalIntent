package com.lesha.criminalintent.domain.usecase

import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.repository.CrimeRepository

class DeleteCrimeUseCase(private val crimeRepository: CrimeRepository) {
    fun deleteCrime(crime: Crime){
        crimeRepository.delete(crime)
    }
}