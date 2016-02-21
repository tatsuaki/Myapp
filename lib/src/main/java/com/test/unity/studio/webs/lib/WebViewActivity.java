package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by maki on 2016/02/21.
 * MyApp.
 */
public class WebViewActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "WebViewActivity";

    public MyWebView mWebView = null;
    private Button mTopButton = null;
    private Button mExitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

//        WebView webView = new WebView(this);
//        webView.loadUrl("http://qiita.com/m_pDorobou/items/8a838feaaa9891471d78");
        setContentView(R.layout.web_activity);
        mWebView = (MyWebView) findViewById(R.id.webView);
        mWebView.invalidate();
        mWebView.InitWebView("http://qiita.com/m_pDorobou/items/8a838feaaa9891471d78");

        mTopButton = (Button) findViewById(R.id.top_button);
        mExitButton = (Button) findViewById(R.id.exit_button);

        mTopButton.setOnClickListener(this);
        mExitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick");
        if (view == mTopButton) {
            finish();
        } else if (view == mExitButton) {
            final AndoirdPluginActivity activity = AndoirdPluginActivity.getInstance();
            activity.ChangeScene("top");
            finish();
            //  final Activity activity = UnityPlayer.currentActivity;
        //  Toast.makeText(this, activity.getLocalClassName(), Toast.LENGTH_SHORT).show();
            // (3) Unity側のスクリプトのonCallBack関数を呼び出す関数
            // スクリプトがAttachされたGameObjectの名前を渡し、スクリプト内指定の
            // 関数を呼び出すことが可能。呼び出し先の関数がvoid型の場合は
            // UnityPlayer.UnitySendMessage(gameObjName, "onCallBack", ""); のように記述。
//            activity.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Log.d(TAG, "UnitySendMessage 1");
//                    UnityPlayer.UnitySendMessage("StartButton", "onCallBack", "ChangeScene");
//                    Log.d(TAG, "UnitySendMessage 2");
//                    //  activity.setContentView(UnityPlayer);
//                }
//            });
        }
    }
}
