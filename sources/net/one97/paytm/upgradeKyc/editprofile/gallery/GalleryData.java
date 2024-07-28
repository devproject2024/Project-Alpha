package net.one97.paytm.upgradeKyc.editprofile.gallery;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class GalleryData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    int f65836a;

    /* renamed from: b  reason: collision with root package name */
    String f65837b;

    /* renamed from: c  reason: collision with root package name */
    String f65838c;

    /* renamed from: d  reason: collision with root package name */
    int f65839d;

    /* renamed from: e  reason: collision with root package name */
    int f65840e;

    /* renamed from: f  reason: collision with root package name */
    String f65841f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f65842g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f65843h;

    /* renamed from: i  reason: collision with root package name */
    private int f65844i;
    private String j;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt2 = parcel.readInt();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new GalleryData(readInt, readString, readString2, readInt2, z2, z, parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new GalleryData[i2];
        }
    }

    public GalleryData() {
        this((String) null, (String) null, false, 0, (String) null, (String) null, 1023);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GalleryData)) {
            return false;
        }
        GalleryData galleryData = (GalleryData) obj;
        return this.f65836a == galleryData.f65836a && k.a((Object) this.f65837b, (Object) galleryData.f65837b) && k.a((Object) this.f65838c, (Object) galleryData.f65838c) && this.f65839d == galleryData.f65839d && this.f65842g == galleryData.f65842g && this.f65843h == galleryData.f65843h && this.f65840e == galleryData.f65840e && this.f65844i == galleryData.f65844i && k.a((Object) this.f65841f, (Object) galleryData.f65841f) && k.a((Object) this.j, (Object) galleryData.j);
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.f65836a).hashCode() * 31;
        String str = this.f65837b;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f65838c;
        int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.valueOf(this.f65839d).hashCode()) * 31;
        boolean z = this.f65842g;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.f65843h;
        if (z2) {
            z2 = true;
        }
        int hashCode4 = (((((i3 + (z2 ? 1 : 0)) * 31) + Integer.valueOf(this.f65840e).hashCode()) * 31) + Integer.valueOf(this.f65844i).hashCode()) * 31;
        String str3 = this.f65841f;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.j;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "GalleryData(id=" + this.f65836a + ", albumName=" + this.f65837b + ", photoUri=" + this.f65838c + ", albumId=" + this.f65839d + ", isSelected=" + this.f65842g + ", isEnabled=" + this.f65843h + ", mediaType=" + this.f65840e + ", duration=" + this.f65844i + ", dateAdded=" + this.f65841f + ", thumbnail=" + this.j + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.f65836a);
        parcel.writeString(this.f65837b);
        parcel.writeString(this.f65838c);
        parcel.writeInt(this.f65839d);
        parcel.writeInt(this.f65842g ? 1 : 0);
        parcel.writeInt(this.f65843h ? 1 : 0);
        parcel.writeInt(this.f65840e);
        parcel.writeInt(this.f65844i);
        parcel.writeString(this.f65841f);
        parcel.writeString(this.j);
    }

    public GalleryData(int i2, String str, String str2, int i3, boolean z, boolean z2, int i4, int i5, String str3, String str4) {
        k.c(str, "albumName");
        k.c(str2, "photoUri");
        k.c(str3, "dateAdded");
        k.c(str4, "thumbnail");
        this.f65836a = i2;
        this.f65837b = str;
        this.f65838c = str2;
        this.f65839d = i3;
        this.f65842g = z;
        this.f65843h = z2;
        this.f65840e = i4;
        this.f65844i = i5;
        this.f65841f = str3;
        this.j = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GalleryData(java.lang.String r15, java.lang.String r16, boolean r17, int r18, java.lang.String r19, java.lang.String r20, int r21) {
        /*
            r14 = this;
            r0 = r21
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r5 = r2
            goto L_0x000b
        L_0x000a:
            r5 = r15
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r16
        L_0x0013:
            r1 = r0 & 32
            r3 = 1
            if (r1 == 0) goto L_0x001a
            r9 = 1
            goto L_0x001c
        L_0x001a:
            r9 = r17
        L_0x001c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0022
            r10 = 1
            goto L_0x0024
        L_0x0022:
            r10 = r18
        L_0x0024:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002a
            r12 = r2
            goto L_0x002c
        L_0x002a:
            r12 = r19
        L_0x002c:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0032
            r13 = r2
            goto L_0x0034
        L_0x0032:
            r13 = r20
        L_0x0034:
            r4 = 0
            r7 = 0
            r8 = 0
            r11 = 0
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.gallery.GalleryData.<init>(java.lang.String, java.lang.String, boolean, int, java.lang.String, java.lang.String, int):void");
    }
}
