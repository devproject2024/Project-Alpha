package net.one97.paytm.passbook.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

public final class HomeKeyWatcher {

    /* renamed from: d  reason: collision with root package name */
    private static HomeKeyWatcher f59218d = new HomeKeyWatcher();

    /* renamed from: a  reason: collision with root package name */
    public Context f59219a;

    /* renamed from: b  reason: collision with root package name */
    public IntentFilter f59220b;

    /* renamed from: c  reason: collision with root package name */
    public InnerReceiver f59221c;

    public static HomeKeyWatcher a() {
        return f59218d;
    }

    private HomeKeyWatcher() {
    }

    public class InnerReceiver extends BroadcastReceiver {
        public InnerReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(Item.KEY_REASON)) != null) {
                q.b("action:" + action + ",reason:" + stringExtra);
                try {
                    if (stringExtra.equals("homekey")) {
                        if (!r.INSTANCE.issecLockShowing(HomeKeyWatcher.this.f59219a)) {
                            r.INSTANCE.setLockPatternSession(false);
                            r.INSTANCE.setIsAppFromBackground(true);
                        }
                    } else if (stringExtra.equals("recentapps")) {
                        if (!r.INSTANCE.issecLockShowing(HomeKeyWatcher.this.f59219a)) {
                            r.INSTANCE.setLockPatternSession(false);
                        }
                        r.INSTANCE.setIsAppFromBackground(true);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
