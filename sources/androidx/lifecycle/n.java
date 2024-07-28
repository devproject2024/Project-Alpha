package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f3674a = new AtomicBoolean(false);

    static void a(Context context) {
        if (!f3674a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }

    static class a extends f {
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        a() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            ac.a(activity);
        }
    }
}
