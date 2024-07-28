package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CreateSignPayload extends IJRPaytmDataModel {
    @b(a = "custId")
    private final String custId;
    @b(a = "imageId")
    private final String imageId;
    @b(a = "url")
    private final String url;

    public static /* synthetic */ CreateSignPayload copy$default(CreateSignPayload createSignPayload, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createSignPayload.custId;
        }
        if ((i2 & 2) != 0) {
            str2 = createSignPayload.imageId;
        }
        if ((i2 & 4) != 0) {
            str3 = createSignPayload.url;
        }
        return createSignPayload.copy(str, str2, str3);
    }

    public final String component1() {
        return this.custId;
    }

    public final String component2() {
        return this.imageId;
    }

    public final String component3() {
        return this.url;
    }

    public final CreateSignPayload copy(String str, String str2, String str3) {
        k.c(str, "custId");
        k.c(str2, "imageId");
        k.c(str3, "url");
        return new CreateSignPayload(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateSignPayload)) {
            return false;
        }
        CreateSignPayload createSignPayload = (CreateSignPayload) obj;
        return k.a((Object) this.custId, (Object) createSignPayload.custId) && k.a((Object) this.imageId, (Object) createSignPayload.imageId) && k.a((Object) this.url, (Object) createSignPayload.url);
    }

    public final int hashCode() {
        String str = this.custId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CreateSignPayload(custId=" + this.custId + ", imageId=" + this.imageId + ", url=" + this.url + ")";
    }

    public final String getCustId() {
        return this.custId;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public CreateSignPayload(String str, String str2, String str3) {
        k.c(str, "custId");
        k.c(str2, "imageId");
        k.c(str3, "url");
        this.custId = str;
        this.imageId = str2;
        this.url = str3;
    }

    public final String getUrl() {
        return this.url;
    }
}
