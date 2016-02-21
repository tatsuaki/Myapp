package com.test.unity.studio.webs.lib;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by maki on 2016/02/21.
 * MyApp.
 */
public class SceneManager {
    private static final String TAG = "SceneManager";

    public void ChangeScene(final UnityPlayer unityPlayer, final String unityObject, final String callbak, final String Scene) {
        final Activity activity = UnityPlayer.currentActivity;
        Toast.makeText(activity, activity.getLocalClassName(), Toast.LENGTH_SHORT).show();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "UnitySendMessage");
                UnityPlayer.UnitySendMessage(unityObject, callbak, Scene);
                activity.setContentView(unityPlayer);
            }
        });
    }
}
