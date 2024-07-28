package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    public final ConnectionResult f12452a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveAccountResponse f12453b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12454c;

    zak(int i2, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f12454c = i2;
        this.f12452a = connectionResult;
        this.f12453b = resolveAccountResponse;
    }

    public zak() {
        this(new ConnectionResult(8, (PendingIntent) null));
    }

    private zak(ConnectionResult connectionResult) {
        this(1, connectionResult, (ResolveAccountResponse) null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f12454c);
        b.a(parcel, 2, this.f12452a, i2, false);
        b.a(parcel, 3, this.f12453b, i2, false);
        b.b(parcel, a2);
    }
}
