package net.one97.paytm.recharge.dth.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.a.q;
import kotlin.g.b.g;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.k.d;
import kotlin.k.e;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.h.d;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.dth.AJRDTHRechargeActivity;
import net.one97.paytm.recharge.dth.a.b;
import net.one97.paytm.recharge.dth.a.d;
import net.one97.paytm.recharge.dth.a.g;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.model.VERTICAL;

public final class f extends a {

    /* renamed from: i  reason: collision with root package name */
    public static final a f62680i = new a((byte) 0);

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.recharge.dth.c.a f62681f;

    /* renamed from: g  reason: collision with root package name */
    public CJRItem f62682g;

    /* renamed from: h  reason: collision with root package name */
    public String f62683h;
    /* access modifiers changed from: private */
    public z<List<CJRFrequentOrder>> j;
    private boolean k;
    private HashMap l;

    public final View b(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public final void u() {
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final /* synthetic */ class b extends i implements q<String, NetworkCustomError, Object, x> {
        b(f fVar) {
            super(3, fVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final d getOwner() {
            return y.b(f.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((f) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class c<T> implements z<List<? extends CJRFrequentOrder>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f62684a;

        c(f fVar) {
            this.f62684a = fVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List list = (List) obj;
            if (list != null) {
                net.one97.paytm.recharge.dth.c.a aVar = this.f62684a.f62681f;
                if (aVar == null) {
                    k.a("viewModel");
                }
                LiveData liveData = aVar.f61414g;
                z a2 = this.f62684a.j;
                if (a2 == null) {
                    k.a();
                }
                liveData.removeObserver(a2);
                this.f62684a.b(!list.isEmpty());
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            Fragment c2 = getChildFragmentManager().c(R.id.container_lyt);
            if (c2 instanceof d) {
                ((d) c2).b();
            } else if (c2 instanceof b) {
                ((b) c2).c();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        View decorView;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("recharge_item");
            if (serializable != null) {
                this.f62682g = (CJRItem) serializable;
                this.k = arguments.getBoolean("is_recharge_tabs_flow", false);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem");
            }
        }
        LiveData liveData = null;
        if (Build.VERSION.SDK_INT >= 21 && !this.k) {
            FragmentActivity activity = getActivity();
            Window window = activity != null ? activity.getWindow() : null;
            if (!(window == null || (decorView = window.getDecorView()) == null)) {
                decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            if (window != null) {
                window.setStatusBarColor(-1);
            }
        }
        try {
            CJRItem cJRItem = this.f62682g;
            if (cJRItem == null) {
                k.a("mRechargeItem");
            }
            ay ayVar = ay.f61523a;
            CJRItem cJRItem2 = this.f62682g;
            if (cJRItem2 == null) {
                k.a("mRechargeItem");
            }
            ay.a(cJRItem2, VERTICAL.RECHARGES);
            if (getActivity() != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                w d2 = net.one97.paytm.recharge.common.b.d.d(activity2);
                d2.o = true;
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    d.a a2 = new d.a(d.b.DTH).a(cJRItem);
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    Context applicationContext = context.getApplicationContext();
                    k.a((Object) applicationContext, "context!!.applicationContext");
                    d.a a3 = a2.a(net.one97.paytm.recharge.common.b.d.b(applicationContext)).a(d2).a((e<x>) new b(this));
                    Context context2 = getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    k.a((Object) context2, "context!!");
                    Context applicationContext2 = context2.getApplicationContext();
                    k.a((Object) applicationContext2, "context!!.applicationContext");
                    net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(applicationContext2);
                    dVar.f64343a = cJRItem;
                    ai a4 = am.a(activity3, (al.b) new net.one97.paytm.recharge.common.h.d(a3.a(dVar))).a(net.one97.paytm.recharge.dth.c.a.class);
                    k.a((Object) a4, "ViewModelProviders.of(th…elFactory)[T::class.java]");
                    net.one97.paytm.recharge.dth.c.a aVar = (net.one97.paytm.recharge.dth.c.a) a4;
                    this.f62681f = aVar;
                    Bundle arguments2 = getArguments();
                    aVar.f61411d = arguments2 != null ? arguments2.getBoolean("open_activity_in_automatic_mode") : false;
                    net.one97.paytm.recharge.dth.c.a aVar2 = this.f62681f;
                    if (aVar2 == null) {
                        k.a("viewModel");
                    }
                    a((net.one97.paytm.recharge.common.h.b) aVar2);
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel a5 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                    CRUFlowModel flowName = a5.getFlowName();
                    if (flowName == null) {
                        flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
                    }
                    a5.setFlowName(flowName);
                    CRUFlowModel flowName2 = a5.getFlowName();
                    if (flowName2 != null) {
                        flowName2.setActionType(ACTION_TYPE.FETCH_RECENTS.name());
                    }
                    aVar.b("frequent_api", "DTH", a5);
                }
                if (com.paytm.utility.d.c(getContext())) {
                    this.j = new c(this);
                    net.one97.paytm.recharge.dth.c.a aVar3 = this.f62681f;
                    if (aVar3 == null) {
                        k.a("viewModel");
                    }
                    if (aVar3 != null) {
                        liveData = aVar3.f61414g;
                    }
                    androidx.lifecycle.q qVar = this;
                    z<List<CJRFrequentOrder>> zVar = this.j;
                    if (zVar == null) {
                        k.a();
                    }
                    liveData.observe(qVar, zVar);
                    return;
                }
                b(false);
            }
        } catch (Exception unused) {
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                activity4.finish();
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dth_home, (ViewGroup) null, false);
    }

    /* access modifiers changed from: private */
    public final void b(boolean z) {
        if (z) {
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            int i2 = R.id.container_lyt;
            b.a aVar = b.f62659h;
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            k.a((Object) arguments, "arguments!!");
            a2.a(i2, b.a.a(arguments), b.class.getSimpleName()).a("").b();
        } else if (!z) {
            androidx.fragment.app.q a3 = getChildFragmentManager().a();
            int i3 = R.id.container_lyt;
            d.a aVar2 = d.f62670f;
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            k.a((Object) arguments2, "arguments!!");
            a3.a(i3, d.a.a(arguments2), d.class.getSimpleName()).a("").b();
        }
    }

    public final void a(CJRCategoryData cJRCategoryData, CJRSelectedGroupItem cJRSelectedGroupItem) {
        if (cJRSelectedGroupItem != null) {
            net.one97.paytm.recharge.dth.c.a aVar = this.f62681f;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.P = cJRSelectedGroupItem;
        }
        net.one97.paytm.recharge.dth.c.a aVar2 = this.f62681f;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        aVar2.O = cJRCategoryData;
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        int i2 = R.id.container_lyt;
        g.a aVar3 = g.v;
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        k.a((Object) arguments, "arguments!!");
        a2.a(i2, g.a.a(arguments), g.class.getSimpleName()).a(g.class.getSimpleName()).b();
    }

    public final void b(CJRCategoryData cJRCategoryData, CJRSelectedGroupItem cJRSelectedGroupItem) {
        Intent intent = new Intent(getActivity(), AJRDTHRechargeActivity.class);
        intent.putExtra("category_data", cJRCategoryData);
        intent.putExtra("selected_item", cJRSelectedGroupItem);
        net.one97.paytm.recharge.dth.c.a aVar = this.f62681f;
        if (aVar == null) {
            k.a("viewModel");
        }
        intent.putExtra("deeplink_data", aVar.m);
        intent.putExtra("bundle_data", getArguments());
        startActivity(intent);
    }

    public final void a(String str) {
        if (str != null && (getActivity() instanceof AJRRechargeUtilityActivity)) {
            this.f62683h = str;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRRechargeUtilityActivity) activity).a(str);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
        }
    }
}
