package com.travel.citybus.best.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.paytm.utility.t;
import com.travel.citybus.R;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.best.ui.a.c;
import com.travel.citybus.best.ui.a.i;
import com.travel.citybus.brts.CJRActionBarBaseActivity;
import com.travel.citybus.brts.utils.d;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;

public final class CityBusTokenValidationActivity extends CJRActionBarBaseActivity implements c.a, i.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23134a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private com.travel.citybus.best.f.a f23135b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TextView> f23136c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f23137d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BestEPurse f23138e;

    /* renamed from: f  reason: collision with root package name */
    private String f23139f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23140g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f23141h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f23142i;

    public final View a(int i2) {
        if (this.f23142i == null) {
            this.f23142i = new HashMap();
        }
        View view = (View) this.f23142i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f23142i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class f<T> implements z<BestEPurseTokenResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23147a;

        f(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23147a = cityBusTokenValidationActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            BestEPurseTokenResponse bestEPurseTokenResponse = (BestEPurseTokenResponse) obj;
            CityBusTokenValidationActivity.a(this.f23147a, false);
            CityBusTokenValidationActivity cityBusTokenValidationActivity = this.f23147a;
            k.a((Object) bestEPurseTokenResponse, "it");
            CityBusTokenValidationActivity.a(cityBusTokenValidationActivity, bestEPurseTokenResponse);
        }
    }

    static final class g<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23148a;

        g(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23148a = cityBusTokenValidationActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            CityBusTokenValidationActivity.a(this.f23148a, false);
            if (num != null) {
                CityBusTokenValidationActivity cityBusTokenValidationActivity = this.f23148a;
                com.paytm.utility.b.a((Context) cityBusTokenValidationActivity, cityBusTokenValidationActivity.getString(R.string.some_went_wrong));
            }
        }
    }

    public static final /* synthetic */ com.travel.citybus.best.f.a d(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
        com.travel.citybus.best.f.a aVar = cityBusTokenValidationActivity.f23135b;
        if (aVar == null) {
            k.a("cityBusTokenValidationViewModel");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        BestToken token;
        BestToken token2;
        BestToken token3;
        BestToken token4;
        BestToken token5;
        BestToken token6;
        BestToken token7;
        BestToken token8;
        BestToken token9;
        BestToken token10;
        BestToken token11;
        BestToken token12;
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.activity_token_validation);
        hideKeyboard();
        d.a aVar = com.travel.citybus.brts.utils.d.f23400a;
        if (!d.a.a(this).b("token_validation_tt", false, false)) {
            i iVar = new i();
            iVar.show(getSupportFragmentManager(), iVar.getTag());
        }
        Intent intent = getIntent();
        Float f2 = null;
        if ((intent != null ? intent.getSerializableExtra("best_e_purse_data") : null) != null) {
            Intent intent2 = getIntent();
            if ((intent2 != null ? intent2.getSerializableExtra("best_e_purse_data") : null) instanceof BestEPurse) {
                Intent intent3 = getIntent();
                this.f23138e = (BestEPurse) (intent3 != null ? intent3.getSerializableExtra("best_e_purse_data") : null);
            }
        }
        Intent intent4 = getIntent();
        CharSequence stringExtra = intent4 != null ? intent4.getStringExtra("best_image_logo") : null;
        if (!(stringExtra == null || stringExtra.length() == 0)) {
            Intent intent5 = getIntent();
            this.f23139f = (intent5 == null || (extras = intent5.getExtras()) == null) ? null : extras.getString("best_image_logo");
        }
        Intent intent6 = getIntent();
        if (intent6 != null) {
            this.f23140g = intent6.getBooleanExtra("is_from_payment", false);
        }
        BestEPurse bestEPurse = this.f23138e;
        if (((bestEPurse == null || (token12 = bestEPurse.getToken()) == null) ? null : token12.getTokenIssuanceDatetime()) != null) {
            TextView textView = (TextView) a(R.id.cityOtpScreenSubTitleTextView);
            k.a((Object) textView, "cityOtpScreenSubTitleTextView");
            com.travel.citybus.best.e.c cVar = com.travel.citybus.best.e.c.f23051a;
            BestEPurse bestEPurse2 = this.f23138e;
            Long tokenIssuanceDatetime = (bestEPurse2 == null || (token11 = bestEPurse2.getToken()) == null) ? null : token11.getTokenIssuanceDatetime();
            if (tokenIssuanceDatetime == null) {
                k.a();
            }
            textView.setText(com.travel.citybus.best.e.c.a("EEE, dd MMM", tokenIssuanceDatetime.longValue()));
        }
        BestEPurse bestEPurse3 = this.f23138e;
        CharSequence sourceName = (bestEPurse3 == null || (token10 = bestEPurse3.getToken()) == null) ? null : token10.getSourceName();
        if (!(sourceName == null || sourceName.length() == 0)) {
            TextView textView2 = (TextView) a(R.id.cityOtpScreenSourceTextView);
            k.a((Object) textView2, "cityOtpScreenSourceTextView");
            BestEPurse bestEPurse4 = this.f23138e;
            textView2.setText((bestEPurse4 == null || (token9 = bestEPurse4.getToken()) == null) ? null : token9.getSourceName());
        }
        BestEPurse bestEPurse5 = this.f23138e;
        CharSequence destinationName = (bestEPurse5 == null || (token8 = bestEPurse5.getToken()) == null) ? null : token8.getDestinationName();
        if (!(destinationName == null || destinationName.length() == 0)) {
            TextView textView3 = (TextView) a(R.id.cityOtpScreenDestinationTextView);
            k.a((Object) textView3, "cityOtpScreenDestinationTextView");
            BestEPurse bestEPurse6 = this.f23138e;
            textView3.setText((bestEPurse6 == null || (token7 = bestEPurse6.getToken()) == null) ? null : token7.getDestinationName());
        }
        BestEPurse bestEPurse7 = this.f23138e;
        if (((bestEPurse7 == null || (token6 = bestEPurse7.getToken()) == null) ? null : token6.getRouteName()) != null) {
            TextView textView4 = (TextView) a(R.id.cityOtpScreenBusServiceIdTextView);
            k.a((Object) textView4, "cityOtpScreenBusServiceIdTextView");
            BestEPurse bestEPurse8 = this.f23138e;
            textView4.setText((bestEPurse8 == null || (token5 = bestEPurse8.getToken()) == null) ? null : token5.getRouteName());
        }
        BestEPurse bestEPurse9 = this.f23138e;
        Integer passengerCount = (bestEPurse9 == null || (token4 = bestEPurse9.getToken()) == null) ? null : token4.getPassengerCount();
        if (passengerCount == null || passengerCount.intValue() != 0) {
            BestEPurse bestEPurse10 = this.f23138e;
            Integer passengerCount2 = (bestEPurse10 == null || (token3 = bestEPurse10.getToken()) == null) ? null : token3.getPassengerCount();
            TextView textView5 = (TextView) a(R.id.cityOtpScreenTicketNumberTextView);
            k.a((Object) textView5, "cityOtpScreenTicketNumberTextView");
            if (passengerCount2 == null) {
                k.a();
            }
            textView5.setText(com.travel.citybus.best.a.a(passengerCount2.intValue()));
        }
        BestEPurse bestEPurse11 = this.f23138e;
        if (!k.a((bestEPurse11 == null || (token2 = bestEPurse11.getToken()) == null) ? null : token2.getAmount())) {
            TextView textView6 = (TextView) a(R.id.cityOtpScreenPriceTextView);
            k.a((Object) textView6, "cityOtpScreenPriceTextView");
            StringBuilder sb = new StringBuilder("₹ ");
            BestEPurse bestEPurse12 = this.f23138e;
            if (!(bestEPurse12 == null || (token = bestEPurse12.getToken()) == null)) {
                f2 = token.getAmount();
            }
            if (f2 == null) {
                k.a();
            }
            sb.append(com.travel.citybus.best.e.b.a(f2.floatValue()));
            textView6.setText(sb.toString());
        }
        t.a(false);
        t.b(this.f23139f, (AppCompatImageView) a(R.id.cityOtpScreenBusImageView));
        ai a2 = am.a((FragmentActivity) this).a(com.travel.citybus.best.f.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ionViewModel::class.java)");
        this.f23135b = (com.travel.citybus.best.f.a) a2;
        this.f23136c.add((TextView) a(R.id.cityOtpScreenBoxOneTextView));
        this.f23136c.add((TextView) a(R.id.cityOtpScreenBoxTwoTextView));
        this.f23136c.add((TextView) a(R.id.cityOtpScreenBoxThreeTextView));
        this.f23136c.add((TextView) a(R.id.cityOtpScreenBoxFourTextView));
        this.f23136c.add((TextView) a(R.id.cityOtpScreenBoxFiveTextView));
        this.f23136c.add((TextView) a(R.id.cityOtpScreenBoxSixTextView));
        EditText editText = (EditText) a(R.id.cityOtpScreenBoxEditText);
        k.a((Object) editText, "cityOtpScreenBoxEditText");
        com.travel.citybus.best.e.c cVar2 = com.travel.citybus.best.e.c.f23051a;
        editText.setFilters(new InputFilter[]{com.travel.citybus.best.e.c.a(), new InputFilter.LengthFilter(this.f23136c.size())});
        EditText editText2 = (EditText) a(R.id.cityOtpScreenBoxEditText);
        if (editText2 != null) {
            editText2.addTextChangedListener(new h(this));
        }
        a(this.f23137d);
        ((TextView) a(R.id.cityOtpScreenGenerateTicketTextView)).setOnClickListener(new b(this));
        ((AppCompatImageView) a(R.id.cityOtpScreenBackImageView)).setOnClickListener(new c(this));
        ((TextView) a(R.id.cityOtpScreenCancelTicketTextView)).setOnClickListener(new d(this));
        ((EditText) a(R.id.cityOtpScreenBoxEditText)).setOnClickListener(new e(this));
        com.travel.citybus.best.f.a aVar2 = this.f23135b;
        if (aVar2 == null) {
            k.a("cityBusTokenValidationViewModel");
        }
        q qVar = this;
        aVar2.f23055a.observe(qVar, new f(this));
        com.travel.citybus.best.f.a aVar3 = this.f23135b;
        if (aVar3 == null) {
            k.a("cityBusTokenValidationViewModel");
        }
        aVar3.f23056b.observe(qVar, new g(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23143a;

        b(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23143a = cityBusTokenValidationActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
            r6 = r6.getToken();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                android.content.Context r6 = (android.content.Context) r6
                boolean r6 = com.paytm.utility.b.c((android.content.Context) r6)
                if (r6 == 0) goto L_0x00cf
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                java.lang.String r6 = r6.f23137d
                int r6 = r6.length()
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r0 = r5.f23143a
                java.util.ArrayList r0 = r0.f23136c
                int r0 = r0.size()
                java.lang.String r1 = "cityBusOtpScreenEnterValidTv"
                r2 = 0
                if (r6 != r0) goto L_0x00be
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                int r0 = com.travel.citybus.R.id.cityBusOtpScreenEnterValidTv
                android.view.View r6 = r6.a((int) r0)
                android.widget.TextView r6 = (android.widget.TextView) r6
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                r0 = 8
                r6.setVisibility(r0)
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                com.travel.citybus.best.model.BestEPurse r6 = r6.f23138e
                r0 = 0
                if (r6 == 0) goto L_0x0049
                com.travel.citybus.best.model.BestToken r6 = r6.getToken()
                if (r6 == 0) goto L_0x0049
                java.lang.String r6 = r6.getTokenId()
                goto L_0x004a
            L_0x0049:
                r6 = r0
            L_0x004a:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r1 = 1
                if (r6 == 0) goto L_0x0058
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0056
                goto L_0x0058
            L_0x0056:
                r6 = 0
                goto L_0x0059
            L_0x0058:
                r6 = 1
            L_0x0059:
                if (r6 != 0) goto L_0x00b8
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                com.travel.citybus.best.model.BestEPurse r6 = r6.f23138e
                if (r6 == 0) goto L_0x0068
                java.lang.String r6 = r6.getUserId()
                goto L_0x0069
            L_0x0068:
                r6 = r0
            L_0x0069:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x0073
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0074
            L_0x0073:
                r2 = 1
            L_0x0074:
                if (r2 != 0) goto L_0x00b8
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                com.travel.citybus.best.f.a r6 = com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity.d(r6)
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r2 = r5.f23143a
                r3 = r2
                android.content.Context r3 = (android.content.Context) r3
                com.travel.citybus.best.model.BestEPurse r2 = r2.f23138e
                if (r2 == 0) goto L_0x0091
                com.travel.citybus.best.model.BestToken r2 = r2.getToken()
                if (r2 == 0) goto L_0x0091
                java.lang.String r0 = r2.getTokenId()
            L_0x0091:
                if (r0 != 0) goto L_0x0096
                kotlin.g.b.k.a()
            L_0x0096:
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r2 = r5.f23143a
                java.lang.String r2 = r2.f23137d
                java.lang.String r4 = "context"
                kotlin.g.b.k.c(r3, r4)
                java.lang.String r4 = "tokenId"
                kotlin.g.b.k.c(r0, r4)
                java.lang.String r4 = "otp"
                kotlin.g.b.k.c(r2, r4)
                com.travel.citybus.best.d.a r4 = com.travel.citybus.best.d.a.f23050a
                com.travel.citybus.best.f.a$a r4 = new com.travel.citybus.best.f.a$a
                r4.<init>(r6)
                com.paytm.network.listener.b r4 = (com.paytm.network.listener.b) r4
                com.travel.citybus.best.d.a.a((android.content.Context) r3, (java.lang.String) r0, (java.lang.String) r2, (com.paytm.network.listener.b) r4)
            L_0x00b8:
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity.a((com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity) r6, (boolean) r1)
                return
            L_0x00be:
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                int r0 = com.travel.citybus.R.id.cityBusOtpScreenEnterValidTv
                android.view.View r6 = r6.a((int) r0)
                android.widget.TextView r6 = (android.widget.TextView) r6
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                r6.setVisibility(r2)
                return
            L_0x00cf:
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r6 = r5.f23143a
                r0 = r6
                android.content.Context r0 = (android.content.Context) r0
                int r1 = com.travel.citybus.R.string.no_internet_title
                java.lang.String r6 = r6.getString(r1)
                com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r1 = r5.f23143a
                int r2 = com.travel.citybus.R.string.no_internet_message
                java.lang.String r1 = r1.getString(r2)
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r6, (java.lang.String) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity.b.onClick(android.view.View):void");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23144a;

        c(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23144a = cityBusTokenValidationActivity;
        }

        public final void onClick(View view) {
            this.f23144a.onBackPressed();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23145a;

        d(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23145a = cityBusTokenValidationActivity;
        }

        public final void onClick(View view) {
            CityBusTokenValidationActivity.e(this.f23145a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23146a;

        e(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23146a = cityBusTokenValidationActivity;
        }

        public final void onClick(View view) {
            if (this.f23146a.f23141h < this.f23146a.f23136c.size()) {
                CityBusTokenValidationActivity cityBusTokenValidationActivity = this.f23146a;
                CityBusTokenValidationActivity.b(cityBusTokenValidationActivity, cityBusTokenValidationActivity.f23141h);
            }
        }
    }

    public static final class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CityBusTokenValidationActivity f23149a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        h(CityBusTokenValidationActivity cityBusTokenValidationActivity) {
            this.f23149a = cityBusTokenValidationActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null) {
                this.f23149a.f23141h = charSequence.length() - 1;
                this.f23149a.f23137d = charSequence.length() == this.f23149a.f23136c.size() ? charSequence.toString() : "";
                this.f23149a.a(charSequence.toString());
                CityBusTokenValidationActivity cityBusTokenValidationActivity = this.f23149a;
                CityBusTokenValidationActivity.b(cityBusTokenValidationActivity, cityBusTokenValidationActivity.f23141h);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        int size = this.f23136c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < str.length()) {
                TextView textView = this.f23136c.get(i2);
                k.a((Object) textView, "otpTextViewArray[i]");
                textView.setText(String.valueOf(str.charAt(i2)));
            } else {
                TextView textView2 = this.f23136c.get(i2);
                k.a((Object) textView2, "otpTextViewArray[i]");
                textView2.setText("");
            }
        }
    }

    public final void a() {
        BestEPurse bestEPurse = this.f23138e;
        if (bestEPurse != null) {
            bestEPurse.setToken((BestToken) null);
        }
    }

    public final void b() {
        BestEPurse bestEPurse = this.f23138e;
        if ((bestEPurse != null ? bestEPurse.getToken() : null) == null) {
            finish();
        }
    }

    public final void c() {
        d.a aVar = com.travel.citybus.brts.utils.d.f23400a;
        d.a.a(this).a("token_validation_tt", true, false);
    }

    public static final /* synthetic */ void a(CityBusTokenValidationActivity cityBusTokenValidationActivity, boolean z) {
        FrameLayout frameLayout = (FrameLayout) cityBusTokenValidationActivity.a(R.id.cityBusOtpScreenProgressFrameLayout);
        k.a((Object) frameLayout, "cityBusOtpScreenProgressFrameLayout");
        frameLayout.setVisibility(z ? 0 : 8);
        TextView textView = (TextView) cityBusTokenValidationActivity.a(R.id.cityOtpScreenGenerateTicketTextView);
        k.a((Object) textView, "cityOtpScreenGenerateTicketTextView");
        textView.setText(!z ? "Generate Ticket" : "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0062, code lost:
        if (kotlin.m.p.a(r0.getStatus(), "REFUND", true) != false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r5, com.travel.citybus.best.model.BestEPurseTokenResponse r6) {
        /*
            java.lang.String r0 = r6.getStatus()
            r1 = 1
            java.lang.String r2 = "SUCCESS"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r6.getStatus()
            java.lang.String r2 = "FAILURE"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x0088
        L_0x0019:
            com.travel.citybus.best.model.BestEPurse r0 = r6.getResponse()
            if (r0 == 0) goto L_0x0088
            com.travel.citybus.best.model.BestEPurse r0 = r6.getResponse()
            java.lang.String r2 = "it.response"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.travel.citybus.best.model.BestToken r0 = r0.getToken()
            if (r0 == 0) goto L_0x0088
            com.travel.citybus.best.model.BestEPurse r0 = r6.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.travel.citybus.best.model.BestToken r0 = r0.getToken()
            java.lang.String r3 = "it.response.token"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.getStatus()
            java.lang.String r4 = "USED"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
            if (r0 != 0) goto L_0x0064
            com.travel.citybus.best.model.BestEPurse r0 = r6.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.travel.citybus.best.model.BestToken r0 = r0.getToken()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.getStatus()
            java.lang.String r2 = "REFUND"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x0088
        L_0x0064:
            android.content.Intent r0 = new android.content.Intent
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity> r2 = com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity.class
            r0.<init>(r1, r2)
            com.travel.citybus.best.model.BestEPurse r6 = r6.getResponse()
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r1 = "validation_success"
            r0.putExtra(r1, r6)
            java.lang.String r6 = r5.f23139f
            java.lang.String r1 = "best_image_logo"
            r0.putExtra(r1, r6)
            r5.startActivity(r0)
            r5.finish()
            return
        L_0x0088:
            int r6 = com.travel.citybus.R.id.cityBusOtpScreenEnterValidTv
            android.view.View r5 = r5.a((int) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r6 = "cityBusOtpScreenEnterValidTv"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = 0
            r5.setVisibility(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity.a(com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity, com.travel.citybus.best.model.BestEPurseTokenResponse):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = r1.getToken();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void e(com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity r5) {
        /*
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r1 == 0) goto L_0x005d
            com.travel.citybus.best.model.BestEPurse r1 = r5.f23138e
            if (r1 == 0) goto L_0x0018
            com.travel.citybus.best.model.BestToken r1 = r1.getToken()
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r1.getTokenId()
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            if (r1 == 0) goto L_0x0027
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r1 = 0
            goto L_0x0028
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 != 0) goto L_0x0053
            com.travel.citybus.best.ui.a.c r0 = new com.travel.citybus.best.ui.a.c
            r0.<init>()
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.travel.citybus.best.model.BestEPurse r3 = r5.f23138e
            java.io.Serializable r3 = (java.io.Serializable) r3
            java.lang.String r4 = "extra_e_purse"
            r1.putSerializable(r4, r3)
            java.lang.String r3 = "from_validation_screen"
            r1.putBoolean(r3, r2)
            r0.setArguments(r1)
            androidx.fragment.app.j r5 = r5.getSupportFragmentManager()
            java.lang.Class<com.travel.citybus.best.ui.a.c> r1 = com.travel.citybus.best.ui.a.c.class
            java.lang.String r1 = r1.getSimpleName()
            r0.show((androidx.fragment.app.j) r5, (java.lang.String) r1)
            return
        L_0x0053:
            int r1 = com.travel.citybus.R.string.no_active_token
            java.lang.String r5 = r5.getString(r1)
            com.paytm.utility.b.a((android.content.Context) r0, (java.lang.String) r5)
            return
        L_0x005d:
            int r1 = com.travel.citybus.R.string.no_internet
            java.lang.String r5 = r5.getString(r1)
            com.paytm.utility.b.a((android.content.Context) r0, (java.lang.String) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity.e(com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity):void");
    }

    public static final /* synthetic */ void b(CityBusTokenValidationActivity cityBusTokenValidationActivity, int i2) {
        int size = cityBusTokenValidationActivity.f23136c.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == i2) {
                cityBusTokenValidationActivity.f23136c.get(i3).setBackgroundResource(R.drawable.best_bg_otp_text_view_active);
            } else {
                cityBusTokenValidationActivity.f23136c.get(i3).setBackgroundResource(R.drawable.best_bg_otp_text_view_inactive);
            }
        }
        if (i2 >= cityBusTokenValidationActivity.f23136c.size()) {
            ArrayList<TextView> arrayList = cityBusTokenValidationActivity.f23136c;
            arrayList.get(arrayList.size() - 1).setBackgroundResource(R.drawable.best_bg_otp_text_view_active);
        }
    }
}
