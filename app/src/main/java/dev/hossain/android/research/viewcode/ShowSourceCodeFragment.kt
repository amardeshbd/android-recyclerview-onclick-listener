package dev.hossain.android.research.viewcode

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import dev.hossain.android.research.databinding.FragmentShowSourceCodeBinding

class ShowSourceCodeFragment : Fragment() {
    private lateinit var binding: FragmentShowSourceCodeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShowSourceCodeBinding.inflate(inflater, container, false)

        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // https://stackoverflow.com/questions/57449900/letting-webview-on-android-work-with-prefers-color-scheme-dark?rq=1
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(binding.webView.settings, WebSettingsCompat.FORCE_DARK_ON)
        }

        binding.webView.apply {
            settings.javaScriptEnabled = true
            webChromeClient = WebViewChromeClient()
            webViewClient = AppWebViewClient()
            loadUrl("file:///android_asset/prism.html")
        }
    }
}
