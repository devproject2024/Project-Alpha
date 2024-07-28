package com.paytm.notification.models;

import android.graphics.Color;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class NotificationProjectConfig {
    private final String apiKey;
    private final String appId;
    private final String appKey;
    private Integer flashPrimaryColor;
    private Integer flashPrimaryColorFromResource;
    private Integer flashSecondaryColor;
    private Integer flashSecondaryColorFromResource;
    private Integer notificationAccentColor;
    private Integer notificationAccentColorFromResource;
    private final String senderId;
    private Boolean showFlashFromPush;

    private NotificationProjectConfig(Builder builder) {
        Integer notificationAccentColorInt$paytmnotification_paytmRelease;
        Integer flashSecondaryColorInt$paytmnotification_paytmRelease;
        Integer flashPrimaryColorInt$paytmnotification_paytmRelease;
        this.appId = builder.getAppId$paytmnotification_paytmRelease();
        this.senderId = builder.getSenderId$paytmnotification_paytmRelease();
        this.appKey = builder.getAppKey$paytmnotification_paytmRelease();
        this.apiKey = builder.getApiKey$paytmnotification_paytmRelease();
        this.flashPrimaryColor = Integer.valueOf(parseColor(builder.getFlashPrimaryColor$paytmnotification_paytmRelease(), "#ffffff"));
        if (builder.getFlashPrimaryColorInt$paytmnotification_paytmRelease() != null && ((flashPrimaryColorInt$paytmnotification_paytmRelease = builder.getFlashPrimaryColorInt$paytmnotification_paytmRelease()) == null || flashPrimaryColorInt$paytmnotification_paytmRelease.intValue() != 0)) {
            this.flashPrimaryColor = builder.getFlashPrimaryColorInt$paytmnotification_paytmRelease();
        }
        this.flashPrimaryColorFromResource = builder.getFlashPrimaryColorFromResource$paytmnotification_paytmRelease();
        this.flashSecondaryColor = Integer.valueOf(parseColor(builder.getFlashSecondaryColor$paytmnotification_paytmRelease(), "#504efa"));
        if (builder.getFlashSecondaryColorInt$paytmnotification_paytmRelease() != null && ((flashSecondaryColorInt$paytmnotification_paytmRelease = builder.getFlashSecondaryColorInt$paytmnotification_paytmRelease()) == null || flashSecondaryColorInt$paytmnotification_paytmRelease.intValue() != 0)) {
            this.flashSecondaryColor = builder.getFlashSecondaryColorInt$paytmnotification_paytmRelease();
        }
        this.flashSecondaryColorFromResource = builder.getFlashSecondaryColorFromResource$paytmnotification_paytmRelease();
        this.notificationAccentColor = Integer.valueOf(parseColor(builder.getNotificationAccentColor$paytmnotification_paytmRelease(), "#012b72"));
        if (builder.getNotificationAccentColorInt$paytmnotification_paytmRelease() != null && ((notificationAccentColorInt$paytmnotification_paytmRelease = builder.getNotificationAccentColorInt$paytmnotification_paytmRelease()) == null || notificationAccentColorInt$paytmnotification_paytmRelease.intValue() != 0)) {
            this.notificationAccentColor = builder.getNotificationAccentColorInt$paytmnotification_paytmRelease();
        }
        this.notificationAccentColorFromResource = builder.getNotificationAccentColorFromResource$paytmnotification_paytmRelease();
        this.showFlashFromPush = builder.getShowFlashFromPush$paytmnotification_paytmRelease();
    }

    public /* synthetic */ NotificationProjectConfig(Builder builder, g gVar) {
        this(builder);
    }

    public final String getAppId$paytmnotification_paytmRelease() {
        return this.appId;
    }

    public final String getSenderId$paytmnotification_paytmRelease() {
        return this.senderId;
    }

    public final String getAppKey$paytmnotification_paytmRelease() {
        return this.appKey;
    }

    public final String getApiKey$paytmnotification_paytmRelease() {
        return this.apiKey;
    }

    public final Integer getFlashPrimaryColor$paytmnotification_paytmRelease() {
        return this.flashPrimaryColor;
    }

    public final void setFlashPrimaryColor$paytmnotification_paytmRelease(Integer num) {
        this.flashPrimaryColor = num;
    }

    public final Integer getFlashPrimaryColorFromResource$paytmnotification_paytmRelease() {
        return this.flashPrimaryColorFromResource;
    }

    public final void setFlashPrimaryColorFromResource$paytmnotification_paytmRelease(Integer num) {
        this.flashPrimaryColorFromResource = num;
    }

    public final Integer getFlashSecondaryColor$paytmnotification_paytmRelease() {
        return this.flashSecondaryColor;
    }

    public final void setFlashSecondaryColor$paytmnotification_paytmRelease(Integer num) {
        this.flashSecondaryColor = num;
    }

    public final Integer getFlashSecondaryColorFromResource$paytmnotification_paytmRelease() {
        return this.flashSecondaryColorFromResource;
    }

    public final void setFlashSecondaryColorFromResource$paytmnotification_paytmRelease(Integer num) {
        this.flashSecondaryColorFromResource = num;
    }

    public final Boolean getShowFlashFromPush$paytmnotification_paytmRelease() {
        return this.showFlashFromPush;
    }

    public final void setShowFlashFromPush$paytmnotification_paytmRelease(Boolean bool) {
        this.showFlashFromPush = bool;
    }

    public final Integer getNotificationAccentColor$paytmnotification_paytmRelease() {
        return this.notificationAccentColor;
    }

    public final void setNotificationAccentColor$paytmnotification_paytmRelease(Integer num) {
        this.notificationAccentColor = num;
    }

    public final Integer getNotificationAccentColorFromResource$paytmnotification_paytmRelease() {
        return this.notificationAccentColorFromResource;
    }

    public final void setNotificationAccentColorFromResource$paytmnotification_paytmRelease(Integer num) {
        this.notificationAccentColorFromResource = num;
    }

    private final int parseColor(String str, String str2) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return Color.parseColor(str2);
        }
    }

    public static final class Builder {
        private String apiKey;
        private String appId;
        private String appKey;
        private String flashPrimaryColor;
        private Integer flashPrimaryColorFromResource;
        private Integer flashPrimaryColorInt;
        private String flashSecondaryColor;
        private Integer flashSecondaryColorFromResource;
        private Integer flashSecondaryColorInt;
        private String notificationAccentColor;
        private Integer notificationAccentColorFromResource;
        private Integer notificationAccentColorInt;
        private String senderId;
        private Boolean showFlashFromPush;

        public final String getAppId$paytmnotification_paytmRelease() {
            return this.appId;
        }

        public final void setAppId$paytmnotification_paytmRelease(String str) {
            this.appId = str;
        }

        public final String getSenderId$paytmnotification_paytmRelease() {
            return this.senderId;
        }

        public final void setSenderId$paytmnotification_paytmRelease(String str) {
            this.senderId = str;
        }

        public final String getAppKey$paytmnotification_paytmRelease() {
            return this.appKey;
        }

        public final void setAppKey$paytmnotification_paytmRelease(String str) {
            this.appKey = str;
        }

        public final String getApiKey$paytmnotification_paytmRelease() {
            return this.apiKey;
        }

        public final void setApiKey$paytmnotification_paytmRelease(String str) {
            this.apiKey = str;
        }

        public final String getFlashPrimaryColor$paytmnotification_paytmRelease() {
            return this.flashPrimaryColor;
        }

        public final void setFlashPrimaryColor$paytmnotification_paytmRelease(String str) {
            this.flashPrimaryColor = str;
        }

        public final String getFlashSecondaryColor$paytmnotification_paytmRelease() {
            return this.flashSecondaryColor;
        }

        public final void setFlashSecondaryColor$paytmnotification_paytmRelease(String str) {
            this.flashSecondaryColor = str;
        }

        public final Integer getFlashPrimaryColorInt$paytmnotification_paytmRelease() {
            return this.flashPrimaryColorInt;
        }

        public final void setFlashPrimaryColorInt$paytmnotification_paytmRelease(Integer num) {
            this.flashPrimaryColorInt = num;
        }

        public final Integer getFlashSecondaryColorInt$paytmnotification_paytmRelease() {
            return this.flashSecondaryColorInt;
        }

        public final void setFlashSecondaryColorInt$paytmnotification_paytmRelease(Integer num) {
            this.flashSecondaryColorInt = num;
        }

        public final Integer getFlashPrimaryColorFromResource$paytmnotification_paytmRelease() {
            return this.flashPrimaryColorFromResource;
        }

        public final void setFlashPrimaryColorFromResource$paytmnotification_paytmRelease(Integer num) {
            this.flashPrimaryColorFromResource = num;
        }

        public final Integer getFlashSecondaryColorFromResource$paytmnotification_paytmRelease() {
            return this.flashSecondaryColorFromResource;
        }

        public final void setFlashSecondaryColorFromResource$paytmnotification_paytmRelease(Integer num) {
            this.flashSecondaryColorFromResource = num;
        }

        public final String getNotificationAccentColor$paytmnotification_paytmRelease() {
            return this.notificationAccentColor;
        }

        public final void setNotificationAccentColor$paytmnotification_paytmRelease(String str) {
            this.notificationAccentColor = str;
        }

        public final Integer getNotificationAccentColorInt$paytmnotification_paytmRelease() {
            return this.notificationAccentColorInt;
        }

        public final void setNotificationAccentColorInt$paytmnotification_paytmRelease(Integer num) {
            this.notificationAccentColorInt = num;
        }

        public final Integer getNotificationAccentColorFromResource$paytmnotification_paytmRelease() {
            return this.notificationAccentColorFromResource;
        }

        public final void setNotificationAccentColorFromResource$paytmnotification_paytmRelease(Integer num) {
            this.notificationAccentColorFromResource = num;
        }

        public final Boolean getShowFlashFromPush$paytmnotification_paytmRelease() {
            return this.showFlashFromPush;
        }

        public final void setShowFlashFromPush$paytmnotification_paytmRelease(Boolean bool) {
            this.showFlashFromPush = bool;
        }

        public final NotificationProjectConfig build() {
            return new NotificationProjectConfig(this, (g) null);
        }

        public final Builder setAppId(String str) {
            k.c(str, "appId");
            this.appId = str;
            return this;
        }

        public final Builder setSenderId(String str) {
            k.c(str, "senderId");
            this.senderId = str;
            return this;
        }

        public final Builder setAppKey(String str) {
            k.c(str, "appKey");
            this.appKey = str;
            return this;
        }

        public final Builder setApiKey(String str) {
            k.c(str, "apiKey");
            this.apiKey = str;
            return this;
        }

        public final Builder setFlashPrimaryColor(String str) {
            k.c(str, "flashPrimaryColor");
            this.flashPrimaryColor = str;
            return this;
        }

        public final Builder setFlashSecondaryColor(String str) {
            k.c(str, "flashSecondaryColor");
            this.flashSecondaryColor = str;
            return this;
        }

        public final Builder setFlashPrimaryColor(int i2) {
            this.flashPrimaryColorInt = Integer.valueOf(i2);
            return this;
        }

        public final Builder setFlashSecondaryColor(int i2) {
            this.flashSecondaryColorInt = Integer.valueOf(i2);
            return this;
        }

        public final Builder setFlashPrimaryColorFromResource(int i2) {
            this.flashPrimaryColorFromResource = Integer.valueOf(i2);
            return this;
        }

        public final Builder setFlashSecondaryColorFromResource(int i2) {
            this.flashSecondaryColorFromResource = Integer.valueOf(i2);
            return this;
        }

        public final Builder setNotificationAccentColor(String str) {
            k.c(str, "notificationAccentColor");
            this.notificationAccentColor = str;
            return this;
        }

        public final Builder setNotificationAccentColor(int i2) {
            this.notificationAccentColorInt = Integer.valueOf(i2);
            return this;
        }

        public final Builder setNotificationAccentColorFromResource(int i2) {
            this.notificationAccentColorFromResource = Integer.valueOf(i2);
            return this;
        }

        public final Builder showFlashFromPush(boolean z) {
            this.showFlashFromPush = Boolean.valueOf(z);
            return this;
        }
    }
}
