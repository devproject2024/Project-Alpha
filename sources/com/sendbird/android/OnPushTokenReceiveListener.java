package com.sendbird.android;

public interface OnPushTokenReceiveListener {
    void onReceived(String str, SendBirdException sendBirdException);
}
