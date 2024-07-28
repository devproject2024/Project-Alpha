package com.google.android.gms.internal.firebase_ml;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import com.google.firebase.ml.common.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class dl implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f9804a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static dl f9805b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f9806c;

    public static Executor a() {
        return dn.INSTANCE;
    }

    public static dl b() {
        dl dlVar;
        synchronized (f9804a) {
            if (f9805b == null) {
                HandlerThread handlerThread = new HandlerThread("FirebaseMLHandler", 9);
                handlerThread.start();
                f9805b = new dl(handlerThread.getLooper());
            }
            dlVar = f9805b;
        }
        return dlVar;
    }

    private dl(Looper looper) {
        this.f9806c = new aj(looper, this);
    }

    public final <ResultT> Task<ResultT> a(Callable<ResultT> callable) {
        f fVar = new f();
        this.f9806c.post(new dk(callable, fVar));
        return fVar.f12478a;
    }

    public final <ResultT> void a(Callable<ResultT> callable, long j) {
        Handler handler = this.f9806c;
        handler.sendMessageDelayed(handler.obtainMessage(1, callable), j);
    }

    public final <ResultT> void b(Callable<ResultT> callable) {
        this.f9806c.removeMessages(1, callable);
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            try {
                ((Callable) message.obj).call();
            } catch (Exception unused) {
            }
        }
        return true;
    }

    static final /* synthetic */ void a(Callable callable, f fVar) {
        try {
            fVar.a(callable.call());
        } catch (a e2) {
            fVar.a((Exception) e2);
        } catch (Exception e3) {
            fVar.a((Exception) new a("Internal error has occurred when executing Firebase ML tasks", 13, e3));
        }
    }
}
