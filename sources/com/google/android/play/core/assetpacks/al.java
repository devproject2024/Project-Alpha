package com.google.android.play.core.assetpacks;

import java.util.Arrays;

final class al extends cs {

    /* renamed from: a  reason: collision with root package name */
    private final String f36979a;

    /* renamed from: b  reason: collision with root package name */
    private final long f36980b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36981c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f36982d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f36983e;

    al(String str, long j, int i2, boolean z, byte[] bArr) {
        this.f36979a = str;
        this.f36980b = j;
        this.f36981c = i2;
        this.f36982d = z;
        this.f36983e = bArr;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f36979a;
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        return this.f36980b;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.f36981c;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.f36982d;
    }

    /* access modifiers changed from: package-private */
    public final byte[] e() {
        return this.f36983e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cs) {
            cs csVar = (cs) obj;
            String str = this.f36979a;
            if (str == null ? csVar.a() == null : str.equals(csVar.a())) {
                if (this.f36980b == csVar.b() && this.f36981c == csVar.c() && this.f36982d == csVar.d()) {
                    if (Arrays.equals(this.f36983e, csVar instanceof al ? ((al) csVar).f36983e : csVar.e())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f36979a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.f36980b;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f36981c) * 1000003) ^ (true != this.f36982d ? 1237 : 1231)) * 1000003) ^ Arrays.hashCode(this.f36983e);
    }

    public final String toString() {
        String str = this.f36979a;
        long j = this.f36980b;
        int i2 = this.f36981c;
        boolean z = this.f36982d;
        String arrays = Arrays.toString(this.f36983e);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 104 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i2);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
