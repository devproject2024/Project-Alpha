package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.List;

public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    private List<DetectedActivity> f11312a;

    /* renamed from: b  reason: collision with root package name */
    private long f11313b;

    /* renamed from: c  reason: collision with root package name */
    private long f11314c;

    /* renamed from: d  reason: collision with root package name */
    private int f11315d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f11316e;

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i2, Bundle bundle) {
        boolean z = true;
        s.b(list != null && list.size() > 0, "Must have at least 1 detected activity");
        s.b((j <= 0 || j2 <= 0) ? false : z, "Must set times");
        this.f11312a = list;
        this.f11313b = j;
        this.f11314c = j2;
        this.f11315d = i2;
        this.f11316e = bundle;
    }

    private static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || ((bundle != null && bundle2 == null) || bundle.size() != bundle2.size())) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            return this.f11313b == activityRecognitionResult.f11313b && this.f11314c == activityRecognitionResult.f11314c && this.f11315d == activityRecognitionResult.f11315d && q.a(this.f11312a, activityRecognitionResult.f11312a) && a(this.f11316e, activityRecognitionResult.f11316e);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(this.f11312a);
        long j = this.f11313b;
        long j2 = this.f11314c;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 124);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(valueOf);
        sb.append(", timeMillis=");
        sb.append(j);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f11313b), Long.valueOf(this.f11314c), Integer.valueOf(this.f11315d), this.f11312a, this.f11316e});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11312a, false);
        b.a(parcel, 2, this.f11313b);
        b.a(parcel, 3, this.f11314c);
        b.b(parcel, 4, this.f11315d);
        b.a(parcel, 5, this.f11316e);
        b.b(parcel, a2);
    }
}
