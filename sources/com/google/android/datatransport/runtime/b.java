package com.google.android.datatransport.runtime;

import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.datatransport.runtime.k;

final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    private final l f7733a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7734b;

    /* renamed from: c  reason: collision with root package name */
    private final c<?> f7735c;

    /* renamed from: d  reason: collision with root package name */
    private final e<?, byte[]> f7736d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.b f7737e;

    /* synthetic */ b(l lVar, String str, c cVar, e eVar, com.google.android.datatransport.b bVar, byte b2) {
        this(lVar, str, cVar, eVar, bVar);
    }

    private b(l lVar, String str, c<?> cVar, e<?, byte[]> eVar, com.google.android.datatransport.b bVar) {
        this.f7733a = lVar;
        this.f7734b = str;
        this.f7735c = cVar;
        this.f7736d = eVar;
        this.f7737e = bVar;
    }

    public final l a() {
        return this.f7733a;
    }

    public final String b() {
        return this.f7734b;
    }

    /* access modifiers changed from: package-private */
    public final c<?> c() {
        return this.f7735c;
    }

    /* access modifiers changed from: package-private */
    public final e<?, byte[]> d() {
        return this.f7736d;
    }

    public final com.google.android.datatransport.b e() {
        return this.f7737e;
    }

    public final String toString() {
        return "SendRequest{transportContext=" + this.f7733a + ", transportName=" + this.f7734b + ", event=" + this.f7735c + ", transformer=" + this.f7736d + ", encoding=" + this.f7737e + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.f7733a.equals(kVar.a()) && this.f7734b.equals(kVar.b()) && this.f7735c.equals(kVar.c()) && this.f7736d.equals(kVar.d()) && this.f7737e.equals(kVar.e());
        }
    }

    public final int hashCode() {
        return ((((((((this.f7733a.hashCode() ^ 1000003) * 1000003) ^ this.f7734b.hashCode()) * 1000003) ^ this.f7735c.hashCode()) * 1000003) ^ this.f7736d.hashCode()) * 1000003) ^ this.f7737e.hashCode();
    }

    static final class a extends k.a {

        /* renamed from: a  reason: collision with root package name */
        private l f7738a;

        /* renamed from: b  reason: collision with root package name */
        private String f7739b;

        /* renamed from: c  reason: collision with root package name */
        private c<?> f7740c;

        /* renamed from: d  reason: collision with root package name */
        private e<?, byte[]> f7741d;

        /* renamed from: e  reason: collision with root package name */
        private com.google.android.datatransport.b f7742e;

        a() {
        }

        public final k.a a(l lVar) {
            if (lVar != null) {
                this.f7738a = lVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public final k.a a(String str) {
            if (str != null) {
                this.f7739b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* access modifiers changed from: package-private */
        public final k.a a(c<?> cVar) {
            if (cVar != null) {
                this.f7740c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public final k.a a(e<?, byte[]> eVar) {
            if (eVar != null) {
                this.f7741d = eVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        /* access modifiers changed from: package-private */
        public final k.a a(com.google.android.datatransport.b bVar) {
            if (bVar != null) {
                this.f7742e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        public final k a() {
            String str = "";
            if (this.f7738a == null) {
                str = str + " transportContext";
            }
            if (this.f7739b == null) {
                str = str + " transportName";
            }
            if (this.f7740c == null) {
                str = str + " event";
            }
            if (this.f7741d == null) {
                str = str + " transformer";
            }
            if (this.f7742e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.f7738a, this.f7739b, this.f7740c, this.f7741d, this.f7742e, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
