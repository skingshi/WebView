package com.sking.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView wv = (WebView) findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:function myFunction(){var x=document.getElementById(\"QNT_box\");  x.parentNode.removeChild(x);}");
                view.loadUrl("javascript:myFunction()");
                super.onPageFinished(view, url);
            }
        });

        WebSettings wvSettings = wv.getSettings();
        wvSettings.setJavaScriptEnabled(true);

        wv.loadUrl("http://touch.qunar.com/h5/flight/?bd_source=kupaijipiao");

    }

}
