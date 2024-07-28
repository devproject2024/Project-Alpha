package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final int f8147a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialPickerConfig f8148b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8149c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8150d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f8151e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8152f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8153g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8154h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f8155a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8156b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f8157c;

        /* renamed from: d  reason: collision with root package name */
        CredentialPickerConfig f8158d = new CredentialPickerConfig.a().a();

        /* renamed from: e  reason: collision with root package name */
        boolean f8159e = false;

        /* renamed from: f  reason: collision with root package name */
        String f8160f;

        /* renamed from: g  reason: collision with root package name */
        String f8161g;
    }

    HintRequest(int i2, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.f8147a = i2;
        this.f8148b = (CredentialPickerConfig) s.a(credentialPickerConfig);
        this.f8149c = z;
        this.f8150d = z2;
        this.f8151e = (String[]) s.a(strArr);
        if (this.f8147a < 2) {
            this.f8152f = true;
            this.f8153g = null;
            this.f8154h = null;
            return;
        }
        this.f8152f = z3;
        this.f8153g = str;
        this.f8154h = str2;
    }

    public /* synthetic */ HintRequest(a aVar, byte b2) {
        this(aVar);
    }

    private HintRequest(a aVar) {
        this(2, aVar.f8158d, aVar.f8155a, aVar.f8156b, aVar.f8157c, aVar.f8159e, aVar.f8160f, aVar.f8161g);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8148b, i2, false);
        b.a(parcel, 2, this.f8149c);
        b.a(parcel, 3, this.f8150d);
        b.a(parcel, 4, this.f8151e);
        b.a(parcel, 5, this.f8152f);
        b.a(parcel, 6, this.f8153g, false);
        b.a(parcel, 7, this.f8154h, false);
        b.b(parcel, 1000, this.f8147a);
        b.b(parcel, a2);
    }
}
