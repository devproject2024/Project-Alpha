package com.google.android.datatransport.runtime;

import com.google.android.datatransport.b;
import java.util.Arrays;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final b f7786a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f7787b;

    public g(b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f7786a = bVar;
            this.f7787b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f7786a.equals(gVar.f7786a)) {
            return false;
        }
        return Arrays.equals(this.f7787b, gVar.f7787b);
    }

    public final int hashCode() {
        return ((this.f7786a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7787b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f7786a + ", bytes=[...]}";
    }
}
