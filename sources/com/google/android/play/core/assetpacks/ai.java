package com.google.android.play.core.assetpacks;

final class ai extends c {

    /* renamed from: a  reason: collision with root package name */
    private final String f36966a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36967b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36968c;

    /* renamed from: d  reason: collision with root package name */
    private final long f36969d;

    /* renamed from: e  reason: collision with root package name */
    private final long f36970e;

    /* renamed from: f  reason: collision with root package name */
    private final int f36971f;

    ai(String str, int i2, int i3, long j, long j2, int i4) {
        if (str != null) {
            this.f36966a = str;
            this.f36967b = i2;
            this.f36968c = i3;
            this.f36969d = j;
            this.f36970e = j2;
            this.f36971f = i4;
            return;
        }
        throw new NullPointerException("Null name");
    }

    public final String a() {
        return this.f36966a;
    }

    public final int b() {
        return this.f36967b;
    }

    public final int c() {
        return this.f36968c;
    }

    public final long d() {
        return this.f36969d;
    }

    public final long e() {
        return this.f36970e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f36966a.equals(cVar.a()) && this.f36967b == cVar.b() && this.f36968c == cVar.c() && this.f36969d == cVar.d() && this.f36970e == cVar.e() && this.f36971f == cVar.f();
        }
    }

    public final int f() {
        return this.f36971f;
    }

    public final int hashCode() {
        int hashCode = this.f36966a.hashCode();
        int i2 = this.f36967b;
        int i3 = this.f36968c;
        long j = this.f36969d;
        long j2 = this.f36970e;
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f36971f;
    }

    public final String toString() {
        String str = this.f36966a;
        int i2 = this.f36967b;
        int i3 = this.f36968c;
        long j = this.f36969d;
        long j2 = this.f36970e;
        int i4 = this.f36971f;
        StringBuilder sb = new StringBuilder(str.length() + 185);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }
}
