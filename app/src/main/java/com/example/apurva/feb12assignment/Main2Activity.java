package com.example.apurva.feb12assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    WebView webView;
    String url="http://";
    Intent intent;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView=findViewById(R.id.webview);

        intent=getIntent();
        b=intent.getExtras();

        url+=b.getString("url");
        url=url.toLowerCase();
        url=url.replace(" ","");
        WebSettings webSettings=webView.getSettings();

        webSettings.setJavaScriptEnabled(true);//to enable java script

        webView.setWebViewClient(new MyWebViewClient());//to load multiple url and https

        webView.loadUrl(url);
    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }
    }
}
