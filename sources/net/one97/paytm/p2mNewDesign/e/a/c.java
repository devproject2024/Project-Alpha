package net.one97.paytm.p2mNewDesign.e.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.CJRPGInstrumentBalance;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.PostpaidBalanceInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.wallet.R;

public class c extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f13286a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public int f13287b = 0;

    /* renamed from: d  reason: collision with root package name */
    private View f13288d;

    /* renamed from: e  reason: collision with root package name */
    private Context f13289e;

    /* renamed from: f  reason: collision with root package name */
    private InstrumentInfo f13290f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13291g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13292h;

    /* renamed from: i  reason: collision with root package name */
    private String f13293i;
    private RadioButton j;
    private g k;
    private TextView l;
    private View m;
    private final int n = 6;
    private String o;

    public final String a() {
        return "GIFT_VOUCHER";
    }

    public final void b() {
    }

    public final void i() {
    }

    public final View a(InstrumentInfo instrumentInfo) {
        this.f13290f = instrumentInfo;
        b(instrumentInfo);
        return this.f13288d;
    }

    private void b(InstrumentInfo instrumentInfo) {
        this.f13291g.setText(instrumentInfo.getDisplayPrimaryInfo());
        if (b.f().b(instrumentInfo) && b.f().d(instrumentInfo.getPayMode())) {
            this.j.setButtonDrawable(R.drawable.ic_radio_active);
            this.f13291g.setTextColor(androidx.core.content.b.c(this.f13289e, R.color.black));
            this.f13291g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        }
        this.f13292h.setText(instrumentInfo.getDisplaySecondaryInfo());
        if (!b.f().d(instrumentInfo.getPayMode())) {
            this.f13288d.setAlpha(0.4f);
            c(false);
            this.f13291g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            this.f13292h.setTextColor(androidx.core.content.b.c(this.f13289e, R.color.color_666666));
            b.f();
            b.a(this.f13289e, (ImageView) this.f13288d.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
            if (this.f13290f.getPayMode().equals(SDKConstants.AI_KEY_PPBL) || this.f13290f.getPayMode().equals("PAYTM_DIGITAL_CREDIT") || this.f13290f.getPayMode().equals("UPI")) {
                this.f13292h.setVisibility(8);
                return;
            }
            return;
        }
        b.f();
        b.a(this.f13289e, (ImageView) this.f13288d.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        d(this.f13293i);
        ((ImageView) this.f13288d.findViewById(R.id.iv_card_type)).setImageDrawable(this.f13289e.getResources().getDrawable(R.drawable.ic_gv));
        b.f();
        if (!b.q(this.f13290f.getPayMode())) {
            this.f13288d.setAlpha(0.4f);
            c(false);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        b.f().z = view.getTag() != null ? ((Boolean) view.getTag()).booleanValue() : false;
        if (id != R.id.lyt_paytm_instrument && id != R.id.tv_instrument_secondary_info) {
            return;
        }
        if (b.f().J == null || b.f().H == null || !b.f().L) {
            if (b.f().t(this.k.d())) {
                this.k.n();
            }
            b.f();
            if (!b.q(this.f13290f.getPayMode())) {
                this.k.a("0".equalsIgnoreCase(b.f().A) ? this.f13289e.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13289e.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
                return;
            }
            this.f13293i = this.k.d();
            if (this.f13290f == null || b.f().d(this.f13290f.getPayMode())) {
                this.j.setChecked(true);
                this.j.setButtonDrawable(androidx.core.content.b.a(this.f13289e, R.drawable.ic_radio_active));
                this.k.f(true);
                this.k.d("GIFT_VOUCHER");
                this.f13291g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                g gVar = this.k;
                if (gVar != null) {
                    gVar.a(this.f13290f, "uncheck");
                    this.k.a(this.f13290f, "updateSelection");
                    this.k.a(this.f13290f, "sectionClose");
                    return;
                }
                return;
            }
            Context context = this.f13289e;
            Toast.makeText(context, this.f13289e.getString(R.string.merchant_doesnt_support_instrunment) + " " + this.f13290f.getDisplayPrimaryInfo(), 0).show();
            return;
        }
        this.f51247c = false;
    }

    private void h() {
        DotProgressBar dotProgressBar = (DotProgressBar) this.f13288d.findViewById(R.id.dot_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
        }
        this.f13292h.setVisibility(0);
        this.f13288d.findViewById(R.id.lyt_fetch_payment_bank_balance).setVisibility(8);
    }

    public final void a(g gVar) {
        this.k = gVar;
    }

    private void d(String str) {
        if (b.f().l != null) {
            if (TextUtils.isEmpty(b.f().l.getTotalBalance()) || Double.valueOf(b.f().l.getTotalBalance()).doubleValue() >= Double.valueOf(str).doubleValue()) {
                this.f13292h.setText(b.f().l.getDisplaySecondaryInfo());
                this.f13292h.setTextColor(androidx.core.content.b.c(this.f13289e, R.color.color_506d85));
                return;
            }
            TextView textView = this.f13292h;
            textView.setText(this.f13289e.getString(R.string.insufficient_gv_balance) + " " + this.f13289e.getString(R.string.rupee_symbol) + " " + b.f().l.getTotalBalance());
            this.f13292h.setTextColor(androidx.core.content.b.c(this.f13289e, R.color.color_ffa400));
        }
    }

    public final void b(String str) {
        int i2 = this.f13287b;
        if (i2 < 6) {
            this.f13287b = i2 + 1;
            a(str, true);
            return;
        }
        g gVar = this.k;
        if (gVar != null) {
            gVar.a(this.f13289e.getString(R.string.unable_to_add_balance_in_gv), false, false);
        }
        h();
    }

    public final void a(String str, boolean z) {
        LiveData<f> a2 = this.k.a(str, this.f13289e, this.o, z);
        if (a2 != null) {
            a2.observeForever(new z(str, z) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onChanged(Object obj) {
                    c.this.a(this.f$1, this.f$2, (f) obj);
                }
            });
        }
    }

    public final void c(String str) {
        this.o = str;
    }

    public final void a(boolean z) {
        if (z) {
            this.f13288d.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.j;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13289e, R.drawable.ic_radio_inactive));
        }
        this.f13291g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    public final View c() {
        return this.f13288d;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
        if (it2.hasNext()) {
            return "GIFT_VOUCHER".equalsIgnoreCase(it2.next().f51232b);
        }
        return false;
    }

    public final String e() {
        return this.f13290f.getPriority();
    }

    public final boolean f() {
        if (this.f13290f.getmIsDisabled() == null) {
            return false;
        }
        return this.f13290f.getmIsDisabled().getStatus().booleanValue();
    }

    public final void d() {
        this.f13292h.setTextColor(androidx.core.content.b.c(this.f13289e, R.color.color_506d85));
        this.f13288d.setAlpha(0.4f);
    }

    public final void g() {
        this.f13288d.setAlpha(1.0f);
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.f13288d = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.f13289e = context;
        this.f13290f = instrumentInfo;
        this.f13293i = str;
        this.f13291g = (TextView) this.f13288d.findViewById(R.id.tv_instrument_primary_info);
        this.f13292h = (TextView) this.f13288d.findViewById(R.id.tv_instrument_secondary_info);
        this.l = (TextView) this.f13288d.findViewById(R.id.tv_instrument_secondary_info_ppbl);
        this.j = (RadioButton) this.f13288d.findViewById(R.id.rb_instrumentInfo);
        this.m = this.f13288d.findViewById(R.id.divider);
        this.l.setVisibility(8);
        this.f13288d.findViewById(R.id.tv_instrument_secondary_info).setClickable(false);
        this.f13288d.findViewById(R.id.tv_instrument_secondary_info).setFocusable(false);
        this.m.setVisibility(0);
        this.f13288d.setOnClickListener(this);
        b(instrumentInfo);
    }

    public final void b(boolean z) {
        if (!z) {
            RadioButton radioButton = this.j;
            if (radioButton != null) {
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13289e, R.drawable.ic_radio_inactive));
            }
            this.f13291g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9) {
        /*
            r8 = this;
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = r0.A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "0"
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0016
        L_0x0010:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r0 = r0.A
        L_0x0016:
            double r2 = java.lang.Double.parseDouble(r0)
            java.lang.Double r0 = java.lang.Double.valueOf(r9)
            double r4 = r0.doubleValue()
            r0 = 1
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x00b8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13290f
            java.lang.String r2 = r2.getPayMode()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r2)
            if (r2 != 0) goto L_0x00c2
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            if (r2 == 0) goto L_0x00ac
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13290f
            java.lang.String r2 = r2.getPayMode()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00ac
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.k
            r2.s()
            android.widget.RadioButton r2 = r8.j
            if (r2 == 0) goto L_0x0069
            android.content.Context r3 = r8.f13289e
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
        L_0x0069:
            android.widget.TextView r2 = r8.f13291g
            android.graphics.Typeface r3 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r6)
            r2.setTypeface(r3)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.k
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.A
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x008f
            android.content.Context r1 = r8.f13289e
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r1 = r1.getString(r3)
            goto L_0x00a9
        L_0x008f:
            android.content.Context r1 = r8.f13289e
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg_with_amount_new
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.A
            r3[r6] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
        L_0x00a9:
            r2.a(r1, r6, r6)
        L_0x00ac:
            android.view.View r1 = r8.f13288d
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r1.setAlpha(r2)
            r8.c(r6)
            goto L_0x00c3
        L_0x00b8:
            android.view.View r1 = r8.f13288d
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
            r8.c(r0)
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            if (r0 != 0) goto L_0x00f8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.l
            java.lang.String r1 = r0.getBalance()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00f8
            double r1 = java.lang.Double.parseDouble(r9)
            java.lang.String r3 = r0.getBalance()
            double r3 = java.lang.Double.parseDouble(r3)
            java.lang.String r5 = r8.f13293i
            double r5 = java.lang.Double.parseDouble(r5)
            r8.f13293i = r9
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x00f1
            r8.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)
            return
        L_0x00f1:
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x00f8
            r8.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.c.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, boolean z, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (str.equalsIgnoreCase("GIFT_VOUCHER")) {
                CJRPGInstrumentBalance cJRPGInstrumentBalance = (CJRPGInstrumentBalance) fVar.f55797b;
                if (!z || !cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue().equals(b.f().l.getBalance())) {
                    this.k.c(false);
                    h();
                    if (cJRPGInstrumentBalance.getBody() != null && cJRPGInstrumentBalance.getBody().getResultInfo() != null && AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getResultInfo().getResultStatus())) {
                        String resultMsg = cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                        g gVar = this.k;
                        if (TextUtils.isEmpty(resultMsg)) {
                            resultMsg = this.f13289e.getString(R.string.p2m_unabletofetch_balance);
                        }
                        gVar.a(resultMsg, false, false);
                    } else if (cJRPGInstrumentBalance.getBody() == null || cJRPGInstrumentBalance.getBody().getBalanceInfo() == null || TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue())) {
                        String resultMsg2 = cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                        g gVar2 = this.k;
                        if (TextUtils.isEmpty(resultMsg2)) {
                            resultMsg2 = this.f13289e.getString(R.string.p2m_unabletofetch_balance);
                        }
                        gVar2.a(resultMsg2, false, false);
                    } else {
                        b f2 = b.f();
                        if (!(f2.l == null || cJRPGInstrumentBalance == null || cJRPGInstrumentBalance.getBody() == null)) {
                            if ((cJRPGInstrumentBalance.getBody().getDetailedBalanceInfo() == null || cJRPGInstrumentBalance.getBody().getDetailedBalanceInfo().size() == 0) && cJRPGInstrumentBalance.getBody().getBalanceInfo() != null) {
                                f2.l.setBalance(String.valueOf(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()));
                                f2.l.setTotalBalance(String.valueOf(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()));
                                f2.l.setDisplaySecondaryInfo(String.format(net.one97.paytm.wallet.communicator.b.a().getContext().getString(R.string.p2m_available_for_baln), new Object[]{String.valueOf(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue())}));
                            } else {
                                Iterator<PostpaidBalanceInfo> it2 = cJRPGInstrumentBalance.getBody().getDetailedBalanceInfo().iterator();
                                while (it2.hasNext()) {
                                    PostpaidBalanceInfo next = it2.next();
                                    if (next.getTemplateId().equalsIgnoreCase(b.f().l.getTempleteId())) {
                                        f2.l.setBalance(next.getValue());
                                        f2.l.setTotalBalance(next.getValue());
                                        f2.l.setDisplaySecondaryInfo(String.format(net.one97.paytm.wallet.communicator.b.a().getContext().getString(R.string.p2m_available_for_baln), new Object[]{next.getValue()}));
                                    }
                                }
                            }
                        }
                        this.f13290f = b.f().l;
                        d(this.k.d());
                        h();
                        this.k.a(this.f13290f, "updateSelection");
                    }
                } else {
                    b("GIFT_VOUCHER");
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar3 = fVar.f55798c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (this.k.a("generic_api_call_fail", bundle, gVar3.f55801c)) {
                h();
            } else if (str.equalsIgnoreCase("GIFT_VOUCHER")) {
                Toast.makeText(this.f13289e, "Unable to fetch balance", 1).show();
                c.class.getSimpleName();
                q.d(gVar3.f55801c.getMessage());
                h();
                if (z) {
                    b("GIFT_VOUCHER");
                }
            }
        }
    }
}
