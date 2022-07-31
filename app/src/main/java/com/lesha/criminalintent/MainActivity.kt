package com.lesha.criminalintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lesha.criminalintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }


        val currentFragment = supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentContainer.id, fragment)
                .commit()
        }
    }
}

