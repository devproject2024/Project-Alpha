package net.one97.paytm.common.entity.moneytransfer.requestmoney;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class MTChatResponse implements IJRDataModel {
    private final String amount;
    private final String date;
    private final String errorMessage;
    private final String expiryDate;
    private final String note;
    private final String payeeCustID;
    private final String payerCustID;
    private final String payerName;
    private final String payerVpa;
    private final String receiverVPA;
    private final String requestID;
    private final String status;
    private final String themeID;

    public static /* synthetic */ MTChatResponse copy$default(MTChatResponse mTChatResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, Object obj) {
        MTChatResponse mTChatResponse2 = mTChatResponse;
        int i3 = i2;
        return mTChatResponse.copy((i3 & 1) != 0 ? mTChatResponse2.payerVpa : str, (i3 & 2) != 0 ? mTChatResponse2.payerName : str2, (i3 & 4) != 0 ? mTChatResponse2.amount : str3, (i3 & 8) != 0 ? mTChatResponse2.status : str4, (i3 & 16) != 0 ? mTChatResponse2.payerCustID : str5, (i3 & 32) != 0 ? mTChatResponse2.payeeCustID : str6, (i3 & 64) != 0 ? mTChatResponse2.date : str7, (i3 & 128) != 0 ? mTChatResponse2.receiverVPA : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mTChatResponse2.expiryDate : str9, (i3 & 512) != 0 ? mTChatResponse2.requestID : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? mTChatResponse2.themeID : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? mTChatResponse2.errorMessage : str12, (i3 & 4096) != 0 ? mTChatResponse2.note : str13);
    }

    public final String component1() {
        return this.payerVpa;
    }

    public final String component10() {
        return this.requestID;
    }

    public final String component11() {
        return this.themeID;
    }

    public final String component12() {
        return this.errorMessage;
    }

    public final String component13() {
        return this.note;
    }

    public final String component2() {
        return this.payerName;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.payerCustID;
    }

    public final String component6() {
        return this.payeeCustID;
    }

    public final String component7() {
        return this.date;
    }

    public final String component8() {
        return this.receiverVPA;
    }

    public final String component9() {
        return this.expiryDate;
    }

    public final MTChatResponse copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        String str14 = str;
        k.c(str14, UpiRequestBuilder.KEY_PAYER_VPA);
        String str15 = str2;
        k.c(str15, "payerName");
        String str16 = str3;
        k.c(str16, "amount");
        String str17 = str4;
        k.c(str17, "status");
        return new MTChatResponse(str14, str15, str16, str17, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MTChatResponse)) {
            return false;
        }
        MTChatResponse mTChatResponse = (MTChatResponse) obj;
        return k.a((Object) this.payerVpa, (Object) mTChatResponse.payerVpa) && k.a((Object) this.payerName, (Object) mTChatResponse.payerName) && k.a((Object) this.amount, (Object) mTChatResponse.amount) && k.a((Object) this.status, (Object) mTChatResponse.status) && k.a((Object) this.payerCustID, (Object) mTChatResponse.payerCustID) && k.a((Object) this.payeeCustID, (Object) mTChatResponse.payeeCustID) && k.a((Object) this.date, (Object) mTChatResponse.date) && k.a((Object) this.receiverVPA, (Object) mTChatResponse.receiverVPA) && k.a((Object) this.expiryDate, (Object) mTChatResponse.expiryDate) && k.a((Object) this.requestID, (Object) mTChatResponse.requestID) && k.a((Object) this.themeID, (Object) mTChatResponse.themeID) && k.a((Object) this.errorMessage, (Object) mTChatResponse.errorMessage) && k.a((Object) this.note, (Object) mTChatResponse.note);
    }

    public final int hashCode() {
        String str = this.payerVpa;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.payerName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.status;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.payerCustID;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payeeCustID;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.date;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.receiverVPA;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.expiryDate;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.requestID;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.themeID;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.errorMessage;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.note;
        if (str13 != null) {
            i2 = str13.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "MTChatResponse(payerVpa=" + this.payerVpa + ", payerName=" + this.payerName + ", amount=" + this.amount + ", status=" + this.status + ", payerCustID=" + this.payerCustID + ", payeeCustID=" + this.payeeCustID + ", date=" + this.date + ", receiverVPA=" + this.receiverVPA + ", expiryDate=" + this.expiryDate + ", requestID=" + this.requestID + ", themeID=" + this.themeID + ", errorMessage=" + this.errorMessage + ", note=" + this.note + ")";
    }

    public MTChatResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        k.c(str, UpiRequestBuilder.KEY_PAYER_VPA);
        k.c(str2, "payerName");
        k.c(str3, "amount");
        k.c(str4, "status");
        this.payerVpa = str;
        this.payerName = str2;
        this.amount = str3;
        this.status = str4;
        this.payerCustID = str5;
        this.payeeCustID = str6;
        this.date = str7;
        this.receiverVPA = str8;
        this.expiryDate = str9;
        this.requestID = str10;
        this.themeID = str11;
        this.errorMessage = str12;
        this.note = str13;
    }

    public final String getPayerVpa() {
        return this.payerVpa;
    }

    public final String getPayerName() {
        return this.payerName;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getPayerCustID() {
        return this.payerCustID;
    }

    public final String getPayeeCustID() {
        return this.payeeCustID;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getReceiverVPA() {
        return this.receiverVPA;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getRequestID() {
        return this.requestID;
    }

    public final String getThemeID() {
        return this.themeID;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getNote() {
        return this.note;
    }
}
