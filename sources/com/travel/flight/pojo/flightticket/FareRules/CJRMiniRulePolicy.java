package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMiniRulePolicy implements IJRDataModel {
    @b(a = "combined")
    private CJRFareRulesJorneyDetails combined;
    @b(a = "header_note")
    private String header_note;
    @b(a = "onward")
    private CJRFareRulesJorneyDetails onward;
    @b(a = "return")
    private CJRFareRulesJorneyDetails return_;
    @b(a = "tc")
    private CJRMiniRuleTC tc;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getHeader_note() {
        return this.header_note;
    }

    public CJRMiniRuleTC getTc() {
        return this.tc;
    }

    public CJRFareRulesJorneyDetails getOnward() {
        return this.onward;
    }

    public CJRFareRulesJorneyDetails getReturn() {
        return this.return_;
    }

    public CJRFareRulesJorneyDetails getCombined() {
        return this.combined;
    }
}
