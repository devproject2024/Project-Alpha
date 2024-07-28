package com.sendbird.android;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public final class SendBirdFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "SENDBIRD_PUSH";

    public final void onTokenRefresh() {
        SendBirdPushHelper.onNewToken(FirebaseInstanceId.a().g());
    }
}
