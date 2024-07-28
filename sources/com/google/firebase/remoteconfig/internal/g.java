package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.google.android.gms.common.util.e;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.installations.l;
import com.google.firebase.remoteconfig.i;
import com.google.firebase.remoteconfig.internal.m;
import com.google.firebase.remoteconfig.k;
import com.google.firebase.remoteconfig.m;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.upi.util.UpiConstants;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final long f39375a = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: b  reason: collision with root package name */
    static final int[] f39376b = {2, 4, 8, 16, 32, 64, 128, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS};

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.installations.g f39377c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.analytics.connector.a f39378d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f39379e;

    /* renamed from: f  reason: collision with root package name */
    private final e f39380f;

    /* renamed from: g  reason: collision with root package name */
    private final Random f39381g;

    /* renamed from: h  reason: collision with root package name */
    private final a f39382h;

    /* renamed from: i  reason: collision with root package name */
    private final ConfigFetchHttpClient f39383i;
    private final m j;
    private final Map<String, String> k;

    public g(com.google.firebase.installations.g gVar, com.google.firebase.analytics.connector.a aVar, Executor executor, e eVar, Random random, a aVar2, ConfigFetchHttpClient configFetchHttpClient, m mVar, Map<String, String> map) {
        this.f39377c = gVar;
        this.f39378d = aVar;
        this.f39379e = executor;
        this.f39380f = eVar;
        this.f39381g = random;
        this.f39382h = aVar2;
        this.f39383i = configFetchHttpClient;
        this.j = mVar;
        this.k = map;
    }

    public final Task<a> a() {
        return a(this.j.c());
    }

    private Task<a> a(long j2) {
        if (this.j.a()) {
            j2 = 0;
        }
        return this.f39382h.b().b(this.f39379e, h.a(this, j2));
    }

    static /* synthetic */ Task a(g gVar, Task task, Task task2, Date date) throws Exception {
        if (!task.b()) {
            return h.a((Exception) new com.google.firebase.remoteconfig.h("Firebase Installations failed to get installation ID for fetch.", task.e()));
        }
        if (!task2.b()) {
            return h.a((Exception) new com.google.firebase.remoteconfig.h("Firebase Installations failed to get installation auth token for fetch.", task2.e()));
        }
        return gVar.a((String) task.d(), ((l) task2.d()).a(), date);
    }

    private Task<a> a(String str, String str2, Date date) {
        try {
            a b2 = b(str, str2, date);
            if (b2.f39384a != 0) {
                return h.a(b2);
            }
            return this.f39382h.a(b2.f39385b, true).a(this.f39379e, new k(b2));
        } catch (i e2) {
            return h.a((Exception) e2);
        }
    }

    private a b(String str, String str2, Date date) throws i {
        String str3;
        boolean z = false;
        try {
            HttpURLConnection a2 = this.f39383i.a();
            ConfigFetchHttpClient configFetchHttpClient = this.f39383i;
            HashMap hashMap = new HashMap();
            if (this.f39378d != null) {
                for (Map.Entry next : this.f39378d.a().entrySet()) {
                    hashMap.put((String) next.getKey(), next.getValue().toString());
                }
            }
            a fetch = configFetchHttpClient.fetch(a2, str, str2, hashMap, this.j.f39404c.getString("last_fetch_etag", (String) null), this.k, date);
            if (fetch.f39386c != null) {
                this.j.a(fetch.f39386c);
            }
            this.j.a(0, m.f39403b);
            return fetch;
        } catch (m e2) {
            int httpStatusCode = e2.getHttpStatusCode();
            if (httpStatusCode == 429 || httpStatusCode == 502 || httpStatusCode == 503 || httpStatusCode == 504) {
                int i2 = this.j.e().f39407a + 1;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                int[] iArr = f39376b;
                long millis = timeUnit.toMillis((long) iArr[Math.min(i2, iArr.length) - 1]);
                this.j.a(i2, new Date(date.getTime() + (millis / 2) + ((long) this.f39381g.nextInt((int) millis))));
            }
            m.a e3 = this.j.e();
            int httpStatusCode2 = e2.getHttpStatusCode();
            if (e3.f39407a > 1 || httpStatusCode2 == 429) {
                z = true;
            }
            if (!z) {
                int httpStatusCode3 = e2.getHttpStatusCode();
                if (httpStatusCode3 == 401) {
                    str3 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
                } else if (httpStatusCode3 == 403) {
                    str3 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
                } else if (httpStatusCode3 == 429) {
                    throw new com.google.firebase.remoteconfig.h("The throttled response from the server was not handled correctly by the FRC SDK.");
                } else if (httpStatusCode3 != 500) {
                    switch (httpStatusCode3) {
                        case H5ErrorCode.HTTP_BAD_GATEWAY:
                        case H5ErrorCode.HTTP_SERVICE_UNAVAILABLE:
                        case 504:
                            str3 = "The server is unavailable. Please try again later.";
                            break;
                        default:
                            str3 = "The server returned an unexpected error.";
                            break;
                    }
                } else {
                    str3 = "There was an internal server error.";
                }
                throw new com.google.firebase.remoteconfig.m(e2.getHttpStatusCode(), "Fetch failed: ".concat(str3), e2);
            }
            throw new k(e3.f39408b.getTime());
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f39384a;

        /* renamed from: b  reason: collision with root package name */
        final f f39385b;

        /* renamed from: c  reason: collision with root package name */
        final String f39386c;

        /* renamed from: d  reason: collision with root package name */
        private final Date f39387d;

        a(Date date, int i2, f fVar, String str) {
            this.f39387d = date;
            this.f39384a = i2;
            this.f39385b = fVar;
            this.f39386c = str;
        }
    }

    static /* synthetic */ Task a(g gVar, Date date, Task task) throws Exception {
        if (task.b()) {
            m mVar = gVar.j;
            synchronized (mVar.f39405d) {
                mVar.f39404c.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
            }
        } else {
            Exception e2 = task.e();
            if (e2 != null) {
                if (e2 instanceof k) {
                    m mVar2 = gVar.j;
                    synchronized (mVar2.f39405d) {
                        mVar2.f39404c.edit().putInt("last_fetch_status", 2).apply();
                    }
                } else {
                    m mVar3 = gVar.j;
                    synchronized (mVar3.f39405d) {
                        mVar3.f39404c.edit().putInt("last_fetch_status", 1).apply();
                    }
                }
            }
        }
        return task;
    }

    static /* synthetic */ Task a(g gVar, long j2, Task task) throws Exception {
        Task<TContinuationResult> task2;
        boolean z;
        Date date = new Date(gVar.f39380f.a());
        if (task.b()) {
            Date date2 = new Date(gVar.j.f39404c.getLong("last_fetch_time_in_millis", -1));
            if (date2.equals(m.f39402a)) {
                z = false;
            } else {
                z = date.before(new Date(date2.getTime() + TimeUnit.SECONDS.toMillis(j2)));
            }
            if (z) {
                return h.a(new a(date, 2, (f) null, (String) null));
            }
        }
        Date date3 = gVar.j.e().f39408b;
        if (!date.before(date3)) {
            date3 = null;
        }
        if (date3 != null) {
            task2 = h.a((Exception) new k(String.format("Fetch is throttled. Please wait before calling fetch again: %s", new Object[]{DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(date3.getTime() - date.getTime()))}), date3.getTime()));
        } else {
            Task<String> a2 = gVar.f39377c.a();
            Task<l> b2 = gVar.f39377c.b();
            task2 = h.b(a2, b2).b(gVar.f39379e, new i(gVar, a2, b2, date));
        }
        return task2.b(gVar.f39379e, new j(gVar, date));
    }
}
