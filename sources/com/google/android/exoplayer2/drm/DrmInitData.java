package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new DrmInitData[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final SchemeData[] f31353a;

    /* renamed from: b  reason: collision with root package name */
    public final String f31354b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31355c;

    /* renamed from: d  reason: collision with root package name */
    private int f31356d;

    public final int describeContents() {
        return 0;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        if (c.f31284a.equals(schemeData.f31357a)) {
            return c.f31284a.equals(schemeData2.f31357a) ? 0 : 1;
        }
        return schemeData.f31357a.compareTo(schemeData2.f31357a);
    }

    public static DrmInitData a(DrmInitData drmInitData, DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.f31354b;
            for (SchemeData schemeData : drmInitData.f31353a) {
                if (schemeData.a()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.f31354b;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.f31353a) {
                if (schemeData2.a() && !a(arrayList, size, schemeData2.f31357a)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, (List<SchemeData>) arrayList);
    }

    public DrmInitData(List<SchemeData> list) {
        this((String) null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }

    public DrmInitData(String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(java.lang.String r1, boolean r2, com.google.android.exoplayer2.drm.DrmInitData.SchemeData... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.f31354b = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r3
        L_0x000e:
            r0.f31353a = r3
            int r1 = r3.length
            r0.f31355c = r1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r1 = r0.f31353a
            java.util.Arrays.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DrmInitData.<init>(java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData$SchemeData[]):void");
    }

    DrmInitData(Parcel parcel) {
        this.f31354b = parcel.readString();
        this.f31353a = (SchemeData[]) ae.a(parcel.createTypedArray(SchemeData.CREATOR));
        this.f31355c = this.f31353a.length;
    }

    public final DrmInitData a(String str) {
        if (ae.a((Object) this.f31354b, (Object) str)) {
            return this;
        }
        return new DrmInitData(str, false, this.f31353a);
    }

    public final int hashCode() {
        if (this.f31356d == 0) {
            String str = this.f31354b;
            this.f31356d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f31353a);
        }
        return this.f31356d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DrmInitData drmInitData = (DrmInitData) obj;
            return ae.a((Object) this.f31354b, (Object) drmInitData.f31354b) && Arrays.equals(this.f31353a, drmInitData.f31353a);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f31354b);
        parcel.writeTypedArray(this.f31353a, 0);
    }

    private static boolean a(ArrayList<SchemeData> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).f31357a.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SchemeData[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final UUID f31357a;

        /* renamed from: b  reason: collision with root package name */
        public final String f31358b;

        /* renamed from: c  reason: collision with root package name */
        public final String f31359c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f31360d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f31361e;

        /* renamed from: f  reason: collision with root package name */
        private int f31362f;

        public final int describeContents() {
            return 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, (byte) 0);
        }

        private SchemeData(UUID uuid, String str, byte[] bArr, byte b2) {
            this(uuid, (String) null, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr, boolean z) {
            this.f31357a = (UUID) a.a(uuid);
            this.f31358b = str;
            this.f31359c = (String) a.a(str2);
            this.f31360d = bArr;
            this.f31361e = z;
        }

        SchemeData(Parcel parcel) {
            this.f31357a = new UUID(parcel.readLong(), parcel.readLong());
            this.f31358b = parcel.readString();
            this.f31359c = (String) ae.a(parcel.readString());
            this.f31360d = parcel.createByteArray();
            this.f31361e = parcel.readByte() != 0;
        }

        public final boolean a(UUID uuid) {
            return c.f31284a.equals(this.f31357a) || uuid.equals(this.f31357a);
        }

        public final boolean a() {
            return this.f31360d != null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return ae.a((Object) this.f31358b, (Object) schemeData.f31358b) && ae.a((Object) this.f31359c, (Object) schemeData.f31359c) && ae.a((Object) this.f31357a, (Object) schemeData.f31357a) && Arrays.equals(this.f31360d, schemeData.f31360d);
        }

        public final int hashCode() {
            if (this.f31362f == 0) {
                int hashCode = this.f31357a.hashCode() * 31;
                String str = this.f31358b;
                this.f31362f = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f31359c.hashCode()) * 31) + Arrays.hashCode(this.f31360d);
            }
            return this.f31362f;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f31357a.getMostSignificantBits());
            parcel.writeLong(this.f31357a.getLeastSignificantBits());
            parcel.writeString(this.f31358b);
            parcel.writeString(this.f31359c);
            parcel.writeByteArray(this.f31360d);
            parcel.writeByte(this.f31361e ? (byte) 1 : 0);
        }
    }
}
