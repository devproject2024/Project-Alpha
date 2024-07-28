package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f8895a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f8896b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<String> f8897c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<zaa> f8898d;

    StringToIntConverter(int i2, ArrayList<zaa> arrayList) {
        this.f8895a = i2;
        this.f8896b = new HashMap<>();
        this.f8897c = new SparseArray<>();
        this.f8898d = null;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            zaa zaa2 = (zaa) obj;
            String str = zaa2.f8899a;
            int i4 = zaa2.f8900b;
            this.f8896b.put(str, Integer.valueOf(i4));
            this.f8897c.put(i4, str);
        }
    }

    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        final String f8899a;

        /* renamed from: b  reason: collision with root package name */
        final int f8900b;

        /* renamed from: c  reason: collision with root package name */
        private final int f8901c;

        zaa(int i2, String str, int i3) {
            this.f8901c = i2;
            this.f8899a = str;
            this.f8900b = i3;
        }

        zaa(String str, int i2) {
            this.f8901c = 1;
            this.f8899a = str;
            this.f8900b = i2;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.b(parcel, 1, this.f8901c);
            b.a(parcel, 2, this.f8899a, false);
            b.b(parcel, 3, this.f8900b);
            b.b(parcel, a2);
        }
    }

    public StringToIntConverter() {
        this.f8895a = 1;
        this.f8896b = new HashMap<>();
        this.f8897c = new SparseArray<>();
        this.f8898d = null;
    }

    public final /* synthetic */ Object a(Object obj) {
        String str = this.f8897c.get(((Integer) obj).intValue());
        return (str != null || !this.f8896b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8895a);
        ArrayList arrayList = new ArrayList();
        for (String next : this.f8896b.keySet()) {
            arrayList.add(new zaa(next, this.f8896b.get(next).intValue()));
        }
        b.a(parcel, 2, arrayList, false);
        b.b(parcel, a2);
    }
}
