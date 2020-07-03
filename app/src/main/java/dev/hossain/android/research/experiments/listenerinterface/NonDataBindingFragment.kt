package dev.hossain.android.research.experiments.listenerinterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.hossain.android.research.R
import dev.hossain.android.research.common.IntentAction.openWebPage
import dev.hossain.android.research.data.SampleDataProvider
import dev.hossain.android.research.data.model.Person
import dev.hossain.android.research.experiments.ExperimentBaseFragment
import timber.log.Timber

/**
 * Fragment that shows usage of [NonDataBindingPeopleAdapter].
 */
class NonDataBindingFragment : ExperimentBaseFragment(), NonDataBindingPeopleAdapter.PersonAdapterListener {
    private val args: NonDataBindingFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.common_full_screen_recycler_view, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val nonDataBindingPeopleAdapter = NonDataBindingPeopleAdapter(this)
        recyclerView.adapter = nonDataBindingPeopleAdapter
        nonDataBindingPeopleAdapter.submitList(SampleDataProvider.people(limit = 30))

        return rootView
    }

    override fun onPersonClicked(person: Person) {
        Timber.d("Clicked on person $person")
    }

    override fun onSynopsisMenuClicked() {
        findNavController().navigate(
            NonDataBindingFragmentDirections
                .actionNonDataBindingFragmentToShowSourceCodeFragment(args.selectedTopic.synopsisHtmlPath)
        )
    }

    override fun onShowCodeClicked() {
        openWebPage(requireContext(), args.selectedTopic.sourceCodeUrl)
    }
}
