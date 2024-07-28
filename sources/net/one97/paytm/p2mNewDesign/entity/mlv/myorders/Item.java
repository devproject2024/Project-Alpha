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

public final class Item extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "actions")
    private List<Action> actions;
    @b(a = "aggregate_item_price")
    private Double aggregateItemPrice;
    @b(a = "amount_collected")
    private Double amountCollected;
    @b(a = "attributes")
    private Attributes_ attributes;
    @b(a = "c2i")
    private Boolean c2i;
    @b(a = "campaign")
    private String campaign;
    @b(a = "cashback")
    private List<? extends Object> cashback;
    @b(a = "cashback_credited")
    private Double cashbackCredited;
    @b(a = "cashback_credited_text")
    private String cashbackCreditedText;
    @b(a = "configuration")
    private Configuration configuration;
    @b(a = "conv_fee")
    private Double convFee;
    @b(a = "custom_text1")
    private String customText1;
    @b(a = "custom_text5")
    private String customText5;
    @b(a = "delivery_type")
    private String deliveryType;
    @b(a = "discount_amount")
    private Double discountAmount;
    @b(a = "discounted_price")
    private Double discountedPrice;
    @b(a = "fulfillment")
    private Fulfillment fulfillment;
    @b(a = "fulfillment_service")
    private String fulfillmentService;
    @b(a = "gratification")
    private List<Gratification> gratification;
    @b(a = "hasReplacement")
    private String hasReplacement;
    @b(a = "id")
    private String id;
    @b(a = "infoObj")
    private InfoObj infoObj;
    @b(a = "installation_eligible")
    private Boolean installationEligible;
    @b(a = "installation_url")
    private Object installationUrl;
    @b(a = "isExchangeForwardItem")
    private String isExchangeForwardItem;
    @b(a = "isExchangeReverseItem")
    private String isExchangeReverseItem;
    @b(a = "isPartialChildItem")
    private String isPartialChildItem;
    @b(a = "is_pfa")
    private String isPfa;
    @b(a = "is_physical")
    private Boolean isPhysical;
    @b(a = "isPickAtStore")
    private Boolean isPickAtStore;
    @b(a = "isReplacement")
    private String isReplacement;
    @b(a = "item_status")
    private String itemStatus;
    @b(a = "max_extend_sla")
    private Integer maxExtendSla;
    @b(a = "merchant_address")
    private MerchantAddress merchantAddress;
    @b(a = "merchant_id")
    private String merchantId;
    @b(a = "meta_data")
    private MetaData2 metaData;
    @b(a = "meta_info")
    private MetaInfo metaInfo;
    @b(a = "mrp")
    private Double mrp;
    @b(a = "name")
    private String name;
    @b(a = "otherTaxes")
    private List<? extends Object> otherTaxes;
    @b(a = "price")
    private Double price;
    @b(a = "priceInclTaxes")
    private List<? extends Object> priceInclTaxes;
    @b(a = "product")
    private Product product;
    @b(a = "promo_code")
    private String promoCode;
    @b(a = "promo_description")
    private String promoDescription;
    @b(a = "promo_text")
    private String promoText;
    @b(a = "quantity")
    private String quantity;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "refund_amount")
    private Double refundAmount;
    @b(a = "return_flow")
    private Boolean returnFlow;
    @b(a = "shipping_amount")
    private Double shippingAmount;
    @b(a = "shipping_charges")
    private Double shippingCharges;
    @b(a = "shipping_discount")
    private Double shippingDiscount;
    @b(a = "status")
    private String status;
    @b(a = "status_flow")
    private List<? extends Object> statusFlow;
    @b(a = "status_text")
    private String statusText;
    @b(a = "subscription")
    private Subscription subscription;
    @b(a = "subtotal")
    private Double subtotal;
    @b(a = "subvention_info")
    private SubventionInfo subventionInfo;
    @b(a = "title")
    private String title;
    @b(a = "total_cashback")
    private Double totalCashback;
    @b(a = "total_price")
    private Double totalPrice;

    public Item() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (String) null, (String) null, (InfoObj) null, (List) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (MerchantAddress) null, (List) null, (List) null, (Boolean) null, (Boolean) null, (Object) null, (Boolean) null, (String) null, (String) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (List) null, (Double) null, (List) null, (Product) null, (Configuration) null, (Attributes_) null, (MetaInfo) null, (MetaData2) null, (SubventionInfo) null, (Subscription) null, (Fulfillment) null, (Boolean) null, (Integer) null, -1, 1073741823, (g) null);
    }

    public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Double d2, Double d3, String str11, String str12, InfoObj infoObj2, List list, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, String str13, MerchantAddress merchantAddress2, List list2, List list3, Boolean bool, Boolean bool2, Object obj, Boolean bool3, String str14, String str15, String str16, Double d12, String str17, String str18, String str19, String str20, Double d13, Double d14, Double d15, String str21, String str22, String str23, List list4, String str24, Boolean bool4, List list5, Double d16, List list6, Product product2, Configuration configuration2, Attributes_ attributes_, MetaInfo metaInfo2, MetaData2 metaData2, SubventionInfo subventionInfo2, Subscription subscription2, Fulfillment fulfillment2, Boolean bool5, Integer num, int i2, int i3, Object obj2) {
        Item item2 = item;
        int i4 = i2;
        int i5 = i3;
        return item.copy((i4 & 1) != 0 ? item2.id : str, (i4 & 2) != 0 ? item2.merchantId : str2, (i4 & 4) != 0 ? item2.name : str3, (i4 & 8) != 0 ? item2.title : str4, (i4 & 16) != 0 ? item2.statusText : str5, (i4 & 32) != 0 ? item2.status : str6, (i4 & 64) != 0 ? item2.itemStatus : str7, (i4 & 128) != 0 ? item2.quantity : str8, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? item2.promoCode : str9, (i4 & 512) != 0 ? item2.campaign : str10, (i4 & TarConstants.EOF_BLOCK) != 0 ? item2.subtotal : d2, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? item2.totalPrice : d3, (i4 & 4096) != 0 ? item2.customText1 : str11, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? item2.customText5 : str12, (i4 & 16384) != 0 ? item2.infoObj : infoObj2, (i4 & 32768) != 0 ? item2.actions : list, (i4 & 65536) != 0 ? item2.price : d4, (i4 & 131072) != 0 ? item2.mrp : d5, (i4 & 262144) != 0 ? item2.convFee : d6, (i4 & 524288) != 0 ? item2.discountedPrice : d7, (i4 & 1048576) != 0 ? item2.discountAmount : d8, (i4 & 2097152) != 0 ? item2.shippingCharges : d9, (i4 & 4194304) != 0 ? item2.shippingAmount : d10, (i4 & 8388608) != 0 ? item2.shippingDiscount : d11, (i4 & 16777216) != 0 ? item2.promoText : str13, (i4 & 33554432) != 0 ? item2.merchantAddress : merchantAddress2, (i4 & 67108864) != 0 ? item2.otherTaxes : list2, (i4 & 134217728) != 0 ? item2.priceInclTaxes : list3, (i4 & 268435456) != 0 ? item2.isPhysical : bool, (i4 & 536870912) != 0 ? item2.installationEligible : bool2, (i4 & 1073741824) != 0 ? item2.installationUrl : obj, (i4 & Integer.MIN_VALUE) != 0 ? item2.c2i : bool3, (i5 & 1) != 0 ? item2.isExchangeForwardItem : str14, (i5 & 2) != 0 ? item2.isExchangeReverseItem : str15, (i5 & 4) != 0 ? item2.fulfillmentService : str16, (i5 & 8) != 0 ? item2.refundAmount : d12, (i5 & 16) != 0 ? item2.isReplacement : str17, (i5 & 32) != 0 ? item2.hasReplacement : str18, (i5 & 64) != 0 ? item2.isPfa : str19, (i5 & 128) != 0 ? item2.deliveryType : str20, (i5 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? item2.aggregateItemPrice : d13, (i5 & 512) != 0 ? item2.totalCashback : d14, (i5 & TarConstants.EOF_BLOCK) != 0 ? item2.cashbackCredited : d15, (i5 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? item2.cashbackCreditedText : str21, (i5 & 4096) != 0 ? item2.redemptionType : str22, (i5 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? item2.promoDescription : str23, (i5 & 16384) != 0 ? item2.gratification : list4, (i5 & 32768) != 0 ? item2.isPartialChildItem : str24, (i5 & 65536) != 0 ? item2.isPickAtStore : bool4, (i5 & 131072) != 0 ? item2.cashback : list5, (i5 & 262144) != 0 ? item2.amountCollected : d16, (i5 & 524288) != 0 ? item2.statusFlow : list6, (i5 & 1048576) != 0 ? item2.product : product2, (i5 & 2097152) != 0 ? item2.configuration : configuration2, (i5 & 4194304) != 0 ? item2.attributes : attributes_, (i5 & 8388608) != 0 ? item2.metaInfo : metaInfo2, (i5 & 16777216) != 0 ? item2.metaData : metaData2, (i5 & 33554432) != 0 ? item2.subventionInfo : subventionInfo2, (i5 & 67108864) != 0 ? item2.subscription : subscription2, (i5 & 134217728) != 0 ? item2.fulfillment : fulfillment2, (i5 & 268435456) != 0 ? item2.returnFlow : bool5, (i5 & 536870912) != 0 ? item2.maxExtendSla : num);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.campaign;
    }

    public final Double component11() {
        return this.subtotal;
    }

    public final Double component12() {
        return this.totalPrice;
    }

    public final String component13() {
        return this.customText1;
    }

    public final String component14() {
        return this.customText5;
    }

    public final InfoObj component15() {
        return this.infoObj;
    }

    public final List<Action> component16() {
        return this.actions;
    }

    public final Double component17() {
        return this.price;
    }

    public final Double component18() {
        return this.mrp;
    }

    public final Double component19() {
        return this.convFee;
    }

    public final String component2() {
        return this.merchantId;
    }

    public final Double component20() {
        return this.discountedPrice;
    }

    public final Double component21() {
        return this.discountAmount;
    }

    public final Double component22() {
        return this.shippingCharges;
    }

    public final Double component23() {
        return this.shippingAmount;
    }

    public final Double component24() {
        return this.shippingDiscount;
    }

    public final String component25() {
        return this.promoText;
    }

    public final MerchantAddress component26() {
        return this.merchantAddress;
    }

    public final List<Object> component27() {
        return this.otherTaxes;
    }

    public final List<Object> component28() {
        return this.priceInclTaxes;
    }

    public final Boolean component29() {
        return this.isPhysical;
    }

    public final String component3() {
        return this.name;
    }

    public final Boolean component30() {
        return this.installationEligible;
    }

    public final Object component31() {
        return this.installationUrl;
    }

    public final Boolean component32() {
        return this.c2i;
    }

    public final String component33() {
        return this.isExchangeForwardItem;
    }

    public final String component34() {
        return this.isExchangeReverseItem;
    }

    public final String component35() {
        return this.fulfillmentService;
    }

    public final Double component36() {
        return this.refundAmount;
    }

    public final String component37() {
        return this.isReplacement;
    }

    public final String component38() {
        return this.hasReplacement;
    }

    public final String component39() {
        return this.isPfa;
    }

    public final String component4() {
        return this.title;
    }

    public final String component40() {
        return this.deliveryType;
    }

    public final Double component41() {
        return this.aggregateItemPrice;
    }

    public final Double component42() {
        return this.totalCashback;
    }

    public final Double component43() {
        return this.cashbackCredited;
    }

    public final String component44() {
        return this.cashbackCreditedText;
    }

    public final String component45() {
        return this.redemptionType;
    }

    public final String component46() {
        return this.promoDescription;
    }

    public final List<Gratification> component47() {
        return this.gratification;
    }

    public final String component48() {
        return this.isPartialChildItem;
    }

    public final Boolean component49() {
        return this.isPickAtStore;
    }

    public final String component5() {
        return this.statusText;
    }

    public final List<Object> component50() {
        return this.cashback;
    }

    public final Double component51() {
        return this.amountCollected;
    }

    public final List<Object> component52() {
        return this.statusFlow;
    }

    public final Product component53() {
        return this.product;
    }

    public final Configuration component54() {
        return this.configuration;
    }

    public final Attributes_ component55() {
        return this.attributes;
    }

    public final MetaInfo component56() {
        return this.metaInfo;
    }

    public final MetaData2 component57() {
        return this.metaData;
    }

    public final SubventionInfo component58() {
        return this.subventionInfo;
    }

    public final Subscription component59() {
        return this.subscription;
    }

    public final String component6() {
        return this.status;
    }

    public final Fulfillment component60() {
        return this.fulfillment;
    }

    public final Boolean component61() {
        return this.returnFlow;
    }

    public final Integer component62() {
        return this.maxExtendSla;
    }

    public final String component7() {
        return this.itemStatus;
    }

    public final String component8() {
        return this.quantity;
    }

    public final String component9() {
        return this.promoCode;
    }

    public final Item copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Double d2, Double d3, String str11, String str12, InfoObj infoObj2, List<Action> list, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, String str13, MerchantAddress merchantAddress2, List<? extends Object> list2, List<? extends Object> list3, Boolean bool, Boolean bool2, Object obj, Boolean bool3, String str14, String str15, String str16, Double d12, String str17, String str18, String str19, String str20, Double d13, Double d14, Double d15, String str21, String str22, String str23, List<Gratification> list4, String str24, Boolean bool4, List<? extends Object> list5, Double d16, List<? extends Object> list6, Product product2, Configuration configuration2, Attributes_ attributes_, MetaInfo metaInfo2, MetaData2 metaData2, SubventionInfo subventionInfo2, Subscription subscription2, Fulfillment fulfillment2, Boolean bool5, Integer num) {
        return new Item(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, d2, d3, str11, str12, infoObj2, list, d4, d5, d6, d7, d8, d9, d10, d11, str13, merchantAddress2, list2, list3, bool, bool2, obj, bool3, str14, str15, str16, d12, str17, str18, str19, str20, d13, d14, d15, str21, str22, str23, list4, str24, bool4, list5, d16, list6, product2, configuration2, attributes_, metaInfo2, metaData2, subventionInfo2, subscription2, fulfillment2, bool5, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        return k.a((Object) this.id, (Object) item.id) && k.a((Object) this.merchantId, (Object) item.merchantId) && k.a((Object) this.name, (Object) item.name) && k.a((Object) this.title, (Object) item.title) && k.a((Object) this.statusText, (Object) item.statusText) && k.a((Object) this.status, (Object) item.status) && k.a((Object) this.itemStatus, (Object) item.itemStatus) && k.a((Object) this.quantity, (Object) item.quantity) && k.a((Object) this.promoCode, (Object) item.promoCode) && k.a((Object) this.campaign, (Object) item.campaign) && k.a((Object) this.subtotal, (Object) item.subtotal) && k.a((Object) this.totalPrice, (Object) item.totalPrice) && k.a((Object) this.customText1, (Object) item.customText1) && k.a((Object) this.customText5, (Object) item.customText5) && k.a((Object) this.infoObj, (Object) item.infoObj) && k.a((Object) this.actions, (Object) item.actions) && k.a((Object) this.price, (Object) item.price) && k.a((Object) this.mrp, (Object) item.mrp) && k.a((Object) this.convFee, (Object) item.convFee) && k.a((Object) this.discountedPrice, (Object) item.discountedPrice) && k.a((Object) this.discountAmount, (Object) item.discountAmount) && k.a((Object) this.shippingCharges, (Object) item.shippingCharges) && k.a((Object) this.shippingAmount, (Object) item.shippingAmount) && k.a((Object) this.shippingDiscount, (Object) item.shippingDiscount) && k.a((Object) this.promoText, (Object) item.promoText) && k.a((Object) this.merchantAddress, (Object) item.merchantAddress) && k.a((Object) this.otherTaxes, (Object) item.otherTaxes) && k.a((Object) this.priceInclTaxes, (Object) item.priceInclTaxes) && k.a((Object) this.isPhysical, (Object) item.isPhysical) && k.a((Object) this.installationEligible, (Object) item.installationEligible) && k.a(this.installationUrl, item.installationUrl) && k.a((Object) this.c2i, (Object) item.c2i) && k.a((Object) this.isExchangeForwardItem, (Object) item.isExchangeForwardItem) && k.a((Object) this.isExchangeReverseItem, (Object) item.isExchangeReverseItem) && k.a((Object) this.fulfillmentService, (Object) item.fulfillmentService) && k.a((Object) this.refundAmount, (Object) item.refundAmount) && k.a((Object) this.isReplacement, (Object) item.isReplacement) && k.a((Object) this.hasReplacement, (Object) item.hasReplacement) && k.a((Object) this.isPfa, (Object) item.isPfa) && k.a((Object) this.deliveryType, (Object) item.deliveryType) && k.a((Object) this.aggregateItemPrice, (Object) item.aggregateItemPrice) && k.a((Object) this.totalCashback, (Object) item.totalCashback) && k.a((Object) this.cashbackCredited, (Object) item.cashbackCredited) && k.a((Object) this.cashbackCreditedText, (Object) item.cashbackCreditedText) && k.a((Object) this.redemptionType, (Object) item.redemptionType) && k.a((Object) this.promoDescription, (Object) item.promoDescription) && k.a((Object) this.gratification, (Object) item.gratification) && k.a((Object) this.isPartialChildItem, (Object) item.isPartialChildItem) && k.a((Object) this.isPickAtStore, (Object) item.isPickAtStore) && k.a((Object) this.cashback, (Object) item.cashback) && k.a((Object) this.amountCollected, (Object) item.amountCollected) && k.a((Object) this.statusFlow, (Object) item.statusFlow) && k.a((Object) this.product, (Object) item.product) && k.a((Object) this.configuration, (Object) item.configuration) && k.a((Object) this.attributes, (Object) item.attributes) && k.a((Object) this.metaInfo, (Object) item.metaInfo) && k.a((Object) this.metaData, (Object) item.metaData) && k.a((Object) this.subventionInfo, (Object) item.subventionInfo) && k.a((Object) this.subscription, (Object) item.subscription) && k.a((Object) this.fulfillment, (Object) item.fulfillment) && k.a((Object) this.returnFlow, (Object) item.returnFlow) && k.a((Object) this.maxExtendSla, (Object) item.maxExtendSla);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.title;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.statusText;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.status;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.itemStatus;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.quantity;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.promoCode;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.campaign;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Double d2 = this.subtotal;
        int hashCode11 = (hashCode10 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.totalPrice;
        int hashCode12 = (hashCode11 + (d3 != null ? d3.hashCode() : 0)) * 31;
        String str11 = this.customText1;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.customText5;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
        InfoObj infoObj2 = this.infoObj;
        int hashCode15 = (hashCode14 + (infoObj2 != null ? infoObj2.hashCode() : 0)) * 31;
        List<Action> list = this.actions;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        Double d4 = this.price;
        int hashCode17 = (hashCode16 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.mrp;
        int hashCode18 = (hashCode17 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.convFee;
        int hashCode19 = (hashCode18 + (d6 != null ? d6.hashCode() : 0)) * 31;
        Double d7 = this.discountedPrice;
        int hashCode20 = (hashCode19 + (d7 != null ? d7.hashCode() : 0)) * 31;
        Double d8 = this.discountAmount;
        int hashCode21 = (hashCode20 + (d8 != null ? d8.hashCode() : 0)) * 31;
        Double d9 = this.shippingCharges;
        int hashCode22 = (hashCode21 + (d9 != null ? d9.hashCode() : 0)) * 31;
        Double d10 = this.shippingAmount;
        int hashCode23 = (hashCode22 + (d10 != null ? d10.hashCode() : 0)) * 31;
        Double d11 = this.shippingDiscount;
        int hashCode24 = (hashCode23 + (d11 != null ? d11.hashCode() : 0)) * 31;
        String str13 = this.promoText;
        int hashCode25 = (hashCode24 + (str13 != null ? str13.hashCode() : 0)) * 31;
        MerchantAddress merchantAddress2 = this.merchantAddress;
        int hashCode26 = (hashCode25 + (merchantAddress2 != null ? merchantAddress2.hashCode() : 0)) * 31;
        List<? extends Object> list2 = this.otherTaxes;
        int hashCode27 = (hashCode26 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<? extends Object> list3 = this.priceInclTaxes;
        int hashCode28 = (hashCode27 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Boolean bool = this.isPhysical;
        int hashCode29 = (hashCode28 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.installationEligible;
        int hashCode30 = (hashCode29 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Object obj = this.installationUrl;
        int hashCode31 = (hashCode30 + (obj != null ? obj.hashCode() : 0)) * 31;
        Boolean bool3 = this.c2i;
        int hashCode32 = (hashCode31 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str14 = this.isExchangeForwardItem;
        int hashCode33 = (hashCode32 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.isExchangeReverseItem;
        int hashCode34 = (hashCode33 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.fulfillmentService;
        int hashCode35 = (hashCode34 + (str16 != null ? str16.hashCode() : 0)) * 31;
        Double d12 = this.refundAmount;
        int hashCode36 = (hashCode35 + (d12 != null ? d12.hashCode() : 0)) * 31;
        String str17 = this.isReplacement;
        int hashCode37 = (hashCode36 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.hasReplacement;
        int hashCode38 = (hashCode37 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.isPfa;
        int hashCode39 = (hashCode38 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.deliveryType;
        int hashCode40 = (hashCode39 + (str20 != null ? str20.hashCode() : 0)) * 31;
        Double d13 = this.aggregateItemPrice;
        int hashCode41 = (hashCode40 + (d13 != null ? d13.hashCode() : 0)) * 31;
        Double d14 = this.totalCashback;
        int hashCode42 = (hashCode41 + (d14 != null ? d14.hashCode() : 0)) * 31;
        Double d15 = this.cashbackCredited;
        int hashCode43 = (hashCode42 + (d15 != null ? d15.hashCode() : 0)) * 31;
        String str21 = this.cashbackCreditedText;
        int hashCode44 = (hashCode43 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.redemptionType;
        int hashCode45 = (hashCode44 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.promoDescription;
        int hashCode46 = (hashCode45 + (str23 != null ? str23.hashCode() : 0)) * 31;
        List<Gratification> list4 = this.gratification;
        int hashCode47 = (hashCode46 + (list4 != null ? list4.hashCode() : 0)) * 31;
        String str24 = this.isPartialChildItem;
        int hashCode48 = (hashCode47 + (str24 != null ? str24.hashCode() : 0)) * 31;
        Boolean bool4 = this.isPickAtStore;
        int hashCode49 = (hashCode48 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        List<? extends Object> list5 = this.cashback;
        int hashCode50 = (hashCode49 + (list5 != null ? list5.hashCode() : 0)) * 31;
        Double d16 = this.amountCollected;
        int hashCode51 = (hashCode50 + (d16 != null ? d16.hashCode() : 0)) * 31;
        List<? extends Object> list6 = this.statusFlow;
        int hashCode52 = (hashCode51 + (list6 != null ? list6.hashCode() : 0)) * 31;
        Product product2 = this.product;
        int hashCode53 = (hashCode52 + (product2 != null ? product2.hashCode() : 0)) * 31;
        Configuration configuration2 = this.configuration;
        int hashCode54 = (hashCode53 + (configuration2 != null ? configuration2.hashCode() : 0)) * 31;
        Attributes_ attributes_ = this.attributes;
        int hashCode55 = (hashCode54 + (attributes_ != null ? attributes_.hashCode() : 0)) * 31;
        MetaInfo metaInfo2 = this.metaInfo;
        int hashCode56 = (hashCode55 + (metaInfo2 != null ? metaInfo2.hashCode() : 0)) * 31;
        MetaData2 metaData2 = this.metaData;
        int hashCode57 = (hashCode56 + (metaData2 != null ? metaData2.hashCode() : 0)) * 31;
        SubventionInfo subventionInfo2 = this.subventionInfo;
        int hashCode58 = (hashCode57 + (subventionInfo2 != null ? subventionInfo2.hashCode() : 0)) * 31;
        Subscription subscription2 = this.subscription;
        int hashCode59 = (hashCode58 + (subscription2 != null ? subscription2.hashCode() : 0)) * 31;
        Fulfillment fulfillment2 = this.fulfillment;
        int hashCode60 = (hashCode59 + (fulfillment2 != null ? fulfillment2.hashCode() : 0)) * 31;
        Boolean bool5 = this.returnFlow;
        int hashCode61 = (hashCode60 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Integer num = this.maxExtendSla;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode61 + i2;
    }

    public final String toString() {
        return "Item(id=" + this.id + ", merchantId=" + this.merchantId + ", name=" + this.name + ", title=" + this.title + ", statusText=" + this.statusText + ", status=" + this.status + ", itemStatus=" + this.itemStatus + ", quantity=" + this.quantity + ", promoCode=" + this.promoCode + ", campaign=" + this.campaign + ", subtotal=" + this.subtotal + ", totalPrice=" + this.totalPrice + ", customText1=" + this.customText1 + ", customText5=" + this.customText5 + ", infoObj=" + this.infoObj + ", actions=" + this.actions + ", price=" + this.price + ", mrp=" + this.mrp + ", convFee=" + this.convFee + ", discountedPrice=" + this.discountedPrice + ", discountAmount=" + this.discountAmount + ", shippingCharges=" + this.shippingCharges + ", shippingAmount=" + this.shippingAmount + ", shippingDiscount=" + this.shippingDiscount + ", promoText=" + this.promoText + ", merchantAddress=" + this.merchantAddress + ", otherTaxes=" + this.otherTaxes + ", priceInclTaxes=" + this.priceInclTaxes + ", isPhysical=" + this.isPhysical + ", installationEligible=" + this.installationEligible + ", installationUrl=" + this.installationUrl + ", c2i=" + this.c2i + ", isExchangeForwardItem=" + this.isExchangeForwardItem + ", isExchangeReverseItem=" + this.isExchangeReverseItem + ", fulfillmentService=" + this.fulfillmentService + ", refundAmount=" + this.refundAmount + ", isReplacement=" + this.isReplacement + ", hasReplacement=" + this.hasReplacement + ", isPfa=" + this.isPfa + ", deliveryType=" + this.deliveryType + ", aggregateItemPrice=" + this.aggregateItemPrice + ", totalCashback=" + this.totalCashback + ", cashbackCredited=" + this.cashbackCredited + ", cashbackCreditedText=" + this.cashbackCreditedText + ", redemptionType=" + this.redemptionType + ", promoDescription=" + this.promoDescription + ", gratification=" + this.gratification + ", isPartialChildItem=" + this.isPartialChildItem + ", isPickAtStore=" + this.isPickAtStore + ", cashback=" + this.cashback + ", amountCollected=" + this.amountCollected + ", statusFlow=" + this.statusFlow + ", product=" + this.product + ", configuration=" + this.configuration + ", attributes=" + this.attributes + ", metaInfo=" + this.metaInfo + ", metaData=" + this.metaData + ", subventionInfo=" + this.subventionInfo + ", subscription=" + this.subscription + ", fulfillment=" + this.fulfillment + ", returnFlow=" + this.returnFlow + ", maxExtendSla=" + this.maxExtendSla + ")";
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

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final void setStatusText(String str) {
        this.statusText = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getItemStatus() {
        return this.itemStatus;
    }

    public final void setItemStatus(String str) {
        this.itemStatus = str;
    }

    public final String getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(String str) {
        this.quantity = str;
    }

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final void setPromoCode(String str) {
        this.promoCode = str;
    }

    public final String getCampaign() {
        return this.campaign;
    }

    public final void setCampaign(String str) {
        this.campaign = str;
    }

    public final Double getSubtotal() {
        return this.subtotal;
    }

    public final void setSubtotal(Double d2) {
        this.subtotal = d2;
    }

    public final Double getTotalPrice() {
        return this.totalPrice;
    }

    public final void setTotalPrice(Double d2) {
        this.totalPrice = d2;
    }

    public final String getCustomText1() {
        return this.customText1;
    }

    public final void setCustomText1(String str) {
        this.customText1 = str;
    }

    public final String getCustomText5() {
        return this.customText5;
    }

    public final void setCustomText5(String str) {
        this.customText5 = str;
    }

    public final InfoObj getInfoObj() {
        return this.infoObj;
    }

    public final void setInfoObj(InfoObj infoObj2) {
        this.infoObj = infoObj2;
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final void setActions(List<Action> list) {
        this.actions = list;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final void setPrice(Double d2) {
        this.price = d2;
    }

    public final Double getMrp() {
        return this.mrp;
    }

    public final void setMrp(Double d2) {
        this.mrp = d2;
    }

    public final Double getConvFee() {
        return this.convFee;
    }

    public final void setConvFee(Double d2) {
        this.convFee = d2;
    }

    public final Double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public final void setDiscountedPrice(Double d2) {
        this.discountedPrice = d2;
    }

    public final Double getDiscountAmount() {
        return this.discountAmount;
    }

    public final void setDiscountAmount(Double d2) {
        this.discountAmount = d2;
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

    public final Double getShippingDiscount() {
        return this.shippingDiscount;
    }

    public final void setShippingDiscount(Double d2) {
        this.shippingDiscount = d2;
    }

    public final String getPromoText() {
        return this.promoText;
    }

    public final void setPromoText(String str) {
        this.promoText = str;
    }

    public final MerchantAddress getMerchantAddress() {
        return this.merchantAddress;
    }

    public final void setMerchantAddress(MerchantAddress merchantAddress2) {
        this.merchantAddress = merchantAddress2;
    }

    public final List<Object> getOtherTaxes() {
        return this.otherTaxes;
    }

    public final void setOtherTaxes(List<? extends Object> list) {
        this.otherTaxes = list;
    }

    public final List<Object> getPriceInclTaxes() {
        return this.priceInclTaxes;
    }

    public final void setPriceInclTaxes(List<? extends Object> list) {
        this.priceInclTaxes = list;
    }

    public final Boolean isPhysical() {
        return this.isPhysical;
    }

    public final void setPhysical(Boolean bool) {
        this.isPhysical = bool;
    }

    public final Boolean getInstallationEligible() {
        return this.installationEligible;
    }

    public final void setInstallationEligible(Boolean bool) {
        this.installationEligible = bool;
    }

    public final Object getInstallationUrl() {
        return this.installationUrl;
    }

    public final void setInstallationUrl(Object obj) {
        this.installationUrl = obj;
    }

    public final Boolean getC2i() {
        return this.c2i;
    }

    public final void setC2i(Boolean bool) {
        this.c2i = bool;
    }

    public final String isExchangeForwardItem() {
        return this.isExchangeForwardItem;
    }

    public final void setExchangeForwardItem(String str) {
        this.isExchangeForwardItem = str;
    }

    public final String isExchangeReverseItem() {
        return this.isExchangeReverseItem;
    }

    public final void setExchangeReverseItem(String str) {
        this.isExchangeReverseItem = str;
    }

    public final String getFulfillmentService() {
        return this.fulfillmentService;
    }

    public final void setFulfillmentService(String str) {
        this.fulfillmentService = str;
    }

    public final Double getRefundAmount() {
        return this.refundAmount;
    }

    public final void setRefundAmount(Double d2) {
        this.refundAmount = d2;
    }

    public final String isReplacement() {
        return this.isReplacement;
    }

    public final void setReplacement(String str) {
        this.isReplacement = str;
    }

    public final String getHasReplacement() {
        return this.hasReplacement;
    }

    public final void setHasReplacement(String str) {
        this.hasReplacement = str;
    }

    public final String isPfa() {
        return this.isPfa;
    }

    public final void setPfa(String str) {
        this.isPfa = str;
    }

    public final String getDeliveryType() {
        return this.deliveryType;
    }

    public final void setDeliveryType(String str) {
        this.deliveryType = str;
    }

    public final Double getAggregateItemPrice() {
        return this.aggregateItemPrice;
    }

    public final void setAggregateItemPrice(Double d2) {
        this.aggregateItemPrice = d2;
    }

    public final Double getTotalCashback() {
        return this.totalCashback;
    }

    public final void setTotalCashback(Double d2) {
        this.totalCashback = d2;
    }

    public final Double getCashbackCredited() {
        return this.cashbackCredited;
    }

    public final void setCashbackCredited(Double d2) {
        this.cashbackCredited = d2;
    }

    public final String getCashbackCreditedText() {
        return this.cashbackCreditedText;
    }

    public final void setCashbackCreditedText(String str) {
        this.cashbackCreditedText = str;
    }

    public final String getRedemptionType() {
        return this.redemptionType;
    }

    public final void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public final String getPromoDescription() {
        return this.promoDescription;
    }

    public final void setPromoDescription(String str) {
        this.promoDescription = str;
    }

    public final List<Gratification> getGratification() {
        return this.gratification;
    }

    public final void setGratification(List<Gratification> list) {
        this.gratification = list;
    }

    public final String isPartialChildItem() {
        return this.isPartialChildItem;
    }

    public final void setPartialChildItem(String str) {
        this.isPartialChildItem = str;
    }

    public final Boolean isPickAtStore() {
        return this.isPickAtStore;
    }

    public final void setPickAtStore(Boolean bool) {
        this.isPickAtStore = bool;
    }

    public final List<Object> getCashback() {
        return this.cashback;
    }

    public final void setCashback(List<? extends Object> list) {
        this.cashback = list;
    }

    public final Double getAmountCollected() {
        return this.amountCollected;
    }

    public final void setAmountCollected(Double d2) {
        this.amountCollected = d2;
    }

    public final List<Object> getStatusFlow() {
        return this.statusFlow;
    }

    public final void setStatusFlow(List<? extends Object> list) {
        this.statusFlow = list;
    }

    public final Product getProduct() {
        return this.product;
    }

    public final void setProduct(Product product2) {
        this.product = product2;
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final void setConfiguration(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public final Attributes_ getAttributes() {
        return this.attributes;
    }

    public final void setAttributes(Attributes_ attributes_) {
        this.attributes = attributes_;
    }

    public final MetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public final void setMetaInfo(MetaInfo metaInfo2) {
        this.metaInfo = metaInfo2;
    }

    public final MetaData2 getMetaData() {
        return this.metaData;
    }

    public final void setMetaData(MetaData2 metaData2) {
        this.metaData = metaData2;
    }

    public final SubventionInfo getSubventionInfo() {
        return this.subventionInfo;
    }

    public final void setSubventionInfo(SubventionInfo subventionInfo2) {
        this.subventionInfo = subventionInfo2;
    }

    public final Subscription getSubscription() {
        return this.subscription;
    }

    public final void setSubscription(Subscription subscription2) {
        this.subscription = subscription2;
    }

    public final Fulfillment getFulfillment() {
        return this.fulfillment;
    }

    public final void setFulfillment(Fulfillment fulfillment2) {
        this.fulfillment = fulfillment2;
    }

    public final Boolean getReturnFlow() {
        return this.returnFlow;
    }

    public final void setReturnFlow(Boolean bool) {
        this.returnFlow = bool;
    }

    public Item(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Double d2, Double d3, String str11, String str12, InfoObj infoObj2, List<Action> list, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, String str13, MerchantAddress merchantAddress2, List<? extends Object> list2, List<? extends Object> list3, Boolean bool, Boolean bool2, Object obj, Boolean bool3, String str14, String str15, String str16, Double d12, String str17, String str18, String str19, String str20, Double d13, Double d14, Double d15, String str21, String str22, String str23, List<Gratification> list4, String str24, Boolean bool4, List<? extends Object> list5, Double d16, List<? extends Object> list6, Product product2, Configuration configuration2, Attributes_ attributes_, MetaInfo metaInfo2, MetaData2 metaData2, SubventionInfo subventionInfo2, Subscription subscription2, Fulfillment fulfillment2, Boolean bool5, Integer num) {
        this.id = str;
        this.merchantId = str2;
        this.name = str3;
        this.title = str4;
        this.statusText = str5;
        this.status = str6;
        this.itemStatus = str7;
        this.quantity = str8;
        this.promoCode = str9;
        this.campaign = str10;
        this.subtotal = d2;
        this.totalPrice = d3;
        this.customText1 = str11;
        this.customText5 = str12;
        this.infoObj = infoObj2;
        this.actions = list;
        this.price = d4;
        this.mrp = d5;
        this.convFee = d6;
        this.discountedPrice = d7;
        this.discountAmount = d8;
        this.shippingCharges = d9;
        this.shippingAmount = d10;
        this.shippingDiscount = d11;
        this.promoText = str13;
        this.merchantAddress = merchantAddress2;
        this.otherTaxes = list2;
        this.priceInclTaxes = list3;
        this.isPhysical = bool;
        this.installationEligible = bool2;
        this.installationUrl = obj;
        this.c2i = bool3;
        this.isExchangeForwardItem = str14;
        this.isExchangeReverseItem = str15;
        this.fulfillmentService = str16;
        this.refundAmount = d12;
        this.isReplacement = str17;
        this.hasReplacement = str18;
        this.isPfa = str19;
        this.deliveryType = str20;
        this.aggregateItemPrice = d13;
        this.totalCashback = d14;
        this.cashbackCredited = d15;
        this.cashbackCreditedText = str21;
        this.redemptionType = str22;
        this.promoDescription = str23;
        this.gratification = list4;
        this.isPartialChildItem = str24;
        this.isPickAtStore = bool4;
        this.cashback = list5;
        this.amountCollected = d16;
        this.statusFlow = list6;
        this.product = product2;
        this.configuration = configuration2;
        this.attributes = attributes_;
        this.metaInfo = metaInfo2;
        this.metaData = metaData2;
        this.subventionInfo = subventionInfo2;
        this.subscription = subscription2;
        this.fulfillment = fulfillment2;
        this.returnFlow = bool5;
        this.maxExtendSla = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Item(java.lang.String r63, java.lang.String r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, java.lang.Double r73, java.lang.Double r74, java.lang.String r75, java.lang.String r76, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.InfoObj r77, java.util.List r78, java.lang.Double r79, java.lang.Double r80, java.lang.Double r81, java.lang.Double r82, java.lang.Double r83, java.lang.Double r84, java.lang.Double r85, java.lang.Double r86, java.lang.String r87, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MerchantAddress r88, java.util.List r89, java.util.List r90, java.lang.Boolean r91, java.lang.Boolean r92, java.lang.Object r93, java.lang.Boolean r94, java.lang.String r95, java.lang.String r96, java.lang.String r97, java.lang.Double r98, java.lang.String r99, java.lang.String r100, java.lang.String r101, java.lang.String r102, java.lang.Double r103, java.lang.Double r104, java.lang.Double r105, java.lang.String r106, java.lang.String r107, java.lang.String r108, java.util.List r109, java.lang.String r110, java.lang.Boolean r111, java.util.List r112, java.lang.Double r113, java.util.List r114, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Product r115, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Configuration r116, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Attributes_ r117, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MetaInfo r118, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MetaData2 r119, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.SubventionInfo r120, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Subscription r121, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Fulfillment r122, java.lang.Boolean r123, java.lang.Integer r124, int r125, int r126, kotlin.g.b.g r127) {
        /*
            r62 = this;
            r0 = r125
            r1 = r126
            r2 = r0 & 1
            if (r2 == 0) goto L_0x000a
            r2 = 0
            goto L_0x000c
        L_0x000a:
            r2 = r63
        L_0x000c:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0014
        L_0x0012:
            r4 = r64
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = 0
            goto L_0x001c
        L_0x001a:
            r5 = r65
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r66
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r67
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r68
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r69
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r70
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r71
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = 0
            goto L_0x0054
        L_0x0052:
            r12 = r72
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = 0
            goto L_0x005c
        L_0x005a:
            r13 = r73
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = 0
            goto L_0x0064
        L_0x0062:
            r14 = r74
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x006a
            r15 = 0
            goto L_0x006c
        L_0x006a:
            r15 = r75
        L_0x006c:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0072
            r3 = 0
            goto L_0x0074
        L_0x0072:
            r3 = r76
        L_0x0074:
            r16 = r3
            r3 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x007c
            r3 = 0
            goto L_0x007e
        L_0x007c:
            r3 = r77
        L_0x007e:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0088
            r17 = 0
            goto L_0x008a
        L_0x0088:
            r17 = r78
        L_0x008a:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x0093
            r18 = 0
            goto L_0x0095
        L_0x0093:
            r18 = r79
        L_0x0095:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x009e
            r19 = 0
            goto L_0x00a0
        L_0x009e:
            r19 = r80
        L_0x00a0:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a9
            r20 = 0
            goto L_0x00ab
        L_0x00a9:
            r20 = r81
        L_0x00ab:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00b4
            r21 = 0
            goto L_0x00b6
        L_0x00b4:
            r21 = r82
        L_0x00b6:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00bf
            r22 = 0
            goto L_0x00c1
        L_0x00bf:
            r22 = r83
        L_0x00c1:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00ca
            r23 = 0
            goto L_0x00cc
        L_0x00ca:
            r23 = r84
        L_0x00cc:
            r24 = 4194304(0x400000, float:5.877472E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00d5
            r24 = 0
            goto L_0x00d7
        L_0x00d5:
            r24 = r85
        L_0x00d7:
            r25 = 8388608(0x800000, float:1.17549435E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e0
            r25 = 0
            goto L_0x00e2
        L_0x00e0:
            r25 = r86
        L_0x00e2:
            r26 = 16777216(0x1000000, float:2.3509887E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00eb
            r26 = 0
            goto L_0x00ed
        L_0x00eb:
            r26 = r87
        L_0x00ed:
            r27 = 33554432(0x2000000, float:9.403955E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00f6
            r27 = 0
            goto L_0x00f8
        L_0x00f6:
            r27 = r88
        L_0x00f8:
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0101
            r28 = 0
            goto L_0x0103
        L_0x0101:
            r28 = r89
        L_0x0103:
            r29 = 134217728(0x8000000, float:3.85186E-34)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x010c
            r29 = 0
            goto L_0x010e
        L_0x010c:
            r29 = r90
        L_0x010e:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0117
            r30 = 0
            goto L_0x0119
        L_0x0117:
            r30 = r91
        L_0x0119:
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0122
            r31 = 0
            goto L_0x0124
        L_0x0122:
            r31 = r92
        L_0x0124:
            r32 = 1073741824(0x40000000, float:2.0)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x012d
            r32 = 0
            goto L_0x012f
        L_0x012d:
            r32 = r93
        L_0x012f:
            r33 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r33
            if (r0 == 0) goto L_0x0137
            r0 = 0
            goto L_0x0139
        L_0x0137:
            r0 = r94
        L_0x0139:
            r33 = r1 & 1
            if (r33 == 0) goto L_0x0140
            r33 = 0
            goto L_0x0142
        L_0x0140:
            r33 = r95
        L_0x0142:
            r34 = r1 & 2
            if (r34 == 0) goto L_0x0149
            r34 = 0
            goto L_0x014b
        L_0x0149:
            r34 = r96
        L_0x014b:
            r35 = r1 & 4
            if (r35 == 0) goto L_0x0152
            r35 = 0
            goto L_0x0154
        L_0x0152:
            r35 = r97
        L_0x0154:
            r36 = r1 & 8
            if (r36 == 0) goto L_0x015b
            r36 = 0
            goto L_0x015d
        L_0x015b:
            r36 = r98
        L_0x015d:
            r37 = r1 & 16
            if (r37 == 0) goto L_0x0164
            r37 = 0
            goto L_0x0166
        L_0x0164:
            r37 = r99
        L_0x0166:
            r38 = r1 & 32
            if (r38 == 0) goto L_0x016d
            r38 = 0
            goto L_0x016f
        L_0x016d:
            r38 = r100
        L_0x016f:
            r39 = r1 & 64
            if (r39 == 0) goto L_0x0176
            r39 = 0
            goto L_0x0178
        L_0x0176:
            r39 = r101
        L_0x0178:
            r125 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r0 = 0
            goto L_0x0182
        L_0x0180:
            r0 = r102
        L_0x0182:
            r40 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018a
            r0 = 0
            goto L_0x018c
        L_0x018a:
            r0 = r103
        L_0x018c:
            r41 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0194
            r0 = 0
            goto L_0x0196
        L_0x0194:
            r0 = r104
        L_0x0196:
            r42 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x019e
            r0 = 0
            goto L_0x01a0
        L_0x019e:
            r0 = r105
        L_0x01a0:
            r43 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01a8
            r0 = 0
            goto L_0x01aa
        L_0x01a8:
            r0 = r106
        L_0x01aa:
            r44 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01b2
            r0 = 0
            goto L_0x01b4
        L_0x01b2:
            r0 = r107
        L_0x01b4:
            r45 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01bc
            r0 = 0
            goto L_0x01be
        L_0x01bc:
            r0 = r108
        L_0x01be:
            r46 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01c6
            r0 = 0
            goto L_0x01c8
        L_0x01c6:
            r0 = r109
        L_0x01c8:
            r47 = 32768(0x8000, float:4.5918E-41)
            r47 = r1 & r47
            if (r47 == 0) goto L_0x01d2
            r47 = 0
            goto L_0x01d4
        L_0x01d2:
            r47 = r110
        L_0x01d4:
            r48 = 65536(0x10000, float:9.18355E-41)
            r48 = r1 & r48
            if (r48 == 0) goto L_0x01dd
            r48 = 0
            goto L_0x01df
        L_0x01dd:
            r48 = r111
        L_0x01df:
            r49 = 131072(0x20000, float:1.83671E-40)
            r49 = r1 & r49
            if (r49 == 0) goto L_0x01e8
            r49 = 0
            goto L_0x01ea
        L_0x01e8:
            r49 = r112
        L_0x01ea:
            r50 = 262144(0x40000, float:3.67342E-40)
            r50 = r1 & r50
            if (r50 == 0) goto L_0x01f3
            r50 = 0
            goto L_0x01f5
        L_0x01f3:
            r50 = r113
        L_0x01f5:
            r51 = 524288(0x80000, float:7.34684E-40)
            r51 = r1 & r51
            if (r51 == 0) goto L_0x01fe
            r51 = 0
            goto L_0x0200
        L_0x01fe:
            r51 = r114
        L_0x0200:
            r52 = 1048576(0x100000, float:1.469368E-39)
            r52 = r1 & r52
            if (r52 == 0) goto L_0x0209
            r52 = 0
            goto L_0x020b
        L_0x0209:
            r52 = r115
        L_0x020b:
            r53 = 2097152(0x200000, float:2.938736E-39)
            r53 = r1 & r53
            if (r53 == 0) goto L_0x0214
            r53 = 0
            goto L_0x0216
        L_0x0214:
            r53 = r116
        L_0x0216:
            r54 = 4194304(0x400000, float:5.877472E-39)
            r54 = r1 & r54
            if (r54 == 0) goto L_0x021f
            r54 = 0
            goto L_0x0221
        L_0x021f:
            r54 = r117
        L_0x0221:
            r55 = 8388608(0x800000, float:1.17549435E-38)
            r55 = r1 & r55
            if (r55 == 0) goto L_0x022a
            r55 = 0
            goto L_0x022c
        L_0x022a:
            r55 = r118
        L_0x022c:
            r56 = 16777216(0x1000000, float:2.3509887E-38)
            r56 = r1 & r56
            if (r56 == 0) goto L_0x0235
            r56 = 0
            goto L_0x0237
        L_0x0235:
            r56 = r119
        L_0x0237:
            r57 = 33554432(0x2000000, float:9.403955E-38)
            r57 = r1 & r57
            if (r57 == 0) goto L_0x0240
            r57 = 0
            goto L_0x0242
        L_0x0240:
            r57 = r120
        L_0x0242:
            r58 = 67108864(0x4000000, float:1.5046328E-36)
            r58 = r1 & r58
            if (r58 == 0) goto L_0x024b
            r58 = 0
            goto L_0x024d
        L_0x024b:
            r58 = r121
        L_0x024d:
            r59 = 134217728(0x8000000, float:3.85186E-34)
            r59 = r1 & r59
            if (r59 == 0) goto L_0x0256
            r59 = 0
            goto L_0x0258
        L_0x0256:
            r59 = r122
        L_0x0258:
            r60 = 268435456(0x10000000, float:2.5243549E-29)
            r60 = r1 & r60
            if (r60 == 0) goto L_0x0261
            r60 = 0
            goto L_0x0263
        L_0x0261:
            r60 = r123
        L_0x0263:
            r61 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r61
            if (r1 == 0) goto L_0x026b
            r1 = 0
            goto L_0x026d
        L_0x026b:
            r1 = r124
        L_0x026d:
            r63 = r62
            r64 = r2
            r65 = r4
            r66 = r5
            r67 = r6
            r68 = r7
            r69 = r8
            r70 = r9
            r71 = r10
            r72 = r11
            r73 = r12
            r74 = r13
            r75 = r14
            r76 = r15
            r77 = r16
            r78 = r3
            r79 = r17
            r80 = r18
            r81 = r19
            r82 = r20
            r83 = r21
            r84 = r22
            r85 = r23
            r86 = r24
            r87 = r25
            r88 = r26
            r89 = r27
            r90 = r28
            r91 = r29
            r92 = r30
            r93 = r31
            r94 = r32
            r95 = r125
            r96 = r33
            r97 = r34
            r98 = r35
            r99 = r36
            r100 = r37
            r101 = r38
            r102 = r39
            r103 = r40
            r104 = r41
            r105 = r42
            r106 = r43
            r107 = r44
            r108 = r45
            r109 = r46
            r110 = r0
            r111 = r47
            r112 = r48
            r113 = r49
            r114 = r50
            r115 = r51
            r116 = r52
            r117 = r53
            r118 = r54
            r119 = r55
            r120 = r56
            r121 = r57
            r122 = r58
            r123 = r59
            r124 = r60
            r125 = r1
            r63.<init>(r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Item.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.InfoObj, java.util.List, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MerchantAddress, java.util.List, java.util.List, java.lang.Boolean, java.lang.Boolean, java.lang.Object, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.Boolean, java.util.List, java.lang.Double, java.util.List, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Product, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Configuration, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Attributes_, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MetaInfo, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MetaData2, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.SubventionInfo, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Subscription, net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Fulfillment, java.lang.Boolean, java.lang.Integer, int, int, kotlin.g.b.g):void");
    }

    public final Integer getMaxExtendSla() {
        return this.maxExtendSla;
    }

    public final void setMaxExtendSla(Integer num) {
        this.maxExtendSla = num;
    }
}
