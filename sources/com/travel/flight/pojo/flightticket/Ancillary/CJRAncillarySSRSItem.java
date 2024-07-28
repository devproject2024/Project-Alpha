package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySSRSItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "baggage")
    private ArrayList<CJRAncillarySSRSBaggageDetails> baggage;
    @b(a = "food")
    private ArrayList<CJRAncillarySSRSFoodDetails> food;

    public ArrayList<CJRAncillarySSRSFoodDetails> getFood() {
        return this.food;
    }

    public ArrayList<CJRAncillarySSRSBaggageDetails> getBaggage() {
        return this.baggage;
    }
}
