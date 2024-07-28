package com.google.android.exoplayer2.a;

import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.h;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.video.g;
import com.google.android.exoplayer2.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class a implements f, h, com.google.android.exoplayer2.drm.b, d.a, com.google.android.exoplayer2.metadata.d, p, g, com.google.android.exoplayer2.video.h, z.a {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArraySet<b> f31073a;

    /* renamed from: b  reason: collision with root package name */
    public final c f31074b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.exoplayer2.g.b f31075c;

    /* renamed from: d  reason: collision with root package name */
    private final ah.b f31076d;

    /* renamed from: e  reason: collision with root package name */
    private z f31077e;

    public /* synthetic */ void b(boolean z) {
        z.a.CC.$default$b(this, z);
    }

    public final void i() {
    }

    /* renamed from: com.google.android.exoplayer2.a.a$a  reason: collision with other inner class name */
    public static class C0529a {
        public static a a(z zVar, com.google.android.exoplayer2.g.b bVar) {
            return new a(zVar, bVar);
        }
    }

    protected a(z zVar, com.google.android.exoplayer2.g.b bVar) {
        if (zVar != null) {
            this.f31077e = zVar;
        }
        this.f31075c = (com.google.android.exoplayer2.g.b) com.google.android.exoplayer2.g.a.a(bVar);
        this.f31073a = new CopyOnWriteArraySet<>();
        this.f31074b = new c();
        this.f31076d = new ah.b();
    }

    public final void g() {
        for (b bVar : new ArrayList(this.f31074b.f31081a)) {
            b(bVar.f31080c, bVar.f31078a);
        }
    }

    public final void a(Metadata metadata) {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void c(com.google.android.exoplayer2.c.d dVar) {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(String str, long j, long j2) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(Format format) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2, long j, long j2) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void d(com.google.android.exoplayer2.c.d dVar) {
        r();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(int i2) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void h() {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(com.google.android.exoplayer2.c.d dVar) {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(String str, long j, long j2) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(Format format) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2, long j) {
        r();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(com.google.android.exoplayer2.c.d dVar) {
        r();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(Surface surface) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2, int i3, int i4, float f2) {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void j() {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2, o.a aVar) {
        c cVar = this.f31074b;
        b bVar = new b(aVar, cVar.f31086f.a(aVar.f33224a) != -1 ? cVar.f31086f : ah.f31122a, i2);
        cVar.f31081a.add(bVar);
        cVar.f31082b.put(aVar, bVar);
        if (cVar.f31081a.size() == 1 && !cVar.f31086f.a()) {
            cVar.c();
        }
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(int i2, o.a aVar) {
        d(i2, aVar);
        c cVar = this.f31074b;
        b remove = cVar.f31082b.remove(aVar);
        boolean z = false;
        if (remove != null) {
            cVar.f31081a.remove(remove);
            if (cVar.f31085e != null && aVar.equals(cVar.f31085e.f31078a)) {
                cVar.f31085e = cVar.f31081a.isEmpty() ? null : cVar.f31081a.get(0);
            }
            z = true;
        }
        if (z) {
            Iterator<b> it2 = this.f31073a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void a(int i2, o.a aVar, p.b bVar, p.c cVar) {
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(int i2, o.a aVar, p.b bVar, p.c cVar) {
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void c(int i2, o.a aVar, p.b bVar, p.c cVar) {
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2, o.a aVar, p.b bVar, p.c cVar, IOException iOException, boolean z) {
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void c(int i2, o.a aVar) {
        c cVar = this.f31074b;
        cVar.f31085e = cVar.f31082b.get(aVar);
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2, o.a aVar, p.c cVar) {
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b(int i2, o.a aVar, p.c cVar) {
        d(i2, aVar);
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(ah ahVar) {
        c cVar = this.f31074b;
        for (int i2 = 0; i2 < cVar.f31081a.size(); i2++) {
            b a2 = cVar.a(cVar.f31081a.get(i2), ahVar);
            cVar.f31081a.set(i2, a2);
            cVar.f31082b.put(a2.f31078a, a2);
        }
        if (cVar.f31085e != null) {
            cVar.f31085e = cVar.a(cVar.f31085e, ahVar);
        }
        cVar.f31086f = ahVar;
        cVar.c();
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a() {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(boolean z) {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(int i2) {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void b() {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void c() {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void a(i iVar) {
        if (iVar.type == 0) {
            t();
        } else {
            q();
        }
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void d() {
        this.f31074b.c();
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void e() {
        q();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void f() {
        if (this.f31074b.f31087g) {
            c cVar = this.f31074b;
            cVar.f31087g = false;
            cVar.c();
            q();
            Iterator<b> it2 = this.f31073a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
    }

    public final void k() {
        t();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void l() {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void m() {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void n() {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void o() {
        s();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void p() {
        r();
        Iterator<b> it2 = this.f31073a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    @RequiresNonNull({"player"})
    private b.a a(ah ahVar, int i2, o.a aVar) {
        if (ahVar.a()) {
            aVar = null;
        }
        o.a aVar2 = aVar;
        long a2 = this.f31075c.a();
        boolean z = true;
        boolean z2 = ahVar == this.f31077e.D() && i2 == this.f31077e.s();
        long j = 0;
        if (aVar2 != null && aVar2.a()) {
            if (!(z2 && this.f31077e.x() == aVar2.f33225b && this.f31077e.y() == aVar2.f33226c)) {
                z = false;
            }
            if (z) {
                j = this.f31077e.u();
            }
        } else if (z2) {
            j = this.f31077e.z();
        } else if (!ahVar.a()) {
            j = com.google.android.exoplayer2.c.a(ahVar.a(i2, this.f31076d).f31136h);
        }
        return new b.a(a2, ahVar, i2, aVar2, j, this.f31077e.u(), this.f31077e.v());
    }

    private b.a a(b bVar) {
        com.google.android.exoplayer2.g.a.a(this.f31077e);
        if (bVar == null) {
            int s = this.f31077e.s();
            c cVar = this.f31074b;
            boolean z = false;
            b bVar2 = null;
            int i2 = 0;
            while (true) {
                if (i2 >= cVar.f31081a.size()) {
                    break;
                }
                b bVar3 = cVar.f31081a.get(i2);
                int a2 = cVar.f31086f.a(bVar3.f31078a.f33224a);
                if (a2 != -1 && cVar.f31086f.a(a2, cVar.f31083c, false).f31125c == s) {
                    if (bVar2 != null) {
                        bVar2 = null;
                        break;
                    }
                    bVar2 = bVar3;
                }
                i2++;
            }
            if (bVar2 == null) {
                ah D = this.f31077e.D();
                if (s < D.b()) {
                    z = true;
                }
                if (!z) {
                    D = ah.f31122a;
                }
                return a(D, s, (o.a) null);
            }
            bVar = bVar2;
        }
        return a(bVar.f31079b, bVar.f31080c, bVar.f31078a);
    }

    private b.a r() {
        return a(this.f31074b.f31084d);
    }

    public final b.a q() {
        return a(this.f31074b.a());
    }

    private b.a s() {
        return a(this.f31074b.f31085e);
    }

    private b.a t() {
        return a(this.f31074b.b());
    }

    private b.a d(int i2, o.a aVar) {
        com.google.android.exoplayer2.g.a.a(this.f31077e);
        if (aVar != null) {
            b a2 = this.f31074b.a(aVar);
            if (a2 != null) {
                return a(a2);
            }
            return a(ah.f31122a, i2, aVar);
        }
        ah D = this.f31077e.D();
        if (!(i2 < D.b())) {
            D = ah.f31122a;
        }
        return a(D, i2, (o.a) null);
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<b> f31081a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        final HashMap<o.a, b> f31082b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        final ah.a f31083c = new ah.a();

        /* renamed from: d  reason: collision with root package name */
        b f31084d;

        /* renamed from: e  reason: collision with root package name */
        b f31085e;

        /* renamed from: f  reason: collision with root package name */
        ah f31086f = ah.f31122a;

        /* renamed from: g  reason: collision with root package name */
        public boolean f31087g;

        public final b a() {
            if (this.f31081a.isEmpty() || this.f31086f.a() || this.f31087g) {
                return null;
            }
            return this.f31081a.get(0);
        }

        public final b b() {
            if (this.f31081a.isEmpty()) {
                return null;
            }
            ArrayList<b> arrayList = this.f31081a;
            return arrayList.get(arrayList.size() - 1);
        }

        public final b a(o.a aVar) {
            return this.f31082b.get(aVar);
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            if (!this.f31081a.isEmpty()) {
                this.f31084d = this.f31081a.get(0);
            }
        }

        /* access modifiers changed from: package-private */
        public final b a(b bVar, ah ahVar) {
            int a2 = ahVar.a(bVar.f31078a.f33224a);
            if (a2 == -1) {
                return bVar;
            }
            return new b(bVar.f31078a, ahVar, ahVar.a(a2, this.f31083c, false).f31125c);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final o.a f31078a;

        /* renamed from: b  reason: collision with root package name */
        public final ah f31079b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31080c;

        public b(o.a aVar, ah ahVar, int i2) {
            this.f31078a = aVar;
            this.f31079b = ahVar;
            this.f31080c = i2;
        }
    }
}
