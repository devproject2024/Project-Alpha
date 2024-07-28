package net.one97.paytm.passbook.genericPassbook.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import net.one97.paytm.passbook.beans.BalanceBreakupModel;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.SAHistoryPagination;
import net.one97.paytm.passbook.beans.SAHistoryResponse;
import net.one97.paytm.passbook.beans.SAHistoryTransaction;
import net.one97.paytm.passbook.beans.SAHistoryTransactionHeader;
import net.one97.paytm.passbook.beans.SAHistoryTransactionItems;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends net.one97.paytm.passbook.genericPassbook.b.a {

    /* renamed from: a  reason: collision with root package name */
    public AppCompatActivity f57338a;

    /* renamed from: b  reason: collision with root package name */
    double f57339b;

    /* renamed from: c  reason: collision with root package name */
    String f57340c;

    /* renamed from: d  reason: collision with root package name */
    i.a<IJRDataModel> f57341d;

    /* renamed from: e  reason: collision with root package name */
    i.a<IJRDataModel> f57342e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> f57343f;

    /* renamed from: g  reason: collision with root package name */
    boolean f57344g;

    /* renamed from: h  reason: collision with root package name */
    CustProductList f57345h;
    net.one97.paytm.passbook.genericPassbook.a.f k;
    c l;
    String m;
    CountDownLatch n;
    CJRSubWallet o;
    ArrayList<SAHistoryTransaction> p;
    String q;
    SAHistoryPagination r;
    Context s;
    private boolean t;
    private ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> u;
    private ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> v;
    private net.one97.paytm.passbook.genericPassbook.a.e w;
    private final ExecutorService x;
    private final String y;
    private final String z;

    public final void a(Context context, View view) {
        k.c(context, "context");
        k.c(view, "viewId");
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.c.a$a  reason: collision with other inner class name */
    static final class C1072a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57346a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57347b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57348c;

        C1072a(a aVar, x.e eVar, x.e eVar2) {
            this.f57346a = aVar;
            this.f57347b = eVar;
            this.f57348c = eVar2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
            r1 = kotlin.m.p.b((r1 = r6.getmTotalBalance()));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onResponse(java.lang.Object r6) {
            /*
                r5 = this;
                net.one97.paytm.passbook.mapping.IJRDataModel r6 = (net.one97.paytm.passbook.mapping.IJRDataModel) r6
                boolean r0 = r6 instanceof net.one97.paytm.passbook.beans.CustProductList
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x006b
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                net.one97.paytm.passbook.beans.CustProductList r6 = (net.one97.paytm.passbook.beans.CustProductList) r6
                r0.f57345h = r6
                java.lang.String r0 = r6.getIsaStatus()
                if (r0 == 0) goto L_0x006a
                java.lang.String r3 = "ISSUED"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                if (r0 == 0) goto L_0x006a
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                if (r6 == 0) goto L_0x0024
                java.lang.String r2 = r6.getIsaAccNum()
            L_0x0024:
                java.lang.String r6 = "it?.isaAccNum"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
                r0.m = r2
                net.one97.paytm.passbook.genericPassbook.c.a r6 = r5.f57346a
                net.one97.paytm.passbook.genericPassbook.a.f r6 = r6.k
                if (r6 == 0) goto L_0x0039
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                java.lang.String r0 = r0.m
                if (r0 == 0) goto L_0x0039
                r6.f57306a = r0
            L_0x0039:
                net.one97.paytm.passbook.genericPassbook.c.a r6 = r5.f57346a
                net.one97.paytm.passbook.genericPassbook.c.c r6 = r6.l
                if (r6 == 0) goto L_0x0047
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                java.lang.String r0 = r0.m
                if (r0 == 0) goto L_0x0047
                r6.f57360a = r0
            L_0x0047:
                net.one97.paytm.passbook.genericPassbook.c.a r6 = r5.f57346a
                java.util.concurrent.CountDownLatch r6 = r6.n
                if (r6 == 0) goto L_0x0050
                r6.countDown()
            L_0x0050:
                net.one97.paytm.passbook.genericPassbook.c.b r6 = net.one97.paytm.passbook.genericPassbook.c.b.f57359a
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                android.content.Context r0 = r0.j
                net.one97.paytm.passbook.genericPassbook.c.a r1 = r5.f57346a
                net.one97.paytm.passbook.mapping.a.i$a<net.one97.paytm.passbook.mapping.IJRDataModel> r1 = r1.f57342e
                if (r1 != 0) goto L_0x0061
                java.lang.String r2 = "fetchBalanceResponseHandler"
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0061:
                kotlin.g.b.x$e r2 = r5.f57347b
                T r2 = r2.element
                net.one97.paytm.passbook.mapping.a.g r2 = (net.one97.paytm.passbook.mapping.a.g) r2
                r6.b(r0, r1, r2)
            L_0x006a:
                return
            L_0x006b:
                boolean r0 = r6 instanceof net.one97.paytm.passbook.beans.CJRAccountSummary
                if (r0 == 0) goto L_0x00ea
                net.one97.paytm.passbook.beans.CJRAccountSummary r6 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r6
                java.lang.String r0 = r6.getStatus()
                if (r0 == 0) goto L_0x00da
                java.lang.String r3 = "SUCCESS"
                boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r1)
                if (r0 == 0) goto L_0x00d9
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                net.one97.paytm.passbook.beans.CJRSubWallet r0 = r0.o
                if (r6 == 0) goto L_0x0096
                java.lang.String r1 = r6.getmTotalBalance()
                if (r1 == 0) goto L_0x0096
                java.lang.Double r1 = kotlin.m.p.b(r1)
                if (r1 == 0) goto L_0x0096
                double r3 = r1.doubleValue()
                goto L_0x0098
            L_0x0096:
                r3 = 0
            L_0x0098:
                r0.setBalance(r3)
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                if (r6 == 0) goto L_0x00a4
                java.lang.String r1 = r6.getmTotalBalance()
                goto L_0x00a5
            L_0x00a4:
                r1 = r2
            L_0x00a5:
                java.lang.String r3 = "it?.getmTotalBalance()"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                java.lang.String r3 = "<set-?>"
                kotlin.g.b.k.c(r1, r3)
                r0.f57340c = r1
                net.one97.paytm.passbook.genericPassbook.c.a r0 = r5.f57346a
                if (r6 == 0) goto L_0x00be
                double r3 = r6.getEffectiveBalance()
                java.lang.Double r6 = java.lang.Double.valueOf(r3)
                goto L_0x00bf
            L_0x00be:
                r6 = r2
            L_0x00bf:
                double r3 = r6.doubleValue()
                r0.f57339b = r3
                kotlin.g.b.x$e r6 = r5.f57348c
                T r6 = r6.element
                androidx.lifecycle.y r6 = (androidx.lifecycle.y) r6
                net.one97.paytm.passbook.genericPassbook.b r0 = new net.one97.paytm.passbook.genericPassbook.b
                net.one97.paytm.passbook.genericPassbook.c r1 = net.one97.paytm.passbook.genericPassbook.c.SUCCESS
                net.one97.paytm.passbook.genericPassbook.c.a r3 = r5.f57346a
                net.one97.paytm.passbook.beans.CJRSubWallet r3 = r3.o
                r0.<init>(r1, r3, r2)
                r6.postValue(r0)
            L_0x00d9:
                return
            L_0x00da:
                kotlin.g.b.x$e r6 = r5.f57348c
                T r6 = r6.element
                androidx.lifecycle.y r6 = (androidx.lifecycle.y) r6
                net.one97.paytm.passbook.genericPassbook.b r0 = new net.one97.paytm.passbook.genericPassbook.b
                net.one97.paytm.passbook.genericPassbook.c r1 = net.one97.paytm.passbook.genericPassbook.c.ERROR
                r0.<init>(r1, r2, r2)
                r6.postValue(r0)
            L_0x00ea:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.c.a.C1072a.onResponse(java.lang.Object):void");
        }
    }

    static final class c<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57351a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57352b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57353c;

        c(a aVar, x.e eVar, x.e eVar2) {
            this.f57351a = aVar;
            this.f57352b = eVar;
            this.f57353c = eVar2;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str;
            String str2;
            ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> transactionDetails;
            ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> transactionDetails2;
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CustProductList) {
                a aVar = this.f57351a;
                aVar.f57345h = (CustProductList) iJRDataModel;
                a.a(aVar, (net.one97.paytm.passbook.mapping.a.g) this.f57352b.element);
            } else if (iJRDataModel instanceof SavingAccountPassbookEntriesModal) {
                SavingAccountPassbookEntriesModal savingAccountPassbookEntriesModal = (SavingAccountPassbookEntriesModal) iJRDataModel;
                SavingAccountPassbookEntriesModal.Response response = savingAccountPassbookEntriesModal.getResponse();
                if (!(response == null || (transactionDetails2 = response.getTransactionDetails()) == null)) {
                    this.f57351a.a(transactionDetails2);
                }
                SavingAccountPassbookEntriesModal.Response response2 = savingAccountPassbookEntriesModal.getResponse();
                if (!(response2 == null || (transactionDetails = response2.getTransactionDetails()) == null)) {
                    this.f57351a.f57343f.addAll(transactionDetails);
                }
                ((y) this.f57353c.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
            } else if (iJRDataModel instanceof SAHistoryResponse) {
                SAHistoryResponse sAHistoryResponse = (SAHistoryResponse) iJRDataModel;
                ArrayList<SAHistoryTransactionItems> txns = sAHistoryResponse.getTxns();
                if (txns != null) {
                    Iterator<SAHistoryTransactionItems> it2 = txns.iterator();
                    while (it2.hasNext()) {
                        SAHistoryTransactionItems next = it2.next();
                        String str3 = this.f57351a.q;
                        String l = net.one97.paytm.passbook.mapping.a.l(next.getDateLabel(), "yyyy-MM-dd", "MMMM yyyy");
                        if (l == null) {
                            str = null;
                        } else if (l != null) {
                            str = l.toUpperCase();
                            k.a((Object) str, "(this as java.lang.String).toUpperCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                        if (!k.a((Object) str3, (Object) str)) {
                            String l2 = net.one97.paytm.passbook.mapping.a.l(next.getDateLabel(), "yyyy-MM-dd", "MMMM yyyy");
                            if (l2 == null) {
                                str2 = null;
                            } else if (l2 != null) {
                                str2 = l2.toUpperCase();
                                k.a((Object) str2, "(this as java.lang.String).toUpperCase()");
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                            this.f57351a.p.add(new SAHistoryTransaction(new SAHistoryTransactionHeader(str2), (SAHistoryTransactionItems) null));
                            if (str2 != null) {
                                this.f57351a.q = str2;
                            }
                        }
                        this.f57351a.p.add(new SAHistoryTransaction((SAHistoryTransactionHeader) null, next));
                    }
                }
                this.f57351a.r = sAHistoryResponse.getPaginationParams();
                if (sAHistoryResponse.getPaginationParams() == null) {
                    this.f57351a.f57344g = false;
                }
                ((y) this.f57353c.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private a(Context context) {
        super(context);
        k.c(context, "context");
        this.s = context;
        this.f57340c = "";
        this.t = net.one97.paytm.passbook.d.b().a("pass2ShowBankTransactionsV2", true);
        this.u = new ArrayList<>();
        this.f57343f = new ArrayList<>();
        this.v = new ArrayList<>();
        this.f57344g = true;
        this.m = "";
        this.x = Executors.newCachedThreadPool();
        this.y = AppConstants.FEED_COMMUNITY;
        this.z = UpiConstants.DEFAULT_ACCOUNT_CONSTANT;
        this.o = new CJRSubWallet();
        this.p = new ArrayList<>();
        this.q = "";
    }

    public final AppCompatActivity n() {
        AppCompatActivity appCompatActivity = this.f57338a;
        if (appCompatActivity == null) {
            k.a("activity");
        }
        return appCompatActivity;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(Context context, AppCompatActivity appCompatActivity) {
        this(context);
        k.c(context, "context");
        k.c(appCompatActivity, "activity");
        this.s = context;
        this.f57338a = appCompatActivity;
    }

    public final RecyclerView.a<RecyclerView.v> a(net.one97.paytm.passbook.genericPassbook.b.c cVar, RecyclerView recyclerView) {
        k.c(cVar, "listener");
        k.c(recyclerView, "rvEntries");
        if (this.t) {
            c cVar2 = this.l;
            if (cVar2 == null) {
                cVar2 = new c(this.p, cVar);
            }
            this.l = cVar2;
            c cVar3 = this.l;
            if (cVar3 == null) {
                k.a();
            }
            recyclerView.addItemDecoration(new net.one97.paytm.passbook.search.b.a(cVar3));
            c cVar4 = this.l;
            if (cVar4 == null) {
                k.a();
            }
            return cVar4;
        }
        net.one97.paytm.passbook.genericPassbook.a.f fVar = this.k;
        if (fVar == null) {
            fVar = new net.one97.paytm.passbook.genericPassbook.a.f(this.u);
        }
        this.k = fVar;
        net.one97.paytm.passbook.genericPassbook.a.f fVar2 = this.k;
        if (fVar2 == null) {
            k.a();
        }
        recyclerView.addItemDecoration(new net.one97.paytm.passbook.search.b.a(fVar2));
        net.one97.paytm.passbook.genericPassbook.a.f fVar3 = this.k;
        if (fVar3 == null) {
            k.a();
        }
        return fVar3;
    }

    public final void a() {
        this.f57344g = true;
        this.f57345h = null;
    }

    public final Fragment c() {
        net.one97.paytm.passbook.genericPassbook.a.e eVar = this.w;
        if (eVar == null) {
            eVar = new net.one97.paytm.passbook.genericPassbook.a.e(this.o);
        }
        this.w = eVar;
        net.one97.paytm.passbook.genericPassbook.a.e eVar2 = this.w;
        if (eVar2 == null) {
            k.a();
        }
        return eVar2;
    }

    public final LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> d() {
        x.e eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = (net.one97.paytm.passbook.mapping.a.g) new b(this, eVar);
        this.f57342e = new C1072a(this, eVar2, eVar);
        if (this.f57345h == null) {
            this.n = new CountDownLatch(1);
            b bVar = b.f57359a;
            Context context = this.j;
            i.a<IJRDataModel> aVar = this.f57342e;
            if (aVar == null) {
                k.a("fetchBalanceResponseHandler");
            }
            bVar.a(context, aVar, (net.one97.paytm.passbook.mapping.a.g) eVar2.element);
        } else {
            b bVar2 = b.f57359a;
            Context context2 = this.j;
            i.a<IJRDataModel> aVar2 = this.f57342e;
            if (aVar2 == null) {
                k.a("fetchBalanceResponseHandler");
            }
            bVar2.b(context2, aVar2, (net.one97.paytm.passbook.mapping.a.g) eVar2.element);
        }
        return (y) eVar.element;
    }

    static final class b implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57349a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57350b;

        b(a aVar, x.e eVar) {
            this.f57349a = aVar;
            this.f57350b = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            CountDownLatch countDownLatch;
            if ((iJRPaytmDataModel instanceof CustProductList) && (countDownLatch = this.f57349a.n) != null) {
                countDownLatch.countDown();
            }
            ((y) this.f57350b.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    public final synchronized LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> a(int i2) {
        x.e eVar;
        eVar = new x.e();
        eVar.element = new y();
        x.e eVar2 = new x.e();
        eVar2.element = (net.one97.paytm.passbook.mapping.a.g) new e(eVar);
        this.f57341d = new c(this, eVar2, eVar);
        this.x.execute(new d(this, eVar2));
        return (y) eVar.element;
    }

    static final class e implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57356a;

        e(x.e eVar) {
            this.f57356a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ((y) this.f57356a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57354a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57355b;

        d(a aVar, x.e eVar) {
            this.f57354a = aVar;
            this.f57355b = eVar;
        }

        public final void run() {
            if (this.f57354a.f57345h == null) {
                CountDownLatch countDownLatch = this.f57354a.n;
                if (countDownLatch != null) {
                    countDownLatch.await();
                }
                if (this.f57354a.f57345h == null) {
                    b bVar = b.f57359a;
                    Context context = this.f57354a.j;
                    i.a<IJRDataModel> aVar = this.f57354a.f57341d;
                    if (aVar == null) {
                        k.a("txnSuccessListener");
                    }
                    bVar.a(context, aVar, (net.one97.paytm.passbook.mapping.a.g) this.f57355b.element);
                    return;
                }
            }
            a.a(this.f57354a, (net.one97.paytm.passbook.mapping.a.g) this.f57355b.element);
        }
    }

    public final boolean e() {
        return this.f57344g;
    }

    public final o<String, ArrayList<String>> f() {
        return new o<>(this.s.getString(R.string.wallet_filter_tran), kotlin.a.k.d(AppConstants.FOR_ALL, "Withdrawals", "Deposits"));
    }

    public final void g() {
        if (this.t) {
            c cVar = this.l;
            if (cVar != null) {
                cVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        net.one97.paytm.passbook.genericPassbook.a.f fVar = this.k;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public final void a(int i2, Runnable runnable) {
        k.c(runnable, "fetchTransactionCallable");
        if (i2 == 0) {
            this.u.clear();
            a(this.f57343f);
        } else if (i2 == 1) {
            a(this.z);
        } else if (i2 == 2) {
            a(this.y);
        }
        g();
    }

    private final void a(String str) {
        this.v.clear();
        int size = this.f57343f.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f57343f.get(i2) instanceof SavingAccountPassbookEntriesModal.TransactionDetail) {
                SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = this.f57343f.get(i2);
                k.a((Object) transactionDetail, "transactionArrayListCopy[i]");
                String txnType = transactionDetail.getTxnType();
                k.a((Object) txnType, "transactionArrayListCopy[i].txnType");
                if (txnType == null) {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                } else if (txnType.contentEquals(str)) {
                    this.v.add(this.f57343f.get(i2));
                }
            }
        }
        this.u.clear();
        a(this.v);
    }

    /* access modifiers changed from: package-private */
    public final void a(ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        String str;
        if (this.u.size() > 0) {
            str = ((SavingAccountPassbookEntriesModal.TransactionDetail) kotlin.a.k.f(this.u)).getTxnDate();
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
            String b2 = b(txnDate);
            if (this.u.size() == 0) {
                this.u.add(new SavingAccountPassbookEntriesModal.TransactionHeader(b2));
            } else if (!p.a(b2, str, true)) {
                this.u.add(new SavingAccountPassbookEntriesModal.TransactionHeader(b2));
            }
            String txnDate2 = next.getTxnDate();
            k.a((Object) txnDate2, "transaction.txnDate");
            next.setFormattedTxnTime(c(txnDate2));
            this.u.add(next);
            str = b2;
        }
    }

    private static String b(String str) {
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

    private static String c(String str) {
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

    public final String h() {
        String string = this.s.getString(R.string.passbook_paytm_bank_savings_account);
        k.a((Object) string, "context.getString(R.stri…ytm_bank_savings_account)");
        return string;
    }

    public final Drawable i() {
        return androidx.core.content.b.a(this.s, R.drawable.pass_ic_payment_bank);
    }

    public final int j() {
        if (this.t) {
            return this.p.size();
        }
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList = this.u;
        return (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue();
    }

    public final void a(TextView textView) {
        k.c(textView, "mBalanceTitleText");
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.pass_info, 0);
        textView.setCompoundDrawablePadding(10);
        textView.setOnClickListener(new f(this));
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57357a;

        f(a aVar) {
            this.f57357a = aVar;
        }

        public final void onClick(View view) {
            a aVar = this.f57357a;
            try {
                double d2 = aVar.f57339b;
                if (aVar.o == null || TextUtils.isEmpty(aVar.f57340c) || TextUtils.equals(aVar.f57340c, "")) {
                    Toast.makeText(aVar.s, "Please wait", 0).show();
                    return;
                }
                double balance = aVar.o.getBalance();
                net.one97.paytm.passbook.main.a.a aVar2 = new net.one97.paytm.passbook.main.a.a(new BalanceBreakupModel(d2, balance - d2, balance));
                AppCompatActivity appCompatActivity = aVar.f57338a;
                if (appCompatActivity == null) {
                    k.a("activity");
                }
                aVar2.show(appCompatActivity.getSupportFragmentManager(), aVar.getClass().getName());
            } catch (Exception unused) {
                Toast.makeText(aVar.s, "Please wait", 0).show();
            }
        }
    }

    public final void k() {
        super.k();
        AppCompatActivity appCompatActivity = this.f57338a;
        if (appCompatActivity == null) {
            k.a("activity");
        }
        com.paytm.utility.b.e((Activity) appCompatActivity);
    }

    public final void a(int i2, int i3, Intent intent) {
        super.a(i2, i3, intent);
        if (i2 == 3) {
            AppCompatActivity appCompatActivity = this.f57338a;
            if (appCompatActivity == null) {
                k.a("activity");
            }
            Fragment c2 = appCompatActivity.getSupportFragmentManager().c(R.id.l2Fragment);
            if (c2 != null) {
                ((PassbookL2Fragment) c2).b();
                a();
                g();
                AppCompatActivity appCompatActivity2 = this.f57338a;
                if (appCompatActivity2 == null) {
                    k.a("activity");
                }
                Fragment c3 = appCompatActivity2.getSupportFragmentManager().c(R.id.l2Fragment);
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
        net.one97.paytm.passbook.d.b().b("/uth_passbook_myaccounts/ppbl_sa", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, this.s);
    }

    public final void m() {
        View view;
        View findViewById;
        View a2;
        AppCompatTextView appCompatTextView;
        LinearLayout linearLayout;
        if (this.t) {
            AppCompatActivity appCompatActivity = this.f57338a;
            if (appCompatActivity == null) {
                k.a("activity");
            }
            Fragment c2 = appCompatActivity.getSupportFragmentManager().c(R.id.l2Fragment);
            if (!(c2 instanceof PassbookL2Fragment)) {
                c2 = null;
            }
            PassbookL2Fragment passbookL2Fragment = (PassbookL2Fragment) c2;
            if (!(passbookL2Fragment == null || (linearLayout = (LinearLayout) passbookL2Fragment.a(R.id.filterLayout)) == null)) {
                linearLayout.setVisibility(8);
            }
            AppCompatActivity appCompatActivity2 = this.f57338a;
            if (appCompatActivity2 == null) {
                k.a("activity");
            }
            Fragment c3 = appCompatActivity2.getSupportFragmentManager().c(R.id.l2Fragment);
            if (!(c3 instanceof PassbookL2Fragment)) {
                c3 = null;
            }
            PassbookL2Fragment passbookL2Fragment2 = (PassbookL2Fragment) c3;
            if (!(passbookL2Fragment2 == null || (a2 = passbookL2Fragment2.a(R.id.layout_transaction_items)) == null || (appCompatTextView = (AppCompatTextView) a2.findViewById(R.id.tvPaymentHistory)) == null)) {
                appCompatTextView.setVisibility(0);
            }
            AppCompatActivity appCompatActivity3 = this.f57338a;
            if (appCompatActivity3 == null) {
                k.a("activity");
            }
            Fragment c4 = appCompatActivity3.getSupportFragmentManager().c(R.id.l2Fragment);
            if (!(c4 instanceof PassbookL2Fragment)) {
                c4 = null;
            }
            PassbookL2Fragment passbookL2Fragment3 = (PassbookL2Fragment) c4;
            if (passbookL2Fragment3 != null && (view = passbookL2Fragment3.getView()) != null && (findViewById = view.findViewById(R.id.paytmLine)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public final void a(Throwable th) {
        View a2;
        ConstraintLayout constraintLayout;
        TextView textView;
        View a3;
        ConstraintLayout constraintLayout2;
        AppCompatActivity appCompatActivity = this.f57338a;
        if (appCompatActivity == null) {
            k.a("activity");
        }
        Fragment c2 = appCompatActivity.getSupportFragmentManager().c(R.id.l2Fragment);
        if (!(c2 instanceof PassbookL2Fragment)) {
            c2 = null;
        }
        PassbookL2Fragment passbookL2Fragment = (PassbookL2Fragment) c2;
        if (!(passbookL2Fragment == null || (a3 = passbookL2Fragment.a(R.id.layout_transaction_items)) == null || (constraintLayout2 = (ConstraintLayout) a3.findViewById(R.id.ilDataFetchError)) == null)) {
            constraintLayout2.setVisibility(0);
        }
        AppCompatActivity appCompatActivity2 = this.f57338a;
        if (appCompatActivity2 == null) {
            k.a("activity");
        }
        Fragment c3 = appCompatActivity2.getSupportFragmentManager().c(R.id.l2Fragment);
        if (!(c3 instanceof PassbookL2Fragment)) {
            c3 = null;
        }
        PassbookL2Fragment passbookL2Fragment2 = (PassbookL2Fragment) c3;
        if (passbookL2Fragment2 != null && (a2 = passbookL2Fragment2.a(R.id.layout_transaction_items)) != null && (constraintLayout = (ConstraintLayout) a2.findViewById(R.id.ilDataFetchError)) != null && (textView = (TextView) constraintLayout.findViewById(R.id.btnRetry)) != null) {
            textView.setOnClickListener(new g(this));
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57358a;

        g(a aVar) {
            this.f57358a = aVar;
        }

        public final void onClick(View view) {
            View a2;
            ConstraintLayout constraintLayout;
            Fragment c2 = this.f57358a.n().getSupportFragmentManager().c(R.id.l2Fragment);
            if (!(c2 instanceof PassbookL2Fragment)) {
                c2 = null;
            }
            PassbookL2Fragment passbookL2Fragment = (PassbookL2Fragment) c2;
            if (!(passbookL2Fragment == null || (a2 = passbookL2Fragment.a(R.id.layout_transaction_items)) == null || (constraintLayout = (ConstraintLayout) a2.findViewById(R.id.ilDataFetchError)) == null)) {
                constraintLayout.setVisibility(8);
            }
            Fragment c3 = this.f57358a.n().getSupportFragmentManager().c(R.id.l2Fragment);
            if (!(c3 instanceof PassbookL2Fragment)) {
                c3 = null;
            }
            PassbookL2Fragment passbookL2Fragment2 = (PassbookL2Fragment) c3;
            if (passbookL2Fragment2 != null) {
                passbookL2Fragment2.a();
            }
        }
    }

    public final String[] b() {
        return this.j.getResources().getStringArray(R.array.passbook_saving_account_tabs);
    }

    public static final /* synthetic */ void a(a aVar, net.one97.paytm.passbook.mapping.a.g gVar) {
        String transactionDateEpoch;
        String lastTxnId;
        a aVar2 = aVar;
        net.one97.paytm.passbook.mapping.a.g gVar2 = gVar;
        if (aVar2.t) {
            b bVar = b.f57359a;
            Context context = aVar2.j;
            String str = aVar2.m;
            SAHistoryPagination sAHistoryPagination = aVar2.r;
            i.a<IJRDataModel> aVar3 = aVar2.f57341d;
            if (aVar3 == null) {
                k.a("txnSuccessListener");
            }
            k.c(context, "mContext");
            k.c(aVar3, "listener");
            k.c(gVar2, "errorListener");
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(net.one97.paytm.passbook.mapping.b.a(context))) {
                String a2 = net.one97.paytm.passbook.mapping.b.a(context);
                k.a((Object) a2, "CJRServerUtility.getSSOToken(mContext)");
                hashMap.put("Authorization", a2);
            }
            String str2 = com.paytm.utility.b.e(context, net.one97.paytm.passbook.d.b().a("pass2BankTransactionV2URL")) + "?pageSize=20";
            if (str != null) {
                str2 = str2 + "&accNum=" + str;
            }
            if (!(sAHistoryPagination == null || (lastTxnId = sAHistoryPagination.getLastTxnId()) == null)) {
                str2 = str2 + "&lastTxnId=" + lastTxnId;
            }
            if (!(sAHistoryPagination == null || (transactionDateEpoch = sAHistoryPagination.getTransactionDateEpoch()) == null)) {
                str2 = str2 + "&transactionDateEpoch=" + transactionDateEpoch;
            }
            net.one97.paytm.passbook.mapping.a.a aVar4 = new net.one97.paytm.passbook.mapping.a.a(str2, aVar3, gVar, new SAHistoryResponse((String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (SAHistoryPagination) null, (String) null, (String) null, (String) null, 1023, (kotlin.g.b.g) null), hashMap, a.c.PASSBOOK, a.b.USER_FACING, bVar.getClass().getSimpleName());
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(aVar4);
            return;
        }
        b bVar2 = b.f57359a;
        Context context2 = aVar2.j;
        String str3 = aVar2.m;
        i.a<IJRDataModel> aVar5 = aVar2.f57341d;
        if (aVar5 == null) {
            k.a("txnSuccessListener");
        }
        k.c(context2, "mContext");
        k.c("0", "offset");
        k.c(str3, "accountNo");
        k.c(aVar5, "listener");
        k.c(gVar2, "errorListener");
        Map hashMap2 = new HashMap();
        String a3 = net.one97.paytm.passbook.mapping.b.a(context2);
        k.a((Object) a3, "CJRServerUtility.getSSOToken(mContext)");
        hashMap2.put("Authorization", a3);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("Accept-Encoding", "gzip");
        HashMap hashMap3 = new HashMap();
        Map map = hashMap3;
        map.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str3);
        map.put("offset", "0");
        k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        net.one97.paytm.passbook.mapping.a.a aVar6 = new net.one97.paytm.passbook.mapping.a.a(b.a(com.paytm.utility.b.e(context2, net.one97.paytm.passbook.mapping.e.D()), hashMap3), aVar5, gVar, new SavingAccountPassbookEntriesModal(), hashMap2, a.c.PASSBOOK, a.b.USER_FACING, bVar2.getClass().getSimpleName());
        net.one97.paytm.passbook.mapping.a.c.a();
        net.one97.paytm.passbook.mapping.a.c.b(aVar6);
    }
}
