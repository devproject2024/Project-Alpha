package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    private final List<LocationRequest> f11351a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11352b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11353c;

    /* renamed from: d  reason: collision with root package name */
    private zzae f11354d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11355a = false;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<LocationRequest> f11356b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f11357c = false;

        /* renamed from: d  reason: collision with root package name */
        private zzae f11358d = null;

        public final a a() {
            this.f11355a = true;
            return this;
        }

        public final a a(LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f11356b.add(locationRequest);
            }
            return this;
        }

        public final LocationSettingsRequest b() {
            return new LocationSettingsRequest(this.f11356b, this.f11355a, this.f11357c, (zzae) null);
        }
    }

    LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, zzae zzae) {
        this.f11351a = list;
        this.f11352b = z;
        this.f11353c = z2;
        this.f11354d = zzae;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, Collections.unmodifiableList(this.f11351a), false);
        b.a(parcel, 2, this.f11352b);
        b.a(parcel, 3, this.f11353c);
        b.a(parcel, 5, this.f11354d, i2, false);
        b.b(parcel, a2);
    }
}
