package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.d;
import java.util.Collections;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f8939a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f8940b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8941c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f8942d = Collections.emptyList();

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f8943e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f8944f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f8945g = Collections.emptyList();

    public static a a() {
        if (f8940b == null) {
            synchronized (f8939a) {
                if (f8940b == null) {
                    f8940b = new a();
                }
            }
        }
        return f8940b;
    }

    private a() {
    }

    public static boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = d.a(context, component.getPackageName());
        }
        if (z) {
            return false;
        }
        return context.bindService(intent, serviceConnection, i2);
    }

    public static boolean b(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        context.getClass().getName();
        return a(context, intent, serviceConnection, i2);
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
