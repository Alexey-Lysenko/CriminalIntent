package com.lesha.criminalintent.application

import android.app.Application
import com.lesha.criminalintent.data.repository.*

class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}