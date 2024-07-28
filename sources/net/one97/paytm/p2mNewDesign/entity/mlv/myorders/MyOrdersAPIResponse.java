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

public final class MyOrdersAPIResponse extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "aggregate_item_price")
    private Double aggregateItemPrice;
    @b(a = "cashback_label")
    private String cashbackLabel;
    @b(a = "channel_id")
    private String channelId;
    @b(a = "created_at")
    private String createdAt;
    @b(a = "customer_id")
    private String customerId;
    @b(a = "discount_amount")
    private Double discountAmount;
    @b(a = "footer")
    private Footer footer;
    @b(a = "grandtotal")
    private Double grandtotal;
    @b(a = "id")
    private String id;
    @b(a = "is_booking")
    private Boolean isBooking;
    @b(a = "is_payment_initiated")
    private String isPaymentInitiated;
    @b(a = "is_physical")
    private Boolean isPhysical;
    @b(a = "items")
    private List<Item> items;
    @b(a = "mlv_info")
    private List<MlvInfo2> mlvInfo;
    @b(a = "need_shipping")
    private Boolean needShipping;
    @b(a = "order_discount")
    private Double orderDiscount;
    @b(a = "order_payment_summary")
    private String orderPaymentSummary;
    @b(a = "order_status")
    private Integer orderStatus;
    @b(a = "order_type")
    private String orderType;
    @b(a = "pay_modes")
    private List<PayMode> payModes;
    @b(a = "payment_status")
    private String paymentStatus;
    @b(a = "payment_summary")
    private String paymentSummary;
    @b(a = "payment_text")
    private String paymentText;
    @b(a = "payments")
    private List<Payment> payments;
    @b(a = "pos_txn_message")
    private final String posTxnMessage;
    @b(a = "pos_txn_required")
    private final String posTxnRequired;
    @b(a = "product_promise_logo_url")
    private String productPromiseLogoUrl;
    @b(a = "refund_source_text")
    private String refundSourceText;
    @b(a = "remote_ip")
    private String remoteIp;
    @b(a = "selling_price")
    private Double sellingPrice;
    @b(a = "shipping_address")
    private ShippingAddress shippingAddress;
    @b(a = "shipping_amount")
    private Double shippingAmount;
    @b(a = "shipping_charges")
    private Double shippingCharges;
    @b(a = "shipping_discount")
    private Double shippingDiscount;
    @b(a = "site_wide_offer")
    private SiteWideOffer siteWideOffer;
    @b(a = "status")
    private String status;
    @b(a = "status_icon")
    private String statusIcon;
    @b(a = "subtotal")
    private Double subtotal;
    @b(a = "total_cashback")
    private String totalCashback;
    @b(a = "total_conv_fee")
    private Double totalConvFee;
    @b(a = "total_otherTaxes")
    private List<? extends Object> totalOtherTaxes;
    @b(a = "transaction_details")
    private List<TransactionDetail> transactionDetails;

    public MyOrdersAPIResponse() {
        this((String) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (List) null, (List) null, (Double) null, (Double) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (List) null, (List) null, (List) null, (List) null, (String) null, (Footer) null, (ShippingAddress) null, (String) null, (String) null, (SiteWideOffer) null, -1, 1023, (g) null);
    }

    public static /* synthetic */ MyOrdersAPIResponse copy$default(MyOrdersAPIResponse myOrdersAPIResponse, String str, String str2, Double d2, Double d3, Double d4, Double d5, Double d6, String str3, Double d7, String str4, String str5, String str6, String str7, Integer num, Double d8, Double d9, String str8, String str9, String str10, String str11, Boolean bool, String str12, String str13, List list, List list2, Double d10, Double d11, String str14, Boolean bool2, Boolean bool3, String str15, String str16, List list3, List list4, List list5, List list6, String str17, Footer footer2, ShippingAddress shippingAddress2, String str18, String str19, SiteWideOffer siteWideOffer2, int i2, int i3, Object obj) {
        MyOrdersAPIResponse myOrdersAPIResponse2 = myOrdersAPIResponse;
        int i4 = i2;
        int i5 = i3;
        return myOrdersAPIResponse.copy((i4 & 1) != 0 ? myOrdersAPIResponse2.id : str, (i4 & 2) != 0 ? myOrdersAPIResponse2.status : str2, (i4 & 4) != 0 ? myOrdersAPIResponse2.subtotal : d2, (i4 & 8) != 0 ? myOrdersAPIResponse2.orderDiscount : d3, (i4 & 16) != 0 ? myOrdersAPIResponse2.shippingCharges : d4, (i4 & 32) != 0 ? myOrdersAPIResponse2.shippingAmount : d5, (i4 & 64) != 0 ? myOrdersAPIResponse2.grandtotal : d6, (i4 & 128) != 0 ? myOrdersAPIResponse2.paymentStatus : str3, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? myOrdersAPIResponse2.sellingPrice : d7, (i4 & 512) != 0 ? myOrdersAPIResponse2.channelId : str4, (i4 & TarConstants.EOF_BLOCK) != 0 ? myOrdersAPIResponse2.customerId : str5, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? myOrdersAPIResponse2.createdAt : str6, (i4 & 4096) != 0 ? myOrdersAPIResponse2.refundSourceText : str7, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? myOrdersAPIResponse2.orderStatus : num, (i4 & 16384) != 0 ? myOrdersAPIResponse2.discountAmount : d8, (i4 & 32768) != 0 ? myOrdersAPIResponse2.shippingDiscount : d9, (i4 & 65536) != 0 ? myOrdersAPIResponse2.paymentSummary : str8, (i4 & 131072) != 0 ? myOrdersAPIResponse2.orderPaymentSummary : str9, (i4 & 262144) != 0 ? myOrdersAPIResponse2.paymentText : str10, (i4 & 524288) != 0 ? myOrdersAPIResponse2.statusIcon : str11, (i4 & 1048576) != 0 ? myOrdersAPIResponse2.needShipping : bool, (i4 & 2097152) != 0 ? myOrdersAPIResponse2.remoteIp : str12, (i4 & 4194304) != 0 ? myOrdersAPIResponse2.orderType : str13, (i4 & 8388608) != 0 ? myOrdersAPIResponse2.items : list, (i4 & 16777216) != 0 ? myOrdersAPIResponse2.totalOtherTaxes : list2, (i4 & 33554432) != 0 ? myOrdersAPIResponse2.totalConvFee : d10, (i4 & 67108864) != 0 ? myOrdersAPIResponse2.aggregateItemPrice : d11, (i4 & 134217728) != 0 ? myOrdersAPIResponse2.productPromiseLogoUrl : str14, (i4 & 268435456) != 0 ? myOrdersAPIResponse2.isPhysical : bool2, (i4 & 536870912) != 0 ? myOrdersAPIResponse2.isBooking : bool3, (i4 & 1073741824) != 0 ? myOrdersAPIResponse2.posTxnRequired : str15, (i4 & Integer.MIN_VALUE) != 0 ? myOrdersAPIResponse2.posTxnMessage : str16, (i5 & 1) != 0 ? myOrdersAPIResponse2.payments : list3, (i5 & 2) != 0 ? myOrdersAPIResponse2.mlvInfo : list4, (i5 & 4) != 0 ? myOrdersAPIResponse2.transactionDetails : list5, (i5 & 8) != 0 ? myOrdersAPIResponse2.payModes : list6, (i5 & 16) != 0 ? myOrdersAPIResponse2.isPaymentInitiated : str17, (i5 & 32) != 0 ? myOrdersAPIResponse2.footer : footer2, (i5 & 64) != 0 ? myOrdersAPIResponse2.shippingAddress : shippingAddress2, (i5 & 128) != 0 ? myOrdersAPIResponse2.totalCashback : str18, (i5 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? myOrdersAPIResponse2.cashbackLabel : str19, (i5 & 512) != 0 ? myOrdersAPIResponse2.siteWideOffer : siteWideOffer2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.channelId;
    }

    public final String component11() {
        return this.customerId;
    }

    public final String component12() {
        return this.createdAt;
    }

    public final String component13() {
        return this.refundSourceText;
    }

    public final Integer component14() {
        return this.orderStatus;
    }

    public final Double component15() {
        return this.discountAmount;
    }

    public final Double component16() {
        return this.shippingDiscount;
    }

    public final String component17() {
        return this.paymentSummary;
    }

    public final String component18() {
        return this.orderPaymentSummary;
    }

    public final String component19() {
        return this.paymentText;
    }

    public final String component2() {
        return this.status;
    }

    public final String component20() {
        return this.statusIcon;
    }

    public final Boolean component21() {
        return this.needShipping;
    }

    public final String component22() {
        return this.remoteIp;
    }

    public final String component23() {
        return this.orderType;
    }

    public final List<Item> component24() {
        return this.items;
    }

    public final List<Object> component25() {
        return this.totalOtherTaxes;
    }

    public final Double component26() {
        return this.totalConvFee;
    }

    public final Double component27() {
        return this.aggregateItemPrice;
    }

    public final String component28() {
        return this.productPromiseLogoUrl;
    }

    public final Boolean component29() {
        return this.isPhysical;
    }

    public final Double component3() {
        return this.subtotal;
    }

    public final Boolean component30() {
        return this.isBooking;
    }

    public final String component31() {
        return this.posTxnRequired;
    }

    public final String component32() {
        return this.posTxnMessage;
    }

    public final List<Payment> component33() {
        return this.payments;
    }

    public final List<MlvInfo2> component34() {
        return this.mlvInfo;
    }

    public final List<TransactionDetail> component35() {
        return this.transactionDetails;
    }

    public final List<PayMode> component36() {
        return this.payModes;
    }

    public final String component37() {
        return this.isPaymentInitiated;
    }

    public final Footer component38() {
        return this.footer;
    }

    public final ShippingAddress component39() {
        return this.shippingAddress;
    }

    public final Double component4() {
        return this.orderDiscount;
    }

    public final String component40() {
        return this.totalCashback;
    }

    public final String component41() {
        return this.cashbackLabel;
    }

    public final SiteWideOffer component42() {
        return this.siteWideOffer;
    }

    public final Double component5() {
        return this.shippingCharges;
    }

    public final Double component6() {
        return this.shippingAmount;
    }

    public final Double component7() {
        return this.grandtotal;
    }

    public final String component8() {
        return this.paymentStatus;
    }

    public final Double component9() {
        return this.sellingPrice;
    }

    public final MyOrdersAPIResponse copy(String str, String str2, Double d2, Double d3, Double d4, Double d5, Double d6, String str3, Double d7, String str4, String str5, String str6, String str7, Integer num, Double d8, Double d9, String str8, String str9, String str10, String str11, Boolean bool, String str12, String str13, List<Item> list, List<? extends Object> list2, Double d10, Double d11, String str14, Boolean bool2, Boolean bool3, String str15, String str16, List<Payment> list3, List<MlvInfo2> list4, List<TransactionDetail> list5, List<PayMode> list6, String str17, Footer footer2, ShippingAddress shippingAddress2, String str18, String str19, SiteWideOffer siteWideOffer2) {
        return new MyOrdersAPIResponse(str, str2, d2, d3, d4, d5, d6, str3, d7, str4, str5, str6, str7, num, d8, d9, str8, str9, str10, str11, bool, str12, str13, list, list2, d10, d11, str14, bool2, bool3, str15, str16, list3, list4, list5, list6, str17, footer2, shippingAddress2, str18, str19, siteWideOffer2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyOrdersAPIResponse)) {
            return false;
        }
        MyOrdersAPIResponse myOrdersAPIResponse = (MyOrdersAPIResponse) obj;
        return k.a((Object) this.id, (Object) myOrdersAPIResponse.id) && k.a((Object) this.status, (Object) myOrdersAPIResponse.status) && k.a((Object) this.subtotal, (Object) myOrdersAPIResponse.subtotal) && k.a((Object) this.orderDiscount, (Object) myOrdersAPIResponse.orderDiscount) && k.a((Object) this.shippingCharges, (Object) myOrdersAPIResponse.shippingCharges) && k.a((Object) this.shippingAmount, (Object) myOrdersAPIResponse.shippingAmount) && k.a((Object) this.grandtotal, (Object) myOrdersAPIResponse.grandtotal) && k.a((Object) this.paymentStatus, (Object) myOrdersAPIResponse.paymentStatus) && k.a((Object) this.sellingPrice, (Object) myOrdersAPIResponse.sellingPrice) && k.a((Object) this.channelId, (Object) myOrdersAPIResponse.channelId) && k.a((Object) this.customerId, (Object) myOrdersAPIResponse.customerId) && k.a((Object) this.createdAt, (Object) myOrdersAPIResponse.createdAt) && k.a((Object) this.refundSourceText, (Object) myOrdersAPIResponse.refundSourceText) && k.a((Object) this.orderStatus, (Object) myOrdersAPIResponse.orderStatus) && k.a((Object) this.discountAmount, (Object) myOrdersAPIResponse.discountAmount) && k.a((Object) this.shippingDiscount, (Object) myOrdersAPIResponse.shippingDiscount) && k.a((Object) this.paymentSummary, (Object) myOrdersAPIResponse.paymentSummary) && k.a((Object) this.orderPaymentSummary, (Object) myOrdersAPIResponse.orderPaymentSummary) && k.a((Object) this.paymentText, (Object) myOrdersAPIResponse.paymentText) && k.a((Object) this.statusIcon, (Object) myOrdersAPIResponse.statusIcon) && k.a((Object) this.needShipping, (Object) myOrdersAPIResponse.needShipping) && k.a((Object) this.remoteIp, (Object) myOrdersAPIResponse.remoteIp) && k.a((Object) this.orderType, (Object) myOrdersAPIResponse.orderType) && k.a((Object) this.items, (Object) myOrdersAPIResponse.items) && k.a((Object) this.totalOtherTaxes, (Object) myOrdersAPIResponse.totalOtherTaxes) && k.a((Object) this.totalConvFee, (Object) myOrdersAPIResponse.totalConvFee) && k.a((Object) this.aggregateItemPrice, (Object) myOrdersAPIResponse.aggregateItemPrice) && k.a((Object) this.productPromiseLogoUrl, (Object) myOrdersAPIResponse.productPromiseLogoUrl) && k.a((Object) this.isPhysical, (Object) myOrdersAPIResponse.isPhysical) && k.a((Object) this.isBooking, (Object) myOrdersAPIResponse.isBooking) && k.a((Object) this.posTxnRequired, (Object) myOrdersAPIResponse.posTxnRequired) && k.a((Object) this.posTxnMessage, (Object) myOrdersAPIResponse.posTxnMessage) && k.a((Object) this.payments, (Object) myOrdersAPIResponse.payments) && k.a((Object) this.mlvInfo, (Object) myOrdersAPIResponse.mlvInfo) && k.a((Object) this.transactionDetails, (Object) myOrdersAPIResponse.transactionDetails) && k.a((Object) this.payModes, (Object) myOrdersAPIResponse.payModes) && k.a((Object) this.isPaymentInitiated, (Object) myOrdersAPIResponse.isPaymentInitiated) && k.a((Object) this.footer, (Object) myOrdersAPIResponse.footer) && k.a((Object) this.shippingAddress, (Object) myOrdersAPIResponse.shippingAddress) && k.a((Object) this.totalCashback, (Object) myOrdersAPIResponse.totalCashback) && k.a((Object) this.cashbackLabel, (Object) myOrdersAPIResponse.cashbackLabel) && k.a((Object) this.siteWideOffer, (Object) myOrdersAPIResponse.siteWideOffer);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.subtotal;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.orderDiscount;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.shippingCharges;
        int hashCode5 = (hashCode4 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.shippingAmount;
        int hashCode6 = (hashCode5 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.grandtotal;
        int hashCode7 = (hashCode6 + (d6 != null ? d6.hashCode() : 0)) * 31;
        String str3 = this.paymentStatus;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d7 = this.sellingPrice;
        int hashCode9 = (hashCode8 + (d7 != null ? d7.hashCode() : 0)) * 31;
        String str4 = this.channelId;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.customerId;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.createdAt;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.refundSourceText;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num = this.orderStatus;
        int hashCode14 = (hashCode13 + (num != null ? num.hashCode() : 0)) * 31;
        Double d8 = this.discountAmount;
        int hashCode15 = (hashCode14 + (d8 != null ? d8.hashCode() : 0)) * 31;
        Double d9 = this.shippingDiscount;
        int hashCode16 = (hashCode15 + (d9 != null ? d9.hashCode() : 0)) * 31;
        String str8 = this.paymentSummary;
        int hashCode17 = (hashCode16 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.orderPaymentSummary;
        int hashCode18 = (hashCode17 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.paymentText;
        int hashCode19 = (hashCode18 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.statusIcon;
        int hashCode20 = (hashCode19 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Boolean bool = this.needShipping;
        int hashCode21 = (hashCode20 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str12 = this.remoteIp;
        int hashCode22 = (hashCode21 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.orderType;
        int hashCode23 = (hashCode22 + (str13 != null ? str13.hashCode() : 0)) * 31;
        List<Item> list = this.items;
        int hashCode24 = (hashCode23 + (list != null ? list.hashCode() : 0)) * 31;
        List<? extends Object> list2 = this.totalOtherTaxes;
        int hashCode25 = (hashCode24 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Double d10 = this.totalConvFee;
        int hashCode26 = (hashCode25 + (d10 != null ? d10.hashCode() : 0)) * 31;
        Double d11 = this.aggregateItemPrice;
        int hashCode27 = (hashCode26 + (d11 != null ? d11.hashCode() : 0)) * 31;
        String str14 = this.productPromiseLogoUrl;
        int hashCode28 = (hashCode27 + (str14 != null ? str14.hashCode() : 0)) * 31;
        Boolean bool2 = this.isPhysical;
        int hashCode29 = (hashCode28 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isBooking;
        int hashCode30 = (hashCode29 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str15 = this.posTxnRequired;
        int hashCode31 = (hashCode30 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.posTxnMessage;
        int hashCode32 = (hashCode31 + (str16 != null ? str16.hashCode() : 0)) * 31;
        List<Payment> list3 = this.payments;
        int hashCode33 = (hashCode32 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<MlvInfo2> list4 = this.mlvInfo;
        int hashCode34 = (hashCode33 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<TransactionDetail> list5 = this.transactionDetails;
        int hashCode35 = (hashCode34 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<PayMode> list6 = this.payModes;
        int hashCode36 = (hashCode35 + (list6 != null ? list6.hashCode() : 0)) * 31;
        String str17 = this.isPaymentInitiated;
        int hashCode37 = (hashCode36 + (str17 != null ? str17.hashCode() : 0)) * 31;
        Footer footer2 = this.footer;
        int hashCode38 = (hashCode37 + (footer2 != null ? footer2.hashCode() : 0)) * 31;
        ShippingAddress shippingAddress2 = this.shippingAddress;
        int hashCode39 = (hashCode38 + (shippingAddress2 != null ? shippingAddress2.hashCode() : 0)) * 31;
        String str18 = this.totalCashback;
        int hashCode40 = (hashCode39 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.cashbackLabel;
        int hashCode41 = (hashCode40 + (str19 != null ? str19.hashCode() : 0)) * 31;
        SiteWideOffer siteWideOffer2 = this.siteWideOffer;
        if (siteWideOffer2 != null) {
            i2 = siteWideOffer2.hashCode();
        }
        return hashCode41 + i2;
    }

    public final String toString() {
        return "MyOrdersAPIResponse(id=" + this.id + ", status=" + this.status + ", subtotal=" + this.subtotal + ", orderDiscount=" + this.orderDiscount + ", shippingCharges=" + this.shippingCharges + ", shippingAmount=" + this.shippingAmount + ", grandtotal=" + this.grandtotal + ", paymentStatus=" + this.paymentStatus + ", sellingPrice=" + this.sellingPrice + ", channelId=" + this.channelId + ", customerId=" + this.customerId + ", createdAt=" + this.createdAt + ", refundSourceText=" + this.refundSourceText + ", orderStatus=" + this.orderStatus + ", discountAmount=" + this.discountAmount + ", shippingDiscount=" + this.shippingDiscount + ", paymentSummary=" + this.paymentSummary + ", orderPaymentSummary=" + this.orderPaymentSummary + ", paymentText=" + this.paymentText + ", statusIcon=" + this.statusIcon + ", needShipping=" + this.needShipping + ", remoteIp=" + this.remoteIp + ", orderType=" + this.orderType + ", items=" + this.items + ", totalOtherTaxes=" + this.totalOtherTaxes + ", totalConvFee=" + this.totalConvFee + ", aggregateItemPrice=" + this.aggregateItemPrice + ", productPromiseLogoUrl=" + this.productPromiseLogoUrl + ", isPhysical=" + this.isPhysical + ", isBooking=" + this.isBooking + ", posTxnRequired=" + this.posTxnRequired + ", posTxnMessage=" + this.posTxnMessage + ", payments=" + this.payments + ", mlvInfo=" + this.mlvInfo + ", transactionDetails=" + this.transactionDetails + ", payModes=" + this.payModes + ", isPaymentInitiated=" + this.isPaymentInitiated + ", footer=" + this.footer + ", shippingAddress=" + this.shippingAddress + ", totalCashback=" + this.totalCashback + ", cashbackLabel=" + this.cashbackLabel + ", siteWideOffer=" + this.siteWideOffer + ")";
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

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final Double getSubtotal() {
        return this.subtotal;
    }

    public final void setSubtotal(Double d2) {
        this.subtotal = d2;
    }

    public final Double getOrderDiscount() {
        return this.orderDiscount;
    }

    public final void setOrderDiscount(Double d2) {
        this.orderDiscount = d2;
    }

    public final Double getShippingCharges() {
        return this.shippingCharges;
    }

    public final void setShippingCharges(Double d2) {
        this.shippingCharges = d2;
    }

    public final Double getShippingAmount() {
        return this.shippingAmount;
    }

    public final void setShippingAmount(Double d2) {
        this.shippingAmount = d2;
    }

    public final Double getGrandtotal() {
        return this.grandtotal;
    }

    public final void setGrandtotal(Double d2) {
        this.grandtotal = d2;
    }

    public final String getPaymentStatus() {
        return this.paymentStatus;
    }

    public final void setPaymentStatus(String str) {
        this.paymentStatus = str;
    }

    public final Double getSellingPrice() {
        return this.sellingPrice;
    }

    public final void setSellingPrice(Double d2) {
        this.sellingPrice = d2;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final String getRefundSourceText() {
        return this.refundSourceText;
    }

    public final void setRefundSourceText(String str) {
        this.refundSourceText = str;
    }

    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    public final void setOrderStatus(Integer num) {
        this.orderStatus = num;
    }

    public final Double getDiscountAmount() {
        return this.discountAmount;
    }

    public final void setDiscountAmount(Double d2) {
        this.discountAmount = d2;
    }

    public final Double getShippingDiscount() {
        return this.shippingDiscount;
    }

    public final void setShippingDiscount(Double d2) {
        this.shippingDiscount = d2;
    }

    public final String getPaymentSummary() {
        return this.paymentSummary;
    }

    public final void setPaymentSummary(String str) {
        this.paymentSummary = str;
    }

    public final String getOrderPaymentSummary() {
        return this.orderPaymentSummary;
    }

    public final void setOrderPaymentSummary(String str) {
        this.orderPaymentSummary = str;
    }

    public final String getPaymentText() {
        return this.paymentText;
    }

    public final void setPaymentText(String str) {
        this.paymentText = str;
    }

    public final String getStatusIcon() {
        return this.statusIcon;
    }

    public final void setStatusIcon(String str) {
        this.statusIcon = str;
    }

    public final Boolean getNeedShipping() {
        return this.needShipping;
    }

    public final void setNeedShipping(Boolean bool) {
        this.needShipping = bool;
    }

    public final String getRemoteIp() {
        return this.remoteIp;
    }

    public final void setRemoteIp(String str) {
        this.remoteIp = str;
    }

    public final String getOrderType() {
        return this.orderType;
    }

    public final void setOrderType(String str) {
        this.orderType = str;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final void setItems(List<Item> list) {
        this.items = list;
    }

    public final List<Object> getTotalOtherTaxes() {
        return this.totalOtherTaxes;
    }

    public final void setTotalOtherTaxes(List<? extends Object> list) {
        this.totalOtherTaxes = list;
    }

    public final Double getTotalConvFee() {
        return this.totalConvFee;
    }

    public final void setTotalConvFee(Double d2) {
        this.totalConvFee = d2;
    }

    public final Double getAggregateItemPrice() {
        return this.aggregateItemPrice;
    }

    public final void setAggregateItemPrice(Double d2) {
        this.aggregateItemPrice = d2;
    }

    public final String getProductPromiseLogoUrl() {
        return this.productPromiseLogoUrl;
    }

    public final void setProductPromiseLogoUrl(String str) {
        this.productPromiseLogoUrl = str;
    }

    public final Boolean isPhysical() {
        return this.isPhysical;
    }

    public final void setPhysical(Boolean bool) {
        this.isPhysical = bool;
    }

    public final Boolean isBooking() {
        return this.isBooking;
    }

    public final void setBooking(Boolean bool) {
        this.isBooking = bool;
    }

    public final String getPosTxnRequired() {
        return this.posTxnRequired;
    }

    public final String getPosTxnMessage() {
        return this.posTxnMessage;
    }

    public final List<Payment> getPayments() {
        return this.payments;
    }

    public final void setPayments(List<Payment> list) {
        this.payments = list;
    }

    public final List<MlvInfo2> getMlvInfo() {
        return this.mlvInfo;
    }

    public final void setMlvInfo(List<MlvInfo2> list) {
        this.mlvInfo = list;
    }

    public final List<TransactionDetail> getTransactionDetails() {
        return this.transactionDetails;
    }

    public final void setTransactionDetails(List<TransactionDetail> list) {
        this.transactionDetails = list;
    }

    public final List<PayMode> getPayModes() {
        return this.payModes;
    }

    public final void setPayModes(List<PayMode> list) {
        this.payModes = list;
    }

    public final String isPaymentInitiated() {
        return this.isPaymentInitiated;
    }

    public final void setPaymentInitiated(String str) {
        this.isPaymentInitiated = str;
    }

    public final Footer getFooter() {
        return this.footer;
    }

    public final void setFooter(Footer footer2) {
        this.footer = footer2;
    }

    public final ShippingAddress getShippingAddress() {
        return this.shippingAddress;
    }

    public final void setShippingAddress(ShippingAddress shippingAddress2) {
        this.shippingAddress = shippingAddress2;
    }

    public final String getTotalCashback() {
        return this.totalCashback;
    }

    public final void setTotalCashback(String str) {
        this.totalCashback = str;
    }

    public final String getCashbackLabel() {
        return this.cashbackLabel;
    }

    public final void setCashbackLabel(String str) {
        this.cashbackLabel = str;
    }

    public MyOrdersAPIResponse(String str, String str2, Double d2, Double d3, Double d4, Double d5, Double d6, String str3, Double d7, String str4, String str5, String str6, String str7, Integer num, Double d8, Double d9, String str8, String str9, String str10, String str11, Boolean bool, String str12, String str13, List<Item> list, List<? extends Object> list2, Double d10, Double d11, String str14, Boolean bool2, Boolean bool3, String str15, String str16, List<Payment> list3, List<MlvInfo2> list4, List<TransactionDetail> list5, List<PayMode> list6, String str17, Footer footer2, ShippingAddress shippingAddress2, String str18, String str19, SiteWideOffer siteWideOffer2) {
        this.id = str;
        this.status = str2;
        this.subtotal = d2;
        this.orderDiscount = d3;
        this.shippingCharges = d4;
        this.shippingAmount = d5;
        this.grandtotal = d6;
        this.paymentStatus = str3;
        this.sellingPrice = d7;
        this.channelId = str4;
        this.customerId = str5;
        this.createdAt = str6;
        this.refundSourceText = str7;
        this.orderStatus = num;
        this.discountAmount = d8;
        this.shippingDiscount = d9;
        this.paymentSummary = str8;
        this.orderPaymentSummary = str9;
        this.paymentText = str10;
        this.statusIcon = str11;
        this.needShipping = bool;
        this.remoteIp = str12;
        this.orderType = str13;
        this.items = list;
        this.totalOtherTaxes = list2;
        this.totalConvFee = d10;
        this.aggregateItemPrice = d11;
        this.productPromiseLogoUrl = str14;
        this.isPhysical = bool2;
        this.isBooking = bool3;
        this.posTxnRequired = str15;
        this.posTxnMessage = str16;
        this.payments = list3;
        this.mlvInfo = list4;
        this.transactionDetails = list5;
        this.payModes = list6;
        this.isPaymentInitiated = str17;
        this.footer = footer2;
        this.shippingAddress = shippingAddress2;
        this.totalCashback = str18;
        this.cashbackLabel = str19;
        this.siteWideOffer = siteWideOffer2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MyOrdersAPIResponse(java.lang.String r42, java.lang.String r43, java.lang.Double r44, java.lang.Double r45, java.lang.Double r46, java.lang.Double r47, java.lang.Double r48, java.lang.String r49, java.lang.Double r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.Integer r55, java.lang.Double r56, java.lang.Double r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.Boolean r62, java.lang.String r63, java.lang.String r64, java.util.List r65, java.util.List r66, java.lang.Double r67, java.lang.Double r68, java.lang.String r69, java.lang.Boolean r70, java.lang.Boolean r71, java.lang.String r72, java.lang.String r73, java.util.List r74, java.util.List r75, java.util.List r76, java.util.List r77, java.lang.String r78, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Footer r79, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.ShippingAddress r80, java.lang.String r81, java.lang.String r82, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.SiteWideOffer r83, int r84, int r85, kotlin.g.b.g r86) {
        /*
            r41 = this;
            r0 = r84
            r1 = r85
            r2 = r0 & 1
            if (r2 == 0) goto L_0x000a
            r2 = 0
            goto L_0x000c
        L_0x000a:
            r2 = r42
        L_0x000c:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0014
        L_0x0012:
            r4 = r43
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = 0
            goto L_0x001c
        L_0x001a:
            r5 = r44
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r45
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r46
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r47
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r48
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r49
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r50
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = 0
            goto L_0x0054
        L_0x0052:
            r12 = r51
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = 0
            goto L_0x005c
        L_0x005a:
            r13 = r52
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = 0
            goto L_0x0064
        L_0x0062:
            r14 = r53
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            r15 = 0
            goto L_0x006c
        L_0x006a:
            r15 = r54
        L_0x006c:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0072
            r3 = 0
            goto L_0x0074
        L_0x0072:
            r3 = r55
        L_0x0074:
            r16 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x007c
            r3 = 0
            goto L_0x007e
        L_0x007c:
            r3 = r56
        L_0x007e:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0088
            r17 = 0
            goto L_0x008a
        L_0x0088:
            r17 = r57
        L_0x008a:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x0093
            r18 = 0
            goto L_0x0095
        L_0x0093:
            r18 = r58
        L_0x0095:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x009e
            r19 = 0
            goto L_0x00a0
        L_0x009e:
            r19 = r59
        L_0x00a0:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a9
            r20 = 0
            goto L_0x00ab
        L_0x00a9:
            r20 = r60
        L_0x00ab:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00b4
            r21 = 0
            goto L_0x00b6
        L_0x00b4:
            r21 = r61
        L_0x00b6:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00bf
            r22 = 0
            goto L_0x00c1
        L_0x00bf:
            r22 = r62
        L_0x00c1:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00ca
            r23 = 0
            goto L_0x00cc
        L_0x00ca:
            r23 = r63
        L_0x00cc:
            r24 = 4194304(0x400000, float:5.877472E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00d5
            r24 = 0
            goto L_0x00d7
        L_0x00d5:
            r24 = r64
        L_0x00d7:
            r25 = 8388608(0x800000, float:1.17549435E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e0
            r25 = 0
            goto L_0x00e2
        L_0x00e0:
            r25 = r65
        L_0x00e2:
            r26 = 16777216(0x1000000, float:2.3509887E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00eb
            r26 = 0
            goto L_0x00ed
        L_0x00eb:
            r26 = r66
        L_0x00ed:
            r27 = 33554432(0x2000000, float:9.403955E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00f6
            r27 = 0
            goto L_0x00f8
        L_0x00f6:
            r27 = r67
        L_0x00f8:
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0101
            r28 = 0
            goto L_0x0103
        L_0x0101:
            r28 = r68
        L_0x0103:
            r29 = 134217728(0x8000000, float:3.85186E-34)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x010c
            r29 = 0
            goto L_0x010e
        L_0x010c:
            r29 = r69
        L_0x010e:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0117
            r30 = 0
            goto L_0x0119
        L_0x0117:
            r30 = r70
        L_0x0119:
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0122
            r31 = 0
            goto L_0x0124
        L_0x0122:
            r31 = r71
        L_0x0124:
            r32 = 1073741824(0x40000000, float:2.0)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x012d
            r32 = 0
            goto L_0x012f
        L_0x012d:
            r32 = r72
        L_0x012f:
            r33 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r33
            if (r0 == 0) goto L_0x0137
            r0 = 0
            goto L_0x0139
        L_0x0137:
            r0 = r73
        L_0x0139:
            r33 = r1 & 1
            if (r33 == 0) goto L_0x0140
            r33 = 0
            goto L_0x0142
        L_0x0140:
            r33 = r74
        L_0x0142:
            r34 = r1 & 2
            if (r34 == 0) goto L_0x0149
            r34 = 0
            goto L_0x014b
        L_0x0149:
            r34 = r75
        L_0x014b:
            r35 = r1 & 4
            if (r35 == 0) goto L_0x0152
            r35 = 0
            goto L_0x0154
        L_0x0152:
            r35 = r76
        L_0x0154:
            r36 = r1 & 8
            if (r36 == 0) goto L_0x015b
            r36 = 0
            goto L_0x015d
        L_0x015b:
            r36 = r77
        L_0x015d:
            r37 = r1 & 16
            if (r37 == 0) goto L_0x0164
            r37 = 0
            goto L_0x0166
        L_0x0164:
            r37 = r78
        L_0x0166:
            r38 = r1 & 32
            if (r38 == 0) goto L_0x016d
            r38 = 0
            goto L_0x016f
        L_0x016d:
            r38 = r79
        L_0x016f:
            r39 = r1 & 64
            if (r39 == 0) goto L_0x0176
            r39 = 0
            goto L_0x0178
        L_0x0176:
            r39 = r80
        L_0x0178:
            r84 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r0 = 0
            goto L_0x0182
        L_0x0180:
            r0 = r81
        L_0x0182:
            r40 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018a
            r0 = 0
            goto L_0x018c
        L_0x018a:
            r0 = r82
        L_0x018c:
            r1 = r1 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0192
            r1 = 0
            goto L_0x0194
        L_0x0192:
            r1 = r83
        L_0x0194:
            r42 = r41
            r43 = r2
            r44 = r4
            r45 = r5
            r46 = r6
            r47 = r7
            r48 = r8
            r49 = r9
            r50 = r10
            r51 = r11
            r52 = r12
            r53 = r13
            r54 = r14
            r55 = r15
            r56 = r16
            r57 = r3
            r58 = r17
            r59 = r18
            r60 = r19
            r61 = r20
            r62 = r21
            r63 = r22
            r64 = r23
            r65 = r24
            r66 = r25
            r67 = r26
            r68 = r27
            r69 = r28
            r70 = r29
            r71 = r30
            r72 = r31
            r73 = r32
            r74 = r84
            r75 = r33
            r76 = r34
            r77 = r35
            r78 = r36
            r79 = r37
            r80 = r38
            r81 = r39
            r82 = r40
            r83 = r0
            r84 = r1
            r42.<init>(r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MyOrdersAPIResponse.<init>(java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.Double, java.lang.Double, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Footer, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.ShippingAddress, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.SiteWideOffer, int, int, kotlin.g.b.g):void");
    }

    public final SiteWideOffer getSiteWideOffer() {
        return this.siteWideOffer;
    }

    public final void setSiteWideOffer(SiteWideOffer siteWideOffer2) {
        this.siteWideOffer = siteWideOffer2;
    }
}
