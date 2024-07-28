package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final int f8138a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8139b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f8140c;

    /* renamed from: d  reason: collision with root package name */
    private final CredentialPickerConfig f8141d;

    /* renamed from: e  reason: collision with root package name */
    private final CredentialPickerConfig f8142e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8143f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8144g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8145h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f8146i;

    CredentialRequest(int i2, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.f8138a = i2;
        this.f8139b = z;
        this.f8140c = (String[]) s.a(strArr);
        this.f8141d = credentialPickerConfig == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig;
        this.f8142e = credentialPickerConfig2 == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig2;
        if (i2 < 3) {
            this.f8143f = true;
            this.f8144g = null;
            this.f8145h = null;
        } else {
            this.f8143f = z2;
            this.f8144g = str;
            this.f8145h = str2;
        }
        this.f8146i = z3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8139b);
        b.a(parcel, 2, this.f8140c);
        b.a(parcel, 3, this.f8141d, i2, false);
        b.a(parcel, 4, this.f8142e, i2, false);
        b.a(parcel, 5, this.f8143f);
        b.a(parcel, 6, this.f8144g, false);
        b.a(parcel, 7, this.f8145h, false);
        b.a(parcel, 8, this.f8146i);
        b.b(parcel, 1000, this.f8138a);
        b.b(parcel, a2);
    }
}
