package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Iterator;

public final class zzam extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzam> CREATOR = new n();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f12367a;

    zzam(Bundle bundle) {
        this.f12367a = bundle;
    }

    /* access modifiers changed from: package-private */
    public final Object a(String str) {
        return this.f12367a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Long b(String str) {
        return Long.valueOf(this.f12367a.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final Double c(String str) {
        return Double.valueOf(this.f12367a.getDouble(str));
    }

    /* access modifiers changed from: package-private */
    public final String d(String str) {
        return this.f12367a.getString(str);
    }

    public final String toString() {
        return this.f12367a.toString();
    }

    public final Bundle a() {
        return new Bundle(this.f12367a);
    }

    public final Iterator<String> iterator() {
        return new m(this);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, a());
        b.b(parcel, a2);
    }
}
