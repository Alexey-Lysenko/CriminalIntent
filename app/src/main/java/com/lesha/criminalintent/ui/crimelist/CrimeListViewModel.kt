package com.lesha.criminalintent.ui.crimelist

import androidx.lifecycle.ViewModel
import com.lesha.criminalintent.data.repository.*

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}