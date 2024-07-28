package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class EmiDetail {
    @c(a = "emiChannelInfos")
    @a
    private List<EmiChannelInfo> emiChannelInfos = null;

    public List<EmiChannelInfo> getEmiChannelInfos() {
        return this.emiChannelInfos;
    }

    public void setEmiChannelInfos(List<EmiChannelInfo> list) {
        this.emiChannelInfos = list;
    }
}
