package com.google.android.gms.vision;

import android.util.Log;

public final class c {
    public static int a(Throwable th, String str, Object... objArr) {
        if (!Log.isLoggable("Vision", 6)) {
            return 0;
        }
        if (Log.isLoggable("Vision", 3)) {
            return Log.e("Vision", String.format(str, objArr), th);
        }
        String format = String.format(str, objArr);
        String valueOf = String.valueOf(th);
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 2 + String.valueOf(valueOf).length());
        sb.append(format);
        sb.append(": ");
        sb.append(valueOf);
        return Log.e("Vision", sb.toString());
    }
}
