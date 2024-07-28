package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    private static final String f11608a = PatternItem.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f11609b;

    /* renamed from: c  reason: collision with root package name */
    private final Float f11610c;

    public PatternItem(int i2, Float f2) {
        boolean z = true;
        if (i2 != 1 && (f2 == null || f2.floatValue() < 0.0f)) {
            z = false;
        }
        String valueOf = String.valueOf(f2);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i2);
        sb.append(" length=");
        sb.append(valueOf);
        s.b(z, sb.toString());
        this.f11609b = i2;
        this.f11610c = f2;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11609b), this.f11610c});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f11609b == patternItem.f11609b && q.a(this.f11610c, patternItem.f11610c);
    }

    public String toString() {
        int i2 = this.f11609b;
        String valueOf = String.valueOf(this.f11610c);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i2);
        sb.append(" length=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f11609b);
        b.a(parcel, 3, this.f11610c);
        b.b(parcel, a2);
    }
}
