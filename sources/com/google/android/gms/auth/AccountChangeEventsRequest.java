package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f8057a;

    /* renamed from: b  reason: collision with root package name */
    private int f8058b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f8059c;

    /* renamed from: d  reason: collision with root package name */
    private Account f8060d;

    AccountChangeEventsRequest(int i2, int i3, String str, Account account) {
        this.f8057a = i2;
        this.f8058b = i3;
        this.f8059c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f8060d = account;
        } else {
            this.f8060d = new Account(str, "com.google");
        }
    }

    public AccountChangeEventsRequest() {
        this.f8057a = 1;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8057a);
        b.b(parcel, 2, this.f8058b);
        b.a(parcel, 3, this.f8059c, false);
        b.a(parcel, 4, this.f8060d, i2, false);
        b.b(parcel, a2);
    }
}
