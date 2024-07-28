package net.one97.paytm.activity;

import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import net.one97.paytm.base.activity.PaytmVariantActivity;

public class PaytmActivity extends PaytmVariantActivity {
    private Trace activityLoadTrace = a.b("paytm_activity_trace");

    public PaytmActivity() {
        a.a();
        Trace trace = this.activityLoadTrace;
        if (trace != null) {
            trace.putAttribute("activity_trace", getClass().getSimpleName());
        }
        Trace trace2 = this.activityLoadTrace;
        if (trace2 != null) {
            trace2.start();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        stopActivityTrace();
    }

    private final void stopActivityTrace() {
        Trace trace = this.activityLoadTrace;
        if (trace != null) {
            trace.stop();
        }
        this.activityLoadTrace = null;
    }
}
