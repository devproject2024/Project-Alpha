package net.one97.paytm.wifi.background.wifiScan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.wifi.background.wifi.f;

public final class WifiScanReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21153a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final f f21154b;

    public WifiScanReceiver(f fVar) {
        k.c(fVar, "wifiHandler");
        this.f21154b = fVar;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        String action = intent.getAction();
        q.d("onReceive Called with action ".concat(String.valueOf(action)));
        if (intent.getExtras() == null) {
            q.b("Empty extras in WIFI receiver broadcast");
        }
        if (action != null) {
            switch (action.hashCode()) {
                case -1875733435:
                    if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                        f fVar = this.f21154b;
                        Bundle extras = intent.getExtras();
                        k.a((Object) extras, "intent.extras");
                        fVar.a(3, extras).sendToTarget();
                        return;
                    }
                    return;
                case -385684331:
                    if (action.equals("android.net.wifi.RSSI_CHANGED")) {
                        f fVar2 = this.f21154b;
                        Bundle extras2 = intent.getExtras();
                        k.a((Object) extras2, "intent.extras");
                        fVar2.a(5, extras2).sendToTarget();
                        return;
                    }
                    return;
                case -343630553:
                    if (action.equals("android.net.wifi.STATE_CHANGE")) {
                        f fVar3 = this.f21154b;
                        Bundle extras3 = intent.getExtras();
                        k.a((Object) extras3, "intent.extras");
                        fVar3.a(6, extras3).sendToTarget();
                        return;
                    }
                    return;
                case -20031181:
                    if (action.equals("android.net.wifi.NETWORK_IDS_CHANGED")) {
                        f fVar4 = this.f21154b;
                        Bundle extras4 = intent.getExtras();
                        k.a((Object) extras4, "intent.extras");
                        fVar4.a(4, extras4).sendToTarget();
                        return;
                    }
                    return;
                case 1878357501:
                    if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                        f fVar5 = this.f21154b;
                        Bundle extras5 = intent.getExtras();
                        k.a((Object) extras5, "intent.extras");
                        fVar5.a(1, extras5).sendToTarget();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static IntentFilter a() {
            IntentFilter intentFilter = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.NETWORK_IDS_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            return intentFilter;
        }
    }
}
