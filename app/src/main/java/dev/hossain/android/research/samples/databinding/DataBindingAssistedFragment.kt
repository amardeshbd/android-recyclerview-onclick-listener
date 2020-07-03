package dev.hossain.android.research.samples.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dev.hossain.android.research.common.IntentAction.openWebPage
import dev.hossain.android.research.data.SampleDataProvider
import dev.hossain.android.research.databinding.ResearchDataBindingAssistedExampleFragmentBinding
import dev.hossain.android.research.samples.ExperimentBaseFragment

class DataBindingAssistedFragment : ExperimentBaseFragment() {
    private lateinit var binding: ResearchDataBindingAssistedExampleFragmentBinding
    private val args: DataBindingAssistedFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ResearchDataBindingAssistedExampleFragmentBinding.inflate(inflater, container, false)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val dataBindingAssistedPeopleAdapter = DataBindingAssistedPeopleAdapter()
        binding.recyclerView.adapter = dataBindingAssistedPeopleAdapter
        dataBindingAssistedPeopleAdapter.submitList(SampleDataProvider.people(limit = 30))

        return binding.root
    }

    override fun onSynopsisMenuClicked() {
        findNavController().navigate(
            DataBindingAssistedFragmentDirections
                .actionDataBindingAssistedFragmentToShowSourceCodeFragment(args.selectedTopic.synopsisHtmlPath)
        )
    }

    override fun onShowCodeClicked() {
        Snackbar.make(binding.root, "Shows source code for this experiment. Continue?", Snackbar.LENGTH_INDEFINITE)
            .setAction("Show Code") {
                openWebPage(requireContext(), args.selectedTopic.sourceCodeUrl)
            }
            .show()
    }
}
