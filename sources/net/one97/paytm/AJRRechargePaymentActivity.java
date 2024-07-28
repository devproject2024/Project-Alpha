package net.one97.paytm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.util.H5Utils;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import easypay.listeners.AssistBuilderCallBack;
import easypay.listeners.WebClientListener;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.EasypayWebViewClient;
import easypay.manager.PaytmAssist;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.OnOrderCreatedListener;
import net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CreateOrderModel;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.mpassevent.MpassEventLogger;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.payments.visascp.VisaSCP;
import net.one97.paytm.payments.visascp.VisaSCPImpl;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.PendingRequestsModel;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserVpaInfo;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.ba;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.widget.i;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRRechargePaymentActivity extends CJRActionBarBaseActivity implements WebClientListener {
    private CJRParcelTrackingInfo C;
    private String D;
    private CJRRechargeCart E;
    /* access modifiers changed from: private */
    public boolean F;
    private String G;
    /* access modifiers changed from: private */
    public boolean H;
    private String I;
    /* access modifiers changed from: private */
    public boolean J;
    private boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    private String M;
    private String N;
    private boolean O;
    /* access modifiers changed from: private */
    public boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W;
    /* access modifiers changed from: private */
    public boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private final String f51660a = "MID";
    /* access modifiers changed from: private */
    public boolean aA;
    private boolean aB;
    private boolean aC;
    /* access modifiers changed from: private */
    public boolean aD;
    /* access modifiers changed from: private */
    public boolean aE;
    /* access modifiers changed from: private */
    public boolean aF;
    /* access modifiers changed from: private */
    public boolean aG;
    private String aH;
    /* access modifiers changed from: private */
    public HashMap<String, ResolveInfo> aI;
    /* access modifiers changed from: private */
    public Map<String, String> aJ;
    private Intent aK;
    private String[] aL;
    /* access modifiers changed from: private */
    public boolean aM;
    private boolean aN;
    /* access modifiers changed from: private */
    public String aO;
    /* access modifiers changed from: private */
    public String aP;
    /* access modifiers changed from: private */
    public String aQ;
    /* access modifiers changed from: private */
    public AlertDialog aR;
    /* access modifiers changed from: private */
    public String aS;
    private y aT;
    /* access modifiers changed from: private */
    public String aU;
    private BroadcastReceiver aV;
    private boolean aW;
    private AssistMerchantDetails aX;
    private boolean aY;
    private final String aZ;
    /* access modifiers changed from: private */
    public boolean aa;
    /* access modifiers changed from: private */
    public boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    /* access modifiers changed from: private */
    public boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private String ar;
    private boolean as;
    private Map<String, Object> at;
    private String au;
    private String av;
    private String aw;
    /* access modifiers changed from: private */
    public String ax;
    private String ay;
    /* access modifiers changed from: private */
    public HashMap<String, String> az;

    /* renamed from: b  reason: collision with root package name */
    private final String f51661b = "ORDER_ID";
    private String bA;
    private TextView bB;
    private TextView bC;
    private TextView bD;
    private LottieAnimationView bE;
    /* access modifiers changed from: private */
    public ProgressBar bF;
    private ShimmerFrameLayout bG;
    private boolean bH;
    private boolean bI;
    private String bJ;
    private boolean bK;
    private String bL;
    private String bM;
    private String bN;
    private Timer bO;
    private TimerTask bP;
    /* access modifiers changed from: private */
    public i bQ;
    private Dialog bR;
    /* access modifiers changed from: private */
    public boolean ba;
    /* access modifiers changed from: private */
    public String bb;
    /* access modifiers changed from: private */
    public String bc;
    /* access modifiers changed from: private */
    public long bd;
    /* access modifiers changed from: private */
    public long be;
    private long bf;
    private int bg;
    /* access modifiers changed from: private */
    public String bh;
    private ImageView bi;
    /* access modifiers changed from: private */
    public c bj;
    /* access modifiers changed from: private */
    public boolean bk;
    /* access modifiers changed from: private */
    public String bl;
    /* access modifiers changed from: private */
    public String bm;
    private boolean bn;
    /* access modifiers changed from: private */
    public String bo;
    private boolean bp;
    /* access modifiers changed from: private */
    public String bq;
    /* access modifiers changed from: private */
    public String br;
    private String bs;
    private String bt;
    /* access modifiers changed from: private */
    public String bu;
    /* access modifiers changed from: private */
    public String bv;
    private RelativeLayout bw;
    private RelativeLayout bx;
    private RelativeLayout by;
    private ImageView bz;

    /* renamed from: c  reason: collision with root package name */
    private final String f51662c = "JsonData";

    /* renamed from: d  reason: collision with root package name */
    private final String f51663d;

    /* renamed from: e  reason: collision with root package name */
    private final String f51664e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WebView f51665f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f51666g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Boolean f51667h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Boolean f51668i;
    /* access modifiers changed from: private */
    public String j;
    private boolean k;
    /* access modifiers changed from: private */
    public CJRRechargePayment l;

    public void OnWcSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public final void a() {
    }

    public AJRRechargePaymentActivity() {
        Class<AJRRechargePaymentActivity> cls = AJRRechargePaymentActivity.class;
        this.f51663d = cls.getName();
        this.f51664e = "^[0-9]{6,8}$";
        this.f51667h = Boolean.FALSE;
        this.f51668i = Boolean.FALSE;
        this.k = false;
        this.E = null;
        this.H = false;
        this.K = false;
        this.L = false;
        this.N = "";
        this.ar = "";
        this.as = false;
        this.at = new HashMap();
        this.au = null;
        this.av = null;
        this.aw = null;
        this.ax = null;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aD = false;
        this.aE = false;
        this.aF = false;
        this.aG = false;
        this.aH = null;
        this.aI = new HashMap<>();
        this.aJ = new HashMap();
        this.aL = new String[]{"jpg", "jpeg", "png", "gif", "JPG", "JPEG", "PNG", "GIF"};
        this.aM = false;
        this.aN = false;
        this.aO = "javascript:function myFunction() {try {var firstInput = document.querySelectorAll('input[type=text],input[type=password],input[type=tel]');for(var x=0; x < firstInput.length; x++) {firstInput[x].addEventListener('change', function () {try{var lastOtp=this.value;OTPInterface.otpFound(lastOtp);} catch(err){}});}} catch(err){} } myFunction();";
        this.aS = "";
        this.aT = new y();
        this.aV = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if ("upi_self_order".equalsIgnoreCase(intent.getAction())) {
                    AJRRechargePaymentActivity.this.B();
                }
            }
        };
        this.aZ = cls.getSimpleName();
        this.bo = getClass().getName();
        this.bp = false;
        this.bI = false;
        this.bJ = "";
        this.bK = false;
    }

    static /* synthetic */ int C(AJRRechargePaymentActivity aJRRechargePaymentActivity) {
        int i2 = aJRRechargePaymentActivity.bg;
        aJRRechargePaymentActivity.bg = i2 + 1;
        return i2;
    }

    private static boolean c() {
        q.d("Enable on Redirection");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("isAssistOnRedirection", "").equals("enable");
    }

    public void onCreate(Bundle bundle) {
        net.one97.paytm.common.b.d.b().k();
        CJRJarvisApplication.s();
        com.paytm.utility.b.e((Activity) this);
        if (bundle == null) {
            if (getIntent() == null || !getIntent().getBooleanExtra("nativeSdkEnabled", false)) {
                setTheme(R.style.JarvisAppBaseTheme);
            } else {
                this.bn = getIntent().getBooleanExtra(SDKConstants.IS_BANK_OFFER, false);
                this.aA = getIntent().getBooleanExtra("enable_paytm_invoke", false);
                this.aB = getIntent().getBooleanExtra("paytm_invoke", false);
                this.aC = getIntent().getBooleanExtra("mWebInvoke", false);
                this.bA = getIntent().getStringExtra("vertical_name");
                this.aE = getIntent().getBooleanExtra("upi_push_native_token", false);
                this.aF = getIntent().getBooleanExtra("upi_check_balance", false);
                this.aG = getIntent().getBooleanExtra("upi_set_mpin", false);
                this.aD = getIntent().getBooleanExtra("isSessionTimeoutCallbackRequiredH5", false);
                if (d()) {
                    setTheme(2132017605);
                }
                w();
            }
        }
        super.onCreate(bundle);
        if (bundle != null) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        int i2 = Build.VERSION.SDK_INT;
        this.bQ = new i(getApplicationContext());
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        try {
            this.s.addView(getLayoutInflater().inflate(R.layout.recharge_payment_view, (ViewGroup) null));
        } catch (Exception e2) {
            r.a(this.bo, "onCreate", (Throwable) e2);
        }
        this.bw = (RelativeLayout) findViewById(R.id.rl_toolbar);
        this.bz = (ImageView) findViewById(R.id.iv_back_arrow_ajr);
        this.bx = (RelativeLayout) findViewById(R.id.cv_progressView);
        this.bB = (TextView) findViewById(R.id.tv_progressMsg);
        this.bC = (TextView) findViewById(R.id.tv_progressMsgSub);
        this.bE = (LottieAnimationView) findViewById(R.id.ltv_loading);
        this.bF = (ProgressBar) findViewById(R.id.payment_load_indicator);
        this.by = (RelativeLayout) findViewById(R.id.header_view);
        this.bD = (TextView) findViewById(R.id.txt_amount);
        this.bG = (ShimmerFrameLayout) findViewById(R.id.shimmer_layout);
        if (getIntent() != null && !getIntent().getBooleanExtra("nativeSdkEnabled", false) && !getIntent().getBooleanExtra("intent_extra_is_offline_pg", false) && !getIntent().getBooleanExtra("auto_add_money", false) && !getIntent().getBooleanExtra("uam_add_money", false)) {
            f();
            this.s.post(new Runnable() {
                public final void run() {
                    AJRRechargePaymentActivity.this.d(true);
                    boolean unused = AJRRechargePaymentActivity.this.ab = true;
                }
            });
        }
        if (getIntent().getBooleanExtra("intent_extra_is_offline_pg", false) || getIntent().getBooleanExtra("auto_add_money", false) || getIntent().getBooleanExtra("uam_add_money", false)) {
            d(false);
            C();
        }
        this.j = getIntent().getStringExtra(UpiConstants.FROM);
        this.bH = getIntent().getBooleanExtra("is_from_app_evoke", false);
        if (getIntent().hasExtra("intent-type-is-buy-flow")) {
            this.k = getIntent().getBooleanExtra("intent-type-is-buy-flow", false);
        }
        if (getIntent().hasExtra("vertical_id")) {
            this.M = getIntent().getStringExtra("vertical_id");
        }
        String str = this.j;
        this.T = str != null && str.equals("Paytm Hotel");
        String str2 = this.j;
        this.ai = str2 != null && str2.equals("Unreserved Bus Ticketing");
        String str3 = this.j;
        if (str3 != null && str3.equalsIgnoreCase("Tourist Bus")) {
            this.aj = true;
        }
        String str4 = this.j;
        if (str4 != null && str4.equalsIgnoreCase("h5_onus_flow")) {
            this.ak = true;
        }
        this.C = (CJRParcelTrackingInfo) getIntent().getParcelableExtra("tracking_info");
        this.D = getIntent().getStringExtra("tracking_info_string");
        if (getIntent().hasExtra("replacement_parent_id")) {
            this.N = getIntent().getStringExtra("replacement_parent_id");
        }
        this.ag = getIntent().getBooleanExtra("add_money_extra_item", false);
        if (getIntent() != null && getIntent().hasExtra("Tab")) {
            this.au = getIntent().getStringExtra("Tab");
        }
        if (getIntent() != null && getIntent().hasExtra("origin")) {
            this.av = getIntent().getStringExtra("origin");
        }
        if (getIntent() != null && getIntent().hasExtra(CLPConstants.PRODUCT_ID)) {
            this.aw = getIntent().getStringExtra(CLPConstants.PRODUCT_ID);
        }
        if (getIntent() != null && getIntent().hasExtra("enable_paytm_invoke")) {
            this.aA = getIntent().getBooleanExtra("enable_paytm_invoke", false);
        }
        if (getIntent() != null && getIntent().hasExtra("started_activity_from_recharge")) {
            this.bp = getIntent().getBooleanExtra("started_activity_from_recharge", false);
        }
        if (getIntent() != null && getIntent().hasExtra("intent_extra_is_from_travel_pass")) {
            this.aN = getIntent().getBooleanExtra("intent_extra_is_from_travel_pass", false);
        }
        if (getIntent() != null && getIntent().hasExtra("key_is_intercept_summary_url")) {
            this.bK = getIntent().getBooleanExtra("key_is_intercept_summary_url", false);
            if (getApplicationContext() != null) {
                net.one97.paytm.j.c.a();
                this.bL = net.one97.paytm.j.c.a("shopSummary", (String) null);
            }
        }
        String str5 = this.j;
        if (str5 != null) {
            try {
                boolean b2 = l.b(str5);
                net.one97.paytm.j.c.a();
                String a2 = net.one97.paytm.j.c.a("categorymap", (String) null);
                if (b2) {
                    net.one97.paytm.j.a.a(str5, b2, (Context) this, a2, this.M);
                } else if (g(a2)) {
                    net.one97.paytm.j.a.a(str5, b2, (Context) this, a2, this.M);
                } else if ("Add_to_paytm_cash".equalsIgnoreCase(str5)) {
                    net.one97.paytm.j.a.a("Wallet", b2, (Context) this, a2, this.M);
                } else if (!"Tickets".equalsIgnoreCase(str5)) {
                    if ("Paytm Hotel".equalsIgnoreCase(str5)) {
                        net.one97.paytm.j.a.a("Paytm Hotel", b2, (Context) this, a2, this.M);
                    } else {
                        net.one97.paytm.j.a.a(SDKConstants.GA_KEY_DEFAULT, b2, (Context) this, a2, this.M);
                    }
                }
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
        }
        String stringExtra = getIntent().getStringExtra("add_money_title_key");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = getResources().getString(R.string.payment);
        }
        setTitle(stringExtra);
        p();
        if (d()) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.parentLayout);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        } else {
            o();
        }
        f();
        if ("release".equals(Boolean.valueOf(com.paytm.utility.b.v))) {
            this.f51666g = (ImageView) findViewById(R.id.img_debug_info);
            this.f51666g.setVisibility(0);
            final EditText editText = (EditText) findViewById(R.id.et_url_checker);
            this.bi = (ImageView) findViewById(R.id.img_close);
            this.bi.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRRechargePaymentActivity.a(AJRRechargePaymentActivity.this, 8);
                }
            });
            ((Button) findViewById(R.id.but_set_url)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String unused = AJRRechargePaymentActivity.this.bh = editText.getText().toString().trim();
                }
            });
            this.f51666g.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (AJRRechargePaymentActivity.this.ba) {
                        AJRRechargePaymentActivity.a(AJRRechargePaymentActivity.this, 8);
                        boolean unused = AJRRechargePaymentActivity.this.ba = false;
                        return;
                    }
                    AJRRechargePaymentActivity.a(AJRRechargePaymentActivity.this, 0);
                    boolean unused2 = AJRRechargePaymentActivity.this.ba = true;
                }
            });
        }
        if ("Shopping_cart".equalsIgnoreCase(this.j)) {
            net.one97.paytm.j.a.b("/payment", GAUtil.MARKET_PLACE, (Context) this);
            net.one97.paytm.j.a.a("screen_loaded_marketplace_payment", "/payment", (Context) this);
        }
        if (getIntent() != null) {
            this.H = getIntent().getBooleanExtra("intent_extra_wallet_send_money_insufficient_balance_error", false);
            if (getIntent().hasExtra("IS_FROM_NEW_SCREEN")) {
                this.K = getIntent().getBooleanExtra("IS_FROM_NEW_SCREEN", false);
            } else {
                this.K = false;
            }
            if (getIntent().hasExtra("is_flight_ticket")) {
                this.S = getIntent().getBooleanExtra("is_flight_ticket", false);
            } else {
                this.S = false;
            }
            if (getIntent().hasExtra("IS_FROM_EVENT")) {
                this.O = getIntent().getBooleanExtra("IS_FROM_EVENT", false);
            } else {
                this.O = false;
            }
            if (getIntent().hasExtra("intent_extra_is_offline_pg")) {
                this.ah = getIntent().getBooleanExtra("intent_extra_is_offline_pg", false);
            } else {
                this.ah = false;
            }
            if (getIntent().hasExtra("is_train_ticket")) {
                this.P = getIntent().getBooleanExtra("is_train_ticket", false);
            } else {
                this.P = false;
            }
            if (getIntent().hasExtra("from_train_module")) {
                this.J = getIntent().getBooleanExtra("from_train_module", false);
            } else {
                this.J = false;
            }
            if (getIntent().hasExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID)) {
                this.I = (String) getIntent().getSerializableExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID);
            }
            if (getIntent().hasExtra("is_movie_ticket")) {
                this.Q = getIntent().getBooleanExtra("is_movie_ticket", false);
            } else {
                this.Q = false;
            }
            if (getIntent().hasExtra("intent_extra_is_recharge")) {
                this.al = getIntent().getBooleanExtra("intent_extra_is_recharge", false);
            } else {
                this.al = false;
            }
            if (getIntent().hasExtra("is_bus_ticket")) {
                this.R = getIntent().getBooleanExtra("is_bus_ticket", false);
            } else {
                this.R = false;
            }
            if (getIntent().hasExtra("city_bus_add_money")) {
                this.aq = getIntent().getBooleanExtra("city_bus_add_money", false);
            }
            if (getIntent().hasExtra("is_bank_pdc")) {
                this.U = getIntent().getBooleanExtra("is_bank_pdc", false);
            } else {
                this.U = false;
            }
            if (getIntent().hasExtra("uam_add_money")) {
                this.V = getIntent().getBooleanExtra("uam_add_money", false);
            } else {
                this.V = false;
            }
            if (getIntent().hasExtra("add_money_to_gv")) {
                this.W = getIntent().getBooleanExtra("add_money_to_gv", false);
            } else {
                this.W = false;
            }
            if (getIntent().hasExtra("auto_add_money")) {
                this.X = getIntent().getBooleanExtra("auto_add_money", false);
            }
            if (getIntent().hasExtra("is_fastag_buy")) {
                this.aW = getIntent().getBooleanExtra("is_fastag_buy", false);
            } else {
                this.aW = false;
            }
            if (getIntent().hasExtra("IS_FROM_AMPARK")) {
                this.ad = getIntent().getBooleanExtra("IS_FROM_AMPARK", false);
            } else {
                this.ad = false;
            }
            if (getIntent().hasExtra("IS_FROM_GIFTCARD")) {
                this.ae = getIntent().getBooleanExtra("IS_FROM_GIFTCARD", false);
            } else {
                this.ae = false;
            }
            if (getIntent().hasExtra("IS_FROM_DEALS")) {
                this.af = getIntent().getBooleanExtra("IS_FROM_DEALS", false);
            }
            if (getIntent().hasExtra("FROM_INSURANCE_SCREEN")) {
                this.aY = getIntent().getBooleanExtra("FROM_INSURANCE_SCREEN", false);
            } else {
                this.aY = false;
            }
            if (getIntent().hasExtra("from_forex_module")) {
                this.Y = getIntent().getBooleanExtra("from_forex_module", false);
            }
            if (getIntent().hasExtra(net.one97.paytm.common.utility.b.bw)) {
                this.Z = getIntent().getBooleanExtra(net.one97.paytm.common.utility.b.bw, false);
            } else {
                this.Z = false;
            }
            if (getIntent().hasExtra("is_from_p2b_via_cc")) {
                this.am = getIntent().getBooleanExtra("is_from_p2b_via_cc", false);
            } else {
                this.am = false;
            }
            if (getIntent().hasExtra("intent_extra_is_from_eduform")) {
                this.an = getIntent().getBooleanExtra("intent_extra_is_from_eduform", false);
            } else {
                this.an = false;
            }
            if (getIntent().hasExtra("intent_extra_is_from_edu_predictor")) {
                this.ao = getIntent().getBooleanExtra("intent_extra_is_from_edu_predictor", false);
            } else {
                this.ao = false;
            }
            this.ap = getIntent().getBooleanExtra("intent_extra_is_from_edu_merchant", false);
            if (getIntent().hasExtra("intent_extra_edu_redirect_url")) {
                this.ar = getIntent().getStringExtra("intent_extra_edu_redirect_url");
            }
            if (getIntent().hasExtra("intent_extra_edu_callback")) {
                this.as = getIntent().getBooleanExtra("intent_extra_edu_callback", false);
            }
            if (getIntent().hasExtra("redirectTo")) {
                this.bJ = getIntent().getStringExtra("redirectTo");
            }
            this.bI = getIntent().getBooleanExtra(H5Event.TYPE_CALL_BACK, false);
            this.bq = getIntent().getStringExtra("card_first_six_digit");
            this.br = getIntent().getStringExtra("card_last_four_digit");
            this.bs = getIntent().getStringExtra("card_expiry_date");
            this.bt = getIntent().getStringExtra("one_click_info");
            if (!TextUtils.isEmpty(this.bt)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.bt).getJSONObject("content");
                    this.bu = jSONObject.getString("authCode");
                    this.bv = jSONObject.getString("partnerOriginalTransactionID");
                } catch (JSONException unused) {
                    this.bt = "";
                }
            }
            if (getIntent().hasExtra("is_rewards_pay")) {
                this.ac = getIntent().getBooleanExtra("is_rewards_pay", false);
            }
        }
        com.paytm.utility.a.c();
        this.at = (Map) getIntent().getSerializableExtra("recharge_ga_data_for_summary");
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.aV, new IntentFilter("upi_self_order"));
        if (e()) {
            ProgressBar progressBar = new ProgressBar(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            progressBar.setLayoutParams(layoutParams);
            progressBar.setIndeterminateDrawable(androidx.core.content.b.a((Context) this, (int) R.drawable.paytm_progress_blue));
            this.s.addView(progressBar);
            progressBar.setVisibility(0);
        }
        if (getIntent() != null && getIntent().getBooleanExtra("nativeSdkEnabled", false)) {
            D();
        }
        if (getIntent() == null || !getIntent().getBooleanExtra("nativeSdkEnabled", false)) {
            a(false);
            return;
        }
        t();
        d(false);
    }

    private boolean d() {
        return (this.aA && this.aB) || this.bn || e();
    }

    /* access modifiers changed from: private */
    public boolean e() {
        return this.aE || this.aG || this.aF;
    }

    private static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected())) {
                if (activeNetworkInfo.getType() == 1) {
                    return H5Utils.NETWORK_TYPE_WIFI;
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return H5Utils.NETWORK_TYPE_2G;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return H5Utils.NETWORK_TYPE_3G;
                        case 13:
                            return H5Utils.NETWORK_TYPE_4G;
                        default:
                            return null;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void f() {
        net.one97.paytm.j.c.a();
        if (!net.one97.paytm.j.c.a("showToolbarOnCashierPage", true)) {
            t();
            RelativeLayout relativeLayout = this.bw;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            ImageView imageView = this.bz;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        net.one97.paytm.j.c.a();
        if (net.one97.paytm.j.c.a("paytmLogoOnPaymentPage", false)) {
            RelativeLayout relativeLayout2 = this.bw;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            t();
            ImageView imageView2 = this.bz;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.bz.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJRRechargePaymentActivity.this.onBackPressed();
                    }
                });
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = this.bw;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        ImageView imageView3 = this.bz;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        String stringExtra = getIntent().getStringExtra("add_money_title_key");
        net.one97.paytm.j.c.a();
        String c2 = net.one97.paytm.j.c.c(getResources().getString(R.string.payment));
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c2;
        }
        setTitle(stringExtra);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (isFinishing()) {
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null && networkCustomError.getMessage() != null && !r.a((Context) this, (Exception) networkCustomError)) {
            if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                return;
            }
            com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
        }
    }

    public void onResume() {
        this.F = false;
        super.onResume();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r8 = this;
            easypay.manager.AssistMerchantDetails r0 = easypay.manager.AssistMerchantDetails.getInstance()
            if (r0 == 0) goto L_0x000f
            easypay.manager.AssistMerchantDetails r0 = easypay.manager.AssistMerchantDetails.getInstance()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.OnBackPressClicked(r1)
        L_0x000f:
            boolean r0 = r8.F
            if (r0 != 0) goto L_0x0185
            r0 = 1
            r8.F = r0
            java.lang.String r1 = r8.j
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0038
            java.lang.String r1 = r8.j
            java.lang.String r3 = "MoviesPage"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0039
        L_0x002b:
            java.lang.String r1 = r8.j
            java.lang.String r3 = "MoviesFnBPage"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0038
            r1 = 0
            r3 = 1
            goto L_0x003a
        L_0x0038:
            r1 = 0
        L_0x0039:
            r3 = 0
        L_0x003a:
            r4 = -1
            if (r1 == 0) goto L_0x0044
            r8.setResult(r4)
            r8.finish()
            return
        L_0x0044:
            boolean r1 = r8.v()
            if (r1 != 0) goto L_0x00dc
            boolean r1 = r8.ah
            if (r1 != 0) goto L_0x00dc
            boolean r1 = r8.V
            if (r1 != 0) goto L_0x00dc
            boolean r1 = r8.W
            if (r1 != 0) goto L_0x00dc
            if (r3 != 0) goto L_0x00dc
            boolean r1 = r8.X
            if (r1 == 0) goto L_0x005e
            goto L_0x00dc
        L_0x005e:
            boolean r1 = r8.Z
            if (r1 == 0) goto L_0x006c
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r1 = r8.l
            java.lang.String r1 = r1.getOrderId()
            r8.c((java.lang.String) r1, (boolean) r0)
            return
        L_0x006c:
            boolean r1 = r8.aY
            if (r1 == 0) goto L_0x007a
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r1 = r8.l
            java.lang.String r1 = r1.getOrderId()
            r8.b((java.lang.String) r1, (boolean) r0)
            return
        L_0x007a:
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l
            if (r0 == 0) goto L_0x00a8
            java.lang.String r0 = r0.getOrderId()
            if (r0 == 0) goto L_0x00a8
            boolean r0 = r8.H
            if (r0 == 0) goto L_0x0091
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l
            java.lang.String r0 = r0.getOrderId()
            r8.f((java.lang.String) r0)
        L_0x0091:
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l
            java.lang.String r0 = r0.getMID()
            if (r0 == 0) goto L_0x00a8
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l
            java.lang.String r0 = r0.getOrderId()
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r1 = r8.l
            java.lang.String r1 = r1.getMID()
            r8.d((java.lang.String) r0, (java.lang.String) r1)
        L_0x00a8:
            boolean r0 = r8.H
            if (r0 == 0) goto L_0x00b8
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l
            if (r0 == 0) goto L_0x00b8
            java.lang.String r0 = r0.getOrderId()
            r8.f((java.lang.String) r0)
            return
        L_0x00b8:
            java.lang.String r0 = r8.j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00d7
            java.lang.String r0 = r8.j
            java.lang.String r1 = "Shopping_cart"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x00d4
            java.lang.String r0 = r8.j
            java.lang.String r1 = "Tickets"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x00d7
        L_0x00d4:
            r8.setResult(r4)
        L_0x00d7:
            r8.finish()
            goto L_0x0185
        L_0x00dc:
            boolean r0 = r8.v()     // Catch:{ Exception -> 0x017d }
            if (r0 == 0) goto L_0x010f
            android.content.res.Resources r0 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r1 = 2131952595(0x7f1303d3, float:1.9541637E38)
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x017d }
            android.content.res.Resources r1 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r3 = 2131952594(0x7f1303d2, float:1.9541635E38)
            java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x017d }
            android.content.res.Resources r3 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r4 = 2131957304(0x7f131638, float:1.9551188E38)
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x017d }
            android.content.res.Resources r4 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r5 = 2131963455(0x7f132e3f, float:1.9563664E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x017d }
            goto L_0x013b
        L_0x010f:
            android.content.res.Resources r0 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r1 = 2131953033(0x7f130589, float:1.9542526E38)
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x017d }
            android.content.res.Resources r1 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r3 = 2131953034(0x7f13058a, float:1.9542528E38)
            java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x017d }
            android.content.res.Resources r3 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r4 = 2131966455(0x7f1339f7, float:1.9569749E38)
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x017d }
            android.content.res.Resources r4 = r8.getResources()     // Catch:{ Exception -> 0x017d }
            r5 = 2131959621(0x7f131f45, float:1.9555888E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x017d }
        L_0x013b:
            r5 = 2131368405(0x7f0a19d5, float:1.835676E38)
            android.view.View r5 = r8.findViewById(r5)     // Catch:{ Exception -> 0x017d }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x017d }
            if (r5 == 0) goto L_0x0153
            int r7 = r5.getVisibility()     // Catch:{ Exception -> 0x017d }
            if (r7 != 0) goto L_0x0153
            r6 = 8
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x017d }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x017d }
        L_0x0153:
            android.app.AlertDialog$Builder r5 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x017d }
            r5.<init>(r8)     // Catch:{ Exception -> 0x017d }
            r5.setTitle(r0)     // Catch:{ Exception -> 0x017d }
            r5.setMessage(r1)     // Catch:{ Exception -> 0x017d }
            net.one97.paytm.AJRRechargePaymentActivity$28 r0 = new net.one97.paytm.AJRRechargePaymentActivity$28     // Catch:{ Exception -> 0x017d }
            r0.<init>()     // Catch:{ Exception -> 0x017d }
            r5.setPositiveButton(r3, r0)     // Catch:{ Exception -> 0x017d }
            net.one97.paytm.AJRRechargePaymentActivity$2 r0 = new net.one97.paytm.AJRRechargePaymentActivity$2     // Catch:{ Exception -> 0x017d }
            r0.<init>(r6)     // Catch:{ Exception -> 0x017d }
            r5.setNegativeButton(r4, r0)     // Catch:{ Exception -> 0x017d }
            r5.setCancelable(r2)     // Catch:{ Exception -> 0x017d }
            android.app.AlertDialog r0 = r5.create()     // Catch:{ Exception -> 0x017d }
            r8.aR = r0     // Catch:{ Exception -> 0x017d }
            android.app.AlertDialog r0 = r8.aR     // Catch:{ Exception -> 0x017d }
            r0.show()     // Catch:{ Exception -> 0x017d }
            return
        L_0x017d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.onBackPressed():void");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        String str = "";
        if (i2 == 1001) {
            if (i3 == -1) {
                str = intent.getStringExtra("upi_mpin");
            }
            if (this.f51665f == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 19) {
                this.f51665f.loadUrl("javascript:setMpinAndSubmit('" + str + "', '" + UpiUtils.getDeviceId(getApplicationContext()) + "', '" + this.aU + "')");
                return;
            }
            this.f51665f.evaluateJavascript("(function() { return setMpinAndSubmit('" + str + "', '" + UpiUtils.getDeviceId(getApplicationContext()) + "', '" + this.aU + "'); } )();", new ValueCallback<String>() {
                public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                }
            });
        } else if (i2 == 1002) {
            if (i3 == -1) {
                str = intent.getStringExtra("upi_mpin");
            } else if (this.aE) {
                Intent intent2 = new Intent();
                intent2.putExtra("nativeSdkForMerchantMessage", "Error fetching mpin");
                setResult(0, intent2);
                if (i3 == 0) {
                    k(SDKConstants.CUI_ACTION_MPIN_BACK_PRESSED);
                } else {
                    k(SDKConstants.CUI_ACTION_ERROR_FETCHING_MPIN);
                }
                finish();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                w();
            } else if (!this.aE) {
                HashMap<String, String> hashMap = this.az;
                if (hashMap != null) {
                    hashMap.put(PayUtility.MPIN, str);
                    this.az.put(PayUtility.SEQ_NUMBER, this.aU);
                    this.az.put("device_id", UpiUtils.getDeviceId(this));
                }
                this.l.setmPGParams(this.az);
                z();
                a(true);
            } else if (!TextUtils.isEmpty(str)) {
                this.aK = intent;
                w();
            } else {
                Intent intent3 = new Intent();
                intent3.putExtra("nativeSdkForMerchantMessage", "Error fetching mpin");
                setResult(0, intent3);
                finish();
            }
        } else if (i2 == 3) {
            if (!com.paytm.utility.a.p(this) || (!this.aA && !this.aB)) {
                finish();
                return;
            }
            j(SDKConstants.AI_LOGIN_SCREEN);
            w();
        } else if (i2 == 1004) {
            if (i3 == -1) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("statusCode", 100);
                    jSONObject.put("statusMsg", "SUCCESS");
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                Intent intent4 = new Intent();
                intent4.putExtra(Payload.RESPONSE, jSONObject.toString());
                setResult(-1, intent4);
                finish();
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("statusCode", 104);
                jSONObject2.put("statusMsg", "FAILURE");
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            Intent intent5 = new Intent();
            intent5.putExtra(Payload.RESPONSE, jSONObject2.toString());
            setResult(-1, intent5);
            finish();
        } else if (i2 == 105) {
            String str2 = "javascript:window.upiIntent.intentAppClosed(" + i3 + ");";
            this.f51665f.loadUrl(str2);
            getClass().getCanonicalName();
            q.d("Js for acknowldgement".concat(String.valueOf(str2)));
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        net.one97.paytm.j.c.a();
        net.one97.paytm.payments.d.a.a((Activity) this, net.one97.paytm.j.c.ar());
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        Intent c2 = ba.c(this);
        if (TextUtils.isEmpty(str)) {
            c2.putExtra("order_id", this.l.getOrderId());
        } else {
            c2.putExtra("order_id", str);
        }
        c2.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.I);
        startActivity(c2);
        finish();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.V     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x000a
            r1.b((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            return
        L_0x000a:
            boolean r0 = r1.X     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0011
            r1.c((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.a(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public synchronized void a(Bundle bundle, String str) {
        if (!isFinishing()) {
            if (!this.aA) {
                if (!this.aE) {
                    a(str, false);
                    return;
                }
            }
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtra(SDKConstants.RESPONSE, bundle.getString(SDKConstants.RESPONSE));
            }
            intent.putExtra("nativeSdkForMerchantMessage", "");
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:137|138|139|140|141|142) */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x06a3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0296, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x0402 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:141:0x0402=Splitter:B:141:0x0402, B:419:0x0992=Splitter:B:419:0x0992, B:114:0x02e5=Splitter:B:114:0x02e5, B:432:0x09db=Splitter:B:432:0x09db} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.isFinishing()     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r8)
            return
        L_0x0009:
            net.one97.paytm.y r0 = r8.aT     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.aS     // Catch:{ all -> 0x0a92 }
            r0.setPaytmAssistFinalUrlKey(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.aS     // Catch:{ all -> 0x0a92 }
            int r0 = r0.length()     // Catch:{ all -> 0x0a92 }
            r1 = 1
            if (r0 <= r1) goto L_0x002a
            java.lang.String r0 = r8.aS     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = r8.aS     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "|"
            int r2 = r2.lastIndexOf(r3)     // Catch:{ all -> 0x0a92 }
            int r2 = r2 + r1
            java.lang.String r0 = r0.substring(r2)     // Catch:{ all -> 0x0a92 }
            goto L_0x002c
        L_0x002a:
            java.lang.String r0 = ""
        L_0x002c:
            net.one97.paytm.y r2 = r8.aT     // Catch:{ all -> 0x0a92 }
            r2.setPaytmAssistLastUrl(r0)     // Catch:{ all -> 0x0a92 }
            boolean r0 = r8.H     // Catch:{ all -> 0x0a92 }
            r2 = 0
            r3 = -1
            r4 = 0
            if (r0 == 0) goto L_0x01d9
            if (r10 == 0) goto L_0x0046
            r8.f((java.lang.String) r9)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.trustlist.c r9 = net.one97.paytm.trustlist.c.a()     // Catch:{ all -> 0x0a92 }
            r9.a((boolean) r4)     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0046:
            net.one97.paytm.trustlist.c r10 = net.one97.paytm.trustlist.c.a()     // Catch:{ all -> 0x0a92 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "frmSendMoney "
            r0.<init>(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.ay     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = " otp "
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.aP     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r1 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = " maskno "
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.aQ     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0a92 }
            com.paytm.utility.q.a(r0)     // Catch:{ all -> 0x0a92 }
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r0 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x008f
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r0 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            int r0 = r0.size()     // Catch:{ all -> 0x0a92 }
            if (r0 <= 0) goto L_0x008f
            java.lang.String r0 = r8.aP     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0097
        L_0x008f:
            java.lang.String r0 = r8.aQ     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x011e
        L_0x0097:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "in smsHoldercheck frmSendMoney "
            r0.<init>(r1)     // Catch:{ all -> 0x0a92 }
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r1 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            int r1 = r1.size()     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0a92 }
            com.paytm.utility.q.a(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.aP     // Catch:{ all -> 0x0a92 }
            r10.a((java.lang.String) r0)     // Catch:{ all -> 0x0a92 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0a92 }
            r5 = 30000(0x7530, double:1.4822E-319)
            long r0 = r0 - r5
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r5 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            if (r5 == 0) goto L_0x00dc
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r5 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            int r5 = r5.size()     // Catch:{ all -> 0x0a92 }
            if (r5 <= 0) goto L_0x00dc
            java.lang.String r2 = r8.ay     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.aP     // Catch:{ all -> 0x0a92 }
            java.util.ArrayList<net.one97.paytm.common.entity.trustlist.MessageInfo> r5 = r10.f65173a     // Catch:{ all -> 0x0a92 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.trustlist.MessageInfo r5 = (net.one97.paytm.common.entity.trustlist.MessageInfo) r5     // Catch:{ all -> 0x0a92 }
            java.lang.String r6 = r8.aQ     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.trustlist.d.a(r2, r0, r1, r5, r6)     // Catch:{ all -> 0x0a92 }
            goto L_0x00e9
        L_0x00dc:
            java.lang.String r5 = r8.ay     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.aP     // Catch:{ all -> 0x0a92 }
            java.lang.String r6 = r8.aQ     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.trustlist.d.a(r5, r0, r1, r2, r6)     // Catch:{ all -> 0x0a92 }
        L_0x00e9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "setAlarm "
            r0.<init>(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.ay     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0a92 }
            com.paytm.utility.q.a(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.ay     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x011e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "setAlarm >>>>>2 "
            r0.<init>(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r8.ay     // Catch:{ all -> 0x0a92 }
            r0.append(r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0a92 }
            com.paytm.utility.q.a(r0)     // Catch:{ all -> 0x0a92 }
            android.content.Context r0 = r8.getApplicationContext()     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.trustlist.TrustListService.a((android.content.Context) r0)     // Catch:{ all -> 0x0a92 }
        L_0x011e:
            r10.a((boolean) r4)     // Catch:{ all -> 0x0a92 }
            r8.q()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r10.<init>()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x01d1
            java.lang.String r0 = "intent_extra_wallet_order_id"
            r10.putExtra(r0, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_email"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_email"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_phone_number"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_phone_number"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_payee_sso_id"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_payee_sso_id"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_send_money_amount"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_send_money_amount"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_comment"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_comment"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_request_code"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_request_code"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_is_to_verify"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_is_to_verify"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_is_limit_applicable"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "intent_extra_wallet_is_limit_applicable"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_paytm_assist_gtmevents"
            net.one97.paytm.y r0 = r8.aT     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_bank_add_money"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_bank_add_money"
            boolean r0 = r0.getBooleanExtra(r1, r4)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_for_Gift_voucher"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_for_Gift_voucher"
            boolean r0 = r0.getBooleanExtra(r1, r4)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
        L_0x01d1:
            r8.setResult(r3, r10)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x01d9:
            boolean r0 = r8.O     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x09db
            boolean r0 = r8.R     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x09db
            boolean r0 = r8.S     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x09db
            boolean r0 = r8.Q     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x09db
            boolean r0 = r8.P     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x01ef
            goto L_0x09db
        L_0x01ef:
            boolean r0 = r8.aN     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0215
            android.content.Intent r0 = net.one97.paytm.utils.ba.g(r8)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = r8.D     // Catch:{ all -> 0x0a92 }
            if (r9 == 0) goto L_0x020d
            java.lang.String r9 = "tracking_info"
            java.lang.String r10 = r8.D     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
        L_0x020d:
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0215:
            boolean r0 = r8.aq     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0230
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0230:
            boolean r0 = r8.ad     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x026d
            java.lang.String r0 = "net.one97.paytm.o2o.amusementpark.activity.AmParkOrderSummary"
            android.content.Intent r0 = net.one97.paytm.deeplink.b.a((android.content.Context) r8, (java.lang.String) r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "From"
            java.lang.String r2 = "Payment"
            r0.putExtra(r1, r2)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "referralSource"
            java.lang.String r1 = r8.G     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "intent_extra_wallet_paytm_assist_gtmevents"
            net.one97.paytm.y r10 = r8.aT     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r9 = r8.C     // Catch:{ all -> 0x0a92 }
            if (r9 == 0) goto L_0x0265
            java.lang.String r9 = "tracking_info"
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r10 = r8.C     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
        L_0x0265:
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x026d:
            boolean r0 = r8.af     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x027b
            java.lang.String r10 = ""
            net.one97.paytm.marketplace.a.a((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x027b:
            boolean r0 = r8.T     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0297
            android.content.Intent r10 = net.one97.paytm.utils.ba.e(r8)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0295
            java.lang.String r0 = "hotel_booking_id"
            r10.putExtra(r0, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "from_payment"
            r10.putExtra(r9, r1)     // Catch:{ all -> 0x0a92 }
            r8.startActivity(r10)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
        L_0x0295:
            monitor-exit(r8)
            return
        L_0x0297:
            boolean r0 = r8.ai     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x02a3
            net.one97.paytm.utils.ba.a(r8, r9)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x02a3:
            boolean r0 = r8.aj     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x02b6
            android.content.Intent r9 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r9.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "is_from_payment"
            r9.putExtra(r10, r1)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x02b6:
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x02e5
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r5 = "gold"
            boolean r0 = r0.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x02e5
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_cancel"
            r0.putExtra(r1, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x02dd
            r8.setResult(r4, r0)     // Catch:{ all -> 0x0a92 }
            goto L_0x02e0
        L_0x02dd:
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
        L_0x02e0:
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x02e5:
            boolean r0 = r8.ah     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x03ba
            net.one97.paytm.postpayment.models.P2MPostPaymentDataModel$a r9 = new net.one97.paytm.postpayment.models.P2MPostPaymentDataModel$a     // Catch:{ all -> 0x0a92 }
            r9.<init>()     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.util.HashMap r10 = r10.getmPGParams()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "phone_no"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a92 }
            r9.f59707a = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.util.HashMap r10 = r10.getmPGParams()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "name"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a92 }
            r9.f59708b = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.util.HashMap r10 = r10.getmPGParams()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "TXN_AMOUNT"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a92 }
            r9.f59709c = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.util.HashMap r10 = r10.getmPGParams()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "comment"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a92 }
            r9.f59710d = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.util.HashMap r10 = r10.getmPGParams()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "tagline"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a92 }
            r9.f59711e = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getmOrderId()     // Catch:{ all -> 0x0a92 }
            r9.f59712f = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getmMID()     // Catch:{ all -> 0x0a92 }
            r9.f59713g = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r10 = r8.l     // Catch:{ all -> 0x0a92 }
            java.util.HashMap r10 = r10.getmPGParams()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "merchant_logo"
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a92 }
            r9.f59714h = r10     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "is_postpaid"
            boolean r10 = r10.getBooleanExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            r9.j = r10     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "is_ppb_transaction"
            boolean r10 = r10.getBooleanExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            r9.k = r10     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "is_upi"
            boolean r10 = r10.getBooleanExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            r9.l = r10     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "is_card_transaction"
            boolean r10 = r10.getBooleanExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            r9.m = r10     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "is_net_banking_transaction"
            boolean r10 = r10.getBooleanExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            r9.n = r10     // Catch:{ all -> 0x0a92 }
            boolean r10 = r8.bH     // Catch:{ all -> 0x0a92 }
            r9.o = r10     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.postpayment.models.P2MPostPaymentDataModel r10 = new net.one97.paytm.postpayment.models.P2MPostPaymentDataModel     // Catch:{ all -> 0x0a92 }
            r10.<init>(r9)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.wallet.utility.d r9 = net.one97.paytm.wallet.utility.d.f72319a     // Catch:{ IOException -> 0x03aa }
            net.one97.paytm.wallet.utility.d.a((android.content.Context) r8, (net.one97.paytm.postpayment.models.P2MPostPaymentDataModel) r10)     // Catch:{ IOException -> 0x03aa }
            goto L_0x03b2
        L_0x03aa:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0a92 }
            com.paytm.utility.q.b(r9)     // Catch:{ all -> 0x0a92 }
        L_0x03b2:
            r8.setResult(r4)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x03ba:
            boolean r0 = r8.U     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x03ed
            android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r10.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "From"
            java.lang.String r1 = "Payment"
            r10.putExtra(r0, r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "order_id"
            r10.putExtra(r0, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "redirectTo"
            java.lang.String r0 = "manage_debit"
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "CUST_PRODUCT"
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "CUST_PRODUCT"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)     // Catch:{ all -> 0x0a92 }
            r10.putExtra(r9, r0)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r3, r10)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x03ed:
            boolean r0 = r8.ak     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0413
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            if (r10 != 0) goto L_0x040b
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x0a92 }
            r10.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "ORDERID"
            r10.put(r1, r9)     // Catch:{ JSONException -> 0x0402 }
        L_0x0402:
            java.lang.String r9 = net.one97.paytm.nativesdk.Constants.SDKConstants.RESPONSE     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
        L_0x040b:
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0413:
            boolean r0 = r8.V     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x045f
            if (r10 == 0) goto L_0x043c
            android.content.Intent r9 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r9.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "order_id"
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.getOrderId()     // Catch:{ all -> 0x0a92 }
            r9.putExtra(r10, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "merchant_id"
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.getMID()     // Catch:{ all -> 0x0a92 }
            r9.putExtra(r10, r0)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r4, r9)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x043c:
            android.content.Intent r9 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r9.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "order_id"
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.getOrderId()     // Catch:{ all -> 0x0a92 }
            r9.putExtra(r10, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "merchant_id"
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r0.getMID()     // Catch:{ all -> 0x0a92 }
            r9.putExtra(r10, r0)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r3, r9)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x045f:
            boolean r0 = r8.W     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x048c
            android.content.Intent r9 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r9.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "order_id"
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r1 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r1.getOrderId()     // Catch:{ all -> 0x0a92 }
            r9.putExtra(r0, r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "merchant_id"
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r1 = r8.l     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = r1.getMID()     // Catch:{ all -> 0x0a92 }
            r9.putExtra(r0, r1)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0484
            r8.setResult(r4, r9)     // Catch:{ all -> 0x0a92 }
            goto L_0x0487
        L_0x0484:
            r8.setResult(r3, r9)     // Catch:{ all -> 0x0a92 }
        L_0x0487:
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x048c:
            boolean r0 = r8.X     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x049c
            if (r10 == 0) goto L_0x0497
            r8.c((boolean) r1)     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0497:
            r8.c((boolean) r4)     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x049c:
            boolean r0 = r8.aY     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x04a5
            r8.b((java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x04a5:
            boolean r0 = r8.aW     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x04be
            r8.q()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r10 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r10.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "KEY_ORDER_ID_TO_TRACK"
            r10.putExtra(r0, r9)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r3, r10)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x04be:
            boolean r0 = r8.Y     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x04df
            android.content.Intent r0 = net.one97.paytm.utils.ba.o(r8)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "From"
            java.lang.String r2 = "Payment"
            r0.putExtra(r1, r2)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x04df:
            boolean r0 = r8.Z     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x04e8
            r8.c((java.lang.String) r9, (boolean) r10)     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x04e8:
            boolean r0 = r8.al     // Catch:{ all -> 0x0a92 }
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            if (r0 == 0) goto L_0x06a4
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "screen_name_to_redirect"
            boolean r0 = r0.hasExtra(r2)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x06a2
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "screen_name_to_redirect"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = r0.setClassName(r8, r2)     // Catch:{ all -> 0x0a92 }
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "recharge cart"
            boolean r2 = r2.hasExtra(r3)     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x052c
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "recharge cart"
            java.io.Serializable r2 = r2.getSerializableExtra(r3)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.CJRRechargeCart r2 = (net.one97.paytm.common.entity.CJRRechargeCart) r2     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "recharge cart"
            r0.putExtra(r3, r2)     // Catch:{ all -> 0x0a92 }
        L_0x052c:
            java.lang.String r2 = "recharge_ga_data_for_summary"
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.at     // Catch:{ all -> 0x0a92 }
            java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x058a
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "Shopping_cart"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x058a
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            r0.addFlags(r6)     // Catch:{ all -> 0x0a92 }
            r0.addFlags(r5)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "order_id"
            r0.putExtra(r2, r9)     // Catch:{ all -> 0x0a92 }
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x0578
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "key_source"
            boolean r2 = r2.hasExtra(r3)     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x0578
            java.lang.String r2 = "key_source"
            android.content.Intent r3 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r4 = "key_source"
            java.lang.String r3 = r3.getStringExtra(r4)     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
        L_0x0578:
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r2 = r8.C     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x0588
            java.lang.String r2 = r8.D     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x0588
            java.lang.String r2 = "tracking_info"
            java.lang.String r3 = r8.D     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
        L_0x0588:
            r4 = 1
            goto L_0x05b9
        L_0x058a:
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x05a2
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "Recharge"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x05a2
            java.lang.String r2 = "Recharge"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
            goto L_0x05b9
        L_0x05a2:
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x05b9
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "Add_to_paytm_cash"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x05b9
            java.lang.String r2 = "Add_to_paytm_cash"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
        L_0x05b9:
            boolean r2 = r8.bp     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x05c3
            r2 = 268468224(0x10008000, float:2.5342157E-29)
            r0.addFlags(r2)     // Catch:{ all -> 0x0a92 }
        L_0x05c3:
            java.lang.String r2 = r8.au     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x05d6
            java.lang.String r2 = r8.au     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x05d6
            java.lang.String r2 = "Tab"
            java.lang.String r3 = r8.au     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
        L_0x05d6:
            java.lang.String r2 = r8.av     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x05e9
            java.lang.String r2 = r8.av     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x05e9
            java.lang.String r2 = "origin"
            java.lang.String r3 = r8.av     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
        L_0x05e9:
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "amount"
            boolean r2 = r2.hasExtra(r3)     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x060a
            android.content.Intent r2 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "amount"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ all -> 0x0a92 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r3 != 0) goto L_0x060a
            java.lang.String r3 = "amount"
            r0.putExtra(r3, r2)     // Catch:{ all -> 0x0a92 }
        L_0x060a:
            java.lang.String r2 = r8.aw     // Catch:{ all -> 0x0a92 }
            if (r2 == 0) goto L_0x061d
            java.lang.String r2 = r8.aw     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x061d
            java.lang.String r2 = "product_id"
            java.lang.String r3 = r8.aw     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
        L_0x061d:
            java.lang.String r2 = "From"
            java.lang.String r3 = "Payment"
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = r8.N     // Catch:{ all -> 0x0a92 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0a92 }
            if (r2 != 0) goto L_0x0634
            java.lang.String r2 = "order_id"
            java.lang.String r3 = r8.N     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
            goto L_0x0639
        L_0x0634:
            java.lang.String r2 = "order_id"
            r0.putExtra(r2, r9)     // Catch:{ all -> 0x0a92 }
        L_0x0639:
            java.lang.String r2 = "referralSource"
            java.lang.String r3 = r8.G     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "is_cancel"
            r0.putExtra(r2, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "intent_extra_wallet_paytm_assist_gtmevents"
            net.one97.paytm.y r2 = r8.aT     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r10, r2)     // Catch:{ all -> 0x0a92 }
            boolean r10 = r8.F     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0688
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0688
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0688
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "paytm.in"
            boolean r10 = r10.contains(r2)     // Catch:{ all -> 0x0a92 }
            if (r10 != 0) goto L_0x0681
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "paytm.com"
            boolean r10 = r10.contains(r2)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0679
            goto L_0x0681
        L_0x0679:
            java.lang.String r10 = "pg_screen"
            java.lang.String r2 = "2"
            r0.putExtra(r10, r2)     // Catch:{ all -> 0x0a92 }
            goto L_0x0688
        L_0x0681:
            java.lang.String r10 = "pg_screen"
            java.lang.String r2 = "1"
            r0.putExtra(r10, r2)     // Catch:{ all -> 0x0a92 }
        L_0x0688:
            if (r4 == 0) goto L_0x069c
            boolean r9 = net.one97.paytm.marketplace.a.a((java.lang.String) r9, (boolean) r1)     // Catch:{ all -> 0x0a92 }
            if (r9 != 0) goto L_0x069f
            java.lang.String r9 = "target_activity_tag"
            java.lang.String r10 = "OrderSummaryActivityTag"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.marketplace.a.a((android.app.Activity) r8, (android.content.Intent) r0)     // Catch:{ all -> 0x0a92 }
            goto L_0x069f
        L_0x069c:
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
        L_0x069f:
            r8.finish()     // Catch:{ all -> 0x0a92 }
        L_0x06a2:
            monitor-exit(r8)
            return
        L_0x06a4:
            boolean r0 = r8.am     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x06bf
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x06bf:
            boolean r0 = r8.an     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x070b
            android.content.Intent r0 = net.one97.paytm.deeplink.j.a((android.content.Context) r8)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_cancel"
            r0.putExtra(r1, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "From"
            java.lang.String r2 = "Payment"
            r0.putExtra(r1, r2)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x06de
            r8.setResult(r4)     // Catch:{ all -> 0x0a92 }
            goto L_0x0706
        L_0x06de:
            java.lang.String r10 = r8.ar     // Catch:{ all -> 0x0a92 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a92 }
            if (r10 != 0) goto L_0x06fb
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            r10.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.ar     // Catch:{ all -> 0x0a92 }
            r10.append(r0)     // Catch:{ all -> 0x0a92 }
            r10.append(r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.deeplink.j.a((android.content.Context) r8, (java.lang.String) r9)     // Catch:{ all -> 0x0a92 }
            goto L_0x0706
        L_0x06fb:
            boolean r9 = r8.as     // Catch:{ all -> 0x0a92 }
            if (r9 == 0) goto L_0x0703
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            goto L_0x0706
        L_0x0703:
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
        L_0x0706:
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x070b:
            boolean r0 = r8.ao     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x072c
            android.content.Intent r0 = net.one97.paytm.deeplink.j.b(r8)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "From"
            java.lang.String r10 = "Payment"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x072c:
            boolean r0 = r8.ap     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0770
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_cancel"
            r0.putExtra(r1, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "From"
            java.lang.String r2 = "Payment"
            r0.putExtra(r1, r2)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x074c
            r8.setResult(r4)     // Catch:{ all -> 0x0a92 }
            goto L_0x076b
        L_0x074c:
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r8.ar     // Catch:{ all -> 0x0a92 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a92 }
            if (r10 != 0) goto L_0x076b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            r10.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.ar     // Catch:{ all -> 0x0a92 }
            r10.append(r0)     // Catch:{ all -> 0x0a92 }
            r10.append(r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.deeplink.j.a((android.content.Context) r8, (java.lang.String) r9)     // Catch:{ all -> 0x0a92 }
        L_0x076b:
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0770:
            java.lang.String r0 = "channel"
            java.lang.String r7 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = r0.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0791
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "CANCELLED"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0791:
            java.lang.String r0 = "postpaid"
            java.lang.String r7 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = r0.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x07a5
            java.lang.String r0 = "lending"
            java.lang.String r7 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = r0.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x07b3
        L_0x07a5:
            boolean r0 = r8.bI     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x0992
            java.lang.String r0 = r8.bJ     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x07b3
            goto L_0x0992
        L_0x07b3:
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "recharge cart"
            java.io.Serializable r0 = r0.getSerializableExtra(r2)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0     // Catch:{ all -> 0x0a92 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            java.lang.Class<net.one97.paytm.AJROrderSummaryActivity> r3 = net.one97.paytm.AJROrderSummaryActivity.class
            r2.<init>(r8, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "recharge cart"
            r2.putExtra(r3, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "recharge_ga_data_for_summary"
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.at     // Catch:{ all -> 0x0a92 }
            java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r0, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x0829
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "Shopping_cart"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0829
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r2.<init>()     // Catch:{ all -> 0x0a92 }
            r2.addFlags(r6)     // Catch:{ all -> 0x0a92 }
            r2.addFlags(r5)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "order_id"
            r2.putExtra(r0, r9)     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0817
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "key_source"
            boolean r0 = r0.hasExtra(r3)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0817
            java.lang.String r0 = "key_source"
            android.content.Intent r3 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r5 = "key_source"
            java.lang.String r3 = r3.getStringExtra(r5)     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r0, r3)     // Catch:{ all -> 0x0a92 }
        L_0x0817:
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r0 = r8.C     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0827
            java.lang.String r0 = r8.D     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0827
            java.lang.String r0 = "tracking_info"
            java.lang.String r3 = r8.D     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r0, r3)     // Catch:{ all -> 0x0a92 }
        L_0x0827:
            r0 = 1
            goto L_0x0859
        L_0x0829:
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x0841
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "Recharge"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0841
            java.lang.String r0 = "Recharge"
            r2.putExtra(r0, r1)     // Catch:{ all -> 0x0a92 }
            goto L_0x0858
        L_0x0841:
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a92 }
            if (r0 != 0) goto L_0x0858
            java.lang.String r0 = r8.j     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = "Add_to_paytm_cash"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0858
            java.lang.String r0 = "Add_to_paytm_cash"
            r2.putExtra(r0, r1)     // Catch:{ all -> 0x0a92 }
        L_0x0858:
            r0 = 0
        L_0x0859:
            java.lang.String r3 = r8.au     // Catch:{ all -> 0x0a92 }
            if (r3 == 0) goto L_0x086c
            java.lang.String r3 = r8.au     // Catch:{ all -> 0x0a92 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0a92 }
            if (r3 != 0) goto L_0x086c
            java.lang.String r3 = "Tab"
            java.lang.String r5 = r8.au     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x0a92 }
        L_0x086c:
            java.lang.String r3 = r8.av     // Catch:{ all -> 0x0a92 }
            if (r3 == 0) goto L_0x087f
            java.lang.String r3 = r8.av     // Catch:{ all -> 0x0a92 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0a92 }
            if (r3 != 0) goto L_0x087f
            java.lang.String r3 = "origin"
            java.lang.String r5 = r8.av     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x0a92 }
        L_0x087f:
            android.content.Intent r3 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r5 = "amount"
            boolean r3 = r3.hasExtra(r5)     // Catch:{ all -> 0x0a92 }
            if (r3 == 0) goto L_0x08a0
            android.content.Intent r3 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r5 = "amount"
            java.lang.String r3 = r3.getStringExtra(r5)     // Catch:{ all -> 0x0a92 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0a92 }
            if (r5 != 0) goto L_0x08a0
            java.lang.String r5 = "amount"
            r2.putExtra(r5, r3)     // Catch:{ all -> 0x0a92 }
        L_0x08a0:
            java.lang.String r3 = r8.aw     // Catch:{ all -> 0x0a92 }
            if (r3 == 0) goto L_0x08b3
            java.lang.String r3 = r8.aw     // Catch:{ all -> 0x0a92 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0a92 }
            if (r3 != 0) goto L_0x08b3
            java.lang.String r3 = "product_id"
            java.lang.String r5 = r8.aw     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x0a92 }
        L_0x08b3:
            java.lang.String r3 = "From"
            java.lang.String r5 = "Payment"
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x0a92 }
            java.lang.String r3 = r8.N     // Catch:{ all -> 0x0a92 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0a92 }
            if (r3 != 0) goto L_0x08ca
            java.lang.String r3 = "order_id"
            java.lang.String r5 = r8.N     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x0a92 }
            goto L_0x08cf
        L_0x08ca:
            java.lang.String r3 = "order_id"
            r2.putExtra(r3, r9)     // Catch:{ all -> 0x0a92 }
        L_0x08cf:
            java.lang.String r3 = "Education"
            android.content.Intent r5 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r6 = "From"
            java.lang.String r5 = r5.getStringExtra(r6)     // Catch:{ all -> 0x0a92 }
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0a92 }
            if (r3 == 0) goto L_0x08e6
            java.lang.String r3 = "isEducationVertical"
            r2.putExtra(r3, r1)     // Catch:{ all -> 0x0a92 }
        L_0x08e6:
            java.lang.String r1 = "is_from_bus_ticket"
            boolean r3 = r8.R     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r1, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "referralSource"
            java.lang.String r3 = r8.G     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r1, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_cancel"
            r2.putExtra(r1, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = "intent_extra_wallet_paytm_assist_gtmevents"
            net.one97.paytm.y r1 = r8.aT     // Catch:{ all -> 0x0a92 }
            r2.putExtra(r10, r1)     // Catch:{ all -> 0x0a92 }
            boolean r10 = r8.F     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x093c
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x093c
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x093c
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "paytm.in"
            boolean r10 = r10.contains(r1)     // Catch:{ all -> 0x0a92 }
            if (r10 != 0) goto L_0x0935
            android.webkit.WebView r10 = r8.f51665f     // Catch:{ all -> 0x0a92 }
            java.lang.String r10 = r10.getUrl()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "paytm.com"
            boolean r10 = r10.contains(r1)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x092d
            goto L_0x0935
        L_0x092d:
            java.lang.String r10 = "pg_screen"
            java.lang.String r1 = "2"
            r2.putExtra(r10, r1)     // Catch:{ all -> 0x0a92 }
            goto L_0x093c
        L_0x0935:
            java.lang.String r10 = "pg_screen"
            java.lang.String r1 = "1"
            r2.putExtra(r10, r1)     // Catch:{ all -> 0x0a92 }
        L_0x093c:
            if (r0 == 0) goto L_0x098a
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x0963
            android.content.Intent r10 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "isMGV"
            boolean r10 = r10.getBooleanExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = r8.getIntent()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "isPAYTMSTORE"
            boolean r4 = r0.getBooleanExtra(r1, r4)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "isMGV"
            r2.putExtra(r0, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "isPAYTMSTORE"
            r2.putExtra(r0, r4)     // Catch:{ all -> 0x0a92 }
            goto L_0x0964
        L_0x0963:
            r10 = 0
        L_0x0964:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            r0.append(r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "?isMGV="
            r0.append(r9)     // Catch:{ all -> 0x0a92 }
            r0.append(r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0a92 }
            boolean r9 = net.one97.paytm.marketplace.a.a((java.lang.String) r9, (boolean) r4)     // Catch:{ all -> 0x0a92 }
            if (r9 != 0) goto L_0x098d
            java.lang.String r9 = "target_activity_tag"
            java.lang.String r10 = "OrderSummaryActivityTag"
            r2.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.marketplace.a.a((android.app.Activity) r8, (android.content.Intent) r2)     // Catch:{ all -> 0x0a92 }
            goto L_0x098d
        L_0x098a:
            r8.startActivity(r2)     // Catch:{ all -> 0x0a92 }
        L_0x098d:
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0992:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            r0.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "is_cancel"
            r0.putExtra(r1, r10)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "From"
            java.lang.String r5 = "Payment"
            r0.putExtra(r1, r5)     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x09ae
            r8.setResult(r4)     // Catch:{ all -> 0x0a92 }
            goto L_0x09d6
        L_0x09ae:
            boolean r10 = r8.bI     // Catch:{ all -> 0x0a92 }
            if (r10 == 0) goto L_0x09b6
            r8.setResult(r3, r0)     // Catch:{ all -> 0x0a92 }
            goto L_0x09d6
        L_0x09b6:
            java.lang.String r10 = r8.bJ     // Catch:{ all -> 0x0a92 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a92 }
            if (r10 != 0) goto L_0x09d6
            net.one97.paytm.deeplink.h$a r10 = net.one97.paytm.deeplink.h.f50349a     // Catch:{ all -> 0x0a92 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "paytmmp://paytm-postpaid?postpaidh5url="
            r10.<init>(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = r8.bJ     // Catch:{ all -> 0x0a92 }
            r10.append(r0)     // Catch:{ all -> 0x0a92 }
            r10.append(r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.deeplink.h.a.a(r8, r9, r2)     // Catch:{ all -> 0x0a92 }
        L_0x09d6:
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x09db:
            boolean r0 = r8.O     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x09f2
            java.lang.String r0 = ""
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0a92 }
            r1.<init>()     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "orderItemId"
            r1.put(r2, r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r0 = "net.one97.paytm.o2o.events.activity.EventOrderSummary"
            android.content.Intent r0 = net.one97.paytm.deeplink.k.a((android.content.Context) r8, (java.lang.String) r0, (java.util.HashMap<java.lang.String, java.lang.String>) r1)     // Catch:{ all -> 0x0a92 }
            goto L_0x0a5f
        L_0x09f2:
            boolean r0 = r8.P     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x09ff
            android.content.Context r0 = r8.getApplicationContext()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = net.one97.paytm.utils.ba.i(r0)     // Catch:{ all -> 0x0a92 }
            goto L_0x0a5f
        L_0x09ff:
            boolean r0 = r8.S     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0a1d
            android.content.Context r0 = r8.getApplicationContext()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = net.one97.paytm.utils.ba.f(r0)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "order-summary-type"
            java.lang.String r3 = "flight"
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "is_from_pg_page"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "isGAEvents"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
            goto L_0x0a5f
        L_0x0a1d:
            boolean r0 = r8.R     // Catch:{ all -> 0x0a92 }
            if (r0 == 0) goto L_0x0a59
            android.content.Context r0 = r8.getApplicationContext()     // Catch:{ all -> 0x0a92 }
            android.content.Intent r0 = net.one97.paytm.utils.ba.d(r0)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.j.c.a()     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "busOrderSummaryRoundtripVersion"
            int r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (int) r4)     // Catch:{ all -> 0x0a92 }
            r3 = 720656(0xaff10, float:1.009854E-39)
            if (r3 >= r2) goto L_0x0a47
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0a92 }
            android.content.Context r2 = r8.getApplicationContext()     // Catch:{ all -> 0x0a92 }
            java.lang.Class<net.one97.paytm.AJROrderSummaryActivity> r3 = net.one97.paytm.AJROrderSummaryActivity.class
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "is_from_bus_ticket"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
        L_0x0a47:
            java.lang.String r2 = "order-summary-type"
            java.lang.String r3 = "bus"
            r0.putExtra(r2, r3)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "is_from_pg_page"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r2 = "isGAEvents"
            r0.putExtra(r2, r1)     // Catch:{ all -> 0x0a92 }
            goto L_0x0a5f
        L_0x0a59:
            java.lang.String r0 = "net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary"
            android.content.Intent r0 = net.one97.paytm.deeplink.z.a(r8, r0, r2)     // Catch:{ all -> 0x0a92 }
        L_0x0a5f:
            java.lang.String r1 = "From"
            java.lang.String r2 = "Payment"
            r0.putExtra(r1, r2)     // Catch:{ all -> 0x0a92 }
            java.lang.String r1 = "order_id"
            r0.putExtra(r1, r9)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "referralSource"
            java.lang.String r1 = r8.G     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r1)     // Catch:{ all -> 0x0a92 }
            java.lang.String r9 = "is_cancel"
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r9 = r8.C     // Catch:{ all -> 0x0a92 }
            if (r9 == 0) goto L_0x0a83
            java.lang.String r9 = "tracking_info"
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r10 = r8.C     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
        L_0x0a83:
            java.lang.String r9 = "intent_extra_wallet_paytm_assist_gtmevents"
            net.one97.paytm.y r10 = r8.aT     // Catch:{ all -> 0x0a92 }
            r0.putExtra(r9, r10)     // Catch:{ all -> 0x0a92 }
            r8.startActivity(r0)     // Catch:{ all -> 0x0a92 }
            r8.finish()     // Catch:{ all -> 0x0a92 }
            monitor-exit(r8)
            return
        L_0x0a92:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.a(java.lang.String, boolean):void");
    }

    private void b(String str, boolean z) {
        if (!z) {
            getIntent().putExtra("is_my_order_screen", false);
            getIntent().putExtra("show_home", true);
            getIntent().putExtra("order_id", str);
            getIntent().putExtra(UpiConstants.FROM, "Insurance");
            net.one97.paytm.deeplink.q qVar = net.one97.paytm.deeplink.q.f50365a;
            net.one97.paytm.deeplink.q.a((Context) this, getIntent());
        } else {
            getIntent().putExtra("order_id", str);
            getIntent().putExtra(AppConstants.IS_CANCEL, z);
            setResult(-1, getIntent());
        }
        finish();
    }

    private void b(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("order_id", this.l.getOrderId());
        intent.putExtra("merchant_id", this.l.getMID());
        intent.putExtra("retry_allowed", str);
        intent.putExtra("error_message", str2);
        setResult(-1, intent);
        finish();
    }

    private void c(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("order_id", this.l.getOrderId());
        intent.putExtra("merchant_id", this.l.getMID());
        intent.putExtra(AppConstants.IS_CANCEL, z);
        setResult(-1, intent);
        finish();
    }

    private void c(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("order_id", this.l.getOrderId());
        intent.putExtra("merchant_id", this.l.getMID());
        intent.putExtra(AppConstants.IS_CANCEL, false);
        intent.putExtra("retry_allowed", str);
        intent.putExtra("error_message", str2);
        setResult(-1, intent);
        finish();
    }

    private boolean v() {
        WebView webView;
        if (!this.F || (webView = this.f51665f) == null || webView.getUrl() == null || this.f51665f.getUrl().contains("paytm.in") || this.f51665f.getUrl().contains("paytm.com")) {
            return false;
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        j();
        k();
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public void f(String str) {
        q();
        Intent intent = new Intent();
        if (getIntent() != null) {
            intent.putExtra("intent_extra_wallet_order_id", str);
            intent.putExtra("intent_extra_wallet_email", getIntent().getStringExtra("intent_extra_wallet_email"));
            intent.putExtra("intent_extra_wallet_phone_number", getIntent().getStringExtra("intent_extra_wallet_phone_number"));
            intent.putExtra("intent_extra_wallet_payee_sso_id", getIntent().getStringExtra("intent_extra_wallet_payee_sso_id"));
            intent.putExtra("intent_extra_wallet_send_money_amount", getIntent().getStringExtra("intent_extra_wallet_send_money_amount"));
            intent.putExtra("intent_extra_wallet_comment", getIntent().getStringExtra("intent_extra_wallet_comment"));
            intent.putExtra("intent_extra_wallet_request_code", getIntent().getStringExtra("intent_extra_wallet_request_code"));
            intent.putExtra("intent_extra_wallet_is_to_verify", getIntent().getStringExtra("intent_extra_wallet_is_to_verify"));
            intent.putExtra("intent_extra_wallet_is_limit_applicable", getIntent().getStringExtra("intent_extra_wallet_is_limit_applicable"));
            intent.putExtra("intent_extra_wallet_is_payment_cancelled", true);
            intent.putExtra("intent_extra_wallet_paytm_assist_gtmevents", this.aT);
            intent.putExtra("is_bank_add_money", getIntent().getBooleanExtra("is_bank_add_money", false));
            intent.putExtra("is_for_Gift_voucher", getIntent().getBooleanExtra("is_for_Gift_voucher", false));
            WebView webView = this.f51665f;
            if (!(webView == null || webView.getUrl() == null)) {
                if (this.f51665f.getUrl().contains("paytm.in") || this.f51665f.getUrl().contains("paytm.com")) {
                    intent.putExtra("pg_screen", "1");
                } else {
                    intent.putExtra("pg_screen", "2");
                }
            }
        }
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.v()     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0078
            boolean r0 = r12.F     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0024
            android.webkit.WebView r0 = r12.f51665f     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0024
            android.webkit.WebView r0 = r12.f51665f     // Catch:{ all -> 0x007a }
            java.lang.String r0 = r0.getUrl()     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0024
            android.webkit.WebView r0 = r12.f51665f     // Catch:{ all -> 0x007a }
            java.lang.String r0 = r0.getUrl()     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "paytm.in/theia/payment/request"
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x007a }
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 != 0) goto L_0x0078
            net.one97.paytm.j.c.a()     // Catch:{ all -> 0x007a }
            java.lang.String r0 = "pgCancelOrderNew"
            r1 = 0
            java.lang.String r3 = net.one97.paytm.j.c.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x007a }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0039
            monitor-exit(r12)
            return
        L_0x0039:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x007a }
            r0.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "MID"
            r0.put(r1, r14)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r14 = "ORDER_ID"
            r0.put(r14, r13)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r13 = "USER_TOKEN"
            java.lang.String r14 = com.paytm.utility.a.q(r12)     // Catch:{ Exception -> 0x0052 }
            r0.put(r13, r14)     // Catch:{ Exception -> 0x0052 }
            goto L_0x005e
        L_0x0052:
            r13 = move-exception
            boolean r14 = com.paytm.utility.b.v     // Catch:{ all -> 0x007a }
            if (r14 == 0) goto L_0x005e
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x007a }
            com.paytm.utility.q.b(r13)     // Catch:{ all -> 0x007a }
        L_0x005e:
            r5 = 0
            r6 = 0
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.POST     // Catch:{ all -> 0x007a }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x007a }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r9 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment     // Catch:{ all -> 0x007a }
            r9.<init>()     // Catch:{ all -> 0x007a }
            com.paytm.network.a$c r10 = com.paytm.network.a.c.PAYMENTS     // Catch:{ all -> 0x007a }
            com.paytm.network.a$b r11 = com.paytm.network.a.b.SILENT     // Catch:{ all -> 0x007a }
            r2 = r12
            r4 = r12
            com.paytm.network.a r13 = net.one97.paytm.common.b.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x007a }
            r13.a()     // Catch:{ all -> 0x007a }
        L_0x0078:
            monitor-exit(r12)
            return
        L_0x007a:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.d(java.lang.String, java.lang.String):void");
    }

    private void b(Context context) {
        try {
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.isDirectory()) {
                a(cacheDir);
            }
        } catch (Exception unused) {
        }
    }

    private boolean a(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private void w() {
        a(false, "", (PaytmSDKRequestClient) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x04f5 A[Catch:{ Exception -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0523 A[Catch:{ Exception -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0525 A[Catch:{ Exception -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x057e A[Catch:{ Exception -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x05b6 A[Catch:{ Exception -> 0x0628 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x05c2 A[Catch:{ Exception -> 0x0628 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r32, java.lang.String r33, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient r34) {
        /*
            r31 = this;
            r14 = r31
            r1 = r34
            java.lang.String r2 = "enableScpText"
            java.lang.String r3 = "isToUseDeferedFlowForAddMoney"
            java.lang.String r4 = "merchant_id"
            java.lang.String r5 = "enable_paytm_invoke"
            java.lang.String r6 = "price"
            java.lang.String r7 = "recharge cart"
            java.lang.String r0 = "verify"
            java.lang.String r8 = "AJRRechargePaymentActivity"
            java.lang.String r15 = "From"
            java.lang.String r9 = "txnToken"
            java.lang.String r13 = ""
            boolean r10 = r14.aB     // Catch:{ Exception -> 0x062a }
            if (r10 != 0) goto L_0x0026
            boolean r10 = r31.e()     // Catch:{ Exception -> 0x062a }
            if (r10 == 0) goto L_0x004f
        L_0x0026:
            boolean r10 = com.paytm.utility.a.p(r31)     // Catch:{ Exception -> 0x062a }
            if (r10 != 0) goto L_0x004f
            java.util.Timer r0 = new java.util.Timer     // Catch:{ Exception -> 0x062a }
            r0.<init>()     // Catch:{ Exception -> 0x062a }
            r14.bO = r0     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.AJRRechargePaymentActivity$3 r0 = new net.one97.paytm.AJRRechargePaymentActivity$3     // Catch:{ Exception -> 0x062a }
            r0.<init>()     // Catch:{ Exception -> 0x062a }
            r14.bP = r0     // Catch:{ Exception -> 0x062a }
            java.util.Timer r0 = r14.bO     // Catch:{ Exception -> 0x062a }
            java.util.TimerTask r1 = r14.bP     // Catch:{ Exception -> 0x062a }
            r2 = 5000(0x1388, double:2.4703E-320)
            r0.schedule(r1, r2)     // Catch:{ Exception -> 0x062a }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x062a }
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r1 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r0.<init>(r14, r1)     // Catch:{ Exception -> 0x062a }
            r1 = 3
            r14.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x062a }
            return
        L_0x004f:
            boolean r10 = r14.aE     // Catch:{ Exception -> 0x062a }
            if (r10 == 0) goto L_0x005b
            android.content.Intent r10 = r14.aK     // Catch:{ Exception -> 0x062a }
            if (r10 != 0) goto L_0x005b
            r31.x()     // Catch:{ Exception -> 0x062a }
            return
        L_0x005b:
            boolean r10 = r14.aF     // Catch:{ Exception -> 0x062a }
            if (r10 != 0) goto L_0x0622
            boolean r10 = r14.aG     // Catch:{ Exception -> 0x062a }
            if (r10 == 0) goto L_0x0065
            goto L_0x0622
        L_0x0065:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x062a }
            r10.<init>()     // Catch:{ Exception -> 0x062a }
            android.content.Context r11 = r31.getApplicationContext()     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.payments.visascp.VisaSCP r16 = net.one97.paytm.app.CJRJarvisApplication.a((android.content.Context) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.String r17 = com.paytm.utility.a.q(r31)     // Catch:{ Exception -> 0x062a }
            java.lang.String r18 = "SSO"
            java.lang.String r19 = com.paytm.utility.a.a((android.content.Context) r31)     // Catch:{ Exception -> 0x062a }
            r20 = 0
            r21 = 0
            r16.checkAllEnrolledCards(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x062a }
            android.content.Intent r11 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            if (r11 == 0) goto L_0x00aa
            android.content.Intent r11 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            boolean r11 = r11.hasExtra(r0)     // Catch:{ Exception -> 0x062a }
            if (r11 == 0) goto L_0x00aa
            android.content.Intent r11 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r0 = r11.getStringExtra(r0)     // Catch:{ Exception -> 0x062a }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a2 }
            r11.<init>(r0)     // Catch:{ JSONException -> 0x00a2 }
            r10 = r11
            goto L_0x00aa
        L_0x00a2:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x062a }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x062a }
        L_0x00aa:
            android.content.Intent r0 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = "Recharge_Payment_info"
            java.io.Serializable r0 = r0.getSerializableExtra(r11)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r0     // Catch:{ Exception -> 0x062a }
            r14.l = r0     // Catch:{ Exception -> 0x062a }
            android.content.Intent r0 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = "tracking_info"
            android.os.Parcelable r0 = r0.getParcelableExtra(r11)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r0 = (net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo) r0     // Catch:{ Exception -> 0x062a }
            r14.C = r0     // Catch:{ Exception -> 0x062a }
            android.content.Intent r0 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = "tracking_info_string"
            java.lang.String r0 = r0.getStringExtra(r11)     // Catch:{ Exception -> 0x062a }
            r14.D = r0     // Catch:{ Exception -> 0x062a }
            android.content.Intent r0 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = "referralSource"
            java.lang.String r0 = r0.getStringExtra(r11)     // Catch:{ Exception -> 0x062a }
            r14.G = r0     // Catch:{ Exception -> 0x062a }
            android.content.Intent r0 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            if (r0 == 0) goto L_0x00ff
            boolean r11 = r0.hasExtra(r7)     // Catch:{ Exception -> 0x062a }
            if (r11 == 0) goto L_0x00ff
            java.io.Serializable r6 = r0.getSerializableExtra(r7)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.common.entity.CJRRechargeCart r6 = (net.one97.paytm.common.entity.CJRRechargeCart) r6     // Catch:{ Exception -> 0x062a }
            r14.E = r6     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.common.entity.CJRRechargeCart r6 = r14.E     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.common.entity.shopping.CJRCart r6 = r6.getCart()     // Catch:{ Exception -> 0x062a }
            java.lang.String r6 = r6.getOrderTotal()     // Catch:{ Exception -> 0x062a }
            goto L_0x010d
        L_0x00ff:
            if (r0 == 0) goto L_0x010c
            boolean r7 = r0.hasExtra(r6)     // Catch:{ Exception -> 0x062a }
            if (r7 == 0) goto L_0x010c
            java.lang.String r6 = r0.getStringExtra(r6)     // Catch:{ Exception -> 0x062a }
            goto L_0x010d
        L_0x010c:
            r6 = r13
        L_0x010d:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x062a }
            r12 = 0
            if (r7 == 0) goto L_0x0122
            r0 = 2131954796(0x7f130c6c, float:1.9546101E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r14, r0, r12)     // Catch:{ Exception -> 0x062a }
            r0.show()     // Catch:{ Exception -> 0x062a }
            r31.finish()     // Catch:{ Exception -> 0x062a }
            return
        L_0x0122:
            android.content.Intent r7 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            if (r7 == 0) goto L_0x013c
            android.content.Intent r7 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            boolean r7 = r7.hasExtra(r5)     // Catch:{ Exception -> 0x062a }
            if (r7 == 0) goto L_0x013c
            android.content.Intent r7 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            boolean r5 = r7.getBooleanExtra(r5, r12)     // Catch:{ Exception -> 0x062a }
            r14.aA = r5     // Catch:{ Exception -> 0x062a }
        L_0x013c:
            android.content.Intent r5 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            if (r5 == 0) goto L_0x016a
            android.content.Intent r5 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            boolean r5 = r5.hasExtra(r4)     // Catch:{ Exception -> 0x062a }
            if (r5 == 0) goto L_0x016a
            android.content.Intent r5 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r4 = r5.getStringExtra(r4)     // Catch:{ Exception -> 0x062a }
            r14.bN = r4     // Catch:{ Exception -> 0x062a }
            java.lang.String r4 = r14.bN     // Catch:{ Exception -> 0x062a }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x062a }
            if (r4 == 0) goto L_0x016a
            android.content.Intent r4 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = com.paytm.utility.e.aT     // Catch:{ Exception -> 0x062a }
            java.lang.String r4 = r4.getStringExtra(r5)     // Catch:{ Exception -> 0x062a }
            r14.bN = r4     // Catch:{ Exception -> 0x062a }
        L_0x016a:
            java.lang.String r4 = r14.bN     // Catch:{ Exception -> 0x062a }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "mid"
            if (r4 == 0) goto L_0x017e
            android.content.Intent r4 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r4 = r4.getStringExtra(r5)     // Catch:{ Exception -> 0x062a }
            r14.bN = r4     // Catch:{ Exception -> 0x062a }
        L_0x017e:
            android.content.Intent r4 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r7 = "orderid"
            java.lang.String r4 = r4.getStringExtra(r7)     // Catch:{ Exception -> 0x062a }
            r14.bM = r4     // Catch:{ Exception -> 0x062a }
            android.content.Intent r4 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r4 = r4.getStringExtra(r9)     // Catch:{ Exception -> 0x062a }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x062a }
            r7.<init>()     // Catch:{ Exception -> 0x062a }
            android.content.Intent r11 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = r11.getStringExtra(r9)     // Catch:{ Exception -> 0x062a }
            r7.put(r9, r11)     // Catch:{ Exception -> 0x062a }
            java.lang.String r9 = "authenticated"
            r11 = 1
            r7.put(r9, r11)     // Catch:{ Exception -> 0x062a }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x062a }
            r9.<init>()     // Catch:{ Exception -> 0x062a }
            java.lang.String r12 = "body"
            r9.put(r12, r7)     // Catch:{ Exception -> 0x062a }
            java.lang.String r7 = "head"
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x062a }
            r12.<init>()     // Catch:{ Exception -> 0x062a }
            r9.put(r7, r12)     // Catch:{ Exception -> 0x062a }
            java.lang.String r7 = r0.getStringExtra(r15)     // Catch:{ Exception -> 0x062a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = "vertical-: "
            r12.<init>(r11)     // Catch:{ Exception -> 0x062a }
            r12.append(r7)     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = " AddMoney GTM: "
            r12.append(r11)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            r18 = r5
            r11 = 1
            boolean r5 = net.one97.paytm.j.c.a((java.lang.String) r3, (boolean) r11)     // Catch:{ Exception -> 0x062a }
            r12.append(r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.utils.r.a((java.lang.String) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x062a }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ Exception -> 0x062a }
            r12.<init>()     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            r11 = 0
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r2, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpEnabledText"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpEnabledText"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "enableScpInfoDescription"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "enableScpInfoDescription"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "enableScpInfoNote"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "enableScpInfoNote"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpEnabledInfoNote"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpEnabledInfoNote"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpTransactionMaxTimer"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpTransactionMaxTimer"
            r11 = 45
            int r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (int) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpTransactionStateChangeTimer"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpTransactionStateChangeTimer"
            r11 = 4
            int r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (int) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpEnabledInfoDescription"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpEnabledInfoDescription"
            r11 = 0
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpPaymentProcessingText1"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpPaymentProcessingText1"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpPaymentProcessingText2"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpPaymentProcessingText2"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "scpPaymentProcessingText3"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "scpPaymentProcessingText3"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "offlineUpiPromotionalText"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "offlineUpiPromotionalText"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "one_click_info_help_text_header"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "one_click_info_help_text_header"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "vscp_repeat_error_msg"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "vscp_repeat_error_msg"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "GOOGLE_SAFTEY_NET_KEY"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "google_safety_net_api_key"
            java.lang.String r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (java.lang.String) r11)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "enable_visa_bank_offer_flow"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "enable_visa_bank_offer_flow"
            r11 = 0
            boolean r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "visa_pretick_flowtype"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "visa_pretick_flowtype"
            r11 = -1
            int r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (int) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "NativePG_EnableBankMandate"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "NativePG_EnableBankMandate"
            r11 = 1
            boolean r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "is_transparent_webview_enabled"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "is_transparent_webview_enabled"
            r11 = 1
            boolean r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "is_fee_promotion_enabled"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "is_fee_promotion_enabled"
            r11 = 0
            boolean r5 = net.one97.paytm.j.c.a((java.lang.String) r5, (boolean) r11)     // Catch:{ Exception -> 0x062a }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r5)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "started_activity_from_recharge"
            boolean r2 = r0.getBooleanExtra(r2, r11)     // Catch:{ Exception -> 0x062a }
            r14.bp = r2     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = net.one97.paytm.recharge.common.utils.az.a((org.json.JSONObject) r10)     // Catch:{ Exception -> 0x062a }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x062a }
            if (r5 == 0) goto L_0x033d
            r2 = r13
        L_0x033d:
            java.lang.String r5 = "Shopping_cart"
            boolean r5 = r5.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x062a }
            if (r5 == 0) goto L_0x037a
            java.lang.String r1 = r14.bN     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.PaytmSDK r1 = r14.g((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient r2 = net.one97.paytm.marketplace.a.l()     // Catch:{ Exception -> 0x062a }
            r1.setRequestClient(r2)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.emiSubvention.ISubventionProvider r2 = net.one97.paytm.marketplace.a.m()     // Catch:{ Exception -> 0x062a }
            r1.setSubventionProvider(r2)     // Catch:{ Exception -> 0x062a }
            java.lang.String r2 = "emi_tenures_info"
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            java.lang.String r3 = "emi_tenures_info"
            java.lang.String r3 = net.one97.paytm.j.c.a((java.lang.String) r3, (java.lang.String) r13)     // Catch:{ Exception -> 0x062a }
            r12.put(r2, r3)     // Catch:{ Exception -> 0x062a }
            r1.setGTMStringValues(r12)     // Catch:{ Exception -> 0x062a }
            android.content.Intent r2 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r3 = "Cashback"
            r4 = 0
            double r2 = r2.getDoubleExtra(r3, r4)     // Catch:{ Exception -> 0x062a }
            r1.setTotalCashBackAmount(r2)     // Catch:{ Exception -> 0x062a }
            goto L_0x03c4
        L_0x037a:
            boolean r5 = r14.bp     // Catch:{ Exception -> 0x062a }
            if (r5 == 0) goto L_0x0396
            net.one97.paytm.common.entity.CJRRechargeCart r5 = r14.E     // Catch:{ Exception -> 0x062a }
            boolean r2 = net.one97.paytm.recharge.common.utils.az.b((android.content.Context) r14, (java.lang.String) r2, (net.one97.paytm.common.entity.CJRRechargeCart) r5)     // Catch:{ Exception -> 0x062a }
            if (r2 == 0) goto L_0x0396
            java.lang.String r1 = r14.bN     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.PaytmSDK r1 = r14.g((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.common.entity.CJRRechargeCart r2 = r14.E     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.recharge.common.utils.s r2 = net.one97.paytm.recharge.common.b.d.a(r14, r10, r2)     // Catch:{ Exception -> 0x062a }
            r1.setRequestClient(r2)     // Catch:{ Exception -> 0x062a }
            goto L_0x03c4
        L_0x0396:
            java.lang.String r2 = "channel"
            boolean r2 = r2.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x062a }
            if (r2 == 0) goto L_0x03b8
            java.lang.String r1 = r14.bN     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.PaytmSDK r1 = r14.g((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.e.a$a r2 = net.one97.paytm.e.a.f50391a     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.e.a$a r2 = net.one97.paytm.e.a.f50391a     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.e.b r2 = net.one97.paytm.e.a.f50392b     // Catch:{ Exception -> 0x062a }
            if (r2 == 0) goto L_0x03b3
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient r11 = r2.a()     // Catch:{ Exception -> 0x062a }
            goto L_0x03b4
        L_0x03b3:
            r11 = 0
        L_0x03b4:
            r1.setRequestClient(r11)     // Catch:{ Exception -> 0x062a }
            goto L_0x03c4
        L_0x03b8:
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient r2 = net.one97.paytm.nativesdk.PaytmSDK.getCheckoutCallbackListener()     // Catch:{ Exception -> 0x062a }
            if (r2 == 0) goto L_0x03ce
            java.lang.String r1 = r14.bN     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.PaytmSDK r1 = r14.g((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x062a }
        L_0x03c4:
            r23 = r0
        L_0x03c6:
            r0 = r12
            r24 = r13
            r19 = r15
            r15 = 0
            goto L_0x04b6
        L_0x03ce:
            net.one97.paytm.AJRRechargePaymentActivity$c r2 = new net.one97.paytm.AJRRechargePaymentActivity$c     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = r14.bM     // Catch:{ Exception -> 0x062a }
            r2.<init>(r5)     // Catch:{ Exception -> 0x062a }
            r14.bj = r2     // Catch:{ Exception -> 0x062a }
            android.content.Intent r2 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            if (r2 == 0) goto L_0x03f5
            android.content.Intent r2 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "isDeferredCheckoutEnable"
            boolean r2 = r2.hasExtra(r5)     // Catch:{ Exception -> 0x062a }
            if (r2 == 0) goto L_0x03f5
            android.content.Intent r2 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            java.lang.String r5 = "isDeferredCheckoutEnable"
            r11 = 0
            boolean r2 = r2.getBooleanExtra(r5, r11)     // Catch:{ Exception -> 0x062a }
            goto L_0x03f7
        L_0x03f5:
            r11 = 0
            r2 = 0
        L_0x03f7:
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x062a }
            r5 = 1
            boolean r3 = net.one97.paytm.j.c.a((java.lang.String) r3, (boolean) r5)     // Catch:{ Exception -> 0x062a }
            if (r3 == 0) goto L_0x042b
            java.lang.String r3 = "Add_to_paytm_cash"
            java.lang.String r5 = r0.getStringExtra(r15)     // Catch:{ Exception -> 0x062a }
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x062a }
            if (r3 == 0) goto L_0x042b
            java.lang.String r2 = r14.bN     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.PaytmSDK r2 = r14.g((java.lang.String) r6, (java.lang.String) r2)     // Catch:{ Exception -> 0x062a }
            java.lang.String r3 = "addmoney:setting deferred client "
            java.lang.String r4 = java.lang.String.valueOf(r34)     // Catch:{ Exception -> 0x062a }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.utils.r.a((java.lang.String) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x062a }
            if (r1 == 0) goto L_0x0438
            r2.setRequestClient(r1)     // Catch:{ Exception -> 0x062a }
            java.lang.String r1 = "addmoney:deferred client set"
            net.one97.paytm.utils.r.a((java.lang.String) r8, (java.lang.String) r1)     // Catch:{ Exception -> 0x062a }
            goto L_0x0438
        L_0x042b:
            if (r2 == 0) goto L_0x043c
            java.lang.String r2 = r14.bN     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.nativesdk.PaytmSDK r2 = r14.g((java.lang.String) r6, (java.lang.String) r2)     // Catch:{ Exception -> 0x062a }
            if (r1 == 0) goto L_0x0438
            r2.setRequestClient(r1)     // Catch:{ Exception -> 0x062a }
        L_0x0438:
            r23 = r0
            r1 = r2
            goto L_0x03c6
        L_0x043c:
            boolean r1 = r14.aE     // Catch:{ Exception -> 0x062a }
            if (r1 == 0) goto L_0x0470
            net.one97.paytm.nativesdk.PaytmSDK r10 = new net.one97.paytm.nativesdk.PaytmSDK     // Catch:{ Exception -> 0x062a }
            r5 = 1
            java.lang.Double r1 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x062a }
            double r6 = r1.doubleValue()     // Catch:{ Exception -> 0x062a }
            java.lang.String r8 = r14.bN     // Catch:{ Exception -> 0x062a }
            java.lang.String r9 = r14.bM     // Catch:{ Exception -> 0x062a }
            java.lang.String r3 = r14.bA     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.AJRRechargePaymentActivity$c r2 = r14.bj     // Catch:{ Exception -> 0x062a }
            r1 = r10
            r16 = r2
            r2 = r31
            r18 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r7 = r8
            r8 = r9
            r9 = r18
            r11 = r10
            r10 = r16
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10)     // Catch:{ Exception -> 0x062a }
            r10 = 1
            r11.setIsAppInvoke(r10)     // Catch:{ Exception -> 0x062a }
            r23 = r0
            r1 = r11
            goto L_0x03c6
        L_0x0470:
            r10 = 1
            net.one97.paytm.nativesdk.PaytmSDK r16 = new net.one97.paytm.nativesdk.PaytmSDK     // Catch:{ Exception -> 0x062a }
            boolean r2 = r14.aA     // Catch:{ Exception -> 0x062a }
            java.lang.String r4 = r9.toString()     // Catch:{ Exception -> 0x062a }
            net.one97.paytm.AJRRechargePaymentActivity$c r5 = r14.bj     // Catch:{ Exception -> 0x062a }
            java.lang.Double r1 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x062a }
            double r6 = r1.doubleValue()     // Catch:{ Exception -> 0x062a }
            android.content.Intent r1 = r31.getIntent()     // Catch:{ Exception -> 0x062a }
            r3 = r18
            java.lang.String r8 = r1.getStringExtra(r3)     // Catch:{ Exception -> 0x062a }
            java.lang.String r9 = r14.bM     // Catch:{ Exception -> 0x062a }
            java.lang.String r11 = "Paytm"
            java.lang.String r3 = r14.bA     // Catch:{ Exception -> 0x062a }
            r17 = 0
            net.one97.paytm.nativesdk.Utils.Server r18 = net.one97.paytm.nativesdk.Utils.Server.PRODUCTION     // Catch:{ Exception -> 0x062a }
            r1 = r16
            r21 = r3
            r3 = r31
            r22 = 1
            r10 = r11
            r23 = r0
            r0 = 0
            r19 = 0
            r11 = r21
            r0 = r12
            r19 = r15
            r15 = 0
            r12 = r17
            r24 = r13
            r13 = r18
            r1.<init>(r2, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0628 }
            r1 = r16
        L_0x04b6:
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r2 = "NativePG_EnablePriorityInOnusAndroidNEW"
            boolean r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (boolean) r15)     // Catch:{ Exception -> 0x0628 }
            r1.setPriorityEnabledForOnUs(r2)     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r2 = "NativePG_EnablePriorityInvokeFullAndroid"
            boolean r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (boolean) r15)     // Catch:{ Exception -> 0x0628 }
            r1.setPriorityEnableForAppInvokeFull(r2)     // Catch:{ Exception -> 0x0628 }
            android.content.Context r2 = r31.getApplicationContext()     // Catch:{ Exception -> 0x0628 }
            boolean r2 = net.one97.paytm.utils.bf.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0628 }
            r1.setVisaOneClickEnabled(r2)     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.AJRRechargePaymentActivity$4 r2 = new net.one97.paytm.AJRRechargePaymentActivity$4     // Catch:{ Exception -> 0x0628 }
            r2.<init>()     // Catch:{ Exception -> 0x0628 }
            r1.setUpiPushCallBackListener(r2)     // Catch:{ Exception -> 0x0628 }
            r1.setGTMStringValues(r0)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r0 = com.paytm.utility.a.a((android.content.Context) r31)     // Catch:{ Exception -> 0x0628 }
            r1.setCustomerId(r0)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r0 = com.paytm.utility.a.b((android.content.Context) r31)     // Catch:{ Exception -> 0x0628 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0628 }
            if (r2 == 0) goto L_0x04f9
            java.lang.String r0 = com.paytm.utility.b.ab(r31)     // Catch:{ Exception -> 0x0628 }
        L_0x04f9:
            android.content.Intent r2 = r31.getIntent()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "native_plus_enabled"
            boolean r2 = r2.getBooleanExtra(r3, r15)     // Catch:{ Exception -> 0x0628 }
            r1.setNativePlusEnabled(r2)     // Catch:{ Exception -> 0x0628 }
            android.content.Intent r2 = r31.getIntent()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "isFromAIO"
            boolean r2 = r2.getBooleanExtra(r3, r15)     // Catch:{ Exception -> 0x0628 }
            r1.setIsFromAllInOneSDK(r2)     // Catch:{ Exception -> 0x0628 }
            boolean r2 = r14.aB     // Catch:{ Exception -> 0x0628 }
            r1.setTransparentAppInvoke(r2)     // Catch:{ Exception -> 0x0628 }
            boolean r2 = r14.aC     // Catch:{ Exception -> 0x0628 }
            r1.setMWebAppInvoke(r2)     // Catch:{ Exception -> 0x0628 }
            boolean r2 = com.paytm.utility.b.aj(r31)     // Catch:{ Exception -> 0x0628 }
            if (r2 != 0) goto L_0x0525
            r2 = 1
            goto L_0x0526
        L_0x0525:
            r2 = 0
        L_0x0526:
            r1.disableRecording(r2)     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r2 = "pb_rsa_key"
            r3 = 0
            java.lang.String r26 = net.one97.paytm.j.c.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r27 = "Basic bWFya2V0LWFwcDo5YTA3MTc2Mi1hNDk5LTRiZDktOTE0YS00MzYxZTdjM2Y0YmM="
            java.lang.String r28 = "market-app"
            java.lang.String r30 = com.paytm.utility.a.q(r31)     // Catch:{ Exception -> 0x0628 }
            r25 = r1
            r29 = r0
            r25.setBankParams(r26, r27, r28, r29, r30)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r2 = com.paytm.utility.a.q(r31)     // Catch:{ Exception -> 0x0628 }
            r1.enablePushUpi(r2, r0)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r0 = r31.y()     // Catch:{ Exception -> 0x0628 }
            r1.setDeviceId(r0)     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r0 = "native_pg_switch_ppbl_to_upi"
            boolean r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (boolean) r15)     // Catch:{ Exception -> 0x0628 }
            r1.enablePPBViaUpi(r0)     // Catch:{ Exception -> 0x0628 }
            android.content.Context r0 = r31.getApplicationContext()     // Catch:{ Exception -> 0x0628 }
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r2 = "easyPay"
            r3 = 1
            boolean r0 = r0.b((java.lang.String) r2, (boolean) r3, (boolean) r3)     // Catch:{ Exception -> 0x0628 }
            r1.setEnablePaytmAssist(r0)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r0 = "Add_to_paytm_cash"
            r3 = r19
            r2 = r23
            java.lang.String r3 = r2.getStringExtra(r3)     // Catch:{ Exception -> 0x0628 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0628 }
            if (r0 == 0) goto L_0x059b
            java.lang.String r0 = "is_for_Gift_voucher"
            boolean r0 = r2.getBooleanExtra(r0, r15)     // Catch:{ Exception -> 0x0628 }
            if (r0 == 0) goto L_0x0591
            r0 = 2131962791(0x7f132ba7, float:1.9562317E38)
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x0628 }
            r1.setHeaderLabelText(r0)     // Catch:{ Exception -> 0x0628 }
            goto L_0x059b
        L_0x0591:
            r0 = 2131962792(0x7f132ba8, float:1.956232E38)
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x0628 }
            r1.setHeaderLabelText(r0)     // Catch:{ Exception -> 0x0628 }
        L_0x059b:
            net.one97.paytm.AJRRechargePaymentActivity$5 r0 = new net.one97.paytm.AJRRechargePaymentActivity$5     // Catch:{ Exception -> 0x0628 }
            r0.<init>()     // Catch:{ Exception -> 0x0628 }
            r1.setDeferredCheckoutCallbackListener(r0)     // Catch:{ Exception -> 0x0628 }
            r3 = r32
            r1.setIsRetryTransaction(r3)     // Catch:{ Exception -> 0x0628 }
            r3 = r33
            r1.setRetryErrorMsg(r3)     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.nativesdk.Utils.Server r0 = net.one97.paytm.nativesdk.Utils.Server.PRODUCTION     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.nativesdk.PaytmSDK.setServer(r0)     // Catch:{ Exception -> 0x0628 }
            boolean r0 = r14.bn     // Catch:{ Exception -> 0x0628 }
            if (r0 == 0) goto L_0x05c2
            net.one97.paytm.AJRRechargePaymentActivity$6 r0 = new net.one97.paytm.AJRRechargePaymentActivity$6     // Catch:{ Exception -> 0x0628 }
            r0.<init>()     // Catch:{ Exception -> 0x0628 }
            r1.setOrFlowCallbackListener(r0)     // Catch:{ Exception -> 0x0628 }
            r1.startTransactionOrFlow()     // Catch:{ Exception -> 0x0628 }
            goto L_0x0619
        L_0x05c2:
            boolean r0 = r14.aE     // Catch:{ Exception -> 0x0628 }
            if (r0 == 0) goto L_0x0616
            android.content.Intent r0 = r14.aK     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "upi_mpin"
            java.lang.String r26 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x0628 }
            android.content.Intent r0 = r14.aK     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "seq_no"
            java.lang.String r27 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x0628 }
            android.content.Intent r0 = r14.aK     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "device_id"
            java.lang.String r28 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x0628 }
            android.content.Intent r0 = r31.getIntent()     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "payer_vpa"
            java.lang.String r0 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r3 = "upi_bankAccount_details_json"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch:{ Exception -> 0x0628 }
            com.google.gson.f r3 = new com.google.gson.f     // Catch:{ Exception -> 0x0628 }
            r3.<init>()     // Catch:{ Exception -> 0x0628 }
            java.lang.Class<net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount> r4 = net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount.class
            java.lang.Object r2 = r3.a((java.lang.String) r2, r4)     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r2 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r2     // Catch:{ Exception -> 0x0628 }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = new net.one97.paytm.upi.common.upi.UpiProfileDefaultBank     // Catch:{ Exception -> 0x0628 }
            r4.<init>()     // Catch:{ Exception -> 0x0628 }
            r4.setDebitBank(r2)     // Catch:{ Exception -> 0x0628 }
            r4.setVirtualAddress(r0)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r29 = r3.b(r4)     // Catch:{ Exception -> 0x0628 }
            java.lang.String r0 = r14.aH     // Catch:{ Exception -> 0x0628 }
            r25 = r1
            r30 = r0
            r25.startTransactionUpiTokenFlow(r26, r27, r28, r29, r30)     // Catch:{ Exception -> 0x0628 }
            goto L_0x0619
        L_0x0616:
            r1.startTransaction()     // Catch:{ Exception -> 0x0628 }
        L_0x0619:
            java.lang.String r0 = "/payment-gateway"
            java.lang.String r1 = "wallet"
            net.one97.paytm.j.a.b((java.lang.String) r0, (java.lang.String) r1, (android.content.Context) r14)     // Catch:{ Exception -> 0x0628 }
            return
        L_0x0622:
            r24 = r13
            r31.x()     // Catch:{ Exception -> 0x0628 }
            return
        L_0x0628:
            r0 = move-exception
            goto L_0x062d
        L_0x062a:
            r0 = move-exception
            r24 = r13
        L_0x062d:
            com.google.firebase.crashlytics.c r1 = com.google.firebase.crashlytics.c.a()
            r1.a((java.lang.Throwable) r0)
            android.content.res.Resources r0 = r31.getResources()
            r1 = 2131957675(0x7f1317ab, float:1.955194E38)
            java.lang.String r0 = r0.getString(r1)
            r1 = r24
            r14.e((java.lang.String) r0, (java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.a(boolean, java.lang.String, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient):void");
    }

    /* access modifiers changed from: private */
    public void e(String str, String str2) {
        final h hVar = new h(this);
        hVar.setTitle(str);
        hVar.a(str2);
        hVar.setCancelable(true);
        hVar.a(-3, getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.cancel();
                if (AJRRechargePaymentActivity.this.e()) {
                    AJRRechargePaymentActivity.this.finish();
                }
            }
        });
        hVar.show();
    }

    private void x() {
        net.one97.paytm.upi.h.a.a(getApplicationContext(), new a.C1347a() {
            public final void onServiceConnected() {
                if (AJRRechargePaymentActivity.this.aE) {
                    AJRRechargePaymentActivity.n(AJRRechargePaymentActivity.this);
                } else if (AJRRechargePaymentActivity.this.aF) {
                    AJRRechargePaymentActivity.p(AJRRechargePaymentActivity.this);
                } else if (AJRRechargePaymentActivity.this.aG) {
                    AJRRechargePaymentActivity.r(AJRRechargePaymentActivity.this);
                }
            }

            public final void onServiceDisconnected() {
                AJRRechargePaymentActivity aJRRechargePaymentActivity = AJRRechargePaymentActivity.this;
                aJRRechargePaymentActivity.e(aJRRechargePaymentActivity.getResources().getString(R.string.message_504), AJRRechargePaymentActivity.this.getResources().getString(R.string.mp_lbl_please_try_again_later));
                r.a("AJRechargePayment", "checkUpiInitialisation", new Throwable("Error intialising UPI lib"));
            }
        });
    }

    private String y() {
        try {
            getSystemService(ContactColumn.PHONE_NUMBER);
            return com.paytm.utility.a.f(this);
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        d(false);
        C();
        TextView textView = this.bC;
        if (textView != null) {
            textView.setText(getString(R.string.native_please_do_not));
        }
    }

    public final void a(boolean z) {
        if (!isFinishing()) {
            if (!z) {
                try {
                    this.l = (CJRRechargePayment) getIntent().getSerializableExtra(SDKConstants.PAYMENT_INFO);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            this.f51665f = (WebView) findViewById(R.id.payment_webview);
            this.aX = AssistMerchantDetails.getInstance();
            String str = "OrderID N/A";
            if (this.l != null && !TextUtils.isEmpty(this.l.getOrderId())) {
                str = this.l.getOrderId();
            }
            String str2 = "MID N/A";
            if (this.l != null && !TextUtils.isEmpty(this.l.getMID())) {
                str2 = this.l.getMID();
            }
            com.paytm.b.a.a a2 = ag.a(getApplicationContext());
            PaytmAssist.Builder builder = new PaytmAssist.Builder(this, str, str2);
            builder.setNativeEnabled(false);
            builder.setWebView(this.f51665f);
            builder.setViewId(Integer.valueOf(R.id.easypayBrowserFragment));
            builder.setServer("PRODUCTION");
            builder.setEnableLogging(true);
            builder.setCallBackListener(new AssistBuilderCallBack() {
                public final void onBuilderStartFailure(String str, Exception exc) {
                    if (AJRRechargePaymentActivity.this.bj != null) {
                        AJRRechargePaymentActivity.this.bj.logCrashAnalytics(getClass().getSimpleName(), str);
                        AJRRechargePaymentActivity.this.bj.logException(getClass().getSimpleName(), str, exc);
                    }
                }
            });
            if (c()) {
                q.d("isEnable:" + c());
                builder.setAssistEnabled(a2.b("easyPay", true, true));
            } else {
                builder.setAssistEnabled(false);
            }
            builder.build();
            PaytmAssist.startAssist();
            if (A()) {
                this.aX.setWebViewClient(new a(this));
                this.f51665f.setWebViewClient(this.aX.getWebClientInstance());
            } else {
                this.f51665f.setWebViewClient(this.aX.getWebClientInstance());
                this.aX.getWebClientInstance().addAssistWebClientListener(this);
            }
            this.f51665f.getSettings().setJavaScriptEnabled(true);
            this.f51665f.getSettings().setDomStorageEnabled(true);
            this.J = getIntent().getBooleanExtra("from_train_module", false);
            if (this.J) {
                this.I = (String) getIntent().getSerializableExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID);
            }
            this.C = (CJRParcelTrackingInfo) getIntent().getParcelableExtra("tracking_info");
            this.D = getIntent().getStringExtra("tracking_info_string");
            this.f51665f.getSettings().setJavaScriptEnabled(true);
            this.f51665f.getSettings().setDomStorageEnabled(true);
            this.f51665f.requestFocus(130);
            try {
                this.G = getIntent().getStringExtra("referralSource");
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            if (!TextUtils.isEmpty(this.j) && this.j.equalsIgnoreCase("Shopping_cart")) {
                ((ImageView) findViewById(R.id.recharge_tab_view)).setImageResource(R.drawable.cart_icon_inpayment);
            } else if (TextUtils.isEmpty(this.j) || !this.j.equalsIgnoreCase("Auto_Recharge")) {
                ((ImageView) findViewById(R.id.recharge_tab_view)).setImageResource(R.drawable.express_cart_pg_header);
            } else {
                ((ImageView) findViewById(R.id.recharge_tab_view)).setVisibility(8);
            }
            this.f51668i = Boolean.FALSE;
            Intent intent = getIntent();
            if (intent != null && intent.hasExtra("recharge cart")) {
                this.E = (CJRRechargeCart) intent.getSerializableExtra("recharge cart");
            }
            if (this.l != null) {
                b((Context) this);
                a(this.l);
            }
            WebView webView = this.f51665f;
            if (webView != null) {
                webView.clearCache(true);
                this.f51665f.clearHistory();
                this.f51665f.addJavascriptInterface(new f(this), "HTMLOUT");
                this.f51665f.addJavascriptInterface(new e(this, (byte) 0), "HtmlOut");
                this.f51665f.addJavascriptInterface(new d(), "OTPInterface");
                this.f51665f.addJavascriptInterface(new b(), "HtmlViewer");
            }
        }
    }

    private boolean A() {
        return !this.J;
    }

    private boolean g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.j == null || !jSONObject.has(this.j.toLowerCase())) {
                return false;
            }
            return true;
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return false;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        try {
            androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.aV);
            HashMap hashMap = new HashMap();
            hashMap.put("paytm_assist_final_url_key", this.aS);
            net.one97.paytm.j.a.b("paytm_assist_final_urls", (Map<String, Object>) hashMap, (Context) this);
            if (this.aX != null) {
                PaytmAssist.removeAssist();
            }
            if (this.bO != null) {
                this.bO.cancel();
                this.bO = null;
            }
            if (this.bP != null) {
                this.bP.cancel();
                this.bP = null;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("paytm_assist_last_url", this.aS.length() > 1 ? this.aS.substring(this.aS.lastIndexOf("|") + 1) : "");
            net.one97.paytm.j.a.b("paytm_assist_last_url", (Map<String, Object>) hashMap2, (Context) this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public static String h(String str) {
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("ORDER_ID");
            return TextUtils.isEmpty(queryParameter) ? parse.getQueryParameter("orderId") : queryParameter;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        net.one97.paytm.upi.passbook.b.a.b.a.a(getApplicationContext()).a((a.C1379a) new a.C1379a() {
            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void a(UpiBaseDataModel upiBaseDataModel) {
                PendingRequestsModel.PendingRequests pendingRequests;
                ArrayList<UpiPendingRequestModel> pendingRequests2;
                if (!AJRRechargePaymentActivity.this.isFinishing()) {
                    try {
                        if (AJRRechargePaymentActivity.this.aR != null && AJRRechargePaymentActivity.this.aR.isShowing()) {
                            AJRRechargePaymentActivity.this.aR.dismiss();
                        }
                    } catch (Exception unused) {
                    }
                    if ((upiBaseDataModel instanceof PendingRequestsModel.PendingRequests) && (pendingRequests = (PendingRequestsModel.PendingRequests) upiBaseDataModel) != null && (pendingRequests2 = pendingRequests.getPendingRequests()) != null && pendingRequests2.size() > 0) {
                        AJRRechargePaymentActivity.a(AJRRechargePaymentActivity.this, (ArrayList) pendingRequests2);
                    }
                }
            }
        }, this.f51663d, 0, this.aZ);
    }

    public void OnWcPageFinish(WebView webView, String str) {
        this.bc = com.paytm.utility.b.a(System.currentTimeMillis());
        this.be -= this.bd;
        i(str);
        long j2 = this.be - this.bd;
        au.e eVar = new au.e();
        eVar.p = 200;
        eVar.o = com.paytm.utility.b.P(str);
        eVar.q = j2;
        eVar.n = "process transcation";
        CJRRechargePayment cJRRechargePayment = this.l;
        if (cJRRechargePayment != null) {
            eVar.v = cJRRechargePayment.getMID();
            eVar.w = this.l.getmOrderId();
        }
        eVar.m = this.bo;
        eVar.l = a.c.PAYMENTS.toString();
        au.a(eVar, au.c.LocalError.stringValue, this);
        try {
            if (!isFinishing()) {
                D();
                d(false);
                b(false);
                webView.loadUrl("javascript:try{window.HtmlViewer.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');}catch(err){}");
                this.f51665f.loadUrl(this.aO);
                com.paytm.b.a.a a2 = ag.a(getApplicationContext());
                boolean b2 = a2.b("is_upi_user", false, true);
                boolean b3 = a2.b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
                net.one97.paytm.j.c.a();
                if (net.one97.paytm.j.c.a("upi_enabled", false) && b2 && b3) {
                    if (Build.VERSION.SDK_INT < 19) {
                        webView.addJavascriptInterface(this, getClass().getSimpleName());
                        webView.loadUrl("javascript:try{CustomWebViewClient.isSelfPush(checkSelfPushFlag())}catch(err){}");
                    } else {
                        webView.evaluateJavascript("(function() { try{ return checkSelfPushFlag(); } catch(err){ return false;} } )();", new ValueCallback<String>() {
                            public final /* synthetic */ void onReceiveValue(Object obj) {
                                if ("true".equalsIgnoreCase((String) obj)) {
                                    AJRRechargePaymentActivity.this.B();
                                }
                            }
                        });
                    }
                }
                if ((this.ah || this.aA) && str != null && str.toLowerCase().contains("/theia/paytmcallback?order_id=")) {
                    webView.loadUrl("javascript:try{window.HTMLOUT.processResponse(document.getElementById('response').value);}catch(err){}");
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void OnWcPageStart(WebView webView, String str, Bitmap bitmap) {
        this.bd = System.currentTimeMillis();
        this.bb = com.paytm.utility.b.a(System.currentTimeMillis());
        try {
            if (!isFinishing()) {
                this.ax = str;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.l.getPGUrlToHit())) {
                    b(true);
                } else if (str.contains(this.l.getPGUrlToHit())) {
                    this.bd = System.currentTimeMillis();
                    if (!this.aM && !this.ah && !this.X) {
                        if (!this.V) {
                            D();
                            d(true);
                        }
                    }
                    C();
                    d(false);
                } else {
                    b(true);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.aS);
                sb.append(this.aS.length() > 0 ? "|" : "");
                sb.append(str);
                this.aS = sb.toString();
                com.paytm.utility.a.c();
                if (str == null || !str.toLowerCase().contains(SDKConstants.PG_CALL_BACK)) {
                    if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("https://cart.paytm.com/payment/status")) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("retryAllowed");
                        String queryParameter2 = parse.getQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            a(queryParameter, queryParameter2);
                        }
                    }
                } else if (this.J) {
                    e("");
                } else {
                    if (!str.equalsIgnoreCase("http://trans-null/")) {
                        if (!str.equalsIgnoreCase("http://trans-0/")) {
                            String replace = str.substring((str.indexOf(SDKConstants.PG_CALL_BACK) >= 0 ? str.indexOf(SDKConstants.PG_CALL_BACK) : 0) + 13).replace("/", "");
                            this.f51667h = Boolean.TRUE;
                            if (!this.f51668i.booleanValue()) {
                                this.f51668i = Boolean.TRUE;
                                a(replace, false);
                                return;
                            }
                            return;
                        }
                    }
                    this.f51667h = Boolean.TRUE;
                    if (!this.f51668i.booleanValue()) {
                        this.f51668i = Boolean.TRUE;
                        u();
                    }
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public boolean WcshouldOverrideUrlLoading(WebView webView, Object obj) {
        if (!(obj instanceof String)) {
            int i2 = Build.VERSION.SDK_INT;
        }
        try {
            this.f51665f.loadUrl(this.aO);
            if (!isFinishing() && !this.f51667h.booleanValue()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (!com.paytm.utility.b.v) {
                return false;
            }
            q.b(e2.getMessage());
            return false;
        }
    }

    public void WcshouldInterceptRequest(WebView webView, String str) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("pg_hide_loader_url", (String) null);
        if (!TextUtils.isEmpty(a2) && str.equalsIgnoreCase(a2)) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    AJRRechargePaymentActivity.this.D();
                    AJRRechargePaymentActivity.this.d(false);
                }
            });
        }
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("https://cart.paytm.com/payment/status")) {
            Uri parse = Uri.parse(str);
            final String queryParameter = parse.getQueryParameter("retryAllowed");
            final String queryParameter2 = parse.getQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
            if (TextUtils.isEmpty(queryParameter) || !Boolean.valueOf(queryParameter).booleanValue()) {
                runOnUiThread(new Runnable() {
                    public final void run() {
                        try {
                            AJRRechargePaymentActivity.this.C();
                        } catch (Exception unused) {
                        }
                    }
                });
            } else {
                runOnUiThread(new Runnable() {
                    public final void run() {
                        try {
                            AJRRechargePaymentActivity.this.f51665f.stopLoading();
                            AJRRechargePaymentActivity.this.f(queryParameter, queryParameter2);
                        } catch (Exception e2) {
                            q.d("Unable to stop webview" + e2.toString());
                        }
                    }
                });
            }
        }
    }

    public static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @JavascriptInterface
    public void isSelfPush(boolean z) {
        if (z) {
            B();
        }
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        try {
            webView.loadData(SDKConstants.GENERICMESSAGEHTML, "text/html", "utf-8");
            if (!this.f51668i.booleanValue()) {
                this.f51668i = Boolean.TRUE;
                if (this.l != null && this.l.getOrderId() != null) {
                    a(this.l.getOrderId(), false);
                }
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    class d {
        d() {
        }

        @JavascriptInterface
        public final void otpFound(String str) {
            if (TextUtils.isEmpty(str) || !str.matches("^[0-9]{6,8}$")) {
                String unused = AJRRechargePaymentActivity.this.aP = "";
            } else {
                String unused2 = AJRRechargePaymentActivity.this.aP = str;
            }
        }
    }

    class b {
        b() {
        }

        @JavascriptInterface
        public final void showHTML(String str) {
            try {
                str.replaceAll("<script.*?script>", "");
                str.replaceAll("<style.*?style>", "");
                String lowerCase = str.replaceAll("<(.*?)\\>", "").replaceAll("<(.*?)\\\n", "").replaceFirst("(.*?)\\>", "").replaceFirst("&.*? ", "").replaceAll("\\r\\n", "").replaceAll("\\n", "").replaceAll("\\r", "").replaceAll("\\s+", "").toLowerCase();
                net.one97.paytm.j.c.a();
                Matcher matcher = Pattern.compile(net.one97.paytm.j.c.a("trustlistRegx", (String) null)).matcher(lowerCase);
                matcher.find();
                if (AJRRechargePaymentActivity.this.aQ == null) {
                    String unused = AJRRechargePaymentActivity.this.aQ = matcher.group(0);
                    if (!TextUtils.isEmpty(AJRRechargePaymentActivity.this.aQ)) {
                        Matcher matcher2 = Pattern.compile("[x|\\d]{3,10}").matcher(AJRRechargePaymentActivity.this.aQ);
                        if (matcher2.find()) {
                            String unused2 = AJRRechargePaymentActivity.this.aQ = matcher2.group(0);
                        }
                    }
                }
            } catch (Exception unused3) {
            }
        }
    }

    class e {
        private e() {
        }

        /* synthetic */ e(AJRRechargePaymentActivity aJRRechargePaymentActivity, byte b2) {
            this();
        }

        @JavascriptInterface
        public final synchronized void processResponse(String str) {
            if (AJRRechargePaymentActivity.this.getIntent().getBooleanExtra("enable_paytm_invoke", false)) {
                Intent intent = new Intent();
                intent.putExtra(SDKConstants.RESPONSE, str);
                intent.putExtra("nativeSdkForMerchantMessage", "");
                AJRRechargePaymentActivity.this.setResult(-1, intent);
                AJRRechargePaymentActivity.this.finish();
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("extra_data", str);
            AJRRechargePaymentActivity.this.setResult(-1, intent2);
            AJRRechargePaymentActivity.this.finish();
        }

        @JavascriptInterface
        public final void onPayNowClick(String str, String str2, String str3, String str4) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String unused = AJRRechargePaymentActivity.this.aU = UpiUtils.getUpiSequenceNo();
                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) new com.google.gson.f().a(str2, BankAccountDetails.BankAccount.class);
                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                upiProfileDefaultBank.setDebitBank(bankAccount);
                upiProfileDefaultBank.setVirtualAddress(bankAccount.getCustomerName());
                upiProfileDefaultBank.setPrimary(true);
                Intent intent = new Intent(AJRRechargePaymentActivity.this.getApplicationContext(), MoneyTransferV3Activity.class);
                intent.putExtra("upi_push", true);
                intent.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                intent.putExtra("amount", str);
                intent.putExtra("payee_name", "");
                intent.putExtra("payee_vpa", str3);
                intent.putExtra("user_upi_details", upiProfileDefaultBank);
                intent.putExtra(UpiConstants.EXTRA_UPI_SEQ_NO, AJRRechargePaymentActivity.this.aU);
                AJRRechargePaymentActivity.this.startActivityForResult(intent, 1001);
            }
        }

        @JavascriptInterface
        public final void getUpiConsentData() {
            final String A = AJRRechargePaymentActivity.this.G();
            AJRRechargePaymentActivity.this.f51665f.post(new Runnable() {
                public final void run() {
                    if (Build.VERSION.SDK_INT < 19) {
                        WebView d2 = AJRRechargePaymentActivity.this.f51665f;
                        d2.loadUrl("javascript:window.setUpiConsentData('" + A + "')");
                        return;
                    }
                    WebView d3 = AJRRechargePaymentActivity.this.f51665f;
                    d3.evaluateJavascript("(function() { setUpiConsentData('" + A + "'); } )();", (ValueCallback) null);
                }
            });
        }

        @JavascriptInterface
        public final void showMpinToast(String str) {
            Toast.makeText(AJRRechargePaymentActivity.this, "MPIN = ".concat(String.valueOf(str)), 0).show();
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        if (!this.ab) {
            RelativeLayout relativeLayout = this.bx;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            TextView textView = this.bB;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.bC;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            this.bE = (LottieAnimationView) findViewById(R.id.ltv_loading);
            LottieAnimationView lottieAnimationView = this.bE;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                this.bE.setAnimation("Payments-Loader.json");
                this.bE.loop(true);
                this.bE.playAnimation();
            }
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2 = this.bx;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        TextView textView = this.bB;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.bC;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        this.bE = (LottieAnimationView) findViewById(R.id.ltv_loading);
        LottieAnimationView lottieAnimationView = this.bE;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        net.one97.paytm.j.c.a();
        if (net.one97.paytm.j.c.a("paytmLogoOnPaymentPage", false) && (relativeLayout = this.bw) != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private String E() {
        if (getIntent() == null) {
            return "";
        }
        if (getIntent().hasExtra("recharge cart") && TextUtils.isEmpty("")) {
            this.E = (CJRRechargeCart) getIntent().getSerializableExtra("recharge cart");
            CJRRechargeCart cJRRechargeCart = this.E;
            if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
                return "";
            }
            return this.E.getCart().getOrderTotal();
        } else if (!getIntent().hasExtra("price") || !TextUtils.isEmpty("")) {
            return "";
        } else {
            return getIntent().getStringExtra("price");
        }
    }

    private String F() {
        if (getIntent() == null) {
            return "";
        }
        if (!getIntent().hasExtra(SDKConstants.PAYMENT_INFO)) {
            return E();
        }
        CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) getIntent().getSerializableExtra(SDKConstants.PAYMENT_INFO);
        if (cJRRechargePayment != null) {
            return com.paytm.utility.b.T(cJRRechargePayment.getPGParams().get("TXN_AMOUNT"));
        }
        return E();
    }

    /* access modifiers changed from: private */
    public void d(boolean z) {
        int i2 = z ? 0 : 8;
        RelativeLayout relativeLayout = this.bx;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i2);
        }
        if (this.by != null) {
            if (TextUtils.isEmpty(this.j) || !this.j.equalsIgnoreCase("gold") || this.k) {
                this.by.setVisibility(i2);
            } else {
                this.by.setVisibility(8);
            }
        }
        ShimmerFrameLayout shimmerFrameLayout = this.bG;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setVisibility(i2);
        }
        if (!z) {
            this.ab = false;
            ShimmerFrameLayout shimmerFrameLayout2 = this.bG;
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.b();
            }
        } else if (!this.ab) {
            String F2 = F();
            if (this.bD != null) {
                if (TextUtils.isEmpty(F2)) {
                    this.bD.setVisibility(8);
                } else {
                    this.bD.setText(getString(R.string.rupee, new Object[]{F2}));
                }
            }
            ShimmerFrameLayout shimmerFrameLayout3 = this.bG;
            if (shimmerFrameLayout3 != null) {
                shimmerFrameLayout3.a();
            }
        }
    }

    public final void b(boolean z) {
        if (z) {
            try {
                if (this.bR == null) {
                    this.bR = net.one97.paytm.wallet.utility.a.c((Activity) this);
                }
                if (this.bR != null && !this.bR.isShowing() && !isFinishing()) {
                    this.bR.show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else {
            try {
                if (this.bR != null && this.bR.isShowing()) {
                    this.bR.dismiss();
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.b(e3.getMessage());
                }
            }
        }
    }

    private void c(String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("order_id", str);
        intent.putExtra(AppConstants.IS_CANCEL, z);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public synchronized void f(String str, String str2) {
        if (this.V) {
            b(str, str2);
        } else if (this.X) {
            c(str, str2);
        } else if (this.aa) {
            this.aa = false;
            a(true, str2, (PaytmSDKRequestClient) null);
        }
    }

    class a extends EasypayWebViewClient {
        private final String TAG = getClass().getSimpleName();

        a(Activity activity) {
            super(activity);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            super.shouldInterceptRequest(webView, str);
            net.one97.paytm.j.c.a();
            String a2 = net.one97.paytm.j.c.a("pg_hide_loader_url", (String) null);
            if (!TextUtils.isEmpty(a2) && str.equalsIgnoreCase(a2)) {
                AJRRechargePaymentActivity.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AJRRechargePaymentActivity.this.D();
                        AJRRechargePaymentActivity.this.d(false);
                    }
                });
            }
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("https://cart.paytm.com/payment/status")) {
                Uri parse = Uri.parse(str);
                final String queryParameter = parse.getQueryParameter("retryAllowed");
                final String queryParameter2 = parse.getQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
                if (TextUtils.isEmpty(queryParameter) || !Boolean.valueOf(queryParameter).booleanValue()) {
                    AJRRechargePaymentActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            try {
                                AJRRechargePaymentActivity.this.C();
                            } catch (Exception unused) {
                            }
                        }
                    });
                } else {
                    AJRRechargePaymentActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            try {
                                AJRRechargePaymentActivity.this.f51665f.stopLoading();
                                AJRRechargePaymentActivity.this.f(queryParameter, queryParameter2);
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            com.paytm.utility.q.b(r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
            return new android.webkit.WebResourceResponse("image/jpeg", "utf-8", new java.io.ByteArrayInputStream(net.one97.paytm.AJRRechargePaymentActivity.a(android.graphics.BitmapFactory.decodeStream(com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(new java.net.URL(r3))))));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fd, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fe, code lost:
            com.paytm.utility.q.b(r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0106, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0107, code lost:
            com.paytm.utility.q.b(r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x010f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0110, code lost:
            com.paytm.utility.q.b(r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0118, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0119, code lost:
            com.paytm.utility.q.b(r0.getMessage());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0106 A[ExcHandler: IOException (r0v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:4:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x010f A[ExcHandler: FileNotFoundException (r0v3 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:4:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0118 A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:4:0x001c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r7, android.webkit.WebResourceRequest r8) {
            /*
                r6 = this;
                java.lang.String r0 = "text/javascript"
                java.lang.String r1 = "image/jpeg"
                super.shouldInterceptRequest(r7, r8)
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 21
                if (r2 < r3) goto L_0x0120
                android.net.Uri r2 = r8.getUrl()
                java.lang.String r3 = net.one97.paytm.AJRRechargePaymentActivity.a((android.net.Uri) r2)
                java.lang.String r2 = r2.getPath()
                if (r2 == 0) goto L_0x0120
                net.one97.paytm.AJRRechargePaymentActivity r2 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                boolean r2 = net.one97.paytm.AJRRechargePaymentActivity.i(r2, r3)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.lang.String r4 = "utf-8"
                if (r2 == 0) goto L_0x008f
                net.one97.paytm.AJRRechargePaymentActivity r0 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.widget.i r0 = r0.bQ     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                com.android.volley.Cache$Entry r0 = r0.a(r3)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                if (r0 != 0) goto L_0x0054
                java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                r0.<init>(r3)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                java.io.InputStream r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r0)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.AJRRechargePaymentActivity r2 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.widget.i r2 = r2.bQ     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                byte[] r0 = net.one97.paytm.AJRRechargePaymentActivity.a((android.graphics.Bitmap) r0)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                java.lang.String r5 = "image"
                r2.a(r3, r0, r5)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                super.shouldInterceptRequest(r7, r8)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                goto L_0x0120
            L_0x0054:
                java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.AJRRechargePaymentActivity r2 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.widget.i r2 = r2.bQ     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                com.android.volley.Cache$Entry r2 = r2.a(r3)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                byte[] r2 = r2.data     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                r0.<init>(r2)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                android.webkit.WebResourceResponse r2 = new android.webkit.WebResourceResponse     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                r2.<init>(r1, r4, r0)     // Catch:{ Exception -> 0x006b, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                return r2
            L_0x006b:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                com.paytm.utility.q.b(r0)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                r0.<init>(r3)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.io.InputStream r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r0)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                byte[] r0 = net.one97.paytm.AJRRechargePaymentActivity.a((android.graphics.Bitmap) r0)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                r2.<init>(r0)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                android.webkit.WebResourceResponse r0 = new android.webkit.WebResourceResponse     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                r0.<init>(r1, r4, r2)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                return r0
            L_0x008f:
                boolean r1 = r3.endsWith("js")     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                if (r1 == 0) goto L_0x00f9
                net.one97.paytm.AJRRechargePaymentActivity r1 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                net.one97.paytm.AJRRechargePaymentActivity.C(r1)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                net.one97.paytm.AJRRechargePaymentActivity r1 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.widget.i r1 = r1.bQ     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                com.android.volley.Cache$Entry r1 = r1.a(r3)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                if (r1 != 0) goto L_0x00c2
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                java.io.InputStream r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r1)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                byte[] r1 = com.google.android.gms.common.util.k.a((java.io.InputStream) r1)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.AJRRechargePaymentActivity r2 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.widget.i r2 = r2.bQ     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                java.lang.String r5 = "js"
                r2.a(r3, r1, r5)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                super.shouldInterceptRequest(r7, r8)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                goto L_0x0120
            L_0x00c2:
                java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.AJRRechargePaymentActivity r2 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                net.one97.paytm.widget.i r2 = r2.bQ     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                com.android.volley.Cache$Entry r2 = r2.a(r3)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                byte[] r2 = r2.data     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                android.webkit.WebResourceResponse r2 = new android.webkit.WebResourceResponse     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                r2.<init>(r0, r4, r1)     // Catch:{ Exception -> 0x00d9, MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106 }
                return r2
            L_0x00d9:
                r1 = move-exception
                java.lang.String r1 = r1.getMessage()     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                com.paytm.utility.q.b(r1)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                r1.<init>(r3)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.io.InputStream r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r1)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                byte[] r2 = com.google.android.gms.common.util.k.a((java.io.InputStream) r1)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                r3.<init>(r2)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                android.webkit.WebResourceResponse r2 = new android.webkit.WebResourceResponse     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                r2.<init>(r0, r4, r1)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                goto L_0x0120
            L_0x00f9:
                super.shouldInterceptRequest(r7, r8)     // Catch:{ MalformedURLException -> 0x0118, FileNotFoundException -> 0x010f, IOException -> 0x0106, Exception -> 0x00fd }
                goto L_0x0120
            L_0x00fd:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.b(r0)
                goto L_0x0120
            L_0x0106:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.b(r0)
                goto L_0x0120
            L_0x010f:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.b(r0)
                goto L_0x0120
            L_0x0118:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                com.paytm.utility.q.b(r0)
            L_0x0120:
                android.webkit.WebResourceResponse r7 = super.shouldInterceptRequest(r7, r8)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.a.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            super.shouldOverrideUrlLoading(webView, str);
            try {
                if (AJRRechargePaymentActivity.j(AJRRechargePaymentActivity.this, str)) {
                    return false;
                }
                AJRRechargePaymentActivity.this.f51665f.loadUrl(AJRRechargePaymentActivity.this.aO);
                if (!AJRRechargePaymentActivity.this.isFinishing() && !AJRRechargePaymentActivity.this.f51667h.booleanValue()) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            super.shouldOverrideUrlLoading(webView, webResourceRequest);
            if (Build.VERSION.SDK_INT < 21) {
                webResourceRequest = null;
            }
            try {
                if (AJRRechargePaymentActivity.j(AJRRechargePaymentActivity.this, webResourceRequest.getUrl().toString())) {
                    return false;
                }
                AJRRechargePaymentActivity.this.f51665f.loadUrl(AJRRechargePaymentActivity.this.aO);
                if (!AJRRechargePaymentActivity.this.isFinishing() && !AJRRechargePaymentActivity.this.f51667h.booleanValue()) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            long unused = AJRRechargePaymentActivity.this.bd = System.currentTimeMillis();
            String unused2 = AJRRechargePaymentActivity.this.bb = com.paytm.utility.b.a(System.currentTimeMillis());
            try {
                if (!AJRRechargePaymentActivity.this.isFinishing()) {
                    String unused3 = AJRRechargePaymentActivity.this.ax = str;
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(AJRRechargePaymentActivity.this.l.getPGUrlToHit())) {
                        AJRRechargePaymentActivity.this.b(true);
                    } else if (str.contains(AJRRechargePaymentActivity.this.l.getPGUrlToHit())) {
                        long unused4 = AJRRechargePaymentActivity.this.bd = System.currentTimeMillis();
                        if (!AJRRechargePaymentActivity.this.aM && !AJRRechargePaymentActivity.this.ah && !AJRRechargePaymentActivity.this.X) {
                            if (!AJRRechargePaymentActivity.this.V) {
                                AJRRechargePaymentActivity.this.D();
                                AJRRechargePaymentActivity.this.d(true);
                            }
                        }
                        AJRRechargePaymentActivity.this.C();
                        AJRRechargePaymentActivity.this.d(false);
                    } else {
                        AJRRechargePaymentActivity.this.b(true);
                    }
                    AJRRechargePaymentActivity aJRRechargePaymentActivity = AJRRechargePaymentActivity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(AJRRechargePaymentActivity.this.aS);
                    sb.append(AJRRechargePaymentActivity.this.aS.length() > 0 ? "|" : "");
                    sb.append(str);
                    String unused5 = aJRRechargePaymentActivity.aS = sb.toString();
                    com.paytm.utility.a.c();
                    if (str == null || !str.toLowerCase().contains(SDKConstants.PG_CALL_BACK)) {
                        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("https://cart.paytm.com/payment/status")) {
                            Uri parse = Uri.parse(str);
                            String queryParameter = parse.getQueryParameter("retryAllowed");
                            String queryParameter2 = parse.getQueryParameter(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
                            if (!TextUtils.isEmpty(queryParameter)) {
                                AJRRechargePaymentActivity.this.a(queryParameter, queryParameter2);
                            }
                        }
                        super.onPageStarted(webView, str, bitmap);
                    }
                    if (AJRRechargePaymentActivity.this.J) {
                        AJRRechargePaymentActivity.this.e("");
                    } else {
                        if (!str.equalsIgnoreCase("http://trans-null/")) {
                            if (!str.equalsIgnoreCase("http://trans-0/")) {
                                String replace = str.substring((str.indexOf(SDKConstants.PG_CALL_BACK) >= 0 ? str.indexOf(SDKConstants.PG_CALL_BACK) : 0) + 13).replace("/", "");
                                Boolean unused6 = AJRRechargePaymentActivity.this.f51667h = Boolean.TRUE;
                                if (!AJRRechargePaymentActivity.this.f51668i.booleanValue()) {
                                    Boolean unused7 = AJRRechargePaymentActivity.this.f51668i = Boolean.TRUE;
                                    AJRRechargePaymentActivity.this.a(replace, false);
                                }
                            }
                        }
                        Boolean unused8 = AJRRechargePaymentActivity.this.f51667h = Boolean.TRUE;
                        if (!AJRRechargePaymentActivity.this.f51668i.booleanValue()) {
                            Boolean unused9 = AJRRechargePaymentActivity.this.f51668i = Boolean.TRUE;
                            AJRRechargePaymentActivity.this.u();
                        }
                    }
                    super.onPageStarted(webView, str, bitmap);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            long unused = AJRRechargePaymentActivity.this.be = System.currentTimeMillis();
            AJRRechargePaymentActivity aJRRechargePaymentActivity = AJRRechargePaymentActivity.this;
            long unused2 = aJRRechargePaymentActivity.be = aJRRechargePaymentActivity.be - AJRRechargePaymentActivity.this.bd;
            String unused3 = AJRRechargePaymentActivity.this.bc = com.paytm.utility.b.a(System.currentTimeMillis());
            AJRRechargePaymentActivity.this.i(str);
            try {
                if (!AJRRechargePaymentActivity.this.isFinishing()) {
                    AJRRechargePaymentActivity.this.D();
                    AJRRechargePaymentActivity.this.d(false);
                    AJRRechargePaymentActivity.this.b(false);
                    webView.loadUrl("javascript:try{window.HtmlViewer.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');}catch(err){}");
                    AJRRechargePaymentActivity.this.f51665f.loadUrl(AJRRechargePaymentActivity.this.aO);
                    com.paytm.b.a.a a2 = ag.a(AJRRechargePaymentActivity.this.getApplicationContext());
                    boolean b2 = a2.b("is_upi_user", false, true);
                    boolean b3 = a2.b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
                    net.one97.paytm.j.c.a();
                    if (net.one97.paytm.j.c.a("upi_enabled", false) && b2 && b3) {
                        if (Build.VERSION.SDK_INT < 19) {
                            webView.addJavascriptInterface(this, getClass().getSimpleName());
                            webView.loadUrl("javascript:try{CustomWebViewClient.isSelfPush(checkSelfPushFlag())}catch(err){}");
                        } else {
                            webView.evaluateJavascript("(function() { try{ return checkSelfPushFlag(); } catch(err){ return false;} } )();", new ValueCallback<String>() {
                                public final /* synthetic */ void onReceiveValue(Object obj) {
                                    if ("true".equalsIgnoreCase((String) obj)) {
                                        AJRRechargePaymentActivity.this.B();
                                    }
                                }
                            });
                        }
                    }
                    if ((AJRRechargePaymentActivity.this.ah || AJRRechargePaymentActivity.this.aA) && str != null && str.toLowerCase().contains("/theia/paytmcallback?order_id=")) {
                        webView.loadUrl("javascript:try{window.HTMLOUT.processResponse(document.getElementById('response').value);}catch(err){}");
                    }
                    super.onPageFinished(webView, str);
                }
            } catch (Exception unused4) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void i(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.l.getPGUrlToHit()) && str.contains(this.l.getPGUrlToHit())) {
            this.be = System.currentTimeMillis();
            long j2 = this.bd;
            if (j2 > 0) {
                this.be -= j2;
                String str2 = this.l.getmMID();
                StringBuilder sb = new StringBuilder();
                sb.append(this.be);
                net.one97.paytm.j.a.a((Context) this, SDKConstants.GA_PAYMENT_GATEWAY, str2, "processTransaction", "", sb.toString(), "/payment-gateway", SDKConstants.GA_PAYMENT_GATEWAY);
            }
        }
    }

    class c implements PaytmSDKCallbackListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f51721b;

        public c(String str) {
            this.f51721b = str;
        }

        public final void onTransactionResponse(Bundle bundle) {
            if (bundle != null) {
                boolean unused = AJRRechargePaymentActivity.this.aa = true;
                CJRRechargePayment unused2 = AJRRechargePaymentActivity.this.l = new CJRRechargePayment();
                AJRRechargePaymentActivity.this.l.setmMID(bundle.getString(SDKConstants.MID));
                AJRRechargePaymentActivity.this.l.setmOrderId(bundle.getString("ORDER_ID"));
                AJRRechargePaymentActivity.this.l.setmPGUrlToHit(bundle.getString(SDKConstants.WEB_VIEW_URL));
                boolean z = bundle.getBoolean("UPIPUSH", false);
                boolean z2 = bundle.getBoolean(SDKConstants.UPI_COLLECT, false);
                HashMap unused3 = AJRRechargePaymentActivity.this.az = (HashMap) bundle.getSerializable(SDKConstants.WEB_VIEW_PARAMS);
                if (z) {
                    if (AJRRechargePaymentActivity.this.aA) {
                        AJRRechargePaymentActivity.this.az.put("appCallbackUrl", "true");
                    }
                    boolean unused4 = AJRRechargePaymentActivity.this.aM = true;
                    String string = bundle.getString("payee_name", "");
                    String string2 = bundle.getString("payee_vpa");
                    String string3 = bundle.getString("merchant_code");
                    String string4 = bundle.getString("user_upi_details");
                    String string5 = bundle.getString("amount");
                    AJRRechargePaymentActivity aJRRechargePaymentActivity = AJRRechargePaymentActivity.this;
                    AJRRechargePaymentActivity.a(aJRRechargePaymentActivity, aJRRechargePaymentActivity, string5, string4, string2, string, string3, "");
                } else if (z2) {
                    AJRRechargePaymentActivity.this.l.setmPGParams(AJRRechargePaymentActivity.this.az);
                    AJRRechargePaymentActivity.this.z();
                    boolean unused5 = AJRRechargePaymentActivity.this.aM = true;
                    AJRRechargePaymentActivity.this.a(true);
                } else if (AJRRechargePaymentActivity.this.aA || AJRRechargePaymentActivity.this.aE) {
                    AJRRechargePaymentActivity.this.a(bundle, this.f51721b);
                }
            } else if (AJRRechargePaymentActivity.this.P) {
                AJRRechargePaymentActivity.this.e(this.f51721b);
            } else {
                AJRRechargePaymentActivity.this.a(bundle, this.f51721b);
            }
        }

        public final void networkError() {
            if (AJRRechargePaymentActivity.this.getIntent().getBooleanExtra("enable_paytm_invoke", false)) {
                Intent intent = new Intent();
                intent.putExtra(SDKConstants.RESPONSE, "");
                intent.putExtra("nativeSdkForMerchantMessage", "networkError");
                AJRRechargePaymentActivity.this.setResult(0, intent);
                AJRRechargePaymentActivity.this.finish();
                return;
            }
            AJRRechargePaymentActivity.this.a(this.f51721b, true);
            Toast.makeText(AJRRechargePaymentActivity.this, "networkError", 0).show();
        }

        public final void onBackPressedCancelTransaction() {
            if (AJRRechargePaymentActivity.this.getIntent().getBooleanExtra("enable_paytm_invoke", false)) {
                Intent intent = new Intent();
                intent.putExtra(SDKConstants.RESPONSE, "");
                intent.putExtra("nativeSdkForMerchantMessage", "onBackPressedCancelTransaction");
                AJRRechargePaymentActivity.this.setResult(0, intent);
            }
            if (this.f51721b == null || TextUtils.isEmpty(AJRRechargePaymentActivity.this.j) || !AJRRechargePaymentActivity.this.j.equalsIgnoreCase("Shopping_cart")) {
                AJRRechargePaymentActivity.this.finish();
                AJRRechargePaymentActivity.this.overridePendingTransition(R.anim.anim_transparent, R.anim.anim_transparent);
                return;
            }
            AJRRechargePaymentActivity.this.a(this.f51721b, true);
        }

        public final void onTransactionCancel(String str) {
            if (AJRRechargePaymentActivity.this.getIntent().getBooleanExtra("enable_paytm_invoke", false)) {
                Intent intent = new Intent();
                intent.putExtra(SDKConstants.RESPONSE, "");
                if (TextUtils.isEmpty(str)) {
                    intent.putExtra("nativeSdkForMerchantMessage", "onTransactionCancel");
                } else {
                    intent.putExtra("nativeSdkForMerchantMessage", str);
                }
                AJRRechargePaymentActivity.this.setResult(0, intent);
                AJRRechargePaymentActivity.this.finish();
                return;
            }
            AJRRechargePaymentActivity.this.a(this.f51721b, true);
            Toast.makeText(AJRRechargePaymentActivity.this, "onTransactionCancel: ".concat(String.valueOf(str)), 0).show();
        }

        public final void performGAOperation(Map<String, Object> map) {
            try {
                map.put("user_id", com.paytm.utility.a.a((Context) AJRRechargePaymentActivity.this));
                net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, map, (Context) AJRRechargePaymentActivity.this);
            } catch (Exception unused) {
            }
        }

        public final void onSessionExpire(CustomVolleyError customVolleyError) {
            if (AJRRechargePaymentActivity.this.aD) {
                Intent intent = new Intent();
                intent.putExtra(Payload.RESPONSE, AJRRechargePaymentActivity.H());
                AJRRechargePaymentActivity.this.setResult(0, intent);
                SDKUtility.closePGScreen(AJRRechargePaymentActivity.this);
                return;
            }
            if (customVolleyError != null) {
                NetworkCustomError networkCustomError = new NetworkCustomError(customVolleyError.getErrorMsg());
                networkCustomError.setUrl(customVolleyError.getUrl());
                if (customVolleyError.networkResponse != null) {
                    networkCustomError.setStatusCode(customVolleyError.networkResponse.statusCode);
                } else {
                    networkCustomError.setStatusCode(401);
                }
            } else {
                new NetworkCustomError(UpiUtils.AUTHENTICATION_FAILURE_401).setStatusCode(401);
            }
            Intent intent2 = new Intent("kill");
            intent2.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
            androidx.localbroadcastmanager.a.a.a((Context) AJRRechargePaymentActivity.this).a(intent2);
            TextView textView = (TextView) AJRRechargePaymentActivity.this.findViewById(R.id.tv_loggedOut);
            if (textView != null) {
                textView.setVisibility(0);
            }
            AJRRechargePaymentActivity.this.j("before_login");
            r.a(AJRRechargePaymentActivity.this, (String) null, (Bundle) null, false, true);
        }

        public final void logCrashAnalytics(String str, String str2) {
            r.a(str, str2);
        }

        public final void logException(String str, String str2, Throwable th) {
            r.a(str, str2, th);
        }
    }

    private PaytmSDK g(String str, String str2) throws JSONException {
        this.bj = new c((String) null);
        PaytmSDK paytmSDK = new PaytmSDK(this, Double.valueOf(str).doubleValue(), str2, com.paytm.utility.a.q(this), this.bA, this.bj);
        paytmSDK.setShowLogin(false);
        paytmSDK.setOrderCreatedListener(new OnOrderCreatedListener() {
            public final void onOrderCreated(CreateOrderResponse createOrderResponse) {
                if (createOrderResponse != null) {
                    String unused = AJRRechargePaymentActivity.this.bj.f51721b = createOrderResponse.getORDER_ID();
                }
            }

            public final void onOrderCreationError(CustomVolleyError customVolleyError, CreateOrderModel createOrderModel) {
                if (customVolleyError != null) {
                    boolean unused = AJRRechargePaymentActivity.this.bk = true;
                    String errorMsg = customVolleyError.getErrorMsg();
                    Intent intent = new Intent();
                    intent.putExtra(BaseDialogFragment.ERROR_MESSAGE, errorMsg);
                    AJRRechargePaymentActivity.this.setResult(-1, intent);
                    AJRRechargePaymentActivity.this.finish();
                }
            }
        });
        return paytmSDK;
    }

    class f {

        /* renamed from: a  reason: collision with root package name */
        Activity f51726a;

        f(Activity activity) {
            this.f51726a = activity;
        }

        @JavascriptInterface
        public final synchronized void processResponse(String str) {
            if (AJRRechargePaymentActivity.this.getIntent().getBooleanExtra("enable_paytm_invoke", false)) {
                Intent intent = new Intent();
                intent.putExtra(SDKConstants.RESPONSE, str);
                intent.putExtra("nativeSdkForMerchantMessage", "");
                AJRRechargePaymentActivity.this.setResult(-1, intent);
                AJRRechargePaymentActivity.this.finish();
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("extra_data", str);
            AJRRechargePaymentActivity.this.setResult(-1, intent2);
            AJRRechargePaymentActivity.this.finish();
        }

        @JavascriptInterface
        public final void getUpiConsentData() {
            final String A = AJRRechargePaymentActivity.this.G();
            AJRRechargePaymentActivity.this.f51665f.post(new Runnable() {
                public final void run() {
                    if (Build.VERSION.SDK_INT < 19) {
                        WebView d2 = AJRRechargePaymentActivity.this.f51665f;
                        d2.loadUrl("javascript:window.setUpiConsentData('" + A + "')");
                        return;
                    }
                    WebView d3 = AJRRechargePaymentActivity.this.f51665f;
                    d3.evaluateJavascript("(function() { setUpiConsentData('" + A + "'); } )();", (ValueCallback) null);
                }
            });
        }

        @JavascriptInterface
        public final void onPayNowClick(String str, String str2, String str3, String str4) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String unused = AJRRechargePaymentActivity.this.aU = UpiUtils.getUpiSequenceNo();
                BankAccountDetails.BankAccount bankAccount = (BankAccountDetails.BankAccount) new com.google.gson.f().a(str2, BankAccountDetails.BankAccount.class);
                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                upiProfileDefaultBank.setDebitBank(bankAccount);
                upiProfileDefaultBank.setVirtualAddress(bankAccount.getCustomerName());
                upiProfileDefaultBank.setPrimary(true);
                Intent intent = new Intent(AJRRechargePaymentActivity.this.getApplicationContext(), MoneyTransferV3Activity.class);
                intent.putExtra("upi_push", true);
                intent.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                intent.putExtra("amount", str);
                intent.putExtra("payee_name", "");
                intent.putExtra("payee_vpa", str3);
                intent.putExtra("user_upi_details", upiProfileDefaultBank);
                intent.putExtra(UpiConstants.EXTRA_UPI_SEQ_NO, AJRRechargePaymentActivity.this.aU);
                AJRRechargePaymentActivity.this.startActivityForResult(intent, 1001);
            }
        }

        @JavascriptInterface
        public final void showMpinToast(String str) {
            Toast.makeText(AJRRechargePaymentActivity.this, "MPIN = ".concat(String.valueOf(str)), 0).show();
        }

        @JavascriptInterface
        public final synchronized void inVokeUpiFlow(String str) {
            try {
                if (AJRRechargePaymentActivity.this.getApplicationContext() != null) {
                    String a2 = a(AJRRechargePaymentActivity.this.getApplicationContext());
                    q.d(a2);
                    this.f51726a.runOnUiThread(new Runnable("javascript:window.upiIntent.setUpiIntentApps('" + a2 + "')") {
                        private final /* synthetic */ String f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AJRRechargePaymentActivity.f.this.a(this.f$1);
                        }
                    });
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            AJRRechargePaymentActivity.this.f51665f.loadUrl(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0077, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void upiAppClicked(java.lang.String r4, java.lang.String r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                net.one97.paytm.AJRRechargePaymentActivity r0 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                if (r0 == 0) goto L_0x0071
                net.one97.paytm.AJRRechargePaymentActivity r0 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.Context r0 = r0.getBaseContext()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r0.getPackageManager()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r1 = "android.intent.action.VIEW"
                r0.<init>(r1)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                net.one97.paytm.AJRRechargePaymentActivity r1 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.util.HashMap r1 = r1.aI     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                if (r1 != 0) goto L_0x0071
                net.one97.paytm.AJRRechargePaymentActivity r1 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.util.HashMap r1 = r1.aI     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.Object r4 = r1.get(r4)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.pm.ActivityInfo r4 = r4.activityInfo     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.ComponentName r1 = new android.content.ComponentName     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.content.pm.ApplicationInfo r2 = r4.applicationInfo     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r4 = r4.name     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r1.<init>(r2, r4)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.net.Uri$Builder r4 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r4.<init>()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r2 = "upi"
                android.net.Uri$Builder r4 = r4.scheme(r2)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r2 = "pay"
                r4.authority(r2)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.net.Uri r4 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.net.Uri$Builder r4 = r4.buildUpon()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r0.setData(r4)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                java.lang.String r4 = "android.intent.category.LAUNCHER"
                r0.addCategory(r4)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r0.setComponent(r1)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                net.one97.paytm.AJRRechargePaymentActivity r4 = net.one97.paytm.AJRRechargePaymentActivity.this     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
                r5 = 105(0x69, float:1.47E-43)
                r4.startActivityForResult(r0, r5)     // Catch:{ Exception -> 0x0076, all -> 0x0073 }
            L_0x0071:
                monitor-exit(r3)
                return
            L_0x0073:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            L_0x0076:
                monitor-exit(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRRechargePaymentActivity.f.upiAppClicked(java.lang.String, java.lang.String):void");
        }

        private String a(Context context) {
            if (context != null) {
                try {
                    com.google.gson.f fVar = new com.google.gson.f();
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("upi").authority("pay");
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(builder.toString()));
                    PackageManager packageManager = context.getPackageManager();
                    for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
                        AJRRechargePaymentActivity.this.aJ.put(next.loadLabel(packageManager).toString(), next.activityInfo.packageName);
                        AJRRechargePaymentActivity.this.aI.put(next.activityInfo.packageName, next);
                    }
                    return fVar.b(AJRRechargePaymentActivity.this.aJ);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            return "";
        }

        @JavascriptInterface
        public final void setPaRes(String str) {
            String unused = AJRRechargePaymentActivity.this.bo;
            VisaSCP a2 = CJRJarvisApplication.a((Context) this.f51726a);
            if (a2 != null) {
                a2.verifyDevice(AJRRechargePaymentActivity.this.bq, AJRRechargePaymentActivity.this.br, "", str, AJRRechargePaymentActivity.this.bu, com.paytm.utility.a.a((Context) this.f51726a), AJRRechargePaymentActivity.this.bv, new VisaSCPImpl.DeviceVerificationListener() {
                    public final void onRequestStart() {
                    }

                    public final void onRequestEnd(boolean z, String str) {
                        String unused = AJRRechargePaymentActivity.this.bo;
                        StringBuilder sb = new StringBuilder("setPaRas:onRequestEnd:calling loadNotifyJavaScript ");
                        sb.append(z);
                        sb.append(" ");
                        sb.append(str);
                        f.a(f.this);
                    }

                    public final void onRequestError(String str, String str2, String str3) {
                        String unused = AJRRechargePaymentActivity.this.bo;
                        f.a(f.this);
                    }
                });
            }
        }

        @JavascriptInterface
        public final void setOneClickToken(String str) {
            String unused = AJRRechargePaymentActivity.this.bo;
            VisaSCP a2 = CJRJarvisApplication.a((Context) this.f51726a);
            if (a2 != null) {
                a2.setEnrollmentData(AJRRechargePaymentActivity.this.bq, AJRRechargePaymentActivity.this.br, "", com.paytm.utility.a.a((Context) this.f51726a), str);
            }
        }

        static /* synthetic */ void a(f fVar) {
            if (Build.VERSION.SDK_INT < 19) {
                AJRRechargePaymentActivity.this.f51665f.addJavascriptInterface(fVar, fVar.getClass().getSimpleName());
                AJRRechargePaymentActivity.this.f51665f.loadUrl("javascript:CustomWebViewClient.isSelfPush(oneClickEnrollConfirmation())");
                return;
            }
            AJRRechargePaymentActivity.this.f51665f.evaluateJavascript("(function() { oneClickEnrollConfirmation(); } )();", (ValueCallback) null);
        }
    }

    /* access modifiers changed from: private */
    public String G() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("custId", com.paytm.utility.a.a((Context) this));
            jSONObject.put(UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE, UpiUtils.getUpiSequenceNo());
            jSONObject.put("deviceId", UpiUtils.getDeviceId(getApplicationContext()));
            jSONObject.put("originChannel", "PAYTM");
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static String H() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseDialogFragment.ERROR_MESSAGE, "session_timeout");
            jSONObject.put("error", 20);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public void j(String str) {
        if (getIntent() != null && !isFinishing()) {
            String stringExtra = getIntent().getStringExtra(SDKConstants.MID);
            String stringExtra2 = getIntent().getStringExtra("orderid");
            Map<String, Object> allInOneEventParams = SDKUtility.getAllInOneEventParams(str, "");
            if (!TextUtils.isEmpty(stringExtra2)) {
                allInOneEventParams.put("event_label", stringExtra2);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                allInOneEventParams.put("event_label3", stringExtra);
            }
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, allInOneEventParams, (Context) this);
        }
    }

    private void k(String str) {
        MpassEventLogger mpassEventLogger = new MpassEventLogger(this, this.bM, this.bN);
        mpassEventLogger.setCustSDKVersion(this.aH);
        mpassEventLogger.setSdkFlow(SDKConstants.CUI_EVENT_CATEGORY);
        mpassEventLogger.setEventAction(str);
        mpassEventLogger.sendLog((Map<String, ? extends Object>) null);
    }

    private void a(final CJRRechargePayment cJRRechargePayment) {
        try {
            HashMap<String, String> pGParams = cJRRechargePayment.getPGParams();
            StringBuffer stringBuffer = new StringBuffer();
            int size = pGParams.size();
            if (!(pGParams == null || pGParams.get("TXN_AMOUNT") == null)) {
                this.ay = pGParams.get("TXN_AMOUNT");
                q.a("Initailise Transaction " + this.ay);
                net.one97.paytm.trustlist.c.a().a(true);
            }
            int i2 = 0;
            for (String next : pGParams.keySet()) {
                if (pGParams.get(next) != null) {
                    stringBuffer.append(URLEncoder.encode(next, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "=" + URLEncoder.encode(pGParams.get(next), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
                    if (i2 < size - 1) {
                        stringBuffer.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                    }
                    i2++;
                }
            }
            if (this.ag) {
                stringBuffer.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                stringBuffer.append(URLEncoder.encode("PAYMENT_DETAILS", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8) + "=" + URLEncoder.encode(cJRRechargePayment.getPaymentDetails(), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
            }
            stringBuffer.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
            stringBuffer.append(URLEncoder.encode("appVersion", com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(com.paytm.utility.b.Q((Context) this), com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8));
            final byte[] bytes = stringBuffer.toString().getBytes();
            runOnUiThread(new Runnable() {
                public final void run() {
                    try {
                        String str = cJRRechargePayment.getmPGUrlToHit();
                        if (str.contains("theia/processTransaction")) {
                            str = SDKUtility.addAuthDefaultParams(AJRRechargePaymentActivity.this, str);
                        }
                        AJRRechargePaymentActivity.this.f51665f.postUrl(str, bytes);
                    } catch (NullPointerException e2) {
                        AJRRechargePaymentActivity aJRRechargePaymentActivity = AJRRechargePaymentActivity.this;
                        com.paytm.utility.b.b((Context) aJRRechargePaymentActivity, aJRRechargePaymentActivity.getResources().getString(R.string.pg_error_cart_url_heading), AJRRechargePaymentActivity.this.getResources().getString(R.string.pg_encoding_cart_url_exception));
                        com.google.firebase.crashlytics.c.a().a((Throwable) e2);
                        net.one97.paytm.common.utility.l.a("Cart Response :- ", cJRRechargePayment.toString());
                        q.b(e2.getMessage());
                    } catch (Exception e3) {
                        AJRRechargePaymentActivity aJRRechargePaymentActivity2 = AJRRechargePaymentActivity.this;
                        com.paytm.utility.b.b((Context) aJRRechargePaymentActivity2, aJRRechargePaymentActivity2.getResources().getString(R.string.pg_error_cart_invalid_response_heading), AJRRechargePaymentActivity.this.getResources().getString(R.string.pg_error_cart_invalid_response_desc));
                        com.google.firebase.crashlytics.c.a().a((Throwable) e3);
                        net.one97.paytm.common.utility.l.a("Post Url Exception :- ", e3.getMessage());
                        q.b(e3.getMessage());
                    }
                }
            });
        } catch (NullPointerException e2) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.pg_error_cart_heading), getResources().getString(R.string.pg_encoding_cart_exception));
            com.google.firebase.crashlytics.c.a().a((Throwable) e2);
            net.one97.paytm.common.utility.l.a("Cart Response :- ", cJRRechargePayment.toString());
            q.b(e2.getMessage());
        } catch (UnsupportedEncodingException e3) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.pg_error_heading), getResources().getString(R.string.pg_encoding_exception));
            com.google.firebase.crashlytics.c.a().a((Throwable) e3);
            net.one97.paytm.common.utility.l.a("UnsupportedEncodingException :- ", e3.getMessage() + "\n\n Cart Response :- " + cJRRechargePayment.toString());
            q.b(e3.getMessage());
        } catch (Exception e4) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.some_went_wrong));
            com.google.firebase.crashlytics.c.a().a((Throwable) e4);
            net.one97.paytm.common.utility.l.a("Generic Exception  :- ", e4.getMessage() + "\n\n Cart Response :- " + cJRRechargePayment.toString());
            q.b(e4.getMessage());
        }
    }

    static /* synthetic */ void a(AJRRechargePaymentActivity aJRRechargePaymentActivity, int i2) {
        ((FrameLayout) aJRRechargePaymentActivity.findViewById(R.id.fl_web_info)).setVisibility(i2);
        TextView textView = (TextView) aJRRechargePaymentActivity.findViewById(R.id.tv_deviceIfo);
        textView.setVisibility(i2);
        TextView textView2 = (TextView) aJRRechargePaymentActivity.findViewById(R.id.tv_networkInfo);
        textView2.setVisibility(i2);
        TextView textView3 = (TextView) aJRRechargePaymentActivity.findViewById(R.id.tv_webInfo);
        textView3.setVisibility(i2);
        String str = "DeviceInfo:\n" + Build.MANUFACTURER + "|" + Build.MODEL + "|" + Build.DEVICE + "|" + Build.BRAND;
        textView.setText(str);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        aJRRechargePaymentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        textView.setText(str + "\n\nDisplayInfo:\n" + displayMetrics.heightPixels + "X" + displayMetrics.widthPixels);
        StringBuilder sb = new StringBuilder("NetworkInfo : \n");
        sb.append(a((Context) aJRRechargePaymentActivity));
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            textView2.setText(sb2);
        } else {
            textView2.setText("Something went wrong");
        }
        if (TextUtils.isEmpty(aJRRechargePaymentActivity.bc) || TextUtils.isEmpty(aJRRechargePaymentActivity.bc)) {
            textView3.setText("Something went wrong");
            return;
        }
        textView3.setText("Page Started Loading:\n" + aJRRechargePaymentActivity.bb + "\nPage Finished Loading:\n" + aJRRechargePaymentActivity.bc + "\nPage Loading time :" + aJRRechargePaymentActivity.be + "ms\nPage visible time:" + aJRRechargePaymentActivity.bf);
    }

    static /* synthetic */ void a(AJRRechargePaymentActivity aJRRechargePaymentActivity, Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Toast.makeText(aJRRechargePaymentActivity, "Insufficient data", 0).show();
            return;
        }
        aJRRechargePaymentActivity.aU = UpiUtils.getUpiSequenceNo();
        Intent intent = new Intent(context, MoneyTransferV3Activity.class);
        intent.putExtra("intent_extra_is_offline_pg", true);
        intent.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
        intent.putExtra("amount", str);
        intent.putExtra("seq_no", aJRRechargePaymentActivity.aU);
        intent.putExtra("payee_name", str4);
        intent.putExtra("payee_vpa", str3);
        intent.putExtra("merchant_code", str5);
        intent.putExtra("user_upi_details", (UpiProfileDefaultBank) new com.google.gson.f().a(str2, UpiProfileDefaultBank.class));
        intent.putExtra(SDKConstants.EXTRA_PUSH_TYPE, str6);
        intent.putExtra("device_id", UpiUtils.getDeviceId(aJRRechargePaymentActivity));
        ((Activity) context).startActivityForResult(intent, 1002);
    }

    static /* synthetic */ void n(AJRRechargePaymentActivity aJRRechargePaymentActivity) {
        final String stringExtra = aJRRechargePaymentActivity.getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        if (stringExtra != null) {
            g.a().a((a.b) new a.b() {
                public final void a(List<UserVpaInfo> list) {
                    boolean z;
                    Iterator<UserVpaInfo> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().getVpa().equals(stringExtra)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        AJRRechargePaymentActivity.af(AJRRechargePaymentActivity.this);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(SDKConstants.RESPONSE, "");
                    intent.putExtra("nativeSdkForMerchantMessage", AJRRechargePaymentActivity.this.getString(R.string.upi_invalid_user_message));
                    AJRRechargePaymentActivity.this.setResult(0, intent);
                    AJRRechargePaymentActivity.this.finish();
                }

                public final void a() {
                    Intent intent = new Intent();
                    intent.putExtra(SDKConstants.RESPONSE, "");
                    intent.putExtra("nativeSdkForMerchantMessage", AJRRechargePaymentActivity.this.getString(R.string.upi_invalid_user_message));
                    AJRRechargePaymentActivity.this.setResult(0, intent);
                    AJRRechargePaymentActivity.this.finish();
                }
            });
        }
    }

    static /* synthetic */ void p(AJRRechargePaymentActivity aJRRechargePaymentActivity) {
        String stringExtra = aJRRechargePaymentActivity.getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        String stringExtra2 = aJRRechargePaymentActivity.getIntent().getStringExtra("upi_bankAccount_details_json");
        UPICheckBalanceHelper build = new UPICheckBalanceHelper.UPICheckBalanceBuilder(aJRRechargePaymentActivity, new n.c() {
            public final void Z_() {
            }

            public final void b() {
            }

            public final void a(String str, String str2, String str3) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("statusCode", 100);
                        jSONObject.put("statusMsg", "SUCCESS");
                        jSONObject.put("totalBalance", str);
                        jSONObject.put("availableBalance", str2);
                    } else {
                        jSONObject.put("statusCode", n.b.ERROR_UNDEFINED.getErrorCode());
                        jSONObject.put("statusMsg", n.b.ERROR_UNDEFINED.getErrorMessage(AJRRechargePaymentActivity.this));
                    }
                    Intent intent = new Intent();
                    intent.putExtra(Payload.RESPONSE, jSONObject.toString());
                    AJRRechargePaymentActivity.this.setResult(-1, intent);
                    AJRRechargePaymentActivity.this.finish();
                } catch (JSONException e2) {
                    r.a("AJRRechargePaymentActivity", "fetchUpiBalanceForTokenSdk//onFetchBalanceSuccess", (Throwable) e2);
                }
            }

            public final void a(n.b bVar) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("statusCode", bVar.getErrorCode());
                    jSONObject.put("statusMsg", bVar.getErrorMessage(AJRRechargePaymentActivity.this));
                } catch (Exception e2) {
                    r.a("AJRRechargePaymentActivity", "fetchUpiBalanceForTokenSdk//onError", (Throwable) e2);
                }
                Intent intent = new Intent();
                intent.putExtra(Payload.RESPONSE, jSONObject.toString());
                AJRRechargePaymentActivity.this.setResult(-1, intent);
                AJRRechargePaymentActivity.this.finish();
            }
        }).setDeviceBindingRequestCode(1003).setOnActivityResultRecieverAfterDeviceBinding((Activity) aJRRechargePaymentActivity).build();
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setDebitBank((BankAccountDetails.BankAccount) new com.google.gson.f().a(stringExtra2, BankAccountDetails.BankAccount.class));
        upiProfileDefaultBank.setVirtualAddress(stringExtra);
        build.getUpiAccountBalance(upiProfileDefaultBank);
    }

    static /* synthetic */ void r(AJRRechargePaymentActivity aJRRechargePaymentActivity) {
        String stringExtra = aJRRechargePaymentActivity.getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        String stringExtra2 = aJRRechargePaymentActivity.getIntent().getStringExtra("upi_bankAccount_details_json");
        UPICheckBalanceHelper build = new UPICheckBalanceHelper.UPICheckBalanceBuilder(aJRRechargePaymentActivity, new n.c() {
            public final void Z_() {
            }

            public final void a(String str, String str2, String str3) {
            }

            public final void a(n.b bVar) {
            }

            public final void b() {
            }
        }).setDeviceBindingRequestCode(1004).setOnActivityResultRecieverAfterDeviceBinding((Activity) aJRRechargePaymentActivity).build();
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setDebitBank((BankAccountDetails.BankAccount) new com.google.gson.f().a(stringExtra2, BankAccountDetails.BankAccount.class));
        upiProfileDefaultBank.setVirtualAddress(stringExtra);
        build.startSetMpinScreen(upiProfileDefaultBank, 1004);
    }

    static /* synthetic */ void a(AJRRechargePaymentActivity aJRRechargePaymentActivity, final ArrayList arrayList) {
        if (!TextUtils.isEmpty(aJRRechargePaymentActivity.ax)) {
            new Handler().post(new Runnable() {
                public final void run() {
                    if (AJRRechargePaymentActivity.this.ax.startsWith("https://securegw")) {
                        String a2 = AJRRechargePaymentActivity.h(AJRRechargePaymentActivity.this.ax);
                        if (!TextUtils.isEmpty(a2)) {
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                final UpiPendingRequestModel upiPendingRequestModel = (UpiPendingRequestModel) it2.next();
                                String note = upiPendingRequestModel.getNote();
                                if (!TextUtils.isEmpty(note) && !AJRRechargePaymentActivity.this.L && note.toLowerCase().contains(a2.toLowerCase())) {
                                    AJRRechargePaymentActivity.this.runOnUiThread(new Runnable() {
                                        public final void run() {
                                            boolean unused = AJRRechargePaymentActivity.this.L = true;
                                            Intent intent = new Intent(AJRRechargePaymentActivity.this.getApplicationContext(), MoneyTransferV3Activity.class);
                                            intent.putExtra("amount", upiPendingRequestModel.getAmount());
                                            intent.putExtra("payee_name", upiPendingRequestModel.getPayeeName());
                                            intent.putExtra("payee_vpa", upiPendingRequestModel.getPayeeVa());
                                            intent.putExtra(UpiConstants.EXTRA_PAYER_VPA, upiPendingRequestModel.getPayerVa());
                                            intent.putExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, true);
                                            intent.putExtra("upi_is_self", true);
                                            intent.putExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, upiPendingRequestModel.getUpiTranlogId());
                                            intent.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, upiPendingRequestModel.getSeqNo());
                                            AJRRechargePaymentActivity.this.startActivity(intent);
                                        }
                                    });
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    AJRRechargePaymentActivity.a(AJRRechargePaymentActivity.this, arrayList);
                }
            });
        }
    }

    static /* synthetic */ String a(Uri uri) {
        return "https://staticpg.paytm.in" + uri.getPath();
    }

    static /* synthetic */ boolean i(AJRRechargePaymentActivity aJRRechargePaymentActivity, String str) {
        for (String endsWith : aJRRechargePaymentActivity.aL) {
            if (str.endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean j(AJRRechargePaymentActivity aJRRechargePaymentActivity, String str) {
        if (TextUtils.isEmpty(aJRRechargePaymentActivity.j) || !aJRRechargePaymentActivity.j.equalsIgnoreCase("gold") || !aJRRechargePaymentActivity.bK || TextUtils.isEmpty(aJRRechargePaymentActivity.bL) || !str.contains(aJRRechargePaymentActivity.bL)) {
            return false;
        }
        aJRRechargePaymentActivity.a(str.replace(aJRRechargePaymentActivity.bL, "").replace("/", ""), false);
        return true;
    }

    static /* synthetic */ void af(AJRRechargePaymentActivity aJRRechargePaymentActivity) {
        Intent intent = aJRRechargePaymentActivity.getIntent();
        String stringExtra = intent.getStringExtra("payee_name");
        String stringExtra2 = intent.getStringExtra("payee_vpa");
        String stringExtra3 = intent.getStringExtra("merchant_code");
        String stringExtra4 = intent.getStringExtra("amount");
        String stringExtra5 = intent.getStringExtra(UpiConstants.EXTRA_PAYER_VPA);
        String stringExtra6 = intent.getStringExtra("upi_bankAccount_details_json");
        aJRRechargePaymentActivity.bM = intent.getStringExtra("orderid");
        aJRRechargePaymentActivity.bN = intent.getStringExtra("mid");
        aJRRechargePaymentActivity.aH = intent.getStringExtra("custSdkVersion");
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        upiProfileDefaultBank.setDebitBank((BankAccountDetails.BankAccount) new com.google.gson.f().a(stringExtra6, BankAccountDetails.BankAccount.class));
        upiProfileDefaultBank.setVirtualAddress(stringExtra5);
        if (TextUtils.isEmpty(stringExtra2)) {
            Toast.makeText(aJRRechargePaymentActivity, "Insufficient data", 0).show();
            return;
        }
        aJRRechargePaymentActivity.aU = UpiUtils.getUpiSequenceNo();
        new com.google.gson.f();
        Intent intent2 = new Intent(aJRRechargePaymentActivity, MoneyTransferV3Activity.class);
        intent2.putExtra("intent_extra_is_offline_pg", true);
        intent2.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
        intent2.putExtra("amount", stringExtra4);
        intent2.putExtra("seq_no", aJRRechargePaymentActivity.aU);
        intent2.putExtra("payee_name", stringExtra);
        intent2.putExtra("payee_vpa", stringExtra2);
        intent2.putExtra("merchant_code", stringExtra3);
        intent2.putExtra("user_upi_details", upiProfileDefaultBank);
        intent2.putExtra(SDKConstants.EXTRA_PUSH_TYPE, "");
        intent2.putExtra("device_id", UpiUtils.getDeviceId(aJRRechargePaymentActivity));
        aJRRechargePaymentActivity.startActivityForResult(intent2, 1002);
        aJRRechargePaymentActivity.k(SDKConstants.CUI_ACTION_OPEN_MPIN_PAGE);
    }
}
