package com.travel.bus.busticket.i;

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
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.q;
import com.paytm.utility.s;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;

public final class m implements e.b, e.c, com.google.android.gms.common.api.m<LocationSettingsResult> {
    /* access modifiers changed from: private */
    public static int j;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22449a = false;

    /* renamed from: b  reason: collision with root package name */
    private Context f22450b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public double f22451c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public double f22452d;

    /* renamed from: e  reason: collision with root package name */
    private String f22453e = null;

    /* renamed from: f  reason: collision with root package name */
    private e f22454f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Activity f22455g;

    /* renamed from: h  reason: collision with root package name */
    private LocationRequest f22456h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f22457i;
    private final com.google.android.gms.location.e k = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = m.this.f22451c = location.getLatitude();
                double unused2 = m.this.f22452d = location.getLongitude();
                StringBuilder sb = new StringBuilder("Received Location update ");
                sb.append(m.this.f22451c);
                sb.append(" ");
                sb.append(m.this.f22452d);
                f.f11373b.a(m.this.f22454f, m.this.k);
                m.this.f();
            }
        }
    };
    /* access modifiers changed from: private */
    public b l;
    private LocationSettingsRequest m;

    public interface b {
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
            try {
                status.a(this.f22455g, 115);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public m(Context context, Activity activity, e eVar, b bVar) {
        this.f22450b = context;
        this.f22455g = activity;
        this.f22454f = eVar;
        this.f22457i = new a(this, (byte) 0);
        this.l = bVar;
        i();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f22456h);
        this.m = aVar.b();
    }

    public final void a() {
        try {
            if (e() && g() && this.f22454f != null) {
                if (androidx.core.app.a.a(this.f22450b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f22450b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location a2 = f.f11373b.a(this.f22454f);
                    if (a2 != null) {
                        this.f22451c = a2.getLatitude();
                        this.f22452d = a2.getLongitude();
                        f();
                        return;
                    }
                    h();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private boolean e() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f22450b.getSystemService("location");
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception e2) {
                q.c(e2.getMessage());
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
            } catch (Exception e3) {
                q.c(e3.getMessage());
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            return false;
        } catch (Exception e4) {
            if (com.paytm.utility.b.v) {
                q.c(e4.getMessage());
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        j++;
        if (this.f22449a) {
            Double.toString(this.f22451c);
            Double.toString(this.f22452d);
            return;
        }
        a(this.f22451c, this.f22452d);
    }

    private void a(double d2, double d3) {
        final double d4 = d2;
        final double d5 = d3;
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00bd  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x00e0  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00f9  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x011c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r12 = this;
                    java.lang.String r0 = "longitude"
                    java.lang.String r1 = "latitude"
                    java.lang.String r2 = "address_state"
                    java.lang.String r3 = "address_city"
                    android.location.Geocoder r4 = new android.location.Geocoder
                    com.travel.bus.busticket.i.m r5 = com.travel.bus.busticket.i.m.this
                    android.app.Activity r5 = r5.f22455g
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    r4.<init>(r5, r6)
                    r10 = 1
                    r11 = 0
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    java.lang.String r6 = "Getting address for location "
                    r5.<init>(r6)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    double r6 = r2     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    r5.append(r6)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    java.lang.String r6 = " "
                    r5.append(r6)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    double r6 = r4     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    r5.append(r6)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    double r5 = r2     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    double r7 = r4     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    r9 = 1
                    java.util.List r4 = r4.getFromLocation(r5, r7, r9)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    if (r4 == 0) goto L_0x0066
                    int r5 = r4.size()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    if (r5 <= 0) goto L_0x0066
                    r5 = 0
                    java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    android.location.Address r4 = (android.location.Address) r4     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    r6.<init>()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    java.lang.String r7 = r4.getLocality()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    r6.append(r7)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    java.lang.String r7 = r6.toString()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                    r6.setLength(r5)     // Catch:{ IOException -> 0x0064 }
                    java.lang.String r4 = r4.getAdminArea()     // Catch:{ IOException -> 0x0064 }
                    r6.append(r4)     // Catch:{ IOException -> 0x0064 }
                    java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0064 }
                    goto L_0x0068
                L_0x0064:
                    r4 = move-exception
                    goto L_0x00ab
                L_0x0066:
                    r4 = r11
                    r7 = r4
                L_0x0068:
                    android.os.Message r5 = android.os.Message.obtain()
                    com.travel.bus.busticket.i.m r6 = com.travel.bus.busticket.i.m.this
                    com.travel.bus.busticket.i.m$a r6 = r6.f22457i
                    r5.setTarget(r6)
                    if (r7 != 0) goto L_0x0080
                    if (r4 == 0) goto L_0x007a
                    goto L_0x0080
                L_0x007a:
                    r5.what = r10
                    r5.setData(r11)
                    goto L_0x00a2
                L_0x0080:
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
                L_0x00a2:
                    r5.sendToTarget()
                    return
                L_0x00a6:
                    r4 = move-exception
                    r7 = r11
                    goto L_0x00ea
                L_0x00a9:
                    r4 = move-exception
                    r7 = r11
                L_0x00ab:
                    r4.getMessage()     // Catch:{ all -> 0x00e9 }
                    android.os.Message r4 = android.os.Message.obtain()
                    com.travel.bus.busticket.i.m r5 = com.travel.bus.busticket.i.m.this
                    com.travel.bus.busticket.i.m$a r5 = r5.f22457i
                    r4.setTarget(r5)
                    if (r7 == 0) goto L_0x00e0
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
                    goto L_0x00e5
                L_0x00e0:
                    r4.what = r10
                    r4.setData(r11)
                L_0x00e5:
                    r4.sendToTarget()
                    return
                L_0x00e9:
                    r4 = move-exception
                L_0x00ea:
                    android.os.Message r5 = android.os.Message.obtain()
                    com.travel.bus.busticket.i.m r6 = com.travel.bus.busticket.i.m.this
                    com.travel.bus.busticket.i.m$a r6 = r6.f22457i
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x011c
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
                    goto L_0x0121
                L_0x011c:
                    r5.what = r10
                    r5.setData(r11)
                L_0x0121:
                    r5.sendToTarget()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.i.m.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean g() {
        if (s.a() && !s.e((Context) this.f22455g)) {
            s.d(this.f22455g);
            return false;
        } else if ((!s.a() || !s.e((Context) this.f22455g)) && s.a()) {
            return false;
        } else {
            return true;
        }
    }

    private void h() {
        if (androidx.core.app.a.a(this.f22450b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f22450b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.f22456h == null) {
                i();
            }
            f.f11373b.a(this.f22454f, this.f22456h, this.k);
        }
    }

    private void i() {
        this.f22456h = LocationRequest.a().a(100).a(10000).b(1000);
    }

    public final void b() {
        if (g() && this.f22454f != null && this.m != null) {
            f.f11375d.a(this.f22454f, this.m).a(this);
        }
    }

    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
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
                        if (m.j < 4) {
                            m.this.f();
                        } else {
                            int unused = m.j = 0;
                            m.this.l.a((CJRUtilityLocationModel) null);
                        }
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
                int unused2 = m.j = 0;
                m.this.l.a(cJRUtilityLocationModel);
                StringBuilder sb2 = new StringBuilder("Location City ");
                sb2.append(str4);
                sb2.append("Location state ");
                sb2.append(str3);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }
}
