package net.one97.paytm.bankOpen.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.CJRCashWallet;
import net.one97.paytm.bankCommon.model.CJRP2BStatus;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.a.a;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class b extends net.one97.paytm.bankCommon.d.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private TextView f16363b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16364c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f16365d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f16366e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f16367f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f16368g;

    /* renamed from: h  reason: collision with root package name */
    private CJRP2BStatus f16369h;

    /* renamed from: i  reason: collision with root package name */
    private CustProductList f16370i;
    private int j = 0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.bank_account_opened, (ViewGroup) null);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        RoboTextView roboTextView = (RoboTextView) getView().findViewById(R.id.bank_account_opened_tv_full_saviings_access);
        this.f16364c = (TextView) getView().findViewById(R.id.transfer_wallet_title);
        this.f16363b = (TextView) getView().findViewById(R.id.available_bal_tv);
        View findViewById = getView().findViewById(R.id.transfer_money_to_bank_btn);
        View findViewById2 = getView().findViewById(R.id.skip_btn);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        this.f16365d = (ViewGroup) getView().findViewById(R.id.normalLayout);
        this.f16366e = (ViewGroup) getView().findViewById(R.id.p2bLayout);
        this.f16367f = (ViewGroup) getView().findViewById(R.id.progressLayout);
        this.f16368g = (LottieAnimationView) getView().findViewById(R.id.wallet_loader);
        if (getArguments() == null || !getArguments().containsKey("bottom_text")) {
            getView().findViewById(R.id.bank_account_opened_lyt_bottom_bar).setVisibility(8);
            getView().findViewById(R.id.divider).setVisibility(8);
        } else {
            roboTextView.setVisibility(0);
            roboTextView.setText(getArguments().getString("bottom_text"));
        }
        f.b().getNameFromKyc(getContext(), new d() {
            public final void onFragmentAction(int i2, Object obj) {
                b.this.a(i2, obj);
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", com.paytm.utility.b.n((Context) getActivity()));
        c.a("bank_savings_account_kyc_success_screen_load", (Map<String, Object>) hashMap, getContext());
        c.a("/bank/saving-account/kyc-success", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, getContext());
        getView().findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        getView().findViewById(R.id.bank_account_opened_btn_done).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        ((TextView) getView().findViewById(R.id.bank_account_opened_tv_name)).setText((String) obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d();
    }

    /* access modifiers changed from: protected */
    public void d() {
        c.a("bank_saving_account_done_clicked", (Map<String, Object>) new HashMap(), getContext());
        if (getActivity() != null && (getActivity() instanceof e)) {
            ((e) getActivity()).a(11);
        }
    }

    private void e() {
        if (getActivity() != null && (getActivity() instanceof net.one97.paytm.bankCommon.f.c)) {
            ((net.one97.paytm.bankCommon.f.c) getActivity()).a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void h() {
        if (getContext() != null) {
            if (com.paytm.utility.b.c(getContext())) {
                this.f16367f.setVisibility(0);
                a(this.f16368g);
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                net.one97.paytm.bankCommon.g.f b2 = a.b(getContext(), this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
                getContext().getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(b2);
                return;
            }
            g();
            com.paytm.utility.b.b(getContext(), getString(R.string.error), getString(R.string.pb_check_your_network));
        }
    }

    private void g() {
        this.f16367f.setVisibility(8);
        b(this.f16368g);
        this.f16365d.setVisibility(0);
        this.f16366e.setVisibility(8);
    }

    /* renamed from: a */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof CustProductList) {
            this.f16370i = (CustProductList) iJRPaytmDataModel;
            CustProductList custProductList = this.f16370i;
            if (custProductList == null || TextUtils.isEmpty(custProductList.getIsaStatus())) {
                g();
            } else if (!this.f16370i.getIsaStatus().equals("ISSUED")) {
                int i2 = this.j;
                if (i2 == 0) {
                    this.j = i2 + 1;
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            b.this.h();
                        }
                    }, 2000);
                    return;
                }
                g();
            } else if (getContext() != null) {
                try {
                    getContext().getApplicationContext();
                    g.a();
                    String a2 = net.one97.paytm.bankCommon.utils.d.a("checkBalance");
                    if (a2 == null) {
                        return;
                    }
                    if (URLUtil.isValidUrl(a2)) {
                        String e2 = com.paytm.utility.b.e(getContext(), a2);
                        HashMap hashMap = new HashMap();
                        hashMap.put("ssotoken", com.paytm.utility.a.q(getContext()));
                        hashMap.put("Accept-Encoding", "gzip");
                        new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(getContext()));
                        com.paytm.utility.b.j();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("screen_name", getClass().getSimpleName());
                        if (com.paytm.utility.b.c(getContext())) {
                            getContext().getApplicationContext();
                            new net.one97.paytm.bankCommon.g.c();
                            net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.b(e2, this, this, new CJRCashWallet(), hashMap, (String) null, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2));
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
            if (cJRCashWallet.getResponse() != null) {
                double amount = cJRCashWallet.getResponse().getAmount();
                String c2 = net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(amount));
                net.one97.paytm.bankCommon.mapping.e.a(getContext(), amount);
                net.one97.paytm.bankCommon.utils.f.a(String.format(getString(R.string.pb_wallet_rs), new Object[]{c2}), this.f16363b);
                net.one97.paytm.bankCommon.utils.d.b();
                int l = net.one97.paytm.bankCommon.utils.d.l();
                if (l <= 0 || amount < ((double) l)) {
                    g();
                    return;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("screen_name", getClass().getSimpleName());
                net.one97.paytm.bankOpen.a.a.a((Activity) getActivity(), this.f16370i.getIsaAccNum(), this.f16370i.getIsaIfsc(), net.one97.paytm.bankCommon.h.b.C(getContext()), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap3);
                return;
            }
            g();
        } else if (iJRPaytmDataModel instanceof CJRP2BStatus) {
            this.f16369h = (CJRP2BStatus) iJRPaytmDataModel;
            CJRP2BStatus cJRP2BStatus = this.f16369h;
            if (cJRP2BStatus == null || cJRP2BStatus.getResponse() == null || !this.f16369h.getResponse().isValidForTxn()) {
                g();
                return;
            }
            Double valueOf = Double.valueOf(0.0d);
            String floatCommission = this.f16369h.getResponse().getStatusTxnWiseResponse().getFloatCommission();
            if (!TextUtils.isEmpty(floatCommission) && !"0.0".equals(floatCommission)) {
                valueOf = Double.valueOf(Double.parseDouble(floatCommission));
            }
            if (valueOf.doubleValue() == 0.0d) {
                String string = getString(R.string.pb_transfer_ur_wallet_balance, "0");
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                spannableStringBuilder.setSpan(new StyleSpan(1), string.indexOf("0") - 1, string.length() - 1, 18);
                this.f16364c.setText(spannableStringBuilder);
                this.f16365d.setVisibility(8);
                b(this.f16368g);
                this.f16367f.setVisibility(8);
                this.f16366e.setVisibility(0);
                return;
            }
            g();
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        g();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.transfer_money_to_bank_btn) {
            if (getContext() != null) {
                c.a(getContext(), "bank_saving_account", "transfer_to_bank_clicked", "", "", "/bank/savings-account/congratulation", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                Intent intent = new Intent(getContext(), f.a().getTransferToBankActivityClass());
                intent.putExtra(net.one97.paytm.bankCommon.mapping.b.aP, this.f16369h);
                intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, false);
                intent.putExtra("isFrom", 1);
                startActivity(intent);
                getActivity().finish();
            }
        } else if (id == R.id.skip_btn && getContext() != null) {
            e();
        }
    }
}
