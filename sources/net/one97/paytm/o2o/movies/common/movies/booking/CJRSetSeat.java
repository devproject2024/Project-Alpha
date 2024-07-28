package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSetSeat extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "items")
    private CJRSetSeatItems items;
    @b(a = "rules")
    private ArrayList<c> rules;
    @b(a = "seatCodes")
    private ArrayList<String> seatCodes = new ArrayList<>();
    @b(a = "seatInfo")
    private String seatInfo;
    @b(a = "tempTransId")
    private String tempTransId;

    public ArrayList<c> getRules() {
        return this.rules;
    }

    public String getSeatInfo() {
        return this.seatInfo;
    }

    public String getTempTransId() {
        return this.tempTransId;
    }

    public ArrayList<String> getSeatCodes() {
        return this.seatCodes;
    }

    public CJRSetSeatItems getItems() {
        return this.items;
    }
}
