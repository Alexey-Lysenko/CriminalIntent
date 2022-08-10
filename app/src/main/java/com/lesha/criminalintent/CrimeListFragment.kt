package com.lesha.criminalintent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.lesha.criminalintent.databinding.FragmentCrimeListBinding
import com.lesha.criminalintent.databinding.ListItemCrimeBinding
import java.text.SimpleDateFormat

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {
    private lateinit var binding: FragmentCrimeListBinding

    private val crimeListViewModel: CrimeListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeListBinding.inflate(inflater, container, false)
        binding.crimeRecyclerView.adapter = CrimeAdapter(emptyList())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crimeListViewModel.crimeListLiveData.observe(
            viewLifecycleOwner
        ) { crimes ->
            crimes?.let {
                updateUI(crimes)
            }
        }
    }

    private inner class CrimeHolder(binding: ListItemCrimeBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var crime: Crime
        val titleTextView: TextView = itemView.findViewById(binding.crimeTitle.id)
        val dateTextView: TextView = itemView.findViewById(binding.crimeDate.id)
        val solvedImageView: ImageView = itemView.findViewById(binding.crimeSolved.id)

        init {
            itemView.setOnClickListener(this)
        }

        @SuppressLint("SimpleDateFormat")
        fun bind(crime: Crime) {
            this.crime = crime
            titleTextView.text = this.crime.title
            dateTextView.text =
                SimpleDateFormat(DateConstants.FORMAT_PATTERN).format(this.crime.date)
            solvedImageView.visibility = if (crime.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "${crime.title}!", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class CrimeAdapter(var crimes: List<Crime>) :
        RecyclerView.Adapter<CrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            return CrimeHolder(
                ListItemCrimeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun getItemCount() = crimes.size

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            holder.bind(crimes[position])
        }
    }

    private fun updateUI(crimes: List<Crime>) {
        binding.crimeRecyclerView.adapter = CrimeAdapter(crimes)
    }

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }
}