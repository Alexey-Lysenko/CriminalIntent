package com.lesha.criminalintent.ui.crimelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lesha.criminalintent.databinding.FragmentCrimeDetailsBinding
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.ui.crimelist.callback.CrimeDiffCallback
import com.lesha.criminalintent.ui.crimelist.holder.CrimeHolder

class CrimeListAdapter : ListAdapter<Crime, CrimeHolder>(CrimeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val binding = FragmentCrimeDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = getItem(position)
        holder.bind(crime)
    }
}