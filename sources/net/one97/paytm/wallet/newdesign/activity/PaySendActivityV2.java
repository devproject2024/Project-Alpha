package net.one97.paytm.wallet.newdesign.activity;

import android.animation.Animator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Vibrator;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.Html;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.gms.vision.a.e;
import com.google.firebase.perf.metrics.Trace;
import com.google.zxing.client.a.af;
import com.google.zxing.client.android.c.g;
import com.google.zxing.r;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.GlobalError;
import net.one97.paytm.common.entity.p2p.MerchantInfo;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SenderInfo;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRExtendedInfoData;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.contacts.sync.ContactSyncLifeObserver;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ae;
import net.one97.paytm.utils.am;
import net.one97.paytm.utils.at;
import net.one97.paytm.utils.bd;
import net.one97.paytm.utils.be;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRProfileQRDisplayActivity;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.activity.AJRScanWebView;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.entity.BankInfo;
import net.one97.paytm.wallet.entity.WalletInfo;
import net.one97.paytm.wallet.f.b;
import net.one97.paytm.wallet.f.c;
import net.one97.paytm.wallet.j.d;
import net.one97.paytm.wallet.newdesign.c.a;
import net.one97.paytm.wallet.newdesign.fastscan.a.b;
import net.one97.paytm.wallet.newdesign.fastscan.a.c;
import net.one97.paytm.wallet.newdesign.models.ScanAadhaarCardModel;
import net.one97.paytm.wallet.newdesign.universalp2p.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.utils.AppExecutor;
import net.one97.paytm.wallet.newdesign.utils.DelegateUtil;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.newdesign.utils.WebLoginAlertDialog;
import net.one97.paytm.wallet.p2p.a;
import net.one97.paytm.wallet.utility.a.a;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.InputSource;

public class PaySendActivityV2 extends AppCompatLockActivity implements View.OnClickListener, b, c, a, a.e {
    private static int E = 3001;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f70520e = true;

    /* renamed from: f  reason: collision with root package name */
    public static final String f70521f = PaySendActivityV2.class.getSimpleName();
    public static int j = 201;
    private boolean A = true;
    private boolean B;
    private boolean C = false;
    private long D;
    private AppCompatTextView F;
    private AppCompatTextView G;
    private AppCompatTextView H;
    private AppCompatImageView I;
    private ShimmerFrameLayout J;
    private ShimmerFrameLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private boolean O;
    private boolean P;
    private boolean Q = true;
    private boolean R;
    private boolean S = false;
    private d T;
    private z<net.one97.paytm.wallet.utility.c<f>> U = new z() {
        public final void onChanged(Object obj) {
            PaySendActivityV2.this.e((net.one97.paytm.wallet.utility.c) obj);
        }
    };
    private z<net.one97.paytm.wallet.utility.c<ArrayList<IJRDataModel>>> V = new z() {
        public final void onChanged(Object obj) {
            PaySendActivityV2.this.d((net.one97.paytm.wallet.utility.c) obj);
        }
    };
    private z<net.one97.paytm.wallet.utility.c<o<Integer, ArrayList<IJRDataModel>>>> W = new z() {
        public final void onChanged(Object obj) {
            PaySendActivityV2.this.c((net.one97.paytm.wallet.utility.c) obj);
        }
    };
    private z<net.one97.paytm.wallet.utility.c<Boolean>> X = new z() {
        public final void onChanged(Object obj) {
            PaySendActivityV2.this.b((net.one97.paytm.wallet.utility.c) obj);
        }
    };
    private z<net.one97.paytm.wallet.utility.c<f>> Y = new z() {
        public final void onChanged(Object obj) {
            PaySendActivityV2.this.a((net.one97.paytm.wallet.utility.c) obj);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public String f70522g = null;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Bundle> f70523h = null;

    /* renamed from: i  reason: collision with root package name */
    public CJRHomePageItem f70524i = null;
    net.one97.paytm.wallet.p2p.a k;
    net.one97.paytm.wallet.p2p.a l;
    private final int m = 201;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private Dialog s;
    private net.one97.paytm.wallet.newdesign.fastscan.a t;
    private RecyclerView u;
    private RecyclerView v;
    private LinearLayout w;
    private ArrayList<IJRDataModel> x = new ArrayList<>();
    private String y = "MOBILE";
    private boolean z = true;

    public void onCreate(Bundle bundle) {
        Trace a2 = com.google.firebase.perf.a.a("PaySendActivityV2_onCreate");
        super.onCreate(bundle);
        setContentView(R.layout.w_activity_pay_send_v2);
        this.T = (d) new al((ao) this, (al.b) new net.one97.paytm.wallet.j.c(getApplication())).a(d.class);
        this.T.f70429e.observe(this, this.U);
        this.T.f70430f.observe(this, this.Y);
        this.T.f70431g.observe(this, this.X);
        this.T.f70432h.observe(this, this.V);
        this.T.f70433i.observe(this, this.W);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f51788c = getIntent().getBooleanExtra("read_text", false);
        }
        getLifecycle().a(new ContactSyncLifeObserver());
        d dVar = this.T;
        Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(new d.g(dVar));
        AppExecutor.getExecutor().runOnHandlerThread(new d.f(dVar));
        dVar.c();
        net.one97.paytm.base.f fVar = dVar.f49511a;
        k.a((Object) runOnBgThread, "future");
        fVar.a(runOnBgThread);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            String stringExtra = getIntent().getStringExtra("TRIGGER");
            d dVar2 = this.T;
            if (stringExtra != null) {
                Future<?> runOnBgThread2 = AppExecutor.getExecutor().runOnBgThread(new d.k(dVar2, stringExtra));
                net.one97.paytm.base.f fVar2 = dVar2.f49511a;
                k.a((Object) runOnBgThread2, "future");
                fVar2.a(runOnBgThread2);
            }
            this.P = "MIDDLE_SCAN".equals(stringExtra);
            this.n = getIntent().getStringExtra("openTab");
            this.o = getIntent().getBooleanExtra(UpiConstants.KEY_IS_SCAN_ONLY, false);
            this.p = getIntent().getBooleanExtra("read_text", false);
            this.q = getIntent().getBooleanExtra("imei_validate", false);
            if (getIntent().hasExtra("from_universal_scanner")) {
                this.B = getIntent().getBooleanExtra("from_universal_scanner", false);
            }
        }
        this.r = getIntent().getBooleanExtra("barcode_only", true);
        this.R = net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this, "scannerPayUsingAndroidV2", true);
        if (net.one97.paytm.wallet.communicator.b.a().isMall()) {
            getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
            findViewById(R.id.scan_only_main_layout).setVisibility(8);
            findViewById(R.id.mall_scan_only_container).setVisibility(0);
            r();
            this.T.d();
        } else {
            int color = getResources().getColor(R.color.black);
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(16);
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = window.getDecorView();
                    window.addFlags(Integer.MIN_VALUE);
                    if (decorView != null) {
                        decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    }
                    window.setStatusBarColor(color);
                }
            }
            getWindow().getDecorView().setSystemUiVisibility(1);
            findViewById(R.id.mall_scan_only_container).setVisibility(8);
            findViewById(R.id.scan_only_main_layout).setVisibility(0);
            this.u = (RecyclerView) findViewById(R.id.so_horizontal_recent_rv);
            this.v = (RecyclerView) findViewById(R.id.remove_recent_rv);
            this.w = (LinearLayout) findViewById(R.id.so_cp_recent_ll);
            this.F = (AppCompatTextView) findViewById(R.id.wallet_balance_tv);
            this.G = (AppCompatTextView) findViewById(R.id.add_money_tv);
            this.H = (AppCompatTextView) findViewById(R.id.bank_account_tv);
            this.I = (AppCompatImageView) findViewById(R.id.bank_account_iv);
            TextView textView = (TextView) findViewById(R.id.enter_mobile_upi_tv);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PaySendActivityV2.this.d(view);
                }
            });
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    return PaySendActivityV2.this.c(view);
                }
            });
            textView.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
                public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }

                public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                public final void onDestroyActionMode(ActionMode actionMode) {
                }

                public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }
            });
            this.J = (ShimmerFrameLayout) findViewById(R.id.shimmer_wallet);
            this.K = (ShimmerFrameLayout) findViewById(R.id.shimmer_bank);
            this.L = (LinearLayout) findViewById(R.id.lyt_pay_using_wallet_content);
            this.M = (LinearLayout) findViewById(R.id.lyt_pay_using_bank_content);
            this.N = (LinearLayout) findViewById(R.id.lyt_or);
            this.J.a();
            this.K.a();
            findViewById(R.id.remove_recent_button).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PaySendActivityV2.this.b(view);
                }
            });
            ((ImageView) findViewById(R.id.contact_icon_iv)).setOnClickListener(this);
            ((TextView) findViewById(R.id.remove_all_tv)).setOnClickListener(this);
            this.G.setOnClickListener(this);
            findViewById(R.id.swipe_listener_view).setOnTouchListener(new am(this));
            if (this.R) {
                findViewById(R.id.lyt_pay_using).setVisibility(0);
                if (com.paytm.utility.b.r((Context) this)) {
                    this.T.a();
                    this.T.b();
                } else {
                    v();
                }
            } else {
                findViewById(R.id.lyt_pay_using).setVisibility(8);
            }
        }
        if (this.t == null) {
            b(false, (String) null, false);
            d dVar3 = this.T;
            Future<?> runOnBgThread3 = AppExecutor.getExecutor().runOnBgThread(new d.i(dVar3));
            net.one97.paytm.base.f fVar3 = dVar3.f49511a;
            k.a((Object) runOnBgThread3, "f");
            fVar3.a(runOnBgThread3);
            d dVar4 = this.T;
            Future<?> runOnBgThread4 = AppExecutor.getExecutor().runOnBgThread(new d.e(dVar4));
            net.one97.paytm.base.f fVar4 = dVar4.f49511a;
            k.a((Object) runOnBgThread4, "f");
            fVar4.a(runOnBgThread4);
        }
        if (this.p) {
            findViewById(R.id.drawable_linear).setVisibility(8);
        }
        if (Build.VERSION.SDK_INT < 26) {
            setRequestedOrientation(1);
        }
        a(getIntent());
        a2.stop();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(net.one97.paytm.wallet.utility.c cVar) {
        f fVar = (f) cVar.a();
        if (fVar != null) {
            int i2 = AnonymousClass7.f70533a[fVar.f55796a.ordinal()];
            if (i2 == 1) {
                BankInfo bankInfo = (BankInfo) fVar.f55797b;
                if (bankInfo == null || !bankInfo.isPrimary()) {
                    u();
                } else {
                    this.H.setTextColor(getResources().getColor(R.color.color_1d252d));
                    this.H.setText(bankInfo.getBankName());
                    this.H.setOnClickListener((View.OnClickListener) null);
                    try {
                        w.a().a(bankInfo.getBankLogoURL()).a(R.drawable.link_bank_ac).b(R.drawable.link_bank_ac).a((ImageView) this.I, (e) null);
                    } catch (Exception unused) {
                    }
                }
                this.K.setVisibility(8);
                this.K.b();
                this.M.setVisibility(0);
            } else if (i2 == 2) {
                this.K.setVisibility(0);
                this.K.a();
            } else if (i2 == 3 || i2 == 4) {
                u();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(net.one97.paytm.wallet.utility.c cVar) {
        boolean z2;
        ArrayList<IJRDataModel> arrayList = (ArrayList) cVar.a();
        if (arrayList != null) {
            this.x = arrayList;
            ArrayList<IJRDataModel> arrayList2 = this.x;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                this.w.setVisibility(8);
                return;
            }
            this.w.setVisibility(0);
            if (this.x.size() > 7) {
                z2 = true;
                this.x = new ArrayList<>(this.x.subList(0, 7));
            } else {
                z2 = false;
            }
            this.k = new net.one97.paytm.wallet.p2p.a(this, this.x, z2, this);
            LayoutAnimationController loadLayoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_slide_right);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(0);
            this.u.setLayoutManager(linearLayoutManager);
            this.u.setAdapter(this.k);
            this.u.setLayoutAnimation(loadLayoutAnimation);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.wallet.utility.c cVar) {
        o oVar = (o) cVar.a();
        if (oVar != null) {
            this.x = (ArrayList) oVar.component2();
            int intValue = ((Integer) oVar.component1()).intValue();
            ArrayList<IJRDataModel> arrayList = this.x;
            if (arrayList == null || arrayList.size() <= 0) {
                this.v.setVisibility(8);
                return;
            }
            this.l = new net.one97.paytm.wallet.p2p.a(this, this.x, new a.f() {
                public final void onRemoved(int i2, IJRDataModel iJRDataModel) {
                    PaySendActivityV2.this.a(i2, iJRDataModel);
                }
            });
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(0);
            this.v.setLayoutManager(linearLayoutManager);
            this.v.setAdapter(this.l);
            this.v.scrollToPosition(intValue);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.wallet.utility.c cVar) {
        Boolean bool = (Boolean) cVar.a();
        if (bool != null && bool.booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    PaySendActivityV2.this.t();
                }
            }, 500);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.wallet.utility.c cVar) {
        f fVar = (f) cVar.a();
        if (fVar != null) {
            int i2 = AnonymousClass7.f70533a[fVar.f55796a.ordinal()];
            if (i2 == 1) {
                WalletInfo walletInfo = (WalletInfo) fVar.f55797b;
                if (walletInfo != null) {
                    this.J.setVisibility(8);
                    this.J.b();
                    this.N.setVisibility(0);
                    this.L.setVisibility(0);
                    this.G.setVisibility(0);
                    if (walletInfo.isTruncate()) {
                        this.F.setText(String.format(getString(R.string.scanner_paytm_bal), new Object[]{walletInfo.getAmt()}));
                        return;
                    }
                    this.F.setText(String.format(getString(R.string.scanner_paytm_balance), new Object[]{walletInfo.getAmt()}));
                }
            } else if (i2 == 2) {
                this.J.setVisibility(0);
                this.J.a();
            } else if (i2 == 3) {
                this.F.setText(String.format(getString(R.string.scanner_paytm_balance), new Object[]{"--"}));
                this.J.setVisibility(8);
                this.J.b();
                this.N.setVisibility(0);
                this.L.setVisibility(0);
                this.G.setVisibility(0);
                if (fVar.f55798c != null) {
                    ae aeVar = ae.f69602a;
                    if (ae.a(fVar.f55798c.f55799a)) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_is_from_fragment", true);
                        ae aeVar2 = ae.f69602a;
                        ae.a(this, fVar.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                        this.O = true;
                    }
                }
            } else if (i2 == 4) {
                v();
            }
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f70533a = new int[h.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.network.h[] r0 = net.one97.paytm.network.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f70533a = r0
                int[] r0 = f70533a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f70533a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.PROGRESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f70533a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f70533a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.CANCELLED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.AnonymousClass7.<clinit>():void");
        }
    }

    public final void a() {
        this.f51786a = 102;
    }

    public void onResume() {
        Trace a2 = com.google.firebase.perf.a.a("PaySendActivityV2_onResume");
        super.onResume();
        findViewById(R.id.scan_only_frag_container_ll).setVisibility(0);
        this.D = System.currentTimeMillis();
        f70520e = true;
        if (this.S) {
            this.T.c();
        }
        if (!this.A && this.R) {
            if (this.T.f70429e.getValue() != null && !this.T.f70429e.getValue().f72317a) {
                this.T.a();
            }
            if (this.T.f70430f.getValue() != null && !this.T.f70430f.getValue().f72317a) {
                this.T.b();
            }
        }
        this.A = false;
        bd.f69715a.b("PAYSENDACTIVITYV2_TRACE");
        a2.stop();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Intent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "extra_home_data"
            boolean r1 = r10.hasExtra(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0040
            java.io.Serializable r1 = r10.getSerializableExtra(r0)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1
            r9.f70524i = r1
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r9.f70524i
            r1.putSerializable(r0, r3)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r9.f70524i
            if (r3 == 0) goto L_0x0025
            java.lang.String r3 = r3.getQrid()
            r9.f70522g = r3
        L_0x0025:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r9.f70524i
            if (r3 == 0) goto L_0x003e
            java.lang.String r3 = r3.getPushFeatureType()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x003e
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r9.f70524i
            java.lang.String r3 = r3.getPushFeatureType()
            java.lang.String r3 = net.one97.paytm.wallet.utility.a.g((java.lang.String) r3)
            goto L_0x0042
        L_0x003e:
            r3 = r2
            goto L_0x0042
        L_0x0040:
            r1 = r2
            r3 = r1
        L_0x0042:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 1
            java.lang.String r6 = "qr_code_id"
            r7 = 0
            if (r4 != 0) goto L_0x0163
            r4 = -1
            int r8 = r3.hashCode()
            switch(r8) {
                case -2065936478: goto L_0x00be;
                case -2065922135: goto L_0x00b4;
                case -1903828497: goto L_0x00aa;
                case -1744309939: goto L_0x00a0;
                case -1152004902: goto L_0x0096;
                case -1102914125: goto L_0x008b;
                case -619964558: goto L_0x0081;
                case 704464919: goto L_0x0077;
                case 1799528586: goto L_0x006c;
                case 1910961662: goto L_0x0062;
                case 1992578977: goto L_0x0056;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x00c8
        L_0x0056:
            java.lang.String r8 = "insurance_buy"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 10
            goto L_0x00c9
        L_0x0062:
            java.lang.String r8 = "scanner"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 6
            goto L_0x00c9
        L_0x006c:
            java.lang.String r8 = "money_transfer"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 8
            goto L_0x00c9
        L_0x0077:
            java.lang.String r8 = "request_money_dl"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 2
            goto L_0x00c9
        L_0x0081:
            java.lang.String r8 = "send_money_bank"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 4
            goto L_0x00c9
        L_0x008b:
            java.lang.String r8 = "lifafa"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 9
            goto L_0x00c9
        L_0x0096:
            java.lang.String r8 = "sendmoneymobile"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 5
            goto L_0x00c9
        L_0x00a0:
            java.lang.String r8 = "scanner_only"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 7
            goto L_0x00c9
        L_0x00aa:
            java.lang.String r8 = "show_code"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 3
            goto L_0x00c9
        L_0x00b4:
            java.lang.String r8 = "wallet_type_pay"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 0
            goto L_0x00c9
        L_0x00be:
            java.lang.String r8 = "wallet_type_add"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x00c8
            r3 = 1
            goto L_0x00c9
        L_0x00c8:
            r3 = -1
        L_0x00c9:
            java.lang.String r4 = "paytmmp://cash_wallet?featuretype=cash_ledger"
            switch(r3) {
                case 0: goto L_0x0159;
                case 1: goto L_0x014c;
                case 2: goto L_0x0148;
                case 3: goto L_0x013d;
                case 4: goto L_0x0132;
                case 5: goto L_0x0119;
                case 6: goto L_0x00fa;
                case 7: goto L_0x00f6;
                case 8: goto L_0x00eb;
                case 9: goto L_0x00df;
                case 10: goto L_0x00d0;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            goto L_0x0163
        L_0x00d0:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            boolean r2 = r2.onInsuranceIntent(r9)
            if (r2 == 0) goto L_0x0163
            r9.finish()
            goto L_0x0163
        L_0x00df:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            r2.onPostcardIntent(r9)
            r9.finish()
            goto L_0x0163
        L_0x00eb:
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            r2.onMoneyTransferIntent(r9)
            r9.finish()
            goto L_0x0163
        L_0x00f6:
            r9.i()
            goto L_0x0163
        L_0x00fa:
            java.lang.String r2 = net.one97.paytm.utils.n.aF
            r9.n = r2
            java.lang.String r2 = r9.f70522g
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0163
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.wallet.activity.AJRQRActivity> r3 = net.one97.paytm.wallet.activity.AJRQRActivity.class
            r2.<init>(r9, r3)
            java.lang.String r3 = r9.f70522g
            r2.putExtra(r6, r3)
            r9.startActivity(r2)
            r9.finish()
            goto L_0x0163
        L_0x0119:
            java.lang.String r2 = net.one97.paytm.utils.n.aG
            r9.n = r2
            if (r10 == 0) goto L_0x012c
            java.lang.String r2 = "isFromDeeplink"
            boolean r2 = r10.getBooleanExtra(r2, r7)
            java.lang.String r3 = "isFromScan"
            boolean r3 = r10.getBooleanExtra(r3, r7)
            goto L_0x012e
        L_0x012c:
            r2 = 0
            r3 = 0
        L_0x012e:
            r9.a((boolean) r2, (boolean) r3)
            goto L_0x0163
        L_0x0132:
            net.one97.paytm.wallet.communicator.c r10 = net.one97.paytm.wallet.communicator.b.a()
            r10.handleDeepLink(r9, r4, r2)
            r9.finish()
            return
        L_0x013d:
            java.lang.String r2 = net.one97.paytm.utils.n.aH
            r9.n = r2
            r9.j()
            r9.finish()
            goto L_0x0163
        L_0x0148:
            r9.finish()
            return
        L_0x014c:
            net.one97.paytm.wallet.communicator.c r10 = net.one97.paytm.wallet.communicator.b.a()
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r9.f70524i
            r10.onAddMoneyIntent(r9, r0)
            r9.finish()
            return
        L_0x0159:
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()
            r3.handleDeepLink(r9, r4, r2)
            r9.finish()
        L_0x0163:
            java.lang.String r2 = r9.n
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0177
            if (r1 != 0) goto L_0x0172
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
        L_0x0172:
            java.lang.String r2 = r9.n
            r9.a((java.lang.String) r2, (android.os.Bundle) r1)
        L_0x0177:
            android.content.Intent r1 = r9.getIntent()
            java.lang.String r2 = "From"
            int r1 = r1.getIntExtra(r2, r7)
            r2 = 100
            java.lang.String r3 = "pay_send"
            if (r1 != r2) goto L_0x0191
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "/bank/pay-send"
            r1.sendGTMOpenScreenWithDeviceInfo(r9, r2, r3)
            goto L_0x019a
        L_0x0191:
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "/wallet/pay-send"
            r1.sendGTMOpenScreenWithDeviceInfo(r9, r2, r3)
        L_0x019a:
            java.io.Serializable r0 = r10.getSerializableExtra(r0)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            if (r0 == 0) goto L_0x01eb
            java.lang.String r1 = r0.getURLType()
            java.lang.String r2 = r0.getDeeplink()
            android.net.Uri r2 = android.net.Uri.parse(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x01ce
            java.lang.String r3 = "scan_pay"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x01ce
            java.lang.String r1 = r0.getP2pmobilenumber()
            r9.f70524i = r0
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x01eb
            net.one97.paytm.wallet.newdesign.fastscan.a.a r0 = net.one97.paytm.wallet.newdesign.fastscan.a.a.f70919c
            r0.a(r1, r7)
            goto L_0x01eb
        L_0x01ce:
            java.lang.String r0 = r2.toString()
            boolean r0 = net.one97.paytm.wallet.utility.a.q((java.lang.String) r0)
            if (r0 == 0) goto L_0x01eb
            java.lang.String r0 = r2.getPath()
            java.lang.String r0 = r0.substring(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x01eb
            net.one97.paytm.wallet.newdesign.fastscan.a.a r1 = net.one97.paytm.wallet.newdesign.fastscan.a.a.f70919c
            r1.a(r0, r7)
        L_0x01eb:
            boolean r0 = r10.hasExtra(r6)
            if (r0 == 0) goto L_0x0205
            net.one97.paytm.f.b r0 = net.one97.paytm.f.b.a()
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r0 = r0.f50402a
            java.lang.String r1 = "active"
            r0.setScanType(r1)
            net.one97.paytm.wallet.newdesign.fastscan.a.a r0 = net.one97.paytm.wallet.newdesign.fastscan.a.a.f70919c
            java.lang.String r10 = r10.getStringExtra(r6)
            r0.a(r10, r7)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.a(android.content.Intent):void");
    }

    private void i() {
        Intent intent = new Intent(this, net.one97.paytm.wallet.communicator.b.a().getMainActivityClass());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "scan");
        startActivity(intent);
        finish();
    }

    private void d(String str) {
        if (!com.paytm.utility.b.r((Context) this)) {
            Intent intent = new Intent(this, PaySendInfoActivity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("mobile", str);
            }
            CJRHomePageItem cJRHomePageItem = this.f70524i;
            if (cJRHomePageItem != null) {
                intent.putExtra("extra_home_data", cJRHomePageItem);
            }
            intent.putExtra("dest", "p2p_screen");
            startActivity(intent);
            finish();
            return;
        }
        Intent intent2 = new Intent(this, P2PActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent2.putExtra("mobile", str);
        }
        CJRHomePageItem cJRHomePageItem2 = this.f70524i;
        if (cJRHomePageItem2 != null) {
            intent2.putExtra("extra_home_data", cJRHomePageItem2);
        }
        startActivityForResult(intent2, 3113);
    }

    private void a(boolean z2, boolean z3) {
        try {
            if (!com.paytm.utility.b.r((Context) this)) {
                Intent intent = new Intent(this, PaySendInfoActivity.class);
                if (this.f70524i != null) {
                    intent.putExtra("extra_home_data", this.f70524i);
                }
                if (!TextUtils.isEmpty(this.f70524i.getP2pmobilenumber())) {
                    intent.putExtra("dest", "p2p_screen");
                    startActivity(intent);
                    finish();
                    return;
                }
                return;
            }
            Intent intent2 = new Intent(this, P2PActivity.class);
            if (this.f70524i != null) {
                intent2.putExtra("extra_home_data", this.f70524i);
            }
            intent2.putExtra("isFromDeeplink", z2);
            intent2.putExtra("isFromScan", z3);
            if (!TextUtils.isEmpty(this.f70524i.getP2pmobilenumber())) {
                startActivity(intent2);
                finish();
            }
        } catch (Exception unused) {
        }
    }

    private void j() {
        if (!com.paytm.utility.b.r((Context) this)) {
            Intent intent = new Intent(this, PaySendInfoActivity.class);
            intent.putExtra("dest", "show_code");
            startActivity(intent);
            finish();
            return;
        }
        startActivity(new Intent(this, ShowCodeActivity.class));
    }

    private void k() {
        try {
            if (!isFinishing()) {
                final com.paytm.utility.h hVar = new com.paytm.utility.h(this);
                hVar.setTitle(getResources().getString(R.string.no_connection));
                hVar.a(getResources().getString(R.string.no_internet));
                hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.cancel();
                    }
                });
                hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        PaySendActivityV2.this.c();
                    }
                });
                hVar.setCancelable(true);
                hVar.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.contact_icon_iv) {
            try {
                c(false);
                net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
                a2.j = a.e.CONATCT_SCREEN;
                a2.l = a.C1450a.CONTACT_ICON_CLICKED;
                a2.k = a.b.WAlLET_SEND_MONEY;
                a2.b((Context) this);
                net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
                net.one97.paytm.wallet.a.a.a("offline_payments", "scan_screen_contacts_clicked", "flow_through_pay_icon", getApplicationContext(), "home/pay-send/select-contacts", "offline_payments");
            } catch (Exception unused) {
            }
        } else if (id == R.id.remove_all_tv) {
            net.one97.paytm.wallet.p2p.a aVar2 = this.l;
            if (aVar2 != null) {
                aVar2.a();
            }
            net.one97.paytm.wallet.p2p.a aVar3 = this.k;
            if (aVar3 != null) {
                aVar3.a();
            }
            RecentDataNetworkManager.clearRecentData(this);
            RecentDataNetworkManager.uploadRecentPaymentsData(this);
            this.w.setVisibility(8);
            a(true, 0);
        } else if (id != R.id.add_money_tv) {
        } else {
            if (!com.paytm.utility.b.c((Context) this)) {
                k();
            } else if (com.paytm.utility.b.r((Context) this)) {
                net.one97.paytm.wallet.a.a aVar4 = net.one97.paytm.wallet.a.a.f69839a;
                String str = this.o ? "flow_through_scan_icon" : "flow_through_pay_icon";
                Context a3 = net.one97.paytm.wallet.a.a.a();
                k.a((Object) a3, "getContext()");
                net.one97.paytm.wallet.a.a.a("offline_payments", "scan_add_money_clicked", str, a3, "home/pay-send/add_money");
                net.one97.paytm.wallet.communicator.b.a().openAddMoneyScreen(this);
            } else {
                net.one97.paytm.wallet.communicator.b.a().callLoginActivity(this);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.Q = false;
        if (i2 == j) {
            this.C = true;
        }
        if (i2 == 128 && this.R) {
            this.T.b();
        }
        if (i2 == 301 && com.paytm.utility.b.r((Context) this)) {
            l();
        }
        if (i2 == 3112) {
            c();
        }
        if (i3 == -1) {
            if (i2 == 3112) {
                if (intent == null) {
                    q.b("No data found in while gallery selection");
                    return;
                }
                net.one97.paytm.wallet.newdesign.fastscan.a.b bVar = net.one97.paytm.wallet.newdesign.fastscan.a.b.f70926g;
                boolean z2 = this.o;
                boolean z3 = this.p;
                boolean z4 = this.B;
                AnonymousClass3 r3 = new b.a() {
                    public final void a() {
                        Fragment c2 = PaySendActivityV2.this.getSupportFragmentManager().c(PaySendActivityV2.f70521f);
                        if (c2 instanceof net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) {
                            ((net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) c2).j();
                        }
                    }

                    public final void b() {
                        net.one97.paytm.wallet.newdesign.fastscan.a.c cVar;
                        LottieAnimationView k;
                        Fragment c2 = PaySendActivityV2.this.getSupportFragmentManager().c(PaySendActivityV2.f70521f);
                        if (c2 instanceof net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) {
                            net.one97.paytm.wallet.newdesign.fastscan.FastScan.a aVar = (net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) c2;
                            if (!(aVar.getView() == null || (k = aVar.k()) == null)) {
                                net.one97.paytm.wallet.newdesign.fastscan.a.a(k);
                            }
                            net.one97.paytm.wallet.newdesign.fastscan.FastScan.b bVar = aVar.f70915i;
                            if (bVar != null && (cVar = bVar.f70898a) != null) {
                                cVar.f70938h = c.a.SCANNED;
                            }
                        }
                    }

                    public final void a(String str) {
                        Toast.makeText(PaySendActivityV2.this, str, 1).show();
                        PaySendActivityV2.this.c();
                    }
                };
                k.c(intent, "data");
                k.c(r3, "galleryFlowListener");
                net.one97.paytm.wallet.newdesign.fastscan.a.b.f70920a = z2;
                net.one97.paytm.wallet.newdesign.fastscan.a.b.f70921b = z3;
                net.one97.paytm.wallet.newdesign.fastscan.a.b.f70922c = z4;
                net.one97.paytm.wallet.newdesign.fastscan.a.b.f70924e = r3;
                Uri data = intent.getData();
                if (intent.hasExtra(CJRQRScanResultModel.KEY_QR_CODE_ID)) {
                    net.one97.paytm.f.b a2 = net.one97.paytm.f.b.a();
                    k.a((Object) a2, "RiskInformationController.getInstance()");
                    RiskExtendedInfo riskExtendedInfo = a2.f50402a;
                    k.a((Object) riskExtendedInfo, "RiskInformationControlle…stance().riskExtendedInfo");
                    riskExtendedInfo.setScanType("active");
                    String stringExtra = intent.getStringExtra(CJRQRScanResultModel.KEY_QR_CODE_ID);
                    k.a((Object) stringExtra, "intent.getStringExtra(CJRConstants.QR_CODE_ID)");
                    net.one97.paytm.wallet.newdesign.fastscan.a.b.a(stringExtra, net.one97.paytm.wallet.newdesign.fastscan.a.b.f70920a);
                    return;
                }
                if (data == null) {
                    try {
                        Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.STREAM");
                        if (parcelableExtra != null) {
                            data = (Uri) parcelableExtra;
                        } else {
                            throw new u("null cannot be cast to non-null type android.net.Uri");
                        }
                    } catch (Exception e2) {
                        b.a aVar = net.one97.paytm.wallet.newdesign.fastscan.a.b.f70924e;
                        if (aVar == null) {
                            k.a("galleryFlowListener");
                        }
                        aVar.a(net.one97.paytm.wallet.newdesign.fastscan.a.b.a(e2.getMessage()));
                        return;
                    }
                }
                Context context = net.one97.paytm.wallet.newdesign.fastscan.a.b.f70925f;
                k.a((Object) context, "mContext");
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), data);
                if (net.one97.paytm.wallet.newdesign.fastscan.a.b.f70921b) {
                    Context context2 = net.one97.paytm.wallet.newdesign.fastscan.a.b.f70925f;
                    k.a((Object) context2, "mContext");
                    com.google.android.gms.vision.a.e a3 = new e.a(context2.getApplicationContext()).a();
                    k.a((Object) a3, "TextRecognizer.Builder(m…plicationContext).build()");
                    net.one97.paytm.wallet.newdesign.fastscan.a.b.f70923d = a3;
                    if (!a3.f12539a.b() || bitmap == null) {
                        throw new Exception("incorrectData");
                    }
                    net.one97.paytm.wallet.newdesign.fastscan.a.b.a(bitmap);
                    return;
                }
                net.one97.paytm.wallet.newdesign.fastscan.b bVar2 = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
                net.one97.paytm.wallet.newdesign.fastscan.b.a(false);
                b.a aVar2 = net.one97.paytm.wallet.newdesign.fastscan.a.b.f70924e;
                if (aVar2 == null) {
                    k.a("galleryFlowListener");
                }
                aVar2.b();
                net.one97.paytm.fastscanner.b.d dVar = net.one97.paytm.fastscanner.b.d.f50426a;
                net.one97.paytm.fastscanner.b.d.a(intent);
                net.one97.paytm.wallet.newdesign.fastscan.b bVar3 = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
                new Handler().postDelayed(b.C1435b.f70929a, net.one97.paytm.wallet.newdesign.fastscan.b.c());
            } else if (i2 == 3113) {
                finish();
            } else if (i2 == 3010) {
                if (intent != null) {
                    setResult(-1, intent);
                    finish();
                }
            } else if (i2 == 3) {
                if (this.O) {
                    l();
                }
                ArrayList<IJRDataModel> arrayList = this.x;
                if (arrayList != null && arrayList.size() > 0) {
                    this.w.setVisibility(0);
                }
                Bundle extras = intent.getExtras();
                String string = extras.getString("qrCodeId", "");
                if (!TextUtils.isEmpty(string) && !isFinishing()) {
                    b(true, string, extras.getBoolean("shouldInvokeRecentFlow"));
                }
            } else if (i2 == E) {
                if (intent != null && intent.hasExtra("p2m")) {
                    a((RecentScan) intent.getSerializableExtra("p2m"));
                }
            } else if (i2 == 4) {
            } else {
                if (i2 == 352 || i2 == 144 || i2 == 304) {
                    d dVar2 = this.T;
                    Future<?> runOnBgThread = AppExecutor.getExecutor().runOnBgThread(new d.h(dVar2));
                    net.one97.paytm.base.f fVar = dVar2.f49511a;
                    k.a((Object) runOnBgThread, "f");
                    fVar.a(runOnBgThread);
                    this.M.setVisibility(8);
                }
            }
        } else if (i2 == 1802) {
            at.b a4 = at.a();
            a4.f69664a = null;
            a4.f69665b = null;
            a4.f69666c = null;
            if (a4.f69668e != null) {
                a4.f69668e.clear();
            }
            a4.f69667d = false;
            this.A = false;
        }
    }

    private void l() {
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.G.setVisibility(8);
        this.T.a();
        this.T.b();
    }

    public void onReLogin(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("callSingleAPI")) {
            ArrayList<IJRDataModel> arrayList = this.x;
            if (arrayList != null && arrayList.size() > 0) {
                this.w.setVisibility(0);
            }
            if (bundle != null) {
                String string = bundle.getString("qrCodeId", "");
                if (!TextUtils.isEmpty(string) && !isFinishing()) {
                    b(true, string, bundle.getBoolean("shouldInvokeRecentFlow"));
                }
            }
        }
    }

    public final void aH_() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        try {
            startActivityForResult(Intent.createChooser(intent, "Select Paytm QR Code"), 3112);
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    private void a(String str, Bundle bundle) {
        if (this.f70523h == null) {
            this.f70523h = new HashMap<>();
        }
        this.f70523h.put(str, bundle);
    }

    public void onDestroy() {
        net.one97.paytm.p2mNewDesign.models.b.c();
        net.one97.paytm.p2mNewDesign.models.b.h();
        long currentTimeMillis = System.currentTimeMillis() - this.D;
        net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
        net.one97.paytm.wallet.a.a.a(false, "", (Long) 0L, currentTimeMillis, 0, (String) null);
        HashMap<String, Bundle> hashMap = this.f70523h;
        if (hashMap != null) {
            hashMap.clear();
            this.f70523h = null;
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().q();
        net.one97.paytm.b.a.e.a();
        net.one97.paytm.b.a.e.b();
        net.one97.paytm.wallet.newdesign.fastscan.a aVar2 = this.t;
        if (aVar2 != null && !aVar2.isRemoving()) {
            this.t.onDestroy();
        }
        super.onDestroy();
    }

    private void a(RecentScan recentScan) {
        if (recentScan.getScanResult() == null || !com.paytm.utility.b.p(recentScan.getScanResult())) {
            try {
                JSONObject jSONObject = new JSONObject(recentScan.getScanResult());
                jSONObject.remove("ORDER_ID");
                if (!com.paytm.utility.b.r((Context) this)) {
                    Intent intent = new Intent(this, PaySendInfoActivity.class);
                    intent.putExtra("dest", "qr_send_money");
                    intent.putExtra("qr_scan_result", jSONObject.toString());
                    startActivity(intent);
                    finish();
                    return;
                }
                String uniqKey = recentScan.getUniqKey();
                e(jSONObject.toString());
                if (!TextUtils.isEmpty(uniqKey) && uniqKey.length() == 24) {
                    net.one97.paytm.b.a.e.a();
                    if (net.one97.paytm.b.a.e.f()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Content-Type", "application/json");
                        hashMap.put("ssotoken", com.paytm.utility.a.q(this));
                        net.one97.paytm.b.a.e.a().a(this, (String) null, uniqKey, hashMap);
                        return;
                    }
                    net.one97.paytm.wallet.utility.a.d((Context) this, uniqKey);
                }
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        } else if (com.paytm.utility.b.r((Context) this)) {
            g(recentScan.getScanResult());
        } else {
            Intent intent2 = new Intent(this, PaySendInfoActivity.class);
            intent2.putExtra("dest", UpiConstants.WALLET_TYPE_MONEY_TRANSFER);
            intent2.putExtra("qr_scan_result", recentScan.getScanResult());
            startActivity(intent2);
            finish();
        }
    }

    private void e(String str) {
        CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
        try {
            cJRQRScanResultModel.parseData(new JSONObject(str), (Context) this);
        } catch (JSONException e2) {
            q.d(String.valueOf(e2));
        }
        if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(cJRQRScanResultModel.getRequestType())) {
            Intent intent = new Intent();
            intent.putExtra("NAME", cJRQRScanResultModel.getName());
            intent.putExtra("PHONE_NUMBER", cJRQRScanResultModel.getMobileNo());
            intent.putExtra("MODE", "RECENT_SCAN");
            net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
            a2.f71392d = a.c.QR_SCAN_PAYTM_P2P;
            a2.f71394f = H5AppHandler.CHECK_VALUE;
            net.one97.paytm.wallet.utility.a.a(intent, (Activity) this);
            finish();
            return;
        }
        Intent intent2 = new Intent(this, AJRQRActivity.class);
        intent2.putExtra("OPERATION", "scan");
        intent2.putExtra("scan_result", str);
        intent2.putExtra("QR_CODE_ID", cJRQRScanResultModel.getQrCodeId());
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        intent2.putExtra("qrScanTime", sb.toString());
        intent2.putExtra("is_from_recent", true);
        startActivityForResult(intent2, 1802);
    }

    public final void a(String str) {
        if (this.q) {
            Intent intent = new Intent();
            intent.putExtra("BarCodeResult", str);
            setResult(-1, intent);
            finish();
            return;
        }
        n.bs = true;
        if (!com.paytm.utility.b.p(str)) {
            net.one97.paytm.p2mNewDesign.models.b.c().b("Others");
            if (net.one97.paytm.wallet.utility.a.m(str)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(UpiConstants.IS_GALLERY_SCAN, n());
                bundle.putBoolean("isFromScan", true);
                if (!net.one97.paytm.wallet.communicator.b.a().handleDeepLink(this, str, bundle)) {
                    a(str, (String) null, (String) null, "");
                }
            } else if (com.paytm.utility.b.r(str)) {
                a(net.one97.paytm.wallet.communicator.b.a().getSchema() + "://embed?url=" + str, (String) null, (String) null, "");
            } else if (!com.paytm.utility.b.n(str) || net.one97.paytm.wallet.utility.a.t(str)) {
                if (com.paytm.utility.b.k(str)) {
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace(com.paytm.utility.b.l(str), "market://"))));
                    } catch (ActivityNotFoundException unused) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                } else if (com.paytm.utility.b.m(str)) {
                    try {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    } catch (ActivityNotFoundException unused2) {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace("market://", "https://play.google.com/store/apps/"))));
                    }
                } else if (com.paytm.utility.b.q(str)) {
                    m();
                    try {
                        net.one97.paytm.wallet.communicator.b.a().isValidBharatQRCode(this, str, n(), at.a().f69664a, this.o, at.a().a("Tscan"), 123);
                    } catch (Exception e2) {
                        q.d(String.valueOf(e2));
                        h(str);
                    }
                } else if (f(str) != null) {
                } else {
                    if (net.one97.paytm.wallet.communicator.b.a().a(this, str)) {
                        net.one97.paytm.wallet.communicator.b.a().handleDeepLink(this, str, (Bundle) null);
                        return;
                    }
                    m();
                    h(str);
                }
            } else if (str.contains("edcpos")) {
                net.one97.paytm.wallet.communicator.b.a().openEDCReceiptActivity(this, str);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                intent2.addFlags(67108864);
                intent2.addFlags(268435456);
                if (intent2.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent2);
                }
            }
        } else if (net.one97.paytm.wallet.utility.a.v(str)) {
            net.one97.paytm.p2mNewDesign.models.b.c();
            net.one97.paytm.p2mNewDesign.models.b.f56925c = false;
            Intent intent3 = new Intent(this, AJRQRActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("p2mUPIDeeplink", str);
            intent3.putExtras(bundle2);
            startActivity(intent3);
        } else {
            net.one97.paytm.f.b.a().f50402a.setRequestType("QR 3rd party");
            g(str);
            m();
        }
    }

    private void m() {
        Fragment c2 = getSupportFragmentManager().c(f70521f);
        if (c2 instanceof net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) {
            ((net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) c2).r();
        }
    }

    private String f(String str) {
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource inputSource = new InputSource();
            String str2 = "pc";
            inputSource.setCharacterStream(new StringReader(str));
            NamedNodeMap attributes = newDocumentBuilder.parse(inputSource).getElementsByTagName("PrintLetterBarcodeData").item(0).getAttributes();
            ScanAadhaarCardModel scanAadhaarCardModel = new ScanAadhaarCardModel();
            if (TextUtils.isEmpty(attributes.getNamedItem("name").getNodeValue()) || TextUtils.isEmpty(attributes.getNamedItem("uid").getNodeValue())) {
                return null;
            } else if (TextUtils.isEmpty(attributes.getNamedItem("gender").getNodeValue())) {
                return null;
            } else {
                scanAadhaarCardModel.setName(attributes.getNamedItem("name").getNodeValue());
                scanAadhaarCardModel.setUid(attributes.getNamedItem("uid").getNodeValue());
                scanAadhaarCardModel.setGender(attributes.getNamedItem("gender").getNodeValue());
                if (attributes.getNamedItem("dob") != null) {
                    try {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("dob").getNodeValue())) {
                            scanAadhaarCardModel.setDob(attributes.getNamedItem("dob").getNodeValue());
                        }
                    } catch (Exception unused) {
                        return null;
                    }
                }
                try {
                    if (attributes.getNamedItem("yob") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("yob").getNodeValue())) {
                            scanAadhaarCardModel.setYob(attributes.getNamedItem("yob").getNodeValue());
                        }
                    }
                    String str3 = "";
                    if (attributes.getNamedItem("co") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("co").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("co").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("house") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("house").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("house").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("street") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("street").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("street").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("loc") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("loc").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("loc").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("lm") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("lm").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("lm").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("vtc") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("vtc").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("vtc").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("po") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("po").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("po").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("dist") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("dist").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("dist").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("subdist") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("subdist").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("subdist").getNodeValue();
                        }
                    }
                    if (attributes.getNamedItem("state") != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem("state").getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem("state").getNodeValue();
                        }
                    }
                    String str4 = str2;
                    if (attributes.getNamedItem(str4) != null) {
                        if (!TextUtils.isEmpty(attributes.getNamedItem(str4).getNodeValue())) {
                            str3 = str3 + " " + attributes.getNamedItem(str4).getNodeValue();
                        }
                    }
                    scanAadhaarCardModel.setAddress(str3);
                } catch (Exception unused2) {
                    return null;
                }
                try {
                    Intent intent = new Intent(this, ScanAadhaarCardActivity.class);
                    intent.putExtra("model", scanAadhaarCardModel);
                    startActivity(intent);
                    return "XML";
                } catch (Exception unused3) {
                    return null;
                }
            }
        } catch (Exception unused4) {
            return null;
        }
    }

    private void g(String str) {
        j.a().a(this, str, str, 4, 8);
        if (!net.one97.paytm.wallet.communicator.b.a().handleUPIDeepLink(this, str, n(), at.a().f69664a, this.o, at.a().a("Tscan"))) {
            o();
        } else {
            net.one97.paytm.p2mNewDesign.models.b.c().b("UPI");
        }
    }

    private boolean n() {
        Fragment c2 = getSupportFragmentManager().c(f70521f);
        if (c2 instanceof net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) {
            return ((net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) c2).o;
        }
        return false;
    }

    private void o() {
        com.paytm.utility.h hVar = new com.paytm.utility.h(this);
        hVar.setTitle("utility_hide_title");
        hVar.a(getString(R.string.upi_qr_message));
        hVar.setCancelable(true);
        hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                com.paytm.utility.h.this.cancel();
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                PaySendActivityV2.this.f(dialogInterface);
            }
        });
        hVar.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(DialogInterface dialogInterface) {
        c();
    }

    private void h(String str) {
        String str2;
        boolean z2;
        String str3;
        String[] split = str.split(" ");
        if (split.length == 1) {
            if (com.paytm.utility.b.s(str)) {
                if (net.one97.paytm.wallet.utility.a.a(str, (Context) this) || a((Context) this)) {
                    a(str, (CJRExtendedInfoData) null);
                    return;
                } else {
                    i(str);
                    return;
                }
            } else if (com.paytm.utility.b.t(str)) {
                if (str.contains("http://")) {
                    str3 = str.replaceFirst(".*(?=http://)", "");
                } else if (str.contains("https://")) {
                    str3 = str.replaceFirst(".*(?=https://)", "");
                } else {
                    str3 = "http://".concat(String.valueOf(str));
                }
                if (!a((Context) this)) {
                    i(str3);
                    return;
                } else {
                    a(str3, (CJRExtendedInfoData) null);
                    return;
                }
            }
        }
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = null;
                break;
            }
            str2 = split[i2];
            if (com.paytm.utility.b.s(str2)) {
                break;
            } else if (com.paytm.utility.b.t(str2)) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        z2 = false;
        com.paytm.utility.h hVar = new com.paytm.utility.h(this);
        hVar.setTitle("utility_hide_title");
        if (str2 != null) {
            hVar.a(Html.fromHtml(str.substring(0, str.indexOf(str2)) + "<font color='#00b9f5'><b>" + str2 + "</b></font>" + str.substring(str.indexOf(str2) + str2.length(), str.length())));
            if (z2) {
                str2 = "http://".concat(String.valueOf(str2));
            }
            hVar.setCancelable(true);
            hVar.a(-1, getResources().getString(R.string.go_to), new View.OnClickListener(str2, hVar) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ com.paytm.utility.h f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    PaySendActivityV2.this.b(this.f$1, this.f$2, view);
                }
            });
        } else {
            hVar.a(str);
            hVar.setCancelable(true);
            hVar.a(-1, getResources().getString(R.string.copy), new View.OnClickListener(str, hVar) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ com.paytm.utility.h f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    PaySendActivityV2.this.a(this.f$1, this.f$2, view);
                }
            });
        }
        hVar.a(-2, getResources().getString(R.string.close), new View.OnClickListener(hVar) {
            private final /* synthetic */ com.paytm.utility.h f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PaySendActivityV2.this.c(this.f$1, view);
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                PaySendActivityV2.this.e(dialogInterface);
            }
        });
        if (!isFinishing() && !hVar.isShowing()) {
            try {
                hVar.show();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str, com.paytm.utility.h hVar, View view) {
        a(str, (CJRExtendedInfoData) null);
        b(true);
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, com.paytm.utility.h hVar, View view) {
        net.one97.paytm.wallet.utility.a.b((Context) this, str);
        b(true);
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(com.paytm.utility.h hVar, View view) {
        b(false);
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(DialogInterface dialogInterface) {
        c();
    }

    private void i(String str) {
        com.paytm.utility.h hVar = new com.paytm.utility.h(this, (byte) 0);
        hVar.setTitle("utility_hide_title");
        hVar.a(String.format(getString(R.string.on_time_confirmation), new Object[]{str}));
        hVar.setCancelable(true);
        hVar.b(getString(R.string.on_time_confirmation_checkbox));
        hVar.a(-1, getResources().getString(R.string.on_time_confirmation_button), new View.OnClickListener(hVar, str) {
            private final /* synthetic */ com.paytm.utility.h f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                PaySendActivityV2.this.a(this.f$1, this.f$2, view);
            }
        });
        hVar.a(-2, getResources().getString(R.string.on_time_confirmation_cancel), new View.OnClickListener(hVar) {
            private final /* synthetic */ com.paytm.utility.h f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PaySendActivityV2.this.b(this.f$1, view);
            }
        });
        hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                PaySendActivityV2.this.d(dialogInterface);
            }
        });
        hVar.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(com.paytm.utility.h hVar, View view) {
        b(false);
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(DialogInterface dialogInterface) {
        c();
    }

    private static boolean a(Context context) {
        return be.a(context.getApplicationContext()).b("OneTimeDialogCheckedForExternalQR", false, true);
    }

    public final void c() {
        Fragment c2 = getSupportFragmentManager().c(f70521f);
        if (c2 instanceof net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) {
            ((net.one97.paytm.wallet.newdesign.fastscan.FastScan.a) c2).q();
        }
    }

    private void b(boolean z2) {
        try {
            HashMap hashMap = new HashMap();
            if (this.o) {
                hashMap.put("scan_source_screen_type", "scan_icon");
            } else {
                hashMap.put("scan_source_screen_type", "pay_icon");
            }
            if (z2) {
                hashMap.put("scan_popup_action", H5Param.MENU_COPY);
            } else {
                hashMap.put("scan_popup_action", "close");
            }
            hashMap.put("scan_qr_code_type", CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, "scan_qr_popup_action", hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(String str, CJRExtendedInfoData cJRExtendedInfoData) {
        if (!net.one97.paytm.wallet.utility.a.m(str) && com.paytm.utility.b.s(str)) {
            if (!str.contains("p-y.tm") || net.one97.paytm.wallet.utility.a.t(str)) {
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception unused) {
                }
            } else {
                Intent intent = new Intent(this, AJRScanWebView.class);
                intent.putExtra("KEY_IS_SHARE_VISIBLE", true);
                intent.putExtra("url", str);
                startActivity(intent);
                return;
            }
        }
        if (cJRExtendedInfoData != null) {
            a(str, cJRExtendedInfoData.getQrCodeId(), cJRExtendedInfoData.getmQrCodeTimestamp(), cJRExtendedInfoData.getmQRCodeRefrenceOrderID());
        }
    }

    public final void b(String str) {
        if (com.paytm.utility.b.r((Context) this)) {
            WebLoginAlertDialog webLoginAlertDialog = new WebLoginAlertDialog(this);
            webLoginAlertDialog.setCancelable(true);
            webLoginAlertDialog.setButton(-1, getResources().getString(R.string.proceed), new View.OnClickListener(webLoginAlertDialog, str) {
                private final /* synthetic */ WebLoginAlertDialog f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    PaySendActivityV2.this.a(this.f$1, this.f$2, view);
                }
            });
            webLoginAlertDialog.setButton(-2, getResources().getString(R.string.cancel), new View.OnClickListener() {
                public final void onClick(View view) {
                    WebLoginAlertDialog.this.cancel();
                }
            });
            webLoginAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    PaySendActivityV2.this.b(dialogInterface);
                }
            });
            webLoginAlertDialog.show();
            return;
        }
        net.one97.paytm.wallet.communicator.b.a().callLoginActivity(this);
    }

    public final void c(String str) {
        d(net.one97.paytm.wallet.utility.a.i(str));
    }

    public final void a(r rVar) {
        String str;
        new af();
        com.google.zxing.client.a.d d2 = af.d(rVar);
        if (d2.f40031a == null || d2.f40031a.length <= 0) {
            str = "";
        } else {
            str = d2.f40031a[0];
        }
        AnonymousClass4 r2 = new g(this, d2) {
        };
        try {
            String c2 = r2.c();
            com.paytm.utility.h hVar = new com.paytm.utility.h(this);
            hVar.setTitle("utility_hide_title");
            hVar.a(String.format(getString(R.string.v_card_received), new Object[]{str}));
            hVar.setCancelable(true);
            if (!TextUtils.isEmpty(c2) && com.paytm.utility.b.b(c2)) {
                hVar.a(-1, getResources().getString(R.string.send_money), new View.OnClickListener(r2, hVar) {
                    private final /* synthetic */ g f$1;
                    private final /* synthetic */ com.paytm.utility.h f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        PaySendActivityV2.this.a(this.f$1, this.f$2, view);
                    }
                });
            }
            hVar.a(-2, getResources().getString(R.string.button_add_contact), new View.OnClickListener(d2, r2, hVar) {
                private final /* synthetic */ com.google.zxing.client.a.d f$1;
                private final /* synthetic */ g f$2;
                private final /* synthetic */ com.paytm.utility.h f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    PaySendActivityV2.this.a(this.f$1, this.f$2, this.f$3, view);
                }
            });
            hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    PaySendActivityV2.this.c(dialogInterface);
                }
            });
            hVar.show();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, com.paytm.utility.h hVar, View view) {
        d(gVar.c());
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface) {
        c();
    }

    public final void a(String str, String str2) {
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this, "shouldShowProfileQrActivity", false)) {
            Intent intent = new Intent(this, AJRProfileQRDisplayActivity.class);
            intent.putExtra("name", str);
            intent.putExtra("mobile", str2);
            intent.putExtra(UpiConstants.IS_GALLERY_SCAN, n());
            intent.putExtra(UpiConstants.IS_MID_SCAN, this.o);
            startActivity(intent);
            finish();
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("NAME", str);
        intent2.putExtra("PHONE_NUMBER", str2);
        intent2.putExtra("MODE", "QR_CODE");
        intent2.putExtra(UpiConstants.IS_GALLERY_SCAN, n());
        intent2.putExtra(UpiConstants.IS_MID_SCAN, this.o);
        net.one97.paytm.wallet.newdesign.universalp2p.c.a.a().f71392d = a.c.QR_SCAN_PAYTM_PROFILE;
        net.one97.paytm.wallet.utility.a.a(intent2, (Activity) this);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(WebLoginAlertDialog webLoginAlertDialog, String str, View view) {
        webLoginAlertDialog.cancel();
        if (com.paytm.utility.b.c((Context) this)) {
            String q2 = com.paytm.utility.a.q(this);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            if (!TextUtils.isEmpty(q2)) {
                String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "web_login");
                p();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("session_token", q2);
                hashMap2.put("Authorization", com.paytm.utility.b.m());
                hashMap2.put("Content-Type", "application/json");
                String e2 = com.paytm.utility.b.e((Context) this, stringFromGTM);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", str);
                } catch (JSONException e3) {
                    q.d(String.valueOf(e3));
                }
                new net.one97.paytm.network.b(e2, new WebLogin(), hashMap, hashMap2, jSONObject.toString()).c().observeForever(new z(jSONObject) {
                    private final /* synthetic */ JSONObject f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onChanged(Object obj) {
                        PaySendActivityV2.this.a(this.f$1, (f) obj);
                    }
                });
                p();
                return;
            }
            net.one97.paytm.wallet.communicator.b.a().showSessionTimeoutAlert(this);
            return;
        }
        k();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        c();
    }

    private void p() {
        try {
            if (this.s == null) {
                this.s = net.one97.paytm.wallet.utility.a.b((Activity) this);
            }
            if (this.s != null && !this.s.isShowing()) {
                this.s.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private void q() {
        try {
            if (this.s != null && this.s.isShowing()) {
                this.s.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106 A[SYNTHETIC, Splitter:B:36:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014a A[Catch:{ Exception -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0157 A[Catch:{ Exception -> 0x02ce }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            r21 = this;
            r9 = r21
            r0 = r23
            r7 = r24
            r5 = r25
            boolean r1 = com.paytm.utility.b.u((java.lang.String) r22)     // Catch:{ Exception -> 0x02ce }
            if (r1 != 0) goto L_0x0047
            java.lang.String r1 = com.paytm.utility.b.N((java.lang.String) r22)     // Catch:{ Exception -> 0x02ce }
            r2 = r22
            boolean r3 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x02ce }
            if (r3 == 0) goto L_0x0045
            java.lang.String r0 = net.one97.paytm.wallet.utility.a.f(r21, r22)     // Catch:{ Exception -> 0x02ce }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02ce }
            if (r1 != 0) goto L_0x003d
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x02ce }
            java.lang.String r2 = "android.intent.action.VIEW"
            java.lang.String r3 = "market://details?id="
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ Exception -> 0x02ce }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x02ce }
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r1)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x003d:
            android.content.Intent r0 = net.one97.paytm.wallet.utility.a.k((java.lang.String) r22)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x0045:
            r6 = r1
            goto L_0x004a
        L_0x0047:
            r2 = r22
            r6 = r2
        L_0x004a:
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r1.getDeeplinkDataItem(r9, r6)     // Catch:{ Exception -> 0x02ce }
            boolean r1 = com.paytm.utility.k.b()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r2 = "affiliateID"
            java.lang.String r4 = "timestamp"
            java.lang.String r8 = "deeplink"
            java.lang.String r10 = "amusement"
            java.lang.String r12 = "qrcode_order_id"
            java.lang.String r14 = "qrcode_id"
            java.lang.String r15 = "events"
            java.lang.String r11 = "activate_pdc"
            java.lang.String r13 = "deeplinking"
            r16 = r2
            java.lang.String r2 = "origin"
            r17 = r4
            java.lang.String r4 = "extra_home_data"
            if (r1 == 0) goto L_0x00fa
            if (r3 == 0) goto L_0x00f9
            java.lang.String r1 = r3.getPushFeatureType()     // Catch:{ Exception -> 0x02ce }
            boolean r1 = r11.equals(r1)     // Catch:{ Exception -> 0x02ce }
            if (r1 == 0) goto L_0x00f9
            boolean r1 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x02ce }
            if (r1 == 0) goto L_0x0085
            return
        L_0x0085:
            r3.setPdcQrCodeId(r0)     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r7 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            android.content.Intent r1 = r1.getIntent(r7, r9, r3)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r7 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            if (r7 == 0) goto L_0x00b8
            java.lang.String r7 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            boolean r7 = r7.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x02ce }
            if (r7 != 0) goto L_0x00ae
            java.lang.String r7 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            boolean r7 = r7.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x02ce }
            if (r7 == 0) goto L_0x00b8
        L_0x00ae:
            r7 = 67108864(0x4000000, float:1.5046328E-36)
            r1.addFlags(r7)     // Catch:{ Exception -> 0x02ce }
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r7)     // Catch:{ Exception -> 0x02ce }
        L_0x00b8:
            if (r1 == 0) goto L_0x00fa
            r1.putExtra(r4, r3)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r2, r13)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r14, r0)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r12, r5)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r8, r6)     // Catch:{ Exception -> 0x02ce }
            r7 = r24
            r18 = r8
            r8 = 1
            r20 = r17
            r17 = r6
            r6 = r20
            r1.putExtra(r6, r7)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r19 = r3.getURL()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = j(r19)     // Catch:{ Exception -> 0x02ce }
            r19 = r6
            r6 = r16
            r1.putExtra(r6, r8)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "source"
            r16 = r6
            java.lang.String r6 = "qrcode"
            r1.putExtra(r8, r6)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r6 = "is_deep_linking_data"
            r8 = 1
            r1.putExtra(r6, r8)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r1)     // Catch:{ Exception -> 0x02ce }
            goto L_0x0102
        L_0x00f9:
            return
        L_0x00fa:
            r7 = r24
            r18 = r8
            r19 = r17
            r17 = r6
        L_0x0102:
            java.lang.String r1 = ""
            if (r3 == 0) goto L_0x0132
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "external"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x0132
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            r0.sendDeeplinkOpen(r1, r3, r9)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r0 = r3.getURL()     // Catch:{ Exception -> 0x02ce }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02ce }
            if (r0 == 0) goto L_0x0124
            goto L_0x012a
        L_0x0124:
            java.lang.String r6 = r3.getURL()     // Catch:{ Exception -> 0x02ce }
            r17 = r6
        L_0x012a:
            android.content.Intent r0 = net.one97.paytm.wallet.utility.a.k((java.lang.String) r17)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x0132:
            if (r3 == 0) goto L_0x0157
            java.lang.String r6 = r3.getDeeplink()     // Catch:{ Exception -> 0x02ce }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02ce }
            if (r6 != 0) goto L_0x0157
            java.lang.String r6 = "branchShare"
            java.lang.String r8 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x0157
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r1 = r3.getDeeplink()     // Catch:{ Exception -> 0x02ce }
            r2 = 1
            r0.shareBranchLink(r9, r2, r1)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x0157:
            if (r3 == 0) goto L_0x0173
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "joinprime"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x0173
            boolean r6 = com.paytm.utility.b.r((android.content.Context) r21)     // Catch:{ Exception -> 0x02ce }
            if (r6 != 0) goto L_0x0173
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            r0.handlePrimeIntent(r9, r3)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x0173:
            if (r3 == 0) goto L_0x01bb
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "fillnbuyins"
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x01bb
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x02ce }
            r0.<init>()     // Catch:{ Exception -> 0x02ce }
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.Class r2 = r2.getShopInsLandingActivityClass()     // Catch:{ Exception -> 0x02ce }
            r1.<init>(r9, r2)     // Catch:{ Exception -> 0x02ce }
            r0.setComponent(r1)     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r2 = r3.getDeeplink()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r3 = r3.getDeeplink()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r4 = "insurance_type"
            int r3 = r3.indexOf(r4)     // Catch:{ Exception -> 0x02ce }
            int r3 = r3 + 14
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r2 = r2.substring(r3)     // Catch:{ Exception -> 0x02ce }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x02ce }
            r1.setInsuranceType(r2)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x01bb:
            if (r3 == 0) goto L_0x01e2
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "healthins"
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x01e2
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x02ce }
            r0.<init>()     // Catch:{ Exception -> 0x02ce }
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.Class r2 = r2.getHealthInsPreQuoteActivityClass()     // Catch:{ Exception -> 0x02ce }
            r1.<init>(r9, r2)     // Catch:{ Exception -> 0x02ce }
            r0.setComponent(r1)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x01e2:
            if (r3 == 0) goto L_0x0225
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "twowheelerins"
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 != 0) goto L_0x01fc
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = "fourwheelerins"
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x0225
        L_0x01fc:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x02ce }
            r0.<init>()     // Catch:{ Exception -> 0x02ce }
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.wallet.communicator.c r5 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.Class r5 = r5.getCarInfoActivityClass()     // Catch:{ Exception -> 0x02ce }
            r1.<init>(r9, r5)     // Catch:{ Exception -> 0x02ce }
            r0.setComponent(r1)     // Catch:{ Exception -> 0x02ce }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ Exception -> 0x02ce }
            r1.<init>()     // Catch:{ Exception -> 0x02ce }
            r1.putSerializable(r4, r3)     // Catch:{ Exception -> 0x02ce }
            r0.putExtra(r2, r13)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r2 = "resultant activity_bundle"
            r0.putExtra(r2, r1)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x0225:
            if (r3 == 0) goto L_0x0273
            java.lang.String r6 = r3.getPushFeatureType()     // Catch:{ Exception -> 0x02ce }
            boolean r6 = r11.equals(r6)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x023b
            boolean r6 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x0238
            return
        L_0x0238:
            r3.setPdcQrCodeId(r0)     // Catch:{ Exception -> 0x02ce }
        L_0x023b:
            net.one97.paytm.wallet.communicator.c r6 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            r6.sendDeeplinkOpen(r1, r3, r9)     // Catch:{ Exception -> 0x02ce }
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            android.content.Intent r1 = r1.getIntent(r6, r9, r3)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x027c
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            boolean r6 = r6.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x02ce }
            if (r6 != 0) goto L_0x0268
            java.lang.String r6 = r3.getURLType()     // Catch:{ Exception -> 0x02ce }
            boolean r6 = r6.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x02ce }
            if (r6 == 0) goto L_0x027c
        L_0x0268:
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            r1.addFlags(r6)     // Catch:{ Exception -> 0x02ce }
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r6)     // Catch:{ Exception -> 0x02ce }
            goto L_0x027c
        L_0x0273:
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            r6 = 0
            android.content.Intent r1 = r1.getIntent(r6, r9, r3)     // Catch:{ Exception -> 0x02ce }
        L_0x027c:
            if (r1 == 0) goto L_0x02b4
            r1.putExtra(r4, r3)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r2, r13)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r14, r0)     // Catch:{ Exception -> 0x02ce }
            r1.putExtra(r12, r5)     // Catch:{ Exception -> 0x02ce }
            r6 = r17
            r0 = r18
            r1.putExtra(r0, r6)     // Catch:{ Exception -> 0x02ce }
            r0 = r19
            r1.putExtra(r0, r7)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r0 = r3.getURL()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r0 = j(r0)     // Catch:{ Exception -> 0x02ce }
            r2 = r16
            r1.putExtra(r2, r0)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r0 = "source"
            java.lang.String r2 = "qrcode"
            r1.putExtra(r0, r2)     // Catch:{ Exception -> 0x02ce }
            java.lang.String r0 = "is_deep_linking_data"
            r2 = 1
            r1.putExtra(r0, r2)     // Catch:{ Exception -> 0x02ce }
            r9.startActivity(r1)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x02b4:
            r6 = r17
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r2 = r3.getURL()     // Catch:{ Exception -> 0x02ce }
            java.lang.String r8 = j(r2)     // Catch:{ Exception -> 0x02ce }
            r2 = r21
            r4 = r23
            r5 = r25
            r7 = r24
            r1.handleDeeplinkByMall(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x02ce }
            return
        L_0x02ce:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static String j(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str).getQueryParameter("AffiliateID");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        c();
    }

    public void onBackPressed() {
        if (!this.o && !this.z) {
            ArrayList<IJRDataModel> arrayList = this.x;
            if (arrayList != null && arrayList.size() > 0) {
                this.w.setVisibility(0);
            }
            r();
        } else if (this.P) {
            this.t.m();
            net.one97.paytm.wallet.utility.a.a(getWindow());
        } else {
            super.onBackPressed();
            overridePendingTransition(0, R.anim.fade_out);
        }
    }

    public final void d() {
        final View findViewById = findViewById(R.id.parent_main);
        if (Build.VERSION.SDK_INT >= 21) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth() / 2, findViewById.getBottom() - net.one97.paytm.wallet.utility.a.a(70, (Context) this), (float) Math.max(findViewById.getWidth(), findViewById.getHeight()), 48.0f);
            createCircularReveal.addListener(new Animator.AnimatorListener() {
                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    findViewById.setVisibility(4);
                    PaySendActivityV2.this.finish();
                }
            });
            createCircularReveal.setDuration(450);
            createCircularReveal.start();
            return;
        }
        super.onBackPressed();
    }

    private void a(boolean z2, int i2) {
        if (z2) {
            findViewById(R.id.lyt_remove_recent).setVisibility(8);
            findViewById(R.id.drawable_linear).setVisibility(0);
            return;
        }
        findViewById(R.id.lyt_remove_recent).setVisibility(0);
        findViewById(R.id.drawable_linear).setVisibility(8);
        this.T.a(i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRDataModel iJRDataModel) {
        net.one97.paytm.wallet.p2p.a aVar = this.k;
        if (i2 < aVar.getItemCount()) {
            aVar.f71546d.remove(i2);
            aVar.notifyItemRemoved(i2);
            aVar.notifyItemRangeChanged(i2, aVar.f71546d.size());
        }
        boolean z2 = iJRDataModel instanceof RecentScan;
        if (z2) {
            j.a();
            ArrayList<IJRDataModel> b2 = j.b(this);
            if (b2 == null) {
                b2 = new ArrayList<>(10);
                j.a(iJRDataModel, (Context) this);
                b2.add(0, iJRDataModel);
            } else {
                Iterator<IJRDataModel> it2 = b2.iterator();
                while (it2.hasNext()) {
                    IJRDataModel next = it2.next();
                    if ((next instanceof RecentScan) && z2 && ((RecentScan) next).getUniqKey().equalsIgnoreCase(((RecentScan) iJRDataModel).getUniqKey())) {
                        it2.remove();
                    }
                }
            }
            DelegateUtil.INSTANCE.writeObjectToFile(this, b2, "recents_data");
        } else if (iJRDataModel instanceof RecentSendMoney) {
            net.one97.paytm.wallet.d.k.a();
            net.one97.paytm.wallet.d.k.a(iJRDataModel, this);
        }
        RecentDataNetworkManager.uploadRecentPaymentsData(this);
    }

    private static boolean k(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    private void b(boolean z2, String str, boolean z3) {
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.f70879a;
        this.t = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.a(this.o, this.r, this.p, this.P, str, Boolean.valueOf(z3), Boolean.valueOf(z2));
        s();
        this.T.d();
    }

    private void r() {
        try {
            this.z = true;
            findViewById(R.id.p2p_scan_frag_container_ll).setVisibility(0);
            if (this.t == null) {
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.f70879a;
                this.t = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.a(this.o, this.r, this.p, this.P);
            }
            if (this.t != null) {
                getSupportFragmentManager().a().a(R.id.p2p_scan_frag_container_ll, this.t, f70521f).c();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        c(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean c(View view) {
        c(true);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(true, 0);
    }

    private void s() {
        try {
            this.z = true;
            findViewById(R.id.scan_only_frag_container_ll).setVisibility(0);
            getSupportFragmentManager().a().a(R.id.scan_only_frag_container_ll, this.t, f70521f).c();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        if (Build.VERSION.SDK_INT >= 23 && androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") != 0) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 201);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 201) {
            if (s.a(iArr)) {
                net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
                net.one97.paytm.wallet.a.a.a("app_permissions", "app_permissions_provided", "contacts=true", (Context) this, "pay/send screen", "app_permission");
            } else {
                net.one97.paytm.wallet.a.a aVar2 = net.one97.paytm.wallet.a.a.f69839a;
                net.one97.paytm.wallet.a.a.a("app_permissions", "app_permissions_provided", "contacts=false", (Context) this, "pay/send screen", "app_permission");
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onPause() {
        super.onPause();
        this.S = true;
    }

    public final void e() {
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.f70879a;
        this.t = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.a(this.o, this.r, this.p, this.P);
        try {
            this.z = true;
            findViewById(R.id.scan_only_frag_container_ll).setVisibility(0);
            if (this.t != null) {
                getSupportFragmentManager().a().a(R.id.scan_only_frag_container_ll, this.t, f70521f).c();
            } else {
                net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a aVar2 = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.f70879a;
                this.t = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.a(this.o, this.r, this.p, this.P);
                getSupportFragmentManager().a().a(R.id.scan_only_frag_container_ll, this.t, f70521f).c();
            }
        } catch (Exception unused) {
        }
        this.T.d();
    }

    private void c(boolean z2) {
        net.one97.paytm.p2mNewDesign.models.b.c().b("Search");
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this, "mt_revamp_enabled", true)) {
            net.one97.paytm.contacts.utils.e eVar = net.one97.paytm.contacts.utils.e.f50261a;
            Intent a2 = net.one97.paytm.contacts.utils.e.a((Context) this, e.c.SCANNER.getType());
            a2.putExtra(CJRQRScanResultModel.KEY_QR_CODE_ID, this.f70522g);
            startActivityForResult(a2, E);
            overridePendingTransition(R.anim.wallet_bottom_up, R.anim.do_not_move);
            return;
        }
        Intent intent = new Intent(this, LocalContactsActivity.class);
        intent.putExtra(CJRQRScanResultModel.KEY_QR_CODE_ID, this.f70522g);
        intent.putExtra("showKeyboardOnStart", z2);
        startActivity(intent);
    }

    public final void a(boolean z2) {
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.f70879a;
        this.t = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.a(z2, this.r, this.p, this.P);
        r();
        this.T.d();
    }

    public final void a(boolean z2, String str, boolean z3) {
        net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a aVar = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.f70879a;
        this.t = net.one97.paytm.wallet.newdesign.fastscan.FastScan.a.a.a(this.o, this.r, this.p, this.P, str, Boolean.valueOf(z3), Boolean.valueOf(z2));
        r();
        this.T.d();
    }

    public final CJRHomePageItem f() {
        return this.f70524i;
    }

    public final void g() {
        this.f70524i = null;
    }

    private void u() {
        this.T.f70428d = true;
        this.I.setImageDrawable(getResources().getDrawable(R.drawable.link_bank_ac));
        this.H.setText(R.string.scanner_add_bank);
        this.H.setTextColor(getResources().getColor(R.color.color_00aced));
        this.H.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaySendActivityV2.this.a(view);
            }
        });
        this.K.setVisibility(8);
        this.K.b();
        this.M.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (!com.paytm.utility.b.c((Context) this)) {
            k();
        } else if (!com.paytm.utility.b.r((Context) this)) {
            net.one97.paytm.wallet.communicator.b.a().callLoginActivity(this);
        } else if (this.T.f70426b) {
            w();
        } else if (this.T.f70427c) {
            startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(this), 352);
        } else {
            w();
        }
    }

    private void v() {
        u();
        this.F.setText(String.format(getString(R.string.scanner_paytm_balance), new Object[]{"--"}));
        this.J.setVisibility(8);
        this.J.b();
        this.N.setVisibility(0);
        this.L.setVisibility(0);
        this.G.setVisibility(0);
    }

    public final void h() {
        net.one97.paytm.wallet.p2p.a aVar = this.k;
        if (aVar != null) {
            aVar.f71548f = true;
            aVar.notifyDataSetChanged();
        }
    }

    private void w() {
        Intent intent = new Intent(this, UpiSelectBankActivity.class);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
        intent.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
        intent.addFlags(536870912);
        startActivityForResult(intent, 352);
        net.one97.paytm.wallet.a.a aVar = net.one97.paytm.wallet.a.a.f69839a;
        String str = this.o ? "flow_through_scan_icon" : "flow_through_pay_icon";
        Context a2 = net.one97.paytm.wallet.a.a.a();
        k.a((Object) a2, "getContext()");
        net.one97.paytm.wallet.a.a.a("offline_payments", "scan_link_bank_account", str, a2, "home/pay-send/post-scan");
    }

    public void onWindowFocusChanged(boolean z2) {
        net.one97.paytm.wallet.newdesign.fastscan.a aVar;
        super.onWindowFocusChanged(z2);
        if (z2 && this.Q && (aVar = this.t) != null) {
            aVar.l();
        }
        this.Q = true;
    }

    public final void a(IJRDataModel iJRDataModel, a.c cVar) {
        y<f> c2;
        IJRDataModel iJRDataModel2 = iJRDataModel;
        a.c cVar2 = cVar;
        net.one97.paytm.p2mNewDesign.models.b.c().b("Recents");
        net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
        a2.f71397i = "horizontal";
        a2.j = a.e.CONATCT_SCREEN;
        a2.l = a.C1450a.CONTACT_SORTED;
        a2.k = a.b.WAlLET_SEND_MONEY;
        a2.b((Context) this);
        if (iJRDataModel2 == null) {
            return;
        }
        if (iJRDataModel2 instanceof RecentSendMoney) {
            this.w.setClickable(false);
            RecentSendMoney recentSendMoney = (RecentSendMoney) iJRDataModel2;
            String a3 = net.one97.paytm.wallet.utility.a.a(recentSendMoney.getPhoneNumber());
            if (a3.length() > 10) {
                a3 = net.one97.paytm.wallet.utility.a.a((Activity) this, a3);
            }
            String str = a3;
            if (k(str)) {
                this.y = "RECENT_NUMBER";
                net.one97.paytm.f.b.a().f50402a.setScanType("none");
                net.one97.paytm.f.b.a().f50402a.setMode("contact");
                if (!net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this, "mt_revamp_enabled", true)) {
                    String name = recentSendMoney.getName();
                    String modeOfPayment = recentSendMoney.getModeOfPayment();
                    Intent intent = new Intent();
                    intent.putExtra("PHONE_NUMBER", str);
                    intent.putExtra("NAME", name);
                    intent.putExtra("MODE", this.y);
                    intent.putExtra("MODE_OF_PAYMENT", modeOfPayment);
                    net.one97.paytm.wallet.utility.a.a(intent, (Activity) this);
                } else if (com.paytm.utility.b.c((Context) this)) {
                    net.one97.paytm.wallet.utility.a.a aVar = net.one97.paytm.wallet.utility.a.a.f72261c;
                    if (net.one97.paytm.wallet.utility.a.a.c() != null) {
                        net.one97.paytm.wallet.utility.a.a aVar2 = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.wallet.utility.a.a.c().b();
                        net.one97.paytm.wallet.utility.a.a aVar3 = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.wallet.utility.a.a.d();
                    }
                    net.one97.paytm.wallet.utility.a.a aVar4 = net.one97.paytm.wallet.utility.a.a.f72261c;
                    String str2 = this.y;
                    String name2 = recentSendMoney.getName();
                    k.c(this, "activity");
                    k.c(str, "payeePhoneNo");
                    k.c(str2, "mode");
                    net.one97.paytm.wallet.utility.a.a.f72259a = str2;
                    x.e eVar = new x.e();
                    eVar.element = new y();
                    Context context = this;
                    if (com.paytm.utility.b.r(context)) {
                        Map hashMap = new HashMap();
                        String simpleName = aVar4.getClass().getSimpleName();
                        k.a((Object) simpleName, "this.javaClass.simpleName");
                        hashMap.put("screen_name", simpleName);
                        net.one97.paytm.wallet.newdesign.universalp2p.a aVar5 = new net.one97.paytm.wallet.newdesign.universalp2p.a(context);
                        String b2 = aVar5.b(a.C1448a.CONSOLIDATE_PAYMENT_INST, new Object[0]);
                        k.a((Object) b2, "universalP2PRequestCompo…CONSOLIDATE_PAYMENT_INST)");
                        String a4 = p.a(b2, "v2", "v3", false);
                        Map<String, String> a5 = aVar5.a(a.C1448a.CONSOLIDATE_PAYMENT_INST, str);
                        k.a((Object) a5, "universalP2PRequestCompo…YMENT_INST, payeePhoneNo)");
                        net.one97.paytm.network.a aVar6 = new net.one97.paytm.network.a(a4, new PaymentCombinationAPIResponse((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (kotlin.g.b.g) null), hashMap, a5);
                        net.one97.paytm.wallet.utility.a.a.f72260b = aVar6;
                        aVar6.e();
                        net.one97.paytm.network.a aVar7 = net.one97.paytm.wallet.utility.a.a.f72260b;
                        if (aVar7 != null) {
                            aVar7.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "payment_combination_api_timeout")));
                        }
                        net.one97.paytm.network.a aVar8 = net.one97.paytm.wallet.utility.a.a.f72260b;
                        if (!(aVar8 == null || (c2 = aVar8.c()) == null)) {
                            c2.observe(this, new a.C1464a(name2, cVar, this, str, eVar, str2));
                        }
                    } else {
                        net.one97.paytm.wallet.utility.a.a.a(this);
                        f.a aVar9 = f.f55795d;
                        ((y) eVar.element).postValue(f.a.b());
                    }
                    ((y) eVar.element).observeForever(new z(cVar2, recentSendMoney, str) {
                        private final /* synthetic */ a.c f$1;
                        private final /* synthetic */ RecentSendMoney f$2;
                        private final /* synthetic */ String f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void onChanged(Object obj) {
                            PaySendActivityV2.this.a(this.f$1, this.f$2, this.f$3, (f) obj);
                        }
                    });
                } else {
                    Toast.makeText(this, getString(R.string.no_internet), 0).show();
                    if (cVar2 != null) {
                        cVar.stopProgress();
                    }
                }
            }
            a2.f71392d = a.c.MOBILE_NUMBER_ENTERED;
            a2.f71394f = H5AppHandler.CHECK_VALUE;
        } else if (iJRDataModel2 instanceof RecentScan) {
            net.one97.paytm.f.b.a().f50402a.setMode("recentBeneficiary");
            a((RecentScan) iJRDataModel2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_category", "scan_qr_code");
            hashMap2.put("event_action", "recent_scan_item_clicked");
            hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
            hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "wallet/pay-send");
            hashMap2.put("VERTICAL_NAME", "wallet");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a.c cVar, RecentSendMoney recentSendMoney, String str, f fVar) {
        f fVar2 = fVar;
        this.w.setClickable(true);
        if (cVar != null) {
            cVar.stopProgress();
        }
        if (fVar2.f55796a == h.SUCCESS) {
            if (fVar2.f55797b != null && (fVar2.f55797b instanceof PaymentCombinationAPIResponse)) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) fVar2.f55797b;
                if (paymentCombinationAPIResponse.getCategory() != null && paymentCombinationAPIResponse.getCategory().equalsIgnoreCase("P2P")) {
                    net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
                    net.one97.paytm.wallet.utility.d.a(this, paymentCombinationAPIResponse, (String) null, (String) null, e.C0905e.PAY.getType(), false, this.o, true, false, false);
                }
            }
        } else if (fVar2.f55796a == h.ERROR && fVar2.f55798c != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            ae aeVar = ae.f69602a;
            if (ae.a(fVar2.f55798c.f55799a)) {
                ae aeVar2 = ae.f69602a;
                ae.a(this, fVar2.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                this.O = true;
                return;
            }
            net.one97.paytm.wallet.utility.d dVar2 = net.one97.paytm.wallet.utility.d.f72319a;
            net.one97.paytm.wallet.utility.d.a(this, (String) null, (String) null, com.paytm.utility.b.j((Context) this), com.paytm.utility.b.l((Context) this), recentSendMoney.getName(), str, true, (ExtraData) null, true, false, false);
        }
    }

    public final void a(int i2) {
        ((Vibrator) getSystemService("vibrator")).vibrate(100);
        a(false, i2);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            if (menuItem.getItemId() == R.id.action_add_money) {
                hashMap.put("new_wallet_pay_options_tab_name", "add_money");
            } else if (menuItem.getItemId() == R.id.action_show_code) {
                hashMap.put("new_wallet_pay_options_tab_name", "show_code");
            } else if (menuItem.getItemId() == R.id.action_open_gallery) {
                hashMap.put("new_wallet_pay_options_tab_name", "gallery");
            } else if (menuItem.getItemId() == R.id.action_pay_via_merchant_id) {
                hashMap.put("new_wallet_pay_options_tab_name", "pay_via_merchant_id");
            }
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, "new_wallet_pay_options_tab_clicked", hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
        if (menuItem.getItemId() == R.id.action_add_money) {
            net.one97.paytm.wallet.communicator.b.a().onAddMoneyIntent(this, (CJRHomePageItem) null);
            finish();
        } else if (menuItem.getItemId() == R.id.action_show_code) {
            j();
        } else if (menuItem.getItemId() == R.id.action_open_gallery) {
            aH_();
        } else if (menuItem.getItemId() == R.id.action_pay_via_merchant_id) {
            Intent intent = new Intent(this, P2PActivity.class);
            intent.putExtra("is_p2m", true);
            startActivityForResult(intent, 3114);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(JSONObject jSONObject, f fVar) {
        long j2;
        f fVar2 = fVar;
        if (fVar2.f55796a == h.SUCCESS) {
            q();
            if (fVar2.f55797b instanceof WebLogin) {
                WebLogin webLogin = (WebLogin) fVar2.f55797b;
                if (!"SUCCESS".equalsIgnoreCase(webLogin.getStatus()) || !WebLogin.RESPONSE_CODE_SUCCESS.equalsIgnoreCase(webLogin.getResponseCode())) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("screen_name", f70521f);
                    hashMap.put("flowName", "Offline_Payments");
                    net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
                    String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "web_login");
                    String jSONObject2 = jSONObject.toString();
                    String responseCode = webLogin.getResponseCode();
                    if (fVar2.f55797b.getNetworkResponse() == null) {
                        j2 = 0;
                    } else {
                        j2 = fVar2.f55797b.getNetworkResponse().networkTimeMs;
                    }
                    a2.pushHawkeyeEvent(this, 200, stringFromGTM, jSONObject2, responseCode, j2, a.b.USER_FACING, hashMap, a.c.PAY);
                    String string = getString(R.string.error);
                    String format = String.format(getString(R.string.some_went_wrong_web_login), new Object[]{webLogin.getResponseCode()});
                    com.paytm.utility.h hVar = new com.paytm.utility.h(this);
                    hVar.setTitle(string);
                    hVar.a(format);
                    hVar.setCancelable(true);
                    hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                        public final void onClick(View view) {
                            com.paytm.utility.h.this.dismiss();
                        }
                    });
                    hVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            PaySendActivityV2.this.a(dialogInterface);
                        }
                    });
                    if (!isFinishing()) {
                        hVar.show();
                        return;
                    }
                    return;
                }
                Toast.makeText(this, "Login successfull", 0).show();
                finish();
            }
        } else if (fVar2.f55796a == h.ERROR) {
            q();
            net.one97.paytm.network.g gVar = fVar2.f55798c;
            if (gVar != null && !isFinishing()) {
                if (gVar.f55799a == 410 || gVar.f55799a == 401 || gVar.f55799a == 403) {
                    net.one97.paytm.wallet.communicator.b.a().handleError(this, gVar.f55801c, (String) null, (Bundle) null, false);
                } else if (gVar.f55801c.getMessage() != null && !net.one97.paytm.wallet.communicator.b.a().checkErrorCode(this, gVar.f55801c)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getResources().getString(R.string.network_error_message));
                    sb.append(" ");
                    sb.append(gVar.f55801c.getUrl());
                    if (gVar.f55801c.getMessage() == null || !gVar.f55801c.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + gVar.f55801c.getUrl());
                        return;
                    }
                    String url = gVar.f55801c.getUrl();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(gVar.f55799a);
                    com.paytm.utility.b.d((Context) this, url, sb2.toString());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.google.zxing.client.a.d dVar, g gVar, com.paytm.utility.h hVar, View view) {
        g gVar2;
        int a2;
        int a3;
        int i2;
        com.google.zxing.client.a.d dVar2 = dVar;
        g gVar3 = gVar;
        String[] strArr = dVar2.j;
        String str = (strArr == null || strArr.length <= 0) ? null : strArr[0];
        String[] strArr2 = dVar2.k;
        String str2 = (strArr2 == null || strArr2.length <= 0) ? null : strArr2[0];
        String[] strArr3 = dVar2.f40031a;
        String[] strArr4 = dVar2.f40032b;
        String str3 = dVar2.f40033c;
        String[] strArr5 = dVar2.f40034d;
        String[] strArr6 = dVar2.f40035e;
        String[] strArr7 = dVar2.f40036f;
        String[] strArr8 = dVar2.f40037g;
        String str4 = dVar2.f40039i;
        String str5 = dVar2.f40038h;
        String str6 = dVar2.l;
        String str7 = dVar2.n;
        String[] strArr9 = dVar2.o;
        String str8 = dVar2.m;
        String[] strArr10 = dVar2.p;
        String str9 = str7;
        String str10 = str6;
        String str11 = str2;
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/contact");
        g.a(intent, "name", strArr3 != null ? strArr3[0] : null);
        g.a(intent, "phonetic_name", str3);
        int min = Math.min(strArr5 != null ? strArr5.length : 0, com.google.zxing.client.android.d.f40189a.length);
        int i3 = 0;
        while (i3 < min) {
            g.a(intent, com.google.zxing.client.android.d.f40189a[i3], strArr5[i3]);
            if (strArr6 == null || i3 >= strArr6.length) {
                i2 = min;
            } else {
                i2 = min;
                int a4 = g.a(strArr6[i3], g.f40175b, g.f40178e);
                if (a4 >= 0) {
                    intent.putExtra(com.google.zxing.client.android.d.f40190b[i3], a4);
                }
            }
            i3++;
            min = i2;
        }
        int min2 = Math.min(strArr7 != null ? strArr7.length : 0, com.google.zxing.client.android.d.f40191c.length);
        for (int i4 = 0; i4 < min2; i4++) {
            g.a(intent, com.google.zxing.client.android.d.f40191c[i4], strArr7[i4]);
            if (strArr8 != null && i4 < strArr8.length && (a3 = g.a(strArr8[i4], g.f40174a, g.f40177d)) >= 0) {
                intent.putExtra(com.google.zxing.client.android.d.f40192d[i4], a3);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (strArr9 != null) {
            int length = strArr9.length;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    String str12 = strArr9[i5];
                    if (str12 != null && !str12.isEmpty()) {
                        ContentValues contentValues = new ContentValues(2);
                        contentValues.put("mimetype", "vnd.android.cursor.item/website");
                        contentValues.put("data1", str12);
                        arrayList.add(contentValues);
                        break;
                    }
                    i5++;
                } else {
                    break;
                }
            }
        }
        if (str8 != null) {
            ContentValues contentValues2 = new ContentValues(3);
            contentValues2.put("mimetype", "vnd.android.cursor.item/contact_event");
            contentValues2.put("data2", 3);
            contentValues2.put("data1", str8);
            arrayList.add(contentValues2);
        }
        if (strArr4 != null) {
            int length2 = strArr4.length;
            int i6 = 0;
            while (true) {
                if (i6 < length2) {
                    String str13 = strArr4[i6];
                    if (str13 != null && !str13.isEmpty()) {
                        ContentValues contentValues3 = new ContentValues(3);
                        contentValues3.put("mimetype", "vnd.android.cursor.item/nickname");
                        contentValues3.put("data2", 1);
                        contentValues3.put("data1", str13);
                        arrayList.add(contentValues3);
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            intent.putParcelableArrayListExtra("data", arrayList);
        }
        StringBuilder sb = new StringBuilder();
        if (str4 != null) {
            sb.append(10);
            sb.append(str4);
        }
        if (strArr10 != null) {
            sb.append(10);
            sb.append(strArr10[0]);
            sb.append(',');
            sb.append(strArr10[1]);
        }
        if (sb.length() > 0) {
            g.a(intent, "notes", sb.substring(1));
        }
        g.a(intent, "im_handle", str5);
        g.a(intent, "postal", str);
        if (str11 != null && (a2 = g.a(str11, g.f40176c, g.f40179f)) >= 0) {
            intent.putExtra("postal_type", a2);
        }
        g.a(intent, "company", str10);
        g.a(intent, "job_title", str9);
        try {
            intent.addFlags(524288);
            StringBuilder sb2 = new StringBuilder("Launching intent: ");
            sb2.append(intent);
            sb2.append(" with extras: ");
            sb2.append(intent.getExtras());
            gVar2 = gVar;
            try {
                gVar2.f40182h.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
            }
        } catch (ActivityNotFoundException unused2) {
            gVar2 = gVar;
            AlertDialog.Builder builder = new AlertDialog.Builder(gVar2.f40182h);
            builder.setTitle(com.google.zxing.client.android.R.string.app_name);
            builder.setMessage(com.google.zxing.client.android.R.string.msg_intent_failed);
            builder.setPositiveButton(com.google.zxing.client.android.R.string.button_ok, (DialogInterface.OnClickListener) null);
            builder.show();
            hVar.cancel();
        }
        hVar.cancel();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.paytm.utility.h hVar, String str, View view) {
        if (hVar.f43821a.isChecked()) {
            be.a(getApplicationContext()).a("OneTimeDialogCheckedForExternalQR", true, true);
        }
        a(str, (CJRExtendedInfoData) null);
        b(true);
        hVar.cancel();
    }
}
