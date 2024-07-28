package net.one97.paytm.games.model;

import com.google.gson.a.c;
import java.util.HashMap;

public class GpPostTxnDataResponse extends GpCommonBaseResponse {
    @c(a = "client_sdk_response")
    private HashMap<String, String> client_sdk_response;

    public HashMap<String, String> getClient_sdk_response() {
        return this.client_sdk_response;
    }
}
