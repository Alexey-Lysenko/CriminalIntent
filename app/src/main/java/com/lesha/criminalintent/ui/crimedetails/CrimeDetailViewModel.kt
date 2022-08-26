package com.lesha.criminalintent.ui.crimedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lesha.criminalintent.data.model.Crime
import com.lesha.criminalintent.data.repository.Repository
import java.util.*

class CrimeDetailViewModel : ViewModel() {
    private val repository = Repository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> = Transformations.switchMap(crimeIdLiveData) { crimeId ->
        repository.getCrime(crimeId)
    }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }

    fun saveCrime(crime: Crime) {
        repository.updateCrime(crime)
    }
}