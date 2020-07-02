package dev.hossain.android.research.data

import dev.hossain.android.research.data.model.ResearchTopic

/**
 * Provides list of [ResearchTopic] for adapter.
 */
object TopicsDataProvider {
    const val TYPE_DATA_PLAIN_LISTENER = "EXAMPLE_ITEM_PLAIN_LISTENER"
    const val TYPE_DATA_BINDING_ASSISTED = "EXAMPLE_ITEM_DATA_BINDING_ASSISTED"

    val topics = listOf(
        ResearchTopic(
            id = TYPE_DATA_PLAIN_LISTENER,
            title = "Plain old callback listener on ViewHolder",
            description = "This is example of setting plain click callback listener using custom interface. " +
                    "This reference example was taken from 'material-components-android' catalog app.",
            url = "https://github.com/material-components/material-components-android/blob/master/catalog/java/io/material/catalog/transition/hero/AlbumsAdapter.java"
        ),
        ResearchTopic(
            id = TYPE_DATA_BINDING_ASSISTED,
            title = "Modern listener using DataBinding",
            description = "This is the example taken from Google's Sunflower app that uses data binding to " +
                    "set model data on view holder and retrieve it when click listener is invoked. " +
                    "This is also taught in the Udacity 'Developing Android Apps with Kotlin' course.",
            url = "https://github.com/android/sunflower/blob/master/app/src/main/java/com/google/samples/apps/sunflower/adapters/PlantAdapter.kt#L46"
        )
    )
}
