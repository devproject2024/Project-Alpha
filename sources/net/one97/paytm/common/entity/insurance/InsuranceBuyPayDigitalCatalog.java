package net.one97.paytm.common.entity.insurance;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class InsuranceBuyPayDigitalCatalog extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "categoryHeader")
    private String categoryHeader;
    @b(a = "categoryId")
    private Integer categoryId;
    @b(a = "description")
    private String description;
    @b(a = "displayName")
    private String displayName;
    @b(a = "relatedCategories")
    private List<InsuranceBuyPayOptionModel> relatedCategories;

    public InsuranceBuyPayDigitalCatalog() {
        this((List) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ InsuranceBuyPayDigitalCatalog copy$default(InsuranceBuyPayDigitalCatalog insuranceBuyPayDigitalCatalog, List<InsuranceBuyPayOptionModel> list, String str, Integer num, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = insuranceBuyPayDigitalCatalog.relatedCategories;
        }
        if ((i2 & 2) != 0) {
            str = insuranceBuyPayDigitalCatalog.displayName;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            num = insuranceBuyPayDigitalCatalog.categoryId;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str2 = insuranceBuyPayDigitalCatalog.description;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = insuranceBuyPayDigitalCatalog.categoryHeader;
        }
        return insuranceBuyPayDigitalCatalog.copy(list, str4, num2, str5, str3);
    }

    public final List<InsuranceBuyPayOptionModel> component1() {
        return this.relatedCategories;
    }

    public final String component2() {
        return this.displayName;
    }

    public final Integer component3() {
        return this.categoryId;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.categoryHeader;
    }

    public final InsuranceBuyPayDigitalCatalog copy(List<InsuranceBuyPayOptionModel> list, String str, Integer num, String str2, String str3) {
        return new InsuranceBuyPayDigitalCatalog(list, str, num, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsuranceBuyPayDigitalCatalog)) {
            return false;
        }
        InsuranceBuyPayDigitalCatalog insuranceBuyPayDigitalCatalog = (InsuranceBuyPayDigitalCatalog) obj;
        return k.a((Object) this.relatedCategories, (Object) insuranceBuyPayDigitalCatalog.relatedCategories) && k.a((Object) this.displayName, (Object) insuranceBuyPayDigitalCatalog.displayName) && k.a((Object) this.categoryId, (Object) insuranceBuyPayDigitalCatalog.categoryId) && k.a((Object) this.description, (Object) insuranceBuyPayDigitalCatalog.description) && k.a((Object) this.categoryHeader, (Object) insuranceBuyPayDigitalCatalog.categoryHeader);
    }

    public final int hashCode() {
        List<InsuranceBuyPayOptionModel> list = this.relatedCategories;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.displayName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.categoryId;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.categoryHeader;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "InsuranceBuyPayDigitalCatalog(relatedCategories=" + this.relatedCategories + ", displayName=" + this.displayName + ", categoryId=" + this.categoryId + ", description=" + this.description + ", categoryHeader=" + this.categoryHeader + ")";
    }

    public final List<InsuranceBuyPayOptionModel> getRelatedCategories() {
        return this.relatedCategories;
    }

    public final void setRelatedCategories(List<InsuranceBuyPayOptionModel> list) {
        this.relatedCategories = list;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final Integer getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(Integer num) {
        this.categoryId = num;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public InsuranceBuyPayDigitalCatalog(List<InsuranceBuyPayOptionModel> list, String str, Integer num, String str2, String str3) {
        this.relatedCategories = list;
        this.displayName = str;
        this.categoryId = num;
        this.description = str2;
        this.categoryHeader = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InsuranceBuyPayDigitalCatalog(java.util.List r5, java.lang.String r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.insurance.InsuranceBuyPayDigitalCatalog.<init>(java.util.List, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getCategoryHeader() {
        return this.categoryHeader;
    }

    public final void setCategoryHeader(String str) {
        this.categoryHeader = str;
    }
}
