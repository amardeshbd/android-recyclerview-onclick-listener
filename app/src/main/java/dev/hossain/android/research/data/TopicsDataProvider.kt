package dev.hossain.android.research.data

import dev.hossain.android.research.data.model.ResearchTopic

object TopicsDataProvider {
    val topics = listOf(
        ResearchTopic(
            title = "Plain old listener on ViewHolder",
            description = "This is example of setting plain click listener using interface. " +
                    "This reference example was taken from XYZ app.",
            url = null
        ),
        ResearchTopic(
            title = "Modern listener using DataBinding",
            description = "This is the example taken from Google's Sunflower app that uses data binding to " +
                    "set model data on view holder and retrieve it when click listener is invoked. " +
                    "This is also taught in the Udacity 'Developing Android Apps with Kotlin' course.",
            url = "https://github.com/android/sunflower/blob/master/app/src/main/java/com/google/samples/apps/sunflower/adapters/PlantAdapter.kt#L46"
        )
    )
}
