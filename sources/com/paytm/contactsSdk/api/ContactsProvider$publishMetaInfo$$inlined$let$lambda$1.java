package com.paytm.contactsSdk.api;

import com.paytm.contactsSdk.api.callback.ContactsSDKMetaInfoCallback;
import com.paytm.contactsSdk.api.model.ContactsSDKMetaInfo;

final class ContactsProvider$publishMetaInfo$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ ContactsSDKMetaInfoCallback $it;
    final /* synthetic */ ContactsSDKMetaInfo $metaInfo$inlined;

    ContactsProvider$publishMetaInfo$$inlined$let$lambda$1(ContactsSDKMetaInfoCallback contactsSDKMetaInfoCallback, ContactsSDKMetaInfo contactsSDKMetaInfo) {
        this.$it = contactsSDKMetaInfoCallback;
        this.$metaInfo$inlined = contactsSDKMetaInfo;
    }

    public final void run() {
        this.$it.onMetaInfoAvailable(this.$metaInfo$inlined);
    }
}
