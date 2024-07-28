package net.one97.paytm.recharge.metro.f;

import android.os.SystemClock;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public enum d {
    INSTANCE;
    
    private final HashMap<String, Long> clickTimeStore;

    private final void storeLastTimeClick(Object obj) {
        String name = obj.getClass().getName();
        k.a((Object) name, "screenName.javaClass.name");
        this.clickTimeStore.put(name, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private final boolean isViewAlreadyClicked(Object obj) {
        Long l = this.clickTimeStore.get(obj.getClass().getName());
        if (l == null || SystemClock.elapsedRealtime() - l.longValue() >= 1000) {
            return false;
        }
        return true;
    }

    public final boolean validateIsAlreadyClicked(Object obj) {
        k.c(obj, SDKConstants.EVENT_KEY_SCREEN_NAME);
        if (isViewAlreadyClicked(obj)) {
            return true;
        }
        storeLastTimeClick(obj);
        return false;
    }
}
