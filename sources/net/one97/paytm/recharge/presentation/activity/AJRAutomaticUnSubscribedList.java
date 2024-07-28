package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.c;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.g;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.presentation.c.a;

public final class AJRAutomaticUnSubscribedList extends PaytmActivity implements View.OnClickListener, net.one97.paytm.recharge.presentation.d.b {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.recharge.presentation.a.d f64697a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.g.a f64698b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRAutomaticSubscriptionListModel f64699c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRFrequentOrderList f64700d;

    /* renamed from: e  reason: collision with root package name */
    private CJRFrequentOrder f64701e;

    /* renamed from: f  reason: collision with root package name */
    private final int f64702f = 2;

    /* renamed from: g  reason: collision with root package name */
    private final a f64703g = new a();

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64704h;

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f64705a = new b();

        b() {
        }

        public final void onClick(View view) {
        }
    }

    public final View b(int i2) {
        if (this.f64704h == null) {
            this.f64704h = new HashMap();
        }
        View view = (View) this.f64704h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64704h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRFrequentOrderList>, x> {
        final /* synthetic */ AJRAutomaticUnSubscribedList this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList) {
            super(1);
            this.this$0 = aJRAutomaticUnSubscribedList;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRFrequentOrderList>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRFrequentOrderList> bVar) {
            FrameLayout frameLayout;
            if (bVar != null) {
                int i2 = f.f64718a[bVar.f64955c.ordinal()];
                if (i2 == 1) {
                    FrameLayout frameLayout2 = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar);
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                    }
                } else if (i2 == 2) {
                    FrameLayout frameLayout3 = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar);
                    if (frameLayout3 != null) {
                        frameLayout3.setVisibility(8);
                    }
                } else if (i2 == 3 && (frameLayout = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar)) != null) {
                    frameLayout.setVisibility(8);
                }
                CJRFrequentOrderList cJRFrequentOrderList = (CJRFrequentOrderList) bVar.f64954b;
                if (cJRFrequentOrderList != null) {
                    this.this$0.f64700d = cJRFrequentOrderList;
                    AJRAutomaticUnSubscribedList.a(this.this$0);
                }
            }
        }
    }

    static final class d extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel>, x> {
        final /* synthetic */ AJRAutomaticUnSubscribedList this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList) {
            super(1);
            this.this$0 = aJRAutomaticUnSubscribedList;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel> bVar) {
            FrameLayout frameLayout;
            if (bVar != null) {
                int i2 = f.f64719b[bVar.f64955c.ordinal()];
                if (i2 == 1) {
                    FrameLayout frameLayout2 = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar);
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                    }
                } else if (i2 == 2) {
                    FrameLayout frameLayout3 = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar);
                    if (frameLayout3 != null) {
                        frameLayout3.setVisibility(8);
                    }
                } else if (i2 == 3 && (frameLayout = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar)) != null) {
                    frameLayout.setVisibility(8);
                }
                CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = (CJRAutomaticSubscriptionCheckModel) bVar.f64954b;
                if (cJRAutomaticSubscriptionCheckModel != null) {
                    AJRAutomaticUnSubscribedList.a(this.this$0, cJRAutomaticSubscriptionCheckModel);
                }
                NetworkCustomError networkCustomError = bVar.f64953a;
                if (networkCustomError == null) {
                    return;
                }
                if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                    net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this.this$0, networkCustomError, 1015);
                    return;
                }
                this.this$0.a();
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel;
        y<net.one97.paytm.recharge.presentation.g.b<CJRFrequentOrderList>> yVar;
        y<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticSubscriptionCheckModel>> yVar2;
        net.one97.paytm.recharge.presentation.g.a aVar;
        y<net.one97.paytm.recharge.presentation.g.b<CJRFrequentOrderList>> yVar3;
        super.onCreate(bundle);
        setContentView(R.layout.revamp_automatic_add_new_bill_recents);
        Intent intent = getIntent();
        net.one97.paytm.recharge.presentation.g.b bVar = null;
        if (intent == null || !intent.hasExtra("automatic_subscription_list")) {
            cJRAutomaticSubscriptionListModel = null;
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("automatic_subscription_list");
            if (!(serializableExtra instanceof CJRAutomaticSubscriptionListModel)) {
                serializableExtra = null;
            }
            cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) serializableExtra;
        }
        this.f64699c = cJRAutomaticSubscriptionListModel;
        Context context = this;
        if (com.paytm.utility.d.c(context)) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.b(true);
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.a((CharSequence) "");
            }
            this.f64698b = (net.one97.paytm.recharge.presentation.g.a) am.a((FragmentActivity) this, (al.b) new net.one97.paytm.recharge.presentation.e.a()).a(net.one97.paytm.recharge.presentation.g.a.class);
            net.one97.paytm.recharge.presentation.g.a aVar2 = this.f64698b;
            if (aVar2 != null) {
                yVar = aVar2.f64926c;
            } else {
                yVar = null;
            }
            net.one97.paytm.recharge.automatic.b.a.d.a(this, yVar, new c(this));
            net.one97.paytm.recharge.presentation.g.a aVar3 = this.f64698b;
            if (aVar3 != null) {
                yVar2 = aVar3.l;
            } else {
                yVar2 = null;
            }
            net.one97.paytm.recharge.automatic.b.a.d.a(this, yVar2, new d(this));
            TextView textView = (TextView) b(R.id.tv_know_more_id);
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            if (!com.paytm.network.b.b.a(context)) {
                c((int) SharedHomeVM.UPDATE_NON_RV_WIDGETS);
            } else {
                net.one97.paytm.recharge.presentation.g.a aVar4 = this.f64698b;
                if (!(aVar4 == null || (yVar3 = aVar4.f64926c) == null)) {
                    bVar = yVar3.getValue();
                }
                if (bVar == null && (aVar = this.f64698b) != null) {
                    aVar.a(context, this.f64699c);
                }
            }
            net.one97.paytm.recharge.automatic.c.a.a aVar5 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            a.C1160a aVar6 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, net.one97.paytm.recharge.automatic.b.a.a.U);
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        String str;
        String str2;
        Map<String, String> productAttributes;
        CJRFrequentOrderProduct frequentOrderProduct;
        String paytype;
        CJRFrequentOrderProduct frequentOrderProduct2;
        String service;
        Intent intent = new Intent(this, AJRAutomaticSetupActivity.class);
        intent.putExtra("selected_recent", this.f64701e);
        StringBuilder sb = new StringBuilder();
        CJRFrequentOrder cJRFrequentOrder = this.f64701e;
        String str3 = null;
        if (cJRFrequentOrder == null || (frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct()) == null || (service = frequentOrderProduct2.getService()) == null) {
            str = null;
        } else if (service != null) {
            str = service.toLowerCase();
            k.a((Object) str, "(this as java.lang.String).toLowerCase()");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        sb.append(str);
        sb.append("_");
        CJRFrequentOrder cJRFrequentOrder2 = this.f64701e;
        if (cJRFrequentOrder2 == null || (frequentOrderProduct = cJRFrequentOrder2.getFrequentOrderProduct()) == null || (paytype = frequentOrderProduct.getPaytype()) == null) {
            str2 = null;
        } else if (paytype != null) {
            str2 = paytype.toLowerCase();
            k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        sb.append(str2);
        intent.putExtra("service_paytype", sb.toString());
        CJRFrequentOrder cJRFrequentOrder3 = this.f64701e;
        if (!(cJRFrequentOrder3 == null || (productAttributes = cJRFrequentOrder3.getProductAttributes()) == null)) {
            str3 = productAttributes.get("is_bank_mandate_enabled");
        }
        intent.putExtra("is_bank_mandate_enabled", p.a("1", str3, true));
        startActivity(intent);
    }

    public static final class a extends BottomSheetBehavior.a {
        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
        }

        a() {
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        net.one97.paytm.recharge.presentation.g.a aVar = this.f64698b;
        if (aVar != null) {
            Context context = this;
            CJRFrequentOrder cJRFrequentOrder = this.f64701e;
            String rechargeNumber = cJRFrequentOrder != null ? cJRFrequentOrder.getRechargeNumber() : null;
            if (rechargeNumber == null) {
                k.a();
            }
            aVar.a(context, rechargeNumber);
        }
    }

    private final void c(int i2) {
        Context context = this;
        c.a aVar = new c.a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.no_internet_retry_dialog, (ViewGroup) null);
        aVar.a(inflate);
        aVar.a(false);
        View findViewById = inflate.findViewById(R.id.btn_back);
        View findViewById2 = inflate.findViewById(R.id.btn_retry);
        androidx.appcompat.app.c a2 = aVar.a();
        k.a((Object) a2, "dialogBuilder.create()");
        findViewById.setOnClickListener(new e(this, a2));
        findViewById2.setOnClickListener(new f(this, a2, i2));
        a2.show();
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticUnSubscribedList f64706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f64707b;

        e(AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList, androidx.appcompat.app.c cVar) {
            this.f64706a = aJRAutomaticUnSubscribedList;
            this.f64707b = cVar;
        }

        public final void onClick(View view) {
            this.f64707b.dismiss();
            this.f64706a.finish();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticUnSubscribedList f64708a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f64709b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f64710c;

        f(AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList, androidx.appcompat.app.c cVar, int i2) {
            this.f64708a = aJRAutomaticUnSubscribedList;
            this.f64709b = cVar;
            this.f64710c = i2;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.b.c((Context) this.f64708a)) {
                this.f64709b.dismiss();
                int i2 = this.f64710c;
                if (i2 == 1016) {
                    net.one97.paytm.recharge.presentation.g.a c2 = this.f64708a.f64698b;
                    if (c2 != null) {
                        AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList = this.f64708a;
                        c2.a((Context) aJRAutomaticUnSubscribedList, aJRAutomaticUnSubscribedList.f64699c);
                    }
                } else if (i2 == 1015) {
                    this.f64708a.b();
                }
            }
        }
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_know_more_id;
        if (valueOf != null && valueOf.intValue() == i2) {
            startActivity(new Intent(this, AJRAutomaticPaymentKnowMore.class));
            return;
        }
        int i3 = R.id.txt_view_all;
        if (valueOf != null && valueOf.intValue() == i3 && this.f64700d != null) {
            TextView textView = (TextView) b(R.id.txt_view_all);
            if (textView != null) {
                textView.setVisibility(8);
            }
            net.one97.paytm.recharge.presentation.a.d dVar = this.f64697a;
            if (dVar != null) {
                CJRFrequentOrderList cJRFrequentOrderList = this.f64700d;
                if (cJRFrequentOrderList == null) {
                    k.a();
                }
                List<CJRFrequentOrder> orderList = cJRFrequentOrderList.getOrderList();
                k.a((Object) orderList, "frequentOrderList!!.orderList");
                k.c(orderList, "allRecent");
                dVar.f64594b = orderList;
                dVar.f64593a = true;
                dVar.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i2) {
        if (i2 == -5) {
            try {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String h2 = net.one97.paytm.recharge.automatic.b.a.a.f60247i;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(this, a2, h2, "", net.one97.paytm.recharge.automatic.b.a.a.R, (Object) null, (Object) null, 96);
            } catch (Throwable unused) {
            }
            startActivity(new Intent(this, AJRAutomaticAddNewBillActivity.class));
            return;
        }
        CJRFrequentOrderList cJRFrequentOrderList = this.f64700d;
        if (cJRFrequentOrderList != null) {
            if (cJRFrequentOrderList == null) {
                k.a();
            }
            this.f64701e = cJRFrequentOrderList.getOrderList().get(i2);
            if (com.paytm.utility.b.c((Context) this)) {
                b();
            } else {
                c(1015);
            }
        }
        CJRFrequentOrder cJRFrequentOrder = this.f64701e;
        String str = "";
        if (cJRFrequentOrder != null) {
            try {
                if (cJRFrequentOrder.getFrequentOrderProduct() != null) {
                    CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
                    k.a((Object) frequentOrderProduct, "frequentOrder.frequentOrderProduct");
                    if (!TextUtils.isEmpty(frequentOrderProduct.getService())) {
                        CJRFrequentOrderProduct frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct();
                        k.a((Object) frequentOrderProduct2, "frequentOrder.frequentOrderProduct");
                        if (!TextUtils.isEmpty(frequentOrderProduct2.getPaytype())) {
                            StringBuilder sb = new StringBuilder();
                            CJRFrequentOrderProduct frequentOrderProduct3 = cJRFrequentOrder.getFrequentOrderProduct();
                            k.a((Object) frequentOrderProduct3, "frequentOrder.frequentOrderProduct");
                            String service = frequentOrderProduct3.getService();
                            k.a((Object) service, "frequentOrder.frequentOrderProduct.service");
                            if (service != null) {
                                String lowerCase = service.toLowerCase();
                                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                                sb.append(lowerCase);
                                sb.append("_");
                                CJRFrequentOrderProduct frequentOrderProduct4 = cJRFrequentOrder.getFrequentOrderProduct();
                                k.a((Object) frequentOrderProduct4, "frequentOrder.frequentOrderProduct");
                                String paytype = frequentOrderProduct4.getPaytype();
                                k.a((Object) paytype, "frequentOrder.frequentOrderProduct.paytype");
                                if (paytype != null) {
                                    String lowerCase2 = paytype.toLowerCase();
                                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                    sb.append(lowerCase2);
                                    str = sb.toString();
                                } else {
                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
                return;
            }
        }
        net.one97.paytm.recharge.automatic.c.a.a aVar5 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
        a.C1160a aVar6 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        String a3 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
        a.C1160a aVar7 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        net.one97.paytm.recharge.automatic.c.a.a.a(this, a3, net.one97.paytm.recharge.automatic.b.a.a.f60246h, "", str, (Object) null, (Object) null, 96);
    }

    public static final /* synthetic */ void a(AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList) {
        List<CJRFrequentOrder> orderList;
        CJRFrequentOrderList cJRFrequentOrderList = aJRAutomaticUnSubscribedList.f64700d;
        if (cJRFrequentOrderList == null || (orderList = cJRFrequentOrderList.getOrderList()) == null || !(!orderList.isEmpty())) {
            aJRAutomaticUnSubscribedList.startActivity(new Intent(aJRAutomaticUnSubscribedList, AJRAutomaticAddNewBillActivity.class));
            aJRAutomaticUnSubscribedList.finish();
            return;
        }
        CJRFrequentOrderList cJRFrequentOrderList2 = aJRAutomaticUnSubscribedList.f64700d;
        if (cJRFrequentOrderList2 == null) {
            k.a();
        }
        if (cJRFrequentOrderList2.getOrderList().size() > 3) {
            TextView textView = (TextView) aJRAutomaticUnSubscribedList.b(R.id.txt_view_all);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) aJRAutomaticUnSubscribedList.b(R.id.txt_view_all);
            if (textView2 != null) {
                textView2.setOnClickListener(aJRAutomaticUnSubscribedList);
            }
        }
        CJRFrequentOrderList cJRFrequentOrderList3 = aJRAutomaticUnSubscribedList.f64700d;
        if (cJRFrequentOrderList3 == null) {
            k.a();
        }
        List<CJRFrequentOrder> orderList2 = cJRFrequentOrderList3.getOrderList();
        k.a((Object) orderList2, "frequentOrderList!!.orderList");
        aJRAutomaticUnSubscribedList.f64697a = new net.one97.paytm.recharge.presentation.a.d(orderList2, aJRAutomaticUnSubscribedList);
        RecyclerView recyclerView = (RecyclerView) aJRAutomaticUnSubscribedList.b(R.id.rv_add_new_bill);
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        RecyclerView recyclerView2 = (RecyclerView) aJRAutomaticUnSubscribedList.b(R.id.rv_add_new_bill);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(aJRAutomaticUnSubscribedList, 1, false));
        }
        RecyclerView recyclerView3 = (RecyclerView) aJRAutomaticUnSubscribedList.b(R.id.rv_add_new_bill);
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new g(aJRAutomaticUnSubscribedList, 68));
        }
        RecyclerView recyclerView4 = (RecyclerView) aJRAutomaticUnSubscribedList.b(R.id.rv_add_new_bill);
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(aJRAutomaticUnSubscribedList.f64697a);
        }
    }

    public static final /* synthetic */ void a(AJRAutomaticUnSubscribedList aJRAutomaticUnSubscribedList, CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel) {
        Integer status = cJRAutomaticSubscriptionCheckModel.getStatus();
        int i2 = aJRAutomaticUnSubscribedList.f64702f;
        if (status != null && status.intValue() == i2) {
            a.C1278a aVar = net.one97.paytm.recharge.presentation.c.a.f64795a;
            String string = aJRAutomaticUnSubscribedList.getString(R.string.automatic_already_set);
            k.a((Object) string, "getString(R.string.automatic_already_set)");
            String string2 = aJRAutomaticUnSubscribedList.getString(R.string.available_subscribed_by_someone_else);
            k.a((Object) string2, "getString(R.string.avail…bscribed_by_someone_else)");
            String string3 = aJRAutomaticUnSubscribedList.getString(R.string.ok_re);
            k.a((Object) string3, "getString(R.string.ok_re)");
            a.C1278a.a(aJRAutomaticUnSubscribedList, string, string2, string3, b.f64705a, aJRAutomaticUnSubscribedList.f64703g).show(aJRAutomaticUnSubscribedList.getSupportFragmentManager(), net.one97.paytm.recharge.presentation.c.a.class.getSimpleName());
            return;
        }
        aJRAutomaticUnSubscribedList.a();
    }
}
