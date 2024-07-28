package net.one97.paytm.o2o.amparkeventcommonlib.b;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import java.util.HashMap;

public enum a {
    INSTANCE;
    
    private HashMap<String, Long> clickTimeStore;

    private void storeLastTimeClick(Object obj, View view) {
        if (view instanceof Button) {
            HashMap<String, Long> hashMap = this.clickTimeStore;
            hashMap.put(obj.getClass().getName() + view.getId() + ((Button) view).getText(), Long.valueOf(SystemClock.elapsedRealtime()));
            return;
        }
        HashMap<String, Long> hashMap2 = this.clickTimeStore;
        hashMap2.put(obj.getClass().getName() + view.getId(), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    private boolean isViewAlreadyClicked(Object obj, View view) {
        Long l;
        if (view instanceof Button) {
            HashMap<String, Long> hashMap = this.clickTimeStore;
            l = hashMap.get(obj.getClass().getName() + view.getId() + ((Button) view).getText());
        } else {
            HashMap<String, Long> hashMap2 = this.clickTimeStore;
            l = hashMap2.get(obj.getClass().getName() + view.getId());
        }
        if (l == null || SystemClock.elapsedRealtime() - l.longValue() >= 1000) {
            return false;
        }
        return true;
    }

    public final boolean validateIsAlreadyClicked(Object obj, View view) {
        if (isViewAlreadyClicked(obj, view)) {
            return true;
        }
        storeLastTimeClick(obj, view);
        return false;
    }
}
