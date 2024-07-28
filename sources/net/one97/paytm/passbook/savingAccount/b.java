package net.one97.paytm.passbook.savingAccount;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.SavingAccountPassbookEntriesModal;
import net.one97.paytm.passbook.beans.TransactionModel;
import net.one97.paytm.passbook.customview.NonSwipeableViewPager;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.e;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.utility.j;
import net.one97.paytm.passbook.utility.l;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends h implements g, i.a<IJRDataModel>, l {
    private static b r;
    private CustProductList A;
    private SavingAccountPassbookEntriesModal.PaginationDetails B;
    private BroadcastReceiver C = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("net.one97.paytm.CONNECTION_CHANGED")) {
                b bVar = b.this;
                bVar.a(bVar.q.isInternetAvailable());
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    String[] f58263a = {AppConstants.FOR_ALL, "Withdrawals", "Deposits"};
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f58264b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f58265c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f58266d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f58267e;

    /* renamed from: f  reason: collision with root package name */
    private NonSwipeableViewPager f58268f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f58269g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f58270h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public NestedScrollView f58271i;
    private String j;
    /* access modifiers changed from: private */
    public View k;
    private ArrayList<String> l;
    private ArrayList<String> m;
    private int n = 0;
    private LinearLayout o;
    private LinearLayout p;
    /* access modifiers changed from: private */
    public TransactionModel q;
    private LottieAnimationView s;
    private boolean t;
    private int u;
    private ArrayList<net.one97.paytm.passbook.utility.h> v = new ArrayList<>();
    private LinkedHashMap<String, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>> w;
    private LinkedHashMap x;
    private ExecutorService y;
    private boolean z = true;

    public final String a(String str, String str2, String str3) {
        return null;
    }

    public final void a(String str, JSONObject jSONObject) {
    }

    public final void b(String str) {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final boolean g() {
        return false;
    }

    public final boolean i() {
        return false;
    }

    public void onEvent(String[] strArr) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        k();
        if (iJRDataModel instanceof SavingAccountPassbookEntriesModal) {
            SavingAccountPassbookEntriesModal savingAccountPassbookEntriesModal = (SavingAccountPassbookEntriesModal) iJRDataModel;
            if (TextUtils.isEmpty(savingAccountPassbookEntriesModal.getStatus()) || !savingAccountPassbookEntriesModal.getStatus().equalsIgnoreCase("SUCCESS")) {
                String string = this.q.getApplicationContext().getString(R.string.error);
                String status = savingAccountPassbookEntriesModal.getStatus();
                if (!this.f58264b.isFinishing()) {
                    c.a((Context) getActivity(), string, status);
                    return;
                }
                return;
            }
            if (!(savingAccountPassbookEntriesModal.getResponse() == null || savingAccountPassbookEntriesModal.getResponse().getTransactionDetails() == null)) {
                final boolean booleanValue = savingAccountPassbookEntriesModal.getResponse().getHasMoreData().booleanValue();
                final ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> transactionDetails = savingAccountPassbookEntriesModal.getResponse().getTransactionDetails();
                if (transactionDetails != null) {
                    this.u += 100;
                    new StringBuilder("onResponse() :: SavingAccountFragment").append(transactionDetails.toString());
                    com.paytm.utility.b.j();
                    Thread thread = new Thread(new Runnable() {
                        public final void run() {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = transactionDetails.iterator();
                            while (it2.hasNext()) {
                                SavingAccountPassbookEntriesModal.TransactionDetail transactionDetail = (SavingAccountPassbookEntriesModal.TransactionDetail) it2.next();
                                String txnType = transactionDetail.getTxnType();
                                if (txnType.equalsIgnoreCase(AppConstants.FEED_COMMUNITY)) {
                                    arrayList2.add(transactionDetail);
                                } else if (txnType.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
                                    arrayList.add(transactionDetail);
                                }
                            }
                            if (!booleanValue) {
                                b.this.h();
                            }
                            b.this.a(a.DEBIT.getSavingAccountPassbookConstantName(), (ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>) arrayList);
                            b.this.a(a.CREDIT.getSavingAccountPassbookConstantName(), (ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>) arrayList2);
                            b.this.a(StringSet.all, (ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>) transactionDetails);
                            b.e(b.this);
                        }
                    });
                    if (this.y == null) {
                        this.y = Executors.newFixedThreadPool(1);
                    }
                    this.y.submit(thread);
                }
            }
            this.B = savingAccountPassbookEntriesModal.getResponse().getPaginationDetails();
            if (this.B == null) {
                this.z = false;
            }
        } else if (iJRDataModel instanceof CustProductList) {
            this.A = (CustProductList) iJRDataModel;
            if (!TextUtils.isEmpty(this.A.getErrorMessage())) {
                com.paytm.utility.b.b(this.q.getApplicationContext(), this.q.getApplicationContext().getString(R.string.error), this.A.getErrorMessage());
            } else if ("ISSUED".equals(this.A.getIsaStatus())) {
                this.j = this.A.getIsaAccNum();
                if (!TextUtils.isEmpty(this.j)) {
                    this.q.setAccountNo(this.j);
                    this.z = true;
                    h();
                    l();
                }
            }
        }
    }

    public static b a() {
        return r;
    }

    public void onDestroy() {
        super.onDestroy();
        r = null;
        System.gc();
    }

    private void j() {
        if (!this.f58264b.isFinishing() && !this.f58264b.isFinishing()) {
            this.p.setVisibility(0);
            net.one97.paytm.passbook.utility.a.a(this.s);
        }
    }

    private void k() {
        if (!this.f58264b.isFinishing() && !this.f58264b.isFinishing()) {
            this.p.setVisibility(8);
            net.one97.paytm.passbook.utility.a.b(this.s);
        }
    }

    public enum a {
        DEBIT(UpiConstants.DEFAULT_ACCOUNT_CONSTANT),
        CREDIT(AppConstants.FEED_COMMUNITY);
        
        private final String mName;

        private a(String str) {
            this.mName = str;
        }

        public final String getSavingAccountPassbookConstantName() {
            return this.mName;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        d.a.a.c.a().a((Object) this, false);
    }

    public void onDetach() {
        super.onDetach();
        d.a.a.c.a().b(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r = this;
        this.f58264b = getActivity();
        try {
            this.j = getArguments().getString("ACCOUNT_NUMBER", (String) null);
        } catch (Exception unused) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q = new TransactionModel(getContext());
        this.q.setAccountNo(this.j);
        this.t = getArguments().getBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST);
        View inflate = layoutInflater.inflate(R.layout.pass_fragment_saving_bank, (ViewGroup) null);
        this.f58271i = (NestedScrollView) inflate.findViewById(R.id.nsv_wallet);
        this.f58271i.setFillViewport(true);
        this.k = inflate.findViewById(R.id.sa_nodata_error_layout);
        this.f58269g = (TextView) inflate.findViewById(R.id.passbook_entry_row_heading_month_tv);
        inflate.findViewById(R.id.passbook_entry_row_heading_next_iv).setVisibility(4);
        this.f58267e = (RelativeLayout) inflate.findViewById(R.id.i_error_layout);
        this.f58270h = (LinearLayout) inflate.findViewById(R.id.ll_no_internet);
        this.p = (LinearLayout) inflate.findViewById(R.id.loader_ll);
        this.s = (LottieAnimationView) inflate.findViewById(R.id.wallet_loader);
        this.f58266d = (RelativeLayout) inflate.findViewById(R.id.passbook_wallet_duration_heading);
        this.f58268f = (NonSwipeableViewPager) inflate.findViewById(R.id.vp_wallet_transaction);
        this.f58265c = (TabLayout) inflate.findViewById(R.id.tl_transaction_tabs);
        this.f58265c.setTabMode(1);
        this.o = (LinearLayout) inflate.findViewById(R.id.subwallet_summury_container);
        this.o.setVisibility(8);
        this.f58268f.setVisibility(0);
        String[] stringArray = getResources().getStringArray(R.array.passbook_saving_account_tabs);
        net.one97.paytm.passbook.mapping.g.a();
        this.l = net.one97.paytm.passbook.mapping.g.a(stringArray);
        this.m = new ArrayList<>(Arrays.asList(this.f58263a));
        a(this.n);
        this.f58265c.setupWithViewPager(this.f58268f);
        if (!TextUtils.isEmpty(this.j)) {
            d();
        } else {
            o();
        }
        return inflate;
    }

    private void l() {
        d();
    }

    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.C, new IntentFilter("net.one97.paytm.CONNECTION_CHANGED"));
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        if (getActivity() != null) {
            androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.C);
        }
        super.onStop();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (!TextUtils.isEmpty(this.j)) {
            m();
        } else {
            o();
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            this.f58271i.setVisibility(0);
        } else {
            this.f58271i.setVisibility(8);
        }
    }

    public final void a(final e eVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f58264b);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) b.this.f58264b)) {
                    b.this.f58264b.getApplicationContext();
                    net.one97.paytm.passbook.mapping.a.c.a();
                    net.one97.paytm.passbook.mapping.a.c.b(eVar);
                    return;
                }
                b.this.a(eVar);
            }
        });
        builder.show();
    }

    public final void a(String str) {
        try {
            if (this.f58269g == null || TextUtils.isEmpty(str)) {
                this.f58266d.setVisibility(8);
                return;
            }
            this.f58269g.setText(str);
            this.f58266d.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    public final void a(int i2) {
        NonSwipeableViewPager nonSwipeableViewPager = this.f58268f;
        if (nonSwipeableViewPager != null) {
            this.n = i2;
            nonSwipeableViewPager.setAdapter(new a(getChildFragmentManager(), this.m, this, this.n, this.t));
            this.f58268f.setCurrentItem(i2);
        }
    }

    public final void b() {
        if (!TextUtils.isEmpty(this.j)) {
            m();
        } else {
            o();
        }
    }

    public final String c() {
        return this.j;
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k();
        FragmentActivity activity = getActivity();
        b.class.getSimpleName();
        j.a((Activity) activity, (Throwable) networkCustomError);
    }

    public final void d() {
        boolean isInternetAvailable = this.q.isInternetAvailable();
        a(isInternetAvailable);
        if (isInternetAvailable) {
            n();
        }
    }

    private void m() {
        boolean isInternetAvailable = this.q.isInternetAvailable();
        a(isInternetAvailable);
        if (isInternetAvailable) {
            this.z = true;
            n();
        }
    }

    private void n() {
        if (this.z) {
            new HashMap().put("screen_name", getClass().getSimpleName());
            net.one97.paytm.passbook.mapping.a.a a2 = a(this.q.getApplicationContext(), this.q.getAccountNo(), "20", this.B, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
            if (this.q.isInternetAvailable()) {
                j();
                this.q.getApplicationContext();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(a2);
                return;
            }
            a((e) a2);
            return;
        }
        this.q.getNodataText();
    }

    public final ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> c(String str) {
        LinkedHashMap<String, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>> linkedHashMap = this.w;
        if (linkedHashMap != null) {
            return linkedHashMap.get(str);
        }
        TransactionModel transactionModel = this.q;
        if (transactionModel == null || transactionModel.isInternetAvailable()) {
            return null;
        }
        if (this.x == null) {
            this.x = (LinkedHashMap) new f().a(m.a(this.q.getApplicationContext()).b("bank_passbook_offline", "", true), new com.google.gson.b.a<LinkedHashMap<String, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>>>() {
            }.getType());
        }
        LinkedHashMap linkedHashMap2 = this.x;
        if (linkedHashMap2 != null) {
            return (ArrayList) linkedHashMap2.get(str);
        }
        return null;
    }

    public final void h() {
        LinkedHashMap<String, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>> linkedHashMap = this.w;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
            a((LinkedHashMap) this.w);
        }
    }

    private void a(LinkedHashMap linkedHashMap) {
        m.a(this.q.getApplicationContext()).a("bank_passbook_offline", new f().a((Object) linkedHashMap, new com.google.gson.b.a<LinkedHashMap<String, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail>>>() {
        }.getType()), true);
    }

    public final void a(String str, ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> arrayList) {
        if (this.w == null) {
            this.w = new LinkedHashMap<>();
        }
        ArrayList arrayList2 = this.w.get(str);
        if (arrayList2 != null) {
            arrayList.addAll(0, arrayList2);
        }
        this.w.put(str, arrayList);
        a((LinkedHashMap) this.w);
    }

    public final void a(net.one97.paytm.passbook.utility.h hVar) {
        this.v.add(hVar);
    }

    public final void b(net.one97.paytm.passbook.utility.h hVar) {
        this.v.remove(hVar);
    }

    private void o() {
        if (this.q.isInternetAvailable()) {
            net.one97.paytm.passbook.mapping.a.a a2 = a(this.q.getApplicationContext(), this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
            this.q.getApplicationContext();
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(a2);
        }
    }

    private static net.one97.paytm.passbook.mapping.a.a a(Context context, i.a<IJRDataModel> aVar, g gVar, a.c cVar, a.b bVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Token", com.paytm.utility.a.q(context));
        hashMap.put("Content-Type", "application/json");
        hashMap.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.passbook.mapping.e.a();
        return new net.one97.paytm.passbook.mapping.a.a(com.paytm.utility.b.e(context, net.one97.paytm.passbook.mapping.e.l()), aVar, gVar, new CustProductList(), hashMap, cVar, bVar, str);
    }

    private static net.one97.paytm.passbook.mapping.a.a a(Context context, String str, String str2, SavingAccountPassbookEntriesModal.PaginationDetails paginationDetails, i.a<IJRDataModel> aVar, g gVar, a.c cVar, a.b bVar, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", com.paytm.utility.a.q(context));
        hashMap.put("Content-Type", "application/json");
        HashMap hashMap2 = new HashMap();
        String str4 = str;
        hashMap2.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str);
        String str5 = str2;
        hashMap2.put("offset", str2);
        if (paginationDetails != null) {
            try {
                JSONObject jSONObject = new JSONObject(paginationDetails.toString());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap2.put(next, jSONObject.get(next).toString());
                }
            } catch (JSONException unused) {
            }
        }
        Context context2 = context;
        return new net.one97.paytm.passbook.mapping.a.a(a(com.paytm.utility.b.e(context, d.b().a("ppb_passbook_history")), (HashMap<String, String>) hashMap2), aVar, gVar, new SavingAccountPassbookEntriesModal(), hashMap, cVar, bVar, str3);
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (sb.length() > 1) {
                sb.append(AppConstants.AND_SIGN);
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
            } else {
                sb.append("?");
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
            }
        }
        return str + sb.toString();
    }

    static /* synthetic */ void e(b bVar) {
        ArrayList<SavingAccountPassbookEntriesModal.TransactionDetail> c2 = bVar.c(StringSet.all);
        if (c2 == null || c2.size() <= 0) {
            bVar.getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.f58271i.setVisibility(8);
                    b.this.k.setVisibility(0);
                }
            });
        } else {
            bVar.getActivity().runOnUiThread(new Runnable() {
                public final void run() {
                    b.this.f58271i.setVisibility(0);
                    b.this.k.setVisibility(8);
                }
            });
        }
        ArrayList<net.one97.paytm.passbook.utility.h> arrayList = bVar.v;
        if (arrayList != null) {
            Iterator<net.one97.paytm.passbook.utility.h> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
        }
    }
}
