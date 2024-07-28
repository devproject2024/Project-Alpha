package net.one97.paytm.passbook.transactionDetail.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.v;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.transactionDetail.a.c;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends h implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f59125a;

    /* renamed from: b  reason: collision with root package name */
    private c f59126b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f59127c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f59128d;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f59129e;

    /* renamed from: f  reason: collision with root package name */
    private int f59130f = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f59131g;

    /* renamed from: h  reason: collision with root package name */
    private String f59132h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f59133i = false;
    private boolean j = false;
    private LinearLayout k;

    public interface a {
        void onTransactionSelection(CJRTransaction cJRTransaction);
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        d();
        this.k.setVisibility(8);
        if (iJRDataModel instanceof CJRLedger) {
            CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
            if ("SUCCESS".equalsIgnoreCase(cJRLedger.getStatusCode())) {
                ArrayList<CJRTransaction> transactionList = cJRLedger.getTransactionList();
                if (transactionList.size() > 0) {
                    this.f59130f += transactionList.size();
                    this.f59126b.f59019a.addAll(transactionList);
                    this.f59126b.notifyDataSetChanged();
                } else {
                    this.j = true;
                }
                this.f59133i = false;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pass_fragment_transaction_recent_history, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        this.f59125a = (RecyclerView) view.findViewById(R.id.recent_history_rv);
        this.f59125a.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f59126b = new c(new a() {
            public final void onTransactionSelection(CJRTransaction cJRTransaction) {
                e.this.a(cJRTransaction);
            }
        });
        this.f59127c = (TextView) view.findViewById(R.id.header_tv);
        this.f59128d = (RelativeLayout) view.findViewById(R.id.loader_rl);
        this.f59129e = (LottieAnimationView) view.findViewById(R.id.loader);
        this.k = (LinearLayout) view.findViewById(R.id.retry_ll);
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.a(view);
            }
        });
        this.f59125a.setFocusable(false);
        this.f59125a.setAdapter(this.f59126b);
        if (getArguments() != null) {
            CJRTransaction cJRTransaction = (CJRTransaction) getArguments().getSerializable("data");
            if (cJRTransaction.getType().equals("1") || cJRTransaction.getType().equals("5") || cJRTransaction.getType().equals("69")) {
                getView().setVisibility(0);
                this.f59132h = cJRTransaction.getPayeeId();
                this.f59131g = cJRTransaction.getPayerId();
                if (cJRTransaction.getType().equals("1")) {
                    str = cJRTransaction.getTxnTo();
                } else if (cJRTransaction.getType().equals("5")) {
                    if ("DR".equalsIgnoreCase(cJRTransaction.getTxnType())) {
                        str = cJRTransaction.getTxnDesc1();
                        if (str.startsWith("To:")) {
                            str = str.replace("To:", "").trim();
                        }
                    } else {
                        str = cJRTransaction.getTxnDesc1();
                        if (str.startsWith("From:")) {
                            str = str.replace("From:", "").trim();
                        }
                    }
                } else if (cJRTransaction.getType().equals("69")) {
                    str = cJRTransaction.getTxnDesc1();
                    if (str.startsWith("To:")) {
                        str = str.replace("To: ", "");
                    }
                } else {
                    str = null;
                }
                if (!v.a(str)) {
                    if ("69".equalsIgnoreCase(cJRTransaction.getType()) && "CR".equalsIgnoreCase(cJRTransaction.getTxnType())) {
                        str = str.replace("From: ", "");
                    }
                    this.f59127c.setText(String.format(getString(R.string.passbook_recent_transaction_with), new Object[]{str}));
                }
                a();
                return;
            }
            getView().setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTransaction cJRTransaction) {
        String str;
        String str2;
        String str3;
        if (getActivity() != null && isAdded() && (getActivity() instanceof PassbookTransactionDetailsActivity)) {
            PassbookTransactionDetailsActivity passbookTransactionDetailsActivity = (PassbookTransactionDetailsActivity) getActivity();
            if (passbookTransactionDetailsActivity.f58986b != -1) {
                if (passbookTransactionDetailsActivity.f58986b == n.TOLL.getValue()) {
                    str3 = "passbook_fastag_wallet";
                    str2 = "fastag_wallet_recent_txn_clicked";
                    str = "/passbook/fastag-wallet/txn-detail";
                } else if (passbookTransactionDetailsActivity.f58986b == n.FOOD_WALLET.getValue()) {
                    str3 = "passbook_food_wallet";
                    str2 = "food_wallet_recent_txn_clicked";
                    str = "/passbook/food-wallet/txn-detail";
                } else {
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                q.a(passbookTransactionDetailsActivity, str3, str2, (ArrayList<String>) null, str);
            }
            Intent intent = new Intent(passbookTransactionDetailsActivity, PassbookTransactionDetailsActivity.class);
            intent.putExtra("passbook_detail_data", cJRTransaction);
            intent.putExtra("EXTENDED_TXN_INFO", passbookTransactionDetailsActivity.f58985a);
            intent.putExtra("sub_wallet_type", passbookTransactionDetailsActivity.f58986b);
            passbookTransactionDetailsActivity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private void a() {
        if (!v.a(this.f59132h) || !v.a(this.f59131g)) {
            b();
        } else {
            getView().setVisibility(8);
        }
    }

    private void b() {
        if (!this.f59133i && !this.j) {
            net.one97.paytm.passbook.mapping.e.a();
            String s = b.s(getContext(), net.one97.paytm.passbook.mapping.e.g());
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", com.paytm.utility.a.q(getContext()));
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("startLimit", this.f59130f);
                jSONObject2.put("lastLimit", this.f59130f + 100);
                if (!v.a(this.f59132h)) {
                    jSONObject2.put("payeeId", this.f59132h);
                } else if (!v.a(this.f59131g)) {
                    jSONObject2.put("payerId", this.f59131g);
                }
                jSONObject.put("request", jSONObject2);
            } catch (JSONException unused) {
            }
            net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(s, this, this, new CJRLedger(), hashMap, jSONObject.toString(), a.c.PASSBOOK, a.b.SILENT, getClass().getName());
            if (b.c(getContext())) {
                this.k.setVisibility(8);
                c();
                getContext();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(bVar);
                this.f59133i = true;
                return;
            }
            net.one97.paytm.passbook.mapping.a.a(bVar, getContext(), new DialogInterface.OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    e.this.a(dialogInterface);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        d();
        this.f59133i = false;
        this.k.setVisibility(0);
    }

    private void c() {
        this.f59128d.setVisibility(0);
        net.one97.paytm.common.widgets.a.a(this.f59129e);
    }

    private void d() {
        this.f59128d.setVisibility(8);
        net.one97.paytm.common.widgets.a.b(this.f59129e);
    }

    public void onDetach() {
        super.onDetach();
        d();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        d();
        this.f59133i = false;
        this.k.setVisibility(0);
    }
}
