package net.one97.paytm.common.entity.recharge;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAttributes implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "alert_heading")
    private String alert_heading;
    @b(a = "alert_message")
    private String alert_message;
    @b(a = "ref_id")
    private String bbpsLabel;
    @b(a = "bbps_assured_logo")
    private String bbpsLogoIconUrl;
    @b(a = "bbps_logo_url")
    private String bbpsLogoUrl;
    @b(a = "card_network")
    private String cardNetwork;
    @b(a = "config_ticket_type")
    private String configTicketType;
    @b(a = "devotional_place")
    private String devotionalPlace;
    @b(a = "disclaimer")
    private String disclaimer;
    @b(a = "fee_structure")
    private String feeStructure;
    @b(a = "ticket_type_icon")
    private String icon;
    @b(a = "is_bank_mandate_enabled")
    private String isBankMandateEnable;
    @b(a = "cancellation_allowed")
    private String isCancellationAllowed;
    @b(a = "imps_enabled")
    private boolean isImpsEnabled = true;
    @b(a = "is_product_disabled")
    private boolean isProductDisabled;
    @b(a = "landing_page_url")
    private String landingPageUrl;
    @b(a = "location")
    private String location;
    @b(a = "amount")
    private String mAmount;
    @b(a = "challan_type")
    private String mChallanType;
    @b(a = "circle")
    private String mCircle;
    @b(a = "circle_label")
    private String mCircleLabel;
    @b(a = "fee_type")
    private String mFeeType;
    @b(a = "fee_type_key")
    private String mFeeTypeKey;
    @b(a = "info")
    private String mInfo;
    @b(a = "max_amount")
    private String mMaxAmount;
    @b(a = "message")
    private String mMessage;
    @b(a = "min_amount")
    private String mMinAmount;
    @b(a = "operator_display_label")
    private String mOperatorDisplayLabel;
    @b(a = "operator_label")
    private String mOperatorLabel;
    @b(a = "operator")
    private String mOperatorName;
    @b(a = "paytype_display_label")
    private String mPayTypeDisplayLabel;
    @b(a = "paytype_label")
    private String mPayTypeLabel;
    @b(a = "paytype")
    private String mPaytype;
    @b(a = "prefetch")
    private String mPrefetch;
    @b(a = "producttype")
    private String mProductType;
    @b(a = "producttype_label")
    private String mProductTypeLabel;
    @b(a = "recharge_number_label")
    private String mRechargeNumberLabel;
    @b(a = "service")
    private String mService;
    @b(a = "service_display_label")
    private String mServiceDisplayLabel;
    @b(a = "service_label")
    private String mServiceLabel;
    @b(a = "status")
    private String mStatus;
    @b(a = "updated_info")
    private String mUpdatedInfo;
    @b(a = "utility_type")
    private String mUtilityType;
    @b(a = "is_metro_ticket_flow")
    private boolean metroQrTicketFLow;
    @b(a = "offering_type")
    private String offeringType;
    @b(a = "operator_Address")
    private String operatorAddress;
    @b(a = "operator_CGST")
    private String operatorCGST;
    @b(a = "operator_Pan")
    private String operatorPan;
    @b(a = "operator_SGST")
    private String operatorSGST;
    @b(a = "prod_image")
    private String prodImageUrl;
    @b(a = "recharge_number_display_label")
    private String rechargeNumberDisplayLabel;
    @b(a = "points_price")
    private String redemptionPointPrice;
    @b(a = "redemption_points")
    private String redemptionPoints;
    @b(a = "sum_insured")
    private String sumInsured;
    @b(a = "ticket_type")
    private String ticketType;
    @b(a = "tn_c_link")
    private String tncLink;
    @b(a = "tnc_text")
    private String tncText;

    public boolean isMetroQrTicketFLow() {
        return this.metroQrTicketFLow;
    }

    public boolean isProductDisabled() {
        return this.isProductDisabled;
    }

    public String getBbpsLogoUrl() {
        return this.bbpsLogoUrl;
    }

    public void setBbpsLogoUrl(String str) {
        this.bbpsLogoUrl = str;
    }

    public String getFeeStructure() {
        return this.feeStructure;
    }

    public void setFeeStructure(String str) {
        this.feeStructure = str;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public String getBbpsLogoIconUrl() {
        return this.bbpsLogoIconUrl;
    }

    public String getBbpsLabel() {
        return this.bbpsLabel;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public String getService() {
        return this.mService;
    }

    public String getPaytype() {
        return this.mPaytype;
    }

    public String getOperatorName() {
        return this.mOperatorName;
    }

    public String getCircle() {
        return this.mCircle;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public String getServiceLabel() {
        return this.mServiceLabel;
    }

    public String getServiceDisplayLabel() {
        if (!TextUtils.isEmpty(this.mServiceDisplayLabel)) {
            return this.mServiceDisplayLabel;
        }
        return this.mServiceLabel;
    }

    public String getPayTypeLabel() {
        return this.mPayTypeLabel;
    }

    public String getPayTypeDisplayLabel() {
        if (!TextUtils.isEmpty(this.mPayTypeDisplayLabel)) {
            return this.mPayTypeDisplayLabel;
        }
        return this.mPayTypeLabel;
    }

    public String getOperatorLabel() {
        return this.mOperatorLabel;
    }

    public String getOperatorDisplayLabel() {
        if (!TextUtils.isEmpty(this.mOperatorDisplayLabel)) {
            return this.mOperatorDisplayLabel;
        }
        return this.mOperatorLabel;
    }

    public String getCircleLabel() {
        return this.mCircleLabel;
    }

    public String getProductTypeLabel() {
        return this.mProductTypeLabel;
    }

    public String getRechargeNumberLabel() {
        return this.mRechargeNumberLabel;
    }

    public void setRechargeNumberLabel(String str) {
        this.mRechargeNumberLabel = str;
    }

    public String getInfo() {
        return this.mInfo;
    }

    public String getMinAmount() {
        return this.mMinAmount;
    }

    public String getMaxAmount() {
        return this.mMaxAmount;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getUpdatedInfo() {
        return this.mUpdatedInfo;
    }

    public String getPrefetch() {
        return this.mPrefetch;
    }

    public String getAlert_message() {
        return this.alert_message;
    }

    public String getAlert_heading() {
        return this.alert_heading;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public String getConfigTicketType() {
        return this.configTicketType;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDevotionalPlace() {
        return this.devotionalPlace;
    }

    public String getOfferingType() {
        return this.offeringType;
    }

    public String getOperatorSGST() {
        return this.operatorSGST;
    }

    public String getOperatorCGST() {
        return this.operatorCGST;
    }

    public String getOperatorAddress() {
        return this.operatorAddress;
    }

    public String getOperatorPan() {
        return this.operatorPan;
    }

    public String getProdImageUrl() {
        return this.prodImageUrl;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getLandingPageUrl() {
        return this.landingPageUrl;
    }

    public boolean isImpsEnabled() {
        return this.isImpsEnabled;
    }

    public void setImpsEnabled(boolean z) {
        this.isImpsEnabled = z;
    }

    public String getSumInsured() {
        return this.sumInsured;
    }

    public String getTnCLink() {
        return this.tncLink;
    }

    public String getTnCText() {
        return this.tncText;
    }

    public String getCardNetwork() {
        return this.cardNetwork;
    }

    public boolean isCancellable() {
        return "1".equalsIgnoreCase(this.isCancellationAllowed);
    }

    public String getRedemptionPoints() {
        return this.redemptionPoints;
    }

    public void setRedemptionPoints(String str) {
        this.redemptionPoints = str;
    }

    public String getRedemptionPointPrice() {
        return this.redemptionPointPrice;
    }

    public void setRedemptionPointPrice(String str) {
        this.redemptionPointPrice = str;
    }

    public boolean isBankMandateEnable() {
        return "1".equalsIgnoreCase(this.isBankMandateEnable);
    }

    public String getmFeeType() {
        return this.mFeeType;
    }

    public String getmFeeTypeKey() {
        return this.mFeeTypeKey;
    }

    public String getmChallanType() {
        return this.mChallanType;
    }

    public String getmUtilityType() {
        return this.mUtilityType;
    }

    public String getRechargeNumberDisplayLabel() {
        return this.rechargeNumberDisplayLabel;
    }

    public void setRechargeNumberDisplayLabel(String str) {
        this.rechargeNumberDisplayLabel = str;
    }
}
