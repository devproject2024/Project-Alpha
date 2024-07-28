package net.one97.paytm.o2o.movies.common;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.api.m;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.q;
import com.paytm.utility.s;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;

public final class c implements e.b, e.c, m<LocationSettingsResult> {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static int f75018i;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f75019a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f75020b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public double f75021c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public double f75022d;

    /* renamed from: e  reason: collision with root package name */
    private e f75023e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Activity f75024f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f75025g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f75026h;
    private final com.google.android.gms.location.e j = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = c.this.f75021c = location.getLatitude();
                double unused2 = c.this.f75022d = location.getLongitude();
                String unused3 = c.this.f75019a;
                q.d("Received Location update " + c.this.f75021c + " " + c.this.f75022d);
                c.d(c.this);
                c.this.f();
            }
        }
    };
    /* access modifiers changed from: private */
    public b k;
    private LocationSettingsRequest l;

    public interface b {
        void a(CJRUtilityLocationModel cJRUtilityLocationModel);

        boolean c();
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i2) {
    }

    public final /* synthetic */ void onResult(l lVar) {
        Status status = ((LocationSettingsResult) lVar).f11359a;
        int i2 = status.f8360g;
        if (i2 == 0) {
            q.d("All location settings are satisfied.");
            a();
        } else if (i2 == 6) {
            q.d("Location settings are not satisfied. Show the user a dialog toupgrade location settings ");
            this.k.c();
            try {
                status.a(this.f75024f, 115);
            } catch (IntentSender.SendIntentException unused) {
                q.d("PendingIntent unable to execute request.");
            }
        } else if (i2 == 8502) {
            q.d("Location settings are inadequate, and cannot be fixed here. Dialog not created.");
        }
    }

    public c(Context context, Activity activity, e eVar, b bVar) {
        this.f75020b = context;
        this.f75024f = activity;
        this.f75023e = eVar;
        this.f75026h = new a(this, (byte) 0);
        this.k = bVar;
        i();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f75025g);
        this.l = aVar.b();
    }

    public final void a() {
        try {
            if (e() && g() && this.f75023e != null) {
                if (androidx.core.app.a.a(this.f75020b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f75020b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location a2 = f.f11373b.a(this.f75023e);
                    if (a2 != null) {
                        this.f75021c = a2.getLatitude();
                        this.f75022d = a2.getLongitude();
                        f();
                        return;
                    }
                    h();
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private boolean e() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f75020b.getSystemService("location");
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception unused) {
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
            } catch (Exception unused2) {
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            this.k.c();
            return false;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            this.k.c();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        f75018i++;
        a(this.f75021c, this.f75022d);
    }

    private void a(double d2, double d3) {
        final double d4 = d2;
        final double d5 = d3;
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00cc  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0108  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r12 = this;
                    java.lang.String r0 = "longitude"
                    java.lang.String r1 = "latitude"
                    java.lang.String r2 = "address_state"
                    java.lang.String r3 = "address_city"
                    android.location.Geocoder r4 = new android.location.Geocoder
                    net.one97.paytm.o2o.movies.common.c r5 = net.one97.paytm.o2o.movies.common.c.this
                    android.app.Activity r5 = r5.f75024f
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    r4.<init>(r5, r6)
                    r10 = 1
                    r11 = 0
                    double r5 = r2     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    double r7 = r4     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    r9 = 1
                    java.util.List r4 = r4.getFromLocation(r5, r7, r9)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    if (r4 == 0) goto L_0x0050
                    int r5 = r4.size()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    if (r5 <= 0) goto L_0x0050
                    r5 = 0
                    java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    android.location.Address r4 = (android.location.Address) r4     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    r6.<init>()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    java.lang.String r7 = r4.getLocality()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    r6.append(r7)     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    java.lang.String r7 = r6.toString()     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    r6.setLength(r5)     // Catch:{ IOException -> 0x004e }
                    java.lang.String r4 = r4.getAdminArea()     // Catch:{ IOException -> 0x004e }
                    r6.append(r4)     // Catch:{ IOException -> 0x004e }
                    java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x004e }
                    goto L_0x0052
                L_0x004e:
                    r4 = move-exception
                    goto L_0x0092
                L_0x0050:
                    r4 = r11
                    r7 = r4
                L_0x0052:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.o2o.movies.common.c r6 = net.one97.paytm.o2o.movies.common.c.this
                    net.one97.paytm.o2o.movies.common.c$a r6 = r6.f75026h
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x0084
                    r5.what = r10
                    android.os.Bundle r6 = new android.os.Bundle
                    r6.<init>()
                    r6.putString(r3, r7)
                    r6.putString(r2, r4)
                    double r2 = r2
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r6.putString(r1, r2)
                    double r1 = r4
                    java.lang.String r1 = java.lang.Double.toString(r1)
                    r6.putString(r0, r1)
                    r5.setData(r6)
                    goto L_0x0089
                L_0x0084:
                    r5.what = r10
                    r5.setData(r11)
                L_0x0089:
                    r5.sendToTarget()
                    return
                L_0x008d:
                    r4 = move-exception
                    r7 = r11
                    goto L_0x00d6
                L_0x0090:
                    r4 = move-exception
                    r7 = r11
                L_0x0092:
                    net.one97.paytm.o2o.movies.common.c r5 = net.one97.paytm.o2o.movies.common.c.this     // Catch:{ all -> 0x00d5 }
                    java.lang.String unused = r5.f75019a     // Catch:{ all -> 0x00d5 }
                    r4.getMessage()     // Catch:{ all -> 0x00d5 }
                    android.os.Message r4 = android.os.Message.obtain()
                    net.one97.paytm.o2o.movies.common.c r5 = net.one97.paytm.o2o.movies.common.c.this
                    net.one97.paytm.o2o.movies.common.c$a r5 = r5.f75026h
                    r4.setTarget(r5)
                    if (r7 == 0) goto L_0x00cc
                    r4.what = r10
                    android.os.Bundle r5 = new android.os.Bundle
                    r5.<init>()
                    r5.putString(r3, r7)
                    r5.putString(r2, r11)
                    double r2 = r2
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r5.putString(r1, r2)
                    double r1 = r4
                    java.lang.String r1 = java.lang.Double.toString(r1)
                    r5.putString(r0, r1)
                    r4.setData(r5)
                    goto L_0x00d1
                L_0x00cc:
                    r4.what = r10
                    r4.setData(r11)
                L_0x00d1:
                    r4.sendToTarget()
                    return
                L_0x00d5:
                    r4 = move-exception
                L_0x00d6:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.o2o.movies.common.c r6 = net.one97.paytm.o2o.movies.common.c.this
                    net.one97.paytm.o2o.movies.common.c$a r6 = r6.f75026h
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x0108
                    r5.what = r10
                    android.os.Bundle r6 = new android.os.Bundle
                    r6.<init>()
                    r6.putString(r3, r7)
                    r6.putString(r2, r11)
                    double r2 = r2
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r6.putString(r1, r2)
                    double r1 = r4
                    java.lang.String r1 = java.lang.Double.toString(r1)
                    r6.putString(r0, r1)
                    r5.setData(r6)
                    goto L_0x010d
                L_0x0108:
                    r5.what = r10
                    r5.setData(r11)
                L_0x010d:
                    r5.sendToTarget()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.c.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean g() {
        if (s.a() && !s.e((Context) this.f75024f)) {
            s.d(this.f75024f);
            return false;
        } else if (!s.a() || s.e((Context) this.f75024f)) {
            return true;
        } else {
            return false;
        }
    }

    private void h() {
        if (androidx.core.app.a.a(this.f75020b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f75020b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.f75025g == null) {
                i();
            }
            f.f11373b.a(this.f75023e, this.f75025g, this.j);
        }
    }

    private void i() {
        this.f75025g = LocationRequest.a().a(100).a(10000).b(1000);
    }

    public final void b() {
        if (!g() || this.f75023e == null || this.l == null) {
            q.b("dasda");
        } else {
            f.f11375d.a(this.f75023e, this.l).a(this);
        }
    }

    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            String str4;
            try {
                if (message.what != 1) {
                    str = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                } else {
                    Bundle data = message.getData();
                    str4 = data.getString("address_city");
                    str3 = data.getString("address_state");
                    str2 = data.getString("latitude");
                    str = data.getString("longitude");
                }
                CJRUtilityLocationModel cJRUtilityLocationModel = new CJRUtilityLocationModel();
                if (str4 == null) {
                    if (str3 == null) {
                        if (c.f75018i <= 0) {
                            c.this.f();
                            return;
                        }
                        int unused = c.f75018i = 0;
                        c.this.k.a((CJRUtilityLocationModel) null);
                        return;
                    }
                }
                if (str4 != null) {
                    cJRUtilityLocationModel.setCity(str4);
                }
                if (str3 != null) {
                    cJRUtilityLocationModel.setState(str3);
                }
                if (str2 != null) {
                    cJRUtilityLocationModel.setLatitude(str2);
                }
                if (str != null) {
                    cJRUtilityLocationModel.setLongitude(str);
                }
                int unused2 = c.f75018i = 0;
                c.this.k.a(cJRUtilityLocationModel);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void d(c cVar) {
        try {
            f.f11373b.a(cVar.f75023e, cVar.j);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
