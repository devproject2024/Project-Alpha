package com.alipay.mobile.nebula.provider;

import android.content.Context;

public interface H5ToastProvider {
    void makeToast(Context context, String str, int i2);

    void showToastWithSuper(Context context, String str, CharSequence charSequence, int i2);
}
