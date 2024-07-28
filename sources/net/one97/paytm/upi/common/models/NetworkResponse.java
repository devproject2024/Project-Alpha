package net.one97.paytm.upi.common.models;

import java.util.List;
import kotlin.g.b.k;

public final class NetworkResponse {
    private final Preference preference;
    private final List<Preference> preferences;

    public static /* synthetic */ NetworkResponse copy$default(NetworkResponse networkResponse, List<Preference> list, Preference preference2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = networkResponse.preferences;
        }
        if ((i2 & 2) != 0) {
            preference2 = networkResponse.preference;
        }
        return networkResponse.copy(list, preference2);
    }

    public final List<Preference> component1() {
        return this.preferences;
    }

    public final Preference component2() {
        return this.preference;
    }

    public final NetworkResponse copy(List<Preference> list, Preference preference2) {
        k.c(list, "preferences");
        return new NetworkResponse(list, preference2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        return k.a((Object) this.preferences, (Object) networkResponse.preferences) && k.a((Object) this.preference, (Object) networkResponse.preference);
    }

    public final int hashCode() {
        List<Preference> list = this.preferences;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Preference preference2 = this.preference;
        if (preference2 != null) {
            i2 = preference2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NetworkResponse(preferences=" + this.preferences + ", preference=" + this.preference + ")";
    }

    public NetworkResponse(List<Preference> list, Preference preference2) {
        k.c(list, "preferences");
        this.preferences = list;
        this.preference = preference2;
    }

    public final List<Preference> getPreferences() {
        return this.preferences;
    }

    public final Preference getPreference() {
        return this.preference;
    }
}
