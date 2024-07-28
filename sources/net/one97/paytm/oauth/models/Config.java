package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class Config extends IJRPaytmDataModel {
    @c(a = "pollingFrequency")
    private final String pollingFrequency;
    @c(a = "sendSmsDelay")
    private final int sendSmsDelay = 2;
    @c(a = "smsTimeOut")
    private final Integer smsTimeOut = 5;

    public final String getPollingFrequency() {
        return this.pollingFrequency;
    }

    public final Integer getSmsTimeOut() {
        return this.smsTimeOut;
    }

    public final int getSendSmsDelay() {
        return this.sendSmsDelay;
    }
}
