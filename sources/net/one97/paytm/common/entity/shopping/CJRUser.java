package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUser implements IJRDataModel {
    @b(a = "experiment_id")
    private String experimentID;
    @b(a = "ga_id")
    private int gaID;
    @b(a = "user_id")
    private int userID;

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int i2) {
        this.userID = i2;
    }

    public int getGaID() {
        return this.gaID;
    }

    public void setGaID(int i2) {
        this.gaID = i2;
    }

    public String getExperimentID() {
        return this.experimentID;
    }

    public void setExperimentID(String str) {
        this.experimentID = str;
    }
}
