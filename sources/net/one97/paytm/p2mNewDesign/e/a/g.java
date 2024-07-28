package net.one97.paytm.p2mNewDesign.e.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.CJRPGInstrumentBalance;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.utility.j;

public class g extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    String f13334a = "UPIInstrumentController";

    /* renamed from: b  reason: collision with root package name */
    public InstrumentInfo f13335b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f13336d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f13337e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13338f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f13339g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f13340h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f13341i;
    private Toast j;
    /* access modifiers changed from: private */
    public net.one97.paytm.p2mNewDesign.f.g k;
    private TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    private String p;
    private View q;
    /* access modifiers changed from: private */
    public Activity r;
    /* access modifiers changed from: private */
    public ImageView s;
    /* access modifiers changed from: private */
    public ImageView t;
    /* access modifiers changed from: private */
    public boolean u = false;

    public final void b() {
    }

    public final void i() {
    }

    public final View a(InstrumentInfo instrumentInfo) {
        this.f13335b = instrumentInfo;
        b(instrumentInfo);
        return this.f13336d;
    }

    private void b(InstrumentInfo instrumentInfo) {
        this.f13338f.setText(instrumentInfo.getDisplayPrimaryInfo());
        if (b.f().b(instrumentInfo) && b.f().d(instrumentInfo.getPayMode())) {
            this.f13341i.setButtonDrawable(R.drawable.ic_radio_active);
            this.f13338f.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.black));
            this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        }
        this.f13339g.setText(instrumentInfo.getDisplaySecondaryInfo());
        this.l.setVisibility(8);
        this.o.setText(instrumentInfo.getmDisplayPrimaryInfo2());
        this.o.setVisibility(8);
        TextView textView = this.f13339g;
        if (textView == null || (!textView.getText().equals(this.f13337e.getString(R.string.check_balance)) && !this.f13339g.getText().equals(this.f13337e.getString(R.string.retry_fetching_balance)))) {
            this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_506d85));
        } else {
            this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_00b9f5));
        }
        if (!b.f().d(instrumentInfo.getPayMode())) {
            this.f13336d.setAlpha(0.4f);
            c(false);
            this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_666666));
            b.f();
            b.a(this.f13337e, (ImageView) this.f13336d.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
            if (this.f13335b.getPayMode().equals(SDKConstants.AI_KEY_PPBL) || this.f13335b.getPayMode().equals("PAYTM_DIGITAL_CREDIT") || this.f13335b.getPayMode().equals("UPI")) {
                this.f13339g.setVisibility(8);
                return;
            }
            return;
        }
        this.f13336d.setAlpha(1.0f);
        c(true);
        if (!TextUtils.isEmpty(this.f13335b.getBalance()) && Double.valueOf(this.f13335b.getBalance()).doubleValue() < Double.valueOf(this.f13340h).doubleValue()) {
            this.f13336d.setAlpha(0.4f);
            c(false);
            ImageView imageView = this.t;
            if (imageView != null) {
                imageView.setClickable(false);
            }
            this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_666666));
        }
        b.f();
        b.a(this.f13337e, (ImageView) this.f13336d.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        w.a().a(UpiRequestBuilder.getBankIconUrl(this.f13337e, b.f().l(instrumentInfo.getAccountNumber()).getIfsc())).b(R.drawable.ic_bhim).a((ImageView) this.f13336d.findViewById(R.id.iv_card_type), (e) null);
        b.f();
        if (!b.q(this.f13335b.getPayMode())) {
            this.f13336d.setAlpha(0.4f);
            c(false);
        } else if (instrumentInfo.isBlocked()) {
            this.f13336d.setAlpha(0.4f);
            c(false);
            this.k.s();
        } else {
            this.f13336d.setAlpha(1.0f);
        }
    }

    private void k() {
        RadioButton radioButton = this.f13341i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13337e, R.drawable.ic_radio_inactive));
        }
        this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    public void onClick(View view) {
        boolean z;
        TextView textView;
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
            if (!b.q(this.f13335b.getPayMode())) {
                this.k.a("0".equalsIgnoreCase(b.f().A) ? this.f13337e.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13337e.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
                return;
            }
            if (this.f13335b.isBlocked()) {
                this.k.a(!TextUtils.isEmpty(this.f13335b.getBlockMessage()) ? this.f13335b.getBlockMessage() : this.f13337e.getString(R.string.p2m_retry_generic_msg), false, false);
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (id == R.id.tv_instrument_secondary_info && (textView = this.f13339g) != null && (textView.getText().equals(this.f13337e.getString(R.string.check_balance)) || this.f13339g.getText().equals(this.f13337e.getString(R.string.retry_fetching_balance)))) {
                    d(true);
                    BankAccountDetails.BankAccount l2 = b.f().l(this.f13335b.getAccountNumber());
                    if (!l2.getMbeba().equals("Y")) {
                        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                        upiProfileDefaultBank.setVirtualAddress(this.f13335b.getmDisplaythirdInfo());
                        upiProfileDefaultBank.setDebitBank(l2);
                        net.one97.paytm.wallet.communicator.b.a().startSetMpinActivity(upiProfileDefaultBank, (Activity) this.f13337e);
                    } else if (this.f13337e.getString(R.string.paytm_payment_bank_account).equalsIgnoreCase(l2.getBankName()) || l2.getIfsc().contains("PYTM")) {
                        LiveData<f> a2 = this.k.a(SDKConstants.AI_KEY_PPBL, this.f13337e, this.p, false);
                        if (a2 != null) {
                            a2.observeForever(new z(SDKConstants.AI_KEY_PPBL) {
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onChanged(Object obj) {
                                    g.this.a(this.f$1, (f) obj);
                                }
                            });
                        }
                    } else {
                        a(b.f().m(this.f13335b.getAccountNumber()));
                    }
                }
                this.f13340h = this.k.d();
                if (this.f13335b != null && !b.f().d(this.f13335b.getPayMode())) {
                    Context context = this.f13337e;
                    Toast.makeText(context, this.f13337e.getString(R.string.merchant_doesnt_support_instrunment) + " " + this.f13335b.getDisplayPrimaryInfo(), 0).show();
                } else if (TextUtils.isEmpty(this.f13340h) || TextUtils.isEmpty(this.f13335b.getBalance()) || Double.valueOf(this.f13340h).doubleValue() <= Double.valueOf(this.f13335b.getBalance()).doubleValue()) {
                    a("offline_payments", "post_scan_upi_selected", b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", this.f13337e, "home/pay-send/post-scan");
                    this.f13341i.setChecked(true);
                    this.f13341i.setButtonDrawable(androidx.core.content.b.a(this.f13337e, R.drawable.ic_radio_active));
                    if (this.k != null) {
                        this.f13335b.setUniqueId(a());
                        this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                        this.k.d(a());
                        this.k.f(true);
                        this.k.a(this.f13335b, "uncheck");
                        this.k.a(this.f13335b, "updateSelection");
                        this.k.a(this.f13335b, "sectionClose");
                    }
                } else {
                    Toast toast = this.j;
                    if (toast == null || (toast != null && !toast.getView().isShown())) {
                        Context context2 = this.f13337e;
                        this.j = Toast.makeText(context2, context2.getString(R.string.insufficient_balance_upi), 1);
                        this.j.show();
                    }
                }
            }
        } else {
            this.f51247c = false;
        }
    }

    public final void d(boolean z) {
        DotProgressBar dotProgressBar = (DotProgressBar) this.f13336d.findViewById(R.id.dot_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
        }
        int i2 = 8;
        this.f13339g.setVisibility(z ? 8 : 0);
        View findViewById = this.f13336d.findViewById(R.id.lyt_fetch_payment_bank_balance);
        if (z) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
    }

    public final void a(net.one97.paytm.p2mNewDesign.f.g gVar) {
        this.k = gVar;
    }

    public final InstrumentInfo d() {
        return this.f13335b;
    }

    public final void b(String str) {
        this.p = str;
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (upiProfileDefaultBank == null) {
            d(false);
        } else {
            new UPICheckBalanceHelper.UPICheckBalanceBuilder(this.r, new n.c() {
                public final void Z_() {
                    g.this.d(true);
                }

                public final void b() {
                    g.this.d(false);
                }

                public final void a(String str, String str2, String str3) {
                    g.this.d(false);
                    b f2 = b.f();
                    Context a2 = g.this.f13337e;
                    double parseDouble = Double.parseDouble(str2);
                    String charSequence = g.this.o.getText().toString();
                    if (f2.m != null) {
                        for (InstrumentInfo next : f2.m) {
                            if (next.getmDisplayPrimaryInfo2().equalsIgnoreCase(charSequence)) {
                                if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                                    next.setDisplaySecondaryInfo(String.format(net.one97.paytm.wallet.utility.a.a(a2, R.string.credit_limit_bal), new Object[]{str}));
                                    next.setAccountType(str3);
                                    next.setmDisplaySecondaryInfo2(String.format(net.one97.paytm.wallet.utility.a.a(a2, R.string.balance_without_format_v2), new Object[]{com.paytm.utility.b.S(String.valueOf(parseDouble))}));
                                    next.setBalance(str);
                                } else {
                                    next.setBalance(Double.toString(parseDouble));
                                    next.setDisplaySecondaryInfo(String.format(net.one97.paytm.wallet.utility.a.a(a2, R.string.balance_without_format_v2), new Object[]{com.paytm.utility.b.S(String.valueOf(parseDouble))}));
                                }
                                next.setAccountType(str3);
                            }
                        }
                    }
                    boolean unused = g.this.u = true;
                    if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
                        if (Double.valueOf(g.this.f13340h).doubleValue() > Double.parseDouble(str)) {
                            g.this.f13336d.setAlpha(0.4f);
                            g.this.c(false);
                            g.this.k.s();
                        } else {
                            g.this.t.setVisibility(8);
                        }
                        g.this.f13339g.setVisibility(0);
                        g.this.f13339g.setText(g.this.f13335b.getDisplaySecondaryInfo());
                        g.this.f13339g.setTextColor(androidx.core.content.b.c(g.this.f13337e, R.color.color_506d85));
                        g.this.o.setVisibility(8);
                        g.this.m.setVisibility(0);
                        g.this.m.setText(g.this.f13335b.getmDisplaySecondaryInfo2());
                        g.this.m.setTextColor(androidx.core.content.b.c(g.this.f13337e, R.color.color_506d85));
                        return;
                    }
                    if (Double.valueOf(g.this.f13340h).doubleValue() > Double.parseDouble(str2)) {
                        g.this.f13336d.setAlpha(0.4f);
                        g.this.c(false);
                        g.this.k.s();
                    }
                    g.this.f13339g.setVisibility(0);
                    g.this.f13339g.setText(g.this.f13335b.getDisplaySecondaryInfo());
                    g.this.f13339g.setTextColor(androidx.core.content.b.c(g.this.f13337e, R.color.color_506d85));
                }

                public final void a(n.b bVar) {
                    g.this.d(false);
                    String errorMessage = bVar.getErrorMessage(g.this.r);
                    if (bVar.getErrorCode() == 4) {
                        NetworkCustomError networkCustomError = new NetworkCustomError();
                        networkCustomError.setStatusCode(401);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_is_from_fragment", true);
                        if (g.this.k.a("upi_balance_api_call", bundle, networkCustomError)) {
                            return;
                        }
                    }
                    net.one97.paytm.p2mNewDesign.f.g i2 = g.this.k;
                    if (TextUtils.isEmpty(errorMessage)) {
                        errorMessage = g.this.f13337e.getResources().getString(R.string.upi_error_fetch_balance);
                    }
                    i2.a(errorMessage, false, false);
                }
            }).setDeviceBindingRequestCode(102).setOnActivityResultRecieverAfterDeviceBinding(this.r).build().getUpiAccountBalance(upiProfileDefaultBank);
        }
    }

    public final void g() {
        this.f13336d.findViewById(R.id.lyt_paytm_instrument).setClickable(true);
        this.f13336d.findViewById(R.id.lyt_paytm_instrument).setFocusable(true);
        this.f13336d.findViewById(R.id.lyt_paytm_instrument).setTag(Boolean.TRUE);
        this.f13336d.findViewById(R.id.lyt_paytm_instrument).performClick();
    }

    public final String a() {
        return "UPI" + this.f13335b.getAccountNumber();
    }

    public final void a(boolean z) {
        if (z) {
            this.f13336d.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.f13341i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13337e, R.drawable.ic_radio_inactive));
        }
        this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
    }

    public final void b(boolean z) {
        if (!z) {
            k();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8) {
        /*
            r7 = this;
            r7.f13340h = r8
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
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            double r4 = r8.doubleValue()
            r8 = 1
            r0 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00ba
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r7.f13335b
            java.lang.String r2 = r2.getPayMode()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r2)
            if (r2 != 0) goto L_0x00c4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            if (r2 == 0) goto L_0x00a9
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r7.f13335b
            java.lang.String r2 = r2.getPayMode()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00a9
            android.widget.RadioButton r2 = r7.f13341i
            if (r2 == 0) goto L_0x0066
            android.content.Context r3 = r7.f13337e
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
        L_0x0066:
            android.widget.TextView r2 = r7.f13338f
            android.graphics.Typeface r3 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r0)
            r2.setTypeface(r3)
            net.one97.paytm.p2mNewDesign.f.g r2 = r7.k
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.A
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x008c
            android.content.Context r1 = r7.f13337e
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r1 = r1.getString(r3)
            goto L_0x00a6
        L_0x008c:
            android.content.Context r1 = r7.f13337e
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg_with_amount_new
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r8]
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.A
            r3[r0] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
        L_0x00a6:
            r2.a(r1, r0, r0)
        L_0x00a9:
            android.view.View r1 = r7.f13336d
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r1.setAlpha(r2)
            net.one97.paytm.p2mNewDesign.f.g r1 = r7.k
            r1.s()
            r7.c(r0)
            goto L_0x00c5
        L_0x00ba:
            android.view.View r1 = r7.f13336d
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
            r7.c(r8)
        L_0x00c4:
            r8 = 0
        L_0x00c5:
            if (r8 != 0) goto L_0x00ce
            java.lang.String r8 = r7.f13340h
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r7.f13335b
            r7.a((java.lang.String) r8, (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.g.a(java.lang.String):void");
    }

    public final View c() {
        return this.f13336d;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        for (net.one97.paytm.p2mNewDesign.db.b.a next : list) {
            if ("UPI".equalsIgnoreCase(next.f51232b)) {
                return this.f13335b.getAccountNumber().equalsIgnoreCase(next.f51233c);
            }
        }
        return false;
    }

    public final String e() {
        return this.f13335b.getPriority();
    }

    public final boolean f() {
        if (this.f13335b.getmIsDisabled() == null) {
            return false;
        }
        return this.f13335b.getmIsDisabled().getStatus().booleanValue();
    }

    public final void b(List<InstrumentInfo> list) {
        if (list != null && list.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (list.get(i2).getAccountNumber().equalsIgnoreCase(this.f13335b.getAccountNumber())) {
                    this.f13335b = list.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        a(this.f13335b);
    }

    public final void h() {
        this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_506d85));
        this.f13336d.setAlpha(0.4f);
    }

    public final void j() {
        this.f13336d.setAlpha(1.0f);
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.f13336d = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.r = (Activity) context;
        this.f13337e = context;
        this.f13335b = instrumentInfo;
        this.f13340h = str;
        this.f13338f = (TextView) this.f13336d.findViewById(R.id.tv_instrument_primary_info);
        this.f13339g = (TextView) this.f13336d.findViewById(R.id.tv_instrument_secondary_info);
        this.o = (TextView) this.f13336d.findViewById(R.id.tv_instrument_secondary_info_ppbl);
        this.l = (TextView) this.f13336d.findViewById(R.id.tv_instrument_primary_info_2);
        this.m = (TextView) this.f13336d.findViewById(R.id.tv_instrument_secondary_info_2);
        this.n = (TextView) this.f13336d.findViewById(R.id.tv_instrument_secondary_info_3);
        this.f13341i = (RadioButton) this.f13336d.findViewById(R.id.rb_instrumentInfo);
        this.q = this.f13336d.findViewById(R.id.divider);
        this.s = (ImageView) this.f13336d.findViewById(R.id.tv_wallet_arrow);
        this.t = (ImageView) this.f13336d.findViewById(R.id.tv_upi_od);
        this.t.setVisibility(8);
        this.o.setVisibility(8);
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (g.this.n.getVisibility() == 8 && g.this.m.getVisibility() == 8) {
                    g.this.n.setVisibility(0);
                    g.this.m.setVisibility(0);
                    g.this.s.setImageDrawable(androidx.core.content.b.a(g.this.f13337e, R.drawable.ic_p2m_arrowup));
                    return;
                }
                g.this.n.setVisibility(8);
                g.this.m.setVisibility(8);
                g.this.s.setImageDrawable(androidx.core.content.b.a(g.this.f13337e, R.drawable.ic_p2m_arrowdown));
            }
        });
        this.f13336d.findViewById(R.id.tv_instrument_secondary_info).setOnClickListener(this);
        this.f13336d.findViewById(R.id.tv_instrument_secondary_info).setClickable(true);
        this.f13336d.findViewById(R.id.tv_instrument_secondary_info).setFocusable(true);
        this.q.setVisibility(0);
        this.f13336d.setOnClickListener(this);
        b(instrumentInfo);
    }

    public final void a(String str, InstrumentInfo instrumentInfo) {
        if (instrumentInfo.isBlocked()) {
            this.n.setVisibility(8);
            this.f13336d.setAlpha(0.4f);
            k();
        } else {
            this.n.setVisibility(8);
            this.f13336d.setAlpha(1.0f);
        }
        if (!TextUtils.isEmpty(instrumentInfo.getBalance())) {
            double parseDouble = Double.parseDouble(str);
            double parseDouble2 = Double.parseDouble(instrumentInfo.getBalance());
            double parseDouble3 = Double.parseDouble(this.f13340h);
            this.f13340h = str;
            if (parseDouble > parseDouble2) {
                a(instrumentInfo);
            } else if (parseDouble3 > parseDouble2) {
                a(instrumentInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (str.equalsIgnoreCase(SDKConstants.AI_KEY_PPBL)) {
                CJRPGInstrumentBalance cJRPGInstrumentBalance = (CJRPGInstrumentBalance) fVar.f55797b;
                this.k.c(false);
                d(false);
                if (cJRPGInstrumentBalance != null && cJRPGInstrumentBalance.getBody() != null && cJRPGInstrumentBalance.getBody().getResultInfo() != null && AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getResultInfo().getResultStatus())) {
                    String resultMsg = cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                    Context context = this.f13337e;
                    if (TextUtils.isEmpty(resultMsg)) {
                        resultMsg = "Unable to fetch balance";
                    }
                    Toast.makeText(context, resultMsg, 1).show();
                    this.f13335b.setPostpaidAPIFail(true);
                } else if (TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getAccountStatus()) || cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase(j.a.ACTIVE.name()) || cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase(j.a.CREDIT_FREEZED.name())) {
                    Double valueOf = Double.valueOf(0.0d);
                    if (!(cJRPGInstrumentBalance == null || cJRPGInstrumentBalance.getBody() == null || cJRPGInstrumentBalance.getBody().getBalanceInfo() == null || TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()))) {
                        valueOf = Double.valueOf(Double.parseDouble(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()));
                        b.f().a(this.f13337e, valueOf.doubleValue(), this.f13335b.getmDisplayPrimaryInfo2());
                    }
                    this.f13339g.setVisibility(0);
                    this.f13339g.setText(this.f13335b.getDisplaySecondaryInfo());
                    this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_666666));
                    this.f13339g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    d(false);
                    if (Double.valueOf(this.f13340h).doubleValue() > valueOf.doubleValue()) {
                        this.f13336d.setAlpha(0.4f);
                        c(false);
                        return;
                    }
                    this.f13336d.setAlpha(1.0f);
                    c(true);
                } else {
                    this.f13336d.setAlpha(0.4f);
                    c(false);
                    this.f13335b.setActive(false);
                    this.f13335b.setErrorMessage(cJRPGInstrumentBalance.getBody().getDisplayMessage());
                    d(false);
                    if (!TextUtils.isEmpty(this.f13335b.getErrorMessage())) {
                        Toast.makeText(this.f13337e, this.f13335b.getErrorMessage(), 1).show();
                    }
                    this.f13338f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                    this.f13339g.setTextColor(androidx.core.content.b.c(this.f13337e, R.color.color_666666));
                    this.f13339g.setVisibility(8);
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (this.k.a("generic_api_call_fail", bundle, gVar.f55801c)) {
                d(false);
                return;
            }
            Toast.makeText(this.f13337e, "Unable to fetch balance", 1).show();
            g.class.getSimpleName();
            q.d(gVar.f55801c.getMessage());
            d(false);
        }
    }
}
