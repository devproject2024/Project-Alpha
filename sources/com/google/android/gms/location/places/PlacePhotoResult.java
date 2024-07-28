package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

@Deprecated
public class PlacePhotoResult extends AbstractSafeParcelable implements l {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private final Status f11400a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapTeleporter f11401b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f11402c;

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapTeleporter) {
        this.f11400a = status;
        this.f11401b = bitmapTeleporter;
        if (this.f11401b != null) {
            this.f11402c = bitmapTeleporter.a();
        } else {
            this.f11402c = null;
        }
    }

    public final Status a() {
        return this.f11400a;
    }

    public String toString() {
        return q.a((Object) this).a("status", this.f11400a).a("bitmap", this.f11402c).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11400a, i2, false);
        b.a(parcel, 2, this.f11401b, i2, false);
        b.b(parcel, a2);
    }
}
