package com.paytm.android.chat.view.kpswitch.b;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.paytm.android.chat.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f42601a;

    /* renamed from: b  reason: collision with root package name */
    private static int f42602b;

    /* renamed from: c  reason: collision with root package name */
    private static int f42603c;

    /* renamed from: d  reason: collision with root package name */
    private static int f42604d;

    public static void a(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int a(Context context) {
        if (f42604d == 0) {
            f42604d = context.getResources().getDimensionPixelSize(R.dimen.min_keyboard_height);
        }
        return f42604d;
    }
}
