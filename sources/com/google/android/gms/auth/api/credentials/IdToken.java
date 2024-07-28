package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final String f8162a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8163b;

    public IdToken(String str, String str2) {
        s.b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        s.b(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f8162a = str;
        this.f8163b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return q.a(this.f8162a, idToken.f8162a) && q.a(this.f8163b, idToken.f8163b);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8162a, false);
        b.a(parcel, 2, this.f8163b, false);
        b.b(parcel, a2);
    }
}
