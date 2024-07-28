package net.one97.paytm.o2o.events.common;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventTrackingInfo implements IJRDataModel {
    @b(a = "active")
    private boolean active;
    @b(a = "awbNumber")
    private String awbNumber;
    @b(a = "date")
    private String date;
    @b(a = "info")
    private String info;
    @b(a = "label")
    private String label;
    @b(a = "stateId")
    private int stateId;

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public int getStateId() {
        return this.stateId;
    }

    public void setStateId(int i2) {
        this.stateId = i2;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean z) {
        this.active = z;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public String getAwbNumber() {
        return this.awbNumber;
    }
}
