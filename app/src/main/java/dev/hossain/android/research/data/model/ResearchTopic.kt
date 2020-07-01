package dev.hossain.android.research.data.model

/**
 * Data class for different research topic related to `RecyclerView` item click listener.
 */
data class ResearchTopic constructor(
    val id: String,
    val title: String,
    val description: String,
    val url: String? = null
)
