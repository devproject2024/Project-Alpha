package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final int f12450a;

    /* renamed from: b  reason: collision with root package name */
    private final ResolveAccountRequest f12451b;

    zai(int i2, ResolveAccountRequest resolveAccountRequest) {
        this.f12450a = i2;
        this.f12451b = resolveAccountRequest;
    }

    public zai(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f12450a);
        b.a(parcel, 2, this.f12451b, i2, false);
        b.b(parcel, a2);
    }
}
