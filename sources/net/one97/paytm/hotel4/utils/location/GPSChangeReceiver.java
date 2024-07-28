package net.one97.paytm.hotel4.utils.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import kotlin.g.b.k;
import kotlin.u;

public final class GPSChangeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final a f28650a;

    public interface a {
        void a(boolean z);
    }

    public GPSChangeReceiver(a aVar) {
        k.c(aVar, "gpsChangeListener");
        this.f28650a = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        Object systemService = context != null ? context.getSystemService("location") : null;
        if (systemService == null) {
            throw new u("null cannot be cast to non-null type android.location.LocationManager");
        } else if (((LocationManager) systemService).isProviderEnabled("gps")) {
            this.f28650a.a(true);
        } else {
            this.f28650a.a(false);
        }
    }
}
