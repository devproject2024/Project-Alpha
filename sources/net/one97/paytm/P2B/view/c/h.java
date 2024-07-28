package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.o;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;
import net.one97.paytm.common.entity.wallet.CJRP2BStatusResponse;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.a.d;
import net.one97.paytm.p2b.d.c;
import net.one97.paytm.p2b.d.g;
import net.one97.paytm.p2b.d.i;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.data.Bean.BannerTypes;
import net.one97.paytm.p2b.e.a;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.p2b.view.CustomView.CustomAmountTextInputEditText;

public class h extends net.one97.paytm.i.h implements View.OnClickListener, d.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f13005a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f13006b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13007c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f13008d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13009e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13010f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13011g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13012h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f13013i;
    private RelativeLayout j;
    private RelativeLayout k;
    private String l;
    private CustomAmountTextInputEditText m;
    private LottieAnimationView n;
    /* access modifiers changed from: private */
    public d.a o;
    /* access modifiers changed from: private */
    public TextView p;
    /* access modifiers changed from: private */
    public View q;
    private String r;
    /* access modifiers changed from: private */
    public boolean s;
    private String t;
    private CJRP2BStatus u;
    private boolean v = false;
    private g w;
    private a x;
    private FrameLayout y;
    private TextWatcher z = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (TextUtils.isEmpty(charSequence.toString())) {
                h.this.f13013i.setTextColor(b.c(h.this.getContext(), R.color.p2b_edittext_hint_color));
            } else {
                h.this.f13013i.setTextColor(b.c(h.this.getContext(), R.color.p2b_black));
            }
            h.this.p.setText("");
            h.this.q.setBackgroundColor(h.this.getResources().getColor(R.color.p2b_blue));
            h hVar = h.this;
            h.a(hVar, (CharSequence) hVar.o.a(charSequence.toString()));
        }
    };

    public static h a(boolean z2, String str, CJRP2BStatus cJRP2BStatus) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putBoolean(c.f12679i, z2);
        bundle.putString(c.f12671a, str);
        bundle.putSerializable(c.M, cJRP2BStatus);
        hVar.setArguments(bundle);
        return hVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = getString(R.string.p2b_rupee_prefix);
        this.x = (a) new al((ao) getActivity(), (al.b) al.a.a(getActivity().getApplication())).a(a.class);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.p2b_fragment_send_money_to_bank, viewGroup, false);
        this.n = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f13006b = (TextView) inflate.findViewById(R.id.tv_offer_text);
        this.f13012h = (TextView) inflate.findViewById(R.id.btn_proceed);
        this.f13012h.setOnClickListener(this);
        this.m = (CustomAmountTextInputEditText) inflate.findViewById(R.id.et_amount);
        this.m.setPrefix("");
        this.m.setMaxDigitsBeforeDecimalPoint(5);
        this.f13013i = (TextView) inflate.findViewById(R.id.tv_rupee_prefix);
        this.j = (RelativeLayout) inflate.findViewById(R.id.lyt_p2b_net_payable);
        this.f13007c = (TextView) inflate.findViewById(R.id.txt_p2b_net_payable);
        this.k = (RelativeLayout) inflate.findViewById(R.id.lyt_p2b_fee);
        this.f13008d = (TextView) inflate.findViewById(R.id.txt_p2b_fee);
        this.p = (TextView) inflate.findViewById(R.id.tv_error);
        this.q = inflate.findViewById(R.id.line);
        this.y = (FrameLayout) inflate.findViewById(R.id.sf_fl);
        this.f13009e = (TextView) inflate.findViewById(R.id.tv_fee_with_rate);
        this.m.setImeOptions(5);
        this.m.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 5) {
                    return false;
                }
                h.this.i();
                return true;
            }
        });
        this.f13010f = (TextView) inflate.findViewById(R.id.tv_fee_charges_description);
        this.m.setOnClickListener(this);
        this.f13011g = (TextView) inflate.findViewById(R.id.tv_send_money_header);
        if (this.s) {
            this.f13011g.setText(getString(R.string.p2b_enter_amount_title_via_cc));
        } else {
            this.f13011g.setText(getString(R.string.p2b_enter_amount_title));
        }
        g();
        this.f13009e.setText(getString(R.string.p2b_fee_with_interest_new, this.l));
        this.m.addTextChangedListener(this.z);
        if (!TextUtils.isEmpty(this.t)) {
            this.m.setText(this.t);
        }
        this.o.a(this.u);
        this.m.requestFocus();
        k.a((EditText) this.m, (Activity) getActivity());
        this.x.k.observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                h.this.a((o) obj);
            }
        });
        this.x.q.observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                h.this.c((String) obj);
            }
        });
        a aVar = this.x;
        net.one97.paytm.p2b.data.a.a aVar2 = aVar.f12767a;
        if (aVar2 != null) {
            aVar2.a(aVar.getApplication(), new a.b(aVar), "P2b");
        }
        this.x.a(BannerTypes.AMOUNT_ENTER_SCREEN, net.one97.paytm.p2b.d.h.b().a("w2bBecomeMerchanrUrl"), "P2B_landing");
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f13005a = context;
        if (context instanceof g) {
            this.w = (g) context;
        }
        if (getArguments() != null) {
            this.s = getArguments().getBoolean(c.f12679i);
            this.t = getArguments().getString(c.f12671a);
            this.u = (CJRP2BStatus) getArguments().getSerializable(c.M);
        }
        this.o = new net.one97.paytm.p2b.c.c(this, net.one97.paytm.p2b.data.a.b.a(this.f13005a), this.s, getClass().getName());
        this.l = k.a(this.o.e());
        if (this.s) {
            i.a(getContext(), c.I, (String) null, (String) null, (String) null);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.w = null;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_proceed) {
            i();
        } else if (id == R.id.et_amount && this.s) {
            i.a(getContext(), c.u, c.v, c.y, (String) null);
        }
    }

    private void e() {
        k.a((Activity) getActivity());
        if (!this.o.g()) {
            Toast.makeText(getActivity(), getString(R.string.p2b_please_wait_p2b_status), 0).show();
            return;
        }
        d.a aVar = this.o;
        if (!aVar.d(aVar.a(this.m.getText().toString()))) {
            return;
        }
        if (this.v) {
            k.a((Activity) getActivity());
            String n2 = net.one97.paytm.p2b.d.h.b().n();
            View inflate = getLayoutInflater().inflate(R.layout.p2b_informatory_popup, (ViewGroup) null);
            final com.google.android.material.bottomsheet.a aVar2 = new com.google.android.material.bottomsheet.a(getContext());
            aVar2.setContentView(inflate);
            final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            aVar2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    from.setState(4);
                    k.a((Activity) h.this.getActivity());
                }
            });
            from.setBottomSheetCallback(new BottomSheetBehavior.a() {
                public final void onStateChanged(View view, int i2) {
                }

                public final void onSlide(View view, float f2) {
                    aVar2.cancel();
                }
            });
            from.setState(2);
            from.setPeekHeight(com.paytm.utility.b.b((Activity) getActivity()));
            aVar2.getWindow().setSoftInputMode(16);
            aVar2.show();
            inflate.findViewById(R.id.iv_cross).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar2.cancel();
                }
            });
            inflate.findViewById(R.id.tv_i_understand).setOnClickListener(new View.OnClickListener() {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ boolean f13024b = true;

                public final void onClick(View view) {
                    aVar2.cancel();
                    if (this.f13024b) {
                        h.this.f();
                    } else if (h.this.s) {
                        i.a(h.this.getContext(), c.u, c.v, c.A, (String) null);
                    }
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_info_via_money_transfer);
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_pop_up_text);
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_rbi_guideline);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_transfer_flow);
            if (this.s) {
                textView.setText(getString(R.string.p2b_interest_charge, this.l));
                textView3.setVisibility(8);
                textView4.setVisibility(0);
                textView2.setVisibility(0);
                imageView.setVisibility(0);
                textView4.setText(getString(R.string.p2b_rbi_guideline));
                try {
                    String string = getString(R.string.p2b_recommend_via_money_transfer);
                    SpannableString spannableString = new SpannableString(string);
                    int indexOf = string.indexOf(getString(R.string.p2b_money_transfer));
                    if (indexOf > 0) {
                        spannableString.setSpan(new ClickableSpan() {
                            public final void onClick(View view) {
                                h.this.startActivity(net.one97.paytm.p2b.d.h.b().b((Context) h.this.getActivity()));
                                h.this.getActivity().finish();
                            }

                            public final void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                textPaint.setColor(h.this.getResources().getColor(R.color.p2b_blue));
                                textPaint.setUnderlineText(false);
                            }
                        }, indexOf, getString(R.string.p2b_recommend_via_money_transfer).length(), 33);
                        textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    textView2.setText(spannableString);
                } catch (Exception unused) {
                }
            } else {
                textView.setText(getString(R.string.p2b_important));
                textView2.setVisibility(8);
                imageView.setVisibility(8);
                textView4.setVisibility(8);
                textView3.setVisibility(0);
                textView3.setText(n2);
            }
        } else {
            f();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(o oVar) {
        if (oVar != null && getActivity() != null) {
            net.one97.paytm.p2b.view.CustomView.a aVar = net.one97.paytm.p2b.view.CustomView.a.f12883a;
            net.one97.paytm.p2b.view.CustomView.a.a(getActivity().getSupportFragmentManager(), this.y, (List) oVar.getFirst(), "P2B_landing", (StoreFrontGAHandler) oVar.getSecond());
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        StringBuilder sb = new StringBuilder();
        boolean d2 = d("shouldShowP2bOfferText1");
        boolean d3 = d("shouldShowP2bOfferText2");
        boolean d4 = d("shouldShowP2bKnowMore");
        String e2 = e("P2bcashBackofferText2");
        if (d2 && !TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(". ");
            if (d3 && !TextUtils.isEmpty(e2)) {
                sb.append(e2);
                sb.append(". ");
            }
            if (!d4 || TextUtils.isEmpty(sb)) {
                this.f13006b.setText(sb.toString());
                return;
            }
            sb.append(getString(R.string.know_more_cash_back_p2b));
            final String e3 = e("knowMoreOfferDeeplinkP2B");
            try {
                String sb2 = sb.toString();
                SpannableString spannableString = new SpannableString(sb2);
                int indexOf = sb2.indexOf(getString(R.string.know_more_cash_back_p2b));
                if (indexOf > 0) {
                    spannableString.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            if (h.this.getContext() != null && !TextUtils.isEmpty(e3)) {
                                net.one97.paytm.p2b.d.h.b().a(h.this.getContext(), e3);
                            }
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(h.this.getResources().getColor(R.color.p2b_blue));
                            textPaint.setUnderlineText(false);
                        }
                    }, indexOf, sb2.length(), 33);
                    this.f13006b.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.f13006b.setText(spannableString);
            } catch (Exception unused) {
            }
        }
    }

    private static boolean d(String str) {
        return net.one97.paytm.p2b.d.h.b().a(str, true);
    }

    private static String e(String str) {
        return net.one97.paytm.p2b.d.h.b().a(str);
    }

    /* access modifiers changed from: private */
    public void f() {
        if (k.a(getContext())) {
            d.a aVar = this.o;
            aVar.c(aVar.a(((Editable) Objects.requireNonNull(this.m.getText())).toString()));
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
    }

    private void g() {
        CJRP2BStatusResponse response;
        CJRP2BStatus cJRP2BStatus = this.u;
        if (cJRP2BStatus != null && (response = cJRP2BStatus.getResponse()) != null) {
            String feeDescriptionText = response.getFeeDescriptionText();
            if (!TextUtils.isEmpty(feeDescriptionText)) {
                this.f13010f.setText(feeDescriptionText);
            }
        }
    }

    public final void a() {
        k.a(this.n);
        a(false);
    }

    public final void b() {
        k.b(this.n);
        a(true);
    }

    private void a(boolean z2) {
        TextView textView = this.f13012h;
        if (textView != null) {
            textView.setEnabled(z2);
        }
    }

    public final String c() {
        return this.o.a(this.m.getText().toString());
    }

    public final void a(String str, String str2) {
        this.p.setText(getString(R.string.p2b_wallet_p2b_amount_error_part_1, com.paytm.utility.b.x(str) + getString(R.string.p2b_wallet_p2b_amount_error_part_2) + com.paytm.utility.b.x(str2)));
        this.q.setBackgroundColor(getResources().getColor(R.color.p2b_error));
        ViewParent parent = this.m.getParent();
        CustomAmountTextInputEditText customAmountTextInputEditText = this.m;
        parent.requestChildFocus(customAmountTextInputEditText, customAmountTextInputEditText);
        this.m.requestFocus();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_error_type", "send_money_error");
            hashMap.put("wallet_error_text", getString(R.string.p2b_wallet_ifsc_code_error));
            i.a(getContext(), (Map<String, Object>) hashMap, this.s);
        } catch (Exception unused) {
        }
    }

    public final void a(String str) {
        try {
            this.l = k.a(Double.valueOf(str).doubleValue());
        } catch (Exception unused) {
            this.l = str;
        }
        g();
        this.f13009e.setText(getString(R.string.p2b_fee_with_interest_new, this.l));
    }

    public final void d() {
        if (this.w != null) {
            h();
        }
    }

    private void h() {
        net.one97.paytm.p2b.d.h.b().a(getContext(), "P2B", "Amount_entered", "Proceed_clicked", SendMoneyToBankActivity.f12799a, String.valueOf(this.o.b()), "p2b", "P2B");
        this.w.a(this.o.b(), this.o.c(), this.o.d(), this.o.e(), this.o.f());
        this.w.d();
    }

    public final void b(String str) {
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

    public final void a(NetworkCustomError networkCustomError) {
        FragmentActivity activity = getActivity();
        String canonicalName = SendMoneyToBankActivity.class.getCanonicalName();
        Boolean bool = Boolean.FALSE;
        k.a((Activity) activity, networkCustomError, canonicalName);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onDestroy() {
        super.onDestroy();
        d.a aVar = this.o;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r0 = r0.f12731c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r3 = this;
            net.one97.paytm.p2b.e.a r0 = r3.x
            androidx.lifecycle.y<net.one97.paytm.p2b.data.a<java.lang.Integer>> r0 = r0.f12768b
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.p2b.data.a r0 = (net.one97.paytm.p2b.data.a) r0
            if (r0 == 0) goto L_0x0038
            net.one97.paytm.p2b.data.b r1 = r0.f12729a
            if (r1 == 0) goto L_0x0038
            net.one97.paytm.p2b.data.b r1 = r0.f12729a
            net.one97.paytm.p2b.data.b r2 = net.one97.paytm.p2b.data.b.ERROR
            if (r1 != r2) goto L_0x0038
            com.paytm.network.model.NetworkCustomError r0 = r0.f12731c
            if (r0 == 0) goto L_0x0038
            com.paytm.network.model.NetworkResponse r1 = r0.networkResponse
            if (r1 == 0) goto L_0x0038
            com.paytm.network.model.NetworkResponse r1 = r0.networkResponse
            int r1 = r1.statusCode
            r2 = 401(0x191, float:5.62E-43)
            if (r1 == r2) goto L_0x0036
            com.paytm.network.model.NetworkResponse r1 = r0.networkResponse
            int r1 = r1.statusCode
            r2 = 403(0x193, float:5.65E-43)
            if (r1 == r2) goto L_0x0036
            com.paytm.network.model.NetworkResponse r0 = r0.networkResponse
            int r0 = r0.statusCode
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 != r1) goto L_0x0038
        L_0x0036:
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x0041
            net.one97.paytm.p2b.d.g r0 = r3.w
            r0.e()
            return
        L_0x0041:
            r3.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2b.view.c.h.i():void");
    }

    public final void a(CJRP2BStatus cJRP2BStatus) {
        if (!k.a(getContext())) {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
        } else if (this.s) {
            i.a(getContext(), c.u, c.v, c.w, (String) null);
            this.o.h();
        } else if (this.w != null) {
            h();
        }
        this.x.r = cJRP2BStatus;
    }

    static /* synthetic */ void a(h hVar, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                hVar.o.b(charSequence.toString());
            } catch (NumberFormatException unused) {
            }
        }
    }
}
