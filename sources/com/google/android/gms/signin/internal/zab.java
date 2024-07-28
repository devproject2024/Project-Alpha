package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zab extends AbstractSafeParcelable implements l {
    public static final Parcelable.Creator<zab> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f12447a;

    /* renamed from: b  reason: collision with root package name */
    private int f12448b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f12449c;

    zab(int i2, int i3, Intent intent) {
        this.f12447a = i2;
        this.f12448b = i3;
        this.f12449c = intent;
    }

    public zab() {
        this((byte) 0);
    }

    private zab(byte b2) {
        this(2, 0, (Intent) null);
    }

    public final Status a() {
        if (this.f12448b == 0) {
            return Status.f8354a;
        }
        return Status.f8358e;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f12447a);
        b.b(parcel, 2, this.f12448b);
        b.a(parcel, 3, this.f12449c, i2, false);
        b.b(parcel, a2);
    }
}
