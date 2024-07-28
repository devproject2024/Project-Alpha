package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class SupercashStagesItem extends IJRPaytmDataModel {
    @b(a = "event")
    private String event;
    @b(a = "surprise_stage")
    private String surpriseStage;

    public String getSurpriseStage() {
        return this.surpriseStage;
    }

    public String getEvent() {
        return this.event;
    }
}
