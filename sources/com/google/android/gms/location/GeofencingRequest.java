package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.location.zzbh;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new ah();

    /* renamed from: a  reason: collision with root package name */
    private final List<zzbh> f11333a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11334b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11335c;

    GeofencingRequest(List<zzbh> list, int i2, String str) {
        this.f11333a = list;
        this.f11334b = i2;
        this.f11335c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeofencingRequest[");
        sb.append("geofences=");
        sb.append(this.f11333a);
        int i2 = this.f11334b;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(", initialTrigger=");
        sb2.append(i2);
        sb2.append(", ");
        sb.append(sb2.toString());
        String valueOf = String.valueOf(this.f11335c);
        sb.append(valueOf.length() != 0 ? "tag=".concat(valueOf) : new String("tag="));
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11333a, false);
        b.b(parcel, 2, this.f11334b);
        b.a(parcel, 3, this.f11335c, false);
        b.b(parcel, a2);
    }
}
