package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new am();

    /* renamed from: a  reason: collision with root package name */
    String f8739a;

    /* renamed from: b  reason: collision with root package name */
    IBinder f8740b;

    /* renamed from: c  reason: collision with root package name */
    Scope[] f8741c;

    /* renamed from: d  reason: collision with root package name */
    Bundle f8742d;

    /* renamed from: e  reason: collision with root package name */
    Account f8743e;

    /* renamed from: f  reason: collision with root package name */
    Feature[] f8744f;

    /* renamed from: g  reason: collision with root package name */
    Feature[] f8745g;

    /* renamed from: h  reason: collision with root package name */
    private final int f8746h;

    /* renamed from: i  reason: collision with root package name */
    private final int f8747i;
    private int j;
    private boolean k;
    private int l;

    public GetServiceRequest(int i2) {
        this.f8746h = 4;
        this.j = d.f8658b;
        this.f8747i = i2;
        this.k = true;
    }

    GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i5) {
        this.f8746h = i2;
        this.f8747i = i3;
        this.j = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f8739a = "com.google.android.gms";
        } else {
            this.f8739a = str;
        }
        if (i2 < 2) {
            this.f8743e = iBinder != null ? a.a(l.a.a(iBinder)) : null;
        } else {
            this.f8740b = iBinder;
            this.f8743e = account;
        }
        this.f8741c = scopeArr;
        this.f8742d = bundle;
        this.f8744f = featureArr;
        this.f8745g = featureArr2;
        this.k = z;
        this.l = i5;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8746h);
        b.b(parcel, 2, this.f8747i);
        b.b(parcel, 3, this.j);
        b.a(parcel, 4, this.f8739a, false);
        b.a(parcel, 5, this.f8740b);
        b.a(parcel, 6, (T[]) this.f8741c, i2);
        b.a(parcel, 7, this.f8742d);
        b.a(parcel, 8, this.f8743e, i2, false);
        b.a(parcel, 10, (T[]) this.f8744f, i2);
        b.a(parcel, 11, (T[]) this.f8745g, i2);
        b.a(parcel, 12, this.k);
        b.b(parcel, 13, this.l);
        b.b(parcel, a2);
    }
}
