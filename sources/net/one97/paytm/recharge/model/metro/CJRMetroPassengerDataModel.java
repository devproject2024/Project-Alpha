package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;

public class CJRMetroPassengerDataModel extends CJRMetroStationDataModel {
    @b(a = "max_passengers")
    private int maxPassengers;

    public int getMaxPassengers() {
        return this.maxPassengers;
    }
}
