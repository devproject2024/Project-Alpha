package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import com.paytm.contactsSdk.constant.ContactsConstant;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.k;
import net.one97.paytm.ups.listener.GetConsentListener;

public final class ContactsConsent$getConsentFromServer$1 implements GetConsentListener {
    final /* synthetic */ ContactsQuery $contactsQuery;
    final /* synthetic */ ContactsQueryCallback $contactsQueryCallback;
    final /* synthetic */ q $onConsentResultAvailable;

    ContactsConsent$getConsentFromServer$1(q qVar, ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery) {
        this.$onConsentResultAvailable = qVar;
        this.$contactsQueryCallback = contactsQueryCallback;
        this.$contactsQuery = contactsQuery;
    }

    public final void onGetConsent(boolean z, Map<String, Boolean> map) {
        k.c(map, "consentMap");
        if (map.containsKey(ContactsConstant.CONTACTS_CONSENT_KEY)) {
            q qVar = this.$onConsentResultAvailable;
            Boolean bool = map.get(ContactsConstant.CONTACTS_CONSENT_KEY);
            if (bool != null) {
                qVar.invoke(Boolean.valueOf(bool.booleanValue()), this.$contactsQueryCallback, this.$contactsQuery);
                return;
            }
            throw new IllegalStateException("".toString());
        }
    }
}
