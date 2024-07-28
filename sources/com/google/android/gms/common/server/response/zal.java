package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final String f8924a;

    /* renamed from: b  reason: collision with root package name */
    final FastJsonResponse.Field<?, ?> f8925b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8926c;

    zal(int i2, String str, FastJsonResponse.Field<?, ?> field) {
        this.f8926c = i2;
        this.f8924a = str;
        this.f8925b = field;
    }

    zal(String str, FastJsonResponse.Field<?, ?> field) {
        this.f8926c = 1;
        this.f8924a = str;
        this.f8925b = field;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8926c);
        b.a(parcel, 2, this.f8924a, false);
        b.a(parcel, 3, this.f8925b, i2, false);
        b.b(parcel, a2);
    }
}
