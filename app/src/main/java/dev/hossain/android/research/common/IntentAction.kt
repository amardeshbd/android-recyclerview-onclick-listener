package dev.hossain.android.research.common

import android.content.Context
import android.content.Intent
import android.net.Uri
import timber.log.Timber

object IntentAction {
    /**
     * Loads an external web URL.
     * https://developer.android.com/guide/components/intents-common#ViewUrl
     */
    fun openWebPage(context: Context, url: String) {
        val webPage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            Timber.w("Unable to find any app that can open web URL")
        }
    }
}