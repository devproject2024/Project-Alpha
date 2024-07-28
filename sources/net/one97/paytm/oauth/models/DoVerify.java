package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DoVerify extends IJRPaytmDataModel {
    @c(a = "canRetry")
    private final String canRetry;
    @c(a = "httpStatus")
    private final String httpStatus;
    @c(a = "isFinish")
    private final String isFinish;
    @c(a = "renderData")
    private final RenderDataResModel renderData;
    @c(a = "resultInfo")
    private final ResultInfoResModel resultInfo;
    @c(a = "verifyId")
    private final String verifyId;

    public final String getHttpStatus() {
        return this.httpStatus;
    }

    public final String getCanRetry() {
        return this.canRetry;
    }

    public final String isFinish() {
        return this.isFinish;
    }

    public final RenderDataResModel getRenderData() {
        return this.renderData;
    }

    public final ResultInfoResModel getResultInfo() {
        return this.resultInfo;
    }

    public final String getVerifyId() {
        return this.verifyId;
    }
}
