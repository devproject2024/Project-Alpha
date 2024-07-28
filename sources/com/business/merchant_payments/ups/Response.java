package com.business.merchant_payments.ups;

import java.util.List;
import kotlin.g.b.k;

public final class Response {
    public List<Preferences> preferences;

    public static /* synthetic */ Response copy$default(Response response, List<Preferences> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = response.preferences;
        }
        return response.copy(list);
    }

    public final List<Preferences> component1() {
        return this.preferences;
    }

    public final Response copy(List<Preferences> list) {
        return new Response(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Response) && k.a((Object) this.preferences, (Object) ((Response) obj).preferences);
        }
        return true;
    }

    public final int hashCode() {
        List<Preferences> list = this.preferences;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Response(preferences=" + this.preferences + ")";
    }

    public Response(List<Preferences> list) {
        this.preferences = list;
    }

    public final List<Preferences> getPreferences() {
        return this.preferences;
    }

    public final void setPreferences(List<Preferences> list) {
        this.preferences = list;
    }
}
