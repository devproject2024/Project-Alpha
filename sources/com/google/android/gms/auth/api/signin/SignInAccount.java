package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    public GoogleSignInAccount f8229a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private String f8230b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f8231c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f8229a = googleSignInAccount;
        this.f8230b = s.a(str, (Object) "8.3 and 8.4 SDKs require non-null email");
        this.f8231c = s.a(str2, (Object) "8.3 and 8.4 SDKs require non-null userId");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 4, this.f8230b, false);
        b.a(parcel, 7, this.f8229a, i2, false);
        b.a(parcel, 8, this.f8231c, false);
        b.b(parcel, a2);
    }
}
