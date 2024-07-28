package net.one97.paytm.common.entity.auth;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class KYCFetchTnc extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String status;
    @b(a = "data")
    private ArrayList<TncData> tncDataList;

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public ArrayList<TncData> getTncDataList() {
        return this.tncDataList;
    }
}
