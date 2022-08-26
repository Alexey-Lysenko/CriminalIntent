package com.lesha.criminalintent.ui.crimelist

import androidx.lifecycle.ViewModel
import com.lesha.criminalintent.data.repository.Repository

class CrimeListViewModel : ViewModel() {
    private val repository = Repository.get()
    val crimeListLiveData = repository.getCrimes()
}