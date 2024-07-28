package net.one97.paytm.recharge.legacy.catalog.model.v2;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeProductAttributesV2 implements IJRDataModel {
    private String One2OneOfferDisclaimer;
    private String One2OneOfferText;
    private CJRRechargeProductAttributesAlertV2 alertV2;
    private String circleDisplay;
    private String circleFilter;
    @b(a = "deals_message")
    private String dealsMessage;
    private String dynamicPlanCategoryLabel;
    private CJRRechargeProductAttributesErrorV2 errorV2;
    private String fetch_amount;
    private int isDynamicPlan = 0;
    private String isOne2OneOfferEnabled;
    private String isOperatorAlert;
    private boolean isSpecialRecharge;
    private boolean isTalktimeTopup;
    private String max_amount;
    @b(a = "min_android_version")
    private String minAndroidVersion;
    private String min_amount;
    private String operatorDisplay;
    private String operatorFilter;
    @b(a = "paytype")
    private String paytype;
    @b(a = "post_order_view_type")
    private String postOrderViewType;
    private String prefetch;
    private String rechargeTypeDisplayName;
    private String rechargeTypeFilterName;
    private String regEx;
    private String remindable;
    @b(a = "schedulable")
    private String schedulable;
    @b(a = "service")
    private String service;
    @b(a = "status")
    private String status;
    @b(a = "voda_fetchbill")
    private String vodaFetchbill;

    public String getPostOrderViewType() {
        return this.postOrderViewType;
    }

    public void setPostOrderViewType(String str) {
        this.postOrderViewType = str;
    }

    public String getMin_amount() {
        return this.min_amount;
    }

    public String getMax_amount() {
        return this.max_amount;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPrefetch() {
        return this.prefetch;
    }

    public String getRegEx() {
        return this.regEx;
    }

    public void setMin_amount(String str) {
        this.min_amount = str;
    }

    public void setMax_amount(String str) {
        this.max_amount = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setPrefetch(String str) {
        this.prefetch = str;
    }

    public void setRegEx(String str) {
        this.regEx = str;
    }

    public String getOperatorFilter() {
        return this.operatorFilter;
    }

    public void setOperatorFilter(String str) {
        this.operatorFilter = str;
    }

    public String getOperatorDisplay() {
        return this.operatorDisplay;
    }

    public void setOperatorDisplay(String str) {
        this.operatorDisplay = str;
    }

    public String getCircleDisplay() {
        return this.circleDisplay;
    }

    public void setCircleDisplay(String str) {
        this.circleDisplay = str;
    }

    public String getCircleFilter() {
        return this.circleFilter;
    }

    public void setCircleFilter(String str) {
        this.circleFilter = str;
    }

    public String getRechargeTypeFilterName() {
        return this.rechargeTypeFilterName;
    }

    public void setRechargeTypeFilterName(String str) {
        this.rechargeTypeFilterName = str;
    }

    public String getRechargeTypeDisplayName() {
        return this.rechargeTypeDisplayName;
    }

    public void setRechargeTypeDisplayName(String str) {
        this.rechargeTypeDisplayName = str;
    }

    public String getFetch_amount() {
        return this.fetch_amount;
    }

    public void setFetch_amount(String str) {
        this.fetch_amount = str;
    }

    public CJRRechargeProductAttributesErrorV2 getErrorV2() {
        return this.errorV2;
    }

    public void setErrorV2(CJRRechargeProductAttributesErrorV2 cJRRechargeProductAttributesErrorV2) {
        this.errorV2 = cJRRechargeProductAttributesErrorV2;
    }

    public CJRRechargeProductAttributesAlertV2 getAlertV2() {
        return this.alertV2;
    }

    public void setAlertV2(CJRRechargeProductAttributesAlertV2 cJRRechargeProductAttributesAlertV2) {
        this.alertV2 = cJRRechargeProductAttributesAlertV2;
    }

    public boolean isTalktimeTopup() {
        return this.isTalktimeTopup;
    }

    public void setTalktimeTopup(boolean z) {
        this.isTalktimeTopup = z;
    }

    public boolean isSpecialRecharge() {
        return this.isSpecialRecharge;
    }

    public void setSpecialRecharge(boolean z) {
        this.isSpecialRecharge = z;
    }

    public String getDealsMessage() {
        return this.dealsMessage;
    }

    public void setDealsMessage(String str) {
        this.dealsMessage = str;
    }

    public String getMinAndroidVersion() {
        return this.minAndroidVersion;
    }

    public void setMinAndroidVersion(String str) {
        this.minAndroidVersion = str;
    }

    public String getSchedulable() {
        return this.schedulable;
    }

    public void setSchedulable(String str) {
        this.schedulable = str;
    }

    public boolean isVodaFetchbill() {
        return "TRUE".equalsIgnoreCase(this.vodaFetchbill);
    }

    public void setVodaFetchbill(String str) {
        this.vodaFetchbill = str;
    }

    public boolean isOne2OneOfferEnabled() {
        return "TRUE".equalsIgnoreCase(this.isOne2OneOfferEnabled);
    }

    public void setOne2OneOfferEnabled(String str) {
        this.isOne2OneOfferEnabled = str;
    }

    public boolean isDynamicPlan() {
        return this.isDynamicPlan == 1;
    }

    public void setIsDynamicPlan(int i2) {
        this.isDynamicPlan = i2;
    }

    public void setRemindable(String str) {
        this.remindable = str;
    }

    public String getRemindable() {
        return this.remindable;
    }

    public String getDynamicPlanCategoryLabel() {
        return this.dynamicPlanCategoryLabel;
    }

    public void setDynamicPlanCategoryLabel(String str) {
        this.dynamicPlanCategoryLabel = str;
    }

    public String getOne2OneOfferText() {
        return this.One2OneOfferText;
    }

    public void setOne2OneOfferText(String str) {
        this.One2OneOfferText = str;
    }

    public String getOne2OneOfferDisclaimer() {
        return this.One2OneOfferDisclaimer;
    }

    public void setOne2OneOfferDisclaimer(String str) {
        this.One2OneOfferDisclaimer = str;
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

    public boolean getIsOperatorAlert() {
        return "1".equalsIgnoreCase(this.isOperatorAlert);
    }

    public void setIsOperatorAlert(String str) {
        this.isOperatorAlert = str;
    }
}
