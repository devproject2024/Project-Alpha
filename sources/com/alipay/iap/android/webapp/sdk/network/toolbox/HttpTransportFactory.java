package com.alipay.iap.android.webapp.sdk.network.toolbox;

public class HttpTransportFactory {
    public static HttpTransport createHttpTransport() {
        return createHttpTransport(false);
    }

    public static HttpTransport createHttpTransport(boolean z) {
        return z ? new UrlTransport(true) : new UrlTransport();
    }
}
