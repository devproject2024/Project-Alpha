package net.one97.paytm.recharge.legacy.catalog.model;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUtilityAttributesV2 implements IJRDataModel {
    @b(a = "additional_info_1")
    private String additionalInfo1;
    @b(a = "additional_info_2")
    private String additionalInfo2;
    @b(a = "additional_info_3")
    private String additionalInfo3;
    @b(a = "additional_info_4")
    private String additionalInfo4;
    @b(a = "alert")
    private CJRUtilityAlertV2 alert;
    @b(a = "amount")
    private String amount;
    @b(a = "amount_buttons")
    private String amountButtonList;
    @b(a = "bbps_logo_url")
    private String bbpsLogoURL;
    @b(a = "cancellation_allowed")
    private String cancellation_allowed;
    @b(a = "checkbox_display_type")
    private String checkboxDisplayType;
    @b(a = "checkbox_flow_type")
    private String checkboxFlowType;
    @b(a = "color_code")
    private String colorCode;
    @b(a = "credit_card_length")
    private String creditCardLength;
    @b(a = "deals_message")
    private String dealsMessage;
    @b(a = "disable_auto_correct")
    private String disableAutoCorrect;
    @b(a = "disclaimer")
    private String disclaimer;
    @b(a = "disclaimer_html")
    private String disclaimerHtml;
    @b(a = "dynamic_plan")
    private int dynamicPlan;
    @b(a = "enable_bill_payment")
    private int enableBillPayment;
    @b(a = "enable_visa_direct")
    private int enableVisaDirect;
    @b(a = "fee_type_flow")
    private String feeTypeFlow;
    @b(a = "fee_type_key")
    private String feeTypeKey;
    @b(a = "fee_type_visibility")
    private String feeTypeVisibility;
    @b(a = "hideReadMore")
    private String hideReadMore;
    @b(a = "mm_icon")
    private String icon;
    @b(a = "image")
    private String image;
    @b(a = "is_metro_ticket_flow")
    private boolean isMetroTicketFlow;
    @b(a = "is_payfee_before_enabled")
    private boolean isPayFeeBeforeEnabled;
    @b(a = "is_product_disabled")
    private boolean isProductDisabled;
    private String is_bank_mandate_enabled;
    @b(a = "length")
    private String lengthyForm;
    @b(a = "location_key")
    private String locationKey;
    @b(a = "min_bal")
    private String min_bal;
    @b(a = "operator")
    private String operator;
    @b(a = "operator_alert")
    private String operatorAlert;
    @b(a = "paytype")
    private String paytype;
    @b(a = "post_order_view_type")
    private String postOrderViewType;
    @b(a = "prefetch")
    private String prefetch = "0";
    @b(a = "proceed_directly_to_PG")
    private String proceedDirectlyToPG;
    @b(a = "prod_image")
    private String prodImageUrl;
    @b(a = "reqType1")
    private String productRequestType;
    @b(a = "remindable")
    private String remindable;
    @b(a = "request_type")
    private String requestType;
    @b(a = "return_Journey_Type")
    private String returnJourneyType;
    @b(a = "reqType")
    private String selectedProductRequestType;
    @b(a = "service")
    private String service;
    @b(a = "bottomsheet_canceltext")
    private String sheetCancelText;
    @b(a = "bottomsheet_checkboxtext")
    private String sheetCheckBokText;
    @b(a = "bottomsheet_heading")
    private String sheetHeading;
    @b(a = "bottomsheet_message")
    private String sheetMessage;
    @b(a = "bottomsheet_oktext")
    private String sheetOkText;
    @b(a = "show_browse_plan")
    private String showBrowsePlan = "0";
    @b(a = "show_display_values")
    private String show_display_values;
    @b(a = "single_journey_type")
    private String singleJourneyType;
    @b(a = "softblock")
    private Boolean softblock;
    @b(a = "status")
    private Boolean status;

    public boolean isShowDisplayValuesEnabled() {
        return !TextUtils.isEmpty(this.show_display_values) && this.show_display_values.equalsIgnoreCase("True");
    }

    public boolean isCancellable() {
        return "1".equalsIgnoreCase(this.cancellation_allowed);
    }

    public String getPostOrderViewType() {
        return this.postOrderViewType;
    }

    public void setPostOrderViewType(String str) {
        this.postOrderViewType = str;
    }

    public boolean isMetroTicketFlow() {
        return this.isMetroTicketFlow;
    }

    public boolean isProductDisabled() {
        return this.isProductDisabled;
    }

    public String getPrefetch() {
        return this.prefetch;
    }

    public void setPrefetch(String str) {
        this.prefetch = str;
    }

    public Boolean getSoftblock() {
        return this.softblock;
    }

    public void setSoftblock(Boolean bool) {
        this.softblock = bool;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public String getFeeTypeVisibility() {
        return this.feeTypeVisibility;
    }

    public void setFeeTypeVisibility(String str) {
        this.feeTypeVisibility = str;
    }

    public CJRUtilityAlertV2 getAlert() {
        return this.alert;
    }

    public String getFeeTypeFlow() {
        return this.feeTypeFlow;
    }

    public void setFeeTypeFlow(String str) {
        this.feeTypeFlow = str;
    }

    public String getAmountButtonList() {
        return this.amountButtonList;
    }

    public String getFeeTypeKey() {
        return this.feeTypeKey;
    }

    public void setFeeTypeKey(String str) {
        this.feeTypeKey = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public String getDisclaimerHtml() {
        return this.disclaimerHtml;
    }

    public void setDisclaimerHtml(String str) {
        this.disclaimerHtml = str;
    }

    public boolean hideReadMore() {
        return "1".equalsIgnoreCase(this.hideReadMore);
    }

    public void setHideReadMore(boolean z) {
        this.hideReadMore = z ? "1" : "0";
    }

    public String getDealsMessage() {
        return this.dealsMessage;
    }

    public void setDealsMessage(String str) {
        this.dealsMessage = str;
    }

    public String getShowBrowsePlan() {
        return this.showBrowsePlan;
    }

    public void setShowBrowsePlan(String str) {
        this.showBrowsePlan = str;
    }

    public String getCheckboxDisplayType() {
        return this.checkboxDisplayType;
    }

    public void setCheckboxDisplayType(String str) {
        this.checkboxDisplayType = str;
    }

    public String getCheckboxFlowType() {
        return this.checkboxFlowType;
    }

    public void setCheckboxFlowType(String str) {
        this.checkboxFlowType = str;
    }

    public boolean isShowBrowsePlan() {
        return !TextUtils.isEmpty(this.showBrowsePlan) && this.showBrowsePlan.equalsIgnoreCase("1");
    }

    public boolean isDynamicPlan() {
        return this.dynamicPlan == 1;
    }

    public boolean isProceedDirectlyToPG() {
        return "1".equalsIgnoreCase(this.proceedDirectlyToPG);
    }

    public boolean isDisableAutoCorrect() {
        return "true".equalsIgnoreCase(this.disableAutoCorrect);
    }

    public String getLocationKey() {
        return this.locationKey;
    }

    public void setLocationKey(String str) {
        this.locationKey = str;
    }

    public String getProdImageUrl() {
        return this.prodImageUrl;
    }

    public void setProdImageUrl(String str) {
        this.prodImageUrl = str;
    }

    public boolean isEnableBillPayment() {
        return this.enableBillPayment == 1;
    }

    public boolean isEnableVisaDirect() {
        return this.enableVisaDirect == 1;
    }

    public String getImage() {
        return this.image;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getSheetHeading() {
        return this.sheetHeading;
    }

    public void setSheetHeading(String str) {
        this.sheetHeading = str;
    }

    public String getSheetMessage() {
        return this.sheetMessage;
    }

    public void setSheetMessage(String str) {
        this.sheetMessage = str;
    }

    public String getSheetOkText() {
        return this.sheetOkText;
    }

    public void setSheetOkText(String str) {
        this.sheetOkText = str;
    }

    public String getSheetCancelText() {
        return this.sheetCancelText;
    }

    public void setSheetCancelText(String str) {
        this.sheetCancelText = str;
    }

    public String getSheetCheckBokText() {
        return this.sheetCheckBokText;
    }

    public void setSheetCheckBokText(String str) {
        this.sheetCheckBokText = str;
    }

    public String getAdditionalInfo1() {
        return this.additionalInfo1;
    }

    public void setAdditionalInfo1(String str) {
        this.additionalInfo1 = str;
    }

    public String getAdditionalInfo2() {
        return this.additionalInfo2;
    }

    public void setAdditionalInfo2(String str) {
        this.additionalInfo2 = str;
    }

    public String getAdditionalInfo3() {
        return this.additionalInfo3;
    }

    public void setAdditionalInfo3(String str) {
        this.additionalInfo3 = str;
    }

    public String getAdditionalInfo4() {
        return this.additionalInfo4;
    }

    public void setAdditionalInfo4(String str) {
        this.additionalInfo4 = str;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String str) {
        this.service = str;
    }

    public String getPaytype() {
        return this.paytype;
    }

    public void setPaytype(String str) {
        this.paytype = str;
    }

    public boolean isOperatorAlert() {
        return "1".equalsIgnoreCase(this.operatorAlert);
    }

    public String getCreditCardLength() {
        return this.creditCardLength;
    }

    public void setCreditCardLength(String str) {
        this.creditCardLength = str;
    }

    public String getRemindable() {
        return this.remindable;
    }

    public boolean isLengthyForm() {
        String str = this.lengthyForm;
        if (str != null) {
            return "1".equalsIgnoreCase(str);
        }
        return false;
    }

    public void setLengthyForm(String str) {
        this.lengthyForm = str;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public void setColorCode(String str) {
        this.colorCode = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getMin_bal() {
        return this.min_bal;
    }

    public String getProductRequestType() {
        return this.productRequestType;
    }

    public String getSelectedProductRequestType() {
        return this.selectedProductRequestType;
    }

    public String getSingleJourneyType() {
        return this.singleJourneyType;
    }

    public String getReturnJourneyType() {
        return this.returnJourneyType;
    }

    public String getBbpsLogoURL() {
        return this.bbpsLogoURL;
    }

    public void setBbpsLogoURL(String str) {
        this.bbpsLogoURL = str;
    }

    public boolean isPayFeeBeforeEnabled() {
        return this.isPayFeeBeforeEnabled;
    }

    public void setPayFeeBeforeEnabled(boolean z) {
        this.isPayFeeBeforeEnabled = z;
    }

    public boolean isBankMandateEnable() {
        return "1".equalsIgnoreCase(this.is_bank_mandate_enabled);
    }
}
