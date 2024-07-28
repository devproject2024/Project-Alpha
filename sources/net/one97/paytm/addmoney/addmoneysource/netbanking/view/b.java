package net.one97.paytm.addmoney.addmoneysource.netbanking.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.netbanking.a.a;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.status.view.AddMoneyStatusActivity;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.addmoney.utils.f;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class b extends h implements a.c {

    /* renamed from: a  reason: collision with root package name */
    public e f48371a;

    /* renamed from: b  reason: collision with root package name */
    private int f48372b;

    /* renamed from: c  reason: collision with root package name */
    private a.C0844a f48373c;

    /* renamed from: d  reason: collision with root package name */
    private String f48374d;

    /* renamed from: e  reason: collision with root package name */
    private c f48375e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f48376f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f48377g;

    /* renamed from: h  reason: collision with root package name */
    private View f48378h;

    /* renamed from: i  reason: collision with root package name */
    private double f48379i;
    /* access modifiers changed from: private */
    public String j;
    private f k;
    private boolean l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f48372b = getArguments().getInt("destinationAddMoney");
        this.f48374d = getArguments().getString("ppb_account_number");
        this.f48379i = getArguments().getDouble("amount");
        this.l = getArguments().getBoolean("destroy_self", false);
        this.j = getArguments().getString("mid");
        FragmentActivity activity = getActivity();
        getParentFragment();
        this.f48373c = new net.one97.paytm.addmoney.addmoneysource.netbanking.b.a(this, net.one97.paytm.addmoney.addmoneysource.netbanking.c.b.a((net.one97.paytm.addmoney.addmoneysource.netbanking.c.a) net.one97.paytm.addmoney.addmoneysource.netbanking.c.a.a.a((Context) activity), (net.one97.paytm.addmoney.addmoneysource.netbanking.c.a) net.one97.paytm.addmoney.addmoneysource.netbanking.c.b.a.a((Context) getActivity(), getParentFragment())), this.f48372b, this.f48374d, this.f48379i);
        View inflate = layoutInflater.inflate(R.layout.uam_fragment_source_nb, viewGroup, false);
        this.f48377g = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f48376f = (RecyclerView) inflate.findViewById(R.id.rv_bank_list);
        this.f48376f.setNestedScrollingEnabled(false);
        this.f48378h = inflate.findViewById(R.id.otherBankButton);
        this.f48378h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(b.this.getActivity(), NBBanksListActivity.class);
                intent.putExtra("mid", b.this.j);
                b.this.startActivityForResult(intent, 1003);
            }
        });
        this.f48376f.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f48375e = new c(getActivity(), this.f48373c);
        this.f48376f.setAdapter(this.f48375e);
        this.f48373c.a();
        return inflate;
    }

    public final void a(boolean z) {
        try {
            if (this.k == null) {
                this.k = new f(getActivity());
            }
            if (z) {
                this.k.a();
            } else {
                this.k.b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str) {
        if (isAdded()) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), str);
        }
    }

    public void onDestroyView() {
        this.f48373c.b();
        super.onDestroyView();
    }

    public final void a() {
        this.f48375e.notifyDataSetChanged();
    }

    public final void a(HashMap hashMap) {
        CJRRechargePayment cJRRechargePayment = c.a().f48962e;
        Intent f2 = net.one97.paytm.helper.a.b().f((Activity) getActivity());
        cJRRechargePayment.setmPGParams(hashMap);
        cJRRechargePayment.setmPGUrlToHit(net.one97.paytm.helper.a.b().f("processTxnAddMoneyURL") + "?mid=" + c.a().f48959b + "&orderId=" + c.a().f48960c);
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra("uam_add_money", true);
        startActivityForResult(f2, 1004);
    }

    public final void b() {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), (String) null, (Bundle) null);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 1003) {
                this.f48373c.a(g.a().f48979f);
            } else if (i2 == 1004) {
                String stringExtra = intent.getStringExtra("retry_allowed");
                String stringExtra2 = intent.getStringExtra("error_message");
                if (!TextUtils.isEmpty(stringExtra) && "true".equalsIgnoreCase(stringExtra)) {
                    com.paytm.utility.b.b(getContext(), "Error", stringExtra2);
                } else if (this.l) {
                    getActivity().setResult(-1);
                    getActivity().finish();
                } else {
                    intent.getStringExtra("extra_data");
                    Intent intent2 = new Intent(getActivity(), AddMoneyStatusActivity.class);
                    intent2.putExtra("destinationAddMoney", this.f48372b);
                    intent2.putExtra("sourceAddMoney", SourceCardType.NET_BANKING.getNumVal());
                    intent2.putExtra("sourceName", this.f48373c.d());
                    intent2.putExtra("sourceDesc", this.f48373c.e());
                    intent2.putExtra("sourceImage", this.f48373c.f());
                    intent2.putExtra("Amount", this.f48379i);
                    intent2.putExtra("mid", intent.getStringExtra("merchant_id"));
                    intent2.putExtra("orderId", intent.getStringExtra("order_id"));
                    startActivity(intent2);
                    getActivity().finish();
                }
            }
        } else if (this.l) {
            getActivity().setResult(0);
            getActivity().finish();
        }
    }

    public final void c() {
        if (this.f48372b == PaymentDestinationType.TO_WALLET.ordinal()) {
            d.a((Context) getActivity(), "add_money_wallet", "proceed_securely_clicked", "/add-money/wallet", "payment_source_net_banking", (String) null);
        }
    }

    public final double d() {
        this.f48379i = this.f48371a.s().doubleValue();
        return this.f48379i;
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), b.class.getCanonicalName(), (Bundle) null);
        }
    }
}
