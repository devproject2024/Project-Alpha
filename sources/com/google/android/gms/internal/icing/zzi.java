package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new fk();

    /* renamed from: a  reason: collision with root package name */
    private final String f10301a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10302b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10303c;

    public zzi(String str, String str2, String str3) {
        this.f10301a = str;
        this.f10302b = str2;
        this.f10303c = str3;
    }

    public final String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.f10301a, this.f10302b, this.f10303c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10301a, false);
        b.a(parcel, 2, this.f10302b, false);
        b.a(parcel, 3, this.f10303c, false);
        b.b(parcel, a2);
    }
}
