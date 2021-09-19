package com.jlexdev.reign.ui.web

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jlexdev.reign.R

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        setupWeb()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWeb() {
        val urlStory = intent.getStringExtra("URL")
        webView = findViewById(R.id.webview)

        webView.apply {
            // WebViewClient allows you to handle
            // onPageFinished and override Url loading.
            webViewClient = WebViewClient()

            // this will enable the javascript settings
            settings.javaScriptEnabled = true

            // if you want to enable zoom feature
            settings.setSupportZoom(true)

            if (urlStory != null) {
                if (urlStory.endsWith(".pdf")) {
                    loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=$urlStory")
                } else {
                    loadUrl(urlStory)
                }
            } else {
                loadUrl("https://www.google.com")
            }
        }
    }

}