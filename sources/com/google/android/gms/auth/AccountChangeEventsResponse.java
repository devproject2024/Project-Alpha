package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f8061a;

    /* renamed from: b  reason: collision with root package name */
    private final List<AccountChangeEvent> f8062b;

    AccountChangeEventsResponse(int i2, List<AccountChangeEvent> list) {
        this.f8061a = i2;
        this.f8062b = (List) s.a(list);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8061a);
        b.a(parcel, 2, this.f8062b, false);
        b.b(parcel, a2);
    }
}
