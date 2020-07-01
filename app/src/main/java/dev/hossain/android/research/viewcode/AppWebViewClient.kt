package dev.hossain.android.research.viewcode

import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import timber.log.Timber

/**
 * Will use `WebViewCompat`
 * - https://developer.android.com/reference/androidx/webkit/WebViewCompat
 * - https://stackoverflow.com/questions/52765057/sample-usage-of-webviewcompat
 * - https://stackoverflow.com/questions/57449900/letting-webview-on-android-work-with-prefers-color-scheme-dark?rq=1
 */
class AppWebViewClient(
    private val allowedUrls: List<String> = emptyList()
) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        val allowedHosts: List<String> = allowedUrls.map { Uri.parse(it).host!! }

        if (url != null) {
            if (allowedHosts.any { it == Uri.parse(url).host }) {
                // This is known allowed site, so do not override and load on WebView
                return false
            } else {
                // External URl requested
            }
        }
        return true // URL is not valid, can not handle it
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        Timber.d("onPageStarted")
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        Timber.d("onPageFinished")
        super.onPageFinished(view, url)
    }

    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        super.onReceivedError(view, request, error)
        Timber.d("onReceivedError")

        view?.loadUrl("about:blank")
    }
}
