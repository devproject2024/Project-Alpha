package com.paytm.contactsSdk.api.callback;

import com.paytm.contactsSdk.api.model.ContactsSDKMetaInfo;

public interface ContactsSDKMetaInfoCallback {
    void onMetaInfoAvailable(ContactsSDKMetaInfo contactsSDKMetaInfo);
}
