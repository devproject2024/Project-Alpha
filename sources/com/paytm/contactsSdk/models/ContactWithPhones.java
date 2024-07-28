package com.paytm.contactsSdk.models;

import java.util.List;
import kotlin.g.b.k;

public final class ContactWithPhones {
    private final Contact contact;
    private final List<ContactPhone> phones;

    public static /* synthetic */ ContactWithPhones copy$default(ContactWithPhones contactWithPhones, Contact contact2, List<ContactPhone> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            contact2 = contactWithPhones.contact;
        }
        if ((i2 & 2) != 0) {
            list = contactWithPhones.phones;
        }
        return contactWithPhones.copy(contact2, list);
    }

    public final Contact component1() {
        return this.contact;
    }

    public final List<ContactPhone> component2() {
        return this.phones;
    }

    public final ContactWithPhones copy(Contact contact2, List<ContactPhone> list) {
        k.c(contact2, "contact");
        k.c(list, "phones");
        return new ContactWithPhones(contact2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactWithPhones)) {
            return false;
        }
        ContactWithPhones contactWithPhones = (ContactWithPhones) obj;
        return k.a((Object) this.contact, (Object) contactWithPhones.contact) && k.a((Object) this.phones, (Object) contactWithPhones.phones);
    }

    public final int hashCode() {
        Contact contact2 = this.contact;
        int i2 = 0;
        int hashCode = (contact2 != null ? contact2.hashCode() : 0) * 31;
        List<ContactPhone> list = this.phones;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ContactWithPhones(contact=" + this.contact + ", phones=" + this.phones + ")";
    }

    public ContactWithPhones(Contact contact2, List<ContactPhone> list) {
        k.c(contact2, "contact");
        k.c(list, "phones");
        this.contact = contact2;
        this.phones = list;
    }

    public final Contact getContact() {
        return this.contact;
    }

    public final List<ContactPhone> getPhones() {
        return this.phones;
    }
}
