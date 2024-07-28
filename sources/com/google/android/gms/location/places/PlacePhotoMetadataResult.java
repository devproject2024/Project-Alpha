package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

@Deprecated
public class PlacePhotoMetadataResult extends AbstractSafeParcelable implements l {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final Status f11397a;

    /* renamed from: b  reason: collision with root package name */
    private final DataHolder f11398b;

    /* renamed from: c  reason: collision with root package name */
    private final d f11399c;

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this.f11397a = status;
        this.f11398b = dataHolder;
        if (dataHolder == null) {
            this.f11399c = null;
        } else {
            this.f11399c = new d(this.f11398b);
        }
    }

    public final Status a() {
        return this.f11397a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11397a, i2, false);
        b.a(parcel, 2, this.f11398b, i2, false);
        b.b(parcel, a2);
    }
}
