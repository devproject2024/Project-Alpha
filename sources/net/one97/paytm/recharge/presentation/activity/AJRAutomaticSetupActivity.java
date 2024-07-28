package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.d;
import net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse;
import net.one97.paytm.recharge.domain.entities.CJRNativeWithDrawDetails;
import net.one97.paytm.recharge.presentation.c.b;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class AJRAutomaticSetupActivity extends PaytmActivity implements b.a, net.one97.paytm.recharge.widgets.b.a {
    private String A;
    private HashMap B;

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.recharge.presentation.g.a f64656a;

    /* renamed from: b  reason: collision with root package name */
    private CJRFrequentOrder f64657b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CJRCreateSubscriptionApiResponse f64658c;

    /* renamed from: d  reason: collision with root package name */
    private String f64659d;

    /* renamed from: e  reason: collision with root package name */
    private String f64660e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f64661f;

    /* renamed from: g  reason: collision with root package name */
    private String f64662g;

    /* renamed from: h  reason: collision with root package name */
    private String f64663h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, String> f64664i;
    private String j;
    private String k;
    private String l;
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.widgets.widget.a r;
    /* access modifiers changed from: private */
    public long s;
    private String t;
    private boolean u;
    private boolean v;
    /* access modifiers changed from: private */
    public long w;
    private int x = -1;
    private net.one97.paytm.recharge.presentation.c.b y;
    private String z;

    public final View b(int i2) {
        if (this.B == null) {
            this.B = new HashMap();
        }
        View view = (View) this.B.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.B.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>, x> {
        final /* synthetic */ Bundle $savedInstanceState;
        final /* synthetic */ AJRAutomaticSetupActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AJRAutomaticSetupActivity aJRAutomaticSetupActivity, Bundle bundle) {
            super(1);
            this.this$0 = aJRAutomaticSetupActivity;
            this.$savedInstanceState = bundle;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse> bVar) {
            FrameLayout frameLayout;
            if (bVar != null) {
                int i2 = c.f64713a[bVar.f64955c.ordinal()];
                if (i2 == 1) {
                    FrameLayout frameLayout2 = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar);
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                    }
                } else if (i2 == 2) {
                    FrameLayout frameLayout3 = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar);
                    if (frameLayout3 != null) {
                        frameLayout3.setVisibility(8);
                    }
                } else if (i2 == 3 && (frameLayout = (FrameLayout) this.this$0.b(R.id.lyt_progress_bar)) != null) {
                    frameLayout.setVisibility(8);
                }
                CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = (CJRCreateSubscriptionApiResponse) bVar.f64954b;
                if (cJRCreateSubscriptionApiResponse != null) {
                    CJRNativeWithDrawDetails nativeWithDrawDetail = cJRCreateSubscriptionApiResponse.getNativeWithDrawDetail();
                    if (!TextUtils.isEmpty(nativeWithDrawDetail != null ? nativeWithDrawDetail.getTxnToken() : null)) {
                        this.this$0.f64658c = cJRCreateSubscriptionApiResponse;
                        this.this$0.w = System.currentTimeMillis();
                        if (this.$savedInstanceState == null) {
                            AJRAutomaticSetupActivity.a(this.this$0);
                        }
                    }
                }
                NetworkCustomError networkCustomError = bVar.f64953a;
                if (networkCustomError == null) {
                    return;
                }
                if (networkCustomError.getStatusCode() == 499) {
                    g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.finish.on.click", this.this$0));
                    g.b(this.this$0, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                    return;
                }
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this.this$0, networkCustomError, (int) IuserActions.SCROLL_MAIN_RV);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        y<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>> yVar;
        y<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>> yVar2;
        super.onCreate(bundle);
        setContentView(R.layout.activity_automatic_payment_setup);
        Intent intent = getIntent();
        net.one97.paytm.recharge.presentation.g.b bVar = null;
        this.f64661f = intent != null ? intent.getExtras() : null;
        if (getIntent() != null) {
            if (getIntent().hasExtra("from")) {
                this.f64659d = getIntent().getStringExtra("from");
            }
            if (getIntent().hasExtra("first_four_digits")) {
                this.z = getIntent().getStringExtra("first_four_digits");
            }
            if (getIntent().hasExtra("last_four_digits")) {
                this.A = getIntent().getStringExtra("last_four_digits");
            }
            if (getIntent().hasExtra(UpiConstants.EXTRA_SUBSCRIPTION_ID)) {
                this.f64660e = getIntent().getStringExtra(UpiConstants.EXTRA_SUBSCRIPTION_ID);
            }
            if (getIntent().hasExtra("operator_logo")) {
                this.f64662g = getIntent().getStringExtra("operator_logo");
            }
            if (getIntent().hasExtra("recharge_number")) {
                this.f64663h = getIntent().getStringExtra("recharge_number");
            }
            if (getIntent().hasExtra("configuraton")) {
                Serializable serializableExtra = getIntent().getSerializableExtra("configuraton");
                if (serializableExtra != null) {
                    this.f64664i = (HashMap) serializableExtra;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
                }
            }
            if (getIntent().hasExtra(CLPConstants.PRODUCT_ID)) {
                this.j = getIntent().getStringExtra(CLPConstants.PRODUCT_ID);
            }
            if (getIntent().hasExtra("nick_name")) {
                this.k = getIntent().getStringExtra("nick_name");
            }
            if (getIntent().hasExtra("service_type")) {
                this.l = getIntent().getStringExtra("service_type");
            }
            if (getIntent().hasExtra("key_action")) {
                this.m = getIntent().getIntExtra("key_action", 0);
            }
            if (getIntent().hasExtra("card_id")) {
                this.n = getIntent().getStringExtra("card_id");
            }
            if (getIntent().hasExtra("key_payment_bank")) {
                this.p = getIntent().getStringExtra("key_payment_bank");
            }
            if (getIntent().hasExtra("key_bank_mandate")) {
                this.q = getIntent().getStringExtra("key_bank_mandate");
            }
            if (getIntent().hasExtra("is_from_reminder")) {
                this.u = getIntent().getBooleanExtra("is_from_reminder", false);
            }
            if (getIntent().hasExtra("operator_name")) {
                this.o = getIntent().getStringExtra("operator_name");
            }
            if (getIntent().hasExtra("is_bank_mandate_enabled")) {
                this.v = getIntent().getBooleanExtra("is_bank_mandate_enabled", false);
            }
            if (getIntent().hasExtra("selected_recent")) {
                Serializable serializableExtra2 = getIntent().getSerializableExtra("selected_recent");
                if (!(serializableExtra2 instanceof CJRFrequentOrder)) {
                    serializableExtra2 = null;
                }
                this.f64657b = (CJRFrequentOrder) serializableExtra2;
                if (TextUtils.isEmpty(this.f64662g)) {
                    CJRFrequentOrder cJRFrequentOrder = this.f64657b;
                    this.f64662g = cJRFrequentOrder != null ? cJRFrequentOrder.getOperatorLogoURL() : null;
                }
                if (TextUtils.isEmpty(this.f64663h)) {
                    CJRFrequentOrder cJRFrequentOrder2 = this.f64657b;
                    this.f64663h = cJRFrequentOrder2 != null ? cJRFrequentOrder2.getRechargeNumber() : null;
                }
                CJRFrequentOrder cJRFrequentOrder3 = this.f64657b;
                Map<String, String> configuration = cJRFrequentOrder3 != null ? cJRFrequentOrder3.getConfiguration() : null;
                if (!(configuration instanceof HashMap)) {
                    configuration = null;
                }
                this.f64664i = (HashMap) configuration;
                if (TextUtils.isEmpty(this.j)) {
                    CJRFrequentOrder cJRFrequentOrder4 = this.f64657b;
                    this.j = cJRFrequentOrder4 != null ? cJRFrequentOrder4.getProductID() : null;
                }
                if (TextUtils.isEmpty(this.k)) {
                    CJRFrequentOrder cJRFrequentOrder5 = this.f64657b;
                    this.k = cJRFrequentOrder5 != null ? cJRFrequentOrder5.getName() : null;
                }
                if (TextUtils.isEmpty(this.o)) {
                    CJRFrequentOrder cJRFrequentOrder6 = this.f64657b;
                    if ((cJRFrequentOrder6 != null ? cJRFrequentOrder6.getFrequentOrderProduct() : null) != null) {
                        CJRFrequentOrder cJRFrequentOrder7 = this.f64657b;
                        this.o = cJRFrequentOrder7 != null ? cJRFrequentOrder7.getOperatorDisplayLabel() : null;
                    }
                }
            }
            if (getIntent().hasExtra("service_paytype")) {
                this.t = getIntent().getStringExtra("service_paytype");
            }
        }
        String str = this.f64659d;
        if (str != null && p.a(str, "manage_screen", true)) {
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.recharge_group);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Context) this, net.one97.paytm.recharge.automatic.b.a.a.Z);
        }
        if (TextUtils.isEmpty(this.f64659d)) {
            net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Context) this, net.one97.paytm.recharge.automatic.b.a.a.Y);
        }
        this.f64656a = (net.one97.paytm.recharge.presentation.g.a) am.a((FragmentActivity) this, (al.b) new net.one97.paytm.recharge.presentation.e.a()).a(net.one97.paytm.recharge.presentation.g.a.class);
        net.one97.paytm.recharge.presentation.g.a aVar5 = this.f64656a;
        if (aVar5 != null) {
            yVar = aVar5.f64927d;
        } else {
            yVar = null;
        }
        d.a(this, yVar, new b(this, bundle));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.a((CharSequence) "");
        }
        TextView textView = (TextView) b(R.id.txt_name);
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(this.k) ? this.f64663h : this.k);
        }
        if (!TextUtils.isEmpty(this.k)) {
            TextView textView2 = (TextView) b(R.id.txt_operator_number);
            k.a((Object) textView2, "txt_operator_number");
            textView2.setText(this.f64663h);
            TextView textView3 = (TextView) b(R.id.txt_operator_number);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(this.o)) {
            TextView textView4 = (TextView) b(R.id.txt_operator);
            if (textView4 != null) {
                textView4.setText(this.o);
            }
            TextView textView5 = (TextView) b(R.id.txt_operator);
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(this.f64662g)) {
            w.a().a(this.f64662g).a((ImageView) b(R.id.ic_operator_icon));
        }
        if (com.paytm.utility.d.c(this)) {
            net.one97.paytm.recharge.presentation.g.a aVar6 = this.f64656a;
            if (!(aVar6 == null || (yVar2 = aVar6.f64927d) == null)) {
                bVar = yVar2.getValue();
            }
            if (bVar == null) {
                b();
                return;
            }
            return;
        }
        net.one97.paytm.recharge.automatic.c.a.a aVar7 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
        net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this, (int) IuserActions.SCROLL_MAIN_RV);
    }

    public final void a(String str, Bundle bundle) {
        if (str != null && str.hashCode() == -1657806898 && str.equals("tag.alert.finish.on.click")) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            net.one97.paytm.recharge.presentation.g.a aVar = this.f64656a;
            if (aVar != null) {
                aVar.a(context, c(), this.v);
                return;
            }
            return;
        }
        d();
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_postpaid", getIntent().getBooleanExtra("is_postpaid", true));
        bundle.putString("recharge_days", getIntent().getStringExtra("recharge_days"));
        bundle.putString("recharge_amount", getIntent().getStringExtra("recharge_amount"));
        bundle.putString("recharge_date", getIntent().getStringExtra("recharge_date"));
        bundle.putString("recharge_number", this.f64663h);
        bundle.putSerializable("configuraton", this.f64664i);
        bundle.putString(UpiConstants.EXTRA_SUBSCRIPTION_ID, this.f64660e);
        bundle.putString("from", this.f64659d);
        bundle.putString(CLPConstants.PRODUCT_ID, this.j);
        return bundle;
    }

    public final void a(boolean z2, boolean z3) {
        Intent intent = new Intent();
        Bundle bundle = this.f64661f;
        if (bundle != null) {
            if (bundle == null) {
                k.a();
            }
            intent.putExtras(bundle);
        }
        intent.putExtra("isSubscribed", z2);
        intent.putExtra("isPending", z3);
        intent.putExtra("key_action", this.m);
        setResult(-1, intent);
        if (!p.a("manage_screen", this.f64659d, true)) {
            Intent intent2 = new Intent(this, AJRAutomaticSubscriptionListActivity.class);
            intent2.putExtra("isSubscribed", z2);
            intent2.putExtra("isPending", z3);
            intent2.putExtra("recharge_number", this.f64663h);
            intent2.putExtra("nick_name", this.k);
            TextView textView = (TextView) b(R.id.txt_operator);
            intent2.putExtra("operator_name", String.valueOf(textView != null ? textView.getText() : null));
            intent2.putExtra("is_event_subscription", true);
            intent2.putExtra("from", this.f64659d);
            startActivity(intent2);
        }
        if (this.u) {
            Intent intent3 = new Intent();
            intent3.putExtra("is_refresh_needed", z2);
            setResult(-1, intent3);
        }
        finish();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1010) {
            if (i2 == 1011 || i2 == 1017) {
                finish();
            } else if (i2 != 1090) {
                super.onActivityResult(i2, i3, intent);
            } else if (intent == null || !intent.hasExtra("is_redirect_flow") || !intent.getBooleanExtra("is_redirect_flow", false)) {
                net.one97.paytm.recharge.presentation.c.b bVar = this.y;
                if (bVar != null) {
                    bVar.onActivityResult(i2, i3, intent);
                }
            } else {
                Intent intent2 = new Intent();
                Intent intent3 = getIntent();
                k.a((Object) intent3, "intent");
                Bundle extras = intent3.getExtras();
                if (extras != null) {
                    intent2.putExtras(extras);
                }
                intent2.putExtra("is_refresh_needed", intent.getBooleanExtra("isPending", false));
                setResult(-1, intent2);
                finish();
            }
        } else if (i3 != 0) {
            b();
        }
    }

    private final void d() {
        this.r = new net.one97.paytm.recharge.widgets.widget.a();
        net.one97.paytm.recharge.widgets.widget.a aVar = this.r;
        if (aVar != null) {
            aVar.a(new a(this));
        }
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            q a2 = supportFragmentManager.a();
            int i2 = R.id.offline_lyt_container;
            net.one97.paytm.recharge.widgets.widget.a aVar2 = this.r;
            if (aVar2 == null) {
                k.a();
            }
            a2.a(i2, aVar2, "").e();
        }
        FrameLayout frameLayout = (FrameLayout) b(R.id.offline_lyt_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticSetupActivity f64665a;

        a(AJRAutomaticSetupActivity aJRAutomaticSetupActivity) {
            this.f64665a = aJRAutomaticSetupActivity;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f64665a.s >= 2000) {
                this.f64665a.s = SystemClock.elapsedRealtime();
                if (com.paytm.utility.b.c((Context) this.f64665a)) {
                    q a2 = this.f64665a.getSupportFragmentManager().a();
                    net.one97.paytm.recharge.widgets.widget.a c2 = this.f64665a.r;
                    if (c2 == null) {
                        k.a();
                    }
                    a2.a((Fragment) c2).b();
                    FrameLayout frameLayout = (FrameLayout) this.f64665a.b(R.id.offline_lyt_container);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.f64665a.b();
                }
            }
        }
    }

    public final boolean a() {
        if (this.f64658c == null) {
            return true;
        }
        net.one97.paytm.recharge.automatic.c.a.b bVar = net.one97.paytm.recharge.automatic.c.a.b.f60258a;
        if (System.currentTimeMillis() - this.w <= ((long) net.one97.paytm.recharge.automatic.c.a.b.r())) {
            return false;
        }
        this.f64658c = null;
        return true;
    }

    public final void a(int i2) {
        if (com.paytm.utility.b.c((Context) this)) {
            this.x = i2;
            FrameLayout frameLayout = (FrameLayout) b(R.id.lyt_container);
            if (frameLayout != null) {
                frameLayout.removeAllViewsInLayout();
            }
            b();
        }
    }

    public static final /* synthetic */ void a(AJRAutomaticSetupActivity aJRAutomaticSetupActivity) {
        CJRNativeWithDrawDetails nativeWithDrawDetail;
        CJRNativeWithDrawDetails nativeWithDrawDetail2;
        Long txnAmount;
        Long orderId;
        b.C1279b bVar = net.one97.paytm.recharge.presentation.c.b.f64805a;
        CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = aJRAutomaticSetupActivity.f64658c;
        Bundle bundle = new Bundle();
        CharSequence charSequence = null;
        bundle.putString("key_mid", cJRCreateSubscriptionApiResponse != null ? cJRCreateSubscriptionApiResponse.getMid() : null);
        bundle.putString("key_order_id", (cJRCreateSubscriptionApiResponse == null || (orderId = cJRCreateSubscriptionApiResponse.getOrderId()) == null) ? null : String.valueOf(orderId.longValue()));
        bundle.putString("txn_amount", (cJRCreateSubscriptionApiResponse == null || (txnAmount = cJRCreateSubscriptionApiResponse.getTxnAmount()) == null) ? null : String.valueOf(txnAmount.longValue()));
        bundle.putString("channel_id", SDKConstants.WAP);
        bundle.putString(CJRGTMConstants.MT_V4_TXN_STATUS, cJRCreateSubscriptionApiResponse != null ? cJRCreateSubscriptionApiResponse.getStatus() : null);
        bundle.putString(UpiConstants.EXTRA_SUBSCRIPTION_ID, (cJRCreateSubscriptionApiResponse == null || (nativeWithDrawDetail2 = cJRCreateSubscriptionApiResponse.getNativeWithDrawDetail()) == null) ? null : nativeWithDrawDetail2.getSubscriptionId());
        bundle.putString("txn_token", (cJRCreateSubscriptionApiResponse == null || (nativeWithDrawDetail = cJRCreateSubscriptionApiResponse.getNativeWithDrawDetail()) == null) ? null : nativeWithDrawDetail.getTxnToken());
        bundle.putString("key_native_withdraw", cJRCreateSubscriptionApiResponse != null ? cJRCreateSubscriptionApiResponse.getNativeWithDraw() : null);
        bundle.putString("from", aJRAutomaticSetupActivity.f64659d);
        bundle.putString("card_id", aJRAutomaticSetupActivity.n);
        bundle.putString("key_payment_bank", aJRAutomaticSetupActivity.p);
        bundle.putString("key_bank_mandate", aJRAutomaticSetupActivity.q);
        bundle.putBoolean("is_bank_mandate_enabled", aJRAutomaticSetupActivity.v);
        TextView textView = (TextView) aJRAutomaticSetupActivity.b(R.id.txt_operator_number);
        if (textView != null) {
            charSequence = textView.getText();
        }
        bundle.putString("operator_name", String.valueOf(charSequence));
        bundle.putString("recharge_number", aJRAutomaticSetupActivity.f64663h);
        bundle.putSerializable("configuraton", aJRAutomaticSetupActivity.f64664i);
        bundle.putString("nick_name", aJRAutomaticSetupActivity.k);
        bundle.putString("service_paytype", aJRAutomaticSetupActivity.t);
        bundle.putBoolean("is_postpaid", aJRAutomaticSetupActivity.getIntent().getBooleanExtra("is_postpaid", true));
        bundle.putString("recharge_days", aJRAutomaticSetupActivity.getIntent().getStringExtra("recharge_days"));
        bundle.putString("recharge_amount", aJRAutomaticSetupActivity.getIntent().getStringExtra("recharge_amount"));
        bundle.putString("recharge_date", aJRAutomaticSetupActivity.getIntent().getStringExtra("recharge_date"));
        bundle.putString("operator_logo", aJRAutomaticSetupActivity.getIntent().getStringExtra("operator_logo"));
        bundle.putString("key_account", aJRAutomaticSetupActivity.getIntent().getStringExtra("key_account"));
        bundle.putString("product_id_option", aJRAutomaticSetupActivity.j);
        bundle.putInt(CLPConstants.PRODUCT_ID, aJRAutomaticSetupActivity.x);
        bundle.putString("first_four_digits", aJRAutomaticSetupActivity.z);
        bundle.putString("last_four_digits", aJRAutomaticSetupActivity.A);
        b.a aVar = aJRAutomaticSetupActivity;
        k.c(bundle, "bundle");
        k.c(aVar, "automaticCompleteListener");
        net.one97.paytm.recharge.presentation.c.b.F = aVar;
        net.one97.paytm.recharge.presentation.c.b bVar2 = new net.one97.paytm.recharge.presentation.c.b();
        bVar2.setArguments(bundle);
        aJRAutomaticSetupActivity.y = bVar2;
        j supportFragmentManager = aJRAutomaticSetupActivity.getSupportFragmentManager();
        if (supportFragmentManager != null) {
            q a2 = supportFragmentManager.a();
            int i2 = R.id.lyt_container;
            net.one97.paytm.recharge.presentation.c.b bVar3 = aJRAutomaticSetupActivity.y;
            if (bVar3 == null) {
                k.a();
            }
            q b2 = a2.b(i2, bVar3);
            if (b2 != null) {
                b2.c();
            }
        }
    }
}
