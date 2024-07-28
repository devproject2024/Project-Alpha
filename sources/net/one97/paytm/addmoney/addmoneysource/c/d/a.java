package net.one97.paytm.addmoney.addmoneysource.c.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.c.a.a;
import net.one97.paytm.addmoney.common.model.BankUtils;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.j;
import net.one97.paytm.addmoney.status.view.AddMoneyStatusActivity;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.addmoney.utils.f;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class a extends h implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public e f48224a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a.C0841a f48225b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f48226c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f48227d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f48228e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f48229f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f48230g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f48231h;

    /* renamed from: i  reason: collision with root package name */
    private int f48232i;
    private f j;
    private View k;
    private View l;
    private View m;
    /* access modifiers changed from: private */
    public View n;
    private double o;
    private String p;
    private boolean q;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f48232i = getArguments().getInt("destinationAddMoney", PaymentDestinationType.NO_CARD.getNumVal());
        this.o = getArguments().getDouble("amount");
        this.p = getArguments().getString("ppb_account_balance", "---");
        this.q = getArguments().getBoolean("destroy_self", false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f48225b = new net.one97.paytm.addmoney.addmoneysource.c.b.a(this, j.b(getContext(), getParentFragment()), this.f48232i, this.o);
        View inflate = layoutInflater.inflate(R.layout.uam_fragment_source_ppb, viewGroup, false);
        this.f48227d = (LinearLayout) inflate.findViewById(R.id.llProceed);
        this.f48228e = (EditText) inflate.findViewById(R.id.etPasscode);
        this.f48229f = (TextView) inflate.findViewById(R.id.tvError);
        this.f48231h = (TextView) inflate.findViewById(R.id.tv_ppb_balance);
        this.f48226c = (LottieAnimationView) inflate.findViewById(R.id.lavProgress);
        this.f48230g = (TextView) inflate.findViewById(R.id.tvForgotPasscode);
        this.k = inflate.findViewById(R.id.setPaytmPasscodeBtn);
        this.l = inflate.findViewById(R.id.noPasscodeLayout);
        this.m = inflate.findViewById(R.id.normalLayout);
        this.n = inflate.findViewById(R.id.crossBtn);
        this.f48231h.setText(getString(R.string.uam_available_ppb_balance, b.T(this.p)));
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f48228e.setText("");
            }
        });
        this.f48227d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.b(a.this)) {
                    a.C0841a d2 = a.this.f48225b;
                    String obj = a.this.f48228e.getText().toString();
                    a.this.f48224a.s().doubleValue();
                    d2.a(obj);
                }
            }
        });
        this.f48230g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f48225b.c();
            }
        });
        this.f48228e.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                a.this.f48229f.setVisibility(8);
                a.this.f48228e.setBackground(androidx.core.content.b.a((Context) a.this.getActivity(), R.drawable.uam_ppb_et_blue_border));
                if (editable.length() == 0) {
                    a.this.n.setVisibility(8);
                    return;
                }
                a.this.n.setVisibility(0);
                if (editable.length() == 4) {
                    b.c((Activity) a.this.getActivity());
                }
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!BankUtils.isUserPasscodeSet(a.this.getActivity())) {
                    net.one97.paytm.helper.a.b().d((Activity) a.this.getActivity());
                }
            }
        });
        this.f48225b.a();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (!BankUtils.isUserPasscodeSet(getActivity())) {
            this.m.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.m.setVisibility(0);
        this.l.setVisibility(8);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f48225b.b();
    }

    public final void a(boolean z) {
        if (z) {
            AddMoneyUtils.a(this.f48226c);
        } else {
            AddMoneyUtils.b(this.f48226c);
        }
    }

    public final void a() {
        startActivity(net.one97.paytm.helper.a.b().e((Activity) getActivity()));
    }

    public final void a(String str) {
        this.f48229f.setVisibility(0);
        this.f48228e.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.uam_ppb_et_red_border));
        this.f48229f.setText(str);
    }

    public final void b() {
        this.f48229f.setVisibility(8);
        this.f48228e.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.uam_ppb_et_blue_border));
    }

    public final void c() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            try {
                if (this.j == null) {
                    this.j = new f(getActivity());
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    this.j.f48967a = null;
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    this.j.f48968b = null;
                }
                this.j.a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void d() {
        f fVar = this.j;
        if (fVar != null) {
            fVar.b();
        }
    }

    public final double f() {
        this.o = this.f48224a.s().doubleValue();
        return this.o;
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

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 1004) {
                String stringExtra = intent.getStringExtra("retry_allowed");
                String stringExtra2 = intent.getStringExtra("error_message");
                if (!TextUtils.isEmpty(stringExtra) && "true".equalsIgnoreCase(stringExtra)) {
                    b.b(getContext(), "Error", stringExtra2);
                } else if (this.q) {
                    getActivity().setResult(-1);
                    getActivity().finish();
                } else {
                    intent.getStringExtra("extra_data");
                    Intent intent2 = new Intent(getActivity(), AddMoneyStatusActivity.class);
                    intent2.putExtra("destinationAddMoney", this.f48232i);
                    intent2.putExtra("sourceAddMoney", SourceCardType.PPB.getNumVal());
                    intent2.putExtra("sourceName", "Paytm Payments Bank");
                    intent2.putExtra("sourceDesc", "");
                    intent2.putExtra("sourceImage", "");
                    intent2.putExtra("Amount", this.o);
                    intent2.putExtra("mid", intent.getStringExtra("merchant_id"));
                    intent2.putExtra("orderId", intent.getStringExtra("order_id"));
                    startActivity(intent2);
                    getActivity().finish();
                }
            }
        } else if (this.q) {
            getActivity().setResult(0);
            getActivity().finish();
        }
    }

    public final void e() {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), (String) null, (Bundle) null);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), a.class.getCanonicalName(), (Bundle) null);
        }
    }

    static /* synthetic */ boolean b(a aVar) {
        String obj = aVar.f48228e.getText().toString();
        if (obj.length() == 0) {
            aVar.f48229f.setVisibility(0);
            aVar.f48228e.setBackground(androidx.core.content.b.a((Context) aVar.getActivity(), R.drawable.uam_ppb_et_red_border));
            aVar.f48229f.setText(R.string.uam_error_enter_passcode);
            return false;
        } else if (obj.length() >= 4) {
            return true;
        } else {
            aVar.f48229f.setVisibility(0);
            aVar.f48228e.setBackground(androidx.core.content.b.a((Context) aVar.getActivity(), R.drawable.uam_ppb_et_red_border));
            aVar.f48229f.setText(R.string.uam_error_enter_valid_passcode);
            return false;
        }
    }
}
