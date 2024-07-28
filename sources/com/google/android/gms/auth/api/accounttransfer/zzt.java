package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.a.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f8110a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f8111b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8112c;

    /* renamed from: d  reason: collision with root package name */
    private String f8113d;

    /* renamed from: e  reason: collision with root package name */
    private int f8114e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f8115f;

    /* renamed from: g  reason: collision with root package name */
    private PendingIntent f8116g;

    /* renamed from: h  reason: collision with root package name */
    private DeviceMetaData f8117h;

    zzt(Set<Integer> set, int i2, String str, int i3, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f8111b = set;
        this.f8112c = i2;
        this.f8113d = str;
        this.f8114e = i3;
        this.f8115f = bArr;
        this.f8116g = pendingIntent;
        this.f8117h = deviceMetaData;
    }

    public zzt() {
        this.f8111b = new b(3);
        this.f8112c = 1;
    }

    public final boolean a(FastJsonResponse.Field field) {
        return this.f8111b.contains(Integer.valueOf(field.a()));
    }

    public final Object b(FastJsonResponse.Field field) {
        int a2 = field.a();
        if (a2 == 1) {
            return Integer.valueOf(this.f8112c);
        }
        if (a2 == 2) {
            return this.f8113d;
        }
        if (a2 == 3) {
            return Integer.valueOf(this.f8114e);
        }
        if (a2 == 4) {
            return this.f8115f;
        }
        int a3 = field.a();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(a3);
        throw new IllegalStateException(sb.toString());
    }

    public final /* synthetic */ Map a() {
        return f8110a;
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f8110a = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.a("accountType", 2));
        f8110a.put("status", FastJsonResponse.Field.a("status"));
        f8110a.put("transferBytes", FastJsonResponse.Field.b("transferBytes"));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel, 20293);
        Set<Integer> set = this.f8111b;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.b.b(parcel, 1, this.f8112c);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f8113d, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.b.b(parcel, 3, this.f8114e);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.f8115f, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f8116g, i2, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.f8117h, i2, true);
        }
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, a2);
    }
}
