package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    private final int f38060a;

    /* renamed from: b  reason: collision with root package name */
    private final Thing[] f38061b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f38062c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f38063d;

    /* renamed from: e  reason: collision with root package name */
    private final zza f38064e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38065f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38066g;

    zzy(int i2, Thing[] thingArr, String[] strArr, String[] strArr2, zza zza, String str, String str2) {
        if (!(i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 6 || i2 == 7)) {
            i2 = 0;
        }
        this.f38060a = i2;
        this.f38061b = thingArr;
        this.f38062c = strArr;
        this.f38063d = strArr2;
        this.f38064e = zza;
        this.f38065f = str;
        this.f38066g = str2;
    }

    zzy(Thing[] thingArr) {
        this(1, thingArr, (String[]) null, (String[]) null, (zza) null, (String) null, (String) null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f38060a);
        b.a(parcel, 2, (T[]) this.f38061b, i2);
        b.a(parcel, 3, this.f38062c);
        b.a(parcel, 5, this.f38063d);
        b.a(parcel, 6, this.f38064e, i2, false);
        b.a(parcel, 7, this.f38065f, false);
        b.a(parcel, 8, this.f38066g, false);
        b.b(parcel, a2);
    }
}
