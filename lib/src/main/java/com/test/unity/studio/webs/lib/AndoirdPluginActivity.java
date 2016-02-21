package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

/**
 * Created by maki on 2016/02/21.
 * MyApp.
 */
public class AndoirdPluginActivity extends Activity implements View.OnClickListener{
    private static final String TAG = "AndoirdPluginActivity";
    public ImageButton mStartButton = null;
    public ImageButton mMovieButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = (ImageButton) findViewById(R.id.startButton);
        mMovieButton = (ImageButton) findViewById(R.id.movieButton);

        mStartButton.setOnClickListener(this);
        mMovieButton.setOnClickListener(this);

        Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
        if (view == mStartButton) {
            Intent intent = new Intent(AndoirdPluginActivity.this, WebViewActivity.class);
            startActivity(intent);
        } else if (view == mMovieButton) {
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//            setContentView(R.layout.web_activity);
//            mWebView = (MyWebView)findViewById(R.id.webView);
//            mWebView.invalidate();
//            mWebView.InitWebView("http://qiita.com/m_pDorobou/items/8a838feaaa9891471d78");
//
//            mTopButton  = (Button)findViewById(R.id.top_button);
//            mExitButton = (Button)findViewById(R.id.exit_button);
//
//            mTopButton.setOnClickListener(this);
//            mExitButton.setOnClickListener(this);
        }
    }
}
