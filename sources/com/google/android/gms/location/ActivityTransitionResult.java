package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    private final List<ActivityTransitionEvent> f11326a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f11326a.equals(((ActivityTransitionResult) obj).f11326a);
    }

    public int hashCode() {
        return this.f11326a.hashCode();
    }

    public ActivityTransitionResult(List<ActivityTransitionEvent> list) {
        s.a(list, (Object) "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i2 = 1; i2 < list.size(); i2++) {
                s.b(list.get(i2).f11319a >= list.get(i2 + -1).f11319a);
            }
        }
        this.f11326a = Collections.unmodifiableList(list);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f11326a, false);
        b.b(parcel, a2);
    }
}
