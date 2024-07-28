package net.one97.paytm.passbook.subWallet.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.search.a.a;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.m;

public final class e extends h implements a.c, a.d {

    /* renamed from: a  reason: collision with root package name */
    private int f58854a;

    /* renamed from: b  reason: collision with root package name */
    private CJRSubWallet f58855b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.passbook.subWallet.d.a f58856c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.passbook.search.a.a f58857d;

    /* renamed from: e  reason: collision with root package name */
    private String f58858e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f58859f;

    public final View a(int i2) {
        if (this.f58859f == null) {
            this.f58859f = new HashMap();
        }
        View view = (View) this.f58859f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f58859f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<ArrayList<CJRTransaction>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f58864a;

        c(e eVar) {
            this.f58864a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList<CJRTransaction> arrayList = (ArrayList) obj;
            net.one97.paytm.passbook.search.a.a a2 = e.a(this.f58864a);
            if (arrayList != null) {
                a2.f58350b = arrayList;
                a2.notifyDataSetChanged();
                m.a aVar = m.f59265a;
                net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                k.a((Object) b2, "PassbookHelper.getImplListener()");
                Context b3 = b2.b();
                k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
                com.paytm.b.a.a a3 = m.a.a(b3);
                if (!a3.b("is_passbook_slide_animation_shown", false, true)) {
                    a3.a("is_passbook_slide_animation_shown", true, true);
                    x.e eVar = new x.e();
                    eVar.element = "1";
                    Handler handler = new Handler();
                    handler.postDelayed(new a.f(a2, eVar), 1000);
                    handler.postDelayed(new a.g(a2, eVar), 2000);
                }
            }
            if (arrayList != null && arrayList.size() == 0) {
                RelativeLayout relativeLayout = (RelativeLayout) this.f58864a.a(R.id.rlNoData);
                k.a((Object) relativeLayout, "rlNoData");
                relativeLayout.setVisibility(0);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f58865a;

        d(e eVar) {
            this.f58865a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            final net.one97.paytm.passbook.mapping.a.e eVar = (net.one97.paytm.passbook.mapping.a.e) obj;
            e.b(this.f58865a).f58911c.postValue(Boolean.FALSE);
            FragmentActivity activity = this.f58865a.getActivity();
            if (activity != null) {
                ((BaseActivity) activity).a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f58866a;

                    {
                        this.f58866a = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        net.one97.paytm.passbook.subWallet.d.a b2 = e.b(this.f58866a.f58865a);
                        net.one97.paytm.passbook.mapping.a.e eVar = eVar;
                        if (eVar == null) {
                            k.a();
                        }
                        b2.a(eVar);
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.base.BaseActivity");
        }
    }

    /* renamed from: net.one97.paytm.passbook.subWallet.b.e$e  reason: collision with other inner class name */
    static final class C1133e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f58868a;

        C1133e(e eVar) {
            this.f58868a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (e.a(this.f58868a).getItemCount() > 0) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f58868a.a(R.id.loaderBottom);
                k.a((Object) lottieAnimationView, "loaderBottom");
                if (bool == null) {
                    k.a();
                }
                e.a(lottieAnimationView, bool.booleanValue());
                return;
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f58868a.a(R.id.loaderCenter);
            k.a((Object) lottieAnimationView2, "loaderCenter");
            if (bool == null) {
                k.a();
            }
            e.a(lottieAnimationView2, bool.booleanValue());
        }
    }

    public e() {
    }

    public static final /* synthetic */ net.one97.paytm.passbook.search.a.a a(e eVar) {
        net.one97.paytm.passbook.search.a.a aVar = eVar.f58857d;
        if (aVar == null) {
            k.a("adapter");
        }
        return aVar;
    }

    public static final /* synthetic */ net.one97.paytm.passbook.subWallet.d.a b(e eVar) {
        net.one97.paytm.passbook.subWallet.d.a aVar = eVar.f58856c;
        if (aVar == null) {
            k.a("walletTxnVM");
        }
        return aVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e(Context context, int i2, CJRSubWallet cJRSubWallet, String str) {
        this();
        k.c(context, "context");
        this.f58854a = i2;
        this.f58855b = cJRSubWallet;
        this.f58858e = str;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_fragment_subwallet_transactions, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.subWallet.d.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…onsViewModel::class.java)");
        this.f58856c = (net.one97.paytm.passbook.subWallet.d.a) a2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.f58857d = new net.one97.paytm.passbook.search.a.a(this, this, this.f58854a);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvPassbookEntries);
        k.a((Object) recyclerView, "rvPassbookEntries");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvPassbookEntries);
        k.a((Object) recyclerView2, "rvPassbookEntries");
        net.one97.paytm.passbook.search.a.a aVar = this.f58857d;
        if (aVar == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(aVar);
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rvPassbookEntries);
        net.one97.paytm.passbook.search.a.a aVar2 = this.f58857d;
        if (aVar2 == null) {
            k.a("adapter");
        }
        recyclerView3.addItemDecoration(new net.one97.paytm.passbook.search.b.a(aVar2));
        net.one97.paytm.passbook.subWallet.d.a aVar3 = this.f58856c;
        if (aVar3 == null) {
            k.a("walletTxnVM");
        }
        q qVar = this;
        aVar3.f58909a.observe(qVar, new c(this));
        net.one97.paytm.passbook.subWallet.d.a aVar4 = this.f58856c;
        if (aVar4 == null) {
            k.a("walletTxnVM");
        }
        aVar4.f58910b.observe(qVar, new d(this));
        net.one97.paytm.passbook.subWallet.d.a aVar5 = this.f58856c;
        if (aVar5 == null) {
            k.a("walletTxnVM");
        }
        aVar5.f58911c.observe(qVar, new C1133e(this));
        a();
    }

    private final void a() {
        net.one97.paytm.passbook.subWallet.d.a aVar = this.f58856c;
        if (aVar == null) {
            k.a("walletTxnVM");
        }
        int i2 = this.f58854a;
        CJRSubWallet cJRSubWallet = this.f58855b;
        aVar.a(i2, cJRSubWallet != null ? cJRSubWallet.getSubWalletName() : null, this.f58858e);
    }

    public final void c() {
        net.one97.paytm.passbook.subWallet.d.a aVar = this.f58856c;
        if (aVar == null) {
            k.a("walletTxnVM");
        }
        if (!aVar.f58912d) {
            net.one97.paytm.passbook.subWallet.d.a aVar2 = this.f58856c;
            if (aVar2 == null) {
                k.a("walletTxnVM");
            }
            if (!aVar2.f58913e) {
                a();
            }
        }
    }

    public static final class a implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f58860a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58861b;

        a(e eVar, int i2) {
            this.f58860a = eVar;
            this.f58861b = i2;
        }

        public final void a() {
            e.a(this.f58860a).notifyItemChanged(this.f58861b);
            e.c(this.f58860a);
        }
    }

    public final void a(int i2, CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String string = getString(R.string.tag_this_payment);
        k.a((Object) string, "getString(R.string.tag_this_payment)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new a(this, i2));
        j fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            aVar.show(fragmentManager, net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
        }
    }

    public static final class b implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f58862a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f58863b;

        b(e eVar, int i2) {
            this.f58862a = eVar;
            this.f58863b = i2;
        }

        public final void a() {
            e.a(this.f58862a).notifyItemChanged(this.f58863b);
            e.c(this.f58862a);
        }
    }

    public final void b(int i2, CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String string = getString(R.string.edit_tag);
        k.a((Object) string, "getString(R.string.edit_tag)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new b(this, i2));
        j fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            aVar.show(fragmentManager, net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f58869a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58870b;

        f(e eVar, x.e eVar2) {
            this.f58869a = eVar;
            this.f58870b = eVar2;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f58870b.element;
            k.a((Object) linearLayout, "view");
            if (linearLayout.getVisibility() == 0 && this.f58869a.isAdded()) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f58869a.getContext(), R.anim.pass_save_tag_banner_up);
                ((LinearLayout) this.f58870b.element).startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new a(this));
            }
        }

        public static final class a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f58871a;

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            a(f fVar) {
                this.f58871a = fVar;
            }

            public final void onAnimationEnd(Animation animation) {
                LinearLayout linearLayout = (LinearLayout) this.f58871a.f58870b.element;
                k.a((Object) linearLayout, "view");
                linearLayout.setVisibility(8);
            }
        }
    }

    public final void c(int i2, CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        Intent intent = new Intent(getContext(), RecentTransactionsActivity.class);
        intent.putExtra("data", cJRTransaction);
        intent.putExtra(H5StartParamManager.index, i2);
        startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.beans.CJRTransaction r4) {
        /*
            r3 = this;
            java.lang.String r0 = "transaction"
            kotlin.g.b.k.c(r4, r0)
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r3.getContext()
            java.lang.Class<net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity> r2 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.class
            r0.<init>(r1, r2)
            r1 = r4
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "passbook_detail_data"
            r0.putExtra(r2, r1)
            java.lang.String r4 = r4.getTxnType()
            java.lang.String r1 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            int r1 = r4.hashCode()
            r2 = -917504720(0xffffffffc94ffd30, float:-851923.0)
            if (r1 == r2) goto L_0x004b
            r2 = 2159(0x86f, float:3.025E-42)
            if (r1 == r2) goto L_0x0040
            r2 = 2190(0x88e, float:3.069E-42)
            if (r1 == r2) goto L_0x0035
            goto L_0x0056
        L_0x0035:
            java.lang.String r1 = "DR"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0056
            java.lang.String r4 = "paid"
            goto L_0x0058
        L_0x0040:
            java.lang.String r1 = "CR"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0056
            java.lang.String r4 = "received"
            goto L_0x0058
        L_0x004b:
            java.lang.String r1 = "CR_added"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0056
            java.lang.String r4 = "added"
            goto L_0x0058
        L_0x0056:
            java.lang.String r4 = "all"
        L_0x0058:
            java.lang.String r1 = "EXTENDED_TXN_INFO"
            r0.putExtra(r1, r4)
            int r4 = r3.f58854a
            java.lang.String r1 = "sub_wallet_type"
            r0.putExtra(r1, r4)
            android.content.Context r4 = r3.getContext()
            if (r4 == 0) goto L_0x006e
            r4.startActivity(r0)
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.subWallet.b.e.a(net.one97.paytm.passbook.beans.CJRTransaction):void");
    }

    public static final /* synthetic */ void a(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
    }

    public static final /* synthetic */ void c(e eVar) {
        if (eVar.getActivity() instanceof PassbookSubwalletActivity) {
            x.e eVar2 = new x.e();
            FragmentActivity activity = eVar.getActivity();
            if (activity != null) {
                eVar2.element = ((PassbookSubwalletActivity) activity).f58764d;
                Animation loadAnimation = AnimationUtils.loadAnimation(eVar.getContext(), R.anim.pass_text_scroll_top_to_bottom);
                LinearLayout linearLayout = (LinearLayout) eVar2.element;
                k.a((Object) linearLayout, "view");
                linearLayout.setVisibility(0);
                ((LinearLayout) eVar2.element).startAnimation(loadAnimation);
                new Handler().postDelayed(new f(eVar, eVar2), 3000);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f58859f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
