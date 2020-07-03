package dev.hossain.android.research.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Data class for different research topic related to `RecyclerView` item click listener.
 */
@Parcelize
data class ResearchTopic constructor(
    val id: String,
    val title: String,
    val description: String,
    val sourceCodeUrl: String,
    val synopsisHtmlPath: String = "wip.html",
    val externalUrl: String? = null
) : Parcelable
