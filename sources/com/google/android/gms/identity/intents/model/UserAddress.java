package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class UserAddress extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private String f9052a;

    /* renamed from: b  reason: collision with root package name */
    private String f9053b;

    /* renamed from: c  reason: collision with root package name */
    private String f9054c;

    /* renamed from: d  reason: collision with root package name */
    private String f9055d;

    /* renamed from: e  reason: collision with root package name */
    private String f9056e;

    /* renamed from: f  reason: collision with root package name */
    private String f9057f;

    /* renamed from: g  reason: collision with root package name */
    private String f9058g;

    /* renamed from: h  reason: collision with root package name */
    private String f9059h;

    /* renamed from: i  reason: collision with root package name */
    private String f9060i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private String n;
    private String o;

    UserAddress() {
    }

    UserAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.f9052a = str;
        this.f9053b = str2;
        this.f9054c = str3;
        this.f9055d = str4;
        this.f9056e = str5;
        this.f9057f = str6;
        this.f9058g = str7;
        this.f9059h = str8;
        this.f9060i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = z;
        this.n = str13;
        this.o = str14;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f9052a, false);
        b.a(parcel, 3, this.f9053b, false);
        b.a(parcel, 4, this.f9054c, false);
        b.a(parcel, 5, this.f9055d, false);
        b.a(parcel, 6, this.f9056e, false);
        b.a(parcel, 7, this.f9057f, false);
        b.a(parcel, 8, this.f9058g, false);
        b.a(parcel, 9, this.f9059h, false);
        b.a(parcel, 10, this.f9060i, false);
        b.a(parcel, 11, this.j, false);
        b.a(parcel, 12, this.k, false);
        b.a(parcel, 13, this.l, false);
        b.a(parcel, 14, this.m);
        b.a(parcel, 15, this.n, false);
        b.a(parcel, 16, this.o, false);
        b.b(parcel, a2);
    }
}
