package com.paytm.notification.models.request;

import com.google.gson.a.c;

public final class TokenRegisterRequest {
    @c(a = "deviceDetails")
    private DeviceDetails deviceDetails;
    @c(a = "geoLocation")
    private GeoLocation geoLocation;
    @c(a = "messaging")
    private Messaging messaging;
    @c(a = "user")
    private User user;

    public final GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    public final void setGeoLocation(GeoLocation geoLocation2) {
        this.geoLocation = geoLocation2;
    }

    public final DeviceDetails getDeviceDetails() {
        return this.deviceDetails;
    }

    public final void setDeviceDetails(DeviceDetails deviceDetails2) {
        this.deviceDetails = deviceDetails2;
    }

    public final Messaging getMessaging() {
        return this.messaging;
    }

    public final void setMessaging(Messaging messaging2) {
        this.messaging = messaging2;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        this.user = user2;
    }
}
