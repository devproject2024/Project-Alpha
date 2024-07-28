package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import kotlin.g.a.q;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.k.d;
import kotlin.x;

final /* synthetic */ class ContactsProvider$checkConsent$1 extends i implements q<Boolean, ContactsQueryCallback, ContactsQuery, x> {
    ContactsProvider$checkConsent$1(ContactsProvider contactsProvider) {
        super(3, contactsProvider);
    }

    public final String getName() {
        return "onConsentResultAvailable";
    }

    public final d getOwner() {
        return y.b(ContactsProvider.class);
    }

    public final String getSignature() {
        return "onConsentResultAvailable(ZLcom/paytm/contactsSdk/api/callback/ContactsQueryCallback;Lcom/paytm/contactsSdk/api/query/ContactsQuery;)V";
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (ContactsQueryCallback) obj2, (ContactsQuery) obj3);
        return x.f47997a;
    }

    public final void invoke(boolean z, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        k.c(contactsQueryCallback, "p2");
        k.c(contactsQuery, "p3");
        ((ContactsProvider) this.receiver).onConsentResultAvailable(z, contactsQueryCallback, contactsQuery);
    }
}
