package com.paytmmall.artifact.scan.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.mapqr.view.ScanActivityVision;
import com.google.android.gms.location.e;
import com.google.android.gms.vision.a.e;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.a;
import com.google.android.gms.vision.d;
import com.google.zxing.client.android.b;
import com.google.zxing.r;
import com.google.zxing.t;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.artifact.R;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.u;
import com.paytmmall.artifact.scan.activity.AJRScanActivity;
import com.paytmmall.artifact.scan.b.a;
import com.paytmmall.artifact.scan.entity.CJRBrtsUTS;
import com.paytmmall.artifact.scan.entity.CJRExtendedInfoData;
import com.paytmmall.artifact.scan.entity.CJRQRInfoResponse;
import com.paytmmall.artifact.scan.entity.RecentScan;
import com.paytmmall.b.a;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.scanner.camera.CameraSourcePreview;
import net.one97.scanner.camera.ViewFinder;
import net.one97.scanner.camera.c;
import net.one97.scanner.camera.d;
import net.one97.scanner.camera.f;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends h implements e, a.C0213a, CameraSourcePreview.a {
    private static final String s = a.class.getSimpleName();
    /* access modifiers changed from: private */
    public RelativeLayout A;
    private Button B;
    private boolean C = false;
    private boolean D;
    private d E;
    private CameraSourcePreview F;
    private boolean G = true;
    /* access modifiers changed from: private */
    public com.paytm.utility.h H;
    /* access modifiers changed from: private */
    public boolean I = true;
    /* access modifiers changed from: private */
    public b J;
    private Location K;
    /* access modifiers changed from: private */
    public com.paytmmall.artifact.scan.c.b L;
    private int M;
    private ImageView N;
    private boolean O;
    /* access modifiers changed from: private */
    public boolean P;
    private boolean Q;
    /* access modifiers changed from: private */
    public String R;
    private String S;
    private boolean T;
    private final int U = 9;
    private LinearLayout V;
    private View W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    LottieAnimationView f15837a;
    private LinearLayout aa;
    private RecyclerView ab;
    private boolean ac;
    private boolean ad;
    private int ae = 0;
    private int af = 0;
    /* access modifiers changed from: private */
    public int ag;
    private boolean ah = false;
    private boolean ai = false;
    private boolean aj = false;

    /* renamed from: b  reason: collision with root package name */
    View f15838b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f15839c;

    /* renamed from: d  reason: collision with root package name */
    TextView f15840d;

    /* renamed from: e  reason: collision with root package name */
    TextView f15841e;

    /* renamed from: f  reason: collision with root package name */
    TextView f15842f;

    /* renamed from: g  reason: collision with root package name */
    TextView f15843g;

    /* renamed from: h  reason: collision with root package name */
    TextView f15844h;

    /* renamed from: i  reason: collision with root package name */
    TextView f15845i;
    TextView j;
    RelativeLayout k;
    com.paytmmall.artifact.scan.c.a l;
    ImageView m;
    LocationManager n;
    ViewFinder o;
    boolean p = false;
    long q;
    long r;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private View y;
    private RelativeLayout z;

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(View view) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k(View view) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m(View view) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(View view) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view, View view2) {
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view, View view2) {
        view.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O = true;
            this.P = false;
            this.Q = getArguments().getBoolean("nearex_scan");
            this.T = getArguments().getBoolean("barcode_only");
        }
    }

    public void onAttach(Activity activity) {
        if (activity instanceof AJRScanActivity) {
            this.l = (com.paytmmall.artifact.scan.c.a) activity;
            this.L = (com.paytmmall.artifact.scan.c.b) activity;
        }
        super.onAttach(activity);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        if (getActivity() != null) {
            this.W.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        com.paytmmall.artifact.scan.c.a aVar = this.l;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        com.paytmmall.artifact.common.a.b.a("scan_qr_cross_clicked", (Map<String, Object>) new HashMap(), (Context) getActivity());
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        getActivity().finish();
    }

    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        super.onViewCreated(view, bundle);
        if (this.T && getResources() != null && (textView = this.f15844h) != null) {
            textView.setText(getResources().getString(R.string.point_at_any_barcode));
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if ((getActivity() instanceof AJRScanActivity) && !TextUtils.isEmpty(((AJRScanActivity) getActivity()).f15860a)) {
            q.d("qrid=" + ((AJRScanActivity) getActivity()).f15860a);
            a(((AJRScanActivity) getActivity()).f15860a);
        }
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.D = z2;
        if (z2) {
            this.C = true;
            d();
        } else if (!isResumed() || z2) {
            isResumed();
        } else {
            b();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 51) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_permissions_and_status", "camera=true");
            if (!(androidx.core.app.a.a((Context) getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a((Context) getActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                hashMap.put("app_permissions_and_status", "camera=false");
            }
            com.paytmmall.artifact.common.a.b.a("app_permissions_provided", (Map<String, Object>) hashMap, getActivity().getApplicationContext());
            if (s.a(iArr)) {
                a(8);
                f();
                return;
            }
            if (s.a(strArr, iArr, "android.permission.CAMERA", getActivity()) == 0) {
                if (getActivity() != null && !getActivity().isFinishing()) {
                    u.a(getActivity().getApplicationContext()).a("DO_NOT_SHOW_CAMERA_PERMISSION", true, true);
                } else {
                    return;
                }
            }
            a(0);
        }
    }

    private void a(int i2) {
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i2);
        }
    }

    private void b() {
        this.G = true;
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.mall_flash_off);
        }
    }

    private boolean c() {
        return !u.a(getActivity().getApplicationContext()).b("DO_NOT_SHOW_CAMERA_PERMISSION", false, true);
    }

    private void d() {
        if (!i()) {
            a(0);
            if (c()) {
                requestPermissions(new String[]{"android.permission.CAMERA"}, 51);
                return;
            }
            return;
        }
        f();
    }

    private void e() {
        LottieAnimationView lottieAnimationView = this.f15837a;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        LottieAnimationView lottieAnimationView = this.f15837a;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    private void f() {
        com.google.android.gms.vision.a.e eVar;
        Context applicationContext = getActivity().getApplicationContext();
        com.google.android.gms.vision.barcode.a a2 = new a.C0165a(applicationContext).a(com.paytmmall.artifact.scan.d.b.a(this.T)).a();
        f l2 = l();
        net.one97.scanner.camera.b bVar = new net.one97.scanner.camera.b(l2);
        String str = null;
        if (this.P) {
            eVar = new e.a(applicationContext).a();
            eVar.a(new net.one97.scanner.camera.e(l2));
        } else {
            eVar = null;
        }
        a2.a(new d.a(bVar).f12628a);
        if (!a2.f12616a.b()) {
            new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW");
        }
        int a3 = com.paytm.utility.b.a((Activity) getActivity());
        int b2 = com.paytm.utility.b.b((Activity) getActivity());
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        if (this.P && eVar != null) {
            arrayList.add(eVar);
        }
        d.a a4 = new d.a(getActivity().getApplicationContext(), arrayList).b().a(a3, b2).a();
        if (Build.VERSION.SDK_INT >= 14) {
            a4 = a4.a("continuous-picture");
        }
        if (!this.G) {
            str = "torch";
        }
        this.E = a4.b(str).c();
        g();
    }

    private void g() {
        net.one97.scanner.camera.d dVar = this.E;
        if (dVar != null) {
            dVar.f72466b = new c() {
                public final void a() {
                    a.this.h();
                }
            };
        } else {
            h();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        a(0);
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.empty);
            TextView textView2 = (TextView) this.z.findViewById(R.id.camera_access);
            Button button = (Button) this.z.findViewById(R.id.capture_enable_camera_btn);
            if (textView != null) {
                textView.setText(getString(R.string.camera_access_message));
            }
            if (textView2 != null) {
                textView2.setText(getString(R.string.camera_access_header));
            }
            if (button != null) {
                button.setText(getString(R.string.ok));
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.a(view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().finish();
    }

    public void onResume() {
        super.onResume();
        this.ac = true;
        com.paytm.utility.h hVar = this.H;
        if (hVar != null && hVar.isShowing()) {
            this.H.dismiss();
        }
        if (!this.C && !i()) {
            a(0);
        }
        if (i()) {
            a(8);
        }
        this.C = false;
        this.J = new b(getActivity());
        this.J.a();
        if (androidx.core.app.a.a((Context) getActivity(), "android.permission.CAMERA") == 0) {
            f();
        } else if (c()) {
            String[] strArr = {"android.permission.CAMERA"};
            if (!androidx.core.app.a.a((Activity) getActivity(), "android.permission.CAMERA")) {
                androidx.core.app.a.a(getActivity(), strArr, 2);
            } else {
                new View.OnClickListener(getActivity(), strArr) {
                    private final /* synthetic */ Activity f$0;
                    private final /* synthetic */ String[] f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        androidx.core.app.a.a(this.f$0, this.f$1, 2);
                    }
                };
            }
        }
        j();
    }

    public void onStart() {
        super.onStart();
        this.I = true;
        this.f15839c.setVisibility(0);
    }

    public void onStop() {
        super.onStop();
        this.I = false;
    }

    private boolean i() {
        return !s.a() || s.a((Activity) getActivity());
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        this.H = new com.paytm.utility.h(getActivity());
        this.H.setTitle(str);
        this.H.a(str2);
        this.H.setCancelable(true);
        this.H.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.H.dismiss();
            }
        });
        this.H.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                a.this.b(dialogInterface);
            }
        });
        try {
            if (getActivity() != null && !getActivity().isFinishing() && !isDetached()) {
                this.H.show();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.I = true;
        onPause();
        onResume();
    }

    public void onPause() {
        super.onPause();
        this.ac = false;
        b();
        CameraSourcePreview cameraSourcePreview = this.F;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        b bVar = this.J;
        if (bVar != null) {
            bVar.close();
        }
        CameraSourcePreview cameraSourcePreview = this.F;
        if (cameraSourcePreview != null && cameraSourcePreview.f72438a != null) {
            cameraSourcePreview.f72438a.a();
            cameraSourcePreview.f72438a = null;
        }
    }

    private void j() throws SecurityException {
        int a2 = com.google.android.gms.common.c.a().a(getActivity().getApplicationContext());
        if (a2 != 0) {
            com.google.android.gms.common.c.a().a((Activity) getActivity(), a2, (int) ScanActivityVision.RC_HANDLE_GMS).show();
        }
        net.one97.scanner.camera.d dVar = this.E;
        if (dVar != null) {
            try {
                this.F.a(dVar);
                this.o.setCameraSource(this.E);
                this.o.a();
            } catch (Exception unused) {
                this.E.a();
                this.E = null;
            }
        }
    }

    public final void a(String str) {
        q.d("qrData=".concat(String.valueOf(str)));
        com.paytmmall.artifact.common.a.b.b("/wallet/pay-send/scan-code", "scan", (Context) getActivity());
        int a2 = com.paytmmall.artifact.scan.d.b.a(str);
        if (a2 == 1) {
            try {
                String b2 = com.google.zxing.client.android.d.b.b(str, UpiConstants.QR_KEY);
                com.paytmmall.artifact.scan.entity.a aVar = new com.paytmmall.artifact.scan.entity.a();
                aVar.a(new JSONObject(b2), getActivity());
                com.paytmmall.artifact.scan.d.a.a().a((Context) getActivity(), b2, aVar.f15886d, 1);
                "QR_CODE_REQUEST_MONEY".equalsIgnoreCase(aVar.f15883a);
            } catch (Exception e2) {
                if (this.L != null) {
                    if (!com.paytm.utility.b.o(str) && !com.paytm.utility.b.r(str)) {
                        com.paytm.utility.b.s(str);
                    }
                    if (!com.paytm.utility.b.p(str) || TextUtils.isEmpty(com.paytm.utility.b.w(str))) {
                        this.L.a(str, this.R, this.S);
                    } else {
                        Map linkedHashMap = new LinkedHashMap();
                        try {
                            linkedHashMap = com.paytmmall.artifact.scan.d.b.b(str);
                        } catch (UnsupportedEncodingException unused) {
                        }
                        if (linkedHashMap.containsKey("pn")) {
                            this.Y = (String) linkedHashMap.get("pn");
                        }
                        if (linkedHashMap.containsKey("tr")) {
                            this.X = (String) linkedHashMap.get("tr");
                        }
                        if (linkedHashMap.containsKey("am")) {
                            this.Z = (String) linkedHashMap.get("am");
                        }
                        a(com.paytm.utility.b.w(str), true);
                    }
                }
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        } else if (a2 == 4) {
            if (this.L == null) {
            }
        } else if (a2 == 7) {
            if (this.L == null) {
            }
        } else if (a2 == 3) {
        } else {
            if (a2 == 6) {
                com.paytmmall.artifact.scan.c.b bVar = this.L;
                if (bVar != null) {
                    bVar.a(new r(str, (byte[]) null, (t[]) null, com.google.zxing.a.QR_CODE));
                }
            } else if (a2 == 5) {
                if (this.L == null) {
                }
            } else if (com.paytm.utility.b.c((Context) getActivity())) {
                a(str, false);
            } else {
                k();
            }
        }
    }

    private void k() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!getActivity().isFinishing()) {
                final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
                hVar.setTitle(getResources().getString(R.string.no_connection));
                hVar.a(getResources().getString(R.string.no_internet));
                hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.cancel();
                    }
                });
                hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        a.this.a(dialogInterface);
                    }
                });
                hVar.setCancelable(true);
                hVar.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.I = true;
    }

    private void a(String str, boolean z2) {
        new com.paytmmall.artifact.scan.b.a().a((Context) getActivity(), (a.C0213a) this);
        if (z2) {
            this.ad = false;
            com.paytmmall.artifact.scan.d.a.a();
            getActivity();
            e();
        }
        StringBuilder sb = new StringBuilder();
        com.paytmmall.artifact.common.a.a.a();
        sb.append(com.paytmmall.artifact.common.a.a.a("QR_INFO", (String) null));
        sb.append(com.paytm.utility.c.a((Context) getActivity(), false));
        final String sb2 = sb.toString();
        new HashMap().put("screen_name", getClass().getSimpleName());
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", l.a((Context) getActivity()));
        hashMap.put("Content-Type", "application/json");
        String b2 = b(str);
        new CJRQRInfoResponse();
        this.R = str;
        com.paytmmall.b.a.a(getContext(), a.C0216a.POST, sb2, b2, hashMap, new CJRQRInfoResponse(), new com.paytmmall.b.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                a aVar = a.this;
                a.a(aVar, (CJRQRInfoResponse) iJRPaytmDataModel, aVar.R);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                a.this.a();
                if (a.this.getActivity() != null && !a.this.getActivity().isFinishing()) {
                    if (TextUtils.isEmpty(networkCustomError.getMessage()) || !(i2 == 401 || i2 == 410)) {
                        a aVar = a.this;
                        aVar.a(aVar.getString(R.string.error), a.this.getString(R.string.some_went_wrong));
                        return;
                    }
                    com.paytmmall.artifact.d.d.a((Activity) a.this.getActivity(), networkCustomError, a.class.getName(), sb2);
                }
            }
        });
    }

    private static String b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("qrCodeId", str);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put("scanCompletedTime", sb.toString());
            jSONObject.put("request", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 401 && i3 == -1) {
            a(8);
            f();
            j();
        }
    }

    public final void a(Location location) {
        if (location == null || location.getLatitude() == 0.0d || location.getLatitude() == 0.0d) {
            this.K = null;
        } else {
            this.K = location;
        }
    }

    /* access modifiers changed from: private */
    public void b(final int i2) {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                int i2 = i2 - 40;
                if (i2 < 0) {
                    i2 = 0;
                }
                a.this.A.setY((float) i2);
                a.this.A.getLayoutParams().height = a.this.ag;
                a.this.A.requestLayout();
                if (i2 != 0) {
                    a aVar = a.this;
                    int unused = aVar.ag;
                    aVar.b(i2);
                }
            }
        }, 1);
    }

    private void b(boolean z2) {
        if (z2) {
            this.f15838b.setBackground((Drawable) null);
            this.f15839c.setBackground((Drawable) null);
        } else {
            this.f15838b.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.frame));
            this.f15839c.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.mall_scanner_tile));
        }
        this.o.setSwipingOn(z2);
    }

    private f l() {
        return new f() {
            public final synchronized void a(final Barcode barcode) {
                final String str = barcode.f12553b;
                a.this.getActivity().runOnUiThread(new Runnable() {
                    public final void run() {
                        if (a.this.I) {
                            a.this.f15839c.setVisibility(8);
                            a.this.J.b();
                            boolean unused = a.this.I = false;
                            if (barcode.f12552a == 256) {
                                a.this.a(str);
                            } else if (a.this.L != null) {
                                a.this.L.a(barcode.f12553b);
                            } else {
                                boolean unused2 = a.this.I = true;
                            }
                        }
                    }
                });
            }

            public final synchronized void a(SparseArray<com.google.android.gms.vision.a.d> sparseArray) {
                if (a.this.I && a.this.P) {
                    a.a(a.this, (SparseArray) sparseArray);
                }
            }
        };
    }

    public final void a(boolean z2) {
        if (getActivity() != null && !getActivity().isFinishing() && !isDetached() && !z2 && this.ac) {
            Toast.makeText(getActivity(), getString(R.string.network_slow_error_message), 0).show();
        }
    }

    public final void a(MotionEvent motionEvent) {
        if (this.F != null) {
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction() & PriceRangeSeekBar.INVALID_POINTER_ID;
            if (action == 0) {
                this.q = System.currentTimeMillis();
                this.r = (long) rawY;
                this.ag = this.A.getHeight();
                this.ae = rawY;
                this.af = (int) this.A.getY();
            } else if (action == 1) {
                b(false);
                int y2 = (int) this.A.getY();
                if ((!this.aj || Math.abs(this.af - y2) <= this.ag / 2) && (System.currentTimeMillis() - this.q >= 500 || ((long) rawY) - this.r <= 50)) {
                    if (this.ai) {
                        b(y2);
                        this.ai = false;
                    }
                    if (this.aj) {
                        b(y2);
                        this.aj = false;
                        return;
                    }
                    return;
                }
                com.paytmmall.artifact.common.a.b.a("scan_qr_code_swipe_down", (Map<String, Object>) new HashMap(), (Context) getActivity());
                this.ah = true;
                Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                int i2 = point.y;
                RelativeLayout relativeLayout = this.A;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "y", new float[]{(float) y2, (float) (i2 + relativeLayout.getHeight())});
                ofFloat.setDuration(300);
                if (Build.VERSION.SDK_INT >= 11) {
                    ofFloat.addListener(new Animator.AnimatorListener() {
                        public final void onAnimationCancel(Animator animator) {
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (a.this.getActivity() != null) {
                                a.this.getActivity().finish();
                            }
                        }
                    });
                }
                ofFloat.start();
            } else if (action == 2) {
                b(true);
                if (!this.ah) {
                    this.A.getY();
                    if (this.ae <= rawY) {
                        if (!this.aj) {
                            this.aj = true;
                        }
                        RelativeLayout relativeLayout2 = this.A;
                        relativeLayout2.setY(relativeLayout2.getY() + ((float) (rawY - this.ae)));
                        this.A.getLayoutParams().height = this.A.getHeight() - (rawY - this.ae);
                        this.A.requestLayout();
                    } else if (this.A.getY() > 0.0f) {
                        if (!this.ai) {
                            this.ai = true;
                        }
                        this.aj = false;
                        this.A.getLayoutParams().height = this.A.getHeight() + (this.ae - rawY);
                        this.A.requestLayout();
                        RelativeLayout relativeLayout3 = this.A;
                        relativeLayout3.setY(relativeLayout3.getY() + ((float) (rawY - this.ae)));
                    }
                    this.ae = rawY;
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        ImageView imageView;
        String str;
        boolean z2 = com.paytmmall.artifact.d.c.f15691a;
        View inflate = layoutInflater.inflate(R.layout.mall_scan_only_gms, viewGroup, false);
        this.y = inflate;
        if (this.O || this.Q) {
            ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar((Toolbar) inflate.findViewById(R.id.tool_bar_scan_only_gms));
            setHasOptionsMenu(false);
            this.f15845i = (TextView) inflate.findViewById(R.id.tvFastScan);
            TextView textView = this.f15845i;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.v = (ImageView) inflate.findViewById(R.id.iv_my_qr);
            this.W = inflate.findViewById(R.id.lyt_my_qr);
            View view = this.W;
            if (view != null) {
                view.setVisibility(8);
                View view2 = this.W;
                ImageView imageView2 = (ImageView) view2.findViewById(R.id.iv_my_qr_code);
                TextView textView2 = (TextView) view2.findViewById(R.id.tv_my_qr_name_heading);
                TextView textView3 = (TextView) view2.findViewById(R.id.tv_my_qr_mobile_number);
                TextView textView4 = (TextView) view2.findViewById(R.id.tv_my_qr_bottom_heading);
                ImageView imageView3 = (ImageView) view2.findViewById(R.id.iv_my_qr_cross_icon);
                ImageView imageView4 = (ImageView) view2.findViewById(R.id.iv_my_qr_scan_qr);
                try {
                    String j2 = com.paytmmall.artifact.d.d.j(getContext());
                    getContext();
                    imageView2.setImageBitmap(com.google.zxing.client.android.d.a.a(j2, com.paytmmall.artifact.d.e.a(250.0f, getContext()), com.paytmmall.artifact.d.e.a(250.0f, getContext()), true));
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                if (TextUtils.isEmpty(com.paytm.utility.b.h(getActivity().getApplicationContext())) || com.paytm.utility.b.h(getActivity().getApplicationContext()).trim().length() <= 0) {
                    str = (TextUtils.isEmpty(com.paytm.utility.b.i(getActivity().getApplicationContext())) || com.paytm.utility.b.i(getActivity().getApplicationContext()).trim().length() <= 0) ? "" : com.paytm.utility.b.i(getActivity().getApplicationContext());
                } else {
                    str = com.paytm.utility.b.h(getActivity().getApplicationContext());
                    if (!TextUtils.isEmpty(com.paytm.utility.b.i(getActivity().getApplicationContext())) && com.paytm.utility.b.i(getActivity().getApplicationContext()).trim().length() > 0) {
                        str = str + " " + com.paytm.utility.b.i(getActivity().getApplicationContext());
                    }
                }
                textView2.setText(getString(R.string.my_qr_name_heading, str));
                textView3.setText(com.paytm.utility.b.l(getActivity().getApplicationContext()));
                textView4.setText(getString(R.string.my_qr_can_chat_send_money, str));
                imageView3.setOnClickListener(new View.OnClickListener(view2) {
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        a.this.b(this.f$1, view);
                    }
                });
                imageView4.setOnClickListener(new View.OnClickListener(view2) {
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        a.this.a(this.f$1, view);
                    }
                });
            }
        }
        this.u = (ImageView) inflate.findViewById(R.id.gallery_icon);
        this.j = (TextView) inflate.findViewById(R.id.tvShareOtp);
        this.aa = (LinearLayout) inflate.findViewById(R.id.recent_ll);
        this.ab = (RecyclerView) inflate.findViewById(R.id.recent_rv);
        this.A = (RelativeLayout) inflate.findViewById(R.id.scan_only_parent_layout);
        this.n = (LocationManager) ((FragmentActivity) Objects.requireNonNull(getActivity())).getSystemService("location");
        this.m = (ImageView) inflate.findViewById(R.id.mobile_icon);
        this.F = (CameraSourcePreview) inflate.findViewById(R.id.preview);
        if (this.O) {
            this.F.setSingleTouchListener(this);
        }
        this.f15838b = inflate.findViewById(R.id.framing_rect);
        this.f15839c = (ImageView) inflate.findViewById(R.id.scanning_line);
        this.f15844h = (TextView) inflate.findViewById(R.id.capture_balance_textview);
        this.f15842f = (TextView) inflate.findViewById(R.id.capture_show_code_btn);
        this.V = (LinearLayout) inflate.findViewById(R.id.ll_shop_not_accepting);
        this.f15843g = (TextView) inflate.findViewById(R.id.permission_show_code_btn);
        this.k = (RelativeLayout) inflate.findViewById(R.id.p2p_invoker_tv);
        this.N = (ImageView) inflate.findViewById(R.id.img_p2p_contact_picker);
        this.w = (ImageView) inflate.findViewById(R.id.cross_icon);
        this.x = (ImageView) inflate.findViewById(R.id.toolbar_btn_back);
        this.o = (ViewFinder) inflate.findViewById(R.id.view_finder);
        if (this.O || this.Q) {
            this.o.setScanOnly(this.O);
        } else {
            this.o.setScanOnly(false);
        }
        this.f15837a = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener($$Lambda$a$wmqlsLLe8NJW0ll43TuC0Z1h8PI.INSTANCE);
        }
        TextView textView5 = this.f15842f;
        if (textView5 != null) {
            textView5.setVisibility(8);
            this.f15842f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.l(view);
                }
            });
        }
        LinearLayout linearLayout = this.V;
        if (linearLayout != null) {
            linearLayout.setOnClickListener($$Lambda$a$2KoCGIYsMNUXhtjv67Swrq12XAA.INSTANCE);
        }
        TextView textView6 = this.f15843g;
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.j(view);
                }
            });
        }
        ImageView imageView5 = this.N;
        if (imageView5 != null) {
            imageView5.setOnClickListener($$Lambda$a$I_5I8Rg8Txyg9K9kxvq8PFXWs5o.INSTANCE);
        }
        TextView textView7 = this.j;
        if (textView7 != null) {
            textView7.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.h(view);
                }
            });
        }
        if (this.O && (imageView = this.v) != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.g(view);
                }
            });
        }
        ImageView imageView6 = this.u;
        if (imageView6 != null) {
            imageView6.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f(view);
                }
            });
        }
        ImageView imageView7 = this.w;
        if (imageView7 != null) {
            imageView7.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.e(view);
                }
            });
        }
        ImageView imageView8 = this.x;
        if (imageView8 != null) {
            imageView8.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.d(view);
                }
            });
        }
        TextView textView8 = this.f15840d;
        if (textView8 != null) {
            textView8.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.c(view);
                }
            });
        }
        TextView textView9 = this.f15841e;
        if (textView9 != null) {
            textView9.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.b(view);
                }
            });
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15838b.getLayoutParams();
        Rect framingRect = this.o.getFramingRect();
        int i3 = 435;
        if (framingRect != null) {
            i3 = framingRect.height();
            i2 = framingRect.width();
        } else {
            i2 = 435;
        }
        layoutParams.height = i3;
        layoutParams.width = i2;
        this.f15838b.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f15839c.getLayoutParams();
        layoutParams2.width = i2 - 10;
        this.f15839c.setLayoutParams(layoutParams2);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, ((((float) i3) / ((float) ((displayMetrics.densityDpi * 44) / 160))) - 0.0f) - 1.0f);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setRepeatCount(-1);
        this.f15839c.startAnimation(translateAnimation);
        this.t = (ImageView) inflate.findViewById(R.id.qr_header_flash_icon);
        if (Build.VERSION.SDK_INT >= 5) {
            if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                this.t.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a.this.p(view);
                    }
                });
            } else {
                this.t.setVisibility(8);
            }
        }
        this.z = (RelativeLayout) inflate.findViewById(R.id.capture_permission_denied_layout);
        this.B = (Button) inflate.findViewById(R.id.capture_enable_camera_btn);
        this.B.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.o(view);
            }
        });
        this.C = true;
        d();
        LinearLayout linearLayout2 = this.V;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        try {
            inflate.findViewById(R.id.refer_shop_tr).setOnClickListener($$Lambda$a$0X66zmCKqjsgLPr1QV3rDvvWah8.INSTANCE);
        } catch (Exception unused) {
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        if (!c()) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getActivity().getPackageName(), (String) null));
            startActivityForResult(intent, 401);
            return;
        }
        requestPermissions(new String[]{"android.permission.CAMERA"}, 51);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        if (this.G) {
            this.t.setImageResource(R.drawable.mall_flash_on);
            this.t.setContentDescription(getString(R.string.tb_flash_on));
        } else {
            this.t.setImageResource(R.drawable.mall_flash_off);
            this.t.setContentDescription(getString(R.string.tb_flash_off));
        }
        this.G = !this.G;
        this.F.a();
        net.one97.scanner.camera.d dVar = this.E;
        if (dVar != null) {
            dVar.a();
            this.E = null;
        }
        f();
        j();
    }

    static /* synthetic */ void a(a aVar, CJRQRInfoResponse cJRQRInfoResponse, String str) {
        aVar.a();
        if (cJRQRInfoResponse == null) {
            return;
        }
        if (cJRQRInfoResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
            JSONObject response = cJRQRInfoResponse.getResponse();
            try {
                response.put(CJRQRScanResultModel.KEY_QR_CODE_ID, aVar.R);
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
            if ("UTS".equals(response.optString("service"))) {
                new com.google.gsonhtcfix.f().a(response.optJSONObject("uts").toString(), new CJRBrtsUTS().getClass());
            } else if ("DEEPLINK".equals(response.optString("service"))) {
                CJRExtendedInfoData cJRExtendedInfoData = (CJRExtendedInfoData) new com.google.gsonhtcfix.f().a(response.optJSONObject("extendedInfo").toString(), new CJRExtendedInfoData().getClass());
                cJRExtendedInfoData.setQrCodeId(response.optString("qrCodeId"));
                cJRExtendedInfoData.setmQRCodeRefrenceOrderID(response.optString("ORDER_ID"));
                if (!TextUtils.isEmpty(cJRExtendedInfoData.getDeepLink())) {
                    new StringBuilder("deeplink - ").append(cJRExtendedInfoData.getDeepLink());
                    if (aVar.L != null) {
                        aVar.S = cJRExtendedInfoData.getmQrCodeTimestamp();
                        aVar.L.a(cJRExtendedInfoData.getDeepLink(), cJRExtendedInfoData);
                        return;
                    }
                    return;
                }
                aVar.a(aVar.getString(R.string.error), aVar.getString(R.string.some_went_wrong));
            } else {
                com.paytmmall.artifact.scan.d.a.a().a((Context) aVar.getActivity(), response.toString(), str, 2);
                if (!aVar.p) {
                    aVar.p = false;
                    try {
                        JSONObject jSONObject = new JSONObject(response.toString());
                        com.paytmmall.artifact.scan.entity.a aVar2 = new com.paytmmall.artifact.scan.entity.a();
                        aVar2.a(jSONObject, aVar.getActivity());
                        if (!TextUtils.isEmpty(aVar.X)) {
                            jSONObject.put("ORDER_ID", aVar.X);
                        }
                        if (TextUtils.isEmpty(aVar2.f15888f) && !TextUtils.isEmpty(aVar.Y)) {
                            jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_NAME, aVar.Y);
                        }
                        if (aVar.Z != null) {
                            jSONObject.put("TXN_AMOUNT", aVar.Z);
                        }
                        if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(aVar2.f15883a)) {
                            Intent intent = new Intent();
                            intent.putExtra("NAME", aVar2.f15887e);
                            intent.putExtra("PHONE_NUMBER", aVar2.f15886d);
                            intent.putExtra("MODE", "QR_CODE");
                            aVar.getActivity().finish();
                        }
                    } catch (JSONException e3) {
                        q.c(e3.getMessage());
                    }
                } else if (!aVar.ad) {
                    com.paytmmall.artifact.scan.d.a a2 = com.paytmmall.artifact.scan.d.a.a();
                    FragmentActivity activity = aVar.getActivity();
                    if (a2.f15881a != null) {
                        RecentScan recentScan = a2.f15881a;
                        ArrayList arrayList = new ArrayList(10);
                        if (recentScan instanceof RecentScan) {
                            String s2 = com.paytm.utility.b.s((Context) activity);
                            String t2 = com.paytm.utility.b.t((Context) activity);
                            double currentTimeMillis = (double) System.currentTimeMillis();
                            int i2 = Calendar.getInstance().get(7);
                            if (!"".equalsIgnoreCase(s2)) {
                                RecentScan recentScan2 = recentScan;
                                recentScan2.getMachineIntelligent().getLocation().setLatitudeweight(Double.parseDouble(s2));
                                recentScan2.getMachineIntelligent().getLocation().setLatitudeCount(1);
                            }
                            if (!"".equalsIgnoreCase(t2)) {
                                RecentScan recentScan3 = recentScan;
                                recentScan3.getMachineIntelligent().getLocation().setLongitudeweight(Double.parseDouble(s2));
                                recentScan3.getMachineIntelligent().getLocation().setLongitudeCount(1);
                            }
                            RecentScan recentScan4 = recentScan;
                            recentScan4.getMachineIntelligent().getTimeOfDay().setTimeOfDayweight(currentTimeMillis);
                            recentScan4.getMachineIntelligent().getTimeOfDay().setTimeOfDayCount(1);
                            recentScan4.getMachineIntelligent().getWeekday().updateweekdaycount(recentScan4.getMachineIntelligent().getWeekday(), i2);
                        }
                        arrayList.add(0, recentScan);
                        a2.f15881a = null;
                    }
                }
            }
        } else {
            aVar.a(aVar.getString(R.string.error), cJRQRInfoResponse.getStatusMessage());
        }
    }

    static /* synthetic */ void a(a aVar, SparseArray sparseArray) {
        String str;
        if (sparseArray.size() > 0) {
            aVar.M++;
        }
        String str2 = null;
        String str3 = null;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            com.google.android.gms.vision.a.d dVar = (com.google.android.gms.vision.a.d) sparseArray.valueAt(i2);
            if (TextUtils.isEmpty(str2)) {
                String[] split = dVar.a().split("\\s|\\n");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        str = null;
                        break;
                    }
                    str = split[i3];
                    if (!TextUtils.isEmpty(str) && str.trim().length() > 6 && str.trim().length() <= 18 && str.trim().replaceAll("[0123456789]", "").length() == 0) {
                        break;
                    }
                    i3++;
                }
                str2 = str;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = com.paytmmall.artifact.scan.d.b.c(dVar.a());
            }
        }
        if (aVar.M < 10) {
            return;
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            aVar.J.b();
            aVar.I = false;
            Intent intent = new Intent();
            intent.putExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str2);
            intent.putExtra("ifsc_code", str3);
            intent.putExtra("is_from_scan_text", true);
            aVar.getActivity().setResult(-1, intent);
            aVar.getActivity().finish();
        }
    }
}
