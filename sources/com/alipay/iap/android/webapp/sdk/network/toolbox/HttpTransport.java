package com.alipay.iap.android.webapp.sdk.network.toolbox;

public interface HttpTransport {
    HttpResponse performRequest(HttpRequest httpRequest) throws Exception;
}
