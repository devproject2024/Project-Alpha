package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.a.c;
import androidx.work.impl.a.d;
import androidx.work.impl.b.p;
import androidx.work.impl.j;
import androidx.work.l;
import com.google.b.a.a.a;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final String f5493f = l.a("ConstraintTrkngWrkr");

    /* renamed from: a  reason: collision with root package name */
    WorkerParameters f5494a;

    /* renamed from: b  reason: collision with root package name */
    final Object f5495b = new Object();

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f5496c = false;

    /* renamed from: d  reason: collision with root package name */
    androidx.work.impl.utils.a.c<ListenableWorker.a> f5497d = androidx.work.impl.utils.a.c.a();

    /* renamed from: e  reason: collision with root package name */
    ListenableWorker f5498e;

    public final void a(List<String> list) {
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f5494a = workerParameters;
    }

    public a<ListenableWorker.a> startWork() {
        getBackgroundExecutor().execute(new Runnable() {
            public final void run() {
                ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
                String a2 = constraintTrackingWorker.getInputData().a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                if (TextUtils.isEmpty(a2)) {
                    l.a();
                    constraintTrackingWorker.a();
                    return;
                }
                constraintTrackingWorker.f5498e = constraintTrackingWorker.getWorkerFactory().a(constraintTrackingWorker.getApplicationContext(), a2, constraintTrackingWorker.f5494a);
                if (constraintTrackingWorker.f5498e == null) {
                    l.a();
                    constraintTrackingWorker.a();
                    return;
                }
                p b2 = j.b(constraintTrackingWorker.getApplicationContext()).f5361c.b().b(constraintTrackingWorker.getId().toString());
                if (b2 == null) {
                    constraintTrackingWorker.a();
                    return;
                }
                d dVar = new d(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                dVar.a((Iterable<p>) Collections.singletonList(b2));
                if (dVar.a(constraintTrackingWorker.getId().toString())) {
                    l.a();
                    String.format("Constraints met for delegate %s", new Object[]{a2});
                    try {
                        a<ListenableWorker.a> startWork = constraintTrackingWorker.f5498e.startWork();
                        startWork.a(new Runnable(startWork) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f5500a;

                            {
                                this.f5500a = r2;
                            }

                            public final void run() {
                                synchronized (ConstraintTrackingWorker.this.f5495b) {
                                    if (ConstraintTrackingWorker.this.f5496c) {
                                        ConstraintTrackingWorker.this.b();
                                    } else {
                                        ConstraintTrackingWorker.this.f5497d.a(this.f5500a);
                                    }
                                }
                            }
                        }, constraintTrackingWorker.getBackgroundExecutor());
                    } catch (Throwable th) {
                        l.a();
                        String.format("Delegated worker %s threw exception in startWork.", new Object[]{a2});
                        new Throwable[1][0] = th;
                        synchronized (constraintTrackingWorker.f5495b) {
                            if (constraintTrackingWorker.f5496c) {
                                l.a();
                                constraintTrackingWorker.b();
                            } else {
                                constraintTrackingWorker.a();
                            }
                        }
                    }
                } else {
                    l.a();
                    String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{a2});
                    constraintTrackingWorker.b();
                }
            }
        });
        return this.f5497d;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f5497d.a(new ListenableWorker.a.C0076a());
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f5497d.a(new ListenableWorker.a.b());
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f5498e;
        if (listenableWorker != null) {
            listenableWorker.stop();
        }
    }

    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.f5498e;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    public androidx.work.impl.utils.b.a getTaskExecutor() {
        return j.b(getApplicationContext()).f5362d;
    }

    public final void b(List<String> list) {
        l.a();
        String.format("Constraints changed for %s", new Object[]{list});
        synchronized (this.f5495b) {
            this.f5496c = true;
        }
    }
}
