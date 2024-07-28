package com.paytm.notification.models;

import android.text.TextUtils;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;

public final class PushConfig {
    public static final String CLIENT_LOGIN = "loginSdk";
    public static final SDKMode SDKMode = new SDKMode((g) null);
    public static final String SERVER_LOGIN = "loginApp";
    private final String appVersion;
    private final String clientName;
    private final String configEndPoints;
    private final String loginMode;
    private final Integer msgIcon;
    private final String secret;
    private final boolean staging;

    public static /* synthetic */ void staging$annotations() {
    }

    private PushConfig(Builder builder) {
        this.appVersion = builder.getAppVersion$paytmnotification_paytmRelease();
        this.clientName = builder.getClientName$paytmnotification_paytmRelease();
        this.secret = builder.getSecret$paytmnotification_paytmRelease();
        this.msgIcon = builder.getMsgIcon$paytmnotification_paytmRelease();
        this.staging = builder.getStaging$paytmnotification_paytmRelease();
        this.loginMode = builder.getLoginMode$paytmnotification_paytmRelease();
        this.configEndPoints = builder.getConfigEndPoints$paytmnotification_paytmRelease();
    }

    public /* synthetic */ PushConfig(Builder builder, g gVar) {
        this(builder);
    }

    public final String getAppVersion$paytmnotification_paytmRelease() {
        return this.appVersion;
    }

    public final String getClientName$paytmnotification_paytmRelease() {
        return this.clientName;
    }

    public final String getSecret$paytmnotification_paytmRelease() {
        return this.secret;
    }

    public final Integer getMsgIcon$paytmnotification_paytmRelease() {
        return this.msgIcon;
    }

    public final boolean getStaging$paytmnotification_paytmRelease() {
        return this.staging;
    }

    public final String getLoginMode$paytmnotification_paytmRelease() {
        return this.loginMode;
    }

    public final String getConfigEndPoints$paytmnotification_paytmRelease() {
        return this.configEndPoints;
    }

    public static final class Builder {
        private String appVersion;
        private String clientName;
        private String configEndPoints;
        private String loginMode = "loginApp";
        private Integer msgIcon;
        private String secret;
        private boolean staging;

        public static /* synthetic */ void staging$annotations() {
        }

        public final String getAppVersion$paytmnotification_paytmRelease() {
            return this.appVersion;
        }

        public final void setAppVersion$paytmnotification_paytmRelease(String str) {
            this.appVersion = str;
        }

        public final String getClientName$paytmnotification_paytmRelease() {
            return this.clientName;
        }

        public final void setClientName$paytmnotification_paytmRelease(String str) {
            this.clientName = str;
        }

        public final String getSecret$paytmnotification_paytmRelease() {
            return this.secret;
        }

        public final void setSecret$paytmnotification_paytmRelease(String str) {
            this.secret = str;
        }

        public final Integer getMsgIcon$paytmnotification_paytmRelease() {
            return this.msgIcon;
        }

        public final void setMsgIcon$paytmnotification_paytmRelease(Integer num) {
            this.msgIcon = num;
        }

        public final boolean getStaging$paytmnotification_paytmRelease() {
            return this.staging;
        }

        public final void setStaging$paytmnotification_paytmRelease(boolean z) {
            this.staging = z;
        }

        public final String getLoginMode$paytmnotification_paytmRelease() {
            return this.loginMode;
        }

        public final void setLoginMode$paytmnotification_paytmRelease(String str) {
            k.c(str, "<set-?>");
            this.loginMode = str;
        }

        public final String getConfigEndPoints$paytmnotification_paytmRelease() {
            return this.configEndPoints;
        }

        public final void setConfigEndPoints$paytmnotification_paytmRelease(String str) {
            this.configEndPoints = str;
        }

        public final Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public final Builder setClientName(String str) {
            this.clientName = str;
            return this;
        }

        public final Builder setSecret(String str) {
            this.secret = str;
            return this;
        }

        public final Builder setMsgIcon(Integer num) {
            this.msgIcon = num;
            return this;
        }

        public final Builder setStaging(boolean z) {
            this.staging = z;
            return this;
        }

        public final Builder setSDKMode(String str) {
            if (str == null) {
                str = "loginApp";
            }
            this.loginMode = str;
            return this;
        }

        public final Builder setConfigEndPoints(String str) {
            this.configEndPoints = getStringWithoutSlashInTheEnd(str);
            return this;
        }

        private final String getStringWithoutSlashInTheEnd(String str) {
            while (!TextUtils.isEmpty(str) && str != null && p.c(str, "/", false)) {
                str = p.g(str);
            }
            return str;
        }

        public final PushConfig build() {
            return new PushConfig(this, (g) null);
        }
    }

    public static final class SDKMode {
        private SDKMode() {
        }

        public /* synthetic */ SDKMode(g gVar) {
            this();
        }
    }
}
