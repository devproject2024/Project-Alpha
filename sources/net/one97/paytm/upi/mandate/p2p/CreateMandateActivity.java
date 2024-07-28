package net.one97.paytm.upi.mandate.p2p;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.deeplink.model.ExtraIntentParams;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.mandate.a.b;
import net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity;
import net.one97.paytm.upi.mandate.d.a;
import net.one97.paytm.upi.mandate.p2p.a.b;
import net.one97.paytm.upi.mandate.p2p.a.c;
import net.one97.paytm.upi.mandate.p2p.a.f;
import net.one97.paytm.upi.mandate.p2p.e;
import net.one97.paytm.upi.mandate.p2p.f;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.EnglishNumberToWords;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class CreateMandateActivity extends PaytmActivity implements b.C1350b, b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f67254a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upi.e.a f67255b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.g f67256c = kotlin.h.a(new a(this));

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.g f67257d = kotlin.h.a(new b(this));

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.g f67258e = kotlin.h.a(new r(this));

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.g f67259f = kotlin.h.a(new e(this));

    /* renamed from: g  reason: collision with root package name */
    private Bundle f67260g;

    /* renamed from: h  reason: collision with root package name */
    private ValidateVpaResponse f67261h;

    /* renamed from: i  reason: collision with root package name */
    private final int f67262i = 1008;
    /* access modifiers changed from: private */
    public final int j = 1009;
    private String k;
    private String l;

    static {
        Class<CreateMandateActivity> cls = CreateMandateActivity.class;
        f67254a = new kotlin.k.i[]{y.a((v) new w(y.b(cls), "createMandateViewModel", "getCreateMandateViewModel()Lnet/one97/paytm/upi/mandate/p2p/CreateMandateViewModel;")), y.a((v) new w(y.b(cls), "frequencyArray", "getFrequencyArray()[Ljava/lang/String;")), y.a((v) new w(y.b(cls), "weeklyArray", "getWeeklyArray()[Ljava/lang/String;")), y.a((v) new w(y.b(cls), "paymentScheduleArray", "getPaymentScheduleArray()[Ljava/lang/String;"))};
    }

    /* access modifiers changed from: private */
    public final c a() {
        return (c) this.f67256c.getValue();
    }

    private final String[] b() {
        return (String[]) this.f67257d.getValue();
    }

    private final String[] c() {
        return (String[]) this.f67259f.getValue();
    }

    static final class q<T> implements z<net.one97.paytm.upi.mandate.data.a<x>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67278a;

        q(CreateMandateActivity createMandateActivity) {
            this.f67278a = createMandateActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upi.mandate.data.a aVar = (net.one97.paytm.upi.mandate.data.a) obj;
            int i2 = a.f67279a[aVar.f67117a.ordinal()];
            if (i2 == 1) {
                CreateMandateActivity.c(this.f67278a);
            } else if (i2 == 2) {
                CreateMandateActivity.a(this.f67278a, aVar.f67119c);
            } else if (i2 == 3) {
                this.f67278a.a(true);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.e.a b(CreateMandateActivity createMandateActivity) {
        net.one97.paytm.upi.e.a aVar = createMandateActivity.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        return aVar;
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<c> {
        final /* synthetic */ CreateMandateActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CreateMandateActivity createMandateActivity) {
            super(0);
            this.this$0 = createMandateActivity;
        }

        public final c invoke() {
            ai a2 = am.a((FragmentActivity) this.this$0, (al.b) new net.one97.paytm.upi.mandate.utils.o()).a(c.class);
            kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(ac…, factory)[T::class.java]");
            return (c) a2;
        }
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<String[]> {
        final /* synthetic */ CreateMandateActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CreateMandateActivity createMandateActivity) {
            super(0);
            this.this$0 = createMandateActivity;
        }

        public final String[] invoke() {
            return this.this$0.getResources().getStringArray(R.array.upi_mandate_frequency_array);
        }
    }

    static final class r extends kotlin.g.b.l implements kotlin.g.a.a<String[]> {
        final /* synthetic */ CreateMandateActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(CreateMandateActivity createMandateActivity) {
            super(0);
            this.this$0 = createMandateActivity;
        }

        public final String[] invoke() {
            return this.this$0.getResources().getStringArray(R.array.upi_mandate_weekly_array);
        }
    }

    static final class e extends kotlin.g.b.l implements kotlin.g.a.a<String[]> {
        final /* synthetic */ CreateMandateActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(CreateMandateActivity createMandateActivity) {
            super(0);
            this.this$0 = createMandateActivity;
        }

        public final String[] invoke() {
            return this.this$0.getResources().getStringArray(R.array.upi_mandate_schedule_payment_array);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.upi.e.a a2 = net.one97.paytm.upi.e.a.a(getLayoutInflater());
        kotlin.g.b.k.a((Object) a2, "ActivityCreateMandateBin…g.inflate(layoutInflater)");
        this.f67255b = a2;
        net.one97.paytm.upi.e.a aVar = this.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        setContentView((View) aVar.a());
        a().b();
        a().m.observe(this, new q(this));
        Intent intent = getIntent();
        if (intent == null) {
            kotlin.g.b.k.a();
        }
        Bundle bundleExtra = intent.getBundleExtra("payee_details");
        kotlin.g.b.k.a((Object) bundleExtra, "intent!!.getBundleExtra(KEY_PAYEE_DETAILS)");
        this.f67260g = bundleExtra;
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_VERIFIED_VPA_RESPONSE");
        if (!(serializableExtra instanceof ValidateVpaResponse)) {
            serializableExtra = null;
        }
        this.f67261h = (ValidateVpaResponse) serializableExtra;
        Bundle bundle2 = this.f67260g;
        if (bundle2 == null) {
            kotlin.g.b.k.a("payeeDetails");
        }
        String a3 = net.one97.paytm.upi.f.a(bundle2.getString("payee_name"));
        if (a3 == null) {
            a3 = "";
        }
        this.k = a3;
        Bundle bundle3 = this.f67260g;
        if (bundle3 == null) {
            kotlin.g.b.k.a("payeeDetails");
        }
        String string = bundle3.getString("payee_vpa");
        if (string == null) {
            string = "";
        }
        this.l = string;
        net.one97.paytm.upi.e.a aVar2 = this.f67255b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText = aVar2.f66716a;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText, "amountEditText");
        customAmountTextInputEditText.addTextChangedListener(new p(aVar2, this));
        net.one97.paytm.upi.e.a aVar3 = this.f67255b;
        if (aVar3 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = aVar3.A;
        kotlin.g.b.k.a((Object) textView, "payeeName");
        String str = this.k;
        if (str == null) {
            kotlin.g.b.k.a("payeeName");
        }
        textView.setText(str);
        TextView textView2 = aVar3.B;
        kotlin.g.b.k.a((Object) textView2, "payeeVpa");
        int i2 = R.string.upi_id_placeholder;
        Object[] objArr = new Object[1];
        String str2 = this.l;
        if (str2 == null) {
            kotlin.g.b.k.a("payeeVpa");
        }
        objArr[0] = str2;
        textView2.setText(getString(i2, objArr));
        TextView textView3 = aVar3.t;
        kotlin.g.b.k.a((Object) textView3, "nameInitials");
        String str3 = this.k;
        if (str3 == null) {
            kotlin.g.b.k.a("payeeName");
        }
        textView3.setText(UpiUtils.getNameInitials(str3));
        net.one97.paytm.upi.e.a aVar4 = this.f67255b;
        if (aVar4 == null) {
            kotlin.g.b.k.a("binding");
        }
        aVar4.p.setOnClickListener(new g(this));
        aVar4.Q.setOnClickListener(new h(this));
        aVar4.R.setOnClickListener(new i(this));
        aVar4.l.setOnClickListener(new j(this));
        aVar4.F.setOnClickListener(new k(this));
        aVar4.x.f66923a.setOnClickListener(new l(this));
        aVar4.f66723h.setOnClickListener(new m(this));
        aVar4.I.setOnClickListener(new n(this));
        net.one97.paytm.upi.e.a aVar5 = this.f67255b;
        if (aVar5 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView4 = aVar5.p;
        kotlin.g.b.k.a((Object) textView4, "frequencyTextView");
        net.one97.paytm.upi.f.b(textView4, R.drawable.upi_mandate_down_arrow);
        TextView textView5 = aVar5.Q;
        kotlin.g.b.k.a((Object) textView5, "schedulePaymentType");
        net.one97.paytm.upi.f.b(textView5, R.drawable.upi_mandate_down_arrow);
        TextView textView6 = aVar5.F;
        kotlin.g.b.k.a((Object) textView6, "paymentDayValue");
        net.one97.paytm.upi.f.b(textView6, R.drawable.upi_mandate_down_arrow);
        TextView textView7 = aVar5.V;
        kotlin.g.b.k.a((Object) textView7, "tvImportantLabel");
        net.one97.paytm.upi.f.a(textView7, R.drawable.upi_ic_important);
        net.one97.paytm.upi.e.a aVar6 = this.f67255b;
        if (aVar6 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView8 = aVar6.R;
        kotlin.g.b.k.a((Object) textView8, "binding.startDate");
        a(textView8);
        net.one97.paytm.upi.e.a aVar7 = this.f67255b;
        if (aVar7 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView9 = aVar7.l;
        kotlin.g.b.k.a((Object) textView9, "binding.endDate");
        a(textView9);
        net.one97.paytm.upi.e.a aVar8 = this.f67255b;
        if (aVar8 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView10 = aVar8.F;
        kotlin.g.b.k.a((Object) textView10, "binding.paymentDayValue");
        a(textView10);
        net.one97.paytm.upi.e.a aVar9 = this.f67255b;
        if (aVar9 == null) {
            kotlin.g.b.k.a("binding");
        }
        RadioGroup radioGroup = aVar9.W;
        kotlin.g.b.k.a((Object) radioGroup, "binding.typeRadioGroup");
        radioGroup.setOnCheckedChangeListener(new o(this, radioGroup));
        net.one97.paytm.upi.e.a aVar10 = this.f67255b;
        if (aVar10 == null) {
            kotlin.g.b.k.a("binding");
        }
        CheckBox checkBox = aVar10.f66719d;
        kotlin.g.b.k.a((Object) checkBox, "binding.amountRuleCheckbox");
        checkBox.setOnCheckedChangeListener(new f(this));
        net.one97.paytm.upi.e.a aVar11 = this.f67255b;
        if (aVar11 == null) {
            kotlin.g.b.k.a("binding");
        }
        RadioGroup radioGroup2 = aVar11.W;
        kotlin.g.b.k.a((Object) radioGroup2, "typeRadioGroup");
        RadioButton a4 = net.one97.paytm.upi.f.a(radioGroup2, a().f67318e.getIndex());
        if (a4 != null) {
            a4.setChecked(true);
        }
        TextView textView11 = aVar11.p;
        kotlin.g.b.k.a((Object) textView11, "frequencyTextView");
        textView11.setText(b()[a().f67316c.getIndex()]);
        TextView textView12 = aVar11.Q;
        kotlin.g.b.k.a((Object) textView12, "schedulePaymentType");
        textView12.setText(c()[a().f67317d.getIndex()]);
    }

    static final class f implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67265a;

        f(CreateMandateActivity createMandateActivity) {
            this.f67265a = createMandateActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f67265a.a().a("MAX");
            } else {
                this.f67265a.a().a("EXACT");
            }
        }
    }

    static final class o implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67274a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RadioGroup f67275b;

        o(CreateMandateActivity createMandateActivity, RadioGroup radioGroup) {
            this.f67274a = createMandateActivity;
            this.f67275b = radioGroup;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            int a2 = net.one97.paytm.upi.f.a(this.f67275b);
            c a3 = this.f67274a.a();
            a3.f67318e = a3.f67322i[a2];
            androidx.transition.v.a((ViewGroup) CreateMandateActivity.b(this.f67274a).a());
            boolean z = false;
            if (a2 == 0) {
                Group group = CreateMandateActivity.b(this.f67274a).G;
                kotlin.g.b.k.a((Object) group, "binding.paymentFrequencyGroup");
                net.one97.paytm.upi.f.b((View) group);
                Group group2 = CreateMandateActivity.b(this.f67274a).j;
                kotlin.g.b.k.a((Object) group2, "binding.dailyPaymentFrequencyHidingGroup");
                net.one97.paytm.upi.f.b((View) group2);
                RadioButton a4 = net.one97.paytm.upi.f.a(this.f67275b, 0);
                if (a4 != null) {
                    a4.setTypeface(Typeface.SANS_SERIF, 1);
                }
                RadioButton a5 = net.one97.paytm.upi.f.a(this.f67275b, 1);
                if (a5 != null) {
                    a5.setTypeface(Typeface.SANS_SERIF, 0);
                }
            } else {
                Group group3 = CreateMandateActivity.b(this.f67274a).G;
                kotlin.g.b.k.a((Object) group3, "binding.paymentFrequencyGroup");
                net.one97.paytm.upi.f.a((View) group3);
                Group group4 = CreateMandateActivity.b(this.f67274a).j;
                kotlin.g.b.k.a((Object) group4, "binding.dailyPaymentFrequencyHidingGroup");
                net.one97.paytm.upi.f.a((View) group4);
                RadioButton a6 = net.one97.paytm.upi.f.a(this.f67275b, 1);
                if (a6 != null) {
                    a6.setTypeface(Typeface.SANS_SERIF, 1);
                }
                RadioButton a7 = net.one97.paytm.upi.f.a(this.f67275b, 0);
                if (a7 != null) {
                    a7.setTypeface(Typeface.SANS_SERIF, 0);
                }
                TextView textView = CreateMandateActivity.b(this.f67274a).T;
                kotlin.g.b.k.a((Object) textView, "binding.startDateError");
                net.one97.paytm.upi.f.a((View) textView);
                TextView textView2 = CreateMandateActivity.b(this.f67274a).n;
                kotlin.g.b.k.a((Object) textView2, "binding.endDateError");
                net.one97.paytm.upi.f.a((View) textView2);
                TextView textView3 = CreateMandateActivity.b(this.f67274a).D;
                kotlin.g.b.k.a((Object) textView3, "binding.paymentDayError");
                net.one97.paytm.upi.f.a((View) textView3);
            }
            if (this.f67274a.a().n != null) {
                z = true;
            }
            if (z) {
                this.f67274a.a().d();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (z) {
            net.one97.paytm.upi.e.a aVar = this.f67255b;
            if (aVar == null) {
                kotlin.g.b.k.a("binding");
            }
            AnimationFactory.startWalletLoader(aVar.r);
            return;
        }
        net.one97.paytm.upi.e.a aVar2 = this.f67255b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        AnimationFactory.stopWalletLoader(aVar2.r);
    }

    public static final class p implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.upi.e.a f67276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67277b;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public p(net.one97.paytm.upi.e.a aVar, CreateMandateActivity createMandateActivity) {
            this.f67276a = aVar;
            this.f67277b = createMandateActivity;
        }

        public final void afterTextChanged(Editable editable) {
            CharSequence charSequence = editable;
            if (charSequence == null || kotlin.m.p.a(charSequence)) {
                CheckBox checkBox = this.f67276a.f66719d;
                kotlin.g.b.k.a((Object) checkBox, "amountRuleCheckbox");
                checkBox.setText(this.f67277b.getString(R.string.upi_enable_any_amt_empty));
                TextView textView = this.f67276a.f66718c;
                kotlin.g.b.k.a((Object) textView, "amountInWords");
                textView.setText("");
                this.f67276a.O.setTextColor(net.one97.paytm.upi.f.c("#8ba6c1"));
                return;
            }
            TextView textView2 = this.f67276a.f66717b;
            kotlin.g.b.k.a((Object) textView2, "amountError");
            net.one97.paytm.upi.f.a((View) textView2);
            CheckBox checkBox2 = this.f67276a.f66719d;
            kotlin.g.b.k.a((Object) checkBox2, "amountRuleCheckbox");
            checkBox2.setText(this.f67277b.getString(R.string.upi_enable_any_amt, new Object[]{net.one97.paytm.upi.f.b(editable.toString())}));
            TextView textView3 = this.f67276a.f66718c;
            kotlin.g.b.k.a((Object) textView3, "amountInWords");
            CreateMandateActivity createMandateActivity = this.f67277b;
            int i2 = R.string.mt_amount_in_words_placeholder;
            CustomAmountTextInputEditText customAmountTextInputEditText = CreateMandateActivity.b(this.f67277b).f66716a;
            kotlin.g.b.k.a((Object) customAmountTextInputEditText, "binding.amountEditText");
            textView3.setText(createMandateActivity.getString(i2, new Object[]{EnglishNumberToWords.convert(customAmountTextInputEditText.getCleanString())}));
            this.f67276a.O.setTextColor(net.one97.paytm.upi.f.c("#1d252d"));
        }
    }

    private final void b(UpiProfileDefaultBank upiProfileDefaultBank) {
        net.one97.paytm.upi.e.a aVar = this.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        net.one97.paytm.upi.e.x xVar = aVar.x;
        kotlin.g.b.k.a((Object) xVar, "noBankSupportedLayout");
        ConstraintLayout a2 = xVar.a();
        kotlin.g.b.k.a((Object) a2, "noBankSupportedLayout.root");
        net.one97.paytm.upi.f.a((View) a2);
        Group group = aVar.y;
        kotlin.g.b.k.a((Object) group, "noBanksGroup");
        net.one97.paytm.upi.f.b((View) group);
        TextView textView = aVar.f66723h;
        kotlin.g.b.k.a((Object) textView, "bankName");
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
        String bankName = debitBank.getBankName();
        StringBuilder sb = new StringBuilder();
        sb.append(bankName);
        BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank2, "upiProfileDefaultBank.debitBank");
        sb.append(UpiUtils.getFormattedMaskedAcc(debitBank2.getAccount()));
        textView.setText(sb.toString());
        UpiUtils.setBankIcon(aVar.f66722g, upiProfileDefaultBank.getDebitBank(), (Context) this);
        a().f67315b = upiProfileDefaultBank.getDebitBank();
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67266a;

        g(CreateMandateActivity createMandateActivity) {
            this.f67266a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.e(this.f67266a);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67267a;

        h(CreateMandateActivity createMandateActivity) {
            this.f67267a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.f(this.f67267a);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67268a;

        i(CreateMandateActivity createMandateActivity) {
            this.f67268a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.g(this.f67268a);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67269a;

        j(CreateMandateActivity createMandateActivity) {
            this.f67269a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.h(this.f67269a);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67270a;

        k(CreateMandateActivity createMandateActivity) {
            this.f67270a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.i(this.f67270a);
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67271a;

        l(CreateMandateActivity createMandateActivity) {
            this.f67271a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity createMandateActivity = this.f67271a;
            AccountProviderActivity.a((Activity) createMandateActivity, createMandateActivity.j);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67272a;

        m(CreateMandateActivity createMandateActivity) {
            this.f67272a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.k(this.f67272a);
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67273a;

        n(CreateMandateActivity createMandateActivity) {
            this.f67273a = createMandateActivity;
        }

        public final void onClick(View view) {
            CreateMandateActivity.l(this.f67273a);
        }
    }

    private static void a(TextView textView) {
        textView.setTextColor(net.one97.paytm.upi.f.c("#8ba6c1"));
        textView.setTypeface(Typeface.SANS_SERIF, 1);
    }

    static final class c implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67263a;

        c(CreateMandateActivity createMandateActivity) {
            this.f67263a = createMandateActivity;
        }

        public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            TextView textView = CreateMandateActivity.b(this.f67263a).l;
            textView.setTextColor(net.one97.paytm.upi.f.c("#1d252d"));
            textView.setTypeface(Typeface.SANS_SERIF, 0);
            String a2 = this.f67263a.a().a(i2, i3, i4, net.one97.paytm.upi.mandate.utils.g.END_DATE);
            textView.setText(this.f67263a.getString(R.string.upi_mandate_ending_date_format, new Object[]{a2}));
            TextView textView2 = CreateMandateActivity.b(this.f67263a).n;
            kotlin.g.b.k.a((Object) textView2, "binding.endDateError");
            net.one97.paytm.upi.f.a((View) textView2);
        }
    }

    static final class d implements DatePickerDialog.OnDateSetListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CreateMandateActivity f67264a;

        d(CreateMandateActivity createMandateActivity) {
            this.f67264a = createMandateActivity;
        }

        public final void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            TextView textView = CreateMandateActivity.b(this.f67264a).R;
            textView.setTextColor(net.one97.paytm.upi.f.c("#1d252d"));
            textView.setTypeface(Typeface.SANS_SERIF, 0);
            String a2 = this.f67264a.a().a(i2, i3, i4, net.one97.paytm.upi.mandate.utils.g.START_DATE);
            if (!kotlin.g.b.k.a((Object) this.f67264a.getString(R.string.upi_mandate_starting_date_format, new Object[]{a2}), (Object) textView.getText().toString())) {
                textView.setText(this.f67264a.getString(R.string.upi_mandate_starting_date_format, new Object[]{a2}));
                this.f67264a.d();
            }
            TextView textView2 = CreateMandateActivity.b(this.f67264a).T;
            kotlin.g.b.k.a((Object) textView2, "binding.startDateError");
            net.one97.paytm.upi.f.a((View) textView2);
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        net.one97.paytm.upi.e.a aVar = this.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = aVar.l;
        kotlin.g.b.k.a((Object) textView, "binding.endDate");
        textView.setText(getString(R.string.select_date));
        net.one97.paytm.upi.e.a aVar2 = this.f67255b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView2 = aVar2.l;
        kotlin.g.b.k.a((Object) textView2, "binding.endDate");
        a(textView2);
        a().l = "";
    }

    public final void a(int i2) {
        c a2 = a();
        a2.f67316c = a2.f67320g[i2];
        net.one97.paytm.upi.e.a aVar = this.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = aVar.p;
        kotlin.g.b.k.a((Object) textView, "binding.frequencyTextView");
        textView.setText(b()[i2]);
        net.one97.paytm.upi.e.a aVar2 = this.f67255b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        androidx.transition.v.a((ViewGroup) aVar2.a());
        a().f67319f = -1;
        net.one97.paytm.upi.e.a aVar3 = this.f67255b;
        if (aVar3 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView2 = aVar3.F;
        kotlin.g.b.k.a((Object) textView2, "binding.paymentDayValue");
        textView2.setText(getString(R.string.upi_mandate_payment_day));
        if (i2 == 1) {
            net.one97.paytm.upi.e.a aVar4 = this.f67255b;
            if (aVar4 == null) {
                kotlin.g.b.k.a("binding");
            }
            Group group = aVar4.j;
            kotlin.g.b.k.a((Object) group, "binding.dailyPaymentFrequencyHidingGroup");
            net.one97.paytm.upi.f.a((View) group);
        } else {
            net.one97.paytm.upi.e.a aVar5 = this.f67255b;
            if (aVar5 == null) {
                kotlin.g.b.k.a("binding");
            }
            Group group2 = aVar5.j;
            kotlin.g.b.k.a((Object) group2, "binding.dailyPaymentFrequencyHidingGroup");
            net.one97.paytm.upi.f.b((View) group2);
        }
        d();
    }

    public final void b(int i2) {
        c a2 = a();
        a2.f67317d = a2.f67321h[i2];
        net.one97.paytm.upi.e.a aVar = this.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = aVar.Q;
        kotlin.g.b.k.a((Object) textView, "binding.schedulePaymentType");
        textView.setText(c()[i2]);
    }

    public final void c(int i2) {
        a().f67319f = i2;
        net.one97.paytm.upi.e.a aVar = this.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = aVar.F;
        textView.setText(String.valueOf(i2));
        textView.setTextColor(net.one97.paytm.upi.f.c("#1d252d"));
        textView.setTypeface(Typeface.SANS_SERIF, 0);
        net.one97.paytm.upi.e.a aVar2 = this.f67255b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView2 = aVar2.D;
        kotlin.g.b.k.a((Object) textView2, "binding.paymentDayError");
        net.one97.paytm.upi.f.a((View) textView2);
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        kotlin.g.b.k.c(upiProfileDefaultBank, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        b(upiProfileDefaultBank);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.j && i3 == -1) {
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
            if (serializableExtra != null) {
                BankVpaCreationActivity.a((Activity) this, (AccountProviderBody.AccountProvider) serializableExtra, a().a().getVirtualAddress(), this.f67262i);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
        } else if (i2 == this.f67262i && i3 == -1) {
            a().b();
        }
    }

    public static final /* synthetic */ void c(CreateMandateActivity createMandateActivity) {
        createMandateActivity.a(false);
        List<UpiProfileDefaultBank> d2 = createMandateActivity.a().d();
        if (d2.isEmpty()) {
            net.one97.paytm.upi.e.a aVar = createMandateActivity.f67255b;
            if (aVar == null) {
                kotlin.g.b.k.a("binding");
            }
            RecyclerView recyclerView = aVar.x.f66924b;
            kotlin.g.b.k.a((Object) recyclerView, "noBankSupportedLayout.allBankList");
            recyclerView.setAdapter((RecyclerView.a) null);
            RecyclerView recyclerView2 = aVar.x.f66924b;
            kotlin.g.b.k.a((Object) recyclerView2, "noBankSupportedLayout.allBankList");
            UpiProfileModel upiProfileModel = createMandateActivity.a().j;
            if (upiProfileModel == null) {
                kotlin.g.b.k.a("profileResponse");
            }
            UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
            kotlin.g.b.k.a((Object) response, "profileResponse.response");
            UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
            kotlin.g.b.k.a((Object) profileDetail, "profileResponse.response.profileDetail");
            ArrayList<BankAccountDetails.BankAccount> bankAccountList = profileDetail.getBankAccountList();
            kotlin.g.b.k.a((Object) bankAccountList, "profileResponse.response…ileDetail.bankAccountList");
            recyclerView2.setAdapter(new net.one97.paytm.upi.mandate.a.a(bankAccountList));
            return;
        }
        createMandateActivity.b(d2.get(0));
    }

    public static final /* synthetic */ void a(CreateMandateActivity createMandateActivity, UpiCustomVolleyError upiCustomVolleyError) {
        String str;
        createMandateActivity.a(false);
        if (upiCustomVolleyError == null || (str = upiCustomVolleyError.getmErrorCode()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && kotlin.g.b.k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
            CustomDialog.showAlert(createMandateActivity, createMandateActivity.getResources().getString(R.string.no_connection), createMandateActivity.getResources().getString(R.string.no_internet));
        } else if (kotlin.m.p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str, true) || "410".equals(upiCustomVolleyError)) {
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getName();
            a2.b().e(createMandateActivity);
        } else {
            Toast.makeText(createMandateActivity, R.string.upi_some_went_wrong, 1).show();
        }
    }

    public static final /* synthetic */ void e(CreateMandateActivity createMandateActivity) {
        e.a aVar = e.f67326a;
        androidx.fragment.app.j supportFragmentManager = createMandateActivity.getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        int index = createMandateActivity.a().f67316c.getIndex();
        kotlin.g.b.k.c(supportFragmentManager, "fragmentManager");
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putInt("current selected index", index);
        eVar.setArguments(bundle);
        eVar.show(supportFragmentManager, "");
    }

    public static final /* synthetic */ void f(CreateMandateActivity createMandateActivity) {
        f.a aVar = f.f67333a;
        androidx.fragment.app.j supportFragmentManager = createMandateActivity.getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        int index = createMandateActivity.a().f67317d.getIndex();
        kotlin.g.b.k.c(supportFragmentManager, "fragmentManager");
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putInt("current selected index", index);
        fVar.setArguments(bundle);
        fVar.show(supportFragmentManager, "");
    }

    public static final /* synthetic */ void g(CreateMandateActivity createMandateActivity) {
        UpiAppUtils.hideKeyboard(createMandateActivity);
        net.one97.paytm.upi.mandate.utils.b bVar = new net.one97.paytm.upi.mandate.utils.b(createMandateActivity, new d(createMandateActivity), Calendar.getInstance().get(1), Calendar.getInstance().get(2), Calendar.getInstance().get(5), (byte) 0);
        DatePicker datePicker = bVar.getDatePicker();
        kotlin.g.b.k.a((Object) datePicker, "datePickerDialog.datePicker");
        datePicker.setMinDate(new Date().getTime());
        bVar.show();
    }

    public static final /* synthetic */ void h(CreateMandateActivity createMandateActivity) {
        long j2;
        if (kotlin.m.p.a(createMandateActivity.a().k)) {
            net.one97.paytm.upi.e.a aVar = createMandateActivity.f67255b;
            if (aVar == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView = aVar.T;
            kotlin.g.b.k.a((Object) textView, "binding.startDateError");
            net.one97.paytm.upi.f.b((View) textView);
            return;
        }
        UpiAppUtils.hideKeyboard(createMandateActivity);
        net.one97.paytm.upi.mandate.utils.b bVar = new net.one97.paytm.upi.mandate.utils.b(createMandateActivity, new c(createMandateActivity), Calendar.getInstance().get(1), Calendar.getInstance().get(2), Calendar.getInstance().get(5), (byte) 0);
        DatePicker datePicker = bVar.getDatePicker();
        kotlin.g.b.k.a((Object) datePicker, "datePickerDialog.datePicker");
        c a2 = createMandateActivity.a();
        switch (d.f67325b[a2.f67316c.ordinal()]) {
            case 1:
                Calendar c2 = a2.c();
                c2.add(2, 1);
                j2 = c2.getTimeInMillis();
                break;
            case 2:
                Calendar c3 = a2.c();
                c3.add(5, 1);
                j2 = c3.getTimeInMillis();
                break;
            case 3:
                Calendar c4 = a2.c();
                c4.add(5, 7);
                j2 = c4.getTimeInMillis();
                break;
            case 4:
                Calendar c5 = a2.c();
                c5.add(5, 15);
                j2 = c5.getTimeInMillis();
                break;
            case 5:
                Calendar c6 = a2.c();
                c6.add(2, 2);
                j2 = c6.getTimeInMillis();
                break;
            case 6:
                Calendar c7 = a2.c();
                c7.add(2, 3);
                j2 = c7.getTimeInMillis();
                break;
            case 7:
                Calendar c8 = a2.c();
                c8.add(2, 6);
                j2 = c8.getTimeInMillis();
                break;
            case 8:
                Calendar c9 = a2.c();
                c9.add(1, 1);
                j2 = c9.getTimeInMillis();
                break;
            default:
                throw new IllegalStateException();
        }
        datePicker.setMinDate(j2);
        bVar.show();
    }

    public static final /* synthetic */ void i(CreateMandateActivity createMandateActivity) {
        int i2 = a.f67280b[createMandateActivity.a().f67316c.ordinal()];
        if (i2 == 1) {
            f.a aVar = net.one97.paytm.upi.mandate.p2p.a.f.f67307a;
            androidx.fragment.app.j supportFragmentManager = createMandateActivity.getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            int i3 = createMandateActivity.a().f67319f;
            kotlin.g.b.k.c(supportFragmentManager, "fragmentManager");
            net.one97.paytm.upi.mandate.p2p.a.f fVar = new net.one97.paytm.upi.mandate.p2p.a.f();
            Bundle bundle = new Bundle();
            bundle.putInt("current selected index", i3);
            fVar.setArguments(bundle);
            fVar.show(supportFragmentManager, "");
        } else if (i2 != 2) {
            c.a aVar2 = net.one97.paytm.upi.mandate.p2p.a.c.f67293a;
            androidx.fragment.app.j supportFragmentManager2 = createMandateActivity.getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager2, "supportFragmentManager");
            int i4 = createMandateActivity.a().f67319f;
            kotlin.g.b.k.c(supportFragmentManager2, "fragmentManager");
            net.one97.paytm.upi.mandate.p2p.a.c cVar = new net.one97.paytm.upi.mandate.p2p.a.c();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("current selected index", i4);
            cVar.setArguments(bundle2);
            cVar.show(supportFragmentManager2, "");
        } else {
            b.a aVar3 = net.one97.paytm.upi.mandate.p2p.a.b.f67286a;
            androidx.fragment.app.j supportFragmentManager3 = createMandateActivity.getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager3, "supportFragmentManager");
            int i5 = createMandateActivity.a().f67319f;
            kotlin.g.b.k.c(supportFragmentManager3, "fragmentManager");
            net.one97.paytm.upi.mandate.p2p.a.b bVar = new net.one97.paytm.upi.mandate.p2p.a.b();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("current selected index", i5);
            bVar.setArguments(bundle3);
            bVar.show(supportFragmentManager3, "");
        }
    }

    public static final /* synthetic */ void k(CreateMandateActivity createMandateActivity) {
        BankAccountDetails.BankAccount bankAccount = createMandateActivity.a().f67315b;
        if (bankAccount != null) {
            b.a aVar = net.one97.paytm.upi.mandate.a.b.f67019c;
            String account = bankAccount.getAccount();
            kotlin.g.b.k.a((Object) account, "currentBank.account");
            b.a.a(account, createMandateActivity.a().f67318e == net.one97.paytm.upi.mandate.utils.n.RECURRING ? "SUBSCRIPTION" : "OTM").show(createMandateActivity.getSupportFragmentManager(), "");
        }
    }

    public static final /* synthetic */ void l(CreateMandateActivity createMandateActivity) {
        CreateMandateActivity createMandateActivity2 = createMandateActivity;
        net.one97.paytm.upi.e.a aVar = createMandateActivity2.f67255b;
        if (aVar == null) {
            kotlin.g.b.k.a("binding");
        }
        CustomAmountTextInputEditText customAmountTextInputEditText = aVar.f66716a;
        kotlin.g.b.k.a((Object) customAmountTextInputEditText, "amountEditText");
        CharSequence text = customAmountTextInputEditText.getText();
        if (text == null || kotlin.m.p.a(text)) {
            TextView textView = aVar.f66717b;
            kotlin.g.b.k.a((Object) textView, "amountError");
            net.one97.paytm.upi.f.b((View) textView);
        } else if (kotlin.m.p.a(createMandateActivity.a().k)) {
            TextView textView2 = aVar.T;
            kotlin.g.b.k.a((Object) textView2, "startDateError");
            net.one97.paytm.upi.f.b((View) textView2);
        } else if (kotlin.m.p.a(createMandateActivity.a().l)) {
            TextView textView3 = aVar.n;
            kotlin.g.b.k.a((Object) textView3, "endDateError");
            net.one97.paytm.upi.f.b((View) textView3);
        } else if (createMandateActivity.a().f67319f == -1 && createMandateActivity.a().f67318e == net.one97.paytm.upi.mandate.utils.n.RECURRING) {
            TextView textView4 = aVar.D;
            kotlin.g.b.k.a((Object) textView4, "paymentDayError");
            net.one97.paytm.upi.f.b((View) textView4);
        } else {
            MandateConfirmationDetailActivity.a aVar2 = MandateConfirmationDetailActivity.f67078a;
            c a2 = createMandateActivity.a();
            Context context = createMandateActivity2;
            net.one97.paytm.upi.e.a aVar3 = createMandateActivity2.f67255b;
            if (aVar3 == null) {
                kotlin.g.b.k.a("binding");
            }
            CustomAmountTextInputEditText customAmountTextInputEditText2 = aVar3.f66716a;
            kotlin.g.b.k.a((Object) customAmountTextInputEditText2, "binding.amountEditText");
            String cleanString = customAmountTextInputEditText2.getCleanString();
            kotlin.g.b.k.a((Object) cleanString, "binding.amountEditText.cleanString");
            String str = createMandateActivity2.l;
            if (str == null) {
                kotlin.g.b.k.a("payeeVpa");
            }
            String str2 = createMandateActivity2.k;
            if (str2 == null) {
                kotlin.g.b.k.a("payeeName");
            }
            kotlin.g.b.k.c(context, "context");
            kotlin.g.b.k.c(cleanString, "amount");
            kotlin.g.b.k.c(str, "payeeVpa");
            kotlin.g.b.k.c(str2, "payeeName");
            String str3 = a2.k;
            String str4 = a2.l;
            String str5 = a2.f67314a;
            String value = a2.f67318e == net.one97.paytm.upi.mandate.utils.n.RECURRING ? a2.f67316c.getValue() : null;
            String valueOf = a2.f67318e == net.one97.paytm.upi.mandate.utils.n.RECURRING ? String.valueOf(a2.f67319f) : null;
            String value2 = a2.f67318e == net.one97.paytm.upi.mandate.utils.n.RECURRING ? a2.f67317d.getValue() : null;
            BankAccountDetails.BankAccount bankAccount = a2.f67315b;
            if (bankAccount == null) {
                kotlin.g.b.k.a();
            }
            MandateConfirmationDetailActivity.a.a(new a.C1354a(context, new MandateConfirmationUiModel(str, str2, cleanString, str3, str4, "", "", str5, value, valueOf, value2, "", "", "", "", bankAccount.getAccRefId(), "", (ExtraIntentParams) null, 131072, (kotlin.g.b.g) null), false), net.one97.paytm.upi.mandate.utils.k.INTENT);
        }
    }
}
