package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.appindexing.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public final class Thing extends AbstractSafeParcelable implements ReflectedParcelable, g {
    public static final Parcelable.Creator<Thing> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final zza f38011a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38012b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f38013c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38014d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38015e;

    public Thing(int i2, Bundle bundle, zza zza2, String str, String str2) {
        this.f38012b = i2;
        this.f38013c = bundle;
        this.f38011a = zza2;
        this.f38014d = str;
        this.f38015e = str2;
        this.f38013c.setClassLoader(getClass().getClassLoader());
    }

    public Thing(Bundle bundle, zza zza2, String str, String str2) {
        this.f38012b = 10;
        this.f38013c = bundle;
        this.f38011a = zza2;
        this.f38014d = str;
        this.f38015e = str2;
    }

    public static class zza extends AbstractSafeParcelable implements g.b {
        public static final Parcelable.Creator<zza> CREATOR = new y();

        /* renamed from: a  reason: collision with root package name */
        final Bundle f38016a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f38017b;

        /* renamed from: c  reason: collision with root package name */
        private final int f38018c;

        /* renamed from: d  reason: collision with root package name */
        private final String f38019d;

        public zza(boolean z, int i2, String str, Bundle bundle) {
            this.f38017b = z;
            this.f38018c = i2;
            this.f38019d = str;
            this.f38016a = bundle == null ? new Bundle() : bundle;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("worksOffline: ");
            sb.append(this.f38017b);
            sb.append(", score: ");
            sb.append(this.f38018c);
            if (!this.f38019d.isEmpty()) {
                sb.append(", accountEmail: ");
                sb.append(this.f38019d);
            }
            Bundle bundle = this.f38016a;
            if (bundle != null && !bundle.isEmpty()) {
                sb.append(", Properties { ");
                Thing.b(this.f38016a, sb);
                sb.append("}");
            }
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return q.a(Boolean.valueOf(this.f38017b), Boolean.valueOf(zza.f38017b)) && q.a(Integer.valueOf(this.f38018c), Integer.valueOf(zza.f38018c)) && q.a(this.f38019d, zza.f38019d) && Thing.b(this.f38016a, zza.f38016a);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f38017b), Integer.valueOf(this.f38018c), this.f38019d, Integer.valueOf(Thing.b(this.f38016a))});
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 1, this.f38017b);
            b.b(parcel, 2, this.f38018c);
            b.a(parcel, 3, this.f38019d, false);
            b.a(parcel, 4, this.f38016a);
            b.b(parcel, a2);
        }
    }

    /* access modifiers changed from: private */
    public static void b(Bundle bundle, StringBuilder sb) {
        try {
            Set keySet = bundle.keySet();
            String[] strArr = (String[]) keySet.toArray(new String[keySet.size()]);
            Arrays.sort(strArr, c.f38023a);
            for (String str : strArr) {
                sb.append("{ key: '");
                sb.append(str);
                sb.append("' value: ");
                Object obj = bundle.get(str);
                if (obj == null) {
                    sb.append("<null>");
                } else if (obj.getClass().isArray()) {
                    sb.append("[ ");
                    for (int i2 = 0; i2 < Array.getLength(obj); i2++) {
                        sb.append("'");
                        sb.append(Array.get(obj, i2));
                        sb.append("' ");
                    }
                    sb.append("]");
                } else {
                    sb.append(obj.toString());
                }
                sb.append(" } ");
            }
        } catch (RuntimeException unused) {
            sb.append("<error>");
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f38015e.equals("Thing") ? "Indexable" : this.f38015e);
        sb.append(" { { id: ");
        if (this.f38014d == null) {
            sb.append("<null>");
        } else {
            sb.append("'");
            sb.append(this.f38014d);
            sb.append("'");
        }
        sb.append(" } Properties { ");
        b(this.f38013c, sb);
        sb.append("} ");
        sb.append("Metadata { ");
        sb.append(this.f38011a.toString());
        sb.append(" } ");
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Thing)) {
            return false;
        }
        Thing thing = (Thing) obj;
        return q.a(Integer.valueOf(this.f38012b), Integer.valueOf(thing.f38012b)) && q.a(this.f38014d, thing.f38014d) && q.a(this.f38015e, thing.f38015e) && q.a(this.f38011a, thing.f38011a) && b(this.f38013c, thing.f38013c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f38012b), this.f38014d, this.f38015e, Integer.valueOf(this.f38011a.hashCode()), Integer.valueOf(b(this.f38013c))});
    }

    /* access modifiers changed from: private */
    public static boolean b(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !b((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null && (obj2 != null || !bundle2.containsKey(str))) {
                return false;
            }
            if (obj instanceof boolean[]) {
                if (!(obj2 instanceof boolean[]) || !Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof long[]) {
                if (!(obj2 instanceof long[]) || !Arrays.equals((long[]) obj, (long[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof double[]) {
                if (!(obj2 instanceof double[]) || !Arrays.equals((double[]) obj, (double[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else if ((obj instanceof Object[]) && (!(obj2 instanceof Object[]) || !Arrays.equals((Object[]) obj, (Object[]) obj2))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int b(Bundle bundle) {
        ArrayList arrayList = new ArrayList(bundle.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList3.get(i2);
            i2++;
            Object obj2 = bundle.get((String) obj);
            if (obj2 instanceof boolean[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((boolean[]) obj2)));
            } else if (obj2 instanceof long[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((long[]) obj2)));
            } else if (obj2 instanceof double[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((double[]) obj2)));
            } else if (obj2 instanceof byte[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((byte[]) obj2)));
            } else if (obj2 instanceof Object[]) {
                arrayList2.add(Integer.valueOf(Arrays.hashCode((Object[]) obj2)));
            } else {
                arrayList2.add(Integer.valueOf(Arrays.hashCode(new Object[]{obj2})));
            }
        }
        return Arrays.hashCode(arrayList2.toArray());
    }

    static final /* synthetic */ int a(String str, String str2) {
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f38013c);
        b.a(parcel, 2, this.f38011a, i2, false);
        b.a(parcel, 3, this.f38014d, false);
        b.a(parcel, 4, this.f38015e, false);
        b.b(parcel, 1000, this.f38012b);
        b.b(parcel, a2);
    }
}
