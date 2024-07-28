package com.paytm.contactsSdk.models.requests;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class ContactInfo {
    private final ArrayList<String> emails;
    private final Phones phones;

    public static /* synthetic */ ContactInfo copy$default(ContactInfo contactInfo, Phones phones2, ArrayList<String> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            phones2 = contactInfo.phones;
        }
        if ((i2 & 2) != 0) {
            arrayList = contactInfo.emails;
        }
        return contactInfo.copy(phones2, arrayList);
    }

    public final Phones component1() {
        return this.phones;
    }

    public final ArrayList<String> component2() {
        return this.emails;
    }

    public final ContactInfo copy(Phones phones2, ArrayList<String> arrayList) {
        k.c(phones2, "phones");
        k.c(arrayList, "emails");
        return new ContactInfo(phones2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactInfo)) {
            return false;
        }
        ContactInfo contactInfo = (ContactInfo) obj;
        return k.a((Object) this.phones, (Object) contactInfo.phones) && k.a((Object) this.emails, (Object) contactInfo.emails);
    }

    public final int hashCode() {
        Phones phones2 = this.phones;
        int i2 = 0;
        int hashCode = (phones2 != null ? phones2.hashCode() : 0) * 31;
        ArrayList<String> arrayList = this.emails;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ContactInfo(phones=" + this.phones + ", emails=" + this.emails + ")";
    }

    public ContactInfo(Phones phones2, ArrayList<String> arrayList) {
        k.c(phones2, "phones");
        k.c(arrayList, "emails");
        this.phones = phones2;
        this.emails = arrayList;
    }

    public final Phones getPhones() {
        return this.phones;
    }

    public final ArrayList<String> getEmails() {
        return this.emails;
    }
}
