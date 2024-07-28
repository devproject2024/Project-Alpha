package com.alipay.mobile.rome.syncsdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.rome.syncsdk.a.c;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.j;

public class LongLinkNetInfoReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f15104a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f15105b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final String f15106c = LongLinkNetInfoReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean b2 = j.b(context);
            f15105b = b2;
            if (!b2) {
                String str = f15106c;
                h.c(str, "onReceive: [ LongLinkNetInfoReceiver ] [ isNetAvailable=" + f15105b + " ]");
                return;
            }
            f15104a = j.c(context);
            if (c.a()) {
                h.c(f15106c, "onReceive: [ LongLinkNetInfoReceiver ] [ isForceStopped=true ]");
                return;
            }
            c b3 = LongLinkService.b();
            if (b3 == null) {
                h.c(f15106c, "onReceive: [ LongLinkNetInfoReceiver ] [ connManager=null ]");
            } else if (b3.p()) {
                b3.h();
            } else {
                h.a(f15106c, "onReceive: [ LongLinkNetInfoReceiver ] [ isConnected=false - need connect ]");
                if (!c.f()) {
                    c.e();
                }
                b3.c();
            }
        }
    }
}
