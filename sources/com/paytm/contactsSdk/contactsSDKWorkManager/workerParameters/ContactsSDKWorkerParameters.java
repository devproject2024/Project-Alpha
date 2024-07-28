package com.paytm.contactsSdk.contactsSDKWorkManager.workerParameters;

import androidx.work.WorkerParameters;
import androidx.work.e;
import androidx.work.impl.utils.b.b;
import androidx.work.x;
import java.util.ArrayList;
import java.util.UUID;

public final class ContactsSDKWorkerParameters {
    public static final ContactsSDKWorkerParameters INSTANCE = new ContactsSDKWorkerParameters();
    private static final b workExecutor = new b(ContactsSDKWorkerParameters$workExecutor$1.INSTANCE);

    private ContactsSDKWorkerParameters() {
    }

    public final WorkerParameters getDefaultWorkerParameters() {
        return new WorkerParameters(UUID.randomUUID(), e.f5092a, new ArrayList(), new WorkerParameters.a(), 1, ContactsSDKWorkerParameters$getDefaultWorkerParameters$1.INSTANCE, workExecutor, x.a(), new ContactsSDKProgressUpdater(), new ContactsSDKForegroundUpdater());
    }
}
