package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SenderInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "kycState")
    private String kycState;
    @b(a = "name")
    private String name;
    @b(a = "phoneNumber")
    private String phoneNumber;
    @b(a = "picture")
    private String picture;

    public SenderInfo() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ SenderInfo copy$default(SenderInfo senderInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = senderInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = senderInfo.picture;
        }
        if ((i2 & 4) != 0) {
            str3 = senderInfo.phoneNumber;
        }
        if ((i2 & 8) != 0) {
            str4 = senderInfo.kycState;
        }
        return senderInfo.copy(str, str2, str3, str4);
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

    public final SenderInfo copy(String str, String str2, String str3, String str4) {
        return new SenderInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SenderInfo)) {
            return false;
        }
        SenderInfo senderInfo = (SenderInfo) obj;
        return k.a((Object) this.name, (Object) senderInfo.name) && k.a((Object) this.picture, (Object) senderInfo.picture) && k.a((Object) this.phoneNumber, (Object) senderInfo.phoneNumber) && k.a((Object) this.kycState, (Object) senderInfo.kycState);
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
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SenderInfo(name=" + this.name + ", picture=" + this.picture + ", phoneNumber=" + this.phoneNumber + ", kycState=" + this.kycState + ")";
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

    public SenderInfo(String str, String str2, String str3, String str4) {
        this.name = str;
        this.picture = str2;
        this.phoneNumber = str3;
        this.kycState = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SenderInfo(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getKycState() {
        return this.kycState;
    }

    public final void setKycState(String str) {
        this.kycState = str;
    }
}
