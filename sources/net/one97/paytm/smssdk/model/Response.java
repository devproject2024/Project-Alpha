package net.one97.paytm.smssdk.model;

import kotlin.g.b.k;

public final class Response {
    private ConsentUpdatePreference preference;

    public static /* synthetic */ Response copy$default(Response response, ConsentUpdatePreference consentUpdatePreference, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            consentUpdatePreference = response.preference;
        }
        return response.copy(consentUpdatePreference);
    }

    public final ConsentUpdatePreference component1() {
        return this.preference;
    }

    public final Response copy(ConsentUpdatePreference consentUpdatePreference) {
        k.c(consentUpdatePreference, "preference");
        return new Response(consentUpdatePreference);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Response) && k.a((Object) this.preference, (Object) ((Response) obj).preference);
        }
        return true;
    }

    public final int hashCode() {
        ConsentUpdatePreference consentUpdatePreference = this.preference;
        if (consentUpdatePreference != null) {
            return consentUpdatePreference.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Response(preference=" + this.preference + ")";
    }

    public Response(ConsentUpdatePreference consentUpdatePreference) {
        k.c(consentUpdatePreference, "preference");
        this.preference = consentUpdatePreference;
    }

    public final ConsentUpdatePreference getPreference() {
        return this.preference;
    }

    public final void setPreference(ConsentUpdatePreference consentUpdatePreference) {
        k.c(consentUpdatePreference, "<set-?>");
        this.preference = consentUpdatePreference;
    }
}
