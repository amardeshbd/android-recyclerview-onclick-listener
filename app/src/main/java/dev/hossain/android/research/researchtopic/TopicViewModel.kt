package dev.hossain.android.research.researchtopic

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.hossain.android.research.common.LiveEvent
import dev.hossain.android.research.data.model.ResearchTopic

class TopicViewModel @ViewModelInject constructor() : ViewModel() {

    private val _navigationEvent = LiveEvent<ResearchTopic>()
    val navigationEvent: LiveData<ResearchTopic> = _navigationEvent

    fun onTopicSelected(researchTopic: ResearchTopic) {
        _navigationEvent.value = researchTopic
    }
}
