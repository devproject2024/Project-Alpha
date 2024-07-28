package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract long a();

    public abstract int b();

    public abstract long c();

    public abstract String d();

    public String toString() {
        long a2 = a();
        int b2 = b();
        long c2 = c();
        String d2 = d();
        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 53);
        sb.append(a2);
        sb.append("\t");
        sb.append(b2);
        sb.append("\t");
        sb.append(c2);
        sb.append(d2);
        return sb.toString();
    }
}
