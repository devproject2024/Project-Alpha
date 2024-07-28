package net.one97.paytm.p2mNewDesign.e.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.paymentsbank.CJRVerifyPasscodeResponse;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.CJRPGInstrumentBalance;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.utility.j;
import org.json.JSONObject;

public class f extends a implements View.OnClickListener {
    private static String B = "home/pay-send/post-scan";
    private ImageView A;
    private boolean C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    String f13321a = "Postpaid controller";

    /* renamed from: b  reason: collision with root package name */
    private View f13322b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f13323d;

    /* renamed from: e  reason: collision with root package name */
    private InstrumentInfo f13324e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13325f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13326g;

    /* renamed from: h  reason: collision with root package name */
    private String f13327h;

    /* renamed from: i  reason: collision with root package name */
    private RadioButton f13328i;
    private Toast j;
    private RelativeLayout k;
    private g l;
    private TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    private TextView p;
    private RelativeLayout q;
    /* access modifiers changed from: private */
    public EditText r;
    private ProgressDialog s;
    private TextView t;
    /* access modifiers changed from: private */
    public TextView u;
    private String v;
    private String w;
    private View x;
    private boolean y;
    /* access modifiers changed from: private */
    public ImageView z;

    public final String a() {
        return "PAYTM_DIGITAL_CREDIT";
    }

    public final void i() {
    }

    public final View a(InstrumentInfo instrumentInfo) {
        this.f13324e = instrumentInfo;
        b(instrumentInfo);
        return this.f13322b;
    }

    private void b(InstrumentInfo instrumentInfo) {
        this.f13325f.setText(instrumentInfo.getDisplayPrimaryInfo());
        if (b.f().b(instrumentInfo) && b.f().d(instrumentInfo.getPayMode())) {
            this.f13328i.setButtonDrawable(R.drawable.ic_radio_active);
            this.f13325f.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.black));
            this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            this.k.setVisibility(8);
            this.k.setOnClickListener(this);
        }
        this.f13326g.setText(instrumentInfo.getDisplaySecondaryInfo());
        this.m.setVisibility(8);
        if (TextUtils.isEmpty(this.f13324e.getBalance())) {
            this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_00b9f5));
        }
        if (!b.f().d(instrumentInfo.getPayMode())) {
            this.f13322b.setAlpha(0.4f);
            c(false);
            this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_666666));
            b.f();
            b.a(this.f13323d, (ImageView) this.f13322b.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
            if (this.f13324e.getPayMode().equals(SDKConstants.AI_KEY_PPBL) || this.f13324e.getPayMode().equals("PAYTM_DIGITAL_CREDIT") || this.f13324e.getPayMode().equals("UPI")) {
                this.f13326g.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setClickable(true);
        }
        this.f13322b.setAlpha(1.0f);
        c(true);
        if (!TextUtils.isEmpty(this.f13324e.getBalance()) && Double.valueOf(this.f13324e.getBalance()).doubleValue() < Double.valueOf(this.f13327h).doubleValue()) {
            this.f13322b.setAlpha(0.4f);
            c(false);
            ImageView imageView2 = this.A;
            if (imageView2 != null) {
                imageView2.setClickable(false);
            }
            this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_666666));
        }
        b.f();
        b.a(this.f13323d, (ImageView) this.f13322b.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        b.f();
        if (!b.q(this.f13324e.getPayMode())) {
            this.f13322b.setAlpha(0.4f);
            c(false);
        }
    }

    public void onClick(View view) {
        TextView textView;
        int id = view.getId();
        b.f().z = view.getTag() != null ? ((Boolean) view.getTag()).booleanValue() : false;
        this.C = false;
        if (id != R.id.lyt_paytm_instrument && id != R.id.tv_instrument_secondary_info) {
            return;
        }
        if (b.f().J == null || b.f().H == null || !b.f().L) {
            if (b.f().t(this.l.d())) {
                this.l.n();
            }
            b.f();
            if (!b.q(this.f13324e.getPayMode())) {
                this.l.a("0".equalsIgnoreCase(b.f().A) ? this.f13323d.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13323d.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
                return;
            }
            this.f13327h = this.l.d();
            if (this.f13324e == null || b.f().d(this.f13324e.getPayMode())) {
                if (TextUtils.isEmpty(this.f13324e.getBalance()) || ((textView = this.f13326g) != null && (textView.getText().equals("Check Balance") || this.f13326g.getText().equals(this.f13323d.getString(R.string.retry_fetching_balance))))) {
                    if (this.f13324e.isActive()) {
                        this.f13322b.findViewById(R.id.secondnary_container).setVisibility(8);
                        d(true);
                        LiveData<net.one97.paytm.network.f> a2 = this.l.a("PAYTM_DIGITAL_CREDIT", this.f13323d, this.w, false);
                        if (a2 != null) {
                            a2.observeForever(new z("PAYTM_DIGITAL_CREDIT") {
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onChanged(Object obj) {
                                    f.this.a(this.f$1, (f) obj);
                                }
                            });
                        }
                    } else {
                        Toast.makeText(this.f13323d, this.f13324e.getErrorMessage(), 0).show();
                        return;
                    }
                }
                String str = "flow_through_scan_icon";
                if (TextUtils.isEmpty(this.f13324e.getBalance()) || Double.valueOf(this.f13327h).doubleValue() <= Double.valueOf(this.f13324e.getBalance()).doubleValue()) {
                    if (!this.f13324e.getPayMode().equalsIgnoreCase("PAYTM_DIGITAL_CREDIT") || !"true".equalsIgnoreCase(this.f13324e.getPasscodeRequired())) {
                        this.q.setVisibility(8);
                    } else {
                        this.r.requestFocus();
                        a((View) this.r);
                        this.q.setVisibility(0);
                    }
                    this.k.setOnClickListener(this);
                    this.f13328i.setChecked(true);
                    this.f13328i.setButtonDrawable(androidx.core.content.b.a(this.f13323d, R.drawable.ic_radio_active));
                    this.f13322b.setAlpha(1.0f);
                    this.f13324e.setUniqueId("PAYTM_DIGITAL_CREDIT");
                    b.f().a(this.f13324e);
                    this.l.d("PAYTM_DIGITAL_CREDIT");
                    if (!this.D && !"true".equalsIgnoreCase(this.f13324e.getPasscodeRequired())) {
                        this.l.f(true);
                    }
                    this.D = false;
                    this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    g gVar = this.l;
                    if (gVar != null) {
                        gVar.a(this.f13324e, "updateSelection");
                    }
                    if (!b.f().f13092h) {
                        str = "flow_through_pay_icon";
                    }
                    a("offline_payments", "post_scan_postpaid_selected", str, this.f13323d, B);
                    return;
                }
                Toast toast = this.j;
                if (toast == null || (toast != null && !toast.getView().isShown())) {
                    if (this.f13324e.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL)) {
                        Context context = this.f13323d;
                        this.j = Toast.makeText(context, context.getString(R.string.insufficient_balance_payment_bank), 1);
                    } else {
                        if (!b.f().f13092h) {
                            str = "flow_through_pay_icon";
                        }
                        a("offline_payments", "post_scan_disabled_postpaid_clicked", str, this.f13323d, B);
                        Context context2 = this.f13323d;
                        this.j = Toast.makeText(context2, context2.getString(R.string.insufficient_balance_payment_postpaid), 1);
                    }
                    this.j.show();
                }
                if (this.y) {
                    this.l.a(this.f13324e, "autoFetchBalance");
                    return;
                }
                return;
            }
            Context context3 = this.f13323d;
            Toast.makeText(context3, this.f13323d.getString(R.string.merchant_doesnt_support_instrunment) + " " + this.f13324e.getDisplayPrimaryInfo(), 0).show();
            return;
        }
        this.f51247c = false;
    }

    private void a(View view) {
        if (!this.l.k()) {
            view.postDelayed(new Runnable() {
                public final void run() {
                    ((InputMethodManager) f.this.f13323d.getSystemService("input_method")).toggleSoftInput(2, 1);
                }
            }, 1);
        }
    }

    private void d(boolean z2) {
        DotProgressBar dotProgressBar = (DotProgressBar) this.f13322b.findViewById(R.id.dot_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
        }
        int i2 = 8;
        this.f13326g.setVisibility(z2 ? 8 : 0);
        View findViewById = this.f13322b.findViewById(R.id.lyt_fetch_payment_bank_balance);
        if (z2) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
    }

    private void a(Object obj) {
        if (obj instanceof CJRVerifyPasscodeResponse) {
            CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) obj;
            h();
            this.l.c(false);
            if (!TextUtils.isEmpty(cJRVerifyPasscodeResponse.getError())) {
                this.r.setBackground(androidx.core.content.b.a(this.f13323d, R.drawable.round_corner_red_shape));
                this.u.setVisibility(0);
                return;
            }
            ((InputMethodManager) this.f13323d.getSystemService("input_method")).hideSoftInputFromWindow(this.r.getWindowToken(), 0);
            this.u.setVisibility(8);
            this.v = cJRVerifyPasscodeResponse.getAccessToken();
            InstrumentInfo instrumentInfo = b.f().n;
            if (instrumentInfo != null) {
                if ("PAYTM_DIGITAL_CREDIT".equalsIgnoreCase(instrumentInfo.getPayMode())) {
                    instrumentInfo.setPaymentDetails(instrumentInfo.getPaymentDetails() + "|" + this.v);
                } else {
                    instrumentInfo.setPaymentDetails(this.v);
                }
                this.l.a(instrumentInfo, "proceedtoPay");
            }
        } else if (obj instanceof CJRPGInstrumentBalance) {
            CJRPGInstrumentBalance cJRPGInstrumentBalance = (CJRPGInstrumentBalance) obj;
            if (cJRPGInstrumentBalance.getBody() == null) {
                Toast.makeText(this.f13323d, "Unable to fetch balance", 1).show();
                this.f13324e.setPostpaidAPIFail(true);
                d(false);
            } else if (cJRPGInstrumentBalance.getBody().getResultInfo() == null) {
                Toast.makeText(this.f13323d, "Unable to fetch balance", 1).show();
                this.f13324e.setPostpaidAPIFail(true);
                d(false);
            } else if (AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getResultInfo().getResultStatus())) {
                String resultMsg = cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                Context context = this.f13323d;
                if (TextUtils.isEmpty(resultMsg)) {
                    resultMsg = "Unable to fetch balance";
                }
                Toast.makeText(context, resultMsg, 1).show();
                this.f13324e.setPostpaidAPIFail(true);
                d(false);
            } else if (cJRPGInstrumentBalance.getBody().getBalanceInfo() == null || TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()) || (!TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getAccountStatus()) && !cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase(j.a.ACTIVE.name()))) {
                this.f13324e.setActive(false);
                this.f13324e.setErrorMessage(cJRPGInstrumentBalance.getBody().getDisplayMessage());
                this.f13324e.setPostpaidAPIFail(true);
                d(false);
                this.f13322b.setAlpha(0.4f);
                this.f51247c = false;
                this.l.s();
                if (!TextUtils.isEmpty(this.f13324e.getErrorMessage())) {
                    Toast.makeText(this.f13323d, this.f13324e.getErrorMessage(), 1).show();
                }
                this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_666666));
                this.f13326g.setVisibility(8);
            } else {
                Double valueOf = Double.valueOf(Double.parseDouble(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()));
                b.f().a(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue(), cJRPGInstrumentBalance.getBody().getPasscodeRequired(), "ACTIVE".equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getAccountStatus()));
                this.f13326g.setVisibility(0);
                this.f13326g.setText(this.f13324e.getDisplaySecondaryInfo());
                this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_666666));
                this.f13326g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                d(false);
                if (Double.valueOf(this.f13327h).doubleValue() > valueOf.doubleValue()) {
                    this.f13322b.setAlpha(0.4f);
                    c(false);
                    this.l.s();
                    if (cJRPGInstrumentBalance.getBody().getAccountStatus() != null && !cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase("ACTIVE")) {
                        this.f13324e.setActive(false);
                        this.f13324e.setErrorMessage(cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg());
                        this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                        this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_666666));
                    }
                    this.l.a(this.f13324e, "autofetchbalance");
                } else if (this.y || !"true".equalsIgnoreCase(this.f13324e.getPasscodeRequired())) {
                    this.f13328i.setChecked(true);
                    this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    this.f13328i.setButtonDrawable(androidx.core.content.b.a(this.f13323d, R.drawable.ic_radio_active));
                    this.l.d("PAYTM_DIGITAL_CREDIT");
                    this.l.a(this.f13324e, "updateSelection");
                } else {
                    this.r.requestFocus();
                    a((View) this.r);
                    this.f13328i.setChecked(true);
                    this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    this.f13328i.setButtonDrawable(androidx.core.content.b.a(this.f13323d, R.drawable.ic_radio_active));
                    this.l.d("PAYTM_DIGITAL_CREDIT");
                    this.l.a(this.f13324e, "uncheck");
                    this.l.a(this.f13324e, "updateSelection");
                    this.l.a(this.f13324e, "sectionClose");
                    this.q.setVisibility(0);
                    this.k.setVisibility(8);
                    this.k.setOnClickListener(this);
                    if (cJRPGInstrumentBalance.getBody().getAccountStatus() != null && !cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase("ACTIVE")) {
                        this.f13324e.setActive(false);
                        this.f13324e.setErrorMessage(cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg());
                        this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                        this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_666666));
                    }
                }
            }
        }
    }

    private void h() {
        try {
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(g gVar) {
        this.l = gVar;
    }

    public final void b(String str) {
        this.w = str;
    }

    public final void a(String str, InstrumentInfo instrumentInfo) {
        if (!TextUtils.isEmpty(instrumentInfo.getBalance())) {
            double parseDouble = Double.parseDouble(str);
            double parseDouble2 = Double.parseDouble(instrumentInfo.getBalance());
            double parseDouble3 = Double.parseDouble(this.f13327h);
            this.f13327h = str;
            if (parseDouble > parseDouble2) {
                a(instrumentInfo);
            } else if (parseDouble3 > parseDouble2) {
                a(instrumentInfo);
            }
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            this.D = true;
            this.f13322b.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.f13328i;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13323d, R.drawable.ic_radio_inactive));
        }
        this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.q;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    public final View c() {
        return this.f13322b;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
        if (it2.hasNext()) {
            return "PAYTM_DIGITAL_CREDIT".equalsIgnoreCase(it2.next().f51232b);
        }
        return false;
    }

    public final String e() {
        return this.f13324e.getPriority();
    }

    public final boolean f() {
        if (this.f13324e.getmIsDisabled() == null) {
            return false;
        }
        return this.f13324e.getmIsDisabled().getStatus().booleanValue();
    }

    public final void d() {
        this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_506d85));
        this.f13322b.setAlpha(0.4f);
    }

    public final void g() {
        this.f13322b.setAlpha(1.0f);
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z2) {
        this.D = false;
        this.f13322b = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.f13323d = context;
        this.f13324e = instrumentInfo;
        this.f13327h = str;
        this.f13325f = (TextView) this.f13322b.findViewById(R.id.tv_instrument_primary_info);
        this.f13326g = (TextView) this.f13322b.findViewById(R.id.tv_instrument_secondary_info);
        this.p = (TextView) this.f13322b.findViewById(R.id.tv_instrument_secondary_info_ppbl);
        this.m = (TextView) this.f13322b.findViewById(R.id.tv_instrument_primary_info_2);
        this.n = (TextView) this.f13322b.findViewById(R.id.tv_instrument_secondary_info_2);
        this.o = (TextView) this.f13322b.findViewById(R.id.tv_instrument_secondary_info_3);
        this.f13328i = (RadioButton) this.f13322b.findViewById(R.id.rb_instrumentInfo);
        this.k = (RelativeLayout) this.f13322b.findViewById(R.id.rl_proceed_to_pay);
        this.q = (RelativeLayout) this.f13322b.findViewById(R.id.rl_enter_passcode_layout);
        this.r = (EditText) this.q.findViewById(R.id.et_passcode);
        this.x = this.f13322b.findViewById(R.id.divider);
        this.z = (ImageView) this.f13322b.findViewById(R.id.tv_wallet_arrow);
        this.A = (ImageView) this.f13322b.findViewById(R.id.tv_upi_od);
        this.A.setVisibility(8);
        this.p.setVisibility(8);
        this.z.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (f.this.o.getVisibility() == 8 && f.this.n.getVisibility() == 8) {
                    f.this.o.setVisibility(0);
                    f.this.n.setVisibility(0);
                    f.this.z.setImageDrawable(androidx.core.content.b.a(f.this.f13323d, R.drawable.ic_p2m_arrowup));
                    return;
                }
                f.this.o.setVisibility(8);
                f.this.n.setVisibility(8);
                f.this.z.setImageDrawable(androidx.core.content.b.a(f.this.f13323d, R.drawable.ic_p2m_arrowdown));
            }
        });
        if (instrumentInfo == null || !instrumentInfo.getPayMode().equalsIgnoreCase("UPI")) {
            this.f13322b.findViewById(R.id.tv_instrument_secondary_info).setClickable(false);
            this.f13322b.findViewById(R.id.tv_instrument_secondary_info).setFocusable(false);
        } else {
            this.f13322b.findViewById(R.id.tv_instrument_secondary_info).setOnClickListener(this);
            this.f13322b.findViewById(R.id.tv_instrument_secondary_info).setClickable(true);
            this.f13322b.findViewById(R.id.tv_instrument_secondary_info).setFocusable(true);
        }
        this.x.setVisibility(0);
        this.t = (TextView) this.q.findViewById(R.id.tv_forgot_passcode);
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.wallet.communicator.b.a().getForgotPasscodeIntent(f.this.f13323d);
            }
        });
        this.u = (TextView) this.q.findViewById(R.id.tv_incorrect_passcode);
        this.r.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() < 4) {
                    f.this.u.setVisibility(8);
                    f.this.r.setBackground(androidx.core.content.b.a(f.this.f13323d, R.drawable.round_corner_shape));
                }
            }
        });
        this.f13322b.setOnClickListener(this);
        EditText editText = this.r;
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    Resources resources;
                    int i2;
                    EditText f2 = f.this.r;
                    if (z) {
                        resources = f.this.f13323d.getResources();
                        i2 = R.drawable.blue_stroke;
                    } else {
                        resources = f.this.f13323d.getResources();
                        i2 = R.drawable.gray_stroke;
                    }
                    f2.setBackground(resources.getDrawable(i2));
                }
            });
        }
        b(instrumentInfo);
    }

    public final void b(boolean z2) {
        if (!z2) {
            RadioButton radioButton = this.f13328i;
            if (radioButton != null) {
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13323d, R.drawable.ic_radio_inactive));
            }
            this.f13325f.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.q;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                EditText editText = this.r;
                if (editText != null) {
                    editText.setText("");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
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
            if (r7 >= 0) goto L_0x00bb
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13324e
            java.lang.String r2 = r2.getPayMode()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r2)
            if (r2 != 0) goto L_0x00c5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            if (r2 == 0) goto L_0x00af
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13324e
            java.lang.String r2 = r2.getPayMode()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00af
            r8.c(r6)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.l
            r2.s()
            android.widget.RadioButton r2 = r8.f13328i
            if (r2 == 0) goto L_0x006c
            android.content.Context r3 = r8.f13323d
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
        L_0x006c:
            android.widget.TextView r2 = r8.f13325f
            android.graphics.Typeface r3 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r6)
            r2.setTypeface(r3)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.l
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.A
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0092
            android.content.Context r1 = r8.f13323d
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r1 = r1.getString(r3)
            goto L_0x00ac
        L_0x0092:
            android.content.Context r1 = r8.f13323d
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg_with_amount_new
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r0]
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.A
            r3[r6] = r4
            java.lang.String r1 = java.lang.String.format(r1, r3)
        L_0x00ac:
            r2.a(r1, r6, r6)
        L_0x00af:
            android.view.View r1 = r8.f13322b
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r1.setAlpha(r2)
            r8.c(r6)
            goto L_0x00c6
        L_0x00bb:
            android.view.View r1 = r8.f13322b
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
            r8.c(r0)
        L_0x00c5:
            r0 = 0
        L_0x00c6:
            if (r0 != 0) goto L_0x00d1
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13093i
            r8.a((java.lang.String) r9, (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.f.a(java.lang.String):void");
    }

    public final void b() {
        String obj = this.r.getText().toString();
        if (TextUtils.isEmpty(this.f13327h) || this.f13327h.equalsIgnoreCase("0")) {
            this.r.requestFocus();
            this.l.c(false);
            a((View) this.r);
        } else if (obj.length() == 4) {
            this.u.setVisibility(8);
            this.u.setText(this.f13323d.getResources().getString(R.string.incorrect_passcode));
            LiveData<net.one97.paytm.network.f> a2 = this.l.a(this.f13323d, this.r.getText().toString());
            if (a2 != null) {
                a2.observeForever(new z() {
                    public final void onChanged(Object obj) {
                        f.this.a((f) obj);
                    }
                });
            }
        } else if (obj.length() >= 4) {
            this.r.setBackground(androidx.core.content.b.a(this.f13323d, R.drawable.round_corner_shape));
            this.u.setVisibility(0);
            this.u.setText(this.f13323d.getResources().getString(R.string.incorrect_passcode));
            this.r.requestFocus();
            this.l.c(false);
            a((View) this.r);
        } else if (obj.length() == 0) {
            this.r.setBackground(androidx.core.content.b.a(this.f13323d, R.drawable.round_corner_shape));
            this.u.setVisibility(0);
            this.u.setText(this.f13323d.getResources().getString(R.string.enter_passcode));
            this.l.c(false);
            this.r.requestFocus();
            a((View) this.r);
        } else {
            this.r.setBackground(androidx.core.content.b.a(this.f13323d, R.drawable.round_corner_shape));
            this.u.setVisibility(0);
            this.u.setText(this.f13323d.getResources().getString(R.string.passcode_four_digit_msg));
            this.r.requestFocus();
            this.l.c(false);
            a((View) this.r);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            this.f13322b.findViewById(R.id.secondnary_container).setVisibility(0);
            CJRPGInstrumentBalance cJRPGInstrumentBalance = (CJRPGInstrumentBalance) fVar.f55797b;
            cJRPGInstrumentBalance.setPayMode(str);
            a((Object) cJRPGInstrumentBalance);
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (this.l.a("generic_api_call_fail", bundle, gVar.f55801c)) {
                d(false);
            } else if (str.equalsIgnoreCase("PAYTM_DIGITAL_CREDIT")) {
                f.class.getSimpleName();
                q.d(gVar.f55801c.getMessage());
                Toast.makeText(this.f13323d, "Unable to fetch balance", 1).show();
                this.f13324e.setPostpaidAPIFail(true);
                d(false);
                this.f13322b.findViewById(R.id.secondnary_container).setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            a((Object) fVar.f55797b);
        } else if (fVar.f55796a == h.ERROR) {
            this.l.c(false);
            net.one97.paytm.network.g gVar = fVar.f55798c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!this.l.a("verify_passcode", bundle, fVar.f55798c.f55801c)) {
                if (gVar.f55799a == 400 && (gVar.f55800b instanceof CJRVerifyPasscodeResponse)) {
                    String str = new String(gVar.f55801c.networkResponse.data);
                    if (!TextUtils.isEmpty(str)) {
                        h();
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("error_description")) {
                                String string = jSONObject.getString("error_description");
                                this.r.setBackground(androidx.core.content.b.a(this.f13323d, R.drawable.round_corner_red_shape));
                                this.u.setVisibility(0);
                                this.u.setText(string);
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                NetworkCustomError networkCustomError = gVar.f55801c;
                if (networkCustomError.getFullUrl().equals(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13323d, UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW))) {
                    d(false);
                    this.f13326g.setVisibility(0);
                    this.f13326g.setTextColor(androidx.core.content.b.c(this.f13323d, R.color.color_00b9f5));
                    this.f13326g.setText(this.f13323d.getString(R.string.retry_fetching_balance));
                    this.f13326g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f13323d.getResources().getDrawable(R.drawable.refresh_icon), (Drawable) null);
                    if (this.y) {
                        this.y = false;
                        this.l.a(this.f13324e, "autoFetchBalance");
                    }
                } else if (networkCustomError.getFullUrl().contains(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13323d, "pgWalletBalanceURL"))) {
                    Context context = this.f13323d;
                    Toast.makeText(context, context.getString(R.string.unable_to_fetch_paytm_wallet_p2m), 1).show();
                }
            }
        }
    }
}
