package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.a.b;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Set;

public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private static final zzp f11476a = a("test_type", 1);

    /* renamed from: b  reason: collision with root package name */
    private static final zzp f11477b = a("labeled_place", 6);

    /* renamed from: c  reason: collision with root package name */
    private static final zzp f11478c = a("here_content", 7);

    /* renamed from: d  reason: collision with root package name */
    private static final Set<zzp> f11479d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11480e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11481f;

    zzp(String str, int i2) {
        s.a(str);
        this.f11480e = str;
        this.f11481f = i2;
    }

    private static zzp a(String str, int i2) {
        return new zzp(str, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) obj;
        return this.f11480e.equals(zzp.f11480e) && this.f11481f == zzp.f11481f;
    }

    public final int hashCode() {
        return this.f11480e.hashCode();
    }

    public final String toString() {
        return this.f11480e;
    }

    static {
        zzp zzp = f11476a;
        zzp zzp2 = f11477b;
        zzp zzp3 = f11478c;
        b bVar = new b(3);
        bVar.add(zzp);
        bVar.add(zzp2);
        bVar.add(zzp3);
        f11479d = Collections.unmodifiableSet(bVar);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f11480e, false);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 2, this.f11481f);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
