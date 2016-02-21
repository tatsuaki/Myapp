package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

/**
 * Created by maki on 2016/02/21.
 * MyApp.
 */
public class AndoirdPluginActivity extends UnityPlayerActivity implements View.OnClickListener {
    private static final String TAG = "AndoirdPluginActivity";
    public static AndoirdPluginActivity instance = null;
//    public UnityPlayer mUnityPlayer;

    public ImageButton mStartButton = null;
    public ImageButton mMovieButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        instance = this;
        setContentView(R.layout.activity_main);

        mStartButton = (ImageButton) findViewById(R.id.startButton);
        mMovieButton = (ImageButton) findViewById(R.id.movieButton);

        mStartButton.setOnClickListener(this);
        mMovieButton.setOnClickListener(this);

        if (null == mUnityPlayer) {
            Log.d(TAG, " new UnityPlayer(this)");
            mUnityPlayer = new UnityPlayer(this);
        }

        mUnityPlayer.requestFocus();
        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
    }

    public static AndoirdPluginActivity getInstance() {
        return instance;
    }

    public static void sendMessages(final String message) {
        Log.d(TAG, "sendMessages " + message);
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ShowWeb(final String message) {
        Log.d(TAG, "ShowWeb " + message);
        Intent intent = new Intent(instance, WebViewActivity.class);
        instance.startActivity(intent);
    }

    public void ChangeScene(final String Scene) {
        SceneManager scene = new SceneManager();
        final Activity activity = AndoirdPluginActivity.instance;
        Toast.makeText(this, activity.getLocalClassName(), Toast.LENGTH_SHORT).show();
        // Unity側のスクリプトのonCallBack関数を呼び出す関数
        // UnityPlayer.UnitySendMessage(gameObjName, "onCallBack", ""); のように記述。
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "UnitySendMessage");
                UnityPlayer.UnitySendMessage("StartButton", "onCallBack", Scene);
                activity.setContentView(mUnityPlayer);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
        if (view == mStartButton) {
            Intent intent = new Intent(instance, WebViewActivity.class);
            startActivity(intent);
        } else if (view == mMovieButton) {
            final Activity activity = AndoirdPluginActivity.instance;
            Toast.makeText(this, activity.getLocalClassName(), Toast.LENGTH_SHORT).show();
            // Unity側のスクリプトのonCallBack関数を呼び出す関数
            // UnityPlayer.UnitySendMessage(gameObjName, "onCallBack", ""); のように記述。
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "UnitySendMessage");
                    UnityPlayer.UnitySendMessage("StartButton", "onCallBack", "ChangeScene");
                    activity.setContentView(mUnityPlayer);
                }
            });
        }
    }
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
    //    mUnityPlayer.quit();
        super.onDestroy();
    }

    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    //    mUnityPlayer.pause();
    }

    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    //    mUnityPlayer.resume();
    }

//    public void onConfigurationChanged(Configuration var1) {
//        super.onConfigurationChanged(var1);
//    //    mUnityPlayer.configurationChanged(var1);
//    }
//
//    public void onWindowFocusChanged(boolean var1) {
//        super.onWindowFocusChanged(var1);
//    //    mUnityPlayer.windowFocusChanged(var1);
//    }
//
//    public boolean dispatchKeyEvent(KeyEvent var1) {
//        return var1.getAction() == 2?this.mUnityPlayer.injectEvent(var1):super.dispatchKeyEvent(var1);
//    }
//
//    public boolean onKeyUp(int var1, KeyEvent var2) {
//        return this.mUnityPlayer.injectEvent(var2);
//    }
//
//    public boolean onKeyDown(int var1, KeyEvent var2) {
//        return this.mUnityPlayer.injectEvent(var2);
//    }
//
//    public boolean onTouchEvent(MotionEvent var1) {
//        return this.mUnityPlayer.injectEvent(var1);
//    }
//
//    public boolean onGenericMotionEvent(MotionEvent var1) {
//        return this.mUnityPlayer.injectEvent(var1);
//    }
}
