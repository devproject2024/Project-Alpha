package com.travel.flight.flightticket.i;

import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse;

public interface b {
    void a();

    void setCancellationData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails);

    void setFlightBaggageData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails);

    void setFlightFareBreakupData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails, CJRFlightPromoResponse cJRFlightPromoResponse, boolean z);

    void setRescheduleData(CJRFareRulesResponse cJRFareRulesResponse, String str, CJRFlightDetails cJRFlightDetails);
}
