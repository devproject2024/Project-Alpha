package net.one97.paytm.contacts.entities.beans;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashSet;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class ContactDetail extends IJRPaytmDataModel implements IJRDataModel {
    private HashSet<String> allPhoneNumberList;
    private String contactDisplayDetail;
    private String contactId;
    private String contactName;
    private String contactNewAddedTimeLocal;
    private String contactNewTime;
    private String contactNickName;
    private String contactScore;
    private String contactStatus;
    private int contactType;
    private HashSet<String> emailIdList;
    private String ifsc;
    private String imageUrl;
    private Boolean isDirty;
    private boolean isSelected;
    private String merchantId;
    private String mode;
    private HashSet<PaymentInstrument> paymentInstrument;
    private String paymentInstrumentId;
    private String primaryPhoneNumber;
    private String uId;
    private String version;

    public ContactDetail() {
        this((String) null, (String) null, (HashSet) null, (HashSet) null, (String) null, (String) null, (String) null, 0, (HashSet) null, (String) null, (String) null, (Boolean) null, 4095, (g) null);
    }

    public static /* synthetic */ ContactDetail copy$default(ContactDetail contactDetail, String str, String str2, HashSet hashSet, HashSet hashSet2, String str3, String str4, String str5, int i2, HashSet hashSet3, String str6, String str7, Boolean bool, int i3, Object obj) {
        ContactDetail contactDetail2 = contactDetail;
        int i4 = i3;
        return contactDetail.copy((i4 & 1) != 0 ? contactDetail2.contactName : str, (i4 & 2) != 0 ? contactDetail2.contactNickName : str2, (i4 & 4) != 0 ? contactDetail2.allPhoneNumberList : hashSet, (i4 & 8) != 0 ? contactDetail2.emailIdList : hashSet2, (i4 & 16) != 0 ? contactDetail2.merchantId : str3, (i4 & 32) != 0 ? contactDetail2.contactId : str4, (i4 & 64) != 0 ? contactDetail2.primaryPhoneNumber : str5, (i4 & 128) != 0 ? contactDetail2.contactType : i2, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? contactDetail2.paymentInstrument : hashSet3, (i4 & 512) != 0 ? contactDetail2.paymentInstrumentId : str6, (i4 & TarConstants.EOF_BLOCK) != 0 ? contactDetail2.version : str7, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? contactDetail2.isDirty : bool);
    }

    public final String component1() {
        return this.contactName;
    }

    public final String component10() {
        return this.paymentInstrumentId;
    }

    public final String component11() {
        return this.version;
    }

    public final Boolean component12() {
        return this.isDirty;
    }

    public final String component2() {
        return this.contactNickName;
    }

    public final HashSet<String> component3() {
        return this.allPhoneNumberList;
    }

    public final HashSet<String> component4() {
        return this.emailIdList;
    }

    public final String component5() {
        return this.merchantId;
    }

    public final String component6() {
        return this.contactId;
    }

    public final String component7() {
        return this.primaryPhoneNumber;
    }

    public final int component8() {
        return this.contactType;
    }

    public final HashSet<PaymentInstrument> component9() {
        return this.paymentInstrument;
    }

    public final ContactDetail copy(String str, String str2, HashSet<String> hashSet, HashSet<String> hashSet2, String str3, String str4, String str5, int i2, HashSet<PaymentInstrument> hashSet3, String str6, String str7, Boolean bool) {
        return new ContactDetail(str, str2, hashSet, hashSet2, str3, str4, str5, i2, hashSet3, str6, str7, bool);
    }

    public final String toString() {
        return "ContactDetail(contactName=" + this.contactName + ", contactNickName=" + this.contactNickName + ", allPhoneNumberList=" + this.allPhoneNumberList + ", emailIdList=" + this.emailIdList + ", merchantId=" + this.merchantId + ", contactId=" + this.contactId + ", primaryPhoneNumber=" + this.primaryPhoneNumber + ", contactType=" + this.contactType + ", paymentInstrument=" + this.paymentInstrument + ", paymentInstrumentId=" + this.paymentInstrumentId + ", version=" + this.version + ", isDirty=" + this.isDirty + ")";
    }

    public ContactDetail(String str, String str2, HashSet<String> hashSet, HashSet<String> hashSet2, String str3, String str4, String str5, int i2, HashSet<PaymentInstrument> hashSet3, String str6, String str7, Boolean bool) {
        this.contactName = str;
        this.contactNickName = str2;
        this.allPhoneNumberList = hashSet;
        this.emailIdList = hashSet2;
        this.merchantId = str3;
        this.contactId = str4;
        this.primaryPhoneNumber = str5;
        this.contactType = i2;
        this.paymentInstrument = hashSet3;
        this.paymentInstrumentId = str6;
        this.version = str7;
        this.isDirty = bool;
        this.uId = k.a(this.contactId, (Object) this.primaryPhoneNumber);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ContactDetail(java.lang.String r13, java.lang.String r14, java.util.HashSet r15, java.util.HashSet r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, java.util.HashSet r21, java.lang.String r22, java.lang.String r23, java.lang.Boolean r24, int r25, kotlin.g.b.g r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            goto L_0x001c
        L_0x001b:
            r4 = r15
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0026
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            goto L_0x0028
        L_0x0026:
            r5 = r16
        L_0x0028:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002e
            r6 = r2
            goto L_0x0030
        L_0x002e:
            r6 = r17
        L_0x0030:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0036
            r7 = r2
            goto L_0x0038
        L_0x0036:
            r7 = r18
        L_0x0038:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003e
            r8 = r2
            goto L_0x0040
        L_0x003e:
            r8 = r19
        L_0x0040:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0046
            r9 = 1
            goto L_0x0048
        L_0x0046:
            r9 = r20
        L_0x0048:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0052
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            goto L_0x0054
        L_0x0052:
            r10 = r21
        L_0x0054:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r2 = r22
        L_0x005b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0062
            java.lang.String r11 = "-1"
            goto L_0x0064
        L_0x0062:
            r11 = r23
        L_0x0064:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x006b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x006d
        L_0x006b:
            r0 = r24
        L_0x006d:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r2
            r24 = r11
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.contacts.entities.beans.ContactDetail.<init>(java.lang.String, java.lang.String, java.util.HashSet, java.util.HashSet, java.lang.String, java.lang.String, java.lang.String, int, java.util.HashSet, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final HashSet<String> getAllPhoneNumberList() {
        return this.allPhoneNumberList;
    }

    public final String getContactId() {
        return this.contactId;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getContactNickName() {
        return this.contactNickName;
    }

    public final int getContactType() {
        return this.contactType;
    }

    public final HashSet<String> getEmailIdList() {
        return this.emailIdList;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final HashSet<PaymentInstrument> getPaymentInstrument() {
        return this.paymentInstrument;
    }

    public final String getPaymentInstrumentId() {
        return this.paymentInstrumentId;
    }

    public final String getPrimaryPhoneNumber() {
        return this.primaryPhoneNumber;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Boolean isDirty() {
        return this.isDirty;
    }

    public final void setAllPhoneNumberList(HashSet<String> hashSet) {
        this.allPhoneNumberList = hashSet;
    }

    public final void setContactId(String str) {
        this.contactId = str;
    }

    public final void setContactName(String str) {
        this.contactName = str;
    }

    public final void setContactNickName(String str) {
        this.contactNickName = str;
    }

    public final void setContactType(int i2) {
        this.contactType = i2;
    }

    public final void setDirty(Boolean bool) {
        this.isDirty = bool;
    }

    public final void setEmailIdList(HashSet<String> hashSet) {
        this.emailIdList = hashSet;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final void setPaymentInstrument(HashSet<PaymentInstrument> hashSet) {
        this.paymentInstrument = hashSet;
    }

    public final void setPaymentInstrumentId(String str) {
        this.paymentInstrumentId = str;
    }

    public final void setPrimaryPhoneNumber(String str) {
        this.primaryPhoneNumber = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final String getContactDisplayDetail() {
        return this.contactDisplayDetail;
    }

    public final void setContactDisplayDetail(String str) {
        this.contactDisplayDetail = str;
    }

    public final String getContactStatus() {
        return this.contactStatus;
    }

    public final void setContactStatus(String str) {
        this.contactStatus = str;
    }

    public final String getContactScore() {
        return this.contactScore;
    }

    public final void setContactScore(String str) {
        this.contactScore = str;
    }

    public final String getContactNewTime() {
        return this.contactNewTime;
    }

    public final void setContactNewTime(String str) {
        this.contactNewTime = str;
    }

    public final String getUId() {
        return this.uId;
    }

    public final void setUId(String str) {
        this.uId = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final String getContactNewAddedTimeLocal() {
        return this.contactNewAddedTimeLocal;
    }

    public final void setContactNewAddedTimeLocal(String str) {
        this.contactNewAddedTimeLocal = str;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            ContactDetail contactDetail = (ContactDetail) obj;
            if (!TextUtils.isEmpty(this.contactName) && !TextUtils.isEmpty(this.primaryPhoneNumber)) {
                return p.a(this.contactName, contactDetail.contactName, true) && p.a(this.primaryPhoneNumber, contactDetail.primaryPhoneNumber, false);
            }
            if (TextUtils.isEmpty(this.contactId) || TextUtils.isEmpty(this.primaryPhoneNumber)) {
                return p.a(contactDetail.contactId, this.contactId, false);
            }
            return p.a(this.contactId, contactDetail.contactId, false) && p.a(this.primaryPhoneNumber, contactDetail.primaryPhoneNumber, false);
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.contacts.entities.beans.ContactDetail");
    }

    public final int hashCode() {
        int i2 = 0;
        if (!TextUtils.isEmpty(this.contactId) && !TextUtils.isEmpty(this.primaryPhoneNumber)) {
            String str = this.contactId;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.primaryPhoneNumber;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        } else if (TextUtils.isEmpty(this.contactId)) {
            return super.hashCode();
        } else {
            String str3 = this.contactId;
            if (str3 != null) {
                return str3.hashCode();
            }
            return 0;
        }
    }
}
