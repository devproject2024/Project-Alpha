package net.one97.paytm.p2mNewDesign.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.utils.ad;
import net.one97.paytm.wallet.R;

public final class b extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public g f13227a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.j.a f13228b;

    /* renamed from: d  reason: collision with root package name */
    private Context f13229d;

    /* renamed from: e  reason: collision with root package name */
    private View f13230e;

    /* renamed from: f  reason: collision with root package name */
    private String f13231f;

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f13232g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f13233h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f13234i;
    private InstrumentInfo j;

    public final String a() {
        return "emi";
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        return false;
    }

    public final void b() {
    }

    public final void b(boolean z) {
    }

    public final void i() {
    }

    public b(String str) {
        this.f13231f = str;
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.j = instrumentInfo;
        this.f13229d = context;
        this.f13230e = LayoutInflater.from(this.f13229d).inflate(R.layout.emi_main_container_lyt, (ViewGroup) null, false);
        this.f13230e.setOnClickListener(this);
        this.f13232g = (RadioButton) this.f13230e.findViewById(R.id.rb_instrumentInfo);
        ((TextView) this.f13230e.findViewById(R.id.tv_pay_mode)).setText("EMI");
        this.f13233h = (RoboTextView) this.f13230e.findViewById(R.id.tv_pay_mode);
        this.f13234i = (LinearLayout) this.f13230e.findViewById(R.id.ll_child_view);
        this.f13230e.findViewById(R.id.rl_pay_mode_pg).setOnClickListener(this);
        d(TextUtils.isEmpty(this.f13227a.e()));
        this.f13228b = new net.one97.paytm.p2mNewDesign.j.a(this.f13229d, this.f13227a);
        if (TextUtils.isEmpty(this.f13227a.e()) || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(Double.parseDouble(this.f13227a.e()))) {
            d(this.f13228b.c());
        } else {
            d(true);
        }
        LinearLayout linearLayout = (LinearLayout) this.f13230e.findViewById(R.id.ll_child_view);
        net.one97.paytm.p2mNewDesign.j.a aVar = this.f13228b;
        aVar.f13365b = LayoutInflater.from(aVar.f13364a).inflate(R.layout.emi_home_screen_lyt, (ViewGroup) null, false);
        aVar.f13367d = (LinearLayout) aVar.f13365b.findViewById(R.id.ll_cards);
        aVar.b();
        aVar.f13365b.findViewById(R.id.tv_select_bank).setOnClickListener(aVar);
        aVar.f13365b.findViewById(R.id.tv_select_emi).setOnClickListener(aVar);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q("GIFT_VOUCHER")) {
            aVar.f13365b.setAlpha(0.4f);
        }
        linearLayout.addView(aVar.f13365b);
    }

    public final void a(boolean z) {
        if (z) {
            this.f13230e.performClick();
        } else {
            d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8) {
        /*
            r7 = this;
            r7.f13231f = r8
            java.lang.String r8 = r7.f13231f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = r0.A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = "0"
            goto L_0x0019
        L_0x0013:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = r0.A
        L_0x0019:
            double r0 = java.lang.Double.parseDouble(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            double r2 = r8.doubleValue()
            r8 = 1053609165(0x3ecccccd, float:0.4)
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0041
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = "emi"
            boolean r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r0)
            if (r0 != 0) goto L_0x0046
            android.view.View r0 = r7.f13230e
            r0.setAlpha(r8)
            r0 = 1
            goto L_0x0047
        L_0x0041:
            android.view.View r0 = r7.f13230e
            r0.setAlpha(r5)
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 != 0) goto L_0x0083
            java.lang.String r0 = r7.f13231f
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0059
            r7.f13231f = r0
            net.one97.paytm.p2mNewDesign.j.a r8 = r7.f13228b
            r8.b()
            return
        L_0x0059:
            net.one97.paytm.p2mNewDesign.j.a r1 = r7.f13228b
            int r1 = r1.d()
            net.one97.paytm.utils.ad r2 = net.one97.paytm.utils.ad.EMI_OUT_OF_RANGE
            int r2 = r2.getEMIAvailability()
            if (r1 != r2) goto L_0x0074
            r7.f13231f = r0
            android.view.View r0 = r7.f13230e
            r0.setAlpha(r8)
            net.one97.paytm.p2mNewDesign.j.a r8 = r7.f13228b
            r8.b()
            return
        L_0x0074:
            net.one97.paytm.p2mNewDesign.j.a r8 = r7.f13228b
            r8.a()
            android.view.View r8 = r8.f13365b
            r8.setAlpha(r5)
            r7.f13231f = r0
            r7.d(r4)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.b.b.a(java.lang.String):void");
    }

    public final View c() {
        return this.f13230e;
    }

    public final void onClick(View view) {
        if (view.getId() != R.id.ll_emi_main && view.getId() != R.id.rl_pay_mode_pg) {
            return;
        }
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().L) {
            this.f13227a.f(true);
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q("emi")) {
                RadioButton radioButton = this.f13232g;
                if (radioButton != null) {
                    radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13229d, R.drawable.ic_radio_inactive));
                }
                this.f13227a.a("0".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A) ? this.f13229d.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13229d.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A}), false, false);
                this.f13230e.setAlpha(0.4f);
            } else if (this.f13228b.d() == ad.AMOUNT_NOT_ENTERED.getEMIAvailability()) {
                this.f13230e.setAlpha(0.4f);
                g gVar = this.f13227a;
                Resources resources = this.f13229d.getResources();
                int i2 = R.string.emi_no_amount;
                Object[] objArr = new Object[1];
                objArr[0] = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w() == null ? "" : com.paytm.utility.b.S(String.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w().getValue()));
                gVar.a(String.format(resources.getString(i2, objArr), new Object[0]), true, true);
            } else if (this.f13228b.d() == ad.EMI_OUT_OF_RANGE.getEMIAvailability()) {
                this.f13230e.setAlpha(0.4f);
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w() != null) {
                    this.f13227a.a(String.format(this.f13229d.getString(R.string.emi_range_mismatch, new Object[]{com.paytm.utility.b.S(String.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w().getValue()))}), new Object[0]), true, true);
                }
            } else if (TextUtils.isEmpty(this.f13227a.e()) || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(Double.parseDouble(this.f13227a.e()))) {
                this.f13230e.setAlpha(1.0f);
                RadioButton radioButton2 = this.f13232g;
                if (radioButton2 != null) {
                    radioButton2.setButtonDrawable(androidx.core.content.b.a(this.f13229d, R.drawable.ic_radio_active));
                    this.f13227a.f(true);
                }
                this.f13233h.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                LinearLayout linearLayout = this.f13234i;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                this.f13227a.d("emi");
                InstrumentInfo instrumentInfo = new InstrumentInfo();
                instrumentInfo.setPayMode("emi");
                g gVar2 = this.f13227a;
                if (gVar2 != null) {
                    gVar2.a(instrumentInfo, "updateSelection");
                    this.f13227a.a(instrumentInfo, "sectionClose");
                    this.f13227a.a(instrumentInfo, "uncheck");
                }
            } else {
                this.f13230e.setAlpha(0.4f);
                this.f13227a.a(String.format(this.f13229d.getResources().getString(R.string.emi_no_bank_availble), new Object[0]), false, false);
            }
        }
    }

    public final void a(g gVar) {
        this.f13227a = gVar;
    }

    private void d(boolean z) {
        this.f13230e.setAlpha(z ? 0.4f : 1.0f);
    }

    public final void d() {
        RadioButton radioButton = this.f13232g;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13229d, R.drawable.ic_radio_inactive));
        }
        this.f13233h.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        LinearLayout linearLayout = this.f13234i;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final String e() {
        return this.j.getPriority();
    }

    public final boolean f() {
        if (this.j.getmIsDisabled() == null) {
            return false;
        }
        return this.j.getmIsDisabled().getStatus().booleanValue();
    }

    public final void g() {
        this.f13230e.setAlpha(1.0f);
    }

    public final void h() {
        this.f13230e.setAlpha(0.4f);
    }
}
