package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRoutes implements IJRDataModel {
    @b(a = "baggage_policies")
    private List<CJRPolicyDetailsBaggage> baggage_policies;
    @b(a = "cancellation_policies")
    private List<CJRPolicyDetailsCancellationNModification> cancellation_policies;
    @b(a = "cancellation_window")
    private String cancellation_window;
    @b(a = "modification_policies")
    private List<CJRPolicyDetailsCancellationNModification> modification_policies;
    @b(a = "refundable")
    private CJRCancelRefund refund;
    @b(a = "reschedule_window")
    private String reschedule_window;
    @b(a = "route")
    private CJRFareRulesJorneyRoute route;

    public CJRFareRulesJorneyRoute getRoute() {
        return this.route;
    }

    public CJRCancelRefund getRefund() {
        return this.refund;
    }

    public void setRefund(CJRCancelRefund cJRCancelRefund) {
        this.refund = cJRCancelRefund;
    }

    public String getCancellation_window() {
        return this.cancellation_window;
    }

    public String getReschedule_window() {
        return this.reschedule_window;
    }

    public List<CJRPolicyDetailsBaggage> getBaggage_policies() {
        return this.baggage_policies;
    }

    public List<CJRPolicyDetailsCancellationNModification> getCancellation_policies() {
        return this.cancellation_policies;
    }

    public List<CJRPolicyDetailsCancellationNModification> getModification_policies() {
        return this.modification_policies;
    }
}
