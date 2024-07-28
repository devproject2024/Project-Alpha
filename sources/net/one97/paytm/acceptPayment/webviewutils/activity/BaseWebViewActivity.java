package net.one97.paytm.acceptPayment.webviewutils.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.ValueCallback;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.d;
import com.paytm.utility.s;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.File;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.activities.BaseActivityWithoutContextWrapping;
import net.one97.paytm.acceptPayment.utils.LocationProvider;
import net.one97.paytm.acceptPayment.webviewutils.b.b;
import net.one97.paytm.acceptPayment.webviewutils.b.c;
import net.one97.paytm.acceptPayment.webviewutils.b.f;
import net.one97.paytm.acceptPayment.webviewutils.c.a;

public abstract class BaseWebViewActivity extends BaseActivityWithoutContextWrapping implements LocationProvider.a, a {

    /* renamed from: c  reason: collision with root package name */
    private Uri f52245c;

    /* renamed from: d  reason: collision with root package name */
    private ValueCallback<Uri[]> f52246d;

    /* renamed from: e  reason: collision with root package name */
    private b f52247e = new b(this);

    /* renamed from: f  reason: collision with root package name */
    private c f52248f = new c(this);

    /* renamed from: g  reason: collision with root package name */
    private LocationProvider f52249g;

    /* renamed from: h  reason: collision with root package name */
    private int f52250h = -1;

    public abstract void a(double d2, double d3, int i2, String str);

    public abstract void a(String str);

    public abstract void a(String str, String str2);

    public abstract Object b(String str);

    public abstract String c();

    public abstract void d();

    public abstract f e();

    public abstract void f();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f52249g = new LocationProvider(this, this, getLifecycle());
    }

    public void onResume() {
        super.onResume();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        int i3 = 0;
        if (i2 == 2) {
            while (i3 < iArr.length) {
                if (iArr[i3] != 0) {
                    a(strArr);
                    return;
                }
                i3++;
            }
            Message message = new Message();
            message.what = 3;
            message.obj = "javascript:accessGiven(\"camera\");";
            this.f52248f.sendMessage(message);
        } else if (i2 == 3) {
            while (i3 < iArr.length) {
                if (iArr[i3] != 0) {
                    a(strArr);
                    return;
                }
                i3++;
            }
            Message message2 = new Message();
            message2.what = 3;
            message2.obj = "javascript:accessGiven(\"gallery\");";
            this.f52248f.sendMessage(message2);
        } else if (i2 != 57) {
        } else {
            if (s.a(iArr)) {
                this.f52249g.a();
            } else if (s.a(strArr, iArr, "android.permission.ACCESS_FINE_LOCATION", this) != 1) {
                com.business.common_module.utilities.a.a(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a().getApplicationContext()).a("loc_perm_blocked", true, true);
                a(-1.0d, -1.0d, 703);
            } else {
                a(-1.0d, -1.0d, 702);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        Uri uri;
        ValueCallback<Uri[]> valueCallback;
        Uri data2;
        ValueCallback<Uri[]> valueCallback2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 7 || i2 == 220) {
            if (i2 != 7) {
                if (i2 == 220) {
                    if (i3 == -1) {
                        this.f52249g.b();
                    } else {
                        a(-1.0d, -1.0d, 704);
                    }
                }
            } else if (!s.e(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a())) {
                a(-1.0d, -1.0d, 703);
            } else {
                this.f52249g.a();
            }
        }
        if (i3 != -1) {
            try {
                if (this.f52246d != null) {
                    this.f52246d.onReceiveValue((Object) null);
                    this.f52246d = null;
                }
            } catch (Exception unused) {
                getClass().getSimpleName();
            }
        } else if (i2 == 5002) {
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_SETTINGS");
            intent2.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!(i2 != 5001 || (data2 = intent.getData()) == null || (valueCallback2 = this.f52246d) == null)) {
                valueCallback2.onReceiveValue(new Uri[]{data2});
                this.f52246d = null;
            }
            if (i2 == 5000 && (uri = this.f52245c) != null && (valueCallback = this.f52246d) != null) {
                valueCallback.onReceiveValue(new Uri[]{uri});
                this.f52246d = null;
            }
        } else if (i2 == 5000) {
            if (this.f52247e != null) {
                w.a().a(this.f52245c).a((af) this.f52247e);
            }
        } else if (i2 == 5001 && intent != null && (data = intent.getData()) != null && this.f52247e != null) {
            w.a().a(data).a((af) this.f52247e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.webkit.ValueCallback<android.net.Uri[]> r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0017
            r3 = 1911932022(0x71f5c476, float:2.4339627E30)
            if (r0 != r3) goto L_0x0021
            java.lang.String r0 = "image/*"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0021
            r7 = 0
            goto L_0x0022
        L_0x0017:
            java.lang.String r0 = ""
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0021
            r7 = 1
            goto L_0x0022
        L_0x0021:
            r7 = -1
        L_0x0022:
            r0 = 0
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r4 = "android.permission.READ_EXTERNAL_STORAGE"
            if (r7 == 0) goto L_0x0054
            if (r7 != r2) goto L_0x006d
            java.lang.String r7 = "android.permission.CAMERA"
            java.lang.String[] r3 = new java.lang.String[]{r7, r4, r3}
            int r7 = androidx.core.content.b.a((android.content.Context) r5, (java.lang.String) r7)
            if (r7 != 0) goto L_0x003e
            boolean r7 = net.one97.paytm.acceptPayment.webviewutils.a.c(r5)
            if (r7 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r1 = 1
        L_0x003f:
            if (r1 == 0) goto L_0x004b
            if (r6 == 0) goto L_0x0046
            r6.onReceiveValue(r0)
        L_0x0046:
            r6 = 2
            androidx.core.app.a.a(r5, r3, r6)
            return
        L_0x004b:
            r5.f52246d = r6
            android.net.Uri r6 = net.one97.paytm.acceptPayment.webviewutils.a.a(r5)
            r5.f52245c = r6
            return
        L_0x0054:
            boolean r7 = net.one97.paytm.acceptPayment.webviewutils.a.c(r5)
            if (r7 != 0) goto L_0x0068
            java.lang.String[] r7 = new java.lang.String[]{r4, r3}
            if (r6 == 0) goto L_0x0063
            r6.onReceiveValue(r0)
        L_0x0063:
            r6 = 3
            androidx.core.app.a.a(r5, r7, r6)
            return
        L_0x0068:
            r5.f52246d = r6
            net.one97.paytm.acceptPayment.webviewutils.a.b(r5)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity.a(android.webkit.ValueCallback, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, int r4) {
        /*
            r2 = this;
            net.one97.paytm.acceptPayment.webviewutils.b.b r0 = r2.f52247e
            r0.f52253b = r4
            int r4 = r3.hashCode()
            r0 = 1
            if (r4 == 0) goto L_0x001a
            r1 = 1911932022(0x71f5c476, float:2.4339627E30)
            if (r4 != r1) goto L_0x0024
            java.lang.String r4 = "image/*"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x001a:
            java.lang.String r4 = ""
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x0024:
            r3 = -1
        L_0x0025:
            if (r3 == 0) goto L_0x0030
            if (r3 != r0) goto L_0x0033
            android.net.Uri r3 = net.one97.paytm.acceptPayment.webviewutils.a.a(r2)
            r2.f52245c = r3
            return
        L_0x0030:
            net.one97.paytm.acceptPayment.webviewutils.a.b(r2)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.webviewutils.activity.BaseWebViewActivity.a(java.lang.String, int):void");
    }

    private void a(String[] strArr) {
        for (String a2 : strArr) {
            if (!androidx.core.app.a.a((Activity) this, a2)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getResources().getString(R.string.ap_transaction_id));
                builder.setMessage(getResources().getString(R.string.ap_one_more_permission_denied_permanantly));
                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        BaseWebViewActivity.this.a(dialogInterface, i2);
                    }
                }).show();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
        startActivityForResult(intent, 5002);
    }

    /* access modifiers changed from: protected */
    public final void a(ValueCallback<Uri[]> valueCallback) {
        this.f52246d = valueCallback;
    }

    /* access modifiers changed from: protected */
    public final ValueCallback<Uri[]> g() {
        return this.f52246d;
    }

    public final Handler h() {
        return this.f52248f;
    }

    public final void a(c cVar) {
        this.f52248f = cVar;
    }

    public final void c(String str) {
        Message message = new Message();
        message.what = 3;
        message.obj = "javascript:processImage(\"" + str + "\");";
        this.f52248f.sendMessage(message);
        try {
            File file = new File(this.f52245c.toString());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public final void i() {
        getClass().getSimpleName();
    }

    public final void a(int i2) {
        this.f52250h = i2;
        LocationProvider locationProvider = this.f52249g;
        if (locationProvider.f52152c.a()) {
            locationProvider.a();
        } else {
            locationProvider.f52152c.b();
        }
    }

    public final void a(j jVar) {
        int i2 = this.f52250h;
        if (i2 == 12) {
            try {
                jVar.startResolutionForResult(this, 220);
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        } else if (i2 == 17) {
            b(-1.0d, -1.0d, 602);
        }
    }

    public final void a(Location location) {
        com.google.android.gms.location.b bVar;
        LocationProvider locationProvider = this.f52249g;
        d dVar = locationProvider.f52151b;
        if (!(dVar == null || (bVar = locationProvider.f52150a) == null)) {
            bVar.a(dVar);
        }
        int i2 = this.f52250h;
        if (i2 == 12) {
            a(location.getLatitude(), location.getLongitude(), 701);
        } else if (i2 == 17) {
            b(location.getLatitude(), location.getLongitude(), 601);
        }
    }

    public final void b() {
        int i2 = this.f52250h;
        if (i2 != 12) {
            if (i2 == 17) {
                b(-1.0d, -1.0d, 602);
            }
        } else if (com.business.common_module.utilities.a.a(getApplicationContext()).b("loc_perm_blocked", false, true)) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivityForResult(intent, 7);
        } else {
            androidx.core.app.a.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 57);
        }
    }

    private void a(double d2, double d3, int i2) {
        a(d2, d3, i2, "userLocationCallback");
    }

    private void b(double d2, double d3, int i2) {
        a(d2, d3, i2, "silentLocationCallback");
    }

    public final boolean a() {
        return s.e(net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a());
    }
}
