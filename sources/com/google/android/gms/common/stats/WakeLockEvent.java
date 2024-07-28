package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8930a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8931b;

    /* renamed from: c  reason: collision with root package name */
    private int f8932c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8933d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8934e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8935f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8936g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f8937h;

    /* renamed from: i  reason: collision with root package name */
    private final String f8938i;
    private final long j;
    private int k;
    private final String l;
    private final float m;
    private final long n;
    private final boolean o;
    private long p;

    WakeLockEvent(int i2, long j2, int i3, String str, int i4, List<String> list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this.f8930a = i2;
        this.f8931b = j2;
        this.f8932c = i3;
        this.f8933d = str;
        this.f8934e = str3;
        this.f8935f = str5;
        this.f8936g = i4;
        this.p = -1;
        this.f8937h = list;
        this.f8938i = str2;
        this.j = j3;
        this.k = i5;
        this.l = str4;
        this.m = f2;
        this.n = j4;
        this.o = z;
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List<String> list, String str2, long j3, int i4, String str3, String str4, float f2, long j4) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, (String) null, false);
    }

    public final long a() {
        return this.f8931b;
    }

    public final int b() {
        return this.f8932c;
    }

    public final long c() {
        return this.p;
    }

    public final String d() {
        String str;
        String str2 = this.f8933d;
        int i2 = this.f8936g;
        List<String> list = this.f8937h;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(AppConstants.COMMA, list);
        }
        int i3 = this.k;
        String str4 = this.f8934e;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.l;
        if (str5 == null) {
            str5 = str3;
        }
        float f2 = this.m;
        String str6 = this.f8935f;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = this.o;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str3).length());
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8930a);
        b.a(parcel, 2, a());
        b.a(parcel, 4, this.f8933d, false);
        b.b(parcel, 5, this.f8936g);
        b.b(parcel, 6, this.f8937h);
        b.a(parcel, 8, this.j);
        b.a(parcel, 10, this.f8934e, false);
        b.b(parcel, 11, b());
        b.a(parcel, 12, this.f8938i, false);
        b.a(parcel, 13, this.l, false);
        b.b(parcel, 14, this.k);
        b.a(parcel, 15, this.m);
        b.a(parcel, 16, this.n);
        b.a(parcel, 17, this.f8935f, false);
        b.a(parcel, 18, this.o);
        b.b(parcel, a2);
    }
}
