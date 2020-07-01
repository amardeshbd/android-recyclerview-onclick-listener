package dev.hossain.android.research.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.hossain.android.research.common.observeKotlin
import dev.hossain.android.research.data.TopicsDataProvider
import dev.hossain.android.research.databinding.FragmentResearchTopicBinding

@AndroidEntryPoint
class TopicFragment : Fragment() {
    private val viewModel by viewModels<TopicViewModel>()
    private lateinit var adapter: TopicsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentResearchTopicBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@TopicFragment
            vm = viewModel
        }

        adapter = TopicsAdapter {
            viewModel.onTopicSelected(it)
        }

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter.submitList(TopicsDataProvider.topics)

        viewModel.navigationEvent.observeKotlin(viewLifecycleOwner) { researchTopicId ->
            when (researchTopicId) {
                TopicsDataProvider.TYPE_DATA_BINDING_ASSISTED -> {
                    findNavController().navigate(TopicFragmentDirections.navigateToDataBindingAssistedFragment())
                }
            }
        }
    }
}
