package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import com.unity3d.player.UnityPlayerNativeActivity;

/**
 * Created by maki on 2016/01/27.
 * WebApp.
 */
public class WebPlugin {
    private static final String TAG = "WebPlugin";

    public static void showToast(final String message) {
        Log.d(TAG, "showToast message = " + message);
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void CallBackUnity(final String message) {
        Log.d(TAG, "CallBackUnity message = " + message);
        final Activity activity = UnityPlayer.currentActivity;
    //    CallJni jni = new CallJni();
    //    final String mess = jni.stringFromJNI();
    //    Log.d(TAG, "CallBackUnity jni mess = " + message);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                UnityPlayer.UnitySendMessage("TestLabel", "AndroidCallback", message);
            }
        });
    }
    public static void ShowWebView(final String url) {
        Log.d(TAG, "ShowWebView url = " + url);
        final Activity activity = UnityPlayer.currentActivity;
     // Application app = activity.getApplication();
//        Intent intent = new Intent(activity, WebManagerActivity.class);
//        intent.putExtra("URL", url);
//        activity.startActivity(intent);
//        activity.finish();
        Log.d(TAG, "ShowWebView activity = " + activity.getLocalClassName());
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run");
//                Intent intent = new Intent(activity, WebManagerActivity.class);
//                intent.putExtra("URL", url);
//                activity.startActivity(intent);
            //  activity.finish();

                MyWeb web = new MyWeb(activity);
                web.InitWebView(url);
                activity.setContentView(web);
//              UnityPlayer.UnitySendMessage("TestLabel", "AndroidCallback", message);
            }
        });
     // MyWeb web = new MyWeb(activity, url);
        //    CallJni jni = new CallJni();
        //    final String mess = jni.stringFromJNI();
        //    Log.d(TAG, "CallBackUnity jni mess = " + message);
//        activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Log.i(TAG, "run");
//                MyWeb web = new MyWeb(activity, url);
////              UnityPlayer.UnitySendMessage("TestLabel", "AndroidCallback", message);
//            }
//        });
    }
}