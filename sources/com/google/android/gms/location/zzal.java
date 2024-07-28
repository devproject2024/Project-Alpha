package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.List;

public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f11489a;

    /* renamed from: b  reason: collision with root package name */
    private final PendingIntent f11490b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11491c;

    zzal(List<String> list, PendingIntent pendingIntent, String str) {
        this.f11489a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f11490b = pendingIntent;
        this.f11491c = str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11489a);
        b.a(parcel, 2, this.f11490b, i2, false);
        b.a(parcel, 3, this.f11491c, false);
        b.b(parcel, a2);
    }
}
