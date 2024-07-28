package net.one97.paytm.landingpage.d;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.f;
import com.paytm.utility.q;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.b.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final long f52741a = TimeUnit.MINUTES.toMillis(10);

    /* renamed from: e  reason: collision with root package name */
    private static volatile a f52742e;

    /* renamed from: b  reason: collision with root package name */
    public e f52743b;

    /* renamed from: c  reason: collision with root package name */
    public e.b f52744c = new e.b() {
        public final void onConnected(Bundle bundle) {
            a aVar = a.this;
            aVar.a(aVar.f52746f);
        }

        public final void onConnectionSuspended(int i2) {
            a aVar = a.this;
            aVar.a(aVar.f52746f);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public e.c f52745d = new e.c() {
        public final void onConnectionFailed(ConnectionResult connectionResult) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.google.android.gms.location.e f52746f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f52747g;

    private a() {
    }

    public static a a() {
        if (f52742e == null) {
            synchronized (a.class.getName()) {
                if (f52742e == null) {
                    f52742e = new a();
                }
            }
        }
        return f52742e;
    }

    public final LocationRequest b() {
        if (this.f52747g == null) {
            this.f52747g = new LocationRequest();
            this.f52747g.a(f52741a);
            this.f52747g.b(f52741a);
            this.f52747g.a(100);
        }
        return this.f52747g;
    }

    public final void c() {
        Context a2 = d.b().a();
        if (com.paytm.utility.a.n(a2) && com.paytm.utility.a.o(a2)) {
            try {
                this.f52743b = new e.a(a2).a(this.f52744c).a(this.f52745d).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public final void d() {
        e eVar = this.f52743b;
        if (eVar != null && eVar.f()) {
            try {
                f.f11373b.a(this.f52743b, this.f52746f);
                this.f52743b.e();
            } catch (IllegalStateException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private boolean e() {
        e eVar = this.f52743b;
        return eVar != null && eVar.f();
    }

    public final void a(final com.google.android.gms.location.e eVar) {
        if (b.a()) {
            if (eVar == null) {
                d();
                return;
            }
            this.f52746f = eVar;
            try {
                if (this.f52743b == null) {
                    c();
                }
                if (!e()) {
                    if (this.f52743b != null && !this.f52743b.g()) {
                        this.f52743b.d();
                    }
                } else if (b.a()) {
                    f.f11373b.a(this.f52743b, b(), new com.google.android.gms.location.e() {
                        public final void a(Location location) {
                            if (location.getLatitude() != 0.0d && location.getLongitude() != 0.0d) {
                                eVar.a(location);
                                a.a(location);
                                a.this.d();
                            }
                        }
                    });
                } else {
                    q.b(a.class.getName() + "->requestLocationAndOffHardware(): Permission not granted");
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(Location location) {
        Intent intent = new Intent("device_location_updated");
        intent.putExtra("latitude", location.getLatitude());
        intent.putExtra("longitude", location.getLongitude());
        androidx.localbroadcastmanager.a.a.a(d.b().a()).a(intent);
    }
}
