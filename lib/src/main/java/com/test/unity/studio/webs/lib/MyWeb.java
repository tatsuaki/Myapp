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
public class MyWeb extends WebView {
    private static final String TAG = "MyWeb";
    private static FrameLayout layout = null;

    public MyWeb(Context context) {
        super(context);
    }
    public MyWeb(Context context, AttributeSet attrs, Map inflateParams) {
        super(context, attrs);
    }
    public MyWeb(Context context, AttributeSet attrs, Map inflateParams, int defStyle) {
        super(context, attrs);
    }

    public void InitWebView(final String url) {
        Log.i(TAG, "InitWebView uri = " + url);
        //  final WebViewPlugin self = this;
//        final Activity a = UnityPlayer.currentActivity;
//        a.runOnUiThread(new Runnable() {public void run() {
//        if (mWebView == null) {
//            mWebView = new WebView(activity);
//            Log.d(TAG, "mWebView == null");
//        } else {
//            Log.d(TAG, "mWebView != null");
//            return;
//        }
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
        Log.d(TAG, "73");
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
//        Log.d(TAG, "メイン領域生成");
//        if (layout == null) {
//            Log.d(TAG, "layout == null");
//            layout = new FrameLayout(activity);
//            activity.addContentView(layout,
//                    new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
//                            FrameLayout.LayoutParams.MATCH_PARENT));
//            layout.setFocusable(true);
//            layout.setFocusableInTouchMode(true);
//        }
        // webView貼り付け
//        activity.addContentView(mWebView,
//        // layout.addView(mWebView,
//                new FrameLayout.LayoutParams(
//                        FrameLayout.LayoutParams.MATCH_PARENT,
//                        FrameLayout.LayoutParams.MATCH_PARENT,
//                        Gravity.NO_GRAVITY));
//        Log.d(TAG, "loadUrl url = " + url);
//        mWebView.invalidate();
//        mWebView.loadUrl(url);

//        final View activityRootView = activity.getWindow().getDecorView().getRootView();
//        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                android.graphics.Rect r = new android.graphics.Rect();
//                //r will be populated with the coordinates of your view that area still visible.
//                activityRootView.getWindowVisibleDisplayFrame(r);
//                android.view.Display display = activity.getWindowManager().getDefaultDisplay();
//                Point size = new Point();
//                display.getSize(size);
//                int heightDiff = activityRootView.getRootView().getHeight() - (r.bottom - r.top);
                //System.out.print(String.format("[NativeWebview] %d, %d\n", size.y, heightDiff));
//                if (heightDiff > size.y / 3) { // assume that this means that the keyboard is on
//                    UnityPlayer.UnitySendMessage(gameObject, "SetKeyboardVisible", "true");
//                } else {
//                    UnityPlayer.UnitySendMessage(gameObject, "SetKeyboardVisible", "false");
//                }
//            }
//        });
        //   mWebView = mWebView;
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