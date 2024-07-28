package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    GoogleSignInOptions f8245a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8246b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f8246b = s.a(str);
        this.f8245a = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f8246b.equals(signInConfiguration.f8246b)) {
            GoogleSignInOptions googleSignInOptions = this.f8245a;
            if (googleSignInOptions == null) {
                if (signInConfiguration.f8245a == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.f8245a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new a().a((Object) this.f8246b).a((Object) this.f8245a).f8255a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f8246b, false);
        b.a(parcel, 5, this.f8245a, i2, false);
        b.b(parcel, a2);
    }
}
