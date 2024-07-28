package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final int f11403a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11404b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11405c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11406d;

    PlaceReport(int i2, String str, String str2, String str3) {
        this.f11403a = i2;
        this.f11404b = str;
        this.f11405c = str2;
        this.f11406d = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return q.a(this.f11404b, placeReport.f11404b) && q.a(this.f11405c, placeReport.f11405c) && q.a(this.f11406d, placeReport.f11406d);
    }

    public String toString() {
        q.a a2 = q.a((Object) this);
        a2.a("placeId", this.f11404b);
        a2.a("tag", this.f11405c);
        if (!SDKConstants.UNKNOWN.equals(this.f11406d)) {
            a2.a("source", this.f11406d);
        }
        return a2.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11404b, this.f11405c, this.f11406d});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11403a);
        b.a(parcel, 2, this.f11404b, false);
        b.a(parcel, 3, this.f11405c, false);
        b.a(parcel, 4, this.f11406d, false);
        b.b(parcel, a2);
    }
}
