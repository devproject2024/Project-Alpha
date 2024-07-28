package net.one97.paytm.common.entity.weex;

import java.util.Map;

public class WXNetworkResponse {
    public final Object data;
    public final Map<String, String> headers;
    public final int status;

    public WXNetworkResponse(int i2, Object obj, Map<String, String> map) {
        this.status = i2;
        this.data = obj;
        this.headers = map;
    }

    public WXNetworkResponse(int i2, Object obj) {
        this(i2, obj, (Map<String, String>) null);
    }
}
