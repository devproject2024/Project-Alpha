package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final PasswordRequestOptions f8165a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleIdTokenRequestOptions f8166b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8167c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8168d;

    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f8169a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8170b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8171c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f8172d;

        /* renamed from: e  reason: collision with root package name */
        private final String f8173e;

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f8174f;

        GoogleIdTokenRequestOptions(boolean z, String str, String str2, boolean z2, String str3, List<String> list) {
            this.f8169a = z;
            if (z) {
                s.a(str, (Object) "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f8170b = str;
            this.f8171c = str2;
            this.f8172d = z2;
            this.f8174f = BeginSignInRequest.a(list);
            this.f8173e = str3;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f8169a), this.f8170b, this.f8171c, Boolean.valueOf(this.f8172d), this.f8173e, this.f8174f});
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            if (this.f8169a != googleIdTokenRequestOptions.f8169a || !q.a(this.f8170b, googleIdTokenRequestOptions.f8170b) || !q.a(this.f8171c, googleIdTokenRequestOptions.f8171c) || this.f8172d != googleIdTokenRequestOptions.f8172d || !q.a(this.f8173e, googleIdTokenRequestOptions.f8173e) || !q.a(this.f8174f, googleIdTokenRequestOptions.f8174f)) {
                return false;
            }
            return true;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 1, this.f8169a);
            b.a(parcel, 2, this.f8170b, false);
            b.a(parcel, 3, this.f8171c, false);
            b.a(parcel, 4, this.f8172d);
            b.a(parcel, 5, this.f8173e, false);
            b.b(parcel, 6, this.f8174f);
            b.b(parcel, a2);
        }
    }

    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new d();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f8175a;

        PasswordRequestOptions(boolean z) {
            this.f8175a = z;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f8175a)});
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof PasswordRequestOptions) && this.f8175a == ((PasswordRequestOptions) obj).f8175a) {
                return true;
            }
            return false;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 1, this.f8175a);
            b.b(parcel, a2);
        }
    }

    BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z) {
        this.f8165a = (PasswordRequestOptions) s.a(passwordRequestOptions);
        this.f8166b = (GoogleIdTokenRequestOptions) s.a(googleIdTokenRequestOptions);
        this.f8167c = str;
        this.f8168d = z;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8165a, this.f8166b, this.f8167c, Boolean.valueOf(this.f8168d)});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        if (!q.a(this.f8165a, beginSignInRequest.f8165a) || !q.a(this.f8166b, beginSignInRequest.f8166b) || !q.a(this.f8167c, beginSignInRequest.f8167c) || this.f8168d != beginSignInRequest.f8168d) {
            return false;
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8165a, i2, false);
        b.a(parcel, 2, this.f8166b, i2, false);
        b.a(parcel, 3, this.f8167c, false);
        b.a(parcel, 4, this.f8168d);
        b.b(parcel, a2);
    }

    static /* synthetic */ List a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        return arrayList;
    }
}
