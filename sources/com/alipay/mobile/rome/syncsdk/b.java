package com.alipay.mobile.rome.syncsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alipay.mobile.rome.syncsdk.b;
import com.alipay.mobile.rome.syncsdk.e.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.LongLinkNetInfoReceiver;
import com.alipay.mobile.rome.syncsdk.service.LongLinkService;
import com.alipay.mobile.rome.syncsdk.service.c;
import com.alipay.mobile.rome.syncsdk.service.g;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15001a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static b f15002b;

    /* renamed from: c  reason: collision with root package name */
    private volatile g f15003c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile a f15004d;

    private b(Context context) {
        LongLinkService a2 = LongLinkService.a();
        a2.f15110c = context;
        if (a2.f15110c != null) {
            LongLinkService.f15108b = new c(context);
            h.b(LongLinkService.f15107a, "registerNetInfoReceiver: ");
            try {
                a2.f15111d = new LongLinkNetInfoReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                a2.f15110c.registerReceiver(a2.f15111d, intentFilter);
            } catch (IllegalArgumentException e2) {
                String str = LongLinkService.f15107a;
                h.d(str, "registerNetInfoReceiver: [ IllegalArgumentException=" + e2 + " ]");
            }
            a2.f15112e = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    String f2 = LongLinkService.f15107a;
                    h.b(f2, "ScreenStatusReceiver Action=" + intent.getAction());
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        a.f15085a = com.alipay.mobile.rome.syncsdk.e.c.SCREEN_OFF;
                        b.a(LongLinkService.this.f15110c).b();
                    } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                        a.f15085a = com.alipay.mobile.rome.syncsdk.e.c.SCREEN_ON;
                        if (a.a() == com.alipay.mobile.rome.syncsdk.e.b.FOREGROUND) {
                            b.a(LongLinkService.this.f15110c).a();
                        }
                    }
                }
            };
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
            intentFilter2.addAction("android.intent.action.SCREEN_ON");
            a2.f15110c.registerReceiver(a2.f15112e, intentFilter2);
        }
        this.f15003c = new c(this);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f15002b == null) {
                f15002b = new b(context);
            }
            bVar = f15002b;
        }
        return bVar;
    }

    public final synchronized void a() {
        h.b(f15001a, "startLink");
        LongLinkService.a();
        if (LongLinkService.d()) {
            h.c(f15001a, "startLink: [ already connected ] ");
            return;
        }
        LongLinkService.a();
        LongLinkService.c();
    }

    public final synchronized void b() {
        h.b(f15001a, "stopLink： ");
        LongLinkService a2 = LongLinkService.a();
        com.alipay.mobile.rome.syncsdk.a.c.b();
        if (LongLinkService.f15108b == null) {
            LongLinkService.f15108b = new c(a2.f15110c);
        }
        LongLinkService.f15108b.e();
        if (!(a2.f15112e == null || a2.f15110c == null)) {
            a2.f15110c.unregisterReceiver(a2.f15112e);
            a2.f15112e = null;
        }
    }
}
