package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new ai();

    /* renamed from: a  reason: collision with root package name */
    public IBinder f8752a;

    /* renamed from: b  reason: collision with root package name */
    public ConnectionResult f8753b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8754c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8755d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8756e;

    ResolveAccountResponse(int i2, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f8756e = i2;
        this.f8752a = iBinder;
        this.f8753b = connectionResult;
        this.f8754c = z;
        this.f8755d = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f8753b.equals(resolveAccountResponse.f8753b) && l.a.a(this.f8752a).equals(l.a.a(resolveAccountResponse.f8752a));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8756e);
        b.a(parcel, 2, this.f8752a);
        b.a(parcel, 3, this.f8753b, i2, false);
        b.a(parcel, 4, this.f8754c);
        b.a(parcel, 5, this.f8755d);
        b.b(parcel, a2);
    }
}
