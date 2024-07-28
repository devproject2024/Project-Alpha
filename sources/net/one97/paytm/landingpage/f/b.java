package net.one97.paytm.landingpage.f;

import android.app.Activity;
import android.os.AsyncTask;
import com.paytmmall.clpartifact.listeners.IHomeTraceListener;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;
import net.one97.paytm.landingpage.activity.AJRMainActivity;

public final class b implements IHomeTraceListener {
    public final void initH5(Activity activity) {
    }

    public final void logAppStartTimeHawkeye(Activity activity) {
        k.c(activity, "activity");
    }

    public final void stopAppClickToHomeRenderingTrace() {
    }

    public final void runAfterHomeSettle(Activity activity) {
        k.c(activity, "activity");
        if (activity instanceof AJRMainActivity) {
            com.paytm.utility.a.c();
            ((AJRMainActivity) activity).g();
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f52777a;

        a(Activity activity) {
            this.f52777a = activity;
        }

        public final void run() {
            d.b().a(this.f52777a);
        }
    }

    public final void stopMainActivityTrace(Activity activity) {
        k.c(activity, "activity");
        AsyncTask.SERIAL_EXECUTOR.execute(new a(activity));
    }
}
