package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f9084a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9085b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f9086c;

    zzah(String str, PendingIntent pendingIntent) {
        this.f9085b = (String) s.a(str);
        this.f9086c = (PendingIntent) s.a(pendingIntent);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f9084a);
        b.a(parcel, 2, this.f9085b, false);
        b.a(parcel, 3, this.f9086c, i2, false);
        b.b(parcel, a2);
    }
}
