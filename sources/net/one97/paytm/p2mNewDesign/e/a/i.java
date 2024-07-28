package net.one97.paytm.p2mNewDesign.e.a;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.utility.j;

public final class i extends a implements View.OnClickListener {
    private static String o = "home/pay-send/post-scan";

    /* renamed from: a  reason: collision with root package name */
    String f13352a = "Wallet Controller";

    /* renamed from: b  reason: collision with root package name */
    private View f13353b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f13354d;

    /* renamed from: e  reason: collision with root package name */
    private InstrumentInfo f13355e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13356f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13357g;

    /* renamed from: h  reason: collision with root package name */
    private String f13358h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f13359i;
    private g j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    private View m;
    /* access modifiers changed from: private */
    public ImageView n;

    public final String a() {
        return "BALANCE";
    }

    public final void b() {
    }

    public final void i() {
    }

    public final View a(InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str) {
        this.f13355e = instrumentInfo;
        this.f13358h = str;
        a(instrumentInfo, instrumentInfo2);
        return this.f13353b;
    }

    private void a(InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2) {
        this.f13356f.setText(instrumentInfo.getDisplayPrimaryInfo());
        d(this.j.t());
        b.f();
        b.a(this.f13354d, (ImageView) this.f13353b.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        if (TextUtils.isEmpty(b.f().f13087c.getTotalBalance()) || Double.valueOf(b.f().f13087c.getTotalBalance()).doubleValue() >= Double.valueOf(this.f13358h).doubleValue()) {
            this.f13357g.setText(instrumentInfo.getDisplaySecondaryInfo());
            this.k.setText(instrumentInfo.getmDisplaythirdInfo());
            b.f().n(instrumentInfo.getPayMode());
            if (instrumentInfo2 == null) {
                this.n.setVisibility(8);
                this.l.setVisibility(8);
                this.k.setVisibility(8);
            } else if (!TextUtils.isEmpty(instrumentInfo2.getBalance()) && Double.valueOf(instrumentInfo2.getBalance()).doubleValue() > 0.0d) {
                this.n.setVisibility(0);
                this.l.setText(instrumentInfo2.getmDisplaythirdInfo());
            }
        } else {
            TextView textView = this.f13357g;
            textView.setText(this.f13354d.getString(R.string.addnpay_intermediate_title) + " " + this.f13354d.getString(R.string.rupee_symbol) + " " + b.f().f13087c.getTotalBalance());
            this.f13357g.setTextColor(androidx.core.content.b.c(this.f13354d, R.color.color_ffa400));
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
        if (b.f().d(instrumentInfo.getPayMode()) || !b.f().w || !b.f().f13087c.isAllPaymodeFetched()) {
            b(this.f13358h);
            return;
        }
        this.f13353b.setAlpha(0.4f);
        c(false);
        this.f13356f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.f13359i.setButtonDrawable(R.drawable.ic_radio_inactive);
        this.j.s();
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id != R.id.lyt_paytm_instrument && id != R.id.tv_instrument_secondary_info) {
            return;
        }
        if (b.f().J == null || b.f().H == null || !b.f().L) {
            a("offline_payments", "post_scan_wallet_selected", b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", this.f13354d, o);
            this.f13358h = this.j.d();
            if (b.f().t(this.j.d())) {
                this.j.n();
            }
            b.f();
            if (!b.q(this.f13355e.getPayMode())) {
                this.j.a("0".equalsIgnoreCase(b.f().A) ? this.f13354d.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13354d.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
            } else if (b.f().w && ((!b.f().w || b.f().x) && this.f13355e != null && !b.f().d(this.f13355e.getPayMode()))) {
                Context context = this.f13354d;
                Toast.makeText(context, this.f13354d.getString(R.string.merchant_doesnt_support_instrunment) + " " + this.f13355e.getDisplayPrimaryInfo(), 0).show();
            } else if (!b.f().s(this.f13358h) || !b.f().E()) {
                if (b.f().f13087c != null) {
                    if (b.f().r(this.f13358h) && !TextUtils.isEmpty(b.f().f13087c.getTotalBalance())) {
                        g();
                        this.j.a(this.f13354d.getString(R.string.insufficient_wallet_balance_p2m), false, false);
                        if (b.f().n != null && "BALANCE".equalsIgnoreCase(b.f().n.getPayMode())) {
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(b.f().f13087c.getBalance())) {
                        b(this.f13358h);
                    }
                }
                this.f13359i.setChecked(true);
                this.f13359i.setButtonDrawable(androidx.core.content.b.a(this.f13354d, R.drawable.ic_radio_active));
                this.f13356f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                this.j.d("BALANCE");
                this.j.f(true);
                if (this.j != null) {
                    this.f13355e.setUniqueId("BALANCE");
                    this.j.a(this.f13355e, "updateSelection");
                    this.j.a(this.f13355e, "sectionClose");
                }
            } else {
                this.j.a(this.f13354d.getString(R.string.insufficient_wallet_balance_p2m_merchant_fail), false, false);
            }
        } else {
            this.f51247c = false;
        }
    }

    public final void a(g gVar) {
        this.j = gVar;
    }

    public final void b(String str) {
        InstrumentInfo instrumentInfo = b.f().f13087c;
        if (instrumentInfo != null && !instrumentInfo.isDummyWalletView() && instrumentInfo.isAllPaymodeFetched()) {
            if (!b.f().s(str) || TextUtils.isEmpty(str)) {
                this.f13353b.setAlpha(1.0f);
                c(true);
                this.f13357g.setText(b.f().f13087c.getDisplaySecondaryInfo());
                this.f13357g.setTextColor(androidx.core.content.b.c(this.f13354d, R.color.color_506d85));
            } else {
                a("offline_payments", "post_scan_wallet_insufficient_balance_selected", b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", this.f13354d, o);
                if (b.f().E()) {
                    g();
                    return;
                } else if (b.f().r(str) || Double.compare(Double.parseDouble(str), j.f72322a.doubleValue()) == 1) {
                    g();
                    return;
                } else {
                    this.f13353b.setAlpha(1.0f);
                    c(true);
                    TextView textView = this.f13357g;
                    textView.setText(this.f13354d.getString(R.string.addnpay_intermediate_title) + " " + this.f13354d.getString(R.string.rupee_symbol) + " " + b.f().f13087c.getTotalBalance());
                    this.f13357g.setTextColor(androidx.core.content.b.c(this.f13354d, R.color.color_ffa400));
                }
            }
            b.f();
            if (!b.q(this.f13355e.getPayMode())) {
                this.f13353b.setAlpha(0.4f);
                c(false);
                return;
            }
            this.f13353b.setAlpha(1.0f);
        }
    }

    public final void d() {
        if (b.f().L) {
            this.f51247c = false;
            return;
        }
        this.f13357g.setText(b.f().f13087c.getDisplaySecondaryInfo());
        this.f13357g.setTextColor(androidx.core.content.b.c(this.f13354d, R.color.color_506d85));
        this.f13353b.setAlpha(1.0f);
    }

    public final void g() {
        this.f13357g.setText(b.f().f13087c.getDisplaySecondaryInfo());
        this.f13357g.setTextColor(androidx.core.content.b.c(this.f13354d, R.color.color_506d85));
        this.f13353b.setAlpha(0.4f);
        c(false);
    }

    public final void d(boolean z) {
        DotProgressBar dotProgressBar = (DotProgressBar) this.f13353b.findViewById(R.id.dot_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
        }
        int i2 = 8;
        this.f13357g.setVisibility(z ? 8 : 0);
        View findViewById = this.f13353b.findViewById(R.id.lyt_fetch_payment_bank_balance);
        if (z) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
    }

    public final void a(boolean z) {
        if (z) {
            this.f13353b.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.f13359i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13354d, R.drawable.ic_radio_inactive));
        }
        this.f13356f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9) {
        /*
            r8 = this;
            r8.f13358h = r9
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = r0.A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "0"
            if (r0 == 0) goto L_0x0012
            r0 = r1
            goto L_0x0018
        L_0x0012:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = r0.A
        L_0x0018:
            double r2 = java.lang.Double.parseDouble(r0)
            java.lang.Double r0 = java.lang.Double.valueOf(r9)
            double r4 = r0.doubleValue()
            r0 = 1
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ba
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13355e
            java.lang.String r2 = r2.getPayMode()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r2)
            if (r2 != 0) goto L_0x00c4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            if (r2 == 0) goto L_0x00ae
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13355e
            java.lang.String r2 = r2.getPayMode()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00ae
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.j
            r2.s()
            android.widget.RadioButton r2 = r8.f13359i
            if (r2 == 0) goto L_0x006b
            android.content.Context r3 = r8.f13354d
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
        L_0x006b:
            android.widget.TextView r2 = r8.f13356f
            android.graphics.Typeface r3 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r6)
            r2.setTypeface(r3)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.j
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.A
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0091
            android.content.Context r1 = r8.f13354d
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r1 = r1.getString(r3)
            goto L_0x00ab
        L_0x0091:
            android.content.Context r1 = r8.f13354d
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg_with_amount_new
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.A
            r3[r6] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
        L_0x00ab:
            r2.a(r1, r6, r6)
        L_0x00ae:
            android.view.View r1 = r8.f13353b
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r1.setAlpha(r2)
            r8.c(r6)
            goto L_0x00c5
        L_0x00ba:
            android.view.View r1 = r8.f13353b
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
            r8.c(r0)
        L_0x00c4:
            r0 = 0
        L_0x00c5:
            if (r0 != 0) goto L_0x00ca
            r8.b((java.lang.String) r9)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.i.a(java.lang.String):void");
    }

    public final View c() {
        return this.f13353b;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
        if (it2.hasNext()) {
            return "BALANCE".equalsIgnoreCase(it2.next().f51232b);
        }
        return false;
    }

    public final String e() {
        return this.f13355e.getPriority();
    }

    public final boolean f() {
        if (this.f13355e.getmIsDisabled() == null) {
            return false;
        }
        return this.f13355e.getmIsDisabled().getStatus().booleanValue();
    }

    public final void h() {
        this.f13353b.setAlpha(1.0f);
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.f13353b = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.f13354d = context;
        this.f13355e = instrumentInfo;
        this.f13358h = str;
        this.f13356f = (TextView) this.f13353b.findViewById(R.id.tv_instrument_primary_info);
        this.f13357g = (TextView) this.f13353b.findViewById(R.id.tv_instrument_secondary_info);
        this.k = (TextView) this.f13353b.findViewById(R.id.tv_instrument_secondary_info_2);
        this.l = (TextView) this.f13353b.findViewById(R.id.tv_instrument_secondary_info_3);
        this.f13359i = (RadioButton) this.f13353b.findViewById(R.id.rb_instrumentInfo);
        this.m = this.f13353b.findViewById(R.id.divider);
        this.n = (ImageView) this.f13353b.findViewById(R.id.tv_wallet_arrow);
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (i.this.l.getVisibility() == 8 && i.this.k.getVisibility() == 8) {
                    i.this.l.setVisibility(0);
                    i.this.k.setVisibility(0);
                    i.this.n.setImageDrawable(androidx.core.content.b.a(i.this.f13354d, R.drawable.ic_p2m_arrowup));
                    return;
                }
                i.this.l.setVisibility(8);
                i.this.k.setVisibility(8);
                i.this.n.setImageDrawable(androidx.core.content.b.a(i.this.f13354d, R.drawable.ic_p2m_arrowdown));
            }
        });
        this.m.setVisibility(0);
        this.f13353b.setOnClickListener(this);
        a(instrumentInfo, instrumentInfo2);
    }

    public final void b(boolean z) {
        if (!z) {
            RadioButton radioButton = this.f13359i;
            if (radioButton != null) {
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13354d, R.drawable.ic_radio_inactive));
            }
            this.f13356f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
    }
}
