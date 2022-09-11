package com.lesha.criminalintent.ui.crimedetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.lesha.criminalintent.domain.model.Crime
import com.lesha.criminalintent.databinding.FragmentCrimeDetailsBinding
import com.lesha.criminalintent.ui.OutputPatterns
import java.text.SimpleDateFormat
import java.util.*

class CrimeDetailFragment : Fragment() {

    private val crimeDetailViewModel: CrimeDetailViewModel by viewModels()
    private lateinit var binding: FragmentCrimeDetailsBinding
    private lateinit var crimeId: UUID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crimeId = arguments?.getSerializable(ARG_CRIME_ID) as UUID
        crimeDetailViewModel.loadCrime(crimeId)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeDetailsBinding.inflate(inflater, container, false)
        binding.crimeDate.apply {
            text = SimpleDateFormat(OutputPatterns.DATE_FORMAT_PATTERN).format(binding.crimeDate.id)
            isEnabled = false
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.crimeTitle.setText( p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) = Unit
        }
        binding.crimeTitle.addTextChangedListener(titleWatcher)

        binding.crimeSolved.setOnCheckedChangeListener { _, isChecked ->
            binding.crimeSolved.isChecked = isChecked
        }
    }

    override fun onStop() {
        super.onStop()
        crimeDetailViewModel.saveCrime(c    rime)
    }

    companion object {
        const val ARG_CRIME_ID = "crime_id"

        fun newInstance(crimeId: UUID): CrimeDetailFragment {
            val args = Bundle().apply {
                putSerializable(ARG_CRIME_ID, crimeId)
            }
            return CrimeDetailFragment().apply { arguments = args }
        }
    }


}