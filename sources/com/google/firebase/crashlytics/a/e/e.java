package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;
import java.util.Arrays;

final class e extends v.c.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f38431a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f38432b;

    /* synthetic */ e(String str, byte[] bArr, byte b2) {
        this(str, bArr);
    }

    private e(String str, byte[] bArr) {
        this.f38431a = str;
        this.f38432b = bArr;
    }

    public final String a() {
        return this.f38431a;
    }

    public final byte[] b() {
        return this.f38432b;
    }

    public final String toString() {
        return "File{filename=" + this.f38431a + ", contents=" + Arrays.toString(this.f38432b) + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.c.b) {
            v.c.b bVar = (v.c.b) obj;
            if (this.f38431a.equals(bVar.a())) {
                if (Arrays.equals(this.f38432b, bVar instanceof e ? ((e) bVar).f38432b : bVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f38431a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f38432b);
    }

    static final class a extends v.c.b.a {

        /* renamed from: a  reason: collision with root package name */
        private String f38433a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f38434b;

        a() {
        }

        public final v.c.b.a a(String str) {
            if (str != null) {
                this.f38433a = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }

        public final v.c.b.a a(byte[] bArr) {
            if (bArr != null) {
                this.f38434b = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public final v.c.b a() {
            String str = "";
            if (this.f38433a == null) {
                str = str + " filename";
            }
            if (this.f38434b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new e(this.f38433a, this.f38434b, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
