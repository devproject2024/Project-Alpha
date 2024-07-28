package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final String f8927a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<zal> f8928b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8929c;

    zam(int i2, String str, ArrayList<zal> arrayList) {
        this.f8929c = i2;
        this.f8927a = str;
        this.f8928b = arrayList;
    }

    zam(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zal> arrayList;
        this.f8929c = 1;
        this.f8927a = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new zal(next, map.get(next)));
            }
        }
        this.f8928b = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8929c);
        b.a(parcel, 2, this.f8927a, false);
        b.a(parcel, 3, this.f8928b, false);
        b.b(parcel, a2);
    }
}
