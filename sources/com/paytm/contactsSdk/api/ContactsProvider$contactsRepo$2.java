package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.repo.ContactsRepo;
import kotlin.g.a.a;
import kotlin.g.b.l;

final class ContactsProvider$contactsRepo$2 extends l implements a<ContactsRepo> {
    public static final ContactsProvider$contactsRepo$2 INSTANCE = new ContactsProvider$contactsRepo$2();

    ContactsProvider$contactsRepo$2() {
        super(0);
    }

    public final ContactsRepo invoke() {
        return new ContactsRepo();
    }
}
