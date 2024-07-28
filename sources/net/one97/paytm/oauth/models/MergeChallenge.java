package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class MergeChallenge extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "currentData")
    private String currentData;
    @b(a = "code")
    private String mCode;
    @b(a = "message")
    private String mMessage;
    @b(a = "parkedState")
    private String mParkedState;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "state")
    private String mState;
    @b(a = "status")
    private String mStatus;
    @b(a = "valueList")
    private ArrayList<String> valueList;

    public String getParkedState() {
        return this.mParkedState;
    }

    public String getCode() {
        return this.mCode;
    }

    public String getState() {
        return this.mState;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getCurrentData() {
        return this.currentData;
    }

    public ArrayList<String> getValueList() {
        return this.valueList;
    }
}
