package com.business.merchant_payments.event;

public class QrEditEvent {
    public String event_type;
    public int position;

    public QrEditEvent(int i2, String str) {
        this.position = i2;
        this.event_type = str;
    }

    public int getPosition() {
        return this.position;
    }

    public String getEvent_type() {
        return this.event_type;
    }
}
