package com.lesha.criminalintent.application

import android.app.Application
import com.lesha.criminalintent.data.repository.CrimeRepositoryImpl

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepositoryImpl.initialize(this)
    }
}