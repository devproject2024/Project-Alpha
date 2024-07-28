package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.places.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class PlaceEntity extends AbstractSafeParcelable implements ReflectedParcelable, b {
    public static final Parcelable.Creator<PlaceEntity> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final String f11428a;

    /* renamed from: b  reason: collision with root package name */
    private final LatLng f11429b;

    /* renamed from: c  reason: collision with root package name */
    private final float f11430c;

    /* renamed from: d  reason: collision with root package name */
    private final LatLngBounds f11431d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11432e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f11433f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11434g;

    /* renamed from: h  reason: collision with root package name */
    private final float f11435h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11436i;
    private final List<Integer> j;
    private final String k;
    private final String l;
    private final String m;
    private final List<String> n;
    private final zzal o;
    private final zzai p;
    private final String q;
    private Locale r;

    PlaceEntity(String str, List<Integer> list, String str2, String str3, String str4, List<String> list2, LatLng latLng, float f2, LatLngBounds latLngBounds, String str5, Uri uri, boolean z, float f3, int i2, zzal zzal, zzai zzai, String str6) {
        List<String> list3;
        this.f11428a = str;
        this.j = Collections.unmodifiableList(list);
        this.k = str2;
        this.l = str3;
        this.m = str4;
        if (list2 != null) {
            list3 = list2;
        } else {
            list3 = Collections.emptyList();
        }
        this.n = list3;
        this.f11429b = latLng;
        this.f11430c = f2;
        this.f11431d = latLngBounds;
        this.f11432e = str5 != null ? str5 : "UTC";
        this.f11433f = uri;
        this.f11434g = z;
        this.f11435h = f3;
        this.f11436i = i2;
        this.r = null;
        this.o = zzal;
        this.p = zzai;
        this.q = str6;
    }

    public final String toString() {
        return q.a((Object) this).a("id", this.f11428a).a("placeTypes", this.j).a(ContactsConstant.LOCALE, this.r).a("name", this.k).a(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, this.l).a("phoneNumber", this.m).a("latlng", this.f11429b).a("viewport", this.f11431d).a("websiteUri", this.f11433f).a("isPermanentlyClosed", Boolean.valueOf(this.f11434g)).a("priceLevel", Integer.valueOf(this.f11436i)).toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11428a, this.r});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceEntity)) {
            return false;
        }
        PlaceEntity placeEntity = (PlaceEntity) obj;
        return this.f11428a.equals(placeEntity.f11428a) && q.a(this.r, placeEntity.r);
    }

    public final /* synthetic */ CharSequence a() {
        return this.k;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f11428a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f11429b, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f11430c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f11431d, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f11432e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.f11433f, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.f11434g);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, this.f11435h);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 11, this.f11436i);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 14, this.l, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 15, this.m, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 17, this.n);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 19, this.k, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20, this.j);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 21, this.o, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 22, this.p, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 23, this.q, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
