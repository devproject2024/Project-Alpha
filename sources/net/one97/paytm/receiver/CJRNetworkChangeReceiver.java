package net.one97.paytm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import net.one97.paytm.f.a;

public class CJRNetworkChangeReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, Intent intent) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                a.a().f50397d = com.paytm.utility.a.r(context);
            }
        });
    }
}
