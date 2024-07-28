package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class TransactionInfo implements Serializable {
    private String BANKNAME;
    private String BANKTXNID;
    private String CURRENCY;
    private String GATEWAYNAME;
    private String MID;
    private String ORDERID;
    private String PAYMENTMODE;
    private String RESPCODE;
    private String RESPMSG;
    private String STATUS;
    private String TXNAMOUNT;
    private String TXNDATE;
    private String TXNID;

    public static /* synthetic */ TransactionInfo copy$default(TransactionInfo transactionInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2, Object obj) {
        TransactionInfo transactionInfo2 = transactionInfo;
        int i3 = i2;
        return transactionInfo.copy((i3 & 1) != 0 ? transactionInfo2.CURRENCY : str, (i3 & 2) != 0 ? transactionInfo2.ORDERID : str2, (i3 & 4) != 0 ? transactionInfo2.STATUS : str3, (i3 & 8) != 0 ? transactionInfo2.BANKTXNID : str4, (i3 & 16) != 0 ? transactionInfo2.GATEWAYNAME : str5, (i3 & 32) != 0 ? transactionInfo2.BANKNAME : str6, (i3 & 64) != 0 ? transactionInfo2.RESPMSG : str7, (i3 & 128) != 0 ? transactionInfo2.PAYMENTMODE : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? transactionInfo2.TXNDATE : str9, (i3 & 512) != 0 ? transactionInfo2.MID : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? transactionInfo2.RESPCODE : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? transactionInfo2.TXNID : str12, (i3 & 4096) != 0 ? transactionInfo2.TXNAMOUNT : str13);
    }

    public final String component1() {
        return this.CURRENCY;
    }

    public final String component10() {
        return this.MID;
    }

    public final String component11() {
        return this.RESPCODE;
    }

    public final String component12() {
        return this.TXNID;
    }

    public final String component13() {
        return this.TXNAMOUNT;
    }

    public final String component2() {
        return this.ORDERID;
    }

    public final String component3() {
        return this.STATUS;
    }

    public final String component4() {
        return this.BANKTXNID;
    }

    public final String component5() {
        return this.GATEWAYNAME;
    }

    public final String component6() {
        return this.BANKNAME;
    }

    public final String component7() {
        return this.RESPMSG;
    }

    public final String component8() {
        return this.PAYMENTMODE;
    }

    public final String component9() {
        return this.TXNDATE;
    }

    public final TransactionInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return new TransactionInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionInfo)) {
            return false;
        }
        TransactionInfo transactionInfo = (TransactionInfo) obj;
        return k.a((Object) this.CURRENCY, (Object) transactionInfo.CURRENCY) && k.a((Object) this.ORDERID, (Object) transactionInfo.ORDERID) && k.a((Object) this.STATUS, (Object) transactionInfo.STATUS) && k.a((Object) this.BANKTXNID, (Object) transactionInfo.BANKTXNID) && k.a((Object) this.GATEWAYNAME, (Object) transactionInfo.GATEWAYNAME) && k.a((Object) this.BANKNAME, (Object) transactionInfo.BANKNAME) && k.a((Object) this.RESPMSG, (Object) transactionInfo.RESPMSG) && k.a((Object) this.PAYMENTMODE, (Object) transactionInfo.PAYMENTMODE) && k.a((Object) this.TXNDATE, (Object) transactionInfo.TXNDATE) && k.a((Object) this.MID, (Object) transactionInfo.MID) && k.a((Object) this.RESPCODE, (Object) transactionInfo.RESPCODE) && k.a((Object) this.TXNID, (Object) transactionInfo.TXNID) && k.a((Object) this.TXNAMOUNT, (Object) transactionInfo.TXNAMOUNT);
    }

    public final int hashCode() {
        String str = this.CURRENCY;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ORDERID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.STATUS;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.BANKTXNID;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.GATEWAYNAME;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.BANKNAME;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.RESPMSG;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.PAYMENTMODE;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.TXNDATE;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.MID;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.RESPCODE;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.TXNID;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.TXNAMOUNT;
        if (str13 != null) {
            i2 = str13.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "TransactionInfo(CURRENCY=" + this.CURRENCY + ", ORDERID=" + this.ORDERID + ", STATUS=" + this.STATUS + ", BANKTXNID=" + this.BANKTXNID + ", GATEWAYNAME=" + this.GATEWAYNAME + ", BANKNAME=" + this.BANKNAME + ", RESPMSG=" + this.RESPMSG + ", PAYMENTMODE=" + this.PAYMENTMODE + ", TXNDATE=" + this.TXNDATE + ", MID=" + this.MID + ", RESPCODE=" + this.RESPCODE + ", TXNID=" + this.TXNID + ", TXNAMOUNT=" + this.TXNAMOUNT + ")";
    }

    public TransactionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.CURRENCY = str;
        this.ORDERID = str2;
        this.STATUS = str3;
        this.BANKTXNID = str4;
        this.GATEWAYNAME = str5;
        this.BANKNAME = str6;
        this.RESPMSG = str7;
        this.PAYMENTMODE = str8;
        this.TXNDATE = str9;
        this.MID = str10;
        this.RESPCODE = str11;
        this.TXNID = str12;
        this.TXNAMOUNT = str13;
    }

    public final String getCURRENCY() {
        return this.CURRENCY;
    }

    public final void setCURRENCY(String str) {
        this.CURRENCY = str;
    }

    public final String getORDERID() {
        return this.ORDERID;
    }

    public final void setORDERID(String str) {
        this.ORDERID = str;
    }

    public final String getSTATUS() {
        return this.STATUS;
    }

    public final void setSTATUS(String str) {
        this.STATUS = str;
    }

    public final String getBANKTXNID() {
        return this.BANKTXNID;
    }

    public final void setBANKTXNID(String str) {
        this.BANKTXNID = str;
    }

    public final String getGATEWAYNAME() {
        return this.GATEWAYNAME;
    }

    public final void setGATEWAYNAME(String str) {
        this.GATEWAYNAME = str;
    }

    public final String getBANKNAME() {
        return this.BANKNAME;
    }

    public final void setBANKNAME(String str) {
        this.BANKNAME = str;
    }

    public final String getRESPMSG() {
        return this.RESPMSG;
    }

    public final void setRESPMSG(String str) {
        this.RESPMSG = str;
    }

    public final String getPAYMENTMODE() {
        return this.PAYMENTMODE;
    }

    public final void setPAYMENTMODE(String str) {
        this.PAYMENTMODE = str;
    }

    public final String getTXNDATE() {
        return this.TXNDATE;
    }

    public final void setTXNDATE(String str) {
        this.TXNDATE = str;
    }

    public final String getMID() {
        return this.MID;
    }

    public final void setMID(String str) {
        this.MID = str;
    }

    public final String getRESPCODE() {
        return this.RESPCODE;
    }

    public final void setRESPCODE(String str) {
        this.RESPCODE = str;
    }

    public final String getTXNID() {
        return this.TXNID;
    }

    public final void setTXNID(String str) {
        this.TXNID = str;
    }

    public final String getTXNAMOUNT() {
        return this.TXNAMOUNT;
    }

    public final void setTXNAMOUNT(String str) {
        this.TXNAMOUNT = str;
    }
}
