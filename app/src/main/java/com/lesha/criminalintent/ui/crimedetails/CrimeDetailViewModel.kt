package com.lesha.criminalintent.ui.crimedetails

import androidx.lifecycle.ViewModel
import com.lesha.criminalintent.data.repository.CrimeRepositoryImpl
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.usecase.GetCrimeUseCase
import com.lesha.criminalintent.domain.usecase.UpdateCrimeUseCase
import java.util.*

class CrimeDetailViewModel : ViewModel() {
    private val repository = CrimeRepositoryImpl.get()

    private val getCrimeUseCase = GetCrimeUseCase(repository)
    private val updateCrimeUseCase = UpdateCrimeUseCase(repository)

    fun loadCrime(crimeId: UUID) {
        getCrimeUseCase.getCrime(crimeId)
    }

    fun saveCrime(crime: Crime) {
        updateCrimeUseCase.editCrime(crime)
    }
}