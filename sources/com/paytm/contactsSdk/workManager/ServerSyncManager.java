package com.paytm.contactsSdk.workManager;

import android.content.Context;
import androidx.work.a;
import androidx.work.c;
import androidx.work.f;
import androidx.work.impl.j;
import androidx.work.m;
import androidx.work.n;
import androidx.work.p;
import androidx.work.w;
import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.contactsSDKWorkManager.ContactsSDKWorkManager;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public final class ServerSyncManager {
    public static final ServerSyncManager INSTANCE = new ServerSyncManager();
    private static final String TAG = "ServerSyncManager";

    private ServerSyncManager() {
    }

    public final void sync(Context context) {
        k.c(context, "context");
        stopAllOneTimeWorkManagers(context);
        j b2 = j.b(context);
        k.a((Object) b2, "WorkManager.getInstance(context)");
        b2.a(ContactsSyncWorker.TAG, f.REPLACE, startAllPeriodicSync());
        b2.a(HealthApiWorker.TAG, f.KEEP, startHealthApiPeriodicSync());
    }

    private final p startHealthApiPeriodicSync() {
        w c2 = ((p.a) new p.a(HealthApiWorker.class, ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().healthApiInterval(), TimeUnit.MINUTES).a(HealthApiWorker.TAG)).c();
        k.a((Object) c2, "PeriodicWorkRequestBuild…\n                .build()");
        return (p) c2;
    }

    public final void syncContactsAsync(Context context) {
        k.c(context, "context");
        try {
            if (!ContactsSdk.INSTANCE.isContactsSDKLocalSyncEnabled$contacts_sdk_release()) {
                q.d("Local Sync Disabled");
            } else if (!ContactsSdk.INSTANCE.isContactsSDKRemoteSyncEnabled$contacts_sdk_release()) {
                q.d("Remote Sync Disabled");
            } else {
                stopAllOneTimeWorkManagers(context);
                j b2 = j.b(context);
                k.a((Object) b2, "WorkManager.getInstance(context)");
                b2.b((List<n>) Collections.singletonList(getDeleteContactsWorkerRequest())).a(getUploadNewContactsWorkerRequest()).a(getEnrichmentDataSyncWorkerRequest()).a();
            }
        } catch (Exception unused) {
        }
    }

    public final void syncContactsInLooperThread() {
        List arrayList = new ArrayList();
        arrayList.add(getDbSyncWorker());
        arrayList.add(getDeleteContactsWorkerRequest());
        arrayList.add(getUploadNewContactsWorkerRequest());
        ContactsSDKWorkManager.INSTANCE.enqueue((List<? extends w>) arrayList);
    }

    private final p startAllPeriodicSync() {
        w c2 = ((p.a) new p.a(ContactsSyncWorker.class, 15, TimeUnit.MINUTES).a(ContactsSyncWorker.TAG)).c();
        k.a((Object) c2, "PeriodicWorkRequestBuild…TAG)\n            .build()");
        return (p) c2;
    }

    private final n getDbSyncWorker() {
        w c2 = ((n.a) ((n.a) new n.a(DbSyncWorker.class).a(0, TimeUnit.SECONDS)).a(DbSyncWorker.TAG)).c();
        k.a((Object) c2, "OneTimeWorkRequest.Build…TAG)\n            .build()");
        return (n) c2;
    }

    private final n getDeleteContactsWorkerRequest() {
        c.a aVar = new c.a();
        aVar.f5083c = m.CONNECTED;
        c b2 = aVar.b();
        k.a((Object) b2, "Constraints.Builder()\n  …TED)\n            .build()");
        w c2 = ((n.a) ((n.a) ((n.a) ((n.a) new n.a(DeleteSyncWorker.class).a(b2)).a(0, TimeUnit.SECONDS)).a(DeleteSyncWorker.TAG)).a(a.EXPONENTIAL, (long) ContactsSdk.INSTANCE.getWorkManagerRetryInterval$contacts_sdk_release(), TimeUnit.SECONDS)).c();
        k.a((Object) c2, "OneTimeWorkRequest.Build…NDS)\n            .build()");
        return (n) c2;
    }

    private final n getUploadNewContactsWorkerRequest() {
        c.a aVar = new c.a();
        aVar.f5084d = true;
        aVar.f5083c = m.CONNECTED;
        c b2 = aVar.b();
        k.a((Object) b2, "Constraints.Builder()\n  …TED)\n            .build()");
        w c2 = ((n.a) ((n.a) ((n.a) new n.a(UploadNewContactsWorker.class).a(UploadNewContactsWorker.Companion.getTAG())).a(b2)).a(a.EXPONENTIAL, (long) ContactsSdk.INSTANCE.getWorkManagerRetryInterval$contacts_sdk_release(), TimeUnit.SECONDS)).c();
        k.a((Object) c2, "OneTimeWorkRequest.Build…NDS)\n            .build()");
        return (n) c2;
    }

    private final n getEnrichmentDataSyncWorkerRequest() {
        c.a aVar = new c.a();
        aVar.f5084d = true;
        aVar.f5083c = m.CONNECTED;
        c b2 = aVar.b();
        k.a((Object) b2, "Constraints.Builder()\n  …TED)\n            .build()");
        w c2 = ((n.a) ((n.a) ((n.a) new n.a(EnrichmentDataSyncWorker.class).a(EnrichmentDataSyncWorker.Companion.getTAG())).a(b2)).a(a.EXPONENTIAL, (long) ContactsSdk.INSTANCE.getWorkManagerRetryInterval$contacts_sdk_release(), TimeUnit.SECONDS)).c();
        k.a((Object) c2, "OneTimeWorkRequest.Build…NDS\n            ).build()");
        return (n) c2;
    }

    public final void stopAllWorkManagers(Context context) {
        k.c(context, "context");
        stopAllOneTimeWorkManagers(context);
        j b2 = j.b(context);
        k.a((Object) b2, "WorkManager.getInstance(context)");
        b2.b(ContactsSyncWorker.TAG);
        b2.b(HealthApiWorker.TAG);
    }

    public final void stopAllOneTimeWorkManagers(Context context) {
        k.c(context, "context");
        j b2 = j.b(context);
        k.a((Object) b2, "WorkManager.getInstance(context)");
        b2.a(DeleteSyncWorker.TAG);
        b2.a(UploadNewContactsWorker.Companion.getTAG());
        b2.a(EnrichmentDataSyncWorker.Companion.getTAG());
    }
}
