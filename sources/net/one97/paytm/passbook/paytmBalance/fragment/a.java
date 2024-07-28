package net.one97.paytm.passbook.paytmBalance.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.paytmBalance.a.a;
import net.one97.paytm.passbook.subWallet.model.TransactionHeader;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.i;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.passbook.utility.n;

public final class a extends h implements net.one97.paytm.passbook.genericPassbook.b.c, a.c {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.paytmBalance.a.a f58228a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRTransaction> f58229b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public int f58230c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58231d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f58232e = "";

    /* renamed from: f  reason: collision with root package name */
    int f58233f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.passbook.paytmBalance.d.b f58234g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.passbook.paytmBalance.e.a f58235h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f58236i;

    public final View a(int i2) {
        if (this.f58236i == null) {
            this.f58236i = new HashMap();
        }
        View view = (View) this.f58236i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f58236i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.passbook.landing.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58239a;

        c(a aVar) {
            this.f58239a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.landing.e.a aVar = (net.one97.paytm.passbook.landing.e.a) obj;
            a.a(this.f58239a).a(false);
            if (aVar != null) {
                a.a(this.f58239a, aVar);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.paytmBalance.d.b a(a aVar) {
        net.one97.paytm.passbook.paytmBalance.d.b bVar = aVar.f58234g;
        if (bVar == null) {
            k.a("uiHandler");
        }
        return bVar;
    }

    public final net.one97.paytm.passbook.paytmBalance.a.a a() {
        net.one97.paytm.passbook.paytmBalance.a.a aVar = this.f58228a;
        if (aVar == null) {
            k.a("rvAdapter");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.paytmBalance.e.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…nceViewModel::class.java)");
        this.f58235h = (net.one97.paytm.passbook.paytmBalance.e.a) a2;
        this.f58234g = new net.one97.paytm.passbook.paytmBalance.d.b(this);
        return layoutInflater.inflate(R.layout.pass_fragment_paytm_balance_transactions, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rvPassbookEntries);
        k.a((Object) recyclerView, "rvPassbookEntries");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f58228a = new net.one97.paytm.passbook.paytmBalance.a.a(this, this, n.PAYTM_WALLET.getValue());
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rvPassbookEntries);
        net.one97.paytm.passbook.paytmBalance.a.a aVar = this.f58228a;
        if (aVar == null) {
            k.a("rvAdapter");
        }
        recyclerView2.addItemDecoration(new net.one97.paytm.passbook.search.b.a(aVar));
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rvPassbookEntries);
        k.a((Object) recyclerView3, "rvPassbookEntries");
        net.one97.paytm.passbook.paytmBalance.a.a aVar2 = this.f58228a;
        if (aVar2 == null) {
            k.a("rvAdapter");
        }
        recyclerView3.setAdapter(aVar2);
        b();
        net.one97.paytm.passbook.paytmBalance.e.a aVar3 = this.f58235h;
        if (aVar3 == null) {
            k.a("mPaytmBalanceViewModel");
        }
        aVar3.f58219a.observe(this, new c(this));
        ((AppCompatTextView) a(R.id.tvFilters)).setOnClickListener(new d(this));
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58240a;

        d(a aVar) {
            this.f58240a = aVar;
        }

        public final void onClick(View view) {
            j supportFragmentManager;
            String string = this.f58240a.getString(R.string.wallet_filter_tran);
            String[] stringArray = this.f58240a.getResources().getStringArray(R.array.passbook_tabs);
            k.a((Object) stringArray, "resources.getStringArray(R.array.passbook_tabs)");
            i iVar = new i(string, kotlin.a.k.d((String[]) Arrays.copyOf(stringArray, stringArray.length)), this.f58240a.f58233f);
            FragmentActivity activity = this.f58240a.getActivity();
            if (!(activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null)) {
                iVar.show(supportFragmentManager, iVar.getTag());
            }
            iVar.a((i.a) new i.a(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f58241a;

                {
                    this.f58241a = r1;
                }

                public final void a(int i2) {
                    this.f58241a.f58240a.f58233f = i2;
                    a.b(this.f58241a.f58240a);
                    this.f58241a.f58240a.b();
                }
            });
        }
    }

    public final void b() {
        net.one97.paytm.passbook.paytmBalance.d.b bVar = this.f58234g;
        if (bVar == null) {
            k.a("uiHandler");
        }
        bVar.a(true);
        net.one97.paytm.passbook.paytmBalance.e.a aVar = this.f58235h;
        if (aVar == null) {
            k.a("mPaytmBalanceViewModel");
        }
        int i2 = this.f58230c;
        net.one97.paytm.passbook.paytmBalance.d.b bVar2 = this.f58234g;
        if (bVar2 == null) {
            k.a("uiHandler");
        }
        aVar.a(i2, bVar2.a(this.f58233f));
    }

    public final void c() {
        if (this.f58231d) {
            b();
        }
    }

    public final void onClick(View view) {
        k.c(view, "viewId");
        throw new kotlin.n("An operation is not implemented: ".concat("Not yet implemented"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        r4 = r4.getIntent();
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
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
            net.one97.paytm.passbook.paytmBalance.d.b r1 = r3.f58234g
            if (r1 != 0) goto L_0x0021
            java.lang.String r1 = "uiHandler"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0021:
            java.lang.String r4 = r4.getTxnType()
            java.lang.String r1 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            java.lang.String r1 = "txnType"
            kotlin.g.b.k.c(r4, r1)
            int r1 = r4.hashCode()
            r2 = -917504720(0xffffffffc94ffd30, float:-851923.0)
            if (r1 == r2) goto L_0x0057
            r2 = 2159(0x86f, float:3.025E-42)
            if (r1 == r2) goto L_0x004c
            r2 = 2190(0x88e, float:3.069E-42)
            if (r1 == r2) goto L_0x0041
            goto L_0x0062
        L_0x0041:
            java.lang.String r1 = "DR"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0062
            java.lang.String r4 = "paid"
            goto L_0x0064
        L_0x004c:
            java.lang.String r1 = "CR"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0062
            java.lang.String r4 = "received"
            goto L_0x0064
        L_0x0057:
            java.lang.String r1 = "CR_added"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0062
            java.lang.String r4 = "added"
            goto L_0x0064
        L_0x0062:
            java.lang.String r4 = "all"
        L_0x0064:
            java.lang.String r1 = "EXTENDED_TXN_INFO"
            r0.putExtra(r1, r4)
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x0082
            android.content.Intent r4 = r4.getIntent()
            if (r4 == 0) goto L_0x0082
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r2 = "passbook_type"
            int r4 = r4.getIntExtra(r2, r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0083
        L_0x0082:
            r4 = 0
        L_0x0083:
            java.io.Serializable r4 = (java.io.Serializable) r4
            java.lang.String r1 = "sub_wallet_type"
            r0.putExtra(r1, r4)
            android.content.Context r4 = r3.getContext()
            if (r4 == 0) goto L_0x0093
            r4.startActivity(r0)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.fragment.a.a(net.one97.paytm.passbook.beans.CJRTransaction):void");
    }

    /* renamed from: net.one97.paytm.passbook.paytmBalance.fragment.a$a  reason: collision with other inner class name */
    public static final class C1123a implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58237a;

        C1123a(a aVar) {
            this.f58237a = aVar;
        }

        public final void a() {
            this.f58237a.a().notifyDataSetChanged();
            a.a(this.f58237a).a();
        }
    }

    public final void b(CJRTransaction cJRTransaction) {
        j supportFragmentManager;
        k.c(cJRTransaction, "transaction");
        String string = getString(R.string.tag_this_payment);
        k.a((Object) string, "getString(R.string.tag_this_payment)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new C1123a(this));
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            aVar.show(supportFragmentManager, net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
        }
    }

    public static final class b implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58238a;

        b(a aVar) {
            this.f58238a = aVar;
        }

        public final void a() {
            this.f58238a.a().notifyDataSetChanged();
            a.a(this.f58238a).a();
        }
    }

    public final void c(CJRTransaction cJRTransaction) {
        j supportFragmentManager;
        k.c(cJRTransaction, "transaction");
        String string = getString(R.string.edit_tag);
        k.a((Object) string, "getString(R.string.edit_tag)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new b(this));
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            aVar.show(supportFragmentManager, net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
        }
    }

    public final void a(int i2, CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        Intent intent = new Intent(getContext(), RecentTransactionsActivity.class);
        intent.putExtra("data", cJRTransaction);
        intent.putExtra(H5StartParamManager.index, i2);
        startActivity(intent);
    }

    public static final /* synthetic */ void a(a aVar, net.one97.paytm.passbook.landing.e.a aVar2) {
        ArrayList<CJRTransaction> arrayList;
        String str;
        if (aVar2 instanceof net.one97.paytm.passbook.paytmBalance.b.b) {
            net.one97.paytm.passbook.paytmBalance.b.b bVar = (net.one97.paytm.passbook.paytmBalance.b.b) aVar2;
            k.c(aVar, "paytmBalanceTransactionsFragment");
            if (net.one97.paytm.passbook.paytmBalance.b.c.f58204a[bVar.f58203a.f57886a.ordinal()] != 1) {
                x xVar = x.f47997a;
                return;
            }
            CJRLedger cJRLedger = (CJRLedger) bVar.f58203a.f57887b;
            if (cJRLedger != null && (arrayList = cJRLedger.mTransactionList) != null) {
                if (arrayList.size() == 0 && aVar.f58229b.size() == 0) {
                    RelativeLayout relativeLayout = (RelativeLayout) aVar.a(R.id.rlNoData);
                    k.a((Object) relativeLayout, "paytmBalanceTransactionsFragment.rlNoData");
                    relativeLayout.setVisibility(0);
                }
                if (arrayList.size() == 0) {
                    aVar.f58231d = false;
                }
                Iterator<CJRTransaction> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTransaction next = it2.next();
                    String str2 = aVar.f58232e;
                    k.a((Object) next, "transactionItem");
                    String l = net.one97.paytm.passbook.mapping.a.l(next.getTxnDate(), "yyyy-MM-dd", "MMMM YYYY");
                    String str3 = null;
                    if (l == null) {
                        str = null;
                    } else if (l != null) {
                        str = l.toUpperCase();
                        k.a((Object) str, "(this as java.lang.String).toUpperCase()");
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                    if (!k.a((Object) str2, (Object) str)) {
                        String l2 = net.one97.paytm.passbook.mapping.a.l(next.getTxnDate(), "yyyy-MM-dd", "MMMM YYYY");
                        if (l2 != null) {
                            if (l2 != null) {
                                str3 = l2.toUpperCase();
                                k.a((Object) str3, "(this as java.lang.String).toUpperCase()");
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        aVar.f58229b.add(new TransactionHeader(str3));
                        if (str3 != null) {
                            k.c(str3, "<set-?>");
                            aVar.f58232e = str3;
                        }
                    }
                    aVar.f58229b.add(next);
                }
                aVar.f58230c += arrayList.size();
                net.one97.paytm.passbook.paytmBalance.a.a a2 = aVar.a();
                ArrayList<CJRTransaction> arrayList2 = aVar.f58229b;
                if (arrayList2 != null) {
                    a2.f58151b = arrayList2;
                    a2.notifyDataSetChanged();
                    m.a aVar3 = m.f59265a;
                    f b2 = net.one97.paytm.passbook.d.b();
                    k.a((Object) b2, "PassbookHelper.getImplListener()");
                    Context b3 = b2.b();
                    k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
                    com.paytm.b.a.a a3 = m.a.a(b3);
                    if (!a3.b("is_passbook_slide_animation_shown", false, true)) {
                        a3.a("is_passbook_slide_animation_shown", true, true);
                        x.e eVar = new x.e();
                        eVar.element = "1";
                        Handler handler = new Handler();
                        handler.postDelayed(new a.e(a2, eVar), 1000);
                        handler.postDelayed(new a.f(a2, eVar), 2000);
                    }
                }
                kotlin.x xVar2 = kotlin.x.f47997a;
            }
        }
    }

    public static final /* synthetic */ void b(a aVar) {
        aVar.f58230c = 0;
        aVar.f58229b.clear();
        aVar.f58231d = true;
        aVar.f58232e = "";
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f58236i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
