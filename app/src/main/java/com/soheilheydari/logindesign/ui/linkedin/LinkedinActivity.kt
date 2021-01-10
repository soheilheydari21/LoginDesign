package com.soheilheydari.logindesign.ui.linkedin

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import com.soheilheydari.logindesign.NetworkConnection
import com.soheilheydari.logindesign.R

class LinkedinActivity : AppCompatActivity() {

    private var web:WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linkedin)

        val connect = findViewById<ConstraintLayout>(R.id.layoutConnect)
        val disConnect = findViewById<ConstraintLayout>(R.id.layoutDisconnect)
        val progress = findViewById<ProgressBar>(R.id.progressBar)

        //disconnect
        val networkConnection = NetworkConnection(this.applicationContext)
        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected){
                disConnect.visibility = View.GONE
                connect.visibility = View.VISIBLE

                val uri = "https://www.linkedin.com/in/"
                web = findViewById(R.id.webView)
                web!!.webViewClient = WebViewClient()
                web!!.settings.javaScriptEnabled = true
                web!!.loadUrl(uri)

                web!!.webViewClient = object:WebViewClient(){
                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        progress.visibility = View.VISIBLE
                        super.onPageStarted(view, url, favicon)
                    }
                    override fun onPageFinished(view: WebView?, url: String?) {
                        progress.visibility = View.GONE
                        super.onPageFinished(view, url)
                    }
                }
            }else{
                connect.visibility = View.GONE
                disConnect.visibility = View.VISIBLE
            }
        })


    }

    override fun onBackPressed() {
        if (web!!.canGoBack()){
            web!!.goBack()
        }
        else{
            super.onBackPressed()
        }
    }

}