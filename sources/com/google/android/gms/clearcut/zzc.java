package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8316a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8317b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8318c;

    public zzc(boolean z, long j, long j2) {
        this.f8316a = z;
        this.f8317b = j;
        this.f8318c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzc = (zzc) obj;
            return this.f8316a == zzc.f8316a && this.f8317b == zzc.f8317b && this.f8318c == zzc.f8318c;
        }
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.f8316a + ",collectForDebugStartTimeMillis: " + this.f8317b + ",collectForDebugExpiryTimeMillis: " + this.f8318c + "]";
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f8316a), Long.valueOf(this.f8317b), Long.valueOf(this.f8318c)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8316a);
        b.a(parcel, 2, this.f8318c);
        b.a(parcel, 3, this.f8317b);
        b.b(parcel, a2);
    }
}
