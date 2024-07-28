package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class ActivityTransition extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    final int f11317a;

    /* renamed from: b  reason: collision with root package name */
    final int f11318b;

    ActivityTransition(int i2, int i3) {
        this.f11317a = i2;
        this.f11318b = i3;
    }

    public static void a(int i2) {
        boolean z = true;
        if (i2 < 0 || i2 > 1) {
            z = false;
        }
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i2);
        sb.append(" is not valid.");
        s.b(z, sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f11317a == activityTransition.f11317a && this.f11318b == activityTransition.f11318b;
    }

    public String toString() {
        int i2 = this.f11317a;
        int i3 = this.f11318b;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i2);
        sb.append(", mTransitionType=");
        sb.append(i3);
        sb.append(']');
        return sb.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11317a), Integer.valueOf(this.f11318b)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11317a);
        b.b(parcel, 2, this.f11318b);
        b.b(parcel, a2);
    }
}
