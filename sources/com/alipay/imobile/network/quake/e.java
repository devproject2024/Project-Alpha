package com.alipay.imobile.network.quake;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.imobile.network.quake.b.a;
import com.alipay.imobile.network.quake.i.b;
import com.alipay.imobile.network.quake.i.h;
import com.sendbird.android.constant.StringSet;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class e implements Comparable<e> {

    /* renamed from: a  reason: collision with root package name */
    public String f14769a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f14770b;

    /* renamed from: c  reason: collision with root package name */
    public String f14771c;

    /* renamed from: d  reason: collision with root package name */
    b f14772d;

    /* renamed from: e  reason: collision with root package name */
    c f14773e;

    /* renamed from: f  reason: collision with root package name */
    public a f14774f;

    /* renamed from: g  reason: collision with root package name */
    C0203e f14775g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f14776h;

    /* renamed from: i  reason: collision with root package name */
    boolean f14777i;
    public boolean j;
    public boolean k;
    boolean l;
    public com.alipay.imobile.network.quake.h.c.b m;
    public a.C0201a n;
    public Object o;
    public Object p;
    String q;
    String r;
    String s;
    public Map<String, String> t;
    public String u;
    public b.a v;
    /* access modifiers changed from: private */
    public final h w;
    private Type x;

    public interface a {
        void a(e eVar) throws com.alipay.mobile.b.b.a;
    }

    public interface b {
        void a(com.alipay.mobile.b.b.a aVar);
    }

    public interface c {
        void a(Object obj);
    }

    public enum d {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* renamed from: com.alipay.imobile.network.quake.e$e  reason: collision with other inner class name */
    interface C0203e {
        void a(e eVar);
    }

    protected static com.alipay.mobile.b.b.a a(com.alipay.mobile.b.b.a aVar) {
        return aVar;
    }

    public String a() {
        return this.f14770b;
    }

    public final void a(String str) {
        if (com.alipay.iap.android.common.b.c.a()) {
            this.w.a(str, Thread.currentThread().getId());
        }
    }

    public final void a(String str, String str2) {
        this.t.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        String str = this.t.get("did");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        String str2 = this.t.get(StringSet.ts);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        map.put("rpc_trace_id", sb.toString());
    }

    public final com.alipay.imobile.network.quake.e.b b() throws com.alipay.mobile.b.b.a {
        return m.a().a(this.q);
    }

    public final void b(Map<String, String> map) {
        String str = this.t.get("Mgw-TraceId");
        if (!TextUtils.isEmpty(str)) {
            map.put("sofa_id", str);
        }
    }

    public Type c() {
        return this.x;
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.q = str;
        }
    }

    public final String d() {
        String str = this.f14771c;
        return str != null ? str : this.f14769a;
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.r = str;
        }
    }

    public final int e() {
        return this.m.a();
    }

    public final void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.s = str;
        }
    }

    public e(String str, c cVar, b bVar) {
        String str2 = null;
        this.w = com.alipay.iap.android.common.b.c.a() ? new h() : null;
        this.f14777i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.p = null;
        this.t = new HashMap();
        this.u = null;
        this.f14769a = str;
        this.x = Object[].class.getComponentType();
        this.f14773e = cVar;
        this.f14772d = bVar;
        m a2 = m.a();
        this.m = new com.alipay.imobile.network.quake.h.c.a();
        c(a2.f14932f);
        d(a2.f14933g);
        e(a2.f14934h);
        try {
            str2 = new URL(str).getPath();
        } catch (MalformedURLException unused) {
        }
        this.f14770b = str2;
    }

    /* access modifiers changed from: package-private */
    public final void b(final String str) {
        C0203e eVar = this.f14775g;
        if (eVar != null) {
            eVar.a(this);
            this.f14772d = null;
            this.f14773e = null;
            this.f14774f = null;
            this.f14775g = null;
            this.n = null;
            this.m = null;
            this.p = null;
            this.t.clear();
        }
        if (com.alipay.iap.android.common.b.c.a()) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        e.this.w.a(str, id);
                        e.this.w.a(toString());
                    }
                });
                return;
            }
            this.w.a(str, id);
            this.w.a(toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.j ? "[X] " : "[ ] ");
        sb.append(b().b(this));
        sb.append(" ");
        sb.append(d.NORMAL);
        sb.append(" ");
        sb.append(this.f14776h);
        return sb.toString();
    }

    public /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        d dVar = d.NORMAL;
        d dVar2 = d.NORMAL;
        return dVar == dVar2 ? this.f14776h.intValue() - eVar.f14776h.intValue() : dVar2.ordinal() - dVar.ordinal();
    }
}
