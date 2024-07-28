package net.one97.paytm.recharge.common.utils;

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
import com.google.android.gms.common.api.m;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.f;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.utility.q;
import com.paytm.utility.s;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;

public final class l implements e.b, e.c, m<LocationSettingsResult> {
    /* access modifiers changed from: private */
    public static int j;

    /* renamed from: a  reason: collision with root package name */
    private final String f61665a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f61666b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public double f61667c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public double f61668d;

    /* renamed from: e  reason: collision with root package name */
    private String f61669e = null;

    /* renamed from: f  reason: collision with root package name */
    private e f61670f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Activity f61671g;

    /* renamed from: h  reason: collision with root package name */
    private LocationRequest f61672h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f61673i;
    private boolean k = false;
    private final com.google.android.gms.location.e l = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = l.this.f61667c = location.getLatitude();
                double unused2 = l.this.f61668d = location.getLongitude();
                l.a(l.this);
                l.this.f();
            }
        }
    };
    /* access modifiers changed from: private */
    public b m;
    private LocationSettingsRequest n;

    public interface b {
        void a(CJRUtilityLocationModel cJRUtilityLocationModel);

        void am_();

        void d();
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i2) {
    }

    public final /* synthetic */ void onResult(com.google.android.gms.common.api.l lVar) {
        Status status = ((LocationSettingsResult) lVar).f11359a;
        int i2 = status.f8360g;
        if (i2 == 0) {
            a();
        } else if (i2 == 6) {
            this.m.am_();
            try {
                status.a(this.f61671g, 115);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public l(Context context, Activity activity, e eVar, b bVar) {
        this.f61666b = context;
        this.f61671g = activity;
        this.f61670f = eVar;
        this.f61673i = new a(this, (byte) 0);
        this.m = bVar;
        i();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f61672h);
        this.n = aVar.b();
    }

    public final void a() {
        try {
            if (e() && g() && this.f61670f != null) {
                if (androidx.core.app.a.a(this.f61666b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f61666b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location a2 = f.f11373b.a(this.f61670f);
                    if (a2 != null) {
                        this.f61667c = a2.getLatitude();
                        this.f61668d = a2.getLongitude();
                        f();
                        return;
                    }
                    h();
                }
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    private boolean e() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f61666b.getSystemService("location");
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception e2) {
                q.d(e2.getMessage());
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
            } catch (Exception e3) {
                q.d(e3.getMessage());
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            this.m.am_();
            return false;
        } catch (Exception e4) {
            q.d(e4.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        j++;
        if (this.k) {
            b bVar = this.m;
            Double.toString(this.f61667c);
            Double.toString(this.f61668d);
            bVar.d();
            return;
        }
        a(this.f61667c, this.f61668d);
    }

    public final void a(double d2, double d3) {
        final double d4 = d2;
        final double d5 = d3;
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00c7  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00e0  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0103  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r12 = this;
                    java.lang.String r0 = "longitude"
                    java.lang.String r1 = "latitude"
                    java.lang.String r2 = "address_state"
                    java.lang.String r3 = "address_city"
                    android.location.Geocoder r4 = new android.location.Geocoder
                    net.one97.paytm.recharge.common.utils.l r5 = net.one97.paytm.recharge.common.utils.l.this
                    android.app.Activity r5 = r5.f61671g
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    r4.<init>(r5, r6)
                    r10 = 1
                    r11 = 0
                    double r5 = r2     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    double r7 = r4     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    r9 = 1
                    java.util.List r4 = r4.getFromLocation(r5, r7, r9)     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    if (r4 == 0) goto L_0x0053
                    int r5 = r4.size()     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    if (r5 <= 0) goto L_0x0053
                    r5 = 0
                    java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    android.location.Address r4 = (android.location.Address) r4     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    r6.<init>()     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    java.lang.String r7 = r4.getLocality()     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    r6.append(r7)     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    java.lang.String r7 = r6.toString()     // Catch:{ IOException -> 0x00d0, all -> 0x0093 }
                    r6.setLength(r5)     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                    java.lang.String r4 = r4.getAdminArea()     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                    r6.append(r4)     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                    java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0050, all -> 0x004e }
                    goto L_0x0055
                L_0x004e:
                    r4 = move-exception
                    goto L_0x0095
                L_0x0050:
                    goto L_0x00d1
                L_0x0053:
                    r4 = r11
                    r7 = r4
                L_0x0055:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.recharge.common.utils.l r6 = net.one97.paytm.recharge.common.utils.l.this
                    net.one97.paytm.recharge.common.utils.l$a r6 = r6.f61673i
                    r5.setTarget(r6)
                    if (r7 != 0) goto L_0x006d
                    if (r4 == 0) goto L_0x0067
                    goto L_0x006d
                L_0x0067:
                    r5.what = r10
                    r5.setData(r11)
                    goto L_0x008f
                L_0x006d:
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
                L_0x008f:
                    r5.sendToTarget()
                    return
                L_0x0093:
                    r4 = move-exception
                    r7 = r11
                L_0x0095:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.recharge.common.utils.l r6 = net.one97.paytm.recharge.common.utils.l.this
                    net.one97.paytm.recharge.common.utils.l$a r6 = r6.f61673i
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x00c7
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
                    goto L_0x00cc
                L_0x00c7:
                    r5.what = r10
                    r5.setData(r11)
                L_0x00cc:
                    r5.sendToTarget()
                    throw r4
                L_0x00d0:
                    r7 = r11
                L_0x00d1:
                    android.os.Message r4 = android.os.Message.obtain()
                    net.one97.paytm.recharge.common.utils.l r5 = net.one97.paytm.recharge.common.utils.l.this
                    net.one97.paytm.recharge.common.utils.l$a r5 = r5.f61673i
                    r4.setTarget(r5)
                    if (r7 == 0) goto L_0x0103
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
                    goto L_0x0108
                L_0x0103:
                    r4.what = r10
                    r4.setData(r11)
                L_0x0108:
                    r4.sendToTarget()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.l.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean g() {
        if (s.a() && !s.e((Context) this.f61671g)) {
            s.d(this.f61671g);
            return false;
        } else if ((!s.a() || !s.e((Context) this.f61671g)) && s.a()) {
            return false;
        } else {
            return true;
        }
    }

    private void h() {
        if (androidx.core.app.a.a(this.f61666b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f61666b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.f61672h == null) {
                i();
            }
            f.f11373b.a(this.f61670f, this.f61672h, this.l);
        }
    }

    private void i() {
        this.f61672h = LocationRequest.a().a(100).a(10000).b(1000);
    }

    public final void b() {
        if (g() && this.f61670f != null && this.n != null) {
            f.f11375d.a(this.f61670f, this.n).a(this);
        }
    }

    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(l lVar, byte b2) {
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
                        if (l.j < 4) {
                            l.this.f();
                            return;
                        }
                        int unused = l.j = 0;
                        l.this.m.a((CJRUtilityLocationModel) null);
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
                int unused2 = l.j = 0;
                l.this.m.a(cJRUtilityLocationModel);
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(l lVar) {
        e eVar = lVar.f61670f;
        if (eVar != null && eVar.f()) {
            f.f11373b.a(lVar.f61670f, lVar.l);
        }
    }
}
