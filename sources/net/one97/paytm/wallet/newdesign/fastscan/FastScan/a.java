package net.one97.paytm.wallet.newdesign.fastscan.FastScan;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.perf.metrics.Trace;
import java.util.HashMap;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.common.widget.VerticalSeekBar;
import net.one97.paytm.fastscanner.b.d;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;

public final class a extends net.one97.paytm.wallet.newdesign.fastscan.a {
    private float s;
    private HashMap t;

    static final class b<T> implements z<net.one97.paytm.wallet.a.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70880a;

        b(a aVar) {
            this.f70880a = aVar;
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    public final View a(int i2) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        View view = (View) this.t.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.t.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void c() {
        HashMap hashMap = this.t;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    static final class l<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70895a;

        l(a aVar) {
            this.f70895a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f70895a.o = true;
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        Trace a2 = com.google.firebase.perf.a.a("FastScanFragmentV2_onCreate");
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getBoolean("isFromMiddleScan");
            this.f70910c = arguments.getBoolean("isShowInvoke");
            this.f70911e = arguments.getString("qrCodeId");
            this.f70909b = arguments.getBoolean(UpiConstants.KEY_IS_SCAN_ONLY);
        }
        this.r = net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(getContext(), "isAutoFlashEnabled", true);
        if (this.r) {
            Context context = getContext();
            Sensor sensor = null;
            this.l = (SensorManager) (context != null ? context.getSystemService("sensor") : null);
            SensorManager sensorManager = this.l;
            if (sensorManager != null) {
                sensor = sensorManager.getDefaultSensor(5);
            }
            this.m = sensor;
            SensorManager sensorManager2 = this.l;
            if (sensorManager2 != null) {
                sensorManager2.registerListener(this, this.m, 2);
            }
            net.one97.paytm.fastscanner.c.a aVar = net.one97.paytm.fastscanner.c.a.f50448b;
            net.one97.paytm.fastscanner.c.a.a((net.one97.paytm.fastscanner.c.d) this);
        }
        a2.stop();
    }

    public final int g() {
        return R.layout.fast_scan_fragment_v2;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        AppCompatImageView appCompatImageView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            if (androidx.core.content.b.a(context, "android.permission.CAMERA") == -1) {
                b(0);
            } else {
                b(8);
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            kotlin.g.b.k.a((Object) activity, "it");
            if (activity.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.toggle_torch_iv);
                if (relativeLayout != null) {
                    relativeLayout.setOnClickListener(new c(this, view));
                }
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.toggle_torch_iv);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
            }
        }
        SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.qrCodeSurfaceView);
        if (surfaceView != null) {
            surfaceView.setOnTouchListener(new d(this));
        }
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) view.findViewById(R.id.back_arrow_iv);
        if (appCompatImageView4 != null) {
            appCompatImageView4.setOnClickListener(new e(this));
        }
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) view.findViewById(R.id.lyt_camera_permission_close);
        if (appCompatImageView5 != null) {
            appCompatImageView5.setOnClickListener(new f(this));
        }
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(getActivity(), "isGalleryEnabledV2", true)) {
            View view2 = getView();
            if (!(view2 == null || (appCompatImageView3 = (AppCompatImageView) view2.findViewById(R.id.galley_scan)) == null)) {
                appCompatImageView3.setVisibility(0);
            }
        } else {
            View view3 = getView();
            if (!(view3 == null || (appCompatImageView2 = (AppCompatImageView) view3.findViewById(R.id.galley_scan)) == null)) {
                appCompatImageView2.setVisibility(8);
            }
        }
        View view4 = getView();
        if (!(view4 == null || (linearLayout3 = (LinearLayout) view4.findViewById(R.id.captureEnableCameraButton)) == null)) {
            linearLayout3.setOnClickListener(new h(this));
        }
        View view5 = getView();
        if (!(view5 == null || (linearLayout2 = (LinearLayout) view5.findViewById(R.id.lyt_show_payment_code)) == null)) {
            linearLayout2.setOnClickListener(new i(this));
        }
        View view6 = getView();
        if (!(view6 == null || (linearLayout = (LinearLayout) view6.findViewById(R.id.lyt_permission_show_payment_code)) == null)) {
            linearLayout.setOnClickListener(new j(this));
        }
        View view7 = getView();
        if (!(view7 == null || (appCompatImageView = (AppCompatImageView) view7.findViewById(R.id.galley_scan)) == null)) {
            appCompatImageView.setOnClickListener(new k(this));
        }
        VerticalSeekBar verticalSeekBar = (VerticalSeekBar) view.findViewById(R.id.zoom_seek_bar);
        kotlin.g.b.k.a((Object) verticalSeekBar, "view.zoom_seek_bar");
        verticalSeekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.MULTIPLY);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f70882b;

        c(a aVar, View view) {
            this.f70881a = aVar;
            this.f70882b = view;
        }

        public final void onClick(View view) {
            this.f70881a.f();
        }
    }

    static final class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70883a;

        d(a aVar) {
            this.f70883a = aVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            a aVar = this.f70883a;
            kotlin.g.b.k.a((Object) motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            return aVar.b(motionEvent);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70884a;

        e(a aVar) {
            this.f70884a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f70884a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70885a;

        f(a aVar) {
            this.f70885a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f70885a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70887a;

        h(a aVar) {
            this.f70887a = aVar;
        }

        public final void onClick(View view) {
            this.f70887a.i();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70888a;

        i(a aVar) {
            this.f70888a = aVar;
        }

        public final void onClick(View view) {
            this.f70888a.o();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70889a;

        j(a aVar) {
            this.f70889a = aVar;
        }

        public final void onClick(View view) {
            this.f70889a.o();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70890a;

        k(a aVar) {
            this.f70890a = aVar;
        }

        public final void onClick(View view) {
            if (this.f70890a.f70915i != null && b.e()) {
                this.f70890a.f();
            }
            this.f70890a.a("android.permission.READ_EXTERNAL_STORAGE", new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ k f70891a;

                {
                    this.f70891a = r1;
                }

                public final void run() {
                    this.f70891a.f70890a.a("android.permission.ACCESS_FINE_LOCATION", new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f70892a;

                        {
                            this.f70892a = r1;
                        }

                        public final void run() {
                            if (net.one97.paytm.wallet.utility.a.g(this.f70892a.f70891a.f70890a.getContext())) {
                                net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
                                net.one97.paytm.wallet.a.a.b(this.f70892a.f70891a.f70890a.f70909b);
                                this.f70892a.f70891a.f70890a.d().aH_();
                                return;
                            }
                            net.one97.paytm.wallet.utility.a.a((Activity) this.f70892a.f70891a.f70890a.getActivity(), (OnSuccessListener<com.google.android.gms.location.g>) AnonymousClass1.f70893a, (OnFailureListener) new OnFailureListener(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ AnonymousClass1 f70894a;

                                {
                                    this.f70894a = r1;
                                }

                                public final void onFailure(Exception exc) {
                                    kotlin.g.b.k.c(exc, "it");
                                    if (exc instanceof com.google.android.gms.common.api.j) {
                                        try {
                                            a aVar = this.f70894a.f70892a.f70891a.f70890a;
                                            PendingIntent resolution = ((com.google.android.gms.common.api.j) exc).getResolution();
                                            kotlin.g.b.k.a((Object) resolution, "it.resolution");
                                            aVar.startIntentSenderForResult(resolution.getIntentSender(), this.f70894a.f70892a.f70891a.f70890a.q, (Intent) null, 0, 0, 0, (Bundle) null);
                                        } catch (IntentSender.SendIntentException unused) {
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }
    }

    public final void p() {
        y<Boolean> yVar;
        super.p();
        b bVar = this.f70915i;
        if (bVar != null && (yVar = bVar.f70901d) != null) {
            yVar.observe(getViewLifecycleOwner(), new l(this));
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70896a;

        m(a aVar) {
            this.f70896a = aVar;
        }

        public final void run() {
            TextView textView;
            RelativeLayout relativeLayout;
            View view = this.f70896a.getView();
            if (!(view == null || (relativeLayout = (RelativeLayout) view.findViewById(R.id.scan_align_rect)) == null)) {
                Context context = this.f70896a.getContext();
                relativeLayout.setBackground(context != null ? androidx.core.content.b.a(context, R.drawable.scan_align_qr_alert_rect) : null);
            }
            ScanAnimationView scanAnimationView = (ScanAnimationView) this.f70896a.a(R.id.lineAnimationImageView);
            if (scanAnimationView != null) {
                scanAnimationView.setAnimationColor(this.f70896a.getResources().getColor(R.color.scan_animation_alert_color));
            }
            View view2 = this.f70896a.getView();
            if (!(view2 == null || (textView = (TextView) view2.findViewById(R.id.alignQrAlert)) == null)) {
                textView.setVisibility(0);
            }
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ m f70897a;

                {
                    this.f70897a = r1;
                }

                public final void run() {
                    RelativeLayout relativeLayout;
                    TextView textView;
                    View view = this.f70897a.f70896a.getView();
                    if (!(view == null || (textView = (TextView) view.findViewById(R.id.alignQrAlert)) == null)) {
                        textView.setVisibility(8);
                    }
                    View view2 = this.f70897a.f70896a.getView();
                    if (!(view2 == null || (relativeLayout = (RelativeLayout) view2.findViewById(R.id.scan_align_rect)) == null)) {
                        Context context = this.f70897a.f70896a.getContext();
                        relativeLayout.setBackground(context != null ? androidx.core.content.b.a(context, R.drawable.scan_blue_rect) : null);
                    }
                    ScanAnimationView scanAnimationView = (ScanAnimationView) this.f70897a.f70896a.a(R.id.lineAnimationImageView);
                    if (scanAnimationView != null) {
                        scanAnimationView.setAnimationColor(this.f70897a.f70896a.getResources().getColor(R.color.scan_animation_color));
                    }
                }
            }, 8000);
        }
    }

    public final void onPause() {
        TextView textView;
        RelativeLayout relativeLayout;
        super.onPause();
        kotlin.g.b.k.a((Object) net.one97.paytm.p2mNewDesign.models.b.c(), "QrScanSessionLogger.getInstance()");
        if (net.one97.paytm.p2mNewDesign.models.b.b()) {
            net.one97.paytm.p2mNewDesign.models.b.c().b("Background");
        }
        Handler handler = this.f70913g;
        Drawable drawable = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        View view = getView();
        if (!(view == null || (relativeLayout = (RelativeLayout) view.findViewById(R.id.scan_align_rect)) == null)) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.b.a(context, R.drawable.scan_blue_rect);
            }
            relativeLayout.setBackground(drawable);
        }
        ((ScanAnimationView) a(R.id.lineAnimationImageView)).setAnimationColor(getResources().getColor(R.color.scan_animation_color));
        if (this.f70915i != null) {
            b.b();
        }
        if (this.f70915i != null) {
            b.d();
        }
        this.o = false;
        View view2 = getView();
        if (view2 != null) {
            kotlin.g.b.k.a((Object) view2, "v");
            AppCompatImageView appCompatImageView = (AppCompatImageView) view2.findViewById(R.id.torch_on_iv);
            kotlin.g.b.k.a((Object) appCompatImageView, "v.torch_on_iv");
            appCompatImageView.setVisibility(8);
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view2.findViewById(R.id.torch_off_iv);
            kotlin.g.b.k.a((Object) appCompatImageView2, "v.torch_off_iv");
            appCompatImageView2.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.toggle_torch_iv);
            if (relativeLayout2 != null) {
                relativeLayout2.setContentDescription(getString(R.string.tb_flash_off));
            }
        }
        ScanAnimationView scanAnimationView = (ScanAnimationView) a(R.id.lineAnimationImageView);
        if (scanAnimationView != null) {
            scanAnimationView.b();
        }
        View view3 = getView();
        if (view3 != null && (textView = (TextView) view3.findViewById(R.id.alignQrAlert)) != null) {
            textView.setVisibility(8);
        }
    }

    public final void onDestroy() {
        y<net.one97.paytm.wallet.a.d> yVar;
        SensorManager sensorManager;
        net.one97.paytm.fastscanner.c.a aVar = net.one97.paytm.fastscanner.c.a.f50448b;
        net.one97.paytm.fastscanner.c.a.a((net.one97.paytm.fastscanner.c.d) null);
        if (this.f70915i != null) {
            b.c();
        }
        if (this.r && (sensorManager = this.l) != null) {
            sensorManager.unregisterListener(this, this.m);
        }
        b bVar = this.f70915i;
        if (!(bVar == null || (yVar = bVar.f70899b) == null)) {
            yVar.removeObserver(new b(this));
        }
        net.one97.paytm.wallet.newdesign.fastscan.b bVar2 = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
        net.one97.paytm.wallet.newdesign.fastscan.b.b(false);
        super.onDestroy();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1802 && i3 == -1) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            activity.setResult(-1);
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            activity2.finish();
        } else if (i3 == -1 && i2 == 9) {
            net.one97.paytm.wallet.utility.a.a(intent, (Activity) getActivity());
        } else if (i3 == -1 && i2 == 301) {
            RecentDataNetworkManager.initializeRecentPaymentsDownload(getActivity());
        } else if (i3 == -1 && i2 == this.q) {
            net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
            net.one97.paytm.wallet.a.a.b(this.f70909b);
            d().aH_();
        }
    }

    public final void f() {
        RelativeLayout relativeLayout;
        if (isResumed() && this.f70915i != null) {
            boolean z = !b.e();
            if (z) {
                View view = getView();
                if (view != null) {
                    kotlin.g.b.k.a((Object) view, "v");
                    AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.torch_on_iv);
                    kotlin.g.b.k.a((Object) appCompatImageView, "v.torch_on_iv");
                    appCompatImageView.setVisibility(0);
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.torch_off_iv);
                    kotlin.g.b.k.a((Object) appCompatImageView2, "v.torch_off_iv");
                    appCompatImageView2.setVisibility(8);
                }
            } else {
                View view2 = getView();
                if (view2 != null) {
                    kotlin.g.b.k.a((Object) view2, "v");
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) view2.findViewById(R.id.torch_on_iv);
                    kotlin.g.b.k.a((Object) appCompatImageView3, "v.torch_on_iv");
                    appCompatImageView3.setVisibility(8);
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) view2.findViewById(R.id.torch_off_iv);
                    kotlin.g.b.k.a((Object) appCompatImageView4, "v.torch_off_iv");
                    appCompatImageView4.setVisibility(0);
                }
                SensorManager sensorManager = this.l;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.m);
                }
                net.one97.paytm.fastscanner.c.a aVar = net.one97.paytm.fastscanner.c.a.f50448b;
                net.one97.paytm.fastscanner.c.a.a((net.one97.paytm.fastscanner.c.d) null);
            }
            View view3 = getView();
            if (!(view3 == null || (relativeLayout = (RelativeLayout) view3.findViewById(R.id.toggle_torch_iv)) == null)) {
                relativeLayout.setContentDescription(getString(z ? R.string.tb_flash_on : R.string.tb_flash_off));
            }
            net.one97.paytm.wallet.a.a aVar2 = net.one97.paytm.wallet.a.a.f69839a;
            boolean z2 = this.f70909b;
            Map hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            hashMap.put("new_wallet_pay_flash_options", z ? "flashOFF" : "flashOn");
            hashMap.put("scan_source_screen_type", z2 ? "scan_icon" : "pay_icon");
            String str = z ? "scan_screen_flashoff_clicked" : "scan_screen_flashon_clicked";
            String str2 = z2 ? "flow_through_scan_icon" : "flow_through_pay_icon";
            Context a2 = net.one97.paytm.wallet.a.a.a();
            kotlin.g.b.k.a((Object) a2, "getContext()");
            net.one97.paytm.wallet.a.a.a("offline_payments", str, str2, a2, "home/pay-send/post-scan");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(net.one97.paytm.wallet.a.a.a(), "new_wallet_pay_flash_options_clicked", hashMap);
            if (this.f70915i != null) {
                b.a(z);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:(1:58)|59|60|61|62|(2:64|(1:66))|67|68|(4:74|(1:78)|79|(1:83))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0111 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r0 = 0
            net.one97.paytm.fastscanner.b.d r1 = net.one97.paytm.fastscanner.b.d.f50426a     // Catch:{ Exception -> 0x014e }
            android.hardware.Camera r1 = net.one97.paytm.fastscanner.b.d.g()     // Catch:{ Exception -> 0x014e }
            if (r1 == 0) goto L_0x000e
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x014e }
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            int r2 = r8.getAction()     // Catch:{ Exception -> 0x014e }
            int r3 = r8.getPointerCount()     // Catch:{ Exception -> 0x014e }
            r4 = 8
            r5 = 1
            if (r3 <= r5) goto L_0x00d2
            r3 = 5
            if (r2 != r3) goto L_0x0027
            float r8 = a((android.view.MotionEvent) r8)     // Catch:{ Exception -> 0x014e }
            r7.s = r8     // Catch:{ Exception -> 0x014e }
            goto L_0x014d
        L_0x0027:
            r3 = 2
            if (r2 != r3) goto L_0x014d
            if (r1 != 0) goto L_0x002f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x014e }
        L_0x002f:
            boolean r2 = r1.isZoomSupported()     // Catch:{ Exception -> 0x014e }
            if (r2 == 0) goto L_0x014d
            net.one97.paytm.fastscanner.b.d r2 = net.one97.paytm.fastscanner.b.d.f50426a     // Catch:{ Exception -> 0x014e }
            android.hardware.Camera r2 = net.one97.paytm.fastscanner.b.d.g()     // Catch:{ Exception -> 0x014e }
            if (r2 == 0) goto L_0x0040
            r2.cancelAutoFocus()     // Catch:{ Exception -> 0x014e }
        L_0x0040:
            int r2 = r1.getMaxZoom()     // Catch:{ Exception -> 0x014e }
            int r3 = r1.getZoom()     // Catch:{ Exception -> 0x014e }
            float r8 = a((android.view.MotionEvent) r8)     // Catch:{ Exception -> 0x014e }
            float r6 = r7.s     // Catch:{ Exception -> 0x014e }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0057
            if (r3 >= r2) goto L_0x0061
            int r3 = r3 + 1
            goto L_0x0061
        L_0x0057:
            float r6 = r7.s     // Catch:{ Exception -> 0x014e }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0061
            if (r3 <= 0) goto L_0x0061
            int r3 = r3 + -1
        L_0x0061:
            r7.s = r8     // Catch:{ Exception -> 0x014e }
            r1.setZoom(r3)     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x0079
            int r6 = net.one97.paytm.wallet.R.id.zoom_seek_bar     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r6)     // Catch:{ Exception -> 0x014e }
            net.one97.paytm.common.widget.VerticalSeekBar r8 = (net.one97.paytm.common.widget.VerticalSeekBar) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x0079
            r8.setMax(r2)     // Catch:{ Exception -> 0x014e }
        L_0x0079:
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x008c
            int r2 = net.one97.paytm.wallet.R.id.zoom_seek_bar     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r2)     // Catch:{ Exception -> 0x014e }
            net.one97.paytm.common.widget.VerticalSeekBar r8 = (net.one97.paytm.common.widget.VerticalSeekBar) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x008c
            r8.setProgress(r3)     // Catch:{ Exception -> 0x014e }
        L_0x008c:
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x009f
            int r2 = net.one97.paytm.wallet.R.id.zoom_seek_bar     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r2)     // Catch:{ Exception -> 0x014e }
            net.one97.paytm.common.widget.VerticalSeekBar r8 = (net.one97.paytm.common.widget.VerticalSeekBar) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x009f
            r8.setClickable(r0)     // Catch:{ Exception -> 0x014e }
        L_0x009f:
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x00b2
            int r2 = net.one97.paytm.wallet.R.id.lyt_side_buttons     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r2)     // Catch:{ Exception -> 0x014e }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x00b2
            r8.setVisibility(r4)     // Catch:{ Exception -> 0x014e }
        L_0x00b2:
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x00c5
            int r2 = net.one97.paytm.wallet.R.id.lyt_zoom_bar     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r2)     // Catch:{ Exception -> 0x014e }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x00c5
            r8.setVisibility(r0)     // Catch:{ Exception -> 0x014e }
        L_0x00c5:
            net.one97.paytm.fastscanner.b.d r8 = net.one97.paytm.fastscanner.b.d.f50426a     // Catch:{ Exception -> 0x014e }
            android.hardware.Camera r8 = net.one97.paytm.fastscanner.b.d.g()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x014d
            r8.setParameters(r1)     // Catch:{ Exception -> 0x014e }
            goto L_0x014d
        L_0x00d2:
            if (r2 != r5) goto L_0x014d
            if (r1 != 0) goto L_0x00d9
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x014e }
        L_0x00d9:
            java.lang.String r2 = "event"
            kotlin.g.b.k.c(r8, r2)     // Catch:{ Exception -> 0x014e }
            java.lang.String r2 = "params"
            kotlin.g.b.k.c(r1, r2)     // Catch:{ Exception -> 0x014e }
            int r2 = r8.getPointerId(r0)     // Catch:{ Exception -> 0x014e }
            int r2 = r8.findPointerIndex(r2)     // Catch:{ Exception -> 0x014e }
            r8.getX(r2)     // Catch:{ Exception -> 0x014e }
            r8.getY(r2)     // Catch:{ Exception -> 0x014e }
            java.util.List r8 = r1.getSupportedFocusModes()     // Catch:{ Exception -> 0x014e }
            java.lang.String r1 = "params.supportedFocusModes"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)     // Catch:{ Exception -> 0x014e }
            java.lang.String r1 = "auto"
            boolean r8 = r8.contains(r1)     // Catch:{ Exception -> 0x0111 }
            if (r8 == 0) goto L_0x0111
            net.one97.paytm.fastscanner.b.d r8 = net.one97.paytm.fastscanner.b.d.f50426a     // Catch:{ Exception -> 0x0111 }
            android.hardware.Camera r8 = net.one97.paytm.fastscanner.b.d.g()     // Catch:{ Exception -> 0x0111 }
            if (r8 == 0) goto L_0x0111
            net.one97.paytm.wallet.newdesign.fastscan.a$a r1 = net.one97.paytm.wallet.newdesign.fastscan.a.C1434a.f70916a     // Catch:{ Exception -> 0x0111 }
            android.hardware.Camera$AutoFocusCallback r1 = (android.hardware.Camera.AutoFocusCallback) r1     // Catch:{ Exception -> 0x0111 }
            r8.autoFocus(r1)     // Catch:{ Exception -> 0x0111 }
        L_0x0111:
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x014d
            int r1 = net.one97.paytm.wallet.R.id.lyt_zoom_bar     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r1)     // Catch:{ Exception -> 0x014e }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x014d
            int r8 = r8.getVisibility()     // Catch:{ Exception -> 0x014e }
            if (r8 != 0) goto L_0x014d
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x013a
            int r1 = net.one97.paytm.wallet.R.id.lyt_zoom_bar     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r1)     // Catch:{ Exception -> 0x014e }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x013a
            r8.setVisibility(r4)     // Catch:{ Exception -> 0x014e }
        L_0x013a:
            android.view.View r8 = r7.getView()     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x014d
            int r1 = net.one97.paytm.wallet.R.id.lyt_side_buttons     // Catch:{ Exception -> 0x014e }
            android.view.View r8 = r8.findViewById(r1)     // Catch:{ Exception -> 0x014e }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x014e }
            if (r8 == 0) goto L_0x014d
            r8.setVisibility(r0)     // Catch:{ Exception -> 0x014e }
        L_0x014d:
            return r5
        L_0x014e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.b(android.view.MotionEvent):boolean");
    }

    public final void h() {
        net.one97.paytm.wallet.newdesign.fastscan.a.c cVar;
        ScanAnimationView scanAnimationView = (ScanAnimationView) a(R.id.lineAnimationImageView);
        if (scanAnimationView != null) {
            scanAnimationView.a();
        }
        SurfaceHolder surfaceHolder = this.f70908a;
        if (surfaceHolder != null) {
            net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
            if (net.one97.paytm.fastscanner.b.d.a() == d.b.STOPPED) {
                try {
                    if (this.f70915i != null) {
                        b.a();
                    }
                } catch (Exception e2) {
                    ScanAnimationView scanAnimationView2 = (ScanAnimationView) a(R.id.lineAnimationImageView);
                    if (scanAnimationView2 != null) {
                        scanAnimationView2.b();
                    }
                    Context context = getContext();
                    Context context2 = getContext();
                    Toast.makeText(context, context2 != null ? context2.getString(R.string.fast_scan_camera_message) : null, 0).show();
                    net.one97.paytm.wallet.communicator.b.a().pushCrashEventToCrashlytics("FastScanFragment", "error in opening camera driver", e2);
                }
            }
            if (this.f70915i != null) {
                b.a(surfaceHolder);
            }
            b bVar = this.f70915i;
            if (bVar != null && (cVar = bVar.f70898a) != null) {
                cVar.f70935e = System.currentTimeMillis();
            }
        }
    }

    public final void i() {
        b(0);
        a("android.permission.CAMERA", new g(this));
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70886a;

        g(a aVar) {
            this.f70886a = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
            r2 = (android.view.SurfaceView) r2.findViewById(net.one97.paytm.wallet.R.id.qrCodeSurfaceView);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
                r0 = 0
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r1 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.b r1 = r1.f70915i     // Catch:{ Exception -> 0x0054 }
                if (r1 == 0) goto L_0x000a
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.b.a()     // Catch:{ Exception -> 0x0054 }
            L_0x000a:
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r1 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                r2 = 8
                r1.b((int) r2)     // Catch:{ Exception -> 0x0054 }
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r1 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r2 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                android.view.View r2 = r2.getView()     // Catch:{ Exception -> 0x0054 }
                if (r2 == 0) goto L_0x002a
                int r3 = net.one97.paytm.wallet.R.id.qrCodeSurfaceView     // Catch:{ Exception -> 0x0054 }
                android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x0054 }
                android.view.SurfaceView r2 = (android.view.SurfaceView) r2     // Catch:{ Exception -> 0x0054 }
                if (r2 == 0) goto L_0x002a
                android.view.SurfaceHolder r2 = r2.getHolder()     // Catch:{ Exception -> 0x0054 }
                goto L_0x002b
            L_0x002a:
                r2 = r0
            L_0x002b:
                r1.f70908a = r2     // Catch:{ Exception -> 0x0054 }
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r1 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                android.view.SurfaceHolder r1 = r1.f70908a     // Catch:{ Exception -> 0x0054 }
                if (r1 == 0) goto L_0x003a
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r2 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                android.view.SurfaceHolder$Callback r2 = (android.view.SurfaceHolder.Callback) r2     // Catch:{ Exception -> 0x0054 }
                r1.addCallback(r2)     // Catch:{ Exception -> 0x0054 }
            L_0x003a:
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r1 = r6.f70886a     // Catch:{ Exception -> 0x0054 }
                android.os.Handler r2 = new android.os.Handler     // Catch:{ Exception -> 0x0054 }
                r2.<init>()     // Catch:{ Exception -> 0x0054 }
                r1.f70913g = r2     // Catch:{ Exception -> 0x0054 }
                android.os.Handler r2 = r1.f70913g     // Catch:{ Exception -> 0x0054 }
                if (r2 == 0) goto L_0x0053
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a$m r3 = new net.one97.paytm.wallet.newdesign.fastscan.FastScan.a$m     // Catch:{ Exception -> 0x0054 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x0054 }
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ Exception -> 0x0054 }
                r4 = 7000(0x1b58, double:3.4585E-320)
                r2.postDelayed(r3, r4)     // Catch:{ Exception -> 0x0054 }
            L_0x0053:
                return
            L_0x0054:
                r1 = move-exception
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r2 = r6.f70886a
                android.content.Context r2 = r2.getContext()
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a r3 = r6.f70886a
                android.content.Context r3 = r3.getContext()
                if (r3 == 0) goto L_0x0069
                int r0 = net.one97.paytm.wallet.R.string.fast_scan_camera_message
                java.lang.String r0 = r3.getString(r0)
            L_0x0069:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r3 = 0
                android.widget.Toast r0 = android.widget.Toast.makeText(r2, r0, r3)
                r0.show()
                net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                java.lang.String r2 = "FastScanFragment"
                java.lang.String r3 = "error in opening camera driver"
                r0.pushCrashEventToCrashlytics(r2, r3, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.g.run():void");
        }
    }

    public final void b(int i2) {
        View view = getView();
        if (view != null) {
            kotlin.g.b.k.a((Object) view, "_view");
            SurfaceView surfaceView = (SurfaceView) view.findViewById(R.id.qrCodeSurfaceView);
            if (surfaceView != null) {
                surfaceView.setVisibility(i2 == 0 ? 8 : 0);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.capturePermissionDeniedLayout);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(i2);
                }
            }
        }
    }

    public final void j() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Toast.makeText(activity, "Format not supported", 0).show();
        }
        View view = getView();
        if (view != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.walletLoader);
            kotlin.g.b.k.a((Object) lottieAnimationView, "it");
            b(lottieAnimationView);
        }
        q();
    }

    public final LottieAnimationView k() {
        return (LottieAnimationView) a(R.id.walletLoader);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.widget.LinearLayout} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l() {
        /*
            r7 = this;
            int r0 = net.one97.paytm.wallet.R.id.captureEnableCameraButton
            android.view.View r0 = r7.a(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            int r0 = a((android.view.View) r0)
            int r1 = net.one97.paytm.wallet.R.id.lyt_permission_show_payment_code
            android.view.View r1 = r7.a(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r1 = b((android.view.View) r1)
            r2 = 0
            r3 = 20
            r4 = 0
            r5 = 10
            if (r0 <= r1) goto L_0x0075
            int r0 = net.one97.paytm.wallet.R.id.lyt_permission_show_payment_code
            android.view.View r0 = r7.a(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.content.Context r1 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r3, (android.content.Context) r1)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r0, (int) r4, (int) r1)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2
            if (r0 == 0) goto L_0x0060
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x004a
            int r1 = net.one97.paytm.wallet.R.id.so_cp_recent_ll
            android.view.View r0 = r0.findViewById(r1)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            android.view.View r0 = (android.view.View) r0
            android.content.Context r1 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r5, (android.content.Context) r1)
            android.content.Context r6 = r7.getContext()
            int r6 = net.one97.paytm.wallet.utility.a.a((int) r5, (android.content.Context) r6)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r0, (int) r1, (int) r6)
        L_0x0060:
            int r0 = net.one97.paytm.wallet.R.id.image
            android.view.View r0 = r7.a(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            r1 = 30
            android.content.Context r6 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r1, (android.content.Context) r6)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r0, (int) r1, (int) r4)
        L_0x0075:
            int r0 = net.one97.paytm.wallet.R.id.scan_align_rect
            android.view.View r0 = r7.a(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            int r0 = a((android.view.View) r0)
            int r1 = net.one97.paytm.wallet.R.id.lyt_show_payment_code
            android.view.View r1 = r7.a(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r1 = b((android.view.View) r1)
            if (r0 <= r1) goto L_0x0104
            int r0 = net.one97.paytm.wallet.R.id.lyt_show_payment_code
            android.view.View r0 = r7.a(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.content.Context r1 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r3, (android.content.Context) r1)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r0, (int) r4, (int) r1)
            int r0 = net.one97.paytm.wallet.R.id.scan_align_rect
            android.view.View r0 = r7.a(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            java.lang.String r1 = "scan_align_rect"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.content.Context r3 = r7.getContext()
            r4 = 190(0xbe, float:2.66E-43)
            int r3 = net.one97.paytm.wallet.utility.a.a((int) r4, (android.content.Context) r3)
            r0.height = r3
            android.content.Context r3 = r7.getContext()
            int r3 = net.one97.paytm.wallet.utility.a.a((int) r4, (android.content.Context) r3)
            r0.width = r3
            int r3 = net.one97.paytm.wallet.R.id.scan_align_rect
            android.view.View r3 = r7.a(r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            r3.setLayoutParams(r0)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2
            if (r0 == 0) goto L_0x015f
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x00ee
            int r1 = net.one97.paytm.wallet.R.id.so_cp_recent_ll
            android.view.View r0 = r0.findViewById(r1)
            r2 = r0
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
        L_0x00ee:
            android.view.View r2 = (android.view.View) r2
            android.content.Context r0 = r7.getContext()
            int r0 = net.one97.paytm.wallet.utility.a.a((int) r5, (android.content.Context) r0)
            android.content.Context r1 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r5, (android.content.Context) r1)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r2, (int) r0, (int) r1)
            return
        L_0x0104:
            int r0 = net.one97.paytm.wallet.R.id.alignQrAlert
            android.view.View r0 = r7.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r0 = a((android.view.View) r0)
            int r1 = net.one97.paytm.wallet.R.id.lyt_show_payment_code
            android.view.View r1 = r7.a(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r1 = b((android.view.View) r1)
            if (r0 <= r1) goto L_0x015f
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2
            if (r0 == 0) goto L_0x014c
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 == 0) goto L_0x0135
            int r1 = net.one97.paytm.wallet.R.id.so_cp_recent_ll
            android.view.View r0 = r0.findViewById(r1)
            r2 = r0
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
        L_0x0135:
            android.view.View r2 = (android.view.View) r2
            r0 = 15
            android.content.Context r1 = r7.getContext()
            int r0 = net.one97.paytm.wallet.utility.a.a((int) r0, (android.content.Context) r1)
            android.content.Context r1 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r5, (android.content.Context) r1)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r2, (int) r0, (int) r1)
        L_0x014c:
            int r0 = net.one97.paytm.wallet.R.id.lyt_show_payment_code
            android.view.View r0 = r7.a(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.content.Context r1 = r7.getContext()
            int r1 = net.one97.paytm.wallet.utility.a.a((int) r3, (android.content.Context) r1)
            net.one97.paytm.wallet.utility.a.a((android.view.View) r0, (int) r4, (int) r1)
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.l():void");
    }

    public final void a(String str, boolean z, boolean z2) {
        Long l2;
        kotlin.g.b.k.c(str, "result");
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                kotlin.g.b.k.a((Object) net.one97.paytm.p2mNewDesign.models.b.c(), "QrScanSessionLogger.getInstance()");
                net.one97.paytm.p2mNewDesign.models.b.a();
                Intent intent = new Intent(getContext(), AJRQRActivity.class);
                intent.putExtra("OPERATION", "scan");
                intent.putExtra("scan_result", str);
                intent.putExtra("QR_CODE_ID", this.f70911e);
                intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, this.f70909b);
                intent.putExtra("showTagline", z);
                intent.putExtra("isStaticQRWithEncryptData", z2);
                intent.putExtra("orderId", this.f70912f);
                StringBuilder sb = new StringBuilder();
                b bVar = this.f70915i;
                if (bVar != null) {
                    l2 = bVar.f70902e;
                } else {
                    l2 = null;
                }
                sb.append(l2);
                intent.putExtra("qrScanTime", sb.toString());
                intent.putExtra("isAutoFlashTxn", this.n);
                intent.putExtra(UpiConstants.IS_GALLERY_SCAN, this.o);
                if (getActivity() instanceof PaySendActivityV2) {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null) {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2");
                    } else if (((PaySendActivityV2) activity2).f() != null) {
                        FragmentActivity activity3 = getActivity();
                        if (activity3 != null) {
                            intent.putExtra("extra_home_data", ((PaySendActivityV2) activity3).f());
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2");
                        }
                    }
                }
                FragmentActivity activity4 = getActivity();
                if (activity4 != null) {
                    activity4.startActivityForResult(intent, 1802);
                }
                FragmentActivity activity5 = getActivity();
                if (activity5 != null) {
                    PaySendActivityV2 paySendActivityV2 = (PaySendActivityV2) activity5;
                    if (paySendActivityV2 != null) {
                        paySendActivityV2.g();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2");
            }
        }
    }

    public final String n() {
        String simpleName = a.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FastScanFragmentV2::class.java.simpleName");
        return simpleName;
    }

    public final void o() {
        net.one97.paytm.p2mNewDesign.models.b.c().b("Payment Code");
        net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
        Map hashMap = new HashMap();
        hashMap.put("new_wallet_screen_type", "send_money");
        net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(net.one97.paytm.wallet.a.a.a(), "new_wallet_see_instant_paytm_otp_clicked", hashMap);
        super.o();
    }

    public final void m() {
        View a2 = a(R.id.viewScreenCover);
        kotlin.g.b.k.a((Object) a2, "viewScreenCover");
        a2.setVisibility(0);
        ((RelativeLayout) a(R.id.fastscan_parent)).setBackgroundColor(-16777216);
        a(R.id.viewScreenCover).postDelayed(new C1432a(this), 50);
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.fastscan.FastScan.a$a  reason: collision with other inner class name */
    static final class C1432a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70878a;

        C1432a(a aVar) {
            this.f70878a = aVar;
        }

        public final void run() {
            FragmentActivity activity = this.f70878a.getActivity();
            if (activity != null) {
                kotlin.g.b.k.a((Object) activity, "it");
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    ((ScanAnimationView) this.f70878a.a(R.id.lineAnimationImageView)).b();
                    RelativeLayout relativeLayout = (RelativeLayout) this.f70878a.a(R.id.scan_align_rect);
                    kotlin.g.b.k.a((Object) relativeLayout, "scan_align_rect");
                    relativeLayout.setVisibility(4);
                    net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
                    Camera g2 = net.one97.paytm.fastscanner.b.d.g();
                    if (g2 != null) {
                        g2.stopPreview();
                    }
                    SurfaceView surfaceView = (SurfaceView) this.f70878a.a(R.id.qrCodeSurfaceView);
                    kotlin.g.b.k.a((Object) surfaceView, "qrCodeSurfaceView");
                    surfaceView.setVisibility(4);
                    ((PaySendActivityV2) activity).d();
                }
            }
        }
    }

    public final void onResume() {
        Trace a2 = com.google.firebase.perf.a.a("FastScanFragmentV2_onResume");
        net.one97.paytm.p2mNewDesign.models.b.c().a("Foreground");
        super.onResume();
        a2.stop();
    }

    public final void e() {
        Context context;
        if (!this.k) {
            net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
            net.one97.paytm.fastscanner.b.d.d();
            net.one97.paytm.fastscanner.b.d dVar2 = net.one97.paytm.fastscanner.b.d.f50426a;
            net.one97.paytm.fastscanner.b.d.e();
            net.one97.paytm.fastscanner.b.d dVar3 = net.one97.paytm.fastscanner.b.d.f50426a;
            net.one97.paytm.fastscanner.b.d.f();
        }
        net.one97.paytm.fastscanner.b.d dVar4 = net.one97.paytm.fastscanner.b.d.f50426a;
        if (net.one97.paytm.fastscanner.b.d.a() == d.b.STOPPED && (context = getContext()) != null) {
            if (this.f70915i != null) {
                b.a(context);
            }
            d.a aVar = d.a.f50429a;
            d.a.b();
            d.a aVar2 = d.a.f50429a;
            d.a.a(com.paytm.utility.b.a((Activity) getActivity()), com.paytm.utility.b.b((Activity) getActivity()));
        }
    }
}
