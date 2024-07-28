package net.one97.paytm.vipcashback.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.common.entity.vipcashback.CashBackNewOfferModal;
import net.one97.paytm.common.entity.vipcashback.CashbackPreferenceUtility;
import net.one97.paytm.common.entity.vipcashback.MerchantCashBackMyOfferModel;
import net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer;
import net.one97.paytm.common.entity.vipcashback.MerchantGameItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.a.d;
import net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.c;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.f.f;
import net.one97.paytm.vipcashback.f.h;
import net.one97.paytm.vipcashback.fragment.a;
import net.one97.paytm.vipcashback.widget.WrapContentLinearLayoutManager;

public final class c extends a implements com.paytm.network.listener.b {

    /* renamed from: h  reason: collision with root package name */
    public static final a f20931h = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.vipcashback.g.b f20932i;
    private boolean j;
    private net.one97.paytm.vipcashback.a.d k;
    private net.one97.paytm.vipcashback.d.a l;
    private ArrayList<MerchantGameItem> m;
    /* access modifiers changed from: private */
    public Handler n;
    private boolean o;
    private HashMap p;

    public final View a(int i2) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.p.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final /* synthetic */ net.one97.paytm.vipcashback.a.d b(c cVar) {
        net.one97.paytm.vipcashback.a.d dVar = cVar.k;
        if (dVar == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        return dVar;
    }

    public static final /* synthetic */ net.one97.paytm.vipcashback.d.a d(c cVar) {
        net.one97.paytm.vipcashback.d.a aVar = cVar.l;
        if (aVar == null) {
            k.a("myOfferVIPCashbackDataModel");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        a.f20912f = arguments != null ? arguments.getBoolean("KEY_IS_FROM_DRAWER") : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z = arguments2.getBoolean("LOAD_ON_CREATE_DATA");
        }
        this.f20916c = z;
        Bundle arguments3 = getArguments();
        this.f20918e = arguments3 != null ? arguments3.getString("OFFER_TAG") : null;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_merchant_cashback, (ViewGroup) null, false);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        Application application;
        this.l = new net.one97.paytm.vipcashback.d.a(true);
        this.m = new ArrayList<>();
        this.n = new Handler();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (application = activity.getApplication()) == null)) {
            this.f20932i = (net.one97.paytm.vipcashback.g.b) am.a((Fragment) this, (al.b) new net.one97.paytm.vipcashback.g.a(application, new String[0])).a(net.one97.paytm.vipcashback.g.b.class);
        }
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(this.f20915b);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_offers);
        k.a((Object) recyclerView, "rv_offers");
        recyclerView.setLayoutManager(wrapContentLinearLayoutManager);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_offers);
        Context context = this.f20915b;
        if (context == null) {
            k.a();
        }
        Drawable a2 = androidx.core.content.b.a(context, net.one97.paytm.common.widgets.R.drawable.divider);
        if (a2 == null) {
            k.a();
        }
        k.a((Object) a2, "ContextCompat.getDrawabl…vider\n                )!!");
        recyclerView2.addItemDecoration(new net.one97.paytm.vipcashback.widget.a(a2, (byte) 0));
        Context context2 = this.f20915b;
        if (context2 == null) {
            k.a();
        }
        d.c cVar = new C0404c(this);
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rv_offers);
        k.a((Object) recyclerView3, "rv_offers");
        ArrayList<MerchantGameItem> arrayList = this.m;
        if (arrayList == null) {
            k.a("mMerchantGameArrayList");
        }
        this.k = new net.one97.paytm.vipcashback.a.d(context2, cVar, recyclerView3, arrayList, a.f20912f, this.f20918e, this.f20916c);
        RecyclerView recyclerView4 = (RecyclerView) a(R.id.rv_offers);
        k.a((Object) recyclerView4, "rv_offers");
        net.one97.paytm.vipcashback.a.d dVar = this.k;
        if (dVar == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        recyclerView4.setAdapter(dVar);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) a(R.id.swipeRefresh);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(net.one97.paytm.common.assets.R.color.paytm_blue);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) a(R.id.swipeRefresh);
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setOnRefreshListener(new d(this));
        }
        SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) a(R.id.swipeRefresh);
        if (swipeRefreshLayout3 != null) {
            swipeRefreshLayout3.setEnabled(true);
        }
        b(false);
        if (!TextUtils.isEmpty(this.f20918e)) {
            a(true);
        } else if (this.f20916c && !this.j) {
            a(true);
            this.j = true;
        }
        ((RecyclerView) a(R.id.rv_offers)).addOnScrollListener(new e(this, wrapContentLinearLayoutManager, (TextView) a(R.id.fake_header_view).findViewById(R.id.tv_heading)));
    }

    /* renamed from: net.one97.paytm.vipcashback.fragment.c$c  reason: collision with other inner class name */
    public static final class C0404c implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20933a;

        /* renamed from: net.one97.paytm.vipcashback.fragment.c$c$a */
        static final class a<T> implements z<h<Object>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0404c f20934a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f20935b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ MerchantGameItem f20936c;

            a(C0404c cVar, int i2, MerchantGameItem merchantGameItem) {
                this.f20934a = cVar;
                this.f20935b = i2;
                this.f20936c = merchantGameItem;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                h hVar = (h) obj;
                if (hVar != null && hVar.f20893a == 104) {
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    Context context = this.f20934a.f20933a.getContext();
                    if (context == null) {
                        k.a();
                    }
                    k.a((Object) context, "context!!");
                    T t = hVar.f20894b;
                    if (t != null) {
                        d.a.a(context, (com.paytm.network.a) t, false);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.CJRCommonNetworkCall");
                } else if (hVar != null && hVar.f20893a == 101) {
                    T t2 = hVar.f20894b;
                    if (t2 instanceof MerchantCashBackMyOfferModel) {
                        MerchantCashBackMyOfferModel merchantCashBackMyOfferModel = (MerchantCashBackMyOfferModel) t2;
                        if (merchantCashBackMyOfferModel.getStatus() == 1 && merchantCashBackMyOfferModel.getData() != null) {
                            net.one97.paytm.vipcashback.a.d b2 = c.b(this.f20934a.f20933a);
                            int i2 = this.f20935b;
                            MerchantGameItem data = merchantCashBackMyOfferModel.getData();
                            k.a((Object) data, "response.data");
                            k.c(data, "offer");
                            int i3 = i2 - b2.f20588a;
                            if (i3 >= 0 && b2.o.size() > i3) {
                                b2.o.set(i3, data);
                                b2.notifyItemChanged(i2);
                            }
                        }
                    }
                } else if (hVar == null || hVar.f20893a != 103) {
                    MerchantGameItem merchantGameItem = this.f20936c;
                    a.i.C0390a aVar2 = a.i.f20808a;
                    merchantGameItem.setGameStatus(a.i.f20810c);
                    net.one97.paytm.vipcashback.a.d b3 = c.b(this.f20934a.f20933a);
                    if (b3 != null) {
                        b3.notifyItemChanged(this.f20935b);
                    }
                    d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
                    Throwable th = hVar != null ? hVar.f20895c : null;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        FragmentActivity activity = this.f20934a.f20933a.getActivity();
                        if (activity != null) {
                            d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) activity, Boolean.FALSE, 8);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                } else {
                    MerchantGameItem merchantGameItem2 = this.f20936c;
                    a.i.C0390a aVar4 = a.i.f20808a;
                    merchantGameItem2.setGameStatus(a.i.f20811d);
                    net.one97.paytm.vipcashback.a.d b4 = c.b(this.f20934a.f20933a);
                    if (b4 != null) {
                        b4.notifyItemChanged(this.f20935b);
                    }
                }
            }
        }

        C0404c(c cVar) {
            this.f20933a = cVar;
        }

        public final void a(int i2, MerchantGameItem merchantGameItem) {
            k.c(merchantGameItem, "merchantGameItem");
            new ArrayList();
            net.one97.paytm.vipcashback.g.b a2 = this.f20933a.f20932i;
            if (a2 != null) {
                a2.a(merchantGameItem).observe(this.f20933a, new a(this, i2, merchantGameItem));
            }
        }

        public final void a(MerchantGameItem merchantGameItem, String str, View view, String str2) {
            k.c(merchantGameItem, "merchantGameItem");
            k.c(str, "action");
            k.c(view, "transitionView");
            k.c(str2, "string");
            c.a(this.f20933a, merchantGameItem, str, view, str2);
        }

        public final void a(int i2) {
            Handler c2 = this.f20933a.n;
            if (c2 != null) {
                c2.postDelayed(new b(this, i2), 500);
            }
        }

        /* renamed from: net.one97.paytm.vipcashback.fragment.c$c$b */
        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0404c f20937a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f20938b;

            b(C0404c cVar, int i2) {
                this.f20937a = cVar;
                this.f20938b = i2;
            }

            public final void run() {
                RecyclerView.v findViewHolderForAdapterPosition;
                View view;
                RecyclerView recyclerView = (RecyclerView) this.f20937a.f20933a.a(R.id.rv_offers);
                if (recyclerView != null && (findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(this.f20938b)) != null && (view = findViewHolderForAdapterPosition.itemView) != null) {
                    view.performClick();
                }
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            k.c(networkCustomError, "error");
            a.C0402a aVar = a.f20913g;
            if (!a.f20912f) {
                this.f20933a.a(networkCustomError);
            }
        }

        public final void a(View view, int i2) {
            Campaign campaign;
            k.c(view, "view");
            net.one97.paytm.vipcashback.a.d b2 = c.b(this.f20933a);
            MerchantGameItem merchantGameItem = (i2 < 0 || i2 >= b2.getItemCount()) ? null : b2.o.get(i2);
            if (!(merchantGameItem == null || (campaign = merchantGameItem.getCampaign()) == null)) {
                campaign.setMyOffersListPosition(i2);
            }
            c cVar = this.f20933a;
            MerchantCashbackOfferDetailActivity.a aVar = MerchantCashbackOfferDetailActivity.f20667a;
            String b3 = MerchantCashbackOfferDetailActivity.J;
            String string = this.f20933a.getString(R.string.transition_cashback_icon);
            k.a((Object) string, "getString(R.string.transition_cashback_icon)");
            c.a(cVar, merchantGameItem, b3, view, string);
        }

        public final void a() {
            c.b(this.f20933a).j = true;
            c.d(this.f20933a).f20767i = 1;
            c cVar = this.f20933a;
            cVar.a(cVar.f20918e);
        }

        public final void a(boolean z) {
            if (z) {
                net.one97.paytm.vipcashback.c.a a2 = net.one97.paytm.vipcashback.c.a.a();
                k.a((Object) a2, "CashbackHelper.getInstance()");
                if ("paytm".equals(a2.c())) {
                    if (!z) {
                        c.a aVar = net.one97.paytm.vipcashback.f.c.f20856a;
                        d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                        int i2 = Calendar.getInstance().get(6);
                        CashbackPreferenceUtility.Companion companion = CashbackPreferenceUtility.Companion;
                        net.one97.paytm.vipcashback.c.b b2 = net.one97.paytm.vipcashback.c.a.b();
                        k.a((Object) b2, "CashbackHelper.getImplListener()");
                        Context applicationContext = b2.getApplicationContext();
                        k.a((Object) applicationContext, "CashbackHelper.getImplLi…ener().applicationContext");
                        companion.getPref(applicationContext).a(net.one97.paytm.vipcashback.f.c.f20858c, i2, false);
                    }
                    this.f20933a.b(true);
                    return;
                }
                this.f20933a.b(true);
                return;
            }
            View a3 = this.f20933a.a(R.id.layoutNoData);
            k.a((Object) a3, "layoutNoData");
            a3.setVisibility(0);
            View findViewById = this.f20933a.a(R.id.layoutNoData).findViewById(R.id.noOfferTV);
            k.a((Object) findViewById, "layoutNoData.findViewByI…TextView>(R.id.noOfferTV)");
            ((TextView) findViewById).setText(this.f20933a.getString(R.string.no_active_offers));
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20933a.a(R.id.loader));
            RecyclerView recyclerView = (RecyclerView) this.f20933a.a(R.id.rv_offers);
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        }
    }

    static final class d implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20939a;

        d(c cVar) {
            this.f20939a = cVar;
        }

        public final void onRefresh() {
            this.f20939a.a(false);
        }
    }

    public static final class e extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20940a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WrapContentLinearLayoutManager f20941b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f20942c;

        e(c cVar, WrapContentLinearLayoutManager wrapContentLinearLayoutManager, TextView textView) {
            this.f20940a = cVar;
            this.f20941b = wrapContentLinearLayoutManager;
            this.f20942c = textView;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            int findFirstCompletelyVisibleItemPosition = this.f20941b.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition > 0) {
                View a2 = this.f20940a.a(R.id.fake_header_view);
                k.a((Object) a2, "fake_header_view");
                a2.setVisibility(0);
                if (findFirstCompletelyVisibleItemPosition >= c.b(this.f20940a).f20588a) {
                    TextView textView = this.f20942c;
                    k.a((Object) textView, "tv_heading");
                    textView.setText(this.f20940a.getString(R.string.cashback_active_heading));
                    return;
                }
                TextView textView2 = this.f20942c;
                k.a((Object) textView2, "tv_heading");
                textView2.setText(this.f20940a.getString(R.string.cashback_new_heading));
                return;
            }
            View a3 = this.f20940a.a(R.id.fake_header_view);
            k.a((Object) a3, "fake_header_view");
            a3.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public final void b(boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.loader));
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_offers);
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            View a2 = a(R.id.fake_header_view);
            if (a2 != null) {
                a2.setVisibility(8);
                return;
            }
            return;
        }
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.loader));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_offers);
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(4);
        }
        View a3 = a(R.id.fake_header_view);
        if (a3 != null) {
            a3.setVisibility(8);
        }
    }

    private final void a(Integer num, Intent intent, Bundle bundle) {
        if (num != null) {
            startActivityForResult(intent, num.intValue(), bundle);
        } else {
            startActivity(intent, bundle);
        }
    }

    public final void b() {
        if (!this.j) {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        net.one97.paytm.vipcashback.a.d dVar = this.k;
        if (dVar == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        dVar.j = false;
        net.one97.paytm.vipcashback.a.d dVar2 = this.k;
        if (dVar2 == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        dVar2.k = false;
        net.one97.paytm.vipcashback.a.d dVar3 = this.k;
        if (dVar3 == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        dVar3.e();
        net.one97.paytm.vipcashback.a.d dVar4 = this.k;
        if (dVar4 == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        dVar4.notifyDataSetChanged();
        net.one97.paytm.vipcashback.a.d dVar5 = this.k;
        if (dVar5 == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        dVar5.a(z);
        a(z, this.f20918e, true);
    }

    /* access modifiers changed from: private */
    public final void a(boolean z, String str, boolean z2) {
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        View view = getView();
        if (view != null) {
            d.a.a((ViewGroup) view);
            net.one97.paytm.vipcashback.d.a aVar2 = this.l;
            if (aVar2 == null) {
                k.a("myOfferVIPCashbackDataModel");
            }
            String str2 = this.f20914a;
            k.a((Object) str2, "TAG");
            com.paytm.network.a a2 = aVar2.a(this, str, str2, z2);
            if (com.paytm.utility.b.c(this.f20915b)) {
                if (z) {
                    e();
                }
                a(R.id.swipeRefresh);
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) a(R.id.swipeRefresh);
                k.a((Object) swipeRefreshLayout, "swipeRefresh");
                if (!swipeRefreshLayout.b()) {
                    SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) a(R.id.swipeRefresh);
                    k.a((Object) swipeRefreshLayout2, "swipeRefresh");
                    swipeRefreshLayout2.setEnabled(false);
                }
                a2.a();
                return;
            }
            f();
            d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            View view2 = getView();
            if (view2 != null) {
                d.a.a(context, (ViewGroup) view2, a2);
                net.one97.paytm.vipcashback.a.d dVar = this.k;
                if (dVar == null) {
                    k.a("mMerchantCashbackOffersListAdapter");
                }
                dVar.l = true;
                net.one97.paytm.vipcashback.a.d dVar2 = this.k;
                if (dVar2 == null) {
                    k.a("mMerchantCashbackOffersListAdapter");
                }
                dVar2.notifyDataSetChanged();
                b(true);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.ViewGroup");
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        net.one97.paytm.vipcashback.d.a aVar = this.l;
        if (aVar == null) {
            k.a("myOfferVIPCashbackDataModel");
        }
        com.paytm.network.listener.b bVar = this;
        String str2 = this.f20914a;
        k.a((Object) str2, "TAG");
        k.c(bVar, "apiListener");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.a((Object) f.a(), "GTMHelper.getInstance()");
        String i2 = f.i();
        k.a((Object) i2, "GTMHelper.getInstance().merchantCashbackGameList");
        IJRPaytmDataModel merchantCashbackOffer = new MerchantCashbackOffer();
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("?");
        sb.append(aVar.f20760b);
        sb.append("=");
        a.i.C0390a aVar2 = a.i.f20808a;
        sb.append(a.i.f20816i);
        sb.append(AppConstants.COMMA);
        a.i.C0390a aVar3 = a.i.f20808a;
        sb.append(a.i.j);
        sb.append(AppConstants.COMMA);
        a.i.C0390a aVar4 = a.i.f20808a;
        sb.append(a.i.k);
        sb.append(AppConstants.COMMA);
        a.i.C0390a aVar5 = a.i.f20808a;
        sb.append(a.i.m);
        sb.append(AppConstants.COMMA);
        a.i.C0390a aVar6 = a.i.f20808a;
        sb.append(a.i.l);
        sb.append(AppConstants.AND_SIGN);
        sb.append(aVar.f20762d);
        sb.append("=");
        sb.append(aVar.f20767i);
        sb.append(AppConstants.AND_SIGN);
        sb.append(aVar.f20763e);
        sb.append("=20");
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(AppConstants.AND_SIGN);
            sb3.append(aVar.f20764f);
            sb3.append("=");
            String encode = URLEncoder.encode(str, AppConstants.UTF_8);
            k.a((Object) encode, "URLEncoder.encode(offersTag, \"UTF-8\")");
            sb3.append(p.a(encode, "+", "%20", false));
            sb2 = sb3.toString();
        }
        d.a aVar7 = net.one97.paytm.vipcashback.f.d.f20859a;
        com.paytm.network.a l2 = d.a.c().a(a.C0715a.GET).a(sb2).a((Map<String, String>) net.one97.paytm.vipcashback.d.a.a()).a(merchantCashbackOffer).c(str2).a(bVar).l();
        k.a((Object) l2, "networkCall");
        if (com.paytm.utility.b.c(this.f20915b)) {
            e();
            l2.a();
            return;
        }
        f();
        a(l2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0134  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r14) {
        /*
            r13 = this;
            boolean r0 = r13.isAdded()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r13.f()
            r0 = 1
            java.lang.String r1 = "mMerchantCashbackOffersListAdapter"
            if (r14 == 0) goto L_0x01bd
            boolean r2 = r14 instanceof net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer
            if (r2 == 0) goto L_0x01bd
            net.one97.paytm.vipcashback.a.d r2 = r13.k
            if (r2 != 0) goto L_0x001a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001a:
            r3 = 0
            r2.l = r3
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer r14 = (net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer) r14
            int r2 = r14.getStatus()
            if (r2 != r0) goto L_0x017f
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer$Data r2 = r14.getData()
            if (r2 == 0) goto L_0x017f
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer$Data r2 = r14.getData()
            boolean r2 = r2.hasExpiredOffers()
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer$Data r4 = r14.getData()
            r5 = 0
            if (r4 == 0) goto L_0x003f
            java.util.ArrayList r4 = r4.getSupercashList()
            goto L_0x0040
        L_0x003f:
            r4 = r5
        L_0x0040:
            java.lang.String r6 = "response.data"
            java.lang.String r7 = "myOfferVIPCashbackDataModel"
            if (r4 == 0) goto L_0x00bc
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer$Data r4 = r14.getData()
            if (r4 == 0) goto L_0x005b
            java.util.ArrayList r4 = r4.getSupercashList()
            if (r4 == 0) goto L_0x005b
            boolean r4 = r4.isEmpty()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x005c
        L_0x005b:
            r4 = r5
        L_0x005c:
            if (r4 != 0) goto L_0x0061
            kotlin.g.b.k.a()
        L_0x0061:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x00bc
            net.one97.paytm.vipcashback.a.d r4 = r13.k
            if (r4 != 0) goto L_0x006e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006e:
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer$Data r8 = r14.getData()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.util.ArrayList r8 = r8.getSupercashList()
            java.lang.String r9 = "response.data.supercashList"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r9 = "newData"
            kotlin.g.b.k.c(r8, r9)
            net.one97.paytm.vipcashback.a.d$c r9 = r4.n
            if (r9 == 0) goto L_0x008a
            r9.a((boolean) r0)
        L_0x008a:
            java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.MerchantGameItem> r9 = r4.o
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r8 = r8.iterator()
        L_0x0099:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto L_0x00b1
            java.lang.Object r11 = r8.next()
            r12 = r11
            net.one97.paytm.common.entity.vipcashback.MerchantGameItem r12 = (net.one97.paytm.common.entity.vipcashback.MerchantGameItem) r12
            if (r12 == 0) goto L_0x00aa
            r12 = 1
            goto L_0x00ab
        L_0x00aa:
            r12 = 0
        L_0x00ab:
            if (r12 == 0) goto L_0x0099
            r10.add(r11)
            goto L_0x0099
        L_0x00b1:
            java.util.List r10 = (java.util.List) r10
            java.util.Collection r10 = (java.util.Collection) r10
            r9.addAll(r10)
            r4.notifyDataSetChanged()
            goto L_0x0103
        L_0x00bc:
            net.one97.paytm.vipcashback.a.d r3 = r13.k
            if (r3 != 0) goto L_0x00c3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00c3:
            boolean r3 = r3.j
            if (r3 != 0) goto L_0x00f9
            net.one97.paytm.vipcashback.a.d r3 = r13.k
            if (r3 != 0) goto L_0x00ce
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00ce:
            r3.c()
            if (r2 != 0) goto L_0x00dd
            net.one97.paytm.vipcashback.a.d r3 = r13.k
            if (r3 != 0) goto L_0x00da
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00da:
            r3.d()
        L_0x00dd:
            net.one97.paytm.vipcashback.d.a r3 = r13.l
            if (r3 != 0) goto L_0x00e4
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x00e4:
            int r3 = r3.f20766h
            if (r3 != r0) goto L_0x0103
            if (r2 == 0) goto L_0x0103
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x00f1
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00f1:
            r14.j = r0
            java.lang.String r14 = r13.f20918e
            r13.a((java.lang.String) r14)
            return
        L_0x00f9:
            net.one97.paytm.vipcashback.a.d r3 = r13.k
            if (r3 != 0) goto L_0x0100
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0100:
            r3.d()
        L_0x0103:
            net.one97.paytm.vipcashback.a.d r3 = r13.k
            if (r3 != 0) goto L_0x010a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x010a:
            boolean r3 = r3.j
            if (r3 == 0) goto L_0x011b
            net.one97.paytm.vipcashback.d.a r3 = r13.l
            if (r3 != 0) goto L_0x0115
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0115:
            int r4 = r3.f20767i
            int r4 = r4 + r0
            r3.f20767i = r4
            goto L_0x0127
        L_0x011b:
            net.one97.paytm.vipcashback.d.a r3 = r13.l
            if (r3 != 0) goto L_0x0122
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0122:
            int r4 = r3.f20766h
            int r4 = r4 + r0
            r3.f20766h = r4
        L_0x0127:
            net.one97.paytm.common.entity.vipcashback.MerchantCashbackOffer$Data r14 = r14.getData()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            boolean r14 = r14.isNext()
            if (r14 != 0) goto L_0x016d
            if (r2 == 0) goto L_0x0162
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x013d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x013d:
            boolean r14 = r14.j
            if (r14 != 0) goto L_0x0162
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x0148
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0148:
            r14.k = r0
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x0151
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0151:
            net.one97.paytm.vipcashback.a.d r2 = r13.k
            if (r2 != 0) goto L_0x0158
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0158:
            int r1 = r2.getItemCount()
            int r1 = r1 - r0
            r14.notifyItemInserted(r1)
            goto L_0x01d1
        L_0x0162:
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x0169
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0169:
            r14.a((kotlin.g.a.a<kotlin.x>) r5)
            goto L_0x01d1
        L_0x016d:
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x0174
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0174:
            net.one97.paytm.vipcashback.fragment.c$b r1 = new net.one97.paytm.vipcashback.fragment.c$b
            r1.<init>(r13)
            kotlin.g.a.a r1 = (kotlin.g.a.a) r1
            r14.a((kotlin.g.a.a<kotlin.x>) r1)
            goto L_0x01d1
        L_0x017f:
            java.util.ArrayList r2 = r14.getErrors()
            if (r2 == 0) goto L_0x01a8
            java.util.ArrayList r2 = r14.getErrors()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x01a8
            net.one97.paytm.vipcashback.f.d$a r1 = net.one97.paytm.vipcashback.f.d.f20859a
            java.util.ArrayList r14 = r14.getErrors()
            java.lang.Object r14 = r14.get(r3)
            java.lang.String r1 = "response.errors[0]"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal r14 = (net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r14
            com.paytm.network.model.NetworkCustomError r14 = net.one97.paytm.vipcashback.f.d.a.a((net.one97.paytm.cashback.posttxn.GetVIPCashBackErrorModal) r14)
            r13.a((com.paytm.network.model.NetworkCustomError) r14)
            goto L_0x01d1
        L_0x01a8:
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x01af
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01af:
            r14.c()
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x01b9
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01b9:
            r14.d()
            goto L_0x01d1
        L_0x01bd:
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x01c4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01c4:
            r14.c()
            net.one97.paytm.vipcashback.a.d r14 = r13.k
            if (r14 != 0) goto L_0x01ce
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01ce:
            r14.d()
        L_0x01d1:
            int r14 = net.one97.paytm.vipcashback.R.id.swipeRefresh
            android.view.View r14 = r13.a((int) r14)
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r14 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r14
            if (r14 == 0) goto L_0x01de
            r14.setEnabled(r0)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.c.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "p2");
        f();
        if (!a.f20912f) {
            a(networkCustomError);
        }
    }

    private void e() {
        net.one97.paytm.vipcashback.a.d dVar = this.k;
        if (dVar == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        dVar.b();
    }

    private void f() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) a(R.id.swipeRefresh);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        net.one97.paytm.vipcashback.a.d dVar = this.k;
        if (dVar == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        net.one97.paytm.vipcashback.a.b.a((net.one97.paytm.vipcashback.a.b) dVar);
    }

    static final class b extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar) {
            super(0);
            this.this$0 = cVar;
        }

        public final void invoke() {
            if (c.b(this.this$0).j) {
                c cVar = this.this$0;
                cVar.a(cVar.f20918e);
            } else if (!c.b(this.this$0).k) {
                c cVar2 = this.this$0;
                cVar2.a(true, cVar2.f20918e, false);
            }
        }
    }

    public final void onDestroyView() {
        net.one97.paytm.vipcashback.a.d dVar = this.k;
        if (dVar == null) {
            k.a("mMerchantCashbackOffersListAdapter");
        }
        net.one97.paytm.vipcashback.e.b bVar = dVar.f20590h;
        if (bVar != null) {
            bVar.f20840e = null;
        }
        dVar.n = null;
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        super.onDestroyView();
        d();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<CashBackNewOfferModal> arrayList;
        super.onActivityResult(i2, i3, intent);
        Serializable serializable = null;
        if (i2 == 1) {
            MerchantCashbackOfferDetailActivity.a aVar = MerchantCashbackOfferDetailActivity.f20667a;
            if (i3 == MerchantCashbackOfferDetailActivity.K) {
                if (intent != null) {
                    serializable = intent.getSerializableExtra("offer");
                }
                if (serializable != null) {
                    MerchantGameItem merchantGameItem = (MerchantGameItem) serializable;
                    net.one97.paytm.vipcashback.a.d dVar = this.k;
                    if (dVar == null) {
                        k.a("mMerchantCashbackOffersListAdapter");
                    }
                    k.c(merchantGameItem, "merchantGameItem");
                    net.one97.paytm.vipcashback.e.b bVar = dVar.f20590h;
                    if (!(bVar == null || (arrayList = bVar.f20836a) == null)) {
                        Campaign campaign = merchantGameItem.getCampaign();
                        k.a((Object) campaign, "merchantGameItem.campaign");
                        arrayList.remove(campaign.getNewOffersListPosition());
                    }
                    net.one97.paytm.vipcashback.a.a aVar2 = dVar.f20589b;
                    if (aVar2 != null) {
                        aVar2.notifyDataSetChanged();
                    }
                    net.one97.paytm.vipcashback.e.b bVar2 = dVar.f20590h;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    dVar.o.add(0, merchantGameItem);
                    dVar.notifyItemInserted(dVar.f20588a + 0);
                    dVar.c();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.MerchantGameItem");
            }
        }
        if (i2 == 2) {
            MerchantCashbackOfferDetailActivity.a aVar3 = MerchantCashbackOfferDetailActivity.f20667a;
            if (i3 == MerchantCashbackOfferDetailActivity.K) {
                if (intent != null) {
                    serializable = intent.getSerializableExtra("offer");
                }
                if (serializable != null) {
                    MerchantGameItem merchantGameItem2 = (MerchantGameItem) serializable;
                    net.one97.paytm.vipcashback.a.d dVar2 = this.k;
                    if (dVar2 == null) {
                        k.a("mMerchantCashbackOffersListAdapter");
                    }
                    Campaign campaign2 = merchantGameItem2.getCampaign();
                    k.a((Object) campaign2, "merchantGameItem.campaign");
                    int myOffersListPosition = campaign2.getMyOffersListPosition();
                    k.c(merchantGameItem2, "offer");
                    if (myOffersListPosition >= 0 && dVar2.o.size() > myOffersListPosition) {
                        dVar2.o.set(myOffersListPosition, merchantGameItem2);
                        dVar2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.vipcashback.MerchantGameItem");
            }
        }
    }

    public final void onResume() {
        super.onResume();
        if (!this.o) {
            net.one97.paytm.vipcashback.c.a.b().sendOpenScreenWithDeviceInfo("/cashback-offers/merchant", "cashback", this.f20917d);
            this.o = true;
        }
    }

    public static final /* synthetic */ void a(c cVar, MerchantGameItem merchantGameItem, String str, View view, String str2) {
        int i2;
        Intent intent = new Intent(cVar.getActivity(), MerchantCashbackOfferDetailActivity.class);
        intent.putExtra("offer", merchantGameItem);
        intent.putExtra("IS_FROM_DRAWER", a.f20912f);
        intent.putExtra("action", str);
        MerchantCashbackOfferDetailActivity.a aVar = MerchantCashbackOfferDetailActivity.f20667a;
        if (k.a((Object) str, (Object) MerchantCashbackOfferDetailActivity.I)) {
            i2 = 1;
        } else {
            a.i.C0390a aVar2 = a.i.f20808a;
            i2 = a.i.f20810c.equals(merchantGameItem != null ? merchantGameItem.getGameStatus() : null) ? 2 : null;
        }
        if (view != null && !TextUtils.isEmpty(str2)) {
            Context context = cVar.f20915b;
            if (context != null) {
                androidx.core.app.b a2 = androidx.core.app.b.a((Activity) context, view, str2);
                k.a((Object) a2, "ActivityOptionsCompat.ma…tion_string\n            )");
                try {
                    cVar.a(i2, intent, a2.a());
                    return;
                } catch (Exception unused) {
                }
            } else {
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }
        cVar.a(i2, intent, (Bundle) null);
    }
}
