package net.one97.paytm.o2o.amusementpark.utils;

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
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.s;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;

public final class f implements e.b, e.c, m<LocationSettingsResult> {
    /* access modifiers changed from: private */
    public static int j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f73651a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f73652b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public double f73653c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public double f73654d;

    /* renamed from: e  reason: collision with root package name */
    private String f73655e = null;

    /* renamed from: f  reason: collision with root package name */
    private e f73656f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Activity f73657g;

    /* renamed from: h  reason: collision with root package name */
    private LocationRequest f73658h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f73659i;
    private boolean k = false;
    private final com.google.android.gms.location.e l = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = f.this.f73653c = location.getLatitude();
                double unused2 = f.this.f73654d = location.getLongitude();
                String unused3 = f.this.f73651a;
                StringBuilder sb = new StringBuilder("Received Location update ");
                sb.append(f.this.f73653c);
                sb.append(" ");
                sb.append(f.this.f73654d);
                com.google.android.gms.location.f.f11373b.a(f.this.f73656f, f.this.l);
                f.this.e();
            }
        }
    };
    /* access modifiers changed from: private */
    public b m;
    private LocationSettingsRequest n;

    public interface b {
        void a();

        void a(CJRUtilityLocationModel cJRUtilityLocationModel);
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
        } else if (i2 == 6) {
            this.m.a();
            try {
                status.a(this.f73657g, 115);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public f(Context context, Activity activity, e eVar, b bVar) {
        this.f73652b = context;
        this.f73657g = activity;
        this.f73656f = eVar;
        this.f73659i = new a(this, (byte) 0);
        this.m = bVar;
        h();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f73658h);
        this.n = aVar.b();
    }

    /* access modifiers changed from: private */
    public void e() {
        j++;
        if (this.k) {
            Double.toString(this.f73653c);
            Double.toString(this.f73654d);
            return;
        }
        final double d2 = this.f73653c;
        final double d3 = this.f73654d;
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00c7  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00ea  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0103  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0126  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r12 = this;
                    java.lang.String r0 = "longitude"
                    java.lang.String r1 = "latitude"
                    java.lang.String r2 = "address_state"
                    java.lang.String r3 = "address_city"
                    android.location.Geocoder r4 = new android.location.Geocoder
                    net.one97.paytm.o2o.amusementpark.utils.f r5 = net.one97.paytm.o2o.amusementpark.utils.f.this
                    android.app.Activity r5 = r5.f73657g
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    r4.<init>(r5, r6)
                    r10 = 1
                    r11 = 0
                    net.one97.paytm.o2o.amusementpark.utils.f r5 = net.one97.paytm.o2o.amusementpark.utils.f.this     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.String unused = r5.f73651a     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.String r6 = "Getting address for location "
                    r5.<init>(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    double r6 = r4     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    r5.append(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.String r6 = " "
                    r5.append(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    double r6 = r6     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    r5.append(r6)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    double r5 = r4     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    double r7 = r6     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    r9 = 1
                    java.util.List r4 = r4.getFromLocation(r5, r7, r9)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    if (r4 == 0) goto L_0x006b
                    int r5 = r4.size()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    if (r5 <= 0) goto L_0x006b
                    r5 = 0
                    java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    android.location.Address r4 = (android.location.Address) r4     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    r6.<init>()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.String r7 = r4.getLocality()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    r6.append(r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    java.lang.String r7 = r6.toString()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                    r6.setLength(r5)     // Catch:{ IOException -> 0x0069 }
                    java.lang.String r4 = r4.getAdminArea()     // Catch:{ IOException -> 0x0069 }
                    r6.append(r4)     // Catch:{ IOException -> 0x0069 }
                    java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0069 }
                    goto L_0x006d
                L_0x0069:
                    r4 = move-exception
                    goto L_0x00b0
                L_0x006b:
                    r4 = r11
                    r7 = r4
                L_0x006d:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.o2o.amusementpark.utils.f r6 = net.one97.paytm.o2o.amusementpark.utils.f.this
                    net.one97.paytm.o2o.amusementpark.utils.f$a r6 = r6.f73659i
                    r5.setTarget(r6)
                    if (r7 != 0) goto L_0x0085
                    if (r4 == 0) goto L_0x007f
                    goto L_0x0085
                L_0x007f:
                    r5.what = r10
                    r5.setData(r11)
                    goto L_0x00a7
                L_0x0085:
                    r5.what = r10
                    android.os.Bundle r6 = new android.os.Bundle
                    r6.<init>()
                    r6.putString(r3, r7)
                    r6.putString(r2, r4)
                    double r2 = r4
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r6.putString(r1, r2)
                    double r1 = r6
                    java.lang.String r1 = java.lang.Double.toString(r1)
                    r6.putString(r0, r1)
                    r5.setData(r6)
                L_0x00a7:
                    r5.sendToTarget()
                    return
                L_0x00ab:
                    r4 = move-exception
                    r7 = r11
                    goto L_0x00f4
                L_0x00ae:
                    r4 = move-exception
                    r7 = r11
                L_0x00b0:
                    net.one97.paytm.o2o.amusementpark.utils.f r5 = net.one97.paytm.o2o.amusementpark.utils.f.this     // Catch:{ all -> 0x00f3 }
                    java.lang.String unused = r5.f73651a     // Catch:{ all -> 0x00f3 }
                    r4.getMessage()     // Catch:{ all -> 0x00f3 }
                    android.os.Message r4 = android.os.Message.obtain()
                    net.one97.paytm.o2o.amusementpark.utils.f r5 = net.one97.paytm.o2o.amusementpark.utils.f.this
                    net.one97.paytm.o2o.amusementpark.utils.f$a r5 = r5.f73659i
                    r4.setTarget(r5)
                    if (r7 == 0) goto L_0x00ea
                    r4.what = r10
                    android.os.Bundle r5 = new android.os.Bundle
                    r5.<init>()
                    r5.putString(r3, r7)
                    r5.putString(r2, r11)
                    double r2 = r4
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r5.putString(r1, r2)
                    double r1 = r6
                    java.lang.String r1 = java.lang.Double.toString(r1)
                    r5.putString(r0, r1)
                    r4.setData(r5)
                    goto L_0x00ef
                L_0x00ea:
                    r4.what = r10
                    r4.setData(r11)
                L_0x00ef:
                    r4.sendToTarget()
                    return
                L_0x00f3:
                    r4 = move-exception
                L_0x00f4:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.o2o.amusementpark.utils.f r6 = net.one97.paytm.o2o.amusementpark.utils.f.this
                    net.one97.paytm.o2o.amusementpark.utils.f$a r6 = r6.f73659i
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x0126
                    r5.what = r10
                    android.os.Bundle r6 = new android.os.Bundle
                    r6.<init>()
                    r6.putString(r3, r7)
                    r6.putString(r2, r11)
                    double r2 = r4
                    java.lang.String r2 = java.lang.Double.toString(r2)
                    r6.putString(r1, r2)
                    double r1 = r6
                    java.lang.String r1 = java.lang.Double.toString(r1)
                    r6.putString(r0, r1)
                    r5.setData(r6)
                    goto L_0x012b
                L_0x0126:
                    r5.what = r10
                    r5.setData(r11)
                L_0x012b:
                    r5.sendToTarget()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.utils.f.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean f() {
        if (s.a() && !s.e((Context) this.f73657g)) {
            s.d(this.f73657g);
            return false;
        } else if ((!s.a() || !s.e((Context) this.f73657g)) && s.a()) {
            return false;
        } else {
            return true;
        }
    }

    private void g() {
        if (androidx.core.app.a.a(this.f73652b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f73652b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.f73658h == null) {
                h();
            }
            com.google.android.gms.location.f.f11373b.a(this.f73656f, this.f73658h, this.l);
        }
    }

    private void h() {
        this.f73658h = LocationRequest.a().a(100).a(10000).b(1000);
    }

    public final void a() {
        try {
            if (i() && f() && this.f73656f != null) {
                if (androidx.core.app.a.a(this.f73652b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f73652b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location a2 = com.google.android.gms.location.f.f11373b.a(this.f73656f);
                    if (a2 != null) {
                        this.f73653c = a2.getLatitude();
                        this.f73654d = a2.getLongitude();
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
        if (f() && this.f73656f != null && this.n != null) {
            com.google.android.gms.location.f.f11375d.a(this.f73656f, this.n).a(this);
        }
    }

    private boolean i() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f73652b.getSystemService("location");
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
            this.m.a();
            return false;
        } catch (Exception unused3) {
            return false;
        }
    }

    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
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
                        if (f.j < 4) {
                            f.this.e();
                        } else {
                            int unused = f.j = 0;
                            f.this.m.a((CJRUtilityLocationModel) null);
                        }
                        String unused2 = f.this.f73651a;
                        StringBuilder sb = new StringBuilder("Location City ");
                        sb.append(str4);
                        sb.append("Location state ");
                        sb.append(str3);
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
                int unused3 = f.j = 0;
                f.this.m.a(cJRUtilityLocationModel);
                String unused4 = f.this.f73651a;
                StringBuilder sb2 = new StringBuilder("Location City ");
                sb2.append(str4);
                sb2.append("Location state ");
                sb2.append(str3);
            } catch (Exception unused5) {
            }
        }
    }
}
