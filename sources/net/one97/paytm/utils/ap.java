package net.one97.paytm.utils;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.c;
import com.paytm.network.j;
import com.paytm.network.model.ConnectionMatrices;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.Executor;
import net.one97.paytm.utils.au;

public final class ap implements j {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f69619a = new a((byte) 0);

    static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final ArrayDeque<Runnable> f69647a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f69648b;

        private a() {
            this.f69647a = new ArrayDeque<>();
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final synchronized void execute(final Runnable runnable) {
            this.f69647a.offer(new Runnable() {
                public final void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f69648b == null) {
                a();
            }
        }

        /* access modifiers changed from: protected */
        public final synchronized void a() {
            Runnable poll = this.f69647a.poll();
            this.f69648b = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.f69648b);
            }
        }
    }

    public final void a(Context context, int i2, String str, long j, NetworkResponse networkResponse, a.b bVar, HashMap<String, String> hashMap, a.c cVar, ConnectionMatrices connectionMatrices, double d2) {
        final NetworkResponse networkResponse2 = networkResponse;
        final int i3 = i2;
        final String str2 = str;
        final long j2 = j;
        final ConnectionMatrices connectionMatrices2 = connectionMatrices;
        final a.b bVar2 = bVar;
        final HashMap<String, String> hashMap2 = hashMap;
        final a.c cVar2 = cVar;
        final double d3 = d2;
        final Context context2 = context;
        f69619a.execute(new Runnable() {
            public final void run() {
                int i2;
                au.e eVar = new au.e();
                String str = networkResponse2.headers.get("ContentEncoding");
                NetworkResponse networkResponse = networkResponse2;
                if (!(networkResponse == null || networkResponse.data == null)) {
                    if (str == null || !str.equals("gzip")) {
                        i2 = new String(networkResponse2.data).getBytes().length;
                    } else {
                        i2 = networkResponse2.data.length;
                    }
                    eVar.r = i2;
                }
                eVar.p = i3;
                eVar.o = b.P(str2);
                eVar.f69690e = au.c.ApiLog.stringValue;
                eVar.q = j2;
                ConnectionMatrices connectionMatrices = connectionMatrices2;
                if (connectionMatrices != null) {
                    eVar.C = connectionMatrices.getMetricConnectionTime();
                    eVar.D = connectionMatrices2.getMetricDomainLookupTime();
                    eVar.E = connectionMatrices2.getMetricRequestTime();
                    eVar.F = connectionMatrices2.getMetricResponseTime();
                    eVar.G = connectionMatrices2.getMetricSecureConnectionTime();
                    eVar.H = connectionMatrices2.getMetricTotalTime();
                    eVar.Y = connectionMatrices2.getRequestWaitTime();
                    eVar.Z = connectionMatrices2.getTotalRoundTripTime();
                }
                int i3 = i3;
                if (!(i3 == 401 || i3 == 403 || i3 == 410)) {
                    a.b bVar = bVar2;
                    if (bVar != null) {
                        eVar.t = bVar.toString();
                    } else {
                        eVar.t = "None";
                    }
                }
                HashMap hashMap = hashMap2;
                if (hashMap != null) {
                    eVar.m = (String) hashMap.get("screen_name");
                    eVar.z = (String) hashMap2.get(AppConstants.X_APP_RID);
                }
                a.c cVar = cVar2;
                if (cVar != null) {
                    eVar.l = cVar.toString();
                } else {
                    eVar.l = a.c.HOME.toString();
                }
                eVar.f69694i = d3;
                au.a(eVar, au.c.ApiLog.stringValue, context2);
            }
        });
    }

    public final void a(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar, ConnectionMatrices connectionMatrices) {
        HashMap<String, String> hashMap2 = hashMap;
        if (hashMap2.get(c.EXCEPTION_NAME) == null || !hashMap2.get(c.EXCEPTION_NAME).equals(c.OUT_OF_MEMORY_EXCEPTION)) {
            final int i3 = i2;
            final String str4 = str;
            final long j2 = j;
            final a.b bVar2 = bVar;
            final ConnectionMatrices connectionMatrices2 = connectionMatrices;
            final HashMap<String, String> hashMap3 = hashMap;
            final a.c cVar2 = cVar;
            final String str5 = str3;
            final Context context2 = context;
            f69619a.execute(new Runnable() {
                public final void run() {
                    au.e eVar = new au.e();
                    eVar.p = i3;
                    eVar.o = b.P(str4);
                    eVar.f69690e = au.c.ApiError.stringValue;
                    eVar.q = j2;
                    int i2 = i3;
                    if (!(i2 == 401 || i2 == 403 || i2 == 410)) {
                        a.b bVar = bVar2;
                        if (bVar != null) {
                            eVar.t = bVar.toString();
                        } else {
                            eVar.t = "None";
                        }
                    }
                    ConnectionMatrices connectionMatrices = connectionMatrices2;
                    if (connectionMatrices != null) {
                        eVar.C = connectionMatrices.getMetricConnectionTime();
                        eVar.D = connectionMatrices2.getMetricDomainLookupTime();
                        eVar.E = connectionMatrices2.getMetricRequestTime();
                        eVar.F = connectionMatrices2.getMetricResponseTime();
                        eVar.G = connectionMatrices2.getMetricSecureConnectionTime();
                        eVar.H = connectionMatrices2.getMetricTotalTime();
                        eVar.Y = connectionMatrices2.getRequestWaitTime();
                        eVar.Z = connectionMatrices2.getTotalRoundTripTime();
                    }
                    HashMap hashMap = hashMap3;
                    if (hashMap != null) {
                        eVar.m = (String) hashMap.get("screen_name");
                        eVar.z = (String) hashMap3.get(AppConstants.X_APP_RID);
                    }
                    a.c cVar = cVar2;
                    if (cVar != null) {
                        eVar.l = cVar.toString();
                    } else {
                        eVar.l = a.c.HOME.toString();
                    }
                    eVar.u = str5;
                    au.a(eVar, au.c.ApiError.stringValue, context2);
                }
            });
            return;
        }
        com.google.firebase.crashlytics.c.a().a("url" + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + Uri.parse(str).buildUpon().clearQuery().toString() + "request_body" + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + str2);
    }

    public final void a(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar, ConnectionMatrices connectionMatrices, String str4) {
        HashMap<String, String> hashMap2 = hashMap;
        if (hashMap2 == null || hashMap2.get(c.EXCEPTION_NAME) == null || !hashMap2.get(c.EXCEPTION_NAME).equals(c.OUT_OF_MEMORY_EXCEPTION)) {
            final int i3 = i2;
            final String str5 = str;
            final long j2 = j;
            final a.b bVar2 = bVar;
            final ConnectionMatrices connectionMatrices2 = connectionMatrices;
            final HashMap<String, String> hashMap3 = hashMap;
            final a.c cVar2 = cVar;
            final String str6 = str3;
            final String str7 = str4;
            final Context context2 = context;
            f69619a.execute(new Runnable() {
                public final void run() {
                    au.e eVar = new au.e();
                    eVar.p = i3;
                    eVar.o = b.P(str5);
                    eVar.f69690e = au.c.ApiError.stringValue;
                    eVar.q = j2;
                    int i2 = i3;
                    if (!(i2 == 401 || i2 == 403 || i2 == 410)) {
                        a.b bVar = bVar2;
                        if (bVar != null) {
                            eVar.t = bVar.toString();
                        } else {
                            eVar.t = "None";
                        }
                    }
                    ConnectionMatrices connectionMatrices = connectionMatrices2;
                    if (connectionMatrices != null) {
                        eVar.C = connectionMatrices.getMetricConnectionTime();
                        eVar.D = connectionMatrices2.getMetricDomainLookupTime();
                        eVar.E = connectionMatrices2.getMetricRequestTime();
                        eVar.F = connectionMatrices2.getMetricResponseTime();
                        eVar.G = connectionMatrices2.getMetricSecureConnectionTime();
                        eVar.H = connectionMatrices2.getMetricTotalTime();
                        eVar.Y = connectionMatrices2.getRequestWaitTime();
                        eVar.Z = connectionMatrices2.getTotalRoundTripTime();
                    }
                    HashMap hashMap = hashMap3;
                    if (hashMap != null) {
                        eVar.m = (String) hashMap.get("screen_name");
                        eVar.z = (String) hashMap3.get(AppConstants.X_APP_RID);
                    }
                    a.c cVar = cVar2;
                    if (cVar != null) {
                        eVar.l = cVar.toString();
                    } else {
                        eVar.l = a.c.HOME.toString();
                    }
                    eVar.u = str6;
                    eVar.g(str7);
                    au.a(eVar, au.c.ApiError.stringValue, context2);
                }
            });
            return;
        }
        com.google.firebase.crashlytics.c.a().a("url" + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + Uri.parse(str).buildUpon().clearQuery().toString() + "request_body" + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + str2);
    }
}
