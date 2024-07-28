package com.paytm.contactsSdk.models.requests;

import kotlin.g.b.k;

public final class ContactDetail {
    private final String contactId;
    private final ContactInfo contactInfo;
    private final String name;
    private final String nickName;

    public ContactDetail(String str, String str2, String str3, ContactInfo contactInfo2) {
        k.c(str, "contactId");
        k.c(str2, "name");
        k.c(str3, "nickName");
        k.c(contactInfo2, "contactInfo");
        this.contactId = str;
        this.name = str2;
        this.nickName = str3;
        this.contactInfo = contactInfo2;
    }

    public final String getContactId() {
        return this.contactId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final ContactInfo getContactInfo() {
        return this.contactInfo;
    }
}
