package net.one97.paytm.common.entity.moneytransfer.requestmoney;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class MTRequestMoneyDetails implements IJRDataModel {
    private String amount;
    private String comment;
    private String customerId;
    private String imageURL;
    private boolean isAmountEditable;
    private boolean isCommentEditable;
    private String mobileNumber;
    private String payerName;
    private String payerVpa;
    private String themeID;

    public static /* synthetic */ MTRequestMoneyDetails copy$default(MTRequestMoneyDetails mTRequestMoneyDetails, String str, String str2, String str3, String str4, String str5, boolean z, String str6, boolean z2, String str7, String str8, int i2, Object obj) {
        MTRequestMoneyDetails mTRequestMoneyDetails2 = mTRequestMoneyDetails;
        int i3 = i2;
        return mTRequestMoneyDetails.copy((i3 & 1) != 0 ? mTRequestMoneyDetails2.payerName : str, (i3 & 2) != 0 ? mTRequestMoneyDetails2.customerId : str2, (i3 & 4) != 0 ? mTRequestMoneyDetails2.mobileNumber : str3, (i3 & 8) != 0 ? mTRequestMoneyDetails2.payerVpa : str4, (i3 & 16) != 0 ? mTRequestMoneyDetails2.amount : str5, (i3 & 32) != 0 ? mTRequestMoneyDetails2.isAmountEditable : z, (i3 & 64) != 0 ? mTRequestMoneyDetails2.comment : str6, (i3 & 128) != 0 ? mTRequestMoneyDetails2.isCommentEditable : z2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mTRequestMoneyDetails2.themeID : str7, (i3 & 512) != 0 ? mTRequestMoneyDetails2.imageURL : str8);
    }

    public final String component1() {
        return this.payerName;
    }

    public final String component10() {
        return this.imageURL;
    }

    public final String component2() {
        return this.customerId;
    }

    public final String component3() {
        return this.mobileNumber;
    }

    public final String component4() {
        return this.payerVpa;
    }

    public final String component5() {
        return this.amount;
    }

    public final boolean component6() {
        return this.isAmountEditable;
    }

    public final String component7() {
        return this.comment;
    }

    public final boolean component8() {
        return this.isCommentEditable;
    }

    public final String component9() {
        return this.themeID;
    }

    public final MTRequestMoneyDetails copy(String str, String str2, String str3, String str4, String str5, boolean z, String str6, boolean z2, String str7, String str8) {
        k.c(str, "payerName");
        String str9 = str5;
        k.c(str9, "amount");
        return new MTRequestMoneyDetails(str, str2, str3, str4, str9, z, str6, z2, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MTRequestMoneyDetails) {
                MTRequestMoneyDetails mTRequestMoneyDetails = (MTRequestMoneyDetails) obj;
                if (k.a((Object) this.payerName, (Object) mTRequestMoneyDetails.payerName) && k.a((Object) this.customerId, (Object) mTRequestMoneyDetails.customerId) && k.a((Object) this.mobileNumber, (Object) mTRequestMoneyDetails.mobileNumber) && k.a((Object) this.payerVpa, (Object) mTRequestMoneyDetails.payerVpa) && k.a((Object) this.amount, (Object) mTRequestMoneyDetails.amount)) {
                    if ((this.isAmountEditable == mTRequestMoneyDetails.isAmountEditable) && k.a((Object) this.comment, (Object) mTRequestMoneyDetails.comment)) {
                        if (!(this.isCommentEditable == mTRequestMoneyDetails.isCommentEditable) || !k.a((Object) this.themeID, (Object) mTRequestMoneyDetails.themeID) || !k.a((Object) this.imageURL, (Object) mTRequestMoneyDetails.imageURL)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.payerName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customerId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mobileNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.payerVpa;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.amount;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.isAmountEditable;
        if (z) {
            z = true;
        }
        int i3 = (hashCode5 + (z ? 1 : 0)) * 31;
        String str6 = this.comment;
        int hashCode6 = (i3 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z2 = this.isCommentEditable;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode6 + (z2 ? 1 : 0)) * 31;
        String str7 = this.themeID;
        int hashCode7 = (i4 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.imageURL;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "MTRequestMoneyDetails(payerName=" + this.payerName + ", customerId=" + this.customerId + ", mobileNumber=" + this.mobileNumber + ", payerVpa=" + this.payerVpa + ", amount=" + this.amount + ", isAmountEditable=" + this.isAmountEditable + ", comment=" + this.comment + ", isCommentEditable=" + this.isCommentEditable + ", themeID=" + this.themeID + ", imageURL=" + this.imageURL + ")";
    }

    public MTRequestMoneyDetails(String str, String str2, String str3, String str4, String str5, boolean z, String str6, boolean z2, String str7, String str8) {
        k.c(str, "payerName");
        k.c(str5, "amount");
        this.payerName = str;
        this.customerId = str2;
        this.mobileNumber = str3;
        this.payerVpa = str4;
        this.amount = str5;
        this.isAmountEditable = z;
        this.comment = str6;
        this.isCommentEditable = z2;
        this.themeID = str7;
        this.imageURL = str8;
    }

    public final String getPayerName() {
        return this.payerName;
    }

    public final void setPayerName(String str) {
        k.c(str, "<set-?>");
        this.payerName = str;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public final String getPayerVpa() {
        return this.payerVpa;
    }

    public final void setPayerVpa(String str) {
        this.payerVpa = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        k.c(str, "<set-?>");
        this.amount = str;
    }

    public final boolean isAmountEditable() {
        return this.isAmountEditable;
    }

    public final void setAmountEditable(boolean z) {
        this.isAmountEditable = z;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MTRequestMoneyDetails(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, boolean r20, java.lang.String r21, boolean r22, java.lang.String r23, java.lang.String r24, int r25, kotlin.g.b.g r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 32
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r9 = 1
            goto L_0x000b
        L_0x0009:
            r9 = r20
        L_0x000b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0011
            r11 = 1
            goto L_0x0013
        L_0x0011:
            r11 = r22
        L_0x0013:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r10 = r21
            r12 = r23
            r13 = r24
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.moneytransfer.requestmoney.MTRequestMoneyDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final boolean isCommentEditable() {
        return this.isCommentEditable;
    }

    public final void setCommentEditable(boolean z) {
        this.isCommentEditable = z;
    }

    public final String getThemeID() {
        return this.themeID;
    }

    public final void setThemeID(String str) {
        this.themeID = str;
    }

    public final String getImageURL() {
        return this.imageURL;
    }

    public final void setImageURL(String str) {
        this.imageURL = str;
    }
}
