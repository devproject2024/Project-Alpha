package com.google.android.gms.location.places.internal;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.Arrays;
import java.util.Locale;

public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private static final zzau f11458a = new zzau("com.google.android.gms", Locale.getDefault());

    /* renamed from: b  reason: collision with root package name */
    private final String f11459b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11460c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11461d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11462e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11463f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11464g;

    public zzau(String str, String str2, String str3, String str4, int i2, int i3) {
        this.f11459b = str;
        this.f11460c = str2;
        this.f11461d = str3;
        this.f11462e = str4;
        this.f11463f = i2;
        this.f11464g = i3;
    }

    private zzau(String str, Locale locale) {
        this(str, a(locale), (String) null, (String) null, c.f8646a, 0);
    }

    public zzau(String str, Locale locale, String str2) {
        this(str, a(locale), str2, (String) null, c.f8646a, 0);
    }

    public final String toString() {
        return q.a((Object) this).a("clientPackageName", this.f11459b).a(ContactsConstant.LOCALE, this.f11460c).a("accountName", this.f11461d).a("gCoreClientName", this.f11462e).toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11459b, this.f11460c, this.f11461d, this.f11462e, Integer.valueOf(this.f11463f), Integer.valueOf(this.f11464g)});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzau)) {
            zzau zzau = (zzau) obj;
            return this.f11463f == zzau.f11463f && this.f11464g == zzau.f11464g && this.f11460c.equals(zzau.f11460c) && this.f11459b.equals(zzau.f11459b) && q.a(this.f11461d, zzau.f11461d) && q.a(this.f11462e, zzau.f11462e);
        }
    }

    private static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        String language = locale.getLanguage();
        String str = "";
        if (language == null) {
            language = str;
        }
        String country = locale.getCountry();
        if (country == null) {
            country = str;
        }
        String valueOf = String.valueOf(language);
        if (country.length() > 0) {
            String valueOf2 = String.valueOf(country);
            str = valueOf2.length() != 0 ? "-".concat(valueOf2) : new String("-");
        }
        String valueOf3 = String.valueOf(str);
        return valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11459b, false);
        b.a(parcel, 2, this.f11460c, false);
        b.a(parcel, 3, this.f11461d, false);
        b.a(parcel, 4, this.f11462e, false);
        b.b(parcel, 6, this.f11463f);
        b.b(parcel, 7, this.f11464g);
        b.b(parcel, a2);
    }
}
