package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import com.google.android.gms.common.internal.s;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f8970a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b  reason: collision with root package name */
    private static DropBoxManager f8971b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8972c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f8973d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static int f8974e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f8975f = 0;

    public static boolean a(Context context, Throwable th) {
        return b(context, th);
    }

    private static boolean b(Context context, Throwable th) {
        try {
            s.a(context);
            s.a(th);
        } catch (Exception unused) {
        }
        return false;
    }
}
