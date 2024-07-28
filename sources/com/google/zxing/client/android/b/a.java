package com.google.zxing.client.android.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40141a = a.class.getSimpleName();

    private a() {
    }

    public static CharSequence a(Context context) {
        ClipData primaryClip = c(context).getPrimaryClip();
        if (b(context)) {
            return primaryClip.getItemAt(0).coerceToText(context);
        }
        return null;
    }

    public static boolean b(Context context) {
        ClipData primaryClip = c(context).getPrimaryClip();
        return primaryClip != null && primaryClip.getItemCount() > 0;
    }

    private static ClipboardManager c(Context context) {
        return (ClipboardManager) context.getSystemService("clipboard");
    }
}
