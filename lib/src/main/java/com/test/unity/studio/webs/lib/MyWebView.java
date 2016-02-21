package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import java.util.Map;

/**
 * Created by maki on 2016/01/27.
 * WebApp.
 */
public class MyWebView extends WebView {
    private static final String TAG = "MyWebView";

    public MyWebView(Context context) {super(context);}
    public MyWebView(Context context, AttributeSet attrs) {super(context, attrs);}
    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        Log.i(TAG, "MyWebView");
    }

    public void InitWebView(final String url) {
        Log.i(TAG, "InitWebView uri = " + url);
        setVisibility(View.VISIBLE);
        //  webView.setFocusable(true);
        setFocusableInTouchMode(true);

        setWebChromeClient(new WebChromeClient());
        setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d(TAG, "shouldOverrideUrlLoading url = " + url);
                if (url.startsWith("http://") || url.startsWith("https://")
                        || url.startsWith("file://") || url.startsWith("javascript:")) {
                    // Let webview handle the URL
                    return false;
                } else if (url.startsWith("unity:")) {
                    String message = url.substring(6);
                    //  mWebViewPlugin.call(message);
                    return true;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent);
                return true;
            }
        });
        //    webView.addJavascriptInterface(mWebViewPlugin , "Unity");
        Log.d(TAG, "62");
        WebSettings webSettings = getSettings();
        webSettings.setSupportZoom(false);
        webSettings.setJavaScriptEnabled(true);
        // 16以上
        // ELLY_BEAN 以上のAPIではデフォルトでfalse。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Log.i(TAG, "Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        loadUrl(url);
    }
}

//    public void LoadURL(final String url) {
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//            if (mWebView == null) {
//                return;
//            }
//            mWebView.loadUrl(url);
//        }});
//    }
//
//    public void Init(final String gameObject, final boolean transparent) {
//    //  final WebViewPlugin self = this;
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//            if (mWebView != null) {
//                return;
//            }
//            WebView webView = new WebView(a);
//            webView.setVisibility(View.GONE);
//        //  webView.setFocusable(true);
//            webView.setFocusableInTouchMode(true);
//
//            // webView.setWebChromeClient(new WebChromeClient() {
//            //     public boolean onConsoleMessage(android.webkit.ConsoleMessage cm) {
//            //         Log.d("Webview", cm.message());
//            //         return true;
//            //     }
//            // });
//            webView.setWebChromeClient(new WebChromeClient());
//            webView.setWebViewClient(new WebViewClient() {
//                @Override
//                public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                    if (url.startsWith("http://") || url.startsWith("https://")
//                            || url.startsWith("file://") || url.startsWith("javascript:")) {
//                        // Let webview handle the URL
//                        return false;
//                    } else if (url.startsWith("unity:")) {
//                        String message = url.substring(6);
//                        //  mWebViewPlugin.call(message);
//                        return true;
//                    }
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                    view.getContext().startActivity(intent);
//                    return true;
//                }
//            });
//        //    webView.addJavascriptInterface(mWebViewPlugin , "Unity");
//
//            WebSettings webSettings = webView.getSettings();
//            webSettings.setSupportZoom(false);
//            webSettings.setJavaScriptEnabled(true);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                // Log.i("WebViewPlugin", "Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT);
//                webSettings.setAllowUniversalAccessFromFileURLs(true);
//            }
//            webSettings.setDatabaseEnabled(true);
//            webSettings.setDomStorageEnabled(true);
//            String databasePath = webView.getContext().getDir("databases", Context.MODE_PRIVATE).getPath();
//            webSettings.setDatabasePath(databasePath);
//
//            if (transparent) {
//                webView.setBackgroundColor(0x00000000);
//            }
//
//            if (layout == null) {
//                layout = new FrameLayout(a);
//                a.addContentView(
//                        layout,
//                        new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
//                                FrameLayout.LayoutParams.MATCH_PARENT));
//                layout.setFocusable(true);
//                layout.setFocusableInTouchMode(true);
//            }
//            layout.addView(
//                    webView,
//                    new FrameLayout.LayoutParams(
//                            FrameLayout.LayoutParams.MATCH_PARENT,
//                            FrameLayout.LayoutParams.MATCH_PARENT,
//                            Gravity.NO_GRAVITY));
//            mWebView = webView;
//        }});
//
//    }
//
//    public void Destroy() {
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//            if (mWebView == null) {
//                return;
//            }
//            layout.removeView(mWebView);
//            mWebView = null;
//        }});
//    }
//
//    public void EvaluateJS(final String js) {
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//            if (mWebView == null) {
//                return;
//            }
//            mWebView.loadUrl("javascript:" + js);
//        }});
//    }
//
//    public void SetMargins(int left, int top, int right, int bottom) {
//        final FrameLayout.LayoutParams params
//                = new FrameLayout.LayoutParams(
//                FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.MATCH_PARENT,
//                Gravity.NO_GRAVITY);
//        params.setMargins(left, top, right, bottom);
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//            if (mWebView == null) {
//                return;
//            }
//            mWebView.setLayoutParams(params);
//        }});
//    }
//
//    public void SetVisibility(final boolean visibility) {
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//            if (mWebView == null) {
//                return;
//            }
//            if (visibility) {
//                mWebView.setVisibility(View.VISIBLE);
//                layout.requestFocus();
//                mWebView.requestFocus();
//            } else {
//                mWebView.setVisibility(View.GONE);
//            }
//        }});
//    }
//}