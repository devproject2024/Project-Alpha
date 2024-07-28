package net.one97.paytm.p2mNewDesign.e.a;

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
import com.paytm.network.model.IJRPaytmDataModel;
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

public class e extends a implements View.OnClickListener {
    private static String w = "home/pay-send/post-scan";

    /* renamed from: a  reason: collision with root package name */
    String f13309a = "PPBL Controller";

    /* renamed from: b  reason: collision with root package name */
    private boolean f13310b;

    /* renamed from: d  reason: collision with root package name */
    private View f13311d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f13312e;

    /* renamed from: f  reason: collision with root package name */
    private InstrumentInfo f13313f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13314g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f13315h;

    /* renamed from: i  reason: collision with root package name */
    private String f13316i;
    private RadioButton j;
    private Toast k;
    private g l;
    private TextView m;
    private TextView n;
    private RelativeLayout o;
    /* access modifiers changed from: private */
    public EditText p;
    private TextView q;
    /* access modifiers changed from: private */
    public TextView r;
    private String s;
    private String t;
    private View u;
    private boolean v;
    private boolean x;

    public final String a() {
        return SDKConstants.AI_KEY_PPBL;
    }

    public final View a(InstrumentInfo instrumentInfo) {
        this.f13313f = instrumentInfo;
        b(instrumentInfo);
        return this.f13311d;
    }

    private void b(InstrumentInfo instrumentInfo) {
        this.f13314g.setText(instrumentInfo.getDisplayPrimaryInfo());
        if (b.f().b(instrumentInfo) && b.f().d(instrumentInfo.getPayMode())) {
            this.j.setButtonDrawable(R.drawable.ic_radio_active);
            this.f13314g.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.black));
            this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        }
        this.f13315h.setText(instrumentInfo.getDisplaySecondaryInfo());
        if (instrumentInfo == null || !TextUtils.isEmpty(instrumentInfo.getBalance())) {
            this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
        } else {
            this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_00b9f5));
        }
        this.m.setVisibility(8);
        if (b.f().d(instrumentInfo.getPayMode()) || "UPI_ONBOARDING".equalsIgnoreCase(instrumentInfo.getPayMode())) {
            if (!TextUtils.isEmpty(this.f13313f.getBalance()) && Double.valueOf(this.f13313f.getBalance()).doubleValue() < Double.valueOf(this.f13316i).doubleValue()) {
                this.f13311d.setAlpha(0.4f);
                c(false);
                this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
            }
            b.f();
            b.a(this.f13312e, (ImageView) this.f13311d.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
            b.f();
            if (!b.q(this.f13313f.getPayMode())) {
                this.f13311d.setAlpha(0.4f);
                c(false);
                return;
            }
            return;
        }
        this.f13311d.setAlpha(0.4f);
        c(false);
        this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
        b.f();
        b.a(this.f13312e, (ImageView) this.f13311d.findViewById(R.id.iv_card_type), b.f().n(instrumentInfo.getPayMode()), instrumentInfo.getPayMode());
        if (this.f13313f.getPayMode().equals(SDKConstants.AI_KEY_PPBL) || this.f13313f.getPayMode().equals("PAYTM_DIGITAL_CREDIT") || this.f13313f.getPayMode().equals("UPI")) {
            this.f13315h.setVisibility(8);
        }
    }

    public void onClick(View view) {
        TextView textView;
        int id = view.getId();
        b.f().z = view.getTag() != null ? ((Boolean) view.getTag()).booleanValue() : false;
        this.x = false;
        if (id != R.id.lyt_paytm_instrument && id != R.id.tv_instrument_secondary_info) {
            return;
        }
        if (b.f().J == null || b.f().H == null || !b.f().L) {
            if (b.f().t(this.l.d())) {
                this.l.n();
            }
            b.f();
            if (!b.q(this.f13313f.getPayMode())) {
                this.l.a("0".equalsIgnoreCase(b.f().A) ? this.f13312e.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13312e.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
                return;
            }
            this.f13316i = this.l.d();
            if (this.f13313f != null && !b.f().d(this.f13313f.getPayMode())) {
                Context context = this.f13312e;
                Toast.makeText(context, this.f13312e.getString(R.string.merchant_doesnt_support_instrunment) + " " + this.f13313f.getDisplayPrimaryInfo(), 0).show();
            } else if (this.f13313f.getPayMode().equals(SDKConstants.AI_KEY_PPBL)) {
                if (this.f13313f.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && (textView = this.f13315h) != null && (textView.getText().equals(this.f13312e.getString(R.string.check_balance)) || this.f13315h.getText().equals(this.f13312e.getString(R.string.retry_fetching_balance)))) {
                    if (this.f13313f.isActive()) {
                        net.one97.paytm.n.e eVar = net.one97.paytm.n.e.f55762a;
                        if (!net.one97.paytm.n.e.i()) {
                            e(true);
                            c(SDKConstants.AI_KEY_PPBL);
                        }
                    } else {
                        Toast.makeText(this.f13312e, this.f13313f.getErrorMessage(), 0).show();
                        return;
                    }
                }
                if (TextUtils.isEmpty(this.f13313f.getBalance()) || Double.valueOf(this.f13316i).doubleValue() <= Double.valueOf(this.f13313f.getBalance()).doubleValue()) {
                    if (!this.f13310b) {
                        this.p.requestFocus();
                        a((View) this.p);
                    }
                    this.f13310b = false;
                    this.o.setVisibility(0);
                    this.j.setChecked(true);
                    this.j.setButtonDrawable(androidx.core.content.b.a(this.f13312e, R.drawable.ic_radio_active));
                    this.l.d(SDKConstants.AI_KEY_PPBL);
                    this.f13313f.setUniqueId(SDKConstants.AI_KEY_PPBL);
                    b.f().a(this.f13313f);
                    this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    g gVar = this.l;
                    if (gVar != null) {
                        gVar.a(this.f13313f, "updateSelection");
                        this.l.a(this.f13313f, "sectionClose");
                        this.l.a(this.f13313f, "uncheck");
                    }
                    a("offline_payments", "post_scan_ppbl_selected", b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", this.f13312e, w);
                    return;
                }
                Toast toast = this.k;
                if (toast == null || (toast != null && !toast.getView().isShown())) {
                    Context context2 = this.f13312e;
                    this.k = Toast.makeText(context2, context2.getString(R.string.insufficient_balance_payment_bank), 1);
                    this.k.show();
                }
                if (this.v) {
                    this.l.a(this.f13313f, "autoFetchBalance");
                }
            }
        } else {
            this.f51247c = false;
        }
    }

    private void a(View view) {
        if (!this.l.k()) {
            view.postDelayed(new Runnable() {
                public final void run() {
                    ((InputMethodManager) e.this.f13312e.getSystemService("input_method")).toggleSoftInput(2, 1);
                }
            }, 1);
        }
    }

    private void e(boolean z) {
        DotProgressBar dotProgressBar = (DotProgressBar) this.f13311d.findViewById(R.id.dot_progress_bar);
        if (dotProgressBar != null) {
            dotProgressBar.setXCoordinateChange(true);
        }
        int i2 = 8;
        this.f13315h.setVisibility(z ? 8 : 0);
        View findViewById = this.f13311d.findViewById(R.id.lyt_fetch_payment_bank_balance);
        if (z) {
            i2 = 0;
        }
        findViewById.setVisibility(i2);
    }

    private void h() {
        ((InputMethodManager) this.f13312e.getSystemService("input_method")).hideSoftInputFromWindow(this.p.getWindowToken(), 0);
    }

    public final void a(g gVar) {
        this.l = gVar;
    }

    public final void b(String str) {
        this.t = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        TextView textView;
        if (this.f13313f.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && (textView = this.f13315h) != null) {
            if (!textView.getText().equals(this.f13312e.getString(R.string.check_balance)) && !this.f13315h.getText().equals(this.f13312e.getString(R.string.retry_fetching_balance))) {
                return;
            }
            if (this.f13313f.isActive()) {
                e(true);
                this.l.u();
                return;
            }
            Toast.makeText(this.f13312e, this.f13313f.getErrorMessage(), 0).show();
        }
    }

    public final void a(String str, InstrumentInfo instrumentInfo) {
        if (!TextUtils.isEmpty(instrumentInfo.getBalance())) {
            double parseDouble = Double.parseDouble(str);
            double parseDouble2 = Double.parseDouble(instrumentInfo.getBalance());
            double parseDouble3 = Double.parseDouble(this.f13316i);
            this.f13316i = str;
            if (parseDouble > parseDouble2) {
                a(instrumentInfo);
            } else if (parseDouble3 > parseDouble2) {
                a(instrumentInfo);
            }
        }
    }

    private void c(String str) {
        LiveData<f> a2 = this.l.a(str, this.f13312e, this.t, false);
        if (a2 != null) {
            a2.observeForever(new z() {
                public final void onChanged(Object obj) {
                    e.this.a((f) obj);
                }
            });
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.f13310b = true;
            this.f13311d.findViewById(R.id.lyt_paytm_instrument).performClick();
            return;
        }
        RadioButton radioButton = this.j;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13312e, R.drawable.ic_radio_inactive));
        }
        this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            EditText editText = this.p;
            if (editText != null) {
                editText.setText("");
            }
        }
    }

    public final View c() {
        return this.f13311d;
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list == null) {
            return false;
        }
        Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
        if (it2.hasNext()) {
            return SDKConstants.AI_KEY_PPBL.equalsIgnoreCase(it2.next().f51232b);
        }
        return false;
    }

    public final String e() {
        return this.f13313f.getPriority();
    }

    public final boolean f() {
        if (this.f13313f.getmIsDisabled() == null) {
            return false;
        }
        return this.f13313f.getmIsDisabled().getStatus().booleanValue();
    }

    public final void d() {
        this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_506d85));
        this.f13311d.setAlpha(0.4f);
    }

    public final void g() {
        this.f13311d.setAlpha(1.0f);
    }

    public final void i() {
        h();
    }

    public final void d(boolean z) {
        if (z) {
            e(true);
            c(SDKConstants.AI_KEY_PPBL);
            return;
        }
        e(false);
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z) {
        this.f13311d = LayoutInflater.from(context).inflate(R.layout.lyt_instrument_info_v2, (ViewGroup) null, false);
        this.f13310b = false;
        this.f13312e = context;
        this.f13313f = instrumentInfo;
        this.f13316i = str;
        this.f13314g = (TextView) this.f13311d.findViewById(R.id.tv_instrument_primary_info);
        this.f13315h = (TextView) this.f13311d.findViewById(R.id.tv_instrument_secondary_info);
        this.n = (TextView) this.f13311d.findViewById(R.id.tv_instrument_secondary_info_ppbl);
        this.m = (TextView) this.f13311d.findViewById(R.id.tv_instrument_primary_info_2);
        this.j = (RadioButton) this.f13311d.findViewById(R.id.rb_instrumentInfo);
        this.o = (RelativeLayout) this.f13311d.findViewById(R.id.rl_enter_passcode_layout);
        this.p = (EditText) this.o.findViewById(R.id.et_passcode);
        this.u = this.f13311d.findViewById(R.id.divider);
        this.n.setVisibility(8);
        this.f13311d.findViewById(R.id.tv_instrument_secondary_info).setClickable(false);
        this.f13311d.findViewById(R.id.tv_instrument_secondary_info).setFocusable(false);
        this.u.setVisibility(0);
        this.q = (TextView) this.o.findViewById(R.id.tv_forgot_passcode);
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.wallet.communicator.b.a().getForgotPasscodeIntent(e.this.f13312e);
            }
        });
        this.r = (TextView) this.o.findViewById(R.id.tv_incorrect_passcode);
        this.p.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() < 4) {
                    e.this.r.setVisibility(8);
                    e.this.p.setBackground(androidx.core.content.b.a(e.this.f13312e, R.drawable.round_corner_shape));
                }
            }
        });
        this.f13315h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                e.this.b(view);
            }
        });
        this.f13311d.setOnClickListener(this);
        EditText editText = this.p;
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    Resources resources;
                    int i2;
                    EditText c2 = e.this.p;
                    if (z) {
                        resources = e.this.f13312e.getResources();
                        i2 = R.drawable.blue_stroke;
                    } else {
                        resources = e.this.f13312e.getResources();
                        i2 = R.drawable.gray_stroke;
                    }
                    c2.setBackground(resources.getDrawable(i2));
                }
            });
        }
        b(instrumentInfo);
    }

    public final void b(boolean z) {
        if (!z) {
            RadioButton radioButton = this.j;
            if (radioButton != null) {
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13312e, R.drawable.ic_radio_inactive));
            }
            this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
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
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13313f
            java.lang.String r2 = r2.getPayMode()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r2)
            if (r2 != 0) goto L_0x00c5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            if (r2 == 0) goto L_0x00af
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.f13313f
            java.lang.String r2 = r2.getPayMode()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x00af
            r8.c(r6)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.l
            r2.s()
            android.widget.RadioButton r2 = r8.j
            if (r2 == 0) goto L_0x006c
            android.content.Context r3 = r8.f13312e
            int r4 = net.one97.paytm.wallet.R.drawable.ic_radio_inactive
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setButtonDrawable(r3)
        L_0x006c:
            android.widget.TextView r2 = r8.f13314g
            android.graphics.Typeface r3 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r6)
            r2.setTypeface(r3)
            net.one97.paytm.p2mNewDesign.f.g r2 = r8.l
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.A
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0092
            android.content.Context r1 = r8.f13312e
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.limit_breach_msg
            java.lang.String r1 = r1.getString(r3)
            goto L_0x00ac
        L_0x0092:
            android.content.Context r1 = r8.f13312e
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
            android.view.View r1 = r8.f13311d
            r2 = 1053609165(0x3ecccccd, float:0.4)
            r1.setAlpha(r2)
            r8.c(r6)
            goto L_0x00c6
        L_0x00bb:
            android.view.View r1 = r8.f13311d
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r2)
            r8.c(r0)
        L_0x00c5:
            r0 = 0
        L_0x00c6:
            if (r0 != 0) goto L_0x00d1
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.j
            r8.a(r9, r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.e.a(java.lang.String):void");
    }

    public final void b() {
        this.f13316i = this.l.d();
        String obj = this.p.getText().toString();
        if (TextUtils.isEmpty(this.f13316i) || this.f13316i.equalsIgnoreCase("0")) {
            this.p.requestFocus();
            this.l.c(false);
            a((View) this.p);
        } else if (obj.length() == 4) {
            this.r.setVisibility(8);
            this.r.setText(this.f13312e.getResources().getString(R.string.incorrect_passcode));
            this.l.a(this.f13312e, this.p.getText().toString()).observeForever(new z() {
                public final void onChanged(Object obj) {
                    e.this.b((f) obj);
                }
            });
        } else if (obj.length() >= 4) {
            this.p.setBackground(androidx.core.content.b.a(this.f13312e, R.drawable.round_corner_shape));
            this.r.setVisibility(0);
            this.r.setText(this.f13312e.getResources().getString(R.string.incorrect_passcode));
            this.p.requestFocus();
            this.l.c(false);
            a((View) this.p);
        } else if (obj.length() == 0) {
            this.p.setBackground(androidx.core.content.b.a(this.f13312e, R.drawable.round_corner_shape));
            this.r.setVisibility(0);
            this.r.setText(this.f13312e.getResources().getString(R.string.enter_passcode));
            this.l.c(false);
            this.p.requestFocus();
            a((View) this.p);
        } else {
            this.p.setBackground(androidx.core.content.b.a(this.f13312e, R.drawable.round_corner_shape));
            this.r.setVisibility(0);
            this.r.setText(this.f13312e.getResources().getString(R.string.passcode_four_digit_msg));
            this.p.requestFocus();
            this.l.c(false);
            a((View) this.p);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            CJRPGInstrumentBalance cJRPGInstrumentBalance = (CJRPGInstrumentBalance) fVar.f55797b;
            this.l.c(false);
            e(false);
            if (cJRPGInstrumentBalance != null && cJRPGInstrumentBalance.getBody() != null && cJRPGInstrumentBalance.getBody().getResultInfo() != null && AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getResultInfo().getResultStatus())) {
                String resultMsg = cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                Context context = this.f13312e;
                if (TextUtils.isEmpty(resultMsg)) {
                    resultMsg = "Unable to fetch balance";
                }
                Toast.makeText(context, resultMsg, 1).show();
                this.f13313f.setPostpaidAPIFail(true);
            } else if (TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getAccountStatus()) || cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase(j.a.ACTIVE.name()) || cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase(j.a.CREDIT_FREEZED.name())) {
                Double.valueOf(0.0d);
                if (cJRPGInstrumentBalance == null || cJRPGInstrumentBalance.getBody() == null || cJRPGInstrumentBalance.getBody().getBalanceInfo() == null || TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue())) {
                    String resultMsg2 = (cJRPGInstrumentBalance.getBody().getResultInfo() == null || TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg())) ? "" : cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                    Context context2 = this.f13312e;
                    if (TextUtils.isEmpty(resultMsg2)) {
                        resultMsg2 = "Unable to fetch balance";
                    }
                    Toast.makeText(context2, resultMsg2, 1).show();
                    this.f13313f.setPostpaidAPIFail(true);
                    return;
                }
                Double valueOf = Double.valueOf(Double.parseDouble(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()));
                if (b.f().y) {
                    b.f().a(this.f13312e, valueOf.doubleValue(), this.f13313f.getmDisplayPrimaryInfo2());
                } else {
                    b.f().a(this.f13312e, valueOf.doubleValue());
                }
                this.f13315h.setVisibility(0);
                this.f13315h.setText(this.f13313f.getDisplaySecondaryInfo());
                this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
                this.f13315h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                e(false);
                if (Double.valueOf(this.f13316i).doubleValue() > valueOf.doubleValue()) {
                    this.f13311d.setAlpha(0.4f);
                    c(false);
                    this.l.s();
                    if (this.v && b.f().n.getPayMode() != null && b.f().n.getPayMode().equalsIgnoreCase("BALANCE")) {
                        this.l.a(this.f13313f, "autofetchbalance");
                    }
                } else if (!this.v || (b.f().n.getPayMode() != null && b.f().n.getPayMode().equalsIgnoreCase("BALANCE"))) {
                    this.j.setChecked(true);
                    this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    this.j.setButtonDrawable(androidx.core.content.b.a(this.f13312e, R.drawable.ic_radio_active));
                    this.l.d(SDKConstants.AI_KEY_PPBL);
                    this.l.a(this.f13313f, "uncheck");
                    this.l.a(this.f13313f, "updateSelection");
                    this.l.a(this.f13313f, "sectionClose");
                    if (!b.f().y) {
                        this.o.setVisibility(0);
                    }
                }
                this.v = false;
            } else {
                this.f13311d.setAlpha(0.4f);
                c(false);
                this.f13313f.setActive(false);
                this.f13313f.setErrorMessage(cJRPGInstrumentBalance.getBody().getDisplayMessage());
                e(false);
                this.f51247c = false;
                this.l.s();
                if (!TextUtils.isEmpty(this.f13313f.getErrorMessage())) {
                    Toast.makeText(this.f13312e, this.f13313f.getErrorMessage(), 1).show();
                }
                this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
                this.f13315h.setVisibility(8);
            }
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (this.l.a("generic_api_call_fail", bundle, gVar.f55801c)) {
                e(false);
                return;
            }
            Toast.makeText(this.f13312e, "Unable to fetch balance", 1).show();
            e.class.getSimpleName();
            q.d(gVar.f55801c.getMessage());
            e(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            if (iJRPaytmDataModel instanceof CJRVerifyPasscodeResponse) {
                CJRVerifyPasscodeResponse cJRVerifyPasscodeResponse = (CJRVerifyPasscodeResponse) iJRPaytmDataModel;
                this.l.c(false);
                if (!TextUtils.isEmpty(cJRVerifyPasscodeResponse.getError())) {
                    this.p.setBackground(androidx.core.content.b.a(this.f13312e, R.drawable.round_corner_red_shape));
                    this.r.setVisibility(0);
                } else {
                    h();
                    this.r.setVisibility(8);
                    this.s = cJRVerifyPasscodeResponse.getAccessToken();
                    InstrumentInfo instrumentInfo = b.f().n;
                    if (instrumentInfo != null) {
                        if ("PAYTM_DIGITAL_CREDIT".equalsIgnoreCase(instrumentInfo.getPayMode())) {
                            instrumentInfo.setPaymentDetails(instrumentInfo.getPaymentDetails() + "|" + this.s);
                        } else {
                            instrumentInfo.setPaymentDetails(this.s);
                        }
                        this.l.a(instrumentInfo, "proceedtoPay");
                    } else {
                        return;
                    }
                }
            }
            if (iJRPaytmDataModel instanceof CJRPGInstrumentBalance) {
                CJRPGInstrumentBalance cJRPGInstrumentBalance = (CJRPGInstrumentBalance) iJRPaytmDataModel;
                if (cJRPGInstrumentBalance.getBody() == null) {
                    Toast.makeText(this.f13312e, "Unable to fetch balance", 1).show();
                    this.f13313f.setPostpaidAPIFail(true);
                    e(false);
                } else if (cJRPGInstrumentBalance.getBody().getResultInfo() == null) {
                    Toast.makeText(this.f13312e, "Unable to fetch balance", 1).show();
                    this.f13313f.setPostpaidAPIFail(true);
                    e(false);
                } else if (AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getResultInfo().getResultStatus())) {
                    String resultMsg = cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg();
                    Context context = this.f13312e;
                    if (TextUtils.isEmpty(resultMsg)) {
                        resultMsg = "Unable to fetch balance";
                    }
                    Toast.makeText(context, resultMsg, 1).show();
                    this.f13313f.setPostpaidAPIFail(true);
                    e(false);
                } else if (cJRPGInstrumentBalance.getBody().getBalanceInfo() == null || TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()) || (!TextUtils.isEmpty(cJRPGInstrumentBalance.getBody().getAccountStatus()) && !cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase(j.a.ACTIVE.name()))) {
                    this.f13313f.setActive(false);
                    this.f13313f.setErrorMessage(cJRPGInstrumentBalance.getBody().getDisplayMessage());
                    this.f13313f.setPostpaidAPIFail(true);
                    e(false);
                    this.f13311d.setAlpha(0.4f);
                    c(false);
                    if (!TextUtils.isEmpty(this.f13313f.getErrorMessage())) {
                        Toast.makeText(this.f13312e, this.f13313f.getErrorMessage(), 1).show();
                    }
                    this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                    this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
                    this.f13315h.setVisibility(8);
                } else {
                    Double valueOf = Double.valueOf(Double.parseDouble(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue()));
                    b.f().a(cJRPGInstrumentBalance.getBody().getBalanceInfo().getValue(), cJRPGInstrumentBalance.getBody().getPasscodeRequired(), "ACTIVE".equalsIgnoreCase(cJRPGInstrumentBalance.getBody().getAccountStatus()));
                    this.f13315h.setVisibility(0);
                    this.f13315h.setText(this.f13313f.getDisplaySecondaryInfo());
                    this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
                    this.f13315h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    e(false);
                    if (Double.valueOf(this.f13316i).doubleValue() > valueOf.doubleValue()) {
                        this.f13311d.setAlpha(0.4f);
                        c(false);
                        if (cJRPGInstrumentBalance.getBody().getAccountStatus() != null && !cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase("ACTIVE")) {
                            this.f13313f.setActive(false);
                            this.f13313f.setErrorMessage(cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg());
                            this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                            this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
                        }
                        this.l.a(this.f13313f, "autofetchbalance");
                    } else if (this.v || !this.f13313f.getPasscodeRequired().equalsIgnoreCase("true")) {
                        this.j.setChecked(true);
                        this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                        this.j.setButtonDrawable(androidx.core.content.b.a(this.f13312e, R.drawable.ic_radio_active));
                        this.l.a(this.f13313f, "uncheck");
                        this.l.a(this.f13313f, "updateSelection");
                        this.l.a(this.f13313f, "sectionClose");
                    } else {
                        this.j.setChecked(true);
                        this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                        this.j.setButtonDrawable(androidx.core.content.b.a(this.f13312e, R.drawable.ic_radio_active));
                        this.l.a(this.f13313f, "uncheck");
                        this.l.a(this.f13313f, "updateSelection");
                        this.l.a(this.f13313f, "sectionClose");
                        this.o.setVisibility(0);
                        if (cJRPGInstrumentBalance.getBody().getAccountStatus() != null && !cJRPGInstrumentBalance.getBody().getAccountStatus().equalsIgnoreCase("ACTIVE")) {
                            this.f13313f.setActive(false);
                            this.f13313f.setErrorMessage(cJRPGInstrumentBalance.getBody().getResultInfo().getResultMsg());
                            this.f13314g.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                            this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_666666));
                        }
                    }
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            this.l.c(false);
            net.one97.paytm.network.g gVar = fVar.f55798c;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!this.l.a("verify_passcode", bundle, fVar.f55798c.f55801c)) {
                if (gVar.f55799a == 400 && (gVar.f55800b instanceof CJRVerifyPasscodeResponse)) {
                    String str = new String(gVar.f55801c.networkResponse.data);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("error_description")) {
                                String string = jSONObject.getString("error_description");
                                this.p.setBackground(androidx.core.content.b.a(this.f13312e, R.drawable.round_corner_red_shape));
                                this.r.setVisibility(0);
                                this.r.setText(string);
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                NetworkCustomError networkCustomError = gVar.f55801c;
                if (networkCustomError.getFullUrl().equals(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13312e, UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW))) {
                    e(false);
                    this.f13315h.setVisibility(0);
                    this.f13315h.setTextColor(androidx.core.content.b.c(this.f13312e, R.color.color_00b9f5));
                    this.f13315h.setText(this.f13312e.getString(R.string.retry_fetching_balance));
                    this.f13315h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f13312e.getResources().getDrawable(R.drawable.refresh_icon), (Drawable) null);
                    if (this.v) {
                        this.v = false;
                        this.l.a(this.f13313f, "autoFetchBalance");
                    }
                } else if (networkCustomError.getFullUrl().contains(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13312e, "pgWalletBalanceURL"))) {
                    Context context2 = this.f13312e;
                    Toast.makeText(context2, context2.getString(R.string.unable_to_fetch_paytm_wallet_p2m), 1).show();
                }
            }
        }
    }
}
