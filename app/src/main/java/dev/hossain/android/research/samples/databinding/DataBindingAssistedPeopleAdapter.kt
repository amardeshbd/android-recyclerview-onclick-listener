package dev.hossain.android.research.samples.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.hossain.android.research.data.model.Person
import dev.hossain.android.research.databinding.ListItemCommonUserContactWithBindingBinding
import timber.log.Timber

/**
 * Adapter with data binding to save bound data to viewholder.
 *
 * Example taken from sunflower app.
 */
class DataBindingAssistedPeopleAdapter
    : ListAdapter<Person, RecyclerView.ViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(
            ListItemCommonUserContactWithBindingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as PersonViewHolder).bind(item)
    }

    class PersonViewHolder(
        private val binding: ListItemCommonUserContactWithBindingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                binding.data?.let { person ->
                    Timber.i("Clicked on person: $person")
                }
            }
        }

        fun bind(item: Person) {
            binding.apply {
                data = item
                executePendingBindings()
            }
        }
    }
}

private class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}