package net.one97.paytm.paymentsBank.slfd.redeemFd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.u;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FDPostTransactionActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDMaxLimitModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDTrialRedeemAmount;
import net.one97.paytm.paymentsBank.slfd.redeemFd.a;
import net.one97.paytm.paymentsBank.slfd.redeemFd.c;
import net.one97.paytm.paymentsBank.slfd.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.utils.q;

public class RedeemFdActivity extends SlfdBaseActivity implements c.b {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f19277c;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.g f19278b = kotlin.h.a(new l(this));

    /* renamed from: d  reason: collision with root package name */
    public c.a f19279d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f19280e;

    /* renamed from: f  reason: collision with root package name */
    public io.reactivex.rxjava3.b.c f19281f;

    /* renamed from: g  reason: collision with root package name */
    double f19282g;

    /* renamed from: h  reason: collision with root package name */
    protected double f19283h;

    /* renamed from: i  reason: collision with root package name */
    public String f19284i;
    boolean j = true;
    protected net.one97.paytm.bankCommon.f.d k;
    private final kotlin.g l = kotlin.h.a(new c(this));
    private final kotlin.g m = kotlin.h.a(new b(this));
    private final kotlin.g n = kotlin.h.a(new p(this));
    private final kotlin.g o = kotlin.h.a(new m(this));
    private final kotlin.g p = kotlin.h.a(new j(this));
    private final kotlin.g q = kotlin.h.a(new d(this));
    private final kotlin.g r = kotlin.h.a(new k(this));
    private final kotlin.g s = kotlin.h.a(new a(this));
    private final kotlin.g t = kotlin.h.a(new n(this));
    private final kotlin.g u = kotlin.h.a(new o(this));
    private SlfdMetaApiResponseModel v;
    private String w;
    /* access modifiers changed from: private */
    public double x = -1.0d;
    private boolean y;
    private HashMap z;

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final g f19287a = new g();

        g() {
        }

        public final void onClick(View view) {
        }
    }

    static {
        Class<RedeemFdActivity> cls = RedeemFdActivity.class;
        f19277c = new kotlin.k.i[]{y.a((v) new w(y.b(cls), "toolbar", "getToolbar()Landroidx/appcompat/widget/Toolbar;")), y.a((v) new w(y.b(cls), "edtAmount", "getEdtAmount()Lnet/one97/paytm/paymentsBank/slfd/view/CustomAmountTextInputEditText;")), y.a((v) new w(y.b(cls), "btnRedeem", "getBtnRedeem()Landroid/widget/Button;")), y.a((v) new w(y.b(cls), "tvRedeemLimit", "getTvRedeemLimit()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "tvAmountInWords", "getTvAmountInWords()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "parentContainer", "getParentContainer()Landroidx/constraintlayout/widget/ConstraintLayout;")), y.a((v) new w(y.b(cls), "ivRedeemBanner", "getIvRedeemBanner()Landroid/widget/ImageView;")), y.a((v) new w(y.b(cls), "progressBar", "getProgressBar()Landroid/widget/ProgressBar;")), y.a((v) new w(y.b(cls), "amountTIL", "getAmountTIL()Lcom/google/android/material/textfield/TextInputLayout;")), y.a((v) new w(y.b(cls), "tvForm60MaxLimit", "getTvForm60MaxLimit()Landroid/widget/TextView;")), y.a((v) new w(y.b(cls), "tvInvestedAmountValue", "getTvInvestedAmountValue()Landroid/widget/TextView;"))};
    }

    private ImageView p() {
        return (ImageView) this.q.getValue();
    }

    private ProgressBar q() {
        return (ProgressBar) this.r.getValue();
    }

    private TextView r() {
        return (TextView) this.t.getValue();
    }

    private TextView s() {
        return (TextView) this.u.getValue();
    }

    public final View a(int i2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.z.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final CustomAmountTextInputEditText g() {
        return (CustomAmountTextInputEditText) this.l.getValue();
    }

    public final Button h() {
        return (Button) this.m.getValue();
    }

    public final TextView i() {
        return (TextView) this.o.getValue();
    }

    public final ConstraintLayout j() {
        return (ConstraintLayout) this.p.getValue();
    }

    public final TextInputLayout k() {
        return (TextInputLayout) this.s.getValue();
    }

    static final class h<T> implements io.reactivex.rxjava3.d.g<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RedeemFdActivity f19288a;

        h(RedeemFdActivity redeemFdActivity) {
            this.f19288a = redeemFdActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            String str = (String) obj;
            RedeemFdActivity redeemFdActivity = this.f19288a;
            kotlin.g.b.k.a((Object) str, "input");
            redeemFdActivity.d(str);
        }
    }

    public final void a(String str) {
        this.w = str;
        v();
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        kotlin.g.b.k.c(slfdMetaApiResponseModel, "model");
        this.v = slfdMetaApiResponseModel;
        u();
    }

    public final c.a f() {
        c.a aVar = this.f19279d;
        if (aVar == null) {
            kotlin.g.b.k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.layout_redeem_fd;
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.a<Toolbar> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final Toolbar invoke() {
            return (Toolbar) this.this$0.findViewById(R.id.toolbar);
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.a<CustomAmountTextInputEditText> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final CustomAmountTextInputEditText invoke() {
            return (CustomAmountTextInputEditText) this.this$0.findViewById(R.id.tiet_amount);
        }
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<Button> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final Button invoke() {
            return (Button) this.this$0.findViewById(R.id.btn_proceed);
        }
    }

    static final class p extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_redeem_fd_hint);
        }
    }

    static final class m extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_redeem_words);
        }
    }

    static final class j extends kotlin.g.b.l implements kotlin.g.a.a<ConstraintLayout> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final ConstraintLayout invoke() {
            return (ConstraintLayout) this.this$0.findViewById(R.id.parent);
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final ImageView invoke() {
            return (ImageView) this.this$0.findViewById(R.id.iv_banner);
        }
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.a<ProgressBar> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final ProgressBar invoke() {
            return (ProgressBar) this.this$0.findViewById(R.id.progress_bar);
        }
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<TextInputLayout> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final TextInputLayout invoke() {
            return (TextInputLayout) this.this$0.findViewById(R.id.amount_til);
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_form_60_max_limit);
        }
    }

    static final class o extends kotlin.g.b.l implements kotlin.g.a.a<TextView> {
        final /* synthetic */ RedeemFdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(RedeemFdActivity redeemFdActivity) {
            super(0);
            this.this$0 = redeemFdActivity;
        }

        public final TextView invoke() {
            return (TextView) this.this$0.findViewById(R.id.tv_invested_amount_value);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context context = this;
        net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit/redeem", "fixed-deposit", context);
        if (getIntent().hasExtra("slfd_max_limit")) {
            this.j = false;
            this.f19282g = getIntent().getDoubleExtra("slfd_max_limit", 0.0d);
        }
        if (getIntent().hasExtra("slfd_meta_response")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("slfd_meta_response");
            if (serializableExtra != null) {
                this.v = (SlfdMetaApiResponseModel) serializableExtra;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel");
            }
        }
        if (getIntent().hasExtra("sfld_account_balance")) {
            String stringExtra = getIntent().getStringExtra("sfld_account_balance");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.w = stringExtra;
        }
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("from_deeplink")) {
            this.y = getIntent().getBooleanExtra("from_deeplink", false);
        }
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "this.applicationContext");
        c.a gVar = new g(net.one97.paytm.paymentsBank.slfd.c.a(applicationContext), this);
        kotlin.g.b.k.c(gVar, "<set-?>");
        this.f19279d = gVar;
        if (this.f19280e) {
            g().setMaxDigitsBeforeDecimalPoint(8);
            g().setMaxDigitsAfterDecimalPoint(0);
            g().setDecimalFormat("##,##,##,##,##0");
            g().setIntegerFormat("##,##,##,##,##0");
            g().a();
            CustomAmountTextInputEditText g2 = g();
            g2.setRegex("(([₹]{1})?([\\s]{1})?([0-9]{1})([0-9,]{0," + (g().getMaxDigitsBeforeDecimalPoint() - 1) + "})?)(?:\\.[0-9]{0," + g().getMaxDigitsAfterDecimalPoint() + "})?");
        } else {
            g().setMaxDigitsBeforeDecimalPoint(8);
            g().setDecimalFormat("##,##,##,##,##0.");
            g().setIntegerFormat("##,##,##,##,##0");
            g().a();
            CustomAmountTextInputEditText g3 = g();
            g3.setRegex("(([₹]{1})?([\\s]{1})?([0-9]{1})([0-9,]{0," + (g().getMaxDigitsBeforeDecimalPoint() - 1) + "})?)(?:\\.[0-9]{0," + g().getMaxDigitsAfterDecimalPoint() + "})?");
        }
        h().setOnClickListener(new f(this));
        ProgressBar q2 = q();
        q2.setOnClickListener(g.f19287a);
        androidx.core.h.u.g((View) q2, (float) net.one97.paytm.bankCommon.mapping.a.a(4.0f, context));
        ((ImageView) ((Toolbar) this.f19278b.getValue()).findViewById(R.id.iv_back_arrow)).setOnClickListener(new e(this));
        io.reactivex.rxjava3.b.c subscribe = q.a(g()).debounce(100, TimeUnit.MILLISECONDS).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new h(this));
        kotlin.g.b.k.a((Object) subscribe, "RxViewObservable.fromVie…ext(input)\n\n            }");
        this.f19281f = subscribe;
        if (this.y) {
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.hasExtra("amount_to_redeem")) {
                g().postDelayed(new i(this, getIntent().getDoubleExtra("amount_to_redeem", 0.0d)), 100);
            }
            f().c();
            if (!net.one97.paytm.bankCommon.h.b.p(context)) {
                net.one97.paytm.paymentsBank.slfd.interestprojection.d.a a2 = net.one97.paytm.paymentsBank.slfd.interestprojection.d.a.a(context);
                kotlin.g.b.k.a((Object) a2, "InterestProjectionManage…tionManagerInstance(this)");
                a2.b(context);
                a2.a((g.b) this, (g.a) this);
                return;
            }
            return;
        }
        u();
        v();
        t();
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RedeemFdActivity f19286a;

        f(RedeemFdActivity redeemFdActivity) {
            this.f19286a = redeemFdActivity;
        }

        public final void onClick(View view) {
            this.f19286a.l();
            net.one97.paytm.bankCommon.mapping.c.a(this.f19286a, "fixed_deposit", "redeem_deposit_proceed_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/redeem", "fixed_deposit");
            String valueOf = String.valueOf(this.f19286a.g().getText());
            RedeemFdActivity redeemFdActivity = this.f19286a;
            String ab = net.one97.paytm.bankCommon.mapping.a.ab(valueOf);
            kotlin.g.b.k.a((Object) ab, "CJRAppUtility.getCleanString(amount)");
            kotlin.g.b.k.c(ab, "amount");
            boolean z = false;
            if (kotlin.m.p.a(ab)) {
                ConstraintLayout j = redeemFdActivity.j();
                kotlin.g.b.k.a((Object) j, "parentContainer");
                String string = redeemFdActivity.getString(R.string.fd_empty_amount);
                kotlin.g.b.k.a((Object) string, "getString(R.string.fd_empty_amount)");
                Snackbar a2 = Snackbar.a((View) j, (CharSequence) string, 0);
                kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
                a2.c();
            } else if (ab.equals("0")) {
                ConstraintLayout j2 = redeemFdActivity.j();
                kotlin.g.b.k.a((Object) j2, "parentContainer");
                String string2 = redeemFdActivity.getString(R.string.fd_zero_amount);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.fd_zero_amount)");
                Snackbar a3 = Snackbar.a((View) j2, (CharSequence) string2, 0);
                kotlin.g.b.k.a((Object) a3, "Snackbar.make(this, message, length)");
                a3.c();
            } else if (redeemFdActivity.j || redeemFdActivity.f19280e || Double.parseDouble(ab) <= redeemFdActivity.f19282g) {
                z = true;
            } else {
                ConstraintLayout j3 = redeemFdActivity.j();
                kotlin.g.b.k.a((Object) j3, "parentContainer");
                String string3 = redeemFdActivity.getString(R.string.pb_fd_empty_amount_exceeded_max_limit);
                kotlin.g.b.k.a((Object) string3, "getString(R.string.pb_fd…mount_exceeded_max_limit)");
                Snackbar a4 = Snackbar.a((View) j3, (CharSequence) string3, 0);
                kotlin.g.b.k.a((Object) a4, "Snackbar.make(this, message, length)");
                a4.c();
            }
            if (z) {
                this.f19286a.f().a(valueOf, this.f19286a.x);
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RedeemFdActivity f19285a;

        e(RedeemFdActivity redeemFdActivity) {
            this.f19285a = redeemFdActivity;
        }

        public final void onClick(View view) {
            this.f19285a.finish();
        }
    }

    public static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RedeemFdActivity f19289a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f19290b;

        i(RedeemFdActivity redeemFdActivity, double d2) {
            this.f19289a = redeemFdActivity;
            this.f19290b = d2;
        }

        public final void run() {
            double d2 = this.f19290b;
            if (d2 - ((double) ((int) d2)) != 0.0d) {
                this.f19289a.g().setText(String.valueOf(this.f19290b));
            } else {
                this.f19289a.g().setText(String.valueOf((int) this.f19290b));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void d(String str) {
        k().setError((CharSequence) null);
        k().setErrorEnabled(false);
        try {
            String ab = net.one97.paytm.bankCommon.mapping.a.ab(str);
            if (TextUtils.isEmpty(ab)) {
                i().setText("");
                return;
            }
            String ab2 = net.one97.paytm.bankCommon.mapping.a.ab(ab);
            kotlin.g.b.k.a((Object) ab2, "CJRAppUtility.getCleanString(cleanText)");
            long parseLong = Long.parseLong(ab2);
            TextView i2 = i();
            i2.setText(net.one97.paytm.paymentsBank.utils.i.a(parseLong) + " " + getString(R.string.pb_fd_rupees));
            i().setVisibility(0);
            if (this.f19280e) {
                if (this.k != null) {
                    net.one97.paytm.bankCommon.f.d dVar = this.k;
                    if (dVar == null) {
                        kotlin.g.b.k.a();
                    }
                    dVar.onFragmentAction(1, ab);
                }
            } else if (!this.j) {
                String ab3 = net.one97.paytm.bankCommon.mapping.a.ab(ab);
                kotlin.g.b.k.a((Object) ab3, "CJRAppUtility.getCleanString(cleanText)");
                if (Double.parseDouble(ab3) > this.f19282g) {
                    i().setVisibility(4);
                    k().setErrorEnabled(true);
                    k().setError(getString(R.string.pb_fd_empty_amount_exceeded_max_limit));
                } else if (this.x != -1.0d) {
                    f().b(str, this.x);
                }
            } else if (this.x != -1.0d) {
                f().b(str, this.x);
            }
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i().setVisibility(4);
        }
    }

    private void t() {
        if (this.j) {
            r().setVisibility(8);
            return;
        }
        r().setVisibility(0);
        r().setText(getString(R.string.pb_fd_you_can_transfer_maximum_10_000, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(this.f19282g))}));
    }

    private void u() {
        String redemptionBannerUrl;
        SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.v;
        if (slfdMetaApiResponseModel != null && (redemptionBannerUrl = slfdMetaApiResponseModel.getRedemptionBannerUrl()) != null) {
            com.squareup.picasso.w.a().a(redemptionBannerUrl).a(p());
        }
    }

    private void v() {
        if (!TextUtils.isEmpty(this.w)) {
            String str = this.w;
            try {
                this.x = Double.parseDouble(str);
                str = new DecimalFormat("##,##,##,##,##,##,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(this.x);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(s());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.rs_str, new Object[]{str}));
            StyleSpan styleSpan = new StyleSpan(1);
            int length = spannableStringBuilder.length();
            Integer valueOf = str != null ? Integer.valueOf(str.length()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            spannableStringBuilder.setSpan(styleSpan, (length - valueOf.intValue()) - 1, spannableStringBuilder.length(), 17);
            s().setText(spannableStringBuilder);
        } else {
            net.one97.paytm.paymentsBank.slfd.b.a.b.c(s());
        }
        d(String.valueOf(g().getText()));
    }

    public final void a(a aVar) {
        String str;
        kotlin.g.b.k.c(aVar, "amountValidationError");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(q());
        if (aVar instanceof a.b) {
            str = ((a.b) aVar).f19294a;
        } else if (aVar instanceof a.C0341a) {
            str = getString(R.string.fd_empty_amount);
            kotlin.g.b.k.a((Object) str, "getString(R.string.fd_empty_amount)");
        } else if (aVar instanceof a.e) {
            str = getString(R.string.fd_zero_amount);
            kotlin.g.b.k.a((Object) str, "getString(R.string.fd_zero_amount)");
        } else if (aVar instanceof a.d) {
            str = getString(R.string.pb_something_wrong_try_again);
            kotlin.g.b.k.a((Object) str, "getString(R.string.pb_something_wrong_try_again)");
        } else if (aVar instanceof a.c) {
            str = getString(R.string.fd_empty_amount_exceeded);
            kotlin.g.b.k.a((Object) str, "getString(R.string.fd_empty_amount_exceeded)");
        } else {
            str = "";
        }
        ConstraintLayout j2 = j();
        kotlin.g.b.k.a((Object) j2, "parentContainer");
        Snackbar a2 = Snackbar.a((View) j2, (CharSequence) str, 0);
        kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.paymentsBank.utils.o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void l() {
        try {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(g().getWindowToken(), 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, "amount");
        f().a(str);
    }

    public final void m() {
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(q());
    }

    public final void b(a aVar) {
        kotlin.g.b.k.c(aVar, "amountValidationError");
        if (aVar instanceof a.c) {
            i().setVisibility(4);
            k().setErrorEnabled(true);
            k().setError(getString(R.string.pb_fd_entered_amount_greater_than_available_deposit));
        }
    }

    public final void n() {
        Context context = this;
        net.one97.paytm.paymentsBank.slfd.interestprojection.d.a a2 = net.one97.paytm.paymentsBank.slfd.interestprojection.d.a.a(context);
        kotlin.g.b.k.a((Object) a2, "InterestProjectionManage…tionManagerInstance(this)");
        a2.b(context);
        String valueOf = String.valueOf(g().getText());
        if (valueOf != null) {
            String ab = net.one97.paytm.bankCommon.mapping.a.ab(kotlin.m.p.b(valueOf).toString());
            kotlin.g.b.k.a((Object) ab, "CJRAppUtility.getCleanSt…t.text.toString().trim())");
            this.f19284i = ab;
            String str = this.f19284i;
            if (str == null) {
                kotlin.g.b.k.a("enteredAmount");
            }
            a2.b(str, this, this);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(q());
        if (iJRPaytmDataModel instanceof FDMaxLimitModel) {
            getIntent();
            this.j = false;
            Double availableAmount = ((FDMaxLimitModel) iJRPaytmDataModel).getAvailableAmount();
            kotlin.g.b.k.a((Object) availableAmount, "fdMaxLimitModel.availableAmount");
            this.f19282g = availableAmount.doubleValue();
            t();
            return;
        }
        FDTrialRedeemAmount fDTrialRedeemAmount = (FDTrialRedeemAmount) iJRPaytmDataModel;
        if (kotlin.m.p.a(fDTrialRedeemAmount.getStatus(), "success", true)) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            Activity activity = this;
            String str = this.f19284i;
            if (str == null) {
                kotlin.g.b.k.a("enteredAmount");
            }
            kotlin.g.b.k.c(activity, "ctx");
            kotlin.g.b.k.c("Enter your Paytm Payments Bank passcode to proceed", "title");
            kotlin.g.b.k.c(fDTrialRedeemAmount, "fdTrialRedeemAmount");
            kotlin.g.b.k.c(str, "enteredAmount");
            Intent intent = new Intent(activity, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", "Enter your Paytm Payments Bank passcode to proceed");
            intent.putExtra("r_token", true);
            intent.putExtra("extra_fd_trial_redeem", fDTrialRedeemAmount);
            intent.putExtra("slfd_amount", str);
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            activity.startActivityForResult(intent, 121);
        } else if (!kotlin.m.p.a(fDTrialRedeemAmount.getStatus(), ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, true) || TextUtils.isEmpty(fDTrialRedeemAmount.getMessage())) {
            net.one97.paytm.bankCommon.mapping.a.b((Context) this, getString(R.string.error), getString(R.string.some_went_wrong));
        } else {
            net.one97.paytm.bankCommon.mapping.a.b((Context) this, getString(R.string.error), fDTrialRedeemAmount.getMessage());
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(iJRPaytmDataModel, "model");
        kotlin.g.b.k.c(networkCustomError, "error");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(q());
        net.one97.paytm.bankCommon.utils.f.a((Activity) this, (Exception) networkCustomError, (String) null);
    }

    public final void a(String str, Double d2) {
        Intent intent = new Intent(this, FDPostTransactionActivity.class);
        intent.putExtra("order_id", str);
        intent.putExtra("slfd_amount", d2);
        startActivity(intent);
        finish();
    }

    public final void o() {
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(q());
    }

    public final void a(NetworkCustomError networkCustomError) {
        String str;
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(q());
        ConstraintLayout j2 = j();
        kotlin.g.b.k.a((Object) j2, "parentContainer");
        View view = j2;
        if (networkCustomError == null || (str = networkCustomError.getAlertMessage()) == null) {
            str = getString(R.string.pb_something_wrong_try_again);
            kotlin.g.b.k.a((Object) str, "getString(R.string.pb_something_wrong_try_again)");
        }
        Snackbar a2 = Snackbar.a(view, (CharSequence) str, 0);
        kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public final void c(String str) {
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(q());
        ConstraintLayout j2 = j();
        kotlin.g.b.k.a((Object) j2, "parentContainer");
        View view = j2;
        if (str == null) {
            str = getString(R.string.pb_something_wrong_try_again);
            kotlin.g.b.k.a((Object) str, "getString(R.string.pb_something_wrong_try_again)");
        }
        Snackbar a2 = Snackbar.a(view, (CharSequence) str, 0);
        kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 121) {
            if (i2 == 301 && i3 == -1) {
                finish();
            }
        } else if (i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            c.a f2 = f();
            String stringExtra = intent.getStringExtra("passcode");
            kotlin.g.b.k.a((Object) stringExtra, "data.getStringExtra(EXTRA_PASSCODE)");
            f2.b(stringExtra);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        f().b();
        io.reactivex.rxjava3.b.c cVar = this.f19281f;
        if (cVar == null) {
            kotlin.g.b.k.a("disposable");
        }
        if (!cVar.isDisposed()) {
            io.reactivex.rxjava3.b.c cVar2 = this.f19281f;
            if (cVar2 == null) {
                kotlin.g.b.k.a("disposable");
            }
            cVar2.dispose();
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            ProgressBar progressBar = (ProgressBar) a(R.id.progress_bar);
            kotlin.g.b.k.a((Object) progressBar, "progress_bar");
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) a(R.id.progress_bar);
        kotlin.g.b.k.a((Object) progressBar2, "progress_bar");
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar2);
    }
}
