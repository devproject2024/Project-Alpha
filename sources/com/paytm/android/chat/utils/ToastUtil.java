package com.paytm.android.chat.utils;

import android.widget.Toast;
import com.paytm.android.chat.c;

public class ToastUtil {
    public static void showMsg(String str) {
        showMsg(str, 0);
    }

    public static void showMsg(int i2) {
        showMsg(i2, 0);
    }

    public static void showMsg(String str, int i2) {
        Toast.makeText(c.a(), str, i2).show();
    }

    public static void showMsg(int i2, int i3) {
        Toast.makeText(c.a(), i2, i3).show();
    }
}
