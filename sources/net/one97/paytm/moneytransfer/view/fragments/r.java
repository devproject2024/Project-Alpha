package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.h;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.presenter.g;
import net.one97.paytm.moneytransfer.view.a.c;
import net.one97.paytm.upi.common.ShimmerFrameLayout;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.passbook.view.UpiPassbookTransactionDetailActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class r extends h implements h.b, c.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54620a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f54621b;

    /* renamed from: c  reason: collision with root package name */
    private ShimmerFrameLayout f54622c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f54623d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f54624e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<UpiTransactionModelV2> f54625f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private h.a f54626g;

    /* renamed from: h  reason: collision with root package name */
    private c f54627h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f54628i = 4;
    /* access modifiers changed from: private */
    public boolean j;
    private HashMap k;

    public static final /* synthetic */ c a(r rVar) {
        c cVar = rVar.f54627h;
        if (cVar == null) {
            k.a("mListAdapter");
        }
        return cVar;
    }

    public static final /* synthetic */ RecyclerView b(r rVar) {
        RecyclerView recyclerView = rVar.f54624e;
        if (recyclerView == null) {
            k.a("mTxnRecyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ h.a e(r rVar) {
        h.a aVar = rVar.f54626g;
        if (aVar == null) {
            k.a("mPresenter");
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_user_history, viewGroup, false);
        h.b bVar = this;
        if (getActivity() == null) {
            k.a();
        }
        this.f54626g = new g(bVar, net.one97.paytm.upi.g.b());
        String str = null;
        FrameLayout frameLayout = inflate != null ? (FrameLayout) inflate.findViewById(R.id.progress_layout_history) : null;
        if (frameLayout != null) {
            this.f54621b = frameLayout;
            View findViewById = inflate.findViewById(R.id.contacts_shimmer_layout);
            if (findViewById != null) {
                this.f54622c = (ShimmerFrameLayout) findViewById;
                View findViewById2 = inflate.findViewById(R.id.ll_no_transaction);
                if (findViewById2 != null) {
                    this.f54623d = (LinearLayout) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.transactions_list);
                    if (findViewById3 != null) {
                        this.f54624e = (RecyclerView) findViewById3;
                        RecyclerView recyclerView = this.f54624e;
                        if (recyclerView == null) {
                            k.a("mTxnRecyclerView");
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        this.f54627h = new c(this.f54625f, getActivity(), this);
                        RecyclerView recyclerView2 = this.f54624e;
                        if (recyclerView2 == null) {
                            k.a("mTxnRecyclerView");
                        }
                        c cVar = this.f54627h;
                        if (cVar == null) {
                            k.a("mListAdapter");
                        }
                        recyclerView2.setAdapter(cVar);
                        h.a aVar = this.f54626g;
                        if (aVar == null) {
                            k.a("mPresenter");
                        }
                        Bundle arguments = getArguments();
                        if (arguments != null) {
                            str = arguments.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                        }
                        if (str == null) {
                            k.a();
                        }
                        k.a((Object) str, "arguments?.getString(CJR…amConstants.ACC_NUMBER)!!");
                        aVar.a(str);
                        RecyclerView recyclerView3 = this.f54624e;
                        if (recyclerView3 == null) {
                            k.a("mTxnRecyclerView");
                        }
                        recyclerView3.addOnScrollListener(new b(this));
                        return inflate;
                    }
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                }
                throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.ShimmerFrameLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public static final class b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f54629a;

        b(r rVar) {
            this.f54629a = rVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 2) {
                int itemCount = r.a(this.f54629a).getItemCount();
                RecyclerView.LayoutManager layoutManager = r.b(this.f54629a).getLayoutManager();
                if (layoutManager == null) {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                } else if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= itemCount - this.f54629a.f54628i && !this.f54629a.j) {
                    h.a e2 = r.e(this.f54629a);
                    Bundle arguments = this.f54629a.getArguments();
                    String string = arguments != null ? arguments.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER) : null;
                    if (string == null) {
                        k.a();
                    }
                    k.a((Object) string, "arguments?.getString(CJR…amConstants.ACC_NUMBER)!!");
                    e2.a(string);
                }
            }
        }
    }

    public final void a(ArrayList<UpiTransactionModelV2> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.j = true;
            ArrayList<UpiTransactionModelV2> arrayList2 = this.f54625f;
            if (arrayList2 != null && arrayList2.size() == 0) {
                LinearLayout linearLayout = this.f54623d;
                if (linearLayout == null) {
                    k.a("mNoTxnsLayout");
                }
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        ArrayList<UpiTransactionModelV2> arrayList3 = this.f54625f;
        Integer valueOf = arrayList3 != null ? Integer.valueOf(arrayList3.size()) : null;
        ArrayList<UpiTransactionModelV2> arrayList4 = this.f54625f;
        if (arrayList4 != null) {
            arrayList4.addAll(arrayList);
        }
        c cVar = this.f54627h;
        if (cVar == null) {
            k.a("mListAdapter");
        }
        if (valueOf == null) {
            k.a();
        }
        cVar.notifyItemRangeInserted(valueOf.intValue(), arrayList.size());
    }

    public final void a(boolean z) {
        if (z) {
            FrameLayout frameLayout = this.f54621b;
            if (frameLayout == null) {
                k.a("mHistoryProgressLayout");
            }
            frameLayout.setVisibility(0);
            ShimmerFrameLayout shimmerFrameLayout = this.f54622c;
            if (shimmerFrameLayout == null) {
                k.a("mShimmerLayout");
            }
            shimmerFrameLayout.startShimmerAnimation();
            return;
        }
        FrameLayout frameLayout2 = this.f54621b;
        if (frameLayout2 == null) {
            k.a("mHistoryProgressLayout");
        }
        frameLayout2.setVisibility(8);
        ShimmerFrameLayout shimmerFrameLayout2 = this.f54622c;
        if (shimmerFrameLayout2 == null) {
            k.a("mShimmerLayout");
        }
        shimmerFrameLayout2.stopShimmerAnimation();
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        String str = null;
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError != null ? upiCustomVolleyError.getMessage() : null, true)) {
            d.a aVar = d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = d.b(d.a.a());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            String name = r.class.getName();
            k.a((Object) name, "MoneyTransferUserHistory…ent::class.java.getName()");
            b2.a((Activity) activity, (Exception) upiCustomVolleyError, name);
            return;
        }
        Context activity2 = getActivity();
        if (upiCustomVolleyError != null) {
            str = upiCustomVolleyError.getAlertMessage();
        }
        com.paytm.utility.b.b(activity2, "Error", str);
    }

    public final void a(UpiTransactionModelV2 upiTransactionModelV2) {
        k.c(upiTransactionModelV2, "upiTransactionModelV2");
        Intent intent = new Intent(getActivity(), UpiPassbookTransactionDetailActivity.class);
        intent.putExtra("transaction", upiTransactionModelV2);
        intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, false);
        startActivity(intent);
    }

    public final void onDestroy() {
        super.onDestroy();
        h.a aVar = this.f54626g;
        if (aVar == null) {
            k.a("mPresenter");
        }
        aVar.a();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
