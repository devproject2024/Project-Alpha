package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class CategoryMap extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "id")
    private String id;
    @b(a = "info")
    private String info;
    @b(a = "name")
    private String name;
    @b(a = "polygon_serviceability")
    private Boolean polygonServiceability;
    @b(a = "url_key")
    private String urlKey;
    @b(a = "vat_restrict")
    private String vatRestrict;

    public CategoryMap() {
        this((String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ CategoryMap copy$default(CategoryMap categoryMap, String str, String str2, String str3, String str4, Boolean bool, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = categoryMap.id;
        }
        if ((i2 & 2) != 0) {
            str2 = categoryMap.name;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = categoryMap.urlKey;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = categoryMap.info;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            bool = categoryMap.polygonServiceability;
        }
        Boolean bool2 = bool;
        if ((i2 & 32) != 0) {
            str5 = categoryMap.vatRestrict;
        }
        return categoryMap.copy(str, str6, str7, str8, bool2, str5);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.urlKey;
    }

    public final String component4() {
        return this.info;
    }

    public final Boolean component5() {
        return this.polygonServiceability;
    }

    public final String component6() {
        return this.vatRestrict;
    }

    public final CategoryMap copy(String str, String str2, String str3, String str4, Boolean bool, String str5) {
        return new CategoryMap(str, str2, str3, str4, bool, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryMap)) {
            return false;
        }
        CategoryMap categoryMap = (CategoryMap) obj;
        return k.a((Object) this.id, (Object) categoryMap.id) && k.a((Object) this.name, (Object) categoryMap.name) && k.a((Object) this.urlKey, (Object) categoryMap.urlKey) && k.a((Object) this.info, (Object) categoryMap.info) && k.a((Object) this.polygonServiceability, (Object) categoryMap.polygonServiceability) && k.a((Object) this.vatRestrict, (Object) categoryMap.vatRestrict);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.urlKey;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.info;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.polygonServiceability;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str5 = this.vatRestrict;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CategoryMap(id=" + this.id + ", name=" + this.name + ", urlKey=" + this.urlKey + ", info=" + this.info + ", polygonServiceability=" + this.polygonServiceability + ", vatRestrict=" + this.vatRestrict + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getUrlKey() {
        return this.urlKey;
    }

    public final void setUrlKey(String str) {
        this.urlKey = str;
    }

    public final String getInfo() {
        return this.info;
    }

    public final void setInfo(String str) {
        this.info = str;
    }

    public final Boolean getPolygonServiceability() {
        return this.polygonServiceability;
    }

    public final void setPolygonServiceability(Boolean bool) {
        this.polygonServiceability = bool;
    }

    public CategoryMap(String str, String str2, String str3, String str4, Boolean bool, String str5) {
        this.id = str;
        this.name = str2;
        this.urlKey = str3;
        this.info = str4;
        this.polygonServiceability = bool;
        this.vatRestrict = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CategoryMap(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Boolean r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.CategoryMap.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getVatRestrict() {
        return this.vatRestrict;
    }

    public final void setVatRestrict(String str) {
        this.vatRestrict = str;
    }
}
