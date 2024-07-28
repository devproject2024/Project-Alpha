package com.paytm.analytics.models;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class LocationStateEvent {
    public static final Companion Companion = new Companion((g) null);
    public static final String EVENT_TYPE_LOCATION_STATE_EVENT = "location_state_event";
    private Boolean isLocationPermission;
    private Boolean isOpenScreen;
    private Boolean isProviderEnabled;

    public LocationStateEvent() {
        this((Boolean) null, (Boolean) null, (Boolean) null, 7, (g) null);
    }

    public static /* synthetic */ LocationStateEvent copy$default(LocationStateEvent locationStateEvent, Boolean bool, Boolean bool2, Boolean bool3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = locationStateEvent.isProviderEnabled;
        }
        if ((i2 & 2) != 0) {
            bool2 = locationStateEvent.isLocationPermission;
        }
        if ((i2 & 4) != 0) {
            bool3 = locationStateEvent.isOpenScreen;
        }
        return locationStateEvent.copy(bool, bool2, bool3);
    }

    public final Boolean component1() {
        return this.isProviderEnabled;
    }

    public final Boolean component2() {
        return this.isLocationPermission;
    }

    public final Boolean component3() {
        return this.isOpenScreen;
    }

    public final LocationStateEvent copy(Boolean bool, Boolean bool2, Boolean bool3) {
        return new LocationStateEvent(bool, bool2, bool3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationStateEvent)) {
            return false;
        }
        LocationStateEvent locationStateEvent = (LocationStateEvent) obj;
        return k.a((Object) this.isProviderEnabled, (Object) locationStateEvent.isProviderEnabled) && k.a((Object) this.isLocationPermission, (Object) locationStateEvent.isLocationPermission) && k.a((Object) this.isOpenScreen, (Object) locationStateEvent.isOpenScreen);
    }

    public final int hashCode() {
        Boolean bool = this.isProviderEnabled;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isLocationPermission;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isOpenScreen;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "LocationStateEvent(isProviderEnabled=" + this.isProviderEnabled + ", isLocationPermission=" + this.isLocationPermission + ", isOpenScreen=" + this.isOpenScreen + ")";
    }

    public LocationStateEvent(Boolean bool, Boolean bool2, Boolean bool3) {
        this.isProviderEnabled = bool;
        this.isLocationPermission = bool2;
        this.isOpenScreen = bool3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationStateEvent(Boolean bool, Boolean bool2, Boolean bool3, int i2, g gVar) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool, (i2 & 2) != 0 ? Boolean.FALSE : bool2, (i2 & 4) != 0 ? Boolean.FALSE : bool3);
    }

    public final Boolean isProviderEnabled() {
        return this.isProviderEnabled;
    }

    public final void setProviderEnabled(Boolean bool) {
        this.isProviderEnabled = bool;
    }

    public final Boolean isLocationPermission() {
        return this.isLocationPermission;
    }

    public final void setLocationPermission(Boolean bool) {
        this.isLocationPermission = bool;
    }

    public final Boolean isOpenScreen() {
        return this.isOpenScreen;
    }

    public final void setOpenScreen(Boolean bool) {
        this.isOpenScreen = bool;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
