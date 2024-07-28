package net.one97.paytm.nativesdk.transactionsummary.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class Body implements IJRDataModel {
    private final String lastOrderAmount;
    private final String lastOrderCreationDate;
    private final String lastOrderId;
    private final String lastOrderStatus;
    private final String merchantName;
    private final String orderId;
    private final String payMode;
    private final String respMsg;
    private final ResultInfo resultInfo;
    private final String status;
    private final Long subsId;
    private final SubsPaymentInstDetails subsPaymentInstDetails;

    public static /* synthetic */ Body copy$default(Body body, String str, String str2, String str3, String str4, String str5, String str6, ResultInfo resultInfo2, String str7, String str8, Long l, String str9, SubsPaymentInstDetails subsPaymentInstDetails2, int i2, Object obj) {
        Body body2 = body;
        int i3 = i2;
        return body.copy((i3 & 1) != 0 ? body2.lastOrderCreationDate : str, (i3 & 2) != 0 ? body2.lastOrderId : str2, (i3 & 4) != 0 ? body2.lastOrderStatus : str3, (i3 & 8) != 0 ? body2.lastOrderAmount : str4, (i3 & 16) != 0 ? body2.orderId : str5, (i3 & 32) != 0 ? body2.payMode : str6, (i3 & 64) != 0 ? body2.resultInfo : resultInfo2, (i3 & 128) != 0 ? body2.status : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? body2.merchantName : str8, (i3 & 512) != 0 ? body2.subsId : l, (i3 & TarConstants.EOF_BLOCK) != 0 ? body2.respMsg : str9, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? body2.subsPaymentInstDetails : subsPaymentInstDetails2);
    }

    public final String component1() {
        return this.lastOrderCreationDate;
    }

    public final Long component10() {
        return this.subsId;
    }

    public final String component11() {
        return this.respMsg;
    }

    public final SubsPaymentInstDetails component12() {
        return this.subsPaymentInstDetails;
    }

    public final String component2() {
        return this.lastOrderId;
    }

    public final String component3() {
        return this.lastOrderStatus;
    }

    public final String component4() {
        return this.lastOrderAmount;
    }

    public final String component5() {
        return this.orderId;
    }

    public final String component6() {
        return this.payMode;
    }

    public final ResultInfo component7() {
        return this.resultInfo;
    }

    public final String component8() {
        return this.status;
    }

    public final String component9() {
        return this.merchantName;
    }

    public final Body copy(String str, String str2, String str3, String str4, String str5, String str6, ResultInfo resultInfo2, String str7, String str8, Long l, String str9, SubsPaymentInstDetails subsPaymentInstDetails2) {
        SubsPaymentInstDetails subsPaymentInstDetails3 = subsPaymentInstDetails2;
        k.c(subsPaymentInstDetails3, "subsPaymentInstDetails");
        return new Body(str, str2, str3, str4, str5, str6, resultInfo2, str7, str8, l, str9, subsPaymentInstDetails3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return k.a((Object) this.lastOrderCreationDate, (Object) body.lastOrderCreationDate) && k.a((Object) this.lastOrderId, (Object) body.lastOrderId) && k.a((Object) this.lastOrderStatus, (Object) body.lastOrderStatus) && k.a((Object) this.lastOrderAmount, (Object) body.lastOrderAmount) && k.a((Object) this.orderId, (Object) body.orderId) && k.a((Object) this.payMode, (Object) body.payMode) && k.a((Object) this.resultInfo, (Object) body.resultInfo) && k.a((Object) this.status, (Object) body.status) && k.a((Object) this.merchantName, (Object) body.merchantName) && k.a((Object) this.subsId, (Object) body.subsId) && k.a((Object) this.respMsg, (Object) body.respMsg) && k.a((Object) this.subsPaymentInstDetails, (Object) body.subsPaymentInstDetails);
    }

    public final int hashCode() {
        String str = this.lastOrderCreationDate;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lastOrderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastOrderStatus;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastOrderAmount;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.orderId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payMode;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ResultInfo resultInfo2 = this.resultInfo;
        int hashCode7 = (hashCode6 + (resultInfo2 != null ? resultInfo2.hashCode() : 0)) * 31;
        String str7 = this.status;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.merchantName;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Long l = this.subsId;
        int hashCode10 = (hashCode9 + (l != null ? l.hashCode() : 0)) * 31;
        String str9 = this.respMsg;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        SubsPaymentInstDetails subsPaymentInstDetails2 = this.subsPaymentInstDetails;
        if (subsPaymentInstDetails2 != null) {
            i2 = subsPaymentInstDetails2.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "Body(lastOrderCreationDate=" + this.lastOrderCreationDate + ", lastOrderId=" + this.lastOrderId + ", lastOrderStatus=" + this.lastOrderStatus + ", lastOrderAmount=" + this.lastOrderAmount + ", orderId=" + this.orderId + ", payMode=" + this.payMode + ", resultInfo=" + this.resultInfo + ", status=" + this.status + ", merchantName=" + this.merchantName + ", subsId=" + this.subsId + ", respMsg=" + this.respMsg + ", subsPaymentInstDetails=" + this.subsPaymentInstDetails + ")";
    }

    public Body(String str, String str2, String str3, String str4, String str5, String str6, ResultInfo resultInfo2, String str7, String str8, Long l, String str9, SubsPaymentInstDetails subsPaymentInstDetails2) {
        k.c(subsPaymentInstDetails2, "subsPaymentInstDetails");
        this.lastOrderCreationDate = str;
        this.lastOrderId = str2;
        this.lastOrderStatus = str3;
        this.lastOrderAmount = str4;
        this.orderId = str5;
        this.payMode = str6;
        this.resultInfo = resultInfo2;
        this.status = str7;
        this.merchantName = str8;
        this.subsId = l;
        this.respMsg = str9;
        this.subsPaymentInstDetails = subsPaymentInstDetails2;
    }

    public final String getLastOrderCreationDate() {
        return this.lastOrderCreationDate;
    }

    public final String getLastOrderId() {
        return this.lastOrderId;
    }

    public final String getLastOrderStatus() {
        return this.lastOrderStatus;
    }

    public final String getLastOrderAmount() {
        return this.lastOrderAmount;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPayMode() {
        return this.payMode;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final Long getSubsId() {
        return this.subsId;
    }

    public final String getRespMsg() {
        return this.respMsg;
    }

    public final SubsPaymentInstDetails getSubsPaymentInstDetails() {
        return this.subsPaymentInstDetails;
    }
}
