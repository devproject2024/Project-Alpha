package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRPaymentOptionResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    private CJRPaymentOptionBody body;

    public CJRPaymentOptionResponse() {
        this((CJRPaymentOptionBody) null, 1, (g) null);
    }

    public static /* synthetic */ CJRPaymentOptionResponse copy$default(CJRPaymentOptionResponse cJRPaymentOptionResponse, CJRPaymentOptionBody cJRPaymentOptionBody, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRPaymentOptionBody = cJRPaymentOptionResponse.body;
        }
        return cJRPaymentOptionResponse.copy(cJRPaymentOptionBody);
    }

    public final CJRPaymentOptionBody component1() {
        return this.body;
    }

    public final CJRPaymentOptionResponse copy(CJRPaymentOptionBody cJRPaymentOptionBody) {
        return new CJRPaymentOptionResponse(cJRPaymentOptionBody);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRPaymentOptionResponse) && k.a((Object) this.body, (Object) ((CJRPaymentOptionResponse) obj).body);
        }
        return true;
    }

    public final int hashCode() {
        CJRPaymentOptionBody cJRPaymentOptionBody = this.body;
        if (cJRPaymentOptionBody != null) {
            return cJRPaymentOptionBody.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRPaymentOptionResponse(body=" + this.body + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRPaymentOptionResponse(CJRPaymentOptionBody cJRPaymentOptionBody, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRPaymentOptionBody);
    }

    public final CJRPaymentOptionBody getBody() {
        return this.body;
    }

    public final void setBody(CJRPaymentOptionBody cJRPaymentOptionBody) {
        this.body = cJRPaymentOptionBody;
    }

    public CJRPaymentOptionResponse(CJRPaymentOptionBody cJRPaymentOptionBody) {
        this.body = cJRPaymentOptionBody;
    }
}
