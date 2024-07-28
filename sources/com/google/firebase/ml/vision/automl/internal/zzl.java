package com.google.firebase.ml.vision.automl.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public final String f39091a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39092b;

    /* renamed from: c  reason: collision with root package name */
    public final float f39093c;

    public zzl(String str, String str2, float f2) {
        this.f39091a = str;
        this.f39092b = str2;
        this.f39093c = f2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl = (zzl) obj;
        return q.a(this.f39091a, zzl.f39091a) && q.a(this.f39092b, zzl.f39092b) && Float.compare(this.f39093c, zzl.f39093c) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39091a, this.f39092b, Float.valueOf(this.f39093c)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f39091a, false);
        b.a(parcel, 2, this.f39092b, false);
        b.a(parcel, 3, this.f39093c);
        b.b(parcel, a2);
    }
}
