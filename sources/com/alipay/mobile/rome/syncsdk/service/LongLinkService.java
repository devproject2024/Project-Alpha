package com.alipay.mobile.rome.syncsdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.alipay.mobile.rome.syncsdk.a.c;

public class LongLinkService {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15107a = LongLinkService.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f15108b = null;

    /* renamed from: f  reason: collision with root package name */
    private static LongLinkService f15109f;

    /* renamed from: c  reason: collision with root package name */
    public Context f15110c;

    /* renamed from: d  reason: collision with root package name */
    public volatile BroadcastReceiver f15111d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f15112e;

    public static LongLinkService a() {
        if (f15109f == null) {
            f15109f = new LongLinkService();
        }
        return f15109f;
    }

    private LongLinkService() {
    }

    public static c b() {
        return f15108b;
    }

    public static void c() {
        c.b();
        if (f15108b != null && !f15108b.p()) {
            f15108b.c();
        }
    }

    public static boolean d() {
        if (f15108b == null) {
            return false;
        }
        return f15108b.p();
    }

    public final synchronized Context e() {
        return this.f15110c;
    }
}
