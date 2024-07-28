package net.one97.paytm.upgradeKyc.editprofile.gallery;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    int f65864a;

    /* renamed from: b  reason: collision with root package name */
    String f65865b;

    /* renamed from: c  reason: collision with root package name */
    String f65866c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<GalleryData> f65867d;

    public g() {
        this((String) null, (String) null, (ArrayList) null, 15);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f65864a == gVar.f65864a && k.a((Object) this.f65865b, (Object) gVar.f65865b) && k.a((Object) this.f65866c, (Object) gVar.f65866c) && k.a((Object) this.f65867d, (Object) gVar.f65867d);
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.f65864a).hashCode() * 31;
        String str = this.f65865b;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f65866c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<GalleryData> arrayList = this.f65867d;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "GalleryAlbums(id=" + this.f65864a + ", name=" + this.f65865b + ", coverUri=" + this.f65866c + ", albumPhotos=" + this.f65867d + ")";
    }

    private g(String str, String str2, ArrayList<GalleryData> arrayList) {
        k.c(str, "name");
        k.c(str2, "coverUri");
        k.c(arrayList, "albumPhotos");
        this.f65864a = 0;
        this.f65865b = str;
        this.f65866c = str2;
        this.f65867d = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(String str, String str2, ArrayList arrayList, int i2) {
        this((i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? new ArrayList() : arrayList);
    }
}
