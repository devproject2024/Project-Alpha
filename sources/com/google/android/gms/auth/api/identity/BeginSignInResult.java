package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class BeginSignInResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInResult> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f8176a;

    public BeginSignInResult(PendingIntent pendingIntent) {
        this.f8176a = (PendingIntent) s.a(pendingIntent);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8176a, i2, false);
        b.b(parcel, a2);
    }
}
