package com.lesha.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lesha.criminalintent.databinding.FragmentCrimeBinding
import com.lesha.criminalintent.databinding.FragmentCrimeListBinding
import com.lesha.criminalintent.databinding.ListItemCrimeBinding

private const val TAG = "CrimeListFragment"

class CrimeListFragment: Fragment() {
    private lateinit var binding: FragmentCrimeListBinding
    private lateinit var crimeRecyclerView: RecyclerView
    private var adapter: CrimeAdapter? = null

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this).get(CrimeListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrimeListBinding.inflate(inflater,container,false)
        crimeRecyclerView = binding.crimeRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
        }
        updateUI()
        return binding.root
    }

    private fun updateUI(){
        val crimes = crimeListViewModel.crimes
        adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }

    private inner class CrimeHolder(binding: ListItemCrimeBinding): RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private lateinit var crime: Crime
        val titleTextView: TextView = itemView.findViewById(binding.crimeTitle.id)
        val dateTextView: TextView = itemView.findViewById(binding.crimeDate.id)
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(crime: Crime){
            this.crime = crime
            titleTextView.text = this.crime.title
            dateTextView.text = this.crime.date.toString()
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context,"${crime.title}!",Toast.LENGTH_SHORT).show()
        }
    }

    private inner class CrimeAdapter(var crimes: List<Crime>): RecyclerView.Adapter<CrimeHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            val binding = ListItemCrimeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return CrimeHolder(binding)
        }

        override fun getItemCount() = crimes.size

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val crime = crimes[position]
            holder.bind(crime)
        }
    }

    companion object{
        fun newInstance(): CrimeListFragment{
            return CrimeListFragment()
        }
    }
}