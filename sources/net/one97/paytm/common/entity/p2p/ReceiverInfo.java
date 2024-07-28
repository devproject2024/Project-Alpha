package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ReceiverInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    private String contactName;
    @b(a = "kycState")
    private String kycState;
    @b(a = "name")
    private String name;
    @b(a = "phoneNumber")
    private String phoneNumber;
    @b(a = "picture")
    private String picture;

    public ReceiverInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ ReceiverInfo copy$default(ReceiverInfo receiverInfo, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = receiverInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = receiverInfo.picture;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = receiverInfo.phoneNumber;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = receiverInfo.kycState;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = receiverInfo.contactName;
        }
        return receiverInfo.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.picture;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final String component4() {
        return this.kycState;
    }

    public final String component5() {
        return this.contactName;
    }

    public final ReceiverInfo copy(String str, String str2, String str3, String str4, String str5) {
        return new ReceiverInfo(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReceiverInfo)) {
            return false;
        }
        ReceiverInfo receiverInfo = (ReceiverInfo) obj;
        return k.a((Object) this.name, (Object) receiverInfo.name) && k.a((Object) this.picture, (Object) receiverInfo.picture) && k.a((Object) this.phoneNumber, (Object) receiverInfo.phoneNumber) && k.a((Object) this.kycState, (Object) receiverInfo.kycState) && k.a((Object) this.contactName, (Object) receiverInfo.contactName);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.picture;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.phoneNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.kycState;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.contactName;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "ReceiverInfo(name=" + this.name + ", picture=" + this.picture + ", phoneNumber=" + this.phoneNumber + ", kycState=" + this.kycState + ", contactName=" + this.contactName + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final void setPicture(String str) {
        this.picture = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public ReceiverInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.picture = str2;
        this.phoneNumber = str3;
        this.kycState = str4;
        this.contactName = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ReceiverInfo(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.ReceiverInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getKycState() {
        return this.kycState;
    }

    public final void setContactName(String str) {
        this.contactName = str;
    }

    public final void setKycState(String str) {
        this.kycState = str;
    }
}
