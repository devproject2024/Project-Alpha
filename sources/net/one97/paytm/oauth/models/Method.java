package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class Method extends IJRPaytmDataModel {
    @c(a = "config")
    private final Config config;
    @c(a = "isIntervenable")
    private final Boolean isIntervenable;
    @c(a = "key")
    private final String key;
    @c(a = "maxRetryCount")
    private final String maxRetryCount;
    @c(a = "name")
    private final String name;
    @c(a = "priority")
    private final int priority;
    @c(a = "retryInterval")
    private final String retryInterval;
    @c(a = "timeout")
    private final String timeout;

    public final Config getConfig() {
        return this.config;
    }

    public final Boolean isIntervenable() {
        return this.isIntervenable;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRetryInterval() {
        return this.retryInterval;
    }

    public final String getTimeout() {
        return this.timeout;
    }

    public final int getPriority() {
        return this.priority;
    }
}
