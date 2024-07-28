package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class Body implements Serializable {
    private BankForm bankForm;
    private String bankFormJson;
    private String callBackUrl;
    private String callbackUrl;
    private DeeplinkInfo deepLinkInfo;
    private OneClickInfo oneClickInfo;
    private String resultCode;
    private String resultCodeId;
    private ResultInfo resultInfo;
    private String resultMsg;
    private RiskContent riskContent;
    private Object txnInfo;

    public static /* synthetic */ Body copy$default(Body body, ResultInfo resultInfo2, Object obj, OneClickInfo oneClickInfo2, DeeplinkInfo deeplinkInfo, BankForm bankForm2, String str, String str2, String str3, RiskContent riskContent2, String str4, String str5, String str6, int i2, Object obj2) {
        Body body2 = body;
        int i3 = i2;
        return body.copy((i3 & 1) != 0 ? body2.resultInfo : resultInfo2, (i3 & 2) != 0 ? body2.txnInfo : obj, (i3 & 4) != 0 ? body2.oneClickInfo : oneClickInfo2, (i3 & 8) != 0 ? body2.deepLinkInfo : deeplinkInfo, (i3 & 16) != 0 ? body2.bankForm : bankForm2, (i3 & 32) != 0 ? body2.callBackUrl : str, (i3 & 64) != 0 ? body2.callbackUrl : str2, (i3 & 128) != 0 ? body2.bankFormJson : str3, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? body2.riskContent : riskContent2, (i3 & 512) != 0 ? body2.resultCode : str4, (i3 & TarConstants.EOF_BLOCK) != 0 ? body2.resultCodeId : str5, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? body2.resultMsg : str6);
    }

    public final ResultInfo component1() {
        return this.resultInfo;
    }

    public final String component10() {
        return this.resultCode;
    }

    public final String component11() {
        return this.resultCodeId;
    }

    public final String component12() {
        return this.resultMsg;
    }

    public final Object component2() {
        return this.txnInfo;
    }

    public final OneClickInfo component3() {
        return this.oneClickInfo;
    }

    public final DeeplinkInfo component4() {
        return this.deepLinkInfo;
    }

    public final BankForm component5() {
        return this.bankForm;
    }

    public final String component6() {
        return this.callBackUrl;
    }

    public final String component7() {
        return this.callbackUrl;
    }

    public final String component8() {
        return this.bankFormJson;
    }

    public final RiskContent component9() {
        return this.riskContent;
    }

    public final Body copy(ResultInfo resultInfo2, Object obj, OneClickInfo oneClickInfo2, DeeplinkInfo deeplinkInfo, BankForm bankForm2, String str, String str2, String str3, RiskContent riskContent2, String str4, String str5, String str6) {
        return new Body(resultInfo2, obj, oneClickInfo2, deeplinkInfo, bankForm2, str, str2, str3, riskContent2, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return k.a((Object) this.resultInfo, (Object) body.resultInfo) && k.a(this.txnInfo, body.txnInfo) && k.a((Object) this.oneClickInfo, (Object) body.oneClickInfo) && k.a((Object) this.deepLinkInfo, (Object) body.deepLinkInfo) && k.a((Object) this.bankForm, (Object) body.bankForm) && k.a((Object) this.callBackUrl, (Object) body.callBackUrl) && k.a((Object) this.callbackUrl, (Object) body.callbackUrl) && k.a((Object) this.bankFormJson, (Object) body.bankFormJson) && k.a((Object) this.riskContent, (Object) body.riskContent) && k.a((Object) this.resultCode, (Object) body.resultCode) && k.a((Object) this.resultCodeId, (Object) body.resultCodeId) && k.a((Object) this.resultMsg, (Object) body.resultMsg);
    }

    public final int hashCode() {
        ResultInfo resultInfo2 = this.resultInfo;
        int i2 = 0;
        int hashCode = (resultInfo2 != null ? resultInfo2.hashCode() : 0) * 31;
        Object obj = this.txnInfo;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        OneClickInfo oneClickInfo2 = this.oneClickInfo;
        int hashCode3 = (hashCode2 + (oneClickInfo2 != null ? oneClickInfo2.hashCode() : 0)) * 31;
        DeeplinkInfo deeplinkInfo = this.deepLinkInfo;
        int hashCode4 = (hashCode3 + (deeplinkInfo != null ? deeplinkInfo.hashCode() : 0)) * 31;
        BankForm bankForm2 = this.bankForm;
        int hashCode5 = (hashCode4 + (bankForm2 != null ? bankForm2.hashCode() : 0)) * 31;
        String str = this.callBackUrl;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.callbackUrl;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankFormJson;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        RiskContent riskContent2 = this.riskContent;
        int hashCode9 = (hashCode8 + (riskContent2 != null ? riskContent2.hashCode() : 0)) * 31;
        String str4 = this.resultCode;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.resultCodeId;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.resultMsg;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "Body(resultInfo=" + this.resultInfo + ", txnInfo=" + this.txnInfo + ", oneClickInfo=" + this.oneClickInfo + ", deepLinkInfo=" + this.deepLinkInfo + ", bankForm=" + this.bankForm + ", callBackUrl=" + this.callBackUrl + ", callbackUrl=" + this.callbackUrl + ", bankFormJson=" + this.bankFormJson + ", riskContent=" + this.riskContent + ", resultCode=" + this.resultCode + ", resultCodeId=" + this.resultCodeId + ", resultMsg=" + this.resultMsg + ")";
    }

    public Body(ResultInfo resultInfo2, Object obj, OneClickInfo oneClickInfo2, DeeplinkInfo deeplinkInfo, BankForm bankForm2, String str, String str2, String str3, RiskContent riskContent2, String str4, String str5, String str6) {
        this.resultInfo = resultInfo2;
        this.txnInfo = obj;
        this.oneClickInfo = oneClickInfo2;
        this.deepLinkInfo = deeplinkInfo;
        this.bankForm = bankForm2;
        this.callBackUrl = str;
        this.callbackUrl = str2;
        this.bankFormJson = str3;
        this.riskContent = riskContent2;
        this.resultCode = str4;
        this.resultCodeId = str5;
        this.resultMsg = str6;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public final Object getTxnInfo() {
        return this.txnInfo;
    }

    public final void setTxnInfo(Object obj) {
        this.txnInfo = obj;
    }

    public final OneClickInfo getOneClickInfo() {
        return this.oneClickInfo;
    }

    public final void setOneClickInfo(OneClickInfo oneClickInfo2) {
        this.oneClickInfo = oneClickInfo2;
    }

    public final DeeplinkInfo getDeepLinkInfo() {
        return this.deepLinkInfo;
    }

    public final void setDeepLinkInfo(DeeplinkInfo deeplinkInfo) {
        this.deepLinkInfo = deeplinkInfo;
    }

    public final BankForm getBankForm() {
        return this.bankForm;
    }

    public final void setBankForm(BankForm bankForm2) {
        this.bankForm = bankForm2;
    }

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final void setCallBackUrl(String str) {
        this.callBackUrl = str;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    public final void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public final String getBankFormJson() {
        return this.bankFormJson;
    }

    public final void setBankFormJson(String str) {
        this.bankFormJson = str;
    }

    public final RiskContent getRiskContent() {
        return this.riskContent;
    }

    public final void setRiskContent(RiskContent riskContent2) {
        this.riskContent = riskContent2;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public Body() {
        this((ResultInfo) null, (Object) null, (OneClickInfo) null, (DeeplinkInfo) null, (BankForm) null, (String) null, (String) null, (String) null, (RiskContent) null, (String) null, (String) null, (String) null);
    }
}
