package dev.hossain.android.research.topic

import android.content.Intent
import android.net.Uri
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
import timber.log.Timber

/**
 * Shows list of recycler view related topic for future experimentation.
 */
@AndroidEntryPoint
class TopicFragment : Fragment() {
    private val viewModel by viewModels<TopicViewModel>()
    private lateinit var adapter: TopicsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentResearchTopicBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@TopicFragment
            vm = viewModel
        }

        adapter = TopicsAdapter({ researchTopic ->
            viewModel.onTopicSelected(researchTopic)
        }, { externalUrl ->
            openWebPage(externalUrl)
        })

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter.submitList(TopicsDataProvider.topics)

        viewModel.navigationEvent.observeKotlin(viewLifecycleOwner) { researchTopicId ->
            Timber.d("Got navigation event: $researchTopicId")
            when (researchTopicId) {
                TopicsDataProvider.TYPE_DATA_BINDING_ASSISTED -> {
                    findNavController().navigate(TopicFragmentDirections.toDataBindingAssistedFragment())
                }
                TopicsDataProvider.TYPE_DATA_PLAIN_LISTENER -> {
                    findNavController().navigate(TopicFragmentDirections.toNonDataBindingFragment())
                }
            }
        }
    }

    /**
     * Loads an external web URL.
     * https://developer.android.com/guide/components/intents-common#ViewUrl
     */
    private fun openWebPage(url: String) {
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(requireContext().packageManager) != null) {
            startActivity(intent)
        }
    }
}
