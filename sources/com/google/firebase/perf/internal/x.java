package com.google.firebase.perf.internal;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.p001firebaseperf.al;
import com.google.android.gms.internal.p001firebaseperf.bq;
import com.google.android.gms.internal.p001firebaseperf.bx;
import com.google.android.gms.internal.p001firebaseperf.v;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import net.one97.paytm.upi.util.UpiContract;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    final long f39240a;

    /* renamed from: b  reason: collision with root package name */
    z f39241b;

    /* renamed from: c  reason: collision with root package name */
    z f39242c;

    /* renamed from: d  reason: collision with root package name */
    final RemoteConfigManager f39243d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f39244e;

    public x(Context context) {
        this(new v(), a(Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID)), RemoteConfigManager.zzbz());
        this.f39244e = al.a(context);
    }

    private x(v vVar, long j, RemoteConfigManager remoteConfigManager) {
        this.f39244e = false;
        this.f39241b = null;
        this.f39242c = null;
        this.f39240a = j;
        this.f39243d = remoteConfigManager;
        this.f39241b = new z(vVar, remoteConfigManager, aa.TRACE, this.f39244e);
        this.f39242c = new z(vVar, remoteConfigManager, aa.NETWORK, this.f39244e);
    }

    static boolean a(List<bq> list) {
        if (list.size() <= 0 || list.get(0).a() <= 0 || list.get(0).b() != bx.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    private static long a(String str) {
        int i2;
        try {
            i2 = al.a(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            i2 = al.a(str.getBytes());
        }
        return (((((long) i2) % 100000000) + 100000000) % 100000000) + 1;
    }
}
