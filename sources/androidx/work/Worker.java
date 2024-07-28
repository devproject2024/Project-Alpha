package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.a.c;
import com.google.b.a.a.a;

public abstract class Worker extends ListenableWorker {
    c<ListenableWorker.a> mFuture;

    public abstract ListenableWorker.a doWork();

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public final a<ListenableWorker.a> startWork() {
        this.mFuture = c.a();
        getBackgroundExecutor().execute(new Runnable() {
            public final void run() {
                try {
                    Worker.this.mFuture.a(Worker.this.doWork());
                } catch (Throwable th) {
                    Worker.this.mFuture.a(th);
                }
            }
        });
        return this.mFuture;
    }
}
