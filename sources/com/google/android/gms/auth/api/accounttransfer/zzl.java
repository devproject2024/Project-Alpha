package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f8090a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f8091b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8092c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<zzr> f8093d;

    /* renamed from: e  reason: collision with root package name */
    private int f8094e;

    /* renamed from: f  reason: collision with root package name */
    private zzo f8095f;

    zzl(Set<Integer> set, int i2, ArrayList<zzr> arrayList, int i3, zzo zzo) {
        this.f8091b = set;
        this.f8092c = i2;
        this.f8093d = arrayList;
        this.f8094e = i3;
        this.f8095f = zzo;
    }

    public zzl() {
        this.f8091b = new HashSet(1);
        this.f8092c = 1;
    }

    public final boolean a(FastJsonResponse.Field field) {
        return this.f8091b.contains(Integer.valueOf(field.a()));
    }

    public final Object b(FastJsonResponse.Field field) {
        int a2 = field.a();
        if (a2 == 1) {
            return Integer.valueOf(this.f8092c);
        }
        if (a2 == 2) {
            return this.f8093d;
        }
        if (a2 == 4) {
            return this.f8095f;
        }
        int a3 = field.a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a3);
        throw new IllegalStateException(sb.toString());
    }

    public final /* synthetic */ Map a() {
        return f8090a;
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f8090a = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.a("authenticatorData", zzr.class));
        f8090a.put(H5Param.PROGRESS, FastJsonResponse.Field.a(H5Param.PROGRESS, 4, zzo.class));
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        Set<Integer> set = this.f8091b;
        if (set.contains(1)) {
            b.b(parcel, 1, this.f8092c);
        }
        if (set.contains(2)) {
            b.a(parcel, 2, this.f8093d, true);
        }
        if (set.contains(3)) {
            b.b(parcel, 3, this.f8094e);
        }
        if (set.contains(4)) {
            b.a(parcel, 4, this.f8095f, i2, true);
        }
        b.b(parcel, a2);
    }
}
