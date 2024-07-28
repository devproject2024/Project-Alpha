package net.one97.paytm.passbook.mapping;

import com.paytm.network.model.NetworkCustomError;

public class d extends NetworkCustomError {
    private String mErrorCode;

    public void setmErrorCode(String str) {
        this.mErrorCode = str;
    }

    public String getmErrorCode() {
        return this.mErrorCode;
    }
}
