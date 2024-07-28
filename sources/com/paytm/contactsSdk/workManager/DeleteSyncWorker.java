package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsConsent;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.contactsSdk.api.p002enum.SyncStage;
import com.paytm.contactsSdk.models.network.DeleteContactRequest;
import com.paytm.contactsSdk.network.NetworkRequestHelper;
import com.paytm.contactsSdk.repo.ContactsRepo;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.ab;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class DeleteSyncWorker extends Worker {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "ContactDeleteSyncWorker";
    private final ContactsRepo contactsRepo = new ContactsRepo();
    private final Context context;
    private List<Integer> deletedContacts = new ArrayList();
    /* access modifiers changed from: private */
    public volatile CountDownLatch latch;
    /* access modifiers changed from: private */
    public ListenableWorker.a workResult;
    private final WorkerParameters workerParameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteSyncWorker(Context context2, WorkerParameters workerParameters2) {
        super(context2, workerParameters2);
        k.c(context2, "context");
        k.c(workerParameters2, "workerParameters");
        this.context = context2;
        this.workerParameters = workerParameters2;
        ListenableWorker.a.C0076a aVar = new ListenableWorker.a.C0076a();
        k.a((Object) aVar, "Result.failure()");
        this.workResult = aVar;
    }

    public static final /* synthetic */ CountDownLatch access$getLatch$p(DeleteSyncWorker deleteSyncWorker) {
        CountDownLatch countDownLatch = deleteSyncWorker.latch;
        if (countDownLatch == null) {
            k.a("latch");
        }
        return countDownLatch;
    }

    public final List<Integer> getDeletedContacts() {
        return this.deletedContacts;
    }

    public final void setDeletedContacts(List<Integer> list) {
        k.c(list, "<set-?>");
        this.deletedContacts = list;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final ContactsRepo getContactsRepo() {
        return this.contactsRepo;
    }

    public final ListenableWorker.a doWork() {
        q.d("Running ContactDeleteSyncWorker");
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
            UploadNewContactsWorker.Companion.getTAG();
            q.d("Remote Sync Enabled");
            ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(true);
            List<Integer> deleteContactFromLocalWithLimit = this.contactsRepo.getDeleteContactFromLocalWithLimit(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().uploadBatchSize());
            if (deleteContactFromLocalWithLimit != null) {
                this.deletedContacts = ab.c(deleteContactFromLocalWithLimit);
                ContactsProvider.INSTANCE.setTotalContactsToSync$contacts_sdk_release(this.contactsRepo.getRemoteContactsSyncCount());
                if (ContactsProvider.INSTANCE.getTotalContactsToSync$contacts_sdk_release() == 0) {
                    ContactsProvider.INSTANCE.setTotalContactsToSync$contacts_sdk_release(1);
                }
                if (this.deletedContacts.isEmpty()) {
                    ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(false);
                    ListenableWorker.a.c cVar3 = new ListenableWorker.a.c();
                    k.a((Object) cVar3, "Result.success()");
                    return cVar3;
                }
                try {
                    new StringBuilder("Making API call to delete these contacts = ").append(this.deletedContacts);
                    this.latch = new CountDownLatch(1);
                    ContactUtil.INSTANCE.sendMetaInfo$contacts_sdk_release(SyncStage.REMOTE_SYNC, getProgressPercent(), getTotalSyncContacts());
                    updateDeletedContacts();
                    CountDownLatch countDownLatch = this.latch;
                    if (countDownLatch == null) {
                        k.a("latch");
                    }
                    countDownLatch.await();
                    ContactsSdk.INSTANCE.setRemoteSyncInProgress$contacts_sdk_release(false);
                    if (k.a((Object) this.workResult, (Object) new ListenableWorker.a.C0076a())) {
                        ContactUtil.INSTANCE.sendSyncStoppedMetaInfo$contacts_sdk_release();
                    }
                    return this.workResult;
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                    return ContactUtil.getSyncWorkerErrorResult$contacts_sdk_release$default(ContactUtil.INSTANCE, this, (Integer) null, (NetworkCustomError) null, 6, (Object) null);
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Int>");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateDeletedContacts() {
        NetworkRequestHelper.INSTANCE.deleteContactsNetworkCall(this.context, new DeleteContactRequest(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().getDeviceId(), (String) null, this.deletedContacts, 2, (g) null), new DeleteSyncWorker$updateDeletedContacts$1(this));
    }

    /* access modifiers changed from: private */
    public final double getProgressPercent() {
        return ((((double) ContactsProvider.INSTANCE.getTotalContactsToSync$contacts_sdk_release()) - ((double) getTotalSyncContacts())) / ((double) ContactsProvider.INSTANCE.getTotalContactsToSync$contacts_sdk_release())) * 100.0d;
    }

    /* access modifiers changed from: private */
    public final int getTotalSyncContacts() {
        return new ContactsRepo().getRemoteContactsSyncCount();
    }
}
