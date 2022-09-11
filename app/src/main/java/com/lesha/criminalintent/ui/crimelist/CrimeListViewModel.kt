package com.lesha.criminalintent.ui.crimelist

import androidx.lifecycle.ViewModel
import com.lesha.criminalintent.data.repository.CrimeRepositoryImpl
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.domain.repository.CrimeRepository
import com.lesha.criminalintent.domain.usecase.DeleteCrimeUseCase
import com.lesha.criminalintent.domain.usecase.GetCrimeListUseCase
import com.lesha.criminalintent.domain.usecase.UpdateCrimeUseCase

class CrimeListViewModel : ViewModel() {
    private val repository = CrimeRepositoryImpl.get()

    private val getCrimeListUseCase = GetCrimeListUseCase(repository)
    private val deleteCrimeUseCase = DeleteCrimeUseCase(repository)
    private val editCrimeUseCase = UpdateCrimeUseCase(repository)

    val crimeList =getCrimeListUseCase.getCrimeList()

    fun deleteCrime(crime: Crime){
        deleteCrimeUseCase.deleteCrime(crime)
    }

    fun editCrime(crime: Crime){
        editCrimeUseCase.editCrime(crime)
    }
}