package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

final class q extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f36924a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36925b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36926c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36927d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f36928e;

    /* renamed from: f  reason: collision with root package name */
    private final int f36929f;

    /* renamed from: g  reason: collision with root package name */
    private final long f36930g;

    /* renamed from: h  reason: collision with root package name */
    private final long f36931h;

    /* renamed from: i  reason: collision with root package name */
    private final long f36932i;
    private final long j;
    private final PendingIntent k;
    private final PendingIntent l;
    private final PendingIntent m;
    private final PendingIntent n;

    q(String str, int i2, int i3, int i4, Integer num, int i5, long j2, long j3, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        String str2 = str;
        if (str2 != null) {
            this.f36924a = str2;
            this.f36925b = i2;
            this.f36926c = i3;
            this.f36927d = i4;
            this.f36928e = num;
            this.f36929f = i5;
            this.f36930g = j2;
            this.f36931h = j3;
            this.f36932i = j4;
            this.j = j5;
            this.k = pendingIntent;
            this.l = pendingIntent2;
            this.m = pendingIntent3;
            this.n = pendingIntent4;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final String a() {
        return this.f36924a;
    }

    public final int b() {
        return this.f36925b;
    }

    public final int c() {
        return this.f36926c;
    }

    public final int d() {
        return this.f36927d;
    }

    public final Integer e() {
        return this.f36928e;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f36924a.equals(aVar.a()) && this.f36925b == aVar.b() && this.f36926c == aVar.c() && this.f36927d == aVar.d() && ((num = this.f36928e) == null ? aVar.e() == null : num.equals(aVar.e())) && this.f36929f == aVar.f() && this.f36930g == aVar.g() && this.f36931h == aVar.h() && this.f36932i == aVar.i() && this.j == aVar.j() && ((pendingIntent = this.k) == null ? aVar.k() == null : pendingIntent.equals(aVar.k())) && ((pendingIntent2 = this.l) == null ? aVar.l() == null : pendingIntent2.equals(aVar.l())) && ((pendingIntent3 = this.m) == null ? aVar.m() == null : pendingIntent3.equals(aVar.m()))) {
                PendingIntent pendingIntent4 = this.n;
                PendingIntent n2 = aVar.n();
                if (pendingIntent4 == null ? n2 == null : pendingIntent4.equals(n2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int f() {
        return this.f36929f;
    }

    public final long g() {
        return this.f36930g;
    }

    public final long h() {
        return this.f36931h;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f36924a.hashCode() ^ 1000003) * 1000003) ^ this.f36925b) * 1000003) ^ this.f36926c) * 1000003) ^ this.f36927d) * 1000003;
        Integer num = this.f36928e;
        int i2 = 0;
        int hashCode2 = num != null ? num.hashCode() : 0;
        int i3 = this.f36929f;
        long j2 = this.f36930g;
        long j3 = this.f36931h;
        long j4 = this.f36932i;
        long j5 = this.j;
        int i4 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        PendingIntent pendingIntent = this.k;
        int hashCode3 = (i4 ^ (pendingIntent != null ? pendingIntent.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent2 = this.l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 != null ? pendingIntent2.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent3 = this.m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 != null ? pendingIntent3.hashCode() : 0)) * 1000003;
        PendingIntent pendingIntent4 = this.n;
        if (pendingIntent4 != null) {
            i2 = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i2;
    }

    /* access modifiers changed from: package-private */
    public final long i() {
        return this.f36932i;
    }

    /* access modifiers changed from: package-private */
    public final long j() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent k() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent l() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent m() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public final PendingIntent n() {
        return this.n;
    }

    public final String toString() {
        String str = this.f36924a;
        int i2 = this.f36925b;
        int i3 = this.f36926c;
        int i4 = this.f36927d;
        String valueOf = String.valueOf(this.f36928e);
        int i5 = this.f36929f;
        long j2 = this.f36930g;
        long j3 = this.f36931h;
        long j4 = this.f36932i;
        long j5 = this.j;
        String valueOf2 = String.valueOf(this.k);
        long j6 = j5;
        String valueOf3 = String.valueOf(this.l);
        String valueOf4 = String.valueOf(this.m);
        long j7 = j4;
        String valueOf5 = String.valueOf(this.n);
        int length = str.length();
        int length2 = String.valueOf(valueOf).length();
        int length3 = String.valueOf(valueOf2).length();
        int length4 = String.valueOf(valueOf3).length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i2);
        sb.append(", updateAvailability=");
        sb.append(i3);
        sb.append(", installStatus=");
        sb.append(i4);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i5);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", additionalSpaceRequired=");
        sb.append(j7);
        sb.append(", assetPackStorageSize=");
        sb.append(j6);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        sb.append(", flexibleUpdateIntent=");
        sb.append(valueOf3);
        sb.append(", immediateDestructiveUpdateIntent=");
        sb.append(valueOf4);
        sb.append(", flexibleDestructiveUpdateIntent=");
        sb.append(valueOf5);
        sb.append("}");
        return sb.toString();
    }
}
