package com.google.android.play.core.a;

public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private final int f36894a;

    /* renamed from: b  reason: collision with root package name */
    private final long f36895b;

    /* renamed from: c  reason: collision with root package name */
    private final long f36896c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36897d;

    /* renamed from: e  reason: collision with root package name */
    private final String f36898e;

    public d(int i2, long j, long j2, int i3, String str) {
        this.f36894a = i2;
        this.f36895b = j;
        this.f36896c = j2;
        this.f36897d = i3;
        if (str != null) {
            this.f36898e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final int a() {
        return this.f36894a;
    }

    public final long b() {
        return this.f36895b;
    }

    public final long c() {
        return this.f36896c;
    }

    public final int d() {
        return this.f36897d;
    }

    public final String e() {
        return this.f36898e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f36894a == bVar.a() && this.f36895b == bVar.b() && this.f36896c == bVar.c() && this.f36897d == bVar.d() && this.f36898e.equals(bVar.e());
        }
    }

    public final int hashCode() {
        int i2 = this.f36894a;
        long j = this.f36895b;
        long j2 = this.f36896c;
        return ((((((((i2 ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f36897d) * 1000003) ^ this.f36898e.hashCode();
    }

    public final String toString() {
        int i2 = this.f36894a;
        long j = this.f36895b;
        long j2 = this.f36896c;
        int i3 = this.f36897d;
        String str = this.f36898e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", installErrorCode=");
        sb.append(i3);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
