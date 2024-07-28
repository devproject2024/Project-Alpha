package net.one97.paytm.bankCommon.mapping;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.paytm.network.model.NetworkCustomError;

public final class h {
    public static VolleyError a(NetworkCustomError networkCustomError) {
        try {
            return new VolleyError(new NetworkResponse(networkCustomError.networkResponse.statusCode, networkCustomError.networkResponse.data, networkCustomError.networkResponse.headers, networkCustomError.networkResponse.notModified, networkCustomError.networkResponse.networkTimeMs));
        } catch (Exception unused) {
            return new VolleyError();
        }
    }
}
