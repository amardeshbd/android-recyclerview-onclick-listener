package dev.hossain.android.research.samples.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.hossain.android.research.databinding.ResearchDataBindingAssistedExampleFragmentBinding

class DataBindingAssistedFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = ResearchDataBindingAssistedExampleFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}
