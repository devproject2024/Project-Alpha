package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final String f8920a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8921b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f8922c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<zam> f8923d = null;

    zaj(int i2, ArrayList<zam> arrayList, String str) {
        this.f8921b = i2;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zam zam = arrayList.get(i3);
            String str2 = zam.f8927a;
            HashMap hashMap2 = new HashMap();
            int size2 = zam.f8928b.size();
            for (int i4 = 0; i4 < size2; i4++) {
                zal zal = zam.f8928b.get(i4);
                hashMap2.put(zal.f8924a, zal.f8925b);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f8922c = hashMap;
        this.f8920a = (String) s.a(str);
        a();
    }

    private void a() {
        for (String str : this.f8922c.keySet()) {
            Map map = this.f8922c.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).f8911h = this;
            }
        }
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> a(String str) {
        return this.f8922c.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f8922c.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.f8922c.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8921b);
        ArrayList arrayList = new ArrayList();
        for (String next : this.f8922c.keySet()) {
            arrayList.add(new zam(next, this.f8922c.get(next)));
        }
        b.a(parcel, 2, arrayList, false);
        b.a(parcel, 3, this.f8920a, false);
        b.b(parcel, a2);
    }
}
