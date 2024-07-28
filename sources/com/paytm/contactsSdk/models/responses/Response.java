package com.paytm.contactsSdk.models.responses;

import kotlin.g.b.k;

public final class Response {
    private final HealthContactDetail contactDetail;

    public static /* synthetic */ Response copy$default(Response response, HealthContactDetail healthContactDetail, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            healthContactDetail = response.contactDetail;
        }
        return response.copy(healthContactDetail);
    }

    public final HealthContactDetail component1() {
        return this.contactDetail;
    }

    public final Response copy(HealthContactDetail healthContactDetail) {
        k.c(healthContactDetail, "contactDetail");
        return new Response(healthContactDetail);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Response) && k.a((Object) this.contactDetail, (Object) ((Response) obj).contactDetail);
        }
        return true;
    }

    public final int hashCode() {
        HealthContactDetail healthContactDetail = this.contactDetail;
        if (healthContactDetail != null) {
            return healthContactDetail.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Response(contactDetail=" + this.contactDetail + ")";
    }

    public Response(HealthContactDetail healthContactDetail) {
        k.c(healthContactDetail, "contactDetail");
        this.contactDetail = healthContactDetail;
    }

    public final HealthContactDetail getContactDetail() {
        return this.contactDetail;
    }
}
