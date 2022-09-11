package com.lesha.criminalintent.domain.usecase

import com.lesha.criminalintent.domain.repository.CrimeRepository
import java.util.*

class GetCrimeUseCase(private val crimeRepository: CrimeRepository) {
    fun getCrime(crimeId: UUID) {
        crimeRepository.get(crimeId)
    }
}