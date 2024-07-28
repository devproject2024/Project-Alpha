package net.one97.paytm.wallet.chatintegration;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class ChatPaymentIntegrationResponseModel extends IJRPaytmDataModel {
    private String amount;
    private long date;
    private String errMsg;
    private String mode;
    private String orderId;
    private String payeeBankAccountNo;
    private String payeeVpa;
    private String payerBankAccountNo;
    private String payerVpa;
    private String status;
    private String themeId;
    private String transcationid;

    public static /* synthetic */ ChatPaymentIntegrationResponseModel copy$default(ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel, String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8, String str9, String str10, String str11, int i2, Object obj) {
        ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel2 = chatPaymentIntegrationResponseModel;
        int i3 = i2;
        return chatPaymentIntegrationResponseModel.copy((i3 & 1) != 0 ? chatPaymentIntegrationResponseModel2.mode : str, (i3 & 2) != 0 ? chatPaymentIntegrationResponseModel2.payeeVpa : str2, (i3 & 4) != 0 ? chatPaymentIntegrationResponseModel2.payeeBankAccountNo : str3, (i3 & 8) != 0 ? chatPaymentIntegrationResponseModel2.payerVpa : str4, (i3 & 16) != 0 ? chatPaymentIntegrationResponseModel2.payerBankAccountNo : str5, (i3 & 32) != 0 ? chatPaymentIntegrationResponseModel2.amount : str6, (i3 & 64) != 0 ? chatPaymentIntegrationResponseModel2.date : j, (i3 & 128) != 0 ? chatPaymentIntegrationResponseModel2.status : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? chatPaymentIntegrationResponseModel2.orderId : str8, (i3 & 512) != 0 ? chatPaymentIntegrationResponseModel2.transcationid : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? chatPaymentIntegrationResponseModel2.themeId : str10, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? chatPaymentIntegrationResponseModel2.errMsg : str11);
    }

    public final String component1() {
        return this.mode;
    }

    public final String component10() {
        return this.transcationid;
    }

    public final String component11() {
        return this.themeId;
    }

    public final String component12() {
        return this.errMsg;
    }

    public final String component2() {
        return this.payeeVpa;
    }

    public final String component3() {
        return this.payeeBankAccountNo;
    }

    public final String component4() {
        return this.payerVpa;
    }

    public final String component5() {
        return this.payerBankAccountNo;
    }

    public final String component6() {
        return this.amount;
    }

    public final long component7() {
        return this.date;
    }

    public final String component8() {
        return this.status;
    }

    public final String component9() {
        return this.orderId;
    }

    public final ChatPaymentIntegrationResponseModel copy(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8, String str9, String str10, String str11) {
        String str12 = str;
        k.c(str12, "mode");
        String str13 = str6;
        k.c(str13, "amount");
        String str14 = str7;
        k.c(str14, "status");
        return new ChatPaymentIntegrationResponseModel(str12, str2, str3, str4, str5, str13, j, str14, str8, str9, str10, str11);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ChatPaymentIntegrationResponseModel) {
                ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel = (ChatPaymentIntegrationResponseModel) obj;
                if (k.a((Object) this.mode, (Object) chatPaymentIntegrationResponseModel.mode) && k.a((Object) this.payeeVpa, (Object) chatPaymentIntegrationResponseModel.payeeVpa) && k.a((Object) this.payeeBankAccountNo, (Object) chatPaymentIntegrationResponseModel.payeeBankAccountNo) && k.a((Object) this.payerVpa, (Object) chatPaymentIntegrationResponseModel.payerVpa) && k.a((Object) this.payerBankAccountNo, (Object) chatPaymentIntegrationResponseModel.payerBankAccountNo) && k.a((Object) this.amount, (Object) chatPaymentIntegrationResponseModel.amount)) {
                    if (!(this.date == chatPaymentIntegrationResponseModel.date) || !k.a((Object) this.status, (Object) chatPaymentIntegrationResponseModel.status) || !k.a((Object) this.orderId, (Object) chatPaymentIntegrationResponseModel.orderId) || !k.a((Object) this.transcationid, (Object) chatPaymentIntegrationResponseModel.transcationid) || !k.a((Object) this.themeId, (Object) chatPaymentIntegrationResponseModel.themeId) || !k.a((Object) this.errMsg, (Object) chatPaymentIntegrationResponseModel.errMsg)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.mode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.payeeVpa;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payeeBankAccountNo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.payerVpa;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.payerBankAccountNo;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.amount;
        int hashCode6 = str6 != null ? str6.hashCode() : 0;
        long j = this.date;
        int i3 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str7 = this.status;
        int hashCode7 = (i3 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.orderId;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.transcationid;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.themeId;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.errMsg;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "ChatPaymentIntegrationResponseModel(mode=" + this.mode + ", payeeVpa=" + this.payeeVpa + ", payeeBankAccountNo=" + this.payeeBankAccountNo + ", payerVpa=" + this.payerVpa + ", payerBankAccountNo=" + this.payerBankAccountNo + ", amount=" + this.amount + ", date=" + this.date + ", status=" + this.status + ", orderId=" + this.orderId + ", transcationid=" + this.transcationid + ", themeId=" + this.themeId + ", errMsg=" + this.errMsg + ")";
    }

    public ChatPaymentIntegrationResponseModel(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8, String str9, String str10, String str11) {
        k.c(str, "mode");
        k.c(str6, "amount");
        k.c(str7, "status");
        this.mode = str;
        this.payeeVpa = str2;
        this.payeeBankAccountNo = str3;
        this.payerVpa = str4;
        this.payerBankAccountNo = str5;
        this.amount = str6;
        this.date = j;
        this.status = str7;
        this.orderId = str8;
        this.transcationid = str9;
        this.themeId = str10;
        this.errMsg = str11;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPayeeBankAccountNo() {
        return this.payeeBankAccountNo;
    }

    public final String getPayeeVpa() {
        return this.payeeVpa;
    }

    public final String getPayerBankAccountNo() {
        return this.payerBankAccountNo;
    }

    public final String getPayerVpa() {
        return this.payerVpa;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getThemeId() {
        return this.themeId;
    }

    public final String getTranscationid() {
        return this.transcationid;
    }

    public final void setAmount(String str) {
        k.c(str, "<set-?>");
        this.amount = str;
    }

    public final void setDate(long j) {
        this.date = j;
    }

    public final void setErrMsg(String str) {
        this.errMsg = str;
    }

    public final void setMode(String str) {
        k.c(str, "<set-?>");
        this.mode = str;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPayeeBankAccountNo(String str) {
        this.payeeBankAccountNo = str;
    }

    public final void setPayeeVpa(String str) {
        this.payeeVpa = str;
    }

    public final void setPayerBankAccountNo(String str) {
        this.payerBankAccountNo = str;
    }

    public final void setPayerVpa(String str) {
        this.payerVpa = str;
    }

    public final void setStatus(String str) {
        k.c(str, "<set-?>");
        this.status = str;
    }

    public final void setThemeId(String str) {
        this.themeId = str;
    }

    public final void setTranscationid(String str) {
        this.transcationid = str;
    }
}
