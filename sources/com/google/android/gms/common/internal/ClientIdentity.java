package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final int f8733a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8734b;

    public ClientIdentity(int i2, String str) {
        this.f8733a = i2;
        this.f8734b = str;
    }

    public int hashCode() {
        return this.f8733a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            return clientIdentity.f8733a == this.f8733a && q.a(clientIdentity.f8734b, this.f8734b);
        }
    }

    public String toString() {
        int i2 = this.f8733a;
        String str = this.f8734b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i2);
        sb.append(AppConstants.COLON);
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8733a);
        b.a(parcel, 2, this.f8734b, false);
        b.b(parcel, a2);
    }
}
