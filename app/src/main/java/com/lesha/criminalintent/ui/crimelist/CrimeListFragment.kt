package com.lesha.criminalintent.ui.crimelist

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.databinding.CrimeListItemBinding
import com.lesha.criminalintent.databinding.FragmentCrimeListBinding
import com.lesha.criminalintent.ui.OutputPatterns
import java.text.SimpleDateFormat
import java.util.*


class CrimeListFragment : Fragment() {
    interface Callbacks {
        fun onCrimeSelected(crimeId: UUID)
    }

    private var callbacks: Callbacks? = null

    private lateinit var binding: FragmentCrimeListBinding

    private val crimeListViewModel: CrimeListViewModel by viewModels()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeListBinding.inflate(inflater, container, false)
        binding.crimeRecyclerView.adapter =
        return binding.root
    }

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }
}