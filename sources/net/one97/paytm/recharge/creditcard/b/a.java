package net.one97.paytm.recharge.creditcard.b;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import easypay.manager.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.h.d;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.creditcard.activity.AJRCreditCardEnterAmountActivity;
import net.one97.paytm.recharge.creditcard.b.c;
import net.one97.paytm.recharge.creditcard.b.d;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;
import net.one97.paytm.recharge.creditcard.v4.activity.AJRCreditCardEnterAmountActivityV4;
import net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4;
import net.one97.paytm.recharge.creditcard.v4.c.b;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends Fragment implements net.one97.paytm.recharge.creditcard.v4.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.recharge.creditcard.c.a f62401a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRItem f62402b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f62403c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f62404d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f62405e;

    /* renamed from: f  reason: collision with root package name */
    private CJRCreditCardModelV8 f62406f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.h.d f62407g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f62408h = "credit_card";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRCategoryData f62409i;
    private boolean j;
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.b.a$a  reason: collision with other inner class name */
    static final /* synthetic */ class C1200a extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        C1200a(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class b extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        b(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class c extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        c(a aVar) {
            super(1, aVar);
        }

        public final String getName() {
            return "performInstuction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "performInstuction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            a.a((a) this.receiver, cJRInstruct);
        }
    }

    static final /* synthetic */ class d extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        d(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class e extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        e(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class f extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        f(a aVar) {
            super(1, aVar);
        }

        public final String getName() {
            return "performInstuction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "performInstuction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            a.a((a) this.receiver, cJRInstruct);
        }
    }

    static final /* synthetic */ class g extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        g(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class h extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        h(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final /* synthetic */ class i extends kotlin.g.b.i implements kotlin.g.a.b<CJRInstruct, x> {
        i(a aVar) {
            super(1, aVar);
        }

        public final String getName() {
            return "performInstuction";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "performInstuction(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            a.a((a) this.receiver, cJRInstruct);
        }
    }

    static final /* synthetic */ class j extends kotlin.g.b.i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        j(a aVar) {
            super(3, aVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(a.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((a) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRCategoryData>, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRCategoryData>) (Data) obj);
            return x.f47997a;
        }

        public final void invoke(Data<CJRCategoryData> data) {
            DataState dataState;
            CJRCategoryData data2;
            if (data != null) {
                dataState = data.getDataState();
            } else {
                dataState = null;
            }
            if (dataState != null) {
                int i2 = b.f62422a[dataState.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            a.i(this.this$0);
                        }
                    } else if (this.this$0.f62404d) {
                        this.this$0.h();
                    }
                } else if (az.d(this.this$0.getActivity())) {
                    try {
                        FrameLayout frameLayout = (FrameLayout) this.this$0.a(R.id.shimmer_parent_layout);
                        if (frameLayout != null) {
                            ai.a(frameLayout);
                        }
                        RecyclerView recyclerView = (RecyclerView) this.this$0.a(R.id.savedcard_listView);
                        if (recyclerView != null) {
                            ai.a(recyclerView);
                        }
                        a.g(this.this$0);
                    } catch (Exception unused) {
                    }
                } else {
                    CardView cardView = (CardView) this.this$0.a(R.id.card_view);
                    if (cardView != null) {
                        ai.a(cardView);
                    }
                    FrameLayout frameLayout2 = (FrameLayout) this.this$0.a(R.id.shimmer_parent_layout);
                    if (frameLayout2 != null) {
                        ai.a(frameLayout2);
                    }
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.this$0.a(R.id.shimmer_creditcard);
                    if (shimmerFrameLayout != null) {
                        shimmerFrameLayout.a();
                    }
                }
            }
            if (data != null && (data2 = data.getData()) != null) {
                this.this$0.f62409i = data2;
                this.this$0.f62403c = true;
                net.one97.paytm.recharge.creditcard.c.a j = this.this$0.f62401a;
                if (j != null) {
                    kotlin.g.b.k.c(data2, "cjrCategoryData");
                    j.R = data2;
                    j.c();
                }
                net.one97.paytm.recharge.creditcard.c.a j2 = this.this$0.f62401a;
                if (j2 != null) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    j2.b(net.one97.paytm.recharge.widgets.c.d.b());
                }
            }
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.b<List<CJRCreditCardModelV8>, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<CJRCreditCardModelV8>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<CJRCreditCardModelV8> list) {
            this.this$0.f62404d = true;
            if (!this.this$0.f62403c) {
                return;
            }
            if (list != null && (!list.isEmpty())) {
                a.a(this.this$0, (List) list);
            } else if (az.d(this.this$0.getActivity())) {
                FrameLayout frameLayout = (FrameLayout) this.this$0.a(R.id.shimmer_parent_layout);
                if (frameLayout != null) {
                    ai.b(frameLayout);
                }
                this.this$0.a();
            } else {
                this.this$0.f();
                Context context = this.this$0.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
                String f2 = this.this$0.f62408h;
                String str = ab.f61496a;
                kotlin.g.b.k.a((Object) str, "CJRRechargeUtilityConstant.UTILITY");
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, f2, "recents_not_shown", "", "", str, (Object) null, (Object) null, 96);
            }
        }
    }

    public final void a(boolean z) {
        net.one97.paytm.recharge.creditcard.c.a aVar;
        if (z && (aVar = this.f62401a) != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            aVar.b(net.one97.paytm.recharge.widgets.c.d.b());
        }
        this.j = z;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            this.f62407g = new net.one97.paytm.recharge.ordersummary.h.d(context);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_credit_card_landing, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        androidx.lifecycle.y<Data<CJRCategoryData>> yVar;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("recharge_item");
            if (serializable != null) {
                this.f62402b = (CJRItem) serializable;
                this.f62405e = arguments.getBoolean("is_recharge_tabs_flow", false);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
            }
        }
        try {
            if (this.f62402b != null) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    CJRItem cJRItem = this.f62402b;
                    if (cJRItem == null) {
                        kotlin.g.b.k.a();
                    }
                    d.a a2 = new d.a(d.b.CREDIT_CARD).a(cJRItem);
                    Context context = getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context, "context!!");
                    Context applicationContext = context.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext, "context!!.applicationContext");
                    d.a a3 = a2.a(net.one97.paytm.recharge.common.b.d.b(applicationContext));
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity2, "activity!!");
                    d.a a4 = a3.a(net.one97.paytm.recharge.common.b.d.d(activity2)).a((kotlin.k.e<x>) new C1200a(this));
                    Context context2 = getContext();
                    if (context2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context2, "context!!");
                    Context applicationContext2 = context2.getApplicationContext();
                    kotlin.g.b.k.a((Object) applicationContext2, "context!!.applicationContext");
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(applicationContext2);
                    dVar.f64343a = cJRItem;
                    androidx.lifecycle.ai a5 = am.a(activity, (al.b) new net.one97.paytm.recharge.common.h.d(a4.a(dVar))).a(net.one97.paytm.recharge.creditcard.c.a.class);
                    kotlin.g.b.k.a((Object) a5, "ViewModelProviders.of(th…elFactory)[T::class.java]");
                    this.f62401a = (net.one97.paytm.recharge.creditcard.c.a) a5;
                    net.one97.paytm.recharge.creditcard.c.a aVar = this.f62401a;
                    if (aVar != null) {
                        aVar.c(Constants.EASYPAY_PAYTYPE_CREDIT_CARD);
                    }
                    CJRItem cJRItem2 = this.f62402b;
                    LiveData liveData = null;
                    if (com.paytm.utility.b.s(cJRItem2 != null ? cJRItem2.getURL() : null)) {
                        if (com.paytm.utility.d.c(getActivity())) {
                            e();
                        }
                        net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62401a;
                        if (aVar2 != null) {
                            yVar = aVar2.x;
                        } else {
                            yVar = null;
                        }
                        net.one97.paytm.recharge.common.utils.g.a(this, yVar, new k(this));
                        net.one97.paytm.recharge.creditcard.c.a aVar3 = this.f62401a;
                        if (aVar3 != null) {
                            liveData = aVar3.O;
                        }
                        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new l(this));
                    }
                }
                net.one97.paytm.recharge.creditcard.c.a aVar4 = this.f62401a;
                if (aVar4 != null) {
                    aVar4.a((kotlin.k.e<x>) new b(this));
                    ai.a(this, aVar4.f61408a, new c(this));
                    w wVar = aVar4.t;
                    if (wVar != null) {
                        wVar.f61788h = new d(this);
                    }
                }
            }
        } catch (Exception unused) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
        if (!com.paytm.utility.d.c(getActivity())) {
            z.a((Activity) getActivity(), (Fragment) this, 3);
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            g();
            return;
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        net.one97.paytm.recharge.creditcard.c.a aVar = this.f62401a;
        if (aVar != null) {
            aVar.a(a2);
        }
        net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62401a;
        if (aVar2 != null) {
            aVar2.b("getCategory", a2);
        }
        net.one97.paytm.recharge.creditcard.c.a aVar3 = this.f62401a;
        if (aVar3 != null) {
            String a3 = com.paytm.utility.d.a(getActivity());
            kotlin.g.b.k.a((Object) a3, "CJRNetUtility.getSSOToken(activity)");
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            aVar3.b(a3, (Context) activity);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.recharge.creditcard.c.a aVar;
        Fragment fragment;
        net.one97.paytm.recharge.creditcard.c.a aVar2;
        AJRCreditCardEnterAmountActivity.b bVar = AJRCreditCardEnterAmountActivity.f62377b;
        if (i2 == AJRCreditCardEnterAmountActivity.P) {
            if (az.d(getActivity())) {
                androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                b.a aVar3 = net.one97.paytm.recharge.creditcard.v4.c.b.f62581b;
                fragment = childFragmentManager.c(net.one97.paytm.recharge.creditcard.v4.c.b.w);
            } else {
                androidx.fragment.app.j childFragmentManager2 = getChildFragmentManager();
                c.a aVar4 = c.f62423a;
                fragment = childFragmentManager2.c(c.u);
            }
            if (fragment instanceof net.one97.paytm.recharge.creditcard.v4.c.b) {
                net.one97.paytm.recharge.creditcard.v4.c.b bVar2 = (net.one97.paytm.recharge.creditcard.v4.c.b) fragment;
                if (bVar2.isAdded() && !bVar2.isDetached()) {
                    bVar2.a();
                }
            }
            if (az.d(getActivity()) && (aVar2 = this.f62401a) != null) {
                a aVar5 = this;
                aVar2.a((kotlin.k.e<x>) new e(aVar5));
                ai.a(this, aVar2.f61408a, new f(aVar5));
                w wVar = aVar2.t;
                if (wVar != null) {
                    wVar.f61788h = new g(aVar5);
                }
            }
        } else {
            AJRNewCardActivityV4.a aVar6 = AJRNewCardActivityV4.f62553a;
            if (i2 == AJRNewCardActivityV4.f62554c) {
                if (az.d(getActivity()) && (aVar = this.f62401a) != null) {
                    a aVar7 = this;
                    aVar.a((kotlin.k.e<x>) new h(aVar7));
                    ai.a(this, aVar.f61408a, new i(aVar7));
                    w wVar2 = aVar.t;
                    if (wVar2 != null) {
                        wVar2.f61788h = new j(aVar7);
                    }
                }
            } else if (i2 == 3) {
                androidx.fragment.app.j childFragmentManager3 = getChildFragmentManager();
                c.a aVar8 = c.f62423a;
                Fragment c2 = childFragmentManager3.c(c.u);
                if (c2 != null && (c2 instanceof c)) {
                    c2.onActivityResult(i2, i3, intent);
                    return;
                } else if (i3 != 0) {
                    e();
                } else {
                    ay.a(true);
                    ay ayVar = ay.f61523a;
                    ay.a(i2);
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1517120432) {
                if (hashCode != 262142210 || !str.equals("get_pf_credit_card_verify")) {
                    return;
                }
            } else if (!str.equals("get_pf_credit_card_token")) {
                return;
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                cJRRechargeErrorModel.setExtraObj((Object) null);
                CRUFlowModel flowName = cJRRechargeErrorModel.getFlowName();
                if (flowName != null) {
                    flowName.setTag(str);
                }
            }
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, getActivity(), (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
        }
    }

    public final void a() {
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a(this.f62401a);
        h();
        FrameLayout frameLayout = (FrameLayout) a(R.id.lyt_container);
        if (frameLayout != null) {
            ai.a(frameLayout);
        }
        net.one97.paytm.recharge.creditcard.v4.c.a aVar = new net.one97.paytm.recharge.creditcard.v4.c.a();
        Bundle bundle = new Bundle();
        CJRCategoryData cJRCategoryData = this.f62409i;
        Object logoUrl = cJRCategoryData != null ? cJRCategoryData.getLogoUrl() : null;
        if (!(logoUrl instanceof String)) {
            logoUrl = null;
        }
        bundle.putString("logo_url", (String) logoUrl);
        aVar.setArguments(bundle);
        getChildFragmentManager().a().b(R.id.lyt_container, aVar, net.one97.paytm.recharge.creditcard.v4.c.a.class.getSimpleName()).c();
    }

    public final void onDestroy() {
        if (az.d(getActivity())) {
            net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
            net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.recharge.creditcard.c.a) null);
        }
        super.onDestroy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: net.one97.paytm.recharge.creditcard.b.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: net.one97.paytm.recharge.creditcard.b.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: net.one97.paytm.recharge.creditcard.b.c} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r4 = this;
            int r0 = net.one97.paytm.recharge.R.id.shimmer_parent_layout
            android.view.View r0 = r4.a((int) r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L_0x000f
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.b(r0)
        L_0x000f:
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.recharge.common.utils.az.d(r0)
            if (r0 == 0) goto L_0x0037
            net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
            net.one97.paytm.recharge.creditcard.c.a r0 = r4.f62401a
            net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.recharge.creditcard.c.a) r0)
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r4.getContext()
            java.lang.Class<net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4> r2 = net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4.class
            r0.<init>(r1, r2)
            net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4$a r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4.f62553a
            int r1 = net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4.f62554c
            r4.startActivityForResult(r0, r1)
            return
        L_0x0037:
            int r0 = net.one97.paytm.recharge.R.id.lyt_container
            android.view.View r0 = r4.a((int) r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L_0x0046
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.recharge.common.utils.ai.a(r0)
        L_0x0046:
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = net.one97.paytm.recharge.common.utils.az.d(r0)
            if (r0 == 0) goto L_0x0067
            net.one97.paytm.recharge.creditcard.v4.c.b r0 = new net.one97.paytm.recharge.creditcard.v4.c.b
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            boolean r2 = r4.f62405e
            java.lang.String r3 = "IS_IN_TABS"
            r1.putBoolean(r3, r2)
            r0.setArguments(r1)
            goto L_0x006c
        L_0x0067:
            net.one97.paytm.recharge.creditcard.b.c r0 = new net.one97.paytm.recharge.creditcard.b.c
            r0.<init>()
        L_0x006c:
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            android.content.Context r1 = (android.content.Context) r1
            boolean r1 = net.one97.paytm.recharge.common.utils.az.d(r1)
            if (r1 == 0) goto L_0x0081
            net.one97.paytm.recharge.creditcard.v4.c.b$a r1 = net.one97.paytm.recharge.creditcard.v4.c.b.f62581b
            java.lang.String r1 = net.one97.paytm.recharge.creditcard.v4.c.b.w
            goto L_0x0087
        L_0x0081:
            net.one97.paytm.recharge.creditcard.b.c$a r1 = net.one97.paytm.recharge.creditcard.b.c.f62423a
            java.lang.String r1 = net.one97.paytm.recharge.creditcard.b.c.u
        L_0x0087:
            androidx.fragment.app.j r2 = r4.getChildFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            int r3 = net.one97.paytm.recharge.R.id.lyt_container
            androidx.fragment.app.q r0 = r2.b(r3, r0, r1)
            java.lang.Class<net.one97.paytm.recharge.creditcard.b.c> r1 = net.one97.paytm.recharge.creditcard.b.c.class
            java.lang.String r1 = r1.getSimpleName()
            androidx.fragment.app.q r0 = r0.a((java.lang.String) r1)
            r0.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.a.f():void");
    }

    /* access modifiers changed from: private */
    public void a(CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, Map<String, ? extends View> map, boolean z2) {
        CJRCategoryData cJRCategoryData;
        CJRCategoryData cJRCategoryData2;
        kotlin.g.b.k.c(cJRCreditCardModelV8, "selectedCard");
        this.f62406f = cJRCreditCardModelV8;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                boolean d2 = az.d(getActivity());
                Intent intent = new Intent(getContext(), d2 ? AJRCreditCardEnterAmountActivityV4.class : AJRCreditCardEnterAmountActivity.class);
                intent.addFlags(67108864);
                intent.putExtra("selected_item", cJRCreditCardModelV8);
                net.one97.paytm.recharge.creditcard.c.a aVar = this.f62401a;
                String str = null;
                intent.putExtra("title", (aVar == null || (cJRCategoryData2 = aVar.R) == null) ? null : cJRCategoryData2.getCategoryHeader());
                net.one97.paytm.recharge.creditcard.c.a aVar2 = this.f62401a;
                intent.putExtra("Recharge browse plan disclaimer", (aVar2 == null || (cJRCategoryData = aVar2.R) == null) ? null : cJRCategoryData.getDisclaimer());
                if (z) {
                    str = "saved_card";
                }
                intent.putExtra(UpiConstants.FROM, str);
                intent.putExtra("recharge_item", this.f62402b);
                intent.putExtra(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, this.f62409i);
                intent.putExtra("deeplink", z2);
                if (d2) {
                    AJRCreditCardEnterAmountActivity.b bVar = AJRCreditCardEnterAmountActivity.f62377b;
                    startActivityForResult(intent, AJRCreditCardEnterAmountActivity.P);
                    cJRCreditCardModelV8.setDeeplinkAmount("");
                } else if (d2) {
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        ArrayList arrayList = new ArrayList();
                        if (map != null) {
                            for (Map.Entry next : map.entrySet()) {
                                if (next.getValue() != null) {
                                    Object value = next.getValue();
                                    if (value == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    arrayList.add(new Pair(value, next.getKey()));
                                }
                            }
                        }
                        Activity activity2 = getActivity();
                        Object[] array = arrayList.toArray(new Pair[0]);
                        if (array != null) {
                            Pair[] pairArr = (Pair[]) array;
                            ActivityOptions makeSceneTransitionAnimation = ActivityOptions.makeSceneTransitionAnimation(activity2, (Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                            AJRCreditCardEnterAmountActivity.b bVar2 = AJRCreditCardEnterAmountActivity.f62377b;
                            startActivityForResult(intent, AJRCreditCardEnterAmountActivity.P, makeSceneTransitionAnimation.toBundle());
                            return;
                        }
                        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    AJRCreditCardEnterAmountActivity.b bVar3 = AJRCreditCardEnterAmountActivity.f62377b;
                    startActivityForResult(intent, AJRCreditCardEnterAmountActivity.P);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        r5 = (r5 = r5.getProductList()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r24, boolean r25, java.util.Map<java.lang.String, ? extends android.view.View> r26, boolean r27, boolean r28) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            java.lang.String r4 = "cardModel"
            kotlin.g.b.k.c(r1, r4)
            net.one97.paytm.recharge.widgets.c.e r4 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            net.one97.paytm.recharge.widgets.c.e r5 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            int r5 = r5.getDELAY_1000_MILLI()
            boolean r4 = r4.validateIsAlreadyClicked(r1, r5)
            if (r4 == 0) goto L_0x001e
            if (r27 != 0) goto L_0x001e
            return
        L_0x001e:
            android.content.Context r4 = r23.getContext()
            boolean r4 = net.one97.paytm.recharge.common.utils.az.d(r4)
            if (r4 != 0) goto L_0x0056
            if (r2 == 0) goto L_0x003f
            net.one97.paytm.recharge.ordersummary.h.d r5 = r0.f62407g
            if (r5 == 0) goto L_0x0056
            java.lang.String r6 = r0.f62408h
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 112(0x70, float:1.57E-43)
            java.lang.String r7 = "pay_bill_for_other_card_clicked"
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0056
        L_0x003f:
            net.one97.paytm.recharge.ordersummary.h.d r14 = r0.f62407g
            if (r14 == 0) goto L_0x0056
            java.lang.String r15 = r0.f62408h
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 112(0x70, float:1.57E-43)
            java.lang.String r16 = "saved_card_clicked"
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x0056:
            androidx.fragment.app.j r4 = r23.getChildFragmentManager()
            int r5 = net.one97.paytm.recharge.R.id.lyt_container
            androidx.fragment.app.Fragment r4 = r4.c((int) r5)
            androidx.fragment.app.FragmentActivity r5 = r23.getActivity()
            android.content.Context r5 = (android.content.Context) r5
            boolean r5 = net.one97.paytm.recharge.common.utils.az.d(r5)
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x00a4
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r24.getSelectedDCVariant()
            if (r5 == 0) goto L_0x00a1
            java.util.List r5 = r5.getProductList()
            if (r5 == 0) goto L_0x00a1
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r6
            if (r5 != r6) goto L_0x00a1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r5 = r24.getSelectedDCVariant()
            if (r5 == 0) goto L_0x009c
            java.util.List r5 = r5.getProductList()
            if (r5 == 0) goto L_0x009c
            java.lang.Object r5 = r5.get(r7)
            net.one97.paytm.recharge.model.v4.CJRProductsItem r5 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r5
            if (r5 == 0) goto L_0x009c
            boolean r5 = r5.isPrefetch()
            goto L_0x009d
        L_0x009c:
            r5 = 0
        L_0x009d:
            r1.setPaytmFirstCreditCard(r5)
            goto L_0x00a4
        L_0x00a1:
            r1.setPaytmFirstCreditCard(r7)
        L_0x00a4:
            boolean r5 = r24.isPaytmFirstCreditCard()
            if (r5 == 0) goto L_0x00d1
            if (r27 != 0) goto L_0x00d1
            int r5 = r24.getCardTypeId()
            int r8 = r24.getFreshCardId()
            if (r5 != r8) goto L_0x00b7
            goto L_0x00d1
        L_0x00b7:
            boolean r5 = r4 instanceof net.one97.paytm.recharge.creditcard.v4.c.c
            if (r5 == 0) goto L_0x00c0
            net.one97.paytm.recharge.creditcard.v4.c.c r4 = (net.one97.paytm.recharge.creditcard.v4.c.c) r4
            r4.a((boolean) r6, false)
        L_0x00c0:
            net.one97.paytm.recharge.creditcard.c.a r4 = r0.f62401a
            if (r4 == 0) goto L_0x00c9
            r5 = r0
            net.one97.paytm.recharge.creditcard.v4.a r5 = (net.one97.paytm.recharge.creditcard.v4.a) r5
            r4.W = r5
        L_0x00c9:
            net.one97.paytm.recharge.creditcard.c.a r4 = r0.f62401a
            if (r4 == 0) goto L_0x00d0
            r4.a((net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8) r1, (boolean) r2, (java.util.Map<java.lang.String, ? extends android.view.View>) r3)
        L_0x00d0:
            return
        L_0x00d1:
            boolean r5 = r4 instanceof net.one97.paytm.recharge.creditcard.v4.c.c
            if (r5 == 0) goto L_0x00da
            net.one97.paytm.recharge.creditcard.v4.c.c r4 = (net.one97.paytm.recharge.creditcard.v4.c.c) r4
            r4.a((boolean) r7, false)
        L_0x00da:
            if (r2 == 0) goto L_0x00e0
            r23.f()
            return
        L_0x00e0:
            r2 = r28
            r0.a(r1, r6, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.b.a.a(net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8, boolean, java.util.Map, boolean, boolean):void");
    }

    public final void b() {
        String str;
        Fragment c2 = getChildFragmentManager().c(R.id.lyt_container);
        if (c2 instanceof d) {
            str = "save card";
        } else {
            str = c2 instanceof c ? "credit card number" : "";
        }
        String str2 = str;
        net.one97.paytm.recharge.ordersummary.h.d dVar = this.f62407g;
        if (dVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, this.f62408h, "back_button_clicked", "", str2, (Object) null, (Object) null, (Object) null, 112);
        }
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        if (childFragmentManager.f() > 1) {
            getChildFragmentManager().d();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void g() {
        if (getContext() != null) {
            if (this.f62405e) {
                net.one97.paytm.recharge.metro.c.p pVar = new net.one97.paytm.recharge.metro.c.p();
                pVar.a(new o(this, pVar));
                FrameLayout frameLayout = (FrameLayout) a(R.id.lyt_container);
                if (frameLayout != null) {
                    ai.a(frameLayout);
                }
                getChildFragmentManager();
                net.one97.paytm.recharge.common.utils.am.a(getChildFragmentManager().a().a(R.id.lyt_container, pVar, ""));
                return;
            }
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            c.a aVar = new c.a(context);
            View inflate = getLayoutInflater().inflate(R.layout.no_internet_retry_dialog, (ViewGroup) null);
            aVar.a(inflate);
            aVar.a(false);
            View findViewById = inflate.findViewById(R.id.btn_back);
            if (findViewById == null) {
                kotlin.g.b.k.a();
            }
            View findViewById2 = inflate.findViewById(R.id.btn_retry);
            if (findViewById2 == null) {
                kotlin.g.b.k.a();
            }
            androidx.appcompat.app.c a2 = aVar.a();
            kotlin.g.b.k.a((Object) a2, "dialogBuilder.create()");
            findViewById.setOnClickListener(new p(this, a2));
            findViewById2.setOnClickListener(new q(this, a2));
            a2.show();
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62415a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.metro.c.p f62416b;

        o(a aVar, net.one97.paytm.recharge.metro.c.p pVar) {
            this.f62415a = aVar;
            this.f62416b = pVar;
        }

        public final void onClick(View view) {
            this.f62415a.e();
            this.f62415a.getChildFragmentManager().a().a((Fragment) this.f62416b).b();
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62417a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f62418b;

        p(a aVar, androidx.appcompat.app.c cVar) {
            this.f62417a = aVar;
            this.f62418b = cVar;
        }

        public final void onClick(View view) {
            this.f62418b.dismiss();
            view.postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ p f62419a;

                {
                    this.f62419a = r1;
                }

                public final void run() {
                    FragmentActivity activity = this.f62419a.f62417a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }, 200);
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f62421b;

        q(a aVar, androidx.appcompat.app.c cVar) {
            this.f62420a = aVar;
            this.f62421b = cVar;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.b.c(this.f62420a.getContext())) {
                this.f62420a.e();
                this.f62421b.dismiss();
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f62411b;

        m(a aVar, androidx.appcompat.app.c cVar) {
            this.f62410a = aVar;
            this.f62411b = cVar;
        }

        public final void onClick(View view) {
            this.f62411b.dismiss();
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ m f62412a;

                {
                    this.f62412a = r1;
                }

                public final void run() {
                    FragmentActivity activity = this.f62412a.f62410a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }, 100);
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62413a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f62414b;

        n(a aVar, androidx.appcompat.app.c cVar) {
            this.f62413a = aVar;
            this.f62414b = cVar;
        }

        public final void onClick(View view) {
            this.f62414b.dismiss();
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                CJRItem l = this.f62413a.f62402b;
                if (com.paytm.utility.b.s(l != null ? l.getURL() : null) && com.paytm.utility.d.c(this.f62413a.getActivity())) {
                    this.f62413a.e();
                }
            }
        }
    }

    public final void c() {
        if (getActivity() != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.FETCH_RECENTS.name());
            }
            if (this.f62401a != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                net.one97.paytm.recharge.creditcard.c.a.a("frequent_api", (Context) activity, (Object) a2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        if (az.d(getActivity())) {
            RecyclerView recyclerView = (RecyclerView) a(R.id.savedcard_listView);
            if (recyclerView != null) {
                recyclerView.setAdapter((RecyclerView.a) null);
                return;
            }
            return;
        }
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_creditcard);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            FrameLayout frameLayout = (FrameLayout) a(R.id.shimmer_parent_layout);
            if (frameLayout != null) {
                ai.b(frameLayout);
            }
            CardView cardView = (CardView) a(R.id.card_view);
            if (cardView != null) {
                ai.b(cardView);
            }
        } catch (Exception unused) {
        }
    }

    public final Context d() {
        return getContext();
    }

    public final void a(CJRCreditCardModelV8 cJRCreditCardModelV8) {
        String str;
        Fragment c2 = getChildFragmentManager().c(R.id.lyt_container);
        if (c2 instanceof net.one97.paytm.recharge.creditcard.v4.c.c) {
            ((net.one97.paytm.recharge.creditcard.v4.c.c) c2).a(false, false);
        }
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        StringBuilder sb = new StringBuilder("PFCC : Validation Failed ");
        if (cJRCreditCardModelV8 == null || (str = cJRCreditCardModelV8.getDisplayCardNumber()) == null) {
            str = "";
        }
        sb.append(str);
        net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
    }

    public static final /* synthetic */ void a(a aVar, CJRInstruct cJRInstruct) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        a aVar2 = aVar;
        CJRInstruct cJRInstruct2 = cJRInstruct;
        String str = null;
        if (cJRInstruct2 instanceof CJRInstruct.sendProductNotSelectedHawkEyeEvent) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            net.one97.paytm.recharge.creditcard.c.a aVar3 = aVar2.f62401a;
            if (aVar3 != null) {
                str = aVar3.A;
            }
            a2.setCategoryId(str);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (kotlin.g.b.g) null);
            }
            a2.setFlowName(flowName);
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setErrorType(ERROR_TYPE.UI_DESCRIPTION.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setTag("fetchPaymentOptions");
            }
            a2.setErrorMsg(aVar2.getString(R.string.product_not_found, ((CJRInstruct.sendProductNotSelectedHawkEyeEvent) cJRInstruct2).getBankCode()));
            az azVar = az.f61525a;
            az.a(a2);
        } else if (cJRInstruct2 instanceof CJRInstruct.showAlertDialog) {
            CJRInstruct.showAlertDialog showalertdialog = (CJRInstruct.showAlertDialog) cJRInstruct2;
            if (showalertdialog.getHawkEyeEvent() instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) showalertdialog.getHawkEyeEvent();
                ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                CRUFlowModel flowName4 = cJRRechargeErrorModel2.getFlowName();
                if (flowName4 != null) {
                    str = flowName4.getActionType();
                }
                cJRRechargeErrorModel = cJRRechargeErrorModel2;
                action_type = companion.getActionType(str, ACTION_TYPE.CLP_PROCEED);
            } else {
                action_type = null;
                cJRRechargeErrorModel = null;
            }
            az azVar2 = az.f61525a;
            Context context = aVar.getContext();
            if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                error_type = ERROR_TYPE.UNDEFINED;
            }
            az.a(context, error_type, action_type, showalertdialog.getTitle(), showalertdialog.getMessage(), false, cJRRechargeErrorModel, false, 1504);
        }
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        Fragment fragment;
        aVar.h();
        Bundle bundle = new Bundle();
        if (list != null) {
            bundle.putSerializable("saved_cards_list", (Serializable) list);
            bundle.putBoolean("is_recharge_tabs_flow", aVar.f62405e);
            Context context = aVar.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            String str = aVar.f62408h;
            Integer valueOf = Integer.valueOf(list.size());
            String str2 = ab.f61496a;
            kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str, "recents_shown", "", valueOf, str2, (Object) null, (Object) null, 96);
            if (aVar.getContext() != null) {
                androidx.fragment.app.j childFragmentManager = aVar.getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                androidx.fragment.app.f u = childFragmentManager.u();
                kotlin.g.b.k.a((Object) u, "childFragmentManager.fragmentFactory");
                if (az.d(aVar.getActivity())) {
                    Context context2 = aVar.getContext();
                    if (context2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context2, "context!!");
                    fragment = u.c(context2.getClassLoader(), net.one97.paytm.recharge.creditcard.v4.c.c.class.getName());
                } else {
                    Context context3 = aVar.getContext();
                    if (context3 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context3, "context!!");
                    fragment = u.c(context3.getClassLoader(), d.class.getName());
                }
                kotlin.g.b.k.a((Object) fragment, "if(RechargeUtilities.isC…gmentV3::class.java.name)");
                fragment.setArguments(bundle);
                androidx.fragment.app.q a2 = aVar.getChildFragmentManager().a();
                int i2 = R.id.lyt_container;
                d.a aVar2 = d.f62443a;
                androidx.fragment.app.q b2 = a2.b(i2, fragment, d.n);
                d.a aVar3 = d.f62443a;
                b2.a(d.n).c();
                FrameLayout frameLayout = (FrameLayout) aVar.a(R.id.lyt_container);
                if (frameLayout != null) {
                    ai.a(frameLayout);
                }
                if ((aVar.getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !aVar.f62405e) {
                    FragmentActivity activity = aVar.getActivity();
                    if (activity != null) {
                        net.one97.paytm.recharge.common.e.y yVar = (net.one97.paytm.recharge.common.e.y) activity;
                        CJRCategoryData cJRCategoryData = aVar.f62409i;
                        yVar.b(cJRCategoryData != null ? cJRCategoryData.getCategoryHeader() : null);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type java.io.Serializable");
    }

    public static final /* synthetic */ void g(a aVar) {
        RecyclerView recyclerView = (RecyclerView) aVar.a(R.id.savedcard_listView);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView2 = (RecyclerView) aVar.a(R.id.savedcard_listView);
        if (recyclerView2 != null) {
            ai.a(recyclerView2);
        }
        RecyclerView recyclerView3 = (RecyclerView) aVar.a(R.id.savedcard_listView);
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
        }
        RecyclerView recyclerView4 = (RecyclerView) aVar.a(R.id.savedcard_listView);
        if (recyclerView4 != null) {
            recyclerView4.setLayoutManager(new LinearLayoutManager(aVar.getActivity()));
        }
        RecyclerView recyclerView5 = (RecyclerView) aVar.a(R.id.savedcard_listView);
        if (recyclerView5 != null) {
            recyclerView5.addItemDecoration(new net.one97.paytm.recharge.automatic.b.a());
        }
        RecyclerView recyclerView6 = (RecyclerView) aVar.a(R.id.savedcard_listView);
        if (recyclerView6 != null) {
            RecyclerView recyclerView7 = (RecyclerView) aVar.a(R.id.savedcard_listView);
            kotlin.g.b.k.a((Object) recyclerView7, "savedcard_listView");
            Context context = recyclerView7.getContext();
            kotlin.g.b.k.a((Object) context, "savedcard_listView.context");
            recyclerView6.setAdapter(new net.one97.paytm.recharge.creditcard.v4.a.a(context, new ArrayList(), "", "", false, true, false, ""));
        }
    }

    public static final /* synthetic */ void i(a aVar) {
        if (aVar.getActivity() != null && aVar.isAdded()) {
            Context context = aVar.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            c.a aVar2 = new c.a(context);
            View inflate = aVar.getLayoutInflater().inflate(R.layout.no_internet_retry_dialog, (ViewGroup) null);
            aVar2.a(inflate);
            aVar2.a(false);
            androidx.appcompat.app.c a2 = aVar2.a();
            kotlin.g.b.k.a((Object) a2, "dialogBuilder.create()");
            View findViewById = inflate.findViewById(R.id.title);
            kotlin.g.b.k.a((Object) findViewById, "(dialogView.findViewById<View>(R.id.title))");
            findViewById.setVisibility(8);
            View findViewById2 = inflate.findViewById(R.id.message);
            kotlin.g.b.k.a((Object) findViewById2, "(dialogView.findViewById<TextView>(R.id.message))");
            ((TextView) findViewById2).setText(aVar.getString(R.string.v4_error_fetch_category));
            TextView textView = (TextView) inflate.findViewById(R.id.btn_back);
            kotlin.g.b.k.a((Object) textView, "backBtn");
            textView.setText(aVar.getString(R.string.cancel_option_str));
            textView.setOnClickListener(new m(aVar, a2));
            TextView textView2 = (TextView) inflate.findViewById(R.id.btn_retry);
            kotlin.g.b.k.a((Object) textView2, "retryBtn");
            textView2.setText(aVar.getString(R.string.v3_error_fetch_category_action_retry));
            textView2.setOnClickListener(new n(aVar, a2));
            a2.show();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
