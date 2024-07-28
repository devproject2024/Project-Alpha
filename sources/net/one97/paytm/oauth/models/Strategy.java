package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public final class Strategy extends IJRPaytmDataModel {
    @c(a = "appVersion")
    private final String appVersion;
    @c(a = "flow")
    private final String flow;
    @c(a = "maxAppVersion")
    private final String maxAppVersion;
    @c(a = "methods")
    private final ArrayList<Method> methods = new ArrayList<>();
    @c(a = "minAppVersion")
    private final String minAppVersion;
    @c(a = "strategy")
    private final String strategy;
    @c(a = "timeout")
    private final String timeout;

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final String getMinAppVersion() {
        return this.minAppVersion;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public final String getTimeout() {
        return this.timeout;
    }

    public final ArrayList<Method> getMethods() {
        return this.methods;
    }
}
