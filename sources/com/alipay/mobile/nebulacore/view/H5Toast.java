package com.alipay.mobile.nebulacore.view;

import android.content.Context;
import android.widget.Toast;

public class H5Toast {
    public static void showToast(Context context, String str, int i2) {
        Toast.makeText(context, str, i2).show();
    }
}
