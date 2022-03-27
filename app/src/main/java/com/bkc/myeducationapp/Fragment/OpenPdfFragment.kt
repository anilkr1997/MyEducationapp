package com.bkc.myeducationapp.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.FileUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bkc.myeducationapp.R
import com.bkc.myeducationapp.utility.Utility.PDF_BASE_URL
import com.changesNewDesignsDiary.BaseFragmentKot
import java.util.*


class OpenPdfFragment : BaseFragmentKot {
lateinit var webView: WebView;
lateinit var url:String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun update(p0: Observable?, p1: Any?) {
        TODO("Not yet implemented")
    }

    override val model: Observable?
        get() = serviceModel



    override fun onCreateViewPost(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_open_pdf, container, false)

    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView=view.findViewById(R.id.webView);
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(PDF_BASE_URL+url)
    }
    companion object {

        @JvmStatic
        fun newInstance(context: Context,url:String) = OpenPdfFragment(context,url).apply {
            }
    }

    constructor(context: Context, url: String){
        this.url=url
    }
}