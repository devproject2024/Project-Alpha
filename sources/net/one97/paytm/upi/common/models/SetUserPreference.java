package net.one97.paytm.upi.common.models;

import kotlin.g.b.k;

public final class SetUserPreference {
    private final Request request;

    public static /* synthetic */ SetUserPreference copy$default(SetUserPreference setUserPreference, Request request2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            request2 = setUserPreference.request;
        }
        return setUserPreference.copy(request2);
    }

    public final Request component1() {
        return this.request;
    }

    public final SetUserPreference copy(Request request2) {
        k.c(request2, "request");
        return new SetUserPreference(request2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SetUserPreference) && k.a((Object) this.request, (Object) ((SetUserPreference) obj).request);
        }
        return true;
    }

    public final int hashCode() {
        Request request2 = this.request;
        if (request2 != null) {
            return request2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "SetUserPreference(request=" + this.request + ")";
    }

    public SetUserPreference(Request request2) {
        k.c(request2, "request");
        this.request = request2;
    }

    public final Request getRequest() {
        return this.request;
    }
}
