package net.one97.paytm.passbook.genericPassbook.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends net.one97.paytm.passbook.genericPassbook.b.a {

    /* renamed from: a  reason: collision with root package name */
    i.a<IJRDataModel> f57255a;

    /* renamed from: b  reason: collision with root package name */
    i.a<IJRDataModel> f57256b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> f57257c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    CustProductList f57258d;

    /* renamed from: e  reason: collision with root package name */
    d f57259e;

    /* renamed from: f  reason: collision with root package name */
    String f57260f;

    /* renamed from: g  reason: collision with root package name */
    String f57261g;

    /* renamed from: h  reason: collision with root package name */
    CountDownLatch f57262h;
    private ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> k = new ArrayList<>();
    private ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> l = new ArrayList<>();
    private boolean m = true;
    private b n;
    private final ExecutorService o = Executors.newCachedThreadPool();
    private final String p = AppConstants.FEED_COMMUNITY;
    private final String q = UpiConstants.DEFAULT_ACCOUNT_CONSTANT;
    private final Context r;

    public final void a(Context context, View view) {
        k.c(context, "context");
        k.c(view, "viewId");
    }

    public final void a(TextView textView) {
        k.c(textView, "mBalanceTitleText");
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.a.a$a  reason: collision with other inner class name */
    static final class C1071a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57263a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57264b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57265c;

        C1071a(a aVar, x.e eVar, x.e eVar2) {
            this.f57263a = aVar;
            this.f57264b = eVar;
            this.f57265c = eVar2;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CustProductList) {
                a aVar = this.f57263a;
                CustProductList custProductList = (CustProductList) iJRDataModel;
                aVar.f57258d = custProductList;
                String iCARefId = custProductList.getICARefId();
                k.a((Object) iCARefId, "it.icaRefId");
                aVar.f57260f = iCARefId;
                a aVar2 = this.f57263a;
                String iCAAccNum = custProductList.getICAAccNum();
                k.a((Object) iCAAccNum, "it.icaAccNum");
                aVar2.f57261g = iCAAccNum;
                d dVar = this.f57263a.f57259e;
                if (dVar != null) {
                    String str = this.f57263a.f57261g;
                    if (str == null) {
                        k.a("mAccountNumber");
                    }
                    if (str != null) {
                        dVar.f57278a = str;
                    }
                }
                CountDownLatch countDownLatch = this.f57263a.f57262h;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                c cVar = c.f57277a;
                Context context = this.f57263a.j;
                i.a<IJRDataModel> aVar3 = this.f57263a.f57256b;
                if (aVar3 == null) {
                    k.a("fetchBalanceResponseHandler");
                }
                g gVar = (g) this.f57264b.element;
                String str2 = this.f57263a.f57260f;
                if (str2 == null) {
                    k.a("acctRefId");
                }
                cVar.a(context, aVar3, gVar, str2);
            } else if (iJRDataModel instanceof CJRAccountSummary) {
                CJRSubWallet cJRSubWallet = new CJRSubWallet();
                String str3 = ((CJRAccountSummary) iJRDataModel).getmTotalBalance();
                k.a((Object) str3, "it.getmTotalBalance()");
                Double b2 = p.b(str3);
                cJRSubWallet.setBalance(b2 != null ? b2.doubleValue() : 0.0d);
                ((y) this.f57265c.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, cJRSubWallet, (Throwable) null));
            }
        }
    }

    static final class c<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57268a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57269b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57270c;

        c(a aVar, x.e eVar, x.e eVar2) {
            this.f57268a = aVar;
            this.f57269b = eVar;
            this.f57270c = eVar2;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> transactionDetails;
            ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> transactionDetails2;
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CustProductList) {
                a aVar = this.f57268a;
                aVar.f57258d = (CustProductList) iJRDataModel;
                a.a(aVar, (g) this.f57269b.element);
            } else if (iJRDataModel instanceof SavingAccountPassbookEntriesModal) {
                SavingAccountPassbookEntriesModal savingAccountPassbookEntriesModal = (SavingAccountPassbookEntriesModal) iJRDataModel;
                SavingAccountPassbookEntriesModal.Response response = savingAccountPassbookEntriesModal.getResponse();
                if (!(response == null || (transactionDetails2 = response.getTransactionDetails()) == null)) {
                    this.f57268a.a(transactionDetails2);
                }
                SavingAccountPassbookEntriesModal.Response response2 = savingAccountPassbookEntriesModal.getResponse();
                if (!(response2 == null || (transactionDetails = response2.getTransactionDetails()) == null)) {
                    this.f57268a.f57257c.addAll(transactionDetails);
                }
                ((y) this.f57270c.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        k.c(context, "context");
        this.r = context;
    }

    public final RecyclerView.a<RecyclerView.v> a(net.one97.paytm.passbook.genericPassbook.b.c cVar, RecyclerView recyclerView) {
        k.c(cVar, "listener");
        k.c(recyclerView, "rvEntries");
        d dVar = this.f57259e;
        if (dVar == null) {
            dVar = new d(this.k);
        }
        this.f57259e = dVar;
        d dVar2 = this.f57259e;
        if (dVar2 == null) {
            k.a();
        }
        recyclerView.addItemDecoration(new net.one97.paytm.passbook.search.b.a(dVar2));
        d dVar3 = this.f57259e;
        if (dVar3 == null) {
            k.a();
        }
        return dVar3;
    }

    public final void a() {
        this.m = true;
        this.f57258d = null;
    }

    public final Fragment c() {
        b bVar = this.n;
        if (bVar == null) {
            bVar = new b();
        }
        this.n = bVar;
        b bVar2 = this.n;
        if (bVar2 == null) {
            k.a();
        }
        return bVar2;
    }

    public final LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> d() {
        x.e eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = (g) new b(this, eVar);
        this.f57256b = new C1071a(this, eVar2, eVar);
        if (this.f57258d == null) {
            this.f57262h = new CountDownLatch(1);
            c cVar = c.f57277a;
            Context context = this.j;
            i.a<IJRDataModel> aVar = this.f57256b;
            if (aVar == null) {
                k.a("fetchBalanceResponseHandler");
            }
            cVar.a(context, aVar, (g) eVar2.element);
        } else {
            c cVar2 = c.f57277a;
            Context context2 = this.j;
            i.a<IJRDataModel> aVar2 = this.f57256b;
            if (aVar2 == null) {
                k.a("fetchBalanceResponseHandler");
            }
            g gVar = (g) eVar2.element;
            String str = this.f57260f;
            if (str == null) {
                k.a("acctRefId");
            }
            cVar2.a(context2, aVar2, gVar, str);
        }
        return (y) eVar.element;
    }

    static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57266a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57267b;

        b(a aVar, x.e eVar) {
            this.f57266a = aVar;
            this.f57267b = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            CountDownLatch countDownLatch;
            if ((iJRPaytmDataModel instanceof CustProductList) && (countDownLatch = this.f57266a.f57262h) != null) {
                countDownLatch.countDown();
            }
            ((y) this.f57267b.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    public final synchronized LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> a(int i2) {
        x.e eVar;
        eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = (g) new e(eVar);
        this.f57255a = new c(this, eVar2, eVar);
        this.o.execute(new d(this, eVar2));
        return (y) eVar.element;
    }

    static final class e implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57273a;

        e(x.e eVar) {
            this.f57273a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ((y) this.f57273a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57271a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57272b;

        d(a aVar, x.e eVar) {
            this.f57271a = aVar;
            this.f57272b = eVar;
        }

        public final void run() {
            if (this.f57271a.f57258d == null) {
                CountDownLatch countDownLatch = this.f57271a.f57262h;
                if (countDownLatch != null) {
                    countDownLatch.await();
                }
                if (this.f57271a.f57258d == null) {
                    c cVar = c.f57277a;
                    Context context = this.f57271a.j;
                    i.a<IJRDataModel> aVar = this.f57271a.f57255a;
                    if (aVar == null) {
                        k.a("txnSuccessListener");
                    }
                    cVar.a(context, aVar, (g) this.f57272b.element);
                    return;
                }
            }
            a.a(this.f57271a, (g) this.f57272b.element);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        String str;
        if (this.k.size() > 0) {
            str = ((SavingAccountPassbookEntriesModal.TransactionDetail) kotlin.a.k.f(this.k)).getTxnDate();
            k.a((Object) str, "transactionArrayList.last().txnDate");
        } else {
            str = "";
        }
        Iterator<SavingAccountPassbookEntriesModal.TransactionDetail> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SavingAccountPassbookEntriesModal.TransactionDetail next = it2.next();
            k.a((Object) next, "transaction");
            String txnDate = next.getTxnDate();
            k.a((Object) txnDate, "transaction.txnDate");
            String a2 = a(txnDate);
            if (this.k.size() == 0) {
                this.k.add(new SavingAccountPassbookEntriesModal.TransactionHeader(a2));
            } else if (!p.a(a2, str, true)) {
                this.k.add(new SavingAccountPassbookEntriesModal.TransactionHeader(a2));
            }
            String txnDate2 = next.getTxnDate();
            k.a((Object) txnDate2, "transaction.txnDate");
            next.setFormattedTxnTime(b(txnDate2));
            this.k.add(next);
            str = a2;
        }
    }

    private static String a(String str) {
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

    private static String b(String str) {
        try {
            String format = new SimpleDateFormat("hh:mm a").format(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str));
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
        return this.m;
    }

    public final o<String, ArrayList<String>> f() {
        return new o<>(this.r.getString(R.string.wallet_filter_tran), kotlin.a.k.d(AppConstants.FOR_ALL, "Withdrawals", "Deposits"));
    }

    public final void g() {
        d dVar = this.f57259e;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    public final void a(int i2, Runnable runnable) {
        k.c(runnable, "fetchTransactionCallable");
        if (i2 == 0) {
            this.k.clear();
            a(this.f57257c);
        } else if (i2 == 1) {
            c(this.q);
        } else if (i2 == 2) {
            c(this.p);
        }
        g();
    }

    private final void c(String str) {
        this.l.clear();
        int size = this.f57257c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f57257c.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionDetail) {
                SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = this.f57257c.get(i2);
                k.a((Object) transactionDetail, "transactionArrayListCopy[i]");
                String txnType = transactionDetail.getTxnType();
                k.a((Object) txnType, "transactionArrayListCopy[i].txnType");
                if (txnType == null) {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                } else if (txnType.contentEquals(str)) {
                    this.l.add(this.f57257c.get(i2));
                }
            }
        }
        this.k.clear();
        a(this.l);
    }

    public final String h() {
        String string = this.r.getString(R.string.pass_ica_title);
        k.a((Object) string, "context.getString(R.string.pass_ica_title)");
        return string;
    }

    public final Drawable i() {
        return androidx.core.content.b.a(this.r, R.drawable.pass_ic_payment_bank);
    }

    public final int j() {
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = this.k;
        return (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue();
    }

    public final void k() {
        super.k();
        Context context = this.r;
        if (context != null) {
            com.paytm.utility.b.e((Activity) context);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    public final void a(Throwable th) {
        Context context = this.r;
        if (!(context instanceof Activity)) {
            context = null;
        }
        getClass().getSimpleName();
        j.a((Activity) context, th);
    }

    public final String[] b() {
        return this.j.getResources().getStringArray(R.array.passbook_saving_account_tabs);
    }

    public static final /* synthetic */ void a(a aVar, g gVar) {
        c cVar = c.f57277a;
        Context context = aVar.j;
        String str = aVar.f57261g;
        if (str == null) {
            k.a("mAccountNumber");
        }
        i.a<IJRDataModel> aVar2 = aVar.f57255a;
        if (aVar2 == null) {
            k.a("txnSuccessListener");
        }
        k.c(context, "mContext");
        k.c("0", "offset");
        k.c(str, "accountNo");
        k.c(aVar2, "listener");
        k.c(gVar, "errorListener");
        Map hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        k.a((Object) a2, "CJRServerUtility.getSSOToken(mContext)");
        hashMap.put("Authorization", a2);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Encoding", "gzip");
        HashMap hashMap2 = new HashMap();
        Map map = hashMap2;
        map.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str);
        map.put("offset", "0");
        map.put(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
        net.one97.paytm.passbook.mapping.a.a aVar3 = new net.one97.paytm.passbook.mapping.a.a(com.paytm.utility.b.e(context, c.a(net.one97.paytm.passbook.d.b().a("ppb_passbook_history"), hashMap2)), aVar2, gVar, new SavingAccountPassbookEntriesModal(), hashMap, a.c.PASSBOOK, a.b.USER_FACING, cVar.getClass().getSimpleName());
        net.one97.paytm.passbook.mapping.a.c.a();
        net.one97.paytm.passbook.mapping.a.c.b(aVar3);
    }
}
