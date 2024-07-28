package com.travel.flight.pojo.flightticket.FareRules;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMiniRulesLayoutItem implements IJRDataModel {
    private String headerNote;
    private String headerTitle;
    private String mLayoutType;
    private CJRPolicyDetailsCancellationNModification policyDetailCancellationModification;
    private CJRPolicyDetailsBaggage policyDetailsBaggage;
    private CJRCancelRefund refundable;
    private CJRFareRulesJorneyRoute route;
    private String screenName;
    private CJRMiniRuleTC termsAndConditions;
    private String windowMessage;

    public String getHeaderTitle() {
        return this.headerTitle;
    }

    public void setHeaderTitle(String str) {
        this.headerTitle = str;
    }

    public String getHeaderNote() {
        return this.headerNote;
    }

    public void setHeaderNote(String str) {
        this.headerNote = str;
    }

    public String getmLayoutType() {
        return this.mLayoutType;
    }

    public void setmLayoutType(String str) {
        this.mLayoutType = str;
    }

    public CJRMiniRuleTC getTermsAndConditions() {
        return this.termsAndConditions;
    }

    public void setTermsAndConditions(CJRMiniRuleTC cJRMiniRuleTC) {
        this.termsAndConditions = cJRMiniRuleTC;
    }

    public CJRFareRulesJorneyRoute getRoute() {
        return this.route;
    }

    public void setRoute(CJRFareRulesJorneyRoute cJRFareRulesJorneyRoute) {
        this.route = cJRFareRulesJorneyRoute;
    }

    public CJRCancelRefund getRefundable() {
        return this.refundable;
    }

    public void setRefundable(CJRCancelRefund cJRCancelRefund) {
        this.refundable = cJRCancelRefund;
    }

    public CJRPolicyDetailsCancellationNModification getPolicyDetailCancellationModification() {
        return this.policyDetailCancellationModification;
    }

    public void setPolicyDetailCancellationModification(CJRPolicyDetailsCancellationNModification cJRPolicyDetailsCancellationNModification) {
        this.policyDetailCancellationModification = cJRPolicyDetailsCancellationNModification;
    }

    public String getWindowMessage() {
        return this.windowMessage;
    }

    public void setWindowMessage(String str) {
        this.windowMessage = str;
    }

    public CJRPolicyDetailsBaggage getPolicyDetailsBaggage() {
        return this.policyDetailsBaggage;
    }

    public void setPolicyDetailsBaggage(CJRPolicyDetailsBaggage cJRPolicyDetailsBaggage) {
        this.policyDetailsBaggage = cJRPolicyDetailsBaggage;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }
}
