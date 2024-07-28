package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.List;

public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final List<zzao> f11447a;

    /* renamed from: b  reason: collision with root package name */
    private final List<zzan> f11448b;

    zzal(List<zzao> list, List<zzan> list2) {
        this.f11447a = Collections.unmodifiableList(list);
        this.f11448b = Collections.unmodifiableList(list2);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11447a, false);
        b.a(parcel, 2, this.f11448b, false);
        b.b(parcel, a2);
    }
}
