package net.one97.paytm.nativesdk.orflow.promo.model;

import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Body implements Serializable {
    private CardDetails cardDetails;
    private String cardHash;
    private String cardNumber;
    private ResultInfo resultInfo;

    public Body() {
        this((ResultInfo) null, (String) null, (String) null, (CardDetails) null, 15, (g) null);
    }

    public static /* synthetic */ Body copy$default(Body body, ResultInfo resultInfo2, String str, String str2, CardDetails cardDetails2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resultInfo2 = body.resultInfo;
        }
        if ((i2 & 2) != 0) {
            str = body.cardHash;
        }
        if ((i2 & 4) != 0) {
            str2 = body.cardNumber;
        }
        if ((i2 & 8) != 0) {
            cardDetails2 = body.cardDetails;
        }
        return body.copy(resultInfo2, str, str2, cardDetails2);
    }

    public final ResultInfo component1() {
        return this.resultInfo;
    }

    public final String component2() {
        return this.cardHash;
    }

    public final String component3() {
        return this.cardNumber;
    }

    public final CardDetails component4() {
        return this.cardDetails;
    }

    public final Body copy(ResultInfo resultInfo2, String str, String str2, CardDetails cardDetails2) {
        return new Body(resultInfo2, str, str2, cardDetails2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return k.a((Object) this.resultInfo, (Object) body.resultInfo) && k.a((Object) this.cardHash, (Object) body.cardHash) && k.a((Object) this.cardNumber, (Object) body.cardNumber) && k.a((Object) this.cardDetails, (Object) body.cardDetails);
    }

    public final int hashCode() {
        ResultInfo resultInfo2 = this.resultInfo;
        int i2 = 0;
        int hashCode = (resultInfo2 != null ? resultInfo2.hashCode() : 0) * 31;
        String str = this.cardHash;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.cardNumber;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CardDetails cardDetails2 = this.cardDetails;
        if (cardDetails2 != null) {
            i2 = cardDetails2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Body(resultInfo=" + this.resultInfo + ", cardHash=" + this.cardHash + ", cardNumber=" + this.cardNumber + ", cardDetails=" + this.cardDetails + ")";
    }

    public Body(ResultInfo resultInfo2, String str, String str2, CardDetails cardDetails2) {
        this.resultInfo = resultInfo2;
        this.cardHash = str;
        this.cardNumber = str2;
        this.cardDetails = cardDetails2;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public final String getCardHash() {
        return this.cardHash;
    }

    public final void setCardHash(String str) {
        this.cardHash = str;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final void setCardNumber(String str) {
        this.cardNumber = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Body(ResultInfo resultInfo2, String str, String str2, CardDetails cardDetails2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : resultInfo2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : cardDetails2);
    }

    public final CardDetails getCardDetails() {
        return this.cardDetails;
    }

    public final void setCardDetails(CardDetails cardDetails2) {
        this.cardDetails = cardDetails2;
    }
}
