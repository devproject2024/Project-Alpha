package com.alipay.iap.android.common.e;

import android.content.Context;
import com.alipay.iap.android.common.b.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14691a = a.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f14692c = null;

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.iap.android.common.e.a.a f14693b;

    private a(Context context) {
        this.f14693b = new com.alipay.iap.android.common.e.a.a.a(context);
    }

    public static a a(Context context) {
        if (f14692c == null) {
            if (context == null) {
                c.i();
                return null;
            }
            synchronized (a.class) {
                if (f14692c == null) {
                    f14692c = new a(context);
                }
            }
        }
        return f14692c;
    }

    public final synchronized void a(long j, long j2) {
        if (this.f14693b == null) {
            c.i();
        } else {
            this.f14693b.a(j, j2);
        }
    }
}
