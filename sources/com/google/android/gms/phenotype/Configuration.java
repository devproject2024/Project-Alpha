package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
    public static final Parcelable.Creator<Configuration> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f12400a;

    /* renamed from: b  reason: collision with root package name */
    private final zzi[] f12401b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f12402c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, zzi> f12403d = new TreeMap();

    public Configuration(int i2, zzi[] zziArr, String[] strArr) {
        this.f12400a = i2;
        this.f12401b = zziArr;
        for (zzi zzi : zziArr) {
            this.f12403d.put(zzi.f12418a, zzi);
        }
        this.f12402c = strArr;
        String[] strArr2 = this.f12402c;
        if (strArr2 != null) {
            Arrays.sort(strArr2);
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return this.f12400a - ((Configuration) obj).f12400a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Configuration) {
            Configuration configuration = (Configuration) obj;
            return this.f12400a == configuration.f12400a && l.a(this.f12403d, configuration.f12403d) && Arrays.equals(this.f12402c, configuration.f12402c);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.f12400a);
        sb.append(", ");
        sb.append("(");
        for (zzi append : this.f12403d.values()) {
            sb.append(append);
            sb.append(", ");
        }
        sb.append(")");
        sb.append(", ");
        sb.append("(");
        String[] strArr = this.f12402c;
        if (strArr != null) {
            for (String append2 : strArr) {
                sb.append(append2);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append(")");
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f12400a);
        b.a(parcel, 3, (T[]) this.f12401b, i2);
        b.a(parcel, 4, this.f12402c);
        b.b(parcel, a2);
    }
}
