package dev.hossain.android.research.samples.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hossain.android.research.data.SampleDataProvider
import dev.hossain.android.research.databinding.ResearchDataBindingAssistedExampleFragmentBinding

class DataBindingAssistedFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ResearchDataBindingAssistedExampleFragmentBinding.inflate(inflater, container, false)

        binding.recyclerView.setHasFixedSize(false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dataBindingAssistedPeopleAdapter = DataBindingAssistedPeopleAdapter()
        binding.recyclerView.adapter = dataBindingAssistedPeopleAdapter
        dataBindingAssistedPeopleAdapter.submitList(SampleDataProvider.people)

        return binding.root
    }
}
