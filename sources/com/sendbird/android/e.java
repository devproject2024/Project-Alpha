package com.sendbird.android;

import android.content.Context;
import com.sendbird.android.SendBird;
import org.json.JSONException;
import org.json.JSONObject;

abstract class e<T> {
    /* access modifiers changed from: package-private */
    public abstract JSONObject getPayload(T t) throws JSONException;

    /* access modifiers changed from: package-private */
    public abstract void getToken(OnPushTokenReceiveListener onPushTokenReceiveListener);

    /* access modifiers changed from: package-private */
    public abstract boolean isSendBirdMessage(T t);

    /* access modifiers changed from: package-private */
    public boolean isUniquePushToken() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract void onMessageReceived(Context context, T t);

    /* access modifiers changed from: package-private */
    public abstract void onNewToken(String str);

    /* access modifiers changed from: package-private */
    public abstract void onTokenUpdated(String str);

    /* access modifiers changed from: package-private */
    public abstract void registerPushToken(String str, boolean z, SendBird.RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler);

    /* access modifiers changed from: package-private */
    public abstract void unregisterPushToken(String str, SendBird.UnregisterPushTokenHandler unregisterPushTokenHandler);

    e() {
    }
}
