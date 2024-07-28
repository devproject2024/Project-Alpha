package net.one97.paytm.landingpage.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.m;
import androidx.lifecycle.am;
import androidx.lifecycle.k;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.perf.metrics.Trace;
import com.paytm.c.b;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.i;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.signal.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel;
import com.paytmmall.clpartifact.view.fragment.SFHomeFragment;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import com.paytmmall.clpartifact.widgets.providers.MenuWidgetProvider;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import io.reactivex.rxjava3.a.p;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.b.e;
import net.one97.paytm.common.entity.CJRContingency;
import net.one97.paytm.common.entity.CJRFlyoutCatalog;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.auth.KYCStatusV2;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.offline.OfflineLeadOTPModel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.paymentsbank.AccountStatus;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.wallet.VerifyProfileCardResponse;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.activity.HomeLifecycleObserver;
import net.one97.paytm.landingpage.c.g;
import net.one97.paytm.landingpage.c.h;
import net.one97.paytm.landingpage.fragment.BottomSheetPostpaidInterstitialFragment;
import net.one97.paytm.landingpage.fragment.FJRProfileVerifyBottomsheet;
import net.one97.paytm.landingpage.fragment.PostpaidLimitIncreaseBottomSheetFragment;
import net.one97.paytm.landingpage.leftNavigation.c;
import net.one97.paytm.landingpage.utils.bankutil.ValidatePasscode;
import net.one97.paytm.landingpage.utils.d;
import net.one97.paytm.landingpage.utils.f;
import net.one97.paytm.landingpage.utils.l;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.t;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.PendingRequestsV2;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.paytmhome.UpiHomeQREducation;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.upi.requestmoney.view.UpiRequestMoneyPagerActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ao;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.s;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class AJRMainActivity extends HomeBaseActivity implements HomeLifecycleObserver.a, net.one97.paytm.landingpage.c.c, g {
    private static boolean aa = false;
    private d A;
    private net.one97.paytm.landingpage.e.b B;
    private Context C;
    private Handler D = new Handler();
    private boolean E = false;
    /* access modifiers changed from: private */
    public boolean F = false;
    private FrameLayout G;
    private boolean H;
    private io.reactivex.rxjava3.b.b I = new io.reactivex.rxjava3.b.b();
    /* access modifiers changed from: private */
    public SharedHomeVM J;
    private net.one97.paytm.landingpage.f.a K = new net.one97.paytm.landingpage.f.a();
    private int L = 0;
    private boolean M = false;
    private int N = 0;
    /* access modifiers changed from: private */
    public net.one97.paytm.landingpage.leftNavigation.g O;
    /* access modifiers changed from: private */
    public boolean P = false;
    private Bundle Q = null;
    private HomeLifecycleObserver R;
    private boolean S = false;
    private boolean T = false;
    private View U;
    private boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private Trace Y;
    private Trace Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52663a = true;
    private Intent ab = null;
    /* access modifiers changed from: private */
    public h ac = new h() {
        public final void dismiss() {
            try {
                if (AJRMainActivity.this.u != null && AJRMainActivity.this.u.isPostpaidPopupShown()) {
                    if (AJRMainActivity.this.u.isAdded() && AJRMainActivity.this.u.isVisible()) {
                        AJRMainActivity.this.u.dismiss();
                    }
                    com.paytm.b.a.a a2 = ag.a(AJRMainActivity.this.getApplicationContext());
                    a2.a("postpaid_popup_display_count", a2.b("postpaid_popup_display_count", 0, true) - 1, true);
                    AJRMainActivity.this.u.setPostpaidPopupShown(false);
                }
            } catch (Exception unused) {
            }
        }
    };
    private BroadcastReceiver ad = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                if (intent.getAction().equalsIgnoreCase("action_update_login_status")) {
                    if (AJRMainActivity.this.f52708d != null) {
                        AJRMainActivity.this.f52708d.d(8388611);
                    }
                } else if (intent.getAction().equalsIgnoreCase("af_non_deferred_login_broadcast_event")) {
                    AJRMainActivity.a((Activity) AJRMainActivity.this, intent.getStringExtra("referral_unique_link"));
                } else if (intent.getAction().equalsIgnoreCase("af_login_time_out_broadcast_event")) {
                    String stringExtra = intent.getStringExtra("referral_unique_link");
                    Bundle bundle = new Bundle();
                    bundle.putString("referral_unique_link", stringExtra);
                    AJRMainActivity aJRMainActivity = AJRMainActivity.this;
                    new f();
                    r.a(aJRMainActivity, (String) null, bundle, false, true);
                }
            }
        }
    };
    private BroadcastReceiver ae = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction() == "SEND_REMOTE_CONFIG_LOADED_MESSAGE" && !AJRMainActivity.this.isDestroyed()) {
                AJRMainActivity.b(AJRMainActivity.this);
                AJRMainActivity.this.l();
            }
        }
    };
    private BroadcastReceiver af = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("email_updated") && !AJRMainActivity.this.isDestroyed()) {
                AJRMainActivity.this.O.f52856c.setValue(Boolean.TRUE);
            }
        }
    };
    private BroadcastReceiver ag = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AJRMainActivity.this.J.setActionImage();
            AJRMainActivity.this.O.f52855b.setValue(Boolean.TRUE);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f52664b;

    /* renamed from: c  reason: collision with root package name */
    public l f52665c = null;
    private int s;
    private CJRHomePageItem t;
    /* access modifiers changed from: private */
    public volatile BottomSheetPostpaidInterstitialFragment u;
    private String v = AJRMainActivity.class.getSimpleName();
    private String w = this.v;
    private String x;
    private boolean y;
    private boolean z = false;

    public void setCartMenuViewClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        Trace a2 = com.google.firebase.perf.a.a("AJRMainActivity_onCreate");
        this.V = false;
        this.Q = bundle;
        if (getIntent() != null && getIntent().hasExtra("EXTRA_IS_FROM_LANGUAGE_CHANGE")) {
            this.X = getIntent().getBooleanExtra("EXTRA_IS_FROM_LANGUAGE_CHANGE", false);
            getIntent().removeExtra("EXTRA_IS_FROM_LANGUAGE_CHANGE");
        }
        setTheme(R.style.JarvisAJRMainActivity);
        new net.one97.paytm.landingpage.b().a(getApplicationContext());
        new net.one97.paytm.landingpage.leftNavigation.c();
        Context applicationContext = getApplicationContext();
        k.c(applicationContext, "context");
        net.one97.paytm.landingpage.leftNavigation.b bVar = net.one97.paytm.landingpage.leftNavigation.b.f52831a;
        if (net.one97.paytm.landingpage.leftNavigation.b.a() == null) {
            AsyncTask.SERIAL_EXECUTOR.execute(new c.a(applicationContext));
        }
        super.onCreate(bundle);
        Drawable r = net.one97.paytm.common.b.d.b().r();
        if (r == null) {
            this.f52708d.setBackgroundResource(R.drawable.background_splash);
        } else {
            this.f52708d.setBackground(r);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("SEND_REMOTE_CONFIG_LOADED_MESSAGE");
        androidx.localbroadcastmanager.a.a.a(this.C).a(this.ae, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("email_updated");
        androidx.localbroadcastmanager.a.a.a(this.C).a(this.af, intentFilter2);
        this.A = new d(getApplicationContext());
        this.B = new net.one97.paytm.landingpage.e.b(this, this.A);
        if (this.V || bundle != null || this.X) {
            this.V = true;
            j();
        }
        if (net.one97.paytm.common.b.d.b().a("upi_enabled", false)) {
            q.d("showWarningForRootedDevice start" + System.currentTimeMillis());
            com.paytm.c.b.a(getApplicationContext(), net.one97.paytm.common.b.d.b().m(), new b.a() {
                public final void a(boolean z) {
                    if (z) {
                        AJRMainActivity.m(AJRMainActivity.this);
                    }
                    q.d("Rooted Status Callback -> ".concat(String.valueOf(z)));
                    AJRMainActivity aJRMainActivity = AJRMainActivity.this;
                    HashMap hashMap = new HashMap();
                    hashMap.put("uninst_lib_root_status", Boolean.valueOf(z));
                    net.one97.paytm.common.b.d.b().b("uninst_lib_root_status", hashMap, aJRMainActivity);
                }

                public final void a() {
                    q.d("playServicesNotUpdated");
                }

                public final void a(Exception exc) {
                    q.d(exc.getMessage());
                }
            });
            q.d("showWarningForRootedDevice end " + System.currentTimeMillis());
        }
        a2.stop();
    }

    private void j() {
        this.C = getApplicationContext();
        this.R = new HomeLifecycleObserver(this);
        getLifecycle().a(this.R);
        net.one97.paytm.common.b.d.b().a((Activity) this, getIntent());
        M();
        if (net.one97.paytm.common.b.d.b().b() && !this.S) {
            this.S = true;
            this.R.a();
        }
        G();
        AsyncTask.SERIAL_EXECUTOR.execute(new c(this, (byte) 0));
        q();
        k();
        this.x = n.a(this.C, n.a());
        if (getIntent() != null && (getIntent().hasExtra("extra_open_chat_feed_tab") || getIntent().hasExtra("extra_open_game_feed_tab"))) {
            if (getIntent().hasExtra("extra_home_data")) {
                this.t = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
            }
            b();
        }
        try {
            if (getIntent() != null && !getIntent().getBooleanExtra("wasLaunchedFromRecent", false)) {
                this.t = (CJRHomePageItem) getIntent().getSerializableExtra("deep_linking_data");
                if (this.t != null && this.t.mUrlType != null && net.one97.paytm.common.b.d.b().b(this.t.mUrlType)) {
                    b();
                } else if (getIntent().getStringExtra("deepLinkUrl") != null && net.one97.paytm.common.b.d.b().b(getIntent().getStringExtra("deepLinkUrl"))) {
                    b();
                } else if (getIntent().getBundleExtra("notificationBundle") != null && getIntent().getBundleExtra("notificationBundle").getString("deepLinkUrl", "").equalsIgnoreCase("chat")) {
                    b();
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        if (getIntent() != null && !getIntent().getBooleanExtra("wasLaunchedFromRecent", false) && getIntent().getStringExtra("deepLinkUrl") != null && getIntent().getStringExtra("deepLinkUrl").equalsIgnoreCase(Utility.VERTICAL_NAME_MALL)) {
            m();
        }
        this.J = (SharedHomeVM) am.a((FragmentActivity) this).a(SharedHomeVM.class);
        this.J.getParentActionLiveData().observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRMainActivity.this.a((HomeParentActionModel) obj);
            }
        });
        this.J.setActionImage();
        this.M = true;
        this.O = (net.one97.paytm.landingpage.leftNavigation.g) am.a((FragmentActivity) this).a(net.one97.paytm.landingpage.leftNavigation.g.class);
        this.O.f52854a.observe(this, $$Lambda$AJRMainActivity$RsT01XUqP09zYBl166HQtzX9QiI.INSTANCE);
        this.O.f52855b.observe(this, $$Lambda$AJRMainActivity$YBpsshd9P4nb1pzUKzwOcUEIsc.INSTANCE);
        this.O.f52856c.observe(this, $$Lambda$AJRMainActivity$MOYzLohExjjQDMHEz6N1tmFBe2I.INSTANCE);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_update_login_status");
        intentFilter.addAction("af_non_deferred_login_broadcast_event");
        intentFilter.addAction("af_login_time_out_broadcast_event");
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.ad, intentFilter);
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.ag, new IntentFilter(CLPConstants.ACTION_UPDATE_PROFILE_PIC_FLYOUT));
        this.J.isScanBtnVisible().observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRMainActivity.this.b((Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(Boolean bool) {
        if (bool.booleanValue()) {
            SFInterface.INSTANCE.notifySuccessTransaction("");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(Boolean bool) {
        if (bool.booleanValue()) {
            SFInterface.INSTANCE.notifySuccessTransaction("");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Boolean bool) {
        if (bool.booleanValue()) {
            SFInterface.INSTANCE.notifySuccessTransaction("");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        if (bool.booleanValue()) {
            this.J.isScanBtnVisible().removeObservers(this);
            if (net.one97.paytm.common.b.d.b().z()) {
                net.one97.paytm.common.b.d.b().B();
                net.one97.paytm.common.b.d.a().G();
                net.one97.paytm.common.b.d.a().W();
                net.one97.paytm.common.b.d.a().X();
                net.one97.paytm.common.b.d.a().I(getApplicationContext());
            }
            if (net.one97.paytm.common.b.d.a() != null) {
                net.one97.paytm.common.b.d.a().a((Context) this, (kotlin.g.a.b<y<Integer>, x>) new kotlin.g.a.b() {
                    public final Object invoke(Object obj) {
                        return AJRMainActivity.this.a((y) obj);
                    }
                });
            }
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
                public final void run() {
                    SFGsonUtils.INSTANCE.getPojo("{}", CJRHomePageItem.class, false);
                }
            });
        }
    }

    private static String a(Context context) {
        if (com.paytm.utility.a.q(context) != null) {
            return com.paytm.utility.a.a(context);
        }
        return com.paytm.utility.a.d(context);
    }

    private void k() {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(-1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (net.one97.paytm.common.b.d.b().b() && this.T) {
            net.one97.paytm.common.b.d.a().K();
            net.one97.paytm.common.b.d.a().L();
            net.one97.paytm.common.b.d.a().M();
        }
    }

    private void m() {
        net.one97.paytm.common.b.d.b().a((Context) this, n());
    }

    private static String n() {
        return net.one97.paytm.common.b.d.b().j() + "homepage_secondary?url=" + net.one97.paytm.common.b.d.b().a("mall_homepage");
    }

    /* access modifiers changed from: private */
    public void a(HomeParentActionModel homeParentActionModel) {
        if (homeParentActionModel.getActionType() == 1001) {
            Map<String, String> a2 = a(homeParentActionModel.getActionData().get(CLPConstants.CATEGORY_URL_MAP));
            Map<String, String> a3 = a(homeParentActionModel.getActionData().get(CLPConstants.CATEGORY_URLTYPE_MAP));
            HomeBaseActivity.q.putAll(a2);
            HomeBaseActivity.r.putAll(a3);
            return;
        }
        String str = "";
        if (homeParentActionModel.getActionType() == 1007) {
            if (!(homeParentActionModel.getActionData() == null || homeParentActionModel.getActionData().get("action") == null)) {
                str = homeParentActionModel.getActionData().get("action").toString();
            }
            if (TextUtils.isEmpty(str)) {
                str = CLPConstants.ACTION_SEARCH_CLICKED;
            }
            net.one97.paytm.landingpage.utils.g.a(this, "top_nav", str, "top_nav");
            Intent i2 = net.one97.paytm.common.b.d.a().i((Activity) this);
            i2.putExtra("isMall", false);
            i2.putExtra("from", "top_nav");
            startActivity(i2);
            overridePendingTransition(R.anim.slide_in_down_anim, R.anim.slide_out_down_anim);
        } else if (homeParentActionModel.getActionType() == 1005) {
            k.c(this, "activity");
            net.one97.paytm.common.b.d.b().b((AppCompatActivity) this);
        } else if (homeParentActionModel.getActionType() == 1016) {
            Object obj = homeParentActionModel.getActionData().get(CLPConstants.NON_RV_WIDGETS);
            if (obj instanceof MenuWidgetProvider) {
                this.K.f52773a = (MenuWidgetProvider) obj;
            }
        } else if (homeParentActionModel.getActionType() == 1006) {
            net.one97.paytm.landingpage.f.a.b();
            f();
            net.one97.paytm.p2mNewDesign.models.b.c().a("Scan Any QR");
            net.one97.paytm.common.b.d.b().a((Context) this, "paytmmp://pay-scanqr");
            net.one97.paytm.landingpage.utils.g.a(this, "floating_nav_home", CJRGTMConstants.MT_V4_SCAN_UPI_QR_CLICKED, "/");
        } else if (homeParentActionModel.getActionType() == 1008) {
            this.P = true;
            net.one97.paytm.landingpage.utils.g.a(this, "top_nav", "update_section_clicked", "top_nav");
            b();
        } else if (homeParentActionModel.getActionType() == 1004) {
            net.one97.paytm.landingpage.utils.g.a(this, "top_nav", "hamburger_clicked", "/");
            if (this.f52708d != null && !this.f52708d.e(8388611)) {
                this.f52708d.c(8388611);
            }
        } else if (homeParentActionModel.getActionType() == 1009) {
            String a4 = s.a(this.C);
            if (TextUtils.isEmpty(a4)) {
                if (net.one97.paytm.common.b.d.b().k(this.C)) {
                    net.one97.paytm.common.b.d.b().a(this.C, (net.one97.paytm.landingpage.c.b) new net.one97.paytm.landingpage.c.b() {
                        public final void a(String str) {
                            AJRMainActivity.this.J.setUserGreeting(str, true);
                        }

                        public final void b(String str) {
                            q.b("No UserName: ".concat(String.valueOf(str)));
                            AJRMainActivity.this.J.setUserGreeting("", true);
                        }
                    });
                } else {
                    this.J.setUserGreeting(str, true);
                }
                if (!com.paytm.utility.b.c(this.C)) {
                    this.J.setUserGreeting(str, true);
                    return;
                }
                return;
            }
            this.J.setUserGreeting(a4, true);
        }
    }

    private static Map<String, String> a(Object obj) {
        try {
            if (obj instanceof Map) {
                return (Map) obj;
            }
        } catch (ClassCastException unused) {
        }
        return new HashMap();
    }

    private boolean a(Intent intent) {
        Intent c2 = net.one97.paytm.common.b.d.b().c(this, intent);
        if (c2 != null) {
            setIntent(c2);
        }
        return b(intent);
    }

    private boolean b(Intent intent) {
        Uri parse;
        if (intent != null && !intent.getBooleanExtra("wasLaunchedFromRecent", false) && !isFinishing()) {
            boolean booleanExtra = intent.getBooleanExtra("isFromNotification", false);
            String stringExtra = intent.getStringExtra("urlToCheck");
            if (booleanExtra) {
                if (getIntent().getExtras() == null || intent.getExtras().getBundle("notificationBundle") == null) {
                    return false;
                }
                Bundle bundle = intent.getExtras().getBundle("notificationBundle");
                bundle.putBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
                return net.one97.paytm.common.b.d.b().a((Context) this, bundle.getString("url"), bundle);
            } else if (TextUtils.isEmpty(stringExtra) || stringExtra.contains("af_dp") || stringExtra.contains("af_web_id") || (parse = Uri.parse(stringExtra.replace('$', '&'))) == null) {
                return false;
            } else {
                if (parse.getHost() != null && a(parse.getHost()) && parse.getHost().equalsIgnoreCase(Utility.VERTICAL_NAME_MALL) && parse.toString().indexOf(Utility.VERTICAL_NAME_MALL) != -1) {
                    parse = Uri.parse(parse.toString().replaceFirst(Utility.VERTICAL_NAME_MALL, "homepage_secondary"));
                    parse.buildUpon().appendQueryParameter("url", net.one97.paytm.common.b.d.b().a("mall_homepage"));
                }
                String queryParameter = parse.getQueryParameter("url");
                if (!TextUtils.isEmpty(queryParameter) && !net.one97.paytm.common.b.d.b().c(queryParameter)) {
                    return false;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
                return net.one97.paytm.common.b.d.b().a((Context) this, stringExtra, bundle2);
            }
        }
        return false;
    }

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.equalsIgnoreCase(Utility.VERTICAL_NAME_MALL) || str.equalsIgnoreCase("updates") || str.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean o() {
        com.paytm.b.a.a a2 = ag.a(getApplicationContext());
        boolean b2 = a2.b("Install_Referrer", false, true);
        if (b2) {
            a2.a("Install_Referrer", false, true);
        }
        return !b2 && !net.one97.paytm.common.b.d.b().w() && !com.paytm.utility.a.p(getApplicationContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void O() {
        this.I.a(p.fromCallable(new Callable() {
            public final Object call() {
                return Boolean.valueOf(AJRMainActivity.this.o());
            }
        }).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new io.reactivex.rxjava3.d.g() {
            public final void accept(Object obj) {
                AJRMainActivity.this.a((Boolean) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) throws Throwable {
        if (bool.booleanValue()) {
            net.one97.paytm.common.b.d.a().a((Activity) this);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("IS_LANGUAGE_CHANGE", true);
        bundle.putInt("tab_position", this.s);
        super.onSaveInstanceState(bundle);
    }

    private void q() {
        this.U = net.one97.paytm.common.b.d.b().p();
        this.n.addView(this.U);
        net.one97.paytm.common.b.d.b().q();
        this.f52709e = (ProgressBar) findViewById(R.id.item_loading_progressbar);
        this.G = (FrameLayout) findViewById(R.id.frame_homepage_loading);
        d(true);
    }

    private void d(boolean z2) {
        try {
            B();
            this.f52663a = true;
            e(z2);
            c(getIntent());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        if (this.f52708d == null) {
            return;
        }
        if (this.f52664b.getCurrentItem() == 1) {
            this.f52708d.setDrawerLockMode(1, 8388611);
        } else {
            this.f52708d.setDrawerLockMode(0, 8388611);
        }
    }

    private void r() {
        getIntent().removeExtra("urlToCheck");
        getIntent().putExtra("EXTRA_IS_FROM_LANGUAGE_CHANGE", true);
        getIntent().setData((Uri) null);
        net.one97.paytm.common.b.d.b().h(this);
        runOnUiThread(new Runnable() {
            public final void run() {
                AJRMainActivity.this.i();
                AJRMainActivity.this.finish();
                AJRMainActivity aJRMainActivity = AJRMainActivity.this;
                aJRMainActivity.startActivity(aJRMainActivity.getIntent());
                AJRMainActivity.this.overridePendingTransition(0, 0);
            }
        });
    }

    public final void a() {
        d(false);
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(AJRMainActivity aJRMainActivity, byte b2) {
            this();
        }

        public final void run() {
            AJRMainActivity.f(AJRMainActivity.this);
            AJRMainActivity.g(AJRMainActivity.this);
            AJRMainActivity.h(AJRMainActivity.this);
            if (!AJRMainActivity.this.isFinishing() && a.b(AJRMainActivity.this.getApplicationContext()) > 0) {
                a.a(AJRMainActivity.this.getApplicationContext(), AJRMainActivity.this.ac);
            }
        }
    }

    public void onResume() {
        if (this.V) {
            s();
        }
        super.onResume();
    }

    private void s() {
        this.z = true;
        AsyncTask.SERIAL_EXECUTOR.execute(new a(this, (byte) 0));
        if (this.f52709e != null) {
            this.f52709e.setVisibility(8);
        }
        t();
        if (!isFinishing()) {
            net.one97.paytm.common.b.d.b().a((Context) this, getSupportFragmentManager());
        }
        if (this.M) {
            this.M = false;
            SharedHomeVM sharedHomeVM = this.J;
            if (sharedHomeVM != null) {
                sharedHomeVM.setNotificationData(this.N);
            }
        }
        this.K.a();
    }

    private void t() {
        ag.a(getApplicationContext());
    }

    public void onPause() {
        this.z = false;
        super.onPause();
        com.paytm.utility.a.k();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (x()) {
            this.ab = intent;
        }
        if (isFinishing()) {
            startActivity(intent);
            return;
        }
        Intent c2 = net.one97.paytm.common.b.d.b().c(this, intent);
        if (c2 != null) {
            setIntent(c2);
        }
        if (intent == null || !intent.getBooleanExtra("open_hamburger", false)) {
            if (intent != null && "OPEN_DRAWER".equals(intent.getStringExtra("ACTION")) && this.f52708d != null && !this.f52708d.e(8388611)) {
                this.f52708d.c(8388611);
            }
            this.t = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data");
            if (intent != null && intent.hasExtra("open_mall_tab")) {
                m();
            }
            if (intent == null || !intent.hasExtra("open_bank_tab")) {
                if (intent == null || !intent.hasExtra("open_mall_tab")) {
                    if (intent != null && (intent.hasExtra("extra_open_game_feed_tab") || intent.hasExtra("extra_open_chat_feed_tab"))) {
                        b();
                    } else if (intent != null && intent.hasExtra("fromInboxGames")) {
                        net.one97.paytm.common.b.d.a();
                    }
                } else if (intent.getBooleanExtra("open_mall_tab", false)) {
                    m();
                }
            } else if (intent.getBooleanExtra("open_bank_tab", false)) {
                u();
            }
            if ((intent.getFlags() & 67108864) == 0 && this.f52708d != null && !intent.hasCategory("android.intent.category.LAUNCHER")) {
                this.f52708d.d(8388611);
            }
            c(intent);
            if (intent.getBooleanExtra("is_deep_linking_data", false)) {
                this.B.a();
            }
            b(intent);
            try {
                if (getIntent() != null && !getIntent().getBooleanExtra("wasLaunchedFromRecent", false)) {
                    this.t = (CJRHomePageItem) getIntent().getSerializableExtra("deep_linking_data");
                    if (this.t != null && this.t.mUrlType != null && net.one97.paytm.common.b.d.b().b(this.t.mUrlType)) {
                        b();
                    } else if (getIntent().getStringExtra("deepLinkUrl") != null && net.one97.paytm.common.b.d.b().b(getIntent().getStringExtra("deepLinkUrl"))) {
                        b();
                    }
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        } else if (this.f52708d != null && !this.f52708d.e(8388611)) {
            this.f52708d.c(8388611);
        }
    }

    private void u() {
        net.one97.paytm.common.b.d.b().a((Context) this, "paytmmp://payment_bank?featuretype=bank_landing");
    }

    public final void b() {
        ViewPager viewPager = this.f52664b;
        if (viewPager != null && viewPager.getAdapter() != null && this.f52664b.getAdapter().getCount() > 1) {
            this.f52664b.setCurrentItem(1, true);
        }
    }

    private void c(Intent intent) {
        if (intent != null) {
            this.B.a(intent);
            if (intent.hasExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE)) {
                intent.getStringExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE);
                com.paytm.utility.a.c();
            }
            if (intent.getBooleanExtra("started_activity_from_recharge", false) && intent.hasExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE)) {
                String stringExtra = intent.getStringExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE);
                com.paytm.utility.a.c();
                b(stringExtra);
            }
        }
    }

    private void b(String str) {
        if (str.equalsIgnoreCase("scan")) {
            D();
        } else if (str.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
            E();
        } else if (!Utility.VERTICAL_NAME_MALL.equalsIgnoreCase(str) && "updates".equalsIgnoreCase(str)) {
            b();
        }
    }

    private void v() {
        View findViewById = findViewById(R.id.bank_pop_up);
        findViewById.setAnimation((Animation) null);
        findViewById.setVisibility(8);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null && !isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
                this.B.f52760g = false;
                CJRFrequentOrderList cJRFrequentOrderList = (CJRFrequentOrderList) iJRPaytmDataModel;
                new net.one97.paytm.landingpage.utils.c(this, (t) null, cJRFrequentOrderList, "frequent_order_list").execute(new Void[0]);
                this.B.f52760g = true;
                net.one97.paytm.common.b.d.a().a(cJRFrequentOrderList);
            } else if (iJRPaytmDataModel instanceof CJRFlyoutCatalog) {
                this.f52711g = ((CJRFlyoutCatalog) iJRPaytmDataModel).getFlyoutCatalog();
                ArrayList<CJRCatalogItem> allCatalogList = this.f52711g.getAllCatalogList();
                if (allCatalogList != null && allCatalogList.size() > 0) {
                    allCatalogList.trimToSize();
                    Iterator<CJRCatalogItem> it2 = allCatalogList.iterator();
                    while (it2.hasNext()) {
                        ArrayList<CJRCatalogItem> subItems = it2.next().getSubItems();
                        if (subItems != null && subItems.size() > 0) {
                            subItems.trimToSize();
                        }
                    }
                }
                this.f52711g.setParentNameItems(new ArrayList());
                net.one97.paytm.common.b.d.a().a(this.f52711g);
                if (!isFinishing()) {
                    CJRCatalog cJRCatalog = this.f52711g;
                    if (this.l != null) {
                        this.f52711g = cJRCatalog;
                        CJRCatalog cJRCatalog2 = new CJRCatalog();
                        cJRCatalog2.setSearchQueryUrl(this.f52711g.getSearchQueryUrl());
                        cJRCatalog2.setAllCatalogList(this.f52711g.getAllCatalogList());
                        net.one97.paytm.landingpage.utils.b bVar = this.l;
                        bVar.f52900c = cJRCatalog2;
                        bVar.a();
                        net.one97.paytm.landingpage.utils.b.f52897f = bVar.f52900c.getCatalogList();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRContingency) {
                CJRContingency cJRContingency = (CJRContingency) iJRPaytmDataModel;
                if (cJRContingency != null && cJRContingency.getStatus()) {
                    Intent f2 = net.one97.paytm.common.b.d.a().f((Activity) this);
                    f2.putExtra("url", cJRContingency.getUrl());
                    f2.putExtra("title", cJRContingency.getMessage());
                    f2.putExtra(UpiConstants.FROM, "Contingency");
                    f2.putExtra("Maintenance", true);
                    f2.putExtra("Close", cJRContingency.getClose());
                    startActivity(f2);
                    if (!cJRContingency.getClose()) {
                        finish();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRUserInfoV2) {
                if (!isFinishing()) {
                    CJRUserInfoV2 cJRUserInfoV2 = (CJRUserInfoV2) iJRPaytmDataModel;
                    if (cJRUserInfoV2 != null && cJRUserInfoV2.getUserAttributeInfo() != null && !cJRUserInfoV2.getUserAttributeInfo().getCreditCardFlag() && cJRUserInfoV2.getUserTypes() != null && cJRUserInfoV2.getUserTypes().contains("POSTPAID_USER") && !a.f52735b) {
                        this.u = BottomSheetPostpaidInterstitialFragment.newInstance();
                        this.u.checkAndShowPostPaidBottomSheet(this);
                    }
                    if (!(cJRUserInfoV2 == null || cJRUserInfoV2.getUserAttributeInfo() == null || cJRUserInfoV2.getUserAttributeInfo().getPostpaidStatus() == null || !cJRUserInfoV2.getUserAttributeInfo().getPostpaidStatus().equalsIgnoreCase("NOT_MIGRATED"))) {
                        new PostpaidLimitIncreaseBottomSheetFragment().checkAndShowPostpaidLimitIncreaseBottomSheet(this);
                    }
                    if (!(cJRUserInfoV2 == null || cJRUserInfoV2.getUserDefaultInfo() == null)) {
                        if ((net.one97.paytm.common.b.d.a().y() || cJRUserInfoV2.getUserDefaultInfo().isKyc()) && !cJRUserInfoV2.isPasswordSet() && !isFinishing()) {
                            net.one97.paytm.common.b.d.a().b(getSupportFragmentManager(), (net.one97.paytm.landingpage.c.c) this);
                        }
                        if (this.E || !TextUtils.isEmpty(cJRUserInfoV2.getUserDefaultInfo().getPhone())) {
                            ag.a(getApplicationContext()).a("isPhoneNoAdded", true, true);
                        } else {
                            this.E = true;
                            net.one97.paytm.common.b.d.a().a(getSupportFragmentManager(), (net.one97.paytm.landingpage.c.c) this);
                        }
                    }
                    if (cJRUserInfoV2.getUserId() != null) {
                        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable(cJRUserInfoV2) {
                            private final /* synthetic */ CJRUserInfoV2 f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                AJRMainActivity.this.a(this.f$1);
                            }
                        });
                    }
                }
            } else if (iJRPaytmDataModel instanceof OfflineLeadOTPModel) {
                d dVar = this.A;
                net.one97.paytm.common.b.d.a().a(dVar.f53011a, (OfflineLeadOTPModel) iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRHomePageV2) {
            } else {
                if (iJRPaytmDataModel instanceof KYCStatusV2) {
                    KYCStatusV2 kYCStatusV2 = (KYCStatusV2) iJRPaytmDataModel;
                    if (kYCStatusV2 != null) {
                        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable(kYCStatusV2) {
                            private final /* synthetic */ KYCStatusV2 f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                AJRMainActivity.this.a(this.f$1);
                            }
                        });
                        if (!net.one97.paytm.common.b.d.a().m(getApplicationContext())) {
                            net.one97.paytm.common.b.d.a().a((Context) this, getSupportFragmentManager(), kYCStatusV2);
                            if (!kYCStatusV2.isMinKycStatus() && kYCStatusV2.getFailSafeKey().equalsIgnoreCase("1") && net.one97.paytm.common.b.d.a().p(getApplicationContext()) == 0 && net.one97.paytm.common.b.d.b().a("min_kyc_pop_up_visiblity", false)) {
                                if (net.one97.paytm.common.b.d.a().b((Context) this, net.one97.paytm.common.b.d.a().b("min_kyc_pop_up_n"))) {
                                    Intent f3 = net.one97.paytm.common.b.d.a().f((Context) this);
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("show_pop_up", true);
                                    bundle.putBoolean("kyc_status_api_call", false);
                                    bundle.putBoolean("min_kyc_mandate_pop_up", net.one97.paytm.common.b.d.a().A());
                                    f3.putExtras(bundle);
                                    startActivity(f3);
                                } else {
                                    net.one97.paytm.common.b.d.a().t();
                                }
                            }
                            if (!isFinishing() && !isDestroyed()) {
                                net.one97.paytm.common.b.d.a().b((Context) this, getSupportFragmentManager(), kYCStatusV2);
                            }
                        } else if (!net.one97.paytm.common.b.d.b().a("kycExpiredPopUpVisibility", false) || !net.one97.paytm.common.b.d.a().a((Context) this, net.one97.paytm.common.b.d.a().b("kycExpiredPopUpN"))) {
                            net.one97.paytm.common.b.d.a().s();
                        } else if (!isFinishing() && !isDestroyed()) {
                            net.one97.paytm.common.b.d.a().a(getSupportFragmentManager());
                        }
                        if (!net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).e() && !net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).f()) {
                            net.one97.paytm.common.b.d.a().B(getApplicationContext());
                        }
                    }
                } else if (iJRPaytmDataModel instanceof CustProductList) {
                    CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
                    if (!TextUtils.isEmpty(custProductList.getIsaStatus())) {
                        if (custProductList.getIsaStatus().equals("NOT_APPLIED") || custProductList.getIsaStatus().equals("LEAD")) {
                            net.one97.paytm.common.b.d.a();
                            AccountStatus accountStatus = AccountStatus.NOT_APPLIED;
                        } else if (custProductList.getIsaStatus().equals("FAILED") || custProductList.getIsaStatus().equals("IN_PROGRESS") || custProductList.getIsaStatus().equals("INITIATED") || custProductList.getIsaStatus().equals("PENDING")) {
                            net.one97.paytm.common.b.d.a();
                            AccountStatus accountStatus2 = AccountStatus.PROCESSING;
                        } else if (custProductList.getIsaStatus().equals("ISSUED")) {
                            net.one97.paytm.common.b.d.a();
                            AccountStatus accountStatus3 = AccountStatus.ISSUED;
                        }
                    }
                    v();
                    h();
                    net.one97.paytm.common.b.d.a().a(custProductList, (Context) this, (g) this);
                    try {
                        if (!isFinishing()) {
                            net.one97.paytm.common.b.d.a().a((Context) this, getSupportFragmentManager());
                        }
                    } catch (Exception unused) {
                    }
                } else if ((iJRPaytmDataModel instanceof VerifyProfileCardResponse) && WebLogin.RESPONSE_CODE_SUCCESS.equalsIgnoreCase(((VerifyProfileCardResponse) iJRPaytmDataModel).getResponseCode()) && this.C != null) {
                    FJRProfileVerifyBottomsheet fJRProfileVerifyBottomsheet = new FJRProfileVerifyBottomsheet();
                    fJRProfileVerifyBottomsheet.setCancelable(true);
                    if (!fJRProfileVerifyBottomsheet.isVisible() && !isFinishing() && getSupportFragmentManager() != null) {
                        ao.a(AJRMainActivity.class, "FJRProfileVerifyBottomsheet");
                        fJRProfileVerifyBottomsheet.show(getSupportFragmentManager(), "verify_profile");
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRUserInfoV2 cJRUserInfoV2) {
        net.one97.paytm.common.b.d.a().A(this);
        net.one97.paytm.common.b.d.a().a(cJRUserInfoV2, (Context) this);
        net.one97.paytm.common.b.d.a().b(cJRUserInfoV2, (Context) this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(KYCStatusV2 kYCStatusV2) {
        net.one97.paytm.common.b.d.a().a(kYCStatusV2, (Context) this);
    }

    public final void a(NetworkCustomError networkCustomError) {
        try {
            h();
            String a2 = net.one97.paytm.common.b.d.b().a("min_kyc_status_v3_url");
            if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getFullUrl()) || !URLUtil.isValidUrl(a2) || !networkCustomError.getFullUrl().contains(a2)) {
                if (networkCustomError != null) {
                    if (networkCustomError.getMessage() != null) {
                        q.b(networkCustomError.getMessage());
                    }
                    if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                        r.a((Activity) this, (Exception) networkCustomError, AJRMainActivity.class.getName(), (Bundle) null);
                    } else if (networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
                        if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message));
                        } else {
                            String url = networkCustomError.getUrl();
                            StringBuilder sb = new StringBuilder();
                            sb.append(networkCustomError.getStatusCode());
                            com.paytm.utility.b.d((Context) this, url, sb.toString());
                        }
                    }
                }
                C();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void e(boolean z2) {
        if (z2) {
            this.f52664b = (ViewPager) findViewById(R.id.home_central_pager);
            w();
            this.f52664b.setCurrentItem(this.L);
            this.f52664b.addOnPageChangeListener(new ViewPager.e() {
                public final void onPageScrollStateChanged(int i2) {
                }

                public final void onPageScrolled(int i2, float f2, int i3) {
                }

                public final void onPageSelected(int i2) {
                    if (i2 != 1 || AJRMainActivity.this.f52708d == null) {
                        AJRMainActivity.this.f52708d.setDrawerLockMode(0, 8388611);
                    } else {
                        if (!AJRMainActivity.this.P) {
                            net.one97.paytm.landingpage.utils.g.a(AJRMainActivity.this, "top_nav", "update_section_clicked", "swipe_left");
                        }
                        AJRMainActivity.this.f52708d.setDrawerLockMode(1, 8388611);
                    }
                    boolean unused = AJRMainActivity.this.P = false;
                }
            });
        }
        C();
    }

    private void w() {
        K();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SFHomeFragment());
        if (net.one97.paytm.common.b.d.b() != null) {
            arrayList.add(net.one97.paytm.common.b.d.b().e());
        }
        this.L = 0;
        this.f52664b.setAdapter(new net.one97.paytm.landingpage.a.b(getSupportFragmentManager(), this, arrayList));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String a2;
        int i4 = i2;
        int i5 = i3;
        Intent intent2 = intent;
        super.onActivityResult(i2, i3, intent);
        if (i4 != 2001) {
            if (net.one97.paytm.common.b.d.a().c(i4)) {
                setResult(-1, intent2);
                finish();
            } else if (net.one97.paytm.common.b.d.a().d(i4)) {
                if (com.paytm.utility.a.p(getApplicationContext())) {
                    if (getIntent() != null) {
                        net.one97.paytm.common.b.d.a().a(getIntent(), (Context) this, SDKConstants.AI_LOGIN_SCREEN);
                    }
                    net.one97.paytm.common.b.d.a().a((Activity) this, getIntent());
                } else {
                    setResult(-1, intent2);
                    finish();
                }
            } else if (net.one97.paytm.common.b.d.a().e(i4)) {
                if (com.paytm.utility.a.p(getApplicationContext())) {
                    net.one97.paytm.common.b.d.a().b((Context) this, getIntent());
                } else {
                    setResult(-1, intent2);
                    finish();
                }
            } else if (net.one97.paytm.common.b.d.a().f(i4) && intent2 != null) {
                Intent intent3 = new Intent();
                intent3.putExtra(SDKConstants.RESPONSE, intent2.getStringExtra(SDKConstants.RESPONSE));
                intent3.putExtra("nativeSdkForMerchantMessage", intent2.getStringExtra("nativeSdkForMerchantMessage"));
                setResult(i5, intent3);
                finish();
            } else if (i4 == 5554) {
                this.O.a(i5 != -1);
                net.one97.paytm.common.b.d.a().a(i5 != -1);
                if (i5 == -1) {
                    aa = false;
                }
            } else if (i4 == 5556 || i4 == 2003) {
                net.one97.paytm.common.b.d.a().a(net.one97.paytm.common.b.d.b().j(this));
                this.O.a(net.one97.paytm.common.b.d.b().j(this));
            } else if (i4 == 5555 || i4 == 2002) {
                this.O.a(i5 == -1);
                net.one97.paytm.common.b.d.a().a(i5 == -1);
                if (i5 == -1) {
                    aa = true;
                }
            }
            if (i4 == 233 || i4 == 111) {
                net.one97.paytm.common.b.d.a().I(getApplicationContext());
                J();
                if (i5 == -1) {
                    com.paytm.b.a.a a3 = ag.a(getApplicationContext());
                    boolean b2 = a3.b("isPrime", false, true);
                    boolean b3 = a3.b("isPasswordSet", false, true);
                    if ((net.one97.paytm.common.b.d.a().y() || b2) && !b3 && !isFinishing()) {
                        net.one97.paytm.common.b.d.a().b(getSupportFragmentManager(), (net.one97.paytm.landingpage.c.c) this);
                    }
                    net.one97.paytm.common.b.d.a().b((AppCompatActivity) this);
                }
            }
            if (i4 == 233) {
                if (i5 == -1) {
                    com.paytm.b.a.a a4 = ag.a(getApplicationContext());
                    if (a4 != null) {
                        String b4 = a4.b("appsflyer_map_data", "", true);
                        if (!TextUtils.isEmpty(b4)) {
                            if (a4.b("af_is_deferred", false, true)) {
                                net.one97.paytm.common.b.d.a().a((HashMap<String, Object>) (HashMap) new com.google.gsonhtcfix.f().a(b4, new com.google.gson.b.a<HashMap<String, Object>>() {
                                }.getType()), (Activity) this);
                            } else {
                                HashMap hashMap = (HashMap) new com.google.gsonhtcfix.f().a(b4, new com.google.gson.b.a<HashMap<String, Object>>() {
                                }.getType());
                                if (hashMap != null && hashMap.containsKey("referral_unique_link") && !TextUtils.isEmpty((CharSequence) hashMap.get("referral_unique_link"))) {
                                    net.one97.paytm.common.b.d.a().c((Activity) this, (String) hashMap.get("referral_unique_link"));
                                }
                            }
                            N();
                        }
                    }
                } else {
                    N();
                }
            }
            if (!(intent2 == null || intent.getExtras() == null || !intent.getExtras().getBoolean("isLeftNavSessionTimeout") || this.l == null)) {
                this.D.postDelayed(new Runnable() {
                    public final void run() {
                        AJRMainActivity.this.P();
                    }
                }, 2000);
            }
            if (i4 == 800 && i5 == -1) {
                net.one97.paytm.landingpage.e.b bVar = this.B;
                bVar.f52760g = false;
                if (com.paytm.utility.d.c(bVar.f52755b.getApplicationContext()) && (a2 = net.one97.paytm.common.b.d.b().a("frequentOrdersAndroid")) != null) {
                    String str = a2 + com.paytm.utility.c.a(bVar.f52755b, false);
                    if (!bVar.f52760g) {
                        bVar.f52760g = true;
                        if (com.paytm.utility.a.m(bVar.f52755b)) {
                            com.paytm.network.a a5 = net.one97.paytm.common.b.d.a(bVar.f52755b, str, new com.paytm.network.listener.b() {
                                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                    if (b.this.f52754a instanceof AJRMainActivity) {
                                        ((AJRMainActivity) b.this.f52754a).a(iJRPaytmDataModel);
                                    }
                                }

                                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                                    b.this.f52760g = false;
                                }
                            }, com.paytm.utility.b.ah(bVar.f52755b), (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRFrequentOrderList(), a.c.HOME, a.b.SILENT);
                            a5.f42859c = false;
                            a5.a();
                            return;
                        }
                        com.paytm.utility.a.c();
                        return;
                    }
                    return;
                }
                return;
            }
            int o = net.one97.paytm.common.b.d.a().o(this);
            if (i5 == -1 && o == -1) {
                this.B.d();
            }
            if (i4 == 5123 && i5 == -1) {
                E();
            }
            if (i4 == 115) {
                try {
                    if (this.s == 1) {
                        Intent intent4 = new Intent("channels_location");
                        intent4.putExtra("requestCode", i4);
                        intent4.putExtra("resultCode", i5);
                        androidx.localbroadcastmanager.a.a.a(this.C).a(intent4);
                    }
                } catch (Exception unused) {
                }
            } else {
                if (i4 == 9856 && i5 == -1) {
                    E();
                }
                if (i5 == -1) {
                    if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 100 || i4 == 200 || i4 == 201 || i4 == 202 || i4 == 4 || i4 == 500 || i4 == 205 || i4 == 7) {
                        if (this.s == 1) {
                            net.one97.paytm.common.b.d.a().a(y(), i4, intent2);
                        }
                        if (intent2 != null && intent.getExtras() != null) {
                            String string = intent.getExtras().getString("referral_unique_link");
                            if (!TextUtils.isEmpty(string)) {
                                net.one97.paytm.common.b.d.a().c((Activity) this, string);
                                N();
                            }
                        }
                    } else if (i4 == 203 && com.paytm.utility.a.p(this)) {
                        Intent intent5 = new Intent(this, net.one97.paytm.common.b.d.a().p());
                        intent5.putExtra("need_wishlist_open", true);
                        intent5.putExtra("wishlist_source", "Account");
                        startActivity(intent5);
                    }
                }
            }
        } else if (i5 == -1) {
            aa = true;
            if (a(getIntent())) {
                I();
            } else {
                J();
            }
        } else if (this.ab == null || !x()) {
            finish();
        } else {
            finish();
            startActivity(this.ab);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P() {
        this.l.f();
    }

    private boolean x() {
        int i2 = Build.VERSION.SDK_INT;
        return Settings.System.getInt(getApplicationContext().getContentResolver(), "always_finish_activities", 0) == 1;
    }

    public void onDestroy() {
        io.reactivex.rxjava3.b.b bVar = this.I;
        if (bVar != null) {
            bVar.a();
        }
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        androidx.localbroadcastmanager.a.a.a(this.C).a(this.ae);
        androidx.localbroadcastmanager.a.a.a(this.C).a(this.af);
        net.one97.paytm.common.b.d.a().v();
        try {
            net.one97.paytm.common.b.d.a().w();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        i.b();
        com.paytm.network.a.a.a.f42865a = null;
        net.one97.paytm.common.b.d.a().C(getApplicationContext());
        net.one97.paytm.common.b.d.a().D(getApplicationContext());
        try {
            e a2 = net.one97.paytm.common.b.d.a();
            getApplicationContext();
            a2.u();
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
        net.one97.paytm.common.utility.b.bo = 0.0d;
        net.one97.paytm.common.b.d.a().r();
        getLifecycle().b(this.R);
        this.K = null;
        net.one97.paytm.common.b.d.a().H();
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.ad);
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.ag);
        super.onDestroy();
    }

    public void onBackPressed() {
        Fragment y2 = y();
        if (this.f52708d == null || !this.f52708d.e(8388611)) {
            ViewPager viewPager = this.f52664b;
            if (viewPager == null || viewPager.getCurrentItem() == 0) {
                if (this.y) {
                    net.one97.paytm.common.b.d.a().b();
                    a.f52735b = false;
                    super.onBackPressed();
                } else {
                    this.y = true;
                    Toast.makeText(this, getString(R.string.press_again_to_close), 0).show();
                }
                if (y2 instanceof SFHomeFragment) {
                    this.K.a();
                    return;
                }
                return;
            }
            this.f52664b.setCurrentItem(0, true);
            return;
        }
        this.f52708d.d(8388611);
    }

    private Fragment y() {
        try {
            if (this.f52664b == null || this.f52664b.getCurrentItem() < 0 || !(this.f52664b.getAdapter() instanceof m)) {
                return null;
            }
            return ((m) this.f52664b.getAdapter()).getItem(this.f52664b.getCurrentItem());
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public void onTrimMemory(int i2) {
        net.one97.paytm.common.b.d.b().s();
        super.onTrimMemory(i2);
    }

    public void onLowMemory() {
        net.one97.paytm.common.b.d.b().s();
        super.onLowMemory();
    }

    public void onStart() {
        super.onStart();
        if (this.V) {
            z();
        }
    }

    private void z() {
        AsyncTask.SERIAL_EXECUTOR.execute(new b(this, (byte) 0));
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(AJRMainActivity aJRMainActivity, byte b2) {
            this();
        }

        public final void run() {
            AJRMainActivity.l(AJRMainActivity.this);
            net.one97.paytm.common.b.d.b().e(AJRMainActivity.this.getApplicationContext());
        }
    }

    public void onStop() {
        net.one97.paytm.landingpage.f.a.b();
        super.onStop();
    }

    private void A() {
        net.one97.paytm.common.b.d.b();
        net.one97.paytm.landingpage.e.b bVar = this.B;
        if (bVar != null && bVar.f52754a != null) {
            if (!com.paytm.utility.s.a()) {
                try {
                    net.one97.paytm.common.b.d.a().g(bVar.f52754a);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            } else if (com.paytm.utility.s.e(bVar.f52754a)) {
                try {
                    net.one97.paytm.common.b.d.a().g(bVar.f52754a);
                } catch (Exception e3) {
                    q.b(e3.getMessage());
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        int i3 = i2;
        String[] strArr2 = strArr;
        int[] iArr2 = iArr;
        if (strArr2.length > 0 && iArr2.length > 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i5 >= strArr2.length) {
                    break;
                } else if (strArr2[i5].equalsIgnoreCase("android.permission.READ_CONTACTS")) {
                    i4 = i5;
                    break;
                } else {
                    i5++;
                }
            }
            if (i3 == 101) {
                if (iArr2[i4] != 0 || !strArr2[i4].equalsIgnoreCase("android.permission.READ_CONTACTS")) {
                    a(this, "app_permissions", "app_permissions_provided", "contact=false", "main starting screen", "app_permission");
                } else {
                    A();
                    a(this, "app_permissions", "app_permissions_provided", "contact=true", "main starting screen", "app_permission");
                }
            }
            b.C0745b bVar = com.paytm.signal.b.f43594e;
            k.c(strArr2, "permissions");
            k.c(iArr2, "grantResults");
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new b.C0745b.d(i3, strArr2, iArr2, (kotlin.d.d) null), 2, (Object) null);
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    private void B() {
        FrameLayout frameLayout = this.G;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    private void C() {
        FrameLayout frameLayout = this.G;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private void D() {
        net.one97.paytm.landingpage.f.a.b();
        Intent c2 = net.one97.paytm.common.b.d.a().c((Context) this);
        c2.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
        c2.putExtra("TRIGGER", "MIDDLE_SCAN");
        startActivity(c2);
    }

    private void E() {
        v();
        if (com.paytm.utility.a.p(getApplicationContext())) {
            net.one97.paytm.common.b.d.a();
            if (!net.one97.paytm.common.b.d.b().a("paytmPaymentBankEnabled", false)) {
                return;
            }
            if (net.one97.paytm.common.b.d.a().d((Context) this)) {
                CJRSendGTMTag.sendCustomGTMEvents(this, "bank_saving_account", "bank_user_status", "bank_user_isa_status_", "ISSUED", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                net.one97.paytm.landingpage.utils.bankutil.a aVar = net.one97.paytm.landingpage.utils.bankutil.a.f52901a;
                net.one97.paytm.landingpage.utils.bankutil.a.a((Context) this, "ISA");
                d();
            } else if (com.paytm.utility.a.m(this)) {
                b(this, getString(R.string.please_wait));
                if (this.p != null) {
                    this.p.setCancelable(true);
                }
                this.B.b();
            } else {
                com.paytm.utility.b.a(getApplicationContext(), getResources().getString(R.string.check_your_network));
            }
        } else {
            Intent b2 = net.one97.paytm.common.b.d.a().b((Activity) this);
            b2.setFlags(67108864);
            startActivityForResult(b2, 5123);
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        this.f52663a = true;
        net.one97.paytm.common.b.d.a().v();
        u();
    }

    private void G() {
        String a2 = n.a(getApplicationContext(), n.a());
        String str = "TAMIL";
        if (!a2.equalsIgnoreCase("en")) {
            if (a2.equalsIgnoreCase("hi")) {
                str = "HINDI";
            } else if (!a2.equalsIgnoreCase("ta") && !a2.equalsIgnoreCase("te")) {
                if (a2.equalsIgnoreCase("kn")) {
                    str = "KANNADA";
                } else if (a2.equalsIgnoreCase("pa")) {
                    str = "PUNJABI";
                } else if (a2.equalsIgnoreCase("mr")) {
                    str = "MARATHI";
                } else if (a2.equalsIgnoreCase("gu")) {
                    str = "GUJARATI";
                } else if (a2.equalsIgnoreCase("bn")) {
                    str = "BANGALI";
                } else {
                    boolean equalsIgnoreCase = a2.equalsIgnoreCase(CLConstants.DEFAULT_LANGUAGE_PREFERENCE);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("current_language", str);
            hashMap.put("user_id", a(getApplicationContext()));
            hashMap.put("dimension55", a(getApplicationContext()));
            hashMap.put("dimension58", str);
            net.one97.paytm.common.b.d.b().a("set_current_language", (Map<String, Object>) hashMap, getApplicationContext());
        }
        str = "ENGLISH";
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("current_language", str);
            hashMap2.put("user_id", a(getApplicationContext()));
            hashMap2.put("dimension55", a(getApplicationContext()));
            hashMap2.put("dimension58", str);
            net.one97.paytm.common.b.d.b().a("set_current_language", (Map<String, Object>) hashMap2, getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a(y yVar) {
        yVar.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRMainActivity.this.a((Integer) obj);
            }
        });
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        this.N = num.intValue();
        SharedHomeVM sharedHomeVM = this.J;
        if (sharedHomeVM != null) {
            sharedHomeVM.setNotificationData(num.intValue());
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2 && !this.W && !this.V) {
            this.W = true;
            this.D.post(new Runnable() {
                public final void run() {
                    AJRMainActivity.this.H();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void H() {
        net.one97.paytm.common.b.d.b().c();
        if (!aa) {
            if (net.one97.paytm.common.b.d.b().j(getApplicationContext()) && net.one97.paytm.common.b.d.b().t() && net.one97.paytm.common.b.d.b().u() && com.paytm.utility.a.p(getApplicationContext())) {
                net.one97.paytm.common.b.d.b().v();
                net.one97.paytm.common.b.d.b().a((AppCompatActivity) this);
                return;
            }
        }
        if (a(getIntent())) {
            I();
        } else if (o()) {
            net.one97.paytm.common.b.d.b().k();
            net.one97.paytm.common.b.d.b().v();
            net.one97.paytm.common.b.d.b().b((Activity) this);
        } else {
            J();
        }
    }

    private void I() {
        this.D.postDelayed(new Runnable() {
            public final void run() {
                AJRMainActivity.this.J();
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public void J() {
        if (!this.V) {
            this.V = true;
            com.google.firebase.perf.a.a();
            this.Y = com.google.firebase.perf.a.b("main_render_trace");
            this.Y.start();
            j();
            z();
            s();
            Trace trace = this.Y;
            if (trace != null) {
                trace.stop();
                this.Y = null;
            }
        }
    }

    private void K() {
        com.google.firebase.perf.a.a();
        this.Z = com.google.firebase.perf.a.b("home_render_trace");
        this.Z.start();
    }

    public static void a(Context context, String str) {
        net.one97.paytm.common.b.d.a().e(context, str);
    }

    public final void c() {
        if (net.one97.paytm.common.b.d.a().a(y())) {
            a(true);
            this.f52663a = true;
        }
    }

    public final void d() {
        if (!net.one97.paytm.common.b.d.a().k(getApplicationContext())) {
            L();
        } else {
            F();
        }
    }

    private void L() {
        if (!net.one97.paytm.common.b.d.a().k((Context) this) && com.paytm.utility.a.p(this)) {
            b(this, getString(R.string.please_wait));
            net.one97.paytm.landingpage.utils.bankutil.a aVar = net.one97.paytm.landingpage.utils.bankutil.a.f52901a;
            com.paytm.network.a a2 = net.one97.paytm.landingpage.utils.bankutil.a.a(this, new com.paytm.network.listener.b() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f52681a = true;

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    try {
                        if (!AJRMainActivity.this.isFinishing() && !AJRMainActivity.this.isDestroyed()) {
                            if (this.f52681a) {
                                AJRMainActivity.this.h();
                            }
                            if (((ValidatePasscode) iJRPaytmDataModel).getResponseCode() == 1100) {
                                net.one97.paytm.landingpage.utils.bankutil.a aVar = net.one97.paytm.landingpage.utils.bankutil.a.f52901a;
                                net.one97.paytm.landingpage.utils.bankutil.a.a(AJRMainActivity.this);
                                if (this.f52681a) {
                                    AJRMainActivity.this.F();
                                }
                            } else if (this.f52681a) {
                                net.one97.paytm.common.b.d.a().a(AJRMainActivity.this);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (this.f52681a) {
                        AJRMainActivity.this.h();
                    }
                }
            }, a.c.HOME, a.b.USER_FACING, "Home");
            if (a2 != null) {
                a2.a();
            } else {
                h();
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        try {
            net.one97.paytm.common.b.d.a().a(context, str, str2, str3, str4, str5);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public final void f() {
        if (!this.F && com.paytm.utility.a.m(this) && net.one97.paytm.common.b.d.b().a("payment_preconnect", false) && !TextUtils.isEmpty(net.one97.paytm.common.b.d.b().a("payment_preconnecturl"))) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.n = a.b.SILENT;
            bVar.f42880d = net.one97.paytm.common.b.d.b().a("payment_preconnecturl");
            bVar.o = "MainActivity";
            bVar.p = "p2m";
            bVar.k = false;
            bVar.f42878b = a.c.PAY;
            bVar.f42885i = new IJRPaytmDataModel() {
                public final IJRPaytmDataModel parseResponse(String str, com.google.gsonhtcfix.f fVar) throws Exception {
                    return this;
                }

                public final void setNetworkResponse(NetworkResponse networkResponse) {
                    super.setNetworkResponse(networkResponse);
                }

                public final NetworkResponse getNetworkResponse() {
                    return super.getNetworkResponse();
                }
            };
            bVar.j = new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    boolean unused = AJRMainActivity.this.F = false;
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    boolean unused = AJRMainActivity.this.F = false;
                }
            };
            bVar.f42879c = a.C0715a.HEAD;
            com.paytm.network.a l = bVar.l();
            l.a((Object) "PRECONNECT");
            this.F = true;
            l.a();
        }
    }

    class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(AJRMainActivity aJRMainActivity, byte b2) {
            this();
        }

        public final void run() {
            AJRMainActivity.p(AJRMainActivity.this);
            AJRMainActivity aJRMainActivity = AJRMainActivity.this;
            CJRCatalog cJRCatalog = new CJRCatalog();
            if (aJRMainActivity.f52711g != null) {
                cJRCatalog.setSearchQueryUrl(aJRMainActivity.f52711g.getSearchQueryUrl());
                cJRCatalog.setAllCatalogList(aJRMainActivity.f52711g.getAllCatalogList());
            }
            aJRMainActivity.l = new net.one97.paytm.landingpage.utils.b(aJRMainActivity, cJRCatalog);
        }
    }

    public final void g() {
        Uri data;
        String queryParameter;
        com.paytm.utility.b.a((Context) this, (View) this.n);
        Trace trace = this.Z;
        if (trace != null) {
            trace.stop();
            this.Z = null;
        }
        net.one97.paytm.common.b.d.b().i();
        boolean z2 = true;
        this.T = true;
        net.one97.paytm.common.b.d.b().k();
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                reportFullyDrawn();
            } catch (Exception unused) {
            }
        }
        this.D.post(new Runnable() {
            public final void run() {
                AJRMainActivity.this.O();
            }
        });
        f();
        try {
            if (!(getIntent() == null || (data = getIntent().getData()) == null || (queryParameter = data.getQueryParameter("urlType")) == null || !queryParameter.equalsIgnoreCase("wallet"))) {
                net.one97.paytm.common.b.d.a().c((Activity) this);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        if (com.paytm.utility.a.p(this)) {
            net.one97.paytm.landingpage.e.b bVar = this.B;
            String b2 = com.paytm.utility.b.b(bVar.f52755b, net.one97.paytm.common.b.d.a().m());
            if (URLUtil.isValidUrl(b2)) {
                Map<String, String> u2 = net.one97.paytm.common.b.d.a().u(bVar.f52755b);
                u2.put("client_id", com.paytm.utility.b.k());
                if (com.paytm.utility.a.m(bVar.f52755b)) {
                    net.one97.paytm.common.b.d.a(bVar.f52755b, b2, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (b.this.f52754a instanceof AJRMainActivity) {
                                ((AJRMainActivity) b.this.f52754a).a(iJRPaytmDataModel);
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            if (b.this.f52754a instanceof AJRMainActivity) {
                                ((AJRMainActivity) b.this.f52754a).a(networkCustomError);
                            }
                        }
                    }, u2, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRUserInfoV2(), a.c.HOME, a.b.SILENT).a();
                }
            }
        }
        net.one97.paytm.common.b.d.a().a((AppCompatActivity) this);
        this.B.d();
        if (net.one97.paytm.common.b.d.a().g((Context) this)) {
            net.one97.paytm.common.b.d.a().i((Context) this);
        } else if (net.one97.paytm.common.b.d.a().h((Context) this)) {
            net.one97.paytm.common.b.d.a().j((Context) this);
        }
        androidx.localbroadcastmanager.a.a.a(this.C).a(new Intent("passbook_key_fresh_app_start"));
        if (net.one97.paytm.common.b.d.a().z() && com.paytm.utility.a.p(this)) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("deep_linking_data");
            if (cJRHomePageItem == null || cJRHomePageItem.getDeeplink() == null || !cJRHomePageItem.getDeeplink().startsWith("paytmmp://upi_passbook")) {
                z2 = false;
            }
            if (!z2) {
                if (UpiGTMLoader.getInstance().isRecurringMandateEnabled().booleanValue()) {
                    net.one97.paytm.upi.requestmoney.a.a().a(this, com.paytm.utility.a.a((Context) this), this);
                } else {
                    net.one97.paytm.upi.requestmoney.a a2 = net.one97.paytm.upi.requestmoney.a.a();
                    net.one97.paytm.upi.g.c().a((a.C1402a) new a.C1402a(this, this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ androidx.lifecycle.q f69106a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ Context f69107b;

                        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                        }

                        {
                            this.f69106a = r2;
                            this.f69107b = r3;
                        }

                        public final void a(UpiBaseDataModel upiBaseDataModel) {
                            androidx.lifecycle.q qVar;
                            if (upiBaseDataModel instanceof PendingRequestsV2) {
                                PendingRequestsV2 pendingRequestsV2 = (PendingRequestsV2) upiBaseDataModel;
                                if (pendingRequestsV2.getRespCode().equalsIgnoreCase("0")) {
                                    a.this.f69105b = new ArrayList<>();
                                    if (pendingRequestsV2 != null) {
                                        ArrayList<UpiPendingRequestModel> pendingRequests = pendingRequestsV2.getPendingRequests();
                                        int i2 = 0;
                                        for (int i3 = 0; i3 < pendingRequests.size(); i3++) {
                                            if (pendingRequests.get(i3).getDirection().equalsIgnoreCase("RECEIVED") && a.a(pendingRequests.get(i3))) {
                                                a.this.f69105b.add(pendingRequests.get(i3));
                                                i2++;
                                            }
                                            if (i2 == 5) {
                                                break;
                                            }
                                        }
                                        if (a.this.f69105b.size() > 0 && (qVar = this.f69106a) != null && qVar.getLifecycle().a().isAtLeast(k.b.STARTED)) {
                                            Intent intent = new Intent(this.f69107b, UpiRequestMoneyPagerActivity.class);
                                            intent.putExtra("pendingRequestModelArrayList", a.this.f69105b);
                                            this.f69107b.startActivity(intent);
                                        }
                                    }
                                }
                            }
                        }
                    }, "", 0, com.paytm.utility.a.a((Context) this));
                }
            }
        }
        net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).m();
        boolean e3 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).e();
        if (a.a(this) && e3) {
            UpiHomeQREducation.a aVar = UpiHomeQREducation.f67814a;
            kotlin.g.b.k.c(this, "activity");
            startActivity(new Intent(this, UpiHomeQREducation.class));
            a.c(this);
        }
        try {
            this.l.b();
        } catch (Exception e4) {
            q.b(e4.getMessage());
        }
        net.one97.paytm.common.b.d.a().b(getSupportFragmentManager());
        if (!net.one97.paytm.common.b.d.b().j(this) || !net.one97.paytm.common.b.d.b().t()) {
            net.one97.paytm.common.b.d.a().e(getSupportFragmentManager());
        }
        boolean booleanExtra = getIntent().getBooleanExtra("wasLaunchedFromRecent", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("isFromNotification", false);
        if (!booleanExtra && !booleanExtra2) {
            net.one97.paytm.common.b.d.a().a(getSupportFragmentManager(), (Activity) this);
        }
        net.one97.paytm.common.b.d.a().k((Activity) this);
        l();
        net.one97.paytm.common.b.d.a().V();
        net.one97.paytm.common.b.d.b().A();
        Context applicationContext = getApplicationContext();
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            String str = packageInfo.versionName;
            int a3 = (int) androidx.core.content.a.a.a(packageInfo);
            StringBuilder sb = new StringBuilder("PackageName = ");
            sb.append(packageInfo.packageName);
            sb.append(", VersionCode = ");
            sb.append(a3);
            sb.append(", VersionName = ");
            sb.append(str);
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
        }
    }

    private void M() {
        if (!net.one97.paytm.common.b.d.b().d()) {
            net.one97.paytm.common.b.d.b().b(this, getIntent());
        }
    }

    private void N() {
        com.paytm.b.a.a a2 = ag.a(getApplicationContext());
        a2.a("appsflyer_map_data", "", true);
        a2.a("af_is_deferred", false, true);
    }

    public final void e() {
        net.one97.paytm.common.b.d.a().e((Activity) this);
        try {
            File file = new File(Environment.getExternalStorageDirectory().toString() + com.paytm.utility.b.am(getApplicationContext()) + UpiConstants.USER_PROFILE_PIC_FILENAME);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        O();
    }

    static /* synthetic */ void a(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("referral_unique_link", str);
        Intent b2 = net.one97.paytm.common.b.d.a().b(activity);
        b2.putExtra("resultant activity_bundle", bundle);
        b2.addFlags(536870912);
        activity.startActivityForResult(b2, 3);
    }

    static /* synthetic */ void b(AJRMainActivity aJRMainActivity) {
        HomeLifecycleObserver homeLifecycleObserver = aJRMainActivity.R;
        if (homeLifecycleObserver != null && !aJRMainActivity.S) {
            aJRMainActivity.S = true;
            homeLifecycleObserver.a();
        }
    }

    static /* synthetic */ void f(AJRMainActivity aJRMainActivity) {
        if (aJRMainActivity.z) {
            if (!net.one97.paytm.common.b.d.b().g()) {
                if (aJRMainActivity.H) {
                    aJRMainActivity.H = false;
                    aJRMainActivity.r();
                    return;
                }
                String a2 = n.a((Context) aJRMainActivity, n.a());
                aJRMainActivity.runOnUiThread(new Runnable() {
                    public final void run() {
                        AJRMainActivity.this.Q();
                    }
                });
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                if (TextUtils.isEmpty(aJRMainActivity.x) || !aJRMainActivity.x.equalsIgnoreCase(a2)) {
                    aJRMainActivity.r();
                    return;
                }
            }
            String a3 = n.a((Context) aJRMainActivity, "en");
            ag.a(aJRMainActivity.getApplicationContext()).a("user-set-language", Resources.getSystem().getConfiguration().locale.getLanguage(), true);
            net.one97.paytm.common.b.d.b().a((Activity) aJRMainActivity, aJRMainActivity.getSupportFragmentManager());
            aJRMainActivity.x = a3;
        }
    }

    static /* synthetic */ void g(AJRMainActivity aJRMainActivity) {
        if (com.paytm.utility.a.p(aJRMainActivity)) {
            com.paytm.b.a.a a2 = ag.a(aJRMainActivity.getApplicationContext());
            if (a2.b("should_fetch_on_launch", true, true)) {
                a2.a("should_fetch_on_launch", false, true);
                net.one97.paytm.common.b.d.b().f(aJRMainActivity);
            }
        }
    }

    static /* synthetic */ void h(AJRMainActivity aJRMainActivity) {
        if (com.paytm.utility.a.p(aJRMainActivity)) {
            com.paytm.b.a.a a2 = ag.a(aJRMainActivity.getApplicationContext());
            if (a2.b("should_download_recent_payments_data", true, true)) {
                a2.a("should_download_recent_payments_data", false, true);
                net.one97.paytm.common.b.d.b().g(aJRMainActivity);
            }
        }
    }

    static /* synthetic */ void l(AJRMainActivity aJRMainActivity) {
        if (com.paytm.utility.a.p(aJRMainActivity.C) && net.one97.paytm.common.b.d.b().c(aJRMainActivity.C) && net.one97.paytm.common.b.d.b().i(aJRMainActivity) != null) {
            net.one97.paytm.landingpage.e.b bVar = aJRMainActivity.B;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", com.paytm.utility.b.m());
                hashMap.put("Content-Type", "application/json");
                hashMap.put("session_token", net.one97.paytm.common.b.d.b().i(bVar.f52755b));
                hashMap.put("version", "2");
                com.paytm.network.a a2 = net.one97.paytm.common.b.d.a(bVar.f52755b, com.paytm.utility.b.e(bVar.f52755b, net.one97.paytm.common.b.d.b().a("offlineConfig")), new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (b.this.f52754a instanceof AJRMainActivity) {
                            ((AJRMainActivity) b.this.f52754a).a(iJRPaytmDataModel);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (b.this.f52754a instanceof AJRMainActivity) {
                            ((AJRMainActivity) b.this.f52754a).a(networkCustomError);
                        }
                    }
                }, hashMap, (Map<String, String>) null, a.C0715a.POST, "", new OfflineLeadOTPModel(), a.c.HOME, a.b.SILENT);
                if (com.paytm.utility.a.m(bVar.f52755b)) {
                    a2.a();
                } else {
                    bVar.f52756c.a(a2);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        aJRMainActivity.A();
        aJRMainActivity.B.a();
    }

    static /* synthetic */ void m(AJRMainActivity aJRMainActivity) {
        final com.paytm.b.a.a a2 = ag.a(aJRMainActivity.getApplicationContext());
        boolean b2 = a2.b("is_root_warning_agreed", false, true);
        if (aJRMainActivity != null && !aJRMainActivity.isFinishing() && !b2) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(aJRMainActivity);
            hVar.setTitle(aJRMainActivity.getString(R.string.alert));
            hVar.a(aJRMainActivity.getString(R.string.upi_device_rooted_message));
            hVar.setCancelable(false);
            hVar.setCanceledOnTouchOutside(false);
            hVar.a(-1, aJRMainActivity.getString(R.string.upi_rooted_popup_agree), new View.OnClickListener() {
                public final void onClick(View view) {
                    a2.a("is_root_warning_agreed", true, true);
                    hVar.dismiss();
                }
            });
            if (!aJRMainActivity.isFinishing()) {
                hVar.show();
            }
        }
    }

    static /* synthetic */ void p(AJRMainActivity aJRMainActivity) {
        String l = com.paytm.utility.a.l(aJRMainActivity);
        String networkOperatorName = ((TelephonyManager) aJRMainActivity.getSystemService(ContactColumn.PHONE_NUMBER)).getNetworkOperatorName();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("uninst_lib_network_type", l);
            hashMap.put("uninst_lib_network_provider", networkOperatorName);
            net.one97.paytm.common.b.d.b().a("uninst_lib_network_info", (Map<String, Object>) hashMap, aJRMainActivity.getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }
}
