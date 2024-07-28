package net.one97.paytm.wallet.newdesign.fastscan;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRExtendedInfoData;
import net.one97.paytm.common.entity.wallet.CJRQRInfoResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.p2mNewDesign.models.SingleAPIBodyV2;
import net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2;
import net.one97.paytm.p2mNewDesign.models.c;
import net.one97.paytm.utils.bd;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.a.d;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.newdesign.fastscan.FastScan.b;
import net.one97.paytm.wallet.newdesign.fastscan.a.c;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a extends net.one97.paytm.base.b implements SensorEventListener, SurfaceHolder.Callback, net.one97.paytm.fastscanner.c.d {
    private String A;
    private boolean B;
    /* access modifiers changed from: private */
    public boolean C = true;
    /* access modifiers changed from: private */
    public net.one97.paytm.wallet.f.c D;
    private boolean E;
    private HashMap F;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f70908a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70909b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f70910c;

    /* renamed from: e  reason: collision with root package name */
    protected String f70911e;

    /* renamed from: f  reason: collision with root package name */
    protected String f70912f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f70913g;

    /* renamed from: h  reason: collision with root package name */
    net.one97.paytm.wallet.a.e f70914h = new net.one97.paytm.wallet.a.e();

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.wallet.newdesign.fastscan.FastScan.b f70915i;
    public net.one97.paytm.wallet.f.b j;
    protected boolean k = true;
    protected SensorManager l;
    protected Sensor m;
    protected boolean n;
    public boolean o;
    protected boolean p;
    public final int q = 1;
    protected boolean r = true;
    private boolean s;
    private boolean t;
    private net.one97.paytm.wallet.newdesign.a.c u;
    private boolean v;
    private boolean w;
    private String x;
    private String y;
    private String z;

    /* renamed from: net.one97.paytm.wallet.newdesign.fastscan.a$a  reason: collision with other inner class name */
    public static final class C1434a implements Camera.AutoFocusCallback {

        /* renamed from: a  reason: collision with root package name */
        public static final C1434a f70916a = new C1434a();

        C1434a() {
        }

        public final void onAutoFocus(boolean z, Camera camera) {
        }
    }

    public View a(int i2) {
        if (this.F == null) {
            this.F = new HashMap();
        }
        View view = (View) this.F.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.F.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract void a(String str, boolean z2, boolean z3);

    public abstract void b(int i2);

    public void c() {
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public abstract void e();

    public abstract void f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract LottieAnimationView k();

    public abstract void l();

    public abstract void m();

    public abstract String n();

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        k.c(surfaceHolder, "holder");
    }

    static final class c<T> implements z<net.one97.paytm.wallet.a.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70930a;

        c(a aVar) {
            this.f70930a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.wallet.a.d dVar = (net.one97.paytm.wallet.a.d) obj;
            if (this.f70930a.C) {
                a.c(this.f70930a);
                if (dVar instanceof d.e) {
                    d.e eVar = (d.e) dVar;
                    a aVar = this.f70930a;
                    if (eVar == null) {
                        k.a();
                    }
                    String str = eVar.f69859a;
                    Boolean bool = eVar.f69860b;
                    if (bool == null) {
                        k.a();
                    }
                    boolean booleanValue = bool.booleanValue();
                    Boolean bool2 = eVar.f69860b;
                    if (bool2 == null) {
                        k.a();
                    }
                    aVar.a(str, booleanValue, bool2.booleanValue());
                } else if (dVar instanceof d.h) {
                    net.one97.paytm.p2mNewDesign.models.b.c().f();
                    d.h hVar = (d.h) dVar;
                    a aVar2 = this.f70930a;
                    if (hVar == null) {
                        k.a();
                    }
                    aVar2.a(hVar.f69866a, hVar.f69867b);
                } else if (dVar instanceof d.j) {
                    a.d(this.f70930a);
                } else if (dVar instanceof d.g) {
                    a.a(this.f70930a, ((d.g) dVar).f69865a);
                } else if (dVar instanceof d.i) {
                    net.one97.paytm.p2mNewDesign.models.b.c().f();
                    d.i iVar = (d.i) dVar;
                    a.a(this.f70930a, iVar.f69870c);
                    this.f70930a.a(iVar.f69868a, iVar.f69869b);
                } else {
                    dVar.a(this.f70930a.f70914h);
                }
                this.f70930a.C = false;
            }
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70941a;

        d(a aVar) {
            this.f70941a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f70941a.j();
            }
        }
    }

    public final net.one97.paytm.wallet.f.b d() {
        net.one97.paytm.wallet.f.b bVar = this.j;
        if (bVar == null) {
            k.a("mGalleryOpenListener");
        }
        return bVar;
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        net.one97.paytm.fastscanner.c.a aVar = net.one97.paytm.fastscanner.c.a.f50448b;
        k.c("net.one97.paytm.wallet.newdesign.fastscan.FastScannerCommunicator", H5TabbarUtils.MATCH_TYPE_PATH);
        net.one97.paytm.fastscanner.c.a.f50447a = "net.one97.paytm.wallet.newdesign.fastscan.FastScannerCommunicator";
        net.one97.paytm.fastscanner.c.a.a("net.one97.paytm.wallet.newdesign.fastscan.FastScannerCommunicator");
        bd.f69715a.a("FASTSCANFRAGMENTV2_TRACE");
        this.f70915i = (net.one97.paytm.wallet.newdesign.fastscan.FastScan.b) am.a((Fragment) this).a(net.one97.paytm.wallet.newdesign.fastscan.FastScan.b.class);
        this.u = new net.one97.paytm.wallet.newdesign.a.c(context);
        if (getActivity() != null && (getActivity() instanceof net.one97.paytm.wallet.f.c)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.D = (net.one97.paytm.wallet.f.c) activity;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.listeners.GenericQRListener");
            }
        }
        net.one97.paytm.wallet.a.e eVar = this.f70914h;
        eVar.f69875a = this.D;
        eVar.f69876b = getActivity();
        if (getActivity() != null && (getActivity() instanceof net.one97.paytm.wallet.f.b)) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                this.j = (net.one97.paytm.wallet.f.b) activity2;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.listeners.GalleryOpenListener");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(g(), viewGroup, false);
        if (this.t && (str = this.f70911e) != null) {
            a(str, this.f70910c);
        }
        p();
        return inflate;
    }

    public final void c(String str, Runnable runnable) {
        k.c(str, "permission");
        if (p.a(str, "android.permission.CAMERA", true)) {
            this.w = true;
            b(0);
            return;
        }
        super.c(str, runnable);
    }

    public void onResume() {
        c cVar;
        super.onResume();
        e();
        if (!this.w) {
            i();
            q();
        }
        this.k = false;
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar = this.f70915i;
        if (!(bVar == null || (cVar = bVar.f70898a) == null)) {
            String uuid = UUID.randomUUID().toString();
            k.a((Object) uuid, "UUID.randomUUID().toString()");
            k.c(uuid, "scanSessionId");
            cVar.f70937g = uuid;
        }
        this.C = true;
        j.a().b();
        bd.f69715a.b("FASTSCANFRAGMENTV2_TRACE");
    }

    public final void b(String str, Runnable runnable) {
        k.c(str, "permission");
        this.w = true;
        super.b(str, runnable);
    }

    public void o() {
        this.f70914h.a(Boolean.valueOf(this.f70909b));
    }

    public void p() {
        y<Boolean> yVar;
        y<net.one97.paytm.wallet.a.d> yVar2;
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar = this.f70915i;
        if (bVar != null) {
            bVar.f70903f = Long.valueOf(System.currentTimeMillis());
        }
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar2 = this.f70915i;
        if (bVar2 != null) {
            boolean z2 = this.f70909b;
            bVar2.f70898a.c();
            bVar2.f70898a.f70932b.observeForever(new b.a(bVar2, z2));
            bVar2.f70898a.f70933c.observeForever(new b.C1433b(bVar2));
            bVar2.f70898a.f70934d.observeForever(new b.c(bVar2));
        }
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar3 = this.f70915i;
        if (!(bVar3 == null || (yVar2 = bVar3.f70899b) == null)) {
            yVar2.observe(getViewLifecycleOwner(), new c(this));
        }
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar4 = this.f70915i;
        if (bVar4 != null && (yVar = bVar4.f70900c) != null) {
            yVar.observe(getViewLifecycleOwner(), new d(this));
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        k.c(surfaceHolder, "surfaceHolder");
        this.s = true;
        this.f70908a = surfaceHolder;
        h();
        bd.f69715a.b("SCANNER_TRACE");
    }

    /* access modifiers changed from: private */
    public final void a(String str, boolean z2) {
        long j2;
        long j3;
        Long l2;
        Long l3;
        String str2 = str;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                net.one97.paytm.wallet.e.a aVar = net.one97.paytm.wallet.e.a.f70357a;
                if (net.one97.paytm.wallet.e.a.a().containsKey(str2)) {
                    net.one97.paytm.wallet.e.a aVar2 = net.one97.paytm.wallet.e.a.f70357a;
                    SingleAPIResponseV2 singleAPIResponseV2 = net.one97.paytm.wallet.e.a.a().get(str2);
                    if (singleAPIResponseV2 != null) {
                        SingleAPIResponseV2 singleAPIResponseV22 = singleAPIResponseV2;
                        SingleAPIBodyV2 body = singleAPIResponseV22.getBody();
                        CJRQRInfoResponse cJRQRInfoResponse = null;
                        if ((body != null ? body.getQrInfo() : null) != null) {
                            if (singleAPIResponseV22 == null) {
                                k.a();
                            }
                            SingleAPIBodyV2 body2 = singleAPIResponseV22.getBody();
                            if (body2 != null) {
                                cJRQRInfoResponse = body2.getQrInfo();
                            }
                            if (cJRQRInfoResponse == null) {
                                k.a();
                            }
                            if (p.a(cJRQRInfoResponse.getStatusCode(), "SUCCESS", true)) {
                                SingleAPIBodyV2 body3 = singleAPIResponseV22.getBody();
                                if (body3 == null) {
                                    k.a();
                                }
                                CJRQRInfoResponse qrInfo = body3.getQrInfo();
                                if (qrInfo == null) {
                                    k.a();
                                }
                                JSONObject response = qrInfo.getResponse();
                                k.a((Object) response, "singleAPIResponse!!.body!!.qrInfo!!.response");
                                try {
                                    response.put(CJRQRScanResultModel.KEY_QR_CODE_ID, str2);
                                } catch (JSONException unused) {
                                }
                                String jSONObject = response.toString();
                                k.a((Object) jSONObject, "payData.toString()");
                                b(jSONObject, true);
                                net.one97.paytm.b.a.e.a().c();
                                if (this.f70915i != null && net.one97.paytm.wallet.newdesign.fastscan.FastScan.b.e()) {
                                    f();
                                }
                                k.a((Object) net.one97.paytm.b.a.e.a(), "SingleAPIManager.getInstance()");
                                y<net.one97.paytm.p2mNewDesign.models.c<Object>> d2 = net.one97.paytm.b.a.e.d();
                                c.a aVar3 = net.one97.paytm.p2mNewDesign.models.c.f56934d;
                                d2.postValue(c.a.a(singleAPIResponseV22));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2");
                }
                BaseActivity baseActivity = (BaseActivity) getActivity();
                Context context = getContext();
                net.one97.paytm.wallet.newdesign.a.c cVar = this.u;
                String str3 = this.x;
                boolean z3 = this.B;
                String str4 = this.f70911e;
                boolean z4 = this.f70909b;
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar = this.f70915i;
                if (bVar == null || (l3 = bVar.f70902e) == null) {
                    j2 = System.currentTimeMillis();
                } else {
                    j2 = l3.longValue();
                }
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar2 = this.f70915i;
                if (bVar2 == null || (l2 = bVar2.f70903f) == null) {
                    j3 = System.currentTimeMillis();
                } else {
                    j3 = l2.longValue();
                }
                net.one97.paytm.wallet.a.c.a(baseActivity, context, str, z2, cVar, str3, z3, str4, z4, j2, j3, new b(this), this.f70912f);
            }
        }
    }

    public static final class b implements net.one97.paytm.wallet.a.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70928a;

        b(a aVar) {
            this.f70928a = aVar;
        }

        public final void e() {
            this.f70928a.q();
        }

        public final void a() {
            LottieAnimationView k;
            a aVar = this.f70928a;
            if (aVar.getView() != null && (k = aVar.k()) != null) {
                a.a(k);
            }
        }

        public final void b() {
            this.f70928a.r();
        }

        public final void a(String str) {
            k.c(str, "message");
            a aVar = this.f70928a;
            Context context = aVar.getContext();
            if (context == null) {
                k.a();
            }
            String string = context.getString(R.string.error);
            k.a((Object) string, "context!!.getString(R.string.error)");
            a.a(aVar, string, str);
        }

        public final void a(String str, boolean z) {
            k.c(str, "scanResultJson");
            this.f70928a.b(str, z);
            a.e(this.f70928a);
            if (this.f70928a.f70915i != null && net.one97.paytm.wallet.newdesign.fastscan.FastScan.b.e()) {
                this.f70928a.f();
            }
        }

        public final void a(IJRDataModel iJRDataModel) {
            k.c(iJRDataModel, "utsData");
            this.f70928a.startActivityForResult(net.one97.paytm.wallet.communicator.b.a().getBRTSIntent(this.f70928a.getContext(), iJRDataModel), 1802);
        }

        public final void c() {
            net.one97.paytm.wallet.utility.a.a((Fragment) this.f70928a);
        }

        public final void a(CJRExtendedInfoData cJRExtendedInfoData) {
            k.c(cJRExtendedInfoData, "deepLinkData");
            Bundle bundle = new Bundle();
            bundle.putString("qrCodeId", cJRExtendedInfoData.getQrCodeId());
            bundle.putBoolean("isFromScan", true);
            if (net.one97.paytm.wallet.utility.a.m(cJRExtendedInfoData.getDeepLink())) {
                net.one97.paytm.wallet.communicator.b.a().handleDeepLink(this.f70928a.getActivity(), cJRExtendedInfoData.getDeepLink(), bundle);
                return;
            }
            net.one97.paytm.wallet.f.c f2 = this.f70928a.D;
            if (f2 != null) {
                f2.a(cJRExtendedInfoData.getDeepLink(), cJRExtendedInfoData);
            }
        }

        public final void a(boolean z) {
            if (this.f70928a.getActivity() != null) {
                FragmentActivity activity = this.f70928a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                if (!activity.isFinishing() && !this.f70928a.isDetached() && !z) {
                    HashMap hashMap = new HashMap();
                    Map map = hashMap;
                    map.put("screen_name", this.f70928a.n());
                    map.put("flowName", "Offline_Payments");
                    net.one97.paytm.wallet.communicator.b.a().pushHawkeyeEvent(this.f70928a.getContext(), -1, net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f70928a.getContext(), "pgQRInfoURL"), "NA", "It seems your internet is slow, so we are not able to scan this QR. Please check your internet connection and try scanning the QR code again.", 0, a.b.USER_FACING, hashMap, a.c.PAY);
                    Toast.makeText(this.f70928a.getActivity(), this.f70928a.getString(R.string.network_slow_error_message), 0).show();
                }
            }
        }

        public final void d() {
            LottieAnimationView k;
            if (this.f70928a.getActivity() != null) {
                FragmentActivity activity = this.f70928a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                if (!activity.isFinishing() && !this.f70928a.isDetached() && this.f70928a.getView() != null && (k = this.f70928a.k()) != null) {
                    a.b(k);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, boolean z2) {
        JSONObject jSONObject = new JSONObject(str);
        CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
        cJRQRScanResultModel.parseData(jSONObject, (Context) getActivity());
        if (!TextUtils.isEmpty(this.f70912f)) {
            jSONObject.put("ORDER_ID", this.f70912f);
        }
        if (TextUtils.isEmpty(cJRQRScanResultModel.getMerchantName()) && !TextUtils.isEmpty(this.y)) {
            jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_NAME, this.y);
        }
        String str2 = this.z;
        if (str2 != null) {
            jSONObject.put("TXN_AMOUNT", str2);
        }
        String str3 = this.A;
        if (str3 != null) {
            jSONObject.put(CJRQRScanResultModel.DESCRIPTION, str3);
        }
        jSONObject.put(CJRQRScanResultModel.KEY_IS_FROM_UPI_INTENT, this.B);
        if (p.a("QR_CODE_REQUEST_MONEY", cJRQRScanResultModel.getRequestType(), true)) {
            this.v = true;
            Intent intent = new Intent();
            intent.putExtra("NAME", cJRQRScanResultModel.getName());
            intent.putExtra("PHONE_NUMBER", cJRQRScanResultModel.getMobileNo());
            intent.putExtra("MODE", "QR_CODE");
            getContext();
            net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
            k.a((Object) a2, "universalP2PGAEventManager");
            a2.a(a.c.QR_SCAN_PAYTM_P2P);
            net.one97.paytm.wallet.utility.a.a(intent, (Activity) getActivity());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            String jSONObject2 = jSONObject.toString();
            k.a((Object) jSONObject2, "payData.toString()");
            a(jSONObject2, z2, false);
        }
        this.w = false;
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f70944a;

        g(com.paytm.utility.h hVar) {
            this.f70944a = hVar;
        }

        public final void onClick(View view) {
            this.f70944a.cancel();
        }
    }

    static final class h implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70945a;

        h(a aVar) {
            this.f70945a = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f70945a.q();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f70942a;

        e(com.paytm.utility.h hVar) {
            this.f70942a = hVar;
        }

        public final void onClick(View view) {
            this.f70942a.dismiss();
        }
    }

    static final class f implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70943a;

        f(a aVar) {
            this.f70943a = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f70943a.q();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        k.c(surfaceHolder, "holder");
        this.s = false;
    }

    public final void q() {
        net.one97.paytm.wallet.newdesign.fastscan.a.c cVar;
        this.C = true;
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar = this.f70915i;
        if (bVar != null && (cVar = bVar.f70898a) != null) {
            cVar.c();
        }
    }

    public static float a(MotionEvent motionEvent) {
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        double y2 = (double) (motionEvent.getY(0) - motionEvent.getY(1));
        return (float) Math.sqrt(((double) (x2 * x2)) + (y2 * y2));
    }

    public final void r() {
        LottieAnimationView k2;
        if (getView() != null && (k2 = k()) != null) {
            b(k2);
        }
    }

    public final void a() {
        if (this.f70915i != null && !net.one97.paytm.wallet.newdesign.fastscan.FastScan.b.e()) {
            f();
            this.n = true;
            net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
            boolean z2 = this.f70909b;
            Map hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            hashMap.put("new_wallet_pay_flash_options", "autoFlashOn");
            hashMap.put("scan_source_screen_type", z2 ? "scan_icon" : "pay_icon");
            String str = z2 ? "flow_through_scan_icon" : "flow_through_pay_icon";
            Context a2 = net.one97.paytm.wallet.a.a.a();
            k.a((Object) a2, "getContext()");
            net.one97.paytm.wallet.a.a.a("offline_payments", "scan_screen_autoFlashOn", str, a2, "home/pay-send/post-scan");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(net.one97.paytm.wallet.a.a.a(), "new_wallet_pay_flash_options_clicked", hashMap);
        }
    }

    public final boolean aI_() {
        return this.E;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            boolean z2 = false;
            if (sensorEvent.values[0] < 10.0f) {
                z2 = true;
            }
            this.E = z2;
        }
    }

    public static int a(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return iArr[1] + view.getHeight();
    }

    public static int b(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public static final /* synthetic */ void c(a aVar) {
        Window window;
        View decorView;
        try {
            FragmentActivity activity = aVar.getActivity();
            if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView.performHapticFeedback(1, 2);
            }
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void d(a aVar) {
        if (aVar.getActivity() != null) {
            FragmentActivity activity = aVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                com.paytm.utility.h hVar = new com.paytm.utility.h(aVar.getContext());
                hVar.setTitle(aVar.getResources().getString(R.string.no_connection));
                hVar.a(aVar.getResources().getString(R.string.no_internet));
                hVar.a(-3, aVar.getResources().getString(R.string.ok), new g(hVar));
                hVar.setOnDismissListener(new h(aVar));
                hVar.setCancelable(true);
                hVar.show();
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        Map<String, String> map;
        aVar.x = str;
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            map = net.one97.paytm.wallet.utility.a.j(str);
            k.a((Object) map, "CJRWalletUtility.splitQuery(qrData)");
        } catch (Exception unused) {
            map = linkedHashMap;
        }
        if (map.containsKey("pn")) {
            aVar.y = map.get("pn");
        }
        if (map.containsKey("tr")) {
            aVar.f70912f = map.get("tr");
        }
        if (map.containsKey("am")) {
            aVar.z = map.get("am");
        }
        if (map.containsKey("tn")) {
            aVar.A = map.get("tn");
        }
        aVar.B = true;
    }

    public static final /* synthetic */ void a(a aVar, String str, String str2) {
        com.paytm.utility.h hVar = new com.paytm.utility.h(aVar.getContext());
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCancelable(true);
        hVar.a(-3, aVar.getResources().getString(R.string.ok), new e(hVar));
        hVar.setOnDismissListener(new f(aVar));
        if (aVar.getActivity() != null) {
            FragmentActivity activity = aVar.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (!activity.isFinishing() && !aVar.isDetached()) {
                hVar.show();
            }
        }
    }

    public static final /* synthetic */ void e(a aVar) {
        aVar.z = null;
        aVar.f70912f = null;
        aVar.A = null;
        aVar.x = null;
        aVar.B = false;
    }
}
