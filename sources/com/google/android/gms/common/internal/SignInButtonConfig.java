package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new aj();

    /* renamed from: a  reason: collision with root package name */
    private final int f8757a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8758b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8759c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final Scope[] f8760d;

    SignInButtonConfig(int i2, int i3, int i4, Scope[] scopeArr) {
        this.f8757a = i2;
        this.f8758b = i3;
        this.f8759c = i4;
        this.f8760d = scopeArr;
    }

    public SignInButtonConfig(int i2, int i3) {
        this(1, i2, i3, (Scope[]) null);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8757a);
        b.b(parcel, 2, this.f8758b);
        b.b(parcel, 3, this.f8759c);
        b.a(parcel, 4, (T[]) this.f8760d, i2);
        b.b(parcel, a2);
    }
}
