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

public final class CartItem extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "aggregate_conv_fee")
    private Double aggregateConvFee;
    @b(a = "aggregate_item_price")
    private Double aggregateItemPrice;
    @b(a = "brand")
    private String brand;
    @b(a = "categoryMap")
    private List<CategoryMap> categoryMap;
    @b(a = "configuration")
    private Configuration configuration;
    @b(a = "conv_fee")
    private Double convFee;
    @b(a = "conv_fee_map")
    private ConvFeeMap convFeeMap;
    @b(a = "discount")
    private Double discount;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "is_physical")
    private Boolean isPhysical;
    @b(a = "item_id")
    private String itemId;
    @b(a = "merchant_name")
    private String merchantName;
    @b(a = "meta_data")
    private MetaData metaData;
    @b(a = "mrp")
    private Double mrp;
    @b(a = "name")
    private String name;
    @b(a = "newurl")
    private String newurl;
    @b(a = "offer_url")
    private String offerUrl;
    @b(a = "price")
    private Double price;
    @b(a = "product_id")
    private Integer productId;
    @b(a = "promocode")
    private String promocode;
    @b(a = "promostatus")
    private String promostatus;
    @b(a = "promotext")
    private String promotext;
    @b(a = "promousage")
    private List<Promousage> promousage;
    @b(a = "quantity")
    private Integer quantity;
    @b(a = "selling_price")
    private Double sellingPrice;
    @b(a = "seourl")
    private String seourl;
    @b(a = "shipping_amount")
    private Double shippingAmount;
    @b(a = "shipping_charges")
    private Double shippingCharges;
    @b(a = "shipping_discount")
    private Double shippingDiscount;
    @b(a = "short_description")
    private ShortDescription shortDescription;
    @b(a = "title")
    private String title;
    @b(a = "total_price")
    private Double totalPrice;
    @b(a = "url")
    private String url;
    @b(a = "vertical_id")
    private Integer verticalId;
    @b(a = "vertical_label")
    private String verticalLabel;
    @b(a = "warehouse_id")
    private String warehouseId;

    public CartItem() {
        this((Integer) null, (String) null, (Integer) null, (String) null, (Configuration) null, (MetaData) null, (Double) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (ShortDescription) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (List) null, (ConvFeeMap) null, -1, 15, (g) null);
    }

    public static /* synthetic */ CartItem copy$default(CartItem cartItem, Integer num, String str, Integer num2, String str2, Configuration configuration2, MetaData metaData2, Double d2, String str3, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, Double d12, String str4, List list, String str5, String str6, String str7, String str8, String str9, Integer num3, String str10, ShortDescription shortDescription2, String str11, String str12, String str13, String str14, String str15, Boolean bool, List list2, ConvFeeMap convFeeMap2, int i2, int i3, Object obj) {
        CartItem cartItem2 = cartItem;
        int i4 = i2;
        return cartItem.copy((i4 & 1) != 0 ? cartItem2.productId : num, (i4 & 2) != 0 ? cartItem2.warehouseId : str, (i4 & 4) != 0 ? cartItem2.quantity : num2, (i4 & 8) != 0 ? cartItem2.promocode : str2, (i4 & 16) != 0 ? cartItem2.configuration : configuration2, (i4 & 32) != 0 ? cartItem2.metaData : metaData2, (i4 & 64) != 0 ? cartItem2.shippingCharges : d2, (i4 & 128) != 0 ? cartItem2.itemId : str3, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cartItem2.shippingAmount : d3, (i4 & 512) != 0 ? cartItem2.shippingDiscount : d4, (i4 & TarConstants.EOF_BLOCK) != 0 ? cartItem2.sellingPrice : d5, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cartItem2.aggregateConvFee : d6, (i4 & 4096) != 0 ? cartItem2.aggregateItemPrice : d7, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cartItem2.totalPrice : d8, (i4 & 16384) != 0 ? cartItem2.mrp : d9, (i4 & 32768) != 0 ? cartItem2.convFee : d10, (i4 & 65536) != 0 ? cartItem2.price : d11, (i4 & 131072) != 0 ? cartItem2.discount : d12, (i4 & 262144) != 0 ? cartItem2.promotext : str4, (i4 & 524288) != 0 ? cartItem2.promousage : list, (i4 & 1048576) != 0 ? cartItem2.promostatus : str5, (i4 & 2097152) != 0 ? cartItem2.imageUrl : str6, (i4 & 4194304) != 0 ? cartItem2.offerUrl : str7, (i4 & 8388608) != 0 ? cartItem2.title : str8, (i4 & 16777216) != 0 ? cartItem2.name : str9, (i4 & 33554432) != 0 ? cartItem2.verticalId : num3, (i4 & 67108864) != 0 ? cartItem2.verticalLabel : str10, (i4 & 134217728) != 0 ? cartItem2.shortDescription : shortDescription2, (i4 & 268435456) != 0 ? cartItem2.url : str11, (i4 & 536870912) != 0 ? cartItem2.newurl : str12, (i4 & 1073741824) != 0 ? cartItem2.seourl : str13, (i4 & Integer.MIN_VALUE) != 0 ? cartItem2.merchantName : str14, (i3 & 1) != 0 ? cartItem2.brand : str15, (i3 & 2) != 0 ? cartItem2.isPhysical : bool, (i3 & 4) != 0 ? cartItem2.categoryMap : list2, (i3 & 8) != 0 ? cartItem2.convFeeMap : convFeeMap2);
    }

    public final Integer component1() {
        return this.productId;
    }

    public final Double component10() {
        return this.shippingDiscount;
    }

    public final Double component11() {
        return this.sellingPrice;
    }

    public final Double component12() {
        return this.aggregateConvFee;
    }

    public final Double component13() {
        return this.aggregateItemPrice;
    }

    public final Double component14() {
        return this.totalPrice;
    }

    public final Double component15() {
        return this.mrp;
    }

    public final Double component16() {
        return this.convFee;
    }

    public final Double component17() {
        return this.price;
    }

    public final Double component18() {
        return this.discount;
    }

    public final String component19() {
        return this.promotext;
    }

    public final String component2() {
        return this.warehouseId;
    }

    public final List<Promousage> component20() {
        return this.promousage;
    }

    public final String component21() {
        return this.promostatus;
    }

    public final String component22() {
        return this.imageUrl;
    }

    public final String component23() {
        return this.offerUrl;
    }

    public final String component24() {
        return this.title;
    }

    public final String component25() {
        return this.name;
    }

    public final Integer component26() {
        return this.verticalId;
    }

    public final String component27() {
        return this.verticalLabel;
    }

    public final ShortDescription component28() {
        return this.shortDescription;
    }

    public final String component29() {
        return this.url;
    }

    public final Integer component3() {
        return this.quantity;
    }

    public final String component30() {
        return this.newurl;
    }

    public final String component31() {
        return this.seourl;
    }

    public final String component32() {
        return this.merchantName;
    }

    public final String component33() {
        return this.brand;
    }

    public final Boolean component34() {
        return this.isPhysical;
    }

    public final List<CategoryMap> component35() {
        return this.categoryMap;
    }

    public final ConvFeeMap component36() {
        return this.convFeeMap;
    }

    public final String component4() {
        return this.promocode;
    }

    public final Configuration component5() {
        return this.configuration;
    }

    public final MetaData component6() {
        return this.metaData;
    }

    public final Double component7() {
        return this.shippingCharges;
    }

    public final String component8() {
        return this.itemId;
    }

    public final Double component9() {
        return this.shippingAmount;
    }

    public final CartItem copy(Integer num, String str, Integer num2, String str2, Configuration configuration2, MetaData metaData2, Double d2, String str3, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, Double d12, String str4, List<Promousage> list, String str5, String str6, String str7, String str8, String str9, Integer num3, String str10, ShortDescription shortDescription2, String str11, String str12, String str13, String str14, String str15, Boolean bool, List<CategoryMap> list2, ConvFeeMap convFeeMap2) {
        return new CartItem(num, str, num2, str2, configuration2, metaData2, d2, str3, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, str4, list, str5, str6, str7, str8, str9, num3, str10, shortDescription2, str11, str12, str13, str14, str15, bool, list2, convFeeMap2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartItem)) {
            return false;
        }
        CartItem cartItem = (CartItem) obj;
        return k.a((Object) this.productId, (Object) cartItem.productId) && k.a((Object) this.warehouseId, (Object) cartItem.warehouseId) && k.a((Object) this.quantity, (Object) cartItem.quantity) && k.a((Object) this.promocode, (Object) cartItem.promocode) && k.a((Object) this.configuration, (Object) cartItem.configuration) && k.a((Object) this.metaData, (Object) cartItem.metaData) && k.a((Object) this.shippingCharges, (Object) cartItem.shippingCharges) && k.a((Object) this.itemId, (Object) cartItem.itemId) && k.a((Object) this.shippingAmount, (Object) cartItem.shippingAmount) && k.a((Object) this.shippingDiscount, (Object) cartItem.shippingDiscount) && k.a((Object) this.sellingPrice, (Object) cartItem.sellingPrice) && k.a((Object) this.aggregateConvFee, (Object) cartItem.aggregateConvFee) && k.a((Object) this.aggregateItemPrice, (Object) cartItem.aggregateItemPrice) && k.a((Object) this.totalPrice, (Object) cartItem.totalPrice) && k.a((Object) this.mrp, (Object) cartItem.mrp) && k.a((Object) this.convFee, (Object) cartItem.convFee) && k.a((Object) this.price, (Object) cartItem.price) && k.a((Object) this.discount, (Object) cartItem.discount) && k.a((Object) this.promotext, (Object) cartItem.promotext) && k.a((Object) this.promousage, (Object) cartItem.promousage) && k.a((Object) this.promostatus, (Object) cartItem.promostatus) && k.a((Object) this.imageUrl, (Object) cartItem.imageUrl) && k.a((Object) this.offerUrl, (Object) cartItem.offerUrl) && k.a((Object) this.title, (Object) cartItem.title) && k.a((Object) this.name, (Object) cartItem.name) && k.a((Object) this.verticalId, (Object) cartItem.verticalId) && k.a((Object) this.verticalLabel, (Object) cartItem.verticalLabel) && k.a((Object) this.shortDescription, (Object) cartItem.shortDescription) && k.a((Object) this.url, (Object) cartItem.url) && k.a((Object) this.newurl, (Object) cartItem.newurl) && k.a((Object) this.seourl, (Object) cartItem.seourl) && k.a((Object) this.merchantName, (Object) cartItem.merchantName) && k.a((Object) this.brand, (Object) cartItem.brand) && k.a((Object) this.isPhysical, (Object) cartItem.isPhysical) && k.a((Object) this.categoryMap, (Object) cartItem.categoryMap) && k.a((Object) this.convFeeMap, (Object) cartItem.convFeeMap);
    }

    public final int hashCode() {
        Integer num = this.productId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.warehouseId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.quantity;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.promocode;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Configuration configuration2 = this.configuration;
        int hashCode5 = (hashCode4 + (configuration2 != null ? configuration2.hashCode() : 0)) * 31;
        MetaData metaData2 = this.metaData;
        int hashCode6 = (hashCode5 + (metaData2 != null ? metaData2.hashCode() : 0)) * 31;
        Double d2 = this.shippingCharges;
        int hashCode7 = (hashCode6 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str3 = this.itemId;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d3 = this.shippingAmount;
        int hashCode9 = (hashCode8 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.shippingDiscount;
        int hashCode10 = (hashCode9 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.sellingPrice;
        int hashCode11 = (hashCode10 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.aggregateConvFee;
        int hashCode12 = (hashCode11 + (d6 != null ? d6.hashCode() : 0)) * 31;
        Double d7 = this.aggregateItemPrice;
        int hashCode13 = (hashCode12 + (d7 != null ? d7.hashCode() : 0)) * 31;
        Double d8 = this.totalPrice;
        int hashCode14 = (hashCode13 + (d8 != null ? d8.hashCode() : 0)) * 31;
        Double d9 = this.mrp;
        int hashCode15 = (hashCode14 + (d9 != null ? d9.hashCode() : 0)) * 31;
        Double d10 = this.convFee;
        int hashCode16 = (hashCode15 + (d10 != null ? d10.hashCode() : 0)) * 31;
        Double d11 = this.price;
        int hashCode17 = (hashCode16 + (d11 != null ? d11.hashCode() : 0)) * 31;
        Double d12 = this.discount;
        int hashCode18 = (hashCode17 + (d12 != null ? d12.hashCode() : 0)) * 31;
        String str4 = this.promotext;
        int hashCode19 = (hashCode18 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<Promousage> list = this.promousage;
        int hashCode20 = (hashCode19 + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.promostatus;
        int hashCode21 = (hashCode20 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageUrl;
        int hashCode22 = (hashCode21 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.offerUrl;
        int hashCode23 = (hashCode22 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.title;
        int hashCode24 = (hashCode23 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.name;
        int hashCode25 = (hashCode24 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Integer num3 = this.verticalId;
        int hashCode26 = (hashCode25 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str10 = this.verticalLabel;
        int hashCode27 = (hashCode26 + (str10 != null ? str10.hashCode() : 0)) * 31;
        ShortDescription shortDescription2 = this.shortDescription;
        int hashCode28 = (hashCode27 + (shortDescription2 != null ? shortDescription2.hashCode() : 0)) * 31;
        String str11 = this.url;
        int hashCode29 = (hashCode28 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.newurl;
        int hashCode30 = (hashCode29 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.seourl;
        int hashCode31 = (hashCode30 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.merchantName;
        int hashCode32 = (hashCode31 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.brand;
        int hashCode33 = (hashCode32 + (str15 != null ? str15.hashCode() : 0)) * 31;
        Boolean bool = this.isPhysical;
        int hashCode34 = (hashCode33 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<CategoryMap> list2 = this.categoryMap;
        int hashCode35 = (hashCode34 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ConvFeeMap convFeeMap2 = this.convFeeMap;
        if (convFeeMap2 != null) {
            i2 = convFeeMap2.hashCode();
        }
        return hashCode35 + i2;
    }

    public final String toString() {
        return "CartItem(productId=" + this.productId + ", warehouseId=" + this.warehouseId + ", quantity=" + this.quantity + ", promocode=" + this.promocode + ", configuration=" + this.configuration + ", metaData=" + this.metaData + ", shippingCharges=" + this.shippingCharges + ", itemId=" + this.itemId + ", shippingAmount=" + this.shippingAmount + ", shippingDiscount=" + this.shippingDiscount + ", sellingPrice=" + this.sellingPrice + ", aggregateConvFee=" + this.aggregateConvFee + ", aggregateItemPrice=" + this.aggregateItemPrice + ", totalPrice=" + this.totalPrice + ", mrp=" + this.mrp + ", convFee=" + this.convFee + ", price=" + this.price + ", discount=" + this.discount + ", promotext=" + this.promotext + ", promousage=" + this.promousage + ", promostatus=" + this.promostatus + ", imageUrl=" + this.imageUrl + ", offerUrl=" + this.offerUrl + ", title=" + this.title + ", name=" + this.name + ", verticalId=" + this.verticalId + ", verticalLabel=" + this.verticalLabel + ", shortDescription=" + this.shortDescription + ", url=" + this.url + ", newurl=" + this.newurl + ", seourl=" + this.seourl + ", merchantName=" + this.merchantName + ", brand=" + this.brand + ", isPhysical=" + this.isPhysical + ", categoryMap=" + this.categoryMap + ", convFeeMap=" + this.convFeeMap + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    public final MetaData getMetaData() {
        return this.metaData;
    }

    public final Integer getProductId() {
        return this.productId;
    }

    public final String getPromocode() {
        return this.promocode;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final Double getShippingCharges() {
        return this.shippingCharges;
    }

    public final String getWarehouseId() {
        return this.warehouseId;
    }

    public final void setConfiguration(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public final void setMetaData(MetaData metaData2) {
        this.metaData = metaData2;
    }

    public final void setProductId(Integer num) {
        this.productId = num;
    }

    public final void setPromocode(String str) {
        this.promocode = str;
    }

    public final void setQuantity(Integer num) {
        this.quantity = num;
    }

    public final void setShippingCharges(Double d2) {
        this.shippingCharges = d2;
    }

    public final void setWarehouseId(String str) {
        this.warehouseId = str;
    }

    public final Double getAggregateConvFee() {
        return this.aggregateConvFee;
    }

    public final Double getAggregateItemPrice() {
        return this.aggregateItemPrice;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Double getSellingPrice() {
        return this.sellingPrice;
    }

    public final Double getShippingAmount() {
        return this.shippingAmount;
    }

    public final Double getShippingDiscount() {
        return this.shippingDiscount;
    }

    public final Double getTotalPrice() {
        return this.totalPrice;
    }

    public final void setAggregateConvFee(Double d2) {
        this.aggregateConvFee = d2;
    }

    public final void setAggregateItemPrice(Double d2) {
        this.aggregateItemPrice = d2;
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final void setSellingPrice(Double d2) {
        this.sellingPrice = d2;
    }

    public final void setShippingAmount(Double d2) {
        this.shippingAmount = d2;
    }

    public final void setShippingDiscount(Double d2) {
        this.shippingDiscount = d2;
    }

    public final void setTotalPrice(Double d2) {
        this.totalPrice = d2;
    }

    public final Double getConvFee() {
        return this.convFee;
    }

    public final Double getDiscount() {
        return this.discount;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Double getMrp() {
        return this.mrp;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final String getPromostatus() {
        return this.promostatus;
    }

    public final String getPromotext() {
        return this.promotext;
    }

    public final List<Promousage> getPromousage() {
        return this.promousage;
    }

    public final void setConvFee(Double d2) {
        this.convFee = d2;
    }

    public final void setDiscount(Double d2) {
        this.discount = d2;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final void setMrp(Double d2) {
        this.mrp = d2;
    }

    public final void setPrice(Double d2) {
        this.price = d2;
    }

    public final void setPromostatus(String str) {
        this.promostatus = str;
    }

    public final void setPromotext(String str) {
        this.promotext = str;
    }

    public final void setPromousage(List<Promousage> list) {
        this.promousage = list;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNewurl() {
        return this.newurl;
    }

    public final String getOfferUrl() {
        return this.offerUrl;
    }

    public final ShortDescription getShortDescription() {
        return this.shortDescription;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getVerticalId() {
        return this.verticalId;
    }

    public final String getVerticalLabel() {
        return this.verticalLabel;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNewurl(String str) {
        this.newurl = str;
    }

    public final void setOfferUrl(String str) {
        this.offerUrl = str;
    }

    public final void setShortDescription(ShortDescription shortDescription2) {
        this.shortDescription = shortDescription2;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setVerticalId(Integer num) {
        this.verticalId = num;
    }

    public final void setVerticalLabel(String str) {
        this.verticalLabel = str;
    }

    public CartItem(Integer num, String str, Integer num2, String str2, Configuration configuration2, MetaData metaData2, Double d2, String str3, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Double d11, Double d12, String str4, List<Promousage> list, String str5, String str6, String str7, String str8, String str9, Integer num3, String str10, ShortDescription shortDescription2, String str11, String str12, String str13, String str14, String str15, Boolean bool, List<CategoryMap> list2, ConvFeeMap convFeeMap2) {
        this.productId = num;
        this.warehouseId = str;
        this.quantity = num2;
        this.promocode = str2;
        this.configuration = configuration2;
        this.metaData = metaData2;
        this.shippingCharges = d2;
        this.itemId = str3;
        this.shippingAmount = d3;
        this.shippingDiscount = d4;
        this.sellingPrice = d5;
        this.aggregateConvFee = d6;
        this.aggregateItemPrice = d7;
        this.totalPrice = d8;
        this.mrp = d9;
        this.convFee = d10;
        this.price = d11;
        this.discount = d12;
        this.promotext = str4;
        this.promousage = list;
        this.promostatus = str5;
        this.imageUrl = str6;
        this.offerUrl = str7;
        this.title = str8;
        this.name = str9;
        this.verticalId = num3;
        this.verticalLabel = str10;
        this.shortDescription = shortDescription2;
        this.url = str11;
        this.newurl = str12;
        this.seourl = str13;
        this.merchantName = str14;
        this.brand = str15;
        this.isPhysical = bool;
        this.categoryMap = list2;
        this.convFeeMap = convFeeMap2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CartItem(java.lang.Integer r37, java.lang.String r38, java.lang.Integer r39, java.lang.String r40, net.one97.paytm.p2mNewDesign.entity.mlv.Configuration r41, net.one97.paytm.p2mNewDesign.entity.mlv.MetaData r42, java.lang.Double r43, java.lang.String r44, java.lang.Double r45, java.lang.Double r46, java.lang.Double r47, java.lang.Double r48, java.lang.Double r49, java.lang.Double r50, java.lang.Double r51, java.lang.Double r52, java.lang.Double r53, java.lang.Double r54, java.lang.String r55, java.util.List r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.Integer r62, java.lang.String r63, net.one97.paytm.p2mNewDesign.entity.mlv.ShortDescription r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.lang.Boolean r70, java.util.List r71, net.one97.paytm.p2mNewDesign.entity.mlv.ConvFeeMap r72, int r73, int r74, kotlin.g.b.g r75) {
        /*
            r36 = this;
            r0 = r73
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r37
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r38
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r39
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r40
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r41
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r42
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r43
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r44
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r45
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r46
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r47
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r48
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r49
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r50
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r51
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r52
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r53
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r54
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r55
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r56
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r57
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r58
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r59
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r60
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r61
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r62
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r63
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r64
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            r29 = 0
            goto L_0x0115
        L_0x0113:
            r29 = r65
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x011e
            r30 = 0
            goto L_0x0120
        L_0x011e:
            r30 = r66
        L_0x0120:
            r31 = 1073741824(0x40000000, float:2.0)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0129
            r31 = 0
            goto L_0x012b
        L_0x0129:
            r31 = r67
        L_0x012b:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x0133
            r0 = 0
            goto L_0x0135
        L_0x0133:
            r0 = r68
        L_0x0135:
            r32 = r74 & 1
            if (r32 == 0) goto L_0x013c
            r32 = 0
            goto L_0x013e
        L_0x013c:
            r32 = r69
        L_0x013e:
            r33 = r74 & 2
            if (r33 == 0) goto L_0x0145
            r33 = 0
            goto L_0x0147
        L_0x0145:
            r33 = r70
        L_0x0147:
            r34 = r74 & 4
            if (r34 == 0) goto L_0x014e
            r34 = 0
            goto L_0x0150
        L_0x014e:
            r34 = r71
        L_0x0150:
            r35 = r74 & 8
            if (r35 == 0) goto L_0x0157
            r35 = 0
            goto L_0x0159
        L_0x0157:
            r35 = r72
        L_0x0159:
            r37 = r36
            r38 = r1
            r39 = r3
            r40 = r4
            r41 = r5
            r42 = r6
            r43 = r7
            r44 = r8
            r45 = r9
            r46 = r10
            r47 = r11
            r48 = r12
            r49 = r13
            r50 = r14
            r51 = r15
            r52 = r2
            r53 = r16
            r54 = r17
            r55 = r18
            r56 = r19
            r57 = r20
            r58 = r21
            r59 = r22
            r60 = r23
            r61 = r24
            r62 = r25
            r63 = r26
            r64 = r27
            r65 = r28
            r66 = r29
            r67 = r30
            r68 = r31
            r69 = r0
            r70 = r32
            r71 = r33
            r72 = r34
            r73 = r35
            r37.<init>(r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.CartItem.<init>(java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.Configuration, net.one97.paytm.p2mNewDesign.entity.mlv.MetaData, java.lang.Double, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.ShortDescription, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.util.List, net.one97.paytm.p2mNewDesign.entity.mlv.ConvFeeMap, int, int, kotlin.g.b.g):void");
    }

    public final String getBrand() {
        return this.brand;
    }

    public final List<CategoryMap> getCategoryMap() {
        return this.categoryMap;
    }

    public final ConvFeeMap getConvFeeMap() {
        return this.convFeeMap;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final String getSeourl() {
        return this.seourl;
    }

    public final Boolean isPhysical() {
        return this.isPhysical;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final void setCategoryMap(List<CategoryMap> list) {
        this.categoryMap = list;
    }

    public final void setConvFeeMap(ConvFeeMap convFeeMap2) {
        this.convFeeMap = convFeeMap2;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public final void setPhysical(Boolean bool) {
        this.isPhysical = bool;
    }

    public final void setSeourl(String str) {
        this.seourl = str;
    }
}
