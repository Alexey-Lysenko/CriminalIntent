package com.lesha.criminalintent.application

import android.app.Application
import com.lesha.criminalintent.data.repository.Repository

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Repository.initialize(this)
    }
}