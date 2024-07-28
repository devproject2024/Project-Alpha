package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.location.zzj;
import java.util.Collections;
import java.util.List;

public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new ah();

    /* renamed from: a  reason: collision with root package name */
    static final List<ClientIdentity> f10425a = Collections.emptyList();

    /* renamed from: b  reason: collision with root package name */
    static final zzj f10426b = new zzj();

    /* renamed from: c  reason: collision with root package name */
    private zzj f10427c;

    /* renamed from: d  reason: collision with root package name */
    private List<ClientIdentity> f10428d;

    /* renamed from: e  reason: collision with root package name */
    private String f10429e;

    zzm(zzj zzj, List<ClientIdentity> list, String str) {
        this.f10427c = zzj;
        this.f10428d = list;
        this.f10429e = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzm = (zzm) obj;
        return q.a(this.f10427c, zzm.f10427c) && q.a(this.f10428d, zzm.f10428d) && q.a(this.f10429e, zzm.f10429e);
    }

    public final int hashCode() {
        return this.f10427c.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10427c, i2, false);
        b.a(parcel, 2, this.f10428d, false);
        b.a(parcel, 3, this.f10429e, false);
        b.b(parcel, a2);
    }
}
