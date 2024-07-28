package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class Details extends IJRPaytmDataModel implements IJRDataModel {
    private String action;
    private String count;
    private String currentCount;
    private String currentLastTimestamp;
    private String lastTimestamp;
    private String type;

    public String getLastTimestamp() {
        return this.lastTimestamp;
    }

    public void setLastTimestamp(String str) {
        this.lastTimestamp = str;
    }

    public String getCurrentCount() {
        return this.currentCount;
    }

    public void setCurrentCount(String str) {
        this.currentCount = str;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getCurrentLastTimestamp() {
        return this.currentLastTimestamp;
    }

    public void setCurrentLastTimestamp(String str) {
        this.currentLastTimestamp = str;
    }

    public String toString() {
        return "ClassPojo [lastTimestamp = " + this.lastTimestamp + ", currentCount = " + this.currentCount + ", count = " + this.count + ", action = " + this.action + ", type = " + this.type + ", currentLastTimestamp = " + this.currentLastTimestamp + "]";
    }
}
