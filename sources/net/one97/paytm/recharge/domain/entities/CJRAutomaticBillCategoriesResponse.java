package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRAutomaticBillCategoriesResponse extends IJRPaytmDataModel {
    @b(a = "entity_type")
    private String category;
    @b(a = "footer_image_url")
    private String footerImageUrl;
    @b(a = "homepage_layout")
    private List<CJRAutomaticBillCategoriesHomepageLayout> homepageLayouts;
    @b(a = "meta_title")
    private String metaTitle;
    @b(a = "placeholder_image_url")
    private String placeholderImageUrl;
    @b(a = "redirect_url")
    private String redirectUrl;
    @b(a = "storeName")
    private String storeName;

    public CJRAutomaticBillCategoriesResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 127, (g) null);
    }

    public static /* synthetic */ CJRAutomaticBillCategoriesResponse copy$default(CJRAutomaticBillCategoriesResponse cJRAutomaticBillCategoriesResponse, String str, String str2, String str3, String str4, String str5, String str6, List<CJRAutomaticBillCategoriesHomepageLayout> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRAutomaticBillCategoriesResponse.metaTitle;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRAutomaticBillCategoriesResponse.category;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = cJRAutomaticBillCategoriesResponse.placeholderImageUrl;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = cJRAutomaticBillCategoriesResponse.storeName;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = cJRAutomaticBillCategoriesResponse.footerImageUrl;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = cJRAutomaticBillCategoriesResponse.redirectUrl;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            list = cJRAutomaticBillCategoriesResponse.homepageLayouts;
        }
        return cJRAutomaticBillCategoriesResponse.copy(str, str7, str8, str9, str10, str11, list);
    }

    public final String component1() {
        return this.metaTitle;
    }

    public final String component2() {
        return this.category;
    }

    public final String component3() {
        return this.placeholderImageUrl;
    }

    public final String component4() {
        return this.storeName;
    }

    public final String component5() {
        return this.footerImageUrl;
    }

    public final String component6() {
        return this.redirectUrl;
    }

    public final List<CJRAutomaticBillCategoriesHomepageLayout> component7() {
        return this.homepageLayouts;
    }

    public final CJRAutomaticBillCategoriesResponse copy(String str, String str2, String str3, String str4, String str5, String str6, List<CJRAutomaticBillCategoriesHomepageLayout> list) {
        return new CJRAutomaticBillCategoriesResponse(str, str2, str3, str4, str5, str6, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRAutomaticBillCategoriesResponse)) {
            return false;
        }
        CJRAutomaticBillCategoriesResponse cJRAutomaticBillCategoriesResponse = (CJRAutomaticBillCategoriesResponse) obj;
        return k.a((Object) this.metaTitle, (Object) cJRAutomaticBillCategoriesResponse.metaTitle) && k.a((Object) this.category, (Object) cJRAutomaticBillCategoriesResponse.category) && k.a((Object) this.placeholderImageUrl, (Object) cJRAutomaticBillCategoriesResponse.placeholderImageUrl) && k.a((Object) this.storeName, (Object) cJRAutomaticBillCategoriesResponse.storeName) && k.a((Object) this.footerImageUrl, (Object) cJRAutomaticBillCategoriesResponse.footerImageUrl) && k.a((Object) this.redirectUrl, (Object) cJRAutomaticBillCategoriesResponse.redirectUrl) && k.a((Object) this.homepageLayouts, (Object) cJRAutomaticBillCategoriesResponse.homepageLayouts);
    }

    public final int hashCode() {
        String str = this.metaTitle;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.category;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.placeholderImageUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.storeName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.footerImageUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.redirectUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<CJRAutomaticBillCategoriesHomepageLayout> list = this.homepageLayouts;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CJRAutomaticBillCategoriesResponse(metaTitle=" + this.metaTitle + ", category=" + this.category + ", placeholderImageUrl=" + this.placeholderImageUrl + ", storeName=" + this.storeName + ", footerImageUrl=" + this.footerImageUrl + ", redirectUrl=" + this.redirectUrl + ", homepageLayouts=" + this.homepageLayouts + ")";
    }

    public final String getMetaTitle() {
        return this.metaTitle;
    }

    public final void setMetaTitle(String str) {
        this.metaTitle = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getPlaceholderImageUrl() {
        return this.placeholderImageUrl;
    }

    public final void setPlaceholderImageUrl(String str) {
        this.placeholderImageUrl = str;
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final void setStoreName(String str) {
        this.storeName = str;
    }

    public final String getFooterImageUrl() {
        return this.footerImageUrl;
    }

    public final void setFooterImageUrl(String str) {
        this.footerImageUrl = str;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public CJRAutomaticBillCategoriesResponse(String str, String str2, String str3, String str4, String str5, String str6, List<CJRAutomaticBillCategoriesHomepageLayout> list) {
        this.metaTitle = str;
        this.category = str2;
        this.placeholderImageUrl = str3;
        this.storeName = str4;
        this.footerImageUrl = str5;
        this.redirectUrl = str6;
        this.homepageLayouts = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRAutomaticBillCategoriesResponse(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.List r13, int r14, kotlin.g.b.g r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.g.b.g):void");
    }

    public final List<CJRAutomaticBillCategoriesHomepageLayout> getHomepageLayouts() {
        return this.homepageLayouts;
    }

    public final void setHomepageLayouts(List<CJRAutomaticBillCategoriesHomepageLayout> list) {
        this.homepageLayouts = list;
    }
}
