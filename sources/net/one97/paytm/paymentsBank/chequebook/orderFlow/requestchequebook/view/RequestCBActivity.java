package net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.h;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.CBorderSummaryActivity;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivity;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivityV2;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.f;
import net.one97.paytm.paymentsBank.chequebook.utils.CbCataloguePayLoad;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCAddNewAddress;

public final class RequestCBActivity extends ChequeBookBaseActivity implements c.b, f {

    /* renamed from: a  reason: collision with root package name */
    String f17694a = "";

    /* renamed from: b  reason: collision with root package name */
    public c.a f17695b;

    /* renamed from: c  reason: collision with root package name */
    final int f17696c = 36;

    /* renamed from: d  reason: collision with root package name */
    String f17697d = "";

    /* renamed from: e  reason: collision with root package name */
    boolean f17698e = true;

    /* renamed from: f  reason: collision with root package name */
    ChequeBookNames f17699f;

    /* renamed from: g  reason: collision with root package name */
    boolean f17700g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f17701h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<PBTncData> f17702i = new ArrayList<>();
    private Boolean j = Boolean.FALSE;
    private boolean k;
    private String l = "";
    private final String m = "RequestCBActivity";
    private int n;
    private a o;
    private TextView p;
    private TextView q;
    private TextView r;
    private RelativeLayout s;
    /* access modifiers changed from: private */
    public int t = 10;
    private net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b u;
    private String v = "";
    private HashMap w;

    public final View a(int i2) {
        if (this.w == null) {
            this.w = new HashMap();
        }
        View view = (View) this.w.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.w.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCBActivity f17708a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f17709b;

        e(RequestCBActivity requestCBActivity, h hVar) {
            this.f17708a = requestCBActivity;
            this.f17709b = hVar;
        }

        public final void onClick(View view) {
            this.f17709b.cancel();
            this.f17708a.finish();
        }
    }

    public final void b(String str, String str2) {
        k.c(str, "profileName");
        k.c(str2, "add");
        if (TextUtils.isEmpty(str)) {
            str = com.paytm.utility.b.C((Context) this);
            k.a((Object) str, "CJRAppCommonUtility.getFullName(this)");
        }
        String l2 = com.paytm.utility.b.l((Context) this);
        CharSequence charSequence = str;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_name);
            k.a((Object) roboTextView, "tv_name");
            roboTextView.setVisibility(8);
        } else {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_name);
            k.a((Object) roboTextView2, "tv_name");
            roboTextView2.setText(charSequence);
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_name);
            k.a((Object) roboTextView3, "tv_name");
            roboTextView3.setVisibility(0);
        }
        CharSequence charSequence2 = l2;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            z = false;
        }
        if (z) {
            TextView textView = (TextView) a(R.id.tv_contact);
            k.a((Object) textView, "tv_contact");
            textView.setVisibility(8);
        } else {
            TextView textView2 = (TextView) a(R.id.tv_contact);
            k.a((Object) textView2, "tv_contact");
            textView2.setText(charSequence2);
            TextView textView3 = (TextView) a(R.id.tv_contact);
            k.a((Object) textView3, "tv_contact");
            textView3.setVisibility(0);
        }
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.tv_address);
        k.a((Object) roboTextView4, "tv_address");
        roboTextView4.setText(str2);
        this.f17697d = str;
        if (this.f17698e && this.f17697d.length() >= this.f17696c) {
            d();
        }
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        k.c(arrayList, "tncList");
        this.f17702i = arrayList;
    }

    public final void c(String str) {
        k.c(str, "<set-?>");
        this.f17694a = str;
    }

    public final int a() {
        return R.layout.pb_activity_request_cb;
    }

    public final c.a c() {
        c.a aVar = this.f17695b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n++;
        this.k = false;
        View findViewById = findViewById(R.id.tv_cb_add_delivery_address);
        if (findViewById != null) {
            this.p = (TextView) findViewById;
            View findViewById2 = findViewById(R.id.rl_delivery_addressess);
            if (findViewById2 != null) {
                this.s = (RelativeLayout) findViewById2;
                View findViewById3 = findViewById(R.id.tv_add_new_address);
                if (findViewById3 != null) {
                    this.r = (TextView) findViewById3;
                    View findViewById4 = findViewById(R.id.tv_error);
                    if (findViewById4 != null) {
                        this.q = (TextView) findViewById4;
                        View a2 = a(R.id.pb_cb_leaves_toolbar);
                        k.a((Object) a2, "pb_cb_leaves_toolbar");
                        a2.setVisibility(0);
                        ((TextView) a(R.id.tv_add_new_address)).setOnClickListener(new b(this));
                        ((TextView) a(R.id.tv_cb_add_delivery_address)).setOnClickListener(new c(this));
                        ((Button) a(R.id.btn_proceed_to_pay)).setOnClickListener(new d(this));
                        net.one97.paytm.paymentsBank.chequebook.utils.d dVar = net.one97.paytm.paymentsBank.chequebook.utils.d.f17950a;
                        Context applicationContext = getApplicationContext();
                        k.a((Object) applicationContext, "applicationContext");
                        c.a aVar = new net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.b.a(net.one97.paytm.paymentsBank.chequebook.utils.d.a(applicationContext), this, this);
                        k.c(aVar, "<set-?>");
                        this.f17695b = aVar;
                        this.o = new a(c(), this);
                        c().d();
                        a aVar2 = this.o;
                        if (aVar2 == null) {
                            k.a("adapter");
                        }
                        aVar2.notifyDataSetChanged();
                        c().c();
                        b.a aVar3 = net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b.f17828f;
                        Integer num = 0;
                        String string = getString(R.string.label_name_to_be_print_on_cheque_book);
                        k.a((Object) string, "getString(R.string.label…_be_print_on_cheque_book)");
                        k.c(string, "title");
                        net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b bVar = new net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b();
                        Bundle bundle2 = new Bundle();
                        if (num == null) {
                            k.a();
                        }
                        bundle2.putInt("amount", num.intValue());
                        bundle2.putString("title", string);
                        bVar.setArguments(bundle2);
                        this.u = bVar;
                        net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b bVar2 = this.u;
                        if (bVar2 == null) {
                            k.a();
                        }
                        f fVar = this;
                        k.c(fVar, "parentListener");
                        bVar2.f17829a = fVar;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: private */
    public final void e() {
        net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b bVar = this.u;
        if (bVar == null) {
            k.a();
        }
        ChequeBookNames chequeBookNames = this.f17699f;
        if (chequeBookNames == null) {
            k.a();
        }
        Button button = (Button) a(R.id.btn_proceed_to_pay);
        k.a((Object) button, "btn_proceed_to_pay");
        CharSequence text = button.getText();
        k.a((Object) text, "btn_proceed_to_pay.text");
        k.c(chequeBookNames, "chequeBookNames");
        k.c(text, "buttonText");
        bVar.f17830b = chequeBookNames;
        bVar.f17831c = text;
        net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b bVar2 = this.u;
        if (bVar2 == null) {
            k.a();
        }
        bVar2.show(getSupportFragmentManager(), "add_photo_dialog_fragment");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCBActivity f17705a;

        b(RequestCBActivity requestCBActivity) {
            this.f17705a = requestCBActivity;
        }

        public final void onClick(View view) {
            RequestCBActivity.a(this.f17705a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCBActivity f17706a;

        c(RequestCBActivity requestCBActivity) {
            this.f17706a = requestCBActivity;
        }

        public final void onClick(View view) {
            RequestCBActivity.a(this.f17706a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCBActivity f17707a;

        d(RequestCBActivity requestCBActivity) {
            this.f17707a = requestCBActivity;
        }

        public final void onClick(View view) {
            this.f17707a.f17701h = true;
            if (this.f17707a.f17698e) {
                Boolean c2 = RequestCBActivity.c(this.f17707a);
                if (c2 == null) {
                    k.a();
                }
                if (!c2.booleanValue()) {
                    this.f17707a.c().e();
                } else if (this.f17707a.f17700g) {
                    this.f17707a.e();
                } else if (this.f17707a.f17697d.length() >= this.f17707a.f17696c && this.f17707a.f17699f == null) {
                    this.f17707a.a(true);
                    this.f17707a.d();
                }
            }
        }
    }

    public final void a(List<CbCataloguePayLoad> list) {
        k.c(list, "cbCataloguePayLoad");
        c.a c2 = c();
        if (c2 != null) {
            c2.a(list.get(0));
        }
        TextView textView = (TextView) a(R.id.tv_ten_leaves_amount);
        k.a((Object) textView, "tv_ten_leaves_amount");
        textView.setText(getString(R.string.rs) + String.valueOf(list.get(0).getAmount()));
        TextView textView2 = (TextView) a(R.id.tv_ten_leaves_amount);
        k.a((Object) textView2, "tv_ten_leaves_amount");
        ((TextView) a(R.id.tv_ten_leaves_amount)).setTypeface(textView2.getTypeface(), 1);
        TextView textView3 = (TextView) a(R.id.tv_25_leaves_amount);
        k.a((Object) textView3, "tv_25_leaves_amount");
        ((TextView) a(R.id.tv_25_leaves_amount)).setTypeface(textView3.getTypeface(), 0);
        if (list.size() == 1) {
            RadioButton radioButton = (RadioButton) a(R.id.rb_25_leaves_cb);
            k.a((Object) radioButton, "rb_25_leaves_cb");
            radioButton.setEnabled(false);
            RadioButton radioButton2 = (RadioButton) a(R.id.rb_25_leaves_cb);
            k.a((Object) radioButton2, "rb_25_leaves_cb");
            radioButton2.setVisibility(8);
            TextView textView4 = (TextView) a(R.id.tv_25_leaves_amount);
            k.a((Object) textView4, "tv_25_leaves_amount");
            textView4.setVisibility(8);
        } else {
            TextView textView5 = (TextView) a(R.id.tv_25_leaves_amount);
            k.a((Object) textView5, "tv_25_leaves_amount");
            textView5.setText(getString(R.string.rs) + String.valueOf(list.get(1).getAmount()));
        }
        this.t = 10;
        this.f17694a = String.valueOf(list.get(0).getAmount());
        c.a c3 = c();
        if ((c3 != null ? Boolean.valueOf(c3.i()) : null).booleanValue()) {
            Button button = (Button) a(R.id.btn_proceed_to_pay);
            k.a((Object) button, "btn_proceed_to_pay");
            button.setText(getString(R.string.pdc_proceed_to_pay_rupee, new Object[]{this.f17694a}));
        }
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_leaves_cb);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new a(this, list));
        }
    }

    static final class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RequestCBActivity f17703a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f17704b;

        a(RequestCBActivity requestCBActivity, List list) {
            this.f17703a = requestCBActivity;
            this.f17704b = list;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            Boolean bool = null;
            if (R.id.rb_ten_leaves_cb == i2) {
                this.f17703a.t = 10;
                TextView textView = (TextView) this.f17703a.a(R.id.tv_ten_leaves_amount);
                k.a((Object) textView, "tv_ten_leaves_amount");
                ((TextView) this.f17703a.a(R.id.tv_ten_leaves_amount)).setTypeface(textView.getTypeface(), 1);
                ((TextView) this.f17703a.a(R.id.tv_25_leaves_amount)).setTypeface((Typeface) null, 0);
                this.f17703a.c(String.valueOf(((CbCataloguePayLoad) this.f17704b.get(0)).getAmount()));
                this.f17703a.c().a((CbCataloguePayLoad) this.f17704b.get(0));
            } else if (R.id.rb_25_leaves_cb == i2) {
                this.f17703a.t = 25;
                ((TextView) this.f17703a.a(R.id.tv_ten_leaves_amount)).setTypeface((Typeface) null, 0);
                TextView textView2 = (TextView) this.f17703a.a(R.id.tv_25_leaves_amount);
                k.a((Object) textView2, "tv_25_leaves_amount");
                ((TextView) this.f17703a.a(R.id.tv_25_leaves_amount)).setTypeface(textView2.getTypeface(), 1);
                this.f17703a.c(String.valueOf(((CbCataloguePayLoad) this.f17704b.get(1)).getAmount()));
                this.f17703a.c().a((CbCataloguePayLoad) this.f17704b.get(1));
            }
            c.a c2 = this.f17703a.c();
            if (c2 != null) {
                bool = Boolean.valueOf(c2.i());
            }
            if (bool.booleanValue()) {
                Button button = (Button) this.f17703a.a(R.id.btn_proceed_to_pay);
                k.a((Object) button, "btn_proceed_to_pay");
                button.setText(this.f17703a.getString(R.string.pdc_proceed_to_pay_rupee, new Object[]{this.f17703a.f17694a}));
            }
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        com.paytm.utility.b.b((Context) this, getString(R.string.error), str2);
    }

    public final void a(boolean z) {
        if (z) {
            String string = getString(R.string.please_wait);
            k.a((Object) string, "getString(R.string.please_wait)");
            a(this, string);
            return;
        }
        h();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121) {
            if (i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                String stringExtra = intent.getStringExtra("passcode");
                c.a c2 = c();
                k.a((Object) stringExtra, "txnToken");
                String str = this.v;
                if (str == null) {
                    k.a();
                }
                c2.a(stringExtra, str);
            }
        } else if (i2 != 104) {
            net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
            if (i2 == net.one97.paytm.paymentsBank.chequebook.utils.e.R() && i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
                String stringExtra2 = intent.getStringExtra("passcode");
                SignatureLandingActivity.a aVar = SignatureLandingActivity.f17776f;
                Context context = this;
                if (stringExtra2 == null) {
                    k.a();
                }
                k.c(context, "context");
                k.c(stringExtra2, "bankToken");
                Intent intent2 = new Intent(context, SignatureLandingActivity.class);
                intent2.putExtra("EXTRA_IS_SIGN_UPDATE_LOW", true);
                intent2.putExtra("passcode_extra", stringExtra2);
                startActivity(intent2);
            }
        } else if (i3 == -1) {
            finish();
        }
    }

    public final void b(String str) {
        k.c(str, StringSet.token);
        TextView textView = this.q;
        if (textView == null) {
            k.a("mTvErrorMessage");
        }
        textView.setVisibility(8);
        Intent intent = new Intent(this, SignatureLandingActivityV2.class);
        c.a c2 = c();
        intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", c2 != null ? c2.j() : null);
        intent.putExtra("is_first_time_user", true);
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        intent.putExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.c(), true);
        intent.putExtra(SDKConstants.AI_TRANSACTION_AMOUNT, this.f17694a);
        intent.putExtra("leaves_extra", this.t);
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        intent.putExtra(net.one97.paytm.paymentsBank.chequebook.utils.e.v(), this.v);
        startActivityForResult(intent, 104);
    }

    public final void b() {
        BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
        String string = getString(R.string.pb_cb_enter_pscd_to_pay_cb, new Object[]{this.f17694a});
        k.a((Object) string, "getString(R.string.pb_cb…pscd_to_pay_cb, cbAmount)");
        String string2 = getString(R.string.pb_cb_issuance_charge_for_leaves, new Object[]{String.valueOf(this.t)});
        k.a((Object) string2, "getString(R.string.pb_cb…ves, cbLeaves.toString())");
        BankPasscodeActivity.a.a((Activity) this, string, string2, 121);
    }

    public final void onResume() {
        this.n++;
        super.onResume();
    }

    public final void onStart() {
        this.n++;
        if (this.k) {
            c().g();
        }
        super.onStart();
    }

    public final void d() {
        c().h();
    }

    public final void a(ChequeBookNames chequeBookNames) {
        k.c(chequeBookNames, "chequeBookNames");
        a(false);
        this.f17699f = chequeBookNames;
        this.f17700g = true;
        if (this.f17701h) {
            this.f17701h = false;
            e();
        }
    }

    public final void d(String str, String str2) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        k.c(str2, "errorTitle");
        a(false);
        this.f17700g = false;
        if (this.f17701h) {
            this.f17701h = false;
            a(str2, str);
        }
    }

    public final void d(String str) {
        System.out.println("Suggested Name: ".concat(String.valueOf(str)));
        this.v = str;
        net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.a.b bVar = this.u;
        if (bVar == null) {
            k.a();
        }
        bVar.dismiss();
        c().e();
    }

    public final void a(String str) {
        k.c(str, "orderId");
        if (TextUtils.isEmpty(str)) {
            com.paytm.utility.b.b((Context) this, "Error!", getString(R.string.cb_generic_error));
            return;
        }
        Intent intent = new Intent(this, CBorderSummaryActivity.class);
        intent.putExtra("order_id", str);
        intent.putExtra("cheque_book_amount", this.f17694a);
        startActivity(intent);
        finish();
    }

    public final void c(String str, String str2) {
        k.c(str, "title");
        k.c(str2, "msg");
        if (!isFinishing()) {
            h hVar = new h(this);
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(false);
            hVar.a(-3, getString(R.string.ok), new e(this, hVar));
            hVar.show();
        }
    }

    public static final /* synthetic */ void a(RequestCBActivity requestCBActivity) {
        requestCBActivity.k = true;
        requestCBActivity.startActivity(new Intent(requestCBActivity, PDCAddNewAddress.class));
    }

    public static final /* synthetic */ Boolean c(RequestCBActivity requestCBActivity) {
        return Boolean.valueOf(requestCBActivity.f17697d.length() >= requestCBActivity.f17696c);
    }
}
