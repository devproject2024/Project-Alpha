package c.a.a;

import java.io.InputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.Interceptor;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    List<m> f5569a;

    /* renamed from: b  reason: collision with root package name */
    protected Headers f5570b;

    /* renamed from: c  reason: collision with root package name */
    List<InputStream> f5571c;

    /* renamed from: d  reason: collision with root package name */
    HostnameVerifier f5572d;

    /* renamed from: e  reason: collision with root package name */
    long f5573e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5574f;

    /* renamed from: g  reason: collision with root package name */
    CookieJar f5575g;

    /* renamed from: h  reason: collision with root package name */
    Cache f5576h;

    /* renamed from: i  reason: collision with root package name */
    Authenticator f5577i;
    CertificatePinner j;
    boolean k;
    boolean l;
    boolean m;
    Proxy n;
    List<Interceptor> o;
    List<Interceptor> p;
    SSLSocketFactory q;
    Dispatcher r;

    /* synthetic */ k(a aVar, byte b2) {
        this(aVar);
    }

    private k(a aVar) {
        this.f5573e = 10000;
        this.f5569a = aVar.f5578a;
        this.f5570b = aVar.f5579b;
        this.f5571c = aVar.f5580c;
        this.f5572d = aVar.f5581d;
        this.f5573e = aVar.f5582e;
        this.f5574f = aVar.f5583f;
        this.f5575g = aVar.f5584g;
        this.f5576h = aVar.f5585h;
        this.f5577i = aVar.f5586i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        List<m> f5578a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        Headers f5579b;

        /* renamed from: c  reason: collision with root package name */
        List<InputStream> f5580c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        HostnameVerifier f5581d;

        /* renamed from: e  reason: collision with root package name */
        long f5582e;

        /* renamed from: f  reason: collision with root package name */
        boolean f5583f;

        /* renamed from: g  reason: collision with root package name */
        CookieJar f5584g = CookieJar.NO_COOKIES;

        /* renamed from: h  reason: collision with root package name */
        Cache f5585h;

        /* renamed from: i  reason: collision with root package name */
        Authenticator f5586i;
        CertificatePinner j;
        boolean k = true;
        boolean l = true;
        boolean m = true;
        Proxy n;
        List<Interceptor> o = new ArrayList();
        List<Interceptor> p = new ArrayList();
        SSLSocketFactory q;
        Dispatcher r;

        public final a a(List<Interceptor> list) {
            this.o.addAll(list);
            return this;
        }

        public final k a() {
            return new k(this, (byte) 0);
        }
    }

    public final Headers a() {
        return this.f5570b;
    }
}
