package dev.hossain.android.research.topic

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hossain.android.research.data.model.ResearchTopic

class TopicViewModel @ViewModelInject constructor() : ViewModel() {

    private val _navigationEvent = MutableLiveData<String>()
    val navigationEvent: LiveData<String> = _navigationEvent

    fun onTopicSelected(researchTopic: ResearchTopic) {
        _navigationEvent.value = researchTopic.id
    }
}
