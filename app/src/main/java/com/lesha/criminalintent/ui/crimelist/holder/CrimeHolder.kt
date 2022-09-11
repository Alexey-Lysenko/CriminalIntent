package com.lesha.criminalintent.ui.crimelist.holder

import androidx.recyclerview.widget.RecyclerView
import com.lesha.criminalintent.databinding.FragmentCrimeDetailsBinding
import com.lesha.criminalintent.domain.model.Crime

class CrimeHolder(private val binding: FragmentCrimeDetailsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.apply {
            crimeTitle.setText(crime.title)
            crimeDate.text = crime.date.toString()
            crimeSolved.isChecked = crime.isSolved
        }
    }
}