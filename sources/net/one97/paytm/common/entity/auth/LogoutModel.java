package net.one97.paytm.common.entity.auth;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class LogoutModel extends IJRPaytmDataModel implements IJRDataModel {
    private boolean loggedOut;
    private String responseCode;
    private String status;

    public String getResponseCode() {
        return this.responseCode;
    }

    public boolean isLoggedOut() {
        return this.loggedOut;
    }

    public String getStatus() {
        return this.status;
    }
}
