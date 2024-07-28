package com.sendbird.android;

final class CountDownTimer {

    public interface CountDownTimerEventHandler {
        void onCancel();

        void onStart();

        void onStop();

        void onTick(int i2, int i3);

        void onTimeout();
    }
}
