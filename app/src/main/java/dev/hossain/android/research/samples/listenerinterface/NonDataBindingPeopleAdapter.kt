package dev.hossain.android.research.samples.listenerinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import dev.hossain.android.research.R
import dev.hossain.android.research.data.model.Person
import dev.hossain.android.research.samples.PersonDiffCallback

/**
 * Adapter without data binding
 *
 * Example taken from material design catalog app.
 * - https://github.com/material-components/material-components-android/blob/master/catalog/java/io/material/catalog/transition/hero/AlbumsAdapter.java
 */
class NonDataBindingPeopleAdapter(
    private val listener: PersonAdapterListener
) : ListAdapter<Person, NonDataBindingPeopleAdapter.PersonViewHolder>(PersonDiffCallback()) {

    /**
     * Custom callback interface defined for this adapter.
     */
    interface PersonAdapterListener {
        fun onPersonClicked(person: Person)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_common_user_contact_without_binding, parent, false)
        return PersonViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = getItem(position)
        holder.bind(person)
    }

    class PersonViewHolder(itemRootView: View, val listener: PersonAdapterListener) :
        RecyclerView.ViewHolder(itemRootView) {

        private val container = itemRootView.findViewById<View>(R.id.container)
        private val name = itemRootView.findViewById<MaterialTextView>(R.id.name)
        private val nameThumb = itemRootView.findViewById<MaterialTextView>(R.id.person_thumb)
        private val phone = itemRootView.findViewById<MaterialTextView>(R.id.phone)
        private val company = itemRootView.findViewById<MaterialTextView>(R.id.company)

        fun bind(person: Person) {
            container.setOnClickListener { listener.onPersonClicked(person) }
            name.text = person.name
            nameThumb.text = person.nameLetter
            phone.text = person.phone
            company.text = person.company
        }
    }
}
