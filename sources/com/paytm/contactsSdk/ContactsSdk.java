package com.paytm.contactsSdk;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.database.ContactChangeObserver;
import com.paytm.contactsSdk.manager.DatabaseManager;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.contactsSdk.workManager.ServerSyncManager;
import com.paytm.utility.q;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.ups.UpsSdk;

public final class ContactsSdk {
    public static final ContactsSdk INSTANCE = new ContactsSdk();
    private static Context appContext;
    public static ContactsSDKApplicationInterface contactsSDKApplicationInterface;
    /* access modifiers changed from: private */
    public static ContactChangeObserver contentObserver;
    private static boolean dbSyncInProgress;
    private static boolean isInitDone;
    private static boolean remoteSyncInProgress;
    private static boolean syncInProgress;

    private ContactsSdk() {
    }

    public static final /* synthetic */ ContactChangeObserver access$getContentObserver$p(ContactsSdk contactsSdk) {
        ContactChangeObserver contactChangeObserver = contentObserver;
        if (contactChangeObserver == null) {
            k.a("contentObserver");
        }
        return contactChangeObserver;
    }

    public final boolean getDbSyncInProgress$contacts_sdk_release() {
        return dbSyncInProgress;
    }

    public final void setDbSyncInProgress$contacts_sdk_release(boolean z) {
        dbSyncInProgress = z;
    }

    public final boolean getRemoteSyncInProgress$contacts_sdk_release() {
        return remoteSyncInProgress;
    }

    public final void setRemoteSyncInProgress$contacts_sdk_release(boolean z) {
        remoteSyncInProgress = z;
    }

    public final boolean getSyncInProgress$contacts_sdk_release() {
        return syncInProgress;
    }

    public final void setSyncInProgress$contacts_sdk_release(boolean z) {
        syncInProgress = z;
    }

    public final ContactsSDKApplicationInterface getContactsSDKApplicationInterface$contacts_sdk_release() {
        ContactsSDKApplicationInterface contactsSDKApplicationInterface2 = contactsSDKApplicationInterface;
        if (contactsSDKApplicationInterface2 == null) {
            k.a("contactsSDKApplicationInterface");
        }
        return contactsSDKApplicationInterface2;
    }

    public final void setContactsSDKApplicationInterface$contacts_sdk_release(ContactsSDKApplicationInterface contactsSDKApplicationInterface2) {
        k.c(contactsSDKApplicationInterface2, "<set-?>");
        contactsSDKApplicationInterface = contactsSDKApplicationInterface2;
    }

    public final boolean init(ContactsSDKApplicationInterface contactsSDKApplicationInterface2) {
        k.c(contactsSDKApplicationInterface2, "provider");
        getClass().getName();
        q.d("Contact SDK Initialization - START");
        boolean z = isInitDone;
        if (z) {
            return z;
        }
        appContext = contactsSDKApplicationInterface2.getApplicationContext();
        contactsSDKApplicationInterface = contactsSDKApplicationInterface2;
        DatabaseManager databaseManager = DatabaseManager.INSTANCE;
        Context context = appContext;
        if (context == null) {
            k.a("appContext");
        }
        databaseManager.initDatabase(context);
        UpsSdk.INSTANCE.initSDK(contactsSDKApplicationInterface2);
        isInitDone = true;
        getClass().getName();
        q.d("Contact SDK Initialization - COMPLETE");
        return isInitDone;
    }

    public final void startWorkerSync() {
        ServerSyncManager serverSyncManager = ServerSyncManager.INSTANCE;
        Context context = appContext;
        if (context == null) {
            k.a("appContext");
        }
        serverSyncManager.sync(context);
    }

    public final String getBaseURL$contacts_sdk_release() {
        ContactsSDKApplicationInterface contactsSDKApplicationInterface2 = contactsSDKApplicationInterface;
        if (contactsSDKApplicationInterface2 == null) {
            k.a("contactsSDKApplicationInterface");
        }
        return contactsSDKApplicationInterface2.getContactsSdkBaseURL();
    }

    public final int getWorkManagerRetryInterval$contacts_sdk_release() {
        ContactsSDKApplicationInterface contactsSDKApplicationInterface2 = contactsSDKApplicationInterface;
        if (contactsSDKApplicationInterface2 == null) {
            k.a("contactsSDKApplicationInterface");
        }
        return contactsSDKApplicationInterface2.getWorkManagerRetryInterval();
    }

    public final boolean initDone() {
        return isInitDone;
    }

    public final boolean isDbSyncInProgress$contacts_sdk_release() {
        return dbSyncInProgress;
    }

    public final synchronized boolean updateSyncInProgress$contacts_sdk_release() {
        if (syncInProgress) {
            return false;
        }
        syncInProgress = true;
        return true;
    }

    public final synchronized void resetSyncInProgress$contacts_sdk_release() {
        syncInProgress = false;
    }

    public final boolean isContactsSDKRemoteSyncEnabled$contacts_sdk_release() {
        ContactsSDKApplicationInterface contactsSDKApplicationInterface2 = contactsSDKApplicationInterface;
        if (contactsSDKApplicationInterface2 == null) {
            k.a("contactsSDKApplicationInterface");
        }
        return contactsSDKApplicationInterface2.isContactsSDKRemoteSyncEnabled();
    }

    public final boolean isContactsSDKLocalSyncEnabled$contacts_sdk_release() {
        ContactsSDKApplicationInterface contactsSDKApplicationInterface2 = contactsSDKApplicationInterface;
        if (contactsSDKApplicationInterface2 == null) {
            k.a("contactsSDKApplicationInterface");
        }
        return contactsSDKApplicationInterface2.isContactsSDKLocalSyncEnabled();
    }

    public final void onLogout() {
        unRegisterContactObserver();
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (f) null, (CoroutineStart) null, new ContactsSdk$onLogout$1((d) null), 3, (Object) null);
        ContactsProvider contactsProvider = ContactsProvider.INSTANCE;
        Context context = appContext;
        if (context == null) {
            k.a("appContext");
        }
        contactsProvider.onLogout$contacts_sdk_release(context);
        ContactUtil contactUtil = ContactUtil.INSTANCE;
        Context context2 = appContext;
        if (context2 == null) {
            k.a("appContext");
        }
        contactUtil.resetAllTimestamps$contacts_sdk_release(context2);
        if (isInitDone) {
            UpsSdk.INSTANCE.onLogout();
        }
    }

    public final boolean isLoggedIn() {
        return UpsSdk.INSTANCE.isLoggedIn();
    }

    public final void registerContactObserver$contacts_sdk_release() {
        if (contentObserver == null) {
            contentObserver = new ContactChangeObserver();
            Uri uri = ContactsContract.Contacts.CONTENT_URI;
            Context context = appContext;
            if (context == null) {
                k.a("appContext");
            }
            ContentResolver contentResolver = context.getContentResolver();
            ContactChangeObserver contactChangeObserver = contentObserver;
            if (contactChangeObserver == null) {
                k.a("contentObserver");
            }
            contentResolver.registerContentObserver(uri, true, contactChangeObserver);
            getClass().getName();
            q.d("ContactChangeObserver Initialized");
        }
    }

    private final void unRegisterContactObserver() {
        if (contentObserver != null) {
            Context context = appContext;
            if (context == null) {
                k.a("appContext");
            }
            ContentResolver contentResolver = context.getContentResolver();
            ContactChangeObserver contactChangeObserver = contentObserver;
            if (contactChangeObserver == null) {
                k.a("contentObserver");
            }
            contentResolver.unregisterContentObserver(contactChangeObserver);
        }
    }
}
