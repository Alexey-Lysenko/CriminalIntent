package com.lesha.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            crimes += Crime(title = "Crime #$i", isSolved = i % 2 == 0)
        }
    }
}