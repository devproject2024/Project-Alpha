package com.alipay.iap.android.webapp.sdk.app;

import com.alibaba.a.a;
import com.alibaba.a.a.b;
import java.io.Serializable;

public class SubAppConfig implements Serializable {
    public String downloadURL;
    public String extendInfo;
    public String index;
    public MinAppVersion minAppVersion;
    public String remoteURLPrefix;
    public boolean shouldLoadRemote;
    public String type;
    public String updatePolicy;
    public String version;

    public static class AppType {
        public static final String NORMAL = "normal";
        public static final String RESOURCE = "resource";
        public static final String SPA = "spa";
    }

    public static class UpdatePolicy {
        public static final String BLOCK_AND_WAIT = "blockAndWait";
        public static final String LOAD_PREVIOUS = "loadPrevious";
        public static final String LOAD_REMOTE = "loadRemote";
    }

    public static class MinAppVersion implements Serializable {

        /* renamed from: android  reason: collision with root package name */
        public String f14711android;

        public String toString() {
            return "MinAppVersion " + a.toJSONString(this);
        }
    }

    public String toString() {
        return "SubAppConfig " + a.toJSONString(this);
    }

    @b(d = false)
    public boolean isResource() {
        return AppType.RESOURCE.equalsIgnoreCase(this.type);
    }
}
