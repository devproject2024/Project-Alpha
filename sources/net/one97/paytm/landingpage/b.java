package net.one97.paytm.landingpage;

import android.content.Context;
import android.os.AsyncTask;
import com.paytmmall.clpartifact.utils.HomeUtils;

public final class b {
    public final void a(final Context context) {
        if (a.a().b() == null) {
            a.a().a(true);
            HomeUtils.d("loadHomeData >> homeResponse is null", false);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public final void run() {
                    a.a().a(HomeUtils.getPreWarmResponse(context));
                    a.a().a(false);
                }
            });
        }
    }
}
