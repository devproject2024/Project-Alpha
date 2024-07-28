package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    public final String f8338a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f8339b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8340c;

    public Feature(String str, long j) {
        this.f8338a = str;
        this.f8340c = j;
        this.f8339b = -1;
    }

    public Feature(String str, int i2, long j) {
        this.f8338a = str;
        this.f8339b = i2;
        this.f8340c = j;
    }

    public final long a() {
        long j = this.f8340c;
        return j == -1 ? (long) this.f8339b : j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.f8338a;
            if (((str == null || !str.equals(feature.f8338a)) && (this.f8338a != null || feature.f8338a != null)) || a() != feature.a()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return q.a((Object) this).a("name", this.f8338a).a("version", Long.valueOf(a())).toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8338a, false);
        b.b(parcel, 2, this.f8339b);
        b.a(parcel, 3, a());
        b.b(parcel, a2);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8338a, Long.valueOf(a())});
    }
}
