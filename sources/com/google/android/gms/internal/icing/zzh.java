package com.google.android.gms.internal.icing;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new fj();

    /* renamed from: a  reason: collision with root package name */
    private final zzk[] f10297a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10298b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10299c;

    /* renamed from: d  reason: collision with root package name */
    private final Account f10300d;

    zzh(zzk[] zzkArr, String str, boolean z, Account account) {
        this.f10297a = zzkArr;
        this.f10298b = str;
        this.f10299c = z;
        this.f10300d = account;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10298b, Boolean.valueOf(this.f10299c), this.f10300d, Integer.valueOf(Arrays.hashCode(this.f10297a))});
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            zzh zzh = (zzh) obj;
            if (!q.a(this.f10298b, zzh.f10298b) || !q.a(Boolean.valueOf(this.f10299c), Boolean.valueOf(zzh.f10299c)) || !q.a(this.f10300d, zzh.f10300d) || !Arrays.equals(this.f10297a, zzh.f10297a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, (T[]) this.f10297a, i2);
        b.a(parcel, 2, this.f10298b, false);
        b.a(parcel, 3, this.f10299c);
        b.a(parcel, 4, this.f10300d, i2, false);
        b.b(parcel, a2);
    }
}
