package net.one97.paytm.paymentsBank.slfd.createfd.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.u;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.x;
import kotlin.m.p;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankCommon.utils.c;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.g.a;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel;
import net.one97.paytm.paymentsBank.si.view.CustomAmountTextInputEditText;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.common.view.SlfdCheckoutActivity;
import net.one97.paytm.paymentsBank.slfd.createfd.a.a;
import net.one97.paytm.paymentsBank.slfd.nominee.view.SlfdNomineeListActivity;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstants;

public final class CreateSlfdActivity extends SlfdBaseActivity implements a.b {

    /* renamed from: b  reason: collision with root package name */
    public a.C0333a f19065b;

    /* renamed from: c  reason: collision with root package name */
    private CustomAmountTextInputEditText f19066c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f19067d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19068e;

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f19069f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f19070g;

    /* renamed from: h  reason: collision with root package name */
    private RadioButton f19071h;

    /* renamed from: i  reason: collision with root package name */
    private CheckBox f19072i;
    private Button j;
    private ProgressBar k;
    private ProgressDialog l;
    private View m;
    private SlfdMetaApiResponseModel n;
    private double o;
    private int p;
    /* access modifiers changed from: private */
    public final int q = 1;
    private final int r = 2;
    private HashMap s;

    public final View a(int i2) {
        if (this.s == null) {
            this.s = new HashMap();
        }
        View view = (View) this.s.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.s.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ RadioButton b(CreateSlfdActivity createSlfdActivity) {
        RadioButton radioButton = createSlfdActivity.f19071h;
        if (radioButton == null) {
            kotlin.g.b.k.a("rbNoNominee");
        }
        return radioButton;
    }

    public static final /* synthetic */ RadioButton c(CreateSlfdActivity createSlfdActivity) {
        RadioButton radioButton = createSlfdActivity.f19069f;
        if (radioButton == null) {
            kotlin.g.b.k.a("rbNominee");
        }
        return radioButton;
    }

    public static final /* synthetic */ CheckBox d(CreateSlfdActivity createSlfdActivity) {
        CheckBox checkBox = createSlfdActivity.f19072i;
        if (checkBox == null) {
            kotlin.g.b.k.a("cbTnC");
        }
        return checkBox;
    }

    public static final /* synthetic */ CustomAmountTextInputEditText f(CreateSlfdActivity createSlfdActivity) {
        CustomAmountTextInputEditText customAmountTextInputEditText = createSlfdActivity.f19066c;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        return customAmountTextInputEditText;
    }

    public final a.C0333a f() {
        a.C0333a aVar = this.f19065b;
        if (aVar == null) {
            kotlin.g.b.k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_fd_create;
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Context context = this;
        this.l = new ProgressDialog(context);
        Serializable serializableExtra = getIntent().getSerializableExtra("slfd_meta_response");
        Double d2 = null;
        if (!(serializableExtra instanceof SlfdMetaApiResponseModel)) {
            serializableExtra = null;
        }
        this.n = (SlfdMetaApiResponseModel) serializableExtra;
        this.o = getIntent().getDoubleExtra("sa_balance", 0.0d);
        View findViewById = findViewById(R.id.parent);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.parent)");
        this.m = findViewById;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        kotlin.g.b.k.a((Object) toolbar, "toolbar");
        toolbar.setNavigationIcon(androidx.core.content.b.a(context, R.drawable.pb_ic_back));
        toolbar.setNavigationOnClickListener(new e(this));
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        kotlin.g.b.k.a((Object) collapsingToolbarLayout, "ctl");
        collapsingToolbarLayout.setTitle(getString(R.string.fd_create_fd_header));
        View findViewById2 = findViewById(R.id.tiet_amount);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById<CustomAmoun…itText>(R.id.tiet_amount)");
        this.f19066c = (CustomAmountTextInputEditText) findViewById2;
        CustomAmountTextInputEditText customAmountTextInputEditText = this.f19066c;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        customAmountTextInputEditText.setMaxDigitsBeforeDecimalPoint(8);
        CustomAmountTextInputEditText customAmountTextInputEditText2 = this.f19066c;
        if (customAmountTextInputEditText2 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        customAmountTextInputEditText2.setDecimalFormat("##,##,##,##,##0.");
        CustomAmountTextInputEditText customAmountTextInputEditText3 = this.f19066c;
        if (customAmountTextInputEditText3 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        customAmountTextInputEditText3.setIntegerFormat("##,##,##,##,##0");
        CustomAmountTextInputEditText customAmountTextInputEditText4 = this.f19066c;
        if (customAmountTextInputEditText4 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        customAmountTextInputEditText4.a();
        CustomAmountTextInputEditText customAmountTextInputEditText5 = this.f19066c;
        if (customAmountTextInputEditText5 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        StringBuilder sb = new StringBuilder("(([₹]{1})?([\\s]{1})?([0-9]{1})([0-9,]{0,");
        CustomAmountTextInputEditText customAmountTextInputEditText6 = this.f19066c;
        if (customAmountTextInputEditText6 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        sb.append(customAmountTextInputEditText6.getMaxDigitsBeforeDecimalPoint() - 1);
        sb.append("})?)(?:\\.[0-9]{0,");
        CustomAmountTextInputEditText customAmountTextInputEditText7 = this.f19066c;
        if (customAmountTextInputEditText7 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        sb.append(customAmountTextInputEditText7.getMaxDigitsAfterDecimalPoint());
        sb.append("})?");
        customAmountTextInputEditText5.setRegex(sb.toString());
        String string = getString(R.string.fd_amount_hint_limit_text);
        if (this.n != null) {
            int i2 = R.string.fd_todays_roi;
            Object[] objArr = new Object[2];
            SlfdMetaApiResponseModel slfdMetaApiResponseModel = this.n;
            objArr[0] = slfdMetaApiResponseModel != null ? slfdMetaApiResponseModel.getPeakInterestRatePerAnnum() : null;
            SlfdMetaApiResponseModel slfdMetaApiResponseModel2 = this.n;
            objArr[1] = slfdMetaApiResponseModel2 != null ? slfdMetaApiResponseModel2.getPeakTenureMonths() : null;
            str = getString(i2, objArr);
            kotlin.g.b.k.a((Object) str, "getString(R.string.fd_to…eModel?.peakTenureMonths)");
            aa aaVar = aa.f47921a;
            kotlin.g.b.k.a((Object) string, "limit");
            Object[] objArr2 = new Object[1];
            SlfdMetaApiResponseModel slfdMetaApiResponseModel3 = this.n;
            if (slfdMetaApiResponseModel3 != null) {
                d2 = slfdMetaApiResponseModel3.getFdFloorAmount();
            }
            objArr2[0] = d2;
            string = String.format(string, Arrays.copyOf(objArr2, 1));
            kotlin.g.b.k.a((Object) string, "java.lang.String.format(format, *args)");
        } else {
            str = "";
        }
        View findViewById3 = findViewById(R.id.tv_amount_limit_hint);
        TextView textView = (TextView) findViewById3;
        kotlin.g.b.k.a((Object) textView, "it");
        textView.setText(string);
        kotlin.g.b.k.a((Object) findViewById3, "(findViewById<TextView>(….also { it.text = limit }");
        this.f19067d = textView;
        SpannableString spannableString = new SpannableString(str);
        f fVar = new f(this);
        String spannableString2 = spannableString.toString();
        kotlin.g.b.k.a((Object) spannableString2, "ss.toString()");
        int a2 = p.a((CharSequence) spannableString2, "View", 0, false, 6);
        int i3 = a2 + 12;
        spannableString.setSpan(fVar, a2, i3, 33);
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_00b9f5)), a2, i3, 33);
        spannableString.setSpan(new StyleSpan(1), a2, i3, 33);
        String spannableString3 = spannableString.toString();
        kotlin.g.b.k.a((Object) spannableString3, "ss.toString()");
        String spannableString4 = spannableString.toString();
        kotlin.g.b.k.a((Object) spannableString4, "ss.toString()");
        spannableString.setSpan(new StyleSpan(1), p.a((CharSequence) spannableString3, "Interest", 0, false, 6) + 9, p.a((CharSequence) spannableString4, "for", 0, false, 6) - 1, 33);
        View findViewById4 = findViewById(R.id.tv_rate_of_interest);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById<TextView>(R.id.tv_rate_of_interest)");
        this.f19068e = (TextView) findViewById4;
        TextView textView2 = this.f19068e;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvInterestRate");
        }
        textView2.setText(spannableString);
        TextView textView3 = this.f19068e;
        if (textView3 == null) {
            kotlin.g.b.k.a("tvInterestRate");
        }
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        View findViewById5 = findViewById(R.id.tv_change_edit_nominee);
        TextView textView4 = (TextView) findViewById5;
        textView4.setOnClickListener(new a(this));
        kotlin.g.b.k.a((Object) findViewById5, "(findViewById<TextView>(…}\n            }\n        }");
        this.f19070g = textView4;
        View findViewById6 = findViewById(R.id.rb_nominee);
        RadioButton radioButton = (RadioButton) findViewById6;
        radioButton.setOnClickListener(new b(this));
        kotlin.g.b.k.a((Object) findViewById6, "(findViewById<RadioButto…)\n            }\n        }");
        this.f19069f = radioButton;
        View findViewById7 = findViewById(R.id.rb_no_nominee);
        RadioButton radioButton2 = (RadioButton) findViewById7;
        radioButton2.setOnClickListener(new c(this));
        kotlin.g.b.k.a((Object) findViewById7, "(findViewById<RadioButto…)\n            }\n        }");
        this.f19071h = radioButton2;
        View findViewById8 = findViewById(R.id.cb_tnc);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById<CheckBox>(R.id.cb_tnc)");
        this.f19072i = (CheckBox) findViewById8;
        SpannableString spannableString5 = new SpannableString(getString(R.string.fd_tnc));
        g gVar = new g(this);
        String spannableString6 = spannableString5.toString();
        kotlin.g.b.k.a((Object) spannableString6, "ssTnc.toString()");
        int a3 = p.a((CharSequence) spannableString6, "Terms", 0, false, 6);
        int i4 = a3 + 18;
        spannableString5.setSpan(gVar, a3, i4, 33);
        spannableString5.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.color_00b9f5)), a3, i4, 33);
        CheckBox checkBox = this.f19072i;
        if (checkBox == null) {
            kotlin.g.b.k.a("cbTnC");
        }
        checkBox.setText(spannableString5);
        CheckBox checkBox2 = this.f19072i;
        if (checkBox2 == null) {
            kotlin.g.b.k.a("cbTnC");
        }
        checkBox2.setMovementMethod(LinkMovementMethod.getInstance());
        View findViewById9 = findViewById(R.id.pb_progress);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById<ProgressBar>(R.id.pb_progress)");
        this.k = (ProgressBar) findViewById9;
        ProgressBar progressBar = this.k;
        if (progressBar == null) {
            kotlin.g.b.k.a("pbProgress");
        }
        u.g((View) progressBar, 10.0f);
        View findViewById10 = findViewById(R.id.btn_proceed);
        Button button = (Button) findViewById10;
        button.setOnClickListener(new d(this));
        kotlin.g.b.k.a((Object) findViewById10, "(findViewById<Button>(R.…}\n            }\n        }");
        this.j = button;
        net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit/create", "fixed-deposit", context);
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        a.C0333a aVar = new net.one97.paytm.paymentsBank.slfd.createfd.b.a(this, net.one97.paytm.paymentsBank.slfd.c.a(applicationContext));
        kotlin.g.b.k.c(aVar, "<set-?>");
        this.f19065b = aVar;
        f().a();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        super.onActivityResult(i2, i3, intent);
        Serializable serializable = null;
        if (i2 == 1) {
            if (i3 == -1) {
                if (intent != null) {
                    serializable = intent.getSerializableExtra("slfd_nominee");
                }
                if (serializable != null) {
                    f().a((SlfdNomineeModel) serializable, intent.getIntExtra("slfd_selected_nominee_position", 0));
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.slfd.SlfdNomineeModel");
            }
        } else if (i2 == 101) {
            if (i3 == -1) {
                if (intent == null || (str = intent.getStringExtra("passcode")) == null) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (str == null) {
                        str = "";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        CustomAmountTextInputEditText customAmountTextInputEditText = this.f19066c;
                        if (customAmountTextInputEditText == null) {
                            kotlin.g.b.k.a("tietAmount");
                        }
                        String ab = net.one97.paytm.bankCommon.mapping.a.ab(String.valueOf(customAmountTextInputEditText.getText()));
                        a.C0333a f2 = f();
                        kotlin.g.b.k.a((Object) ab, "amount");
                        RadioButton radioButton = this.f19071h;
                        if (radioButton == null) {
                            kotlin.g.b.k.a("rbNoNominee");
                        }
                        f2.a(ab, str, !radioButton.isChecked());
                        return;
                    }
                    View view = this.m;
                    if (view == null) {
                        kotlin.g.b.k.a("parentContainer");
                    }
                    String string = getString(R.string.pb_something_wrong_try_again);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.pb_something_wrong_try_again)");
                    Snackbar a2 = Snackbar.a(view, (CharSequence) string, 0);
                    kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
                    a2.c();
                }
            }
        } else if (i2 == 2 && i3 == -1) {
            f().a(true);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        f().b();
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19077a;

        e(CreateSlfdActivity createSlfdActivity) {
            this.f19077a = createSlfdActivity;
        }

        public final void onClick(View view) {
            this.f19077a.finish();
        }
    }

    public static final class f extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19078a;

        f(CreateSlfdActivity createSlfdActivity) {
            this.f19078a = createSlfdActivity;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            o.a().openWebViewActivity(this.f19078a.getApplicationContext(), "https://paytm.com/offer/know-more-for-fixed-deposit/", "");
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19073a;

        a(CreateSlfdActivity createSlfdActivity) {
            this.f19073a = createSlfdActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19073a, "fixed_deposit", "add_change_new_nominee", "", "", "", "/fixed-deposit/create", "fixed_deposit");
            kotlin.g.b.k.a((Object) view, "it");
            if (kotlin.g.b.k.a(view.getTag(), (Object) Integer.valueOf(this.f19073a.q))) {
                CreateSlfdActivity createSlfdActivity = this.f19073a;
                Context context = createSlfdActivity;
                Intent intent = new Intent(context, PaymentsBankBaseActivity.class);
                intent.setClass(context, PaymentsBankBaseActivity.class);
                intent.putExtra("extraDefaultFrame", 2);
                intent.putExtra("DO_CREATE_ACCOUNT", false);
                intent.putExtra("add_nominee_for_slfd", true);
                createSlfdActivity.startActivityForResult(intent, 2);
                return;
            }
            this.f19073a.f().c();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19074a;

        b(CreateSlfdActivity createSlfdActivity) {
            this.f19074a = createSlfdActivity;
        }

        public final void onClick(View view) {
            CreateSlfdActivity.b(this.f19074a).setChecked(false);
            CreateSlfdActivity.c(this.f19074a).setTypeface(Typeface.create("sans-serif-medium", 0));
            CreateSlfdActivity.c(this.f19074a).setTextColor(androidx.core.content.b.c(this.f19074a, R.color.color_222222));
            CreateSlfdActivity.b(this.f19074a).setTypeface(Typeface.create("sans-serif", 0));
            CreateSlfdActivity.b(this.f19074a).setTextColor(androidx.core.content.b.c(this.f19074a, R.color.color_444444));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19075a;

        c(CreateSlfdActivity createSlfdActivity) {
            this.f19075a = createSlfdActivity;
        }

        public final void onClick(View view) {
            CreateSlfdActivity.c(this.f19075a).setChecked(false);
            CreateSlfdActivity.c(this.f19075a).setTypeface(Typeface.create("sans-serif", 0));
            CreateSlfdActivity.c(this.f19075a).setTextColor(androidx.core.content.b.c(this.f19075a, R.color.color_444444));
            CreateSlfdActivity.b(this.f19075a).setTypeface(Typeface.create("sans-serif-medium", 0));
            CreateSlfdActivity.b(this.f19075a).setTextColor(androidx.core.content.b.c(this.f19075a, R.color.color_222222));
        }
    }

    public static final class g extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19079a;

        g(CreateSlfdActivity createSlfdActivity) {
            this.f19079a = createSlfdActivity;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            CreateSlfdActivity.d(this.f19079a).setChecked(!CreateSlfdActivity.d(this.f19079a).isChecked());
            this.f19079a.f().d();
        }

        public final void updateDrawState(TextPaint textPaint) {
            kotlin.g.b.k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19076a;

        d(CreateSlfdActivity createSlfdActivity) {
            this.f19076a = createSlfdActivity;
        }

        public final void onClick(View view) {
            if (CreateSlfdActivity.e(this.f19076a)) {
                net.one97.paytm.bankCommon.mapping.c.a(this.f19076a, "fixed_deposit", "proceed_button_clicked", CreateSlfdActivity.c(this.f19076a).isChecked() ? "add_nominee_selected" : "no_nominee_selected", (String) null, (String) null, "/fixed-deposit/create", "fixed_deposit");
                String ab = net.one97.paytm.bankCommon.mapping.a.ab(String.valueOf(CreateSlfdActivity.f(this.f19076a).getText()));
                a.C0333a f2 = this.f19076a.f();
                kotlin.g.b.k.a((Object) ab, "amount");
                f2.a(ab);
            }
        }
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "nomineeName");
        RadioButton radioButton = this.f19069f;
        if (radioButton == null) {
            kotlin.g.b.k.a("rbNominee");
        }
        radioButton.setText(str);
        RadioButton radioButton2 = this.f19069f;
        if (radioButton2 == null) {
            kotlin.g.b.k.a("rbNominee");
        }
        radioButton2.setVisibility(0);
        RadioButton radioButton3 = this.f19069f;
        if (radioButton3 == null) {
            kotlin.g.b.k.a("rbNominee");
        }
        radioButton3.setChecked(true);
        RadioButton radioButton4 = this.f19071h;
        if (radioButton4 == null) {
            kotlin.g.b.k.a("rbNoNominee");
        }
        radioButton4.setChecked(false);
        TextView textView = this.f19070g;
        if (textView == null) {
            kotlin.g.b.k.a("tvEditNominee");
        }
        textView.setTag(Integer.valueOf(this.r));
        TextView textView2 = this.f19070g;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvEditNominee");
        }
        textView2.setText(getString(R.string.fd_change_edit_nominee));
    }

    public final void a() {
        RadioButton radioButton = this.f19069f;
        if (radioButton == null) {
            kotlin.g.b.k.a("rbNominee");
        }
        radioButton.setVisibility(8);
        RadioButton radioButton2 = this.f19069f;
        if (radioButton2 == null) {
            kotlin.g.b.k.a("rbNominee");
        }
        radioButton2.setChecked(false);
        RadioButton radioButton3 = this.f19071h;
        if (radioButton3 == null) {
            kotlin.g.b.k.a("rbNoNominee");
        }
        radioButton3.setChecked(true);
        TextView textView = this.f19070g;
        if (textView == null) {
            kotlin.g.b.k.a("tvEditNominee");
        }
        textView.setText(getString(R.string.fd_add_nominee));
        TextView textView2 = this.f19070g;
        if (textView2 == null) {
            kotlin.g.b.k.a("tvEditNominee");
        }
        textView2.setTag(Integer.valueOf(this.q));
    }

    public final void b(int i2) {
        Intent intent = new Intent(this, SlfdNomineeListActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("slfd_selected_nominee_position", i2);
        startActivityForResult(intent, 1);
    }

    public final void a(boolean z) {
        if (z) {
            this.p++;
            ProgressBar progressBar = this.k;
            if (progressBar == null) {
                kotlin.g.b.k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
            return;
        }
        this.p--;
        if (this.p == 0) {
            ProgressBar progressBar2 = this.k;
            if (progressBar2 == null) {
                kotlin.g.b.k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar2);
        }
    }

    public final void b(boolean z) {
        if (z) {
            ProgressDialog progressDialog = this.l;
            if (progressDialog == null) {
                kotlin.g.b.k.a("progreeDialog");
            }
            progressDialog.show();
            ProgressDialog progressDialog2 = this.l;
            if (progressDialog2 == null) {
                kotlin.g.b.k.a("progreeDialog");
            }
            progressDialog2.setMessage("Please wait while we create your Fixed Deposit");
            return;
        }
        ProgressDialog progressDialog3 = this.l;
        if (progressDialog3 == null) {
            kotlin.g.b.k.a("progreeDialog");
        }
        progressDialog3.dismiss();
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "errorTitle");
        View view = this.m;
        if (view == null) {
            kotlin.g.b.k.a("parentContainer");
        }
        if (str2 == null) {
            str2 = getString(R.string.pb_something_wrong_try_again);
            kotlin.g.b.k.a((Object) str2, "getString(R.string.pb_something_wrong_try_again)");
        }
        Snackbar a2 = Snackbar.a(view, (CharSequence) str2, 0);
        kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    static final class k implements a.C0317a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19085a;

        k(CreateSlfdActivity createSlfdActivity) {
            this.f19085a = createSlfdActivity;
        }

        public final void a() {
            CreateSlfdActivity.d(this.f19085a).setChecked(true);
        }
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        kotlin.g.b.k.c(arrayList, "tncDataList");
        net.one97.paytm.paymentsBank.g.a a2 = net.one97.paytm.paymentsBank.g.a.a(arrayList);
        a2.a((a.C0317a) new k(this));
        a2.show(getSupportFragmentManager(), "KycTNCFragment");
    }

    public final void b() {
        Context context = this;
        View inflate = LayoutInflater.from(context).inflate(R.layout.fd_bottom_sheet, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_confirm_title);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.tv_confirm_amount);
            if (findViewById2 != null) {
                TextView textView2 = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.tv_desc);
                if (findViewById3 != null) {
                    TextView textView3 = (TextView) findViewById3;
                    View findViewById4 = inflate.findViewById(R.id.tv_desc_number);
                    if (findViewById4 != null) {
                        TextView textView4 = (TextView) findViewById4;
                        View findViewById5 = inflate.findViewById(R.id.btn_action);
                        if (findViewById5 != null) {
                            Button button = (Button) findViewById5;
                            CustomAmountTextInputEditText customAmountTextInputEditText = this.f19066c;
                            if (customAmountTextInputEditText == null) {
                                kotlin.g.b.k.a("tietAmount");
                            }
                            textView2.setText(customAmountTextInputEditText.getText());
                            CustomAmountTextInputEditText customAmountTextInputEditText2 = this.f19066c;
                            if (customAmountTextInputEditText2 == null) {
                                kotlin.g.b.k.a("tietAmount");
                            }
                            String ab = net.one97.paytm.bankCommon.mapping.a.ab(String.valueOf(customAmountTextInputEditText2.getText()));
                            x.a aVar = new x.a();
                            aVar.element = false;
                            try {
                                kotlin.g.b.k.a((Object) ab, "amount");
                                if (Double.compare(Double.parseDouble(ab), this.o) > 0) {
                                    aVar.element = true;
                                    textView.setText(getString(R.string.fd_low_sa_balance));
                                    textView2.setVisibility(8);
                                    button.setText(getString(R.string.fd_add_money));
                                } else {
                                    textView.setText(getString(R.string.fd_invest_confirm_text));
                                    textView2.setVisibility(0);
                                    aa aaVar = aa.f47921a;
                                    String string = getString(R.string.fd_confirm_to_invest);
                                    kotlin.g.b.k.a((Object) string, "getString(R.string.fd_confirm_to_invest)");
                                    String format = String.format(string, Arrays.copyOf(new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(ab)}, 1));
                                    kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                                    button.setText(format);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            textView3.setText(getString(R.string.fd_invest_sa_balance));
                            aa aaVar2 = aa.f47921a;
                            String string2 = getString(R.string.fd_amount);
                            kotlin.g.b.k.a((Object) string2, "getString(R.string.fd_amount)");
                            String format2 = String.format(string2, Arrays.copyOf(new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(this.o))}, 1));
                            kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                            net.one97.paytm.bankCommon.mapping.e.a(format2, textView4);
                            com.google.android.material.bottomsheet.a aVar2 = new com.google.android.material.bottomsheet.a(context);
                            aVar2.setContentView(inflate);
                            kotlin.g.b.k.a((Object) inflate, "bottomSheet");
                            ViewParent parent = inflate.getParent();
                            if (parent != null) {
                                BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
                                kotlin.g.b.k.a((Object) from, "BottomSheetBehavior.from…ttomSheet.parent as View)");
                                from.setState(3);
                                aVar2.show();
                                aVar2.setOnDismissListener(new i(from));
                                View findViewById6 = inflate.findViewById(R.id.iv_close);
                                if (findViewById6 != null) {
                                    ((ImageView) findViewById6).setOnClickListener(new h(aVar2));
                                    button.setOnClickListener(new j(this, aVar2, aVar));
                                    net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit/create-proceed", "fixed-deposit", context);
                                    return;
                                }
                                throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            throw new kotlin.u("null cannot be cast to non-null type android.view.View");
                        }
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.Button");
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class i implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f19081a;

        i(BottomSheetBehavior bottomSheetBehavior) {
            this.f19081a = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f19081a.setState(4);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f19080a;

        h(com.google.android.material.bottomsheet.a aVar) {
            this.f19080a = aVar;
        }

        public final void onClick(View view) {
            this.f19080a.dismiss();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateSlfdActivity f19082a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f19083b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.a f19084c;

        j(CreateSlfdActivity createSlfdActivity, com.google.android.material.bottomsheet.a aVar, x.a aVar2) {
            this.f19082a = createSlfdActivity;
            this.f19083b = aVar;
            this.f19084c = aVar2;
        }

        public final void onClick(View view) {
            this.f19083b.dismiss();
            if (this.f19084c.element) {
                net.one97.paytm.bankCommon.mapping.c.a(this.f19082a, "fixed_deposit", "add_money_button_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/create", "fixed_deposit");
                Intent intent = this.f19082a.getIntent();
                net.one97.paytm.paymentsBank.h.a a2 = o.a();
                kotlin.g.b.k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
                intent.setClass(this.f19082a, a2.getMoneyTransferActivityV3Class());
                intent.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, c.a.ALL);
                intent.putExtra(UpiConstants.MONEY_TRANSFER_HEADER, this.f19082a.getResources().getString(R.string.money_transfer));
                this.f19082a.startActivity(intent);
                return;
            }
            net.one97.paytm.bankCommon.mapping.c.a(this.f19082a, "fixed_deposit", "confirm_to_invest_button_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/create", "fixed_deposit");
            Intent intent2 = this.f19082a.getIntent();
            net.one97.paytm.paymentsBank.h.a a3 = o.a();
            kotlin.g.b.k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
            intent2.setClass(this.f19082a, a3.getAJREnterPasscodeClass());
            intent2.putExtra("ENTER_HEADER", "paytm_create_fd_passcode");
            intent2.putExtra("REDIRECT_TO", c.b.RETURN_TO_CALLER_ACTIVITY.ordinal());
            this.f19082a.startActivityForResult(intent2, 101);
        }
    }

    public final void a(String str, double d2) {
        kotlin.g.b.k.c(str, "orderId");
        Intent intent = getIntent();
        intent.setClass(this, SlfdCheckoutActivity.class);
        intent.putExtra("order_id", str);
        intent.putExtra("is_from_impulse", true);
        intent.putExtra("slfd_amount", d2);
        startActivity(intent);
        finish();
    }

    public static final /* synthetic */ boolean e(CreateSlfdActivity createSlfdActivity) {
        Double fdFloorAmount;
        CustomAmountTextInputEditText customAmountTextInputEditText = createSlfdActivity.f19066c;
        if (customAmountTextInputEditText == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        if (TextUtils.isEmpty(String.valueOf(customAmountTextInputEditText.getText()))) {
            View view = createSlfdActivity.m;
            if (view == null) {
                kotlin.g.b.k.a("parentContainer");
            }
            String string = createSlfdActivity.getString(R.string.fd_empty_amount);
            kotlin.g.b.k.a((Object) string, "getString(R.string.fd_empty_amount)");
            Snackbar a2 = Snackbar.a(view, (CharSequence) string, 0);
            kotlin.g.b.k.a((Object) a2, "Snackbar.make(this, message, length)");
            a2.c();
            return false;
        }
        CustomAmountTextInputEditText customAmountTextInputEditText2 = createSlfdActivity.f19066c;
        if (customAmountTextInputEditText2 == null) {
            kotlin.g.b.k.a("tietAmount");
        }
        String ab = net.one97.paytm.bankCommon.mapping.a.ab(String.valueOf(customAmountTextInputEditText2.getText()));
        kotlin.g.b.k.a((Object) ab, "amount");
        double parseDouble = Double.parseDouble(ab);
        double d2 = 0.0d;
        if (Double.compare(parseDouble, 0.0d) == 0) {
            View view2 = createSlfdActivity.m;
            if (view2 == null) {
                kotlin.g.b.k.a("parentContainer");
            }
            String string2 = createSlfdActivity.getString(R.string.fd_zero_amount);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.fd_zero_amount)");
            Snackbar a3 = Snackbar.a(view2, (CharSequence) string2, 0);
            kotlin.g.b.k.a((Object) a3, "Snackbar.make(this, message, length)");
            a3.c();
            return false;
        }
        SlfdMetaApiResponseModel slfdMetaApiResponseModel = createSlfdActivity.n;
        if (!(slfdMetaApiResponseModel == null || (fdFloorAmount = slfdMetaApiResponseModel.getFdFloorAmount()) == null)) {
            d2 = fdFloorAmount.doubleValue();
        }
        if (parseDouble < d2) {
            View view3 = createSlfdActivity.m;
            if (view3 == null) {
                kotlin.g.b.k.a("parentContainer");
            }
            int i2 = R.string.fd_create_min_amount_error;
            Object[] objArr = new Object[1];
            SlfdMetaApiResponseModel slfdMetaApiResponseModel2 = createSlfdActivity.n;
            objArr[0] = slfdMetaApiResponseModel2 != null ? slfdMetaApiResponseModel2.getFdFloorAmount() : null;
            String string3 = createSlfdActivity.getString(i2, objArr);
            kotlin.g.b.k.a((Object) string3, "getString(R.string.fd_cr…onseModel?.fdFloorAmount)");
            Snackbar a4 = Snackbar.a(view3, (CharSequence) string3, 0);
            kotlin.g.b.k.a((Object) a4, "Snackbar.make(this, message, length)");
            a4.c();
            return false;
        }
        RadioButton radioButton = createSlfdActivity.f19071h;
        if (radioButton == null) {
            kotlin.g.b.k.a("rbNoNominee");
        }
        if (!radioButton.isChecked()) {
            RadioButton radioButton2 = createSlfdActivity.f19069f;
            if (radioButton2 == null) {
                kotlin.g.b.k.a("rbNominee");
            }
            if (!radioButton2.isChecked()) {
                View view4 = createSlfdActivity.m;
                if (view4 == null) {
                    kotlin.g.b.k.a("parentContainer");
                }
                String string4 = createSlfdActivity.getString(R.string.fd_select_nominee_msg);
                kotlin.g.b.k.a((Object) string4, "getString(R.string.fd_select_nominee_msg)");
                Snackbar a5 = Snackbar.a(view4, (CharSequence) string4, 0);
                kotlin.g.b.k.a((Object) a5, "Snackbar.make(this, message, length)");
                a5.c();
                return false;
            }
            RadioButton radioButton3 = createSlfdActivity.f19069f;
            if (radioButton3 == null) {
                kotlin.g.b.k.a("rbNominee");
            }
            if (radioButton3.getText().length() <= 0) {
                View view5 = createSlfdActivity.m;
                if (view5 == null) {
                    kotlin.g.b.k.a("parentContainer");
                }
                Snackbar a6 = Snackbar.a(view5, (CharSequence) "Nominee error", 0);
                kotlin.g.b.k.a((Object) a6, "Snackbar.make(this, message, length)");
                a6.c();
                return false;
            }
        }
        CheckBox checkBox = createSlfdActivity.f19072i;
        if (checkBox == null) {
            kotlin.g.b.k.a("cbTnC");
        }
        if (checkBox.isChecked()) {
            return true;
        }
        View view6 = createSlfdActivity.m;
        if (view6 == null) {
            kotlin.g.b.k.a("parentContainer");
        }
        String string5 = createSlfdActivity.getString(R.string.fd_accept_tnc);
        kotlin.g.b.k.a((Object) string5, "getString(R.string.fd_accept_tnc)");
        Snackbar a7 = Snackbar.a(view6, (CharSequence) string5, 0);
        kotlin.g.b.k.a((Object) a7, "Snackbar.make(this, message, length)");
        a7.c();
        return false;
    }
}
