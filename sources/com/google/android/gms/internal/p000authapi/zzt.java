package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

/* renamed from: com.google.android.gms.internal.auth-api.zzt  reason: invalid package */
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzt> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final Credential f9071a;

    public zzt(Credential credential) {
        this.f9071a = credential;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f9071a, i2, false);
        b.b(parcel, a2);
    }
}
