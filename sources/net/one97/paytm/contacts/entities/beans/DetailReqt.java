package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class DetailReqt extends IJRPaytmDataModel implements IJRDataModel {
    private int count;
    private Long lastTimestamp;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public Long getLastTimestamp() {
        return this.lastTimestamp;
    }

    public void setLastTimestamp(Long l) {
        this.lastTimestamp = l;
    }
}
