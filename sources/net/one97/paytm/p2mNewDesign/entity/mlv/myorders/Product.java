package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class Product extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "attributes")
    private Attributes attributes;
    @b(a = "brand")
    private String brand;
    @b(a = "category_id")
    private String categoryId;
    @b(a = "categoryMap")
    private List<CategoryMap> categoryMap;
    @b(a = "display_brand")
    private String displayBrand;
    @b(a = "ga_key")
    private String gaKey;
    @b(a = "id")
    private String id;
    @b(a = "image")
    private Object image;
    @b(a = "image_url")
    private Object imageUrl;
    @b(a = "installation_info")
    private InstallationInfo installationInfo;
    @b(a = "merchant_name")
    private String merchantName;
    @b(a = "name")
    private String name;
    @b(a = "need_shipping")
    private Boolean needShipping;
    @b(a = "newurl")
    private String newurl;
    @b(a = "parent_id")
    private Object parentId;
    @b(a = "price")
    private Double price;
    @b(a = "product_type")
    private String productType;
    @b(a = "return_policy_text")
    private String returnPolicyText;
    @b(a = "seourl")
    private String seourl;
    @b(a = "tag")
    private Object tag;
    @b(a = "thumbnail")
    private String thumbnail;
    @b(a = "type")
    private String type;
    @b(a = "url")
    private String url;
    @b(a = "vertical_id")
    private String verticalId;
    @b(a = "vertical_label")
    private String verticalLabel;
    @b(a = "warranty_details_v2")
    private Object warrantyDetailsV2;

    public Product() {
        this((String) null, (String) null, (Object) null, (Object) null, (String) null, (String) null, (String) null, (String) null, (Object) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Object) null, (String) null, (Boolean) null, (String) null, (Object) null, (String) null, (Attributes) null, (InstallationInfo) null, 67108863, (g) null);
    }

    public static /* synthetic */ Product copy$default(Product product, String str, String str2, Object obj, Object obj2, String str3, String str4, String str5, String str6, Object obj3, Double d2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List list, Object obj4, String str14, Boolean bool, String str15, Object obj5, String str16, Attributes attributes2, InstallationInfo installationInfo2, int i2, Object obj6) {
        Product product2 = product;
        int i3 = i2;
        return product.copy((i3 & 1) != 0 ? product2.id : str, (i3 & 2) != 0 ? product2.name : str2, (i3 & 4) != 0 ? product2.parentId : obj, (i3 & 8) != 0 ? product2.image : obj2, (i3 & 16) != 0 ? product2.thumbnail : str3, (i3 & 32) != 0 ? product2.merchantName : str4, (i3 & 64) != 0 ? product2.url : str5, (i3 & 128) != 0 ? product2.type : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? product2.tag : obj3, (i3 & 512) != 0 ? product2.price : d2, (i3 & TarConstants.EOF_BLOCK) != 0 ? product2.brand : str7, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? product2.seourl : str8, (i3 & 4096) != 0 ? product2.newurl : str9, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? product2.verticalId : str10, (i3 & 16384) != 0 ? product2.categoryId : str11, (i3 & 32768) != 0 ? product2.verticalLabel : str12, (i3 & 65536) != 0 ? product2.returnPolicyText : str13, (i3 & 131072) != 0 ? product2.categoryMap : list, (i3 & 262144) != 0 ? product2.warrantyDetailsV2 : obj4, (i3 & 524288) != 0 ? product2.productType : str14, (i3 & 1048576) != 0 ? product2.needShipping : bool, (i3 & 2097152) != 0 ? product2.displayBrand : str15, (i3 & 4194304) != 0 ? product2.imageUrl : obj5, (i3 & 8388608) != 0 ? product2.gaKey : str16, (i3 & 16777216) != 0 ? product2.attributes : attributes2, (i3 & 33554432) != 0 ? product2.installationInfo : installationInfo2);
    }

    public final String component1() {
        return this.id;
    }

    public final Double component10() {
        return this.price;
    }

    public final String component11() {
        return this.brand;
    }

    public final String component12() {
        return this.seourl;
    }

    public final String component13() {
        return this.newurl;
    }

    public final String component14() {
        return this.verticalId;
    }

    public final String component15() {
        return this.categoryId;
    }

    public final String component16() {
        return this.verticalLabel;
    }

    public final String component17() {
        return this.returnPolicyText;
    }

    public final List<CategoryMap> component18() {
        return this.categoryMap;
    }

    public final Object component19() {
        return this.warrantyDetailsV2;
    }

    public final String component2() {
        return this.name;
    }

    public final String component20() {
        return this.productType;
    }

    public final Boolean component21() {
        return this.needShipping;
    }

    public final String component22() {
        return this.displayBrand;
    }

    public final Object component23() {
        return this.imageUrl;
    }

    public final String component24() {
        return this.gaKey;
    }

    public final Attributes component25() {
        return this.attributes;
    }

    public final InstallationInfo component26() {
        return this.installationInfo;
    }

    public final Object component3() {
        return this.parentId;
    }

    public final Object component4() {
        return this.image;
    }

    public final String component5() {
        return this.thumbnail;
    }

    public final String component6() {
        return this.merchantName;
    }

    public final String component7() {
        return this.url;
    }

    public final String component8() {
        return this.type;
    }

    public final Object component9() {
        return this.tag;
    }

    public final Product copy(String str, String str2, Object obj, Object obj2, String str3, String str4, String str5, String str6, Object obj3, Double d2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<CategoryMap> list, Object obj4, String str14, Boolean bool, String str15, Object obj5, String str16, Attributes attributes2, InstallationInfo installationInfo2) {
        return new Product(str, str2, obj, obj2, str3, str4, str5, str6, obj3, d2, str7, str8, str9, str10, str11, str12, str13, list, obj4, str14, bool, str15, obj5, str16, attributes2, installationInfo2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return k.a((Object) this.id, (Object) product.id) && k.a((Object) this.name, (Object) product.name) && k.a(this.parentId, product.parentId) && k.a(this.image, product.image) && k.a((Object) this.thumbnail, (Object) product.thumbnail) && k.a((Object) this.merchantName, (Object) product.merchantName) && k.a((Object) this.url, (Object) product.url) && k.a((Object) this.type, (Object) product.type) && k.a(this.tag, product.tag) && k.a((Object) this.price, (Object) product.price) && k.a((Object) this.brand, (Object) product.brand) && k.a((Object) this.seourl, (Object) product.seourl) && k.a((Object) this.newurl, (Object) product.newurl) && k.a((Object) this.verticalId, (Object) product.verticalId) && k.a((Object) this.categoryId, (Object) product.categoryId) && k.a((Object) this.verticalLabel, (Object) product.verticalLabel) && k.a((Object) this.returnPolicyText, (Object) product.returnPolicyText) && k.a((Object) this.categoryMap, (Object) product.categoryMap) && k.a(this.warrantyDetailsV2, product.warrantyDetailsV2) && k.a((Object) this.productType, (Object) product.productType) && k.a((Object) this.needShipping, (Object) product.needShipping) && k.a((Object) this.displayBrand, (Object) product.displayBrand) && k.a(this.imageUrl, product.imageUrl) && k.a((Object) this.gaKey, (Object) product.gaKey) && k.a((Object) this.attributes, (Object) product.attributes) && k.a((Object) this.installationInfo, (Object) product.installationInfo);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.parentId;
        int hashCode3 = (hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.image;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        String str3 = this.thumbnail;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.merchantName;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.url;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.type;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Object obj3 = this.tag;
        int hashCode9 = (hashCode8 + (obj3 != null ? obj3.hashCode() : 0)) * 31;
        Double d2 = this.price;
        int hashCode10 = (hashCode9 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str7 = this.brand;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.seourl;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.newurl;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.verticalId;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.categoryId;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.verticalLabel;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.returnPolicyText;
        int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 31;
        List<CategoryMap> list = this.categoryMap;
        int hashCode18 = (hashCode17 + (list != null ? list.hashCode() : 0)) * 31;
        Object obj4 = this.warrantyDetailsV2;
        int hashCode19 = (hashCode18 + (obj4 != null ? obj4.hashCode() : 0)) * 31;
        String str14 = this.productType;
        int hashCode20 = (hashCode19 + (str14 != null ? str14.hashCode() : 0)) * 31;
        Boolean bool = this.needShipping;
        int hashCode21 = (hashCode20 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str15 = this.displayBrand;
        int hashCode22 = (hashCode21 + (str15 != null ? str15.hashCode() : 0)) * 31;
        Object obj5 = this.imageUrl;
        int hashCode23 = (hashCode22 + (obj5 != null ? obj5.hashCode() : 0)) * 31;
        String str16 = this.gaKey;
        int hashCode24 = (hashCode23 + (str16 != null ? str16.hashCode() : 0)) * 31;
        Attributes attributes2 = this.attributes;
        int hashCode25 = (hashCode24 + (attributes2 != null ? attributes2.hashCode() : 0)) * 31;
        InstallationInfo installationInfo2 = this.installationInfo;
        if (installationInfo2 != null) {
            i2 = installationInfo2.hashCode();
        }
        return hashCode25 + i2;
    }

    public final String toString() {
        return "Product(id=" + this.id + ", name=" + this.name + ", parentId=" + this.parentId + ", image=" + this.image + ", thumbnail=" + this.thumbnail + ", merchantName=" + this.merchantName + ", url=" + this.url + ", type=" + this.type + ", tag=" + this.tag + ", price=" + this.price + ", brand=" + this.brand + ", seourl=" + this.seourl + ", newurl=" + this.newurl + ", verticalId=" + this.verticalId + ", categoryId=" + this.categoryId + ", verticalLabel=" + this.verticalLabel + ", returnPolicyText=" + this.returnPolicyText + ", categoryMap=" + this.categoryMap + ", warrantyDetailsV2=" + this.warrantyDetailsV2 + ", productType=" + this.productType + ", needShipping=" + this.needShipping + ", displayBrand=" + this.displayBrand + ", imageUrl=" + this.imageUrl + ", gaKey=" + this.gaKey + ", attributes=" + this.attributes + ", installationInfo=" + this.installationInfo + ")";
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

    public final Object getParentId() {
        return this.parentId;
    }

    public final void setParentId(Object obj) {
        this.parentId = obj;
    }

    public final Object getImage() {
        return this.image;
    }

    public final void setImage(Object obj) {
        this.image = obj;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final void setPrice(Double d2) {
        this.price = d2;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final String getSeourl() {
        return this.seourl;
    }

    public final void setSeourl(String str) {
        this.seourl = str;
    }

    public final String getNewurl() {
        return this.newurl;
    }

    public final void setNewurl(String str) {
        this.newurl = str;
    }

    public final String getVerticalId() {
        return this.verticalId;
    }

    public final void setVerticalId(String str) {
        this.verticalId = str;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(String str) {
        this.categoryId = str;
    }

    public final String getVerticalLabel() {
        return this.verticalLabel;
    }

    public final void setVerticalLabel(String str) {
        this.verticalLabel = str;
    }

    public final String getReturnPolicyText() {
        return this.returnPolicyText;
    }

    public final void setReturnPolicyText(String str) {
        this.returnPolicyText = str;
    }

    public final List<CategoryMap> getCategoryMap() {
        return this.categoryMap;
    }

    public final void setCategoryMap(List<CategoryMap> list) {
        this.categoryMap = list;
    }

    public final Object getWarrantyDetailsV2() {
        return this.warrantyDetailsV2;
    }

    public final void setWarrantyDetailsV2(Object obj) {
        this.warrantyDetailsV2 = obj;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final void setProductType(String str) {
        this.productType = str;
    }

    public final Boolean getNeedShipping() {
        return this.needShipping;
    }

    public final void setNeedShipping(Boolean bool) {
        this.needShipping = bool;
    }

    public final String getDisplayBrand() {
        return this.displayBrand;
    }

    public final void setDisplayBrand(String str) {
        this.displayBrand = str;
    }

    public final Object getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(Object obj) {
        this.imageUrl = obj;
    }

    public final String getGaKey() {
        return this.gaKey;
    }

    public final void setGaKey(String str) {
        this.gaKey = str;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(Attributes attributes2) {
        this.attributes = attributes2;
    }

    public Product(String str, String str2, Object obj, Object obj2, String str3, String str4, String str5, String str6, Object obj3, Double d2, String str7, String str8, String str9, String str10, String str11, String str12, String str13, List<CategoryMap> list, Object obj4, String str14, Boolean bool, String str15, Object obj5, String str16, Attributes attributes2, InstallationInfo installationInfo2) {
        this.id = str;
        this.name = str2;
        this.parentId = obj;
        this.image = obj2;
        this.thumbnail = str3;
        this.merchantName = str4;
        this.url = str5;
        this.type = str6;
        this.tag = obj3;
        this.price = d2;
        this.brand = str7;
        this.seourl = str8;
        this.newurl = str9;
        this.verticalId = str10;
        this.categoryId = str11;
        this.verticalLabel = str12;
        this.returnPolicyText = str13;
        this.categoryMap = list;
        this.warrantyDetailsV2 = obj4;
        this.productType = str14;
        this.needShipping = bool;
        this.displayBrand = str15;
        this.imageUrl = obj5;
        this.gaKey = str16;
        this.attributes = attributes2;
        this.installationInfo = installationInfo2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Product(java.lang.String r28, java.lang.String r29, java.lang.Object r30, java.lang.Object r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Object r36, java.lang.Double r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.util.List r45, java.lang.Object r46, java.lang.String r47, java.lang.Boolean r48, java.lang.String r49, java.lang.Object r50, java.lang.String r51, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Attributes r52, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.InstallationInfo r53, int r54, kotlin.g.b.g r55) {
        /*
            r27 = this;
            r0 = r54
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r28
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r29
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r30
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r31
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r32
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r33
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r34
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r35
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r36
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r37
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r38
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r39
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r40
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r41
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r42
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r43
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r44
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r45
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r46
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r47
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r48
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r49
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r50
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r51
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r52
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 & r26
            if (r0 == 0) goto L_0x00f1
            r0 = 0
            goto L_0x00f3
        L_0x00f1:
            r0 = r53
        L_0x00f3:
            r28 = r27
            r29 = r1
            r30 = r3
            r31 = r4
            r32 = r5
            r33 = r6
            r34 = r7
            r35 = r8
            r36 = r9
            r37 = r10
            r38 = r11
            r39 = r12
            r40 = r13
            r41 = r14
            r42 = r15
            r43 = r2
            r44 = r16
            r45 = r17
            r46 = r18
            r47 = r19
            r48 = r20
            r49 = r21
            r50 = r22
            r51 = r23
            r52 = r24
            r53 = r25
            r54 = r0
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Product.<init>(java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Object, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Object, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Attributes, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.InstallationInfo, int, kotlin.g.b.g):void");
    }

    public final InstallationInfo getInstallationInfo() {
        return this.installationInfo;
    }

    public final void setInstallationInfo(InstallationInfo installationInfo2) {
        this.installationInfo = installationInfo2;
    }
}
