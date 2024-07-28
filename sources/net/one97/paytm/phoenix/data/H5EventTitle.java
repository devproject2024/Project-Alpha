package net.one97.paytm.phoenix.data;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class H5EventTitle {
    private String image;
    private String subtitle;
    private String title;

    public H5EventTitle() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ H5EventTitle copy$default(H5EventTitle h5EventTitle, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = h5EventTitle.title;
        }
        if ((i2 & 2) != 0) {
            str2 = h5EventTitle.subtitle;
        }
        if ((i2 & 4) != 0) {
            str3 = h5EventTitle.image;
        }
        return h5EventTitle.copy(str, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.image;
    }

    public final H5EventTitle copy(String str, String str2, String str3) {
        return new H5EventTitle(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H5EventTitle)) {
            return false;
        }
        H5EventTitle h5EventTitle = (H5EventTitle) obj;
        return k.a((Object) this.title, (Object) h5EventTitle.title) && k.a((Object) this.subtitle, (Object) h5EventTitle.subtitle) && k.a((Object) this.image, (Object) h5EventTitle.image);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.image;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "H5EventTitle(title=" + this.title + ", subtitle=" + this.subtitle + ", image=" + this.image + ")";
    }

    public H5EventTitle(String str, String str2, String str3) {
        this.title = str;
        this.subtitle = str2;
        this.image = str3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setSubtitle(String str) {
        this.subtitle = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H5EventTitle(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        this.image = str;
    }
}
