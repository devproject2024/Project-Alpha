package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.l;

public final class a extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5120d = l.a("BatteryChrgTracker");

    public a(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
    }

    public final IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    public final void a(Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            l.a();
            String.format("Received %s", new Object[]{action});
            char c2 = 65535;
            switch (action.hashCode()) {
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -54942926:
                    if (action.equals("android.os.action.DISCHARGING")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 948344062:
                    if (action.equals("android.os.action.CHARGING")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                a(Boolean.TRUE);
            } else if (c2 == 1) {
                a(Boolean.FALSE);
            } else if (c2 == 2) {
                a(Boolean.TRUE);
            } else if (c2 == 3) {
                a(Boolean.FALSE);
            }
        }
    }

    public final /* synthetic */ Object b() {
        int intExtra;
        Intent registerReceiver = this.f5127b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            l.a();
            return null;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23 ? registerReceiver.getIntExtra("plugged", 0) == 0 : !((intExtra = registerReceiver.getIntExtra("status", -1)) == 2 || intExtra == 5)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
