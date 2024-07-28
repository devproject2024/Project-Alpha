package com.paytmmall.clpartifact.modal.clpCommon;

import com.android.volley.VolleyError;
import java.io.Serializable;

public class CLPNetworkResponse implements Serializable {
    private VolleyError error;

    public CLPNetworkResponse() {
    }

    public CLPNetworkResponse(VolleyError volleyError) {
        this.error = volleyError;
    }

    public boolean isSuccess() {
        return this.error == null;
    }

    public VolleyError getError() {
        return this.error;
    }

    public void setError(VolleyError volleyError) {
        this.error = volleyError;
    }
}
