package com.paytm.contactsSdk.contactsSDKWorkManager.workerParameters;

import android.content.Context;
import androidx.work.e;
import androidx.work.impl.utils.a.c;
import androidx.work.q;
import com.google.b.a.a.a;
import com.google.gson.f;
import com.paytm.contactsSdk.api.ContactsProvider;
import java.util.UUID;
import kotlin.g.b.k;

public final class ContactsSDKProgressUpdater implements q {
    public final a<Void> updateProgress(Context context, UUID uuid, e eVar) {
        k.c(context, "context");
        k.c(uuid, "id");
        k.c(eVar, "data");
        com.paytm.utility.q.d(new f().b(eVar));
        ContactsProvider.INSTANCE.postProgressUpdateFromLooperThread$contacts_sdk_release(eVar);
        c a2 = c.a();
        k.a((Object) a2, "SettableFuture.create()");
        return a2;
    }
}
