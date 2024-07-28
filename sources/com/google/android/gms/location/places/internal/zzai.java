package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.List;

public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final List<Integer> f11440a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11441b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f11442c;

    /* renamed from: d  reason: collision with root package name */
    private final float f11443d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11444e;

    zzai(List<Integer> list, String str, Uri uri, float f2, int i2) {
        this.f11440a = Collections.unmodifiableList(list);
        this.f11441b = str;
        this.f11442c = uri;
        this.f11443d = f2;
        this.f11444e = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11440a);
        b.a(parcel, 2, this.f11441b, false);
        b.a(parcel, 3, this.f11442c, i2, false);
        b.a(parcel, 4, this.f11443d);
        b.b(parcel, 5, this.f11444e);
        b.b(parcel, a2);
    }
}
