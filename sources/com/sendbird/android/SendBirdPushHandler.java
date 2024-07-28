package com.sendbird.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.w;
import com.google.firebase.messaging.RemoteMessage;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdPushHelper;
import com.sendbird.android.constant.StringSet;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SendBirdPushHandler extends e<RemoteMessage> {
    /* access modifiers changed from: protected */
    public boolean isUniquePushToken() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void onMessageReceived(Context context, RemoteMessage remoteMessage);

    /* access modifiers changed from: protected */
    public void onNewToken(String str) {
    }

    /* access modifiers changed from: package-private */
    public void onTokenUpdated(String str) {
        SendBirdPushHelper.registerPushToken(str, isUniquePushToken(), (SendBirdPushHelper.OnPushRequestCompleteListener) null);
        onNewToken(str);
    }

    /* access modifiers changed from: package-private */
    public void getToken(final OnPushTokenReceiveListener onPushTokenReceiveListener) {
        try {
            FirebaseInstanceId.a().f().a(new c<w>() {

                /* renamed from: c  reason: collision with root package name */
                private String f44650c = "FCM token access is failure.";

                public final void a(Task<w> task) {
                    if (task.b()) {
                        w d2 = task.d();
                        if (d2 != null) {
                            String b2 = d2.b();
                            StringBuilder sb = new StringBuilder("FCM token : ");
                            sb.append(b2);
                            sb.append(" by OnCompleteListener");
                            OnPushTokenReceiveListener onPushTokenReceiveListener = onPushTokenReceiveListener;
                            if (onPushTokenReceiveListener != null) {
                                onPushTokenReceiveListener.onReceived(b2, (SendBirdException) null);
                                return;
                            }
                            return;
                        }
                        onPushTokenReceiveListener.onReceived("getting FCM token is failed", new SendBirdException(this.f44650c, SendBirdError.ERR_REQUEST_FAILED));
                    } else if (onPushTokenReceiveListener != null) {
                        Exception e2 = task.e();
                        if (e2 != null && !TextUtils.isEmpty(e2.getMessage())) {
                            this.f44650c = e2.getMessage();
                        }
                        OnPushTokenReceiveListener onPushTokenReceiveListener2 = onPushTokenReceiveListener;
                        String str = this.f44650c;
                        onPushTokenReceiveListener2.onReceived(str, new SendBirdException(str, SendBirdError.ERR_REQUEST_FAILED));
                    }
                }
            });
        } catch (Throwable th) {
            if (onPushTokenReceiveListener != null) {
                onPushTokenReceiveListener.onReceived((String) null, new SendBirdException(th.getMessage()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject getPayload(RemoteMessage remoteMessage) throws JSONException {
        if (remoteMessage.b().containsKey(StringSet.sendbird)) {
            return new JSONObject(remoteMessage.b().get(StringSet.sendbird));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isSendBirdMessage(RemoteMessage remoteMessage) {
        return remoteMessage.b().containsKey(StringSet.sendbird);
    }

    /* access modifiers changed from: package-private */
    public void registerPushToken(String str, boolean z, SendBird.RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
        SendBird.registerPushTokenForCurrentUserInternal(SendBird.PushTokenType.GCM, str, z, true, registerPushTokenWithStatusHandler);
    }

    /* access modifiers changed from: package-private */
    public void unregisterPushToken(String str, SendBird.UnregisterPushTokenHandler unregisterPushTokenHandler) {
        SendBird.unregisterPushTokenForCurrentUser(SendBird.PushTokenType.GCM, str, unregisterPushTokenHandler);
    }
}
