package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPolicyDetailsCancellationNModification implements IJRDataModel {
    @b(a = "baggage_type")
    private String baggageType;
    @b(a = "messages")
    private ArrayList<CJRMessageKeyValue> messages;
    @b(a = "notes")
    private ArrayList<Object> notes;
    private String title;

    public String getBaggageType() {
        return this.baggageType;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRMessageKeyValue> getMessages() {
        return this.messages;
    }
}
