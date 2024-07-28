package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Deprecated
public class AddPlaceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final String f11378a;

    /* renamed from: b  reason: collision with root package name */
    private final LatLng f11379b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11380c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Integer> f11381d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11382e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f11383f;

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this.f11378a = s.a(str);
        this.f11379b = (LatLng) s.a(latLng);
        this.f11380c = s.a(str2);
        this.f11381d = new ArrayList((Collection) s.a(list));
        boolean z = true;
        s.b(!this.f11381d.isEmpty(), "At least one place type should be provided.");
        if (TextUtils.isEmpty(str3) && uri == null) {
            z = false;
        }
        s.b(z, "One of phone number or URI should be provided.");
        this.f11382e = str3;
        this.f11383f = uri;
    }

    public String toString() {
        return q.a((Object) this).a("name", this.f11378a).a("latLng", this.f11379b).a(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, this.f11380c).a("placeTypes", this.f11381d).a("phoneNumer", this.f11382e).a("websiteUri", this.f11383f).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11378a, false);
        b.a(parcel, 2, this.f11379b, i2, false);
        b.a(parcel, 3, this.f11380c, false);
        b.a(parcel, 4, this.f11381d);
        b.a(parcel, 5, this.f11382e, false);
        b.a(parcel, 6, this.f11383f, i2, false);
        b.b(parcel, a2);
    }
}
