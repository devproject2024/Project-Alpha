package net.one97.paytm.recharge.mobile_v3.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.e.ac;
import net.one97.paytm.recharge.common.e.ah;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.e.p;
import net.one97.paytm.recharge.common.utils.aa;
import net.one97.paytm.recharge.common.utils.an;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.mobile_v3.activity.AJRMobileRechargeActivityV3;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class g extends net.one97.paytm.i.h implements net.one97.paytm.recharge.common.b.a.a, ah, ai, net.one97.paytm.recharge.mobile.d {

    /* renamed from: a  reason: collision with root package name */
    boolean f63846a;

    /* renamed from: b  reason: collision with root package name */
    private CJRItem f63847b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f63848c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.recharge.mobile.d.a f63849d;

    /* renamed from: e  reason: collision with root package name */
    private aa f63850e;

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<n> f63851f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashSet<p> f63852g = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f63853h;

    /* renamed from: i  reason: collision with root package name */
    private String f63854i;
    private boolean j;
    private h k;
    private final String l = "android:support:fragments";
    private HashMap m;

    static final /* synthetic */ class b extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        b(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class c extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        c(g gVar) {
            super(1, gVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((g) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class d extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        d(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class e extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        e(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class f extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        f(g gVar) {
            super(1, gVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((g) this.receiver).a(cJRInstruct);
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.b.g$g  reason: collision with other inner class name */
    static final /* synthetic */ class C1250g extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        C1250g(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class h extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        h(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class i extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        i(g gVar) {
            super(1, gVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((g) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class j extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        j(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class k extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        k(g gVar) {
            super(3, gVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((g) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class l extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        l(g gVar) {
            super(1, gVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(g.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((g) this.receiver).a(cJRInstruct);
        }
    }

    public final void a(boolean z) {
        net.one97.paytm.recharge.mobile.d.a aVar;
        if (z && (aVar = this.f63849d) != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            aVar.b(net.one97.paytm.recharge.widgets.c.d.b());
        }
        this.f63846a = z;
    }

    public final void onCreate(Bundle bundle) {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                kotlin.g.b.k.a();
            }
            Serializable serializable = arguments.getSerializable("recharge_item");
            if (serializable != null) {
                this.f63847b = (CJRItem) serializable;
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    kotlin.g.b.k.a();
                }
                this.f63848c = arguments2.getBoolean("open_activity_in_automatic_mode");
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    kotlin.g.b.k.a();
                }
                this.f63853h = arguments3.getBoolean("is_recharge_tabs_flow", false);
                Bundle arguments4 = getArguments();
                if (arguments4 == null) {
                    kotlin.g.b.k.a();
                }
                this.f63854i = arguments4.getString("recharge.component.name");
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
            }
        }
        if (!TextUtils.isEmpty(this.f63854i)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " started " + this.f63854i);
            if (bundle != null && bundle.containsKey(this.l)) {
                bundle.remove(this.l);
            }
        }
        super.onCreate(bundle);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010e, code lost:
        if (r6.equals("datacard_postpaid") != false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0110, code lost:
        r3 = 23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011b, code lost:
        if (r6.equals("datacard-prepaid") != false) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011d, code lost:
        r3 = 19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012a, code lost:
        if (r3.intValue() != 23) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0162, code lost:
        if (androidx.core.content.b.a((android.content.Context) r3, "android.permission.READ_CONTACTS") == 0) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b9, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "21", (java.lang.Object) r10.r.getCategoryId()) != false) goto L_0x01bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0258 A[Catch:{ all -> 0x0324 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0151 A[Catch:{ all -> 0x0324 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0184 A[Catch:{ all -> 0x0324 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a1 A[Catch:{ all -> 0x0324 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e3 A[Catch:{ all -> 0x0324 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
            r8 = this;
            java.lang.String r11 = "17"
            java.lang.String r0 = "context!!"
            java.lang.String r1 = "inflater"
            kotlin.g.b.k.c(r9, r1)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            int r1 = net.one97.paytm.recharge.R.layout.fragment_mobile_landing
            r2 = 0
            android.view.View r9 = r9.inflate(r1, r10, r2)
            net.one97.paytm.common.entity.CJRItem r10 = r8.f63847b     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x032a
            java.lang.String r10 = r8.f63854i     // Catch:{ all -> 0x0324 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0324 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0324 }
            r1 = 0
            if (r10 == 0) goto L_0x028e
            net.one97.paytm.recharge.common.h.d r10 = new net.one97.paytm.recharge.common.h.d     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.h.d$a r2 = new net.one97.paytm.recharge.common.h.d$a     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.h.d$b r3 = net.one97.paytm.recharge.common.h.d.b.MOBILE     // Catch:{ all -> 0x0324 }
            r2.<init>(r3)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.common.entity.CJRItem r3 = r8.f63847b     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x0034
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x0034:
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.common.entity.CJRItem) r3)     // Catch:{ all -> 0x0324 }
            android.content.Context r3 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x0041
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x0041:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile.b r3 = net.one97.paytm.recharge.common.b.d.c(r3)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.b.c r3 = (net.one97.paytm.recharge.common.b.c) r3     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.recharge.common.b.c) r3)     // Catch:{ all -> 0x0324 }
            android.content.Context r3 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x0057
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x0057:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.utils.w r3 = net.one97.paytm.recharge.common.b.d.d(r3)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.recharge.common.utils.w) r3)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.g$b r3 = new net.one97.paytm.recharge.mobile_v3.b.g$b     // Catch:{ all -> 0x0324 }
            r4 = r8
            net.one97.paytm.recharge.mobile_v3.b.g r4 = (net.one97.paytm.recharge.mobile_v3.b.g) r4     // Catch:{ all -> 0x0324 }
            r3.<init>(r4)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((kotlin.k.e<kotlin.x>) r3)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.ordersummary.h.d r3 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ all -> 0x0324 }
            android.content.Context r4 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r4 != 0) goto L_0x0079
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x0079:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0324 }
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = "context!!.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0324 }
            r3.<init>(r4)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.common.entity.CJRItem r4 = r8.f63847b     // Catch:{ all -> 0x0324 }
            r3.f64343a = r4     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.h.d$a r2 = r2.a((net.one97.paytm.recharge.ordersummary.h.d) r3)     // Catch:{ all -> 0x0324 }
            r10.<init>(r2)     // Catch:{ all -> 0x0324 }
            androidx.lifecycle.al$b r10 = (androidx.lifecycle.al.b) r10     // Catch:{ all -> 0x0324 }
            androidx.lifecycle.al r10 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r8, (androidx.lifecycle.al.b) r10)     // Catch:{ all -> 0x0324 }
            java.lang.Class<net.one97.paytm.recharge.mobile.d.a> r2 = net.one97.paytm.recharge.mobile.d.a.class
            androidx.lifecycle.ai r10 = r10.a(r2)     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = "ViewModelProviders.of(th…elFactory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile.d.a r10 = (net.one97.paytm.recharge.mobile.d.a) r10     // Catch:{ all -> 0x0324 }
            r8.f63849d = r10     // Catch:{ all -> 0x0324 }
            r2 = 1
            r10.w = r2     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.b.a r3 = r10.x     // Catch:{ all -> 0x0324 }
            r3.f60871b = r2     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r3 = r10.f61408a     // Catch:{ all -> 0x0324 }
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.g$c r4 = new net.one97.paytm.recharge.mobile_v3.b.g$c     // Catch:{ all -> 0x0324 }
            r5 = r8
            net.one97.paytm.recharge.mobile_v3.b.g r5 = (net.one97.paytm.recharge.mobile_v3.b.g) r5     // Catch:{ all -> 0x0324 }
            r4.<init>(r5)     // Catch:{ all -> 0x0324 }
            kotlin.g.a.b r4 = (kotlin.g.a.b) r4     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.utils.ai.a(r8, r3, r4)     // Catch:{ all -> 0x0324 }
            boolean r3 = r8.f63848c     // Catch:{ all -> 0x0324 }
            r10.f61411d = r3     // Catch:{ all -> 0x0324 }
            net.one97.paytm.common.entity.CJRItem r3 = r10.r     // Catch:{ all -> 0x0324 }
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ all -> 0x0324 }
            if (r3 == 0) goto L_0x00d5
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x0324 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0324 }
            goto L_0x00d6
        L_0x00d5:
            r3 = r1
        L_0x00d6:
            r4 = 19
            r5 = 23
            if (r3 == 0) goto L_0x0121
            net.one97.paytm.common.entity.CJRItem r6 = r10.r     // Catch:{ all -> 0x0324 }
            java.lang.String r6 = r6.getURLType()     // Catch:{ all -> 0x0324 }
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0324 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0324 }
            if (r7 != 0) goto L_0x0121
            if (r6 != 0) goto L_0x00ee
            goto L_0x0121
        L_0x00ee:
            int r7 = r6.hashCode()     // Catch:{ all -> 0x0324 }
            switch(r7) {
                case 682105564: goto L_0x0115;
                case 1529423953: goto L_0x0108;
                case 1707833887: goto L_0x00ff;
                case 1923276394: goto L_0x00f6;
                default: goto L_0x00f5;
            }     // Catch:{ all -> 0x0324 }
        L_0x00f5:
            goto L_0x0121
        L_0x00f6:
            java.lang.String r7 = "datacard_prepaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0324 }
            if (r6 == 0) goto L_0x0121
            goto L_0x011d
        L_0x00ff:
            java.lang.String r7 = "datacard-postpaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0324 }
            if (r6 == 0) goto L_0x0121
            goto L_0x0110
        L_0x0108:
            java.lang.String r7 = "datacard_postpaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0324 }
            if (r6 == 0) goto L_0x0121
        L_0x0110:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0324 }
            goto L_0x0121
        L_0x0115:
            java.lang.String r7 = "datacard-prepaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0324 }
            if (r6 == 0) goto L_0x0121
        L_0x011d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0324 }
        L_0x0121:
            java.lang.String r6 = "frequent_api"
            if (r3 != 0) goto L_0x0126
            goto L_0x012c
        L_0x0126:
            int r7 = r3.intValue()     // Catch:{ all -> 0x0324 }
            if (r7 == r5) goto L_0x0142
        L_0x012c:
            if (r3 != 0) goto L_0x012f
            goto L_0x0136
        L_0x012f:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0324 }
            if (r3 != r4) goto L_0x0136
            goto L_0x0142
        L_0x0136:
            java.lang.String r3 = "Mobile"
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)     // Catch:{ all -> 0x0324 }
            r10.b(r6, r3, r4)     // Catch:{ all -> 0x0324 }
            goto L_0x014d
        L_0x0142:
            java.lang.String r3 = "datacard"
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)     // Catch:{ all -> 0x0324 }
            r10.b(r6, r3, r4)     // Catch:{ all -> 0x0324 }
        L_0x014d:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0324 }
            if (r3 < r5) goto L_0x0164
            androidx.fragment.app.FragmentActivity r3 = r8.getActivity()     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x015a
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x015a:
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = "android.permission.READ_CONTACTS"
            int r3 = androidx.core.content.b.a((android.content.Context) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0324 }
            if (r3 != 0) goto L_0x0173
        L_0x0164:
            r3 = r8
            androidx.lifecycle.q r3 = (androidx.lifecycle.q) r3     // Catch:{ all -> 0x0324 }
            androidx.loader.a.a r3 = androidx.loader.a.a.a(r3)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = "LoaderManager.getInstanc…bileControllerFragmentV3)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile.d.a.a((androidx.loader.a.a) r3)     // Catch:{ all -> 0x0324 }
        L_0x0173:
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0324 }
            r3.setErrorType(r4)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()     // Catch:{ all -> 0x0324 }
            if (r4 == 0) goto L_0x018d
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = r5.name()     // Catch:{ all -> 0x0324 }
            r4.setErrorType(r5)     // Catch:{ all -> 0x0324 }
        L_0x018d:
            r10.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = "getCategory"
            net.one97.paytm.common.entity.CJRItem r5 = r10.r     // Catch:{ all -> 0x0324 }
            java.lang.String r5 = r5.getCategoryId()     // Catch:{ all -> 0x0324 }
            r10.a((java.lang.String) r4, (java.lang.String) r5, (net.one97.paytm.recharge.common.e.ai) r10, (net.one97.paytm.recharge.common.b.a.a) r10, (java.lang.Object) r3)     // Catch:{ all -> 0x0324 }
            android.content.Context r3 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r3 == 0) goto L_0x01df
            net.one97.paytm.common.entity.CJRItem r3 = r10.r     // Catch:{ all -> 0x0324 }
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ all -> 0x0324 }
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r3)     // Catch:{ all -> 0x0324 }
            java.lang.String r4 = "21"
            if (r3 != 0) goto L_0x01bb
            net.one97.paytm.common.entity.CJRItem r3 = r10.r     // Catch:{ all -> 0x0324 }
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ all -> 0x0324 }
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ all -> 0x0324 }
            if (r3 == 0) goto L_0x01df
        L_0x01bb:
            java.lang.String r3 = "get.rc.category.in.background"
            android.content.Context r5 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r5 != 0) goto L_0x01c6
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x01c6:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.common.entity.CJRItem r0 = r10.r     // Catch:{ all -> 0x0324 }
            java.lang.String r0 = r0.getCategoryId()     // Catch:{ all -> 0x0324 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)     // Catch:{ all -> 0x0324 }
            if (r0 == 0) goto L_0x01d6
            r11 = r4
        L_0x01d6:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r1, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)     // Catch:{ all -> 0x0324 }
            r10.a((java.lang.String) r3, (android.content.Context) r5, (java.lang.String) r11, (java.lang.Object) r0)     // Catch:{ all -> 0x0324 }
        L_0x01df:
            boolean r10 = r10.A     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x0258
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63849d     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x020b
            boolean r10 = r10.f61411d     // Catch:{ all -> 0x0324 }
            if (r10 != r2) goto L_0x020b
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0324 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.b r0 = new net.one97.paytm.recharge.mobile_v3.b.b     // Catch:{ all -> 0x0324 }
            r0.<init>()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.b$a r2 = net.one97.paytm.recharge.mobile_v3.b.b.f63768f     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = net.one97.paytm.recharge.mobile_v3.b.b.G     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r2)     // Catch:{ all -> 0x0324 }
            r10.c()     // Catch:{ all -> 0x0324 }
            goto L_0x0313
        L_0x020b:
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x0313
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r10 != 0) goto L_0x021a
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x021a:
            java.lang.Class<net.one97.paytm.recharge.mobile_v3.b.h> r11 = net.one97.paytm.recharge.mobile_v3.b.h.class
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0324 }
            android.os.Bundle r0 = r8.getArguments()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.Fragment r10 = androidx.fragment.app.Fragment.instantiate(r10, r11, r0)     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x0250
            net.one97.paytm.recharge.mobile_v3.b.h r10 = (net.one97.paytm.recharge.mobile_v3.b.h) r10     // Catch:{ all -> 0x0324 }
            r8.k = r10     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0324 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.h r0 = r8.k     // Catch:{ all -> 0x0324 }
            if (r0 != 0) goto L_0x023f
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x023f:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.h$a r2 = net.one97.paytm.recharge.mobile_v3.b.h.C     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = net.one97.paytm.recharge.mobile_v3.b.h.aa     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r2)     // Catch:{ all -> 0x0324 }
            r10.c()     // Catch:{ all -> 0x0324 }
            goto L_0x0313
        L_0x0250:
            kotlin.u r10 = new kotlin.u     // Catch:{ all -> 0x0324 }
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.recharge.mobile_v3.fragment.FJRMobileLandingFragmentV3"
            r10.<init>(r11)     // Catch:{ all -> 0x0324 }
            throw r10     // Catch:{ all -> 0x0324 }
        L_0x0258:
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x0313
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0324 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0324 }
            android.content.Context r0 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r0 != 0) goto L_0x0271
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x0271:
            java.lang.Class<net.one97.paytm.recharge.mobile_v3.b.f> r2 = net.one97.paytm.recharge.mobile_v3.b.f.class
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0324 }
            android.os.Bundle r3 = r8.getArguments()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.instantiate(r0, r2, r3)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.f$a r2 = net.one97.paytm.recharge.mobile_v3.b.f.f63845f     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = net.one97.paytm.recharge.mobile_v3.b.f.E     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r2)     // Catch:{ all -> 0x0324 }
            r10.c()     // Catch:{ all -> 0x0324 }
            goto L_0x0313
        L_0x028e:
            net.one97.paytm.recharge.common.utils.y r10 = net.one97.paytm.recharge.common.utils.y.f61814b     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile.d.a r10 = net.one97.paytm.recharge.common.utils.y.j()     // Catch:{ all -> 0x0324 }
            r8.f63849d = r10     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63849d     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x030a
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63849d     // Catch:{ all -> 0x0324 }
            if (r10 != 0) goto L_0x02a1
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x02a1:
            net.one97.paytm.recharge.mobile_v3.b.g$d r11 = new net.one97.paytm.recharge.mobile_v3.b.g$d     // Catch:{ all -> 0x0324 }
            r0 = r8
            net.one97.paytm.recharge.mobile_v3.b.g r0 = (net.one97.paytm.recharge.mobile_v3.b.g) r0     // Catch:{ all -> 0x0324 }
            r11.<init>(r0)     // Catch:{ all -> 0x0324 }
            r10.a((kotlin.k.e<kotlin.x>) r11)     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63849d     // Catch:{ all -> 0x0324 }
            if (r10 != 0) goto L_0x02b3
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x02b3:
            net.one97.paytm.recharge.common.utils.w r10 = r10.t     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x02c1
            net.one97.paytm.recharge.mobile_v3.b.g$e r11 = new net.one97.paytm.recharge.mobile_v3.b.g$e     // Catch:{ all -> 0x0324 }
            r0 = r8
            net.one97.paytm.recharge.mobile_v3.b.g r0 = (net.one97.paytm.recharge.mobile_v3.b.g) r0     // Catch:{ all -> 0x0324 }
            r11.<init>(r0)     // Catch:{ all -> 0x0324 }
            r10.f61788h = r11     // Catch:{ all -> 0x0324 }
        L_0x02c1:
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63849d     // Catch:{ all -> 0x0324 }
            if (r10 != 0) goto L_0x02c8
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x02c8:
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r10 = r10.f61408a     // Catch:{ all -> 0x0324 }
            androidx.lifecycle.LiveData r10 = (androidx.lifecycle.LiveData) r10     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.mobile_v3.b.g$f r11 = new net.one97.paytm.recharge.mobile_v3.b.g$f     // Catch:{ all -> 0x0324 }
            r0 = r8
            net.one97.paytm.recharge.mobile_v3.b.g r0 = (net.one97.paytm.recharge.mobile_v3.b.g) r0     // Catch:{ all -> 0x0324 }
            r11.<init>(r0)     // Catch:{ all -> 0x0324 }
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11     // Catch:{ all -> 0x0324 }
            net.one97.paytm.recharge.common.utils.ai.a(r8, r10, r11)     // Catch:{ all -> 0x0324 }
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x0313
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0324 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0324 }
            android.content.Context r0 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r0 != 0) goto L_0x02f2
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x02f2:
            java.lang.String r2 = r8.f63854i     // Catch:{ all -> 0x0324 }
            if (r2 != 0) goto L_0x02f8
            java.lang.String r2 = ""
        L_0x02f8:
            android.os.Bundle r3 = r8.getArguments()     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.instantiate(r0, r2, r3)     // Catch:{ all -> 0x0324 }
            java.lang.String r2 = r8.f63854i     // Catch:{ all -> 0x0324 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r2)     // Catch:{ all -> 0x0324 }
            r10.c()     // Catch:{ all -> 0x0324 }
            goto L_0x0313
        L_0x030a:
            androidx.fragment.app.FragmentActivity r10 = r8.getActivity()     // Catch:{ all -> 0x0324 }
            if (r10 == 0) goto L_0x0313
            r10.finish()     // Catch:{ all -> 0x0324 }
        L_0x0313:
            net.one97.paytm.recharge.common.utils.aa r10 = new net.one97.paytm.recharge.common.utils.aa     // Catch:{ all -> 0x0324 }
            android.content.Context r11 = r8.getContext()     // Catch:{ all -> 0x0324 }
            if (r11 != 0) goto L_0x031e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0324 }
        L_0x031e:
            r10.<init>(r11, r1)     // Catch:{ all -> 0x0324 }
            r8.f63850e = r10     // Catch:{ all -> 0x0324 }
            goto L_0x032a
        L_0x0324:
            r10 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r11 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r11.debugLogExceptions(r10)
        L_0x032a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.g.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final aa b() {
        return this.f63850e;
    }

    public final net.one97.paytm.recharge.common.e.d a() {
        return this.f63849d;
    }

    public final Fragment c() {
        return getChildFragmentManager().c(R.id.container_frame);
    }

    public final boolean d() {
        if (TextUtils.isEmpty(this.f63854i) || this.j) {
            this.j = false;
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                new t(activity).a();
            }
            if (!(getActivity() == null || getHost() == null)) {
                androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                if (!childFragmentManager.h()) {
                    Fragment c2 = getChildFragmentManager().c(R.id.container_frame);
                    if ((c2 instanceof ac) && ((ac) c2).ax_()) {
                        return false;
                    }
                    androidx.fragment.app.j childFragmentManager2 = getChildFragmentManager();
                    kotlin.g.b.k.a((Object) childFragmentManager2, "childFragmentManager");
                    boolean i2 = childFragmentManager2.i();
                    if (i2 && Build.VERSION.SDK_INT <= 25) {
                        return false;
                    }
                    if (i2 || !getChildFragmentManager().e()) {
                        return true;
                    }
                    h hVar = this.k;
                    if (hVar != null) {
                        if (hVar == null) {
                            kotlin.g.b.k.a();
                        }
                        hVar.L();
                    }
                    return false;
                }
            }
            return false;
        }
        this.j = true;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
        return false;
    }

    public final void a(CJRInstruct cJRInstruct) {
        if (getActivity() != null && getHost() != null && !isDetached() && isAdded()) {
            for (p a2 : this.f63852g) {
                a2.a(cJRInstruct);
            }
        }
    }

    public final void a(p pVar) {
        kotlin.g.b.k.c(pVar, "listener");
        if (!this.f63852g.contains(pVar)) {
            this.f63852g.add(pVar);
        }
    }

    public final void b(p pVar) {
        kotlin.g.b.k.c(pVar, "listener");
        this.f63852g.remove(pVar);
    }

    public final void e() {
        this.f63852g.clear();
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        if (getContext() != null && getActivity() != null && isAdded()) {
            if (networkCustomError instanceof an) {
                i();
                if ((((an) networkCustomError).getError() instanceof as) && !com.paytm.utility.b.c(getContext())) {
                    x.e eVar = new x.e();
                    T t = null;
                    eVar.element = null;
                    try {
                        T c2 = getChildFragmentManager().c(net.one97.paytm.recharge.metro.c.p.f63425a);
                        if (!(c2 instanceof net.one97.paytm.recharge.metro.c.p)) {
                            c2 = null;
                        }
                        eVar.element = (net.one97.paytm.recharge.metro.c.p) c2;
                    } catch (Throwable unused) {
                    }
                    if (((net.one97.paytm.recharge.metro.c.p) eVar.element) != null || getActivity() == null || getHost() == null || isDetached() || !isAdded()) {
                        net.one97.paytm.recharge.metro.c.p pVar = (net.one97.paytm.recharge.metro.c.p) eVar.element;
                        if (pVar != null) {
                            pVar.b();
                        }
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt(AppManagerUtil.EXTEND_TYPE, net.one97.paytm.recharge.metro.c.p.f63428d);
                        Context context = getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        T instantiate = Fragment.instantiate(context, net.one97.paytm.recharge.metro.c.p.class.getName(), bundle);
                        if (instantiate instanceof net.one97.paytm.recharge.metro.c.p) {
                            t = instantiate;
                        }
                        eVar.element = (net.one97.paytm.recharge.metro.c.p) t;
                        net.one97.paytm.recharge.metro.c.p pVar2 = (net.one97.paytm.recharge.metro.c.p) eVar.element;
                        if (pVar2 == null) {
                            kotlin.g.b.k.a();
                        }
                        pVar2.a(new a(this, eVar));
                        androidx.fragment.app.q a2 = getChildFragmentManager().a();
                        int i2 = R.id.no_network_container;
                        net.one97.paytm.recharge.metro.c.p pVar3 = (net.one97.paytm.recharge.metro.c.p) eVar.element;
                        if (pVar3 == null) {
                            kotlin.g.b.k.a();
                        }
                        a2.a(i2, pVar3, net.one97.paytm.recharge.metro.c.p.f63425a).c();
                        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !this.f63853h) {
                            FragmentActivity activity = getActivity();
                            if (activity != null) {
                                ((net.one97.paytm.recharge.common.e.y) activity).b("");
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                            }
                        }
                    }
                }
            }
            for (n a3 : this.f63851f) {
                a3.a(str, networkCustomError, obj);
            }
        }
    }

    public final void a(n nVar) {
        kotlin.g.b.k.c(nVar, "listener");
        if (!this.f63851f.contains(nVar)) {
            this.f63851f.add(nVar);
        }
    }

    public final void b(n nVar) {
        kotlin.g.b.k.c(nVar, "listener");
        this.f63851f.remove(nVar);
    }

    public final void f() {
        this.f63851f.clear();
    }

    public final void a(Map<String, ? extends View> map) {
        int i2;
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(this.f63849d);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        Intent intent = null;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.OPEN_ENTER_NUMBER_SCREEN);
        Intent intent2 = new Intent(getActivity(), AJRMobileRechargeActivityV3.class);
        FragmentActivity activity = getActivity();
        if ((activity != null ? activity.getIntent() : null) != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                intent = activity2.getIntent();
            }
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            intent2.putExtras(intent);
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63849d;
        if (aVar == null || !aVar.f61411d) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putString("recharge.component.name", c.class.getName());
            }
            i2 = 4566;
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                arguments2.putString("recharge.component.name", a.class.getName());
            }
            i2 = 4565;
        }
        intent2.putExtra("arguments", getArguments());
        intent2.setFlags(603979776);
        startActivityForResult(intent2, i2);
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " started enter mobile number screen");
    }

    public final void b(Map<String, ? extends View> map) {
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(this.f63849d);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        Intent intent = null;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.OPEN_RECHARGE_AMOUNT_SCREEN);
        Intent intent2 = new Intent(getActivity(), AJRMobileRechargeActivityV3.class);
        FragmentActivity activity = getActivity();
        if ((activity != null ? activity.getIntent() : null) != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                intent = activity2.getIntent();
            }
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            intent2.putExtras(intent);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString("recharge.component.name", d.class.getName());
        }
        intent2.putExtra("arguments", getArguments());
        intent2.setFlags(603979776);
        startActivityForResult(intent2, 4567);
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " started amount screen");
    }

    public final void a(Map<String, ? extends View> map, Bundle bundle) {
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(this.f63849d);
        Intent intent = new Intent(getActivity(), AJRMobileRechargeActivityV3.class);
        FragmentActivity activity = getActivity();
        Intent intent2 = null;
        if ((activity != null ? activity.getIntent() : null) != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                intent2 = activity2.getIntent();
            }
            if (intent2 == null) {
                kotlin.g.b.k.a();
            }
            intent.putExtras(intent2);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString("recharge.component.name", net.one97.paytm.recharge.common.fragment.h.class.getName());
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arguments2.putAll(bundle);
        }
        intent.putExtra("arguments", getArguments());
        startActivityForResult(intent, 4569);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " started browse plan screen");
    }

    public final void a(Map<String, ? extends View> map, h.c cVar, boolean z) {
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(this.f63849d);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        Intent intent = null;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.OPEN_SEARCH_CONTACT_SCREEN);
        Intent intent2 = new Intent(getActivity(), AJRMobileRechargeActivityV3.class);
        FragmentActivity activity = getActivity();
        if ((activity != null ? activity.getIntent() : null) != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                intent = activity2.getIntent();
            }
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            intent2.putExtras(intent);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString("recharge.component.name", j.class.getName());
        }
        intent2.putExtra("arguments", getArguments());
        startActivityForResult(intent2, 4568);
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(AJRMobileRechargeActivityV3.class.getSimpleName() + " started contact search screen");
    }

    public final androidx.fragment.app.j g() {
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    public final net.one97.paytm.recharge.mobile.d.a h() {
        return this.f63849d;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        w wVar;
        if (i2 == 4567 || i2 == 4566 || i2 == 4565) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63849d;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            g gVar = this;
            aVar.a((kotlin.k.e<kotlin.x>) new C1250g(gVar));
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63849d;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            w wVar2 = aVar2.t;
            if (wVar2 != null) {
                wVar2.f61788h = new h(gVar);
            }
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63849d;
            if (aVar3 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.common.utils.ai.a(this, aVar3.f61408a, new i(gVar));
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            Fragment c2 = getChildFragmentManager().c(R.id.container_frame);
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) c2, "childFragmentManager.fin…d(R.id.container_frame)!!");
            childFragmentManager.a(c2.getTag());
        } else if (i2 == 4568 || i2 == 4569) {
            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63849d;
            if (aVar4 != null) {
                aVar4.a((kotlin.k.e<kotlin.x>) new j(this));
            }
            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63849d;
            if (!(aVar5 == null || (wVar = aVar5.t) == null)) {
                wVar.f61788h = new k(this);
            }
            net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63849d;
            if (aVar6 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.common.utils.ai.a(this, aVar6.f61408a, new l(this));
            Fragment c3 = c();
            if (c3 != null) {
                c3.onActivityResult(i2, i3, intent);
            }
        } else {
            super.onActivityResult(i2, i3, intent);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f63855a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f63856b;

        a(g gVar, x.e eVar) {
            this.f63855a = gVar;
            this.f63856b = eVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.metro.c.p pVar = (net.one97.paytm.recharge.metro.c.p) this.f63856b.element;
            if (pVar == null) {
                kotlin.g.b.k.a();
            }
            pVar.a();
            net.one97.paytm.recharge.mobile.d.a a2 = this.f63855a.f63849d;
            if (a2 != null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a3.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a3.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                a2.a(a3);
                CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) a2.y.getValue();
                if (cJRRelatedCategory == null) {
                    String categoryId = a2.r.getCategoryId();
                    g gVar = this.f63855a;
                    a2.a("offline.retry.get.category", categoryId, (ai) gVar, (net.one97.paytm.recharge.common.b.a.a) gVar, (Object) a3);
                } else if (net.one97.paytm.recharge.common.utils.g.c(cJRRelatedCategory.getUrl())) {
                    String url = cJRRelatedCategory.getUrl();
                    if (url == null) {
                        kotlin.g.b.k.a();
                    }
                    g gVar2 = this.f63855a;
                    a2.a("offline.retry.get.category", url, (Object) a3, (ai) gVar2, (net.one97.paytm.recharge.common.b.a.a) gVar2);
                } else {
                    FragmentActivity activity = this.f63855a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
        }
    }

    private void i() {
        try {
            Fragment c2 = getChildFragmentManager().c(net.one97.paytm.recharge.metro.c.p.f63425a);
            if (c2 != null && c2.isAdded()) {
                ((net.one97.paytm.recharge.metro.c.p) c2).b();
                if (com.paytm.utility.b.c(getContext())) {
                    getChildFragmentManager().a().a(c2).d();
                    if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !this.f63853h) {
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            ((net.one97.paytm.recharge.common.e.y) activity).i();
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        if (str != null && str.hashCode() == 2122454023 && str.equals("offline.retry.get.category")) {
            i();
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63849d;
            if (aVar != null) {
                aVar.a_(str, iJRPaytmDataModel, obj);
            }
        }
    }

    public final void a(String str, boolean z, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
        if (str.hashCode() == 2122454023 && str.equals("offline.retry.get.category")) {
            i();
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63849d;
            if (aVar != null) {
                aVar.a(str, z, iJRPaytmDataModel, obj);
            }
        }
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
        if (str.hashCode() == 2122454023 && str.equals("offline.retry.get.category")) {
            i();
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63849d;
            if (aVar != null) {
                aVar.a(str, iJRPaytmDataModel, obj);
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        if (str != null && str.hashCode() == 2122454023 && str.equals("offline.retry.get.category")) {
            try {
                Fragment c2 = getChildFragmentManager().c(net.one97.paytm.recharge.metro.c.p.f63425a);
                if (c2 != null && c2.isAdded()) {
                    ((net.one97.paytm.recharge.metro.c.p) c2).b();
                }
            } catch (Throwable unused) {
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                cJRRechargeErrorModel.setErrorType(ERROR_TYPE.NO_CONNECTION);
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
