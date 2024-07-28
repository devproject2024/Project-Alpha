package net.one97.paytm.p2mNewDesign.entity.mlv;

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

public final class Cart extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "address")
    private Object address;
    @b(a = "aggregate_conv_fee")
    private Double aggregateConvFee;
    @b(a = "aggregate_item_price")
    private Double aggregateItemPrice;
    @b(a = "billing_address")
    private Object billingAddress;
    @b(a = "cart_items")
    private List<CartItem> cartItems;
    @b(a = "count")
    private Integer count;
    @b(a = "customer_id")
    private Integer customerId;
    @b(a = "error")
    private Object error;
    @b(a = "error_code")
    private Object errorCode;
    @b(a = "grandtotal")
    private Double grandtotal;
    @b(a = "gstin")
    private Object gstin;
    @b(a = "is_physical")
    private Boolean isPhysical;
    @b(a = "mlv_info")
    private MLVInfo mLVInfo;
    @b(a = "paymentInfo")
    private PaymentInfo paymentInfo;
    @b(a = "payment_method")
    private String paymentMethod;
    @b(a = "pg_mid")
    private String pgMid;
    @b(a = "pos_transaction_required")
    private String posTransactionRequired;
    @b(a = "promo_failure_text")
    private Object promoFailureText;
    @b(a = "promocode")
    private Object promocode;
    @b(a = "promostatus")
    private String promostatus;
    @b(a = "promotext")
    private Object promotext;
    @b(a = "promousage")
    private Object promousage;
    @b(a = "selling_price")
    private Double sellingPrice;
    @b(a = "shipping_amount")
    private Double shippingAmount;
    @b(a = "shipping_charges")
    private Double shippingCharges;
    @b(a = "shipping_discount")
    private Double shippingDiscount;
    @b(a = "site_id")
    private Integer siteId;
    @b(a = "store_info")
    private StoreInfo storeInfo;
    @b(a = "total_price")
    private Double totalPrice;

    public Cart() {
        this((Integer) null, (String) null, (Integer) null, (Integer) null, (Boolean) null, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Object) null, (String) null, (List) null, (Object) null, (Object) null, (Object) null, (String) null, (PaymentInfo) null, (MLVInfo) null, (StoreInfo) null, (String) null, 536870911, (g) null);
    }

    public static /* synthetic */ Cart copy$default(Cart cart, Integer num, String str, Integer num2, Integer num3, Boolean bool, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Object obj6, String str2, List list, Object obj7, Object obj8, Object obj9, String str3, PaymentInfo paymentInfo2, MLVInfo mLVInfo2, StoreInfo storeInfo2, String str4, int i2, Object obj10) {
        Cart cart2 = cart;
        int i3 = i2;
        return cart.copy((i3 & 1) != 0 ? cart2.count : num, (i3 & 2) != 0 ? cart2.pgMid : str, (i3 & 4) != 0 ? cart2.customerId : num2, (i3 & 8) != 0 ? cart2.siteId : num3, (i3 & 16) != 0 ? cart2.isPhysical : bool, (i3 & 32) != 0 ? cart2.gstin : obj, (i3 & 64) != 0 ? cart2.billingAddress : obj2, (i3 & 128) != 0 ? cart2.address : obj3, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cart2.error : obj4, (i3 & 512) != 0 ? cart2.errorCode : obj5, (i3 & TarConstants.EOF_BLOCK) != 0 ? cart2.totalPrice : d2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cart2.aggregateItemPrice : d3, (i3 & 4096) != 0 ? cart2.shippingAmount : d4, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cart2.shippingCharges : d5, (i3 & 16384) != 0 ? cart2.shippingDiscount : d6, (i3 & 32768) != 0 ? cart2.grandtotal : d7, (i3 & 65536) != 0 ? cart2.sellingPrice : d8, (i3 & 131072) != 0 ? cart2.aggregateConvFee : d9, (i3 & 262144) != 0 ? cart2.promoFailureText : obj6, (i3 & 524288) != 0 ? cart2.paymentMethod : str2, (i3 & 1048576) != 0 ? cart2.cartItems : list, (i3 & 2097152) != 0 ? cart2.promocode : obj7, (i3 & 4194304) != 0 ? cart2.promotext : obj8, (i3 & 8388608) != 0 ? cart2.promousage : obj9, (i3 & 16777216) != 0 ? cart2.promostatus : str3, (i3 & 33554432) != 0 ? cart2.paymentInfo : paymentInfo2, (i3 & 67108864) != 0 ? cart2.mLVInfo : mLVInfo2, (i3 & 134217728) != 0 ? cart2.storeInfo : storeInfo2, (i3 & 268435456) != 0 ? cart2.posTransactionRequired : str4);
    }

    public final Integer component1() {
        return this.count;
    }

    public final Object component10() {
        return this.errorCode;
    }

    public final Double component11() {
        return this.totalPrice;
    }

    public final Double component12() {
        return this.aggregateItemPrice;
    }

    public final Double component13() {
        return this.shippingAmount;
    }

    public final Double component14() {
        return this.shippingCharges;
    }

    public final Double component15() {
        return this.shippingDiscount;
    }

    public final Double component16() {
        return this.grandtotal;
    }

    public final Double component17() {
        return this.sellingPrice;
    }

    public final Double component18() {
        return this.aggregateConvFee;
    }

    public final Object component19() {
        return this.promoFailureText;
    }

    public final String component2() {
        return this.pgMid;
    }

    public final String component20() {
        return this.paymentMethod;
    }

    public final List<CartItem> component21() {
        return this.cartItems;
    }

    public final Object component22() {
        return this.promocode;
    }

    public final Object component23() {
        return this.promotext;
    }

    public final Object component24() {
        return this.promousage;
    }

    public final String component25() {
        return this.promostatus;
    }

    public final PaymentInfo component26() {
        return this.paymentInfo;
    }

    public final MLVInfo component27() {
        return this.mLVInfo;
    }

    public final StoreInfo component28() {
        return this.storeInfo;
    }

    public final String component29() {
        return this.posTransactionRequired;
    }

    public final Integer component3() {
        return this.customerId;
    }

    public final Integer component4() {
        return this.siteId;
    }

    public final Boolean component5() {
        return this.isPhysical;
    }

    public final Object component6() {
        return this.gstin;
    }

    public final Object component7() {
        return this.billingAddress;
    }

    public final Object component8() {
        return this.address;
    }

    public final Object component9() {
        return this.error;
    }

    public final Cart copy(Integer num, String str, Integer num2, Integer num3, Boolean bool, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Object obj6, String str2, List<CartItem> list, Object obj7, Object obj8, Object obj9, String str3, PaymentInfo paymentInfo2, MLVInfo mLVInfo2, StoreInfo storeInfo2, String str4) {
        return new Cart(num, str, num2, num3, bool, obj, obj2, obj3, obj4, obj5, d2, d3, d4, d5, d6, d7, d8, d9, obj6, str2, list, obj7, obj8, obj9, str3, paymentInfo2, mLVInfo2, storeInfo2, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) obj;
        return k.a((Object) this.count, (Object) cart.count) && k.a((Object) this.pgMid, (Object) cart.pgMid) && k.a((Object) this.customerId, (Object) cart.customerId) && k.a((Object) this.siteId, (Object) cart.siteId) && k.a((Object) this.isPhysical, (Object) cart.isPhysical) && k.a(this.gstin, cart.gstin) && k.a(this.billingAddress, cart.billingAddress) && k.a(this.address, cart.address) && k.a(this.error, cart.error) && k.a(this.errorCode, cart.errorCode) && k.a((Object) this.totalPrice, (Object) cart.totalPrice) && k.a((Object) this.aggregateItemPrice, (Object) cart.aggregateItemPrice) && k.a((Object) this.shippingAmount, (Object) cart.shippingAmount) && k.a((Object) this.shippingCharges, (Object) cart.shippingCharges) && k.a((Object) this.shippingDiscount, (Object) cart.shippingDiscount) && k.a((Object) this.grandtotal, (Object) cart.grandtotal) && k.a((Object) this.sellingPrice, (Object) cart.sellingPrice) && k.a((Object) this.aggregateConvFee, (Object) cart.aggregateConvFee) && k.a(this.promoFailureText, cart.promoFailureText) && k.a((Object) this.paymentMethod, (Object) cart.paymentMethod) && k.a((Object) this.cartItems, (Object) cart.cartItems) && k.a(this.promocode, cart.promocode) && k.a(this.promotext, cart.promotext) && k.a(this.promousage, cart.promousage) && k.a((Object) this.promostatus, (Object) cart.promostatus) && k.a((Object) this.paymentInfo, (Object) cart.paymentInfo) && k.a((Object) this.mLVInfo, (Object) cart.mLVInfo) && k.a((Object) this.storeInfo, (Object) cart.storeInfo) && k.a((Object) this.posTransactionRequired, (Object) cart.posTransactionRequired);
    }

    public final int hashCode() {
        Integer num = this.count;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.pgMid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.customerId;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.siteId;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Boolean bool = this.isPhysical;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Object obj = this.gstin;
        int hashCode6 = (hashCode5 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.billingAddress;
        int hashCode7 = (hashCode6 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.address;
        int hashCode8 = (hashCode7 + (obj3 != null ? obj3.hashCode() : 0)) * 31;
        Object obj4 = this.error;
        int hashCode9 = (hashCode8 + (obj4 != null ? obj4.hashCode() : 0)) * 31;
        Object obj5 = this.errorCode;
        int hashCode10 = (hashCode9 + (obj5 != null ? obj5.hashCode() : 0)) * 31;
        Double d2 = this.totalPrice;
        int hashCode11 = (hashCode10 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.aggregateItemPrice;
        int hashCode12 = (hashCode11 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.shippingAmount;
        int hashCode13 = (hashCode12 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.shippingCharges;
        int hashCode14 = (hashCode13 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.shippingDiscount;
        int hashCode15 = (hashCode14 + (d6 != null ? d6.hashCode() : 0)) * 31;
        Double d7 = this.grandtotal;
        int hashCode16 = (hashCode15 + (d7 != null ? d7.hashCode() : 0)) * 31;
        Double d8 = this.sellingPrice;
        int hashCode17 = (hashCode16 + (d8 != null ? d8.hashCode() : 0)) * 31;
        Double d9 = this.aggregateConvFee;
        int hashCode18 = (hashCode17 + (d9 != null ? d9.hashCode() : 0)) * 31;
        Object obj6 = this.promoFailureText;
        int hashCode19 = (hashCode18 + (obj6 != null ? obj6.hashCode() : 0)) * 31;
        String str2 = this.paymentMethod;
        int hashCode20 = (hashCode19 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<CartItem> list = this.cartItems;
        int hashCode21 = (hashCode20 + (list != null ? list.hashCode() : 0)) * 31;
        Object obj7 = this.promocode;
        int hashCode22 = (hashCode21 + (obj7 != null ? obj7.hashCode() : 0)) * 31;
        Object obj8 = this.promotext;
        int hashCode23 = (hashCode22 + (obj8 != null ? obj8.hashCode() : 0)) * 31;
        Object obj9 = this.promousage;
        int hashCode24 = (hashCode23 + (obj9 != null ? obj9.hashCode() : 0)) * 31;
        String str3 = this.promostatus;
        int hashCode25 = (hashCode24 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PaymentInfo paymentInfo2 = this.paymentInfo;
        int hashCode26 = (hashCode25 + (paymentInfo2 != null ? paymentInfo2.hashCode() : 0)) * 31;
        MLVInfo mLVInfo2 = this.mLVInfo;
        int hashCode27 = (hashCode26 + (mLVInfo2 != null ? mLVInfo2.hashCode() : 0)) * 31;
        StoreInfo storeInfo2 = this.storeInfo;
        int hashCode28 = (hashCode27 + (storeInfo2 != null ? storeInfo2.hashCode() : 0)) * 31;
        String str4 = this.posTransactionRequired;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode28 + i2;
    }

    public final String toString() {
        return "Cart(count=" + this.count + ", pgMid=" + this.pgMid + ", customerId=" + this.customerId + ", siteId=" + this.siteId + ", isPhysical=" + this.isPhysical + ", gstin=" + this.gstin + ", billingAddress=" + this.billingAddress + ", address=" + this.address + ", error=" + this.error + ", errorCode=" + this.errorCode + ", totalPrice=" + this.totalPrice + ", aggregateItemPrice=" + this.aggregateItemPrice + ", shippingAmount=" + this.shippingAmount + ", shippingCharges=" + this.shippingCharges + ", shippingDiscount=" + this.shippingDiscount + ", grandtotal=" + this.grandtotal + ", sellingPrice=" + this.sellingPrice + ", aggregateConvFee=" + this.aggregateConvFee + ", promoFailureText=" + this.promoFailureText + ", paymentMethod=" + this.paymentMethod + ", cartItems=" + this.cartItems + ", promocode=" + this.promocode + ", promotext=" + this.promotext + ", promousage=" + this.promousage + ", promostatus=" + this.promostatus + ", paymentInfo=" + this.paymentInfo + ", mLVInfo=" + this.mLVInfo + ", storeInfo=" + this.storeInfo + ", posTransactionRequired=" + this.posTransactionRequired + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Object getAddress() {
        return this.address;
    }

    public final Object getBillingAddress() {
        return this.billingAddress;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getCustomerId() {
        return this.customerId;
    }

    public final Object getGstin() {
        return this.gstin;
    }

    public final String getPgMid() {
        return this.pgMid;
    }

    public final Integer getSiteId() {
        return this.siteId;
    }

    public final Boolean isPhysical() {
        return this.isPhysical;
    }

    public final void setAddress(Object obj) {
        this.address = obj;
    }

    public final void setBillingAddress(Object obj) {
        this.billingAddress = obj;
    }

    public final void setCount(Integer num) {
        this.count = num;
    }

    public final void setCustomerId(Integer num) {
        this.customerId = num;
    }

    public final void setGstin(Object obj) {
        this.gstin = obj;
    }

    public final void setPgMid(String str) {
        this.pgMid = str;
    }

    public final void setPhysical(Boolean bool) {
        this.isPhysical = bool;
    }

    public final void setSiteId(Integer num) {
        this.siteId = num;
    }

    public final Double getAggregateItemPrice() {
        return this.aggregateItemPrice;
    }

    public final Object getError() {
        return this.error;
    }

    public final Object getErrorCode() {
        return this.errorCode;
    }

    public final Double getShippingAmount() {
        return this.shippingAmount;
    }

    public final Double getShippingCharges() {
        return this.shippingCharges;
    }

    public final Double getShippingDiscount() {
        return this.shippingDiscount;
    }

    public final Double getTotalPrice() {
        return this.totalPrice;
    }

    public final void setAggregateItemPrice(Double d2) {
        this.aggregateItemPrice = d2;
    }

    public final void setError(Object obj) {
        this.error = obj;
    }

    public final void setErrorCode(Object obj) {
        this.errorCode = obj;
    }

    public final void setShippingAmount(Double d2) {
        this.shippingAmount = d2;
    }

    public final void setShippingCharges(Double d2) {
        this.shippingCharges = d2;
    }

    public final void setShippingDiscount(Double d2) {
        this.shippingDiscount = d2;
    }

    public final void setTotalPrice(Double d2) {
        this.totalPrice = d2;
    }

    public final Double getAggregateConvFee() {
        return this.aggregateConvFee;
    }

    public final List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public final Double getGrandtotal() {
        return this.grandtotal;
    }

    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    public final Object getPromoFailureText() {
        return this.promoFailureText;
    }

    public final Object getPromocode() {
        return this.promocode;
    }

    public final Object getPromotext() {
        return this.promotext;
    }

    public final Double getSellingPrice() {
        return this.sellingPrice;
    }

    public final void setAggregateConvFee(Double d2) {
        this.aggregateConvFee = d2;
    }

    public final void setCartItems(List<CartItem> list) {
        this.cartItems = list;
    }

    public final void setGrandtotal(Double d2) {
        this.grandtotal = d2;
    }

    public final void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public final void setPromoFailureText(Object obj) {
        this.promoFailureText = obj;
    }

    public final void setPromocode(Object obj) {
        this.promocode = obj;
    }

    public final void setPromotext(Object obj) {
        this.promotext = obj;
    }

    public final void setSellingPrice(Double d2) {
        this.sellingPrice = d2;
    }

    public Cart(Integer num, String str, Integer num2, Integer num3, Boolean bool, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Object obj6, String str2, List<CartItem> list, Object obj7, Object obj8, Object obj9, String str3, PaymentInfo paymentInfo2, MLVInfo mLVInfo2, StoreInfo storeInfo2, String str4) {
        this.count = num;
        this.pgMid = str;
        this.customerId = num2;
        this.siteId = num3;
        this.isPhysical = bool;
        this.gstin = obj;
        this.billingAddress = obj2;
        this.address = obj3;
        this.error = obj4;
        this.errorCode = obj5;
        this.totalPrice = d2;
        this.aggregateItemPrice = d3;
        this.shippingAmount = d4;
        this.shippingCharges = d5;
        this.shippingDiscount = d6;
        this.grandtotal = d7;
        this.sellingPrice = d8;
        this.aggregateConvFee = d9;
        this.promoFailureText = obj6;
        this.paymentMethod = str2;
        this.cartItems = list;
        this.promocode = obj7;
        this.promotext = obj8;
        this.promousage = obj9;
        this.promostatus = str3;
        this.paymentInfo = paymentInfo2;
        this.mLVInfo = mLVInfo2;
        this.storeInfo = storeInfo2;
        this.posTransactionRequired = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Cart(java.lang.Integer r31, java.lang.String r32, java.lang.Integer r33, java.lang.Integer r34, java.lang.Boolean r35, java.lang.Object r36, java.lang.Object r37, java.lang.Object r38, java.lang.Object r39, java.lang.Object r40, java.lang.Double r41, java.lang.Double r42, java.lang.Double r43, java.lang.Double r44, java.lang.Double r45, java.lang.Double r46, java.lang.Double r47, java.lang.Double r48, java.lang.Object r49, java.lang.String r50, java.util.List r51, java.lang.Object r52, java.lang.Object r53, java.lang.Object r54, java.lang.String r55, net.one97.paytm.p2mNewDesign.entity.mlv.PaymentInfo r56, net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r57, net.one97.paytm.p2mNewDesign.entity.mlv.StoreInfo r58, java.lang.String r59, int r60, kotlin.g.b.g r61) {
        /*
            r30 = this;
            r0 = r60
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r31
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r32
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r33
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r34
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r35
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r36
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r37
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r38
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r39
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r40
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r41
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r42
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r43
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r44
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r45
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r46
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r47
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r48
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r49
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r50
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r51
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r52
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r53
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r54
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r55
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r56
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r57
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r58
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 & r29
            if (r0 == 0) goto L_0x0112
            r0 = 0
            goto L_0x0114
        L_0x0112:
            r0 = r59
        L_0x0114:
            r31 = r30
            r32 = r1
            r33 = r3
            r34 = r4
            r35 = r5
            r36 = r6
            r37 = r7
            r38 = r8
            r39 = r9
            r40 = r10
            r41 = r11
            r42 = r12
            r43 = r13
            r44 = r14
            r45 = r15
            r46 = r2
            r47 = r16
            r48 = r17
            r49 = r18
            r50 = r19
            r51 = r20
            r52 = r21
            r53 = r22
            r54 = r23
            r55 = r24
            r56 = r25
            r57 = r26
            r58 = r27
            r59 = r28
            r60 = r0
            r31.<init>(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.Cart.<init>(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Object, java.lang.String, java.util.List, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.PaymentInfo, net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo, net.one97.paytm.p2mNewDesign.entity.mlv.StoreInfo, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final MLVInfo getMLVInfo() {
        return this.mLVInfo;
    }

    public final PaymentInfo getPaymentInfo() {
        return this.paymentInfo;
    }

    public final String getPosTransactionRequired() {
        return this.posTransactionRequired;
    }

    public final String getPromostatus() {
        return this.promostatus;
    }

    public final Object getPromousage() {
        return this.promousage;
    }

    public final StoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    public final void setMLVInfo(MLVInfo mLVInfo2) {
        this.mLVInfo = mLVInfo2;
    }

    public final void setPaymentInfo(PaymentInfo paymentInfo2) {
        this.paymentInfo = paymentInfo2;
    }

    public final void setPosTransactionRequired(String str) {
        this.posTransactionRequired = str;
    }

    public final void setPromostatus(String str) {
        this.promostatus = str;
    }

    public final void setPromousage(Object obj) {
        this.promousage = obj;
    }

    public final void setStoreInfo(StoreInfo storeInfo2) {
        this.storeInfo = storeInfo2;
    }
}
