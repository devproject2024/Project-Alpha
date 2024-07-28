package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryBodyDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "onward")
    private List<CJRAncillaryItemDetail> onwardjrnyList;
    @b(a = "return")
    private List<CJRAncillaryItemDetail> returnJrnyList;

    public List<CJRAncillaryItemDetail> getOnwardjrnyList() {
        return this.onwardjrnyList;
    }

    public List<CJRAncillaryItemDetail> getReturnJrnyList() {
        return this.returnJrnyList;
    }
}
