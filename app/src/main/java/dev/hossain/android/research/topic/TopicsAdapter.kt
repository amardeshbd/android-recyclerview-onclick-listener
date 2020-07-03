package dev.hossain.android.research.topic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import dev.hossain.android.research.R
import dev.hossain.android.research.common.DataBoundListAdapter
import dev.hossain.android.research.data.model.ResearchTopic
import dev.hossain.android.research.databinding.ListItemResearchTopicBinding

class TopicsAdapter constructor(
    private val itemClickCallback: ((ResearchTopic) -> Unit),
    private val itemUrlClickCallback: ((String) -> Unit)
) : DataBoundListAdapter<ResearchTopic, ListItemResearchTopicBinding>(
    diffCallback = object : DiffUtil.ItemCallback<ResearchTopic>() {
        override fun areItemsTheSame(oldItem: ResearchTopic, newItem: ResearchTopic): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResearchTopic, newItem: ResearchTopic): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun createBinding(parent: ViewGroup): ListItemResearchTopicBinding {
        val binding = DataBindingUtil.inflate<ListItemResearchTopicBinding>(
            LayoutInflater.from(parent.context), R.layout.list_item_research_topic,
            parent, false
        )

        binding.root.setOnClickListener {
            binding.data?.let {
                itemClickCallback.invoke(it)
            }
        }

        binding.externalLink.setOnClickListener {
            binding.data?.let {
                itemUrlClickCallback.invoke(it.externalUrl!!)
            }
        }

        return binding
    }

    override fun bind(binding: ListItemResearchTopicBinding, item: ResearchTopic) {
        binding.data = item
    }
}
