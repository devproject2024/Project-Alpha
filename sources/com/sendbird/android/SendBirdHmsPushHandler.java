package com.sendbird.android;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.RemoteMessage;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdPushHelper;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SendBirdHmsPushHandler extends e<RemoteMessage> {
    /* access modifiers changed from: private */
    public final AtomicReference<String> pendingToken = new AtomicReference<>();
    private final ExecutorService tokenExecutorService = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public volatile CountDownLatch waitLock;

    /* access modifiers changed from: protected */
    public abstract Context getContext();

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
        this.pendingToken.set(str);
        if (this.waitLock != null) {
            this.waitLock.countDown();
            return;
        }
        SendBirdPushHelper.registerPushToken(str, isUniquePushToken(), (SendBirdPushHelper.OnPushRequestCompleteListener) null);
        onNewToken(str);
    }

    /* access modifiers changed from: package-private */
    public void getToken(final OnPushTokenReceiveListener onPushTokenReceiveListener) {
        Logger.d("getHmsPushToken context : " + getContext());
        if (getContext() != null && onPushTokenReceiveListener != null) {
            if (!TextUtils.isEmpty(this.pendingToken.get())) {
                onPushTokenReceiveListener.onReceived(this.pendingToken.get(), (SendBirdException) null);
            } else {
                this.tokenExecutorService.execute(new Runnable() {
                    public final void run() {
                        try {
                            Context applicationContext = SendBirdHmsPushHandler.this.getContext().getApplicationContext();
                            String token = HmsInstanceId.getInstance(applicationContext).getToken(AGConnectServicesConfig.fromContext(applicationContext).getString("client/app_id"), "HCM");
                            Logger.d("pushToken : ".concat(String.valueOf(token)));
                            boolean z = true;
                            if (!TextUtils.isEmpty(token)) {
                                SendBirdHmsPushHandler.this.pendingToken.set(token);
                            } else {
                                CountDownLatch unused = SendBirdHmsPushHandler.this.waitLock = new CountDownLatch(1);
                                z = SendBirdHmsPushHandler.this.waitLock.await(5, TimeUnit.SECONDS);
                                CountDownLatch unused2 = SendBirdHmsPushHandler.this.waitLock = null;
                            }
                            String str = (String) SendBirdHmsPushHandler.this.pendingToken.get();
                            if (!z || TextUtils.isEmpty(str)) {
                                Logger.i("getHmsPushToken failed", new Object[0]);
                                onPushTokenReceiveListener.onReceived((String) null, new SendBirdException("getting HMS token is failed", SendBirdError.ERR_REQUEST_FAILED));
                                return;
                            }
                            onPushTokenReceiveListener.onReceived(str, (SendBirdException) null);
                        } catch (Exception e2) {
                            Logger.i("getHmsPushToken failed, ".concat(String.valueOf(e2)), new Object[0]);
                            onPushTokenReceiveListener.onReceived((String) null, new SendBirdException("getting HMS token is failed", SendBirdError.ERR_REQUEST_FAILED));
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject getPayload(RemoteMessage remoteMessage) throws JSONException {
        if (remoteMessage.getDataOfMap().containsKey(StringSet.sendbird)) {
            return new JSONObject((String) remoteMessage.getDataOfMap().get(StringSet.sendbird));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isSendBirdMessage(RemoteMessage remoteMessage) {
        return remoteMessage.getDataOfMap().containsKey(StringSet.sendbird);
    }

    /* access modifiers changed from: package-private */
    public void registerPushToken(String str, boolean z, SendBird.RegisterPushTokenWithStatusHandler registerPushTokenWithStatusHandler) {
        SendBird.registerPushTokenForCurrentUserInternal(SendBird.PushTokenType.HMS, str, z, true, registerPushTokenWithStatusHandler);
    }

    /* access modifiers changed from: package-private */
    public void unregisterPushToken(String str, SendBird.UnregisterPushTokenHandler unregisterPushTokenHandler) {
        SendBird.HMS.unregisterPushTokenForCurrentUser(str, unregisterPushTokenHandler);
    }
}
