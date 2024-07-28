package com.paytm.contactsSdk.contactsSDKWorkManager;

import com.paytm.contactsSdk.contactsSDKWorkManager.ContactsSDKWorkManagerImpl;
import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;

final /* synthetic */ class ContactsSDKWorkManagerImpl$sendMessage$2 extends n {
    ContactsSDKWorkManagerImpl$sendMessage$2(ContactsSDKWorkManagerImpl contactsSDKWorkManagerImpl) {
        super(contactsSDKWorkManagerImpl);
    }

    public final String getName() {
        return "contactsSDKWorkManagerHandler";
    }

    public final d getOwner() {
        return y.b(ContactsSDKWorkManagerImpl.class);
    }

    public final String getSignature() {
        return "getContactsSDKWorkManagerHandler()Lcom/paytm/contactsSdk/contactsSDKWorkManager/ContactsSDKWorkManagerImpl$ContactsSDKWorkManagerHandler;";
    }

    public final Object get() {
        return ContactsSDKWorkManagerImpl.access$getContactsSDKWorkManagerHandler$p((ContactsSDKWorkManagerImpl) this.receiver);
    }

    public final void set(Object obj) {
        ((ContactsSDKWorkManagerImpl) this.receiver).contactsSDKWorkManagerHandler = (ContactsSDKWorkManagerImpl.ContactsSDKWorkManagerHandler) obj;
    }
}
