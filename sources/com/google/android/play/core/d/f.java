package com.google.android.play.core.d;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

final class f extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f37406a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37407b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37408c;

    /* renamed from: d  reason: collision with root package name */
    private final long f37409d;

    /* renamed from: e  reason: collision with root package name */
    private final long f37410e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f37411f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f37412g;

    /* renamed from: h  reason: collision with root package name */
    private final PendingIntent f37413h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Intent> f37414i;

    f(int i2, int i3, int i4, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.f37406a = i2;
        this.f37407b = i3;
        this.f37408c = i4;
        this.f37409d = j;
        this.f37410e = j2;
        this.f37411f = list;
        this.f37412g = list2;
        this.f37413h = pendingIntent;
        this.f37414i = list3;
    }

    public final int a() {
        return this.f37406a;
    }

    public final int b() {
        return this.f37407b;
    }

    public final int c() {
        return this.f37408c;
    }

    public final long d() {
        return this.f37409d;
    }

    public final long e() {
        return this.f37410e;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f37406a == dVar.a() && this.f37407b == dVar.b() && this.f37408c == dVar.c() && this.f37409d == dVar.d() && this.f37410e == dVar.e() && ((list = this.f37411f) == null ? dVar.i() == null : list.equals(dVar.i())) && ((list2 = this.f37412g) == null ? dVar.j() == null : list2.equals(dVar.j())) && ((pendingIntent = this.f37413h) == null ? dVar.h() == null : pendingIntent.equals(dVar.h()))) {
                List<Intent> list3 = this.f37414i;
                List<Intent> k = dVar.k();
                if (list3 == null ? k == null : list3.equals(k)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public final PendingIntent h() {
        return this.f37413h;
    }

    public final int hashCode() {
        int i2 = this.f37406a;
        int i3 = this.f37407b;
        int i4 = this.f37408c;
        long j = this.f37409d;
        long j2 = this.f37410e;
        int i5 = (((((((((i2 ^ 1000003) * 1000003) ^ i3) * 1000003) ^ i4) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f37411f;
        int i6 = 0;
        int hashCode = (i5 ^ (list != null ? list.hashCode() : 0)) * 1000003;
        List<String> list2 = this.f37412g;
        int hashCode2 = (hashCode ^ (list2 != null ? list2.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent = this.f37413h;
        int hashCode3 = (hashCode2 ^ (pendingIntent != null ? pendingIntent.hashCode() : 0)) * 1000003;
        List<Intent> list3 = this.f37414i;
        if (list3 != null) {
            i6 = list3.hashCode();
        }
        return hashCode3 ^ i6;
    }

    /* access modifiers changed from: package-private */
    public final List<String> i() {
        return this.f37411f;
    }

    /* access modifiers changed from: package-private */
    public final List<String> j() {
        return this.f37412g;
    }

    /* access modifiers changed from: package-private */
    public final List<Intent> k() {
        return this.f37414i;
    }

    public final String toString() {
        int i2 = this.f37406a;
        int i3 = this.f37407b;
        int i4 = this.f37408c;
        long j = this.f37409d;
        long j2 = this.f37410e;
        String valueOf = String.valueOf(this.f37411f);
        String valueOf2 = String.valueOf(this.f37412g);
        String valueOf3 = String.valueOf(this.f37413h);
        String valueOf4 = String.valueOf(this.f37414i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i2);
        sb.append(", status=");
        sb.append(i3);
        sb.append(", errorCode=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }
}
