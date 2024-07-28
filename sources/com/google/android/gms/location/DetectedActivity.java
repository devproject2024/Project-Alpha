package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.H5Utils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Comparator;

public class DetectedActivity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new ab();

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<DetectedActivity> f11327b = new aa();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f11328c = {9, 10};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f11329d = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f11330e = {0, 1, 2, 3, 7, 8, 16, 17};

    /* renamed from: a  reason: collision with root package name */
    int f11331a;

    /* renamed from: f  reason: collision with root package name */
    private int f11332f;

    public DetectedActivity(int i2, int i3) {
        this.f11332f = i2;
        this.f11331a = i3;
    }

    public static void a(int i2) {
        boolean z = false;
        for (int i3 : f11330e) {
            if (i3 == i2) {
                z = true;
            }
        }
        if (!z) {
            StringBuilder sb = new StringBuilder(81);
            sb.append(i2);
            sb.append(" is not a valid DetectedActivity supported by Activity Transition API.");
        }
    }

    public final int a() {
        int i2 = this.f11332f;
        if (i2 > 19 || i2 < 0) {
            return 4;
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            return this.f11332f == detectedActivity.f11332f && this.f11331a == detectedActivity.f11331a;
        }
    }

    public String toString() {
        String str;
        int a2 = a();
        if (a2 == 0) {
            str = "IN_VEHICLE";
        } else if (a2 == 1) {
            str = "ON_BICYCLE";
        } else if (a2 == 2) {
            str = "ON_FOOT";
        } else if (a2 == 3) {
            str = "STILL";
        } else if (a2 == 4) {
            str = H5Utils.NETWORK_TYPE_UNKNOWN;
        } else if (a2 == 5) {
            str = "TILTING";
        } else if (a2 == 7) {
            str = "WALKING";
        } else if (a2 != 8) {
            switch (a2) {
                case 16:
                    str = "IN_ROAD_VEHICLE";
                    break;
                case 17:
                    str = "IN_RAIL_VEHICLE";
                    break;
                case 18:
                    str = "IN_TWO_WHEELER_VEHICLE";
                    break;
                case 19:
                    str = "IN_FOUR_WHEELER_VEHICLE";
                    break;
                default:
                    str = Integer.toString(a2);
                    break;
            }
        } else {
            str = "RUNNING";
        }
        int i2 = this.f11331a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(str);
        sb.append(", confidence=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f11332f);
        b.b(parcel, 2, this.f11331a);
        b.b(parcel, a2);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11332f), Integer.valueOf(this.f11331a)});
    }
}
