package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public int f8242a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8243b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f8244c;

    GoogleSignInOptionsExtensionParcelable(int i2, int i3, Bundle bundle) {
        this.f8243b = i2;
        this.f8242a = i3;
        this.f8244c = bundle;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8243b);
        b.b(parcel, 2, this.f8242a);
        b.a(parcel, 3, this.f8244c);
        b.b(parcel, a2);
    }
}
