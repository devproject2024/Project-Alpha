package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightClientLoginPayload implements IJRDataModel {
    private static CJRFlightClientLoginPayload instance;
    @b(a = "events")
    private ArrayList<PayloadEventDetails> events = new ArrayList<>();
    @b(a = "requestid")
    private String requestid;
    @b(a = "user_id")
    private String user_id;

    private CJRFlightClientLoginPayload() {
    }

    public static CJRFlightClientLoginPayload getInstance() {
        if (instance == null) {
            instance = new CJRFlightClientLoginPayload();
        }
        return instance;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public void setRequestid(String str) {
        this.requestid = str;
    }

    public ArrayList<PayloadEventDetails> getEvents() {
        return this.events;
    }

    private void setEvents(ArrayList<PayloadEventDetails> arrayList) {
        this.events = arrayList;
    }

    private void setEvents(PayloadEventDetails payloadEventDetails) {
        this.events.add(payloadEventDetails);
    }

    public void setEvent(String str, String str2) {
        PayloadEventDetails payloadEventDetails = new PayloadEventDetails();
        payloadEventDetails.setName(str);
        payloadEventDetails.setValue(str2);
        payloadEventDetails.setTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        instance.setEvents(payloadEventDetails);
    }

    public static void clear() {
        instance = null;
    }
}
