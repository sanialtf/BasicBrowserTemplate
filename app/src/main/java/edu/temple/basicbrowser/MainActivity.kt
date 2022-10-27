package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest

class MainActivity : AppCompatActivity() {

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView
    lateinit var url: String
    lateinit var requestQueue: RequestQueue

//    val downloadHandler = Handler(Looper.getMainLooper()) {
//
//        true
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        requestQueue = Volley.newRequestQueue(this)

        //Enable JavaScript
        webView.settings.javaScriptEnabled = true

        //Userin
        goButton.setOnClickListener{
            url = urlEditText.text.toString()


        }

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object: WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                StringRequest(Request.Method.GET, url, {
                    webView.loadDataWithBaseURL("", it, "text/html", "utf-8", null)
                }, {})

            }

        }
//        requestQueue.add(
//            StringRequest(Request.Method.GET, "https://www.temple.edu", {
//                webView.loadDataWithBaseURL("", it, "text/html", "utf-8", null)
//            }, {})
//        )








    }
}