package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class l extends v.d.C0634d.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final w<v.d.C0634d.a.b.e> f38500a;

    /* renamed from: b  reason: collision with root package name */
    private final v.d.C0634d.a.b.c f38501b;

    /* renamed from: c  reason: collision with root package name */
    private final v.d.C0634d.a.b.C0640d f38502c;

    /* renamed from: d  reason: collision with root package name */
    private final w<v.d.C0634d.a.b.C0636a> f38503d;

    /* synthetic */ l(w wVar, v.d.C0634d.a.b.c cVar, v.d.C0634d.a.b.C0640d dVar, w wVar2, byte b2) {
        this(wVar, cVar, dVar, wVar2);
    }

    private l(w<v.d.C0634d.a.b.e> wVar, v.d.C0634d.a.b.c cVar, v.d.C0634d.a.b.C0640d dVar, w<v.d.C0634d.a.b.C0636a> wVar2) {
        this.f38500a = wVar;
        this.f38501b = cVar;
        this.f38502c = dVar;
        this.f38503d = wVar2;
    }

    public final w<v.d.C0634d.a.b.e> a() {
        return this.f38500a;
    }

    public final v.d.C0634d.a.b.c b() {
        return this.f38501b;
    }

    public final v.d.C0634d.a.b.C0640d c() {
        return this.f38502c;
    }

    public final w<v.d.C0634d.a.b.C0636a> d() {
        return this.f38503d;
    }

    public final String toString() {
        return "Execution{threads=" + this.f38500a + ", exception=" + this.f38501b + ", signal=" + this.f38502c + ", binaries=" + this.f38503d + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.C0634d.a.b) {
            v.d.C0634d.a.b bVar = (v.d.C0634d.a.b) obj;
            return this.f38500a.equals(bVar.a()) && this.f38501b.equals(bVar.b()) && this.f38502c.equals(bVar.c()) && this.f38503d.equals(bVar.d());
        }
    }

    public final int hashCode() {
        return ((((((this.f38500a.hashCode() ^ 1000003) * 1000003) ^ this.f38501b.hashCode()) * 1000003) ^ this.f38502c.hashCode()) * 1000003) ^ this.f38503d.hashCode();
    }

    static final class a extends v.d.C0634d.a.b.C0638b {

        /* renamed from: a  reason: collision with root package name */
        private w<v.d.C0634d.a.b.e> f38504a;

        /* renamed from: b  reason: collision with root package name */
        private v.d.C0634d.a.b.c f38505b;

        /* renamed from: c  reason: collision with root package name */
        private v.d.C0634d.a.b.C0640d f38506c;

        /* renamed from: d  reason: collision with root package name */
        private w<v.d.C0634d.a.b.C0636a> f38507d;

        a() {
        }

        public final v.d.C0634d.a.b.C0638b a(w<v.d.C0634d.a.b.e> wVar) {
            if (wVar != null) {
                this.f38504a = wVar;
                return this;
            }
            throw new NullPointerException("Null threads");
        }

        public final v.d.C0634d.a.b.C0638b a(v.d.C0634d.a.b.c cVar) {
            if (cVar != null) {
                this.f38505b = cVar;
                return this;
            }
            throw new NullPointerException("Null exception");
        }

        public final v.d.C0634d.a.b.C0638b a(v.d.C0634d.a.b.C0640d dVar) {
            if (dVar != null) {
                this.f38506c = dVar;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public final v.d.C0634d.a.b.C0638b b(w<v.d.C0634d.a.b.C0636a> wVar) {
            if (wVar != null) {
                this.f38507d = wVar;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public final v.d.C0634d.a.b a() {
            String str = "";
            if (this.f38504a == null) {
                str = str + " threads";
            }
            if (this.f38505b == null) {
                str = str + " exception";
            }
            if (this.f38506c == null) {
                str = str + " signal";
            }
            if (this.f38507d == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new l(this.f38504a, this.f38505b, this.f38506c, this.f38507d, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
