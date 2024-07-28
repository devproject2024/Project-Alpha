package com.paytmmall.artifact.scan.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Handler;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15871a = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f15872b;

    /* renamed from: c  reason: collision with root package name */
    private C0213a f15873c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f15874d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public double f15875e;

    /* renamed from: com.paytmmall.artifact.scan.b.a$a  reason: collision with other inner class name */
    public interface C0213a {
        void a(boolean z);
    }

    static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f15874d;
        aVar.f15874d = i2 - 1;
        return i2;
    }

    public final void a(final Context context, final C0213a aVar) {
        com.paytmmall.artifact.common.a.a.a();
        if (com.paytmmall.artifact.common.a.a.a("shouldDetectNetwork", false) && !a(context)) {
            this.f15875e = 0.0d;
            this.f15873c = aVar;
            this.f15872b = new Handler();
            com.paytmmall.artifact.common.a.a.a();
            this.f15874d = com.paytmmall.artifact.common.a.a.a("qrInfoNetworkTimeout", 0) + 1;
            final double[] dArr = new double[1];
            this.f15872b.postDelayed(new Runnable() {
                public final void run() {
                    if (a.this.f15874d >= 0) {
                        double mobileTxBytes = (double) TrafficStats.getMobileTxBytes();
                        double d2 = mobileTxBytes - dArr[0];
                        String unused = a.f15871a;
                        String unused2 = a.f15871a;
                        new StringBuilder("Timer value : ").append(a.this.f15874d);
                        dArr[0] = mobileTxBytes;
                        int a2 = a.this.f15874d;
                        com.paytmmall.artifact.common.a.a.a();
                        if (a2 <= com.paytmmall.artifact.common.a.a.a("qrInfoNetworkTimeout", 0)) {
                            String unused3 = a.f15871a;
                            new StringBuilder("Adding to total : ").append(a.this.f15874d);
                            a aVar = a.this;
                            double unused4 = aVar.f15875e = aVar.f15875e + d2;
                        }
                        a.c(a.this);
                        com.paytmmall.artifact.common.a.a.a();
                        int a3 = com.paytmmall.artifact.common.a.a.a("qrInfoNetworkTimeout", 0) / 2;
                        if (a.this.f15874d == a3) {
                            String unused5 = a.f15871a;
                            C0213a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(a.a(a.this.f15875e, a3));
                            }
                        }
                        if (a.this.f15874d == 0) {
                            String unused6 = a.f15871a;
                            if (aVar == null) {
                                return;
                            }
                            return;
                        }
                        a.this.f15872b.postDelayed(this, 1000);
                    }
                }
            }, 1000);
        }
    }

    private static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    static /* synthetic */ boolean a(double d2, int i2) {
        com.paytmmall.artifact.common.a.a.a();
        return d2 / ((double) i2) > ((double) com.paytmmall.artifact.common.a.a.a("speedThresholdBytesPerSecond", 0));
    }
}
