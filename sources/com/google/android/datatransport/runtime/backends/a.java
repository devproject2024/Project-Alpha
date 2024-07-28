package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.h;
import java.util.Arrays;

final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<h> f7743a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f7744b;

    /* synthetic */ a(Iterable iterable, byte[] bArr, byte b2) {
        this(iterable, bArr);
    }

    private a(Iterable<h> iterable, byte[] bArr) {
        this.f7743a = iterable;
        this.f7744b = bArr;
    }

    public final Iterable<h> a() {
        return this.f7743a;
    }

    public final byte[] b() {
        return this.f7744b;
    }

    public final String toString() {
        return "BackendRequest{events=" + this.f7743a + ", extras=" + Arrays.toString(this.f7744b) + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f7743a.equals(fVar.a())) {
                if (Arrays.equals(this.f7744b, fVar instanceof a ? ((a) fVar).f7744b : fVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7743a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7744b);
    }

    /* renamed from: com.google.android.datatransport.runtime.backends.a$a  reason: collision with other inner class name */
    public static final class C0115a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<h> f7745a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f7746b;

        public final f.a a(Iterable<h> iterable) {
            this.f7745a = iterable;
            return this;
        }

        public final f.a a(byte[] bArr) {
            this.f7746b = bArr;
            return this;
        }

        public final f a() {
            String str = "";
            if (this.f7745a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new a(this.f7745a, this.f7746b, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
