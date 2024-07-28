package net.one97.paytm.p2mNewDesign.e.a;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.base.d;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldPortfolio;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.wallet.R;

public final class b extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f13277a = "Gold Controller";

    /* renamed from: b  reason: collision with root package name */
    private View f13278b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f13279d;

    /* renamed from: e  reason: collision with root package name */
    private InstrumentInfo f13280e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13281f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13282g;

    /* renamed from: h  reason: collision with root package name */
    private String f13283h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f13284i;
    private Toast j;
    private RelativeLayout k;
    private g l;
    private TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    private TextView p;
    private String q;
    private boolean r;
    private ImageView s;
    private String t = "";
    private View u;
    /* access modifiers changed from: private */
    public ImageView v;
    private ImageView w;

    public final String a() {
        return "Gold";
    }

    public final void b() {
    }

    public final void i() {
    }

    public final View a(InstrumentInfo instrumentInfo) {
        this.f13280e = instrumentInfo;
        b(instrumentInfo);
        return this.f13278b;
    }

    private void b(InstrumentInfo instrumentInfo) {
        this.f13281f.setText(instrumentInfo.getDisplayPrimaryInfo());
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(instrumentInfo)) {
            this.f13284i.setButtonDrawable(R.drawable.ic_radio_active);
            this.f13281f.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.black));
            this.f13281f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            this.l.f(true);
            this.k.setVisibility(8);
            this.k.setOnClickListener(this);
        }
        this.f13282g.setText(instrumentInfo.getDisplaySecondaryInfo());
        if (!TextUtils.isEmpty(instrumentInfo.getmDisplayPrimaryInfo2())) {
            this.m.setText(Html.fromHtml(instrumentInfo.getmDisplayPrimaryInfo2()));
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
        this.s.setVisibility(0);
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(instrumentInfo.getPayMode()) || this.r || "UPI_ONBOARDING".equalsIgnoreCase(instrumentInfo.getPayMode())) {
            ImageView imageView = this.w;
            if (imageView != null) {
                imageView.setClickable(true);
            }
            this.f13278b.setAlpha(1.0f);
            c(true);
            this.t = "";
            if (!TextUtils.isEmpty(instrumentInfo.getDisplaySecondaryInfo())) {
                this.f13282g.setText(Html.fromHtml(instrumentInfo.getDisplaySecondaryInfo()));
                this.f13282g.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.color_506d85));
            }
            this.m.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.color_506d85));
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(this.f13279d, (ImageView) this.f13278b.findViewById(R.id.iv_card_type), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.f13280e.getPayMode())) {
                this.f13278b.setAlpha(0.4f);
                c(false);
                return;
            }
            return;
        }
        this.f13278b.setAlpha(0.4f);
        c(false);
        this.f13281f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.f13282g.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.color_666666));
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(this.f13279d, (ImageView) this.f13278b.findViewById(R.id.iv_card_type), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        if (this.f13280e.getPayMode().equals(SDKConstants.AI_KEY_PPBL) || this.f13280e.getPayMode().equals("PAYTM_DIGITAL_CREDIT") || this.f13280e.getPayMode().equals("UPI")) {
            this.f13282g.setVisibility(8);
        }
    }

    public final void onClick(View view) {
        String str;
        y<f> yVar;
        int id = view.getId();
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().z = view.getTag() != null ? ((Boolean) view.getTag()).booleanValue() : false;
        if (id == R.id.lyt_paytm_instrument || id == R.id.tv_instrument_secondary_info) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().L) {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().t(this.l.d())) {
                    this.l.n();
                }
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.f13280e.getPayMode())) {
                    this.l.a("0".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A) ? this.f13279d.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13279d.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A}), false, false);
                    return;
                }
                this.f13283h = this.l.d();
                TextView textView = this.f13282g;
                if (textView != null && (textView.getText().equals("") || this.f13282g.getText().equals(this.f13279d.getString(R.string.retry_fetching_balance)))) {
                    d(true);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f13279d));
                    String goldPortFolioURL = net.one97.paytm.wallet.communicator.b.a().getGoldPortFolioURL(this.f13279d);
                    if (TextUtils.isEmpty(goldPortFolioURL)) {
                        str = null;
                    } else {
                        str = goldPortFolioURL + this.q;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        net.one97.paytm.network.a aVar = new net.one97.paytm.network.a(str, new CJRGoldPortfolio(), (Map<String, String>) null, hashMap);
                        if (com.paytm.utility.b.c(this.f13279d)) {
                            yVar = aVar.c();
                            d(true);
                        } else {
                            yVar = d.f49504d.a(this.f13279d, aVar);
                        }
                        if (yVar != null) {
                            yVar.observeForever(new z() {
                                public final void onChanged(Object obj) {
                                    b.this.a((f) obj);
                                }
                            });
                        }
                    }
                } else if (!TextUtils.isEmpty(this.t)) {
                    Toast toast = this.j;
                    if (toast == null || (toast != null && !toast.getView().isShown())) {
                        this.j = Toast.makeText(this.f13279d, this.t, 1);
                        this.j.show();
                    }
                } else {
                    this.f13284i.setChecked(true);
                    this.f13284i.setButtonDrawable(androidx.core.content.b.a(this.f13279d, R.drawable.ic_radio_active));
                    this.l.d("Gold");
                    this.l.f(true);
                    this.f13280e.setUniqueId("Gold");
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.f13280e);
                    this.k.setVisibility(8);
                    this.k.setOnClickListener(this);
                    this.f13281f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    g gVar = this.l;
                    if (gVar != null) {
                        gVar.a(this.f13280e, "updateSelection");
                        this.l.a(this.f13280e, "sectionClose");
                        this.l.a(this.f13280e, "uncheck");
                    }
                }
            } else {
                this.f51247c = false;
            }
        } else if (id == R.id.tv_info_icon) {
            net.one97.paytm.wallet.communicator.b.a().showJewellerPriceAlert(this.f13279d, "payment_method_screen");
        }
    }

    private void d(boolean z) {
        DotProgressBar dotProgressBar = (DotProgressBar) this.f13278b.findViewById(R.id.dot_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
        }
        int i2 = 8;
        this.f13282g.setVisibility(z ? 8 : 0);
        View findViewById = this.f13278b.findViewById(R.id.lyt_fetch_payment_bank_balance);
        if (z) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
    }

    public final void a(boolean z) {
        if (z) {
            this.f13278b.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.f13284i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13279d, R.drawable.ic_radio_inactive));
        }
        this.f13281f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    public final View c() {
        return this.f13278b;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
        if (it2.hasNext()) {
            return "Gold".equalsIgnoreCase(it2.next().f51232b);
        }
        return false;
    }

    public final String e() {
        return this.f13280e.getPriority();
    }

    public final boolean f() {
        if (this.f13280e.getmIsDisabled() == null) {
            return false;
        }
        return this.f13280e.getmIsDisabled().getStatus().booleanValue();
    }

    public final void d() {
        this.f13282g.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.color_506d85));
        this.f13278b.setAlpha(0.4f);
    }

    public final void g() {
        this.f13278b.setAlpha(1.0f);
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.f13278b = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.f13279d = context;
        this.f13280e = instrumentInfo;
        this.f13283h = str;
        this.f13281f = (TextView) this.f13278b.findViewById(R.id.tv_instrument_primary_info);
        this.f13282g = (TextView) this.f13278b.findViewById(R.id.tv_instrument_secondary_info);
        this.p = (TextView) this.f13278b.findViewById(R.id.tv_instrument_secondary_info_ppbl);
        this.m = (TextView) this.f13278b.findViewById(R.id.tv_instrument_primary_info_2);
        this.n = (TextView) this.f13278b.findViewById(R.id.tv_instrument_secondary_info_2);
        this.o = (TextView) this.f13278b.findViewById(R.id.tv_instrument_secondary_info_3);
        this.f13284i = (RadioButton) this.f13278b.findViewById(R.id.rb_instrumentInfo);
        this.k = (RelativeLayout) this.f13278b.findViewById(R.id.rl_proceed_to_pay);
        this.s = (ImageView) this.f13278b.findViewById(R.id.tv_info_icon);
        this.u = this.f13278b.findViewById(R.id.divider);
        this.v = (ImageView) this.f13278b.findViewById(R.id.tv_wallet_arrow);
        this.w = (ImageView) this.f13278b.findViewById(R.id.tv_upi_od);
        this.w.setVisibility(8);
        this.p.setVisibility(8);
        this.v.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.this.o.getVisibility() == 8 && b.this.n.getVisibility() == 8) {
                    b.this.o.setVisibility(0);
                    b.this.n.setVisibility(0);
                    b.this.v.setImageDrawable(androidx.core.content.b.a(b.this.f13279d, R.drawable.ic_p2m_arrowup));
                    return;
                }
                b.this.o.setVisibility(8);
                b.this.n.setVisibility(8);
                b.this.v.setImageDrawable(androidx.core.content.b.a(b.this.f13279d, R.drawable.ic_p2m_arrowdown));
            }
        });
        if (instrumentInfo == null || !instrumentInfo.getPayMode().equalsIgnoreCase("UPI")) {
            this.f13278b.findViewById(R.id.tv_instrument_secondary_info).setClickable(false);
            this.f13278b.findViewById(R.id.tv_instrument_secondary_info).setFocusable(false);
        } else {
            this.f13278b.findViewById(R.id.tv_instrument_secondary_info).setOnClickListener(this);
            this.f13278b.findViewById(R.id.tv_instrument_secondary_info).setClickable(true);
            this.f13278b.findViewById(R.id.tv_instrument_secondary_info).setFocusable(true);
        }
        this.u.setVisibility(0);
        this.f13278b.setOnClickListener(this);
        this.s.setOnClickListener(this);
        b(instrumentInfo);
    }

    public final void b(boolean z) {
        if (!z) {
            RadioButton radioButton = this.f13284i;
            if (radioButton != null) {
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13279d, R.drawable.ic_radio_inactive));
            }
            this.f13281f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
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
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13280e
            java.lang.String r2 = r2.getPayMode()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r2)
            if (r2 != 0) goto L_0x00c2
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            if (r2 == 0) goto L_0x00ac
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13280e
            java.lang.String r2 = r2.getPayMode()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00ac
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.l
            r2.s()
            android.widget.RadioButton r2 = r8.f13284i
            if (r2 == 0) goto L_0x0069
            android.content.Context r3 = r8.f13279d
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
        L_0x0069:
            android.widget.TextView r2 = r8.f13281f
            android.graphics.Typeface r3 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r6)
            r2.setTypeface(r3)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.l
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.A
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x008f
            android.content.Context r1 = r8.f13279d
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r1 = r1.getString(r3)
            goto L_0x00a9
        L_0x008f:
            android.content.Context r1 = r8.f13279d
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
            android.view.View r1 = r8.f13278b
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r1.setAlpha(r2)
            r8.c(r6)
            goto L_0x00c3
        L_0x00b8:
            android.view.View r1 = r8.f13278b
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
            r8.c(r0)
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            if (r0 != 0) goto L_0x00f8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.k
            java.lang.String r1 = r0.getBalance()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00f8
            double r1 = java.lang.Double.parseDouble(r9)
            java.lang.String r3 = r0.getBalance()
            double r3 = java.lang.Double.parseDouble(r3)
            java.lang.String r5 = r8.f13283h
            double r5 = java.lang.Double.parseDouble(r5)
            r8.f13283h = r9
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.b.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            if (iJRPaytmDataModel instanceof CJRGoldPortfolio) {
                CJRGoldPortfolio cJRGoldPortfolio = (CJRGoldPortfolio) iJRPaytmDataModel;
                this.l.c(false);
                double parseDouble = Double.parseDouble(cJRGoldPortfolio.getNetWorth());
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.f13279d, cJRGoldPortfolio);
                this.f13282g.setText(this.f13280e.getDisplaySecondaryInfo());
                this.f13282g.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.color_506d85));
                this.f13282g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                d(false);
                if (Double.valueOf(this.f13283h).doubleValue() > parseDouble) {
                    this.f13278b.setAlpha(0.4f);
                    c(false);
                    return;
                }
                this.f13284i.setChecked(true);
                this.f13281f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                this.f13284i.setButtonDrawable(androidx.core.content.b.a(this.f13279d, R.drawable.ic_radio_active));
                this.l.d("Gold");
                this.l.f(true);
                this.l.a(this.f13280e, "uncheck");
                this.l.a(this.f13280e, "updateSelection");
            }
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            net.one97.paytm.p2mNewDesign.b.a.class.getSimpleName();
            q.d(gVar.f55801c.getMessage());
            d(false);
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!this.l.a("gold_balance_api", bundle, fVar.f55798c.f55801c)) {
                NetworkCustomError networkCustomError = gVar.f55801c;
                if (networkCustomError.getFullUrl().equals(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13279d, UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW))) {
                    d(false);
                    this.f13282g.setVisibility(0);
                    this.f13282g.setTextColor(androidx.core.content.b.c(this.f13279d, R.color.color_00b9f5));
                    this.f13282g.setText(this.f13279d.getString(R.string.retry_fetching_balance));
                    this.f13282g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f13279d.getResources().getDrawable(R.drawable.refresh_icon), (Drawable) null);
                } else if (networkCustomError.getFullUrl().contains(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13279d, "pgWalletBalanceURL"))) {
                    Context context = this.f13279d;
                    Toast.makeText(context, context.getString(R.string.unable_to_fetch_paytm_wallet_p2m), 1).show();
                }
            }
        }
    }
}
