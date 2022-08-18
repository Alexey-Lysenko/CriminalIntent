package com.lesha.criminalintent.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lesha.criminalintent.databinding.ActivityMainBinding
import com.lesha.criminalintent.ui.crimedetails.CrimeFragment
import com.lesha.criminalintent.ui.crimelist.CrimeListFragment
import java.util.*

class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks {

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

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager.beginTransaction().also {
            it.replace(binding.fragmentContainer.id, fragment)
            it.addToBackStack(null)
            it.commit()
        }
    }
}

