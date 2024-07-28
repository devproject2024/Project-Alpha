package net.one97.paytm.oauth.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import java.util.ArrayList;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.asynctask.EncryptedTokenWorker;
import net.one97.paytm.oauth.d;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.fragment.ProgressView;
import net.one97.paytm.oauth.fragment.aa;
import net.one97.paytm.oauth.fragment.ag;
import net.one97.paytm.oauth.fragment.ah;
import net.one97.paytm.oauth.fragment.ai;
import net.one97.paytm.oauth.fragment.ap;
import net.one97.paytm.oauth.fragment.aq;
import net.one97.paytm.oauth.fragment.ar;
import net.one97.paytm.oauth.g.g;
import net.one97.paytm.oauth.models.AuthorizationInitResModel;
import net.one97.paytm.oauth.models.AuthorizationResModel;
import net.one97.paytm.oauth.models.CJRAccessToken;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.TokenV3ResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.a.a;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.k;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.utils.v;

public class OAuthMainActivity extends OAuthBaseActivity implements View.OnClickListener, d, ap {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f52534a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f52535b;

    /* renamed from: c  reason: collision with root package name */
    private Guideline f52536c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f52537d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressView f52538e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f52539f;

    /* renamed from: g  reason: collision with root package name */
    private g f52540g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52541h = false;

    /* renamed from: i  reason: collision with root package name */
    private String f52542i;
    private boolean j = false;
    private Animation k;
    /* access modifiers changed from: private */
    public Animation l;
    private Handler m = new Handler();
    private boolean n;
    private String o = "";
    /* access modifiers changed from: private */
    public ConstraintLayout p;
    private boolean q;
    private v r = new v();
    private k s = new k();
    private TextView t;
    private String u;
    private i v;
    /* access modifiers changed from: private */
    public boolean w;
    private Runnable x = new Runnable() {
        public final void run() {
            if (OAuthMainActivity.this.p.isShown()) {
                OAuthMainActivity.this.p.startAnimation(OAuthMainActivity.this.l);
                OAuthMainActivity.this.p.setVisibility(8);
            }
        }
    };
    private BroadcastReceiver y = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("setLanguage", false)) {
                OAuthMainActivity.this.h();
                boolean unused = OAuthMainActivity.this.w = true;
            }
        }
    };

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            net.one97.paytm.oauth.g.b r6 = new net.one97.paytm.oauth.g.b
            android.app.Application r0 = r5.getApplication()
            r1 = 0
            java.lang.String[] r2 = new java.lang.String[r1]
            r6.<init>(r0, r2)
            androidx.lifecycle.al r6 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r5, (androidx.lifecycle.al.b) r6)
            java.lang.Class<net.one97.paytm.oauth.g.g> r0 = net.one97.paytm.oauth.g.g.class
            androidx.lifecycle.ai r6 = r6.a(r0)
            net.one97.paytm.oauth.g.g r6 = (net.one97.paytm.oauth.g.g) r6
            r5.f52540g = r6
            int r6 = net.one97.paytm.oauth.R.layout.activity_oauth_main
            r5.setContentView((int) r6)
            int r6 = net.one97.paytm.oauth.R.id.root
            android.view.View r6 = r5.findViewById(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r5.f52539f = r6
            android.content.Context r6 = r5.getApplicationContext()
            int r0 = net.one97.paytm.oauth.R.anim.slide_in_top
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r6, r0)
            r5.k = r6
            android.content.Context r6 = r5.getApplicationContext()
            int r0 = net.one97.paytm.oauth.R.anim.slide_out_top
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r6, r0)
            r5.l = r6
            net.one97.paytm.oauth.b r6 = net.one97.paytm.oauth.OauthModule.b()
            boolean r6 = r6.isPreviewCompleted()
            r0 = 1
            if (r6 != 0) goto L_0x0063
            r5.n = r0
            net.one97.paytm.oauth.b r6 = net.one97.paytm.oauth.OauthModule.b()
            r6.markPreviewCompleted()
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r2 = net.one97.paytm.oauth.utils.p.f56797b
            java.lang.String r3 = "/"
            r6.putExtra(r2, r3)
        L_0x0063:
            int r6 = net.one97.paytm.oauth.R.id.guideline
            android.view.View r6 = r5.findViewById(r6)
            androidx.constraintlayout.widget.Guideline r6 = (androidx.constraintlayout.widget.Guideline) r6
            r5.f52536c = r6
            int r6 = net.one97.paytm.oauth.R.id.top_backIcon
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r5.f52534a = r6
            int r6 = net.one97.paytm.oauth.R.id.imgMotif
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r5.f52535b = r6
            int r6 = net.one97.paytm.oauth.R.id.txtSkip
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.f52537d = r6
            int r6 = net.one97.paytm.oauth.R.id.tv_selected_language
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r5.t = r6
            int r6 = net.one97.paytm.oauth.R.id.layoutPwdSuccess
            android.view.View r6 = r5.findViewById(r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            r5.p = r6
            int r6 = net.one97.paytm.oauth.R.id.btnOk
            android.view.View r6 = r5.findViewById(r6)
            r6.setOnClickListener(r5)
            android.widget.ImageView r6 = r5.f52534a
            r6.setOnClickListener(r5)
            android.widget.TextView r6 = r5.f52537d
            r6.setOnClickListener(r5)
            android.widget.TextView r6 = r5.t
            r6.setOnClickListener(r5)
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r2 = "deep_link_name"
            java.lang.String r6 = r6.getStringExtra(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r4 = "FRAGMENT_LOGIN_MOBILE"
            if (r3 == 0) goto L_0x00cb
        L_0x00c9:
            r0 = 0
            goto L_0x00f4
        L_0x00cb:
            java.lang.String r3 = "createAccount"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x00d9
            android.os.Bundle r6 = android.os.Bundle.EMPTY
            r5.a((java.lang.String) r4, (android.os.Bundle) r6, (boolean) r1)
            goto L_0x00f4
        L_0x00d9:
            java.lang.String r3 = "loginMobile"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x00e9
            java.lang.String r3 = "loginEmail"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x00c9
        L_0x00e9:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r3.putString(r2, r6)
            r5.a((java.lang.String) r4, (android.os.Bundle) r3, (boolean) r1)
        L_0x00f4:
            if (r0 != 0) goto L_0x012f
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r0 = "screen_name"
            java.lang.String r6 = r6.getStringExtra(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x011a
            java.lang.String r0 = "FRAGMENT_ACCOUNT_CLAIM"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x012f
            android.content.Intent r6 = r5.getIntent()
            android.os.Bundle r6 = r6.getExtras()
            r5.a((java.lang.String) r0, (android.os.Bundle) r6, (boolean) r1)
            return
        L_0x011a:
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            android.content.Intent r0 = r5.getIntent()
            java.lang.String r2 = "login_mobile"
            java.lang.String r0 = r0.getStringExtra(r2)
            r6.putString(r2, r0)
            r5.a((java.lang.String) r4, (android.os.Bundle) r6, (boolean) r1)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.activity.OAuthMainActivity.onCreate(android.os.Bundle):void");
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.q = getIntent().getBooleanExtra("is_forgot_password", false);
        if (this.q) {
            this.p.setVisibility(0);
            Animation animation = this.k;
            if (animation != null) {
                this.p.startAnimation(animation);
            }
            this.m.postDelayed(this.x, 3000);
            return;
        }
        b(false);
    }

    public void onStart() {
        super.onStart();
        if (b.r((Context) this)) {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.w) {
            e();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("login", false)) {
            f();
        }
    }

    public final void b() {
        ProgressView progressView = this.f52538e;
        if (progressView != null) {
            progressView.setVisibility(8);
        }
    }

    public final void a(String str) {
        this.u = str;
    }

    public final void a(String str, String str2, boolean z, i iVar) {
        this.f52542i = str;
        this.j = z;
        this.v = iVar;
        g.a(str, str2).observe(this, new z() {
            public final void onChanged(Object obj) {
                OAuthMainActivity.this.b((e) obj);
            }
        });
    }

    public final void a(String str, boolean z, String str2, i iVar) {
        this.f52542i = str2;
        this.j = z;
        this.v = iVar;
        q qVar = q.f56798a;
        q.a(z);
        q qVar2 = q.f56798a;
        q.a(-1);
        q qVar3 = q.f56798a;
        String f2 = q.f();
        if (f2 == null || f2.isEmpty()) {
            q qVar4 = q.f56798a;
            a aVar = a.f56764a;
            q.a(a.a(this));
        }
        if (!TextUtils.isEmpty(str)) {
            if (!OAuthUtils.a((Context) this)) {
                getString(R.string.txt_verifying_details);
                a();
            }
            this.f52540g.a(str).observe(this, new z() {
                public final void onChanged(Object obj) {
                    OAuthMainActivity.this.c((e) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(e eVar) {
        if (eVar.f52602a == 101) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
            if (iJRPaytmDataModel instanceof CJRAccessToken) {
                this.o = ((CJRAccessToken) iJRPaytmDataModel).getAccessToken();
                q qVar = q.f56798a;
                q.f(this.o);
            } else if (iJRPaytmDataModel instanceof TokenV3ResModel) {
                this.o = l.a((TokenV3ResModel) iJRPaytmDataModel);
            }
            if (this.q) {
                OauthModule.b().sendGAMultipleLabelEvent(this, "forgot_password", "forgot_password_login_success", new ArrayList(), (String) null, "/signup", p.f56796a);
            }
            if (!TextUtils.isEmpty(this.o)) {
                b.n(this, this.f52542i);
                OauthModule.b().saveSSOToken(this.o);
                if (!TextUtils.isEmpty(this.u)) {
                    q qVar2 = q.f56798a;
                    q.c(this.u);
                }
                EncryptedTokenWorker.a aVar = EncryptedTokenWorker.f52567a;
                EncryptedTokenWorker.a.a();
                getWindow().getAttributes().windowAnimations = R.style.Fade;
                Intent intent = new Intent();
                intent.putExtra(StringSet.token, this.o);
                intent.putExtra("auth_flow", this.v);
                if (!TextUtils.isEmpty(this.f52542i)) {
                    intent.putExtra("login_mobile", this.f52542i);
                }
                intent.putExtra("is_new_signup", this.j);
                if (this.n) {
                    intent.putExtra("isUpiFlow", true);
                }
                setResult(-1, intent);
                finish();
                return;
            }
            g();
            b();
            b.b((Context) this, getString(R.string.oauth_error), getString(R.string.some_went_wrong));
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(e eVar) {
        if (eVar.f52602a == 101) {
            AuthorizationInitResModel authorizationInitResModel = (AuthorizationInitResModel) eVar.f52603b;
            if ("BE1400001".equals(authorizationInitResModel.getResponseCode())) {
                g.b(authorizationInitResModel.getData().getAuthenticationValueType(), authorizationInitResModel.getData().getStateToken()).observe(this, new z() {
                    public final void onChanged(Object obj) {
                        OAuthMainActivity.this.a((e) obj);
                    }
                });
                return;
            }
            g();
            net.one97.paytm.oauth.d.a.a((Context) this, authorizationInitResModel.getMessage(), (View.OnClickListener) null);
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(e eVar) {
        if (eVar.f52602a == 101) {
            g();
            AuthorizationResModel authorizationResModel = (AuthorizationResModel) eVar.f52603b;
            if ("BE1400001".equals(authorizationResModel.getResponseCode())) {
                a(authorizationResModel.getData().getCode(), this.j, this.f52542i, this.v);
            } else {
                net.one97.paytm.oauth.d.a.a((Context) this, authorizationResModel.getMessage(), (View.OnClickListener) null);
            }
        } else if (eVar.f52602a == 102) {
            a((ErrorModel) eVar.f52603b);
        }
    }

    private void a(ErrorModel errorModel) {
        b();
        NetworkCustomError customError = errorModel.getCustomError();
        g();
        if (!OAuthUtils.a((Activity) this, (Fragment) null, customError)) {
            net.one97.paytm.oauth.d.a.a((Context) this, getString(R.string.some_went_wrong), (View.OnClickListener) null);
        }
    }

    public final void a(String str, Bundle bundle, boolean z) {
        Fragment fragment;
        String str2 = "";
        if (bundle != null) {
            if (!TextUtils.isEmpty(bundle.getString("login_mobile"))) {
                this.f52542i = bundle.getString("login_mobile");
            }
            if (!TextUtils.isEmpty(bundle.getString(BaseDialogFragment.ERROR_MESSAGE))) {
                b.b((Context) this, (String) null, bundle.getString(BaseDialogFragment.ERROR_MESSAGE));
                bundle.putString(BaseDialogFragment.ERROR_MESSAGE, str2);
            }
            str2 = bundle.getString(p.f56797b, str2);
        }
        if ("FRAGMENT_LOGIN_MOBILE".equals(str)) {
            d();
        } else {
            this.f52534a.setVisibility(0);
            a(false);
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2127973353:
                if (str.equals("FRAGMENT_DEVICE_BINDING_OTP")) {
                    c2 = 4;
                    break;
                }
                break;
            case -2094641177:
                if (str.equals("FRAGMENT_LOGIN_MOBILE")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1015891808:
                if (str.equals("FRAGMENT_LOGIN_PASSWORD")) {
                    c2 = 2;
                    break;
                }
                break;
            case -526116523:
                if (str.equals("FRAGMENT_OTP_ENTER")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1634206651:
                if (str.equals("FRAGMENT_ACCOUNT_CLAIM")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            if (!TextUtils.isEmpty(str2)) {
                getIntent().putExtra(p.f56797b, str2);
            }
            f();
            Fragment c3 = getSupportFragmentManager().c("FRAGMENT_LOGIN_MOBILE");
            if (!(c3 instanceof aq) || !c3.isVisible()) {
                aq.a aVar = aq.f56353b;
                fragment = aq.a.a(bundle);
            } else {
                return;
            }
        } else if (c2 == 1) {
            fragment = ai.a(bundle);
        } else if (c2 == 2) {
            ag.a aVar2 = ag.f56310d;
            fragment = ag.a.a(bundle);
        } else if (c2 == 3) {
            fragment = ah.a(bundle);
        } else if (c2 == 4) {
            this.f52536c.setGuidelinePercent(0.05f);
            this.f52535b.setVisibility(8);
            fragment = aa.a(bundle);
        } else {
            throw new IllegalArgumentException("Unknown fragment code ");
        }
        a(fragment, str, z);
    }

    private void a(Fragment fragment, String str, boolean z) {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        a2.a(R.animator.slide_in_left, R.animator.slide_out_right, 0, 0);
        a2.i();
        a2.b(R.id.fragment_container, fragment, str);
        if (z) {
            a2.a("login_singup");
        }
        a2.c();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.top_backIcon) {
            onBackPressed();
        } else if (view.getId() == R.id.txtSkip) {
            if (this.f52537d.getText().toString().equals(getString(R.string.oauth_deny))) {
                this.r.a(Boolean.TRUE);
                return;
            }
            OauthModule.b().sendGAMultipleLabelEvent(getApplicationContext(), "login_signup", "skip_button_clicked", (ArrayList<String>) null, (String) null, "/login-signup", p.f56796a);
            finish();
        } else if (view.getId() == R.id.tv_selected_language) {
            OauthModule.b().sendGAMultipleLabelEvent(getApplicationContext(), "login_signup", "change_lang_clicked", (ArrayList<String>) null, (String) null, "/login-signup", p.f56796a);
            net.one97.paytm.oauth.a.a();
            if (net.one97.paytm.oauth.a.a("oauthEnableH5ChangeLanguage", true)) {
                androidx.localbroadcastmanager.a.a.a((Context) this).a(this.y, new IntentFilter("net.paytm.one97.action.REFRESH_LOGIN"));
                OauthModule.b().checkDeepLinking(this, "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MvcHJlZmVycmVkLWxhbmd1YWdlIiwic3BhcmFtcyI6eyJjYW5QdWxsRG93biI6ZmFsc2UsInB1bGxSZWZyZXNoIjpmYWxzZSwic2hvd1RpdGxlQmFyIjpmYWxzZX19&url=https://paytm.com");
                return;
            }
            OauthModule.b().openChooseLaguageScreen(this, 1092);
        } else if (view.getId() == R.id.btnOk) {
            this.p.setVisibility(8);
        }
    }

    public void onStop() {
        super.onStop();
        OAuthUtils.a((Activity) this);
        b(true);
    }

    public void onDestroy() {
        h();
        super.onDestroy();
    }

    public void onBackPressed() {
        ProgressView progressView = this.f52538e;
        if (progressView == null || !progressView.isShown()) {
            ArrayList arrayList = new ArrayList();
            String str = "login";
            if (getSupportFragmentManager().f3424a.d().size() > 0) {
                if (getSupportFragmentManager().f3424a.d().get(0) instanceof ai) {
                    if (((ai) getSupportFragmentManager().f3424a.d().get(0)).d()) {
                        str = "signup";
                    }
                    arrayList.add("otp");
                } else if (getSupportFragmentManager().f3424a.d().get(0) instanceof aq) {
                    arrayList.add(str);
                } else if (getSupportFragmentManager().f3424a.d().get(0) instanceof ag) {
                    arrayList.add("password");
                }
            }
            OauthModule.b().sendGAMultipleLabelEvent(getApplicationContext(), str, "back_button_clicked", arrayList, (String) null, (String) null, p.f56796a);
            if (getSupportFragmentManager().f() > 0) {
                d();
                f();
                return;
            }
            finish();
        } else if (this.f52541h) {
            b();
        }
    }

    public final void b(TextView textView) {
        a(textView);
    }

    private void d() {
        this.f52536c.setGuidelinePercent(0.1f);
        this.f52534a.setVisibility(8);
        this.f52535b.setVisibility(0);
        a(true);
    }

    private void a(boolean z) {
        int i2 = 0;
        this.f52537d.setVisibility(z ? 0 : 8);
        TextView textView = this.t;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            Fragment c2 = getSupportFragmentManager().c("FRAGMENT_LOGIN_MOBILE");
            if ((c2 instanceof aq) && c2.isVisible()) {
                c2.onActivityResult(i2, i3, intent);
                return;
            }
        }
        if (i3 != -1) {
            return;
        }
        if (i2 == 1092) {
            e();
        } else if (i2 == 1093) {
            if (intent != null) {
                getIntent().putExtra(p.f56797b, intent.getStringExtra(p.f56797b));
            }
            f();
        }
    }

    private void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.c(this, n.a((Context) this, n.a())));
        OauthModule.b().sendGAMultipleLabelEvent(getApplicationContext(), "login_signup", "language_updated", arrayList, (String) null, "/login-signup", p.f56796a);
        recreate();
    }

    public final k c() {
        return this.s;
    }

    private void b(boolean z) {
        if (z) {
            this.m.removeCallbacksAndMessages((Object) null);
        }
        this.p.setVisibility(8);
    }

    private void f() {
        try {
            getSupportFragmentManager().a("login_singup", 1);
        } catch (IllegalStateException e2) {
            com.paytm.utility.q.b(e2.getLocalizedMessage());
        }
    }

    private void g() {
        Fragment c2 = getSupportFragmentManager().c(ar.class.getName());
        new StringBuilder().append(c2);
        if (c2 instanceof ar) {
            ((ar) c2).dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            androidx.localbroadcastmanager.a.a.a((Context) this).a(this.y);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        this.f52541h = false;
        if (this.f52538e == null) {
            this.f52538e = (ProgressView) LayoutInflater.from(this).inflate(R.layout.progress_view, this.f52539f, false);
            this.f52539f.addView(this.f52538e, new RelativeLayout.LayoutParams(-1, -1));
            this.f52538e.setAlpha(1.0f);
        }
        this.f52538e.setVisibility(0);
    }
}
