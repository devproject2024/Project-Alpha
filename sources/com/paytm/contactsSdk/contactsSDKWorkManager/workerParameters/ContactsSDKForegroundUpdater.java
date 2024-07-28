package com.paytm.contactsSdk.contactsSDKWorkManager.workerParameters;

import android.content.Context;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.utils.a.c;
import com.google.b.a.a.a;
import java.util.UUID;
import kotlin.g.b.k;

public final class ContactsSDKForegroundUpdater implements i {
    public final a<Void> setForegroundAsync(Context context, UUID uuid, h hVar) {
        k.c(context, "context");
        k.c(uuid, "id");
        k.c(hVar, "foregroundInfo");
        c a2 = c.a();
        k.a((Object) a2, "SettableFuture.create()");
        return a2;
    }
}
