package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    public final String f8352a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8353b;

    Scope(int i2, String str) {
        s.a(str, (Object) "scopeUri must not be null or empty");
        this.f8353b = i2;
        this.f8352a = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f8352a.equals(((Scope) obj).f8352a);
    }

    public final int hashCode() {
        return this.f8352a.hashCode();
    }

    public final String toString() {
        return this.f8352a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8353b);
        b.a(parcel, 2, this.f8352a, false);
        b.b(parcel, a2);
    }
}
