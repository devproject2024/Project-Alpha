package com.google.android.gms.location;

import java.util.Comparator;

final class aa implements Comparator<DetectedActivity> {
    aa() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        int compareTo = Integer.valueOf(detectedActivity2.f11331a).compareTo(Integer.valueOf(detectedActivity.f11331a));
        return compareTo == 0 ? Integer.valueOf(detectedActivity.a()).compareTo(Integer.valueOf(detectedActivity2.a())) : compareTo;
    }
}
