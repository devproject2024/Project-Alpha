package net.one97.paytm.upi.mandate.data.model;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class AuthMandateRequestModel implements UpiBaseDataModel {
    @b(a = "accRefId")
    private final String accRefId;
    @b(a = "action")
    private final String action;
    @b(a = "deviceId")
    private final String deviceId;
    @b(a = "mandateType")
    private final String mandateType;
    @b(a = "mpin")
    private final String mpin;
    @b(a = "payerAccount")
    private final String payerAccount;
    @b(a = "payerIfsc")
    private final String payerIfsc;
    @b(a = "seqNo")
    private final String seqNo;
    @b(a = "umn")
    private final String umn;

    public static /* synthetic */ AuthMandateRequestModel copy$default(AuthMandateRequestModel authMandateRequestModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) {
        AuthMandateRequestModel authMandateRequestModel2 = authMandateRequestModel;
        int i3 = i2;
        return authMandateRequestModel.copy((i3 & 1) != 0 ? authMandateRequestModel2.seqNo : str, (i3 & 2) != 0 ? authMandateRequestModel2.deviceId : str2, (i3 & 4) != 0 ? authMandateRequestModel2.action : str3, (i3 & 8) != 0 ? authMandateRequestModel2.mpin : str4, (i3 & 16) != 0 ? authMandateRequestModel2.umn : str5, (i3 & 32) != 0 ? authMandateRequestModel2.payerIfsc : str6, (i3 & 64) != 0 ? authMandateRequestModel2.payerAccount : str7, (i3 & 128) != 0 ? authMandateRequestModel2.accRefId : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? authMandateRequestModel2.mandateType : str9);
    }

    public final String component1() {
        return this.seqNo;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.action;
    }

    public final String component4() {
        return this.mpin;
    }

    public final String component5() {
        return this.umn;
    }

    public final String component6() {
        return this.payerIfsc;
    }

    public final String component7() {
        return this.payerAccount;
    }

    public final String component8() {
        return this.accRefId;
    }

    public final String component9() {
        return this.mandateType;
    }

    public final AuthMandateRequestModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, "action");
        k.c(str4, PayUtility.MPIN);
        String str10 = str5;
        k.c(str10, "umn");
        String str11 = str6;
        k.c(str11, "payerIfsc");
        String str12 = str7;
        k.c(str12, PayUtility.PAYER_ACCOUNT);
        String str13 = str8;
        k.c(str13, "accRefId");
        String str14 = str9;
        k.c(str14, "mandateType");
        return new AuthMandateRequestModel(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthMandateRequestModel)) {
            return false;
        }
        AuthMandateRequestModel authMandateRequestModel = (AuthMandateRequestModel) obj;
        return k.a((Object) this.seqNo, (Object) authMandateRequestModel.seqNo) && k.a((Object) this.deviceId, (Object) authMandateRequestModel.deviceId) && k.a((Object) this.action, (Object) authMandateRequestModel.action) && k.a((Object) this.mpin, (Object) authMandateRequestModel.mpin) && k.a((Object) this.umn, (Object) authMandateRequestModel.umn) && k.a((Object) this.payerIfsc, (Object) authMandateRequestModel.payerIfsc) && k.a((Object) this.payerAccount, (Object) authMandateRequestModel.payerAccount) && k.a((Object) this.accRefId, (Object) authMandateRequestModel.accRefId) && k.a((Object) this.mandateType, (Object) authMandateRequestModel.mandateType);
    }

    public final int hashCode() {
        String str = this.seqNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.action;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mpin;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.umn;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payerIfsc;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.payerAccount;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.accRefId;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.mandateType;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "AuthMandateRequestModel(seqNo=" + this.seqNo + ", deviceId=" + this.deviceId + ", action=" + this.action + ", mpin=" + this.mpin + ", umn=" + this.umn + ", payerIfsc=" + this.payerIfsc + ", payerAccount=" + this.payerAccount + ", accRefId=" + this.accRefId + ", mandateType=" + this.mandateType + ")";
    }

    public AuthMandateRequestModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, "action");
        k.c(str4, PayUtility.MPIN);
        k.c(str5, "umn");
        k.c(str6, "payerIfsc");
        k.c(str7, PayUtility.PAYER_ACCOUNT);
        k.c(str8, "accRefId");
        k.c(str9, "mandateType");
        this.seqNo = str;
        this.deviceId = str2;
        this.action = str3;
        this.mpin = str4;
        this.umn = str5;
        this.payerIfsc = str6;
        this.payerAccount = str7;
        this.accRefId = str8;
        this.mandateType = str9;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMpin() {
        return this.mpin;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final String getPayerIfsc() {
        return this.payerIfsc;
    }

    public final String getPayerAccount() {
        return this.payerAccount;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final String getMandateType() {
        return this.mandateType;
    }
}
