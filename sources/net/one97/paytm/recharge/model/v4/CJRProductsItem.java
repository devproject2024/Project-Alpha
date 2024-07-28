package net.one97.paytm.recharge.model.v4;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRProductsItem implements IJRDataModel {
    @b(a = "dynamic_plan")
    private final String _dynamicPlan;
    @b(a = "dynamicPlanCategoryLabel")
    private final String _dynamicPlanCategoryLabel;
    @b(a = "dynamic_plan_category_label")
    private final String _dynamic_plan_category_label;
    @b(a = "maxAmount")
    private final String _maxAmount;
    @b(a = "max_amount")
    private final String _max_Amount;
    @b(a = "minAmount")
    private final String _minAmount;
    @b(a = "min_amount")
    private final String _min_Amount;
    @b(a = "show_browse_plan")
    private final String _showBrowsePlan;
    @b(a = "One2One_offer")
    private final String _showOne2OneOffer;
    @b(a = "One2One_user_offer")
    private final String _showOne2OneUserOffer;
    @b(a = "alert")
    private final CJRUtilityAlertV2 alert;
    @b(a = "amount_buttons")
    private final String amountButtons;
    @b(a = "is_bank_mandate_enabled")
    private String bankEMandateEnable;
    @b(a = "bank_name_logo")
    private String bankNameLogoV4;
    @b(a = "bbpsLogoUrl")
    private String bbpsLogoUrl;
    @b(a = "bbps_logo_url")
    private String bbps_logo_url;
    @b(a = "board")
    private final String board;
    @b(a = "bottomsheet_canceltext")
    private final String bottomSheetCancelText;
    @b(a = "bottomsheet_checkboxtext")
    private final String bottomSheetCheckBoxText;
    @b(a = "bottomsheet_heading")
    private final String bottomSheetHeading;
    @b(a = "bottomsheet_message")
    private final String bottomSheetMessage;
    @b(a = "bottomsheet_oktext")
    private final String bottomSheetOkText;
    @b(a = "card_bg")
    private String cardBgV4;
    @b(a = "card_network_logo")
    private String cardTypeLogo;
    @b(a = "catalogProductId")
    private final Integer catalogProductId;
    @b(a = "groupingCheckbox")
    private final String checkBoxKey;
    @b(a = "checkbox_display_type")
    private final String checkboxDisplayType;
    @b(a = "checkbox_flow_type")
    private final String checkboxFlowType;
    @b(a = "checkbox_screen_title")
    private final String checkboxScreenTitle;
    private final String circle;
    @b(a = "circle_label")
    private final String circleLabel;
    @b(a = "city")
    private final String city;
    @b(a = "credit_card_length")
    private final String creditCardLength;
    @b(a = "deals_message")
    private final String dealsMessage;
    @b(a = "declaration_caption")
    private final String declarationCaption;
    @b(a = "declaration_cta")
    private final String declarationCta;
    @b(a = "declaration_text_1")
    private final String declarationText1;
    @b(a = "declaration_text_2")
    private final String declarationText2;
    @b(a = "description")
    private final String description;
    @b(a = "disclaimer")
    private final String disclaimer;
    @b(a = "disclaimer_image")
    private final String disclaimerImage;
    @b(a = "disclaimer_new")
    private final String disclaimerNew;
    @b(a = "displayName")
    private final String displayName;
    @b(a = "dth_amountfetch")
    private final String dthAmountFetch;
    @b(a = "dthhelp")
    private final List<Help> dthHelp;
    @b(a = "dynamic_plans_grouping")
    private List<? extends Map<?, ?>> dynamicPlansGrouping;
    @b(a = "enable_bill_payment")
    private final int enableBillPayment;
    @b(a = "enable_visa_direct")
    private final int enableVisaDirect;
    @b(a = "flow_image")
    private final String errorImage;
    @b(a = "extnAttrs")
    private final CJRExtensionAttributes extnAttrs;
    @b(a = "fee_type_visibility")
    private String feeTypeVisibility;
    @b(a = "fetch_amount")
    private final String fetchAmount;
    @b(a = "groupConfigKey")
    private final String groupConfigKey;
    @b(a = "group_config_key")
    private final String group_Config_Key;
    @b(a = "hide_fastforward")
    private final Boolean hide_fastforward;
    @b(a = "image")
    private final String image;
    private final String imageUrl;
    @b(a = "inputFields")
    private final List<CJRInputFieldsItem> inputFields;
    private final String metaDescription;
    private final String metaTitle;
    @b(a = "offers_for_you")
    private final String offersForYou;
    @b(a = "offers_for_you-disclaimer")
    private final String offersForYouDisclaimer;
    @b(a = "One2One_offer_disclaimer")
    private final String one2OneDisclaimerText;
    @b(a = "One2One_offer_text")
    private final String one2OneOfferText;
    @b(a = "operator")
    private final String operator;
    @b(a = "operator_display_label")
    private final String operatorDisplayLabel;
    @b(a = "operator_label")
    private final String operatorLabel;
    @b(a = "overrideAttrs")
    private final Object overrideAttrs;
    @b(a = "payTypeSupported")
    private final HashMap<String, Integer> payTypeSupported;
    @b(a = "paytpaytypeLabelype")
    private final String paytpaytypeLabelype;
    @b(a = "paytype")
    private final String paytype;
    @b(a = "post_order_view_type")
    private final String postOrderViewType;
    @b(a = "prefetch")
    private final String prefetch;
    @b(a = "price")
    private final Double price;
    @b(a = "proceed_directly_to_PG")
    private final String proceedDirectlyToPG;
    @b(a = "productId")
    private final Long productId;
    @b(a = "producttype")
    private final String productType;
    @b(a = "producttype_label")
    private final String productTypeLabel;
    @b(a = "remindable")
    private String remindable;
    @b(a = "request_type")
    private final String requestType;
    @b(a = "service")
    private final String service;
    @b(a = "service_display_label")
    private String serviceDisplayLabel;
    @b(a = "serviceLabel")
    private final String serviceLabel;
    @b(a = "show_display_values")
    private final String showDisplayValues;
    @b(a = "show_view_bill")
    private final String showViewBill;
    @b(a = "softprefetch")
    private final String softPrefetch;
    @b(a = "state")
    private final String state;
    private final String status;
    @b(a = "offer_widget_url")
    private final String thinBannerURL;
    @b(a = "user_consent")
    private final String userConsent;
    @b(a = "vending_charge")
    private final String vendingCharge;
    @b(a = "verticalId")
    private final String verticalId;
    @b(a = "voda_fetchbill")
    private final String vodaFetchbill;
    @b(a = "warehouseId")
    private final Integer warehouseId;

    public CJRProductsItem() {
        this((String) null, (HashMap) null, (String) null, (CJRUtilityAlertV2) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (CJRExtensionAttributes) null, (String) null, (Integer) null, (Boolean) null, (String) null, (String) null, (Object) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, -1, -1, 1073741823, (g) null);
    }

    private final String component1() {
        return this._minAmount;
    }

    private final String component10() {
        return this.vodaFetchbill;
    }

    private final String component15() {
        return this.showViewBill;
    }

    private final String component19() {
        return this._maxAmount;
    }

    private final String component36() {
        return this.showDisplayValues;
    }

    private final String component51() {
        return this._showBrowsePlan;
    }

    private final String component52() {
        return this._dynamicPlan;
    }

    private final String component53() {
        return this._showOne2OneOffer;
    }

    private final String component54() {
        return this._showOne2OneUserOffer;
    }

    private final String component56() {
        return this._dynamicPlanCategoryLabel;
    }

    private final String component57() {
        return this._dynamic_plan_category_label;
    }

    private final String component58() {
        return this.vendingCharge;
    }

    private final String component65() {
        return this._max_Amount;
    }

    private final String component67() {
        return this._min_Amount;
    }

    private final String component80() {
        return this.amountButtons;
    }

    private final String component81() {
        return this.proceedDirectlyToPG;
    }

    private final String component9() {
        return this.fetchAmount;
    }

    public static /* synthetic */ CJRProductsItem copy$default(CJRProductsItem cJRProductsItem, String str, HashMap hashMap, String str2, CJRUtilityAlertV2 cJRUtilityAlertV2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, String str11, String str12, List list, Double d2, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Long l, CJRExtensionAttributes cJRExtensionAttributes, String str20, Integer num2, Boolean bool, String str21, String str22, Object obj, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, int i2, int i3, String str59, String str60, String str61, String str62, String str63, String str64, String str65, String str66, String str67, String str68, String str69, String str70, String str71, List list2, String str72, String str73, String str74, String str75, String str76, List list3, String str77, String str78, String str79, String str80, int i4, int i5, int i6, Object obj2) {
        CJRProductsItem cJRProductsItem2 = cJRProductsItem;
        int i7 = i4;
        int i8 = i5;
        int i9 = i6;
        return cJRProductsItem.copy((i7 & 1) != 0 ? cJRProductsItem2._minAmount : str, (i7 & 2) != 0 ? cJRProductsItem2.payTypeSupported : hashMap, (i7 & 4) != 0 ? cJRProductsItem2.city : str2, (i7 & 8) != 0 ? cJRProductsItem2.alert : cJRUtilityAlertV2, (i7 & 16) != 0 ? cJRProductsItem2.paytpaytypeLabelype : str3, (i7 & 32) != 0 ? cJRProductsItem2.displayName : str4, (i7 & 64) != 0 ? cJRProductsItem2.prefetch : str5, (i7 & 128) != 0 ? cJRProductsItem2.softPrefetch : str6, (i7 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRProductsItem2.fetchAmount : str7, (i7 & 512) != 0 ? cJRProductsItem2.vodaFetchbill : str8, (i7 & TarConstants.EOF_BLOCK) != 0 ? cJRProductsItem2.catalogProductId : num, (i7 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRProductsItem2.description : str9, (i7 & 4096) != 0 ? cJRProductsItem2.operator : str10, (i7 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRProductsItem2.productType : str11, (i7 & 16384) != 0 ? cJRProductsItem2.showViewBill : str12, (i7 & 32768) != 0 ? cJRProductsItem2.inputFields : list, (i7 & 65536) != 0 ? cJRProductsItem2.price : d2, (i7 & 131072) != 0 ? cJRProductsItem2.state : str13, (i7 & 262144) != 0 ? cJRProductsItem2._maxAmount : str14, (i7 & 524288) != 0 ? cJRProductsItem2.disclaimer : str15, (i7 & 1048576) != 0 ? cJRProductsItem2.disclaimerNew : str16, (i7 & 2097152) != 0 ? cJRProductsItem2.disclaimerImage : str17, (i7 & 4194304) != 0 ? cJRProductsItem2.serviceLabel : str18, (i7 & 8388608) != 0 ? cJRProductsItem2.creditCardLength : str19, (i7 & 16777216) != 0 ? cJRProductsItem2.productId : l, (i7 & 33554432) != 0 ? cJRProductsItem2.extnAttrs : cJRExtensionAttributes, (i7 & 67108864) != 0 ? cJRProductsItem2.verticalId : str20, (i7 & 134217728) != 0 ? cJRProductsItem2.warehouseId : num2, (i7 & 268435456) != 0 ? cJRProductsItem2.hide_fastforward : bool, (i7 & 536870912) != 0 ? cJRProductsItem2.service : str21, (i7 & 1073741824) != 0 ? cJRProductsItem2.paytype : str22, (i7 & Integer.MIN_VALUE) != 0 ? cJRProductsItem2.overrideAttrs : obj, (i8 & 1) != 0 ? cJRProductsItem2.board : str23, (i8 & 2) != 0 ? cJRProductsItem2.groupConfigKey : str24, (i8 & 4) != 0 ? cJRProductsItem2.checkBoxKey : str25, (i8 & 8) != 0 ? cJRProductsItem2.showDisplayValues : str26, (i8 & 16) != 0 ? cJRProductsItem2.checkboxDisplayType : str27, (i8 & 32) != 0 ? cJRProductsItem2.checkboxScreenTitle : str28, (i8 & 64) != 0 ? cJRProductsItem2.checkboxFlowType : str29, (i8 & 128) != 0 ? cJRProductsItem2.dealsMessage : str30, (i8 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRProductsItem2.bottomSheetHeading : str31, (i8 & 512) != 0 ? cJRProductsItem2.bottomSheetCancelText : str32, (i8 & TarConstants.EOF_BLOCK) != 0 ? cJRProductsItem2.bottomSheetMessage : str33, (i8 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRProductsItem2.bottomSheetOkText : str34, (i8 & 4096) != 0 ? cJRProductsItem2.bottomSheetCheckBoxText : str35, (i8 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRProductsItem2.errorImage : str36, (i8 & 16384) != 0 ? cJRProductsItem2.image : str37, (i8 & 32768) != 0 ? cJRProductsItem2.remindable : str38, (i8 & 65536) != 0 ? cJRProductsItem2.feeTypeVisibility : str39, (i8 & 131072) != 0 ? cJRProductsItem2.metaDescription : str40, (i8 & 262144) != 0 ? cJRProductsItem2._showBrowsePlan : str41, (i8 & 524288) != 0 ? cJRProductsItem2._dynamicPlan : str42, (i8 & 1048576) != 0 ? cJRProductsItem2._showOne2OneOffer : str43, (i8 & 2097152) != 0 ? cJRProductsItem2._showOne2OneUserOffer : str44, (i8 & 4194304) != 0 ? cJRProductsItem2.one2OneOfferText : str45, (i8 & 8388608) != 0 ? cJRProductsItem2._dynamicPlanCategoryLabel : str46, (i8 & 16777216) != 0 ? cJRProductsItem2._dynamic_plan_category_label : str47, (i8 & 33554432) != 0 ? cJRProductsItem2.vendingCharge : str48, (i8 & 67108864) != 0 ? cJRProductsItem2.circle : str49, (i8 & 134217728) != 0 ? cJRProductsItem2.operatorLabel : str50, (i8 & 268435456) != 0 ? cJRProductsItem2.operatorDisplayLabel : str51, (i8 & 536870912) != 0 ? cJRProductsItem2.group_Config_Key : str52, (i8 & 1073741824) != 0 ? cJRProductsItem2.status : str53, (i8 & Integer.MIN_VALUE) != 0 ? cJRProductsItem2.bankEMandateEnable : str54, (i9 & 1) != 0 ? cJRProductsItem2._max_Amount : str55, (i9 & 2) != 0 ? cJRProductsItem2.circleLabel : str56, (i9 & 4) != 0 ? cJRProductsItem2._min_Amount : str57, (i9 & 8) != 0 ? cJRProductsItem2.productTypeLabel : str58, (i9 & 16) != 0 ? cJRProductsItem2.enableBillPayment : i2, (i9 & 32) != 0 ? cJRProductsItem2.enableVisaDirect : i3, (i9 & 64) != 0 ? cJRProductsItem2.imageUrl : str59, (i9 & 128) != 0 ? cJRProductsItem2.metaTitle : str60, (i9 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRProductsItem2.postOrderViewType : str61, (i9 & 512) != 0 ? cJRProductsItem2.one2OneDisclaimerText : str62, (i9 & TarConstants.EOF_BLOCK) != 0 ? cJRProductsItem2.declarationCaption : str63, (i9 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRProductsItem2.declarationText1 : str64, (i9 & 4096) != 0 ? cJRProductsItem2.declarationText2 : str65, (i9 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRProductsItem2.declarationCta : str66, (i9 & 16384) != 0 ? cJRProductsItem2.userConsent : str67, (i9 & 32768) != 0 ? cJRProductsItem2.amountButtons : str68, (i9 & 65536) != 0 ? cJRProductsItem2.proceedDirectlyToPG : str69, (i9 & 131072) != 0 ? cJRProductsItem2.thinBannerURL : str70, (i9 & 262144) != 0 ? cJRProductsItem2.requestType : str71, (i9 & 524288) != 0 ? cJRProductsItem2.dthHelp : list2, (i9 & 1048576) != 0 ? cJRProductsItem2.dthAmountFetch : str72, (i9 & 2097152) != 0 ? cJRProductsItem2.offersForYou : str73, (i9 & 4194304) != 0 ? cJRProductsItem2.offersForYouDisclaimer : str74, (i9 & 8388608) != 0 ? cJRProductsItem2.bbpsLogoUrl : str75, (i9 & 16777216) != 0 ? cJRProductsItem2.bbps_logo_url : str76, (i9 & 33554432) != 0 ? cJRProductsItem2.dynamicPlansGrouping : list3, (i9 & 67108864) != 0 ? cJRProductsItem2.bankNameLogoV4 : str77, (i9 & 134217728) != 0 ? cJRProductsItem2.cardBgV4 : str78, (i9 & 268435456) != 0 ? cJRProductsItem2.cardTypeLogo : str79, (i9 & 536870912) != 0 ? cJRProductsItem2.serviceDisplayLabel : str80);
    }

    public final Integer component11() {
        return this.catalogProductId;
    }

    public final String component12() {
        return this.description;
    }

    public final String component13() {
        return this.operator;
    }

    public final String component14() {
        return this.productType;
    }

    public final List<CJRInputFieldsItem> component16() {
        return this.inputFields;
    }

    public final Double component17() {
        return this.price;
    }

    public final String component18() {
        return this.state;
    }

    public final HashMap<String, Integer> component2() {
        return this.payTypeSupported;
    }

    public final String component20() {
        return this.disclaimer;
    }

    public final String component21() {
        return this.disclaimerNew;
    }

    public final String component22() {
        return this.disclaimerImage;
    }

    public final String component23() {
        return this.serviceLabel;
    }

    public final String component24() {
        return this.creditCardLength;
    }

    public final Long component25() {
        return this.productId;
    }

    public final CJRExtensionAttributes component26() {
        return this.extnAttrs;
    }

    public final String component27() {
        return this.verticalId;
    }

    public final Integer component28() {
        return this.warehouseId;
    }

    public final Boolean component29() {
        return this.hide_fastforward;
    }

    public final String component3() {
        return this.city;
    }

    public final String component30() {
        return this.service;
    }

    public final String component31() {
        return this.paytype;
    }

    public final Object component32() {
        return this.overrideAttrs;
    }

    public final String component33() {
        return this.board;
    }

    public final String component34() {
        return this.groupConfigKey;
    }

    public final String component35() {
        return this.checkBoxKey;
    }

    public final String component37() {
        return this.checkboxDisplayType;
    }

    public final String component38() {
        return this.checkboxScreenTitle;
    }

    public final String component39() {
        return this.checkboxFlowType;
    }

    public final CJRUtilityAlertV2 component4() {
        return this.alert;
    }

    public final String component40() {
        return this.dealsMessage;
    }

    public final String component41() {
        return this.bottomSheetHeading;
    }

    public final String component42() {
        return this.bottomSheetCancelText;
    }

    public final String component43() {
        return this.bottomSheetMessage;
    }

    public final String component44() {
        return this.bottomSheetOkText;
    }

    public final String component45() {
        return this.bottomSheetCheckBoxText;
    }

    public final String component46() {
        return this.errorImage;
    }

    public final String component47() {
        return this.image;
    }

    public final String component48() {
        return this.remindable;
    }

    public final String component49() {
        return this.feeTypeVisibility;
    }

    public final String component5() {
        return this.paytpaytypeLabelype;
    }

    public final String component50() {
        return this.metaDescription;
    }

    public final String component55() {
        return this.one2OneOfferText;
    }

    public final String component59() {
        return this.circle;
    }

    public final String component6() {
        return this.displayName;
    }

    public final String component60() {
        return this.operatorLabel;
    }

    public final String component61() {
        return this.operatorDisplayLabel;
    }

    public final String component62() {
        return this.group_Config_Key;
    }

    public final String component63() {
        return this.status;
    }

    public final String component64() {
        return this.bankEMandateEnable;
    }

    public final String component66() {
        return this.circleLabel;
    }

    public final String component68() {
        return this.productTypeLabel;
    }

    public final int component69() {
        return this.enableBillPayment;
    }

    public final String component7() {
        return this.prefetch;
    }

    public final int component70() {
        return this.enableVisaDirect;
    }

    public final String component71() {
        return this.imageUrl;
    }

    public final String component72() {
        return this.metaTitle;
    }

    public final String component73() {
        return this.postOrderViewType;
    }

    public final String component74() {
        return this.one2OneDisclaimerText;
    }

    public final String component75() {
        return this.declarationCaption;
    }

    public final String component76() {
        return this.declarationText1;
    }

    public final String component77() {
        return this.declarationText2;
    }

    public final String component78() {
        return this.declarationCta;
    }

    public final String component79() {
        return this.userConsent;
    }

    public final String component8() {
        return this.softPrefetch;
    }

    public final String component82() {
        return this.thinBannerURL;
    }

    public final String component83() {
        return this.requestType;
    }

    public final List<Help> component84() {
        return this.dthHelp;
    }

    public final String component85() {
        return this.dthAmountFetch;
    }

    public final String component86() {
        return this.offersForYou;
    }

    public final String component87() {
        return this.offersForYouDisclaimer;
    }

    public final String component88() {
        return this.bbpsLogoUrl;
    }

    public final String component89() {
        return this.bbps_logo_url;
    }

    public final List<Map<?, ?>> component90() {
        return this.dynamicPlansGrouping;
    }

    public final String component91() {
        return this.bankNameLogoV4;
    }

    public final String component92() {
        return this.cardBgV4;
    }

    public final String component93() {
        return this.cardTypeLogo;
    }

    public final String component94() {
        return this.serviceDisplayLabel;
    }

    public final CJRProductsItem copy(String str, HashMap<String, Integer> hashMap, String str2, CJRUtilityAlertV2 cJRUtilityAlertV2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, String str11, String str12, List<CJRInputFieldsItem> list, Double d2, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Long l, CJRExtensionAttributes cJRExtensionAttributes, String str20, Integer num2, Boolean bool, String str21, String str22, Object obj, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, int i2, int i3, String str59, String str60, String str61, String str62, String str63, String str64, String str65, String str66, String str67, String str68, String str69, String str70, String str71, List<Help> list2, String str72, String str73, String str74, String str75, String str76, List<? extends Map<?, ?>> list3, String str77, String str78, String str79, String str80) {
        return new CJRProductsItem(str, hashMap, str2, cJRUtilityAlertV2, str3, str4, str5, str6, str7, str8, num, str9, str10, str11, str12, list, d2, str13, str14, str15, str16, str17, str18, str19, l, cJRExtensionAttributes, str20, num2, bool, str21, str22, obj, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, i2, i3, str59, str60, str61, str62, str63, str64, str65, str66, str67, str68, str69, str70, str71, list2, str72, str73, str74, str75, str76, list3, str77, str78, str79, str80);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRProductsItem) {
                CJRProductsItem cJRProductsItem = (CJRProductsItem) obj;
                if (k.a((Object) this._minAmount, (Object) cJRProductsItem._minAmount) && k.a((Object) this.payTypeSupported, (Object) cJRProductsItem.payTypeSupported) && k.a((Object) this.city, (Object) cJRProductsItem.city) && k.a((Object) this.alert, (Object) cJRProductsItem.alert) && k.a((Object) this.paytpaytypeLabelype, (Object) cJRProductsItem.paytpaytypeLabelype) && k.a((Object) this.displayName, (Object) cJRProductsItem.displayName) && k.a((Object) this.prefetch, (Object) cJRProductsItem.prefetch) && k.a((Object) this.softPrefetch, (Object) cJRProductsItem.softPrefetch) && k.a((Object) this.fetchAmount, (Object) cJRProductsItem.fetchAmount) && k.a((Object) this.vodaFetchbill, (Object) cJRProductsItem.vodaFetchbill) && k.a((Object) this.catalogProductId, (Object) cJRProductsItem.catalogProductId) && k.a((Object) this.description, (Object) cJRProductsItem.description) && k.a((Object) this.operator, (Object) cJRProductsItem.operator) && k.a((Object) this.productType, (Object) cJRProductsItem.productType) && k.a((Object) this.showViewBill, (Object) cJRProductsItem.showViewBill) && k.a((Object) this.inputFields, (Object) cJRProductsItem.inputFields) && k.a((Object) this.price, (Object) cJRProductsItem.price) && k.a((Object) this.state, (Object) cJRProductsItem.state) && k.a((Object) this._maxAmount, (Object) cJRProductsItem._maxAmount) && k.a((Object) this.disclaimer, (Object) cJRProductsItem.disclaimer) && k.a((Object) this.disclaimerNew, (Object) cJRProductsItem.disclaimerNew) && k.a((Object) this.disclaimerImage, (Object) cJRProductsItem.disclaimerImage) && k.a((Object) this.serviceLabel, (Object) cJRProductsItem.serviceLabel) && k.a((Object) this.creditCardLength, (Object) cJRProductsItem.creditCardLength) && k.a((Object) this.productId, (Object) cJRProductsItem.productId) && k.a((Object) this.extnAttrs, (Object) cJRProductsItem.extnAttrs) && k.a((Object) this.verticalId, (Object) cJRProductsItem.verticalId) && k.a((Object) this.warehouseId, (Object) cJRProductsItem.warehouseId) && k.a((Object) this.hide_fastforward, (Object) cJRProductsItem.hide_fastforward) && k.a((Object) this.service, (Object) cJRProductsItem.service) && k.a((Object) this.paytype, (Object) cJRProductsItem.paytype) && k.a(this.overrideAttrs, cJRProductsItem.overrideAttrs) && k.a((Object) this.board, (Object) cJRProductsItem.board) && k.a((Object) this.groupConfigKey, (Object) cJRProductsItem.groupConfigKey) && k.a((Object) this.checkBoxKey, (Object) cJRProductsItem.checkBoxKey) && k.a((Object) this.showDisplayValues, (Object) cJRProductsItem.showDisplayValues) && k.a((Object) this.checkboxDisplayType, (Object) cJRProductsItem.checkboxDisplayType) && k.a((Object) this.checkboxScreenTitle, (Object) cJRProductsItem.checkboxScreenTitle) && k.a((Object) this.checkboxFlowType, (Object) cJRProductsItem.checkboxFlowType) && k.a((Object) this.dealsMessage, (Object) cJRProductsItem.dealsMessage) && k.a((Object) this.bottomSheetHeading, (Object) cJRProductsItem.bottomSheetHeading) && k.a((Object) this.bottomSheetCancelText, (Object) cJRProductsItem.bottomSheetCancelText) && k.a((Object) this.bottomSheetMessage, (Object) cJRProductsItem.bottomSheetMessage) && k.a((Object) this.bottomSheetOkText, (Object) cJRProductsItem.bottomSheetOkText) && k.a((Object) this.bottomSheetCheckBoxText, (Object) cJRProductsItem.bottomSheetCheckBoxText) && k.a((Object) this.errorImage, (Object) cJRProductsItem.errorImage) && k.a((Object) this.image, (Object) cJRProductsItem.image) && k.a((Object) this.remindable, (Object) cJRProductsItem.remindable) && k.a((Object) this.feeTypeVisibility, (Object) cJRProductsItem.feeTypeVisibility) && k.a((Object) this.metaDescription, (Object) cJRProductsItem.metaDescription) && k.a((Object) this._showBrowsePlan, (Object) cJRProductsItem._showBrowsePlan) && k.a((Object) this._dynamicPlan, (Object) cJRProductsItem._dynamicPlan) && k.a((Object) this._showOne2OneOffer, (Object) cJRProductsItem._showOne2OneOffer) && k.a((Object) this._showOne2OneUserOffer, (Object) cJRProductsItem._showOne2OneUserOffer) && k.a((Object) this.one2OneOfferText, (Object) cJRProductsItem.one2OneOfferText) && k.a((Object) this._dynamicPlanCategoryLabel, (Object) cJRProductsItem._dynamicPlanCategoryLabel) && k.a((Object) this._dynamic_plan_category_label, (Object) cJRProductsItem._dynamic_plan_category_label) && k.a((Object) this.vendingCharge, (Object) cJRProductsItem.vendingCharge) && k.a((Object) this.circle, (Object) cJRProductsItem.circle) && k.a((Object) this.operatorLabel, (Object) cJRProductsItem.operatorLabel) && k.a((Object) this.operatorDisplayLabel, (Object) cJRProductsItem.operatorDisplayLabel) && k.a((Object) this.group_Config_Key, (Object) cJRProductsItem.group_Config_Key) && k.a((Object) this.status, (Object) cJRProductsItem.status) && k.a((Object) this.bankEMandateEnable, (Object) cJRProductsItem.bankEMandateEnable) && k.a((Object) this._max_Amount, (Object) cJRProductsItem._max_Amount) && k.a((Object) this.circleLabel, (Object) cJRProductsItem.circleLabel) && k.a((Object) this._min_Amount, (Object) cJRProductsItem._min_Amount) && k.a((Object) this.productTypeLabel, (Object) cJRProductsItem.productTypeLabel)) {
                    if (this.enableBillPayment == cJRProductsItem.enableBillPayment) {
                        if (!(this.enableVisaDirect == cJRProductsItem.enableVisaDirect) || !k.a((Object) this.imageUrl, (Object) cJRProductsItem.imageUrl) || !k.a((Object) this.metaTitle, (Object) cJRProductsItem.metaTitle) || !k.a((Object) this.postOrderViewType, (Object) cJRProductsItem.postOrderViewType) || !k.a((Object) this.one2OneDisclaimerText, (Object) cJRProductsItem.one2OneDisclaimerText) || !k.a((Object) this.declarationCaption, (Object) cJRProductsItem.declarationCaption) || !k.a((Object) this.declarationText1, (Object) cJRProductsItem.declarationText1) || !k.a((Object) this.declarationText2, (Object) cJRProductsItem.declarationText2) || !k.a((Object) this.declarationCta, (Object) cJRProductsItem.declarationCta) || !k.a((Object) this.userConsent, (Object) cJRProductsItem.userConsent) || !k.a((Object) this.amountButtons, (Object) cJRProductsItem.amountButtons) || !k.a((Object) this.proceedDirectlyToPG, (Object) cJRProductsItem.proceedDirectlyToPG) || !k.a((Object) this.thinBannerURL, (Object) cJRProductsItem.thinBannerURL) || !k.a((Object) this.requestType, (Object) cJRProductsItem.requestType) || !k.a((Object) this.dthHelp, (Object) cJRProductsItem.dthHelp) || !k.a((Object) this.dthAmountFetch, (Object) cJRProductsItem.dthAmountFetch) || !k.a((Object) this.offersForYou, (Object) cJRProductsItem.offersForYou) || !k.a((Object) this.offersForYouDisclaimer, (Object) cJRProductsItem.offersForYouDisclaimer) || !k.a((Object) this.bbpsLogoUrl, (Object) cJRProductsItem.bbpsLogoUrl) || !k.a((Object) this.bbps_logo_url, (Object) cJRProductsItem.bbps_logo_url) || !k.a((Object) this.dynamicPlansGrouping, (Object) cJRProductsItem.dynamicPlansGrouping) || !k.a((Object) this.bankNameLogoV4, (Object) cJRProductsItem.bankNameLogoV4) || !k.a((Object) this.cardBgV4, (Object) cJRProductsItem.cardBgV4) || !k.a((Object) this.cardTypeLogo, (Object) cJRProductsItem.cardTypeLogo) || !k.a((Object) this.serviceDisplayLabel, (Object) cJRProductsItem.serviceDisplayLabel)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this._minAmount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        HashMap<String, Integer> hashMap = this.payTypeSupported;
        int hashCode2 = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        String str2 = this.city;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CJRUtilityAlertV2 cJRUtilityAlertV2 = this.alert;
        int hashCode4 = (hashCode3 + (cJRUtilityAlertV2 != null ? cJRUtilityAlertV2.hashCode() : 0)) * 31;
        String str3 = this.paytpaytypeLabelype;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.displayName;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.prefetch;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.softPrefetch;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.fetchAmount;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.vodaFetchbill;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num = this.catalogProductId;
        int hashCode11 = (hashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        String str9 = this.description;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.operator;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.productType;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.showViewBill;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        List<CJRInputFieldsItem> list = this.inputFields;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        Double d2 = this.price;
        int hashCode17 = (hashCode16 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str13 = this.state;
        int hashCode18 = (hashCode17 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this._maxAmount;
        int hashCode19 = (hashCode18 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.disclaimer;
        int hashCode20 = (hashCode19 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.disclaimerNew;
        int hashCode21 = (hashCode20 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.disclaimerImage;
        int hashCode22 = (hashCode21 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.serviceLabel;
        int hashCode23 = (hashCode22 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.creditCardLength;
        int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
        Long l = this.productId;
        int hashCode25 = (hashCode24 + (l != null ? l.hashCode() : 0)) * 31;
        CJRExtensionAttributes cJRExtensionAttributes = this.extnAttrs;
        int hashCode26 = (hashCode25 + (cJRExtensionAttributes != null ? cJRExtensionAttributes.hashCode() : 0)) * 31;
        String str20 = this.verticalId;
        int hashCode27 = (hashCode26 + (str20 != null ? str20.hashCode() : 0)) * 31;
        Integer num2 = this.warehouseId;
        int hashCode28 = (hashCode27 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Boolean bool = this.hide_fastforward;
        int hashCode29 = (hashCode28 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str21 = this.service;
        int hashCode30 = (hashCode29 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.paytype;
        int hashCode31 = (hashCode30 + (str22 != null ? str22.hashCode() : 0)) * 31;
        Object obj = this.overrideAttrs;
        int hashCode32 = (hashCode31 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str23 = this.board;
        int hashCode33 = (hashCode32 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.groupConfigKey;
        int hashCode34 = (hashCode33 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.checkBoxKey;
        int hashCode35 = (hashCode34 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.showDisplayValues;
        int hashCode36 = (hashCode35 + (str26 != null ? str26.hashCode() : 0)) * 31;
        String str27 = this.checkboxDisplayType;
        int hashCode37 = (hashCode36 + (str27 != null ? str27.hashCode() : 0)) * 31;
        String str28 = this.checkboxScreenTitle;
        int hashCode38 = (hashCode37 + (str28 != null ? str28.hashCode() : 0)) * 31;
        String str29 = this.checkboxFlowType;
        int hashCode39 = (hashCode38 + (str29 != null ? str29.hashCode() : 0)) * 31;
        String str30 = this.dealsMessage;
        int hashCode40 = (hashCode39 + (str30 != null ? str30.hashCode() : 0)) * 31;
        String str31 = this.bottomSheetHeading;
        int hashCode41 = (hashCode40 + (str31 != null ? str31.hashCode() : 0)) * 31;
        String str32 = this.bottomSheetCancelText;
        int hashCode42 = (hashCode41 + (str32 != null ? str32.hashCode() : 0)) * 31;
        String str33 = this.bottomSheetMessage;
        int hashCode43 = (hashCode42 + (str33 != null ? str33.hashCode() : 0)) * 31;
        String str34 = this.bottomSheetOkText;
        int hashCode44 = (hashCode43 + (str34 != null ? str34.hashCode() : 0)) * 31;
        String str35 = this.bottomSheetCheckBoxText;
        int hashCode45 = (hashCode44 + (str35 != null ? str35.hashCode() : 0)) * 31;
        String str36 = this.errorImage;
        int hashCode46 = (hashCode45 + (str36 != null ? str36.hashCode() : 0)) * 31;
        String str37 = this.image;
        int hashCode47 = (hashCode46 + (str37 != null ? str37.hashCode() : 0)) * 31;
        String str38 = this.remindable;
        int hashCode48 = (hashCode47 + (str38 != null ? str38.hashCode() : 0)) * 31;
        String str39 = this.feeTypeVisibility;
        int hashCode49 = (hashCode48 + (str39 != null ? str39.hashCode() : 0)) * 31;
        String str40 = this.metaDescription;
        int hashCode50 = (hashCode49 + (str40 != null ? str40.hashCode() : 0)) * 31;
        String str41 = this._showBrowsePlan;
        int hashCode51 = (hashCode50 + (str41 != null ? str41.hashCode() : 0)) * 31;
        String str42 = this._dynamicPlan;
        int hashCode52 = (hashCode51 + (str42 != null ? str42.hashCode() : 0)) * 31;
        String str43 = this._showOne2OneOffer;
        int hashCode53 = (hashCode52 + (str43 != null ? str43.hashCode() : 0)) * 31;
        String str44 = this._showOne2OneUserOffer;
        int hashCode54 = (hashCode53 + (str44 != null ? str44.hashCode() : 0)) * 31;
        String str45 = this.one2OneOfferText;
        int hashCode55 = (hashCode54 + (str45 != null ? str45.hashCode() : 0)) * 31;
        String str46 = this._dynamicPlanCategoryLabel;
        int hashCode56 = (hashCode55 + (str46 != null ? str46.hashCode() : 0)) * 31;
        String str47 = this._dynamic_plan_category_label;
        int hashCode57 = (hashCode56 + (str47 != null ? str47.hashCode() : 0)) * 31;
        String str48 = this.vendingCharge;
        int hashCode58 = (hashCode57 + (str48 != null ? str48.hashCode() : 0)) * 31;
        String str49 = this.circle;
        int hashCode59 = (hashCode58 + (str49 != null ? str49.hashCode() : 0)) * 31;
        String str50 = this.operatorLabel;
        int hashCode60 = (hashCode59 + (str50 != null ? str50.hashCode() : 0)) * 31;
        String str51 = this.operatorDisplayLabel;
        int hashCode61 = (hashCode60 + (str51 != null ? str51.hashCode() : 0)) * 31;
        String str52 = this.group_Config_Key;
        int hashCode62 = (hashCode61 + (str52 != null ? str52.hashCode() : 0)) * 31;
        String str53 = this.status;
        int hashCode63 = (hashCode62 + (str53 != null ? str53.hashCode() : 0)) * 31;
        String str54 = this.bankEMandateEnable;
        int hashCode64 = (hashCode63 + (str54 != null ? str54.hashCode() : 0)) * 31;
        String str55 = this._max_Amount;
        int hashCode65 = (hashCode64 + (str55 != null ? str55.hashCode() : 0)) * 31;
        String str56 = this.circleLabel;
        int hashCode66 = (hashCode65 + (str56 != null ? str56.hashCode() : 0)) * 31;
        String str57 = this._min_Amount;
        int hashCode67 = (hashCode66 + (str57 != null ? str57.hashCode() : 0)) * 31;
        String str58 = this.productTypeLabel;
        int hashCode68 = (((((hashCode67 + (str58 != null ? str58.hashCode() : 0)) * 31) + this.enableBillPayment) * 31) + this.enableVisaDirect) * 31;
        String str59 = this.imageUrl;
        int hashCode69 = (hashCode68 + (str59 != null ? str59.hashCode() : 0)) * 31;
        String str60 = this.metaTitle;
        int hashCode70 = (hashCode69 + (str60 != null ? str60.hashCode() : 0)) * 31;
        String str61 = this.postOrderViewType;
        int hashCode71 = (hashCode70 + (str61 != null ? str61.hashCode() : 0)) * 31;
        String str62 = this.one2OneDisclaimerText;
        int hashCode72 = (hashCode71 + (str62 != null ? str62.hashCode() : 0)) * 31;
        String str63 = this.declarationCaption;
        int hashCode73 = (hashCode72 + (str63 != null ? str63.hashCode() : 0)) * 31;
        String str64 = this.declarationText1;
        int hashCode74 = (hashCode73 + (str64 != null ? str64.hashCode() : 0)) * 31;
        String str65 = this.declarationText2;
        int hashCode75 = (hashCode74 + (str65 != null ? str65.hashCode() : 0)) * 31;
        String str66 = this.declarationCta;
        int hashCode76 = (hashCode75 + (str66 != null ? str66.hashCode() : 0)) * 31;
        String str67 = this.userConsent;
        int hashCode77 = (hashCode76 + (str67 != null ? str67.hashCode() : 0)) * 31;
        String str68 = this.amountButtons;
        int hashCode78 = (hashCode77 + (str68 != null ? str68.hashCode() : 0)) * 31;
        String str69 = this.proceedDirectlyToPG;
        int hashCode79 = (hashCode78 + (str69 != null ? str69.hashCode() : 0)) * 31;
        String str70 = this.thinBannerURL;
        int hashCode80 = (hashCode79 + (str70 != null ? str70.hashCode() : 0)) * 31;
        String str71 = this.requestType;
        int hashCode81 = (hashCode80 + (str71 != null ? str71.hashCode() : 0)) * 31;
        List<Help> list2 = this.dthHelp;
        int hashCode82 = (hashCode81 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str72 = this.dthAmountFetch;
        int hashCode83 = (hashCode82 + (str72 != null ? str72.hashCode() : 0)) * 31;
        String str73 = this.offersForYou;
        int hashCode84 = (hashCode83 + (str73 != null ? str73.hashCode() : 0)) * 31;
        String str74 = this.offersForYouDisclaimer;
        int hashCode85 = (hashCode84 + (str74 != null ? str74.hashCode() : 0)) * 31;
        String str75 = this.bbpsLogoUrl;
        int hashCode86 = (hashCode85 + (str75 != null ? str75.hashCode() : 0)) * 31;
        String str76 = this.bbps_logo_url;
        int hashCode87 = (hashCode86 + (str76 != null ? str76.hashCode() : 0)) * 31;
        List<? extends Map<?, ?>> list3 = this.dynamicPlansGrouping;
        int hashCode88 = (hashCode87 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str77 = this.bankNameLogoV4;
        int hashCode89 = (hashCode88 + (str77 != null ? str77.hashCode() : 0)) * 31;
        String str78 = this.cardBgV4;
        int hashCode90 = (hashCode89 + (str78 != null ? str78.hashCode() : 0)) * 31;
        String str79 = this.cardTypeLogo;
        int hashCode91 = (hashCode90 + (str79 != null ? str79.hashCode() : 0)) * 31;
        String str80 = this.serviceDisplayLabel;
        if (str80 != null) {
            i2 = str80.hashCode();
        }
        return hashCode91 + i2;
    }

    public final String toString() {
        return "CJRProductsItem(_minAmount=" + this._minAmount + ", payTypeSupported=" + this.payTypeSupported + ", city=" + this.city + ", alert=" + this.alert + ", paytpaytypeLabelype=" + this.paytpaytypeLabelype + ", displayName=" + this.displayName + ", prefetch=" + this.prefetch + ", softPrefetch=" + this.softPrefetch + ", fetchAmount=" + this.fetchAmount + ", vodaFetchbill=" + this.vodaFetchbill + ", catalogProductId=" + this.catalogProductId + ", description=" + this.description + ", operator=" + this.operator + ", productType=" + this.productType + ", showViewBill=" + this.showViewBill + ", inputFields=" + this.inputFields + ", price=" + this.price + ", state=" + this.state + ", _maxAmount=" + this._maxAmount + ", disclaimer=" + this.disclaimer + ", disclaimerNew=" + this.disclaimerNew + ", disclaimerImage=" + this.disclaimerImage + ", serviceLabel=" + this.serviceLabel + ", creditCardLength=" + this.creditCardLength + ", productId=" + this.productId + ", extnAttrs=" + this.extnAttrs + ", verticalId=" + this.verticalId + ", warehouseId=" + this.warehouseId + ", hide_fastforward=" + this.hide_fastforward + ", service=" + this.service + ", paytype=" + this.paytype + ", overrideAttrs=" + this.overrideAttrs + ", board=" + this.board + ", groupConfigKey=" + this.groupConfigKey + ", checkBoxKey=" + this.checkBoxKey + ", showDisplayValues=" + this.showDisplayValues + ", checkboxDisplayType=" + this.checkboxDisplayType + ", checkboxScreenTitle=" + this.checkboxScreenTitle + ", checkboxFlowType=" + this.checkboxFlowType + ", dealsMessage=" + this.dealsMessage + ", bottomSheetHeading=" + this.bottomSheetHeading + ", bottomSheetCancelText=" + this.bottomSheetCancelText + ", bottomSheetMessage=" + this.bottomSheetMessage + ", bottomSheetOkText=" + this.bottomSheetOkText + ", bottomSheetCheckBoxText=" + this.bottomSheetCheckBoxText + ", errorImage=" + this.errorImage + ", image=" + this.image + ", remindable=" + this.remindable + ", feeTypeVisibility=" + this.feeTypeVisibility + ", metaDescription=" + this.metaDescription + ", _showBrowsePlan=" + this._showBrowsePlan + ", _dynamicPlan=" + this._dynamicPlan + ", _showOne2OneOffer=" + this._showOne2OneOffer + ", _showOne2OneUserOffer=" + this._showOne2OneUserOffer + ", one2OneOfferText=" + this.one2OneOfferText + ", _dynamicPlanCategoryLabel=" + this._dynamicPlanCategoryLabel + ", _dynamic_plan_category_label=" + this._dynamic_plan_category_label + ", vendingCharge=" + this.vendingCharge + ", circle=" + this.circle + ", operatorLabel=" + this.operatorLabel + ", operatorDisplayLabel=" + this.operatorDisplayLabel + ", group_Config_Key=" + this.group_Config_Key + ", status=" + this.status + ", bankEMandateEnable=" + this.bankEMandateEnable + ", _max_Amount=" + this._max_Amount + ", circleLabel=" + this.circleLabel + ", _min_Amount=" + this._min_Amount + ", productTypeLabel=" + this.productTypeLabel + ", enableBillPayment=" + this.enableBillPayment + ", enableVisaDirect=" + this.enableVisaDirect + ", imageUrl=" + this.imageUrl + ", metaTitle=" + this.metaTitle + ", postOrderViewType=" + this.postOrderViewType + ", one2OneDisclaimerText=" + this.one2OneDisclaimerText + ", declarationCaption=" + this.declarationCaption + ", declarationText1=" + this.declarationText1 + ", declarationText2=" + this.declarationText2 + ", declarationCta=" + this.declarationCta + ", userConsent=" + this.userConsent + ", amountButtons=" + this.amountButtons + ", proceedDirectlyToPG=" + this.proceedDirectlyToPG + ", thinBannerURL=" + this.thinBannerURL + ", requestType=" + this.requestType + ", dthHelp=" + this.dthHelp + ", dthAmountFetch=" + this.dthAmountFetch + ", offersForYou=" + this.offersForYou + ", offersForYouDisclaimer=" + this.offersForYouDisclaimer + ", bbpsLogoUrl=" + this.bbpsLogoUrl + ", bbps_logo_url=" + this.bbps_logo_url + ", dynamicPlansGrouping=" + this.dynamicPlansGrouping + ", bankNameLogoV4=" + this.bankNameLogoV4 + ", cardBgV4=" + this.cardBgV4 + ", cardTypeLogo=" + this.cardTypeLogo + ", serviceDisplayLabel=" + this.serviceDisplayLabel + ")";
    }

    public CJRProductsItem(String str, HashMap<String, Integer> hashMap, String str2, CJRUtilityAlertV2 cJRUtilityAlertV2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, String str9, String str10, String str11, String str12, List<CJRInputFieldsItem> list, Double d2, String str13, String str14, String str15, String str16, String str17, String str18, String str19, Long l, CJRExtensionAttributes cJRExtensionAttributes, String str20, Integer num2, Boolean bool, String str21, String str22, Object obj, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, int i2, int i3, String str59, String str60, String str61, String str62, String str63, String str64, String str65, String str66, String str67, String str68, String str69, String str70, String str71, List<Help> list2, String str72, String str73, String str74, String str75, String str76, List<? extends Map<?, ?>> list3, String str77, String str78, String str79, String str80) {
        this._minAmount = str;
        this.payTypeSupported = hashMap;
        this.city = str2;
        this.alert = cJRUtilityAlertV2;
        this.paytpaytypeLabelype = str3;
        this.displayName = str4;
        this.prefetch = str5;
        this.softPrefetch = str6;
        this.fetchAmount = str7;
        this.vodaFetchbill = str8;
        this.catalogProductId = num;
        this.description = str9;
        this.operator = str10;
        this.productType = str11;
        this.showViewBill = str12;
        this.inputFields = list;
        this.price = d2;
        this.state = str13;
        this._maxAmount = str14;
        this.disclaimer = str15;
        this.disclaimerNew = str16;
        this.disclaimerImage = str17;
        this.serviceLabel = str18;
        this.creditCardLength = str19;
        this.productId = l;
        this.extnAttrs = cJRExtensionAttributes;
        this.verticalId = str20;
        this.warehouseId = num2;
        this.hide_fastforward = bool;
        this.service = str21;
        this.paytype = str22;
        this.overrideAttrs = obj;
        this.board = str23;
        this.groupConfigKey = str24;
        this.checkBoxKey = str25;
        this.showDisplayValues = str26;
        this.checkboxDisplayType = str27;
        this.checkboxScreenTitle = str28;
        this.checkboxFlowType = str29;
        this.dealsMessage = str30;
        this.bottomSheetHeading = str31;
        this.bottomSheetCancelText = str32;
        this.bottomSheetMessage = str33;
        this.bottomSheetOkText = str34;
        this.bottomSheetCheckBoxText = str35;
        this.errorImage = str36;
        this.image = str37;
        this.remindable = str38;
        this.feeTypeVisibility = str39;
        this.metaDescription = str40;
        this._showBrowsePlan = str41;
        this._dynamicPlan = str42;
        this._showOne2OneOffer = str43;
        this._showOne2OneUserOffer = str44;
        this.one2OneOfferText = str45;
        this._dynamicPlanCategoryLabel = str46;
        this._dynamic_plan_category_label = str47;
        this.vendingCharge = str48;
        this.circle = str49;
        this.operatorLabel = str50;
        this.operatorDisplayLabel = str51;
        this.group_Config_Key = str52;
        this.status = str53;
        this.bankEMandateEnable = str54;
        this._max_Amount = str55;
        this.circleLabel = str56;
        this._min_Amount = str57;
        this.productTypeLabel = str58;
        this.enableBillPayment = i2;
        this.enableVisaDirect = i3;
        this.imageUrl = str59;
        this.metaTitle = str60;
        this.postOrderViewType = str61;
        this.one2OneDisclaimerText = str62;
        this.declarationCaption = str63;
        this.declarationText1 = str64;
        this.declarationText2 = str65;
        this.declarationCta = str66;
        this.userConsent = str67;
        this.amountButtons = str68;
        this.proceedDirectlyToPG = str69;
        this.thinBannerURL = str70;
        this.requestType = str71;
        this.dthHelp = list2;
        this.dthAmountFetch = str72;
        this.offersForYou = str73;
        this.offersForYouDisclaimer = str74;
        this.bbpsLogoUrl = str75;
        this.bbps_logo_url = str76;
        this.dynamicPlansGrouping = list3;
        this.bankNameLogoV4 = str77;
        this.cardBgV4 = str78;
        this.cardTypeLogo = str79;
        this.serviceDisplayLabel = str80;
    }

    public final HashMap<String, Integer> getPayTypeSupported() {
        return this.payTypeSupported;
    }

    public final String getCity() {
        return this.city;
    }

    public final CJRUtilityAlertV2 getAlert() {
        return this.alert;
    }

    public final String getPaytpaytypeLabelype() {
        return this.paytpaytypeLabelype;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getPrefetch() {
        return this.prefetch;
    }

    public final String getSoftPrefetch() {
        return this.softPrefetch;
    }

    public final Integer getCatalogProductId() {
        return this.catalogProductId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final List<CJRInputFieldsItem> getInputFields() {
        return this.inputFields;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final String getState() {
        return this.state;
    }

    public final String getDisclaimer() {
        return this.disclaimer;
    }

    public final String getDisclaimerNew() {
        return this.disclaimerNew;
    }

    public final String getDisclaimerImage() {
        return this.disclaimerImage;
    }

    public final String getServiceLabel() {
        return this.serviceLabel;
    }

    public final String getCreditCardLength() {
        return this.creditCardLength;
    }

    public final Long getProductId() {
        return this.productId;
    }

    public final CJRExtensionAttributes getExtnAttrs() {
        return this.extnAttrs;
    }

    public final String getVerticalId() {
        return this.verticalId;
    }

    public final Integer getWarehouseId() {
        return this.warehouseId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRProductsItem(java.lang.String r94, java.util.HashMap r95, java.lang.String r96, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2 r97, java.lang.String r98, java.lang.String r99, java.lang.String r100, java.lang.String r101, java.lang.String r102, java.lang.String r103, java.lang.Integer r104, java.lang.String r105, java.lang.String r106, java.lang.String r107, java.lang.String r108, java.util.List r109, java.lang.Double r110, java.lang.String r111, java.lang.String r112, java.lang.String r113, java.lang.String r114, java.lang.String r115, java.lang.String r116, java.lang.String r117, java.lang.Long r118, net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r119, java.lang.String r120, java.lang.Integer r121, java.lang.Boolean r122, java.lang.String r123, java.lang.String r124, java.lang.Object r125, java.lang.String r126, java.lang.String r127, java.lang.String r128, java.lang.String r129, java.lang.String r130, java.lang.String r131, java.lang.String r132, java.lang.String r133, java.lang.String r134, java.lang.String r135, java.lang.String r136, java.lang.String r137, java.lang.String r138, java.lang.String r139, java.lang.String r140, java.lang.String r141, java.lang.String r142, java.lang.String r143, java.lang.String r144, java.lang.String r145, java.lang.String r146, java.lang.String r147, java.lang.String r148, java.lang.String r149, java.lang.String r150, java.lang.String r151, java.lang.String r152, java.lang.String r153, java.lang.String r154, java.lang.String r155, java.lang.String r156, java.lang.String r157, java.lang.String r158, java.lang.String r159, java.lang.String r160, java.lang.String r161, int r162, int r163, java.lang.String r164, java.lang.String r165, java.lang.String r166, java.lang.String r167, java.lang.String r168, java.lang.String r169, java.lang.String r170, java.lang.String r171, java.lang.String r172, java.lang.String r173, java.lang.String r174, java.lang.String r175, java.lang.String r176, java.util.List r177, java.lang.String r178, java.lang.String r179, java.lang.String r180, java.lang.String r181, java.lang.String r182, java.util.List r183, java.lang.String r184, java.lang.String r185, java.lang.String r186, java.lang.String r187, int r188, int r189, int r190, kotlin.g.b.g r191) {
        /*
            r93 = this;
            r0 = r188
            r1 = r189
            r2 = r190
            r3 = r0 & 1
            if (r3 == 0) goto L_0x000c
            r3 = 0
            goto L_0x000e
        L_0x000c:
            r3 = r94
        L_0x000e:
            r5 = r0 & 2
            if (r5 == 0) goto L_0x0014
            r5 = 0
            goto L_0x0016
        L_0x0014:
            r5 = r95
        L_0x0016:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001c
            r6 = 0
            goto L_0x001e
        L_0x001c:
            r6 = r96
        L_0x001e:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0024
            r7 = 0
            goto L_0x0026
        L_0x0024:
            r7 = r97
        L_0x0026:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002c
            r8 = 0
            goto L_0x002e
        L_0x002c:
            r8 = r98
        L_0x002e:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0034
            r9 = 0
            goto L_0x0036
        L_0x0034:
            r9 = r99
        L_0x0036:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003c
            r10 = 0
            goto L_0x003e
        L_0x003c:
            r10 = r100
        L_0x003e:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0044
            r11 = 0
            goto L_0x0046
        L_0x0044:
            r11 = r101
        L_0x0046:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004c
            r12 = 0
            goto L_0x004e
        L_0x004c:
            r12 = r102
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0054
            r13 = 0
            goto L_0x0056
        L_0x0054:
            r13 = r103
        L_0x0056:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005c
            r14 = 0
            goto L_0x005e
        L_0x005c:
            r14 = r104
        L_0x005e:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0064
            r15 = 0
            goto L_0x0066
        L_0x0064:
            r15 = r105
        L_0x0066:
            r4 = r0 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x006c
            r4 = 0
            goto L_0x006e
        L_0x006c:
            r4 = r106
        L_0x006e:
            r16 = r4
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x0076
            r4 = 0
            goto L_0x0078
        L_0x0076:
            r4 = r107
        L_0x0078:
            r17 = r4
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x0080
            r4 = 0
            goto L_0x0082
        L_0x0080:
            r4 = r108
        L_0x0082:
            r18 = 32768(0x8000, float:4.5918E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x008c
            r18 = 0
            goto L_0x008e
        L_0x008c:
            r18 = r109
        L_0x008e:
            r19 = 65536(0x10000, float:9.18355E-41)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x0097
            r19 = 0
            goto L_0x0099
        L_0x0097:
            r19 = r110
        L_0x0099:
            r20 = 131072(0x20000, float:1.83671E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a2
            r20 = 0
            goto L_0x00a4
        L_0x00a2:
            r20 = r111
        L_0x00a4:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ad
            r21 = 0
            goto L_0x00af
        L_0x00ad:
            r21 = r112
        L_0x00af:
            r22 = 524288(0x80000, float:7.34684E-40)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00b8
            r22 = 0
            goto L_0x00ba
        L_0x00b8:
            r22 = r113
        L_0x00ba:
            r23 = 1048576(0x100000, float:1.469368E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00c3
            r23 = 0
            goto L_0x00c5
        L_0x00c3:
            r23 = r114
        L_0x00c5:
            r24 = 2097152(0x200000, float:2.938736E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00ce
            r24 = 0
            goto L_0x00d0
        L_0x00ce:
            r24 = r115
        L_0x00d0:
            r25 = 4194304(0x400000, float:5.877472E-39)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00d9
            r25 = 0
            goto L_0x00db
        L_0x00d9:
            r25 = r116
        L_0x00db:
            r26 = 8388608(0x800000, float:1.17549435E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00e4
            r26 = 0
            goto L_0x00e6
        L_0x00e4:
            r26 = r117
        L_0x00e6:
            r27 = 16777216(0x1000000, float:2.3509887E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00ef
            r27 = 0
            goto L_0x00f1
        L_0x00ef:
            r27 = r118
        L_0x00f1:
            r28 = 33554432(0x2000000, float:9.403955E-38)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00fa
            r28 = 0
            goto L_0x00fc
        L_0x00fa:
            r28 = r119
        L_0x00fc:
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0105
            r29 = 0
            goto L_0x0107
        L_0x0105:
            r29 = r120
        L_0x0107:
            r30 = 134217728(0x8000000, float:3.85186E-34)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0110
            r30 = 0
            goto L_0x0112
        L_0x0110:
            r30 = r121
        L_0x0112:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x011b
            java.lang.Boolean r31 = java.lang.Boolean.FALSE
            goto L_0x011d
        L_0x011b:
            r31 = r122
        L_0x011d:
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x0126
            r32 = 0
            goto L_0x0128
        L_0x0126:
            r32 = r123
        L_0x0128:
            r33 = 1073741824(0x40000000, float:2.0)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x0131
            r33 = 0
            goto L_0x0133
        L_0x0131:
            r33 = r124
        L_0x0133:
            r34 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r34
            if (r0 == 0) goto L_0x013b
            r0 = 0
            goto L_0x013d
        L_0x013b:
            r0 = r125
        L_0x013d:
            r34 = r1 & 1
            if (r34 == 0) goto L_0x0144
            r34 = 0
            goto L_0x0146
        L_0x0144:
            r34 = r126
        L_0x0146:
            r35 = r1 & 2
            if (r35 == 0) goto L_0x014d
            r35 = 0
            goto L_0x014f
        L_0x014d:
            r35 = r127
        L_0x014f:
            r36 = r1 & 4
            if (r36 == 0) goto L_0x0156
            r36 = 0
            goto L_0x0158
        L_0x0156:
            r36 = r128
        L_0x0158:
            r37 = r1 & 8
            if (r37 == 0) goto L_0x015f
            r37 = 0
            goto L_0x0161
        L_0x015f:
            r37 = r129
        L_0x0161:
            r38 = r1 & 16
            if (r38 == 0) goto L_0x0168
            r38 = 0
            goto L_0x016a
        L_0x0168:
            r38 = r130
        L_0x016a:
            r39 = r1 & 32
            if (r39 == 0) goto L_0x0171
            r39 = 0
            goto L_0x0173
        L_0x0171:
            r39 = r131
        L_0x0173:
            r40 = r1 & 64
            if (r40 == 0) goto L_0x017a
            r40 = 0
            goto L_0x017c
        L_0x017a:
            r40 = r132
        L_0x017c:
            r188 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0184
            r0 = 0
            goto L_0x0186
        L_0x0184:
            r0 = r133
        L_0x0186:
            r41 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018e
            r0 = 0
            goto L_0x0190
        L_0x018e:
            r0 = r134
        L_0x0190:
            r42 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0198
            r0 = 0
            goto L_0x019a
        L_0x0198:
            r0 = r135
        L_0x019a:
            r43 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01a2
            r0 = 0
            goto L_0x01a4
        L_0x01a2:
            r0 = r136
        L_0x01a4:
            r44 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01ac
            r0 = 0
            goto L_0x01ae
        L_0x01ac:
            r0 = r137
        L_0x01ae:
            r45 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01b6
            r0 = 0
            goto L_0x01b8
        L_0x01b6:
            r0 = r138
        L_0x01b8:
            r46 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01c0
            r0 = 0
            goto L_0x01c2
        L_0x01c0:
            r0 = r139
        L_0x01c2:
            r47 = r0
            r0 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x01ca
            r0 = 0
            goto L_0x01cc
        L_0x01ca:
            r0 = r140
        L_0x01cc:
            r48 = 32768(0x8000, float:4.5918E-41)
            r48 = r1 & r48
            if (r48 == 0) goto L_0x01d6
            r48 = 0
            goto L_0x01d8
        L_0x01d6:
            r48 = r141
        L_0x01d8:
            r49 = 65536(0x10000, float:9.18355E-41)
            r49 = r1 & r49
            if (r49 == 0) goto L_0x01e1
            r49 = 0
            goto L_0x01e3
        L_0x01e1:
            r49 = r142
        L_0x01e3:
            r50 = 131072(0x20000, float:1.83671E-40)
            r50 = r1 & r50
            if (r50 == 0) goto L_0x01ec
            r50 = 0
            goto L_0x01ee
        L_0x01ec:
            r50 = r143
        L_0x01ee:
            r51 = 262144(0x40000, float:3.67342E-40)
            r51 = r1 & r51
            if (r51 == 0) goto L_0x01f7
            r51 = 0
            goto L_0x01f9
        L_0x01f7:
            r51 = r144
        L_0x01f9:
            r52 = 524288(0x80000, float:7.34684E-40)
            r52 = r1 & r52
            if (r52 == 0) goto L_0x0202
            r52 = 0
            goto L_0x0204
        L_0x0202:
            r52 = r145
        L_0x0204:
            r53 = 1048576(0x100000, float:1.469368E-39)
            r53 = r1 & r53
            if (r53 == 0) goto L_0x020d
            r53 = 0
            goto L_0x020f
        L_0x020d:
            r53 = r146
        L_0x020f:
            r54 = 2097152(0x200000, float:2.938736E-39)
            r54 = r1 & r54
            if (r54 == 0) goto L_0x0218
            r54 = 0
            goto L_0x021a
        L_0x0218:
            r54 = r147
        L_0x021a:
            r55 = 4194304(0x400000, float:5.877472E-39)
            r55 = r1 & r55
            if (r55 == 0) goto L_0x0223
            r55 = 0
            goto L_0x0225
        L_0x0223:
            r55 = r148
        L_0x0225:
            r56 = 8388608(0x800000, float:1.17549435E-38)
            r56 = r1 & r56
            if (r56 == 0) goto L_0x022e
            r56 = 0
            goto L_0x0230
        L_0x022e:
            r56 = r149
        L_0x0230:
            r57 = 16777216(0x1000000, float:2.3509887E-38)
            r57 = r1 & r57
            if (r57 == 0) goto L_0x0239
            r57 = 0
            goto L_0x023b
        L_0x0239:
            r57 = r150
        L_0x023b:
            r58 = 33554432(0x2000000, float:9.403955E-38)
            r58 = r1 & r58
            if (r58 == 0) goto L_0x0244
            r58 = 0
            goto L_0x0246
        L_0x0244:
            r58 = r151
        L_0x0246:
            r59 = 67108864(0x4000000, float:1.5046328E-36)
            r59 = r1 & r59
            if (r59 == 0) goto L_0x024f
            r59 = 0
            goto L_0x0251
        L_0x024f:
            r59 = r152
        L_0x0251:
            r60 = 134217728(0x8000000, float:3.85186E-34)
            r60 = r1 & r60
            if (r60 == 0) goto L_0x025a
            r60 = 0
            goto L_0x025c
        L_0x025a:
            r60 = r153
        L_0x025c:
            r61 = 268435456(0x10000000, float:2.5243549E-29)
            r61 = r1 & r61
            if (r61 == 0) goto L_0x0265
            r61 = 0
            goto L_0x0267
        L_0x0265:
            r61 = r154
        L_0x0267:
            r62 = 536870912(0x20000000, float:1.0842022E-19)
            r62 = r1 & r62
            if (r62 == 0) goto L_0x0270
            r62 = 0
            goto L_0x0272
        L_0x0270:
            r62 = r155
        L_0x0272:
            r63 = 1073741824(0x40000000, float:2.0)
            r63 = r1 & r63
            if (r63 == 0) goto L_0x027b
            r63 = 0
            goto L_0x027d
        L_0x027b:
            r63 = r156
        L_0x027d:
            r64 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r64
            if (r1 == 0) goto L_0x0285
            r1 = 0
            goto L_0x0287
        L_0x0285:
            r1 = r157
        L_0x0287:
            r64 = r2 & 1
            if (r64 == 0) goto L_0x028e
            r64 = 0
            goto L_0x0290
        L_0x028e:
            r64 = r158
        L_0x0290:
            r65 = r2 & 2
            if (r65 == 0) goto L_0x0297
            r65 = 0
            goto L_0x0299
        L_0x0297:
            r65 = r159
        L_0x0299:
            r66 = r2 & 4
            if (r66 == 0) goto L_0x02a0
            r66 = 0
            goto L_0x02a2
        L_0x02a0:
            r66 = r160
        L_0x02a2:
            r67 = r2 & 8
            if (r67 == 0) goto L_0x02a9
            r67 = 0
            goto L_0x02ab
        L_0x02a9:
            r67 = r161
        L_0x02ab:
            r68 = r2 & 16
            if (r68 == 0) goto L_0x02b2
            r68 = 0
            goto L_0x02b4
        L_0x02b2:
            r68 = r162
        L_0x02b4:
            r69 = r2 & 32
            if (r69 == 0) goto L_0x02bb
            r69 = 0
            goto L_0x02bd
        L_0x02bb:
            r69 = r163
        L_0x02bd:
            r70 = r2 & 64
            if (r70 == 0) goto L_0x02c4
            r70 = 0
            goto L_0x02c6
        L_0x02c4:
            r70 = r164
        L_0x02c6:
            r189 = r1
            r1 = r2 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x02ce
            r1 = 0
            goto L_0x02d0
        L_0x02ce:
            r1 = r165
        L_0x02d0:
            r71 = r1
            r1 = r2 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x02d8
            r1 = 0
            goto L_0x02da
        L_0x02d8:
            r1 = r166
        L_0x02da:
            r72 = r1
            r1 = r2 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x02e2
            r1 = 0
            goto L_0x02e4
        L_0x02e2:
            r1 = r167
        L_0x02e4:
            r73 = r1
            r1 = r2 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x02ec
            r1 = 0
            goto L_0x02ee
        L_0x02ec:
            r1 = r168
        L_0x02ee:
            r74 = r1
            r1 = r2 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x02f6
            r1 = 0
            goto L_0x02f8
        L_0x02f6:
            r1 = r169
        L_0x02f8:
            r75 = r1
            r1 = r2 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0300
            r1 = 0
            goto L_0x0302
        L_0x0300:
            r1 = r170
        L_0x0302:
            r76 = r1
            r1 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x030a
            r1 = 0
            goto L_0x030c
        L_0x030a:
            r1 = r171
        L_0x030c:
            r77 = r1
            r1 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0314
            r1 = 0
            goto L_0x0316
        L_0x0314:
            r1 = r172
        L_0x0316:
            r78 = 32768(0x8000, float:4.5918E-41)
            r78 = r2 & r78
            if (r78 == 0) goto L_0x0320
            r78 = 0
            goto L_0x0322
        L_0x0320:
            r78 = r173
        L_0x0322:
            r79 = 65536(0x10000, float:9.18355E-41)
            r79 = r2 & r79
            if (r79 == 0) goto L_0x032b
            r79 = 0
            goto L_0x032d
        L_0x032b:
            r79 = r174
        L_0x032d:
            r80 = 131072(0x20000, float:1.83671E-40)
            r80 = r2 & r80
            if (r80 == 0) goto L_0x0336
            r80 = 0
            goto L_0x0338
        L_0x0336:
            r80 = r175
        L_0x0338:
            r81 = 262144(0x40000, float:3.67342E-40)
            r81 = r2 & r81
            if (r81 == 0) goto L_0x0341
            r81 = 0
            goto L_0x0343
        L_0x0341:
            r81 = r176
        L_0x0343:
            r82 = 524288(0x80000, float:7.34684E-40)
            r82 = r2 & r82
            if (r82 == 0) goto L_0x034c
            r82 = 0
            goto L_0x034e
        L_0x034c:
            r82 = r177
        L_0x034e:
            r83 = 1048576(0x100000, float:1.469368E-39)
            r83 = r2 & r83
            if (r83 == 0) goto L_0x0357
            r83 = 0
            goto L_0x0359
        L_0x0357:
            r83 = r178
        L_0x0359:
            r84 = 2097152(0x200000, float:2.938736E-39)
            r84 = r2 & r84
            if (r84 == 0) goto L_0x0362
            r84 = 0
            goto L_0x0364
        L_0x0362:
            r84 = r179
        L_0x0364:
            r85 = 4194304(0x400000, float:5.877472E-39)
            r85 = r2 & r85
            if (r85 == 0) goto L_0x036d
            r85 = 0
            goto L_0x036f
        L_0x036d:
            r85 = r180
        L_0x036f:
            r86 = 8388608(0x800000, float:1.17549435E-38)
            r86 = r2 & r86
            if (r86 == 0) goto L_0x0378
            r86 = 0
            goto L_0x037a
        L_0x0378:
            r86 = r181
        L_0x037a:
            r87 = 16777216(0x1000000, float:2.3509887E-38)
            r87 = r2 & r87
            if (r87 == 0) goto L_0x0383
            r87 = 0
            goto L_0x0385
        L_0x0383:
            r87 = r182
        L_0x0385:
            r88 = 33554432(0x2000000, float:9.403955E-38)
            r88 = r2 & r88
            if (r88 == 0) goto L_0x038e
            r88 = 0
            goto L_0x0390
        L_0x038e:
            r88 = r183
        L_0x0390:
            r89 = 67108864(0x4000000, float:1.5046328E-36)
            r89 = r2 & r89
            if (r89 == 0) goto L_0x0399
            r89 = 0
            goto L_0x039b
        L_0x0399:
            r89 = r184
        L_0x039b:
            r90 = 134217728(0x8000000, float:3.85186E-34)
            r90 = r2 & r90
            if (r90 == 0) goto L_0x03a4
            r90 = 0
            goto L_0x03a6
        L_0x03a4:
            r90 = r185
        L_0x03a6:
            r91 = 268435456(0x10000000, float:2.5243549E-29)
            r91 = r2 & r91
            if (r91 == 0) goto L_0x03af
            r91 = 0
            goto L_0x03b1
        L_0x03af:
            r91 = r186
        L_0x03b1:
            r92 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r92
            if (r2 == 0) goto L_0x03b9
            r2 = 0
            goto L_0x03bb
        L_0x03b9:
            r2 = r187
        L_0x03bb:
            r94 = r93
            r95 = r3
            r96 = r5
            r97 = r6
            r98 = r7
            r99 = r8
            r100 = r9
            r101 = r10
            r102 = r11
            r103 = r12
            r104 = r13
            r105 = r14
            r106 = r15
            r107 = r16
            r108 = r17
            r109 = r4
            r110 = r18
            r111 = r19
            r112 = r20
            r113 = r21
            r114 = r22
            r115 = r23
            r116 = r24
            r117 = r25
            r118 = r26
            r119 = r27
            r120 = r28
            r121 = r29
            r122 = r30
            r123 = r31
            r124 = r32
            r125 = r33
            r126 = r188
            r127 = r34
            r128 = r35
            r129 = r36
            r130 = r37
            r131 = r38
            r132 = r39
            r133 = r40
            r134 = r41
            r135 = r42
            r136 = r43
            r137 = r44
            r138 = r45
            r139 = r46
            r140 = r47
            r141 = r0
            r142 = r48
            r143 = r49
            r144 = r50
            r145 = r51
            r146 = r52
            r147 = r53
            r148 = r54
            r149 = r55
            r150 = r56
            r151 = r57
            r152 = r58
            r153 = r59
            r154 = r60
            r155 = r61
            r156 = r62
            r157 = r63
            r158 = r189
            r159 = r64
            r160 = r65
            r161 = r66
            r162 = r67
            r163 = r68
            r164 = r69
            r165 = r70
            r166 = r71
            r167 = r72
            r168 = r73
            r169 = r74
            r170 = r75
            r171 = r76
            r172 = r77
            r173 = r1
            r174 = r78
            r175 = r79
            r176 = r80
            r177 = r81
            r178 = r82
            r179 = r83
            r180 = r84
            r181 = r85
            r182 = r86
            r183 = r87
            r184 = r88
            r185 = r89
            r186 = r90
            r187 = r91
            r188 = r2
            r94.<init>(r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRProductsItem.<init>(java.lang.String, java.util.HashMap, java.lang.String, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, net.one97.paytm.recharge.model.v4.CJRExtensionAttributes, java.lang.String, java.lang.Integer, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.g.b.g):void");
    }

    public final Boolean getHide_fastforward() {
        return this.hide_fastforward;
    }

    public final String getService() {
        return this.service;
    }

    public final String getPaytype() {
        return this.paytype;
    }

    public final Object getOverrideAttrs() {
        return this.overrideAttrs;
    }

    public final String getBoard() {
        return this.board;
    }

    public final String getGroupConfigKey() {
        return this.groupConfigKey;
    }

    public final String getCheckBoxKey() {
        return this.checkBoxKey;
    }

    public final String getCheckboxDisplayType() {
        return this.checkboxDisplayType;
    }

    public final String getCheckboxScreenTitle() {
        return this.checkboxScreenTitle;
    }

    public final String getCheckboxFlowType() {
        return this.checkboxFlowType;
    }

    public final String getDealsMessage() {
        return this.dealsMessage;
    }

    public final String getBottomSheetHeading() {
        return this.bottomSheetHeading;
    }

    public final String getBottomSheetCancelText() {
        return this.bottomSheetCancelText;
    }

    public final String getBottomSheetMessage() {
        return this.bottomSheetMessage;
    }

    public final String getBottomSheetOkText() {
        return this.bottomSheetOkText;
    }

    public final String getBottomSheetCheckBoxText() {
        return this.bottomSheetCheckBoxText;
    }

    public final String getErrorImage() {
        return this.errorImage;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getRemindable() {
        return this.remindable;
    }

    public final void setRemindable(String str) {
        this.remindable = str;
    }

    public final String getFeeTypeVisibility() {
        return this.feeTypeVisibility;
    }

    public final void setFeeTypeVisibility(String str) {
        this.feeTypeVisibility = str;
    }

    public final String getMetaDescription() {
        return this.metaDescription;
    }

    public final String getOne2OneOfferText() {
        return this.one2OneOfferText;
    }

    public final String getCircle() {
        return this.circle;
    }

    public final String getOperatorLabel() {
        return this.operatorLabel;
    }

    public final String getOperatorDisplayLabel() {
        return this.operatorDisplayLabel;
    }

    public final String getGroup_Config_Key() {
        return this.group_Config_Key;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getBankEMandateEnable() {
        return this.bankEMandateEnable;
    }

    public final void setBankEMandateEnable(String str) {
        this.bankEMandateEnable = str;
    }

    public final String getCircleLabel() {
        return this.circleLabel;
    }

    public final String getProductTypeLabel() {
        return this.productTypeLabel;
    }

    public final int getEnableBillPayment() {
        return this.enableBillPayment;
    }

    public final int getEnableVisaDirect() {
        return this.enableVisaDirect;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getMetaTitle() {
        return this.metaTitle;
    }

    public final String getPostOrderViewType() {
        return this.postOrderViewType;
    }

    public final String getOne2OneDisclaimerText() {
        return this.one2OneDisclaimerText;
    }

    public final String getDeclarationCaption() {
        return this.declarationCaption;
    }

    public final String getDeclarationText1() {
        return this.declarationText1;
    }

    public final String getDeclarationText2() {
        return this.declarationText2;
    }

    public final String getDeclarationCta() {
        return this.declarationCta;
    }

    public final String getUserConsent() {
        return this.userConsent;
    }

    public final String getThinBannerURL() {
        return this.thinBannerURL;
    }

    public final String getRequestType() {
        return this.requestType;
    }

    public final List<Help> getDthHelp() {
        return this.dthHelp;
    }

    public final String getDthAmountFetch() {
        return this.dthAmountFetch;
    }

    public final String getOffersForYou() {
        return this.offersForYou;
    }

    public final String getOffersForYouDisclaimer() {
        return this.offersForYouDisclaimer;
    }

    public final String getBbpsLogoUrl() {
        return this.bbpsLogoUrl;
    }

    public final void setBbpsLogoUrl(String str) {
        this.bbpsLogoUrl = str;
    }

    public final String getBbps_logo_url() {
        return this.bbps_logo_url;
    }

    public final void setBbps_logo_url(String str) {
        this.bbps_logo_url = str;
    }

    public final List<Map<?, ?>> getDynamicPlansGrouping() {
        return this.dynamicPlansGrouping;
    }

    public final void setDynamicPlansGrouping(List<? extends Map<?, ?>> list) {
        this.dynamicPlansGrouping = list;
    }

    public final String getBankNameLogoV4() {
        return this.bankNameLogoV4;
    }

    public final void setBankNameLogoV4(String str) {
        this.bankNameLogoV4 = str;
    }

    public final String getCardBgV4() {
        return this.cardBgV4;
    }

    public final void setCardBgV4(String str) {
        this.cardBgV4 = str;
    }

    public final String getCardTypeLogo() {
        return this.cardTypeLogo;
    }

    public final void setCardTypeLogo(String str) {
        this.cardTypeLogo = str;
    }

    public final String getServiceDisplayLabel() {
        return this.serviceDisplayLabel;
    }

    public final void setServiceDisplayLabel(String str) {
        this.serviceDisplayLabel = str;
    }

    public final boolean getShowBrowsePlan() {
        String str = this._showBrowsePlan;
        return str != null && str.equals("1");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r0 = r3._showOne2OneUserOffer;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getShowOne2OneOffer() {
        /*
            r3 = this;
            java.lang.String r0 = r3._showOne2OneOffer
            java.lang.String r1 = "TRUE"
            r2 = 1
            if (r0 == 0) goto L_0x000d
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            if (r0 == r2) goto L_0x0017
        L_0x000d:
            java.lang.String r0 = r3._showOne2OneUserOffer
            if (r0 == 0) goto L_0x0018
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            if (r0 != r2) goto L_0x0018
        L_0x0017:
            return r2
        L_0x0018:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRProductsItem.getShowOne2OneOffer():boolean");
    }

    public final boolean getShowOne2OneUserOffer() {
        String str = this._showOne2OneUserOffer;
        return str != null && p.a(str, "TRUE", true);
    }

    public final boolean getShowDynamicPlan() {
        String str = this._dynamicPlan;
        return str != null && str.equals("1");
    }

    public final String getMinAmount() {
        String str = this._minAmount;
        if (str == null) {
            str = this._min_Amount;
        }
        return str == null ? "1" : str;
    }

    public final String getMaxAmount() {
        String str = this._maxAmount;
        if (str == null) {
            str = this._max_Amount;
        }
        return str == null ? "9999" : str;
    }

    public final boolean isVodaFetchBill() {
        String str = this.vodaFetchbill;
        return str != null && p.a(str, "TRUE", true);
    }

    public final boolean isFetchAmount() {
        String str = this.fetchAmount;
        return str != null && p.a(str, "1", true);
    }

    public final String getDynamicPlanCategoryLabel() {
        String str = this._dynamicPlanCategoryLabel;
        if (str == null) {
            str = this._dynamic_plan_category_label;
        }
        return str == null ? "" : str;
    }

    public final boolean isPrefetch() {
        String str = this.prefetch;
        return str != null && p.a(str, "1", true);
    }

    public final boolean isSoftPrefetch() {
        String str = this.softPrefetch;
        return str != null && p.a(str, "1", true);
    }

    public final boolean isShowDisplayValuesEnabled() {
        String str = this.showDisplayValues;
        return str != null && p.a(str, "TRUE", true);
    }

    public final CJRUtilityAlertV2 getAlertObject() {
        CJRUtilityAlertV2 cJRUtilityAlertV2 = this.alert;
        if (cJRUtilityAlertV2 == null) {
            return cJRUtilityAlertV2;
        }
        CharSequence charSequence = this.bottomSheetHeading;
        if (charSequence == null || p.a(charSequence)) {
            return null;
        }
        CJRUtilityAlertV2 cJRUtilityAlertV22 = new CJRUtilityAlertV2();
        cJRUtilityAlertV22.setHeading(this.bottomSheetHeading);
        cJRUtilityAlertV22.setMessage(this.bottomSheetMessage);
        cJRUtilityAlertV22.setNegative_btn_txt(this.bottomSheetCancelText);
        cJRUtilityAlertV22.setPositive_btn_txt(this.bottomSheetOkText);
        cJRUtilityAlertV22.setCheck_box_text(this.bottomSheetCheckBoxText);
        return cJRUtilityAlertV22;
    }

    public final boolean isRemindable() {
        return p.a("2", this.remindable, true);
    }

    public final boolean isPostPaid() {
        return p.a(BaseViewModel.PaymentType.POSTPAID, this.paytype, true);
    }

    public final boolean shouldHideFastForward() {
        return k.a((Object) this.hide_fastforward, (Object) Boolean.TRUE);
    }

    public final List<String> getAmountButtonList() {
        String str;
        if (TextUtils.isEmpty(this.amountButtons) || (str = this.amountButtons) == null) {
            return null;
        }
        return new l(";").split(str, 0);
    }

    public final boolean isProceedToPGEnabled() {
        return p.a("1", this.proceedDirectlyToPG, true);
    }

    public final boolean isBillPaymentEnabled() {
        return this.enableBillPayment == 1;
    }

    public final boolean isVisaDirectEnabled() {
        return this.enableVisaDirect == 1;
    }

    public final int getVendingChargeInInteger() {
        String str = this.vendingCharge;
        if (str == null) {
            return 0;
        }
        try {
            return (int) Double.parseDouble(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public final boolean isShowViewMyBillWithMobileVerfication() {
        return p.a("2", this.showViewBill, true);
    }

    public final boolean isDTHAmountFetchTrue() {
        return p.a("true", this.dthAmountFetch, true);
    }

    public final boolean isOffersForYouEnabled() {
        return p.a("true", this.offersForYou, true);
    }

    public final boolean isBankMandateEnable() {
        return p.a("1", this.bankEMandateEnable, true);
    }
}
