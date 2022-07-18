package com.lesha.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lesha.criminalintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {setContentView(it.root) }


        val currentFragment = supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
        if (currentFragment == null){
            val fragment = CrimeFragment()
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentContainer.id,fragment)
                .commit()
        }
    }
}