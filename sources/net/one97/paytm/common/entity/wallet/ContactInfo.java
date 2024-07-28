package net.one97.paytm.common.entity.wallet;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ContactInfo implements IJRDataModel {
    private String contactImageUrl;
    private String contactName;
    private Boolean hasPayInstrumentPresent;
    private String phoneNumber;
    private String timestamp;

    public static /* synthetic */ ContactInfo copy$default(ContactInfo contactInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = contactInfo.contactName;
        }
        if ((i2 & 2) != 0) {
            str2 = contactInfo.phoneNumber;
        }
        if ((i2 & 4) != 0) {
            str3 = contactInfo.contactImageUrl;
        }
        return contactInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.contactName;
    }

    public final String component2() {
        return this.phoneNumber;
    }

    public final String component3() {
        return this.contactImageUrl;
    }

    public final ContactInfo copy(String str, String str2, String str3) {
        k.c(str2, "phoneNumber");
        return new ContactInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactInfo)) {
            return false;
        }
        ContactInfo contactInfo = (ContactInfo) obj;
        return k.a((Object) this.contactName, (Object) contactInfo.contactName) && k.a((Object) this.phoneNumber, (Object) contactInfo.phoneNumber) && k.a((Object) this.contactImageUrl, (Object) contactInfo.contactImageUrl);
    }

    public final int hashCode() {
        String str = this.contactName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.phoneNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.contactImageUrl;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ContactInfo(contactName=" + this.contactName + ", phoneNumber=" + this.phoneNumber + ", contactImageUrl=" + this.contactImageUrl + ")";
    }

    public ContactInfo(String str, String str2, String str3) {
        k.c(str2, "phoneNumber");
        this.contactName = str;
        this.phoneNumber = str2;
        this.contactImageUrl = str3;
    }

    public final String getContactImageUrl() {
        return this.contactImageUrl;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setContactImageUrl(String str) {
        this.contactImageUrl = str;
    }

    public final void setContactName(String str) {
        this.contactName = str;
    }

    public final void setPhoneNumber(String str) {
        k.c(str, "<set-?>");
        this.phoneNumber = str;
    }

    public final Boolean getHasPayInstrumentPresent() {
        return this.hasPayInstrumentPresent;
    }

    public final void setHasPayInstrumentPresent(Boolean bool) {
        this.hasPayInstrumentPresent = bool;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(String str) {
        this.timestamp = str;
    }
}
