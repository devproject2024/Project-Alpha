package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f8103a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f8104b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8105c;

    /* renamed from: d  reason: collision with root package name */
    private zzt f8106d;

    /* renamed from: e  reason: collision with root package name */
    private String f8107e;

    /* renamed from: f  reason: collision with root package name */
    private String f8108f;

    /* renamed from: g  reason: collision with root package name */
    private String f8109g;

    public zzr() {
        this.f8104b = new HashSet(3);
        this.f8105c = 1;
    }

    zzr(Set<Integer> set, int i2, zzt zzt, String str, String str2, String str3) {
        this.f8104b = set;
        this.f8105c = i2;
        this.f8106d = zzt;
        this.f8107e = str;
        this.f8108f = str2;
        this.f8109g = str3;
    }

    public final boolean a(FastJsonResponse.Field field) {
        return this.f8104b.contains(Integer.valueOf(field.a()));
    }

    public final Object b(FastJsonResponse.Field field) {
        int a2 = field.a();
        if (a2 == 1) {
            return Integer.valueOf(this.f8105c);
        }
        if (a2 == 2) {
            return this.f8106d;
        }
        if (a2 == 3) {
            return this.f8107e;
        }
        if (a2 == 4) {
            return this.f8108f;
        }
        int a3 = field.a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a3);
        throw new IllegalStateException(sb.toString());
    }

    public final /* synthetic */ Map a() {
        return f8103a;
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f8103a = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.a("authenticatorInfo", 2, zzt.class));
        f8103a.put("signature", FastJsonResponse.Field.a("signature", 3));
        f8103a.put("package", FastJsonResponse.Field.a("package", 4));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        Set<Integer> set = this.f8104b;
        if (set.contains(1)) {
            b.b(parcel, 1, this.f8105c);
        }
        if (set.contains(2)) {
            b.a(parcel, 2, this.f8106d, i2, true);
        }
        if (set.contains(3)) {
            b.a(parcel, 3, this.f8107e, true);
        }
        if (set.contains(4)) {
            b.a(parcel, 4, this.f8108f, true);
        }
        if (set.contains(5)) {
            b.a(parcel, 5, this.f8109g, true);
        }
        b.b(parcel, a2);
    }
}
