package com.lesha.criminalintent.domain.usecase

import androidx.lifecycle.LiveData
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.repository.CrimeRepository

class GetCrimeListUseCase(private val crimeRepository: CrimeRepository) {
    fun getCrimeList(): LiveData<List<Crime>> {
        return  crimeRepository.getAll()
    }
}

