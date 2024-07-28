package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.clearcut.fd;
import java.util.Arrays;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new gl();

    /* renamed from: a  reason: collision with root package name */
    public final int f9439a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9440b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9441c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9442d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9443e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9444f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f9445g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f9446h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9447i;

    public zzr(String str, int i2, int i3, String str2, String str3, String str4, boolean z, fd.v.b bVar) {
        this.f9441c = (String) s.a(str);
        this.f9442d = i2;
        this.f9439a = i3;
        this.f9440b = str2;
        this.f9443e = str3;
        this.f9444f = str4;
        this.f9445g = !z;
        this.f9446h = z;
        this.f9447i = bVar.zzc();
    }

    public zzr(String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f9441c = str;
        this.f9442d = i2;
        this.f9439a = i3;
        this.f9443e = str2;
        this.f9444f = str3;
        this.f9445g = z;
        this.f9440b = str4;
        this.f9446h = z2;
        this.f9447i = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzr) {
            zzr zzr = (zzr) obj;
            return q.a(this.f9441c, zzr.f9441c) && this.f9442d == zzr.f9442d && this.f9439a == zzr.f9439a && q.a(this.f9440b, zzr.f9440b) && q.a(this.f9443e, zzr.f9443e) && q.a(this.f9444f, zzr.f9444f) && this.f9445g == zzr.f9445g && this.f9446h == zzr.f9446h && this.f9447i == zzr.f9447i;
        }
    }

    public final String toString() {
        return "PlayLoggerContext[" + "package=" + this.f9441c + ',' + "packageVersionCode=" + this.f9442d + ',' + "logSource=" + this.f9439a + ',' + "logSourceName=" + this.f9440b + ',' + "uploadAccount=" + this.f9443e + ',' + "loggingId=" + this.f9444f + ',' + "logAndroidId=" + this.f9445g + ',' + "isAnonymous=" + this.f9446h + ',' + "qosTier=" + this.f9447i + "]";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f9441c, false);
        b.b(parcel, 3, this.f9442d);
        b.b(parcel, 4, this.f9439a);
        b.a(parcel, 5, this.f9443e, false);
        b.a(parcel, 6, this.f9444f, false);
        b.a(parcel, 7, this.f9445g);
        b.a(parcel, 8, this.f9440b, false);
        b.a(parcel, 9, this.f9446h);
        b.b(parcel, 10, this.f9447i);
        b.b(parcel, a2);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9441c, Integer.valueOf(this.f9442d), Integer.valueOf(this.f9439a), this.f9440b, this.f9443e, this.f9444f, Boolean.valueOf(this.f9445g), Boolean.valueOf(this.f9446h), Integer.valueOf(this.f9447i)});
    }
}
