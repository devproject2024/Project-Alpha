package net.one97.paytm.passbook.genericPassbook.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.genericPassbook.d.a.a;
import net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.search.PassbookSearchActivity;
import net.one97.paytm.passbook.subWallet.model.TransactionHeader;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.n;

public final class c extends net.one97.paytm.passbook.genericPassbook.b.a implements a.c {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRTransaction> f57432a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    boolean f57433b = true;

    /* renamed from: c  reason: collision with root package name */
    a f57434c;

    /* renamed from: d  reason: collision with root package name */
    int f57435d;

    /* renamed from: e  reason: collision with root package name */
    final AppCompatActivity f57436e;

    /* renamed from: f  reason: collision with root package name */
    private i.a<IJRDataModel> f57437f;

    /* renamed from: g  reason: collision with root package name */
    private i.a<IJRDataModel> f57438g;

    /* renamed from: h  reason: collision with root package name */
    private View f57439h;
    private MenuItem k;
    private b l;

    public final void a(Context context, View view) {
        k.c(context, "mContext");
        k.c(view, "viewId");
    }

    public final void a(TextView textView) {
        k.c(textView, "mBalanceTitleText");
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.d.a.c$c  reason: collision with other inner class name */
    static final class C1078c<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57442a;

        C1078c(x.e eVar) {
            this.f57442a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRCashWallet) {
                ((y) this.f57442a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
            }
        }
    }

    static final class e<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57444a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57445b;

        e(c cVar, x.e eVar) {
            this.f57444a = cVar;
            this.f57445b = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str;
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRLedger) {
                c cVar = this.f57444a;
                CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
                ArrayList<CJRTransaction> arrayList = cJRLedger.mTransactionList;
                k.a((Object) arrayList, "ijrDataModel?.mTransactionList");
                if (arrayList.size() == 0) {
                    cVar.f57433b = false;
                }
                if (cVar.f57432a.size() > 0) {
                    str = ((CJRTransaction) kotlin.a.k.f(cVar.f57432a)).getTxnDate();
                    k.a((Object) str, "transactionArrayList.last().txnDate");
                } else {
                    str = "";
                }
                Iterator<CJRTransaction> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTransaction next = it2.next();
                    k.a((Object) next, "transaction");
                    String txnDate = next.getTxnDate();
                    k.a((Object) txnDate, "transaction.txnDate");
                    String a2 = c.a(txnDate);
                    if (cVar.f57432a.size() == 0) {
                        cVar.f57432a.add(new TransactionHeader(a2));
                    } else if (!p.a(a2, str, true)) {
                        cVar.f57432a.add(new TransactionHeader(a2));
                    }
                    String txnDate2 = next.getTxnDate();
                    k.a((Object) txnDate2, "transaction.txnDate");
                    next.setFormattedTxnTime(c.b(txnDate2));
                    next.setmTxnDate(a2);
                    cVar.f57432a.add(next);
                    str = a2;
                }
                a aVar = this.f57444a.f57434c;
                if (aVar != null) {
                    aVar.a(this.f57444a.f57432a);
                }
                ((y) this.f57445b.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
                ArrayList<CJRTransaction> arrayList2 = cJRLedger.mTransactionList;
                if (arrayList2 != null) {
                    this.f57444a.f57435d += arrayList2.size();
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, AppCompatActivity appCompatActivity) {
        super(context);
        k.c(context, "context");
        k.c(appCompatActivity, "activity");
        this.f57436e = appCompatActivity;
    }

    public final RecyclerView.a<RecyclerView.v> a(net.one97.paytm.passbook.genericPassbook.b.c cVar, RecyclerView recyclerView) {
        k.c(cVar, "listener");
        k.c(recyclerView, "rvEntries");
        a aVar = this.f57434c;
        if (aVar == null) {
            aVar = new a(cVar, this, n.PAYTM_WALLET.getValue());
        }
        this.f57434c = aVar;
        a aVar2 = this.f57434c;
        if (aVar2 == null) {
            k.a();
        }
        recyclerView.addItemDecoration(new net.one97.paytm.passbook.search.b.a(aVar2));
        a aVar3 = this.f57434c;
        if (aVar3 == null) {
            k.a();
        }
        return aVar3;
    }

    public final void a() {
        this.f57433b = true;
        this.f57435d = 0;
        ArrayList<CJRTransaction> arrayList = this.f57432a;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final Fragment c() {
        b bVar = this.l;
        if (bVar == null) {
            bVar = new b();
        }
        this.l = bVar;
        b bVar2 = this.l;
        if (bVar2 == null) {
            k.a();
        }
        return bVar2;
    }

    public final LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> d() {
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.passbook.mapping.a.g dVar = new d(eVar);
        this.f57438g = new C1078c(eVar);
        e eVar2 = e.f57457a;
        Context context = this.j;
        i.a<IJRDataModel> aVar = this.f57438g;
        if (aVar == null) {
            k.a("fetchBalanceResponseHandler");
        }
        eVar2.a(context, aVar, dVar);
        return (y) eVar.element;
    }

    static final class d implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57443a;

        d(x.e eVar) {
            this.f57443a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ((y) this.f57443a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    public final synchronized LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> a(int i2) {
        x.e eVar;
        eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.passbook.mapping.a.g fVar = new f(eVar);
        this.f57437f = new e(this, eVar);
        if (this.f57433b) {
            e eVar2 = e.f57457a;
            Context context = this.j;
            int value = n.PAYTM_WALLET.getValue();
            String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? SDKConstants.ALL_TYPE : "ON_HOLD" : "ADDED" : "RECEIVED" : "PAID" : SDKConstants.ALL_TYPE;
            i.a<IJRDataModel> aVar = this.f57437f;
            if (aVar == null) {
                k.a("txnSuccessListener");
            }
            e.a(context, value, "PAYTM WALLET", str, aVar, fVar, this.f57435d);
        } else {
            ((y) eVar.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, null, (Throwable) null));
        }
        return (y) eVar.element;
    }

    static final class f implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57446a;

        f(x.e eVar) {
            this.f57446a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ((y) this.f57446a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    static String a(String str) {
        try {
            String format = new SimpleDateFormat("dd MMM yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
            k.a((Object) format, "outputFormat.format(dt)");
            if (format != null) {
                String upperCase = format.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                return upperCase;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            return str;
        }
    }

    static String b(String str) {
        try {
            String format = new SimpleDateFormat("hh:mm a").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
            k.a((Object) format, "outputFormat.format(dt)");
            if (format != null) {
                String lowerCase = format.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                return lowerCase;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            return str;
        }
    }

    public final boolean e() {
        return this.f57433b;
    }

    public final void a(int i2, Runnable runnable) {
        k.c(runnable, "fetchTransactionCallable");
        a();
        runnable.run();
    }

    public final void g() {
        a aVar = this.f57434c;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final int j() {
        ArrayList<CJRTransaction> arrayList = this.f57432a;
        return (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r10 = r10.getIntent();
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.beans.CJRTransaction r10) {
        /*
            r9 = this;
            java.lang.String r0 = "transaction"
            kotlin.g.b.k.c(r10, r0)
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r9.j
            java.lang.Class<net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity> r2 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.class
            r0.<init>(r1, r2)
            r1 = r10
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r2 = "passbook_detail_data"
            r0.putExtra(r2, r1)
            java.lang.String r10 = r10.getTxnType()
            java.lang.String r1 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
            int r1 = r10.hashCode()
            r2 = -917504720(0xffffffffc94ffd30, float:-851923.0)
            if (r1 == r2) goto L_0x0049
            r2 = 2159(0x86f, float:3.025E-42)
            if (r1 == r2) goto L_0x003e
            r2 = 2190(0x88e, float:3.069E-42)
            if (r1 == r2) goto L_0x0033
            goto L_0x0054
        L_0x0033:
            java.lang.String r1 = "DR"
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0054
            java.lang.String r10 = "paid"
            goto L_0x0056
        L_0x003e:
            java.lang.String r1 = "CR"
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0054
            java.lang.String r10 = "received"
            goto L_0x0056
        L_0x0049:
            java.lang.String r1 = "CR_added"
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0054
            java.lang.String r10 = "added"
            goto L_0x0056
        L_0x0054:
            java.lang.String r10 = "all"
        L_0x0056:
            java.lang.String r1 = "EXTENDED_TXN_INFO"
            r0.putExtra(r1, r10)
            androidx.appcompat.app.AppCompatActivity r10 = r9.f57436e
            if (r10 == 0) goto L_0x0072
            android.content.Intent r10 = r10.getIntent()
            if (r10 == 0) goto L_0x0072
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r2 = "passbook_type"
            int r10 = r10.getIntExtra(r2, r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x0073
        L_0x0072:
            r10 = 0
        L_0x0073:
            java.io.Serializable r10 = (java.io.Serializable) r10
            java.lang.String r1 = "sub_wallet_type"
            r0.putExtra(r1, r10)
            android.content.Context r10 = r9.j
            if (r10 == 0) goto L_0x0082
            r10.startActivity(r0)
        L_0x0082:
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            android.content.Context r2 = r9.j
            java.lang.String r3 = "passbook"
            java.lang.String r4 = "recents_clicked"
            java.lang.String r5 = "wallet"
            java.lang.String r6 = ""
            java.lang.String r7 = "/passbook/wallet"
            java.lang.String r8 = "passbook"
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.a.c.a(net.one97.paytm.passbook.beans.CJRTransaction):void");
    }

    public static final class a implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57440a;

        a(c cVar) {
            this.f57440a = cVar;
        }

        public final void a() {
            this.f57440a.g();
            c.a(this.f57440a);
        }
    }

    public final void b(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String string = this.j.getString(R.string.tag_this_payment);
        k.a((Object) string, "mContext.getString(R.string.tag_this_payment)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new a(this));
        aVar.show(this.f57436e.getSupportFragmentManager(), net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
    }

    public static final class b implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57441a;

        b(c cVar) {
            this.f57441a = cVar;
        }

        public final void a() {
            this.f57441a.g();
            c.a(this.f57441a);
        }
    }

    public final void c(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String string = this.j.getString(R.string.edit_tag);
        k.a((Object) string, "mContext.getString(R.string.edit_tag)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new b(this));
        aVar.show(this.f57436e.getSupportFragmentManager(), net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
    }

    public final void a(int i2, CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        Intent intent = new Intent(this.j, RecentTransactionsActivity.class);
        intent.putExtra("data", cJRTransaction);
        intent.putExtra(H5StartParamManager.index, i2);
        this.j.startActivity(intent);
    }

    public static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57448a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57449b;

        h(c cVar, x.e eVar) {
            this.f57448a = cVar;
            this.f57449b = eVar;
        }

        public final void run() {
            try {
                LinearLayout linearLayout = (LinearLayout) this.f57449b.element;
                if (linearLayout != null && linearLayout.getVisibility() == 0) {
                    Fragment c2 = this.f57448a.f57436e.getSupportFragmentManager().c(R.id.l2Fragment);
                    if (c2 == null) {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
                    } else if (((PassbookL2Fragment) c2).isAdded()) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.f57448a.j, R.anim.pass_save_tag_banner_up);
                        LinearLayout linearLayout2 = (LinearLayout) this.f57449b.element;
                        if (linearLayout2 != null) {
                            linearLayout2.startAnimation(loadAnimation);
                        }
                        loadAnimation.setAnimationListener(new a(this));
                    }
                }
            } catch (Exception unused) {
            }
        }

        public static final class a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f57450a;

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            a(h hVar) {
                this.f57450a = hVar;
            }

            public final void onAnimationEnd(Animation animation) {
                LinearLayout linearLayout = (LinearLayout) this.f57450a.f57449b.element;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
        }
    }

    public final void a(View view) {
        k.c(view, "view");
        this.f57439h = view;
        View view2 = this.f57439h;
        if (view2 == null) {
            k.a("fragmentView");
        }
        ((TextView) view2.findViewById(R.id.okTv)).setOnClickListener(new g(view));
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f57447a;

        g(View view) {
            this.f57447a = view;
        }

        public final void onClick(View view) {
            View findViewById = this.f57447a.findViewById(R.id.tagSavedLl);
            k.a((Object) findViewById, "view.findViewById<LinearLayout>(R.id.tagSavedLl)");
            ((LinearLayout) findViewById).setVisibility(8);
        }
    }

    public final void a(Menu menu, MenuInflater menuInflater) {
        MenuItem findItem;
        super.a(menu, menuInflater);
        if (menuInflater != null) {
            menuInflater.inflate(R.menu.pass_passbookmenu, menu);
        }
        if (!(menu == null || (findItem = menu.findItem(R.id.action_passbook_search)) == null)) {
            findItem.setVisible(false);
        }
        MenuItem findItem2 = menu != null ? menu.findItem(R.id.action_passbook_search_new) : null;
        if (findItem2 == null) {
            k.a();
        }
        this.k = findItem2;
        MenuItem menuItem = this.k;
        if (menuItem == null) {
            k.a("mSearchMenuItem");
        }
        menuItem.setVisible(true);
    }

    public final void a(MenuItem menuItem) {
        super.a(menuItem);
        if (menuItem != null && menuItem.getItemId() == R.id.action_passbook_search_new) {
            Intent intent = new Intent(this.j, PassbookSearchActivity.class);
            intent.putExtra("title", this.j.getResources().getString(R.string.search));
            intent.putExtra("issearch", true);
            intent.putExtra("sub_wallet_type", n.PAYTM_WALLET.getValue());
            this.j.startActivity(intent);
            net.one97.paytm.passbook.d.b().a(this.j, "passbook", "wallet_search_clicked", (String) null, "", "/passbook/wallet", "passbook");
        }
    }

    public final void a(int i2, int i3, Intent intent) {
        super.a(i2, i3, intent);
        if (i2 == 128 || i2 == 127 || i2 == 3) {
            Fragment c2 = this.f57436e.getSupportFragmentManager().c(R.id.l2Fragment);
            if (c2 != null) {
                ((PassbookL2Fragment) c2).b();
                a();
                Fragment c3 = this.f57436e.getSupportFragmentManager().c(R.id.l2Fragment);
                if (c3 != null) {
                    ((PassbookL2Fragment) c3).a();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
        }
    }

    public final void l() {
        net.one97.paytm.passbook.d.b().b("/uth_passbook_myaccounts/Paytm_wallet", "PASSBOOK", this.j);
    }

    public final void a(Throwable th) {
        getClass().getSimpleName();
        j.a((Activity) this.f57436e, th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x003c, code lost:
        r1 = r1.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.FrameLayout r9) {
        /*
            r8 = this;
            java.lang.String r0 = "pbBannerContainer"
            kotlin.g.b.k.c(r9, r0)
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.utility.k r1 = net.one97.paytm.passbook.utility.k.f59256a
            java.lang.String r1 = net.one97.paytm.passbook.utility.k.e()
            r2 = 1
            boolean r0 = r0.a((java.lang.String) r1, (boolean) r2)
            if (r0 == 0) goto L_0x0056
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.utility.k r1 = net.one97.paytm.passbook.utility.k.f59256a
            java.lang.String r1 = net.one97.paytm.passbook.utility.k.f()
            java.lang.String r4 = r0.a((java.lang.String) r1)
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()
            androidx.appcompat.app.AppCompatActivity r0 = r8.f57436e
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            com.paytm.network.a$c r5 = com.paytm.network.a.c.PASSBOOK
            r6 = r9
            android.view.View r6 = (android.view.View) r6
            java.lang.String r7 = "Main Wallet Passbook"
            androidx.fragment.app.Fragment r0 = r2.a((android.app.Activity) r3, (java.lang.String) r4, (com.paytm.network.a.c) r5, (android.view.View) r6, (java.lang.String) r7)
            androidx.appcompat.app.AppCompatActivity r1 = r8.f57436e
            if (r1 == 0) goto L_0x0047
            androidx.fragment.app.j r1 = r1.getSupportFragmentManager()
            if (r1 == 0) goto L_0x0047
            androidx.fragment.app.q r1 = r1.a()
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            if (r1 == 0) goto L_0x0051
            int r9 = r9.getId()
            r1.b(r9, r0)
        L_0x0051:
            if (r1 == 0) goto L_0x0056
            r1.c()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.a.c.a(android.widget.FrameLayout):void");
    }

    public final String[] b() {
        return this.j.getResources().getStringArray(R.array.passbook_tabs);
    }

    public final o<String, ArrayList<String>> f() {
        String[] stringArray = this.j.getResources().getStringArray(R.array.passbook_tabs);
        k.a((Object) stringArray, "mContext.resources.getSt…ay(R.array.passbook_tabs)");
        return new o<>(this.j.getString(R.string.wallet_filter_tran), (ArrayList) kotlin.a.f.a((T[]) stringArray, new ArrayList()));
    }

    public final String h() {
        String string = this.j.getString(R.string.pass_paytm_wallet);
        k.a((Object) string, "mContext.getString(R.string.pass_paytm_wallet)");
        return string;
    }

    public final Drawable i() {
        return androidx.core.content.b.a(this.j, R.drawable.pass_ic_payment_bank);
    }

    public static final /* synthetic */ void a(c cVar) {
        x.e eVar = new x.e();
        View view = cVar.f57439h;
        if (view == null) {
            k.a("fragmentView");
        }
        eVar.element = view != null ? (LinearLayout) view.findViewById(R.id.tagSavedLl) : null;
        Animation loadAnimation = AnimationUtils.loadAnimation(cVar.j, R.anim.pass_text_scroll_top_to_bottom);
        LinearLayout linearLayout = (LinearLayout) eVar.element;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = (LinearLayout) eVar.element;
        if (linearLayout2 != null) {
            linearLayout2.startAnimation(loadAnimation);
        }
        new Handler().postDelayed(new h(cVar, eVar), 3000);
    }
}
