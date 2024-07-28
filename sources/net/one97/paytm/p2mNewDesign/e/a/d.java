package net.one97.paytm.p2mNewDesign.e.a;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.j;
import androidx.lifecycle.z;
import com.paytm.utility.q;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.d.b;
import net.one97.paytm.p2mNewDesign.e.a;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchBinDetailsV2;
import net.one97.paytm.p2mNewDesign.entity.HasLowSuccessRate;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.a;
import net.one97.paytm.wallet.entity.CardExpiryEditText;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a implements View.OnClickListener {
    private static String Q = "offline_PG";
    private static String R = "home/pay-send/post-scan";
    /* access modifiers changed from: private */
    public EditText A;
    /* access modifiers changed from: private */
    public String B;
    private InstrumentInfo C;
    /* access modifiers changed from: private */
    public LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    /* access modifiers changed from: private */
    public int G;
    private TextView H;
    /* access modifiers changed from: private */
    public String I;
    private CheckBox J;
    private CheckBox K;
    private boolean L;
    /* access modifiers changed from: private */
    public TextView M;
    private g N;
    private j O;
    private TextView P;
    /* access modifiers changed from: private */
    public boolean S;
    /* access modifiers changed from: private */
    public boolean T;
    /* access modifiers changed from: private */
    public boolean U;
    private boolean V;
    private RelativeLayout W;
    private String X;
    private net.one97.paytm.p2mNewDesign.models.a Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13294a;
    private List<View> aa = new ArrayList();
    private List<View> ab = new ArrayList();
    /* access modifiers changed from: private */
    public boolean ac;
    private b ad;
    /* access modifiers changed from: private */
    public LinearLayout ae;
    private String af;
    /* access modifiers changed from: private */
    public String ag;
    /* access modifiers changed from: private */
    public String ah;
    private String ai;
    private boolean aj;
    private LinearLayout ak;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f13295b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13296d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f13297e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f13298f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f13299g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CardExpiryEditText f13300h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ImageView f13301i;
    /* access modifiers changed from: private */
    public ImageView j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public int o;
    private RadioButton p;
    private String q;
    private TextView r;
    /* access modifiers changed from: private */
    public TextView s;
    private RelativeLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private RadioButton w;
    private RelativeLayout x;
    private RelativeLayout y;
    private EditText z;

    private void k() {
        this.u = (LinearLayout) LayoutInflater.from(this.f13298f).inflate(R.layout.lyt_pay_with_new_card, (ViewGroup) null);
        this.F.addView(this.u);
        a((View) this.u);
    }

    public final void onClick(View view) {
        boolean z2;
        boolean z3;
        int id = view.getId();
        String u2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().u(this.q);
        if (!TextUtils.isEmpty(u2) && !"0".equalsIgnoreCase(u2) && Double.parseDouble(u2) < Double.valueOf(this.N.d()).doubleValue()) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.q)) {
                this.N.a(String.format(this.f13298f.getResources().getString(R.string.merchant_limit_exhaust_p2m), new Object[]{u2}), false, false);
                return;
            }
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.q)) {
            this.N.a("0".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A) ? this.f13298f.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13298f.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A}), false, false);
        } else if (id == R.id.iv_clear) {
            this.f13299g.getText().clear();
            this.f13300h.getText().clear();
            this.A.getText().clear();
            this.f13299g.requestFocus();
        } else if (id == R.id.tv_cvv_help) {
            this.A.clearFocus();
            this.f13299g.clearFocus();
            this.f13300h.clearFocus();
            b((View) this.f13297e);
            b bVar = this.ad;
            if (bVar == null || !bVar.isAdded()) {
                if (TextUtils.isEmpty(this.B)) {
                    this.ad = b.a(b.a.ALL);
                } else if (!this.B.equalsIgnoreCase("AMEX")) {
                    this.ad = b.a(b.a.NON_AMEX);
                } else {
                    this.ad = b.a(b.a.AMEX);
                }
                this.ad.show(this.O, (String) null);
            }
        } else if (id == R.id.rb_instrumentInfo || id == R.id.rl_pay_mode_pg) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().L) {
                this.p.setButtonDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.ic_radio_active));
                this.N.d(this.C.getPayMode());
                a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", this.f13298f, R);
                LinearLayout linearLayout = this.f13297e;
                boolean booleanValue = (linearLayout == null || linearLayout.getTag() == null) ? false : ((Boolean) this.f13297e.getTag()).booleanValue();
                InstrumentInfo instrumentInfo = new InstrumentInfo();
                instrumentInfo.setPayMode(this.q);
                if (!booleanValue) {
                    z2 = false;
                } else {
                    z2 = this.V;
                }
                instrumentInfo.setEmiTypeCard(z2);
                if (!booleanValue) {
                    z3 = false;
                } else {
                    z3 = this.V;
                }
                instrumentInfo.setEmiClicked(z3);
                instrumentInfo.setDisplayPrimaryInfo("");
                this.N.a(instrumentInfo, "sectionClose");
                this.N.a(instrumentInfo, "updateSelection");
                this.N.a(instrumentInfo, "uncheck");
                TextView textView = this.H;
                if (textView != null) {
                    textView.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_00b9f5));
                }
                this.F.setVisibility(0);
                this.f13299g.requestFocus();
                a((View) this.u);
                return;
            }
            this.f51247c = false;
        } else if (id == R.id.tv_pay_with_new_debit_card) {
            this.N.a(this.C, "uncheck");
            this.H.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_222222));
            a((View) this.u);
        } else if (id == R.id.rl_proceed_to_pay) {
            o();
        }
    }

    private static String c(String str) {
        String valueOf = String.valueOf(Calendar.getInstance().get(1) / 100);
        StringBuilder sb = new StringBuilder(str);
        sb.insert(0, valueOf);
        return sb.toString();
    }

    private void a(View view) {
        this.S = false;
        this.aj = false;
        this.U = false;
        this.T = false;
        RelativeLayout relativeLayout = this.x;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.ae;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.ae.setVisibility(8);
        }
        RadioButton radioButton = this.w;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.ic_radio_inactive));
        }
        this.v = (LinearLayout) view.findViewById(R.id.lyt_new_card);
        this.v.setVisibility(0);
        l();
        this.y = (RelativeLayout) view.findViewById(R.id.rl_proceed_to_pay);
        this.y.setTag("new card");
        this.y.setVisibility(8);
        this.y.setOnClickListener(this);
    }

    public static boolean b(String str) {
        int i2 = 0;
        boolean z2 = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (z2 && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i2 += parseInt;
            z2 = !z2;
        }
        return i2 % 10 == 0;
    }

    private void d(String str) {
        Toast.makeText(this.f13298f, str, 0).show();
    }

    private void l() {
        this.f13299g = (EditText) this.v.findViewById(R.id.editText);
        this.f13301i = (ImageView) this.v.findViewById(R.id.iv_clear);
        this.j = (ImageView) this.v.findViewById(R.id.iv_card_logo);
        this.k = (TextView) this.v.findViewById(R.id.tv_cvv_help);
        this.f13300h = (CardExpiryEditText) this.v.findViewById(R.id.et_expiry_validity);
        this.f13300h.setFocusableInTouchMode(true);
        this.m = (TextView) this.v.findViewById(R.id.tv_expiry_validity);
        this.l = (TextView) this.v.findViewById(R.id.tv_enter_card_number);
        this.A = (EditText) this.v.findViewById(R.id.et_new_card_cvv);
        this.s = (TextView) this.v.findViewById(R.id.tv_enter_cvv);
        this.D = (LinearLayout) this.v.findViewById(R.id.ll_new_card_cvv);
        this.ak = (LinearLayout) this.v.findViewById(R.id.lyt_card_auto_saved);
        this.E = (LinearLayout) this.v.findViewById(R.id.ll_save_card_for_future);
        this.J = (CheckBox) this.E.findViewById(R.id.cb_save_card);
        this.M = (TextView) this.v.findViewById(R.id.tv_low_success);
        this.v.findViewById(R.id.shield_icon).setVisibility(0);
        try {
            ((ImageView) this.v.findViewById(R.id.shield_icon)).setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.auto_save_shield));
        } catch (Exception unused) {
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = false;
        c((View) this.v);
        this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
        this.f13300h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        this.ak.setVisibility(0);
        this.f13299g.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                d dVar = d.this;
                dVar.b((View) dVar.f13299g);
                return false;
            }
        });
        this.A.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                d dVar = d.this;
                dVar.b((View) dVar.A);
                return false;
            }
        });
        this.f13300h.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                d dVar = d.this;
                dVar.b((View) dVar.f13300h);
                return false;
            }
        });
        this.k.setOnClickListener(this);
        this.f13301i.setOnClickListener(this);
        this.f13299g.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    d.this.f13301i.setVisibility(0);
                } else {
                    d.this.f13301i.setVisibility(8);
                }
                if (charSequence.length() <= 6) {
                    String unused = d.this.B = "";
                    d.this.D.setAlpha(1.0f);
                    d.this.A.setEnabled(true);
                    d.this.f13300h.setEnabled(true);
                    d.this.f13300h.setAlpha(1.0f);
                    d.this.k.setOnClickListener(d.this);
                    d.this.m.setEnabled(true);
                    d.this.m.setAlpha(1.0f);
                    d.this.j.setImageDrawable((Drawable) null);
                    d.this.M.setVisibility(8);
                    boolean unused2 = d.this.f13296d = false;
                    boolean unused3 = d.this.f13294a = false;
                    d.this.d();
                } else if (d.this.o < 7) {
                    d.a(d.this, charSequence.toString().replace(" ", ""));
                }
                int unused4 = d.this.o = charSequence.length();
            }

            public final void afterTextChanged(Editable editable) {
                String unused = d.this.I = editable.toString().replace(" ", "");
                if (d.this.n > 0 && d.this.I.length() > d.this.n - (d.this.n / 5) && editable.toString().replace(" ", "").length() >= 6) {
                    editable.delete(d.this.n - (d.this.n / 5), editable.length());
                }
                int i2 = 0;
                while (i2 < editable.length()) {
                    if (' ' == editable.charAt(i2)) {
                        int i3 = i2 + 1;
                        if (i3 % 5 != 0 || i3 == editable.length()) {
                            editable.delete(i2, i3);
                        }
                    }
                    i2++;
                }
                for (int i4 = 4; i4 < editable.length(); i4 += 5) {
                    if ("0123456789".indexOf(editable.charAt(i4)) >= 0) {
                        editable.insert(i4, " ");
                    }
                }
                if (d.this.f13299g.getSelectionStart() > 0 && editable.charAt(d.this.f13299g.getSelectionStart() - 1) == ' ') {
                    d.this.f13299g.setSelection(d.this.f13299g.getSelectionStart() - 1);
                }
                if (editable.toString().length() != d.this.n || TextUtils.isEmpty(d.this.I)) {
                    if (d.this.ac || editable.length() < 6) {
                        d.this.f13299g.setBackground(androidx.core.content.b.a(d.this.f13298f, R.drawable.white_background_with_border));
                        d.this.l.setText(d.this.f13298f.getString(R.string.enter_card_number));
                        d.this.l.setTextColor(androidx.core.content.b.c(d.this.f13298f, R.color.color_444444));
                        boolean unused2 = d.this.S = false;
                    }
                } else if (!d.b(d.this.I)) {
                    d.this.l.setText(d.this.f13298f.getString(R.string.enter_valid_card_number));
                    d.this.l.setTextColor(androidx.core.content.b.c(d.this.f13298f, R.color.color_fd5c5c));
                    d.this.f13299g.setBackground(androidx.core.content.b.a(d.this.f13298f, R.drawable.red_background_with_border));
                    boolean unused3 = d.this.S = false;
                } else {
                    if (!d.this.S) {
                        boolean unused4 = d.this.S = true;
                        d.this.a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", d.this.f13298f);
                    }
                    if (d.this.f13296d && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().G && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null) {
                        d.this.m();
                        net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
                        net.one97.paytm.wallet.i.b.a(d.this.f13298f, d.this.ag, d.this.ah, "", new a.b() {
                            public final void a(boolean z, boolean z2, String str) {
                                if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().P) {
                                    boolean unused = d.this.f13294a = z;
                                    if (!z2) {
                                        d.this.d();
                                    } else if (!z) {
                                        d.this.f13295b.setVisibility(8);
                                        d.this.ae.setVisibility(0);
                                        d.this.ae.startAnimation(AnimationUtils.loadAnimation(d.this.f13298f, R.anim.wallet_vscp_shake));
                                    } else if (d.v(d.this)) {
                                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = true;
                                        d.this.ae.clearAnimation();
                                        d.this.ae.setVisibility(8);
                                        d.this.f13295b.setVisibility(0);
                                    }
                                }
                            }

                            public final void a(String str, String str2) {
                                a(false, false, (String) null);
                            }
                        });
                    }
                    d.this.f13300h.requestFocus();
                }
            }
        });
        this.A.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                d.this.A.setBackground(androidx.core.content.b.a(d.this.f13298f, R.drawable.white_background_with_border));
                d.this.s.setText(d.this.f13298f.getString(R.string.cvv));
                d.this.s.setTextColor(androidx.core.content.b.c(d.this.f13298f, R.color.color_444444));
                if (charSequence.length() == d.this.G) {
                    d dVar = d.this;
                    dVar.b((View) dVar.A);
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.length() != d.this.G) {
                    boolean unused = d.this.U = false;
                } else if (!d.this.U) {
                    boolean unused2 = d.this.U = true;
                    d.this.a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", d.this.f13298f);
                }
            }
        });
        this.f13300h.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                StringBuilder sb = new StringBuilder(charSequence);
                if (sb.length() > 0 && sb.length() == 3 && '/' == sb.charAt(sb.length() - 1)) {
                    sb.delete(sb.length() - 1, sb.length());
                }
                if (sb.length() > 0 && sb.length() == 3 && Character.isDigit(sb.charAt(sb.length() - 1))) {
                    sb.insert(sb.length() - 1, "/");
                }
                if (charSequence.length() < 5) {
                    d.this.m.setText(d.this.f13298f.getString(R.string.expiry_validity_date));
                    d.this.m.setTextColor(androidx.core.content.b.c(d.this.f13298f, R.color.color_444444));
                    d.this.f13300h.setBackground(androidx.core.content.b.a(d.this.f13298f, R.drawable.white_background_with_border));
                }
                d.this.f13300h.removeTextChangedListener(this);
                d.this.f13300h.setText(sb);
                d.this.f13300h.addTextChangedListener(this);
                if (sb.length() == 5 && d.this.D.isEnabled()) {
                    d.this.A.requestFocus();
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null) {
                    return;
                }
                if (editable.toString().length() != 5 || !d.this.D.isEnabled()) {
                    boolean unused = d.this.T = false;
                } else if (!d.this.T) {
                    boolean unused2 = d.this.T = true;
                    d.this.a("offline_payments", "post_scan_card_selected", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", d.this.f13298f);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void m() {
        this.af = this.f13299g.getText().toString().replace(" ", "");
        this.ai = this.f13300h.getText().toString().replace("/", "");
        if (!TextUtils.isEmpty(this.af)) {
            this.ag = this.af.substring(0, 6);
            String str = this.af;
            this.ah = str.substring(str.length() - 4);
        }
    }

    /* access modifiers changed from: private */
    public void b(View view) {
        Context context = this.f13298f;
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    private static boolean e(String str) {
        String[] split = str.split("/");
        if (split.length > 2) {
            return false;
        }
        split[1] = c(split[1]);
        Calendar instance = Calendar.getInstance();
        return Integer.valueOf(split[0]).intValue() <= 12 && (Integer.valueOf(split[1]).intValue() > instance.get(1) || (Integer.valueOf(split[1]).intValue() == instance.get(1) && Integer.valueOf(split[0]).intValue() > instance.get(2)));
    }

    public final void a(g gVar) {
        this.N = gVar;
    }

    private void n() {
        RadioButton radioButton = this.p;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.ic_radio_inactive));
        }
        RelativeLayout relativeLayout = this.y;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        EditText editText = this.z;
        if (editText != null) {
            editText.setVisibility(8);
        }
        TextView textView = this.P;
        if (textView != null) {
            textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        TextView textView2 = this.r;
        if (textView2 != null) {
            textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        RelativeLayout relativeLayout2 = this.x;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        LinearLayout linearLayout = this.ae;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.ae.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.W;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.F;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private void o() {
        int length = this.f13299g.getText().length();
        if (TextUtils.isEmpty(this.f13299g.getText()) || length < 17 || length > 23) {
            this.l.setText(this.f13298f.getString(R.string.enter_valid_card_number));
            this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
            this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
            this.N.c(false);
        } else if (!this.ac) {
            d(this.f13298f.getString(R.string.please_enter_correct_card));
            this.N.c(false);
        } else {
            String str = this.B;
            if (str == null) {
                this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.white_background_with_border));
                this.l.setText(this.f13298f.getString(R.string.enter_card_number));
                this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_444444));
            } else if ((!str.equalsIgnoreCase("DINERS") || length == 17) && ((!this.B.equalsIgnoreCase("AMEX") || length == 18) && (((!this.B.equalsIgnoreCase("DISCOVER") && !this.B.equalsIgnoreCase(SDKConstants.VISA) && !this.B.equalsIgnoreCase("MASTER") && !this.B.equalsIgnoreCase("RUPAY")) || length == 19) && (!this.B.equalsIgnoreCase(SDKConstants.MAESTRO) || length == 23)))) {
                this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.white_background_with_border));
                this.l.setText(this.f13298f.getString(R.string.enter_card_number));
                this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_444444));
                if (!this.f13300h.isEnabled() || (!TextUtils.isEmpty(this.f13300h.getText().toString()) && this.f13300h.getText().length() >= 5 && e(this.f13300h.getText().toString()))) {
                    this.m.setText(this.f13298f.getString(R.string.expiry_validity_date));
                    this.m.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_444444));
                    if (!this.A.isEnabled() || this.A.getText().length() >= this.G) {
                        this.C = new InstrumentInfo();
                        this.C.setPayMode(this.V ? "EMI" : this.q);
                        if (this.V) {
                            this.C.setPlanId(this.Y.f56918a);
                            this.C.setEmiType(this.q);
                            this.C.setSelectedEMIPlan(this.Y);
                        }
                        String[] split = this.f13300h.getText().toString().split("/");
                        if (split == null || split.length <= 1) {
                            InstrumentInfo instrumentInfo = this.C;
                            instrumentInfo.setPaymentDetails("|" + this.I + "|" + this.A.getText() + "|");
                        } else {
                            InstrumentInfo instrumentInfo2 = this.C;
                            instrumentInfo2.setPaymentDetails("|" + this.I + "|" + this.A.getText() + "|" + split[0] + c(split[1]));
                        }
                        this.C.setPaymentTypeId(this.q.equalsIgnoreCase(SDKConstants.CREDIT) ? Constants.EASYPAY_PAYTYPE_CREDIT_CARD : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
                        JSONObject jSONObject = this.C.getmAdditionalParams();
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                        try {
                            jSONObject.put(CJRPGTransactionRequestUtils.STORE_CARD, this.J.isChecked() ? "1" : "0");
                            if (this.L) {
                                jSONObject.put("addMoney", "1");
                            }
                        } catch (JSONException e2) {
                            this.N.c(false);
                            q.d(String.valueOf(e2));
                        }
                        this.C.setmAdditionalParams(jSONObject);
                        this.C.setCardFirstSixDigit(this.ag);
                        this.C.setCardLastFourDigit(this.ah);
                        this.C.setExpiryDate(this.ai);
                        InstrumentInfo instrumentInfo3 = this.C;
                        instrumentInfo3.setUniqueId(instrumentInfo3.getPayMode());
                        this.C.setIsScpEnrolled(this.f13294a);
                        this.C.setOneClickSupported(this.f13296d);
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.C);
                        this.N.a(this.C, "proceedToPay");
                        return;
                    }
                    this.A.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
                    this.s.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
                    this.s.setText(this.f13298f.getString(R.string.enter_valid_cvv));
                    this.N.c(false);
                    return;
                }
                this.m.setText(this.f13298f.getString(R.string.invalid_expiry_date));
                this.m.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
                this.f13300h.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
                this.N.c(false);
            } else {
                this.l.setText(this.f13298f.getString(R.string.enter_valid_card_number));
                this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
                this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
                this.N.c(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, String str3, Context context) {
        if (this.T && this.U && this.S) {
            try {
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvents(str, str2, str3, (String) null, context, "home/pay-send/post-scan/card-details-entered", Q);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    public final void d() {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = false;
        CheckBox checkBox = this.K;
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        LinearLayout linearLayout = this.ae;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.ae.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.f13295b;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void c(View view) {
        this.f13295b = (RelativeLayout) view.findViewById(R.id.lyt_scp_enabled);
        this.f13295b.findViewById(R.id.scp_enabled_info_cta).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.f(view);
            }
        });
        TextView textView = (TextView) this.f13295b.findViewById(R.id.scp_enabled_tv);
        if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13298f, SDKConstants.KEY_SCP_ENABLED_TEXT))) {
            textView.setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13298f, SDKConstants.KEY_SCP_ENABLED_TEXT));
        }
        this.ae = (LinearLayout) view.findViewById(R.id.ll_visa_one_click);
        this.ae.findViewById(R.id.visa_one_click_info_cta).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.e(view);
            }
        });
        this.K = (CheckBox) this.ae.findViewById(R.id.cb_visa_one_click);
        this.ae.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.d(view);
            }
        });
        ((TextView) view.findViewById(R.id.tv_enable_visa_one_click)).setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13298f, SDKConstants.KEY_ENABLE_SCP_TEXT));
        this.K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                d.this.a(compoundButton, z);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        this.N.p();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.N.o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        CheckBox checkBox = this.K;
        checkBox.setChecked(!checkBox.isChecked());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isChecked()) {
            m();
            if (!TextUtils.isEmpty(this.ag) && !TextUtils.isEmpty(this.ah)) {
                net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
                net.one97.paytm.wallet.i.b.a(this.f13298f, this.ag, this.ah, "");
            }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = true;
            return;
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().F = false;
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z2) {
        String str2;
        int i2;
        Context context2;
        if (!instrumentInfo.isEMICard()) {
            this.f13298f = context;
            this.f13297e = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card, (ViewGroup) null);
            this.f13297e.setTag(Boolean.FALSE);
            this.q = instrumentInfo.getPayMode();
            this.t = (RelativeLayout) this.f13297e.findViewById(R.id.rl_pay_mode_pg);
            this.t.setOnClickListener(this);
            this.F = (LinearLayout) this.f13297e.findViewById(R.id.ll_card_expand);
            this.p = (RadioButton) this.f13297e.findViewById(R.id.rb_instrumentInfo);
            this.p.setOnClickListener(this);
            this.r = (TextView) this.f13297e.findViewById(R.id.tv_pay_mode);
            TextView textView = this.r;
            if (this.q.equalsIgnoreCase(SDKConstants.DEBIT)) {
                context2 = this.f13298f;
                i2 = R.string.debit_card_pay_mode;
            } else {
                context2 = this.f13298f;
                i2 = R.string.credit_card;
            }
            textView.setText(context2.getString(i2));
            this.C = instrumentInfo;
            k();
            this.O = this.N.getFragmentManager();
        } else {
            this.f13298f = context;
            this.q = instrumentInfo.getPayMode();
            this.V = true;
            this.X = instrumentInfo.getBankCode();
            this.Y = instrumentInfo.getSelectedEMIPlan();
            this.Z = true;
            boolean isSavedCardPresent = instrumentInfo.isSavedCardPresent();
            this.f13297e = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card, (ViewGroup) null);
            this.f13297e.setTag(Boolean.TRUE);
            this.t = (RelativeLayout) this.f13297e.findViewById(R.id.rl_pay_mode_pg);
            this.t.setOnClickListener(this);
            this.F = (LinearLayout) this.f13297e.findViewById(R.id.ll_card_expand);
            this.p = (RadioButton) this.f13297e.findViewById(R.id.rb_instrumentInfo);
            this.p.setOnClickListener(this);
            this.r = (TextView) this.f13297e.findViewById(R.id.tv_pay_mode);
            k();
            if (SDKConstants.DEBIT.equalsIgnoreCase(this.C.getPayMode())) {
                str2 = "Debit";
            } else {
                str2 = SDKConstants.CREDIT.equalsIgnoreCase(this.C.getPayMode()) ? "Credit" : "";
            }
            this.r.setText(isSavedCardPresent ? String.format(context.getString(R.string.emi_new_card_title), new Object[]{str2}) : context.getString(R.string.p2m_enter_card_details));
            this.O = this.N.getFragmentManager();
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.q)) {
            this.f13297e.setAlpha(0.4f);
        }
    }

    public final String a() {
        return this.C.getPayMode();
    }

    public final void a(boolean z2) {
        if (z2) {
            this.t.performClick();
        } else {
            n();
        }
    }

    public final void b(boolean z2) {
        if (!z2) {
            n();
        }
    }

    public final View c() {
        return this.f13297e;
    }

    public final void b() {
        o();
    }

    public final boolean a(List<net.one97.paytm.p2mNewDesign.db.b.a> list) {
        if (list != null) {
            Iterator<net.one97.paytm.p2mNewDesign.db.b.a> it2 = list.iterator();
            if (it2.hasNext()) {
                net.one97.paytm.p2mNewDesign.db.b.a next = it2.next();
                if (SDKConstants.DEBIT.equalsIgnoreCase(next.f51232b) || SDKConstants.CREDIT.equalsIgnoreCase(next.f51232b)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final String e() {
        return this.C.getPriority();
    }

    public final boolean f() {
        if (this.C.getmIsDisabled() == null) {
            return false;
        }
        return this.C.getmIsDisabled().getStatus().booleanValue();
    }

    public final boolean g() {
        return SDKConstants.DEBIT.equalsIgnoreCase(this.q);
    }

    public final void h() {
        this.f13297e.setAlpha(0.4f);
    }

    public final void j() {
        this.f13297e.setAlpha(1.0f);
    }

    public final void i() {
        b((View) this.f13297e);
    }

    public final void a(String str) {
        String str2;
        String str3;
        String u2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().u(this.q);
        if (!TextUtils.isEmpty(u2) && !"0".equalsIgnoreCase(u2) && Double.parseDouble(u2) < Double.valueOf(str).doubleValue()) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.q)) {
                if (SDKConstants.DEBIT.equalsIgnoreCase(this.q)) {
                    List<View> list = this.aa;
                    if (list != null && list.size() > 0) {
                        for (View next : this.aa) {
                            next.findViewById(R.id.et_cvv).setEnabled(false);
                            next.setAlpha(0.4f);
                        }
                    }
                    this.f13297e.setAlpha(0.4f);
                    c(false);
                    return;
                }
                List<View> list2 = this.aa;
                if (list2 != null && list2.size() > 0) {
                    for (View next2 : this.aa) {
                        next2.findViewById(R.id.et_cvv).setEnabled(false);
                        next2.setAlpha(0.4f);
                    }
                }
                this.f13297e.setAlpha(0.4f);
                c(false);
                return;
            }
        }
        if (TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A)) {
            str2 = "0";
        } else {
            str2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A;
        }
        if (Double.parseDouble(str2) < Double.valueOf(str).doubleValue()) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(this.q)) {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && this.q.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                    g gVar = this.N;
                    if ("0".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A)) {
                        str3 = this.f13298f.getResources().getString(R.string.limit_breach_msg);
                    } else {
                        str3 = String.format(this.f13298f.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A});
                    }
                    gVar.a(str3, false, false);
                }
                List<View> list3 = this.ab;
                if (list3 != null && list3.size() > 0) {
                    for (View next3 : this.ab) {
                        next3.findViewById(R.id.et_cvv).setEnabled(false);
                        next3.setAlpha(0.4f);
                    }
                }
                List<View> list4 = this.aa;
                if (list4 != null && list4.size() > 0) {
                    for (View next4 : this.aa) {
                        next4.findViewById(R.id.et_cvv).setEnabled(false);
                        next4.setAlpha(0.4f);
                    }
                }
                this.f13297e.setAlpha(0.4f);
                return;
            }
            return;
        }
        this.f13297e.setAlpha(1.0f);
        List<View> list5 = this.ab;
        if (list5 != null && list5.size() > 0) {
            for (View next5 : this.ab) {
                this.f13297e.setEnabled(true);
                next5.findViewById(R.id.et_cvv).setEnabled(true);
                next5.setAlpha(1.0f);
            }
        }
        List<View> list6 = this.aa;
        if (list6 != null && list6.size() > 0) {
            for (View next6 : this.aa) {
                this.f13297e.setEnabled(true);
                next6.findViewById(R.id.et_cvv).setEnabled(true);
                next6.setAlpha(1.0f);
            }
        }
        c(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        String str;
        String str2;
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof CJRFetchBinDetailsV2) {
                CJRFetchBinDetailsV2 cJRFetchBinDetailsV2 = (CJRFetchBinDetailsV2) fVar.f55797b;
                if (cJRFetchBinDetailsV2.getBody() != null) {
                    this.f13296d = cJRFetchBinDetailsV2.getBody().isOneClickSupported();
                    if (cJRFetchBinDetailsV2.getBody().getResultInfo() != null && AppConstants.FEED_SUB_TYPE.equalsIgnoreCase(cJRFetchBinDetailsV2.getBody().getResultInfo().getResultStatus())) {
                        this.l.setText(TextUtils.isEmpty(cJRFetchBinDetailsV2.getBody().getResultInfo().getResultMsg()) ? String.format(this.f13298f.getResources().getString(R.string.emi_valid_card_details), new Object[]{this.q.equalsIgnoreCase(SDKConstants.CREDIT) ? "Credit" : "Debit"}) : cJRFetchBinDetailsV2.getBody().getResultInfo().getResultMsg());
                        this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
                        this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
                        this.S = false;
                        this.ac = false;
                    } else if (this.V && cJRFetchBinDetailsV2.getBody().getBinDetail() != null && (str2 = this.X) != null && !str2.equalsIgnoreCase(cJRFetchBinDetailsV2.getBody().getBinDetail().getIssuingBank())) {
                        this.l.setText(String.format(this.f13298f.getResources().getString(R.string.emi_choose_valid_bank), new Object[]{this.X}));
                        this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
                        this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
                        this.S = false;
                        this.ac = false;
                    } else if (cJRFetchBinDetailsV2.getBody().getBinDetail() == null || (str = this.q) == null || str.equalsIgnoreCase(cJRFetchBinDetailsV2.getBody().getBinDetail().getPaymentMode())) {
                        this.ac = true;
                        HasLowSuccessRate hasLowSuccessRate = cJRFetchBinDetailsV2.getBody().getHasLowSuccessRate();
                        if (hasLowSuccessRate != null && hasLowSuccessRate.getStatus()) {
                            this.M.setVisibility(0);
                            this.M.setText(hasLowSuccessRate.getMsg());
                        }
                        if (cJRFetchBinDetailsV2.getBody().getBinDetail() != null) {
                            this.B = cJRFetchBinDetailsV2.getBody().getBinDetail().getChannelName().toLowerCase();
                            String channelCode = cJRFetchBinDetailsV2.getBody().getBinDetail().getChannelCode();
                            String iconUrl = cJRFetchBinDetailsV2.getBody().getEmiChannel() == null ? "" : cJRFetchBinDetailsV2.getBody().getEmiChannel().getIconUrl();
                            String str3 = this.q;
                            if (this.B.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                                this.D.setAlpha(0.4f);
                                this.D.setEnabled(false);
                                this.A.setEnabled(false);
                                this.f13300h.setEnabled(false);
                                this.f13300h.setAlpha(0.4f);
                                this.k.setOnClickListener((View.OnClickListener) null);
                                this.m.setEnabled(false);
                                this.m.setAlpha(0.4f);
                            } else {
                                this.f13300h.setEnabled(true);
                                this.f13300h.setAlpha(1.0f);
                                this.m.setEnabled(true);
                                this.m.setAlpha(1.0f);
                                this.D.setAlpha(1.0f);
                                this.D.setEnabled(true);
                                this.A.setEnabled(true);
                            }
                            if (this.B.equalsIgnoreCase(SDKConstants.VISA)) {
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.saved_cards_visa));
                                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.n = 19;
                                this.G = 3;
                            } else if (this.B.equalsIgnoreCase("MASTER")) {
                                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.saved_cards_master_card));
                                this.n = 19;
                                this.G = 3;
                            } else if (this.B.equalsIgnoreCase("DINERS")) {
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.diners));
                                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(17)});
                                this.n = 17;
                                this.G = 3;
                            } else if (this.B.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                                this.D.setEnabled(false);
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.saved_cards_maestro));
                                this.n = 23;
                            } else if (this.B.equalsIgnoreCase("AMEX")) {
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
                                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.saved_cards_ae));
                                this.n = 23;
                                this.G = 4;
                            } else if (this.B.equalsIgnoreCase("JCB")) {
                                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.jcb));
                                this.n = 19;
                                this.G = 3;
                            } else if (this.B.equalsIgnoreCase("RUPAY")) {
                                this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(19)});
                                this.j.setImageDrawable(androidx.core.content.b.a(this.f13298f, R.drawable.saved_cards_rupay));
                                this.n = 19;
                                this.G = 3;
                            } else {
                                this.n = 23;
                                this.f13299g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(23)});
                                this.G = 3;
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(this.f13298f, this.j, iconUrl, str3);
                            }
                            if (channelCode.equalsIgnoreCase("bajaj")) {
                                this.D.setVisibility(8);
                                this.A.setEnabled(false);
                            }
                            this.j.setVisibility(0);
                        }
                    } else {
                        this.l.setText(String.format(this.f13298f.getResources().getString(R.string.emi_valid_credit_card), new Object[]{this.q.equalsIgnoreCase(SDKConstants.CREDIT) ? "credit card" : "debit card"}));
                        this.l.setTextColor(androidx.core.content.b.c(this.f13298f, R.color.color_fd5c5c));
                        this.f13299g.setBackground(androidx.core.content.b.a(this.f13298f, R.drawable.red_background_with_border));
                        this.S = false;
                        this.ac = false;
                    }
                }
            }
        } else if (fVar.f55796a == h.ERROR) {
            net.one97.paytm.p2mNewDesign.b.a.class.getSimpleName();
            q.d(fVar.f55798c.f55801c.getMessage());
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            this.N.a("bin_detail", bundle, fVar.f55798c.f55801c);
        }
    }

    static /* synthetic */ void a(d dVar, String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(dVar.f13298f));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
            jSONObject2.put("channelId", "WEB");
            jSONObject3.put("mid", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e);
            jSONObject3.put("isEMIDetail", true);
            jSONObject3.put("bin", str);
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        String jSONObject4 = jSONObject.toString();
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(dVar.f13298f, "offlinePGFetchBinDetails") + "?mid=" + net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e, new CJRFetchBinDetailsV2(), (Map<String, String>) null, hashMap2, jSONObject4);
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(dVar.f13298f, "p2mGenericAPITimeOut")));
        bVar.c().observeForever(new z() {
            public final void onChanged(Object obj) {
                d.this.a((f) obj);
            }
        });
    }

    static /* synthetic */ boolean v(d dVar) {
        return !TextUtils.isEmpty(dVar.N.d()) && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().D()) && Double.valueOf(dVar.N.d()).doubleValue() >= 0.0d && Double.valueOf(dVar.N.d()).doubleValue() <= Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().D()).doubleValue();
    }
}
