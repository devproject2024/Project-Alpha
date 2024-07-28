package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DoViewResModel extends IJRPaytmDataModel {
    @c(a = "httpStatus")
    private final String httpStatus;
    @c(a = "method")
    private final String method;
    @c(a = "renderData")
    private final RenderDataRes renderData;
    @c(a = "resultInfo")
    private final ResultInfoRes resultInfo;
    @c(a = "verifyId")
    private final String verifyId;

    public final String getHttpStatus() {
        return this.httpStatus;
    }

    public final String getMethod() {
        return this.method;
    }

    public final RenderDataRes getRenderData() {
        return this.renderData;
    }

    public final ResultInfoRes getResultInfo() {
        return this.resultInfo;
    }

    public final String getVerifyId() {
        return this.verifyId;
    }
}
