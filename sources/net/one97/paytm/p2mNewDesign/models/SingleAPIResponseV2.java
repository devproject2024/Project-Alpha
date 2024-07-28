package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRInfoResponse;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.network.c;
import net.one97.paytm.p2mNewDesign.entity.mlv.Cart;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails;
import org.json.JSONObject;

public final class SingleAPIResponseV2 extends CJRWalletDataModel implements IJRDataModel, c {
    @b(a = "body")
    private SingleAPIBodyV2 body;
    @b(a = "head")
    private HeadV2 head;

    public SingleAPIResponseV2() {
        this((HeadV2) null, (SingleAPIBodyV2) null, 3, (g) null);
    }

    public static /* synthetic */ SingleAPIResponseV2 copy$default(SingleAPIResponseV2 singleAPIResponseV2, HeadV2 headV2, SingleAPIBodyV2 singleAPIBodyV2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            headV2 = singleAPIResponseV2.head;
        }
        if ((i2 & 2) != 0) {
            singleAPIBodyV2 = singleAPIResponseV2.body;
        }
        return singleAPIResponseV2.copy(headV2, singleAPIBodyV2);
    }

    public final HeadV2 component1() {
        return this.head;
    }

    public final SingleAPIBodyV2 component2() {
        return this.body;
    }

    public final SingleAPIResponseV2 copy(HeadV2 headV2, SingleAPIBodyV2 singleAPIBodyV2) {
        return new SingleAPIResponseV2(headV2, singleAPIBodyV2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleAPIResponseV2)) {
            return false;
        }
        SingleAPIResponseV2 singleAPIResponseV2 = (SingleAPIResponseV2) obj;
        return k.a((Object) this.head, (Object) singleAPIResponseV2.head) && k.a((Object) this.body, (Object) singleAPIResponseV2.body);
    }

    public final int hashCode() {
        HeadV2 headV2 = this.head;
        int i2 = 0;
        int hashCode = (headV2 != null ? headV2.hashCode() : 0) * 31;
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 != null) {
            i2 = singleAPIBodyV2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SingleAPIResponseV2(head=" + this.head + ", body=" + this.body + ")";
    }

    public SingleAPIResponseV2(HeadV2 headV2, SingleAPIBodyV2 singleAPIBodyV2) {
        this.head = headV2;
        this.body = singleAPIBodyV2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SingleAPIResponseV2(HeadV2 headV2, SingleAPIBodyV2 singleAPIBodyV2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : headV2, (i2 & 2) != 0 ? null : singleAPIBodyV2);
    }

    public final SingleAPIBodyV2 getBody() {
        return this.body;
    }

    public final HeadV2 getHead() {
        return this.head;
    }

    public final void setBody(SingleAPIBodyV2 singleAPIBodyV2) {
        this.body = singleAPIBodyV2;
    }

    public final void setHead(HeadV2 headV2) {
        this.head = headV2;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        k.c(fVar, "gson");
        JSONObject jSONObject = new JSONObject(str);
        this.body = new SingleAPIBodyV2((BodyV2) null, (String) null, (ResultInfoV2) null, (ChannelPaymentDetails) null, 15, (g) null);
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 != null) {
            singleAPIBodyV2.parseResponse(jSONObject.optString("body"), fVar);
        }
        return this;
    }

    public final CJRQRInfoResponse getQRInfo() {
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 != null) {
            return singleAPIBodyV2.getQrInfo();
        }
        return null;
    }

    public final boolean isInvalidResponse() {
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 == null) {
            return true;
        }
        BodyV2 bodyV2 = null;
        if ((singleAPIBodyV2 != null ? singleAPIBodyV2.getQrInfo() : null) == null) {
            return true;
        }
        SingleAPIBodyV2 singleAPIBodyV22 = this.body;
        if (singleAPIBodyV22 != null) {
            bodyV2 = singleAPIBodyV22.getPaymentOptions();
        }
        return bodyV2 == null;
    }

    public final boolean isChannelOptionPresent() {
        ChannelPaymentDetails channelPaymentDetails;
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 == null) {
            return false;
        }
        Cart cart = null;
        if ((singleAPIBodyV2 != null ? singleAPIBodyV2.getChannelPaymentDetails() : null) == null) {
            return false;
        }
        SingleAPIBodyV2 singleAPIBodyV22 = this.body;
        if (!(singleAPIBodyV22 == null || (channelPaymentDetails = singleAPIBodyV22.getChannelPaymentDetails()) == null)) {
            cart = channelPaymentDetails.getCart();
        }
        return cart != null;
    }

    public final ChannelPaymentDetails getChannelOption() {
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 != null) {
            return singleAPIBodyV2.getChannelPaymentDetails();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getPaymentOptions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean getNativeJsonRequestSupported() {
        /*
            r1 = this;
            net.one97.paytm.p2mNewDesign.models.SingleAPIBodyV2 r0 = r1.body
            if (r0 == 0) goto L_0x0013
            net.one97.paytm.p2mNewDesign.models.BodyV2 r0 = r0.getPaymentOptions()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.getNativeJsonRequestSupported()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0018
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2.getNativeJsonRequestSupported():java.lang.Boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = (r0 = r0.getResultInfo()).getResultStatus();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean getResultFailed() {
        /*
            r3 = this;
            net.one97.paytm.p2mNewDesign.models.SingleAPIBodyV2 r0 = r3.body
            if (r0 == 0) goto L_0x001c
            net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r0 = r0.getResultInfo()
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = r0.getResultStatus()
            if (r0 == 0) goto L_0x001c
            r1 = 1
            java.lang.String r2 = "F"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 != 0) goto L_0x0021
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2.getResultFailed():java.lang.Boolean");
    }

    public final String getResultFailedMsg() {
        ResultInfoV2 resultInfo;
        SingleAPIBodyV2 singleAPIBodyV2 = this.body;
        if (singleAPIBodyV2 == null || (resultInfo = singleAPIBodyV2.getResultInfo()) == null) {
            return null;
        }
        return resultInfo.getResultMsg();
    }
}
