package net.one97.paytm.passbook.genericPassbook.d.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRCashWalletResponse;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.customview.c;
import net.one97.paytm.passbook.genericPassbook.d.a.a;
import net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment;
import net.one97.paytm.passbook.main.entity.MultiSubWallet;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.subWallet.model.TransactionHeader;
import net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity;
import net.one97.paytm.passbook.utility.CirclePageIndicator;
import net.one97.paytm.passbook.utility.n;

public final class c extends net.one97.paytm.passbook.genericPassbook.b.a implements a.c {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRTransaction> f57473a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRSubWallet> f57474b;

    /* renamed from: c  reason: collision with root package name */
    boolean f57475c = true;

    /* renamed from: d  reason: collision with root package name */
    net.one97.paytm.passbook.genericPassbook.d.a.a f57476d;

    /* renamed from: e  reason: collision with root package name */
    int f57477e;

    /* renamed from: f  reason: collision with root package name */
    final Context f57478f;

    /* renamed from: g  reason: collision with root package name */
    final AppCompatActivity f57479g;

    /* renamed from: h  reason: collision with root package name */
    final int f57480h;
    private i.a<IJRDataModel> k;
    private i.a<IJRDataModel> l;
    private View m;
    private Fragment n;

    public final void a(Context context, View view) {
        k.c(context, "context");
        k.c(view, "viewId");
    }

    public final void a(TextView textView) {
        k.c(textView, "mBalanceTitleText");
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.d.b.c$c  reason: collision with other inner class name */
    static final class C1081c<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57483a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57484b;

        C1081c(c cVar, x.e eVar) {
            this.f57483a = cVar;
            this.f57484b = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            AppCompatActivity appCompatActivity;
            Fragment c2;
            AppCompatActivity appCompatActivity2;
            String str;
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRCashWallet) {
                List<CJRSubWallet> list = null;
                ((y) this.f57484b.element).setValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
                c cVar = this.f57483a;
                CJRCashWalletResponse response = ((CJRCashWallet) iJRDataModel).getResponse();
                if (response != null) {
                    list = response.getSubWalletDetailList();
                }
                if (list != null) {
                    cVar.f57474b = (ArrayList) list;
                    c cVar2 = this.f57483a;
                    if (!(cVar2.f57480h == n.GIFT_VOUCHER.getValue() || cVar2.f57480h == n.TOLL.getValue() || cVar2.f57474b == null || (appCompatActivity2 = cVar2.f57479g) == null || appCompatActivity2.getSupportFragmentManager().c(R.id.l2Fragment) == null)) {
                        Fragment c3 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                        k.a((Object) c3, "activity.l2Fragment");
                        LinearLayout linearLayout = (LinearLayout) c3.getView().findViewById(R.id.multipleSubWalletLayout);
                        k.a((Object) linearLayout, "activity.l2Fragment.multipleSubWalletLayout");
                        linearLayout.setVisibility(0);
                        MultiSubWallet multiSubWallet = new MultiSubWallet(cVar2.f57480h, false);
                        ArrayList<CJRSubWallet> arrayList = cVar2.f57474b;
                        if (arrayList != null) {
                            Collection collection = arrayList;
                            if (!collection.isEmpty()) {
                                int size = collection.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    CJRSubWallet cJRSubWallet = arrayList.get(i2);
                                    k.a((Object) cJRSubWallet, "it[i]");
                                    if (cJRSubWallet.getSubWalletType() == cVar2.f57480h) {
                                        multiSubWallet.addSubWallet(arrayList.get(i2));
                                    }
                                }
                            }
                        }
                        ArrayList<CJRSubWallet> subWalletList = multiSubWallet.getSubWalletList();
                        k.a((Object) subWalletList, "multiSubWallet.subWalletList");
                        if (cVar2.f57480h == n.LOYALTY_WALLET.getValue() || cVar2.f57480h == n.LOYALTY_WALLET_TYPE_7.getValue() || cVar2.f57480h == n.ALLOWALANCE_WALLET.getValue()) {
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<CJRSubWallet> arrayList3 = new ArrayList<>();
                            int i3 = 0;
                            for (Object next : subWalletList) {
                                int i4 = i3 + 1;
                                if (i3 < 0) {
                                    kotlin.a.k.a();
                                }
                                CJRSubWallet cJRSubWallet2 = (CJRSubWallet) next;
                                if (arrayList2.contains(cJRSubWallet2.getmIssuerId())) {
                                    CJRSubWallet cJRSubWallet3 = (CJRSubWallet) kotlin.a.k.f(arrayList3);
                                    cJRSubWallet3.setBalance(cJRSubWallet3.getBalance() + cJRSubWallet2.getBalance());
                                } else {
                                    arrayList3.add(cJRSubWallet2);
                                    if (!(cJRSubWallet2 == null || (str = cJRSubWallet2.getmIssuerId()) == null)) {
                                        arrayList2.add(str);
                                    }
                                }
                                i3 = i4;
                            }
                            subWalletList = arrayList3;
                        }
                        kotlin.a.k.a(subWalletList, i.f57493a);
                        net.one97.paytm.passbook.subWallet.a.a aVar = new net.one97.paytm.passbook.subWallet.a.a(cVar2.f57478f, subWalletList);
                        Fragment c4 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                        k.a((Object) c4, "activity.l2Fragment");
                        ViewPager viewPager = (ViewPager) c4.getView().findViewById(R.id.multipleSubWalletPager);
                        k.a((Object) viewPager, "activity.l2Fragment.multipleSubWalletPager");
                        viewPager.setAdapter(aVar);
                        Fragment c5 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                        k.a((Object) c5, "activity.l2Fragment");
                        Fragment c6 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                        k.a((Object) c6, "activity.l2Fragment");
                        ((CirclePageIndicator) c5.getView().findViewById(R.id.pageIndicator)).setViewPager((ViewPager) c6.getView().findViewById(R.id.multipleSubWalletPager));
                        int a2 = cVar2.a(subWalletList);
                        Fragment c7 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                        k.a((Object) c7, "activity.l2Fragment");
                        ((ViewPager) c7.getView().findViewById(R.id.multipleSubWalletPager)).setCurrentItem(a2, true);
                        if (subWalletList.size() > 1) {
                            Fragment c8 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                            k.a((Object) c8, "activity.l2Fragment");
                            CirclePageIndicator circlePageIndicator = (CirclePageIndicator) c8.getView().findViewById(R.id.pageIndicator);
                            k.a((Object) circlePageIndicator, "activity.l2Fragment.pageIndicator");
                            circlePageIndicator.setVisibility(0);
                        } else {
                            Fragment c9 = cVar2.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                            k.a((Object) c9, "activity.l2Fragment");
                            CirclePageIndicator circlePageIndicator2 = (CirclePageIndicator) c9.getView().findViewById(R.id.pageIndicator);
                            k.a((Object) circlePageIndicator2, "activity.l2Fragment.pageIndicator");
                            circlePageIndicator2.setVisibility(8);
                        }
                    }
                    if (cVar2.f57480h == n.TOLL.getValue() && (appCompatActivity = cVar2.f57479g) != null && (c2 = appCompatActivity.getSupportFragmentManager().c(R.id.l2Fragment)) != null) {
                        RoboTextView roboTextView = (RoboTextView) c2.getView().findViewById(R.id.walletSubTitle);
                        k.a((Object) roboTextView, "it.walletSubTitle");
                        roboTextView.setVisibility(0);
                        ((RoboTextView) c2.getView().findViewById(R.id.walletSubTitle)).setText(R.string.toll_tag_payments);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<net.one97.paytm.passbook.beans.CJRSubWallet> /* = java.util.ArrayList<net.one97.paytm.passbook.beans.CJRSubWallet> */");
            }
        }
    }

    static final class e<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57487b;

        e(c cVar, x.e eVar) {
            this.f57486a = cVar;
            this.f57487b = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            String str;
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof CJRLedger) {
                c cVar = this.f57486a;
                CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
                ArrayList<CJRTransaction> arrayList = cJRLedger.mTransactionList;
                k.a((Object) arrayList, "ijrDataModel?.mTransactionList");
                if (arrayList.size() == 0) {
                    cVar.f57475c = false;
                }
                if (cVar.f57473a.size() > 0) {
                    str = ((CJRTransaction) kotlin.a.k.f(cVar.f57473a)).getTxnDate();
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
                    if (cVar.f57473a.size() == 0) {
                        cVar.f57473a.add(new TransactionHeader(a2));
                    } else if (!p.a(a2, str, true)) {
                        cVar.f57473a.add(new TransactionHeader(a2));
                    }
                    String txnDate2 = next.getTxnDate();
                    k.a((Object) txnDate2, "transaction.txnDate");
                    next.setFormattedTxnTime(c.b(txnDate2));
                    next.setmTxnDate(a2);
                    cVar.f57473a.add(next);
                    str = a2;
                }
                net.one97.paytm.passbook.genericPassbook.d.a.a aVar = this.f57486a.f57476d;
                if (aVar != null) {
                    aVar.a(this.f57486a.f57473a);
                }
                ((y) this.f57487b.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, iJRDataModel, (Throwable) null));
                ArrayList<CJRTransaction> arrayList2 = cJRLedger.mTransactionList;
                if (arrayList2 != null) {
                    this.f57486a.f57477e += arrayList2.size();
                }
            }
        }
    }

    static final class i<T> implements Comparator<CJRSubWallet> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f57493a = new i();

        i() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRSubWallet) obj, (CJRSubWallet) obj2);
        }

        private static int a(CJRSubWallet cJRSubWallet, CJRSubWallet cJRSubWallet2) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy", Locale.US);
            try {
                k.a((Object) cJRSubWallet2, "o2");
                Date parse = simpleDateFormat.parse(cJRSubWallet2.getExpiry());
                k.a((Object) parse, "spf.parse(o2.expiry)");
                long time = parse.getTime();
                k.a((Object) cJRSubWallet, "o1");
                Date parse2 = simpleDateFormat.parse(cJRSubWallet.getExpiry());
                k.a((Object) parse2, "spf.parse(o1.expiry)");
                return (int) (time - parse2.getTime());
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, AppCompatActivity appCompatActivity, int i2) {
        super(context);
        k.c(context, "context");
        k.c(appCompatActivity, "activity");
        this.f57478f = context;
        this.f57479g = appCompatActivity;
        this.f57480h = i2;
    }

    public final RecyclerView.a<RecyclerView.v> a(net.one97.paytm.passbook.genericPassbook.b.c cVar, RecyclerView recyclerView) {
        k.c(cVar, "listener");
        k.c(recyclerView, "rvEntries");
        net.one97.paytm.passbook.genericPassbook.d.a.a aVar = this.f57476d;
        if (aVar == null) {
            aVar = new net.one97.paytm.passbook.genericPassbook.d.a.a(cVar, this, this.f57480h);
        }
        this.f57476d = aVar;
        net.one97.paytm.passbook.genericPassbook.d.a.a aVar2 = this.f57476d;
        if (aVar2 == null) {
            k.a();
        }
        recyclerView.addItemDecoration(new net.one97.paytm.passbook.search.b.a(aVar2));
        net.one97.paytm.passbook.genericPassbook.d.a.a aVar3 = this.f57476d;
        if (aVar3 == null) {
            k.a();
        }
        return aVar3;
    }

    public final void a() {
        this.f57475c = true;
        this.f57477e = 0;
        ArrayList<CJRTransaction> arrayList = this.f57473a;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final String[] b() {
        if (this.f57480h == n.GIFT_VOUCHER.getValue()) {
            return this.j.getResources().getStringArray(R.array.passbook_tabs_gift_voucher);
        }
        return this.j.getResources().getStringArray(R.array.passbook_tabs);
    }

    public final Fragment c() {
        Fragment fragment;
        if (this.f57480h == n.GIFT_VOUCHER.getValue()) {
            fragment = new a();
        } else {
            fragment = new b(this.f57480h);
        }
        this.n = fragment;
        Fragment fragment2 = this.n;
        if (fragment2 == null) {
            k.a();
        }
        return fragment2;
    }

    public final LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> d() {
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.passbook.mapping.a.g dVar = new d(eVar);
        this.l = new C1081c(this, eVar);
        net.one97.paytm.passbook.genericPassbook.d.a.e eVar2 = net.one97.paytm.passbook.genericPassbook.d.a.e.f57457a;
        Context context = this.j;
        i.a<IJRDataModel> aVar = this.l;
        if (aVar == null) {
            k.a("fetchBalanceResponseHandler");
        }
        eVar2.a(context, aVar, dVar);
        return (y) eVar.element;
    }

    static final class d implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57485a;

        d(x.e eVar) {
            this.f57485a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ((y) this.f57485a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    public final synchronized LiveData<net.one97.paytm.passbook.genericPassbook.b<IJRPaytmDataModel>> a(int i2) {
        x.e eVar;
        eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.passbook.mapping.a.g fVar = new f(eVar);
        this.k = new e(this, eVar);
        if (this.f57475c) {
            net.one97.paytm.passbook.genericPassbook.d.a.e eVar2 = net.one97.paytm.passbook.genericPassbook.d.a.e.f57457a;
            Context context = this.j;
            int i3 = this.f57480h;
            String str = this.f57480h == n.GIFT_VOUCHER.getValue() ? i2 != 0 ? i2 != 1 ? i2 != 2 ? SDKConstants.ALL_TYPE : "ADDED" : "PAID" : SDKConstants.ALL_TYPE : i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? SDKConstants.ALL_TYPE : "ON_HOLD" : "ADDED" : "RECEIVED" : "PAID" : SDKConstants.ALL_TYPE;
            i.a<IJRDataModel> aVar = this.k;
            if (aVar == null) {
                k.a("txnSuccessListener");
            }
            net.one97.paytm.passbook.genericPassbook.d.a.e.a(context, i3, "PAYTM WALLET", str, aVar, fVar, this.f57477e);
        } else {
            ((y) eVar.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.SUCCESS, null, (Throwable) null));
        }
        return (y) eVar.element;
    }

    static final class f implements net.one97.paytm.passbook.mapping.a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f57488a;

        f(x.e eVar) {
            this.f57488a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ((y) this.f57488a.element).postValue(new net.one97.paytm.passbook.genericPassbook.b(net.one97.paytm.passbook.genericPassbook.c.ERROR, iJRPaytmDataModel, networkCustomError));
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
        return this.f57475c;
    }

    public final o<String, ArrayList<String>> f() {
        if (this.f57480h == n.GIFT_VOUCHER.getValue()) {
            String string = this.j.getString(R.string.wallet_filter_tran);
            String[] stringArray = this.j.getResources().getStringArray(R.array.passbook_tabs_gift_voucher);
            k.a((Object) stringArray, "mContext.resources.getSt…ssbook_tabs_gift_voucher)");
            return new o<>(string, kotlin.a.f.a((T[]) stringArray, new ArrayList()));
        }
        String[] stringArray2 = this.j.getResources().getStringArray(R.array.passbook_tabs);
        k.a((Object) stringArray2, "mContext.resources.getSt…ay(R.array.passbook_tabs)");
        return new o<>(this.j.getString(R.string.wallet_filter_tran), (ArrayList) kotlin.a.f.a((T[]) stringArray2, new ArrayList()));
    }

    public final void a(int i2, Runnable runnable) {
        k.c(runnable, "fetchTransactionCallable");
        a();
        runnable.run();
    }

    public final void g() {
        net.one97.paytm.passbook.genericPassbook.d.a.a aVar = this.f57476d;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final String h() {
        int i2 = this.f57480h;
        if (i2 == n.LOYALTY_WALLET_TYPE_7.getValue()) {
            String walletName = n.LOYALTY_WALLET_TYPE_7.getWalletName();
            k.a((Object) walletName, "PassbookType.LOYALTY_WALLET_TYPE_7.walletName");
            return walletName;
        } else if (i2 == n.LOYALTY_WALLET.getValue()) {
            String walletName2 = n.LOYALTY_WALLET.getWalletName();
            k.a((Object) walletName2, "PassbookType.LOYALTY_WALLET.walletName");
            return walletName2;
        } else if (i2 == n.ALLOWALANCE_WALLET.getValue()) {
            String walletName3 = n.ALLOWALANCE_WALLET.getWalletName();
            k.a((Object) walletName3, "PassbookType.ALLOWALANCE_WALLET.walletName");
            return walletName3;
        } else if (i2 == n.FOOD_WALLET.getValue()) {
            String string = this.f57478f.getString(R.string.food_wallet);
            k.a((Object) string, "context.getString(R.string.food_wallet)");
            return string;
        } else if (i2 == n.GIFT_VOUCHER.getValue()) {
            String string2 = this.f57478f.getString(R.string.gift_voucher);
            k.a((Object) string2, "context.getString(R.string.gift_voucher)");
            return string2;
        } else if (i2 != n.TOLL.getValue()) {
            return "";
        } else {
            String string3 = this.f57478f.getString(R.string.fastag);
            k.a((Object) string3, "context.getString(R.string.fastag)");
            return string3;
        }
    }

    public final Drawable i() {
        if (this.f57480h == n.GIFT_VOUCHER.getValue()) {
            return androidx.core.content.b.a(this.f57478f, R.drawable.pass_payments_bank_logo);
        }
        return androidx.core.content.b.a(this.f57478f, R.drawable.pass_ic_paytm_logo);
    }

    public final int j() {
        ArrayList<CJRTransaction> arrayList = this.f57473a;
        return (arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        r1 = r1.getIntent();
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.beans.CJRTransaction r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "transaction"
            kotlin.g.b.k.c(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = r0.f57478f
            java.lang.Class<net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity> r4 = net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity.class
            r2.<init>(r3, r4)
            r3 = r1
            java.io.Serializable r3 = (java.io.Serializable) r3
            java.lang.String r4 = "passbook_detail_data"
            r2.putExtra(r4, r3)
            java.lang.String r1 = r20.getTxnType()
            java.lang.String r3 = "transaction.txnType"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            int r3 = r1.hashCode()
            r4 = -917504720(0xffffffffc94ffd30, float:-851923.0)
            if (r3 == r4) goto L_0x004b
            r4 = 2159(0x86f, float:3.025E-42)
            if (r3 == r4) goto L_0x0040
            r4 = 2190(0x88e, float:3.069E-42)
            if (r3 == r4) goto L_0x0035
            goto L_0x0056
        L_0x0035:
            java.lang.String r3 = "DR"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = "paid"
            goto L_0x0058
        L_0x0040:
            java.lang.String r3 = "CR"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = "received"
            goto L_0x0058
        L_0x004b:
            java.lang.String r3 = "CR_added"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = "added"
            goto L_0x0058
        L_0x0056:
            java.lang.String r1 = "all"
        L_0x0058:
            java.lang.String r3 = "EXTENDED_TXN_INFO"
            r2.putExtra(r3, r1)
            androidx.appcompat.app.AppCompatActivity r1 = r0.f57479g
            r3 = 0
            if (r1 == 0) goto L_0x0075
            android.content.Intent r1 = r1.getIntent()
            if (r1 == 0) goto L_0x0075
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r5 = "passbook_type"
            int r1 = r1.getIntExtra(r5, r4)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0076
        L_0x0075:
            r1 = r3
        L_0x0076:
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r4 = "sub_wallet_type"
            r2.putExtra(r4, r1)
            android.content.Context r1 = r0.f57478f
            if (r1 == 0) goto L_0x0084
            r1.startActivity(r2)
        L_0x0084:
            int r1 = r0.f57480h
            net.one97.paytm.passbook.utility.n r2 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
            int r2 = r2.getValue()
            if (r1 == r2) goto L_0x0098
            int r1 = r0.f57480h
            net.one97.paytm.passbook.utility.n r2 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
            int r2 = r2.getValue()
            if (r1 != r2) goto L_0x00e0
        L_0x0098:
            androidx.appcompat.app.AppCompatActivity r1 = r0.f57479g
            if (r1 == 0) goto L_0x00a9
            android.content.Intent r1 = r1.getIntent()
            if (r1 == 0) goto L_0x00a9
            java.lang.String r2 = "passbookTypeFirstGames"
            java.io.Serializable r1 = r1.getSerializableExtra(r2)
            goto L_0x00aa
        L_0x00a9:
            r1 = r3
        L_0x00aa:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.utility.n
            if (r2 != 0) goto L_0x00af
            r1 = r3
        L_0x00af:
            net.one97.paytm.passbook.utility.n r1 = (net.one97.paytm.passbook.utility.n) r1
            net.one97.paytm.passbook.utility.n r2 = net.one97.paytm.passbook.utility.n.PAYTM_FIRST_GAMES_WALLET
            if (r1 != r2) goto L_0x00cb
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()
            android.content.Context r4 = r0.f57478f
            java.lang.String r5 = "passbook"
            java.lang.String r6 = "recents_clicked"
            java.lang.String r7 = "paytm first games"
            java.lang.String r8 = ""
            java.lang.String r9 = "/passbook/first-games"
            java.lang.String r10 = "passbook"
            r3.a(r4, r5, r6, r7, r8, r9, r10)
            return
        L_0x00cb:
            net.one97.paytm.passbook.mapping.f r11 = net.one97.paytm.passbook.d.b()
            android.content.Context r12 = r0.f57478f
            java.lang.String r13 = "passbook"
            java.lang.String r14 = "recents_clicked"
            java.lang.String r15 = "loyalty wallet"
            java.lang.String r16 = ""
            java.lang.String r17 = "/passbook/loyalty-wallet"
            java.lang.String r18 = "passbook"
            r11.a(r12, r13, r14, r15, r16, r17, r18)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.b.c.a(net.one97.paytm.passbook.beans.CJRTransaction):void");
    }

    public static final class a implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57481a;

        a(c cVar) {
            this.f57481a = cVar;
        }

        public final void a() {
            this.f57481a.g();
            c.a(this.f57481a);
        }
    }

    public final void b(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String string = this.f57478f.getString(R.string.tag_this_payment);
        k.a((Object) string, "context.getString(R.string.tag_this_payment)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new a(this));
        aVar.show(this.f57479g.getSupportFragmentManager(), net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
    }

    public static final class b implements net.one97.paytm.passbook.transactionDetail.b.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57482a;

        b(c cVar) {
            this.f57482a = cVar;
        }

        public final void a() {
            this.f57482a.g();
            c.a(this.f57482a);
        }
    }

    public final void c(CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        String string = this.f57478f.getString(R.string.edit_tag);
        k.a((Object) string, "context.getString(R.string.edit_tag)");
        net.one97.paytm.passbook.transactionDetail.b.a aVar = new net.one97.paytm.passbook.transactionDetail.b.a(string, cJRTransaction);
        aVar.a((net.one97.paytm.passbook.transactionDetail.b.b) new b(this));
        aVar.show(this.f57479g.getSupportFragmentManager(), net.one97.paytm.passbook.transactionDetail.b.a.class.getSimpleName());
    }

    public final void a(int i2, CJRTransaction cJRTransaction) {
        k.c(cJRTransaction, "transaction");
        Intent intent = new Intent(this.f57478f, RecentTransactionsActivity.class);
        intent.putExtra("data", cJRTransaction);
        intent.putExtra(H5StartParamManager.index, i2);
        this.f57478f.startActivity(intent);
    }

    public static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57491b;

        h(c cVar, x.e eVar) {
            this.f57490a = cVar;
            this.f57491b = eVar;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f57491b.element;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                Fragment c2 = this.f57490a.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                if (c2 == null) {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
                } else if (((PassbookL2Fragment) c2).isAdded()) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f57490a.f57478f, R.anim.pass_save_tag_banner_up);
                    LinearLayout linearLayout2 = (LinearLayout) this.f57491b.element;
                    if (linearLayout2 != null) {
                        linearLayout2.startAnimation(loadAnimation);
                    }
                    loadAnimation.setAnimationListener(new a(this));
                }
            }
        }

        public static final class a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f57492a;

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            a(h hVar) {
                this.f57492a = hVar;
            }

            public final void onAnimationEnd(Animation animation) {
                LinearLayout linearLayout = (LinearLayout) this.f57492a.f57491b.element;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
        }
    }

    public final void a(View view) {
        k.c(view, "view");
        this.m = view;
        View view2 = this.m;
        if (view2 == null) {
            k.a("fragmentView");
        }
        ((TextView) view2.findViewById(R.id.okTv)).setOnClickListener(new g(view));
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f57489a;

        g(View view) {
            this.f57489a = view;
        }

        public final void onClick(View view) {
            View findViewById = this.f57489a.findViewById(R.id.tagSavedLl);
            k.a((Object) findViewById, "view.findViewById<LinearLayout>(R.id.tagSavedLl)");
            ((LinearLayout) findViewById).setVisibility(8);
        }
    }

    public final void a(Menu menu, MenuInflater menuInflater) {
        MenuItem findItem;
        MenuItem findItem2;
        super.a(menu, menuInflater);
        if (this.f57480h != n.GIFT_VOUCHER.getValue()) {
            if (menuInflater != null) {
                menuInflater.inflate(R.menu.pass_passbookmenu, menu);
            }
            if (!(menu == null || (findItem2 = menu.findItem(R.id.action_passbook_search)) == null)) {
                findItem2.setVisible(false);
            }
            if (menu != null && (findItem = menu.findItem(R.id.action_how_it_works_bs_info)) != null) {
                findItem.setVisible(true);
            }
        }
    }

    public final void a(MenuItem menuItem) {
        super.a(menuItem);
        if (menuItem != null && menuItem.getItemId() == R.id.action_how_it_works_bs_info) {
            ArrayList<CJRSubWallet> arrayList = this.f57474b;
            if (arrayList != null) {
                c.a aVar = net.one97.paytm.passbook.customview.c.f57211a;
                CJRSubWallet cJRSubWallet = arrayList.get(a(arrayList));
                k.a((Object) cJRSubWallet, "it.get(getDefaultSelection(it))");
                j supportFragmentManager = this.f57479g.getSupportFragmentManager();
                k.a((Object) supportFragmentManager, "activity.supportFragmentManager");
                c.a.a(cJRSubWallet, supportFragmentManager);
                return;
            }
            Toast.makeText(this.f57478f, "Please Wait", 0).show();
        }
    }

    public final void a(int i2, int i3, Intent intent) {
        super.a(i2, i3, intent);
        if (i2 == 128 || i2 == 127) {
            Fragment c2 = this.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
            if (c2 != null) {
                ((PassbookL2Fragment) c2).b();
                a();
                Fragment c3 = this.f57479g.getSupportFragmentManager().c(R.id.l2Fragment);
                if (c3 != null) {
                    ((PassbookL2Fragment) c3).a();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(ArrayList<CJRSubWallet> arrayList) {
        int intExtra = this.f57479g.getIntent().getIntExtra("clicked_wallet_id", -1);
        String stringExtra = this.f57479g.getIntent().getStringExtra("clickedWalletIssuerId");
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (!TextUtils.isEmpty(stringExtra) && k.a((Object) stringExtra, (Object) arrayList.get(i2).getmIssuerId())) {
                    return i2;
                }
                CJRSubWallet cJRSubWallet = arrayList.get(i2);
                k.a((Object) cJRSubWallet, "cjrSubWallets.get(i)");
                if (cJRSubWallet.getId() == intExtra) {
                    return i2;
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l() {
        /*
            r4 = this;
            androidx.appcompat.app.AppCompatActivity r0 = r4.f57479g
            r1 = 0
            if (r0 == 0) goto L_0x0012
            android.content.Intent r0 = r0.getIntent()
            if (r0 == 0) goto L_0x0012
            java.lang.String r2 = "passbookTypeFirstGames"
            java.io.Serializable r0 = r0.getSerializableExtra(r2)
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            boolean r2 = r0 instanceof net.one97.paytm.passbook.utility.n
            if (r2 != 0) goto L_0x0018
            r0 = r1
        L_0x0018:
            net.one97.paytm.passbook.utility.n r0 = (net.one97.paytm.passbook.utility.n) r0
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.PAYTM_FIRST_GAMES_WALLET
            java.lang.String r2 = "PASSBOOK"
            if (r0 != r1) goto L_0x002c
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            android.content.Context r1 = r4.f57478f
            java.lang.String r3 = "/uth_passbook_myaccounts/first_games"
            r0.b(r3, r2, r1)
            return
        L_0x002c:
            int r0 = r4.f57480h
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
            int r1 = r1.getValue()
            if (r0 == r1) goto L_0x0040
            int r0 = r4.f57480h
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x004b
        L_0x0040:
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            android.content.Context r1 = r4.f57478f
            java.lang.String r3 = "/uth_passbook_myaccounts/loyalty_wallet"
            r0.b(r3, r2, r1)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.b.c.l():void");
    }

    public final void a(Throwable th) {
        Context context = this.f57478f;
        if (!(context instanceof Activity)) {
            context = null;
        }
        getClass().getSimpleName();
        net.one97.paytm.passbook.utility.j.a((Activity) context, th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0046, code lost:
        r1 = r1.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.FrameLayout r9) {
        /*
            r8 = this;
            java.lang.String r0 = "pbBannerContainer"
            kotlin.g.b.k.c(r9, r0)
            int r0 = r8.f57480h
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.FOOD_WALLET
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x0060
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.utility.k r1 = net.one97.paytm.passbook.utility.k.f59256a
            java.lang.String r1 = net.one97.paytm.passbook.utility.k.g()
            r2 = 1
            boolean r0 = r0.a((java.lang.String) r1, (boolean) r2)
            if (r0 == 0) goto L_0x0060
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.utility.k r1 = net.one97.paytm.passbook.utility.k.f59256a
            java.lang.String r1 = net.one97.paytm.passbook.utility.k.h()
            java.lang.String r4 = r0.a((java.lang.String) r1)
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()
            androidx.appcompat.app.AppCompatActivity r0 = r8.f57479g
            r3 = r0
            android.app.Activity r3 = (android.app.Activity) r3
            com.paytm.network.a$c r5 = com.paytm.network.a.c.PASSBOOK
            r6 = r9
            android.view.View r6 = (android.view.View) r6
            java.lang.String r7 = "Food Wallet Passbook"
            androidx.fragment.app.Fragment r0 = r2.a((android.app.Activity) r3, (java.lang.String) r4, (com.paytm.network.a.c) r5, (android.view.View) r6, (java.lang.String) r7)
            androidx.appcompat.app.AppCompatActivity r1 = r8.f57479g
            if (r1 == 0) goto L_0x0051
            androidx.fragment.app.j r1 = r1.getSupportFragmentManager()
            if (r1 == 0) goto L_0x0051
            androidx.fragment.app.q r1 = r1.a()
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            if (r1 == 0) goto L_0x005b
            int r9 = r9.getId()
            r1.b(r9, r0)
        L_0x005b:
            if (r1 == 0) goto L_0x0060
            r1.c()
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.b.c.a(android.widget.FrameLayout):void");
    }

    public static final /* synthetic */ void a(c cVar) {
        x.e eVar = new x.e();
        View view = cVar.m;
        if (view == null) {
            k.a("fragmentView");
        }
        eVar.element = view != null ? (LinearLayout) view.findViewById(R.id.tagSavedLl) : null;
        Animation loadAnimation = AnimationUtils.loadAnimation(cVar.f57478f, R.anim.pass_text_scroll_top_to_bottom);
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
