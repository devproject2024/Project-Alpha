package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroPriceResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "rjt_fare")
    private CJRMetroPriceModel rjtFare;
    @b(a = "sjt_fare")
    private CJRMetroPriceModel sjtFare;
    @b(a = "trip_pass_arr")
    private ArrayList<CJRMetroPriceModel> tripPassArr;
    @b(a = "trip_pass")
    private CJRMetroPriceModel tripPassFare;

    public CJRMetroPriceModel getSjtFare() {
        return this.sjtFare;
    }

    public CJRMetroPriceModel getRjtFare() {
        return this.rjtFare;
    }

    public CJRMetroPriceModel getTripPassFare() {
        return this.tripPassFare;
    }

    public ArrayList<CJRMetroPriceModel> getTripPassArray() {
        return this.tripPassArr;
    }
}
