package net.one97.paytm.fastscanner.b;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.k;

public class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public CountDownLatch f50422a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(HandlerThread handlerThread) {
        super(handlerThread.getLooper());
        k.c(handlerThread, "handlerThread");
    }

    public final CountDownLatch a() {
        CountDownLatch countDownLatch = this.f50422a;
        if (countDownLatch == null) {
            k.a("exceptionCountDownLatch");
        }
        return countDownLatch;
    }

    public static net.one97.paytm.fastscanner.a b() {
        d dVar = d.f50426a;
        return d.b();
    }
}
