package net.one97.paytm.ups.workManager;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.ups.UpsSdk;
import net.one97.paytm.ups.db.ConsentItem;
import net.one97.paytm.ups.db.UpsDao;
import net.one97.paytm.ups.manager.DatabaseManager;

public final class UpsSyncWorker extends Worker {
    /* access modifiers changed from: private */
    public final UpsSyncWorker$consentUpdateListener$1 consentUpdateListener = new UpsSyncWorker$consentUpdateListener$1(this);
    private final Context context;
    public volatile CountDownLatch latch;
    private ListenableWorker.a result;
    private final WorkerParameters workerParameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpsSyncWorker(Context context2, WorkerParameters workerParameters2) {
        super(context2, workerParameters2);
        k.c(context2, "context");
        k.c(workerParameters2, "workerParameters");
        this.context = context2;
        this.workerParameters = workerParameters2;
    }

    public final CountDownLatch getLatch() {
        CountDownLatch countDownLatch = this.latch;
        if (countDownLatch == null) {
            k.a("latch");
        }
        return countDownLatch;
    }

    public final void setLatch(CountDownLatch countDownLatch) {
        k.c(countDownLatch, "<set-?>");
        this.latch = countDownLatch;
    }

    public final ListenableWorker.a getResult() {
        return this.result;
    }

    public final void setResult(ListenableWorker.a aVar) {
        this.result = aVar;
    }

    public final ListenableWorker.a doWork() {
        if (!UpsSdk.INSTANCE.isLoggedIn()) {
            ListenableWorker.a.c cVar = new ListenableWorker.a.c();
            k.a((Object) cVar, "Result.success()");
            return cVar;
        }
        try {
            List consentNeededToSyncWithServer$default = UpsDao.DefaultImpls.getConsentNeededToSyncWithServer$default(DatabaseManager.INSTANCE.getDatabase().getUpsDao(), false, 1, (Object) null);
            if (consentNeededToSyncWithServer$default.isEmpty()) {
                ListenableWorker.a.c cVar2 = new ListenableWorker.a.c();
                k.a((Object) cVar2, "Result.success()");
                return cVar2;
            }
            this.latch = new CountDownLatch(1);
            syncConsentToServer((ConsentItem) consentNeededToSyncWithServer$default.get(0));
            CountDownLatch countDownLatch = this.latch;
            if (countDownLatch == null) {
                k.a("latch");
            }
            countDownLatch.await();
            ListenableWorker.a aVar = this.result;
            if (aVar == null) {
                k.a();
            }
            return aVar;
        } catch (Exception unused) {
            ListenableWorker.a.C0076a aVar2 = new ListenableWorker.a.C0076a();
            k.a((Object) aVar2, "Result.failure()");
            return aVar2;
        }
    }

    private final void syncConsentToServer(ConsentItem consentItem) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new UpsSyncWorker$syncConsentToServer$1(this, consentItem, (d) null), 2, (Object) null);
    }
}
