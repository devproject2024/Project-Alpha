package com.paytm.contactsSdk.database;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.api.callback.ContactsSDKMetaInfoCallback;

public final class ContactChangeObserver extends ContentObserver {
    public ContactChangeObserver() {
        super((Handler) null);
    }

    public final void onChange(boolean z, Uri uri) {
        super.onChange(z, uri);
        StringBuilder sb = new StringBuilder("OncontactChanged self change ");
        sb.append(z);
        sb.append(" ur ");
        sb.append(uri);
        if (!ContactsSdk.INSTANCE.isDbSyncInProgress$contacts_sdk_release()) {
            ContactsProvider.INSTANCE.forceSync((ContactsSDKMetaInfoCallback) null);
        }
    }
}
