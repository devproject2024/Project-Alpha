package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MlvTemplateListResponse extends IJRDataModel {
    @b(a = "response")
    private Response response;

    public MlvTemplateListResponse() {
        this((Response) null, 1, (g) null);
    }

    public static /* synthetic */ MlvTemplateListResponse copy$default(MlvTemplateListResponse mlvTemplateListResponse, Response response2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            response2 = mlvTemplateListResponse.response;
        }
        return mlvTemplateListResponse.copy(response2);
    }

    public final Response component1() {
        return this.response;
    }

    public final MlvTemplateListResponse copy(Response response2) {
        return new MlvTemplateListResponse(response2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof MlvTemplateListResponse) && k.a((Object) this.response, (Object) ((MlvTemplateListResponse) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        Response response2 = this.response;
        if (response2 != null) {
            return response2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "MlvTemplateListResponse(response=" + this.response + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MlvTemplateListResponse(Response response2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : response2);
    }

    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(Response response2) {
        this.response = response2;
    }

    public MlvTemplateListResponse(Response response2) {
        this.response = response2;
    }
}
