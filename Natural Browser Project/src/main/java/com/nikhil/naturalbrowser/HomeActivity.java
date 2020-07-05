package com.nikhil.naturalbrowser;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    ProgressBar bar;
    WebView wv;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);   // Only Portrait Mode

        bar = findViewById(R.id.progressBar);

        wv = findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setBuiltInZoomControls(true);  // Pinch to zoom
        wv.getSettings().setDisplayZoomControls(false);  // Zoom controls
        wv.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                bar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                bar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }

        });
        wv.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onBackPressed() {

        if(wv.canGoBack()){
            wv.goBack();
        }else{
            finish();
        }
    }

    public void go(View v){

        EditText url = findViewById(R.id.url);
        String str = url.getText().toString();

        if(str.isEmpty()){
            Toast t = Toast.makeText(getApplicationContext(), "Type URL", Toast.LENGTH_LONG);
            t.show();
        }

        if(str.startsWith("https://")){
            wv.loadUrl(str);
        }else{
            (findViewById(R.id.google)).animate().translationX(3000).setDuration(1000);
            (findViewById(R.id.wikipedia)).animate().translationX(3000).setDuration(1000);
            (findViewById(R.id.youtube)).animate().translationX(3000).setDuration(1000);
            (findViewById(R.id.go)).animate().translationX(3000).setDuration(1000);
            (findViewById(R.id.url)).animate().translationX(3000).setDuration(1000);
            (findViewById(R.id.progressBar)).animate().alpha(1);
            (findViewById(R.id.url)).setFocusableInTouchMode(false);
            (findViewById(R.id.logo)).animate().alpha(1);

            (findViewById(R.id.webView)).animate().alpha(1).setDuration(1000);
            (findViewById(R.id.home)).animate().alpha(1).setDuration(1000);
            (findViewById(R.id.reload)).animate().alpha(1).setDuration(1000);

            (findViewById(R.id.webView)).setFocusableInTouchMode(true);

            wv.loadUrl("https://" + str);
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(findViewById(R.id.go).getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }

        if(!str.endsWith(".\\w+")){
            wv.loadUrl("https://www.google.com/search?q=" + str);
        }

        closeKeyboard();

    }

    private void closeKeyboard(){
        View v = this.getCurrentFocus();
    }

    public void google(View v){

        (findViewById(R.id.google)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.wikipedia)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.youtube)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.go)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.url)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.progressBar)).animate().alpha(1);
        (findViewById(R.id.url)).setFocusableInTouchMode(false);
        (findViewById(R.id.logo)).animate().alpha(1);

        (findViewById(R.id.webView)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.home)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.reload)).animate().alpha(1).setDuration(1000);

        (findViewById(R.id.webView)).setFocusableInTouchMode(true);

        wv.loadUrl("https://www.google.com");
    }

    public void wikipedia(View v){
        (findViewById(R.id.google)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.wikipedia)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.youtube)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.go)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.url)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.progressBar)).animate().alpha(1);
        (findViewById(R.id.url)).setFocusableInTouchMode(false);
        (findViewById(R.id.logo)).animate().alpha(1);

        (findViewById(R.id.webView)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.home)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.reload)).animate().alpha(1).setDuration(1000);

        (findViewById(R.id.webView)).setFocusableInTouchMode(true);

        wv.loadUrl("https://www.wikipedia.com");

    }

    public void youtube(View v){
        (findViewById(R.id.google)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.wikipedia)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.youtube)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.go)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.url)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.progressBar)).animate().alpha(1);
        (findViewById(R.id.url)).setFocusableInTouchMode(false);
        (findViewById(R.id.logo)).animate().alpha(1);

        (findViewById(R.id.webView)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.home)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.reload)).animate().alpha(1).setDuration(1000);

        (findViewById(R.id.webView)).setFocusableInTouchMode(true);

        wv.loadUrl("https://www.youtube.com");

    }

    public void website(View v){

        (findViewById(R.id.google)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.wikipedia)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.youtube)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.go)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.url)).animate().translationX(3000).setDuration(1000);
        (findViewById(R.id.progressBar)).animate().alpha(1);
        (findViewById(R.id.url)).setFocusableInTouchMode(false);
        (findViewById(R.id.logo)).animate().alpha(1);

        (findViewById(R.id.webView)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.home)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.reload)).animate().alpha(1).setDuration(1000);

        (findViewById(R.id.webView)).setFocusableInTouchMode(true);

        wv.loadUrl("https://www.youtube.com/nikhiltech");

    }

    public void home(View v){
        (findViewById(R.id.google)).animate().translationX(0).setDuration(1000);
        (findViewById(R.id.wikipedia)).animate().translationX(0).setDuration(1000);
        (findViewById(R.id.youtube)).animate().translationX(0).setDuration(1000);
        (findViewById(R.id.go)).animate().translationX(0).setDuration(1000);
        (findViewById(R.id.url)).animate().translationX(0).setDuration(1000);
        (findViewById(R.id.progressBar)).animate().alpha(0);
        (findViewById(R.id.logo)).animate().alpha(0);

        (findViewById(R.id.webView)).animate().alpha(0).setDuration(1000);
        (findViewById(R.id.home)).animate().alpha(0).setDuration(1000);
        (findViewById(R.id.reload)).animate().alpha(0).setDuration(1000);

        ((Button)findViewById(R.id.google)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.wikipedia)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.youtube)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.go)).animate().alpha(1).setDuration(1000);
        (findViewById(R.id.webView)).setFocusableInTouchMode(false);
        (findViewById(R.id.url)).setFocusableInTouchMode(true);

        wv.clearHistory();
        wv.clearCache(true);

    }

    public void reload(View v){

        wv.reload();
        Toast t = Toast.makeText(getApplicationContext(), "Reloaded", Toast.LENGTH_LONG);
        t.show();

    }
}
