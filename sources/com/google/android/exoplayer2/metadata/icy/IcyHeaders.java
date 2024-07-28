package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;

public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new IcyHeaders[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f32670a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32671b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32672c;

    /* renamed from: d  reason: collision with root package name */
    public final String f32673d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f32674e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32675f;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d2 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.metadata.icy.IcyHeaders a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "icy-br"
            java.lang.Object r1 = r12.get(r1)
            java.util.List r1 = (java.util.List) r1
            r2 = -1
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            int r5 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x002d }
            int r5 = r5 * 1000
            if (r5 <= 0) goto L_0x0020
            r6 = r5
            r1 = 1
            goto L_0x003f
        L_0x0020:
            java.lang.String r6 = "Invalid bitrate: "
            java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch:{ NumberFormatException -> 0x002e }
            r6.concat(r7)     // Catch:{ NumberFormatException -> 0x002e }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ NumberFormatException -> 0x002e }
            goto L_0x003d
        L_0x002d:
            r5 = -1
        L_0x002e:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r6 = "Invalid bitrate header: "
            r6.concat(r1)
            com.google.android.exoplayer2.g.l.c()
            r6 = r5
            r1 = 0
            goto L_0x003f
        L_0x003d:
            r1 = 0
            r6 = -1
        L_0x003f:
            java.lang.String r5 = "icy-genre"
            java.lang.Object r5 = r12.get(r5)
            java.util.List r5 = (java.util.List) r5
            r7 = 0
            if (r5 == 0) goto L_0x0052
            java.lang.Object r1 = r5.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r5 = 1
            goto L_0x0054
        L_0x0052:
            r5 = r1
            r1 = r7
        L_0x0054:
            java.lang.String r8 = "icy-name"
            java.lang.Object r8 = r12.get(r8)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x0067
            java.lang.Object r5 = r8.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r8 = r5
            r5 = 1
            goto L_0x0068
        L_0x0067:
            r8 = r7
        L_0x0068:
            java.lang.String r9 = "icy-url"
            java.lang.Object r9 = r12.get(r9)
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x007b
            java.lang.Object r5 = r9.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r9 = r5
            r5 = 1
            goto L_0x007c
        L_0x007b:
            r9 = r7
        L_0x007c:
            java.lang.String r10 = "icy-pub"
            java.lang.Object r10 = r12.get(r10)
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x0095
            java.lang.Object r5 = r10.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r10 = "1"
            boolean r5 = r5.equals(r10)
            r10 = r5
            r5 = 1
            goto L_0x0096
        L_0x0095:
            r10 = 0
        L_0x0096:
            java.lang.String r11 = "icy-metaint"
            java.lang.Object r12 = r12.get(r11)
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x00c7
            java.lang.Object r12 = r12.get(r4)
            java.lang.String r12 = (java.lang.String) r12
            int r4 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x00bb }
            if (r4 <= 0) goto L_0x00af
            r11 = r4
            r5 = 1
            goto L_0x00c8
        L_0x00af:
            java.lang.String r3 = java.lang.String.valueOf(r12)     // Catch:{ NumberFormatException -> 0x00ba }
            r0.concat(r3)     // Catch:{ NumberFormatException -> 0x00ba }
            com.google.android.exoplayer2.g.l.c()     // Catch:{ NumberFormatException -> 0x00ba }
            goto L_0x00c7
        L_0x00ba:
            r2 = r4
        L_0x00bb:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r0.concat(r12)
            com.google.android.exoplayer2.g.l.c()
            r11 = r2
            goto L_0x00c8
        L_0x00c7:
            r11 = -1
        L_0x00c8:
            if (r5 == 0) goto L_0x00d2
            com.google.android.exoplayer2.metadata.icy.IcyHeaders r12 = new com.google.android.exoplayer2.metadata.icy.IcyHeaders
            r5 = r12
            r7 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return r12
        L_0x00d2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.icy.IcyHeaders.a(java.util.Map):com.google.android.exoplayer2.metadata.icy.IcyHeaders");
    }

    private IcyHeaders(int i2, String str, String str2, String str3, boolean z, int i3) {
        a.a(i3 == -1 || i3 > 0);
        this.f32670a = i2;
        this.f32671b = str;
        this.f32672c = str2;
        this.f32673d = str3;
        this.f32674e = z;
        this.f32675f = i3;
    }

    IcyHeaders(Parcel parcel) {
        this.f32670a = parcel.readInt();
        this.f32671b = parcel.readString();
        this.f32672c = parcel.readString();
        this.f32673d = parcel.readString();
        this.f32674e = ae.a(parcel);
        this.f32675f = parcel.readInt();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            return this.f32670a == icyHeaders.f32670a && ae.a((Object) this.f32671b, (Object) icyHeaders.f32671b) && ae.a((Object) this.f32672c, (Object) icyHeaders.f32672c) && ae.a((Object) this.f32673d, (Object) icyHeaders.f32673d) && this.f32674e == icyHeaders.f32674e && this.f32675f == icyHeaders.f32675f;
        }
    }

    public final int hashCode() {
        int i2 = (this.f32670a + 527) * 31;
        String str = this.f32671b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f32672c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32673d;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return ((((hashCode2 + i3) * 31) + (this.f32674e ? 1 : 0)) * 31) + this.f32675f;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.f32672c + "\", genre=\"" + this.f32671b + "\", bitrate=" + this.f32670a + ", metadataInterval=" + this.f32675f;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32670a);
        parcel.writeString(this.f32671b);
        parcel.writeString(this.f32672c);
        parcel.writeString(this.f32673d);
        ae.a(parcel, this.f32674e);
        parcel.writeInt(this.f32675f);
    }
}
