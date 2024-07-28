package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final zzg f38056b = new zzg(1);

    /* renamed from: c  reason: collision with root package name */
    private static final zzg f38057c = new zzg(2);

    /* renamed from: d  reason: collision with root package name */
    private static final zzg f38058d = new zzg(3);

    /* renamed from: a  reason: collision with root package name */
    public final int f38059a;

    public zzg(int i2) {
        this.f38059a = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f38059a);
        b.b(parcel, a2);
    }
}
