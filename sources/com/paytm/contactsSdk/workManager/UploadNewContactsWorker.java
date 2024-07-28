package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsConsent;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.api.p002enum.LocalContactSyncType;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.database.ContactsDatabase;
import com.paytm.contactsSdk.models.ContactWithPhones;
import com.paytm.contactsSdk.models.requests.PostContactRequest;
import com.paytm.contactsSdk.network.NetworkRequestHelper;
import com.paytm.contactsSdk.repo.ContactsRepo;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.a;
import com.paytm.utility.q;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class UploadNewContactsWorker extends Worker {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final String TAG;
    public CountDownLatch countDownLatch;
    private ListenableWorker.a workerResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadNewContactsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        ListenableWorker.a.b bVar = new ListenableWorker.a.b();
        k.a((Object) bVar, "Result.retry()");
        this.workerResult = bVar;
    }

    public final ListenableWorker.a getWorkerResult() {
        return this.workerResult;
    }

    public final void setWorkerResult(ListenableWorker.a aVar) {
        k.c(aVar, "<set-?>");
        this.workerResult = aVar;
    }

    public final CountDownLatch getCountDownLatch() {
        CountDownLatch countDownLatch2 = this.countDownLatch;
        if (countDownLatch2 == null) {
            k.a("countDownLatch");
        }
        return countDownLatch2;
    }

    public final void setCountDownLatch(CountDownLatch countDownLatch2) {
        k.c(countDownLatch2, "<set-?>");
        this.countDownLatch = countDownLatch2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getTAG() {
            return UploadNewContactsWorker.TAG;
        }
    }

    static {
        String simpleName = UploadNewContactsWorker.class.getSimpleName();
        k.a((Object) simpleName, "UploadNewContactsWorker::class.java.simpleName");
        TAG = simpleName;
    }

    public final ListenableWorker.a doWork() {
        q.d("Running " + TAG);
        if (!ContactsSdk.INSTANCE.isLoggedIn()) {
            q.d("User Not Logged-in!!!");
            ListenableWorker.a.C0076a aVar = new ListenableWorker.a.C0076a();
            k.a((Object) aVar, "Result.failure()");
            return aVar;
        } else if (!ContactsConsent.INSTANCE.checkLocalConsent()) {
            q.d("Consent not given.");
            ListenableWorker.a.c cVar = new ListenableWorker.a.c();
            k.a((Object) cVar, "Result.success()");
            return cVar;
        } else {
            q.d("Consent given.");
            if (!ContactsSdk.INSTANCE.isContactsSDKRemoteSyncEnabled$contacts_sdk_release()) {
                q.d("Remote Sync Disabled");
                ListenableWorker.a.c cVar2 = new ListenableWorker.a.c();
                k.a((Object) cVar2, "Result.success()");
                return cVar2;
            }
            q.d("Remote Sync Enabled");
            this.countDownLatch = new CountDownLatch(1);
            ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(true);
            ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.REMOTE_SYNC, getProgressPert(), getTotalSyncContacts());
            syncData();
            CountDownLatch countDownLatch2 = this.countDownLatch;
            if (countDownLatch2 == null) {
                k.a("countDownLatch");
            }
            countDownLatch2.await();
            Thread.sleep(100);
            ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(false);
            if (k.a((Object) this.workerResult, (Object) new ListenableWorker.a.C0076a())) {
                ContactUtil.INSTANCE.sendSyncStoppedMetaInfo$contacts_sdk_release();
            }
            return this.workerResult;
        }
    }

    /* access modifiers changed from: private */
    public final void syncData() {
        try {
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            List<ContactWithPhones> uploadContactList = getUploadContactList(applicationContext);
            if (!uploadContactList.isEmpty()) {
                NetworkRequestHelper networkRequestHelper = NetworkRequestHelper.INSTANCE;
                Context applicationContext2 = getApplicationContext();
                k.a((Object) applicationContext2, "applicationContext");
                PostContactRequest postContactRequest = networkRequestHelper.getaddContactAPIRequest(applicationContext2, uploadContactList);
                StringBuilder sb = new StringBuilder();
                sb.append(TAG);
                sb.append(" uploading");
                q.b(String.valueOf(uploadContactList));
                NetworkRequestHelper networkRequestHelper2 = NetworkRequestHelper.INSTANCE;
                Context applicationContext3 = getApplicationContext();
                k.a((Object) applicationContext3, "applicationContext");
                a addContactsNetworkCall = networkRequestHelper2.addContactsNetworkCall(applicationContext3, postContactRequest, new UploadNewContactsWorker$syncData$1(this, uploadContactList));
                if (addContactsNetworkCall != null) {
                    addContactsNetworkCall.a();
                    return;
                }
                return;
            }
            ListenableWorker.a.c cVar = new ListenableWorker.a.c();
            k.a((Object) cVar, "Result.success()");
            this.workerResult = cVar;
            CountDownLatch countDownLatch2 = this.countDownLatch;
            if (countDownLatch2 == null) {
                k.a("countDownLatch");
            }
            countDownLatch2.countDown();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            ListenableWorker.a.C0076a aVar = new ListenableWorker.a.C0076a();
            k.a((Object) aVar, "Result.failure()");
            this.workerResult = aVar;
            CountDownLatch countDownLatch3 = this.countDownLatch;
            if (countDownLatch3 == null) {
                k.a("countDownLatch");
            }
            countDownLatch3.countDown();
        }
    }

    private final List<ContactWithPhones> getUploadContactList(Context context) {
        return getUnsyncedContacts(context);
    }

    private final List<ContactWithPhones> getUnsyncedContacts(Context context) {
        return ContactsDatabase.Companion.getInstance(context).contactsDao().getContacts(LocalContactSyncType.SYNC_ADD_UPDATE.ordinal(), ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().uploadBatchSize());
    }

    /* access modifiers changed from: private */
    public final void changeContactsToSynced(Context context, List<ContactWithPhones> list) {
        ContactsDatabase instance = ContactsDatabase.Companion.getInstance(context);
        instance.contactsDao().updateContacts(ContactUtil.INSTANCE.getContactsFromContactPhoneWithSync$contacts_sdk_release(list, LocalContactSyncType.SYNC_NONE));
    }

    /* access modifiers changed from: private */
    public final double getProgressPert() {
        return ((((double) ContactsProvider.INSTANCE.getTotalContactsToSync$contacts_sdk_release()) - ((double) getTotalSyncContacts())) / ((double) ContactsProvider.INSTANCE.getTotalContactsToSync$contacts_sdk_release())) * 100.0d;
    }

    /* access modifiers changed from: private */
    public final int getTotalSyncContacts() {
        return new ContactsRepo().getRemoteContactsSyncCount();
    }
}
