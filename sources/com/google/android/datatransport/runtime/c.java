package com.google.android.datatransport.runtime;

import com.google.android.datatransport.d;
import com.google.android.datatransport.runtime.l;
import java.util.Arrays;

final class c extends l {

    /* renamed from: a  reason: collision with root package name */
    private final String f7766a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f7767b;

    /* renamed from: c  reason: collision with root package name */
    private final d f7768c;

    /* synthetic */ c(String str, byte[] bArr, d dVar, byte b2) {
        this(str, bArr, dVar);
    }

    private c(String str, byte[] bArr, d dVar) {
        this.f7766a = str;
        this.f7767b = bArr;
        this.f7768c = dVar;
    }

    public final String a() {
        return this.f7766a;
    }

    public final byte[] b() {
        return this.f7767b;
    }

    public final d c() {
        return this.f7768c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f7766a.equals(lVar.a())) {
                return Arrays.equals(this.f7767b, lVar instanceof c ? ((c) lVar).f7767b : lVar.b()) && this.f7768c.equals(lVar.c());
            }
        }
    }

    public final int hashCode() {
        return ((((this.f7766a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7767b)) * 1000003) ^ this.f7768c.hashCode();
    }

    static final class a extends l.a {

        /* renamed from: a  reason: collision with root package name */
        private String f7769a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f7770b;

        /* renamed from: c  reason: collision with root package name */
        private d f7771c;

        a() {
        }

        public final l.a a(String str) {
            if (str != null) {
                this.f7769a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public final l.a a(byte[] bArr) {
            this.f7770b = bArr;
            return this;
        }

        public final l.a a(d dVar) {
            if (dVar != null) {
                this.f7771c = dVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        public final l a() {
            String str = "";
            if (this.f7769a == null) {
                str = str + " backendName";
            }
            if (this.f7771c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.f7769a, this.f7770b, this.f7771c, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
