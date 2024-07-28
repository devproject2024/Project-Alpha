package net.one97.paytm.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.utils.r;

public final class a implements Application.ActivityLifecycleCallbacks {
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityStarted(Activity activity) {
        if (activity != null && !(activity instanceof AJRMainActivity)) {
            c.a(activity);
        }
    }

    public final void onActivityResumed(Activity activity) {
        r.b("active_module", activity.getLocalClassName());
        r.b("active_user", com.paytm.utility.a.a((Context) activity));
    }
}
