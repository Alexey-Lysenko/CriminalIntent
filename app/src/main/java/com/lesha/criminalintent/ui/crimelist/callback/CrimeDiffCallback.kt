package com.lesha.criminalintent.ui.crimelist.callback

import androidx.recyclerview.widget.DiffUtil
import com.lesha.criminalintent.domain.model.Crime

class CrimeDiffCallback : DiffUtil.ItemCallback<Crime>() {
    override fun areItemsTheSame(oldItem: Crime, newItem: Crime): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Crime, newItem: Crime): Boolean {
        return (oldItem == newItem)
    }
}