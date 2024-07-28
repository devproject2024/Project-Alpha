package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    static final List<ClientIdentity> f10401a = Collections.emptyList();

    /* renamed from: b  reason: collision with root package name */
    private LocationRequest f10402b;

    /* renamed from: c  reason: collision with root package name */
    private List<ClientIdentity> f10403c;

    /* renamed from: d  reason: collision with root package name */
    private String f10404d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10405e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10406f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10407g;

    /* renamed from: h  reason: collision with root package name */
    private String f10408h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10409i = true;

    zzbd(LocationRequest locationRequest, List<ClientIdentity> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f10402b = locationRequest;
        this.f10403c = list;
        this.f10404d = str;
        this.f10405e = z;
        this.f10406f = z2;
        this.f10407g = z3;
        this.f10408h = str2;
    }

    @Deprecated
    public static zzbd a(LocationRequest locationRequest) {
        return new zzbd(locationRequest, f10401a, (String) null, false, false, false, (String) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbd = (zzbd) obj;
        return q.a(this.f10402b, zzbd.f10402b) && q.a(this.f10403c, zzbd.f10403c) && q.a(this.f10404d, zzbd.f10404d) && this.f10405e == zzbd.f10405e && this.f10406f == zzbd.f10406f && this.f10407g == zzbd.f10407g && q.a(this.f10408h, zzbd.f10408h);
    }

    public final int hashCode() {
        return this.f10402b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10402b);
        if (this.f10404d != null) {
            sb.append(" tag=");
            sb.append(this.f10404d);
        }
        if (this.f10408h != null) {
            sb.append(" moduleId=");
            sb.append(this.f10408h);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f10405e);
        sb.append(" clients=");
        sb.append(this.f10403c);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f10406f);
        if (this.f10407g) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10402b, i2, false);
        b.a(parcel, 5, this.f10403c, false);
        b.a(parcel, 6, this.f10404d, false);
        b.a(parcel, 7, this.f10405e);
        b.a(parcel, 8, this.f10406f);
        b.a(parcel, 9, this.f10407g);
        b.a(parcel, 10, this.f10408h, false);
        b.b(parcel, a2);
    }
}
