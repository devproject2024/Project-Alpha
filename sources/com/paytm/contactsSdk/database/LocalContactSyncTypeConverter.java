package com.paytm.contactsSdk.database;

import com.paytm.contactsSdk.api.p002enum.LocalContactSyncType;
import kotlin.g.b.k;

public final class LocalContactSyncTypeConverter {
    public final int fromLocalContactSyncType(LocalContactSyncType localContactSyncType) {
        k.c(localContactSyncType, "type");
        return localContactSyncType.ordinal();
    }

    public final LocalContactSyncType toLocalContactSyncType(int i2) {
        for (LocalContactSyncType localContactSyncType : LocalContactSyncType.values()) {
            if (localContactSyncType.ordinal() == i2) {
                return localContactSyncType;
            }
        }
        return LocalContactSyncType.SYNC_NONE;
    }
}
