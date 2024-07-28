package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickSRP extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "departure_date")
    private boolean departureDate;
    @b(a = "departure_dates")
    private List<Object> departureDates = null;
    @b(a = "destination_station")
    private boolean destinationStation;
    @b(a = "source_station")
    private boolean sourceStation;

    public boolean getSourceStation() {
        return this.sourceStation;
    }

    public boolean getDestinationStation() {
        return this.destinationStation;
    }

    public boolean getDepartureDate() {
        return this.departureDate;
    }

    public List<Object> getDepartureDates() {
        return this.departureDates;
    }
}
