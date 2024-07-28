package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBPDPCancellationBody implements IJRDataModel {
    @b(a = "boarding_points")
    public List<CJRLocation> boarding_points;
    @b(a = "cancellation_policy")
    public List<CJRBusCancellationPolicy> cancellation_policy;
    @b(a = "cancellation_policy_note_text")
    public List<String> cancellation_policy_note_text;
    @b(a = "dropping_points")
    public List<CJRLocation> dropping_points;

    public List<CJRLocation> getBoarding_points() {
        return this.boarding_points;
    }

    public List<CJRLocation> getDropping_points() {
        return this.dropping_points;
    }

    public List<CJRBusCancellationPolicy> getCancellation_policy() {
        return this.cancellation_policy;
    }

    public List<String> getCancellation_policy_note_text() {
        return this.cancellation_policy_note_text;
    }
}
