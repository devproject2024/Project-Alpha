package net.one97.paytm.auth.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.paytm.contactsSdk.api.ContactsProvider;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.e;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.CJRActionBarBaseActivity;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.m;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.j.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.e.e;
import net.one97.paytm.oauth.fragment.ProgressView;
import net.one97.paytm.oauth.fragment.ay;
import net.one97.paytm.oauth.fragment.bi;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.utils.w;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.model.CJRInstantOperator;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.SignUpAddBankActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.ups.listener.UpdateConsentListener;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.as;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.utils.v;
import net.one97.paytm.wallet.f.d;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRAuthActivity extends CJRActionBarBaseActivity {
    private ProgressView C;
    private ViewGroup D;
    /* access modifiers changed from: private */
    public String E;
    /* access modifiers changed from: private */
    public boolean F;
    /* access modifiers changed from: private */
    public long G;
    private long H;
    private i I;
    private String J;
    /* access modifiers changed from: private */
    public String K;
    /* access modifiers changed from: private */
    public b L;
    private e M;

    /* renamed from: a  reason: collision with root package name */
    private final String f49089a;

    /* renamed from: b  reason: collision with root package name */
    private CJRDetailProduct f49090b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f49091c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49092d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49093e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f49094f;

    /* renamed from: g  reason: collision with root package name */
    private String f49095g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f49096h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f49097i;
    private int j = 1001;
    private String k;
    private boolean l;

    public final void a() {
    }

    public AJRAuthActivity() {
        Class<AJRAuthActivity> cls = AJRAuthActivity.class;
        this.f49089a = cls.getName();
        this.k = cls.getSimpleName();
        this.l = true;
    }

    public void onCreate(Bundle bundle) {
        this.E = getIntent().getStringExtra("prev_token");
        if (getIntent().hasExtra("authError")) {
            this.f49093e = getIntent().getBooleanExtra("authError", false);
        }
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.auth, (ViewGroup) null));
        this.D = (ViewGroup) findViewById(R.id.root);
        if (getSupportActionBar() != null) {
            getSupportActionBar().a((CharSequence) "");
            getSupportActionBar().f();
            o();
            this.p.b(false);
        }
        this.f49094f = (ProgressBar) findViewById(R.id.progressBarCircular);
        r();
        this.f49092d = getIntent().getBooleanExtra("sign_in_sign_up_with_step_2", false);
        this.f49096h = getIntent().getStringExtra("VERTICAL_NAME");
        if (getIntent().hasExtra("product_details_bargin")) {
            this.f49090b = (CJRDetailProduct) getIntent().getSerializableExtra("product_details_bargin");
        }
        c();
        this.F = getIntent().getBooleanExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, false);
        if (!a.p(this) || this.f49093e) {
            this.l = false;
            if (this.F) {
                if (bundle == null || !bundle.containsKey("IS_FORCE_RESTART")) {
                    Intent intent = new Intent(this, OAuthMainActivity.class);
                    intent.putExtras(getIntent().getExtras() == null ? new Bundle() : getIntent().getExtras());
                    startActivityForResult(intent, this.j);
                    this.J = "full_page";
                    return;
                }
                finish();
            } else if (this.f49093e) {
                this.f49094f.setVisibility(0);
                w wVar = new w(new w.a() {
                    public final void a() {
                        AJRAuthActivity.this.b();
                    }

                    public final void b() {
                        AJRAuthActivity.this.f49094f.setVisibility(8);
                        net.one97.paytm.auth.b.b.a((Context) AJRAuthActivity.this);
                        if (!TextUtils.isEmpty(AJRAuthActivity.this.E)) {
                            OAuthUtils.a(AJRAuthActivity.this.getSupportFragmentManager(), (View.OnClickListener) new View.OnClickListener() {
                                public final void onClick(View view) {
                                    AJRAuthActivity.AnonymousClass1.this.a(view);
                                }
                            });
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    AJRAuthActivity.AnonymousClass1.this.c();
                                }
                            }, 500);
                            return;
                        }
                        AJRAuthActivity.this.b(net.one97.paytm.oauth.utils.b.SESSION_EXPIRY);
                        AJRAuthActivity.this.a(net.one97.paytm.oauth.utils.b.SESSION_EXPIRY);
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void a(View view) {
                        AJRAuthActivity.this.b(net.one97.paytm.oauth.utils.b.SESSION_EXPIRY);
                        AJRAuthActivity.this.a(net.one97.paytm.oauth.utils.b.SESSION_EXPIRY);
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void c() {
                        net.one97.paytm.auth.b.b.a(AJRAuthActivity.this, false);
                        OauthModule.d();
                    }
                });
                o oVar = o.f56791a;
                if (o.a()) {
                    q qVar = q.f56798a;
                    if (!TextUtils.isEmpty(q.s())) {
                        q qVar2 = q.f56798a;
                        net.one97.paytm.oauth.b.b.a(q.s(), (com.paytm.network.listener.b) new w.c(wVar), a.c.AUTH);
                        this.J = "sessionExpiryEvent";
                    }
                }
                wVar.f56802a.b();
                this.J = "sessionExpiryEvent";
            } else {
                b(net.one97.paytm.oauth.utils.b.VERTICAL);
                a(net.one97.paytm.oauth.utils.b.VERTICAL);
                this.J = "ind_vertical";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("IS_FORCE_RESTART", true);
        super.onSaveInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        if (com.paytm.utility.a.p(this) && this.l) {
            finish();
        }
    }

    public void onStop() {
        com.paytm.utility.b.c((Activity) this);
        as.a().f69661a = null;
        d.a().b();
        super.onStop();
    }

    public void onBackPressed() {
        c();
        com.paytm.utility.b.c((Activity) this);
        if (this.f49093e) {
            super.onBackPressed();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        super.onActivityResult(i2, i3, intent);
        com.paytm.utility.a.c();
        if (i2 == 101) {
            Fragment c2 = getSupportFragmentManager().c(bi.class.getName());
            if ((c2 instanceof bi) && c2.isVisible()) {
                c2.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == this.j) {
            this.l = false;
            if (i3 != -1 || intent == null) {
                finish();
                return;
            }
            net.one97.paytm.oauth.a.a();
            if (net.one97.paytm.oauth.a.a("oauthComsUserConsent", true)) {
                ContactsProvider.INSTANCE.updateConsent(true, new UpdateConsentListener() {
                    public final void onConsentUpdated(boolean z, String str, boolean z2) {
                        com.paytm.utility.q.d("Consent Update has errors -> ".concat(String.valueOf(z)));
                    }
                });
            }
            a(intent.getStringExtra("login_mobile"));
            getResources().getString(R.string.txt_verifying_details);
            this.C = (ProgressView) LayoutInflater.from(this).inflate(R.layout.progress_view, this.D, false);
            this.D.addView(this.C, new RelativeLayout.LayoutParams(-1, -1));
            this.C.setAlpha(1.0f);
            this.C.setVisibility(0);
            if (intent != null) {
                this.f49091c = intent.getBooleanExtra("is_new_signup", false);
                this.I = (i) intent.getSerializableExtra("flow_type");
                if (this.f49091c) {
                    if (this.I == i.CLAIM) {
                        this.K = "claim_signup";
                    } else {
                        this.K = "signup";
                    }
                } else if (this.I == i.CLAIM) {
                    this.K = "claim_login";
                } else {
                    this.K = "login";
                }
            }
            b();
        } else if (i2 == 2001) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            if (intent == null) {
                str2 = "";
            } else {
                str2 = intent.getStringExtra("result");
            }
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(str2);
            arrayList.add(String.valueOf((currentTimeMillis - this.G) / 1000));
            OauthModule.b().sendGAMultipleLabelEvent(this, "onboarding", "upi_onboarding_done", arrayList, this.K, "", p.f56796a);
            this.H = System.currentTimeMillis();
            f();
        } else if (i2 == 2002) {
            long currentTimeMillis2 = System.currentTimeMillis();
            ArrayList arrayList2 = new ArrayList();
            if (intent == null) {
                str = "";
            } else {
                str = intent.getStringExtra("result");
            }
            if (str == null) {
                str = "";
            }
            arrayList2.add(str);
            arrayList2.add(String.valueOf((currentTimeMillis2 - this.H) / 1000));
            OauthModule.b().sendGAMultipleLabelEvent(this, "onboarding", "min_kyc_onboarding_done", arrayList2, this.K, "", p.f56796a);
            x();
        } else if (i2 == 113) {
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        ag.a(this).a("mobile", str, true);
    }

    /* access modifiers changed from: private */
    public void b() {
        g();
        o oVar = o.f56791a;
        if (o.a()) {
            OauthModule.a((com.paytm.network.listener.b) this, "DEFAULT,USERID,USER_TYPE,USER_ATTRIBUTE,password_status,kyc_state,device_binding_info");
            a aVar = new a(getApplicationContext());
            aVar.f49107a = getIntent().getBooleanExtra("is_from_upi", false);
            aVar.execute(new Void[0]);
            return;
        }
        t.a((Activity) this, (com.paytm.network.listener.b) this, a.c.OAUTH);
    }

    private void c() {
        ag.a(getApplicationContext()).a("key_user_is_sign_in_shown", true, true);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        j();
        k();
        l();
        d(this.f49095g);
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public void a(net.one97.paytm.oauth.utils.b bVar) {
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("resultant activity_bundle");
        bundle.putSerializable("auth_flow", bVar);
        if (bundleExtra != null) {
            bundle.putBoolean("close_pop_up", bundleExtra.getBoolean("close_pop_up", false));
        }
        OauthModule.a(bundle, getSupportFragmentManager(), this.M);
    }

    /* access modifiers changed from: private */
    public void b(final net.one97.paytm.oauth.utils.b bVar) {
        this.M = new e() {
            public final void a(b bVar, Boolean bool, String str) {
                AJRAuthActivity.this.a(str);
                b unused = AJRAuthActivity.this.L = bVar;
                if (bVar == net.one97.paytm.oauth.utils.b.VERTICAL) {
                    boolean unused2 = AJRAuthActivity.this.f49091c = bool.booleanValue();
                }
                AJRAuthActivity.this.b();
            }
        };
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        super.onApiSuccess(iJRPaytmDataModel);
        if (!isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRShoppingCart) {
                c.a();
                String a2 = c.a("min_kyc_status_v3_url", (String) null);
                if (URLUtil.isValidUrl(a2)) {
                    String e2 = com.paytm.utility.b.e(getApplicationContext(), a2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", t.b(getApplicationContext()));
                    if (com.paytm.utility.a.m(getApplicationContext())) {
                        net.one97.paytm.common.b.d.a(this, e2, this, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new KYCStatusV2(), a.c.AUTH, a.b.SILENT).a();
                    }
                }
                e();
            } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                CJRPGTokenList cJRPGTokenList = (CJRPGTokenList) iJRPaytmDataModel;
                t.b(cJRPGTokenList);
                t.a(cJRPGTokenList);
                if (t.c((Context) this) != null) {
                    OauthModule.a((com.paytm.network.listener.b) this, "DEFAULT,USERID,USER_TYPE,USER_ATTRIBUTE,password_status,kyc_state,device_binding_info");
                    a aVar = new a(getApplicationContext());
                    aVar.f49107a = getIntent().getBooleanExtra("is_from_upi", false);
                    aVar.execute(new Void[0]);
                }
            } else if (iJRPaytmDataModel instanceof CJRUserInfoV2) {
                CJRUserInfoV2 cJRUserInfoV2 = (CJRUserInfoV2) iJRPaytmDataModel;
                if (!(cJRUserInfoV2 == null || cJRUserInfoV2.getUserDefaultInfo() == null || TextUtils.isEmpty(cJRUserInfoV2.getUserDefaultInfo().getPhone()))) {
                    ag.a(getApplicationContext()).a("isPhoneNoAdded", true, true);
                }
                t.d(cJRUserInfoV2.getUserId());
                t.c(cJRUserInfoV2.getUserId());
                l.a(cJRUserInfoV2, (Context) this);
                String str = "";
                if (!(cJRUserInfoV2 == null || cJRUserInfoV2.getUserId() == null || cJRUserInfoV2.getUserDefaultInfo() == null || cJRUserInfoV2.getUserDefaultInfo().getPhone() == null)) {
                    net.one97.paytm.j.a.b("/login", str, (Context) this);
                }
                if (this.f49091c) {
                    if (cJRUserInfoV2 != null) {
                        v vVar = v.f69802a;
                        Context applicationContext = getApplicationContext();
                        String userId = cJRUserInfoV2.getUserId();
                        k.c(userId, "customerId");
                        try {
                            Map hashMap2 = new HashMap();
                            hashMap2.put(AFInAppEventParameterName.CUSTOMER_USER_ID, userId);
                            hashMap2.put(AFInAppEventParameterName.REGSITRATION_METHOD, "Mobile Device");
                            vVar.a(applicationContext, AFInAppEventType.COMPLETE_REGISTRATION, hashMap2);
                        } catch (Exception e3) {
                            if (com.paytm.utility.b.v) {
                                vVar.getClass().getSimpleName();
                                com.paytm.utility.q.b(e3.getMessage());
                            }
                        }
                    }
                } else if (cJRUserInfoV2 != null) {
                    v vVar2 = v.f69802a;
                    Context applicationContext2 = getApplicationContext();
                    String userId2 = cJRUserInfoV2.getUserId();
                    k.c(userId2, "customerId");
                    try {
                        Map hashMap3 = new HashMap();
                        hashMap3.put(AFInAppEventParameterName.CUSTOMER_USER_ID, userId2);
                        vVar2.a(applicationContext2, AFInAppEventType.LOGIN, hashMap3);
                    } catch (Exception e4) {
                        if (com.paytm.utility.b.v) {
                            vVar2.getClass().getSimpleName();
                            com.paytm.utility.q.b(e4.getMessage());
                        }
                    }
                }
                String b2 = com.paytm.utility.a.b((Context) this);
                if (!getIntent().getBooleanExtra("is_from_upi", false)) {
                    e();
                }
                if (!this.f49092d) {
                    v();
                } else if (!(cJRUserInfoV2 == null || cJRUserInfoV2.getUserDefaultInfo() == null)) {
                    c.a();
                    if (!c.a("showStep2", false) || cJRUserInfoV2.getUserDefaultInfo().isPhoneVerificationStatus()) {
                        v();
                    } else {
                        setResult(-1, new Intent());
                        finish();
                    }
                }
                if (b2 != null) {
                    str = b2;
                }
                net.one97.paytm.recharge.mobile.b c2 = net.one97.paytm.recharge.common.b.d.c(this);
                AnonymousClass8 r3 = new ai() {
                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                    }

                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        boolean unused = AJRAuthActivity.this.f49097i = ((CJRInstantOperator) iJRPaytmDataModel).getPostPaid();
                        ag.a(AJRAuthActivity.this.getApplicationContext()).a("is_postpaid", String.valueOf(AJRAuthActivity.this.f49097i), true);
                    }
                };
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                c2.e("requestMNP", r3, str, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
                androidx.localbroadcastmanager.a.a.a((Context) this).a(new Intent("action_update_login_status"));
                if (com.paytm.utility.a.p(this)) {
                    net.one97.paytm.utils.w.a((Context) this);
                }
                ArrayList<String> userTypes = cJRUserInfoV2.getUserTypes();
                c.a();
                if (c.a("checkPaymentBankLead", true)) {
                    if (userTypes == null || userTypes.size() <= 0) {
                        net.one97.paytm.utils.a.b.a((Context) this, true);
                    } else if (userTypes.contains("BANK_LEAD") && !userTypes.contains("BANK_CUSTOMER")) {
                        net.one97.paytm.utils.a.b.c(this);
                        net.one97.paytm.utils.a.b.a((Context) this, false);
                    } else if (!userTypes.contains("BANK_LEAD") && !userTypes.contains("BANK_CUSTOMER")) {
                        net.one97.paytm.utils.a.b.a((Context) this, true);
                    }
                } else if (userTypes == null || userTypes.size() <= 0 || !userTypes.contains("BANK_CUSTOMER")) {
                    net.one97.paytm.utils.a.b.a((Context) this, false);
                    net.one97.paytm.utils.a.b.c(this);
                }
                if (userTypes != null) {
                    ag.a(getApplicationContext()).a("ppb_customer", userTypes.contains("PPB_CUSTOMER"), true);
                }
                if (userTypes == null || userTypes.size() <= 0) {
                    l.a((Context) this, false);
                    l.b((Context) this, false);
                } else {
                    if (userTypes.contains("PRIME_USER")) {
                        l.a((Context) this, true);
                    } else {
                        l.a((Context) this, false);
                    }
                    if (userTypes.contains("POSTPAID_USER")) {
                        l.b((Context) this, true);
                    } else {
                        l.b((Context) this, false);
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.J);
                ay ayVar = ay.f56391a;
                q qVar = q.f56798a;
                if (ay.a((Context) this, q.k())) {
                    arrayList.add("location_flow");
                }
                if (this.f49091c) {
                    a("signup_successful", arrayList, this.I == i.CLAIM ? "claim_signup" : "signup");
                } else {
                    OauthModule.b().sendGAMultipleLabelEvent(getApplicationContext(), "login_signup", "login_successful", arrayList, this.I == i.CLAIM ? "claim_login" : "login", "/login-signup", p.f56796a);
                }
                m mVar = m.f50358c;
                k.c(this, "context");
                if (DynamicModuleManager.getInstance().isInstalled("feed")) {
                    m.b(this);
                    new StringBuilder("Listener :: ").append(m.f50356a);
                    m.a aVar2 = m.f50356a;
                    if (aVar2 != null) {
                        aVar2.onUserLoggedIn(this);
                    }
                }
                com.paytm.utility.b.y(getApplicationContext(), e.b.CONSUMER.name());
            } else if (iJRPaytmDataModel instanceof KYCStatusV2) {
                KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRPaytmDataModel;
                j.a(getApplicationContext(), kYCStatusV2.getIsKycDone());
                j.a(getApplicationContext(), kYCStatusV2.isMinKycStatus());
                j.b(getApplicationContext(), kYCStatusV2.isMinKycEligible());
                if (!TextUtils.isEmpty(kYCStatusV2.getKycType())) {
                    j.c(getApplicationContext(), kYCStatusV2.getKycType());
                }
                if (kYCStatusV2.isKycExpired() == 0 || kYCStatusV2.isKycExpired() == 1) {
                    j.b(getApplicationContext(), kYCStatusV2.isKycExpired());
                } else {
                    j.b(getApplicationContext(), 0);
                }
                if (!TextUtils.isEmpty(kYCStatusV2.getKycExpiryTime())) {
                    j.d(getApplicationContext(), com.paytm.utility.b.h(kYCStatusV2.getKycExpiryTime(), "dd/MM/yyyy", "dd MMM yyyy"));
                }
                if (!TextUtils.isEmpty(kYCStatusV2.getIsMinor())) {
                    j.e(getApplicationContext(), kYCStatusV2.getIsMinor());
                }
                j.c(getApplicationContext(), kYCStatusV2.isAadharVerified());
                OauthModule.a((com.paytm.network.listener.b) this, "DEFAULT,USERID,USER_TYPE,USER_ATTRIBUTE,password_status,kyc_state,device_binding_info");
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        super.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        if (networkCustomError == null) {
            return;
        }
        if ((!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) || networkCustomError.getMessage() == null || r.a((Context) this, (Exception) networkCustomError)) {
            return;
        }
        if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
            if (URLUtil.isValidUrl(networkCustomError.getUrl())) {
                str = getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl();
            } else {
                str = getResources().getString(R.string.network_error_message);
            }
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), str);
            return;
        }
        com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
    }

    private void d() {
        if (TextUtils.isEmpty(com.paytm.utility.a.b((Context) this))) {
            com.paytm.utility.b.ab(this);
        }
        getApplicationContext();
        getApplicationContext();
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null));
        a2.b((a.C1389a) new a.C1389a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            }
        }, this.f49089a, this.k);
        a2.c(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (AJRAuthActivity.this.u()) {
                    AJRAuthActivity.this.x();
                } else if (AJRAuthActivity.this.F) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel == null || TextUtils.isEmpty(upiAvailabilityModel.getStatus()) || !"success".equalsIgnoreCase(upiAvailabilityModel.getStatus().toLowerCase().trim())) {
                        AJRAuthActivity.this.x();
                        return;
                    }
                    UpiAvailabilityModel.UpiAvailabilityResponse response = upiAvailabilityModel.getResponse();
                    String str = "no";
                    if (response == null || response.isUpiUser() || response.isUpiProfileExist()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(H5AppHandler.CHECK_VALUE);
                        net.one97.paytm.oauth.b b2 = OauthModule.b();
                        AJRAuthActivity aJRAuthActivity = AJRAuthActivity.this;
                        b2.sendGAMultipleLabelEvent(aJRAuthActivity, "onboarding", "upi_exists", arrayList, aJRAuthActivity.K, "", p.f56796a);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str);
                        net.one97.paytm.oauth.b b3 = OauthModule.b();
                        AJRAuthActivity aJRAuthActivity2 = AJRAuthActivity.this;
                        b3.sendGAMultipleLabelEvent(aJRAuthActivity2, "onboarding", "upi_exists", arrayList2, aJRAuthActivity2.K, "", p.f56796a);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    net.one97.paytm.deeplink.v vVar = net.one97.paytm.deeplink.v.f50378a;
                    if (net.one97.paytm.deeplink.v.a((Context) AJRAuthActivity.this)) {
                        str = H5AppHandler.CHECK_VALUE;
                    }
                    arrayList3.add(str);
                    net.one97.paytm.oauth.b b4 = OauthModule.b();
                    AJRAuthActivity aJRAuthActivity3 = AJRAuthActivity.this;
                    b4.sendGAMultipleLabelEvent(aJRAuthActivity3, "onboarding", "min_kyc_exists", arrayList3, aJRAuthActivity3.K, "", p.f56796a);
                    if (response == null) {
                        AJRAuthActivity.this.x();
                    } else if (response.isUpiUser() || response.isUpiProfileExist()) {
                        AJRAuthActivity.this.f();
                    } else {
                        long unused = AJRAuthActivity.this.G = System.currentTimeMillis();
                        AJRAuthActivity.h(AJRAuthActivity.this);
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                AJRAuthActivity.this.x();
            }
        }, this.f49089a, this.k);
    }

    private void e() {
        if (t.a() != null) {
            c.a();
            String a2 = c.a("cartv2", (String) null);
            String g2 = t.g(this);
            if (g2 != null) {
                String str = a2 + "/" + g2;
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, getApplicationContext());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("action", "applypromo");
                    JSONObject jSONObject2 = new JSONObject();
                    Map<String, String> a4 = t.a();
                    if (a4 != null) {
                        for (Map.Entry next : a4.entrySet()) {
                            jSONObject2.put((String) next.getKey(), next.getValue());
                        }
                    }
                    jSONObject.put("item_map", jSONObject2);
                } catch (JSONException e2) {
                    if (com.paytm.utility.b.v) {
                        com.paytm.utility.q.b(e2.getMessage());
                    }
                }
                net.one97.paytm.common.b.d.a(this, str, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        com.paytm.utility.a.c();
                        CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRPaytmDataModel;
                        if ((cJRShoppingCart == null || !cJRShoppingCart.getStatus().getResult().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) && cJRShoppingCart != null && cJRShoppingCart.getCart() != null && cJRShoppingCart.getCart().getPromoStatus().equalsIgnoreCase("success")) {
                            if (cJRShoppingCart.getCart().getCartItems() != null && cJRShoppingCart.getCart().getCartItems().size() > 0) {
                                t.a((Context) AJRAuthActivity.this, cJRShoppingCart.getCart().getCartItems().size());
                                t.b(AJRAuthActivity.this, cJRShoppingCart.getCart().getFinalPrice());
                            }
                            t.h(AJRAuthActivity.this);
                            t.b();
                            t.a(false);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getAlertTitle()) && !TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                            t.a(true);
                        }
                        t.b();
                    }
                }, a3, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRShoppingCart(), a.c.AUTH, a.b.SILENT).a();
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        boolean z;
        boolean z2 = this.f49091c;
        net.one97.paytm.oauth.a.a();
        if (z2) {
            z = net.one97.paytm.oauth.a.a("oauthEnableMinKycOnboardingSignUp", true);
        } else {
            z = net.one97.paytm.oauth.a.a("oauthEnableMinKycOnboarding", true);
        }
        if (z) {
            net.one97.paytm.deeplink.v vVar = net.one97.paytm.deeplink.v.f50378a;
            if (!net.one97.paytm.deeplink.v.a((Context) this)) {
                net.one97.paytm.payments.d.a.a((Activity) this, "paytmmp://min_kyc?featuretype=onboarding");
                return;
            }
        }
        x();
    }

    /* access modifiers changed from: private */
    public boolean u() {
        return UpiLandingPageActivity.class.getName().equalsIgnoreCase(getIntent().getStringExtra("resultant activity"));
    }

    private void v() {
        d();
        if (!u() && !this.F) {
            x();
        }
    }

    private void w() {
        b bVar = this.L;
        if (bVar != null) {
            bVar.dismissAllowingStateLoss();
        }
        if (getIntent().getBooleanExtra("finish_current", false)) {
            as a2 = as.a();
            if ((a2.f69661a != null ? (Activity) a2.f69661a.get() : null) != null) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        AJRAuthActivity.this.A();
                    }
                }, 100);
                return;
            }
        }
        as.a().f69661a = null;
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A() {
        as a2 = as.a();
        if (a2.f69661a != null && !((Activity) a2.f69661a.get()).getClass().getName().equals("net.one97.paytm.landingpage.activity.AJRMainActivity")) {
            ((Activity) a2.f69661a.get()).finish();
        }
        a2.f69661a = null;
        finish();
    }

    /* access modifiers changed from: private */
    public void x() {
        Bundle bundleExtra;
        String string;
        net.one97.paytm.common.utility.b.br = true;
        net.one97.paytm.utils.g.a(this, false);
        z();
        String str = null;
        if (getIntent().hasExtra("deeplink") || getIntent().hasExtra(UpiConstants.EXTRA_KEY_DEEPLINK_BUNDLE)) {
            if (TextUtils.isEmpty(getIntent().getStringExtra("deeplink")) || !getIntent().getStringExtra("deeplink").contains("upi_landing")) {
                y();
            } else {
                g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)).c(new a.C1389a() {
                    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                        AJRAuthActivity.this.y();
                    }

                    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                        AJRAuthActivity.this.y();
                    }
                }, "", "");
                return;
            }
        }
        if (getIntent().getStringExtra("resultant activity") != null) {
            String stringExtra = getIntent().getStringExtra("resultant activity");
            if (getIntent().hasExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE)) {
                str = getIntent().getStringExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE);
            }
            l.a("AJRAuthActivity", "TargetClass ".concat(String.valueOf(stringExtra)));
            try {
                Intent intent = new Intent(this, Class.forName(stringExtra));
                if (this.f49093e) {
                    intent.addFlags(65536);
                }
                if (getIntent().hasExtra("resultant activity_bundle") && (bundleExtra = getIntent().getBundleExtra("resultant activity_bundle")) != null) {
                    try {
                        if (bundleExtra.containsKey("origin") && (string = bundleExtra.getString("origin")) != null && (string.equalsIgnoreCase("deeplinking") || string.equalsIgnoreCase("pushnotification"))) {
                            intent.putExtra("origin", string);
                            intent.putExtra("extra_home_data", bundleExtra.getSerializable("extra_home_data"));
                            intent.putExtra("DeeplinkUrl", getIntent().getStringExtra("DeeplinkUrl"));
                            intent.putExtra("order_summary_url", getIntent().getStringExtra("order_summary_url"));
                            if (bundleExtra.containsKey("kyc_pan_deeplink")) {
                                intent.putExtra("kyc_pan_deeplink", true);
                            } else if (bundleExtra.containsKey("passcode")) {
                                intent.putExtra("passcode", true);
                            } else if (bundleExtra.containsKey("is_beneficiary_Deeplink")) {
                                intent.putExtra("is_beneficiary_Deeplink", true);
                            } else if (bundleExtra.containsKey("prime_login")) {
                                intent.putExtra("prime_login", true);
                            }
                        }
                        if (bundleExtra.containsKey("is_deep_linking_data")) {
                            intent.putExtra("is_deep_linking_data", bundleExtra.getBoolean("is_deep_linking_data"));
                        }
                        if (bundleExtra.containsKey("order_id")) {
                            intent.putExtra("order_id", getIntent().getStringExtra("order_id"));
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            com.paytm.utility.q.b(e2.getMessage());
                        }
                    }
                    intent.putExtras(bundleExtra);
                }
                if (str != null) {
                    intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, str);
                }
                intent.putExtra("current_catalog", this.r);
                intent.putExtra("frequent_orders", this.v);
                intent.putExtra("is_from_signup", this.f49091c);
                startActivity(intent);
                w();
            } catch (ClassNotFoundException unused) {
                com.google.firebase.crashlytics.c.a().a((Throwable) new ClassNotFoundException("CNFE ".concat(String.valueOf(stringExtra))));
                w();
            } catch (ActivityNotFoundException unused2) {
                com.google.firebase.crashlytics.c.a().a((Throwable) new ActivityNotFoundException("ANFE ".concat(String.valueOf(stringExtra))));
                w();
            }
        } else {
            if (this.f49090b != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("product_details_bargin", this.f49090b);
                setResult(-1, intent2);
            } else if (getIntent().hasExtra("branch_share_url")) {
                Intent intent3 = new Intent();
                intent3.putExtra("branch_share_url", getIntent().getStringExtra("branch_share_url"));
                setResult(-1, intent3);
            } else if (getIntent().hasExtra("branch_deeplink_key")) {
                String stringExtra2 = getIntent().getStringExtra("branch_deeplink_key");
                try {
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        h.a aVar = h.f50349a;
                        h.a.a(this, stringExtra2, (Bundle) null);
                    }
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        com.paytm.utility.q.b(e3.getMessage());
                    }
                }
            } else {
                Intent intent4 = new Intent();
                Bundle bundleExtra2 = getIntent().getBundleExtra("resultant activity_bundle");
                if (bundleExtra2 != null) {
                    intent4.putExtras(bundleExtra2);
                }
                setResult(-1, intent4);
            }
            as.a().f69661a = null;
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        h.a aVar = h.f50349a;
        if (h.a.a(this, getIntent().getStringExtra("deeplink"), getIntent().getBundleExtra(UpiConstants.EXTRA_KEY_DEEPLINK_BUNDLE))) {
            finish();
        }
    }

    private void z() {
        ag.a(getApplicationContext()).a("is_from_signup", this.f49091c, true);
    }

    private void a(String str, ArrayList<String> arrayList, String str2) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "login_signup");
        hashMap.put("event_action", str);
        hashMap.put("event_value", str2);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, this.f49091c ? "/signup-otp" : "/login-otp");
        hashMap.put("VERTICAL_NAME".toLowerCase(), p.f56796a);
        if (arrayList.size() > 0) {
            Iterator<String> it2 = arrayList.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                String next = it2.next();
                if (i2 == 1) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(i2);
                }
                hashMap.put("event_label".concat(String.valueOf(str3)), next);
                i2++;
            }
        } else {
            hashMap.put("event_label", "");
        }
        q qVar = q.f56798a;
        hashMap.put("acquisition_source", q.g());
        q qVar2 = q.f56798a;
        hashMap.put("acquisition_medium", q.h());
        q qVar3 = q.f56798a;
        hashMap.put("acquisition_campaign", q.i());
        OauthModule.b().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, getApplicationContext());
    }

    public void onDestroy() {
        com.paytm.utility.g.f43805b = null;
        this.L = null;
        super.onDestroy();
    }

    static /* synthetic */ void h(AJRAuthActivity aJRAuthActivity) {
        boolean z;
        boolean z2 = aJRAuthActivity.f49091c;
        net.one97.paytm.oauth.a.a();
        if (z2) {
            z = net.one97.paytm.oauth.a.a("oauthEnableUpiOnboardingSignUp", true);
        } else {
            z = net.one97.paytm.oauth.a.a("oauthEnableUpiOnboarding", true);
        }
        if (z) {
            aJRAuthActivity.startActivityForResult(new Intent(aJRAuthActivity, SignUpAddBankActivity.class), 2001);
        } else {
            aJRAuthActivity.f();
        }
    }
}
