package net.one97.paytm.wifi.background.wifi.connector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import android.os.Handler;
import androidx.lifecycle.y;
import com.paytm.utility.q;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class WifiConnectProcessReceiver extends BroadcastReceiver {

    /* renamed from: f  reason: collision with root package name */
    public static final a f21120f = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final y<SupplicantState> f21121a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f21122b;

    /* renamed from: c  reason: collision with root package name */
    public final b f21123c;

    /* renamed from: d  reason: collision with root package name */
    public long f21124d = 30000;

    /* renamed from: e  reason: collision with root package name */
    public WifiAccessPoint f21125e;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public WifiManager f21126g;

    public WifiConnectProcessReceiver(WifiManager wifiManager, WifiAccessPoint wifiAccessPoint) {
        k.c(wifiManager, "wifiManager");
        k.c(wifiAccessPoint, "accessPoint");
        this.f21126g = wifiManager;
        this.f21125e = wifiAccessPoint;
        this.f21121a = new y<>();
        this.f21122b = new Handler();
        this.f21123c = new b(this);
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WifiConnectProcessReceiver f21127a;

        b(WifiConnectProcessReceiver wifiConnectProcessReceiver) {
            this.f21127a = wifiConnectProcessReceiver;
        }

        public final void run() {
            q.d("Connection timed out... ");
            b.a(this.f21127a.f21126g, this.f21127a.f21125e);
            if (b.a(this.f21127a.f21126g, this.f21127a.f21125e.getBssids())) {
                this.f21127a.f21121a.postValue(SupplicantState.COMPLETED);
            } else {
                this.f21127a.f21121a.postValue(SupplicantState.DISCONNECTED);
            }
            this.f21127a.f21122b.removeCallbacks(this);
        }
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        String action = intent.getAction();
        q.d("Connection broadcast received action ".concat(String.valueOf(action)));
        if (p.a("android.net.wifi.STATE_CHANGE", action, true)) {
            if (b.a(this.f21126g, this.f21125e.getBssids())) {
                this.f21122b.removeCallbacks(this.f21123c);
                this.f21121a.postValue(SupplicantState.COMPLETED);
            }
        } else if (p.a("android.net.wifi.supplicant.STATE_CHANGE", action, true)) {
            SupplicantState supplicantState = (SupplicantState) intent.getParcelableExtra("newState");
            int intExtra = intent.getIntExtra("supplicantError", -1);
            if (supplicantState == null) {
                this.f21122b.removeCallbacks(this.f21123c);
                this.f21121a.postValue(SupplicantState.DISCONNECTED);
                return;
            }
            q.d("Connection status ".concat(String.valueOf(supplicantState)));
            int i2 = a.f21128a[supplicantState.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (b.a(this.f21126g, this.f21125e.getBssids())) {
                    this.f21122b.removeCallbacks(this.f21123c);
                    this.f21121a.postValue(SupplicantState.COMPLETED);
                }
            } else if (i2 != 3) {
                this.f21121a.postValue(supplicantState);
                q.d("Re- attempting to connect...");
                b.a(this.f21126g, this.f21125e);
            } else if (intExtra == 1) {
                q.b("Authentication error.... Done");
                this.f21122b.removeCallbacks(this.f21123c);
                this.f21121a.postValue(SupplicantState.DISCONNECTED);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
