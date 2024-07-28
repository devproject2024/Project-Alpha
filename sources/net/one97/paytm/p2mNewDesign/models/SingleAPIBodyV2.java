package net.one97.paytm.p2mNewDesign.models;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRQRInfoResponse;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.network.c;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails;
import org.json.JSONObject;

public final class SingleAPIBodyV2 extends CJRWalletDataModel implements IJRDataModel, c {
    @b(a = "channelPaymentDetails")
    private ChannelPaymentDetails channelPaymentDetails;
    @b(a = "extraParamsMap")
    private String extraParamsMap;
    @b(a = "paymentOptions")
    private BodyV2 paymentOptions;
    private CJRQRInfoResponse qrInfo;
    @b(a = "resultInfo")
    private ResultInfoV2 resultInfo;

    public SingleAPIBodyV2() {
        this((BodyV2) null, (String) null, (ResultInfoV2) null, (ChannelPaymentDetails) null, 15, (g) null);
    }

    public static /* synthetic */ SingleAPIBodyV2 copy$default(SingleAPIBodyV2 singleAPIBodyV2, BodyV2 bodyV2, String str, ResultInfoV2 resultInfoV2, ChannelPaymentDetails channelPaymentDetails2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bodyV2 = singleAPIBodyV2.paymentOptions;
        }
        if ((i2 & 2) != 0) {
            str = singleAPIBodyV2.extraParamsMap;
        }
        if ((i2 & 4) != 0) {
            resultInfoV2 = singleAPIBodyV2.resultInfo;
        }
        if ((i2 & 8) != 0) {
            channelPaymentDetails2 = singleAPIBodyV2.channelPaymentDetails;
        }
        return singleAPIBodyV2.copy(bodyV2, str, resultInfoV2, channelPaymentDetails2);
    }

    public final BodyV2 component1() {
        return this.paymentOptions;
    }

    public final String component2() {
        return this.extraParamsMap;
    }

    public final ResultInfoV2 component3() {
        return this.resultInfo;
    }

    public final ChannelPaymentDetails component4() {
        return this.channelPaymentDetails;
    }

    public final SingleAPIBodyV2 copy(BodyV2 bodyV2, String str, ResultInfoV2 resultInfoV2, ChannelPaymentDetails channelPaymentDetails2) {
        return new SingleAPIBodyV2(bodyV2, str, resultInfoV2, channelPaymentDetails2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleAPIBodyV2)) {
            return false;
        }
        SingleAPIBodyV2 singleAPIBodyV2 = (SingleAPIBodyV2) obj;
        return k.a((Object) this.paymentOptions, (Object) singleAPIBodyV2.paymentOptions) && k.a((Object) this.extraParamsMap, (Object) singleAPIBodyV2.extraParamsMap) && k.a((Object) this.resultInfo, (Object) singleAPIBodyV2.resultInfo) && k.a((Object) this.channelPaymentDetails, (Object) singleAPIBodyV2.channelPaymentDetails);
    }

    public final int hashCode() {
        BodyV2 bodyV2 = this.paymentOptions;
        int i2 = 0;
        int hashCode = (bodyV2 != null ? bodyV2.hashCode() : 0) * 31;
        String str = this.extraParamsMap;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        ResultInfoV2 resultInfoV2 = this.resultInfo;
        int hashCode3 = (hashCode2 + (resultInfoV2 != null ? resultInfoV2.hashCode() : 0)) * 31;
        ChannelPaymentDetails channelPaymentDetails2 = this.channelPaymentDetails;
        if (channelPaymentDetails2 != null) {
            i2 = channelPaymentDetails2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SingleAPIBodyV2(paymentOptions=" + this.paymentOptions + ", extraParamsMap=" + this.extraParamsMap + ", resultInfo=" + this.resultInfo + ", channelPaymentDetails=" + this.channelPaymentDetails + ")";
    }

    public SingleAPIBodyV2(BodyV2 bodyV2, String str, ResultInfoV2 resultInfoV2, ChannelPaymentDetails channelPaymentDetails2) {
        this.paymentOptions = bodyV2;
        this.extraParamsMap = str;
        this.resultInfo = resultInfoV2;
        this.channelPaymentDetails = channelPaymentDetails2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SingleAPIBodyV2(BodyV2 bodyV2, String str, ResultInfoV2 resultInfoV2, ChannelPaymentDetails channelPaymentDetails2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bodyV2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : resultInfoV2, (i2 & 8) != 0 ? null : channelPaymentDetails2);
    }

    public final ChannelPaymentDetails getChannelPaymentDetails() {
        return this.channelPaymentDetails;
    }

    public final String getExtraParamsMap() {
        return this.extraParamsMap;
    }

    public final BodyV2 getPaymentOptions() {
        return this.paymentOptions;
    }

    public final ResultInfoV2 getResultInfo() {
        return this.resultInfo;
    }

    public final void setChannelPaymentDetails(ChannelPaymentDetails channelPaymentDetails2) {
        this.channelPaymentDetails = channelPaymentDetails2;
    }

    public final void setExtraParamsMap(String str) {
        this.extraParamsMap = str;
    }

    public final void setPaymentOptions(BodyV2 bodyV2) {
        this.paymentOptions = bodyV2;
    }

    public final void setResultInfo(ResultInfoV2 resultInfoV2) {
        this.resultInfo = resultInfoV2;
    }

    public final CJRQRInfoResponse getQrInfo() {
        return this.qrInfo;
    }

    public final void setQrInfo(CJRQRInfoResponse cJRQRInfoResponse) {
        this.qrInfo = cJRQRInfoResponse;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        k.c(fVar, "gson");
        JSONObject jSONObject = new JSONObject(str);
        this.qrInfo = new CJRQRInfoResponse();
        CJRQRInfoResponse cJRQRInfoResponse = this.qrInfo;
        if (cJRQRInfoResponse == null) {
            k.a();
        }
        cJRQRInfoResponse.parseResponse(jSONObject.optString("qrInfo"), fVar);
        this.extraParamsMap = jSONObject.optString(this.extraParamsMap);
        String optString = jSONObject.optString("resultInfo");
        String optString2 = jSONObject.optString("paymentOptions");
        String optString3 = jSONObject.optString("channelPaymentDetails");
        if (!TextUtils.isEmpty(optString)) {
            this.resultInfo = (ResultInfoV2) fVar.a(optString, ResultInfoV2.class);
        }
        if (!TextUtils.isEmpty(optString2)) {
            this.paymentOptions = (BodyV2) fVar.a(optString2, BodyV2.class);
        }
        if (!TextUtils.isEmpty(optString3)) {
            this.channelPaymentDetails = (ChannelPaymentDetails) fVar.a(optString3, ChannelPaymentDetails.class);
        }
        return this;
    }
}
