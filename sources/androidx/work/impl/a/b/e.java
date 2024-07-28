package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.l;

public final class e extends d<androidx.work.impl.a.b> {

    /* renamed from: d  reason: collision with root package name */
    static final String f5133d = l.a("NetworkStateTracker");

    /* renamed from: e  reason: collision with root package name */
    private final ConnectivityManager f5134e = ((ConnectivityManager) this.f5127b.getSystemService("connectivity"));

    /* renamed from: f  reason: collision with root package name */
    private b f5135f;

    /* renamed from: g  reason: collision with root package name */
    private a f5136g;

    public e(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
        if (e()) {
            this.f5135f = new b();
        } else {
            this.f5136g = new a();
        }
    }

    public final void c() {
        if (e()) {
            try {
                l.a();
                this.f5134e.registerDefaultNetworkCallback(this.f5135f);
            } catch (IllegalArgumentException | SecurityException e2) {
                l.a();
                new Throwable[1][0] = e2;
            }
        } else {
            l.a();
            this.f5127b.registerReceiver(this.f5136g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public final void d() {
        if (e()) {
            try {
                l.a();
                this.f5134e.unregisterNetworkCallback(this.f5135f);
            } catch (IllegalArgumentException | SecurityException e2) {
                l.a();
                new Throwable[1][0] = e2;
            }
        } else {
            l.a();
            this.f5127b.unregisterReceiver(this.f5136g);
        }
    }

    private static boolean e() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final androidx.work.impl.a.b b() {
        boolean z;
        NetworkCapabilities networkCapabilities;
        NetworkInfo activeNetworkInfo = this.f5134e.getActiveNetworkInfo();
        boolean z2 = false;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean z4 = Build.VERSION.SDK_INT >= 23 && (networkCapabilities = this.f5134e.getNetworkCapabilities(this.f5134e.getActiveNetwork())) != null && networkCapabilities.hasCapability(16);
        ConnectivityManager connectivityManager = this.f5134e;
        if (Build.VERSION.SDK_INT >= 16) {
            z = connectivityManager.isActiveNetworkMetered();
        } else {
            NetworkInfo activeNetworkInfo2 = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo2 != null) {
                switch (activeNetworkInfo2.getType()) {
                    case 1:
                    case 7:
                    case 9:
                        z = false;
                        break;
                }
            }
            z = true;
        }
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z2 = true;
        }
        return new androidx.work.impl.a.b(z3, z4, z, z2);
    }

    class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            l.a();
            String str = e.f5133d;
            String.format("Network capabilities changed: %s", new Object[]{networkCapabilities});
            e eVar = e.this;
            eVar.a(eVar.b());
        }

        public final void onLost(Network network) {
            l.a();
            String str = e.f5133d;
            e eVar = e.this;
            eVar.a(eVar.b());
        }
    }

    class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                l.a();
                String str = e.f5133d;
                e eVar = e.this;
                eVar.a(eVar.b());
            }
        }
    }
}
