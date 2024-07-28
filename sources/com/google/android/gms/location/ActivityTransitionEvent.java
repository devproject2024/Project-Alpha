package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    final long f11319a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11320b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11321c;

    public ActivityTransitionEvent(int i2, int i3, long j) {
        DetectedActivity.a(i2);
        ActivityTransition.a(i3);
        this.f11320b = i2;
        this.f11321c = i3;
        this.f11319a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f11320b == activityTransitionEvent.f11320b && this.f11321c == activityTransitionEvent.f11321c && this.f11319a == activityTransitionEvent.f11319a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.f11320b;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i2);
        sb.append(sb2.toString());
        sb.append(" ");
        int i3 = this.f11321c;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i3);
        sb.append(sb3.toString());
        sb.append(" ");
        long j = this.f11319a;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j);
        sb.append(sb4.toString());
        return sb.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11320b), Integer.valueOf(this.f11321c), Long.valueOf(this.f11319a)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11320b);
        b.b(parcel, 2, this.f11321c);
        b.a(parcel, 3, this.f11319a);
        b.b(parcel, a2);
    }
}
