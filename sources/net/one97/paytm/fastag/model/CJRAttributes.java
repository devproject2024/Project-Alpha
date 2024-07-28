package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAttributes extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "alert_heading")
    private String alert_heading;
    @b(a = "alert_message")
    private String alert_message;
    @b(a = "bbps_logo_url")
    private String bbpsLogoUrl;
    @b(a = "devotional_place")
    private String devotionalPlace;
    @b(a = "disclaimer")
    private String disclaimer;
    @b(a = "fee_structure")
    private String feeStructure;
    @b(a = "ticket_type_icon")
    private String icon;
    @b(a = "is_product_disabled")
    private boolean isProductDisabled;
    @b(a = "landing_page_url")
    private String landingPageUrl;
    @b(a = "location")
    private String location;
    @b(a = "amount")
    private String mAmount;
    @b(a = "circle")
    private String mCircle;
    @b(a = "circle_label")
    private String mCircleLabel;
    @b(a = "info")
    private String mInfo;
    @b(a = "max_amount")
    private String mMaxAmount;
    @b(a = "message")
    private String mMessage;
    @b(a = "min_amount")
    private String mMinAmount;
    @b(a = "operator_label")
    private String mOperatorLabel;
    @b(a = "operator")
    private String mOperatorName;
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
    @b(a = "service")
    private String mService;
    @b(a = "service_label")
    private String mServiceLabel;
    @b(a = "status")
    private String mStatus;
    @b(a = "updated_info")
    private String mUpdatedInfo;
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
    @b(a = "ticket_type")
    private String ticketType;

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

    public String getPayTypeLabel() {
        return this.mPayTypeLabel;
    }

    public String getOperatorLabel() {
        return this.mOperatorLabel;
    }

    public String getCircleLabel() {
        return this.mCircleLabel;
    }

    public String getProductTypeLabel() {
        return this.mProductTypeLabel;
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
}
