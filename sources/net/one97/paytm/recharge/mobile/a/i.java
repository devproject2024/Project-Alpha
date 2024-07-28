package net.one97.paytm.recharge.mobile.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.k;
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
import net.one97.paytm.recharge.common.fragment.i;
import net.one97.paytm.recharge.common.fragment.t;
import net.one97.paytm.recharge.common.utils.aa;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.mobile.a.a;
import net.one97.paytm.recharge.mobile.a.b;
import net.one97.paytm.recharge.mobile.a.e;
import net.one97.paytm.recharge.mobile.a.f;
import net.one97.paytm.recharge.mobile.activity.AJRMobileRechargeActivityV8;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class i extends net.one97.paytm.i.h implements net.one97.paytm.recharge.common.b.a.a, ah, ai, net.one97.paytm.recharge.mobile.d {

    /* renamed from: a  reason: collision with root package name */
    boolean f63651a;

    /* renamed from: b  reason: collision with root package name */
    private CJRItem f63652b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f63653c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.recharge.mobile.d.a f63654d;

    /* renamed from: e  reason: collision with root package name */
    private aa f63655e;

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<n> f63656f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashSet<p> f63657g = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f63658h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f63659i;
    private boolean j;
    private final int k = 4567;
    private j l;
    private final String m = "android:support:fragments";
    private boolean n;
    private HashMap o;

    static final /* synthetic */ class b extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        b(i iVar) {
            super(3, iVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((i) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class c extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        c(i iVar) {
            super(1, iVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((i) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class d extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        d(i iVar) {
            super(3, iVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((i) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class e extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        e(i iVar) {
            super(3, iVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((i) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class f extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        f(i iVar) {
            super(1, iVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((i) this.receiver).a(cJRInstruct);
        }
    }

    static final /* synthetic */ class g extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        g(i iVar) {
            super(3, iVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((i) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class h extends kotlin.g.b.i implements q<String, NetworkCustomError, Object, x> {
        h(i iVar) {
            super(3, iVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((i) this.receiver).a(str, networkCustomError, obj);
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.i$i  reason: collision with other inner class name */
    static final /* synthetic */ class C1238i extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        C1238i(i iVar) {
            super(1, iVar);
        }

        public final String getName() {
            return "performInstruction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(i.class);
        }

        public final String getSignature() {
            return "performInstruction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            ((i) this.receiver).a(cJRInstruct);
        }
    }

    public final void a(boolean z) {
        if (z) {
            Fragment c2 = getChildFragmentManager().c(R.id.container_frame);
            if (c2 instanceof j) {
                ((j) c2).L();
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
            if (aVar != null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aVar.b(net.one97.paytm.recharge.widgets.c.d.b());
            }
        }
        this.f63651a = z;
    }

    public final void onCreate(Bundle bundle) {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            Serializable serializable = arguments.getSerializable("recharge_item");
            if (serializable != null) {
                this.f63652b = (CJRItem) serializable;
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    k.a();
                }
                this.f63653c = arguments2.getBoolean("open_activity_in_automatic_mode");
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    k.a();
                }
                this.f63658h = arguments3.getBoolean("is_recharge_tabs_flow", false);
                Bundle arguments4 = getArguments();
                if (arguments4 == null) {
                    k.a();
                }
                this.f63659i = arguments4.getBoolean("startAmountScreen", false);
                Bundle arguments5 = getArguments();
                if (arguments5 == null) {
                    k.a();
                }
                this.n = arguments5.getBoolean("isInitialFragment", false);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
            }
        }
        if (this.f63659i && bundle != null && bundle.containsKey(this.m)) {
            bundle.remove(this.m);
        }
        super.onCreate(bundle);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0102, code lost:
        if (r6.equals("datacard_postpaid") != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0104, code lost:
        r3 = 23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010f, code lost:
        if (r6.equals("datacard-prepaid") != false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0111, code lost:
        r3 = 19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011e, code lost:
        if (r3.intValue() != 23) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0156, code lost:
        if (androidx.core.content.b.a((android.content.Context) r3, "android.permission.READ_CONTACTS") == 0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ad, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "21", (java.lang.Object) r10.r.getCategoryId()) != false) goto L_0x01af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x024c A[Catch:{ all -> 0x0343 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0145 A[Catch:{ all -> 0x0343 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0178 A[Catch:{ all -> 0x0343 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0195 A[Catch:{ all -> 0x0343 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d7 A[Catch:{ all -> 0x0343 }] */
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
            net.one97.paytm.common.entity.CJRItem r10 = r8.f63652b     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0349
            boolean r10 = r8.f63659i     // Catch:{ all -> 0x0343 }
            r1 = 1
            r2 = 0
            if (r10 != 0) goto L_0x0282
            net.one97.paytm.recharge.common.h.d r10 = new net.one97.paytm.recharge.common.h.d     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.h.d$a r3 = new net.one97.paytm.recharge.common.h.d$a     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.h.d$b r4 = net.one97.paytm.recharge.common.h.d.b.MOBILE     // Catch:{ all -> 0x0343 }
            r3.<init>(r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.common.entity.CJRItem r4 = r8.f63652b     // Catch:{ all -> 0x0343 }
            if (r4 != 0) goto L_0x002f
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x002f:
            net.one97.paytm.recharge.common.h.d$a r3 = r3.a((net.one97.paytm.common.entity.CJRItem) r4)     // Catch:{ all -> 0x0343 }
            android.content.Context r4 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r4 != 0) goto L_0x003c
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x003c:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.b r4 = net.one97.paytm.recharge.common.b.d.c(r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.b.c r4 = (net.one97.paytm.recharge.common.b.c) r4     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.h.d$a r3 = r3.a((net.one97.paytm.recharge.common.b.c) r4)     // Catch:{ all -> 0x0343 }
            android.content.Context r4 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r4 != 0) goto L_0x0052
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x0052:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.utils.w r4 = net.one97.paytm.recharge.common.b.d.d(r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.h.d$a r3 = r3.a((net.one97.paytm.recharge.common.utils.w) r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.i$b r4 = new net.one97.paytm.recharge.mobile.a.i$b     // Catch:{ all -> 0x0343 }
            r5 = r8
            net.one97.paytm.recharge.mobile.a.i r5 = (net.one97.paytm.recharge.mobile.a.i) r5     // Catch:{ all -> 0x0343 }
            r4.<init>(r5)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.h.d$a r3 = r3.a((kotlin.k.e<kotlin.x>) r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.ordersummary.h.d r4 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ all -> 0x0343 }
            android.content.Context r5 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r5 != 0) goto L_0x0074
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x0074:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ all -> 0x0343 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x0343 }
            java.lang.String r6 = "context!!.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0343 }
            r4.<init>(r5)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.common.entity.CJRItem r5 = r8.f63652b     // Catch:{ all -> 0x0343 }
            r4.f64343a = r5     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.h.d$a r3 = r3.a((net.one97.paytm.recharge.ordersummary.h.d) r4)     // Catch:{ all -> 0x0343 }
            r10.<init>(r3)     // Catch:{ all -> 0x0343 }
            androidx.lifecycle.al$b r10 = (androidx.lifecycle.al.b) r10     // Catch:{ all -> 0x0343 }
            androidx.lifecycle.al r10 = androidx.lifecycle.am.a((androidx.fragment.app.Fragment) r8, (androidx.lifecycle.al.b) r10)     // Catch:{ all -> 0x0343 }
            java.lang.Class<net.one97.paytm.recharge.mobile.d.a> r3 = net.one97.paytm.recharge.mobile.d.a.class
            androidx.lifecycle.ai r10 = r10.a(r3)     // Catch:{ all -> 0x0343 }
            java.lang.String r3 = "ViewModelProviders.of(th…elFactory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.d.a r10 = (net.one97.paytm.recharge.mobile.d.a) r10     // Catch:{ all -> 0x0343 }
            r8.f63654d = r10     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r3 = r10.f61408a     // Catch:{ all -> 0x0343 }
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.i$c r4 = new net.one97.paytm.recharge.mobile.a.i$c     // Catch:{ all -> 0x0343 }
            r5 = r8
            net.one97.paytm.recharge.mobile.a.i r5 = (net.one97.paytm.recharge.mobile.a.i) r5     // Catch:{ all -> 0x0343 }
            r4.<init>(r5)     // Catch:{ all -> 0x0343 }
            kotlin.g.a.b r4 = (kotlin.g.a.b) r4     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.utils.ai.a(r8, r3, r4)     // Catch:{ all -> 0x0343 }
            boolean r3 = r8.f63653c     // Catch:{ all -> 0x0343 }
            r10.f61411d = r3     // Catch:{ all -> 0x0343 }
            net.one97.paytm.common.entity.CJRItem r3 = r10.r     // Catch:{ all -> 0x0343 }
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ all -> 0x0343 }
            if (r3 == 0) goto L_0x00c9
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x0343 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0343 }
            goto L_0x00ca
        L_0x00c9:
            r3 = r2
        L_0x00ca:
            r4 = 19
            r5 = 23
            if (r3 == 0) goto L_0x0115
            net.one97.paytm.common.entity.CJRItem r6 = r10.r     // Catch:{ all -> 0x0343 }
            java.lang.String r6 = r6.getURLType()     // Catch:{ all -> 0x0343 }
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0343 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0343 }
            if (r7 != 0) goto L_0x0115
            if (r6 != 0) goto L_0x00e2
            goto L_0x0115
        L_0x00e2:
            int r7 = r6.hashCode()     // Catch:{ all -> 0x0343 }
            switch(r7) {
                case 682105564: goto L_0x0109;
                case 1529423953: goto L_0x00fc;
                case 1707833887: goto L_0x00f3;
                case 1923276394: goto L_0x00ea;
                default: goto L_0x00e9;
            }     // Catch:{ all -> 0x0343 }
        L_0x00e9:
            goto L_0x0115
        L_0x00ea:
            java.lang.String r7 = "datacard_prepaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0343 }
            if (r6 == 0) goto L_0x0115
            goto L_0x0111
        L_0x00f3:
            java.lang.String r7 = "datacard-postpaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0343 }
            if (r6 == 0) goto L_0x0115
            goto L_0x0104
        L_0x00fc:
            java.lang.String r7 = "datacard_postpaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0343 }
            if (r6 == 0) goto L_0x0115
        L_0x0104:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0343 }
            goto L_0x0115
        L_0x0109:
            java.lang.String r7 = "datacard-prepaid"
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0343 }
            if (r6 == 0) goto L_0x0115
        L_0x0111:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0343 }
        L_0x0115:
            java.lang.String r6 = "frequent_api"
            if (r3 != 0) goto L_0x011a
            goto L_0x0120
        L_0x011a:
            int r7 = r3.intValue()     // Catch:{ all -> 0x0343 }
            if (r7 == r5) goto L_0x0136
        L_0x0120:
            if (r3 != 0) goto L_0x0123
            goto L_0x012a
        L_0x0123:
            int r3 = r3.intValue()     // Catch:{ all -> 0x0343 }
            if (r3 != r4) goto L_0x012a
            goto L_0x0136
        L_0x012a:
            java.lang.String r3 = "Mobile"
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)     // Catch:{ all -> 0x0343 }
            r10.b(r6, r3, r4)     // Catch:{ all -> 0x0343 }
            goto L_0x0141
        L_0x0136:
            java.lang.String r3 = "datacard"
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)     // Catch:{ all -> 0x0343 }
            r10.b(r6, r3, r4)     // Catch:{ all -> 0x0343 }
        L_0x0141:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0343 }
            if (r3 < r5) goto L_0x0158
            androidx.fragment.app.FragmentActivity r3 = r8.getActivity()     // Catch:{ all -> 0x0343 }
            if (r3 != 0) goto L_0x014e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x014e:
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ all -> 0x0343 }
            java.lang.String r4 = "android.permission.READ_CONTACTS"
            int r3 = androidx.core.content.b.a((android.content.Context) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0343 }
            if (r3 != 0) goto L_0x0167
        L_0x0158:
            r3 = r8
            androidx.lifecycle.q r3 = (androidx.lifecycle.q) r3     // Catch:{ all -> 0x0343 }
            androidx.loader.a.a r3 = androidx.loader.a.a.a(r3)     // Catch:{ all -> 0x0343 }
            java.lang.String r4 = "LoaderManager.getInstanc…FJRMobileLandingFragment)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.d.a.a((androidx.loader.a.a) r3)     // Catch:{ all -> 0x0343 }
        L_0x0167:
            net.one97.paytm.recharge.widgets.c.d r3 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0343 }
            r3.setErrorType(r4)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r3.getFlowName()     // Catch:{ all -> 0x0343 }
            if (r4 == 0) goto L_0x0181
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ all -> 0x0343 }
            java.lang.String r5 = r5.name()     // Catch:{ all -> 0x0343 }
            r4.setErrorType(r5)     // Catch:{ all -> 0x0343 }
        L_0x0181:
            r10.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3)     // Catch:{ all -> 0x0343 }
            java.lang.String r4 = "getCategory"
            net.one97.paytm.common.entity.CJRItem r5 = r10.r     // Catch:{ all -> 0x0343 }
            java.lang.String r5 = r5.getCategoryId()     // Catch:{ all -> 0x0343 }
            r10.a((java.lang.String) r4, (java.lang.String) r5, (net.one97.paytm.recharge.common.e.ai) r10, (net.one97.paytm.recharge.common.b.a.a) r10, (java.lang.Object) r3)     // Catch:{ all -> 0x0343 }
            android.content.Context r3 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r3 == 0) goto L_0x01d3
            net.one97.paytm.common.entity.CJRItem r3 = r10.r     // Catch:{ all -> 0x0343 }
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ all -> 0x0343 }
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r3)     // Catch:{ all -> 0x0343 }
            java.lang.String r4 = "21"
            if (r3 != 0) goto L_0x01af
            net.one97.paytm.common.entity.CJRItem r3 = r10.r     // Catch:{ all -> 0x0343 }
            java.lang.String r3 = r3.getCategoryId()     // Catch:{ all -> 0x0343 }
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ all -> 0x0343 }
            if (r3 == 0) goto L_0x01d3
        L_0x01af:
            java.lang.String r3 = "get.rc.category.in.background"
            android.content.Context r5 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r5 != 0) goto L_0x01ba
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x01ba:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.common.entity.CJRItem r0 = r10.r     // Catch:{ all -> 0x0343 }
            java.lang.String r0 = r0.getCategoryId()     // Catch:{ all -> 0x0343 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)     // Catch:{ all -> 0x0343 }
            if (r0 == 0) goto L_0x01ca
            r11 = r4
        L_0x01ca:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)     // Catch:{ all -> 0x0343 }
            r10.a((java.lang.String) r3, (android.content.Context) r5, (java.lang.String) r11, (java.lang.Object) r0)     // Catch:{ all -> 0x0343 }
        L_0x01d3:
            boolean r10 = r10.A     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x024c
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63654d     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x01ff
            boolean r10 = r10.f61411d     // Catch:{ all -> 0x0343 }
            if (r10 != r1) goto L_0x01ff
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0343 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.c r0 = new net.one97.paytm.recharge.mobile.a.c     // Catch:{ all -> 0x0343 }
            r0.<init>()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.c$a r1 = net.one97.paytm.recharge.mobile.a.c.f63593f     // Catch:{ all -> 0x0343 }
            java.lang.String r1 = net.one97.paytm.recharge.mobile.a.c.G     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r1)     // Catch:{ all -> 0x0343 }
            r10.c()     // Catch:{ all -> 0x0343 }
            goto L_0x0332
        L_0x01ff:
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0332
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r10 != 0) goto L_0x020e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x020e:
            java.lang.Class<net.one97.paytm.recharge.mobile.a.j> r11 = net.one97.paytm.recharge.mobile.a.j.class
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x0343 }
            android.os.Bundle r0 = r8.getArguments()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.Fragment r10 = androidx.fragment.app.Fragment.instantiate(r10, r11, r0)     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0244
            net.one97.paytm.recharge.mobile.a.j r10 = (net.one97.paytm.recharge.mobile.a.j) r10     // Catch:{ all -> 0x0343 }
            r8.l = r10     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0343 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.j r0 = r8.l     // Catch:{ all -> 0x0343 }
            if (r0 != 0) goto L_0x0233
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x0233:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.j$a r1 = net.one97.paytm.recharge.mobile.a.j.C     // Catch:{ all -> 0x0343 }
            java.lang.String r1 = net.one97.paytm.recharge.mobile.a.j.T     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r1)     // Catch:{ all -> 0x0343 }
            r10.c()     // Catch:{ all -> 0x0343 }
            goto L_0x0332
        L_0x0244:
            kotlin.u r10 = new kotlin.u     // Catch:{ all -> 0x0343 }
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.recharge.mobile.fragment.FJRMobileLandingFragmentV8"
            r10.<init>(r11)     // Catch:{ all -> 0x0343 }
            throw r10     // Catch:{ all -> 0x0343 }
        L_0x024c:
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0332
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0343 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0343 }
            android.content.Context r0 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r0 != 0) goto L_0x0265
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x0265:
            java.lang.Class<net.one97.paytm.recharge.mobile.a.h> r1 = net.one97.paytm.recharge.mobile.a.h.class
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0343 }
            android.os.Bundle r3 = r8.getArguments()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.instantiate(r0, r1, r3)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.h$a r1 = net.one97.paytm.recharge.mobile.a.h.f63650f     // Catch:{ all -> 0x0343 }
            java.lang.String r1 = net.one97.paytm.recharge.mobile.a.h.E     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r1)     // Catch:{ all -> 0x0343 }
            r10.c()     // Catch:{ all -> 0x0343 }
            goto L_0x0332
        L_0x0282:
            net.one97.paytm.recharge.common.utils.y r10 = net.one97.paytm.recharge.common.utils.y.f61814b     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.d.a r10 = net.one97.paytm.recharge.common.utils.y.j()     // Catch:{ all -> 0x0343 }
            r8.f63654d = r10     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63654d     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0329
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63654d     // Catch:{ all -> 0x0343 }
            if (r10 != 0) goto L_0x0295
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x0295:
            net.one97.paytm.recharge.mobile.a.i$d r11 = new net.one97.paytm.recharge.mobile.a.i$d     // Catch:{ all -> 0x0343 }
            r0 = r8
            net.one97.paytm.recharge.mobile.a.i r0 = (net.one97.paytm.recharge.mobile.a.i) r0     // Catch:{ all -> 0x0343 }
            r11.<init>(r0)     // Catch:{ all -> 0x0343 }
            r10.a((kotlin.k.e<kotlin.x>) r11)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63654d     // Catch:{ all -> 0x0343 }
            if (r10 != 0) goto L_0x02a7
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x02a7:
            net.one97.paytm.recharge.common.utils.w r10 = r10.t     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x02b5
            net.one97.paytm.recharge.mobile.a.i$e r11 = new net.one97.paytm.recharge.mobile.a.i$e     // Catch:{ all -> 0x0343 }
            r0 = r8
            net.one97.paytm.recharge.mobile.a.i r0 = (net.one97.paytm.recharge.mobile.a.i) r0     // Catch:{ all -> 0x0343 }
            r11.<init>(r0)     // Catch:{ all -> 0x0343 }
            r10.f61788h = r11     // Catch:{ all -> 0x0343 }
        L_0x02b5:
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63654d     // Catch:{ all -> 0x0343 }
            if (r10 != 0) goto L_0x02bc
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x02bc:
            net.one97.paytm.recharge.common.utils.be<net.one97.paytm.recharge.model.v4.CJRInstruct> r10 = r10.f61408a     // Catch:{ all -> 0x0343 }
            androidx.lifecycle.LiveData r10 = (androidx.lifecycle.LiveData) r10     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.i$f r11 = new net.one97.paytm.recharge.mobile.a.i$f     // Catch:{ all -> 0x0343 }
            r0 = r8
            net.one97.paytm.recharge.mobile.a.i r0 = (net.one97.paytm.recharge.mobile.a.i) r0     // Catch:{ all -> 0x0343 }
            r11.<init>(r0)     // Catch:{ all -> 0x0343 }
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.common.utils.ai.a(r8, r10, r11)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.d.a r10 = r8.f63654d     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x02f4
            boolean r10 = r10.f61411d     // Catch:{ all -> 0x0343 }
            if (r10 != r1) goto L_0x02f4
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0343 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.b r0 = new net.one97.paytm.recharge.mobile.a.b     // Catch:{ all -> 0x0343 }
            r0.<init>()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.b$a r1 = net.one97.paytm.recharge.mobile.a.b.f63592f     // Catch:{ all -> 0x0343 }
            java.lang.String r1 = net.one97.paytm.recharge.mobile.a.b.B     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r1)     // Catch:{ all -> 0x0343 }
            r10.c()     // Catch:{ all -> 0x0343 }
            goto L_0x0332
        L_0x02f4:
            android.content.Context r10 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0332
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a()     // Catch:{ all -> 0x0343 }
            int r11 = net.one97.paytm.recharge.R.id.container_frame     // Catch:{ all -> 0x0343 }
            android.content.Context r0 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r0 != 0) goto L_0x030d
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x030d:
            java.lang.Class<net.one97.paytm.recharge.mobile.a.f> r1 = net.one97.paytm.recharge.mobile.a.f.class
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0343 }
            android.os.Bundle r3 = r8.getArguments()     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.instantiate(r0, r1, r3)     // Catch:{ all -> 0x0343 }
            net.one97.paytm.recharge.mobile.a.f$a r1 = net.one97.paytm.recharge.mobile.a.f.y     // Catch:{ all -> 0x0343 }
            java.lang.String r1 = net.one97.paytm.recharge.mobile.a.f.ag     // Catch:{ all -> 0x0343 }
            androidx.fragment.app.q r10 = r10.a(r11, r0, r1)     // Catch:{ all -> 0x0343 }
            r10.c()     // Catch:{ all -> 0x0343 }
            goto L_0x0332
        L_0x0329:
            androidx.fragment.app.FragmentActivity r10 = r8.getActivity()     // Catch:{ all -> 0x0343 }
            if (r10 == 0) goto L_0x0332
            r10.finish()     // Catch:{ all -> 0x0343 }
        L_0x0332:
            net.one97.paytm.recharge.common.utils.aa r10 = new net.one97.paytm.recharge.common.utils.aa     // Catch:{ all -> 0x0343 }
            android.content.Context r11 = r8.getContext()     // Catch:{ all -> 0x0343 }
            if (r11 != 0) goto L_0x033d
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0343 }
        L_0x033d:
            r10.<init>(r11, r2)     // Catch:{ all -> 0x0343 }
            r8.f63655e = r10     // Catch:{ all -> 0x0343 }
            goto L_0x0349
        L_0x0343:
            r10 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r11 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r11.debugLogExceptions(r10)
        L_0x0349:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.i.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final aa b() {
        return this.f63655e;
    }

    public final net.one97.paytm.recharge.common.e.d a() {
        return this.f63654d;
    }

    public final Fragment c() {
        return getChildFragmentManager().c(R.id.container_frame);
    }

    public final boolean d() {
        Fragment c2;
        if (!this.f63659i || this.j) {
            this.j = false;
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                new t(activity).a();
            }
            if (!(getActivity() == null || getHost() == null)) {
                j childFragmentManager = getChildFragmentManager();
                k.a((Object) childFragmentManager, "childFragmentManager");
                if (!childFragmentManager.h()) {
                    Fragment c3 = getChildFragmentManager().c(R.id.container_frame);
                    if ((c3 instanceof ac) && ((ac) c3).ax_()) {
                        return false;
                    }
                    if (c3 instanceof net.one97.paytm.recharge.common.fragment.t) {
                        j childFragmentManager2 = getChildFragmentManager();
                        k.a((Object) childFragmentManager2, "childFragmentManager");
                        if (childFragmentManager2.f() >= 2) {
                            j childFragmentManager3 = getChildFragmentManager();
                            j childFragmentManager4 = getChildFragmentManager();
                            k.a((Object) childFragmentManager4, "childFragmentManager");
                            j.a b2 = childFragmentManager3.b(childFragmentManager4.f() - 2);
                            String g2 = b2 != null ? b2.g() : null;
                            if (!TextUtils.isEmpty(g2) && (c2 = getChildFragmentManager().c(g2)) != null) {
                                c2.onResume();
                            }
                        }
                    }
                    j childFragmentManager5 = getChildFragmentManager();
                    k.a((Object) childFragmentManager5, "childFragmentManager");
                    boolean i2 = childFragmentManager5.i();
                    if (i2 && Build.VERSION.SDK_INT <= 25) {
                        return false;
                    }
                    if (i2 || !getChildFragmentManager().e()) {
                        return true;
                    }
                    j jVar = this.l;
                    if (jVar != null) {
                        jVar.K();
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
            for (p a2 : this.f63657g) {
                a2.a(cJRInstruct);
            }
        }
    }

    public final void a(p pVar) {
        k.c(pVar, "listener");
        if (!this.f63657g.contains(pVar)) {
            this.f63657g.add(pVar);
        }
    }

    public final void b(p pVar) {
        k.c(pVar, "listener");
        this.f63657g.remove(pVar);
    }

    public final void e() {
        this.f63657g.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r3 = r3.getErrorType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, com.paytm.network.model.NetworkCustomError r4, java.lang.Object r5) {
        /*
            r2 = this;
            boolean r0 = r4 instanceof net.one97.paytm.recharge.common.utils.an
            if (r0 == 0) goto L_0x00ec
            r2.i()
            net.one97.paytm.recharge.common.utils.an r4 = (net.one97.paytm.recharge.common.utils.an) r4
            com.paytm.network.model.NetworkCustomError r3 = r4.getError()
            boolean r3 = r3 instanceof net.one97.paytm.recharge.common.utils.as
            r5 = 0
            if (r3 != 0) goto L_0x002d
            com.paytm.network.model.NetworkCustomError r3 = r4.getError()
            if (r3 == 0) goto L_0x0023
            com.paytm.network.model.NetworkCustomError$ErrorType r3 = r3.getErrorType()
            if (r3 == 0) goto L_0x0023
            java.lang.String r3 = r3.name()
            goto L_0x0024
        L_0x0023:
            r3 = r5
        L_0x0024:
            r4 = 1
            java.lang.String r0 = "TimeOutError"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r4)
            if (r3 == 0) goto L_0x0104
        L_0x002d:
            kotlin.g.b.x$e r3 = new kotlin.g.b.x$e
            r3.<init>()
            r3.element = r5
            androidx.fragment.app.j r4 = r2.getChildFragmentManager()     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = net.one97.paytm.recharge.metro.c.p.f63425a     // Catch:{ all -> 0x0048 }
            androidx.fragment.app.Fragment r4 = r4.c((java.lang.String) r0)     // Catch:{ all -> 0x0048 }
            boolean r0 = r4 instanceof net.one97.paytm.recharge.metro.c.p     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0043
            r4 = r5
        L_0x0043:
            net.one97.paytm.recharge.metro.c.p r4 = (net.one97.paytm.recharge.metro.c.p) r4     // Catch:{ all -> 0x0048 }
            r3.element = r4     // Catch:{ all -> 0x0048 }
            goto L_0x0049
        L_0x0048:
        L_0x0049:
            T r4 = r3.element
            net.one97.paytm.recharge.metro.c.p r4 = (net.one97.paytm.recharge.metro.c.p) r4
            if (r4 != 0) goto L_0x00e2
            androidx.fragment.app.FragmentActivity r4 = r2.getActivity()
            if (r4 == 0) goto L_0x00e2
            java.lang.Object r4 = r2.getHost()
            if (r4 == 0) goto L_0x00e2
            boolean r4 = r2.isDetached()
            if (r4 != 0) goto L_0x00e2
            boolean r4 = r2.isAdded()
            if (r4 == 0) goto L_0x00e2
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            int r0 = net.one97.paytm.recharge.metro.c.p.f63428d
            java.lang.String r1 = "Type"
            r4.putInt(r1, r0)
            android.content.Context r0 = r2.getContext()
            if (r0 != 0) goto L_0x007c
            kotlin.g.b.k.a()
        L_0x007c:
            java.lang.Class<net.one97.paytm.recharge.metro.c.p> r1 = net.one97.paytm.recharge.metro.c.p.class
            java.lang.String r1 = r1.getName()
            androidx.fragment.app.Fragment r4 = androidx.fragment.app.Fragment.instantiate(r0, r1, r4)
            boolean r0 = r4 instanceof net.one97.paytm.recharge.metro.c.p
            if (r0 != 0) goto L_0x008b
            r4 = r5
        L_0x008b:
            net.one97.paytm.recharge.metro.c.p r4 = (net.one97.paytm.recharge.metro.c.p) r4
            r3.element = r4
            T r4 = r3.element
            net.one97.paytm.recharge.metro.c.p r4 = (net.one97.paytm.recharge.metro.c.p) r4
            if (r4 != 0) goto L_0x0098
            kotlin.g.b.k.a()
        L_0x0098:
            net.one97.paytm.recharge.mobile.a.i$a r5 = new net.one97.paytm.recharge.mobile.a.i$a
            r5.<init>(r2, r3)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.a(r5)
            androidx.fragment.app.j r4 = r2.getChildFragmentManager()
            androidx.fragment.app.q r4 = r4.a()
            int r5 = net.one97.paytm.recharge.R.id.no_network_container
            T r3 = r3.element
            net.one97.paytm.recharge.metro.c.p r3 = (net.one97.paytm.recharge.metro.c.p) r3
            if (r3 != 0) goto L_0x00b5
            kotlin.g.b.k.a()
        L_0x00b5:
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            java.lang.String r0 = net.one97.paytm.recharge.metro.c.p.f63425a
            androidx.fragment.app.q r3 = r4.a(r5, r3, r0)
            r3.c()
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            boolean r3 = r3 instanceof net.one97.paytm.recharge.common.e.y
            if (r3 == 0) goto L_0x00eb
            boolean r3 = r2.f63658h
            if (r3 != 0) goto L_0x00eb
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x00da
            net.one97.paytm.recharge.common.e.y r3 = (net.one97.paytm.recharge.common.e.y) r3
            java.lang.String r4 = ""
            r3.b((java.lang.String) r4)
            return
        L_0x00da:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface"
            r3.<init>(r4)
            throw r3
        L_0x00e2:
            T r3 = r3.element
            net.one97.paytm.recharge.metro.c.p r3 = (net.one97.paytm.recharge.metro.c.p) r3
            if (r3 == 0) goto L_0x00eb
            r3.b()
        L_0x00eb:
            return
        L_0x00ec:
            java.util.HashSet<net.one97.paytm.recharge.common.e.n> r0 = r2.f63656f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00f4:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0104
            java.lang.Object r1 = r0.next()
            net.one97.paytm.recharge.common.e.n r1 = (net.one97.paytm.recharge.common.e.n) r1
            r1.a(r3, r4, r5)
            goto L_0x00f4
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.i.a(java.lang.String, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    public final void a(n nVar) {
        k.c(nVar, "listener");
        if (!this.f63656f.contains(nVar)) {
            this.f63656f.add(nVar);
        }
    }

    public final void b(n nVar) {
        k.c(nVar, "listener");
        this.f63656f.remove(nVar);
    }

    public final void f() {
        this.f63656f.clear();
    }

    public final void a(Map<String, ? extends View> map) {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
        if (aVar != null && aVar.f61411d) {
            a.C1233a aVar2 = a.f63586f;
            a2.a(R.id.container_frame, new a(), a.E);
            a.C1233a aVar3 = a.f63586f;
            k.a((Object) a2.a(a.E), "transition?.addToBackSta…bileNumberFragmentV8.TAG)");
        } else if (getContext() != null) {
            int i2 = R.id.container_frame;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            Fragment instantiate = Fragment.instantiate(context, e.class.getName(), getArguments());
            e.a aVar4 = e.A;
            a2.a(i2, instantiate, e.D);
            e.a aVar5 = e.A;
            a2.a(e.D);
        }
        for (Map.Entry next : map.entrySet()) {
            a2.a((View) next.getValue(), (String) next.getKey());
        }
        a2.c();
    }

    public final void b(Map<String, ? extends View> map) {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        a2.a(17498112, 17498113);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
        if (aVar != null && aVar.f61411d) {
            b.a aVar2 = b.f63592f;
            a2.a(R.id.container_frame, new b(), b.B);
            b.a aVar3 = b.f63592f;
            a2.a(b.B);
            for (Map.Entry next : map.entrySet()) {
                a2.a((View) next.getValue(), (String) next.getKey());
            }
            j childFragmentManager = getChildFragmentManager();
            Fragment c2 = getChildFragmentManager().c(R.id.container_frame);
            if (c2 == null) {
                k.a();
            }
            k.a((Object) c2, "childFragmentManager.fin…d(R.id.container_frame)!!");
            childFragmentManager.a(c2.getTag());
            a2.c();
        } else if (this.f63658h) {
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            net.one97.paytm.recharge.common.utils.y.a(this.f63654d);
            Intent intent = new Intent(getActivity(), AJRMobileRechargeActivityV8.class);
            FragmentActivity activity = getActivity();
            Intent intent2 = null;
            if ((activity != null ? activity.getIntent() : null) != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    intent2 = activity2.getIntent();
                }
                if (intent2 == null) {
                    k.a();
                }
                intent.putExtras(intent2);
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putBoolean("startAmountScreen", true);
            }
            intent.putExtra("arguments", getArguments());
            intent.setFlags(603979776);
            startActivityForResult(intent, this.k);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a(AJRMobileRechargeActivityV8.class.getSimpleName() + " started amount screen");
        } else if (getContext() != null) {
            int i2 = R.id.container_frame;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            Fragment instantiate = Fragment.instantiate(context, f.class.getName(), getArguments());
            f.a aVar4 = f.y;
            a2.a(i2, instantiate, f.ag);
            f.a aVar5 = f.y;
            a2.a(f.ag);
            for (Map.Entry next2 : map.entrySet()) {
                a2.a((View) next2.getValue(), (String) next2.getKey());
            }
            j childFragmentManager2 = getChildFragmentManager();
            Fragment c3 = getChildFragmentManager().c(R.id.container_frame);
            if (c3 == null) {
                k.a();
            }
            k.a((Object) c3, "childFragmentManager.fin…d(R.id.container_frame)!!");
            childFragmentManager2.a(c3.getTag());
            a2.c();
        }
    }

    public final void a(Map<String, ? extends View> map, Bundle bundle) {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        net.one97.paytm.recharge.common.fragment.i iVar = new net.one97.paytm.recharge.common.fragment.i();
        iVar.setArguments(bundle);
        a2.a(R.anim.v8_slideup_content, 0, 0, R.anim.v8_slide_down);
        i.a aVar = net.one97.paytm.recharge.common.fragment.i.f61240d;
        a2.a(R.id.container_frame, iVar, net.one97.paytm.recharge.common.fragment.i.n);
        for (Map.Entry next : map.entrySet()) {
            a2.a((View) next.getValue(), (String) next.getKey());
        }
        i.a aVar2 = net.one97.paytm.recharge.common.fragment.i.f61240d;
        a2.a(net.one97.paytm.recharge.common.fragment.i.n);
        a2.c();
    }

    public final void a(Map<String, ? extends View> map, h.c cVar, boolean z) {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        net.one97.paytm.recharge.common.fragment.t tVar = new net.one97.paytm.recharge.common.fragment.t();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_recharge_tabs_flow", z);
        tVar.setArguments(bundle);
        tVar.f61399a = cVar;
        t.a aVar = net.one97.paytm.recharge.common.fragment.t.f61397b;
        a2.a(R.id.container_frame, tVar, net.one97.paytm.recharge.common.fragment.t.f61398e);
        for (Map.Entry next : map.entrySet()) {
            a2.a((View) next.getValue(), (String) next.getKey());
        }
        t.a aVar2 = net.one97.paytm.recharge.common.fragment.t.f61397b;
        a2.a(net.one97.paytm.recharge.common.fragment.t.f61398e);
        a2.c();
    }

    public final j g() {
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    public final net.one97.paytm.recharge.mobile.d.a h() {
        return this.f63654d;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == this.k) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
            if (aVar == null) {
                k.a();
            }
            i iVar = this;
            aVar.a((kotlin.k.e<x>) new g(iVar));
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63654d;
            if (aVar2 == null) {
                k.a();
            }
            w wVar = aVar2.t;
            if (wVar != null) {
                wVar.f61788h = new h(iVar);
            }
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63654d;
            if (aVar3 == null) {
                k.a();
            }
            net.one97.paytm.recharge.common.utils.ai.a(this, aVar3.f61408a, new C1238i(iVar));
            j childFragmentManager = getChildFragmentManager();
            Fragment c2 = getChildFragmentManager().c(R.id.container_frame);
            if (c2 == null) {
                k.a();
            }
            k.a((Object) c2, "childFragmentManager.fin…d(R.id.container_frame)!!");
            childFragmentManager.a(c2.getTag());
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f63660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f63661b;

        a(i iVar, x.e eVar) {
            this.f63660a = iVar;
            this.f63661b = eVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.metro.c.p pVar = (net.one97.paytm.recharge.metro.c.p) this.f63661b.element;
            if (pVar == null) {
                k.a();
            }
            pVar.a();
            net.one97.paytm.recharge.mobile.d.a a2 = this.f63660a.f63654d;
            if (a2 != null) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a3.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a3.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                a2.a(a3);
                String categoryId = a2.r.getCategoryId();
                i iVar = this.f63660a;
                a2.a("offline.retry.get.category", categoryId, (ai) iVar, (net.one97.paytm.recharge.common.b.a.a) iVar, (Object) a3);
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
                    if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !this.f63658h) {
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
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
            if (aVar != null) {
                aVar.a_(str, iJRPaytmDataModel, obj);
            }
        }
    }

    public final void a(String str, boolean z, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        if (str.hashCode() == 2122454023 && str.equals("offline.retry.get.category")) {
            i();
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
            if (aVar != null) {
                aVar.a(str, z, iJRPaytmDataModel, obj);
            }
        }
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        if (str.hashCode() == 2122454023 && str.equals("offline.retry.get.category")) {
            i();
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63654d;
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

    public final void onDestroy() {
        if (this.n) {
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.recharge.mobile.d.a) null);
        }
        super.onDestroy();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
