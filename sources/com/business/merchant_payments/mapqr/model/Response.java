package com.business.merchant_payments.mapqr.model;

import com.business.common_module.f.a;
import kotlin.g.b.k;

public final class Response extends a {
    public MapResponse mapResponse;
    public String qrCodeId;
    public String stickerId;

    public static /* synthetic */ Response copy$default(Response response, String str, String str2, MapResponse mapResponse2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = response.stickerId;
        }
        if ((i2 & 2) != 0) {
            str2 = response.qrCodeId;
        }
        if ((i2 & 4) != 0) {
            mapResponse2 = response.mapResponse;
        }
        return response.copy(str, str2, mapResponse2);
    }

    public final String component1() {
        return this.stickerId;
    }

    public final String component2() {
        return this.qrCodeId;
    }

    public final MapResponse component3() {
        return this.mapResponse;
    }

    public final Response copy(String str, String str2, MapResponse mapResponse2) {
        return new Response(str, str2, mapResponse2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return k.a((Object) this.stickerId, (Object) response.stickerId) && k.a((Object) this.qrCodeId, (Object) response.qrCodeId) && k.a((Object) this.mapResponse, (Object) response.mapResponse);
    }

    public final int hashCode() {
        String str = this.stickerId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.qrCodeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        MapResponse mapResponse2 = this.mapResponse;
        if (mapResponse2 != null) {
            i2 = mapResponse2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Response(stickerId=" + this.stickerId + ", qrCodeId=" + this.qrCodeId + ", mapResponse=" + this.mapResponse + ")";
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final void setStickerId(String str) {
        this.stickerId = str;
    }

    public final String getQrCodeId() {
        return this.qrCodeId;
    }

    public final void setQrCodeId(String str) {
        this.qrCodeId = str;
    }

    public final MapResponse getMapResponse() {
        return this.mapResponse;
    }

    public final void setMapResponse(MapResponse mapResponse2) {
        this.mapResponse = mapResponse2;
    }

    public Response(String str, String str2, MapResponse mapResponse2) {
        this.stickerId = str;
        this.qrCodeId = str2;
        this.mapResponse = mapResponse2;
    }
}
