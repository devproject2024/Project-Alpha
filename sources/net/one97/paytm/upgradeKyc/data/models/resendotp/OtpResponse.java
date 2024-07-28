package net.one97.paytm.upgradeKyc.data.models.resendotp;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class OtpResponse extends IJRPaytmDataModel {
    @a
    @b(a = "channel")
    private String channel;
    @a
    @b(a = "state")
    private String state;

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        this.channel = str;
    }
}
