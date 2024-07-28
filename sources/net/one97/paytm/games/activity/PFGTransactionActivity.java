package net.one97.paytm.games.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.s;
import kotlin.u;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.a.g;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.model.pfg.GameUserTransaction;
import net.one97.paytm.games.model.pfg.PFGUserTransactionResponse;
import net.one97.paytm.games.model.pfg.TxnDate;

public final class PFGTransactionActivity extends GpBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35538b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final int n = 4;
    /* access modifiers changed from: private */
    public static final int o = 1;
    /* access modifiers changed from: private */
    public static final int p = 2;
    /* access modifiers changed from: private */
    public static final int q = 3;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.games.fragment.a.d f35539c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f35540d;

    /* renamed from: e  reason: collision with root package name */
    private SwipeRefreshLayout f35541e;

    /* renamed from: f  reason: collision with root package name */
    private RadioGroup f35542f;

    /* renamed from: g  reason: collision with root package name */
    private View f35543g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.games.a.a.d f35544h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f35545i = n;
    /* access modifiers changed from: private */
    public boolean j;
    private int k = 4;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m = 1;
    private HashMap r;

    static final class c<T> implements z<s<? extends Integer, ? extends Integer, ? extends PFGUserTransactionResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGTransactionActivity f35547a;

        c(PFGTransactionActivity pFGTransactionActivity) {
            this.f35547a = pFGTransactionActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
            r1 = r1.getData();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r4) {
            /*
                r3 = this;
                kotlin.s r4 = (kotlin.s) r4
                net.one97.paytm.games.activity.PFGTransactionActivity r0 = r3.f35547a
                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = net.one97.paytm.games.activity.PFGTransactionActivity.a(r0)
                boolean r0 = r0.f4572b
                r1 = 0
                if (r0 == 0) goto L_0x0016
                net.one97.paytm.games.activity.PFGTransactionActivity r0 = r3.f35547a
                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = net.one97.paytm.games.activity.PFGTransactionActivity.a(r0)
                r0.setRefreshing(r1)
            L_0x0016:
                java.lang.Object r0 = r4.getFirst()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                r2 = 2001(0x7d1, float:2.804E-42)
                if (r0 == r2) goto L_0x0039
                net.one97.paytm.games.activity.PFGTransactionActivity r4 = r3.f35547a
                r0 = r4
                android.content.Context r0 = (android.content.Context) r0
                int r2 = net.one97.paytm.games.R.string.com_gamepind_something_went_retry
                java.lang.String r4 = r4.getString(r2)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                android.widget.Toast r4 = android.widget.Toast.makeText(r0, r4, r1)
                r4.show()
                return
            L_0x0039:
                net.one97.paytm.games.activity.PFGTransactionActivity r0 = r3.f35547a
                java.lang.Object r2 = r4.getThird()
                net.one97.paytm.games.model.pfg.PFGUserTransactionResponse r2 = (net.one97.paytm.games.model.pfg.PFGUserTransactionResponse) r2
                if (r2 == 0) goto L_0x0053
                net.one97.paytm.games.model.pfg.PFGUserTransactionResponse$UserTransactionData r2 = r2.getData()
                if (r2 == 0) goto L_0x0053
                java.lang.Integer r2 = r2.getTotal()
                if (r2 == 0) goto L_0x0053
                int r1 = r2.intValue()
            L_0x0053:
                r0.l = r1
                net.one97.paytm.games.activity.PFGTransactionActivity r0 = r3.f35547a
                int r1 = r0.m
                int r1 = r1 + 1
                r0.m = r1
                net.one97.paytm.games.activity.PFGTransactionActivity r0 = r3.f35547a
                java.lang.Object r1 = r4.getThird()
                net.one97.paytm.games.model.pfg.PFGUserTransactionResponse r1 = (net.one97.paytm.games.model.pfg.PFGUserTransactionResponse) r1
                if (r1 == 0) goto L_0x0076
                net.one97.paytm.games.model.pfg.PFGUserTransactionResponse$UserTransactionData r1 = r1.getData()
                if (r1 == 0) goto L_0x0076
                java.util.ArrayList r1 = r1.getData()
                goto L_0x0077
            L_0x0076:
                r1 = 0
            L_0x0077:
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r4 = r4.getSecond()
                java.lang.Number r4 = (java.lang.Number) r4
                int r4 = r4.intValue()
                net.one97.paytm.games.activity.PFGTransactionActivity.a(r0, r1, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.activity.PFGTransactionActivity.c.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ SwipeRefreshLayout a(PFGTransactionActivity pFGTransactionActivity) {
        SwipeRefreshLayout swipeRefreshLayout = pFGTransactionActivity.f35541e;
        if (swipeRefreshLayout == null) {
            k.a("mSwipeRefresh");
        }
        return swipeRefreshLayout;
    }

    public final void onCreate(Bundle bundle) {
        y<s<Integer, Integer, PFGUserTransactionResponse>> yVar;
        super.onCreate(bundle);
        setContentView(R.layout.com_gamepind_transaction_activity);
        View findViewById = findViewById(R.id.rv_transaction_list);
        k.a((Object) findViewById, "findViewById(R.id.rv_transaction_list)");
        this.f35540d = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.swipe_refresh_txn);
        k.a((Object) findViewById2, "findViewById(R.id.swipe_refresh_txn)");
        this.f35541e = (SwipeRefreshLayout) findViewById2;
        View findViewById3 = findViewById(R.id.container_txn_type_btn);
        k.a((Object) findViewById3, "findViewById(R.id.container_txn_type_btn)");
        this.f35542f = (RadioGroup) findViewById3;
        View findViewById4 = findViewById(R.id.root_txn_none);
        k.a((Object) findViewById4, "findViewById(R.id.root_txn_none)");
        this.f35543g = findViewById4;
        this.f35539c = (net.one97.paytm.games.fragment.a.d) am.a((FragmentActivity) this).a(net.one97.paytm.games.fragment.a.d.class);
        net.one97.paytm.games.fragment.a.d dVar = this.f35539c;
        if (!(dVar == null || (yVar = dVar.f35649h) == null)) {
            yVar.observe(this, new c(this));
        }
        SwipeRefreshLayout swipeRefreshLayout = this.f35541e;
        if (swipeRefreshLayout == null) {
            k.a("mSwipeRefresh");
        }
        swipeRefreshLayout.setOnRefreshListener(new d(this));
        RadioGroup radioGroup = this.f35542f;
        if (radioGroup == null) {
            k.a("mRootTxnTypeBtn");
        }
        radioGroup.setOnCheckedChangeListener(new e(this));
        net.one97.paytm.games.e.b bVar = net.one97.paytm.games.e.b.f35599a;
        if (!net.one97.paytm.games.e.b.c().getValue().booleanValue()) {
            int i2 = R.id.passbook_transaction_type_withdrawn;
            if (this.r == null) {
                this.r = new HashMap();
            }
            View view = (View) this.r.get(Integer.valueOf(i2));
            if (view == null) {
                view = findViewById(i2);
                this.r.put(Integer.valueOf(i2), view);
            }
            g.b((RadioButton) view);
            this.k = 2;
        }
        RecyclerView recyclerView = this.f35540d;
        if (recyclerView == null) {
            k.a("mRvTxnList");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView2 = this.f35540d;
        if (recyclerView2 == null) {
            k.a("mRvTxnList");
        }
        recyclerView2.addOnScrollListener(new b(this));
        f();
    }

    static final class d implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGTransactionActivity f35548a;

        d(PFGTransactionActivity pFGTransactionActivity) {
            this.f35548a = pFGTransactionActivity;
        }

        public final void onRefresh() {
            this.f35548a.j = false;
            this.f35548a.m = 1;
            this.f35548a.f();
        }
    }

    static final class e implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGTransactionActivity f35549a;

        e(PFGTransactionActivity pFGTransactionActivity) {
            this.f35549a = pFGTransactionActivity;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            if (i2 == R.id.passbook_transaction_type_all) {
                f.a(this.f35549a, "/passbook-txn-pfg", "pfg_passbook", "recent_transactions_clicked", AppConstants.FOR_ALL, (String) null);
                PFGTransactionActivity pFGTransactionActivity = this.f35549a;
                a aVar = PFGTransactionActivity.f35538b;
                pFGTransactionActivity.f35545i = PFGTransactionActivity.n;
            } else if (i2 == R.id.passbook_transaction_type_paid) {
                f.a(this.f35549a, "/passbook-txn-pfg", "pfg_passbook", "recent_transactions_clicked", "Paid", (String) null);
                PFGTransactionActivity pFGTransactionActivity2 = this.f35549a;
                a aVar2 = PFGTransactionActivity.f35538b;
                pFGTransactionActivity2.f35545i = PFGTransactionActivity.o;
            } else if (i2 == R.id.passbook_transaction_type_received) {
                f.a(this.f35549a, "/passbook-txn-pfg", "pfg_passbook", "recent_transactions_clicked", "Received", (String) null);
                PFGTransactionActivity pFGTransactionActivity3 = this.f35549a;
                a aVar3 = PFGTransactionActivity.f35538b;
                pFGTransactionActivity3.f35545i = PFGTransactionActivity.p;
            } else if (i2 == R.id.passbook_transaction_type_withdrawn) {
                f.a(this.f35549a, "/passbook-txn-pfg", "pfg_passbook", "recent_transactions_clicked", "Withdrawn", (String) null);
                PFGTransactionActivity pFGTransactionActivity4 = this.f35549a;
                a aVar4 = PFGTransactionActivity.f35538b;
                pFGTransactionActivity4.f35545i = PFGTransactionActivity.q;
            }
            this.f35549a.m = 1;
            this.f35549a.j = false;
            net.one97.paytm.games.a.a.d d2 = this.f35549a.f35544h;
            if (d2 != null) {
                d2.f35454b = 0;
                d2.f35455c = 0;
                List<? extends Object> list = d2.f35453a;
                if (list != null) {
                    ((ArrayList) list).clear();
                    d2.notifyDataSetChanged();
                } else {
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>");
                }
            }
            this.f35549a.f();
        }
    }

    public static final class b extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PFGTransactionActivity f35546a;

        b(PFGTransactionActivity pFGTransactionActivity) {
            this.f35546a = pFGTransactionActivity;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Integer valueOf = layoutManager != null ? Integer.valueOf(layoutManager.getItemCount()) : null;
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
                if (i2 == 0 && valueOf != null && this.f35546a.f35544h != null) {
                    net.one97.paytm.games.a.a.d d2 = this.f35546a.f35544h;
                    if (d2 == null) {
                        k.a();
                    }
                    Collection collection = d2.f35453a;
                    boolean z = false;
                    if (!(collection == null || collection.isEmpty()) && d2.f35455c < d2.f35454b) {
                        z = true;
                    }
                    if (z && valueOf.intValue() <= findLastVisibleItemPosition + 1) {
                        this.f35546a.j = true;
                        this.f35546a.f();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    private static List<Object> a(ArrayList<Object> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        Collection collection = arrayList;
        if (collection == null || collection.isEmpty()) {
            return arrayList2;
        }
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            Object obj = arrayList.get(0);
            if (obj != null) {
                str = ((GameUserTransaction) obj).getDay();
                arrayList2.add(new TxnDate(str));
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.games.model.pfg.GameUserTransaction");
            }
        }
        int size = collection.size();
        for (int i2 = 0; i2 < size; i2++) {
            CharSequence charSequence2 = str;
            if (!(charSequence2 == null || p.a(charSequence2))) {
                Object obj2 = arrayList.get(i2);
                if (obj2 != null) {
                    GameUserTransaction gameUserTransaction = (GameUserTransaction) obj2;
                    if (!k.a((Object) gameUserTransaction.getDay(), (Object) str)) {
                        arrayList2.add(new TxnDate(gameUserTransaction.getDay()));
                    }
                    arrayList2.add(gameUserTransaction);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.games.model.pfg.GameUserTransaction");
                }
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public final void f() {
        Context context = this;
        if (!f.a(context)) {
            SwipeRefreshLayout swipeRefreshLayout = this.f35541e;
            if (swipeRefreshLayout == null) {
                k.a("mSwipeRefresh");
            }
            if (swipeRefreshLayout.f4572b) {
                SwipeRefreshLayout swipeRefreshLayout2 = this.f35541e;
                if (swipeRefreshLayout2 == null) {
                    k.a("mSwipeRefresh");
                }
                swipeRefreshLayout2.setRefreshing(false);
            }
            Toast.makeText(context, getString(R.string.com_gamepind_no_internet_available), 0).show();
            return;
        }
        if (!this.j) {
            SwipeRefreshLayout swipeRefreshLayout3 = this.f35541e;
            if (swipeRefreshLayout3 == null) {
                k.a("mSwipeRefresh");
            }
            swipeRefreshLayout3.setRefreshing(true);
        }
        net.one97.paytm.games.fragment.a.d dVar = this.f35539c;
        if (dVar != null) {
            dVar.a(this.m, this.k, this.f35545i);
        }
    }

    public final void onClick(View view) {
        k.c(view, "v");
        if (view.getId() == R.id.img_back_arrow) {
            finish();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.games.activity.PFGTransactionActivity r4, java.util.List r5, int r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x00f4
            boolean r1 = r5.isEmpty()
            java.lang.String r2 = "mRootTxnNone"
            java.lang.String r3 = "mRvTxnList"
            if (r1 == 0) goto L_0x0024
            android.view.View r5 = r4.f35543g
            if (r5 != 0) goto L_0x0014
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0014:
            net.one97.paytm.games.e.a.g.a(r5)
            androidx.recyclerview.widget.RecyclerView r4 = r4.f35540d
            if (r4 != 0) goto L_0x001e
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x001e:
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.games.e.a.g.c(r4)
            return
        L_0x0024:
            androidx.recyclerview.widget.RecyclerView r1 = r4.f35540d
            if (r1 != 0) goto L_0x002b
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x002b:
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.games.e.a.g.a(r1)
            android.view.View r1 = r4.f35543g
            if (r1 != 0) goto L_0x0037
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0037:
            net.one97.paytm.games.e.a.g.c(r1)
            net.one97.paytm.games.a.a.d r1 = r4.f35544h
            r2 = 0
            if (r1 != 0) goto L_0x006c
            net.one97.paytm.games.a.a.d r6 = new net.one97.paytm.games.a.a.d
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            r6.<init>(r0)
            r4.f35544h = r6
            net.one97.paytm.games.a.a.d r6 = r4.f35544h
            if (r6 == 0) goto L_0x005d
            r0 = r5
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.List r0 = a((java.util.ArrayList<java.lang.Object>) r0, (java.lang.String) r2)
            int r1 = r4.l
            int r5 = r5.size()
            r6.a(r0, r1, r5)
        L_0x005d:
            androidx.recyclerview.widget.RecyclerView r5 = r4.f35540d
            if (r5 != 0) goto L_0x0064
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0064:
            net.one97.paytm.games.a.a.d r4 = r4.f35544h
            androidx.recyclerview.widget.RecyclerView$a r4 = (androidx.recyclerview.widget.RecyclerView.a) r4
            r5.setAdapter(r4)
            return
        L_0x006c:
            boolean r3 = r4.j
            if (r3 != 0) goto L_0x0087
            int r3 = r4.f35545i
            if (r3 != r6) goto L_0x0087
            if (r1 == 0) goto L_0x0086
            r6 = r5
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.util.List r6 = a((java.util.ArrayList<java.lang.Object>) r6, (java.lang.String) r2)
            int r4 = r4.l
            int r5 = r5.size()
            r1.a(r6, r4, r5)
        L_0x0086:
            return
        L_0x0087:
            boolean r1 = r4.j
            if (r1 == 0) goto L_0x00e8
            int r1 = r4.f35545i
            if (r1 != r6) goto L_0x00e8
            net.one97.paytm.games.a.a.d r6 = r4.f35544h
            if (r6 == 0) goto L_0x00b6
            java.util.List<? extends java.lang.Object> r0 = r6.f35453a
            if (r0 == 0) goto L_0x00a7
            java.util.List<? extends java.lang.Object> r6 = r6.f35453a
            if (r6 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            int r6 = kotlin.a.k.a(r6)
            java.lang.Object r6 = r0.get(r6)
            goto L_0x00a8
        L_0x00a7:
            r6 = r2
        L_0x00a8:
            boolean r0 = r6 instanceof net.one97.paytm.games.model.pfg.GameUserTransaction
            if (r0 != 0) goto L_0x00ad
            r6 = r2
        L_0x00ad:
            net.one97.paytm.games.model.pfg.GameUserTransaction r6 = (net.one97.paytm.games.model.pfg.GameUserTransaction) r6
            if (r6 == 0) goto L_0x00b6
            java.lang.String r6 = r6.getDay()
            goto L_0x00b7
        L_0x00b6:
            r6 = r2
        L_0x00b7:
            net.one97.paytm.games.a.a.d r0 = r4.f35544h
            if (r0 == 0) goto L_0x00e7
            r1 = r5
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.List r6 = a((java.util.ArrayList<java.lang.Object>) r1, (java.lang.String) r6)
            int r4 = r4.l
            int r5 = r5.size()
            java.lang.String r1 = "data"
            kotlin.g.b.k.c(r6, r1)
            java.util.List<? extends java.lang.Object> r1 = r0.f35453a
            boolean r3 = r1 instanceof java.util.ArrayList
            if (r3 != 0) goto L_0x00d4
            r1 = r2
        L_0x00d4:
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            if (r1 == 0) goto L_0x00dd
            java.util.Collection r6 = (java.util.Collection) r6
            r1.addAll(r6)
        L_0x00dd:
            r0.f35454b = r4
            int r4 = r0.f35455c
            int r4 = r4 + r5
            r0.f35455c = r4
            r0.notifyDataSetChanged()
        L_0x00e7:
            return
        L_0x00e8:
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.games.R.string.com_gamepind_something_went_retry
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r5, r0)
            r4.show()
            return
        L_0x00f4:
            r5 = r4
            android.content.Context r5 = (android.content.Context) r5
            int r6 = net.one97.paytm.games.R.string.com_gamepind_something_went_retry
            java.lang.String r4 = r4.getString(r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            android.widget.Toast r4 = android.widget.Toast.makeText(r5, r4, r0)
            r4.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.activity.PFGTransactionActivity.a(net.one97.paytm.games.activity.PFGTransactionActivity, java.util.List, int):void");
    }
}
