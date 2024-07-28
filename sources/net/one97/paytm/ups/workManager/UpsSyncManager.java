package net.one97.paytm.ups.workManager;

import android.app.Application;
import android.content.Context;
import androidx.work.a;
import androidx.work.c;
import androidx.work.g;
import androidx.work.impl.j;
import androidx.work.m;
import androidx.work.n;
import androidx.work.w;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.ups.UpsSdk;

public final class UpsSyncManager {
    public static final UpsSyncManager INSTANCE = new UpsSyncManager();
    private static final long backoffDelay = 1;
    private static final String workTag = "UPS_SYNCING_WORK_MANAGER";

    private UpsSyncManager() {
    }

    public final void syncLocalConsentToServer() {
        Application applicationContext;
        if (UpsSdk.INSTANCE.isLoggedIn() && (applicationContext = UpsSdk.INSTANCE.getApplicationContext()) != null) {
            c.a aVar = new c.a();
            aVar.f5083c = m.CONNECTED;
            c b2 = aVar.b();
            k.a((Object) b2, "Constraints.Builder()\n  …                 .build()");
            w c2 = ((n.a) ((n.a) ((n.a) ((n.a) new n.a(UpsSyncWorker.class).a(b2)).a(2, TimeUnit.SECONDS)).a(workTag)).a(a.EXPONENTIAL, 1, TimeUnit.MINUTES)).c();
            k.a((Object) c2, "OneTimeWorkRequest.Build…                 .build()");
            j b3 = j.b((Context) applicationContext);
            k.a((Object) b3, "WorkManager.getInstance(it)");
            b3.a(workTag);
            b3.a(workTag, g.REPLACE, (n) c2);
        }
    }
}
