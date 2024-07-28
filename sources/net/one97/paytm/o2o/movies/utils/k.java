package net.one97.paytm.o2o.movies.utils;

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
import com.paytm.utility.s;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;

public final class k implements e.b, e.c, m<LocationSettingsResult> {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static int f75940i;

    /* renamed from: a  reason: collision with root package name */
    public double f75941a;

    /* renamed from: b  reason: collision with root package name */
    public double f75942b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f75943c = getClass().getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private Context f75944d;

    /* renamed from: e  reason: collision with root package name */
    private e f75945e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Activity f75946f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f75947g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f75948h;
    private final com.google.android.gms.location.e j = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = k.this.f75941a = location.getLatitude();
                double unused2 = k.this.f75942b = location.getLongitude();
                String unused3 = k.this.f75943c;
                StringBuilder sb = new StringBuilder("Received Location update ");
                sb.append(k.this.f75941a);
                sb.append(" ");
                sb.append(k.this.f75942b);
                k.d(k.this);
                k.this.e();
            }
        }
    };
    /* access modifiers changed from: private */
    public b k;
    private LocationSettingsRequest l;
    private boolean m;

    public interface b {
        void f();
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
            a();
        } else if (i2 == 6 && this.m) {
            try {
                status.a(this.f75946f, 115);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public k(Context context, Activity activity, e eVar, b bVar) {
        this.f75944d = context;
        this.f75946f = activity;
        this.f75945e = eVar;
        this.f75948h = new a(this, (byte) 0);
        this.k = bVar;
        this.m = true;
        h();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f75947g);
        this.l = aVar.b();
    }

    /* access modifiers changed from: private */
    public void e() {
        f75940i++;
        final double d2 = this.f75941a;
        final double d3 = this.f75942b;
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
                    net.one97.paytm.o2o.movies.utils.k r5 = net.one97.paytm.o2o.movies.utils.k.this
                    android.app.Activity r5 = r5.f75946f
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    r4.<init>(r5, r6)
                    r10 = 1
                    r11 = 0
                    double r5 = r3     // Catch:{ IOException -> 0x0090, all -> 0x008d }
                    double r7 = r5     // Catch:{ IOException -> 0x0090, all -> 0x008d }
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
                    net.one97.paytm.o2o.movies.utils.k r6 = net.one97.paytm.o2o.movies.utils.k.this
                    net.one97.paytm.o2o.movies.utils.k$a r6 = r6.f75948h
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x0084
                    r5.what = r10
                    android.os.Bundle r6 = new android.os.Bundle
                    r6.<init>()
                    r6.putString(r3, r7)
                    r6.putString(r2, r4)
                    double r2 = r3
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r6.putString(r1, r2)
                    double r1 = r5
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
                    net.one97.paytm.o2o.movies.utils.k r5 = net.one97.paytm.o2o.movies.utils.k.this     // Catch:{ all -> 0x00d5 }
                    java.lang.String unused = r5.f75943c     // Catch:{ all -> 0x00d5 }
                    r4.getMessage()     // Catch:{ all -> 0x00d5 }
                    android.os.Message r4 = android.os.Message.obtain()
                    net.one97.paytm.o2o.movies.utils.k r5 = net.one97.paytm.o2o.movies.utils.k.this
                    net.one97.paytm.o2o.movies.utils.k$a r5 = r5.f75948h
                    r4.setTarget(r5)
                    if (r7 == 0) goto L_0x00cc
                    r4.what = r10
                    android.os.Bundle r5 = new android.os.Bundle
                    r5.<init>()
                    r5.putString(r3, r7)
                    r5.putString(r2, r11)
                    double r2 = r3
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r5.putString(r1, r2)
                    double r1 = r5
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
                    net.one97.paytm.o2o.movies.utils.k r6 = net.one97.paytm.o2o.movies.utils.k.this
                    net.one97.paytm.o2o.movies.utils.k$a r6 = r6.f75948h
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x0108
                    r5.what = r10
                    android.os.Bundle r6 = new android.os.Bundle
                    r6.<init>()
                    r6.putString(r3, r7)
                    r6.putString(r2, r11)
                    double r2 = r3
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r6.putString(r1, r2)
                    double r1 = r5
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
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.k.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean f() {
        if (s.a() && !s.e((Context) this.f75946f)) {
            s.d(this.f75946f);
            return false;
        } else if (!s.a() || s.e((Context) this.f75946f)) {
            return true;
        } else {
            return false;
        }
    }

    private void g() {
        if (androidx.core.app.a.a(this.f75944d, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f75944d, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.f75947g == null) {
                h();
            }
            f.f11373b.a(this.f75945e, this.f75947g, this.j);
        }
    }

    private void h() {
        this.f75947g = LocationRequest.a().a(100).a(10000).b(1000);
    }

    public final void a() {
        try {
            if (i() && f() && this.f75945e != null) {
                if (androidx.core.app.a.a(this.f75944d, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f75944d, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location a2 = f.f11373b.a(this.f75945e);
                    if (a2 != null) {
                        this.f75941a = a2.getLatitude();
                        this.f75942b = a2.getLongitude();
                        e();
                        return;
                    }
                    g();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void b() {
        if (f() && this.f75945e != null && this.l != null) {
            f.f11375d.a(this.f75945e, this.l).a(this);
        }
    }

    private boolean i() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f75944d.getSystemService("location");
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
            return false;
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(k kVar, byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            try {
                String str4 = null;
                if (message.what != 1) {
                    str = null;
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
                        if (k.f75940i <= 0) {
                            k.this.e();
                            return;
                        }
                        int unused = k.f75940i = 0;
                        k.this.k.f();
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
                int unused2 = k.f75940i = 0;
                k.this.k.f();
            } catch (Exception unused3) {
            }
        }
    }

    static /* synthetic */ void d(k kVar) {
        try {
            f.f11373b.a(kVar.f75945e, kVar.j);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
