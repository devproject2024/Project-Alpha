package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final int f8726a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f8727b;

    /* renamed from: c  reason: collision with root package name */
    private final Scope[] f8728c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f8729d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f8730e;

    /* renamed from: f  reason: collision with root package name */
    private Account f8731f;

    AuthAccountRequest(int i2, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.f8726a = i2;
        this.f8727b = iBinder;
        this.f8728c = scopeArr;
        this.f8729d = num;
        this.f8730e = num2;
        this.f8731f = account;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8726a);
        b.a(parcel, 2, this.f8727b);
        b.a(parcel, 3, (T[]) this.f8728c, i2);
        b.a(parcel, 4, this.f8729d);
        b.a(parcel, 5, this.f8730e);
        b.a(parcel, 6, this.f8731f, i2, false);
        b.b(parcel, a2);
    }
}
