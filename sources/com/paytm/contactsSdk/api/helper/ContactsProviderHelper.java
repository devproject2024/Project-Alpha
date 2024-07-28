package com.paytm.contactsSdk.api.helper;

import com.paytm.contactsSdk.api.callback.ContactsQueryCallback;
import com.paytm.contactsSdk.api.callback.ContactsSDKMetaInfoCallback;
import com.paytm.contactsSdk.api.query.ContactsQuery;
import net.one97.paytm.ups.listener.UpdateConsentListener;

public interface ContactsProviderHelper {
    void fetchContacts(ContactsQueryCallback contactsQueryCallback, ContactsQuery contactsQuery);

    void forceSync(ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback);

    void registerContactSyncMetaInfoCallback(ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback);

    void updateConsent(boolean z, UpdateConsentListener updateConsentListener);
}
