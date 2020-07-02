package dev.hossain.android.research.samples.listenerinterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.hossain.android.research.R
import dev.hossain.android.research.data.SampleDataProvider
import dev.hossain.android.research.data.model.Person
import timber.log.Timber

/**
 * Fragment that shows usage of [NonDataBindingPeopleAdapter].
 */
class NonDataBindingFragment : Fragment(), NonDataBindingPeopleAdapter.PersonAdapterListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_full_screen_recycler_view, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val nonDataBindingPeopleAdapter = NonDataBindingPeopleAdapter(this)
        recyclerView.adapter = nonDataBindingPeopleAdapter
        nonDataBindingPeopleAdapter.submitList(SampleDataProvider.people)

        return rootView
    }

    override fun onPersonClicked(person: Person) {
        Timber.d("Clicked on person $person")
    }
}
