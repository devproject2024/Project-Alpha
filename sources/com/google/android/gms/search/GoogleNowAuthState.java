package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class GoogleNowAuthState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f12426a;

    /* renamed from: b  reason: collision with root package name */
    private String f12427b;

    /* renamed from: c  reason: collision with root package name */
    private long f12428c;

    GoogleNowAuthState(String str, String str2, long j) {
        this.f12426a = str;
        this.f12427b = str2;
        this.f12428c = j;
    }

    public String toString() {
        String str = this.f12426a;
        String str2 = this.f12427b;
        long j = this.f12428c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74 + String.valueOf(str2).length());
        sb.append("mAuthCode = ");
        sb.append(str);
        sb.append("\nmAccessToken = ");
        sb.append(str2);
        sb.append("\nmNextAllowedTimeMillis = ");
        sb.append(j);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f12426a, false);
        b.a(parcel, 2, this.f12427b, false);
        b.a(parcel, 3, this.f12428c);
        b.b(parcel, a2);
    }
}
