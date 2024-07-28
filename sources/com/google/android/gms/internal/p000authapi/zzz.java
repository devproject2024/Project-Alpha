package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

/* renamed from: com.google.android.gms.internal.auth-api.zzz  reason: invalid package */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private final Credential f9072a;

    public zzz(Credential credential) {
        this.f9072a = credential;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f9072a, i2, false);
        b.b(parcel, a2);
    }
}
