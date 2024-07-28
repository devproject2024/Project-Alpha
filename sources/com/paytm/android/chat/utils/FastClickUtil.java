package com.paytm.android.chat.utils;

public class FastClickUtil {
    private static final int MIN_CLICK_DELAY_TIME = 500;
    private static long lastClickTime;

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime <= 500) {
            return false;
        }
        lastClickTime = currentTimeMillis;
        return true;
    }

    public static boolean isFastClickAudio() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime <= 500) {
            return false;
        }
        lastClickTime = currentTimeMillis;
        return true;
    }
}
