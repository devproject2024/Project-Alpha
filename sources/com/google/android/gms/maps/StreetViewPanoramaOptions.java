package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.a.j;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private StreetViewPanoramaCamera f11515a;

    /* renamed from: b  reason: collision with root package name */
    private String f11516b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f11517c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f11518d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f11519e = Boolean.TRUE;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f11520f = Boolean.TRUE;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f11521g = Boolean.TRUE;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f11522h = Boolean.TRUE;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f11523i;
    private StreetViewSource j = StreetViewSource.f11645a;

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b2, byte b3, byte b4, byte b5, byte b6, StreetViewSource streetViewSource) {
        this.f11515a = streetViewPanoramaCamera;
        this.f11517c = latLng;
        this.f11518d = num;
        this.f11516b = str;
        this.f11519e = j.a(b2);
        this.f11520f = j.a(b3);
        this.f11521g = j.a(b4);
        this.f11522h = j.a(b5);
        this.f11523i = j.a(b6);
        this.j = streetViewSource;
    }

    public StreetViewPanoramaOptions() {
    }

    public final String toString() {
        return q.a((Object) this).a("PanoramaId", this.f11516b).a("Position", this.f11517c).a("Radius", this.f11518d).a("Source", this.j).a("StreetViewPanoramaCamera", this.f11515a).a("UserNavigationEnabled", this.f11519e).a("ZoomGesturesEnabled", this.f11520f).a("PanningGesturesEnabled", this.f11521g).a("StreetNamesEnabled", this.f11522h).a("UseViewLifecycleInFragment", this.f11523i).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f11515a, i2, false);
        b.a(parcel, 3, this.f11516b, false);
        b.a(parcel, 4, this.f11517c, i2, false);
        b.a(parcel, 5, this.f11518d);
        b.a(parcel, 6, j.a(this.f11519e));
        b.a(parcel, 7, j.a(this.f11520f));
        b.a(parcel, 8, j.a(this.f11521g));
        b.a(parcel, 9, j.a(this.f11522h));
        b.a(parcel, 10, j.a(this.f11523i));
        b.a(parcel, 11, this.j, i2, false);
        b.b(parcel, a2);
    }
}
