package com.paytm.contactsSdk;

import com.paytm.contactsSdk.database.ContactChangeObserver;
import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;

final /* synthetic */ class ContactsSdk$unRegisterContactObserver$1 extends n {
    ContactsSdk$unRegisterContactObserver$1(ContactsSdk contactsSdk) {
        super(contactsSdk);
    }

    public final String getName() {
        return "contentObserver";
    }

    public final d getOwner() {
        return y.b(ContactsSdk.class);
    }

    public final String getSignature() {
        return "getContentObserver()Lcom/paytm/contactsSdk/database/ContactChangeObserver;";
    }

    public final Object get() {
        return ContactsSdk.access$getContentObserver$p((ContactsSdk) this.receiver);
    }

    public final void set(Object obj) {
        ContactsSdk.contentObserver = (ContactChangeObserver) obj;
    }
}
