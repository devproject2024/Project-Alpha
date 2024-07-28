package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsuranceBody implements IJRDataModel {
    @b(a = "cancellation_protect")
    private List<CJRCancelProtectInsuranceItem> cancelProtectInsuranceDetail = new ArrayList();
    @b(a = "travel_insurance")
    private List<CJRInsuranceItem> insuranceDetail = new ArrayList();

    public List<CJRInsuranceItem> getInsuranceDetail() {
        return this.insuranceDetail;
    }

    public List<CJRCancelProtectInsuranceItem> getCancelProtectInsuranceDetail() {
        return this.cancelProtectInsuranceDetail;
    }
}
