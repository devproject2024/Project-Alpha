package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final String f8177a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8178b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8179c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8180d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f8181e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8182f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8183g;

    public SignInCredential(String str, String str2, String str3, String str4, Uri uri, String str5, String str6) {
        this.f8177a = s.a(str);
        this.f8178b = str2;
        this.f8179c = str3;
        this.f8180d = str4;
        this.f8181e = uri;
        this.f8182f = str5;
        this.f8183g = str6;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8177a, this.f8178b, this.f8179c, this.f8180d, this.f8181e, this.f8182f, this.f8183g});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        if (!q.a(this.f8177a, signInCredential.f8177a) || !q.a(this.f8178b, signInCredential.f8178b) || !q.a(this.f8179c, signInCredential.f8179c) || !q.a(this.f8180d, signInCredential.f8180d) || !q.a(this.f8181e, signInCredential.f8181e) || !q.a(this.f8182f, signInCredential.f8182f) || !q.a(this.f8183g, signInCredential.f8183g)) {
            return false;
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8177a, false);
        b.a(parcel, 2, this.f8178b, false);
        b.a(parcel, 3, this.f8179c, false);
        b.a(parcel, 4, this.f8180d, false);
        b.a(parcel, 5, this.f8181e, i2, false);
        b.a(parcel, 6, this.f8182f, false);
        b.a(parcel, 7, this.f8183g, false);
        b.b(parcel, a2);
    }
}
