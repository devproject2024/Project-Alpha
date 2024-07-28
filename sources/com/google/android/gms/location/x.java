package com.google.android.gms.location;

import java.util.Comparator;

final class x implements Comparator<ActivityTransition> {
    x() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        int i2 = activityTransition.f11317a;
        int i3 = activityTransition2.f11317a;
        if (i2 != i3) {
            return i2 < i3 ? -1 : 1;
        }
        int i4 = activityTransition.f11318b;
        int i5 = activityTransition2.f11318b;
        if (i4 == i5) {
            return 0;
        }
        return i4 < i5 ? -1 : 1;
    }
}
