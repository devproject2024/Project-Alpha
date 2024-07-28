package net.one97.paytm.common.entity.wallet.chatintegration;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class MTSDKTransferDetail extends IJRPaytmDataModel implements IJRDataModel {
    private final String accRefId;
    private final String accountNumber;
    private final String bankName;
    private final String customerId;
    private final String ifsc;
    private final String merchantId;
    private final String mobileNumber;
    private final int transferMode;
    private final String vpa;

    public static /* synthetic */ MTSDKTransferDetail copy$default(MTSDKTransferDetail mTSDKTransferDetail, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, Object obj) {
        MTSDKTransferDetail mTSDKTransferDetail2 = mTSDKTransferDetail;
        int i4 = i3;
        return mTSDKTransferDetail.copy((i4 & 1) != 0 ? mTSDKTransferDetail2.transferMode : i2, (i4 & 2) != 0 ? mTSDKTransferDetail2.customerId : str, (i4 & 4) != 0 ? mTSDKTransferDetail2.mobileNumber : str2, (i4 & 8) != 0 ? mTSDKTransferDetail2.accountNumber : str3, (i4 & 16) != 0 ? mTSDKTransferDetail2.ifsc : str4, (i4 & 32) != 0 ? mTSDKTransferDetail2.vpa : str5, (i4 & 64) != 0 ? mTSDKTransferDetail2.merchantId : str6, (i4 & 128) != 0 ? mTSDKTransferDetail2.bankName : str7, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mTSDKTransferDetail2.accRefId : str8);
    }

    public final int component1() {
        return this.transferMode;
    }

    public final String component2() {
        return this.customerId;
    }

    public final String component3() {
        return this.mobileNumber;
    }

    public final String component4() {
        return this.accountNumber;
    }

    public final String component5() {
        return this.ifsc;
    }

    public final String component6() {
        return this.vpa;
    }

    public final String component7() {
        return this.merchantId;
    }

    public final String component8() {
        return this.bankName;
    }

    public final String component9() {
        return this.accRefId;
    }

    public final MTSDKTransferDetail copy(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new MTSDKTransferDetail(i2, str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MTSDKTransferDetail) {
                MTSDKTransferDetail mTSDKTransferDetail = (MTSDKTransferDetail) obj;
                if (!(this.transferMode == mTSDKTransferDetail.transferMode) || !k.a((Object) this.customerId, (Object) mTSDKTransferDetail.customerId) || !k.a((Object) this.mobileNumber, (Object) mTSDKTransferDetail.mobileNumber) || !k.a((Object) this.accountNumber, (Object) mTSDKTransferDetail.accountNumber) || !k.a((Object) this.ifsc, (Object) mTSDKTransferDetail.ifsc) || !k.a((Object) this.vpa, (Object) mTSDKTransferDetail.vpa) || !k.a((Object) this.merchantId, (Object) mTSDKTransferDetail.merchantId) || !k.a((Object) this.bankName, (Object) mTSDKTransferDetail.bankName) || !k.a((Object) this.accRefId, (Object) mTSDKTransferDetail.accRefId)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.transferMode * 31;
        String str = this.customerId;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mobileNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ifsc;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.vpa;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.merchantId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.bankName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.accRefId;
        if (str8 != null) {
            i3 = str8.hashCode();
        }
        return hashCode7 + i3;
    }

    public final String toString() {
        return "MTSDKTransferDetail(transferMode=" + this.transferMode + ", customerId=" + this.customerId + ", mobileNumber=" + this.mobileNumber + ", accountNumber=" + this.accountNumber + ", ifsc=" + this.ifsc + ", vpa=" + this.vpa + ", merchantId=" + this.merchantId + ", bankName=" + this.bankName + ", accRefId=" + this.accRefId + ")";
    }

    public final int getTransferMode() {
        return this.transferMode;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getBankName() {
        return this.bankName;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MTSDKTransferDetail(int r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, kotlin.g.b.g r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r18
        L_0x003d:
            r11 = r9
            r12 = r10
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.wallet.chatintegration.MTSDKTransferDetail.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public MTSDKTransferDetail(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.transferMode = i2;
        this.customerId = str;
        this.mobileNumber = str2;
        this.accountNumber = str3;
        this.ifsc = str4;
        this.vpa = str5;
        this.merchantId = str6;
        this.bankName = str7;
        this.accRefId = str8;
    }
}
