package net.one97.paytm.wallet.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.j;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.g;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.g.b.k;
import net.one97.paytm.wallet.R;

public final class AJRLocationCaptureActivity extends Activity implements net.one97.paytm.p2mNewDesign.f.b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f69887a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f69888b = true;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.gms.location.b f69889c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.wallet.dialog.b f69890d;

    /* renamed from: e  reason: collision with root package name */
    private final int f69891e = 101;

    /* renamed from: f  reason: collision with root package name */
    private long f69892f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f69893g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f69894h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f69895i = "";
    /* access modifiers changed from: private */
    public String j = "";
    /* access modifiers changed from: private */
    public final int k = 1;
    private final d l = new d(this);

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_capture);
        this.f69889c = com.google.android.gms.location.f.b((Activity) this);
        this.f69892f = net.one97.paytm.wallet.communicator.b.a().getLongFromGTM(this, "locationFetchTime");
        c();
    }

    private final void a(int i2) {
        this.f69890d = new net.one97.paytm.wallet.dialog.b(this, i2);
        net.one97.paytm.wallet.dialog.b bVar = this.f69890d;
        if (bVar == null) {
            k.a("dialog");
        }
        bVar.setCanceledOnTouchOutside(false);
        net.one97.paytm.wallet.dialog.b bVar2 = this.f69890d;
        if (bVar2 == null) {
            k.a("dialog");
        }
        bVar2.setOnDismissListener(new c(this));
        net.one97.paytm.wallet.dialog.b bVar3 = this.f69890d;
        if (bVar3 == null) {
            k.a("dialog");
        }
        bVar3.show();
    }

    static final class c implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRLocationCaptureActivity f69898a;

        c(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
            this.f69898a = aJRLocationCaptureActivity;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AJRLocationCaptureActivity.a(this.f69898a);
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.k) {
            return;
        }
        if (i3 == -1) {
            c();
        } else if (i3 == 0) {
            setResult(0);
            finish();
        }
    }

    static final class a<TResult> implements com.google.android.gms.tasks.c<Location> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRLocationCaptureActivity f69896a;

        a(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
            this.f69896a = aJRLocationCaptureActivity;
        }

        public final void a(Task<Location> task) {
            k.c(task, "task");
            Location d2 = task.d();
            if (d2 == null) {
                this.f69896a.setResult(0);
                this.f69896a.finish();
                return;
            }
            this.f69896a.f69895i = String.valueOf(d2.getLatitude());
            this.f69896a.j = String.valueOf(d2.getLongitude());
            AJRLocationCaptureActivity.b(this.f69896a);
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        Context context = this;
        if (!net.one97.paytm.wallet.utility.a.f(context)) {
            a(0);
        } else if (net.one97.paytm.wallet.utility.a.g(context)) {
            try {
                this.f69893g = new Handler();
                this.f69894h = new b(this);
                Handler handler = this.f69893g;
                if (handler != null) {
                    handler.postDelayed(this.f69894h, this.f69892f);
                }
            } catch (Exception e2) {
                net.one97.paytm.wallet.communicator.b.a().pushCrashEventToCrashlytics(getClass().getName(), e2.getMessage(), (Throwable) null);
            }
            d();
        } else {
            a(1);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRLocationCaptureActivity f69897a;

        b(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
            this.f69897a = aJRLocationCaptureActivity;
        }

        public final void run() {
            AJRLocationCaptureActivity.c(this.f69897a);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == this.f69891e) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                c();
            } else if (!androidx.core.app.a.a((Activity) this, "android.permission.ACCESS_FINE_LOCATION")) {
                this.f69888b = true;
                a(3);
            } else if (!this.f69887a) {
                this.f69887a = true;
                this.f69888b = true;
                a(2);
            } else {
                finish();
            }
        }
    }

    private final void d() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.a(100);
        locationRequest.a(5000);
        locationRequest.b(2000);
        locationRequest.b();
        this.f69889c = com.google.android.gms.location.f.b((Activity) this);
        com.google.android.gms.location.b bVar = this.f69889c;
        if (bVar != null) {
            bVar.a(locationRequest, this.l, Looper.myLooper());
        }
    }

    public static final class d extends com.google.android.gms.location.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRLocationCaptureActivity f69899a;

        d(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
            this.f69899a = aJRLocationCaptureActivity;
        }

        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Double d2 = null;
            Location a2 = locationResult != null ? locationResult.a() : null;
            this.f69899a.f69895i = String.valueOf(a2 != null ? Double.valueOf(a2.getLatitude()) : null);
            AJRLocationCaptureActivity aJRLocationCaptureActivity = this.f69899a;
            if (a2 != null) {
                d2 = Double.valueOf(a2.getLongitude());
            }
            aJRLocationCaptureActivity.j = String.valueOf(d2);
            AJRLocationCaptureActivity.b(this.f69899a);
        }
    }

    public final void a() {
        this.f69888b = false;
        net.one97.paytm.wallet.dialog.b bVar = this.f69890d;
        if (bVar == null) {
            k.a("dialog");
        }
        bVar.dismiss();
        net.one97.paytm.wallet.dialog.b bVar2 = this.f69890d;
        if (bVar2 == null) {
            k.a("dialog");
        }
        int i2 = bVar2.f70292b;
        if (i2 == 0) {
            net.one97.paytm.wallet.utility.a.a((Activity) this, this.f69891e);
        } else if (i2 == 1) {
            net.one97.paytm.wallet.utility.a.a((Activity) this, (OnSuccessListener<g>) new e(this), (OnFailureListener) new f(this));
        } else if (i2 == 2) {
            net.one97.paytm.wallet.utility.a.a((Activity) this, this.f69891e);
        } else if (i2 == 3) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), (String) null));
            startActivity(intent);
            finish();
        }
    }

    public static final class e implements OnSuccessListener<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRLocationCaptureActivity f69900a;

        e(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
            this.f69900a = aJRLocationCaptureActivity;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            this.f69900a.c();
        }
    }

    static final class f implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRLocationCaptureActivity f69901a;

        f(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
            this.f69901a = aJRLocationCaptureActivity;
        }

        public final void onFailure(Exception exc) {
            k.c(exc, "it");
            if (exc instanceof j) {
                try {
                    ((j) exc).startResolutionForResult(this.f69901a, this.f69901a.k);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }
    }

    public final void b() {
        net.one97.paytm.wallet.dialog.b bVar = this.f69890d;
        if (bVar == null) {
            k.a("dialog");
        }
        bVar.dismiss();
    }

    public static final /* synthetic */ void a(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
        if (aJRLocationCaptureActivity.f69888b && !aJRLocationCaptureActivity.isFinishing()) {
            aJRLocationCaptureActivity.finish();
        }
    }

    public static final /* synthetic */ void b(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
        Intent intent = new Intent();
        intent.putExtra("lat", aJRLocationCaptureActivity.f69895i);
        intent.putExtra("lng", aJRLocationCaptureActivity.j);
        aJRLocationCaptureActivity.setResult(-1, intent);
        Handler handler = aJRLocationCaptureActivity.f69893g;
        if (handler != null) {
            handler.removeCallbacks(aJRLocationCaptureActivity.f69894h);
        }
        com.google.android.gms.location.b bVar = aJRLocationCaptureActivity.f69889c;
        if (bVar != null) {
            bVar.a(aJRLocationCaptureActivity.l);
        }
        aJRLocationCaptureActivity.finish();
    }

    public static final /* synthetic */ void c(AJRLocationCaptureActivity aJRLocationCaptureActivity) {
        Task<Location> a2;
        com.google.android.gms.location.b bVar = aJRLocationCaptureActivity.f69889c;
        if (bVar != null && (a2 = bVar.a()) != null) {
            a2.a((com.google.android.gms.tasks.c<Location>) new a(aJRLocationCaptureActivity));
        }
    }
}
