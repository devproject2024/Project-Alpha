package com.google.android.gms.internal.p001firebaseperf;

import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.toolbox.HttpClientStack;
import com.google.android.gms.internal.p001firebaseperf.bj;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.a;
import com.google.firebase.perf.internal.e;
import com.google.firebase.perf.internal.f;
import com.google.firebase.perf.internal.g;
import com.google.firebase.perf.internal.l;
import com.google.firebase.perf.internal.zzs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.t  reason: invalid package */
public final class t extends f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final bj.b f9726a;

    /* renamed from: b  reason: collision with root package name */
    private final List<zzs> f9727b;

    /* renamed from: c  reason: collision with root package name */
    private final GaugeManager f9728c;

    /* renamed from: d  reason: collision with root package name */
    private g f9729d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9730e;

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<e> f9731f;

    public final void a(zzs zzs) {
        if (this.f9726a.c() && !this.f9726a.e()) {
            this.f9727b.add(zzs);
        }
    }

    public static t a(g gVar) {
        return new t(gVar);
    }

    private t(g gVar) {
        this(gVar, a.a(), GaugeManager.zzbe());
    }

    private t(g gVar, a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.f9726a = bj.f();
        this.f9731f = new WeakReference<>(this);
        this.f9729d = gVar;
        this.f9728c = gaugeManager;
        this.f9727b = new ArrayList();
        zzay();
    }

    public final t a(String str) {
        if (str != null) {
            this.f9726a.a(al.b(al.a(str)));
        }
        return this;
    }

    public final t b(String str) {
        bj.c cVar;
        if (str != null) {
            String upperCase = str.toUpperCase();
            char c2 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals(HttpClientStack.HttpPatch.METHOD_NAME)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals("TRACE")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals("CONNECT")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    cVar = bj.c.GET;
                    break;
                case 1:
                    cVar = bj.c.PUT;
                    break;
                case 2:
                    cVar = bj.c.POST;
                    break;
                case 3:
                    cVar = bj.c.DELETE;
                    break;
                case 4:
                    cVar = bj.c.HEAD;
                    break;
                case 5:
                    cVar = bj.c.zzlf;
                    break;
                case 6:
                    cVar = bj.c.OPTIONS;
                    break;
                case 7:
                    cVar = bj.c.TRACE;
                    break;
                case 8:
                    cVar = bj.c.CONNECT;
                    break;
                default:
                    cVar = bj.c.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.f9726a.a(cVar);
        }
        return this;
    }

    public final t a(int i2) {
        this.f9726a.a(i2);
        return this;
    }

    public final t a(long j) {
        this.f9726a.a(j);
        return this;
    }

    public final t b(long j) {
        zzs zzcm = SessionManager.zzcl().zzcm();
        SessionManager.zzcl().zzc(this.f9731f);
        this.f9726a.c(j);
        this.f9727b.add(zzcm);
        if (zzcm.f39255b) {
            this.f9728c.zzbg();
        }
        return this;
    }

    public final t c(long j) {
        this.f9726a.e(j);
        return this;
    }

    public final t d(long j) {
        this.f9726a.f(j);
        if (SessionManager.zzcl().zzcm().f39255b) {
            this.f9728c.zzbg();
        }
        return this;
    }

    public final t e(long j) {
        this.f9726a.b(j);
        return this;
    }

    public final t c(String str) {
        if (str == null) {
            this.f9726a.b();
            return this;
        }
        boolean z = false;
        if (str.length() <= 128) {
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt > 127) {
                    break;
                }
                i2++;
            }
        }
        if (z) {
            this.f9726a.b(str);
        } else {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "The content type of the response is not a valid content-type:".concat(valueOf);
            } else {
                new String("The content type of the response is not a valid content-type:");
            }
        }
        return this;
    }

    public final t a() {
        this.f9726a.a(bj.d.GENERIC_CLIENT_ERROR);
        return this;
    }

    public final bj b() {
        SessionManager.zzcl().zzd(this.f9731f);
        zzaz();
        bq[] a2 = zzs.a(this.f9727b);
        if (a2 != null) {
            this.f9726a.a((Iterable<? extends bq>) Arrays.asList(a2));
        }
        bj bjVar = (bj) this.f9726a.k();
        if (!this.f9730e) {
            g gVar = this.f9729d;
            if (gVar != null) {
                gVar.f39199a.execute(new l(gVar, bjVar, zzal()));
                SessionManager.zzcl().zzcn();
            }
            this.f9730e = true;
        }
        return bjVar;
    }
}
