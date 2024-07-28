package com.travel.train.j;

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
import com.travel.train.model.CJRUtilityLocationModel;

public final class d implements e.b, e.c, m<LocationSettingsResult> {
    /* access modifiers changed from: private */
    public static int k = 0;
    /* access modifiers changed from: private */
    public static String l = "CJRTrainUtils";

    /* renamed from: a  reason: collision with root package name */
    public boolean f27518a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f27519b = getClass().getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private Context f27520c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public double f27521d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public double f27522e;

    /* renamed from: f  reason: collision with root package name */
    private String f27523f = null;

    /* renamed from: g  reason: collision with root package name */
    private e f27524g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Activity f27525h;

    /* renamed from: i  reason: collision with root package name */
    private LocationRequest f27526i;
    /* access modifiers changed from: private */
    public a j;
    private final com.google.android.gms.location.e m = new com.google.android.gms.location.e() {
        public final void a(Location location) {
            if (location != null) {
                double unused = d.this.f27521d = location.getLatitude();
                double unused2 = d.this.f27522e = location.getLongitude();
                String unused3 = d.this.f27519b;
                StringBuilder sb = new StringBuilder("Received Location update ");
                sb.append(d.this.f27521d);
                sb.append(" ");
                sb.append(d.this.f27522e);
                f.f11373b.a(d.this.f27524g, d.this.m);
                d.this.g();
            }
        }
    };
    /* access modifiers changed from: private */
    public b n;
    private LocationSettingsRequest o;

    public interface b {
        void a(CJRUtilityLocationModel cJRUtilityLocationModel);

        void a(String str, String str2);

        void d();
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
            this.n.d();
            try {
                status.a(this.f27525h, 115);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public d(Context context, Activity activity, e eVar, b bVar) {
        this.f27520c = context;
        this.f27525h = activity;
        this.f27524g = eVar;
        this.j = new a(this, (byte) 0);
        this.n = bVar;
        j();
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.f27526i);
        this.o = aVar.b();
    }

    public final void a() {
        try {
            if (f() && h() && this.f27524g != null) {
                if (androidx.core.app.a.a(this.f27520c, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f27520c, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    Location a2 = f.f11373b.a(this.f27524g);
                    if (a2 != null) {
                        this.f27521d = a2.getLatitude();
                        this.f27522e = a2.getLongitude();
                        g();
                        return;
                    }
                    i();
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private boolean f() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f27520c.getSystemService("location");
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
            this.n.d();
            return false;
        } catch (Exception e4) {
            if (com.paytm.utility.b.v) {
                q.c(e4.getMessage());
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        k++;
        if (this.f27518a) {
            this.n.a(Double.toString(this.f27521d), Double.toString(this.f27522e));
        } else {
            a(this.f27521d, this.f27522e);
        }
    }

    private void a(double d2, double d3) {
        final double d4 = d2;
        final double d5 = d3;
        new Thread() {
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0167 A[ADDED_TO_REGION] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x01b4 A[ADDED_TO_REGION] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r19 = this;
                    r1 = r19
                    java.lang.String r2 = "longitude"
                    java.lang.String r3 = "latitude"
                    java.lang.String r4 = "address_line"
                    java.lang.String r5 = "default_address_pincode"
                    java.lang.String r6 = "address_state"
                    java.lang.String r7 = "address_city"
                    android.location.Geocoder r8 = new android.location.Geocoder
                    com.travel.train.j.d r0 = com.travel.train.j.d.this
                    android.app.Activity r0 = r0.f27525h
                    java.util.Locale r9 = java.util.Locale.ENGLISH
                    r8.<init>(r0, r9)
                    com.travel.train.j.d r0 = com.travel.train.j.d.this     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.String unused = r0.f27519b     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.String r9 = "Getting address for location "
                    r0.<init>(r9)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    double r9 = r2     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    r0.append(r9)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.String r9 = " "
                    r0.append(r9)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    double r9 = r4     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    r0.append(r9)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    double r9 = r2     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    double r11 = r4     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    r13 = 1
                    java.util.List r0 = r8.getFromLocation(r9, r11, r13)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    if (r0 == 0) goto L_0x00f6
                    int r8 = r0.size()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    if (r8 <= 0) goto L_0x00f6
                    r8 = 0
                    java.lang.Object r0 = r0.get(r8)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    android.location.Address r0 = (android.location.Address) r0     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    r9.<init>()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.String r10 = r0.getLocality()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    r9.append(r10)     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    java.lang.String r10 = r9.toString()     // Catch:{ IOException -> 0x014b, all -> 0x0145 }
                    r9.setLength(r8)     // Catch:{ IOException -> 0x00f0, all -> 0x00ed }
                    java.lang.String r11 = r0.getAdminArea()     // Catch:{ IOException -> 0x00f0, all -> 0x00ed }
                    r9.append(r11)     // Catch:{ IOException -> 0x00f0, all -> 0x00ed }
                    java.lang.String r11 = r9.toString()     // Catch:{ IOException -> 0x00f0, all -> 0x00ed }
                    r9.setLength(r8)     // Catch:{ IOException -> 0x00e9, all -> 0x00e6 }
                    java.lang.String r12 = r0.getPostalCode()     // Catch:{ IOException -> 0x00e9, all -> 0x00e6 }
                    r9.append(r12)     // Catch:{ IOException -> 0x00e9, all -> 0x00e6 }
                    java.lang.String r12 = r9.toString()     // Catch:{ IOException -> 0x00e9, all -> 0x00e6 }
                    r9.setLength(r8)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.String r13 = ", "
                    com.google.a.a.b.a.a.a.a.a r15 = new com.google.a.a.b.a.a.a.a.a     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r15.<init>((java.lang.String) r13)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    com.google.a.a.b.a.a.a.a.a$1 r13 = new com.google.a.a.b.a.a.a.a.a$1     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r13.<init>(r15)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.String r15 = r0.getFeatureName()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    if (r15 == 0) goto L_0x0094
                    java.lang.String r15 = r0.getFeatureName()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    goto L_0x0098
                L_0x0094:
                    java.lang.String r15 = r0.getPremises()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                L_0x0098:
                    java.lang.String r14 = r0.getSubThoroughfare()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r8 = 2
                    java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.String r18 = r0.getThoroughfare()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r17 = 0
                    r8[r17] = r18     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.String r0 = r0.getSubLocality()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r16 = 1
                    r8[r16] = r0     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    com.google.a.a.b.a.a.a.a.c.a(r8)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    com.google.a.a.b.a.a.a.a.a$2 r0 = new com.google.a.a.b.a.a.a.a.a$2     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r0.<init>(r8, r15, r14)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r8.<init>()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.StringBuilder r0 = r13.a((java.lang.StringBuilder) r8, (java.util.Iterator<?>) r0)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r9.append(r0)     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    java.lang.String r15 = r9.toString()     // Catch:{ IOException -> 0x00e1, all -> 0x00dd }
                    r0 = 0
                    r9.setLength(r0)     // Catch:{ IOException -> 0x00d8, all -> 0x00d4 }
                    goto L_0x00fa
                L_0x00d4:
                    r0 = move-exception
                    r8 = r15
                    goto L_0x01a5
                L_0x00d8:
                    r0 = move-exception
                    r8 = r15
                    r15 = r10
                    goto L_0x0150
                L_0x00dd:
                    r0 = move-exception
                    r8 = 0
                    goto L_0x01a5
                L_0x00e1:
                    r0 = move-exception
                    r15 = r10
                    r8 = 0
                    goto L_0x0150
                L_0x00e6:
                    r0 = move-exception
                    r8 = 0
                    goto L_0x0149
                L_0x00e9:
                    r0 = move-exception
                    r15 = r10
                    r8 = 0
                    goto L_0x00f4
                L_0x00ed:
                    r0 = move-exception
                    r8 = 0
                    goto L_0x0148
                L_0x00f0:
                    r0 = move-exception
                    r15 = r10
                    r8 = 0
                    r11 = 0
                L_0x00f4:
                    r12 = 0
                    goto L_0x0150
                L_0x00f6:
                    r10 = 0
                    r11 = 0
                    r12 = 0
                    r15 = 0
                L_0x00fa:
                    android.os.Message r0 = android.os.Message.obtain()
                    com.travel.train.j.d r8 = com.travel.train.j.d.this
                    com.travel.train.j.d$a r8 = r8.j
                    r0.setTarget(r8)
                    if (r10 != 0) goto L_0x0118
                    if (r11 != 0) goto L_0x0118
                    if (r12 != 0) goto L_0x0118
                    if (r15 == 0) goto L_0x0110
                    goto L_0x0118
                L_0x0110:
                    r8 = 1
                    r0.what = r8
                    r2 = 0
                    r0.setData(r2)
                    goto L_0x0141
                L_0x0118:
                    r8 = 1
                    r0.what = r8
                    android.os.Bundle r8 = new android.os.Bundle
                    r8.<init>()
                    r8.putString(r7, r10)
                    r8.putString(r6, r11)
                    r8.putString(r5, r12)
                    r8.putString(r4, r15)
                    double r4 = r2
                    java.lang.String r4 = java.lang.Double.toString(r4)
                    r8.putString(r3, r4)
                    double r3 = r4
                    java.lang.String r3 = java.lang.Double.toString(r3)
                    r8.putString(r2, r3)
                    r0.setData(r8)
                L_0x0141:
                    r0.sendToTarget()
                    return
                L_0x0145:
                    r0 = move-exception
                    r8 = 0
                    r10 = 0
                L_0x0148:
                    r11 = 0
                L_0x0149:
                    r12 = 0
                    goto L_0x01a5
                L_0x014b:
                    r0 = move-exception
                    r8 = 0
                    r11 = 0
                    r12 = 0
                    r15 = 0
                L_0x0150:
                    com.travel.train.j.d r9 = com.travel.train.j.d.this     // Catch:{ all -> 0x01a3 }
                    java.lang.String unused = r9.f27519b     // Catch:{ all -> 0x01a3 }
                    r0.getMessage()     // Catch:{ all -> 0x01a3 }
                    android.os.Message r0 = android.os.Message.obtain()
                    com.travel.train.j.d r9 = com.travel.train.j.d.this
                    com.travel.train.j.d$a r9 = r9.j
                    r0.setTarget(r9)
                    if (r15 != 0) goto L_0x0176
                    if (r11 != 0) goto L_0x0176
                    if (r12 != 0) goto L_0x0176
                    if (r8 == 0) goto L_0x016e
                    goto L_0x0176
                L_0x016e:
                    r9 = 1
                    r0.what = r9
                    r2 = 0
                    r0.setData(r2)
                    goto L_0x019f
                L_0x0176:
                    r9 = 1
                    r0.what = r9
                    android.os.Bundle r9 = new android.os.Bundle
                    r9.<init>()
                    r9.putString(r7, r15)
                    r9.putString(r6, r11)
                    r9.putString(r5, r12)
                    r9.putString(r4, r8)
                    double r4 = r2
                    java.lang.String r4 = java.lang.Double.toString(r4)
                    r9.putString(r3, r4)
                    double r3 = r4
                    java.lang.String r3 = java.lang.Double.toString(r3)
                    r9.putString(r2, r3)
                    r0.setData(r9)
                L_0x019f:
                    r0.sendToTarget()
                    return
                L_0x01a3:
                    r0 = move-exception
                    r10 = r15
                L_0x01a5:
                    android.os.Message r9 = android.os.Message.obtain()
                    com.travel.train.j.d r13 = com.travel.train.j.d.this
                    com.travel.train.j.d$a r13 = r13.j
                    r9.setTarget(r13)
                    if (r10 != 0) goto L_0x01c3
                    if (r11 != 0) goto L_0x01c3
                    if (r12 != 0) goto L_0x01c3
                    if (r8 == 0) goto L_0x01bb
                    goto L_0x01c3
                L_0x01bb:
                    r13 = 1
                    r9.what = r13
                    r2 = 0
                    r9.setData(r2)
                    goto L_0x01ec
                L_0x01c3:
                    r13 = 1
                    r9.what = r13
                    android.os.Bundle r13 = new android.os.Bundle
                    r13.<init>()
                    r13.putString(r7, r10)
                    r13.putString(r6, r11)
                    r13.putString(r5, r12)
                    r13.putString(r4, r8)
                    double r4 = r2
                    java.lang.String r4 = java.lang.Double.toString(r4)
                    r13.putString(r3, r4)
                    double r3 = r4
                    java.lang.String r3 = java.lang.Double.toString(r3)
                    r13.putString(r2, r3)
                    r9.setData(r13)
                L_0x01ec:
                    r9.sendToTarget()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.d.AnonymousClass2.run():void");
            }
        }.start();
    }

    private boolean h() {
        if (s.a() && !s.e((Context) this.f27525h)) {
            s.d(this.f27525h);
            return false;
        } else if ((!s.a() || !s.e((Context) this.f27525h)) && s.a()) {
            return false;
        } else {
            return true;
        }
    }

    private void i() {
        if (androidx.core.app.a.a(this.f27520c, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(this.f27520c, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.f27526i == null) {
                j();
            }
            f.f11373b.a(this.f27524g, this.f27526i, this.m);
        }
    }

    private void j() {
        this.f27526i = LocationRequest.a().a(102).a(10000).b(1000);
    }

    public final void b() {
        if (h() && this.f27524g != null && this.o != null) {
            f.f11375d.a(this.f27524g, this.o).a(this);
        }
    }

    class a extends Handler {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            try {
                if (message.what != 1) {
                    str = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                } else {
                    Bundle data = message.getData();
                    str6 = data.getString("address_city");
                    str5 = data.getString("address_state");
                    str4 = data.getString("default_address_pincode");
                    str3 = data.getString("address_line");
                    str2 = data.getString("latitude");
                    str = data.getString("longitude");
                }
                CJRUtilityLocationModel cJRUtilityLocationModel = new CJRUtilityLocationModel();
                if (str6 == null) {
                    if (str5 == null) {
                        if (d.k < 4) {
                            d.this.g();
                        } else {
                            int unused = d.k = 0;
                            d.this.n.a((CJRUtilityLocationModel) null);
                        }
                        String unused2 = d.this.f27519b;
                        StringBuilder sb = new StringBuilder("Location City ");
                        sb.append(str6);
                        sb.append("Location state ");
                        sb.append(str5);
                    }
                }
                if (str6 != null) {
                    cJRUtilityLocationModel.setCity(str6);
                }
                if (str5 != null) {
                    cJRUtilityLocationModel.setState(str5);
                }
                if (str4 != null) {
                    cJRUtilityLocationModel.setPinCode(str4);
                }
                if (str3 != null) {
                    cJRUtilityLocationModel.setAddressLine(str3);
                }
                if (str2 != null) {
                    cJRUtilityLocationModel.setLatitude(str2);
                }
                if (str != null) {
                    cJRUtilityLocationModel.setLongitude(str);
                }
                int unused3 = d.k = 0;
                d.this.n.a(cJRUtilityLocationModel);
                String unused4 = d.this.f27519b;
                StringBuilder sb2 = new StringBuilder("Location City ");
                sb2.append(str6);
                sb2.append("Location state ");
                sb2.append(str5);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    String unused5 = d.l;
                    q.c(e2.getMessage());
                }
            }
        }
    }
}
