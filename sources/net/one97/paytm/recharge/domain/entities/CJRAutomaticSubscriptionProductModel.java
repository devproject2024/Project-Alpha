package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRAutomaticSubscriptionProductModel implements IJRDataModel {
    @b(a = "attributes")
    private String attributes;
    @b(a = "circle")
    private String circle;
    @b(a = "operator")
    private String operator;
    @b(a = "paytype")
    private String paytype;
    @b(a = "product_id")
    private final long productId;
    @b(a = "service")
    private String service;
    @b(a = "thumbnail")
    private String thumbnail;

    public static /* synthetic */ CJRAutomaticSubscriptionProductModel copy$default(CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel, long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel2 = cJRAutomaticSubscriptionProductModel;
        return cJRAutomaticSubscriptionProductModel.copy((i2 & 1) != 0 ? cJRAutomaticSubscriptionProductModel2.productId : j, (i2 & 2) != 0 ? cJRAutomaticSubscriptionProductModel2.operator : str, (i2 & 4) != 0 ? cJRAutomaticSubscriptionProductModel2.circle : str2, (i2 & 8) != 0 ? cJRAutomaticSubscriptionProductModel2.paytype : str3, (i2 & 16) != 0 ? cJRAutomaticSubscriptionProductModel2.thumbnail : str4, (i2 & 32) != 0 ? cJRAutomaticSubscriptionProductModel2.service : str5, (i2 & 64) != 0 ? cJRAutomaticSubscriptionProductModel2.attributes : str6);
    }

    public final long component1() {
        return this.productId;
    }

    public final String component2() {
        return this.operator;
    }

    public final String component3() {
        return this.circle;
    }

    public final String component4() {
        return this.paytype;
    }

    public final String component5() {
        return this.thumbnail;
    }

    public final String component6() {
        return this.service;
    }

    public final String component7() {
        return this.attributes;
    }

    public final CJRAutomaticSubscriptionProductModel copy(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, StringSet.operator);
        k.c(str2, "circle");
        k.c(str3, "paytype");
        String str7 = str4;
        k.c(str7, "thumbnail");
        String str8 = str5;
        k.c(str8, "service");
        return new CJRAutomaticSubscriptionProductModel(j, str, str2, str3, str7, str8, str6);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRAutomaticSubscriptionProductModel) {
                CJRAutomaticSubscriptionProductModel cJRAutomaticSubscriptionProductModel = (CJRAutomaticSubscriptionProductModel) obj;
                if (!(this.productId == cJRAutomaticSubscriptionProductModel.productId) || !k.a((Object) this.operator, (Object) cJRAutomaticSubscriptionProductModel.operator) || !k.a((Object) this.circle, (Object) cJRAutomaticSubscriptionProductModel.circle) || !k.a((Object) this.paytype, (Object) cJRAutomaticSubscriptionProductModel.paytype) || !k.a((Object) this.thumbnail, (Object) cJRAutomaticSubscriptionProductModel.thumbnail) || !k.a((Object) this.service, (Object) cJRAutomaticSubscriptionProductModel.service) || !k.a((Object) this.attributes, (Object) cJRAutomaticSubscriptionProductModel.attributes)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.productId;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.operator;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.circle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.paytype;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.thumbnail;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.service;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.attributes;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return hashCode5 + i3;
    }

    public final String toString() {
        return "CJRAutomaticSubscriptionProductModel(productId=" + this.productId + ", operator=" + this.operator + ", circle=" + this.circle + ", paytype=" + this.paytype + ", thumbnail=" + this.thumbnail + ", service=" + this.service + ", attributes=" + this.attributes + ")";
    }

    public CJRAutomaticSubscriptionProductModel(long j, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, StringSet.operator);
        k.c(str2, "circle");
        k.c(str3, "paytype");
        k.c(str4, "thumbnail");
        k.c(str5, "service");
        this.productId = j;
        this.operator = str;
        this.circle = str2;
        this.paytype = str3;
        this.thumbnail = str4;
        this.service = str5;
        this.attributes = str6;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final void setOperator(String str) {
        k.c(str, "<set-?>");
        this.operator = str;
    }

    public final String getCircle() {
        return this.circle;
    }

    public final void setCircle(String str) {
        k.c(str, "<set-?>");
        this.circle = str;
    }

    public final String getPaytype() {
        return this.paytype;
    }

    public final void setPaytype(String str) {
        k.c(str, "<set-?>");
        this.paytype = str;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setThumbnail(String str) {
        k.c(str, "<set-?>");
        this.thumbnail = str;
    }

    public final String getService() {
        return this.service;
    }

    public final void setService(String str) {
        k.c(str, "<set-?>");
        this.service = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAutomaticSubscriptionProductModel(long j, String str, String str2, String str3, String str4, String str5, String str6, int i2, g gVar) {
        this(j, str, str2, str3, str4, str5, (i2 & 64) != 0 ? null : str6);
    }

    public final String getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(String str) {
        this.attributes = str;
    }
}
