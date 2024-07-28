package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private static final String f11567a = Cap.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final int f11568b;

    /* renamed from: c  reason: collision with root package name */
    private final a f11569c;

    /* renamed from: d  reason: collision with root package name */
    private final Float f11570d;

    private Cap(int i2, a aVar, Float f2) {
        s.b(i2 != 3 || (aVar != null && (f2 != null && (f2.floatValue() > 0.0f ? 1 : (f2.floatValue() == 0.0f ? 0 : -1)) > 0)), String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[]{Integer.valueOf(i2), aVar, f2}));
        this.f11568b = i2;
        this.f11569c = aVar;
        this.f11570d = f2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Cap(int r2, android.os.IBinder r3, java.lang.Float r4) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0004
            r3 = 0
            goto L_0x000e
        L_0x0004:
            com.google.android.gms.b.b r3 = com.google.android.gms.b.b.a.a(r3)
            com.google.android.gms.maps.model.a r0 = new com.google.android.gms.maps.model.a
            r0.<init>(r3)
            r3 = r0
        L_0x000e:
            r1.<init>((int) r2, (com.google.android.gms.maps.model.a) r3, (java.lang.Float) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.Cap.<init>(int, android.os.IBinder, java.lang.Float):void");
    }

    protected Cap(int i2) {
        this(i2, (a) null, (Float) null);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11568b), this.f11569c, this.f11570d});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f11568b == cap.f11568b && q.a(this.f11569c, cap.f11569c) && q.a(this.f11570d, cap.f11570d);
    }

    public String toString() {
        int i2 = this.f11568b;
        StringBuilder sb = new StringBuilder(23);
        sb.append("[Cap: type=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f11568b);
        a aVar = this.f11569c;
        if (aVar == null) {
            iBinder = null;
        } else {
            iBinder = aVar.f11663a.asBinder();
        }
        b.a(parcel, 3, iBinder);
        b.a(parcel, 4, this.f11570d);
        b.b(parcel, a2);
    }
}
