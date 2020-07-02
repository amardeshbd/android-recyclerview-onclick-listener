package dev.hossain.android.research.samples.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dev.hossain.android.research.data.model.Person
import dev.hossain.android.research.databinding.ListItemCommonUserContactWithBindingBinding
import dev.hossain.android.research.samples.PersonDiffCallback
import timber.log.Timber

/**
 * Adapter with data binding to save bound data to viewholder.
 *
 * Example taken from sunflower app.
 */
class DataBindingAssistedPeopleAdapter :
    ListAdapter<Person, RecyclerView.ViewHolder>(PersonDiffCallback()) {

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
                    Timber.i("Clicked on person: $person at adapterPosition=$adapterPosition")

                    // Show user their tap feedback
                    Snackbar.make(
                        binding.root,
                        "You tapped on $person at adapter position $adapterPosition.",
                        Snackbar.LENGTH_SHORT
                    ).show()
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
