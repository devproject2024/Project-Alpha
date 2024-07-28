package net.one97.paytm.wallet.newdesign.fastscan.a;

import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.fastscanner.b.e;
import net.one97.paytm.utils.at;

public final class c implements net.one97.paytm.fastscanner.c.c {

    /* renamed from: a  reason: collision with root package name */
    volatile Set<e> f70931a;

    /* renamed from: b  reason: collision with root package name */
    public y<e> f70932b;

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f70933c;

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f70934d;

    /* renamed from: e  reason: collision with root package name */
    public long f70935e;

    /* renamed from: f  reason: collision with root package name */
    boolean f70936f;

    /* renamed from: g  reason: collision with root package name */
    public String f70937g;

    /* renamed from: h  reason: collision with root package name */
    public volatile a f70938h;

    /* renamed from: i  reason: collision with root package name */
    private Long f70939i;
    private HashMap<e, Long> j;
    private volatile Handler k;
    private Runnable l;

    public enum a {
        INITIAL,
        SCANNED
    }

    public c() {
        this.f70932b = new y<>();
        this.f70933c = new y<>();
        this.f70934d = new y<>();
        this.f70935e = System.currentTimeMillis();
        this.j = new HashMap<>();
        this.f70938h = a.INITIAL;
        this.f70938h = a.INITIAL;
        net.one97.paytm.fastscanner.c.a aVar = net.one97.paytm.fastscanner.c.a.f50448b;
        net.one97.paytm.fastscanner.c.a.a((net.one97.paytm.fastscanner.c.c) this);
        Set<e> synchronizedSet = Collections.synchronizedSet(new HashSet());
        k.a((Object) synchronizedSet, "Collections.synchronizedSet(HashSet())");
        this.f70931a = synchronizedSet;
        d();
        this.l = new b(this);
    }

    public final void b() {
        net.one97.paytm.p2mNewDesign.models.b.c().d();
    }

    public final void a(e eVar) {
        k.c(eVar, "qrData");
        net.one97.paytm.p2mNewDesign.models.b.c().e();
        this.f70939i = Long.valueOf(System.currentTimeMillis() - this.f70935e);
        net.one97.paytm.wallet.newdesign.fastscan.b bVar = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
        if (!this.f70931a.contains(eVar)) {
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.utility.a.r(eVar.f50433a))) {
                Handler handler = this.k;
                if (handler != null) {
                    handler.removeCallbacks(this.l);
                }
                if (!this.f70931a.contains(eVar)) {
                    this.f70931a.add(eVar);
                    this.j.put(eVar, Long.valueOf(System.currentTimeMillis() - this.f70935e));
                    c(eVar);
                    a(eVar, false);
                } else {
                    return;
                }
            } else if (net.one97.paytm.wallet.utility.a.s(eVar.f50433a)) {
                Handler handler2 = this.k;
                if (handler2 != null) {
                    handler2.removeCallbacks(this.l);
                }
                if (!this.f70931a.contains(eVar)) {
                    this.f70931a.add(eVar);
                    this.j.put(eVar, Long.valueOf(System.currentTimeMillis() - this.f70935e));
                    c(eVar);
                    a(eVar, false);
                } else {
                    return;
                }
            } else if (!this.f70936f && !this.f70931a.contains(eVar)) {
                this.f70931a.add(eVar);
                this.j.put(eVar, Long.valueOf(System.currentTimeMillis() - this.f70935e));
            } else {
                return;
            }
            if (this.k == null) {
                this.k = new Handler();
                Handler handler3 = this.k;
                if (handler3 != null) {
                    Runnable runnable = this.l;
                    net.one97.paytm.wallet.newdesign.fastscan.b bVar2 = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
                    handler3.postDelayed(runnable, net.one97.paytm.wallet.newdesign.fastscan.b.b());
                }
            }
        }
    }

    public final void b(e eVar) {
        k.c(eVar, "qrData");
        net.one97.paytm.wallet.newdesign.fastscan.b bVar = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
        net.one97.paytm.wallet.newdesign.fastscan.b.a(true);
        net.one97.paytm.wallet.newdesign.fastscan.b bVar2 = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
        net.one97.paytm.wallet.newdesign.fastscan.b.b(true);
        this.f70934d.postValue(Boolean.TRUE);
        a(eVar, true);
    }

    public final void a() {
        net.one97.paytm.wallet.newdesign.fastscan.b bVar = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
        net.one97.paytm.wallet.newdesign.fastscan.b.a(true);
        this.f70933c.postValue(Boolean.TRUE);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(e eVar, boolean z) {
        if (this.f70938h == a.INITIAL) {
            this.f70938h = a.SCANNED;
            if (!z) {
                net.one97.paytm.p2mNewDesign.models.b.c().a(eVar.f50433a, this.f70931a.size(), this.f70937g);
                net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
                net.one97.paytm.wallet.a.a.a(true, eVar.f50433a, this.f70939i, System.currentTimeMillis() - this.f70935e, this.f70931a.size(), this.f70937g);
                at.a().a(at.a.Tscan, System.currentTimeMillis(), "");
            }
            this.f70932b.postValue(eVar);
            this.k = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(e eVar) {
        for (e next : this.f70931a) {
            b(next, p.a(eVar.f50433a, next.f50433a, true));
        }
    }

    private final void b(e eVar, boolean z) {
        Long l2 = this.j.get(eVar);
        if (l2 != null) {
            net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
            net.one97.paytm.wallet.a.a.a(eVar.f50433a, z, l2.longValue(), this.f70937g);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f70940a;

        b(c cVar) {
            this.f70940a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
            r2 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                net.one97.paytm.wallet.newdesign.fastscan.a.c r0 = r5.f70940a
                java.util.Set<net.one97.paytm.fastscanner.b.e> r0 = r0.f70931a
                java.util.Iterator r0 = r0.iterator()
                r1 = 0
                r2 = r1
                r3 = r2
            L_0x000b:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto L_0x0029
                java.lang.Object r3 = r0.next()
                net.one97.paytm.fastscanner.b.e r3 = (net.one97.paytm.fastscanner.b.e) r3
                java.lang.String r4 = r3.f50433a
                boolean r4 = com.paytm.utility.b.p((java.lang.String) r4)
                if (r4 != 0) goto L_0x0038
                java.lang.String r4 = r3.f50433a
                boolean r4 = net.one97.paytm.wallet.utility.a.m((java.lang.String) r4)
                if (r4 == 0) goto L_0x000b
                r2 = r3
                goto L_0x000b
            L_0x0029:
                if (r2 == 0) goto L_0x002e
                java.lang.String r0 = r2.f50433a
                goto L_0x002f
            L_0x002e:
                r0 = r1
            L_0x002f:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0038
                goto L_0x0039
            L_0x0038:
                r2 = r3
            L_0x0039:
                if (r2 == 0) goto L_0x003e
                java.lang.String r0 = r2.f50433a
                goto L_0x003f
            L_0x003e:
                r0 = r1
            L_0x003f:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0048
                r1 = r2
            L_0x0048:
                if (r1 != 0) goto L_0x0050
                net.one97.paytm.wallet.newdesign.fastscan.a.c r0 = r5.f70940a
                r0.c()
                return
            L_0x0050:
                net.one97.paytm.wallet.newdesign.fastscan.a.c r0 = r5.f70940a
                r2 = 1
                r0.f70936f = r2
                r0.c(r1)
                net.one97.paytm.wallet.newdesign.fastscan.a.c r0 = r5.f70940a
                r2 = 0
                r0.a(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.fastscan.a.c.b.run():void");
        }
    }

    private final void d() {
        this.f70931a.clear();
        this.j.clear();
        this.f70936f = false;
    }

    public final void c() {
        d();
        this.f70938h = a.INITIAL;
        this.k = null;
    }
}
