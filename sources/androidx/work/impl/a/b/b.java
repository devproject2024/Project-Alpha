package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import com.alipay.mobile.nebula.permission.H5PermissionManager;

public final class b extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5121d = l.a("BatteryNotLowTracker");

    public b(Context context, a aVar) {
        super(context, aVar);
    }

    public final IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    public final void a(Intent intent) {
        if (intent.getAction() != null) {
            l.a();
            String.format("Received %s", new Object[]{intent.getAction()});
            String action = intent.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1980154005) {
                if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                    c2 = 1;
                }
            } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
                c2 = 0;
            }
            if (c2 == 0) {
                a(Boolean.TRUE);
            } else if (c2 == 1) {
                a(Boolean.FALSE);
            }
        }
    }

    public final /* synthetic */ Object b() {
        Intent registerReceiver = this.f5127b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            l.a();
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra(H5PermissionManager.level, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        boolean z = true;
        if (intExtra != 1 && intExtra2 <= 0.15f) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
