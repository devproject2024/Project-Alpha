package com.google.android.play.core.b;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f37278a;

    public b(String str) {
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        String valueOf2 = String.valueOf(str);
        this.f37278a = valueOf2.length() == 0 ? new String(valueOf) : valueOf.concat(valueOf2);
    }

    private final int a(int i2, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i2)) {
            return Log.i("PlayCore", a(this.f37278a, str, objArr));
        }
        return 0;
    }

    private static String a(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException unused) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() == 0) {
                    new String("Unable to format ");
                } else {
                    "Unable to format ".concat(valueOf);
                }
                String join = TextUtils.join(", ", objArr);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length());
                sb.append(str2);
                sb.append(" [");
                sb.append(join);
                sb.append("]");
                str2 = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" : ");
        sb2.append(str2);
        return sb2.toString();
    }

    public final void a(String str, Object... objArr) {
        a(3, str, objArr);
    }

    public final void b(String str, Object... objArr) {
        a(6, str, objArr);
    }

    public final void c(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            a(this.f37278a, str, objArr);
        }
    }

    public final void d(String str, Object... objArr) {
        a(4, str, objArr);
    }

    public final void e(String str, Object... objArr) {
        a(5, str, objArr);
    }
}
