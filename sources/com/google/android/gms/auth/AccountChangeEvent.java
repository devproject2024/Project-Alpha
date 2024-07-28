package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8051a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8052b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8053c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8054d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8055e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8056f;

    AccountChangeEvent(int i2, long j, String str, int i3, int i4, String str2) {
        this.f8051a = i2;
        this.f8052b = j;
        this.f8053c = (String) s.a(str);
        this.f8054d = i3;
        this.f8055e = i4;
        this.f8056f = str2;
    }

    public String toString() {
        int i2 = this.f8054d;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? H5Utils.NETWORK_TYPE_UNKNOWN : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.f8053c;
        String str3 = this.f8056f;
        int i3 = this.f8055e;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8051a), Long.valueOf(this.f8052b), this.f8053c, Integer.valueOf(this.f8054d), Integer.valueOf(this.f8055e), this.f8056f});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            return this.f8051a == accountChangeEvent.f8051a && this.f8052b == accountChangeEvent.f8052b && q.a(this.f8053c, accountChangeEvent.f8053c) && this.f8054d == accountChangeEvent.f8054d && this.f8055e == accountChangeEvent.f8055e && q.a(this.f8056f, accountChangeEvent.f8056f);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8051a);
        b.a(parcel, 2, this.f8052b);
        b.a(parcel, 3, this.f8053c, false);
        b.b(parcel, 4, this.f8054d);
        b.b(parcel, 5, this.f8055e);
        b.a(parcel, 6, this.f8056f, false);
        b.b(parcel, a2);
    }
}
