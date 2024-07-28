package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzad extends AbstractSafeParcelable implements l {
    public static final Parcelable.Creator<zzad> CREATOR = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final zzad f10399b = new zzad(Status.f8354a);

    /* renamed from: a  reason: collision with root package name */
    public final Status f10400a;

    public zzad(Status status) {
        this.f10400a = status;
    }

    public final Status a() {
        return this.f10400a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10400a, i2, false);
        b.b(parcel, a2);
    }
}
