package net.one97.paytm.contacts.sync;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.k;
import net.one97.paytm.contacts.sync.i;

public final class SyncAndSavePayeeDataWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50156a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static String f50157c = "SyncAndSavePayeeDataWorker";

    /* renamed from: b  reason: collision with root package name */
    private Context f50158b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncAndSavePayeeDataWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f50158b = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final ListenableWorker.a doWork() {
        try {
            i.a aVar = i.f50213c;
            i a2 = i.a.a();
            a2.f50215a = new CountDownLatch(1);
            CountDownLatch countDownLatch = a2.f50215a;
            if (countDownLatch == null) {
                k.a("cdLatch");
            }
            countDownLatch.await();
            ListenableWorker.a aVar2 = a2.f50216b;
            if (aVar2 != null) {
                return aVar2;
            }
            k.a();
            return aVar2;
        } catch (InterruptedException unused) {
            ListenableWorker.a c2 = ListenableWorker.a.c();
            k.a((Object) c2, "Result.failure()");
            return c2;
        } catch (Throwable unused2) {
            ListenableWorker.a c3 = ListenableWorker.a.c();
            k.a((Object) c3, "Result.failure()");
            return c3;
        }
    }
}
