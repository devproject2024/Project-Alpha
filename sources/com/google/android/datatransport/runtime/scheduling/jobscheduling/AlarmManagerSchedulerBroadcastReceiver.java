package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.e.a;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.q;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    static /* synthetic */ void a() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        q.a(context);
        l.a a2 = l.d().a(queryParameter).a(a.a(intValue));
        if (queryParameter2 != null) {
            a2.a(Base64.decode(queryParameter2, 0));
        }
        q.a().f7801a.a(a2.a(), i2, b.a());
    }
}
