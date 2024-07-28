package com.paytm.contactsSdk.api.helper;

import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import kotlin.g.a.q;
import kotlin.x;

public interface ContactsConsentHelper {
    boolean checkLocalConsent();

    void getConsentFromLocalDB(q<? super Boolean, ? super ContactsQueryCallback, ? super ContactsQuery, x> qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery);

    void getConsentFromLocalDBThenServer(q<? super Boolean, ? super ContactsQueryCallback, ? super ContactsQuery, x> qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery);

    void getConsentFromServer(q<? super Boolean, ? super ContactsQueryCallback, ? super ContactsQuery, x> qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery);
}
