package net.one97.paytm.payments.visascp.network.model;

import com.android.volley.NetworkResponse;
import java.io.Serializable;

public class BaseModel implements Serializable {
    private NetworkResponse response;

    public NetworkResponse getResponse() {
        return this.response;
    }

    public void setResponse(NetworkResponse networkResponse) {
        this.response = networkResponse;
    }
}
