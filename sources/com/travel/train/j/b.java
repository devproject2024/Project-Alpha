package com.travel.train.j;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.e;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.activity.AJRIRCTCSignUpActivity;
import com.travel.train.activity.AJRTrainWebViewActivity;
import com.travel.train.helper.CJRSmsReceiver;
import com.travel.train.i.j;
import com.travel.train.j.s;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRIRCTCUserStatus;
import com.travel.train.model.trainticket.CJRIRCTCuserId;
import com.travel.train.model.trainticket.CJRTrainForgotPassword;
import com.travel.train.model.trainticket.CJRTrainForgotUserId;
import com.travel.train.model.trainticket.CJRTrainResendOTP;
import com.travel.train.model.trainticket.CJRTrainVerifyOTP;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class b implements View.OnClickListener, com.paytm.network.listener.b, j, s.a {
    private static String au = "CJRIRCTCLoginDilogUtil";
    private TextView A;
    private LottieAnimationView B;
    private ScrollView C;
    private LinearLayout D;
    private ProgressDialog E;
    private LinearLayout F;
    /* access modifiers changed from: private */
    public Dialog G;
    private View H;
    /* access modifiers changed from: private */
    public TextView I;
    /* access modifiers changed from: private */
    public View J;
    private View K;
    private CJRSmsReceiver L;
    /* access modifiers changed from: private */
    public C0491b M;
    private boolean N = false;
    private RelativeLayout O;
    private RelativeLayout P;
    private CJRTrainSearchInput Q;
    /* access modifiers changed from: private */
    public TextView R;
    /* access modifiers changed from: private */
    public TextView S;
    private TextView T;
    private TextView U;
    private RoboTextView V;
    private LinearLayout W;
    private LinearLayout X;
    private View Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<View> f27484a = new ArrayList<>();
    private TextView aa;
    private TextView ab;
    private TextView ac;
    private EditText ad;
    private TextView ae;
    private RelativeLayout af;
    private LinearLayout ag;
    private String ah;
    private androidx.fragment.app.j ai;
    private LinearLayout aj;
    private RoboTextView ak;
    private RoboTextView al;
    private LinearLayout am;
    private LinearLayout an;
    private boolean ao;
    private int ap;
    /* access modifiers changed from: private */
    public ImageView aq;
    private c ar;
    private View as;
    /* access modifiers changed from: private */
    public HorizontalScrollView at;
    private TextWatcher av = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (b.this.S.getVisibility() == 0) {
                b.this.S.setVisibility(8);
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 0) {
                b.this.v.setVisibility(0);
            } else {
                b.this.v.setVisibility(8);
            }
        }
    };
    private TextWatcher aw = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (b.this.R.getVisibility() == 0) {
                b.this.R.setVisibility(8);
            }
            if (b.this.I.getVisibility() == 0) {
                b.this.I.setVisibility(8);
                b.this.J.setBackgroundColor(androidx.core.content.b.c(b.this.f27487d, R.color.bg_grid_grey));
            }
            b.this.f27491h.setSelection(b.this.f27491h.getText().length());
            if (b.this.f27491h.getText().length() <= 0 || b.this.z.getText().equals(b.this.f27487d.getString(R.string.forgot_password_txt))) {
                b.this.f27490g.setVisibility(8);
                b.this.aq.setVisibility(8);
                return;
            }
            b.this.f27490g.setVisibility(0);
            b.this.aq.setVisibility(0);
        }
    };
    private TextWatcher ax = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (b.this.p.getVisibility() == 0) {
                b.this.p.setVisibility(8);
            }
            if (b.this.r.getVisibility() == 0) {
                b.this.r.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                b.this.u.setVisibility(0);
            } else {
                b.this.u.setVisibility(8);
            }
        }
    };
    private TextWatcher ay = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (b.this.q.getVisibility() == 0) {
                b.this.q.setVisibility(8);
            }
            if (b.this.r.getVisibility() == 0) {
                b.this.r.setVisibility(8);
            }
            if (charSequence.length() > 0) {
                b.this.x.setVisibility(0);
            } else {
                b.this.x.setVisibility(8);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private boolean f27485b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27486c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f27487d;

    /* renamed from: e  reason: collision with root package name */
    private String f27488e;

    /* renamed from: f  reason: collision with root package name */
    private String f27489f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f27490g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public EditText f27491h;

    /* renamed from: i  reason: collision with root package name */
    private RoboTextView f27492i;
    private EditText j;
    private EditText k;
    private RelativeLayout l;
    private RelativeLayout m;
    private TextInputLayout n;
    private TextInputLayout o;
    /* access modifiers changed from: private */
    public TextView p;
    /* access modifiers changed from: private */
    public TextView q;
    /* access modifiers changed from: private */
    public TextView r;
    private TextView s;
    private TextView t;
    /* access modifiers changed from: private */
    public ImageView u;
    /* access modifiers changed from: private */
    public ImageView v;
    private ImageView w;
    /* access modifiers changed from: private */
    public ImageView x;
    private TextInputLayout y;
    /* access modifiers changed from: private */
    public TextView z;

    /* renamed from: com.travel.train.j.b$b  reason: collision with other inner class name */
    public interface C0491b {
        void b();

        void c();
    }

    public enum c {
        BOTH_PENDING,
        EMAIL_PENDING,
        MOBILE_PENDING
    }

    public b(Activity activity, C0491b bVar, boolean z2, String str, String str2, CJRTrainSearchInput cJRTrainSearchInput, androidx.fragment.app.j jVar, boolean z3, int i2, boolean z4, boolean z5) {
        this.f27487d = activity;
        this.M = bVar;
        this.N = z2;
        this.f27488e = str;
        this.f27489f = str2;
        this.Q = cJRTrainSearchInput;
        this.ap = i2;
        this.ai = jVar;
        this.ao = z3;
        this.f27485b = z4;
        this.f27486c = z5;
    }

    public final void a() {
        this.G = new Dialog(this.f27487d);
        this.G.requestWindowFeature(1);
        this.H = this.f27487d.getLayoutInflater().inflate(R.layout.pre_t_irctc_login_layout, (ViewGroup) null);
        this.G.setContentView(this.H);
        this.W = (LinearLayout) this.H.findViewById(R.id.id_verification_progress);
        this.as = this.H.findViewById(R.id.mobile_verification_progress);
        this.Y = this.H.findViewById(R.id.email_verification_progress);
        ((RelativeLayout) this.H.findViewById(R.id.dialog_close)).setOnClickListener(this);
        this.aj = (LinearLayout) this.H.findViewById(R.id.verify_btn_lyt);
        this.S = (TextView) this.H.findViewById(R.id.mobile_number_error);
        this.z = (TextView) this.H.findViewById(R.id.irctc_heading);
        this.an = (LinearLayout) this.H.findViewById(R.id.transparent_lyt);
        this.an.setOnClickListener(this);
        this.aa = (TextView) this.H.findViewById(R.id.user_id_heading);
        this.T = (TextView) this.H.findViewById(R.id.forgot_userid_text);
        this.T.setOnClickListener(this);
        this.ak = (RoboTextView) this.H.findViewById(R.id.verify_btn);
        this.ak.setOnClickListener(this);
        this.al = (RoboTextView) this.H.findViewById(R.id.cancel_btn);
        this.al.setOnClickListener(this);
        this.ab = (TextView) this.H.findViewById(R.id.date_of_birth);
        this.ab.setOnClickListener(this);
        this.V = (RoboTextView) this.H.findViewById(R.id.submit_btn);
        this.V.setOnClickListener(this);
        this.U = (TextView) this.H.findViewById(R.id.dob_error);
        this.A = (TextView) this.H.findViewById(R.id.irctc_sub_heading);
        this.D = (LinearLayout) this.H.findViewById(R.id.lottieLL);
        this.B = (LottieAnimationView) this.H.findViewById(R.id.lottie_in_reset_password);
        this.C = (ScrollView) this.H.findViewById(R.id.scroll_view);
        this.P = (RelativeLayout) this.H.findViewById(R.id.user_id_lyt);
        this.f27490g = (RelativeLayout) this.H.findViewById(R.id.irctc_login);
        this.J = this.H.findViewById(R.id.user_id_below_view1);
        this.K = this.H.findViewById(R.id.user_id_below_view2);
        this.I = (TextView) this.H.findViewById(R.id.verification_instruction);
        this.f27490g.setOnClickListener(this);
        this.af = (RelativeLayout) this.H.findViewById(R.id.forgot_id_password_lyt);
        this.ag = (LinearLayout) this.H.findViewById(R.id.date_of_birth_lyt);
        this.ae = (TextView) this.H.findViewById(R.id.continue_txt);
        this.ae.setOnClickListener(this);
        this.F = (LinearLayout) this.H.findViewById(R.id.otp_verify_lyt);
        this.R = (TextView) this.H.findViewById(R.id.error_text);
        this.X = (LinearLayout) this.H.findViewById(R.id.user_id_container);
        this.at = (HorizontalScrollView) this.H.findViewById(R.id.user_id_scroll);
        this.at.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                b.this.at.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                b.this.at.fullScroll(2);
            }
        });
        this.l = (RelativeLayout) this.H.findViewById(R.id.irctc_mobile_otp_container);
        this.n = (TextInputLayout) this.H.findViewById(R.id.irctc_mobile_otp_edit_parent);
        this.j = (EditText) this.H.findViewById(R.id.irctc_mobile_otp_edit);
        this.p = (TextView) this.H.findViewById(R.id.mobile_otp_error_text);
        this.s = (TextView) this.H.findViewById(R.id.resend_mobile_otp_text);
        this.u = (ImageView) this.H.findViewById(R.id.iv_mobile_otp_clear);
        this.u.setOnClickListener(this);
        this.j.addTextChangedListener(this.ax);
        this.s.setOnClickListener(this);
        this.m = (RelativeLayout) this.H.findViewById(R.id.irctc_email_otp_container);
        this.o = (TextInputLayout) this.H.findViewById(R.id.irctc_email_otp_edit_parent);
        this.k = (EditText) this.H.findViewById(R.id.irctc_email_otp_edit);
        this.t = (TextView) this.H.findViewById(R.id.resend_email_otp_text);
        this.q = (TextView) this.H.findViewById(R.id.email_otp_error_text);
        this.r = (TextView) this.H.findViewById(R.id.common_error);
        this.x = (ImageView) this.H.findViewById(R.id.iv_email_otp_clear);
        this.k.addTextChangedListener(this.ay);
        this.t.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.O = (RelativeLayout) this.H.findViewById(R.id.email_mobile_lyt);
        this.v = (ImageView) this.H.findViewById(R.id.mobile_clear_button);
        this.v.setOnClickListener(this);
        this.ad = (EditText) this.H.findViewById(R.id.mobile_email);
        this.y = (TextInputLayout) this.H.findViewById(R.id.mobile_email_parent);
        this.am = (LinearLayout) this.H.findViewById(R.id.button_lyt);
        this.am.setOnClickListener(this);
        this.f27491h = (EditText) this.H.findViewById(R.id.irctc_user_id);
        this.w = (ImageView) this.H.findViewById(R.id.img_forgot_id);
        ResourceUtils.loadTrainImagesFromCDN(this.w, "group_icon.png", false, false, n.a.V1);
        this.f27491h.addTextChangedListener(this.aw);
        this.aq = (ImageView) this.H.findViewById(R.id.remove_user_id_close_btn);
        this.aq.setOnClickListener(this);
        if (g.f27551a != null) {
            e();
            if (this.f27485b) {
                this.H.findViewById(R.id.question_text).setVisibility(8);
            } else if (!TextUtils.isEmpty(g.f27551a.getNoAccount())) {
                this.H.findViewById(R.id.question_text).setVisibility(0);
                ((TextView) this.H.findViewById(R.id.question_text)).setText(g.f27551a.getNoAccount());
            }
            if (!TextUtils.isEmpty(g.f27551a.getUserDetails())) {
                this.z.setText(g.f27551a.getUserDetails());
            }
            if (!g.f27551a.getForgotUserID() || TextUtils.isEmpty(g.f27551a.getForgotUserId())) {
                this.T.setVisibility(8);
            } else {
                this.T.setVisibility(0);
                this.T.setText(g.f27551a.getForgotUserId());
            }
        } else {
            this.am.setVisibility(0);
        }
        this.ad.addTextChangedListener(this.av);
        this.ac = (TextView) this.H.findViewById(R.id.forgot_password_text);
        this.ac.setOnClickListener(this);
        if (g.f27551a == null || !g.f27551a.getForgotIrctcPassword()) {
            this.ac.setVisibility(8);
        } else {
            this.ac.setVisibility(0);
        }
        this.Z = (TextView) this.H.findViewById(R.id.get_password);
        this.Z.setOnClickListener(this);
        this.G.show();
        Window window = this.G.getWindow();
        window.setLayout(-1, -1);
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        g();
        if (this.N) {
            m();
            if (this.f27488e.equalsIgnoreCase("B")) {
                this.ar = c.BOTH_PENDING;
            } else if (this.f27488e.equalsIgnoreCase("E")) {
                this.ar = c.EMAIL_PENDING;
            } else {
                this.ar = c.MOBILE_PENDING;
            }
            this.P.setVisibility(8);
            this.al.setText(this.f27487d.getString(R.string.cancel));
            this.J.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.bg_grid_grey));
            this.J.setVisibility(8);
            this.F.setVisibility(0);
            this.I.setVisibility(8);
            this.z.setText(this.f27487d.getString(R.string.verification_text));
            this.aj.setVisibility(0);
            this.ak.setText(this.f27487d.getString(R.string.submit));
            this.X.setVisibility(8);
            this.aa.setVisibility(8);
            this.at.setVisibility(8);
            if (this.H.findViewById(R.id.button_lyt).getVisibility() == 0) {
                this.H.findViewById(R.id.button_lyt).setVisibility(8);
            }
            com.paytm.utility.b.j();
            this.af.setVisibility(8);
            int i2 = AnonymousClass3.f27499a[this.ar.ordinal()];
            if (i2 == 1) {
                l();
            } else if (i2 == 2) {
                k();
            } else if (i2 == 3) {
                j();
            }
        }
        f();
        h();
        if (this.ao) {
            this.ac.performClick();
        }
        d();
    }

    /* renamed from: com.travel.train.j.b$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27499a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.travel.train.j.b$c[] r0 = com.travel.train.j.b.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27499a = r0
                int[] r0 = f27499a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.train.j.b$c r1 = com.travel.train.j.b.c.BOTH_PENDING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f27499a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.train.j.b$c r1 = com.travel.train.j.b.c.EMAIL_PENDING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f27499a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.train.j.b$c r1 = com.travel.train.j.b.c.MOBILE_PENDING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.b.AnonymousClass3.<clinit>():void");
        }
    }

    private void d() {
        if ((g.f27552b == null || g.f27552b.size() == 0) && this.f27486c) {
            this.ac.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
            layoutParams.addRule(11);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(9);
            }
            this.T.setLayoutParams(layoutParams);
            this.f27492i.setText("Create new User ID");
            this.f27492i.setMovementMethod(LinkMovementMethod.getInstance());
            SpannableString spannableString = new SpannableString(this.f27492i.getText());
            try {
                spannableString.setSpan(new a(""), 0, 18, 33);
            } catch (Exception unused) {
            }
            this.f27492i.setText(spannableString);
            this.f27491h.setFocusable(false);
            this.f27491h.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.f27491h.setFocusableInTouchMode(true);
                    b.a((Context) b.this.f27487d, b.this.f27491h);
                }
            });
            return;
        }
        this.ac.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
        layoutParams2.addRule(9);
        this.T.setLayoutParams(layoutParams2);
        g();
    }

    private void e() {
        if (g.f27551a == null || !g.f27551a.getCreateNewAccount()) {
            this.am.setVisibility(8);
        } else {
            this.am.setVisibility(0);
        }
    }

    private void f() {
        if (g.f27552b != null && g.f27552b.size() > 0) {
            this.at.setVisibility(0);
            this.aa.setVisibility(0);
            ArrayList<CJRIRCTCuserId> arrayList = g.f27552b;
            for (final int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 <= 2) {
                    View inflate = this.f27487d.getLayoutInflater().inflate(R.layout.pre_t_lyt_user_id_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.user_id);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.display_time);
                    final RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.parent_lyt);
                    final CJRIRCTCuserId cJRIRCTCuserId = arrayList.get(i2);
                    if (!TextUtils.isEmpty(cJRIRCTCuserId.getmUserId())) {
                        textView.setText(cJRIRCTCuserId.getmUserId());
                    }
                    if (!TextUtils.isEmpty(cJRIRCTCuserId.getmDisplayTime())) {
                        textView2.setVisibility(0);
                        textView2.setText(cJRIRCTCuserId.getmDisplayTime());
                    }
                    if (i2 == 0) {
                        relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_alternate_class_bg_selected);
                        this.f27491h.setText(cJRIRCTCuserId.getmUserId());
                    }
                    inflate.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_alternate_class_bg_selected);
                            if (b.this.f27491h != null) {
                                b.this.f27491h.setText(cJRIRCTCuserId.getmUserId());
                            }
                            for (int i2 = 0; i2 < b.this.f27484a.size(); i2++) {
                                RelativeLayout relativeLayout = (RelativeLayout) b.this.f27484a.get(i2).findViewById(R.id.parent_lyt);
                                if (i2 != i2) {
                                    relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_search_class_border_drawable);
                                }
                            }
                        }
                    });
                    this.f27484a.add(inflate);
                }
            }
            for (int size = this.f27484a.size() - 1; size >= 0; size--) {
                this.X.addView(this.f27484a.get(size));
            }
        }
    }

    private void g() {
        this.f27492i = (RoboTextView) this.H.findViewById(R.id.irctc_create_account_txt);
        this.f27492i.setOnClickListener(this);
        String string = this.f27487d.getString(R.string.irctc_create_account_text);
        this.f27492i.setText(string);
        String string2 = this.f27487d.getString(R.string.click_here_text);
        int indexOf = string.indexOf(string2);
        this.f27492i.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(this.f27492i.getText());
        if (indexOf != -1) {
            try {
                spannableString.setSpan(new a(""), indexOf, string2.length() + indexOf, 33);
            } catch (Exception unused) {
            }
        }
        this.f27492i.setText(spannableString);
    }

    private void h() {
        String str;
        EditText editText = this.f27491h;
        if (editText != null && editText.getVisibility() == 0 && (str = this.f27489f) != null) {
            this.f27491h.setText(str);
            if (g.f27552b != null && g.f27552b.size() > 0) {
                ArrayList<CJRIRCTCuserId> arrayList = g.f27552b;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (i2 <= 2) {
                        RelativeLayout relativeLayout = (RelativeLayout) this.f27484a.get(i2).findViewById(R.id.parent_lyt);
                        if (arrayList.get(i2).getmUserId().equalsIgnoreCase(this.f27489f)) {
                            relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_alternate_class_bg_selected);
                        } else {
                            relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_search_class_border_drawable);
                        }
                    }
                }
            }
        }
    }

    public final void onClick(View view) {
        EditText editText;
        String str;
        String str2;
        String str3;
        String str4;
        int id = view.getId();
        if (id == R.id.irctc_create_account_txt || id == R.id.button_lyt) {
            this.f27487d.startActivityForResult(new Intent(this.f27487d, AJRIRCTCSignUpActivity.class), e.aJ);
            HashMap hashMap = new HashMap();
            hashMap.put("train_search_list_position", Integer.valueOf(this.ap));
            o.a("train_search_results", this.Q.getmSourceCityName(), this.Q.getmDestCityName(), this.Q.getmDate(), (String) null, (String) null, (String) null, "irctc_create_account", "/trains/search-results", this.f27487d, hashMap);
            g("train_search_results_user_details_click_here_clicked");
            b();
        } else if (id == R.id.irctc_login) {
            c();
            EditText editText2 = this.f27491h;
            if (editText2 == null || editText2.getText() == null) {
                str4 = "";
            } else {
                str4 = this.f27491h.getText().toString().trim();
            }
            if (TextUtils.isEmpty(str4)) {
                c("");
            } else if (str4.length() < 3 || str4.length() > 35 || !str4.matches("[a-zA-Z0-9_]*")) {
                c(this.f27487d.getString(R.string.username_validation_condition_text));
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("train_search_list_position", Integer.valueOf(this.ap));
                o.a("train_search_results", (String) null, (String) null, (String) null, this.Q.getmSourceCityName(), this.Q.getmDestCityName(), this.Q.getmDate(), "ticket_selected", "/trains/search-results", this.f27487d, hashMap2);
                g("train_search_results_irctc_userid_entered");
                g("train_search_results_user_details_proceed_clicked");
                this.f27489f = str4.trim();
                a(this.f27489f);
                if (this.ak.getText().toString().equalsIgnoreCase(this.f27487d.getString(R.string.submit))) {
                    c();
                    com.travel.train.b.a();
                    String d2 = com.travel.train.b.b().d();
                    int i2 = AnonymousClass3.f27499a[this.ar.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 == 3) {
                                if (!d("")) {
                                    d2 = d2 + "userId=" + this.f27489f + "&smsCode=" + this.j.getText().toString().trim() + "&type=M";
                                } else {
                                    return;
                                }
                            }
                        } else if (!e("")) {
                            d2 = d2 + "userId=" + this.f27489f + "&emailCode=" + this.k.getText().toString().trim() + "&type=E";
                        } else {
                            return;
                        }
                    } else if (!f("")) {
                        d2 = d2 + "userId=" + this.f27489f + "&smsCode=" + this.j.getText().toString().trim() + "&emailCode=" + this.k.getText().toString().trim() + "&type=B";
                    } else {
                        return;
                    }
                    i(d2);
                }
            }
        } else if (id == R.id.verify_btn) {
            if (this.ak.getText().toString().equalsIgnoreCase(this.f27487d.getString(R.string.submit))) {
                c();
                com.travel.train.b.a();
                String d3 = com.travel.train.b.b().d();
                int i3 = AnonymousClass3.f27499a[this.ar.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            if (!d("")) {
                                d3 = d3 + "userId=" + this.f27489f + "&smsCode=" + this.j.getText().toString().trim() + "&type=M";
                            } else {
                                return;
                            }
                        }
                    } else if (!e("")) {
                        d3 = d3 + "userId=" + this.f27489f + "&emailCode=" + this.k.getText().toString().trim() + "&type=E";
                    } else {
                        return;
                    }
                } else if (!f("")) {
                    d3 = d3 + "userId=" + this.f27489f + "&smsCode=" + this.j.getText().toString().trim() + "&emailCode=" + this.k.getText().toString().trim() + "&type=B";
                } else {
                    return;
                }
                i(d3);
            }
        } else if (id == R.id.resend_mobile_otp_text) {
            h("M");
        } else if (id == R.id.resend_email_otp_text) {
            h("E");
        } else {
            if (id == R.id.forgot_password_text) {
                String str5 = d.dK;
                try {
                    HashMap hashMap3 = new HashMap();
                    if (com.paytm.utility.b.n((Context) this.f27487d) != null) {
                        str3 = com.paytm.utility.b.n((Context) this.f27487d);
                    } else {
                        str3 = "";
                    }
                    hashMap3.put("user_id", str3);
                    hashMap3.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(str5, (Map<String, Object>) hashMap3, (Context) this.f27487d);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                if (g.f27551a != null && g.f27551a.getResetIRCTCPasswordFlow() != null && !TextUtils.isEmpty(g.f27551a.getResetIRCTCPasswordFlow())) {
                    if (g.f27551a.getResetIRCTCPasswordFlow().equalsIgnoreCase("native")) {
                        this.z.setText(this.f27487d.getString(R.string.forgot_password_txt));
                        this.H.findViewById(R.id.button_lyt).setVisibility(8);
                        this.Z.setVisibility(0);
                        this.af.setVisibility(8);
                        this.f27490g.setVisibility(8);
                        this.aa.setVisibility(8);
                        this.at.setVisibility(8);
                        this.H.findViewById(R.id.forgot_password_text).setVisibility(8);
                        if (this.f27491h.getText().toString().trim().length() != 0) {
                            this.aq.setVisibility(8);
                            this.f27491h.setEnabled(false);
                        }
                        if (g.f27551a.getResetIRCTCPasswordLabel() != null) {
                            this.y.setHint(g.f27551a.getResetIRCTCPasswordLabel());
                        } else {
                            this.y.setHint("Enter IRCTC registered mobile number");
                        }
                        this.O.setVisibility(0);
                        this.ad.setText("");
                        g("train_search_results_user_details_reset_clicked");
                        return;
                    }
                    String resetIRCTCPasswordUrl = (g.f27551a == null || g.f27551a.getResetIRCTCPasswordUrl() == null || TextUtils.isEmpty(g.f27551a.getResetIRCTCPasswordUrl())) ? "https://www.irctc.co.in/eticketing/forgotPassword.jsf" : g.f27551a.getResetIRCTCPasswordUrl();
                    Intent intent = new Intent(this.f27487d, AJRTrainWebViewActivity.class);
                    intent.putExtra("url", resetIRCTCPasswordUrl);
                    intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "Reset IRCTC Password");
                    this.f27487d.startActivityForResult(intent, 550);
                }
            } else if (id == R.id.get_password) {
                g("train_search_results_reset_get_password_clicked");
                if (this.f27491h.getText().length() == 0) {
                    c("");
                } else if (this.f27491h.getText().toString().length() < 3 || this.f27491h.getText().length() > 35 || !this.f27491h.getText().toString().matches("[a-zA-Z0-9_]*")) {
                    c(this.f27487d.getString(R.string.username_validation_condition_text));
                } else if (this.ad.getText().length() == 0) {
                    this.S.setVisibility(0);
                    this.S.setText(this.f27487d.getString(R.string.irctc_wrong_mobile_email_number));
                } else {
                    String i4 = i();
                    if (i4.equalsIgnoreCase("E")) {
                        if (!com.paytm.utility.b.d(this.ad.getText().toString())) {
                            this.S.setVisibility(0);
                            this.S.setText(this.f27487d.getString(R.string.please_enter_valid_input_field, new Object[]{this.f27487d.getString(R.string.sign_up_email_id)}));
                            return;
                        }
                    } else if (i4.equalsIgnoreCase("M") && this.ad.getText().toString().trim().length() < 10) {
                        this.S.setVisibility(0);
                        this.S.setText(this.f27487d.getString(R.string.traveller_empty_field_message, new Object[]{this.f27487d.getString(R.string.mobile_number)}));
                        return;
                    }
                    com.travel.train.b.a();
                    String r2 = com.travel.train.b.b().r();
                    if (URLUtil.isValidUrl(r2)) {
                        r2 = o.b((Context) this.f27487d, com.paytm.utility.b.s(this.f27487d, r2));
                    }
                    if (i4.equalsIgnoreCase("E")) {
                        str2 = v.a(r2, "&email=" + this.ad.getText().toString() + "&userLoginId=" + this.f27491h.getText().toString() + "&otpType=E");
                    } else {
                        str2 = v.a(r2, "&mobile=" + this.ad.getText().toString() + "&userLoginId=" + this.f27491h.getText().toString() + "&otpType=M");
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this.f27487d;
                    bVar.f42878b = a.c.TRAIN;
                    bVar.n = a.b.SILENT;
                    bVar.o = g.r;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42880d = str2;
                    bVar.f42882f = n.b((Context) this.f27487d);
                    bVar.f42885i = new CJRTrainForgotPassword();
                    bVar.j = this;
                    com.paytm.network.a l2 = bVar.l();
                    l2.f42859c = false;
                    if (com.paytm.utility.b.c((Context) this.f27487d)) {
                        c();
                        this.C.setVisibility(4);
                        LinearLayout linearLayout = this.D;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                            net.one97.paytm.common.widgets.a.a(this.B);
                        }
                        l2.a();
                        return;
                    }
                    a(l2);
                }
            } else if (id == R.id.submit_btn) {
                this.A.setText(this.f27487d.getString(R.string.password_redirect_text));
                this.A.setTextSize(13.0f);
                this.A.setTextColor(androidx.core.content.b.c(this.f27487d, R.color.black));
                this.F.setVisibility(8);
                this.ae.setVisibility(0);
                this.V.setVisibility(8);
                this.J.setVisibility(8);
            } else if (id == R.id.continue_txt) {
                g("train_search_results_forgot_continue_clicked");
                if (this.ag.getVisibility() == 0) {
                    if (this.ad.getText().length() == 0) {
                        this.S.setVisibility(0);
                        this.S.setText(this.f27487d.getString(R.string.train_no_mobile_email_error));
                        return;
                    }
                    String i5 = i();
                    if (i5.equalsIgnoreCase("E")) {
                        if (!com.paytm.utility.b.d(this.ad.getText().toString())) {
                            this.S.setVisibility(0);
                            this.S.setText(this.f27487d.getString(R.string.please_enter_valid_input_field, new Object[]{this.f27487d.getString(R.string.sign_up_email_id)}));
                            return;
                        }
                    } else if (i5.equalsIgnoreCase("M") && this.ad.getText().toString().trim().length() < 10) {
                        this.S.setVisibility(0);
                        this.S.setText(this.f27487d.getString(R.string.traveller_empty_field_message, new Object[]{this.f27487d.getString(R.string.mobile_number)}));
                        return;
                    }
                    if (this.ab.getText().length() == 0) {
                        this.U.setVisibility(0);
                        this.U.setText(this.f27487d.getString(R.string.train_err_dob));
                        return;
                    }
                    if (i5.equalsIgnoreCase("E")) {
                        StringBuilder sb = new StringBuilder();
                        com.travel.train.b.a();
                        sb.append(com.travel.train.b.b().r());
                        sb.append("email=");
                        sb.append(this.ad.getText().toString());
                        sb.append("&type=U&dob=");
                        sb.append(this.ah);
                        str = sb.toString();
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.travel.train.b.a();
                        sb2.append(com.travel.train.b.b().r());
                        sb2.append("mobile=");
                        sb2.append(this.ad.getText().toString());
                        sb2.append("&type=U&dob=");
                        sb2.append(this.ah);
                        str = sb2.toString();
                    }
                    if (URLUtil.isValidUrl(str)) {
                        str = o.b((Context) this.f27487d, com.paytm.utility.b.s(this.f27487d, str));
                    }
                    Activity activity = this.f27487d;
                    a((Context) activity, activity.getString(R.string.please_wait_progress_msg));
                    com.paytm.network.b bVar2 = new com.paytm.network.b();
                    bVar2.f42877a = this.f27487d;
                    bVar2.f42878b = a.c.TRAIN;
                    bVar2.n = a.b.SILENT;
                    bVar2.o = g.r;
                    bVar2.f42879c = a.C0715a.GET;
                    bVar2.f42880d = str;
                    bVar2.f42882f = n.b((Context) this.f27487d);
                    bVar2.f42885i = new CJRTrainForgotUserId();
                    bVar2.j = this;
                    com.paytm.network.a l3 = bVar2.l();
                    l3.f42859c = false;
                    if (com.paytm.utility.b.c((Context) this.f27487d)) {
                        l3.a();
                    } else {
                        a(l3);
                    }
                } else if (this.ao) {
                    C0491b bVar3 = this.M;
                    if (bVar3 != null) {
                        bVar3.c();
                    }
                    Dialog dialog = this.G;
                    if (dialog != null && dialog.isShowing()) {
                        this.G.dismiss();
                    }
                } else {
                    this.A.setVisibility(8);
                    this.ae.setVisibility(8);
                    this.P.setVisibility(0);
                    this.af.setVisibility(0);
                    this.w.setVisibility(8);
                    if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getUserDetails())) {
                        this.z.setText(this.f27487d.getString(R.string.irctc_login_heading));
                    } else {
                        this.z.setText(g.f27551a.getUserDetails());
                    }
                    this.H.findViewById(R.id.forgot_password_text).setVisibility(0);
                    this.H.findViewById(R.id.button_lyt).setVisibility(0);
                    this.J.setVisibility(0);
                    this.f27490g.setVisibility(0);
                    this.aa.setVisibility(8);
                    this.at.setVisibility(8);
                    this.at.setVisibility(0);
                    d();
                }
            } else if (id == R.id.date_of_birth) {
                if (this.U.getVisibility() == 0) {
                    this.U.setVisibility(8);
                }
                new s(this.ab.getText().toString(), this).show(this.ai, H5Plugin.CommonEvents.DATE_PICKER);
            } else if (id == R.id.forgot_userid_text) {
                this.P.setVisibility(8);
                this.O.setVisibility(0);
                this.aa.setVisibility(8);
                this.at.setVisibility(8);
                this.J.setVisibility(8);
                this.H.findViewById(R.id.button_lyt).setVisibility(8);
                this.ae.setVisibility(0);
                this.ag.setVisibility(0);
                this.af.setVisibility(8);
                this.z.setText(this.f27487d.getString(R.string.irctc_forgot_userid));
                g("train_search_results_user_details_forgot_clicked");
            } else if (id == R.id.cancel_btn) {
                b();
            } else if (id == R.id.dialog_close) {
                b();
                c();
            } else if (id == R.id.transparent_lyt) {
                b();
            } else if (id == R.id.remove_user_id_close_btn) {
                EditText editText3 = this.f27491h;
                if (editText3 != null) {
                    editText3.setText("");
                    this.aj.setVisibility(8);
                    a((Context) this.f27487d, this.f27491h);
                    e();
                    for (int i6 = 0; i6 < this.f27484a.size(); i6++) {
                        ((RelativeLayout) this.f27484a.get(i6).findViewById(R.id.parent_lyt)).setBackgroundResource(R.drawable.pre_t_train_train_search_class_border_drawable);
                    }
                }
            } else if (id == R.id.iv_mobile_otp_clear) {
                EditText editText4 = this.j;
                if (editText4 != null) {
                    editText4.setText("");
                }
            } else if (id == R.id.iv_email_otp_clear) {
                EditText editText5 = this.k;
                if (editText5 != null) {
                    editText5.setText("");
                }
            } else if (id == R.id.mobile_clear_button && (editText = this.ad) != null) {
                editText.setText("");
            }
        }
    }

    public static void a(final Context context, final EditText editText) {
        try {
            editText.requestFocus();
            editText.post(new Runnable() {
                public final void run() {
                    ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 0);
                }
            });
        } catch (NullPointerException e2) {
            q.c(e2.getMessage());
        } catch (Exception e3) {
            q.c(e3.getMessage());
        }
    }

    private void c(String str) {
        this.R.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.R.setText(str);
        } else {
            this.R.setText(this.f27487d.getString(R.string.train_enter_user_id));
        }
    }

    private boolean d(String str) {
        if (this.j.getText().toString().length() != 0) {
            return false;
        }
        this.p.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        this.p.setText(str);
        return true;
    }

    private boolean e(String str) {
        if (this.k.getText().toString().length() != 0) {
            return false;
        }
        this.q.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        this.q.setText(str);
        return true;
    }

    private boolean f(String str) {
        if (d(str)) {
            return true;
        }
        return e(str);
    }

    private String i() {
        return this.ad.getText().toString().matches("[0-9]+") ? "M" : "E";
    }

    private void g(String str) {
        try {
            String n2 = com.paytm.utility.b.n((Context) this.f27487d);
            HashMap hashMap = new HashMap();
            if (n2 != null && !TextUtils.isEmpty(n2)) {
                hashMap.put(d.f49600g, n2);
            }
            if (this.Q != null) {
                hashMap.put(d.f49601h, this.Q.getmSourceCityName());
                hashMap.put(d.f49602i, this.Q.getmDestCityName());
            }
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.t);
            hashMap.put("train_search_list_position", Integer.valueOf(this.ap));
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) this.f27487d);
        } catch (Exception unused) {
        }
    }

    public final void b() {
        Dialog dialog = this.G;
        if (dialog != null && dialog.isShowing()) {
            this.G.dismiss();
        }
        c();
    }

    private void a(Context context, String str) {
        ProgressDialog progressDialog = this.E;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.E = new ProgressDialog(context);
            try {
                this.E.setProgressStyle(0);
                this.E.setMessage(str);
                this.E.setCancelable(false);
                this.E.setCanceledOnTouchOutside(false);
                this.E.show();
            } catch (IllegalArgumentException e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str) {
        Activity activity = this.f27487d;
        a((Context) activity, activity.getString(R.string.irctc_userid_verifing));
        StringBuilder sb = new StringBuilder();
        com.travel.train.b.a();
        sb.append(com.travel.train.b.b().y());
        sb.append(str);
        String b2 = o.b((Context) this.f27487d, com.paytm.utility.b.s(this.f27487d, o.a((Context) this.f27487d, sb.toString())));
        if (URLUtil.isValidUrl(b2)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27487d;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = b2;
            bVar.f42882f = n.b((Context) this.f27487d);
            bVar.f42885i = new CJRIRCTCUserStatus();
            bVar.j = this;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            if (com.paytm.utility.b.c((Context) this.f27487d)) {
                l2.a();
            } else {
                a(l2);
            }
        } else {
            Activity activity2 = this.f27487d;
            com.paytm.utility.b.b((Context) activity2, activity2.getString(R.string.error), this.f27487d.getString(R.string.msg_invalid_url_train));
        }
    }

    public final void a(String str, String str2) {
        String g2 = com.paytm.utility.b.g(str, str2);
        if (g2 != null) {
            if (this.j != null) {
                "----Setting OTP-------".concat(String.valueOf(g2));
                com.paytm.utility.b.j();
                this.j.setText(g2);
            }
            try {
                if (this.L != null) {
                    this.f27487d.unregisterReceiver(this.L);
                    this.L.f27253a = null;
                    this.L = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getSimpleName());
                    sb.append(" : unregister");
                    com.paytm.utility.b.j();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        int indexOf;
        Activity activity = this.f27487d;
        if (activity != null && !activity.isFinishing() && iJRPaytmDataModel != null) {
            ProgressDialog progressDialog = this.E;
            if (progressDialog != null && progressDialog.isShowing()) {
                n();
            }
            if (iJRPaytmDataModel instanceof CJRIRCTCUserStatus) {
                CJRIRCTCUserStatus cJRIRCTCUserStatus = (CJRIRCTCUserStatus) iJRPaytmDataModel;
                if (cJRIRCTCUserStatus.getStatus() == null || !cJRIRCTCUserStatus.getStatus().f27711a.equalsIgnoreCase("success")) {
                    if (cJRIRCTCUserStatus.getStatus() != null && cJRIRCTCUserStatus.getStatus().f27711a.equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) && cJRIRCTCUserStatus.getStatus().f27712b != null) {
                        com.paytm.utility.b.b((Context) this.f27487d, cJRIRCTCUserStatus.getStatus().f27712b.f27709a, cJRIRCTCUserStatus.getStatus().f27712b.f27710b);
                    }
                } else if (cJRIRCTCUserStatus.getUserBody() == null) {
                } else {
                    if (cJRIRCTCUserStatus.getUserBody().f27705a.equalsIgnoreCase("true") && cJRIRCTCUserStatus.getUserBody().f27706b.equalsIgnoreCase("true") && cJRIRCTCUserStatus.getUserBody().f27707c.equalsIgnoreCase("true")) {
                        Dialog dialog = this.G;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        c();
                        com.paytm.utility.b.j((Context) this.f27487d, this.f27489f);
                        C0491b bVar = this.M;
                        if (bVar != null) {
                            bVar.b();
                        }
                        String str = cJRIRCTCUserStatus.getUserBody().f27708d;
                        if ((str != null) && (!TextUtils.isEmpty(str))) {
                            w.a(this.f27487d.getApplicationContext()).a("new_user_flag", str, false);
                        } else {
                            w.a(this.f27487d.getApplicationContext()).a("new_user_flag", (String) null, false);
                        }
                    } else if (cJRIRCTCUserStatus.getUserBody().f27705a.equalsIgnoreCase("false")) {
                        if (this.G == null) {
                            a();
                        }
                        this.aj.setVisibility(0);
                        this.al.setVisibility(8);
                        this.P.setVisibility(8);
                        this.af.setVisibility(8);
                        this.H.findViewById(R.id.button_lyt).setVisibility(8);
                        this.J.setVisibility(8);
                        this.F.setVisibility(0);
                        this.I.setVisibility(8);
                        this.z.setText(this.f27487d.getString(R.string.verification_text));
                        this.ak.setText(this.f27487d.getString(R.string.submit));
                        if (cJRIRCTCUserStatus.getUserBody().f27706b.equalsIgnoreCase("false") && cJRIRCTCUserStatus.getUserBody().f27707c.equalsIgnoreCase("false")) {
                            this.f27488e = "B";
                            this.ar = c.BOTH_PENDING;
                            l();
                            h("B");
                        } else if (cJRIRCTCUserStatus.getUserBody().f27707c.equalsIgnoreCase("false")) {
                            this.f27488e = "E";
                            this.ar = c.EMAIL_PENDING;
                            k();
                            h("E");
                        } else if (cJRIRCTCUserStatus.getUserBody().f27706b.equalsIgnoreCase("false")) {
                            this.f27488e = "M";
                            this.ar = c.MOBILE_PENDING;
                            j();
                            m();
                            h("M");
                        }
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRTrainResendOTP) {
                CJRTrainResendOTP cJRTrainResendOTP = (CJRTrainResendOTP) iJRPaytmDataModel;
                if (cJRTrainResendOTP.getResendStatus() != null && cJRTrainResendOTP.getResendStatus().f27722a.equalsIgnoreCase("success")) {
                    this.A.setVisibility(0);
                    if (cJRTrainResendOTP.getOTPDetails() == null || TextUtils.isEmpty(cJRTrainResendOTP.getOTPDetails().f27721a)) {
                        this.A.setText(this.f27487d.getString(R.string.otp_sent_msg, new Object[]{this.f27489f}));
                    } else {
                        this.A.setText(cJRTrainResendOTP.getOTPDetails().f27721a);
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRTrainVerifyOTP) {
                CJRTrainVerifyOTP cJRTrainVerifyOTP = (CJRTrainVerifyOTP) iJRPaytmDataModel;
                if (cJRTrainVerifyOTP.getVerifyOTPStatus() != null && cJRTrainVerifyOTP.getVerifyOTPStatus().getResult().equalsIgnoreCase("success")) {
                    com.paytm.utility.b.j((Context) this.f27487d, this.f27489f);
                    this.H.findViewById(R.id.irctc_login_lyt).setVisibility(8);
                    this.H.findViewById(R.id.irctc_success_lyt).setVisibility(0);
                    this.as.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.available_text_color));
                    this.Y.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.available_text_color));
                    c();
                    ((TextView) this.H.findViewById(R.id.irctc_continue_text)).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (b.this.G != null && b.this.G.isShowing()) {
                                b.this.G.dismiss();
                                b.this.c();
                                if (b.this.M != null) {
                                    b.this.M.b();
                                }
                            }
                        }
                    });
                } else if (cJRTrainVerifyOTP.getVerifyOTPStatus() != null && cJRTrainVerifyOTP.getVerifyOTPStatus().getResult().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
                    f("");
                }
            } else if (iJRPaytmDataModel instanceof CJRTrainForgotPassword) {
                o();
                this.C.setVisibility(0);
                CJRTrainForgotPassword cJRTrainForgotPassword = (CJRTrainForgotPassword) iJRPaytmDataModel;
                if (cJRTrainForgotPassword.getForgotPasswordStatus() != null && cJRTrainForgotPassword.getForgotPasswordStatus().f27714a != null && cJRTrainForgotPassword.getForgotPasswordStatus().f27714a.equalsIgnoreCase("success")) {
                    this.z.setText(this.f27487d.getString(R.string.reset_password_txt));
                    this.P.setVisibility(8);
                    this.Z.setVisibility(8);
                    this.O.setVisibility(8);
                    this.A.setVisibility(0);
                    this.w.setVisibility(0);
                    this.am.setVisibility(8);
                    this.f27491h.setEnabled(true);
                    if (!(cJRTrainForgotPassword.getPasswordBody() == null || cJRTrainForgotPassword.getPasswordBody().f27713a == null)) {
                        String str2 = cJRTrainForgotPassword.getPasswordBody().f27713a;
                        try {
                            if (str2.contains("**")) {
                                str2 = str2.replaceAll("[^\\w ].*", ".: " + this.ad.getText().toString());
                            } else if (str2.contains("XXXX")) {
                                str2 = str2.replaceAll("XX.*", ".: " + this.ad.getText().toString());
                            }
                            SpannableString spannableString = new SpannableString(str2);
                            if (str2.contains(this.ad.getText().toString()) && (indexOf = str2.indexOf(this.ad.getText().toString())) != -1) {
                                spannableString.setSpan(new StyleSpan(1), indexOf, str2.length(), 33);
                            }
                            this.A.setText(spannableString);
                        } catch (Exception e2) {
                            com.google.firebase.crashlytics.c.a().a(e2.getMessage());
                        }
                    }
                    this.A.setTextSize(13.0f);
                    this.A.setTextColor(this.f27487d.getResources().getColor(R.color.color_666666));
                    this.F.setVisibility(8);
                    this.ae.setVisibility(0);
                    this.J.setVisibility(8);
                }
            } else if (iJRPaytmDataModel instanceof CJRTrainForgotUserId) {
                CJRTrainForgotUserId cJRTrainForgotUserId = (CJRTrainForgotUserId) iJRPaytmDataModel;
                if (!(cJRTrainForgotUserId.getForgotUserIsStatus() == null || cJRTrainForgotUserId.getForgotUserIsStatus().f27716a == null || !cJRTrainForgotUserId.getForgotUserIsStatus().f27716a.equalsIgnoreCase("success"))) {
                    this.ag.setVisibility(8);
                    this.O.setVisibility(8);
                    this.A.setVisibility(0);
                    this.w.setVisibility(0);
                    this.am.setVisibility(8);
                    if (!(cJRTrainForgotUserId.getForgotUserIdBody() == null || cJRTrainForgotUserId.getForgotUserIdBody().f27715a == null)) {
                        this.A.setText(cJRTrainForgotUserId.getForgotUserIdBody().f27715a);
                        this.A.setTextColor(this.f27487d.getResources().getColor(R.color.color_666666));
                    }
                }
                c();
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        Activity activity = this.f27487d;
        if (activity != null && !activity.isFinishing()) {
            ProgressDialog progressDialog = this.E;
            if (progressDialog != null && progressDialog.isShowing()) {
                n();
            }
            LinearLayout linearLayout = this.D;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                this.C.setVisibility(0);
                o();
            }
            try {
                com.travel.train.model.a aVar = new com.travel.train.model.a();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    if (networkResponse.data != null) {
                        try {
                            aVar = (com.travel.train.model.a) new f().a(new String(networkResponse.data), aVar.getClass());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                }
                if (i2 != 401) {
                    if (i2 != 410) {
                        if (!(i2 == 449 || i2 == 499 || i2 == 502 || i2 == 503)) {
                            if (i2 != 504) {
                                if (aVar == null || aVar.getStatus() == null || aVar.getStatus().getMessage() == null || TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) || TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                                    if (TextUtils.isEmpty(networkCustomError.getMessage()) || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                                        if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                                            com.travel.train.b.a();
                                            if (!com.travel.train.b.b().a((Context) this.f27487d, (Exception) networkCustomError, "error.trains@paytm.com")) {
                                                if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                                    com.paytm.utility.b.b((Context) this.f27487d, this.f27487d.getResources().getString(R.string.network_error_heading), this.f27487d.getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                                    return;
                                                }
                                                String string = this.f27487d.getResources().getString(R.string.trains_message_error_data_display);
                                                com.paytm.utility.b.b((Context) this.f27487d, this.f27487d.getResources().getString(R.string.error_data_display), string);
                                                return;
                                            }
                                        }
                                        com.paytm.utility.b.b((Context) this.f27487d, this.f27487d.getResources().getString(R.string.network_error_heading), this.f27487d.getResources().getString(R.string.network_error_message_train));
                                        return;
                                    }
                                    String alertTitle = networkCustomError.getAlertTitle();
                                    String alertMessage = networkCustomError.getAlertMessage();
                                    if (!TextUtils.isEmpty(networkCustomError.getFullUrl())) {
                                        String fullUrl = networkCustomError.getFullUrl();
                                        com.travel.train.b.a();
                                        if (fullUrl.contains(com.travel.train.b.b().e())) {
                                            if (this.G == null) {
                                                a();
                                            }
                                            f(networkCustomError.getAlertMessage());
                                            return;
                                        }
                                        String fullUrl2 = networkCustomError.getFullUrl();
                                        com.travel.train.b.a();
                                        if (fullUrl2.contains(com.travel.train.b.b().y())) {
                                            if (this.G == null) {
                                                a();
                                            }
                                            c(networkCustomError.getAlertMessage());
                                            return;
                                        }
                                        String fullUrl3 = networkCustomError.getFullUrl();
                                        com.travel.train.b.a();
                                        if (fullUrl3.contains(com.travel.train.b.b().d())) {
                                            this.r.setText(networkCustomError.getAlertMessage());
                                            this.r.setVisibility(0);
                                            return;
                                        }
                                        com.paytm.utility.b.b((Context) this.f27487d, alertTitle, alertMessage);
                                        return;
                                    }
                                    com.paytm.utility.b.b((Context) this.f27487d, alertTitle, alertMessage);
                                    return;
                                } else if (!TextUtils.isEmpty(networkCustomError.getFullUrl())) {
                                    String fullUrl4 = networkCustomError.getFullUrl();
                                    com.travel.train.b.a();
                                    if (fullUrl4.contains(com.travel.train.b.b().e())) {
                                        if (this.G == null) {
                                            a();
                                        }
                                        f(aVar.getStatus().getMessage().f27693b);
                                        return;
                                    }
                                    String fullUrl5 = networkCustomError.getFullUrl();
                                    com.travel.train.b.a();
                                    if (fullUrl5.contains(com.travel.train.b.b().y())) {
                                        if (this.G == null) {
                                            a();
                                        }
                                        c(aVar.getStatus().getMessage().f27693b);
                                        return;
                                    }
                                    String fullUrl6 = networkCustomError.getFullUrl();
                                    com.travel.train.b.a();
                                    if (fullUrl6.contains(com.travel.train.b.b().d())) {
                                        this.r.setText(aVar.getStatus().getMessage().f27693b);
                                        this.r.setVisibility(0);
                                        return;
                                    }
                                    com.paytm.utility.b.b((Context) this.f27487d, aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                                    return;
                                } else {
                                    com.paytm.utility.b.b((Context) this.f27487d, aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                                    return;
                                }
                            }
                        }
                        com.paytm.utility.b.b((Context) this.f27487d, networkCustomError.getMessage(), networkCustomError.getMessage());
                        return;
                    }
                }
                com.travel.train.b.a();
                com.travel.train.b.b().a(this.f27487d, networkCustomError);
            } catch (Exception unused) {
            }
        }
    }

    private void j() {
        this.W.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(8);
        this.aa.setVisibility(8);
        this.at.setVisibility(8);
        this.s.setText(this.f27487d.getString(R.string.resend_otp));
        this.t.setText(this.f27487d.getString(R.string.verified));
        this.as.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.available_text_color));
        this.Y.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.train_not_confirmed_otp));
    }

    private void k() {
        this.W.setVisibility(0);
        this.l.setVisibility(8);
        this.m.setVisibility(0);
        this.aa.setVisibility(8);
        this.at.setVisibility(8);
        this.s.setText(this.f27487d.getString(R.string.verified));
        this.t.setText(this.f27487d.getString(R.string.resend_otp));
        this.as.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.available_text_color));
        this.Y.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.train_not_confirmed_otp));
    }

    private void l() {
        this.W.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.A.setVisibility(0);
        this.aa.setVisibility(8);
        this.at.setVisibility(8);
        this.A.setText(this.f27487d.getString(R.string.otp_sent_msg, new Object[]{this.f27489f}));
        this.s.setText(this.f27487d.getString(R.string.resend_otp));
        this.t.setText(this.f27487d.getString(R.string.resend_otp));
        this.as.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.train_not_confirmed_otp));
        this.Y.setBackgroundColor(androidx.core.content.b.c(this.f27487d, R.color.train_not_confirmed_otp));
    }

    public final void a(final com.paytm.network.a aVar) {
        Activity activity = this.f27487d;
        if (activity != null) {
            final h hVar = new h(activity);
            hVar.setTitle(this.f27487d.getResources().getString(R.string.no_connection));
            hVar.a(this.f27487d.getResources().getString(R.string.no_internet_train));
            hVar.a(-3, this.f27487d.getString(R.string.network_retry_yes), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (com.paytm.utility.b.c((Context) b.this.f27487d)) {
                        aVar.a();
                    } else {
                        b.this.a(aVar);
                    }
                }
            });
            hVar.show();
        }
    }

    private void m() {
        try {
            if ((!com.paytm.utility.s.a() || com.paytm.utility.s.d((Context) this.f27487d)) && this.L == null) {
                this.L = new CJRSmsReceiver();
                this.L.f27253a = this;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                intentFilter.setPriority(1000);
                this.f27487d.registerReceiver(this.L, intentFilter);
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName());
                sb.append(" : register");
                com.paytm.utility.b.j();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    private void h(String str) {
        StringBuilder sb = new StringBuilder();
        com.travel.train.b.a();
        sb.append(com.travel.train.b.b().e());
        sb.append("?type=");
        sb.append(str);
        sb.append(AppConstants.AND_SIGN);
        String sb2 = sb.toString();
        String str2 = this.f27489f;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            Activity activity = this.f27487d;
            a((Context) activity, activity.getString(R.string.please_wait_progress_msg));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27487d;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = sb2 + "userId=" + this.f27489f;
            bVar.f42882f = n.b((Context) this.f27487d);
            bVar.f42885i = new CJRTrainResendOTP();
            bVar.j = this;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            if (com.paytm.utility.b.c((Context) this.f27487d)) {
                l2.a();
            } else {
                a(l2);
            }
        }
    }

    private void i(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            Activity activity = this.f27487d;
            a((Context) activity, activity.getString(R.string.verifying_otp));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27487d;
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.r;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str;
            bVar.f42882f = n.b((Context) this.f27487d);
            bVar.f42885i = new CJRTrainVerifyOTP();
            bVar.j = this;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            if (com.paytm.utility.b.c((Context) this.f27487d)) {
                l2.a();
            } else {
                a(l2);
            }
        }
    }

    private void n() {
        Activity activity = this.f27487d;
        if (activity != null && !activity.isFinishing()) {
            this.E.dismiss();
        }
    }

    public final void c() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f27487d.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.j.getWindowToken(), 0);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public final void b(String str) {
        if (str != null) {
            TextView textView = this.ab;
            if (textView != null) {
                textView.setText(str);
                this.H.findViewById(R.id.date_of_birth_heading).setVisibility(0);
            }
            this.ah = com.paytm.utility.b.d(str, "dd/MM/yyyy", "yyyyMMdd");
            com.paytm.utility.b.j();
        }
    }

    class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        String f27510a;

        public a(String str) {
            this.f27510a = str;
        }

        public final void onClick(View view) {
            this.f27510a.equalsIgnoreCase(b.this.f27487d.getString(R.string.click_here_text));
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(b.this.f27487d.getResources().getColor(R.color.paytm_blue));
            textPaint.setUnderlineText(false);
        }
    }

    private void o() {
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            net.one97.paytm.common.widgets.a.b(this.B);
        }
    }
}
