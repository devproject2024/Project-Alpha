package com.paytm.notification.models;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class NotificationUserConfig {
    public static final Companion Companion = new Companion((g) null);
    public static final String LOGIN_DEFAULT = "loginApp";
    public static final String LOGIN_SDK = "loginSdk";
    private String appLanguage;
    private String appVersion;
    private String buildFlavour;
    private String clientName;
    private String configEndPoints;
    private String customerId;
    private String deviceId;
    private Boolean enableInboxCountSchedule;
    private String eventBatchEndPoint;
    private Integer eventBatchFrequency;
    private Integer eventBatchSize;
    private String flashEndPoint;
    private Long inboxCountScheduleInterval;
    private String inboxEndPoints;
    private Boolean isFlashEnabled;
    private Boolean isInboxEnabled;
    private Boolean isPushEnabled;
    private String loginState;
    private Integer msgIcon;
    private String secret;
    private String serverEndPoints;
    private Boolean showDebugLogs;
    private Boolean staging;

    public static /* synthetic */ void staging$annotations() {
    }

    private NotificationUserConfig(Builder builder) {
        this.enableInboxCountSchedule = Boolean.FALSE;
        this.deviceId = builder.getDeviceId$paytmnotification_paytmRelease();
        this.customerId = builder.getCustomerId$paytmnotification_paytmRelease();
        this.serverEndPoints = builder.getServerEndPoints$paytmnotification_paytmRelease();
        this.appVersion = builder.getAppVersion$paytmnotification_paytmRelease();
        this.appLanguage = builder.getAppLanguage$paytmnotification_paytmRelease();
        this.buildFlavour = builder.getBuildFlavour$paytmnotification_paytmRelease();
        this.clientName = builder.getClientName$paytmnotification_paytmRelease();
        this.secret = builder.getSecret$paytmnotification_paytmRelease();
        this.inboxEndPoints = builder.getInboxEndPoints$paytmnotification_paytmRelease();
        this.flashEndPoint = builder.getFlashEndPoint$paytmnotification_paytmRelease();
        this.eventBatchEndPoint = builder.getEventBatchEndPoint$paytmnotification_paytmRelease();
        if (builder.isInboxDisabled$paytmnotification_paytmRelease() != null) {
            Boolean isInboxDisabled$paytmnotification_paytmRelease = builder.isInboxDisabled$paytmnotification_paytmRelease();
            if (isInboxDisabled$paytmnotification_paytmRelease == null) {
                k.a();
            }
            this.isInboxEnabled = Boolean.valueOf(!isInboxDisabled$paytmnotification_paytmRelease.booleanValue());
        }
        if (builder.isFlashDisabled$paytmnotification_paytmRelease() != null) {
            Boolean isFlashDisabled$paytmnotification_paytmRelease = builder.isFlashDisabled$paytmnotification_paytmRelease();
            if (isFlashDisabled$paytmnotification_paytmRelease == null) {
                k.a();
            }
            this.isFlashEnabled = Boolean.valueOf(!isFlashDisabled$paytmnotification_paytmRelease.booleanValue());
        }
        if (builder.isPushDisabled$paytmnotification_paytmRelease() != null) {
            Boolean isPushDisabled$paytmnotification_paytmRelease = builder.isPushDisabled$paytmnotification_paytmRelease();
            if (isPushDisabled$paytmnotification_paytmRelease == null) {
                k.a();
            }
            this.isPushEnabled = Boolean.valueOf(!isPushDisabled$paytmnotification_paytmRelease.booleanValue());
        }
        this.eventBatchSize = builder.getEventBatchSize$paytmnotification_paytmRelease();
        this.eventBatchFrequency = builder.getEventBatchFrequency$paytmnotification_paytmRelease();
        this.msgIcon = builder.getMsgIcon$paytmnotification_paytmRelease();
        this.staging = Boolean.valueOf(builder.getStaging$paytmnotification_paytmRelease());
        this.loginState = builder.getLoginState$paytmnotification_paytmRelease();
        this.configEndPoints = builder.getConfigEndPoints$paytmnotification_paytmRelease();
        this.showDebugLogs = Boolean.valueOf(builder.getShowDebugLogs$paytmnotification_paytmRelease());
        this.enableInboxCountSchedule = builder.getEnableInboxCountSchedule$paytmnotification_paytmRelease();
        this.inboxCountScheduleInterval = builder.getInboxCountScheduleInterval$paytmnotification_paytmRelease();
    }

    public /* synthetic */ NotificationUserConfig(Builder builder, g gVar) {
        this(builder);
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

    public final Boolean getStaging$paytmnotification_paytmRelease() {
        return this.staging;
    }

    public final void setStaging$paytmnotification_paytmRelease(Boolean bool) {
        this.staging = bool;
    }

    public final String getLoginState$paytmnotification_paytmRelease() {
        return this.loginState;
    }

    public final void setLoginState$paytmnotification_paytmRelease(String str) {
        this.loginState = str;
    }

    public final String getConfigEndPoints$paytmnotification_paytmRelease() {
        return this.configEndPoints;
    }

    public final void setConfigEndPoints$paytmnotification_paytmRelease(String str) {
        this.configEndPoints = str;
    }

    public final String getCustomerId$paytmnotification_paytmRelease() {
        return this.customerId;
    }

    public final void setCustomerId$paytmnotification_paytmRelease(String str) {
        this.customerId = str;
    }

    public final String getServerEndPoints$paytmnotification_paytmRelease() {
        return this.serverEndPoints;
    }

    public final void setServerEndPoints$paytmnotification_paytmRelease(String str) {
        this.serverEndPoints = str;
    }

    public final String getInboxEndPoints$paytmnotification_paytmRelease() {
        return this.inboxEndPoints;
    }

    public final void setInboxEndPoints$paytmnotification_paytmRelease(String str) {
        this.inboxEndPoints = str;
    }

    public final String getFlashEndPoint$paytmnotification_paytmRelease() {
        return this.flashEndPoint;
    }

    public final void setFlashEndPoint$paytmnotification_paytmRelease(String str) {
        this.flashEndPoint = str;
    }

    public final String getEventBatchEndPoint$paytmnotification_paytmRelease() {
        return this.eventBatchEndPoint;
    }

    public final void setEventBatchEndPoint$paytmnotification_paytmRelease(String str) {
        this.eventBatchEndPoint = str;
    }

    public final Integer getEventBatchFrequency$paytmnotification_paytmRelease() {
        return this.eventBatchFrequency;
    }

    public final void setEventBatchFrequency$paytmnotification_paytmRelease(Integer num) {
        this.eventBatchFrequency = num;
    }

    public final Integer getEventBatchSize$paytmnotification_paytmRelease() {
        return this.eventBatchSize;
    }

    public final void setEventBatchSize$paytmnotification_paytmRelease(Integer num) {
        this.eventBatchSize = num;
    }

    public final Boolean isInboxEnabled$paytmnotification_paytmRelease() {
        return this.isInboxEnabled;
    }

    public final void setInboxEnabled$paytmnotification_paytmRelease(Boolean bool) {
        this.isInboxEnabled = bool;
    }

    public final Boolean isFlashEnabled$paytmnotification_paytmRelease() {
        return this.isFlashEnabled;
    }

    public final void setFlashEnabled$paytmnotification_paytmRelease(Boolean bool) {
        this.isFlashEnabled = bool;
    }

    public final Boolean isPushEnabled$paytmnotification_paytmRelease() {
        return this.isPushEnabled;
    }

    public final void setPushEnabled$paytmnotification_paytmRelease(Boolean bool) {
        this.isPushEnabled = bool;
    }

    public final String getDeviceId$paytmnotification_paytmRelease() {
        return this.deviceId;
    }

    public final void setDeviceId$paytmnotification_paytmRelease(String str) {
        this.deviceId = str;
    }

    public final String getAppLanguage$paytmnotification_paytmRelease() {
        return this.appLanguage;
    }

    public final void setAppLanguage$paytmnotification_paytmRelease(String str) {
        this.appLanguage = str;
    }

    public final String getBuildFlavour$paytmnotification_paytmRelease() {
        return this.buildFlavour;
    }

    public final void setBuildFlavour$paytmnotification_paytmRelease(String str) {
        this.buildFlavour = str;
    }

    public final Boolean getShowDebugLogs$paytmnotification_paytmRelease() {
        return this.showDebugLogs;
    }

    public final void setShowDebugLogs$paytmnotification_paytmRelease(Boolean bool) {
        this.showDebugLogs = bool;
    }

    public final Boolean getEnableInboxCountSchedule$paytmnotification_paytmRelease() {
        return this.enableInboxCountSchedule;
    }

    public final void setEnableInboxCountSchedule$paytmnotification_paytmRelease(Boolean bool) {
        this.enableInboxCountSchedule = bool;
    }

    public final Long getInboxCountScheduleInterval$paytmnotification_paytmRelease() {
        return this.inboxCountScheduleInterval;
    }

    public final void setInboxCountScheduleInterval$paytmnotification_paytmRelease(Long l) {
        this.inboxCountScheduleInterval = l;
    }

    public final boolean handleLogin() {
        return k.a((Object) this.loginState, (Object) "loginSdk");
    }

    public static final class Builder {
        private String appLanguage;
        private String appVersion;
        private String buildFlavour;
        private String clientName;
        private String configEndPoints;
        private String customerId;
        private String deviceId;
        private Boolean enableInboxCountSchedule = Boolean.FALSE;
        private String eventBatchEndPoint;
        private Integer eventBatchFrequency;
        private Integer eventBatchSize;
        private String flashEndPoint;
        private Long inboxCountScheduleInterval;
        private String inboxEndPoints;
        private Boolean isFlashDisabled;
        private Boolean isInboxDisabled;
        private Boolean isPushDisabled;
        private String loginState;
        private Integer msgIcon;
        private String secret;
        private String serverEndPoints;
        private boolean showDebugLogs;
        private boolean staging;

        public static /* synthetic */ void staging$annotations() {
        }

        public final String getDeviceId$paytmnotification_paytmRelease() {
            return this.deviceId;
        }

        public final void setDeviceId$paytmnotification_paytmRelease(String str) {
            this.deviceId = str;
        }

        public final String getCustomerId$paytmnotification_paytmRelease() {
            return this.customerId;
        }

        public final void setCustomerId$paytmnotification_paytmRelease(String str) {
            this.customerId = str;
        }

        public final String getServerEndPoints$paytmnotification_paytmRelease() {
            return this.serverEndPoints;
        }

        public final void setServerEndPoints$paytmnotification_paytmRelease(String str) {
            this.serverEndPoints = str;
        }

        public final String getAppVersion$paytmnotification_paytmRelease() {
            return this.appVersion;
        }

        public final void setAppVersion$paytmnotification_paytmRelease(String str) {
            this.appVersion = str;
        }

        public final String getAppLanguage$paytmnotification_paytmRelease() {
            return this.appLanguage;
        }

        public final void setAppLanguage$paytmnotification_paytmRelease(String str) {
            this.appLanguage = str;
        }

        public final String getBuildFlavour$paytmnotification_paytmRelease() {
            return this.buildFlavour;
        }

        public final void setBuildFlavour$paytmnotification_paytmRelease(String str) {
            this.buildFlavour = str;
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

        public final String getInboxEndPoints$paytmnotification_paytmRelease() {
            return this.inboxEndPoints;
        }

        public final void setInboxEndPoints$paytmnotification_paytmRelease(String str) {
            this.inboxEndPoints = str;
        }

        public final String getFlashEndPoint$paytmnotification_paytmRelease() {
            return this.flashEndPoint;
        }

        public final void setFlashEndPoint$paytmnotification_paytmRelease(String str) {
            this.flashEndPoint = str;
        }

        public final String getEventBatchEndPoint$paytmnotification_paytmRelease() {
            return this.eventBatchEndPoint;
        }

        public final void setEventBatchEndPoint$paytmnotification_paytmRelease(String str) {
            this.eventBatchEndPoint = str;
        }

        public final Boolean isInboxDisabled$paytmnotification_paytmRelease() {
            return this.isInboxDisabled;
        }

        public final void setInboxDisabled$paytmnotification_paytmRelease(Boolean bool) {
            this.isInboxDisabled = bool;
        }

        public final Boolean isFlashDisabled$paytmnotification_paytmRelease() {
            return this.isFlashDisabled;
        }

        public final void setFlashDisabled$paytmnotification_paytmRelease(Boolean bool) {
            this.isFlashDisabled = bool;
        }

        public final Boolean isPushDisabled$paytmnotification_paytmRelease() {
            return this.isPushDisabled;
        }

        public final void setPushDisabled$paytmnotification_paytmRelease(Boolean bool) {
            this.isPushDisabled = bool;
        }

        public final Integer getEventBatchSize$paytmnotification_paytmRelease() {
            return this.eventBatchSize;
        }

        public final void setEventBatchSize$paytmnotification_paytmRelease(Integer num) {
            this.eventBatchSize = num;
        }

        public final Integer getEventBatchFrequency$paytmnotification_paytmRelease() {
            return this.eventBatchFrequency;
        }

        public final void setEventBatchFrequency$paytmnotification_paytmRelease(Integer num) {
            this.eventBatchFrequency = num;
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

        public final String getLoginState$paytmnotification_paytmRelease() {
            return this.loginState;
        }

        public final void setLoginState$paytmnotification_paytmRelease(String str) {
            this.loginState = str;
        }

        public final String getConfigEndPoints$paytmnotification_paytmRelease() {
            return this.configEndPoints;
        }

        public final void setConfigEndPoints$paytmnotification_paytmRelease(String str) {
            this.configEndPoints = str;
        }

        public final boolean getShowDebugLogs$paytmnotification_paytmRelease() {
            return this.showDebugLogs;
        }

        public final void setShowDebugLogs$paytmnotification_paytmRelease(boolean z) {
            this.showDebugLogs = z;
        }

        public final Boolean getEnableInboxCountSchedule$paytmnotification_paytmRelease() {
            return this.enableInboxCountSchedule;
        }

        public final void setEnableInboxCountSchedule$paytmnotification_paytmRelease(Boolean bool) {
            this.enableInboxCountSchedule = bool;
        }

        public final Long getInboxCountScheduleInterval$paytmnotification_paytmRelease() {
            return this.inboxCountScheduleInterval;
        }

        public final void setInboxCountScheduleInterval$paytmnotification_paytmRelease(Long l) {
            this.inboxCountScheduleInterval = l;
        }

        public final Builder setCustomerId(String str) {
            this.customerId = str;
            return this;
        }

        public final Builder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public final Builder setServerEndPoints(String str) {
            this.serverEndPoints = str;
            return this;
        }

        public final Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public final Builder setAppLanguage(String str) {
            this.appLanguage = str;
            return this;
        }

        public final Builder setBuildFlavour(String str) {
            this.buildFlavour = str;
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

        public final Builder setInboxEndPoints(String str) {
            this.inboxEndPoints = str;
            return this;
        }

        public final Builder setFlashEndPoints(String str) {
            this.flashEndPoint = str;
            return this;
        }

        public final Builder setEventBatchEndPoints(String str) {
            this.eventBatchEndPoint = str;
            return this;
        }

        public final Builder setInboxEnabled(boolean z) {
            this.isInboxDisabled = Boolean.valueOf(!z);
            return this;
        }

        public final Builder setFlashEnabled(boolean z) {
            this.isFlashDisabled = Boolean.valueOf(!z);
            return this;
        }

        public final Builder setPushEnabled(boolean z) {
            this.isPushDisabled = Boolean.valueOf(!z);
            return this;
        }

        public final Builder setEventBatchSize(int i2) {
            this.eventBatchSize = Integer.valueOf(i2);
            return this;
        }

        public final Builder setEventBatchFrequency(int i2) {
            this.eventBatchFrequency = Integer.valueOf(i2);
            return this;
        }

        public final Builder setMsgIcon(int i2) {
            this.msgIcon = Integer.valueOf(i2);
            return this;
        }

        public final Builder setStaging(boolean z) {
            this.staging = z;
            return this;
        }

        public final Builder setShowDebugLogs(boolean z) {
            this.showDebugLogs = z;
            return this;
        }

        public final Builder setLoginState(String str) {
            this.loginState = str;
            return this;
        }

        public final Builder setConfigEndPoints(String str) {
            this.configEndPoints = str;
            return this;
        }

        public final Builder setEnableInboxCountSchedule(Boolean bool) {
            this.enableInboxCountSchedule = bool;
            return this;
        }

        public final Builder setInboxCountScheduleInterval(Long l) {
            this.inboxCountScheduleInterval = l;
            return this;
        }

        public final NotificationUserConfig build() {
            return new NotificationUserConfig(this, (g) null);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
