package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by maki on 2016/02/21.
 * MyApp.
 */
public class AndoirdPlugin {
    private static final String TAG = "AndoirdPlugin";

    public static void showWeb(final String message) {
        Log.d(TAG, "showWeb " + message);
        final Activity activity = UnityPlayer.currentActivity;
        Toast.makeText(activity, activity.getLocalClassName(), Toast.LENGTH_SHORT).show();
//          Log.d(TAG, "activity.getContentScene() = " + activity.getContentScene());
//            activity.getContentScene();
        // (3) Unity側のスクリプトのonCallBack関数を呼び出す関数
        // スクリプトがAttachされたGameObjectの名前を渡し、スクリプト内指定の
        // 関数を呼び出すことが可能。呼び出し先の関数がvoid型の場合は
        // UnityPlayer.UnitySendMessage(gameObjName, "onCallBack", ""); のように記述。
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(activity, WebViewActivity.class);
                activity.startActivity(intent);
                Log.d(TAG, "startActivity");
//                UnityPlayer.UnitySendMessage("SceneManagers", "onCallBack", "ChangeScene");
//                Log.d(TAG, "UnitySendMessage 2");
//                //  activity.setContentView(UnityPlayer);
            }
        });
    }
}
