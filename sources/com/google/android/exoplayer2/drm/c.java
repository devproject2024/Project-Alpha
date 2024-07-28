package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.g.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class c<T extends g> implements a.c<T>, e<T> {

    /* renamed from: a  reason: collision with root package name */
    public final h<b> f31374a;

    /* renamed from: b  reason: collision with root package name */
    final List<a<T>> f31375b;

    /* renamed from: c  reason: collision with root package name */
    volatile c<T>.defpackage.a f31376c;

    /* renamed from: d  reason: collision with root package name */
    private final UUID f31377d;

    /* renamed from: e  reason: collision with root package name */
    private final h<T> f31378e;

    /* renamed from: f  reason: collision with root package name */
    private final k f31379f;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f31380g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f31381h;

    /* renamed from: i  reason: collision with root package name */
    private final int f31382i;
    private final List<a<T>> j;
    private Looper k;
    private int l;
    private byte[] m;

    public static final class b extends Exception {
        private b(UUID uuid) {
            super("Media does not support uuid: ".concat(String.valueOf(uuid)));
        }
    }

    public final boolean a(DrmInitData drmInitData) {
        if (this.m != null) {
            return true;
        }
        if (a(drmInitData, this.f31377d, true).isEmpty()) {
            if (drmInitData.f31355c != 1 || !drmInitData.f31353a[0].a(com.google.android.exoplayer2.c.f31285b)) {
                return false;
            }
            new StringBuilder("DrmInitData only contains common PSSH SchemeData. Assuming support for: ").append(this.f31377d);
            l.c();
        }
        String str = drmInitData.f31354b;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if (("cbc1".equals(str) || "cbcs".equals(str) || "cens".equals(str)) && ae.f32499a < 25) {
            return false;
        }
        return true;
    }

    public final d<T> a(Looper looper, DrmInitData drmInitData) {
        List<DrmInitData.SchemeData> list;
        a aVar;
        Looper looper2 = this.k;
        com.google.android.exoplayer2.g.a.b(looper2 == null || looper2 == looper);
        if (this.f31375b.isEmpty()) {
            this.k = looper;
            if (this.f31376c == null) {
                this.f31376c = new a(looper);
            }
        }
        a aVar2 = null;
        if (this.m == null) {
            List<DrmInitData.SchemeData> a2 = a(drmInitData, this.f31377d, false);
            if (a2.isEmpty()) {
                b bVar = new b(this.f31377d);
                this.f31374a.a(new h.a() {
                    public final void sendTo(Object obj) {
                        ((b) obj).n();
                    }
                });
                return new f(new d.a(bVar));
            }
            list = a2;
        } else {
            list = null;
        }
        if (this.f31381h) {
            Iterator<a<T>> it2 = this.f31375b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                a next = it2.next();
                if (ae.a((Object) next.f31363a, (Object) list)) {
                    aVar2 = next;
                    break;
                }
            }
        } else if (!this.f31375b.isEmpty()) {
            aVar2 = this.f31375b.get(0);
        }
        if (aVar2 == null) {
            aVar = new a(this.f31377d, this.f31378e, this, list, this.l, this.m, this.f31380g, this.f31379f, looper, this.f31374a, this.f31382i);
            this.f31375b.add(aVar);
        } else {
            aVar = aVar2;
        }
        aVar.a();
        return aVar;
    }

    public final void a(d<T> dVar) {
        if (!(dVar instanceof f)) {
            a<T> aVar = (a) dVar;
            if (aVar.b()) {
                this.f31375b.remove(aVar);
                if (this.j.size() > 1 && this.j.get(0) == aVar) {
                    this.j.get(1).c();
                }
                this.j.remove(aVar);
            }
        }
    }

    public final void a(a<T> aVar) {
        if (!this.j.contains(aVar)) {
            this.j.add(aVar);
            if (this.j.size() == 1) {
                aVar.c();
            }
        }
    }

    public final void a() {
        for (a<T> d2 : this.j) {
            d2.d();
        }
        this.j.clear();
    }

    public final void a(Exception exc) {
        for (a<T> a2 : this.j) {
            a2.a(exc);
        }
        this.j.clear();
    }

    private static List<DrmInitData.SchemeData> a(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.f31355c);
        for (int i2 = 0; i2 < drmInitData.f31355c; i2++) {
            DrmInitData.SchemeData schemeData = drmInitData.f31353a[i2];
            if ((schemeData.a(uuid) || (com.google.android.exoplayer2.c.f31286c.equals(uuid) && schemeData.a(com.google.android.exoplayer2.c.f31285b))) && (schemeData.f31360d != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (a next : c.this.f31375b) {
                    if (Arrays.equals(next.f31370h, bArr)) {
                        next.a(message.what);
                        return;
                    }
                }
            }
        }
    }
}
