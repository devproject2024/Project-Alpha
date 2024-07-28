package net.one97.paytm.o2o.amparkeventcommonlib.a;

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

public final class a implements e.b, e.c, m<LocationSettingsResult> {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static int f52447i;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f52448a = getClass().getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f52449b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public double f52450c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public double f52451d;

    /* renamed from: e  reason: collision with root package name */
    private e f52452e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Activity f52453f;

    /* renamed from: g  reason: collision with root package name */
    private LocationRequest f52454g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public C0938a f52455h;
    private final com.google.android.gms.location.e j = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = a.this.f52450c = location.getLatitude();
                double unused2 = a.this.f52451d = location.getLongitude();
                String unused3 = a.this.f52448a;
                q.d("Received Location update " + a.this.f52450c + " " + a.this.f52451d);
                a.d(a.this);
                a.this.f();
            }
        }
    };
    /* access modifiers changed from: private */
    public b k;
    private LocationSettingsRequest l;

    public interface b {
        void a(CJRUtilityLocationModel cJRUtilityLocationModel);

        boolean a();
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
            this.k.a();
            try {
                status.a(this.f52453f, 115);
            } catch (IntentSender.SendIntentException unused) {
                q.d("PendingIntent unable to execute request.");
            }
        } else if (i2 == 8502) {
            q.d("Location settings are inadequate, and cannot be fixed here. Dialog not created.");
        }
    }

    public a(Context context, Activity activity, e eVar, b bVar) {
        this.f52449b = context;
        this.f52453f = activity;
        this.f52452e = eVar;
        this.f52455h = new C0938a(this, (byte) 0);
        this.k = bVar;
        h();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f52454g);
        this.l = aVar.b();
    }

    public final void a() {
        try {
            if (e() && g() && this.f52452e != null) {
                if (androidx.core.app.a.a(this.f52449b, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    if (androidx.core.app.a.a(this.f52449b, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                        return;
                    }
                }
                Location a2 = f.f11373b.a(this.f52452e);
                if (a2 != null) {
                    this.f52450c = a2.getLatitude();
                    this.f52451d = a2.getLongitude();
                    f();
                } else if (androidx.core.app.a.a(this.f52449b, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f52449b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    if (this.f52454g == null) {
                        h();
                    }
                    f.f11373b.a(this.f52452e, this.f52454g, this.j);
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
            LocationManager locationManager = (LocationManager) this.f52449b.getSystemService("location");
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception e2) {
                e2.printStackTrace();
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
            } catch (Exception e3) {
                e3.printStackTrace();
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            this.k.a();
            return false;
        } catch (Exception e4) {
            q.b(e4.getMessage());
            this.k.a();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        f52447i++;
        a(this.f52450c, this.f52451d);
    }

    private void a(double d2, double d3) {
        final double d4 = d2;
        final double d5 = d3;
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00c4  */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00e7  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0100  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0123  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r12 = this;
                    java.lang.String r0 = "longitude"
                    java.lang.String r1 = "latitude"
                    java.lang.String r2 = "address_state"
                    java.lang.String r3 = "address_city"
                    android.location.Geocoder r4 = new android.location.Geocoder
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a r5 = net.one97.paytm.o2o.amparkeventcommonlib.a.a.this
                    android.app.Activity r5 = r5.f52453f
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    r4.<init>(r5, r6)
                    r10 = 1
                    r11 = 0
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a r5 = net.one97.paytm.o2o.amparkeventcommonlib.a.a.this     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.String unused = r5.f52448a     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.String r6 = "Getting address for location "
                    r5.<init>(r6)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    double r6 = r2     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    r5.append(r6)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.String r6 = " "
                    r5.append(r6)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    double r6 = r4     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    r5.append(r6)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    double r5 = r2     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    double r7 = r4     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    r9 = 1
                    java.util.List r4 = r4.getFromLocation(r5, r7, r9)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    if (r4 == 0) goto L_0x006b
                    int r5 = r4.size()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    if (r5 <= 0) goto L_0x006b
                    r5 = 0
                    java.lang.Object r4 = r4.get(r5)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    android.location.Address r4 = (android.location.Address) r4     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    r6.<init>()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.String r7 = r4.getLocality()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    r6.append(r7)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    java.lang.String r7 = r6.toString()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                    r6.setLength(r5)     // Catch:{ IOException -> 0x0069 }
                    java.lang.String r4 = r4.getAdminArea()     // Catch:{ IOException -> 0x0069 }
                    r6.append(r4)     // Catch:{ IOException -> 0x0069 }
                    java.lang.String r4 = r6.toString()     // Catch:{ IOException -> 0x0069 }
                    goto L_0x006d
                L_0x0069:
                    r4 = move-exception
                    goto L_0x00ad
                L_0x006b:
                    r4 = r11
                    r7 = r4
                L_0x006d:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a r6 = net.one97.paytm.o2o.amparkeventcommonlib.a.a.this
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a$a r6 = r6.f52455h
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x009f
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
                    goto L_0x00a4
                L_0x009f:
                    r5.what = r10
                    r5.setData(r11)
                L_0x00a4:
                    r5.sendToTarget()
                    return
                L_0x00a8:
                    r4 = move-exception
                    r7 = r11
                    goto L_0x00f1
                L_0x00ab:
                    r4 = move-exception
                    r7 = r11
                L_0x00ad:
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a r5 = net.one97.paytm.o2o.amparkeventcommonlib.a.a.this     // Catch:{ all -> 0x00f0 }
                    java.lang.String unused = r5.f52448a     // Catch:{ all -> 0x00f0 }
                    r4.getMessage()     // Catch:{ all -> 0x00f0 }
                    android.os.Message r4 = android.os.Message.obtain()
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a r5 = net.one97.paytm.o2o.amparkeventcommonlib.a.a.this
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a$a r5 = r5.f52455h
                    r4.setTarget(r5)
                    if (r7 == 0) goto L_0x00e7
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
                    goto L_0x00ec
                L_0x00e7:
                    r4.what = r10
                    r4.setData(r11)
                L_0x00ec:
                    r4.sendToTarget()
                    return
                L_0x00f0:
                    r4 = move-exception
                L_0x00f1:
                    android.os.Message r5 = android.os.Message.obtain()
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a r6 = net.one97.paytm.o2o.amparkeventcommonlib.a.a.this
                    net.one97.paytm.o2o.amparkeventcommonlib.a.a$a r6 = r6.f52455h
                    r5.setTarget(r6)
                    if (r7 == 0) goto L_0x0123
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
                    goto L_0x0128
                L_0x0123:
                    r5.what = r10
                    r5.setData(r11)
                L_0x0128:
                    r5.sendToTarget()
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amparkeventcommonlib.a.a.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean g() {
        if (s.a() && !s.e((Context) this.f52453f)) {
            s.d(this.f52453f);
            return false;
        } else if (!s.a() || s.e((Context) this.f52453f)) {
            return true;
        } else {
            return false;
        }
    }

    private void h() {
        this.f52454g = LocationRequest.a().a(100).a(10000).b(1000);
    }

    public final void b() {
        if (!g() || this.f52452e == null || this.l == null) {
            q.b("dasda");
        } else {
            f.f11375d.a(this.f52452e, this.l).a(this);
        }
    }

    /* renamed from: net.one97.paytm.o2o.amparkeventcommonlib.a.a$a  reason: collision with other inner class name */
    class C0938a extends Handler {
        private C0938a() {
        }

        /* synthetic */ C0938a(a aVar, byte b2) {
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
                        if (a.f52447i <= 0) {
                            a.this.f();
                        } else {
                            int unused = a.f52447i = 0;
                            a.this.k.a((CJRUtilityLocationModel) null);
                        }
                        String unused2 = a.this.f52448a;
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
                int unused3 = a.f52447i = 0;
                a.this.k.a(cJRUtilityLocationModel);
                String unused4 = a.this.f52448a;
                StringBuilder sb2 = new StringBuilder("Location City ");
                sb2.append(str4);
                sb2.append("Location state ");
                sb2.append(str3);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void d(a aVar) {
        try {
            f.f11373b.a(aVar.f52452e, aVar.j);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
