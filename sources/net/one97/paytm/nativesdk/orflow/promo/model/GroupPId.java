package net.one97.paytm.nativesdk.orflow.promo.model;

import java.io.Serializable;

public class GroupPId implements Serializable {
    private Integer pid;
    private String pidKey;
    private Integer qty;

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer num) {
        this.pid = num;
    }

    public String getPidKey() {
        return this.pidKey;
    }

    public void setPidKey(String str) {
        this.pidKey = str;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer num) {
        this.qty = num;
    }
}
