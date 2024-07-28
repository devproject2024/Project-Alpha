package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.api.ContactsConsent;
import com.paytm.contactsSdk.api.p002enum.HealthActionType;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.models.requests.HealthContactDetailReq;
import com.paytm.contactsSdk.models.requests.HealthRequest;
import com.paytm.contactsSdk.network.ContactEnrichmentManager;
import com.paytm.contactsSdk.network.NetworkRequestHelper;
import com.paytm.contactsSdk.utils.ContactUtil;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.ups.UpsSdk;

public final class HealthApiWorker extends Worker {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "HealthApiWorker";
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public volatile CountDownLatch latch;
    /* access modifiers changed from: private */
    public ListenableWorker.a workResult;
    private final WorkerParameters workerParams;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HealthActionType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[HealthActionType.DELTA.ordinal()] = 1;
            $EnumSwitchMapping$0[HealthActionType.RE_SYNC.ordinal()] = 2;
        }
    }

    public static final /* synthetic */ CountDownLatch access$getLatch$p(HealthApiWorker healthApiWorker) {
        CountDownLatch countDownLatch = healthApiWorker.latch;
        if (countDownLatch == null) {
            k.a("latch");
        }
        return countDownLatch;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HealthApiWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        k.c(context2, "context");
        k.c(workerParameters, "workerParams");
        this.context = context2;
        this.workerParams = workerParameters;
        ListenableWorker.a.C0076a aVar = new ListenableWorker.a.C0076a();
        k.a((Object) aVar, "Result.failure()");
        this.workResult = aVar;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final ListenableWorker.a doWork() {
        q.b("running===" + this.workerParams.f5044c.toString());
        UpsSdk.INSTANCE.initSDK(ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release());
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
            if (!checkForLastHealthSync(this.context)) {
                q.b("last timestamp check failed===");
                ListenableWorker.a.c cVar3 = new ListenableWorker.a.c();
                k.a((Object) cVar3, "Result.success()");
                this.workResult = cVar3;
                return this.workResult;
            }
            q.b("last timestamp check passed===");
            try {
                this.latch = new CountDownLatch(1);
                q.b("CountDownLatch(1)");
                healthApi();
                q.b("healthApi");
                CountDownLatch countDownLatch = this.latch;
                if (countDownLatch == null) {
                    k.a("latch");
                }
                countDownLatch.await();
                q.b("latch.await()");
            } catch (Exception e2) {
                q.b("exception=" + e2.getMessage());
                this.workResult = ContactUtil.getSyncWorkerErrorResult$contacts_sdk_release$default(ContactUtil.INSTANCE, this, (Integer) null, (NetworkCustomError) null, 6, (Object) null);
            }
            return this.workResult;
        }
    }

    private final boolean checkForLastHealthSync(Context context2) {
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        return instance.getTimeInMillis() - ContactUtil.INSTANCE.getLastHealthApiTimestamp$contacts_sdk_release(context2) >= getHealthApiThreshold();
    }

    private final long getHealthApiThreshold() {
        return ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().healthApiInterval() * 60 * 1000;
    }

    private final void healthApi() {
        q.b("healthApi_call");
        String A = b.A(this.context);
        HealthContactDetailReq healthContactDetailReq = new HealthContactDetailReq(ContactsConstant.CONTACT_TYPE_VALUE, 0, 0, ContactEnrichmentManager.INSTANCE.getLastEnrichmentDataSyncedTimeStamp(this.context));
        k.a((Object) A, "deviceID");
        a healthAPINetworkCall = NetworkRequestHelper.INSTANCE.healthAPINetworkCall(this.context, new HealthRequest(A, healthContactDetailReq), new HealthApiWorker$healthApi$1(this));
        if (healthAPINetworkCall != null) {
            healthAPINetworkCall.a();
        }
    }
}
