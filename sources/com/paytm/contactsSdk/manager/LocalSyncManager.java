package com.paytm.contactsSdk.manager;

import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsConsent;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.manager.helper.LocalSyncManagerHelper;
import com.paytm.contactsSdk.repo.ContactsRepo;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.utility.q;

public final class LocalSyncManager implements LocalSyncManagerHelper {
    public static final LocalSyncManager INSTANCE = new LocalSyncManager();
    private static final ContactsRepo contactsRepo = new ContactsRepo();

    private LocalSyncManager() {
    }

    public final void localDbSync() {
        if (ContactsSdk.INSTANCE.isContactsSDKLocalSyncEnabled$contacts_sdk_release()) {
            q.d("Local Sync Enabled");
            ContactsConsent.INSTANCE.checkLocalConsent();
            ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.LOCAL_SYNC, 0.0d, 0);
            ContactsSdk.INSTANCE.setDbSyncInProgress$contacts_sdk_release(true);
            contactsRepo.copyContactsFromContactsProviderToLocalDb(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getApplicationContext());
            ContactsSdk.INSTANCE.setDbSyncInProgress$contacts_sdk_release(false);
            ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.LOCAL_SYNC, 100.0d, 0);
            return;
        }
        q.d("Local Sync Disabled");
    }
}
