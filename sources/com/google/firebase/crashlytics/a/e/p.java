package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class p extends v.d.C0634d.a.b.e {

    /* renamed from: a  reason: collision with root package name */
    private final String f38532a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38533b;

    /* renamed from: c  reason: collision with root package name */
    private final w<v.d.C0634d.a.b.e.C0643b> f38534c;

    /* synthetic */ p(String str, int i2, w wVar, byte b2) {
        this(str, i2, wVar);
    }

    private p(String str, int i2, w<v.d.C0634d.a.b.e.C0643b> wVar) {
        this.f38532a = str;
        this.f38533b = i2;
        this.f38534c = wVar;
    }

    public final String a() {
        return this.f38532a;
    }

    public final int b() {
        return this.f38533b;
    }

    public final w<v.d.C0634d.a.b.e.C0643b> c() {
        return this.f38534c;
    }

    public final String toString() {
        return "Thread{name=" + this.f38532a + ", importance=" + this.f38533b + ", frames=" + this.f38534c + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.C0634d.a.b.e) {
            v.d.C0634d.a.b.e eVar = (v.d.C0634d.a.b.e) obj;
            return this.f38532a.equals(eVar.a()) && this.f38533b == eVar.b() && this.f38534c.equals(eVar.c());
        }
    }

    public final int hashCode() {
        return ((((this.f38532a.hashCode() ^ 1000003) * 1000003) ^ this.f38533b) * 1000003) ^ this.f38534c.hashCode();
    }

    static final class a extends v.d.C0634d.a.b.e.C0642a {

        /* renamed from: a  reason: collision with root package name */
        private String f38535a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f38536b;

        /* renamed from: c  reason: collision with root package name */
        private w<v.d.C0634d.a.b.e.C0643b> f38537c;

        a() {
        }

        public final v.d.C0634d.a.b.e.C0642a a(String str) {
            if (str != null) {
                this.f38535a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public final v.d.C0634d.a.b.e.C0642a a(int i2) {
            this.f38536b = Integer.valueOf(i2);
            return this;
        }

        public final v.d.C0634d.a.b.e.C0642a a(w<v.d.C0634d.a.b.e.C0643b> wVar) {
            if (wVar != null) {
                this.f38537c = wVar;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public final v.d.C0634d.a.b.e a() {
            String str = "";
            if (this.f38535a == null) {
                str = str + " name";
            }
            if (this.f38536b == null) {
                str = str + " importance";
            }
            if (this.f38537c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new p(this.f38535a, this.f38536b.intValue(), this.f38537c, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
