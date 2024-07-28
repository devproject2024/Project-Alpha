package net.one97.paytm.v2.features.cashbackoffers.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.d.f;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.x;
import kotlin.g.b.y;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public class a extends net.one97.paytm.i.h implements SwipeRefreshLayout.b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f20400a;

    /* renamed from: i  reason: collision with root package name */
    public static final b f20401i = new b((byte) 0);
    private final kotlin.g A = kotlin.h.a(new u(this));
    /* access modifiers changed from: private */
    public net.one97.paytm.v2.features.b.c.a B;
    /* access modifiers changed from: private */
    public kotlin.g.a.b<? super ScratchCard, x> C;
    private HashMap D;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.v2.features.cashbacklanding.c.b f20402b;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.v2.features.cashbackoffers.c.a f20403c;

    /* renamed from: d  reason: collision with root package name */
    int f20404d = 5;

    /* renamed from: e  reason: collision with root package name */
    String f20405e = "";

    /* renamed from: f  reason: collision with root package name */
    RecyclerView.l f20406f;

    /* renamed from: g  reason: collision with root package name */
    net.one97.paytm.v2.features.b.b.a f20407g;

    /* renamed from: h  reason: collision with root package name */
    final CoroutineExceptionHandler f20408h = new C0366a(CoroutineExceptionHandler.Key);
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public Integer k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public String m = "";
    private String n = "";
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public boolean p;
    private String q = "";
    /* access modifiers changed from: private */
    public boolean r;
    /* access modifiers changed from: private */
    public int s;
    /* access modifiers changed from: private */
    public int t;
    private final kotlin.g u = kotlin.h.a(new t(this));
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public int w;
    private final kotlin.g x = kotlin.h.a(new s(this));
    /* access modifiers changed from: private */
    public int y;
    private final kotlin.g z = kotlin.h.a(new d(this));

    static final class o<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20427a;

        o(a aVar) {
            this.f20427a = aVar;
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    static {
        Class<a> cls = a.class;
        f20400a = new kotlin.k.i[]{y.a((v) new w(y.b(cls), "tollBarHeightDiff", "getTollBarHeightDiff()I")), y.a((v) new w(y.b(cls), "singleHeadingTextSizeDiff", "getSingleHeadingTextSizeDiff()I")), y.a((v) new w(y.b(cls), "headerTittleTextSizeDiff", "getHeaderTittleTextSizeDiff()I")), y.a((v) new w(y.b(cls), "translationX", "getTranslationX()I"))};
    }

    public View b(int i2) {
        if (this.D == null) {
            this.D = new HashMap();
        }
        View view = (View) this.D.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.D.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void b() {
        HashMap hashMap = this.D;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    /* renamed from: net.one97.paytm.v2.features.cashbackoffers.ui.a$a  reason: collision with other inner class name */
    public static final class C0366a extends kotlin.d.a implements CoroutineExceptionHandler {
        public C0366a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            kotlin.g.b.k.c(fVar, "context");
            kotlin.g.b.k.c(th, "exception");
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            sb.append(" handled !");
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.b<View, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return x.f47997a;
        }

        public final void invoke(View view) {
            kotlin.g.b.k.c(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Integer m = this.this$0.k;
            if (m == null) {
                kotlin.g.b.k.a();
            }
            layoutParams.width = m.intValue();
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            Integer m2 = this.this$0.k;
            if (m2 == null) {
                kotlin.g.b.k.a();
            }
            layoutParams2.height = (int) (((double) m2.intValue()) * 1.16d);
        }
    }

    static final class j<T> implements z<ScratchCard> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20418a;

        j(a aVar) {
            this.f20418a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ScratchCard scratchCard = (ScratchCard) obj;
            if (scratchCard != null) {
                String scratchCardStatus = scratchCard.getScratchCardStatus();
                a.j.C0391a aVar = a.j.f20817a;
                if (kotlin.g.b.k.a((Object) scratchCardStatus, (Object) a.j.f20822f)) {
                    this.f20418a.p = true;
                    if (this.f20418a.f20403c instanceof net.one97.paytm.v2.features.cashbacklanding.d.d) {
                        net.one97.paytm.v2.features.cashbackoffers.c.a aVar2 = this.f20418a.f20403c;
                        if (aVar2 != null) {
                            ((net.one97.paytm.v2.features.cashbacklanding.d.d) aVar2).a(scratchCard);
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.DealOfferViewModel");
                    }
                }
            }
        }
    }

    static final class l<T> implements z<net.one97.paytm.vipcashback.f.h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20420a;

        l(a aVar) {
            this.f20420a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.vipcashback.f.h hVar = (net.one97.paytm.vipcashback.f.h) obj;
            this.f20420a.l = false;
            switch (hVar.f20893a) {
                case 101:
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout, "swipeRefresh");
                    swipeRefreshLayout.setRefreshing(false);
                    SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout2, "swipeRefresh");
                    swipeRefreshLayout2.setEnabled(true);
                    SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout3, "swipeRefresh");
                    swipeRefreshLayout3.setRefreshing(false);
                    View b2 = this.f20420a.b(R.id.no_network);
                    kotlin.g.b.k.a((Object) b2, "no_network");
                    b2.setVisibility(8);
                    View b3 = this.f20420a.b(R.id.layoutNoData);
                    kotlin.g.b.k.a((Object) b3, "layoutNoData");
                    b3.setVisibility(8);
                    RecyclerView recyclerView = (RecyclerView) this.f20420a.b(R.id.recyclerView);
                    kotlin.g.b.k.a((Object) recyclerView, "recyclerView");
                    recyclerView.setVisibility(0);
                    a.d(this.f20420a);
                    this.f20420a.a().a(this.f20420a.m);
                    net.one97.paytm.v2.features.cashbacklanding.c.b a2 = this.f20420a.a();
                    T t = hVar.f20894b;
                    if (t != null) {
                        a2.a((ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a>) (ArrayList) t);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.CashbackOffer>");
                case 102:
                    SwipeRefreshLayout swipeRefreshLayout4 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout4, "swipeRefresh");
                    swipeRefreshLayout4.setRefreshing(false);
                    SwipeRefreshLayout swipeRefreshLayout5 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout5, "swipeRefresh");
                    swipeRefreshLayout5.setEnabled(true);
                    a.d(this.f20420a);
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f20420a.b(R.id.storefrontShimmerLayout);
                    if (shimmerFrameLayout != null) {
                        shimmerFrameLayout.b();
                    }
                    if (this.f20420a.getActivity() != null) {
                        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                        Throwable th = hVar != null ? hVar.f20895c : null;
                        if (th != null) {
                            NetworkCustomError networkCustomError = (NetworkCustomError) th;
                            FragmentActivity activity = this.f20420a.getActivity();
                            if (activity != null) {
                                d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) activity, (Boolean) null, 12);
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                            }
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                        }
                    }
                    View b4 = this.f20420a.b(R.id.no_network);
                    if (b4 != null) {
                        b4.setVisibility(8);
                    }
                    View b5 = this.f20420a.b(R.id.layoutNoData);
                    if (b5 != null) {
                        b5.setVisibility(8);
                    }
                    ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.f20420a.b(R.id.offerShimmerLayout);
                    if (shimmerFrameLayout2 != null) {
                        shimmerFrameLayout2.b();
                    }
                    ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) this.f20420a.b(R.id.offerShimmerLayout);
                    if (shimmerFrameLayout3 != null) {
                        shimmerFrameLayout3.setVisibility(8);
                        return;
                    }
                    return;
                case 104:
                    SwipeRefreshLayout swipeRefreshLayout6 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout6, "swipeRefresh");
                    swipeRefreshLayout6.setRefreshing(false);
                    View b6 = this.f20420a.b(R.id.layoutNoData);
                    if (b6 != null) {
                        b6.setVisibility(8);
                    }
                    RecyclerView recyclerView2 = (RecyclerView) this.f20420a.b(R.id.recyclerView);
                    kotlin.g.b.k.a((Object) recyclerView2, "recyclerView");
                    if (recyclerView2.getVisibility() == 0) {
                        d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                        Context context = this.f20420a.getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) context, "context!!");
                        d.a.a(context, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                            final /* synthetic */ l this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void invoke() {
                                FragmentActivity activity = this.this$0.f20420a.getActivity();
                                if (activity != null) {
                                    activity.finish();
                                }
                            }
                        });
                    } else {
                        a.d(this.f20420a);
                        SwipeRefreshLayout swipeRefreshLayout7 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                        kotlin.g.b.k.a((Object) swipeRefreshLayout7, "swipeRefresh");
                        swipeRefreshLayout7.setEnabled(true);
                        this.f20420a.a(0);
                    }
                    ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) this.f20420a.b(R.id.offerShimmerLayout);
                    if (shimmerFrameLayout4 != null) {
                        shimmerFrameLayout4.b();
                    }
                    ShimmerFrameLayout shimmerFrameLayout5 = (ShimmerFrameLayout) this.f20420a.b(R.id.offerShimmerLayout);
                    if (shimmerFrameLayout5 != null) {
                        shimmerFrameLayout5.setVisibility(8);
                        return;
                    }
                    return;
                case 105:
                    SwipeRefreshLayout swipeRefreshLayout8 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout8, "swipeRefresh");
                    swipeRefreshLayout8.setRefreshing(false);
                    SwipeRefreshLayout swipeRefreshLayout9 = (SwipeRefreshLayout) this.f20420a.b(R.id.swipeRefresh);
                    kotlin.g.b.k.a((Object) swipeRefreshLayout9, "swipeRefresh");
                    swipeRefreshLayout9.setEnabled(true);
                    a.d(this.f20420a);
                    ShimmerFrameLayout shimmerFrameLayout6 = (ShimmerFrameLayout) this.f20420a.b(R.id.storefrontShimmerLayout);
                    if (shimmerFrameLayout6 != null) {
                        shimmerFrameLayout6.b();
                    }
                    RecyclerView recyclerView3 = (RecyclerView) this.f20420a.b(R.id.recyclerView);
                    kotlin.g.b.k.a((Object) recyclerView3, "recyclerView");
                    recyclerView3.setVisibility(8);
                    View b7 = this.f20420a.b(R.id.no_network);
                    if (b7 != null) {
                        b7.setVisibility(8);
                    }
                    View b8 = this.f20420a.b(R.id.layoutNoData);
                    kotlin.g.b.k.a((Object) b8, "layoutNoData");
                    b8.setVisibility(0);
                    int f2 = this.f20420a.j;
                    a.b.C0384a aVar3 = a.b.f20777a;
                    if (f2 == a.b.f20783g) {
                        TextView textView = (TextView) this.f20420a.b(R.id.noOfferTV);
                        kotlin.g.b.k.a((Object) textView, "noOfferTV");
                        textView.setText(this.f20420a.getResources().getString(R.string.no_active_voucher));
                    } else {
                        a.b.C0384a aVar4 = a.b.f20777a;
                        if (f2 == a.b.f20778b) {
                            TextView textView2 = (TextView) this.f20420a.b(R.id.noOfferTV);
                            kotlin.g.b.k.a((Object) textView2, "noOfferTV");
                            textView2.setText(this.f20420a.getResources().getString(R.string.no_active_cashback));
                        } else {
                            a.b.C0384a aVar5 = a.b.f20777a;
                            if (f2 == a.b.f20779c) {
                                TextView textView3 = (TextView) this.f20420a.b(R.id.noOfferTV);
                                kotlin.g.b.k.a((Object) textView3, "noOfferTV");
                                textView3.setText(this.f20420a.getResources().getString(R.string.no_active_points));
                            } else {
                                a.b.C0384a aVar6 = a.b.f20777a;
                                if (f2 == a.b.f20782f) {
                                    TextView textView4 = (TextView) this.f20420a.b(R.id.noOfferTV);
                                    kotlin.g.b.k.a((Object) textView4, "noOfferTV");
                                    textView4.setText(this.f20420a.getResources().getString(R.string.no_active_deals));
                                } else {
                                    a.b.C0384a aVar7 = a.b.f20777a;
                                    if (f2 == a.b.f20780d) {
                                        TextView textView5 = (TextView) this.f20420a.b(R.id.noOfferTV);
                                        kotlin.g.b.k.a((Object) textView5, "noOfferTV");
                                        textView5.setText(this.f20420a.getResources().getString(R.string.no_active_scratch_card));
                                    } else {
                                        a.b.C0384a aVar8 = a.b.f20777a;
                                        if (f2 == a.b.f20781e) {
                                            TextView textView6 = (TextView) this.f20420a.b(R.id.noOfferTV);
                                            kotlin.g.b.k.a((Object) textView6, "noOfferTV");
                                            textView6.setText(this.f20420a.getResources().getString(R.string.no_active_offer));
                                        } else {
                                            a.b.C0384a aVar9 = a.b.f20777a;
                                            if (f2 == a.b.f20784h) {
                                                TextView textView7 = (TextView) this.f20420a.b(R.id.noOfferTV);
                                                kotlin.g.b.k.a((Object) textView7, "noOfferTV");
                                                textView7.setText(this.f20420a.getResources().getString(R.string.no_active_offer));
                                            } else {
                                                a.b.C0384a aVar10 = a.b.f20777a;
                                                if (f2 == a.b.f20785i) {
                                                    TextView textView8 = (TextView) this.f20420a.b(R.id.noOfferTV);
                                                    kotlin.g.b.k.a((Object) textView8, "noOfferTV");
                                                    textView8.setText(this.f20420a.getResources().getString(R.string.no_voucher_text));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ShimmerFrameLayout shimmerFrameLayout7 = (ShimmerFrameLayout) this.f20420a.b(R.id.offerShimmerLayout);
                    if (shimmerFrameLayout7 != null) {
                        shimmerFrameLayout7.b();
                    }
                    ShimmerFrameLayout shimmerFrameLayout8 = (ShimmerFrameLayout) this.f20420a.b(R.id.offerShimmerLayout);
                    if (shimmerFrameLayout8 != null) {
                        shimmerFrameLayout8.setVisibility(8);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static final class m<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20421a;

        m(a aVar) {
            this.f20421a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                if (this.f20421a.f20406f == null) {
                    RecyclerView recyclerView = (RecyclerView) this.f20421a.b(R.id.recyclerView);
                    kotlin.g.b.k.a((Object) recyclerView, "recyclerView");
                    if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                        RecyclerView recyclerView2 = (RecyclerView) this.f20421a.b(R.id.recyclerView);
                        kotlin.g.b.k.a((Object) recyclerView2, "recyclerView");
                        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                        if (layoutManager != null) {
                            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                            this.f20421a.f20406f = new RecyclerView.l(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ m f20422a;

                                {
                                    this.f20422a = r1;
                                }

                                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                                    kotlin.g.b.k.c(recyclerView, "recyclerView");
                                    super.onScrolled(recyclerView, i2, i3);
                                    if (i2 > 0 || i3 > 0) {
                                        int itemCount = gridLayoutManager.getItemCount();
                                        int findLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                                        if (!this.f20422a.f20421a.l && itemCount <= findLastVisibleItemPosition + this.f20422a.f20421a.f20404d) {
                                            this.f20422a.f20421a.l = true;
                                            net.one97.paytm.v2.features.cashbackoffers.c.a aVar = this.f20422a.f20421a.f20403c;
                                            if (aVar != null) {
                                                aVar.f();
                                            }
                                        }
                                    }
                                }
                            };
                            RecyclerView.l lVar = this.f20421a.f20406f;
                            if (lVar != null) {
                                ((RecyclerView) this.f20421a.b(R.id.recyclerView)).addOnScrollListener(lVar);
                                return;
                            }
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                    }
                }
                if (this.f20421a.f20406f == null) {
                    RecyclerView recyclerView3 = (RecyclerView) this.f20421a.b(R.id.recyclerView);
                    kotlin.g.b.k.a((Object) recyclerView3, "recyclerView");
                    if (recyclerView3.getLayoutManager() instanceof LinearLayoutManager) {
                        RecyclerView recyclerView4 = (RecyclerView) this.f20421a.b(R.id.recyclerView);
                        kotlin.g.b.k.a((Object) recyclerView4, "recyclerView");
                        RecyclerView.LayoutManager layoutManager2 = recyclerView4.getLayoutManager();
                        if (layoutManager2 != null) {
                            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                            this.f20421a.f20406f = new RecyclerView.l(this) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ m f20424a;

                                {
                                    this.f20424a = r1;
                                }

                                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                                    kotlin.g.b.k.c(recyclerView, "recyclerView");
                                    super.onScrolled(recyclerView, i2, i3);
                                    if (i2 > 0 || i3 > 0) {
                                        int itemCount = linearLayoutManager.getItemCount();
                                        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                                        if (!this.f20424a.f20421a.l && itemCount <= findLastVisibleItemPosition + this.f20424a.f20421a.f20404d) {
                                            this.f20424a.f20421a.l = true;
                                            net.one97.paytm.v2.features.cashbackoffers.c.a aVar = this.f20424a.f20421a.f20403c;
                                            if (aVar != null) {
                                                aVar.f();
                                            }
                                        }
                                    }
                                }
                            };
                            RecyclerView.l lVar2 = this.f20421a.f20406f;
                            if (lVar2 != null) {
                                ((RecyclerView) this.f20421a.b(R.id.recyclerView)).addOnScrollListener(lVar2);
                                return;
                            }
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                    return;
                }
                return;
            }
            RecyclerView.l lVar3 = this.f20421a.f20406f;
            if (lVar3 != null) {
                ((RecyclerView) this.f20421a.b(R.id.recyclerView)).removeOnScrollListener(lVar3);
                this.f20421a.f20406f = null;
            }
        }
    }

    static final class n<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20426a;

        n(a aVar) {
            this.f20426a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f20426a.b(R.id.loadMoreLoader));
            } else {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20426a.b(R.id.loadMoreLoader));
            }
        }
    }

    static final class p<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20428a;

        p(a aVar) {
            this.f20428a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CharSequence charSequence;
            TextView textView;
            TextView textView2;
            String str = (String) obj;
            if (str != null) {
                if (str.length() > 0) {
                    this.f20428a.o = str.toString();
                    TextView textView3 = (TextView) this.f20428a.b(R.id.amountHeading);
                    kotlin.g.b.k.a((Object) textView3, "amountHeading");
                    Integer valueOf = Integer.valueOf(this.f20428a.j);
                    a.b.C0384a aVar = a.b.f20777a;
                    if (valueOf.equals(Integer.valueOf(a.b.f20778b))) {
                        TextView textView4 = (TextView) this.f20428a.b(R.id.ruppeSymbol);
                        if (textView4 != null) {
                            textView4.setVisibility(0);
                        }
                        TextView textView5 = (TextView) this.f20428a.b(R.id.rupeeToolbar);
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                        }
                        d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                        charSequence = d.a.e(str.toString());
                    } else {
                        d.a aVar3 = net.one97.paytm.vipcashback.f.d.f20859a;
                        charSequence = d.a.e(str.toString());
                    }
                    textView3.setText(charSequence);
                    TextView textView6 = (TextView) this.f20428a.b(R.id.amountHeading);
                    kotlin.g.b.k.a((Object) textView6, "amountHeading");
                    textView6.setVisibility(0);
                    TextView textView7 = (TextView) this.f20428a.b(R.id.singleHeading);
                    kotlin.g.b.k.a((Object) textView7, "singleHeading");
                    textView7.setVisibility(0);
                    int f2 = this.f20428a.j;
                    a.b.C0384a aVar4 = a.b.f20777a;
                    CharSequence charSequence2 = null;
                    if (f2 == a.b.f20778b && (textView2 = (TextView) this.f20428a.b(R.id.singleHeadingToolbar)) != null) {
                        TextView textView8 = (TextView) this.f20428a.b(R.id.amountHeading);
                        textView2.setText((String.valueOf(textView8 != null ? textView8.getText() : null) + " ") + this.f20428a.getResources().getString(R.string.cashback_won));
                    }
                    int f3 = this.f20428a.j;
                    a.b.C0384a aVar5 = a.b.f20777a;
                    if (f3 == a.b.f20779c && (textView = (TextView) this.f20428a.b(R.id.singleHeadingToolbar)) != null) {
                        TextView textView9 = (TextView) this.f20428a.b(R.id.amountHeading);
                        if (textView9 != null) {
                            charSequence2 = textView9.getText();
                        }
                        textView.setText((String.valueOf(charSequence2) + " ") + this.f20428a.getResources().getString(R.string.points_won));
                    }
                }
            }
        }
    }

    static final class q extends kotlin.g.b.l implements kotlin.g.a.m<Integer, String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(a aVar) {
            super(2);
            this.this$0 = aVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return x.f47997a;
        }

        public final void invoke(int i2, String str) {
            kotlin.g.b.k.c(str, "title");
            if (!this.this$0.r) {
                this.this$0.r = true;
                LiveData<Object> liveData = null;
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO().plus(this.this$0.f20408h), (CoroutineStart) null, new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ q this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        kotlin.g.b.k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        public final net.one97.paytm.v2.features.cashbacklanding.c.b a() {
                            net.one97.paytm.v2.features.cashbacklanding.c.b bVar = this.f20402b;
                            if (bVar == null) {
                                kotlin.g.b.k.a("mAdapter");
                            }
                            return bVar;
                        }

                        static final class t extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
                            final /* synthetic */ a this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            t(a aVar) {
                                super(0);
                                this.this$0 = aVar;
                            }

                            public final int invoke() {
                                return this.this$0.t - this.this$0.s;
                            }
                        }

                        static final class s extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
                            final /* synthetic */ a this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            s(a aVar) {
                                super(0);
                                this.this$0 = aVar;
                            }

                            public final int invoke() {
                                return this.this$0.v - this.this$0.w;
                            }
                        }

                        static final class d extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
                            final /* synthetic */ a this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            d(a aVar) {
                                super(0);
                                this.this$0 = aVar;
                            }

                            public final int invoke() {
                                return this.this$0.y - this.this$0.w;
                            }
                        }

                        static final class u extends kotlin.g.b.l implements kotlin.g.a.a<Integer> {
                            final /* synthetic */ a this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            u(a aVar) {
                                super(0);
                                this.this$0 = aVar;
                            }

                            public final int invoke() {
                                return this.this$0.getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_40dp);
                            }
                        }

                        public static final class b {
                            private b() {
                            }

                            public /* synthetic */ b(byte b2) {
                                this();
                            }
                        }

                        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
                            kotlin.g.b.k.c(layoutInflater, "inflater");
                            return layoutInflater.inflate(R.layout.fragment_offer_list, viewGroup, false);
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:274:0x0669, code lost:
                            if (r9 == net.one97.paytm.vipcashback.d.a.b.f20784h) goto L_0x066b;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:108:0x029f  */
                        /* JADX WARNING: Removed duplicated region for block: B:114:0x02f2  */
                        /* JADX WARNING: Removed duplicated region for block: B:117:0x0312  */
                        /* JADX WARNING: Removed duplicated region for block: B:142:0x03af  */
                        /* JADX WARNING: Removed duplicated region for block: B:166:0x0429  */
                        /* JADX WARNING: Removed duplicated region for block: B:169:0x0436  */
                        /* JADX WARNING: Removed duplicated region for block: B:172:0x043d  */
                        /* JADX WARNING: Removed duplicated region for block: B:175:0x044c  */
                        /* JADX WARNING: Removed duplicated region for block: B:345:0x07de  */
                        /* JADX WARNING: Removed duplicated region for block: B:348:0x07eb  */
                        /* JADX WARNING: Removed duplicated region for block: B:351:0x07f8  */
                        /* JADX WARNING: Removed duplicated region for block: B:354:0x0805  */
                        /* JADX WARNING: Removed duplicated region for block: B:357:0x0812  */
                        /* JADX WARNING: Removed duplicated region for block: B:360:0x081f  */
                        /* JADX WARNING: Removed duplicated region for block: B:368:0x0843  */
                        /* JADX WARNING: Removed duplicated region for block: B:371:0x0860  */
                        /* JADX WARNING: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onViewCreated(android.view.View r9, android.os.Bundle r10) {
                            /*
                                r8 = this;
                                java.lang.String r0 = "view"
                                kotlin.g.b.k.c(r9, r0)
                                super.onViewCreated(r9, r10)
                                android.content.res.Resources r9 = r8.getResources()
                                int r10 = net.one97.paytm.common.assets.R.dimen.dimen_64dp
                                int r9 = r9.getDimensionPixelOffset(r10)
                                r8.s = r9
                                android.content.res.Resources r9 = r8.getResources()
                                int r10 = net.one97.paytm.common.assets.R.dimen.dimen_160dp
                                int r9 = r9.getDimensionPixelOffset(r10)
                                r8.t = r9
                                android.content.res.Resources r9 = r8.getResources()
                                int r10 = net.one97.paytm.common.assets.R.dimen.dimen_20sp
                                int r9 = r9.getDimensionPixelSize(r10)
                                r8.v = r9
                                android.content.res.Resources r9 = r8.getResources()
                                int r10 = net.one97.paytm.common.assets.R.dimen.dimen_16sp
                                int r9 = r9.getDimensionPixelSize(r10)
                                r8.w = r9
                                android.content.res.Resources r9 = r8.getResources()
                                int r10 = net.one97.paytm.vipcashback.R.dimen.dimen_32sp
                                int r9 = r9.getDimensionPixelSize(r10)
                                r8.y = r9
                                int r9 = net.one97.paytm.vipcashback.R.id.backArrowOffer
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x0058
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$k r10 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$k
                                r10.<init>(r8)
                                android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
                                r9.setOnClickListener(r10)
                            L_0x0058:
                                android.os.Bundle r9 = r8.getArguments()
                                r10 = 0
                                if (r9 == 0) goto L_0x0066
                                java.lang.String r0 = "offer_type_card"
                                int r9 = r9.getInt(r0)
                                goto L_0x0067
                            L_0x0066:
                                r9 = 0
                            L_0x0067:
                                r8.j = r9
                                android.os.Bundle r9 = r8.getArguments()
                                java.lang.String r0 = ""
                                if (r9 == 0) goto L_0x0079
                                java.lang.String r1 = "offertag"
                                java.lang.String r9 = r9.getString(r1)
                                if (r9 != 0) goto L_0x007a
                            L_0x0079:
                                r9 = r0
                            L_0x007a:
                                r8.m = r9
                                android.os.Bundle r9 = r8.getArguments()
                                if (r9 == 0) goto L_0x008a
                                java.lang.String r1 = "activityName"
                                java.lang.String r9 = r9.getString(r1)
                                if (r9 != 0) goto L_0x008b
                            L_0x008a:
                                r9 = r0
                            L_0x008b:
                                r8.f20405e = r9
                                android.os.Bundle r9 = r8.getArguments()
                                if (r9 == 0) goto L_0x009b
                                java.lang.String r1 = "titleName"
                                java.lang.String r9 = r9.getString(r1)
                                if (r9 != 0) goto L_0x009c
                            L_0x009b:
                                r9 = r0
                            L_0x009c:
                                r8.q = r9
                                java.lang.String r9 = r8.m
                                r1 = 1
                                r2 = 0
                                if (r9 == 0) goto L_0x00b4
                                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                                int r9 = r9.length()
                                if (r9 <= 0) goto L_0x00ae
                                r9 = 1
                                goto L_0x00af
                            L_0x00ae:
                                r9 = 0
                            L_0x00af:
                                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
                                goto L_0x00b5
                            L_0x00b4:
                                r9 = r2
                            L_0x00b5:
                                boolean r9 = r9.booleanValue()
                                if (r9 == 0) goto L_0x00cd
                                int r9 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20784h
                                if (r9 == r3) goto L_0x00cd
                                net.one97.paytm.vipcashback.d.a$b$a r9 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r9 = net.one97.paytm.vipcashback.d.a.b.f20781e
                                r8.j = r9
                            L_0x00cd:
                                android.os.Bundle r9 = r8.getArguments()
                                if (r9 == 0) goto L_0x00db
                                java.lang.String r3 = "header_image_url"
                                java.lang.String r9 = r9.getString(r3)
                                if (r9 != 0) goto L_0x00dc
                            L_0x00db:
                                r9 = r0
                            L_0x00dc:
                                r8.n = r9
                                android.content.res.Resources r9 = r8.getResources()
                                java.lang.String r0 = "resources"
                                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                                android.util.DisplayMetrics r9 = r9.getDisplayMetrics()
                                int r9 = r9.widthPixels
                                android.content.res.Resources r0 = r8.getResources()
                                int r3 = net.one97.paytm.common.assets.R.dimen.dimen_88dp
                                int r0 = r0.getDimensionPixelSize(r3)
                                int r9 = r9 - r0
                                r0 = 2
                                int r9 = r9 / r0
                                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                                r8.k = r9
                                net.one97.paytm.v2.features.cashbacklanding.c.a r9 = new net.one97.paytm.v2.features.cashbacklanding.c.a
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$c r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$c
                                r3.<init>(r8)
                                kotlin.g.a.b r3 = (kotlin.g.a.b) r3
                                r9.<init>(r3)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r3 = net.one97.paytm.v2.features.cashbackoffers.a.a.b.d()
                                net.one97.paytm.v2.features.cashbackoffers.a.b.l r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.l
                                r5 = r8
                                androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
                                r4.<init>(r5)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r3 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.l) r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.b.j r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.j
                                android.content.Context r5 = r8.getContext()
                                if (r5 != 0) goto L_0x0127
                                kotlin.g.b.k.a()
                            L_0x0127:
                                java.lang.String r6 = "context!!"
                                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                                r4.<init>(r5)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r3 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.j) r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.b.n r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.n
                                r4.<init>()
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r3 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.n) r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.b.f r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.f
                                int r5 = r8.j
                                r4.<init>(r5)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r3 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.f) r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.b.y r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.y
                                int r5 = r8.j
                                r4.<init>(r5)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r3 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.y) r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.b.c r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.c
                                int r5 = r8.j
                                r4.<init>(r9, r5)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r9 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.c) r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.b.a r3 = new net.one97.paytm.v2.features.cashbackoffers.a.b.a
                                androidx.fragment.app.FragmentActivity r4 = r8.getActivity()
                                if (r4 != 0) goto L_0x0168
                                kotlin.g.b.k.a()
                            L_0x0168:
                                if (r4 == 0) goto L_0x0873
                                androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
                                r3.<init>(r4)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.b$a r9 = r9.a((net.one97.paytm.v2.features.cashbackoffers.a.b.a) r3)
                                net.one97.paytm.v2.features.cashbackoffers.a.a.a r9 = r9.a()
                                net.one97.paytm.v2.features.cashbackoffers.a r3 = r9.a()
                                net.one97.paytm.v2.features.cashbacklanding.c.b r4 = r9.b()
                                r8.f20402b = r4
                                net.one97.paytm.v2.features.b.c.a r4 = r9.c()
                                r8.B = r4
                                net.one97.paytm.v2.features.b.c.a r4 = r8.B
                                if (r4 == 0) goto L_0x018e
                                r9.a((net.one97.paytm.v2.features.b.c.a) r4)
                            L_0x018e:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                r8.f20403c = r4
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                java.lang.String r5 = "Debug>>> viewModel "
                                r4.<init>(r5)
                                net.one97.paytm.v2.features.cashbackoffers.c.a r5 = r8.f20403c
                                r4.append(r5)
                                java.lang.String r5 = " fragment "
                                r4.append(r5)
                                r4.append(r8)
                                int r4 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20783g
                                r6 = 8
                                if (r4 == r5) goto L_0x0267
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20785i
                                if (r4 != r5) goto L_0x01bc
                                goto L_0x0267
                            L_0x01bc:
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20778b
                                java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.DealOfferViewModel"
                                if (r4 == r5) goto L_0x0257
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20779c
                                if (r4 == r5) goto L_0x0257
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.j
                                if (r4 != r5) goto L_0x01d8
                                goto L_0x0257
                            L_0x01d8:
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20782f
                                if (r4 != r5) goto L_0x0209
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                if (r4 == 0) goto L_0x0203
                                net.one97.paytm.v2.features.cashbacklanding.d.d r4 = (net.one97.paytm.v2.features.cashbacklanding.d.d) r4
                                r9.a((net.one97.paytm.v2.features.cashbacklanding.d.d) r4)
                                int r9 = net.one97.paytm.vipcashback.R.id.appBarLayout
                                android.view.View r9 = r8.b((int) r9)
                                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                                if (r9 == 0) goto L_0x01f6
                                r9.setVisibility(r6)
                            L_0x01f6:
                                int r9 = net.one97.paytm.vipcashback.R.id.mainToolbar
                                android.view.View r9 = r8.b((int) r9)
                                if (r9 == 0) goto L_0x0288
                                r9.setVisibility(r6)
                                goto L_0x0288
                            L_0x0203:
                                kotlin.u r9 = new kotlin.u
                                r9.<init>(r7)
                                throw r9
                            L_0x0209:
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20780d
                                if (r4 != r5) goto L_0x0223
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                if (r4 == 0) goto L_0x021b
                                net.one97.paytm.v2.features.cashbacklanding.d.a r4 = (net.one97.paytm.v2.features.cashbacklanding.d.a) r4
                                r9.a((net.one97.paytm.v2.features.cashbacklanding.d.a) r4)
                                goto L_0x0288
                            L_0x021b:
                                kotlin.u r9 = new kotlin.u
                                java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.CashbackOfferViewModel"
                                r9.<init>(r10)
                                throw r9
                            L_0x0223:
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20781e
                                if (r4 != r5) goto L_0x023d
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                if (r4 == 0) goto L_0x0235
                                net.one97.paytm.v2.features.cashbacklanding.d.c r4 = (net.one97.paytm.v2.features.cashbacklanding.d.c) r4
                                r9.a((net.one97.paytm.v2.features.cashbacklanding.d.c) r4)
                                goto L_0x0288
                            L_0x0235:
                                kotlin.u r9 = new kotlin.u
                                java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.CategoryOfferListViewModel"
                                r9.<init>(r10)
                                throw r9
                            L_0x023d:
                                net.one97.paytm.vipcashback.d.a$b$a r5 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r5 = net.one97.paytm.vipcashback.d.a.b.f20784h
                                if (r4 != r5) goto L_0x0288
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                if (r4 == 0) goto L_0x024f
                                net.one97.paytm.v2.features.cashbackoffers.c.b r4 = (net.one97.paytm.v2.features.cashbackoffers.c.b) r4
                                r9.a((net.one97.paytm.v2.features.cashbackoffers.c.b) r4)
                                goto L_0x0288
                            L_0x024f:
                                kotlin.u r9 = new kotlin.u
                                java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbackoffers.viewModel.OffersViewModel"
                                r9.<init>(r10)
                                throw r9
                            L_0x0257:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                if (r4 == 0) goto L_0x0261
                                net.one97.paytm.v2.features.cashbacklanding.d.d r4 = (net.one97.paytm.v2.features.cashbacklanding.d.d) r4
                                r9.a((net.one97.paytm.v2.features.cashbacklanding.d.d) r4)
                                goto L_0x0288
                            L_0x0261:
                                kotlin.u r9 = new kotlin.u
                                r9.<init>(r7)
                                throw r9
                            L_0x0267:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r4 = r3.f20297a
                                if (r4 == 0) goto L_0x086b
                                net.one97.paytm.v2.features.cashbacklanding.d.e r4 = (net.one97.paytm.v2.features.cashbacklanding.d.e) r4
                                r9.a((net.one97.paytm.v2.features.cashbacklanding.d.e) r4)
                                int r9 = net.one97.paytm.vipcashback.R.id.appBarLayout
                                android.view.View r9 = r8.b((int) r9)
                                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                                if (r9 == 0) goto L_0x027d
                                r9.setVisibility(r6)
                            L_0x027d:
                                int r9 = net.one97.paytm.vipcashback.R.id.mainToolbar
                                android.view.View r9 = r8.b((int) r9)
                                if (r9 == 0) goto L_0x0288
                                r9.setVisibility(r6)
                            L_0x0288:
                                int r9 = net.one97.paytm.vipcashback.R.id.recyclerView
                                android.view.View r9 = r8.b((int) r9)
                                androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
                                java.lang.String r4 = "recyclerView"
                                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                                int r5 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r7 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r7 = net.one97.paytm.vipcashback.d.a.b.f20778b
                                if (r5 == r7) goto L_0x02b4
                                net.one97.paytm.vipcashback.d.a$b$a r7 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r7 = net.one97.paytm.vipcashback.d.a.b.f20779c
                                if (r5 != r7) goto L_0x02a8
                                goto L_0x02b4
                            L_0x02a8:
                                androidx.recyclerview.widget.GridLayoutManager r5 = new androidx.recyclerview.widget.GridLayoutManager
                                android.content.Context r7 = r8.getContext()
                                r5.<init>(r7, r0)
                                androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r5
                                goto L_0x02c0
                            L_0x02b4:
                                androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
                                android.content.Context r5 = r8.getContext()
                                r0.<init>(r5)
                                r5 = r0
                                androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r5
                            L_0x02c0:
                                r9.setLayoutManager(r5)
                                int r9 = net.one97.paytm.vipcashback.R.id.swipeRefresh
                                android.view.View r9 = r8.b((int) r9)
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
                                r0 = r8
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout$b r0 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout.b) r0
                                r9.setOnRefreshListener(r0)
                                int r9 = net.one97.paytm.vipcashback.R.id.swipeRefresh
                                android.view.View r9 = r8.b((int) r9)
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
                                java.lang.String r0 = "swipeRefresh"
                                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                                r9.setRefreshing(r10)
                                int r9 = net.one97.paytm.vipcashback.R.id.recyclerView
                                android.view.View r9 = r8.b((int) r9)
                                androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
                                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                                net.one97.paytm.v2.features.cashbacklanding.c.b r0 = r8.f20402b
                                java.lang.String r5 = "mAdapter"
                                if (r0 != 0) goto L_0x02f5
                                kotlin.g.b.k.a((java.lang.String) r5)
                            L_0x02f5:
                                androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
                                r9.setAdapter(r0)
                                int r9 = net.one97.paytm.vipcashback.R.id.recyclerView
                                android.view.View r9 = r8.b((int) r9)
                                androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
                                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                                r9.setVisibility(r6)
                                int r9 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r0 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r0 = net.one97.paytm.vipcashback.d.a.b.f20778b
                                if (r9 == r0) goto L_0x0342
                                int r9 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r0 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r0 = net.one97.paytm.vipcashback.d.a.b.f20779c
                                if (r9 == r0) goto L_0x0342
                                android.content.res.Resources r9 = r8.getResources()
                                int r0 = net.one97.paytm.common.assets.R.dimen.dimen_22dp
                                int r9 = r9.getDimensionPixelSize(r0)
                                android.content.res.Resources r0 = r8.getResources()
                                int r4 = net.one97.paytm.common.assets.R.dimen.dimen_8dp
                                int r0 = r0.getDimensionPixelOffset(r4)
                                int r4 = net.one97.paytm.vipcashback.R.id.recyclerView
                                android.view.View r4 = r8.b((int) r4)
                                androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
                                net.one97.paytm.vipcashback.widget.c r7 = new net.one97.paytm.vipcashback.widget.c
                                r7.<init>(r0, r9, r0)
                                androidx.recyclerview.widget.RecyclerView$h r7 = (androidx.recyclerview.widget.RecyclerView.h) r7
                                r4.addItemDecoration(r7)
                            L_0x0342:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r9 = r3.f20297a
                                androidx.lifecycle.LiveData r9 = r9.b()
                                r0 = r8
                                androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$l r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$l
                                r3.<init>(r8)
                                androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
                                r9.observe(r0, r3)
                                net.one97.paytm.v2.features.cashbackoffers.c.a r9 = r8.f20403c
                                if (r9 == 0) goto L_0x0369
                                androidx.lifecycle.LiveData r9 = r9.e()
                                if (r9 == 0) goto L_0x0369
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$m r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$m
                                r3.<init>(r8)
                                androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
                                r9.observe(r0, r3)
                            L_0x0369:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r9 = r8.f20403c
                                if (r9 == 0) goto L_0x037d
                                androidx.lifecycle.LiveData r9 = r9.c()
                                if (r9 == 0) goto L_0x037d
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$n r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$n
                                r3.<init>(r8)
                                androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
                                r9.observe(r0, r3)
                            L_0x037d:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r9 = r8.f20403c
                                if (r9 == 0) goto L_0x0391
                                androidx.lifecycle.LiveData r9 = r9.d()
                                if (r9 == 0) goto L_0x0391
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$o r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$o
                                r3.<init>(r8)
                                androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
                                r9.observe(r0, r3)
                            L_0x0391:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r9 = r8.f20403c
                                if (r9 == 0) goto L_0x03a5
                                androidx.lifecycle.LiveData r9 = r9.a()
                                if (r9 == 0) goto L_0x03a5
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$p r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$p
                                r3.<init>(r8)
                                androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
                                r9.observe(r0, r3)
                            L_0x03a5:
                                int r9 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20778b
                                if (r9 == r3) goto L_0x03ed
                                int r9 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20779c
                                if (r9 != r3) goto L_0x03ba
                                goto L_0x03ed
                            L_0x03ba:
                                int r9 = net.one97.paytm.vipcashback.R.id.offerShimmerLayout
                                android.view.View r9 = r8.b((int) r9)
                                net.one97.paytm.common.views.ShimmerFrameLayout r9 = (net.one97.paytm.common.views.ShimmerFrameLayout) r9
                                if (r9 == 0) goto L_0x03d3
                                android.view.View r9 = (android.view.View) r9
                                int r3 = net.one97.paytm.vipcashback.R.id.gridLayout
                                android.view.View r9 = r9.findViewById(r3)
                                androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
                                if (r9 == 0) goto L_0x03d3
                                r9.setVisibility(r10)
                            L_0x03d3:
                                int r9 = net.one97.paytm.vipcashback.R.id.offerShimmerLayout
                                android.view.View r9 = r8.b((int) r9)
                                net.one97.paytm.common.views.ShimmerFrameLayout r9 = (net.one97.paytm.common.views.ShimmerFrameLayout) r9
                                if (r9 == 0) goto L_0x041f
                                android.view.View r9 = (android.view.View) r9
                                int r3 = net.one97.paytm.vipcashback.R.id.listLayout
                                android.view.View r9 = r9.findViewById(r3)
                                androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
                                if (r9 == 0) goto L_0x041f
                                r9.setVisibility(r6)
                                goto L_0x041f
                            L_0x03ed:
                                int r9 = net.one97.paytm.vipcashback.R.id.offerShimmerLayout
                                android.view.View r9 = r8.b((int) r9)
                                net.one97.paytm.common.views.ShimmerFrameLayout r9 = (net.one97.paytm.common.views.ShimmerFrameLayout) r9
                                if (r9 == 0) goto L_0x0406
                                android.view.View r9 = (android.view.View) r9
                                int r3 = net.one97.paytm.vipcashback.R.id.gridLayout
                                android.view.View r9 = r9.findViewById(r3)
                                androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
                                if (r9 == 0) goto L_0x0406
                                r9.setVisibility(r6)
                            L_0x0406:
                                int r9 = net.one97.paytm.vipcashback.R.id.offerShimmerLayout
                                android.view.View r9 = r8.b((int) r9)
                                net.one97.paytm.common.views.ShimmerFrameLayout r9 = (net.one97.paytm.common.views.ShimmerFrameLayout) r9
                                if (r9 == 0) goto L_0x041f
                                android.view.View r9 = (android.view.View) r9
                                int r3 = net.one97.paytm.vipcashback.R.id.listLayout
                                android.view.View r9 = r9.findViewById(r3)
                                androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
                                if (r9 == 0) goto L_0x041f
                                r9.setVisibility(r10)
                            L_0x041f:
                                int r9 = net.one97.paytm.vipcashback.R.id.offerShimmerLayout
                                android.view.View r9 = r8.b((int) r9)
                                net.one97.paytm.common.views.ShimmerFrameLayout r9 = (net.one97.paytm.common.views.ShimmerFrameLayout) r9
                                if (r9 == 0) goto L_0x042c
                                r9.a()
                            L_0x042c:
                                int r9 = net.one97.paytm.vipcashback.R.id.offerShimmerLayout
                                android.view.View r9 = r8.b((int) r9)
                                net.one97.paytm.common.views.ShimmerFrameLayout r9 = (net.one97.paytm.common.views.ShimmerFrameLayout) r9
                                if (r9 == 0) goto L_0x0439
                                r9.setVisibility(r10)
                            L_0x0439:
                                net.one97.paytm.v2.features.cashbackoffers.c.a r9 = r8.f20403c
                                if (r9 == 0) goto L_0x0442
                                java.lang.String r3 = r8.m
                                r9.b(r3)
                            L_0x0442:
                                int r9 = r8.j
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20783g
                                if (r9 == r3) goto L_0x07d4
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20785i
                                if (r9 == r3) goto L_0x07d4
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20782f
                                if (r9 != r3) goto L_0x045e
                                goto L_0x07d4
                            L_0x045e:
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20778b
                                java.lang.String r4 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
                                if (r9 != r3) goto L_0x04fe
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0486
                                android.content.Context r1 = r8.getContext()
                                if (r1 != 0) goto L_0x047b
                                kotlin.g.b.k.a()
                            L_0x047b:
                                int r3 = net.one97.paytm.vipcashback.R.string.cashback_won
                                java.lang.String r1 = r1.getString(r3)
                                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                                r9.setText(r1)
                            L_0x0486:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                java.lang.String r1 = "#FFFFFF"
                                if (r9 == 0) goto L_0x0499
                                int r3 = android.graphics.Color.parseColor(r1)
                                r9.setTextColor(r3)
                            L_0x0499:
                                int r9 = net.one97.paytm.vipcashback.R.id.amountHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x04aa
                                int r3 = android.graphics.Color.parseColor(r1)
                                r9.setTextColor(r3)
                            L_0x04aa:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x04bb
                                int r1 = android.graphics.Color.parseColor(r1)
                                r9.setTextColor(r1)
                            L_0x04bb:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerImage
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x04d2
                                android.content.res.Resources r1 = r8.getResources()
                                int r3 = net.one97.paytm.vipcashback.R.color.color_00aaff
                                int r1 = r1.getColor(r3)
                                r9.setBackgroundColor(r1)
                            L_0x04d2:
                                int r9 = net.one97.paytm.vipcashback.R.id.swipeRefresh
                                android.view.View r9 = r8.b((int) r9)
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
                                if (r9 == 0) goto L_0x04e0
                                android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
                            L_0x04e0:
                                if (r2 == 0) goto L_0x04f8
                                android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                                r2.setMargins(r10, r10, r10, r10)
                                int r9 = net.one97.paytm.vipcashback.R.id.swipeRefresh
                                android.view.View r9 = r8.b((int) r9)
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
                                if (r9 == 0) goto L_0x0822
                                android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
                                r9.setLayoutParams(r2)
                                goto L_0x0822
                            L_0x04f8:
                                kotlin.u r9 = new kotlin.u
                                r9.<init>(r4)
                                throw r9
                            L_0x04fe:
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20779c
                                if (r9 != r3) goto L_0x0649
                                int r9 = net.one97.paytm.vipcashback.R.id.backArrowOffer
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x0515
                                int r1 = net.one97.paytm.vipcashback.R.drawable.ic_back_brown_cashback
                                r9.setImageResource(r1)
                            L_0x0515:
                                int r9 = net.one97.paytm.vipcashback.R.id.amountHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                java.lang.String r1 = "#D5A55D"
                                if (r9 == 0) goto L_0x0528
                                int r3 = android.graphics.Color.parseColor(r1)
                                r9.setTextColor(r3)
                            L_0x0528:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0546
                                android.content.Context r3 = r8.getContext()
                                if (r3 != 0) goto L_0x053b
                                kotlin.g.b.k.a()
                            L_0x053b:
                                int r7 = net.one97.paytm.vipcashback.R.string.jr_pc_paytm_coins
                                java.lang.String r3 = r3.getString(r7)
                                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                                r9.setText(r3)
                            L_0x0546:
                                int r9 = net.one97.paytm.vipcashback.R.id.rupeeToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0553
                                r9.setVisibility(r6)
                            L_0x0553:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0564
                                int r3 = android.graphics.Color.parseColor(r1)
                                r9.setTextColor(r3)
                            L_0x0564:
                                int r9 = net.one97.paytm.vipcashback.R.id.reedem
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.Button r9 = (android.widget.Button) r9
                                if (r9 == 0) goto L_0x0571
                                r9.setVisibility(r10)
                            L_0x0571:
                                int r9 = net.one97.paytm.vipcashback.R.id.reedemRightArrow
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x057e
                                r9.setVisibility(r10)
                            L_0x057e:
                                net.one97.paytm.vipcashback.f.f r9 = net.one97.paytm.vipcashback.f.f.a()
                                java.lang.String r3 = "GTMHelper.getInstance()"
                                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
                                java.lang.String r9 = net.one97.paytm.vipcashback.f.f.V()
                                int r3 = net.one97.paytm.vipcashback.R.id.reedem
                                android.view.View r3 = r8.b((int) r3)
                                android.widget.Button r3 = (android.widget.Button) r3
                                if (r3 == 0) goto L_0x059f
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$e r6 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$e
                                r6.<init>(r8, r9)
                                android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
                                r3.setOnClickListener(r6)
                            L_0x059f:
                                int r3 = net.one97.paytm.vipcashback.R.id.reedemRightArrow
                                android.view.View r3 = r8.b((int) r3)
                                android.widget.ImageView r3 = (android.widget.ImageView) r3
                                if (r3 == 0) goto L_0x05b3
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$f r6 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$f
                                r6.<init>(r8, r9)
                                android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
                                r3.setOnClickListener(r6)
                            L_0x05b3:
                                int r3 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r3 = r8.b((int) r3)
                                android.widget.TextView r3 = (android.widget.TextView) r3
                                if (r3 == 0) goto L_0x05c4
                                int r1 = android.graphics.Color.parseColor(r1)
                                r3.setTextColor(r1)
                            L_0x05c4:
                                int r1 = net.one97.paytm.vipcashback.R.id.reedemToolbar
                                android.view.View r1 = r8.b((int) r1)
                                android.widget.Button r1 = (android.widget.Button) r1
                                if (r1 == 0) goto L_0x05d1
                                r1.setVisibility(r10)
                            L_0x05d1:
                                int r1 = net.one97.paytm.vipcashback.R.id.reedemRightArrowToolbar
                                android.view.View r1 = r8.b((int) r1)
                                android.widget.ImageView r1 = (android.widget.ImageView) r1
                                if (r1 == 0) goto L_0x05de
                                r1.setVisibility(r10)
                            L_0x05de:
                                int r1 = net.one97.paytm.vipcashback.R.id.reedemToolbar
                                android.view.View r1 = r8.b((int) r1)
                                android.widget.Button r1 = (android.widget.Button) r1
                                if (r1 == 0) goto L_0x05f2
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$g r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$g
                                r3.<init>(r8, r9)
                                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                                r1.setOnClickListener(r3)
                            L_0x05f2:
                                int r1 = net.one97.paytm.vipcashback.R.id.reedemRightArrowToolbar
                                android.view.View r1 = r8.b((int) r1)
                                android.widget.ImageView r1 = (android.widget.ImageView) r1
                                if (r1 == 0) goto L_0x0606
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$h r3 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$h
                                r3.<init>(r8, r9)
                                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                                r1.setOnClickListener(r3)
                            L_0x0606:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerImage
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x061d
                                android.content.res.Resources r1 = r8.getResources()
                                int r3 = net.one97.paytm.vipcashback.R.color.color_191e33
                                int r1 = r1.getColor(r3)
                                r9.setBackgroundColor(r1)
                            L_0x061d:
                                int r9 = net.one97.paytm.vipcashback.R.id.swipeRefresh
                                android.view.View r9 = r8.b((int) r9)
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
                                if (r9 == 0) goto L_0x062b
                                android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
                            L_0x062b:
                                if (r2 == 0) goto L_0x0643
                                android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                                r2.setMargins(r10, r10, r10, r10)
                                int r9 = net.one97.paytm.vipcashback.R.id.swipeRefresh
                                android.view.View r9 = r8.b((int) r9)
                                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
                                if (r9 == 0) goto L_0x0822
                                android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
                                r9.setLayoutParams(r2)
                                goto L_0x0822
                            L_0x0643:
                                kotlin.u r9 = new kotlin.u
                                r9.<init>(r4)
                                throw r9
                            L_0x0649:
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20780d
                                if (r9 == r3) goto L_0x0700
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.j
                                if (r9 != r3) goto L_0x065b
                                goto L_0x0700
                            L_0x065b:
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20781e
                                if (r9 == r3) goto L_0x066b
                                net.one97.paytm.vipcashback.d.a$b$a r3 = net.one97.paytm.vipcashback.d.a.b.f20777a
                                int r3 = net.one97.paytm.vipcashback.d.a.b.f20784h
                                if (r9 != r3) goto L_0x0822
                            L_0x066b:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0678
                                r9.setVisibility(r6)
                            L_0x0678:
                                int r9 = net.one97.paytm.vipcashback.R.id.amountHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0685
                                r9.setVisibility(r6)
                            L_0x0685:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerTitle
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0692
                                r9.setVisibility(r10)
                            L_0x0692:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerTitle
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x06a3
                                java.lang.String r3 = r8.m
                                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                                r9.setText(r3)
                            L_0x06a3:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerTitle
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x06b1
                                android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
                            L_0x06b1:
                                if (r2 == 0) goto L_0x06fa
                                android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                                android.content.res.Resources r9 = r8.getResources()
                                int r3 = net.one97.paytm.common.assets.R.dimen.dimen_14dp
                                int r9 = r9.getDimensionPixelOffset(r3)
                                r2.bottomMargin = r9
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x06ce
                                r9.setVisibility(r6)
                            L_0x06ce:
                                java.lang.String r9 = r8.n
                                if (r9 == 0) goto L_0x0822
                                r2 = r9
                                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                                int r2 = r2.length()
                                if (r2 <= 0) goto L_0x06dc
                                goto L_0x06dd
                            L_0x06dc:
                                r1 = 0
                            L_0x06dd:
                                if (r1 == 0) goto L_0x0822
                                com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
                                com.squareup.picasso.aa r9 = r1.a((java.lang.String) r9)
                                int r1 = net.one97.paytm.vipcashback.R.drawable.header_bg_cashback
                                com.squareup.picasso.aa r9 = r9.a((int) r1)
                                int r1 = net.one97.paytm.vipcashback.R.id.headerImage
                                android.view.View r1 = r8.b((int) r1)
                                android.widget.ImageView r1 = (android.widget.ImageView) r1
                                r9.a((android.widget.ImageView) r1)
                                goto L_0x0822
                            L_0x06fa:
                                kotlin.u r9 = new kotlin.u
                                r9.<init>(r4)
                                throw r9
                            L_0x0700:
                                int r9 = net.one97.paytm.vipcashback.R.id.appBarLayout
                                android.view.View r9 = r8.b((int) r9)
                                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                                if (r9 == 0) goto L_0x070d
                                r9.setExpanded(r10, r10)
                            L_0x070d:
                                int r9 = net.one97.paytm.vipcashback.R.id.appBarLayout
                                android.view.View r9 = r8.b((int) r9)
                                com.google.android.material.appbar.AppBarLayout r9 = (com.google.android.material.appbar.AppBarLayout) r9
                                android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
                                if (r9 == 0) goto L_0x07cc
                                androidx.coordinatorlayout.widget.CoordinatorLayout$d r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r9
                                android.content.res.Resources r2 = r8.getResources()
                                int r3 = net.one97.paytm.common.assets.R.dimen.dimen_64dp
                                float r2 = r2.getDimension(r3)
                                int r2 = (int) r2
                                r9.height = r2
                                int r9 = net.one97.paytm.vipcashback.R.id.headerTitle
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0737
                                r9.setVisibility(r6)
                            L_0x0737:
                                int r9 = net.one97.paytm.vipcashback.R.id.amountHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0744
                                r9.setVisibility(r6)
                            L_0x0744:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0751
                                r9.setVisibility(r6)
                            L_0x0751:
                                int r9 = net.one97.paytm.vipcashback.R.id.backArrowOffer
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x0760
                                int r2 = net.one97.paytm.vipcashback.R.drawable.ic_ico_back
                                r9.setImageResource(r2)
                            L_0x0760:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerImage
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x0777
                                android.content.res.Resources r2 = r8.getResources()
                                int r3 = net.one97.paytm.vipcashback.R.color.white
                                int r2 = r2.getColor(r3)
                                r9.setBackgroundColor(r2)
                            L_0x0777:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0784
                                r9.setVisibility(r10)
                            L_0x0784:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x079b
                                android.content.res.Resources r2 = r8.getResources()
                                int r3 = net.one97.paytm.vipcashback.R.color.color_1d252d
                                int r2 = r2.getColor(r3)
                                r9.setTextColor(r2)
                            L_0x079b:
                                java.lang.String r9 = r8.q
                                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                                if (r9 == 0) goto L_0x07a9
                                int r9 = r9.length()
                                if (r9 != 0) goto L_0x07a8
                                goto L_0x07a9
                            L_0x07a8:
                                r1 = 0
                            L_0x07a9:
                                if (r1 != 0) goto L_0x07bc
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x07bc
                                java.lang.String r1 = r8.q
                                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                                r9.setText(r1)
                            L_0x07bc:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0822
                                r1 = 1065353216(0x3f800000, float:1.0)
                                r9.setAlpha(r1)
                                goto L_0x0822
                            L_0x07cc:
                                kotlin.u r9 = new kotlin.u
                                java.lang.String r10 = "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams"
                                r9.<init>(r10)
                                throw r9
                            L_0x07d4:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x07e1
                                r9.setVisibility(r6)
                            L_0x07e1:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerTitle
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x07ee
                                r9.setVisibility(r6)
                            L_0x07ee:
                                int r9 = net.one97.paytm.vipcashback.R.id.backArrowOffer
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x07fb
                                r9.setVisibility(r6)
                            L_0x07fb:
                                int r9 = net.one97.paytm.vipcashback.R.id.headerImage
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.ImageView r9 = (android.widget.ImageView) r9
                                if (r9 == 0) goto L_0x0808
                                r9.setVisibility(r6)
                            L_0x0808:
                                int r9 = net.one97.paytm.vipcashback.R.id.amountHeading
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0815
                                r9.setVisibility(r6)
                            L_0x0815:
                                int r9 = net.one97.paytm.vipcashback.R.id.singleHeadingToolbar
                                android.view.View r9 = r8.b((int) r9)
                                android.widget.TextView r9 = (android.widget.TextView) r9
                                if (r9 == 0) goto L_0x0822
                                r9.setVisibility(r6)
                            L_0x0822:
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$i r9 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$i
                                r9.<init>(r8)
                                kotlin.g.a.b r9 = (kotlin.g.a.b) r9
                                r8.C = r9
                                net.one97.paytm.v2.features.b.c.a r9 = r8.B
                                if (r9 == 0) goto L_0x083f
                                androidx.lifecycle.y<net.one97.paytm.common.entity.vipcashback.ScratchCard> r9 = r9.f20108g
                                androidx.lifecycle.LiveData r9 = (androidx.lifecycle.LiveData) r9
                                if (r9 == 0) goto L_0x083f
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$j r1 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$j
                                r1.<init>(r8)
                                androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
                                r9.observe(r0, r1)
                            L_0x083f:
                                net.one97.paytm.v2.features.cashbacklanding.c.b r9 = r8.f20402b
                                if (r9 != 0) goto L_0x0846
                                kotlin.g.b.k.a((java.lang.String) r5)
                            L_0x0846:
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$q r0 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$q
                                r0.<init>(r8)
                                kotlin.g.a.m r0 = (kotlin.g.a.m) r0
                                r9.f20149a = r0
                                kotlin.g.b.x$a r9 = new kotlin.g.b.x$a
                                r9.<init>()
                                r9.element = r10
                                int r10 = net.one97.paytm.vipcashback.R.id.appBarLayout
                                android.view.View r10 = r8.b((int) r10)
                                com.google.android.material.appbar.AppBarLayout r10 = (com.google.android.material.appbar.AppBarLayout) r10
                                if (r10 == 0) goto L_0x086a
                                net.one97.paytm.v2.features.cashbackoffers.ui.a$r r0 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$r
                                r0.<init>(r8, r9)
                                com.google.android.material.appbar.AppBarLayout$b r0 = (com.google.android.material.appbar.AppBarLayout.b) r0
                                r10.a((com.google.android.material.appbar.AppBarLayout.b) r0)
                            L_0x086a:
                                return
                            L_0x086b:
                                kotlin.u r9 = new kotlin.u
                                java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.viewmodel.VoucherViewModel"
                                r9.<init>(r10)
                                throw r9
                            L_0x0873:
                                kotlin.u r9 = new kotlin.u
                                java.lang.String r10 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
                                r9.<init>(r10)
                                throw r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.ui.a.onViewCreated(android.view.View, android.os.Bundle):void");
                        }

                        static final class k implements View.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20419a;

                            k(a aVar) {
                                this.f20419a = aVar;
                            }

                            public final void onClick(View view) {
                                if (!(this.f20419a.f20405e.length() > 0) || !this.f20419a.p) {
                                    FragmentActivity activity = this.f20419a.getActivity();
                                    if (activity != null) {
                                        activity.onBackPressed();
                                        return;
                                    }
                                    return;
                                }
                                FragmentActivity activity2 = this.f20419a.getActivity();
                                if (activity2 != null) {
                                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                                    String str = this.f20419a.f20405e;
                                    kotlin.g.b.k.a((Object) activity2, "it1");
                                    d.a.a(str, (Context) activity2);
                                }
                            }
                        }

                        static final class r implements AppBarLayout.b {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20430a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ x.a f20431b;

                            r(a aVar, x.a aVar2) {
                                this.f20430a = aVar;
                                this.f20431b = aVar2;
                            }

                            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                                if (!this.f20431b.element) {
                                    int f2 = this.f20430a.j;
                                    a.b.C0384a aVar = a.b.f20777a;
                                    if (f2 != a.b.f20780d) {
                                        int f3 = this.f20430a.j;
                                        a.b.C0384a aVar2 = a.b.f20777a;
                                        if (f3 != a.b.j) {
                                            this.f20431b.element = true;
                                            float abs = ((float) Math.abs(i2)) / ((float) ((Number) this.f20430a.u.getValue()).intValue());
                                            float abs2 = 1.0f - (((float) (Math.abs(i2) * 3)) / ((float) ((Number) this.f20430a.u.getValue()).intValue()));
                                            TextView textView = (TextView) this.f20430a.b(R.id.headerTitle);
                                            if (textView != null) {
                                                float j = ((float) this.f20430a.y) - ((((float) ((Number) this.f20430a.z.getValue()).intValue()) / ((float) ((Number) this.f20430a.u.getValue()).intValue())) * ((float) Math.abs(i2)));
                                                Resources resources = this.f20430a.getResources();
                                                kotlin.g.b.k.a((Object) resources, "resources");
                                                textView.setTextSize(j / resources.getDisplayMetrics().scaledDensity);
                                            }
                                            TextView textView2 = (TextView) this.f20430a.b(R.id.headerTitle);
                                            if (textView2 != null) {
                                                textView2.setTranslationX(((float) ((Number) this.f20430a.A.getValue()).intValue()) * (((float) Math.abs(i2)) / ((float) ((Number) this.f20430a.u.getValue()).intValue())));
                                            }
                                            int abs3 = Math.abs(i2);
                                            kotlin.g.b.k.a((Object) appBarLayout, "appBarLayout");
                                            ViewGroup.LayoutParams layoutParams = null;
                                            if (abs3 == appBarLayout.getTotalScrollRange()) {
                                                TextView textView3 = (TextView) this.f20430a.b(R.id.headerTitle);
                                                if (textView3 != null) {
                                                    textView3.setTranslationX((((float) ((Number) this.f20430a.A.getValue()).intValue()) * (((float) Math.abs(i2)) / ((float) ((Number) this.f20430a.u.getValue()).intValue()))) - this.f20430a.getResources().getDimension(R.dimen.dimen_10dp));
                                                }
                                                TextView textView4 = (TextView) this.f20430a.b(R.id.headerTitle);
                                                ViewGroup.LayoutParams layoutParams2 = textView4 != null ? textView4.getLayoutParams() : null;
                                                if (layoutParams2 != null) {
                                                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = this.f20430a.getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_22dp);
                                                } else {
                                                    throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                                }
                                            }
                                            if (i2 == 0) {
                                                TextView textView5 = (TextView) this.f20430a.b(R.id.headerTitle);
                                                if (textView5 != null) {
                                                    layoutParams = textView5.getLayoutParams();
                                                }
                                                if (layoutParams != null) {
                                                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.f20430a.getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_14dp);
                                                } else {
                                                    throw new kotlin.u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                                }
                                            }
                                            TextView textView6 = (TextView) this.f20430a.b(R.id.ruppeSymbol);
                                            if (textView6 != null) {
                                                textView6.setAlpha(abs2);
                                            }
                                            TextView textView7 = (TextView) this.f20430a.b(R.id.amountHeading);
                                            if (textView7 != null) {
                                                textView7.setAlpha(abs2);
                                            }
                                            TextView textView8 = (TextView) this.f20430a.b(R.id.singleHeading);
                                            if (textView8 != null) {
                                                textView8.setAlpha(abs2);
                                            }
                                            Button button = (Button) this.f20430a.b(R.id.reedem);
                                            if (button != null) {
                                                button.setAlpha(abs2);
                                            }
                                            ImageView imageView = (ImageView) this.f20430a.b(R.id.reedemRightArrow);
                                            if (imageView != null) {
                                                imageView.setAlpha(abs2);
                                            }
                                            TextView textView9 = (TextView) this.f20430a.b(R.id.singleHeadingToolbar);
                                            if (textView9 != null) {
                                                textView9.setAlpha(abs);
                                            }
                                            TextView textView10 = (TextView) this.f20430a.b(R.id.rupeeToolbar);
                                            if (textView10 != null) {
                                                textView10.setAlpha(abs);
                                            }
                                            Button button2 = (Button) this.f20430a.b(R.id.reedemToolbar);
                                            if (button2 != null) {
                                                button2.setAlpha(abs);
                                            }
                                            ImageView imageView2 = (ImageView) this.f20430a.b(R.id.reedemRightArrowToolbar);
                                            if (imageView2 != null) {
                                                imageView2.setAlpha(abs);
                                            }
                                            this.f20431b.element = false;
                                        }
                                    }
                                }
                            }
                        }

                        public void onRefresh() {
                            RecyclerView.l lVar = this.f20406f;
                            if (lVar != null) {
                                ((RecyclerView) b(R.id.recyclerView)).removeOnScrollListener(lVar);
                                this.f20406f = null;
                            }
                            net.one97.paytm.v2.features.cashbackoffers.c.a aVar = this.f20403c;
                            if (aVar != null) {
                                aVar.a(this.m);
                            }
                        }

                        static final class e implements View.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20409a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f20410b;

                            e(a aVar, String str) {
                                this.f20409a = aVar;
                                this.f20410b = str;
                            }

                            public final void onClick(View view) {
                                String str = this.f20410b;
                                if (str != null) {
                                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20409a.getContext(), str);
                                }
                            }
                        }

                        static final class f implements View.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20411a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f20412b;

                            f(a aVar, String str) {
                                this.f20411a = aVar;
                                this.f20412b = str;
                            }

                            public final void onClick(View view) {
                                String str = this.f20412b;
                                if (str != null) {
                                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20411a.getContext(), str);
                                }
                            }
                        }

                        static final class g implements View.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20413a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f20414b;

                            g(a aVar, String str) {
                                this.f20413a = aVar;
                                this.f20414b = str;
                            }

                            public final void onClick(View view) {
                                String str = this.f20414b;
                                if (str != null) {
                                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20413a.getContext(), str);
                                }
                            }
                        }

                        static final class h implements View.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20415a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f20416b;

                            h(a aVar, String str) {
                                this.f20415a = aVar;
                                this.f20416b = str;
                            }

                            public final void onClick(View view) {
                                String str = this.f20416b;
                                if (str != null) {
                                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20415a.getContext(), str);
                                }
                            }
                        }

                        public static final class i implements kotlin.g.a.b<ScratchCard, kotlin.x> {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ a f20417a;

                            /* renamed from: net.one97.paytm.v2.features.cashbackoffers.ui.a$i$a  reason: collision with other inner class name */
                            static final class C0367a extends kotlin.g.b.l implements kotlin.g.a.b<Boolean, kotlin.x> {
                                final /* synthetic */ i this$0;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                C0367a(i iVar) {
                                    super(1);
                                    this.this$0 = iVar;
                                }

                                public final /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Boolean) obj).booleanValue());
                                    return kotlin.x.f47997a;
                                }

                                public final void invoke(boolean z) {
                                    this.this$0.f20417a.f20407g = null;
                                }
                            }

                            i(a aVar) {
                                this.f20417a = aVar;
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
                                r0 = r0.getWindow();
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final /* synthetic */ java.lang.Object invoke(java.lang.Object r7) {
                                /*
                                    r6 = this;
                                    net.one97.paytm.common.entity.vipcashback.ScratchCard r7 = (net.one97.paytm.common.entity.vipcashback.ScratchCard) r7
                                    java.lang.String r0 = "scratchCard"
                                    kotlin.g.b.k.c(r7, r0)
                                    net.one97.paytm.v2.features.cashbackoffers.ui.a r0 = r6.f20417a
                                    androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                                    if (r0 == 0) goto L_0x001a
                                    android.view.Window r0 = r0.getWindow()
                                    if (r0 == 0) goto L_0x001a
                                    android.view.View r0 = r0.getDecorView()
                                    goto L_0x001b
                                L_0x001a:
                                    r0 = 0
                                L_0x001b:
                                    if (r0 == 0) goto L_0x0054
                                    android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                                    net.one97.paytm.v2.features.cashbackoffers.ui.a r1 = r6.f20417a
                                    net.one97.paytm.v2.features.b.b.a r2 = new net.one97.paytm.v2.features.b.b.a
                                    androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
                                    if (r3 != 0) goto L_0x002c
                                    kotlin.g.b.k.a()
                                L_0x002c:
                                    java.lang.String r4 = "activity!!"
                                    kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                                    net.one97.paytm.v2.features.cashbackoffers.ui.a r4 = r6.f20417a
                                    net.one97.paytm.v2.features.b.c.a r4 = r4.B
                                    if (r4 != 0) goto L_0x003c
                                    kotlin.g.b.k.a()
                                L_0x003c:
                                    net.one97.paytm.v2.features.cashbackoffers.ui.a$i$a r5 = new net.one97.paytm.v2.features.cashbackoffers.ui.a$i$a
                                    r5.<init>(r6)
                                    kotlin.g.a.b r5 = (kotlin.g.a.b) r5
                                    r2.<init>(r0, r3, r4, r5)
                                    r1.f20407g = r2
                                    net.one97.paytm.v2.features.cashbackoffers.ui.a r0 = r6.f20417a
                                    net.one97.paytm.v2.features.b.b.a r0 = r0.f20407g
                                    if (r0 == 0) goto L_0x0051
                                    r0.a(r7)
                                L_0x0051:
                                    kotlin.x r7 = kotlin.x.f47997a
                                    return r7
                                L_0x0054:
                                    kotlin.u r7 = new kotlin.u
                                    java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup"
                                    r7.<init>(r0)
                                    throw r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbackoffers.ui.a.i.invoke(java.lang.Object):java.lang.Object");
                            }
                        }

                        public void a(int i2) {
                            View b2 = b(R.id.no_network);
                            kotlin.g.b.k.a((Object) b2, "no_network");
                            b2.setVisibility(i2);
                        }

                        public void onActivityResult(int i2, int i3, Intent intent) {
                            super.onActivityResult(i2, i3, intent);
                            if (i3 == -1 && i2 == 105) {
                                this.p = true;
                            }
                        }

                        public static final /* synthetic */ void d(a aVar) {
                            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aVar.b(R.id.offerShimmerLayout);
                            if (shimmerFrameLayout != null) {
                                shimmerFrameLayout.b();
                            }
                            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) aVar.b(R.id.offerShimmerLayout);
                            if (shimmerFrameLayout2 != null) {
                                shimmerFrameLayout2.setVisibility(8);
                            }
                        }
                    }
