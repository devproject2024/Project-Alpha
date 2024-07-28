package com.google.android.gms.internal.measurement;

import com.alipay.mobile.nebula.filecache.FileCache;

public final class hy implements hz {
    private static final bd<Long> A;
    private static final bd<Long> B;
    private static final bd<Long> C;
    private static final bd<Long> D;
    private static final bd<Long> E;
    private static final bd<Long> F;
    private static final bd<Long> G;
    private static final bd<Long> H;
    private static final bd<String> I;
    private static final bd<Long> J;

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Long> f10741a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Long> f10742b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<String> f10743c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<String> f10744d;

    /* renamed from: e  reason: collision with root package name */
    private static final bd<String> f10745e;

    /* renamed from: f  reason: collision with root package name */
    private static final bd<Long> f10746f;

    /* renamed from: g  reason: collision with root package name */
    private static final bd<Long> f10747g;

    /* renamed from: h  reason: collision with root package name */
    private static final bd<Long> f10748h;

    /* renamed from: i  reason: collision with root package name */
    private static final bd<Long> f10749i;
    private static final bd<Long> j;
    private static final bd<Long> k;
    private static final bd<Long> l;
    private static final bd<Long> m;
    private static final bd<Long> n;
    private static final bd<Long> o;
    private static final bd<Long> p;
    private static final bd<Long> q;
    private static final bd<String> r;
    private static final bd<Long> s;
    private static final bd<Long> t;
    private static final bd<Long> u;
    private static final bd<Long> v;
    private static final bd<Long> w;
    private static final bd<Long> x;
    private static final bd<Long> y;
    private static final bd<Long> z;

    public final long a() {
        return f10741a.c().longValue();
    }

    public final long b() {
        return f10742b.c().longValue();
    }

    public final String c() {
        return f10744d.c();
    }

    public final String d() {
        return f10745e.c();
    }

    public final long e() {
        return f10746f.c().longValue();
    }

    public final long f() {
        return f10747g.c().longValue();
    }

    public final long g() {
        return f10748h.c().longValue();
    }

    public final long h() {
        return f10749i.c().longValue();
    }

    public final long i() {
        return j.c().longValue();
    }

    public final long j() {
        return k.c().longValue();
    }

    public final long k() {
        return l.c().longValue();
    }

    public final long l() {
        return m.c().longValue();
    }

    public final long m() {
        return n.c().longValue();
    }

    public final long n() {
        return o.c().longValue();
    }

    public final long o() {
        return q.c().longValue();
    }

    public final long p() {
        return s.c().longValue();
    }

    public final long q() {
        return t.c().longValue();
    }

    public final long r() {
        return u.c().longValue();
    }

    public final long s() {
        return v.c().longValue();
    }

    public final long t() {
        return w.c().longValue();
    }

    public final long u() {
        return x.c().longValue();
    }

    public final long v() {
        return y.c().longValue();
    }

    public final long w() {
        return z.c().longValue();
    }

    public final long x() {
        return A.c().longValue();
    }

    public final long y() {
        return B.c().longValue();
    }

    public final long z() {
        return C.c().longValue();
    }

    public final long A() {
        return D.c().longValue();
    }

    public final long B() {
        return E.c().longValue();
    }

    public final long C() {
        return F.c().longValue();
    }

    public final long D() {
        return G.c().longValue();
    }

    public final long E() {
        return H.c().longValue();
    }

    public final String F() {
        return I.c();
    }

    public final long G() {
        return J.c().longValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10741a = bd.a(bjVar, "measurement.ad_id_cache_time", 10000);
        f10742b = bd.a(bjVar, "measurement.config.cache_time", 86400000);
        f10743c = bd.a(bjVar, "measurement.log_tag", "FA");
        f10744d = bd.a(bjVar, "measurement.config.url_authority", "app-measurement.com");
        f10745e = bd.a(bjVar, "measurement.config.url_scheme", "https");
        f10746f = bd.a(bjVar, "measurement.upload.debug_upload_interval", 1000);
        f10747g = bd.a(bjVar, "measurement.lifetimevalue.max_currency_tracked", 4);
        f10748h = bd.a(bjVar, "measurement.store.max_stored_events_per_app", 100000);
        f10749i = bd.a(bjVar, "measurement.experiment.max_ids", 50);
        j = bd.a(bjVar, "measurement.audience.filter_result_max_count", 200);
        k = bd.a(bjVar, "measurement.alarm_manager.minimum_interval", 60000);
        l = bd.a(bjVar, "measurement.upload.minimum_delay", 500);
        m = bd.a(bjVar, "measurement.monitoring.sample_period_millis", 86400000);
        n = bd.a(bjVar, "measurement.upload.realtime_upload_interval", 10000);
        o = bd.a(bjVar, "measurement.upload.refresh_blacklisted_config_interval", (long) FileCache.EXPIRE_TIME);
        p = bd.a(bjVar, "measurement.config.cache_time.service", 3600000);
        q = bd.a(bjVar, "measurement.service_client.idle_disconnect_millis", 5000);
        r = bd.a(bjVar, "measurement.log_tag.service", "FA-SVC");
        s = bd.a(bjVar, "measurement.upload.stale_data_deletion_interval", 86400000);
        t = bd.a(bjVar, "measurement.upload.backoff_period", 43200000);
        u = bd.a(bjVar, "measurement.upload.initial_upload_delay_time", 15000);
        v = bd.a(bjVar, "measurement.upload.interval", 3600000);
        w = bd.a(bjVar, "measurement.upload.max_bundle_size", 65536);
        x = bd.a(bjVar, "measurement.upload.max_bundles", 100);
        y = bd.a(bjVar, "measurement.upload.max_conversions_per_day", 500);
        z = bd.a(bjVar, "measurement.upload.max_error_events_per_day", 1000);
        A = bd.a(bjVar, "measurement.upload.max_events_per_bundle", 1000);
        B = bd.a(bjVar, "measurement.upload.max_events_per_day", 100000);
        C = bd.a(bjVar, "measurement.upload.max_public_events_per_day", 50000);
        D = bd.a(bjVar, "measurement.upload.max_queue_time", 2419200000L);
        E = bd.a(bjVar, "measurement.upload.max_realtime_events_per_day", 10);
        F = bd.a(bjVar, "measurement.upload.max_batch_size", 65536);
        G = bd.a(bjVar, "measurement.upload.retry_count", 6);
        H = bd.a(bjVar, "measurement.upload.retry_time", 1800000);
        I = bd.a(bjVar, "measurement.upload.url", "https://app-measurement.com/a");
        J = bd.a(bjVar, "measurement.upload.window_interval", 3600000);
    }
}
