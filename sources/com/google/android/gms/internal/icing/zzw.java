package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Locale;

public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new fs();

    /* renamed from: a  reason: collision with root package name */
    private final zzi f10325a;

    /* renamed from: b  reason: collision with root package name */
    private final long f10326b;

    /* renamed from: c  reason: collision with root package name */
    private int f10327c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10328d;

    /* renamed from: e  reason: collision with root package name */
    private final zzh f10329e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10330f;

    /* renamed from: g  reason: collision with root package name */
    private int f10331g;

    /* renamed from: h  reason: collision with root package name */
    private int f10332h;

    /* renamed from: i  reason: collision with root package name */
    private final String f10333i;

    zzw(zzi zzi, long j, int i2, String str, zzh zzh, boolean z, int i3, int i4, String str2) {
        this.f10325a = zzi;
        this.f10326b = j;
        this.f10327c = i2;
        this.f10328d = str;
        this.f10329e = zzh;
        this.f10330f = z;
        this.f10331g = i3;
        this.f10332h = i4;
        this.f10333i = str2;
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.f10325a, Long.valueOf(this.f10326b), Integer.valueOf(this.f10327c), Integer.valueOf(this.f10332h)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10325a, i2, false);
        b.a(parcel, 2, this.f10326b);
        b.b(parcel, 3, this.f10327c);
        b.a(parcel, 4, this.f10328d, false);
        b.a(parcel, 5, this.f10329e, i2, false);
        b.a(parcel, 6, this.f10330f);
        b.b(parcel, 7, this.f10331g);
        b.b(parcel, 8, this.f10332h);
        b.a(parcel, 9, this.f10333i, false);
        b.b(parcel, a2);
    }
}
