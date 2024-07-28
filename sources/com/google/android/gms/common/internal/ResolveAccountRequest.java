package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new ah();

    /* renamed from: a  reason: collision with root package name */
    private final int f8748a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f8749b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8750c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f8751d;

    ResolveAccountRequest(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f8748a = i2;
        this.f8749b = account;
        this.f8750c = i3;
        this.f8751d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8748a);
        b.a(parcel, 2, this.f8749b, i2, false);
        b.b(parcel, 3, this.f8750c);
        b.a(parcel, 4, this.f8751d, i2, false);
        b.b(parcel, a2);
    }
}
