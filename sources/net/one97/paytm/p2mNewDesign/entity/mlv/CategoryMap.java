package net.one97.paytm.p2mNewDesign.entity.mlv;

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
    @b(a = "parent_id")
    private Object parentId;
    @b(a = "polygon_serviceability")
    private Boolean polygonServiceability;
    @b(a = "url_key")
    private String urlKey;
    @b(a = "vat_restrict")
    private final Integer vatRestrict;

    public CategoryMap() {
        this((String) null, (String) null, (String) null, (Object) null, (String) null, (Boolean) null, (Integer) null, 127, (g) null);
    }

    public static /* synthetic */ CategoryMap copy$default(CategoryMap categoryMap, String str, String str2, String str3, Object obj, String str4, Boolean bool, Integer num, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = categoryMap.urlKey;
        }
        if ((i2 & 2) != 0) {
            str2 = categoryMap.id;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = categoryMap.name;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            obj = categoryMap.parentId;
        }
        Object obj3 = obj;
        if ((i2 & 16) != 0) {
            str4 = categoryMap.info;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            bool = categoryMap.polygonServiceability;
        }
        Boolean bool2 = bool;
        if ((i2 & 64) != 0) {
            num = categoryMap.vatRestrict;
        }
        return categoryMap.copy(str, str5, str6, obj3, str7, bool2, num);
    }

    public final String component1() {
        return this.urlKey;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.name;
    }

    public final Object component4() {
        return this.parentId;
    }

    public final String component5() {
        return this.info;
    }

    public final Boolean component6() {
        return this.polygonServiceability;
    }

    public final Integer component7() {
        return this.vatRestrict;
    }

    public final CategoryMap copy(String str, String str2, String str3, Object obj, String str4, Boolean bool, Integer num) {
        return new CategoryMap(str, str2, str3, obj, str4, bool, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryMap)) {
            return false;
        }
        CategoryMap categoryMap = (CategoryMap) obj;
        return k.a((Object) this.urlKey, (Object) categoryMap.urlKey) && k.a((Object) this.id, (Object) categoryMap.id) && k.a((Object) this.name, (Object) categoryMap.name) && k.a(this.parentId, categoryMap.parentId) && k.a((Object) this.info, (Object) categoryMap.info) && k.a((Object) this.polygonServiceability, (Object) categoryMap.polygonServiceability) && k.a((Object) this.vatRestrict, (Object) categoryMap.vatRestrict);
    }

    public final int hashCode() {
        String str = this.urlKey;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.id;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj = this.parentId;
        int hashCode4 = (hashCode3 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str4 = this.info;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.polygonServiceability;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num = this.vatRestrict;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CategoryMap(urlKey=" + this.urlKey + ", id=" + this.id + ", name=" + this.name + ", parentId=" + this.parentId + ", info=" + this.info + ", polygonServiceability=" + this.polygonServiceability + ", vatRestrict=" + this.vatRestrict + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CategoryMap(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Object r10, java.lang.String r11, java.lang.Boolean r12, java.lang.Integer r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.CategoryMap.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.Boolean, java.lang.Integer, int, kotlin.g.b.g):void");
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getId() {
        return this.id;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getName() {
        return this.name;
    }

    public final Object getParentId() {
        return this.parentId;
    }

    public final Boolean getPolygonServiceability() {
        return this.polygonServiceability;
    }

    public final String getUrlKey() {
        return this.urlKey;
    }

    public final Integer getVatRestrict() {
        return this.vatRestrict;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setInfo(String str) {
        this.info = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setParentId(Object obj) {
        this.parentId = obj;
    }

    public final void setPolygonServiceability(Boolean bool) {
        this.polygonServiceability = bool;
    }

    public final void setUrlKey(String str) {
        this.urlKey = str;
    }

    public CategoryMap(String str, String str2, String str3, Object obj, String str4, Boolean bool, Integer num) {
        this.urlKey = str;
        this.id = str2;
        this.name = str3;
        this.parentId = obj;
        this.info = str4;
        this.polygonServiceability = bool;
        this.vatRestrict = num;
    }
}
