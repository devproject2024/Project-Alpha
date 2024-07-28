package androidx.recyclerview.widget;

import androidx.a.d;
import androidx.a.g;
import androidx.core.g.e;
import androidx.recyclerview.widget.RecyclerView;

final class ab {

    /* renamed from: a  reason: collision with root package name */
    final g<RecyclerView.v, a> f4165a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.v> f4166b = new d<>();

    interface b {
        void a(RecyclerView.v vVar);

        void a(RecyclerView.v vVar, RecyclerView.f.b bVar, RecyclerView.f.b bVar2);

        void b(RecyclerView.v vVar, RecyclerView.f.b bVar, RecyclerView.f.b bVar2);

        void c(RecyclerView.v vVar, RecyclerView.f.b bVar, RecyclerView.f.b bVar2);
    }

    ab() {
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f4165a.clear();
        this.f4166b.d();
    }

    /* access modifiers changed from: package-private */
    public final void a(RecyclerView.v vVar, RecyclerView.f.b bVar) {
        a aVar = this.f4165a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4165a.put(vVar, aVar);
        }
        aVar.f4169b = bVar;
        aVar.f4168a |= 4;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(RecyclerView.v vVar) {
        a aVar = this.f4165a.get(vVar);
        return (aVar == null || (aVar.f4168a & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final RecyclerView.f.b a(RecyclerView.v vVar, int i2) {
        a c2;
        RecyclerView.f.b bVar;
        int a2 = this.f4165a.a((Object) vVar);
        if (a2 < 0 || (c2 = this.f4165a.c(a2)) == null || (c2.f4168a & i2) == 0) {
            return null;
        }
        c2.f4168a &= ~i2;
        if (i2 == 4) {
            bVar = c2.f4169b;
        } else if (i2 == 8) {
            bVar = c2.f4170c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((c2.f4168a & 12) == 0) {
            this.f4165a.d(a2);
            a.a(c2);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j, RecyclerView.v vVar) {
        this.f4166b.b(j, vVar);
    }

    /* access modifiers changed from: package-private */
    public final void b(RecyclerView.v vVar, RecyclerView.f.b bVar) {
        a aVar = this.f4165a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4165a.put(vVar, aVar);
        }
        aVar.f4170c = bVar;
        aVar.f4168a |= 8;
    }

    /* access modifiers changed from: package-private */
    public final void b(RecyclerView.v vVar) {
        a aVar = this.f4165a.get(vVar);
        if (aVar == null) {
            aVar = a.a();
            this.f4165a.put(vVar, aVar);
        }
        aVar.f4168a |= 1;
    }

    /* access modifiers changed from: package-private */
    public final void c(RecyclerView.v vVar) {
        a aVar = this.f4165a.get(vVar);
        if (aVar != null) {
            aVar.f4168a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(RecyclerView.v vVar) {
        int b2 = this.f4166b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (vVar == this.f4166b.c(b2)) {
                this.f4166b.a(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f4165a.remove(vVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    static class a {

        /* renamed from: d  reason: collision with root package name */
        static e.a<a> f4167d = new e.b(20);

        /* renamed from: a  reason: collision with root package name */
        int f4168a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.f.b f4169b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.f.b f4170c;

        private a() {
        }

        static a a() {
            a a2 = f4167d.a();
            return a2 == null ? new a() : a2;
        }

        static void a(a aVar) {
            aVar.f4168a = 0;
            aVar.f4169b = null;
            aVar.f4170c = null;
            f4167d.a(aVar);
        }

        static void b() {
            do {
            } while (f4167d.a() != null);
        }
    }
}
