package net.one97.paytm.recharge.widgets.c;

import android.os.SystemClock;
import android.util.LruCache;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public enum e {
    INSTANCE;
    
    private final int DELAY_1000_MILLI;
    private final int DELAY_500_MILLI;
    private final a clickTimeStore;
    private int delay;

    public final int getDELAY_500_MILLI() {
        return this.DELAY_500_MILLI;
    }

    public final int getDELAY_1000_MILLI() {
        return this.DELAY_1000_MILLI;
    }

    public static final class a extends LruCache<String, Long> {
        a() {
            super(20);
        }

        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            d dVar = d.f64967a;
            d.a(e.class.getSimpleName() + " cache resized : evicted:" + z);
            super.entryRemoved(z, (String) obj, (Long) obj2, (Long) obj3);
        }
    }

    private final void storeLastTimeClick(Object obj) {
        this.clickTimeStore.put(String.valueOf(obj.hashCode()), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private final boolean isViewAlreadyClicked(Object obj) {
        Long l = (Long) this.clickTimeStore.get(String.valueOf(obj.hashCode()));
        if (l != null) {
            if (SystemClock.elapsedRealtime() - l.longValue() < ((long) this.delay)) {
                return true;
            }
            d dVar = d.f64967a;
            d.a(e.class.getSimpleName() + " removed manually");
            this.clickTimeStore.remove(String.valueOf(obj.hashCode()));
        }
        return false;
    }

    public final boolean validateIsAlreadyClicked(Object obj) {
        k.c(obj, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.delay = this.DELAY_1000_MILLI;
        if (isViewAlreadyClicked(obj)) {
            return true;
        }
        storeLastTimeClick(obj);
        return false;
    }

    public final boolean validateIsAlreadyClicked(Object obj, int i2) {
        k.c(obj, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.delay = i2;
        if (isViewAlreadyClicked(obj)) {
            return true;
        }
        storeLastTimeClick(obj);
        return false;
    }
}
