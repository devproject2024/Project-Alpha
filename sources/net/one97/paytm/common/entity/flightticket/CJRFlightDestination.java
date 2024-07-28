package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightDestination implements IJRDataModel {
    @b(a = "airport")
    private String flightDestinationAirport;
    @b(a = "city")
    private String flightDestinationCity;
    @b(a = "iata")
    private String flightDestinationCode;

    public String getFlightDestinationCode() {
        return this.flightDestinationCode;
    }

    public void setFlightDestinationCode(String str) {
        this.flightDestinationCode = str;
    }

    public String getFlightDestinationCity() {
        return this.flightDestinationCity;
    }

    public void setFlightDestinationCity(String str) {
        this.flightDestinationCity = str;
    }

    public String getFlightDestinationAirport() {
        return this.flightDestinationAirport;
    }

    public void setFlightDestinationAirport(String str) {
        this.flightDestinationAirport = str;
    }
}
