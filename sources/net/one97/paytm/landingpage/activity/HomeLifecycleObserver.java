package net.one97.paytm.landingpage.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.paytm.utility.q;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.u;
import net.one97.paytm.common.b.d;
import net.one97.paytm.utils.ag;

public final class HomeLifecycleObserver implements p {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.landingpage.d.a f52714a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f52715b;

    /* renamed from: c  reason: collision with root package name */
    private b f52716c;

    /* renamed from: d  reason: collision with root package name */
    private e f52717d;

    /* renamed from: e  reason: collision with root package name */
    private final g f52718e = h.a(new c(this));
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Context f52719f;

    public interface a {
        void a();
    }

    public HomeLifecycleObserver(Context context) {
        k.c(context, "homeContext");
        this.f52719f = context;
    }

    static final class c extends l implements kotlin.g.a.a<com.google.android.gms.location.e> {
        final /* synthetic */ HomeLifecycleObserver this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(HomeLifecycleObserver homeLifecycleObserver) {
            super(0);
            this.this$0 = homeLifecycleObserver;
        }

        public final com.google.android.gms.location.e invoke() {
            return new com.google.android.gms.location.e(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f52721a;

                {
                    this.f52721a = r1;
                }

                public final void a(Location location) {
                    k.a((Object) location, "location");
                    if (location.getLatitude() != 0.0d && location.getLongitude() != 0.0d) {
                        HomeLifecycleObserver.a(this.f52721a.this$0, location.getLatitude(), location.getLongitude());
                    }
                }
            };
        }
    }

    @aa(a = k.a.ON_START)
    public final void onStart() {
        net.one97.paytm.landingpage.d.a a2 = net.one97.paytm.landingpage.d.a.a();
        kotlin.g.b.k.a((Object) a2, "LocationManager.getManager()");
        this.f52714a = a2;
        net.one97.paytm.landingpage.d.a aVar = this.f52714a;
        if (aVar == null) {
            kotlin.g.b.k.a("mLocationManager");
        }
        aVar.c();
        aVar.b();
        if (!com.paytm.utility.b.a("com.paytm.pos", this.f52719f)) {
            this.f52717d = new e.a(this.f52719f).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) com.google.android.gms.a.a.f8032a).a();
            e eVar = this.f52717d;
            if (eVar != null) {
                eVar.d();
            }
            try {
                net.one97.paytm.common.utility.e eVar2 = net.one97.paytm.common.utility.e.f49603a;
                Context context = this.f52719f;
                if (context != null) {
                    net.one97.paytm.common.utility.e.a((Activity) context);
                } else {
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        d.b().l(this.f52719f);
    }

    @aa(a = k.a.ON_RESUME)
    public final void onResume() {
        net.one97.paytm.landingpage.d.a aVar = this.f52714a;
        if (aVar == null) {
            kotlin.g.b.k.a("mLocationManager");
        }
        aVar.a((com.google.android.gms.location.e) this.f52718e.getValue());
        if (!this.f52715b) {
            this.f52715b = true;
            this.f52716c = new b();
            this.f52719f.registerReceiver(this.f52716c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @aa(a = k.a.ON_PAUSE)
    public final void onPause() {
        net.one97.paytm.landingpage.d.a aVar = this.f52714a;
        if (aVar == null) {
            kotlin.g.b.k.a("mLocationManager");
        }
        aVar.d();
        b bVar = this.f52716c;
        if (bVar != null) {
            this.f52719f.unregisterReceiver(bVar);
            this.f52716c = null;
        }
    }

    @aa(a = k.a.ON_STOP)
    public final void onStop() {
        net.one97.paytm.landingpage.d.a aVar = this.f52714a;
        if (aVar == null) {
            kotlin.g.b.k.a("mLocationManager");
        }
        try {
            if (aVar.f52743b != null) {
                aVar.f52743b.b(aVar.f52745d);
                if (aVar.f52744c != null) {
                    aVar.f52743b.b(aVar.f52744c);
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    final class b extends BroadcastReceiver {
        public b() {
        }

        public final void onReceive(Context context, Intent intent) {
            Bundle extras;
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(intent, "intent");
            if (kotlin.g.b.k.a((Object) intent.getAction(), (Object) "android.net.conn.CONNECTIVITY_CHANGE") && (extras = intent.getExtras()) != null && !extras.getBoolean("noConnectivity", false)) {
                if (HomeLifecycleObserver.this.f52715b) {
                    HomeLifecycleObserver.this.f52715b = false;
                } else if (HomeLifecycleObserver.this.f52719f instanceof a) {
                    ((a) HomeLifecycleObserver.this.f52719f).a();
                }
            }
        }
    }

    public final void a() {
        d.b().m(this.f52719f);
    }

    @aa(a = k.a.ON_DESTROY)
    public final void onDestroy() {
        d.b().y();
    }

    public static final /* synthetic */ void a(HomeLifecycleObserver homeLifecycleObserver, double d2, double d3) {
        String valueOf = String.valueOf(d2);
        String valueOf2 = String.valueOf(d3);
        ag.a aVar = ag.f69605a;
        Context applicationContext = homeLifecycleObserver.f52719f.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "homeContext.applicationContext");
        com.paytm.b.a.a a2 = ag.a.a(applicationContext);
        a2.a("pref_key_latitude", valueOf, true);
        a2.a("pref_key_longitude", valueOf2, true);
    }
}
