package dev.hossain.android.research

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ResearchApp : Application() {
    override fun onCreate() {
        super.onCreate()

        installLogging()
    }

    private fun installLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
