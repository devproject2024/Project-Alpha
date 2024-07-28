package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.o;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusTxnWiseResponse;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.common.entity.wallet.FeeDetailsBreakupList;
import net.one97.paytm.common.entity.wallet.P2BCommissionMetaObject;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.a.c;
import net.one97.paytm.p2b.b.e;
import net.one97.paytm.p2b.c.b;
import net.one97.paytm.p2b.d.d;
import net.one97.paytm.p2b.d.g;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.data.Bean.BannerTypes;
import net.one97.paytm.p2b.e.a;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankPostTxnActivity;
import net.one97.paytm.upi.util.UpiUtils;

public class c extends h implements View.OnClickListener, c.b, net.one97.paytm.p2b.b.c, e {
    private g A;
    private ImageView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private RelativeLayout F;
    /* access modifiers changed from: private */
    public CheckBox G;
    /* access modifiers changed from: private */
    public a H;
    /* access modifiers changed from: private */
    public boolean I = false;
    private RelativeLayout J;
    private ConstraintLayout K;
    private boolean L;
    private String M;
    private ConstraintLayout N;
    private double O;
    private double P;
    private CJRP2BStatus Q;
    private FrameLayout R;

    /* renamed from: a  reason: collision with root package name */
    int f12920a = 36865;

    /* renamed from: b  reason: collision with root package name */
    private c.a f12921b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f12922c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f12923d;

    /* renamed from: e  reason: collision with root package name */
    private String f12924e;

    /* renamed from: f  reason: collision with root package name */
    private String f12925f;

    /* renamed from: g  reason: collision with root package name */
    private String f12926g;

    /* renamed from: h  reason: collision with root package name */
    private String f12927h;

    /* renamed from: i  reason: collision with root package name */
    private String f12928i;
    private String j;
    private String k;
    private double l;
    private boolean m;
    private LottieAnimationView n;
    private LottieAnimationView o;
    private TextView p;
    private double q;
    private d r;
    private boolean s;
    private CardView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private String y;
    private boolean z;

    public final void a(CJRAddBeneficiary cJRAddBeneficiary) {
    }

    public static c a(String str, String str2, String str3, boolean z2, String str4, String str5, double d2, String str6, double d3, double d4, boolean z3) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        String str7 = str;
        bundle.putString(net.one97.paytm.p2b.d.c.f12675e, str);
        String str8 = str2;
        bundle.putString(net.one97.paytm.p2b.d.c.f12676f, str2);
        String str9 = str3;
        bundle.putString(net.one97.paytm.p2b.d.c.f12677g, str3);
        boolean z4 = z2;
        bundle.putBoolean(net.one97.paytm.p2b.d.c.f12678h, z2);
        String str10 = str4;
        bundle.putString(PayUtility.BANK_NAME, str4);
        String str11 = str5;
        bundle.putString("branch_name", str5);
        String str12 = str6;
        bundle.putString(net.one97.paytm.p2b.d.c.f12671a, str6);
        double d5 = d2;
        bundle.putDouble(net.one97.paytm.p2b.d.c.f12672b, d2);
        bundle.putDouble(net.one97.paytm.p2b.d.c.f12674d, d4);
        double d6 = d3;
        bundle.putDouble("fixed_commision", d3);
        bundle.putBoolean(net.one97.paytm.p2b.d.c.f12679i, z3);
        cVar.setArguments(bundle);
        return cVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.p2b_transfer_summary_fragment, viewGroup, false);
        this.C = (TextView) inflate.findViewById(R.id.know_more);
        this.N = (ConstraintLayout) inflate.findViewById(R.id.data_layout);
        this.E = (TextView) inflate.findViewById(R.id.terms_text);
        this.D = (TextView) inflate.findViewById(R.id.user_slab_text);
        this.F = (RelativeLayout) inflate.findViewById(R.id.user_slab_query_layout);
        this.w = (TextView) inflate.findViewById(R.id.tv_fee);
        this.u = (TextView) inflate.findViewById(R.id.tv_fee_label);
        this.f12922c = (TextView) inflate.findViewById(R.id.tv_account_number);
        this.f12923d = (TextView) inflate.findViewById(R.id.tv_account_holder_name);
        this.v = (TextView) inflate.findViewById(R.id.tv_amount_to_sent);
        this.x = (TextView) inflate.findViewById(R.id.tv_net_payable);
        this.f12924e = getArguments().getString(net.one97.paytm.p2b.d.c.f12675e);
        this.f12925f = getArguments().getString(net.one97.paytm.p2b.d.c.f12676f);
        this.f12926g = getArguments().getString(net.one97.paytm.p2b.d.c.f12677g);
        this.t = (CardView) inflate.findViewById(R.id.include_summary);
        this.m = getArguments().getBoolean(net.one97.paytm.p2b.d.c.f12678h);
        this.f12928i = getArguments().getString(PayUtility.BANK_NAME);
        this.j = getArguments().getString("branch_name");
        this.k = getArguments().getString(net.one97.paytm.p2b.d.c.f12671a);
        this.l = getArguments().getDouble(net.one97.paytm.p2b.d.c.f12674d);
        this.z = getArguments().getBoolean(net.one97.paytm.p2b.d.c.f12679i);
        this.p = (TextView) inflate.findViewById(R.id.btn_proceed);
        this.n = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.o = (LottieAnimationView) inflate.findViewById(R.id.lav_amount_progress);
        this.B = (ImageView) inflate.findViewById(R.id.iv_bank_icon);
        this.G = (CheckBox) inflate.findViewById(R.id.cb_mark_account_belong_to_me);
        this.J = (RelativeLayout) inflate.findViewById(R.id.rl_loader);
        this.K = (ConstraintLayout) inflate.findViewById(R.id.rl_mark_self);
        this.R = (FrameLayout) inflate.findViewById(R.id.sf_fl);
        this.K.setVisibility(8);
        this.H.l.observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                c.this.a((o) obj);
            }
        });
        a(this.f12922c, k.a(getString(R.string.p2b_acc_number_initial, ""), this.f12928i, this.f12924e));
        a(this.f12923d, this.f12925f);
        this.G.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.G.isChecked()) {
                    boolean unused = c.this.I = true;
                } else {
                    boolean unused2 = c.this.I = false;
                }
            }
        });
        if (!TextUtils.isEmpty(this.f12926g)) {
            k.a(this.B.getContext(), this.B, this.f12926g);
        }
        this.H.m.observe(this, new z<CJRAddBeneficiary.CJRAddBeneficiarySubError>() {
            public final /* synthetic */ void onChanged(Object obj) {
                c cVar = c.this;
                cVar.a((CJRAddBeneficiary.CJRAddBeneficiarySubError) obj, cVar.H.o);
            }
        });
        this.H.f12773g.observe(this, new z<Boolean>() {
            public final /* synthetic */ void onChanged(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    c.this.H.b(Boolean.TRUE);
                    c.this.a(false, (String) null, false);
                    return;
                }
                c.this.b(true);
            }
        });
        if (this.m && this.H.n != null && this.H.n.instrumentPreferences.otherBank.accounts.get(0).self) {
            this.G.setEnabled(false);
            this.K.setAlpha(0.7f);
        }
        this.H.a(BannerTypes.CONFIRMATION_SCREEN, net.one97.paytm.p2b.d.h.b().a("confirmation_banner_url", "https://storefront.paytm.com/v2/h/p2b-confirmation-screen"), "P2B_confirmation");
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(o oVar) {
        if (oVar != null && getActivity() != null) {
            net.one97.paytm.p2b.view.CustomView.a aVar = net.one97.paytm.p2b.view.CustomView.a.f12883a;
            net.one97.paytm.p2b.view.CustomView.a.a(getActivity().getSupportFragmentManager(), this.R, (List) oVar.getFirst(), "P2B_confirmation", (StoreFrontGAHandler) oVar.getSecond());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.N.setVisibility(0);
        this.Q = this.H.r;
        if (this.Q != null) {
            b(true);
            CJRP2BStatusTxnWiseResponse statusTxnWiseResponse = this.Q.getResponse().getStatusTxnWiseResponse();
            P2BCommissionMetaObject p2BCommissionMetaObject = this.Q.getResponse().getP2BCommissionMetaObject();
            if (p2BCommissionMetaObject != null) {
                this.O = p2BCommissionMetaObject.getCommissionAmount().doubleValue();
                this.P = p2BCommissionMetaObject.getTotalPayableAmount().doubleValue();
                this.l = Double.valueOf(statusTxnWiseResponse.getFloatCommission()).doubleValue();
                this.q = p2BCommissionMetaObject.getCommissionAmount().doubleValue();
            }
            this.t.setVisibility(0);
            TextView textView = this.v;
            textView.setText(k.a(this.k, this.y));
            TextView textView2 = this.x;
            StringBuilder sb = new StringBuilder();
            sb.append(this.P);
            textView2.setText(k.a(sb.toString(), this.y));
            try {
                a(p2BCommissionMetaObject);
                this.p.setOnClickListener(this);
            } catch (Exception | NumberFormatException unused) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.p2b.d.h.b().a(this, (e) this);
        this.H = (a) new al((ao) Objects.requireNonNull(getActivity()), (al.b) al.a.a(((FragmentActivity) Objects.requireNonNull(getActivity())).getApplication())).a(a.class);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.y = getString(R.string.p2b_rupee_prefix);
        if (activity instanceof g) {
            this.A = (g) activity;
        }
        if (this.r == null) {
            this.r = new d();
        }
        this.r.a((Activity) getActivity(), "P2B_TRANSFER", (net.one97.paytm.p2b.b.c) this);
        this.r.f12693h = false;
        if (getArguments() != null) {
            this.z = getArguments().getBoolean(net.one97.paytm.p2b.d.c.f12679i);
        }
        this.f12921b = new b(this, net.one97.paytm.p2b.data.a.b.a(getContext()), this.z, getClass().getName());
    }

    private static void a(TextView textView, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public final void d() {
        this.J.setVisibility(0);
        k.a(this.n);
        b(false);
    }

    public final void e() {
        k.b(this.n);
        this.J.setVisibility(8);
        b(true);
    }

    public final void b(boolean z2) {
        TextView textView = this.p;
        if (textView != null) {
            textView.setEnabled(z2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing() && isResumed()) {
            e();
            b(true);
            if (networkCustomError instanceof NetworkCustomError) {
                String valueOf = String.valueOf(networkCustomError.getStatusCode());
                if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(valueOf) || "403".equalsIgnoreCase(valueOf) || "410".equalsIgnoreCase(valueOf)) {
                    this.A.e();
                } else {
                    c(networkCustomError.getAlertMessage());
                }
            } else if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403 || networkCustomError.getStatusCode() == 410)) {
                c((String) null);
            } else {
                this.A.e();
            }
        }
    }

    public final void a(String str) {
        if (getActivity() != null && !getActivity().isFinishing() && isResumed()) {
            net.one97.paytm.p2b.d.h.b().a(getContext(), "P2B", "P2B_txn_details_screen", "OTP_triggered", SendMoneyToBankActivity.f12799a, "", "p2b", "P2B");
            b(true);
            b(str);
        }
    }

    private void b(String str) {
        e();
        if (TextUtils.isEmpty(str)) {
            c((String) null);
            return;
        }
        String str2 = this.f12924e;
        String str3 = this.f12925f;
        String str4 = this.f12926g;
        boolean z2 = this.m;
        String str5 = this.f12928i;
        String str6 = this.j;
        double d2 = this.q;
        i a2 = i.a(str2, str3, str4, z2, str5, str6, d2, this.k, this.l, str, this.I);
        a2.show(getActivity().getSupportFragmentManager(), a2.getTag());
    }

    public final void b(NetworkCustomError networkCustomError) {
        if (networkCustomError instanceof NetworkCustomError) {
            String valueOf = String.valueOf(networkCustomError.getStatusCode());
            if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(valueOf) || "403".equalsIgnoreCase(valueOf) || "410".equalsIgnoreCase(valueOf)) {
                this.A.e();
            } else {
                c(networkCustomError.getAlertMessage());
            }
        } else {
            c((String) null);
        }
        b(true);
    }

    public final void b() {
        if (getActivity() != null && !getActivity().isFinishing() && isResumed()) {
            d();
            b(false);
        }
    }

    public final void c() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            e();
            b(true);
        }
    }

    public final void a() {
        this.A.e();
    }

    private void a(Intent intent) {
        intent.putExtra(net.one97.paytm.p2b.d.c.O, this.f12925f);
        String str = net.one97.paytm.p2b.d.c.Q;
        intent.putExtra(str, this.k);
        intent.putExtra(net.one97.paytm.p2b.d.c.P, this.f12927h);
        intent.putExtra(net.one97.paytm.p2b.d.c.R, this.f12924e);
        intent.putExtra(net.one97.paytm.p2b.d.c.T, this.f12928i);
        intent.putExtra(net.one97.paytm.p2b.d.c.U, this.Q);
        intent.putExtra(net.one97.paytm.p2b.d.c.S, this.q);
        intent.putExtra("tran_time", System.currentTimeMillis());
        intent.putExtra(net.one97.paytm.p2b.d.c.f12674d, this.l);
        intent.putExtra(net.one97.paytm.p2b.d.c.f12673c, this.x.getText().toString());
        intent.putExtra("is_self", this.I);
        intent.putExtra("key_source", SendMoneyToBankActivity.f12799a);
        if (this.z) {
            intent.putExtra(net.one97.paytm.p2b.d.c.m, (String) null);
            intent.putExtra(net.one97.paytm.p2b.d.c.n, false);
        }
    }

    public void onDetach() {
        super.onDetach();
        d dVar = this.r;
        if (dVar != null) {
            dVar.f();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, String str, boolean z3) {
        d();
        this.s = z2;
        this.M = str;
        this.L = z3;
        net.one97.paytm.p2b.d.h.b().q();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        k.a((Activity) getActivity(), new Handler());
        if (i2 == 104) {
            if (intent != null) {
                a(true, intent.getStringExtra("intent_extra_wallet_order_id"), intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false));
            }
        } else if (i2 == net.one97.paytm.p2b.d.c.l) {
            if (intent != null) {
                intent.getStringExtra("order_id");
                intent.getBooleanExtra(AppConstants.IS_CANCEL, false);
            }
        } else if (i2 == this.f12920a) {
            if (i3 == 0) {
                e();
            }
            net.one97.paytm.p2b.d.h.b().a(i2, i3, intent);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_proceed) {
            this.H.o = "";
            this.I = this.G.isChecked();
            c(false);
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        net.one97.paytm.p2b.d.h.b().a(getContext(), "P2B", "P2B_txn_details_screen", "Proceed_clicked", SendMoneyToBankActivity.f12799a, String.valueOf(this.k), "p2b", "P2B");
        if (z2) {
            this.I = false;
            if (!this.m) {
                b(this.H.o);
                return;
            }
        } else {
            boolean z3 = this.m;
            if (!z3) {
                d(this.I);
                return;
            }
            boolean z4 = this.I;
            if (z4 && z3) {
                e(z4);
                return;
            }
        }
        a(false, (String) null, false);
    }

    private void d(boolean z2) {
        if (k.a(getContext())) {
            this.f12921b.a(this.f12924e, this.f12926g, this.f12925f, this.f12928i, z2);
        } else {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
        }
    }

    private void e(boolean z2) {
        if (k.a(getContext())) {
            this.f12921b.a(this.H.n, z2);
        } else {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
        }
    }

    private void a(P2BCommissionMetaObject p2BCommissionMetaObject) {
        if (p2BCommissionMetaObject != null) {
            List<FeeDetailsBreakupList> feeDetailsBreakupList = p2BCommissionMetaObject.getFeeDetailsBreakupList();
            if (getView() != null) {
                LinearLayout linearLayout = (LinearLayout) getView().findViewById(R.id.slab_layout);
                if (feeDetailsBreakupList != null) {
                    int size = feeDetailsBreakupList.size();
                    int size2 = feeDetailsBreakupList.size();
                    if (this.O > 0.0d) {
                        this.E.setVisibility(0);
                    }
                    if (size2 > 1) {
                        boolean a2 = net.one97.paytm.p2b.d.h.b().a("showTwoDifferentCharges", false);
                        String a3 = net.one97.paytm.p2b.d.h.b().a("knowMoreTwoDifferentChargeLink", "");
                        if (a2 && this.O > 0.0d) {
                            this.D.setText(getString(R.string.slab_text, Integer.valueOf(size2)));
                            this.F.setVisibility(0);
                            this.C.setOnClickListener(new View.OnClickListener(a3) {
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onClick(View view) {
                                    c.this.a(this.f$1, view);
                                }
                            });
                        }
                    }
                    int i2 = 0;
                    while (i2 < size) {
                        FeeDetailsBreakupList feeDetailsBreakupList2 = feeDetailsBreakupList.get(i2);
                        if (feeDetailsBreakupList2 != null) {
                            View inflate = LinearLayout.inflate(getContext(), R.layout.p2b_amount_row, (ViewGroup) null);
                            TextView textView = (TextView) inflate.findViewById(R.id.tv_fee_item_label_item);
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_info_icon_item);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_fee_item);
                            if (i2 != 0 || feeDetailsBreakupList2.getSlabFeePercentage().doubleValue() == 0.0d) {
                                imageView.setVisibility(8);
                            }
                            imageView.setOnClickListener(new View.OnClickListener(feeDetailsBreakupList2, feeDetailsBreakupList) {
                                private final /* synthetic */ FeeDetailsBreakupList f$1;
                                private final /* synthetic */ List f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void onClick(View view) {
                                    c.this.a(this.f$1, this.f$2, view);
                                }
                            });
                            String a4 = k.a(feeDetailsBreakupList2.getSlabFeePercentage().doubleValue());
                            if (size > 1) {
                                textView.setText(getString(R.string.p2b_fee_with_interest_slab, feeDetailsBreakupList2.getSlabTxnAmount().toString(), a4));
                            } else {
                                textView.setText(getString(R.string.p2b_fee_with_interest_new, a4));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(feeDetailsBreakupList2.getSlabFeeAmount());
                            textView2.setText(k.a(sb.toString(), this.y));
                            linearLayout.addView(inflate);
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(FeeDetailsBreakupList feeDetailsBreakupList, List list, View view) {
        this.A.a(feeDetailsBreakupList.getSlabFeePercentage().doubleValue(), list);
    }

    private void a(double d2) {
        if (!k.a((Context) getActivity())) {
            e();
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
        } else if (!this.z) {
            String replace = this.f12924e.replace("\\n", "").replace("\\r", "");
            net.one97.paytm.f.b.a().a(getActivity(), this.f12925f, (String) null, false, "p2b", (String) null, (String) null);
            d dVar = this.r;
            String str = this.f12925f;
            String str2 = this.f12928i;
            String str3 = this.f12926g;
            String l2 = com.paytm.utility.b.l((Context) getActivity());
            String d3 = Double.toString(d2);
            String str4 = this.f12927h;
            StringBuilder sb = new StringBuilder();
            sb.append(this.O);
            dVar.a(str, str, str2, str3, replace, l2, d3, str4, sb.toString());
        }
    }

    private void c(String str) {
        String string = getString(R.string.p2b_error_title);
        String string2 = getString(R.string.p2b_default_error);
        if (TextUtils.isEmpty(str)) {
            str = string2;
        }
        final com.paytm.utility.h hVar = new com.paytm.utility.h(getContext());
        hVar.setTitle(string);
        hVar.a(str);
        hVar.a(-1, getString(R.string.p2b_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    private void a(String str, final boolean z2) {
        View inflate = getLayoutInflater().inflate(R.layout.p2b_mark_layout_self_statue, (ViewGroup) null);
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getContext(), R.style.p2bAppBottomSheetDialogTheme);
        aVar.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
                k.a((Activity) c.this.getActivity());
            }
        });
        from.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onStateChanged(View view, int i2) {
            }

            public final void onSlide(View view, float f2) {
                aVar.cancel();
                k.a((Activity) c.this.getActivity());
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_failure_msg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.btn_cancel);
        TextView textView3 = (TextView) inflate.findViewById(R.id.btn_proceed);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
        if (z2) {
            textView3.setText(getString(R.string.p2b_try_again));
            textView2.setText(getString(R.string.p2b_proceed_anyway));
        } else {
            textView3.setText(getString(R.string.p2b_proceed_anyway));
            textView2.setText(getString(R.string.p2b_cancel));
        }
        textView3.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (z2) {
                    c.this.c(false);
                } else {
                    c.this.c(true);
                }
                aVar.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (z2) {
                    c.this.c(true);
                }
                aVar.dismiss();
            }
        });
        from.setState(2);
        from.setPeekHeight(com.paytm.utility.b.b((Activity) getActivity()) - k.b(getContext()));
        aVar.getWindow().setSoftInputMode(16);
        aVar.show();
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                aVar.cancel();
                return true;
            }
        });
    }

    public final void a(CJRAddBeneficiary.CJRAddBeneficiarySubError cJRAddBeneficiarySubError, String str) {
        if (getActivity() != null && !getActivity().isFinishing() && isResumed()) {
            String code = cJRAddBeneficiarySubError.getCode();
            if (code.equalsIgnoreCase("INT-1003") || code.equalsIgnoreCase("INT-1001")) {
                c(getString(R.string.p2b_phone_number_not_found));
            } else if (code.equalsIgnoreCase("INT-1000")) {
                a(getString(R.string.p2b_self_upi_down_error), true);
            } else if (code.equalsIgnoreCase("INT-1002")) {
                a(getString(R.string.p2b_self_upi_not_exist), false);
            } else {
                a(getString(R.string.p2b_generic_self_mark_error), false);
            }
            this.H.o = str;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        c.a aVar = this.f12921b;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.H;
        aVar2.o = "";
        aVar2.a(Boolean.FALSE);
    }

    public void onStart() {
        super.onStart();
        k.a((Activity) getActivity());
    }

    public final void a(boolean z2) {
        if (z2) {
            d();
        }
    }

    public final void g() {
        e();
        Toast.makeText(getActivity(), "Passcode verification failed", 1).show();
    }

    public final void f() {
        double d2;
        if (TextUtils.isEmpty(com.paytm.utility.b.l((Context) getActivity())) || !isAdded()) {
            Toast.makeText(getContext(), getString(R.string.p2b_mobile_number_not_found), 0).show();
            e();
        } else if (this.r != null) {
            try {
                double parseDouble = Double.parseDouble(this.k);
                d2 = k.b(parseDouble, k.a(parseDouble, this.l));
            } catch (Exception unused) {
                d2 = 0.0d;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("new_wallet_screen_type", "send_money");
                if (!this.z) {
                    net.one97.paytm.p2b.d.h.b().a("new_wallet_bank_proceed_clicked", (Map<String, ? extends Object>) hashMap, (Context) getActivity());
                }
            } catch (Exception unused2) {
            }
            if (this.s) {
                d dVar = this.r;
                String str = this.M;
                String str2 = this.f12925f;
                dVar.a(str, str2, str2, this.f12928i, this.f12926g, this.f12924e, com.paytm.utility.b.l((Context) getActivity()), Double.toString(d2), this.f12927h, String.valueOf(this.q), this.L);
                return;
            }
            a(d2);
        }
    }

    public final void a(IJRDataModel iJRDataModel) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            hashMap.put("new_wallet_bank_amount", this.k);
            hashMap.put("new_wallet_bank_ifsc_code", this.f12926g);
            hashMap.put("new_wallet_bank_name", this.f12928i);
            hashMap.put("new_wallet_bank_transaction_status", "success");
            net.one97.paytm.p2b.d.h.b().a("new_wallet_bank_transaction_status", (Map<String, ? extends Object>) hashMap, (Context) getActivity());
        } catch (Exception unused) {
        }
        net.one97.paytm.f.b.a().c();
        if (iJRDataModel instanceof CJRSendMoney) {
            Intent intent = new Intent(getContext(), SendMoneyToBankPostTxnActivity.class);
            intent.putExtra(net.one97.paytm.p2b.d.c.N, iJRDataModel);
            a(intent);
            startActivity(intent);
            getActivity().finish();
        } else if (iJRDataModel instanceof CJRValidateTransaction) {
            Intent intent2 = new Intent(getContext(), SendMoneyToBankPostTxnActivity.class);
            intent2.putExtra(net.one97.paytm.p2b.d.c.N, iJRDataModel);
            a(intent2);
            startActivity(intent2);
            getActivity().finish();
        }
    }
}
