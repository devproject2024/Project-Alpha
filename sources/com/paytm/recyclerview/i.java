package com.paytm.recyclerview;

import androidx.a.d;
import androidx.core.g.e;
import com.paytm.recyclerview.RecyclerView;

final class i {

    /* renamed from: a  reason: collision with root package name */
    final androidx.a.a<RecyclerView.q, a> f15356a = new androidx.a.a<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.q> f15357b = new d<>();

    interface b {
        void a(RecyclerView.q qVar);

        void a(RecyclerView.q qVar, RecyclerView.e.b bVar, RecyclerView.e.b bVar2);

        void b(RecyclerView.q qVar, RecyclerView.e.b bVar, RecyclerView.e.b bVar2);

        void c(RecyclerView.q qVar, RecyclerView.e.b bVar, RecyclerView.e.b bVar2);
    }

    i() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f15356a.clear();
        this.f15357b.d();
    }

    /* access modifiers changed from: package-private */
    public final void a(RecyclerView.q qVar, RecyclerView.e.b bVar) {
        a aVar = this.f15356a.get(qVar);
        if (aVar == null) {
            aVar = a.a();
            this.f15356a.put(qVar, aVar);
        }
        aVar.f15360b = bVar;
        aVar.f15359a |= 4;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(RecyclerView.q qVar) {
        a aVar = this.f15356a.get(qVar);
        return (aVar == null || (aVar.f15359a & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final RecyclerView.e.b a(RecyclerView.q qVar, int i2) {
        a c2;
        RecyclerView.e.b bVar;
        int a2 = this.f15356a.a((Object) qVar);
        if (a2 < 0 || (c2 = this.f15356a.c(a2)) == null || (c2.f15359a & i2) == 0) {
            return null;
        }
        c2.f15359a &= ~i2;
        if (i2 == 4) {
            bVar = c2.f15360b;
        } else if (i2 == 8) {
            bVar = c2.f15361c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c2.f15359a & 12) == 0) {
            this.f15356a.d(a2);
            a.a(c2);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j, RecyclerView.q qVar) {
        this.f15357b.b(j, qVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(RecyclerView.q qVar, RecyclerView.e.b bVar) {
        a aVar = this.f15356a.get(qVar);
        if (aVar == null) {
            aVar = a.a();
            this.f15356a.put(qVar, aVar);
        }
        aVar.f15359a |= 2;
        aVar.f15360b = bVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(RecyclerView.q qVar) {
        a aVar = this.f15356a.get(qVar);
        return (aVar == null || (aVar.f15359a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final RecyclerView.q a(long j) {
        return this.f15357b.a(j, null);
    }

    /* access modifiers changed from: package-private */
    public final void c(RecyclerView.q qVar, RecyclerView.e.b bVar) {
        a aVar = this.f15356a.get(qVar);
        if (aVar == null) {
            aVar = a.a();
            this.f15356a.put(qVar, aVar);
        }
        aVar.f15361c = bVar;
        aVar.f15359a |= 8;
    }

    /* access modifiers changed from: package-private */
    public final void c(RecyclerView.q qVar) {
        a aVar = this.f15356a.get(qVar);
        if (aVar == null) {
            aVar = a.a();
            this.f15356a.put(qVar, aVar);
        }
        aVar.f15359a |= 1;
    }

    /* access modifiers changed from: package-private */
    public final void d(RecyclerView.q qVar) {
        a aVar = this.f15356a.get(qVar);
        if (aVar != null) {
            aVar.f15359a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        for (int size = this.f15356a.size() - 1; size >= 0; size--) {
            RecyclerView.q b2 = this.f15356a.b(size);
            a d2 = this.f15356a.d(size);
            if ((d2.f15359a & 3) == 3) {
                bVar.a(b2);
            } else if ((d2.f15359a & 1) != 0) {
                if (d2.f15360b == null) {
                    bVar.a(b2);
                } else {
                    bVar.a(b2, d2.f15360b, d2.f15361c);
                }
            } else if ((d2.f15359a & 14) == 14) {
                bVar.b(b2, d2.f15360b, d2.f15361c);
            } else if ((d2.f15359a & 12) == 12) {
                bVar.c(b2, d2.f15360b, d2.f15361c);
            } else if ((d2.f15359a & 4) != 0) {
                bVar.a(b2, d2.f15360b, (RecyclerView.e.b) null);
            } else if ((d2.f15359a & 8) != 0) {
                bVar.b(b2, d2.f15360b, d2.f15361c);
            }
            a.a(d2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(RecyclerView.q qVar) {
        int b2 = this.f15357b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (qVar == this.f15357b.c(b2)) {
                this.f15357b.a(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f15356a.remove(qVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static e.a<a> f15358d = new e.b(20);

        /* renamed from: a  reason: collision with root package name */
        int f15359a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.e.b f15360b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.e.b f15361c;

        private a() {
        }

        static a a() {
            a a2 = f15358d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f15359a = 0;
            aVar.f15360b = null;
            aVar.f15361c = null;
            f15358d.a(aVar);
        }

        static void b() {
            do {
            } while (f15358d.a() != null);
        }
    }
}
