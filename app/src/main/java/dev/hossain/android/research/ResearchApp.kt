package dev.hossain.android.research

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ResearchApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // Lock app to dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        initEmojiCompat()
        installLogging()
    }

    /**
     * Despite having auto download, looks like the [EmojiCompat] needs to be initialized.
     * > "EmojiCompat has to be initialized using init(EmojiCompat.Config) function before it can process a CharSequence."
     *
     * NOTE: Auto download config can be found at [R.font.noto_color_emoji_compat]
     */
    private fun initEmojiCompat() {
        val fontRequest = FontRequest(
            "com.google.android.gms.fonts" /* fontProviderAuthority */,
            "com.google.android.gms" /* fontProviderPackage */,
            "Noto Color Emoji Compat" /* fontProviderQuery */,
            R.array.com_google_android_gms_fonts_certs /* fontProviderCerts */
        )
        val config = FontRequestEmojiCompatConfig(this, fontRequest)
        EmojiCompat.init(config)
    }

    private fun installLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
