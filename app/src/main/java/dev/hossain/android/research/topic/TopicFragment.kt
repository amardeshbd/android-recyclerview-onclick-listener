package dev.hossain.android.research.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.hossain.android.research.databinding.FragmentResearchTopicBinding
import timber.log.Timber

@AndroidEntryPoint
class TopicFragment : Fragment() {
    private val viewModel by viewModels<TopicViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Timber.d("Loading view for Topic Fragment")
        val binding = FragmentResearchTopicBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@TopicFragment
            vm = viewModel
        }
        return binding.root
    }
}
