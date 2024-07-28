package net.one97.paytm.wallet.p2p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.QuickPayModeEnum;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.at;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;

public class P2PLandingPageActivity extends P2PAppCompatActivity implements View.OnClickListener {
    private boolean A;
    private boolean B;
    private LottieAnimationView C;
    private RelativeLayout D;
    private RelativeLayout E;
    private Button F;
    private String G;
    private String H;
    private String I;
    private LottieAnimationView J;
    private AppCompatImageView K;
    private AppCompatImageView L;
    private View M;
    private TextView N;
    private ImageView O;
    private ImageView P;
    private boolean Q = true;
    private Button R;
    /* access modifiers changed from: private */
    public ChatPaymentIntegrationResponseModel S;

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f71493a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f71494b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f71495c;

    /* renamed from: e  reason: collision with root package name */
    private TextView f71496e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f71497f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f71498g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f71499h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f71500i;
    private TextView j;
    private TextView k;
    private TextView l;
    private CircularImageView m;
    private AppCompatImageView n;
    private TableRow o;
    private TableRow p;
    private TableRow q;
    private TableRow r;
    private TableRow s;
    private String t;
    /* access modifiers changed from: private */
    public String u = "";
    /* access modifiers changed from: private */
    public String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onCreate(Bundle bundle) {
        ThemeData a2;
        Bundle bundle2 = bundle;
        super.onCreate(bundle);
        if (bundle2 != null && bundle2.containsKey("shouldPlaySound")) {
            this.Q = bundle2.getBoolean("shouldPlaySound");
        }
        com.paytm.utility.b.c((Activity) this);
        setContentView(R.layout.activity_p2p_landing_v2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.D = (RelativeLayout) findViewById(R.id.share_rl);
        this.D.setOnClickListener(this);
        this.f71494b = (TextView) findViewById(R.id.p2p_header_tv);
        this.C = (LottieAnimationView) findViewById(R.id.p2p_success_status_lav);
        this.n = (AppCompatImageView) findViewById(R.id.p2p_status_holder_iv);
        this.m = (CircularImageView) findViewById(R.id.p2p_profile_iv);
        this.f71495c = (TextView) findViewById(R.id.p2p_amount_tv);
        this.f71496e = (TextView) findViewById(R.id.p2p_name_tv);
        this.f71497f = (TextView) findViewById(R.id.p2p_mobile_tv);
        this.f71498g = (TextView) findViewById(R.id.p2p_message_tv);
        this.f71499h = (TextView) findViewById(R.id.p2p_date_tv);
        this.f71500i = (TextView) findViewById(R.id.p2p_transaction_tv);
        this.j = (TextView) findViewById(R.id.p2p_chat_message_tv);
        this.k = (TextView) findViewById(R.id.p2p_benificiary_tv);
        this.o = (TableRow) findViewById(R.id.p2p_chat_tr);
        this.o.setOnClickListener(this);
        this.p = (TableRow) findViewById(R.id.p2p_payment_tr);
        this.p.setOnClickListener(this);
        this.q = (TableRow) findViewById(R.id.p2p_beneficiary_tr);
        this.l = (TextView) findViewById(R.id.p2p_payment_shop);
        this.q.setOnClickListener(this);
        this.J = (LottieAnimationView) findViewById(R.id.theme_animation);
        this.K = (AppCompatImageView) findViewById(R.id.motif_iv);
        this.L = (AppCompatImageView) findViewById(R.id.paytm_logo);
        this.M = findViewById(R.id.viewBelowAnimation);
        this.N = (TextView) findViewById(R.id.p2p_share_iv);
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "font/share_android.ttf");
        this.N.setText("S");
        this.N.setTypeface(createFromAsset);
        this.O = (ImageView) findViewById(R.id.iv_cross_background);
        this.P = (ImageView) findViewById(R.id.iv_cross_icon);
        findViewById(R.id.lyt_cross).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(P2PLandingPageActivity.this, b.a().getMainActivityClass());
                intent.addFlags(67108864);
                P2PLandingPageActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.floating_nav).setOnClickListener((View.OnClickListener) null);
        this.s = (TableRow) findViewById(R.id.link_bank_account_tr);
        if (getIntent().hasExtra("uni_p2p_user_primary_vpa")) {
            this.G = getIntent().getStringExtra("uni_p2p_user_primary_vpa");
        }
        if (getIntent().hasExtra("uni_p2p_landing_intent_extra_timestamp")) {
            this.H = getIntent().getStringExtra("uni_p2p_landing_intent_extra_timestamp");
        }
        if (!TextUtils.isEmpty(this.G) || !g.a((net.one97.paytm.upi.h.a) null).e()) {
            this.s.setOnClickListener(this);
        } else {
            this.s.setVisibility(8);
        }
        this.F = (Button) findViewById(R.id.p2p_complete_kyc);
        this.E = (RelativeLayout) findViewById(R.id.rlyReferLayout);
        this.r = (TableRow) findViewById(R.id.p2p_view_passbook_tr);
        this.r.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.R = (Button) findViewById(R.id.back_to_home_bt);
        String e2 = com.paytm.utility.b.e((Context) this, b.a().getStringFromGTM(this, "p2pNavbarSFUrl"));
        net.one97.paytm.widget.g gVar = net.one97.paytm.widget.g.f72427a;
        net.one97.paytm.widget.g.a(e2, (FragmentActivity) this, (net.one97.paytm.widget.b) new net.one97.paytm.widget.b() {
            public final void onReceivedWidget(IStaticWidget iStaticWidget) {
                P2PLandingPageActivity.this.a(iStaticWidget);
            }
        });
        this.R.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                P2PLandingPageActivity.this.a(view);
            }
        });
        String stringFromGTM = b.a().getStringFromGTM(this, "walletAdSlotP2PApiURL");
        if (TextUtils.isEmpty(stringFromGTM)) {
            stringFromGTM = "https://storefront.paytm.com/v2/h/scan-pay-post-txn-page-p2p";
        }
        Fragment sfBannerFragment = b.a().getSfBannerFragment(this, findViewById(R.id.ad_fragment_container), stringFromGTM, a.c.WALLET);
        q a3 = getSupportFragmentManager().a();
        a3.b(R.id.ad_fragment_container, sfBannerFragment, (String) null);
        a3.c();
        String stringExtra = getIntent().getStringExtra("uni_p2p_landing_intent_extra_success");
        if (getIntent().hasExtra("uni_p2p_landing_intent_extra_theme")) {
            this.I = getIntent().getStringExtra("uni_p2p_landing_intent_extra_theme");
        }
        if ("SUCCESS".equalsIgnoreCase(stringExtra)) {
            this.z = getIntent().getStringExtra("uni_p2p_landing_intent_extra_success");
            this.A = true;
            if (this.Q) {
                this.f71493a = MediaPlayer.create(this, R.raw.payment_success);
                this.Q = false;
                MediaPlayer mediaPlayer = this.f71493a;
                if (mediaPlayer != null) {
                    if (!mediaPlayer.isPlaying()) {
                        this.f71493a.start();
                    }
                    this.f71493a.setOnCompletionListener($$Lambda$E7FaxYylohOwFmBzAjza06XyF8.INSTANCE);
                }
            }
        }
        if (this.A) {
            net.one97.paytm.wallet.newdesign.universalp2p.c.a a4 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
            a4.f71389a = a.e.WALLET_PAY_SUMMARY;
            a4.f71391c = a.C1450a.SUCCESSFUL_TRANS;
            a4.f71395g = this.I;
            a4.a((Context) this);
            this.p.setVisibility(8);
            findViewById(R.id.another_payment_view).setVisibility(8);
            a(stringExtra);
        } else {
            this.p.setVisibility(0);
            findViewById(R.id.another_payment_view).setVisibility(0);
            a(stringExtra);
        }
        if (getIntent().hasExtra("uni_p2p_landing_intent_extra_name")) {
            this.u = getIntent().getStringExtra("uni_p2p_landing_intent_extra_name");
        }
        try {
            if (getIntent().hasExtra("UNI_P2P_LANDING_INTENT_EXTRA_ERROR_CODE")) {
                if ("RWL_3005".equalsIgnoreCase(getIntent().getStringExtra("UNI_P2P_LANDING_INTENT_EXTRA_ERROR_CODE"))) {
                    this.F.setVisibility(0);
                } else {
                    this.F.setVisibility(8);
                }
            }
        } catch (Exception unused) {
        }
        this.v = getIntent().getStringExtra("uni_p2p_landing_intent_extra_mobile_no");
        this.w = getIntent().getStringExtra("uni_p2p_landing_intent_extra_comment");
        this.x = getIntent().getStringExtra("uni_p2p_landing_intent_extra_amount");
        this.B = getIntent().getBooleanExtra("uni_p2p_landing_intent_extra_beneficiary_flag", false);
        this.y = getIntent().getStringExtra("uni_p2p_landing_intent_extra_transaction_id");
        this.t = getIntent().getStringExtra("uni_p2p_landing_intent_extra_image_url");
        findViewById(R.id.set_payment_tr).setOnClickListener(this);
        if (this.x != null) {
            TextView textView = this.f71495c;
            textView.setText(getString(R.string.rupee_symbol) + " " + this.x);
        }
        TextView textView2 = this.f71497f;
        textView2.setText(getString(R.string.p2p_landing_receiver_name) + " " + this.v);
        try {
            if (!TextUtils.isEmpty(this.H)) {
                this.f71499h.setText(com.paytm.utility.b.a(Long.valueOf(Long.parseLong(this.H)), "hh:mm a, dd MMM yyyy"));
            } else {
                this.f71499h.setText(new SimpleDateFormat("hh:mm a, dd MMM yyyy").format(Long.valueOf(System.currentTimeMillis())));
            }
        } catch (Exception unused2) {
        }
        if (TextUtils.isEmpty(this.t)) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            w.a().a(this.t).a((ah) new a(this, (byte) 0)).a(getResources().getDrawable(R.drawable.profile_logout)).b(R.drawable.profile_logout).a((ImageView) this.m, (e) null);
        }
        if (!TextUtils.isEmpty(this.y)) {
            TextView textView3 = this.f71500i;
            textView3.setText(getString(R.string.p2p_txn_id_landing_screen) + " " + this.y);
        } else {
            this.f71500i.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.u)) {
            this.f71496e.setVisibility(8);
            this.j.setText(String.format(getString(R.string.p2p_chat_with_user_name), new Object[]{this.v}));
            this.k.setText(String.format(getString(R.string.p2p_add_user_name_as_beneficiary), new Object[]{this.v}));
        } else {
            this.f71496e.setVisibility(0);
            TextView textView4 = this.f71496e;
            textView4.setText(this.u + "’s");
            this.f71496e.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setText(String.format(getString(R.string.p2p_chat_with_user_name), new Object[]{this.u}));
            this.k.setText(String.format(getString(R.string.p2p_add_user_name_as_beneficiary), new Object[]{this.u}));
        }
        this.k.setText(getString(R.string.uni_p2p_manage_your_beneficiaries));
        if (!TextUtils.isEmpty(this.w)) {
            this.f71498g.setVisibility(0);
            this.f71498g.setText(this.w);
        } else {
            this.f71498g.setVisibility(8);
        }
        if (this.A) {
            this.D.setVisibility(0);
            this.f71494b.setText(getString(R.string.p2p_paid_successfully));
            this.n.setVisibility(8);
            this.C.setVisibility(0);
            this.n.setImageResource(R.drawable.gree_tick_icon);
            this.C.setAnimation("payment-success.json");
            this.C.loop(true);
            this.C.playAnimation();
            if (b.a().getBooleanFromGTM(this, "refer_shopkeeper_show", true)) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
            b(b.a().showSetReminderView(this.v, QuickPayModeEnum.WALLET.getPayMode()));
        } else {
            this.E.setVisibility(8);
            this.D.setVisibility(8);
            this.f71494b.setText(getString(R.string.p2p_money_transfer_fail));
            this.n.setVisibility(0);
            this.C.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_error);
        }
        boolean booleanFromGTM = b.a().getBooleanFromGTM(this, "showAddBeneficiary", false);
        if (this.B || !booleanFromGTM) {
            this.q.setVisibility(8);
            findViewById(R.id.add_beneficiary_view).setVisibility(8);
        } else {
            this.q.setVisibility(0);
            findViewById(R.id.add_beneficiary_view).setVisibility(0);
        }
        if (this.A && getIntent() != null && !getIntent().hasExtra("bill") && b.a().getBooleanFromGTM(this, "isCTAToChatEnableFromWalletTxn", true)) {
            findViewById(R.id.p2p_chat_redirect).setVisibility(0);
            ThemeData a5 = net.one97.paytm.p2p.theme.g.a((Context) this).a(this.I);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_tag);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.payment_done_p2p_chat_tag));
            arrayList.add(getString(R.string.enjoy_p2p_chat_tag));
            recyclerView.setAdapter(new net.one97.paytm.wallet.p2p.a.a(this, arrayList, a5, new c() {
                public final void a(String str) {
                    P2PLandingPageActivity.this.sendGATags("mt_p2p_new_v1", "Send_Message_In_Chat_clicked", str, "null", b.a().getContext(), "/mt_p2p_wallet_post-transaction");
                    c a2 = b.a();
                    P2PLandingPageActivity p2PLandingPageActivity = P2PLandingPageActivity.this;
                    a2.handleDeepLink(p2PLandingPageActivity, String.format("paytmmp://chat?featuretype=start_chat&phone=%1s&defaultMessage=%2s", new Object[]{p2PLandingPageActivity.v, str}), (Bundle) null);
                    P2PLandingPageActivity.this.finish();
                }
            }));
        }
        if (this.A && (a2 = net.one97.paytm.p2p.theme.g.a((Context) this).a(this.I)) != null) {
            this.K.setVisibility(4);
            if (!TextUtils.isEmpty(a2.getBgcolor())) {
                ((RelativeLayout) findViewById(R.id.p2p_top_body_rl)).setBackgroundColor(Color.parseColor(a2.getBgcolor()));
                this.P.setColorFilter(Color.parseColor(a2.getBgcolor()));
            }
            this.M.setVisibility(8);
            int parseColor = Color.parseColor(a2.getBgcolor());
            Window window = getWindow();
            if (window != null) {
                window.setSoftInputMode(16);
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        decorView.setSystemUiVisibility(0);
                    }
                    window.setStatusBarColor(parseColor);
                }
            }
            this.L.setVisibility(4);
            if (a2.getWhiteNavText() != null && a2.getWhiteNavText().equalsIgnoreCase("0")) {
                getWindow().getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
            if (!TextUtils.isEmpty(a2.getColor())) {
                this.f71494b.setTextColor(Color.parseColor(a2.getColor()));
                this.f71495c.setTextColor(Color.parseColor(a2.getColor()));
                this.f71496e.setTextColor(Color.parseColor(a2.getColor()));
                this.f71497f.setTextColor(Color.parseColor(a2.getColor()));
                this.f71498g.setTextColor(Color.parseColor(a2.getColor()));
                this.f71499h.setTextColor(Color.parseColor(a2.getColor()));
                this.f71499h.setHintTextColor(Color.parseColor(a2.getColor()));
                this.f71500i.setTextColor(Color.parseColor(a2.getColor()));
                this.N.setTextColor(Color.parseColor(a2.getColor()));
                this.O.setColorFilter(Color.parseColor(a2.getColor()));
            }
            if (a2.getJsonData() != null && !TextUtils.isEmpty(a2.getJsonData())) {
                this.J.setVisibility(0);
                this.J.cancelAnimation();
                String jsonData = a2.getJsonData();
                LottieAnimationView lottieAnimationView = this.J;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setAnimationFromJson(jsonData, (String) null);
                    this.J.setRepeatCount(-1);
                    this.J.playAnimation();
                }
            }
        }
        if (!TextUtils.isEmpty(this.y) && this.A) {
            View cashbackView = b.a().getCashbackView(this, this.y);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_20dp);
            if (cashbackView != null) {
                ((ViewGroup) findViewById(R.id.post_txn_view)).addView(cashbackView, layoutParams);
            }
        }
        String str = this.x;
        if (str != null) {
            this.S = new ChatPaymentIntegrationResponseModel(SDKConstants.AI_KEY_WALLET, (String) null, (String) null, (String) null, (String) null, str, System.currentTimeMillis(), stringExtra, (String) null, this.y, this.I, this.w);
            Intent intent = getIntent();
            if (intent != null && intent.hasExtra("bill")) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        if (!P2PLandingPageActivity.this.isFinishing()) {
                            Intent intent = new Intent();
                            intent.putExtra("chat_txn_response", P2PLandingPageActivity.this.S);
                            P2PLandingPageActivity.this.setResult(-1, intent);
                            P2PLandingPageActivity.this.finish();
                        }
                    }
                }, 2000);
            }
        }
    }

    private static void a(String str) {
        at.a().a(at.a.Tprocess, System.currentTimeMillis(), str);
        at.a().a(at.a.Tpayment, System.currentTimeMillis(), str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IStaticWidget iStaticWidget) {
        ((RelativeLayout) findViewById(R.id.floating_nav)).addView(iStaticWidget.getView());
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x017b */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0185 A[Catch:{ Exception -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x018d A[Catch:{ Exception -> 0x0196 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r8 = r8.getId()
            int r0 = net.one97.paytm.wallet.R.id.p2p_back_arrow_iv
            if (r8 != r0) goto L_0x000c
            r7.finish()
            return
        L_0x000c:
            int r0 = net.one97.paytm.wallet.R.id.share_rl
            r1 = 0
            r2 = 1
            if (r8 != r0) goto L_0x00e1
            java.lang.String r8 = "share_icon_clicked"
            r7.b((java.lang.String) r8)
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            r3 = 0
            if (r8 < r0) goto L_0x003d
            boolean r8 = com.paytm.utility.s.a()
            if (r8 == 0) goto L_0x003d
            java.lang.String r8 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r8 = r7.checkSelfPermission(r8)
            if (r8 == 0) goto L_0x003d
            com.paytm.utility.s.b((android.app.Activity) r7)
            int r8 = net.one97.paytm.wallet.R.string.permission_not_granted
            java.lang.String r8 = r7.getString(r8)
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r8, r3)
            r8.show()
            return
        L_0x003d:
            android.content.Intent r8 = new android.content.Intent     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "android.intent.action.SEND"
            r8.<init>(r0)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "image/png"
            r8.setType(r0)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = "android.intent.extra.SUBJECT"
            int r4 = net.one97.paytm.wallet.R.string.post_payment_share_subject     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r4 = r7.getString(r4)     // Catch:{ Exception -> 0x00d4 }
            r8.putExtra(r0, r4)     // Catch:{ Exception -> 0x00d4 }
            int r0 = net.one97.paytm.wallet.R.id.p2p_top_body_rl     // Catch:{ Exception -> 0x00d4 }
            android.view.View r0 = r7.findViewById(r0)     // Catch:{ Exception -> 0x00d4 }
            android.widget.RelativeLayout r4 = r7.D     // Catch:{ Exception -> 0x00d4 }
            r5 = 8
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x00d4 }
            int r4 = r0.getWidth()     // Catch:{ Exception -> 0x00d4 }
            int r5 = r0.getHeight()     // Catch:{ Exception -> 0x00d4 }
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x00d4 }
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ Exception -> 0x00d4 }
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch:{ Exception -> 0x00d4 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00d4 }
            r0.draw(r5)     // Catch:{ Exception -> 0x00d4 }
            android.widget.RelativeLayout r0 = r7.D     // Catch:{ Exception -> 0x00d4 }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x00d4 }
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r3.<init>()     // Catch:{ Exception -> 0x00d4 }
            int r5 = net.one97.paytm.wallet.R.string.title     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = r7.getString(r5)     // Catch:{ Exception -> 0x00d4 }
            r3.append(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = "-"
            r3.append(r5)     // Catch:{ Exception -> 0x00d4 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d4 }
            r3.append(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = android.provider.MediaStore.Images.Media.insertImage(r0, r4, r3, r1)     // Catch:{ Exception -> 0x00d4 }
            if (r0 != 0) goto L_0x00a5
            return
        L_0x00a5:
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r1 = "android.intent.extra.STREAM"
            r8.putExtra(r1, r0)     // Catch:{ Exception -> 0x00d4 }
            int r0 = net.one97.paytm.wallet.R.string.post_payment_share_title     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = r7.getString(r0)     // Catch:{ Exception -> 0x00d4 }
            android.content.Intent r8 = android.content.Intent.createChooser(r8, r0)     // Catch:{ Exception -> 0x00d4 }
            android.content.pm.PackageManager r0 = r7.getPackageManager()     // Catch:{ Exception -> 0x00d4 }
            android.content.ComponentName r0 = r8.resolveActivity(r0)     // Catch:{ Exception -> 0x00d4 }
            if (r0 == 0) goto L_0x00c6
            r7.startActivity(r8)     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x00c6:
            int r8 = net.one97.paytm.wallet.R.string.no_app_found     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x00d4 }
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r8, r2)     // Catch:{ Exception -> 0x00d4 }
            r8.show()     // Catch:{ Exception -> 0x00d4 }
            return
        L_0x00d4:
            r8 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x00e0
            java.lang.String r8 = java.lang.String.valueOf(r8)
            com.paytm.utility.q.d(r8)
        L_0x00e0:
            return
        L_0x00e1:
            int r0 = net.one97.paytm.wallet.R.id.p2p_chat_tr
            if (r8 != r0) goto L_0x00eb
            java.lang.String r8 = "chat_clicked"
            r7.b((java.lang.String) r8)
            return
        L_0x00eb:
            int r0 = net.one97.paytm.wallet.R.id.p2p_payment_tr
            if (r8 != r0) goto L_0x010b
            java.lang.String r8 = "make_another_payment_clicked"
            r7.b((java.lang.String) r8)
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            java.lang.String r0 = r7.v
            java.lang.String r1 = "PHONE_NUMBER"
            r8.putExtra(r1, r0)
            java.lang.String r0 = r7.u
            java.lang.String r1 = "NAME"
            r8.putExtra(r1, r0)
            net.one97.paytm.wallet.utility.a.a((android.content.Intent) r8, (android.app.Activity) r7)
            return
        L_0x010b:
            int r0 = net.one97.paytm.wallet.R.id.p2p_payment_shop
            if (r8 != r0) goto L_0x0128
            java.lang.String r8 = "refer_shopkeeper_clicked"
            r7.b((java.lang.String) r8)
            r7.a(r2)
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r8 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((android.app.Activity) r7)
            net.one97.paytm.wallet.p2p.P2PLandingPageActivity$3 r0 = new net.one97.paytm.wallet.p2p.P2PLandingPageActivity$3
            r0.<init>()
            java.lang.String r2 = r7.v
            java.lang.String r3 = r7.u
            r8.a(r0, r2, r3, r1)
            return
        L_0x0128:
            int r0 = net.one97.paytm.wallet.R.id.p2p_beneficiary_tr
            if (r8 != r0) goto L_0x0139
            java.lang.String r8 = "add_beneficiary_clicked"
            r7.b((java.lang.String) r8)
            net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()
            r8.startManageBeneficiary(r7)
            return
        L_0x0139:
            int r0 = net.one97.paytm.wallet.R.id.p2p_view_passbook_tr
            if (r8 != r0) goto L_0x0197
            boolean r8 = r7.A
            if (r8 == 0) goto L_0x017b
            java.lang.String r8 = "view_passbook_clicked"
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x017b }
            r0.<init>()     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "screenName"
            java.lang.String r3 = "/wallet/pay-send/success"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "event_category"
            java.lang.String r3 = "wallet_send_money"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "event_action"
            r0.put(r2, r8)     // Catch:{ Exception -> 0x017b }
            java.lang.String r8 = "vertical_name"
            java.lang.String r2 = "wallet"
            r0.put(r8, r2)     // Catch:{ Exception -> 0x017b }
            java.lang.String r8 = "event_label"
            java.lang.String r2 = "p2p"
            r0.put(r8, r2)     // Catch:{ Exception -> 0x017b }
            java.lang.String r8 = "user_id"
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x017b }
            r0.put(r8, r2)     // Catch:{ Exception -> 0x017b }
            net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "custom_event"
            r8.sendCustomGTMEvent(r7, r2, r0)     // Catch:{ Exception -> 0x017b }
        L_0x017b:
            android.content.Context r8 = r7.getApplicationContext()     // Catch:{ Exception -> 0x0196 }
            boolean r8 = com.paytm.utility.b.r((android.content.Context) r8)     // Catch:{ Exception -> 0x0196 }
            if (r8 == 0) goto L_0x018d
            net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0196 }
            r8.startPassbookSubwalletActivity(r7)     // Catch:{ Exception -> 0x0196 }
            return
        L_0x018d:
            net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x0196 }
            java.lang.String r0 = "paytmmp://cash_wallet?featuretype=cash_ledger"
            r8.handleDeepLink(r7, r0, r1)     // Catch:{ Exception -> 0x0196 }
        L_0x0196:
            return
        L_0x0197:
            int r0 = net.one97.paytm.wallet.R.id.p2p_complete_kyc
            if (r8 != r0) goto L_0x01b7
            r7.getApplicationContext()     // Catch:{ Exception -> 0x01b6 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r8 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()     // Catch:{ Exception -> 0x01b6 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$b r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.b.KYC_UPGRADE_WALLET     // Catch:{ Exception -> 0x01b6 }
            r8.f71390b = r0     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r0 = "p2p_failure_clicked"
            r8.f71397i = r0     // Catch:{ Exception -> 0x01b6 }
            r8.b((android.content.Context) r7)     // Catch:{ Exception -> 0x01b6 }
            net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x01b6 }
            java.lang.String r0 = "paytmmp://upgrade_wallet"
            r8.checkDeepLinking(r7, r0)     // Catch:{ Exception -> 0x01b6 }
        L_0x01b6:
            return
        L_0x01b7:
            int r0 = net.one97.paytm.wallet.R.id.set_payment_tr
            if (r8 != r0) goto L_0x0207
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r8 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$e r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.e.WALLET_PAY
            r8.j = r0
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$a r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.C1450a.SET_REMINDER_CLICKED
            r8.l = r0
            net.one97.paytm.wallet.newdesign.universalp2p.c.a$b r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.b.WAlLET_SEND_MONEY
            r8.k = r0
            r8.b((android.content.Context) r7)
            net.one97.paytm.wallet.communicator.c r8 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Intent r8 = r8.getPaymentReminderCreationActivity(r7)
            java.lang.String r0 = r7.t
            java.lang.String r1 = "tag_url"
            r8.putExtra(r1, r0)
            java.lang.String r0 = r7.u
            java.lang.String r1 = "tag_name"
            r8.putExtra(r1, r0)
            net.one97.paytm.upi.common.QuickPayModeEnum r0 = net.one97.paytm.upi.common.QuickPayModeEnum.WALLET
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r1 = "quick_pay_mode"
            r8.putExtra(r1, r0)
            java.lang.String r0 = r7.v
            java.lang.String r1 = "quick_mobile_number"
            r8.putExtra(r1, r0)
            java.lang.String r0 = "is_called_post_txn_screen"
            r8.putExtra(r0, r2)
            java.lang.String r0 = r7.x
            java.lang.String r1 = "quick_amount"
            r8.putExtra(r1, r0)
            r0 = 120(0x78, float:1.68E-43)
            r7.startActivityForResult(r8, r0)
        L_0x0207:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.p2p.P2PLandingPageActivity.onClick(android.view.View):void");
    }

    private void b(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "payment successful screen");
            hashMap.put("event_category", "wallet_send_money");
            hashMap.put("event_action", str);
            hashMap.put("vertical_name", "wallet");
            hashMap.put("event_label", "success screen");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            b.a().sendCustomGTMEvent(this, GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception unused) {
        }
    }

    private void b(boolean z2) {
        if (z2) {
            findViewById(R.id.set_payment_tr).setVisibility(0);
            findViewById(R.id.set_payment_tr).setOnClickListener(this);
            return;
        }
        findViewById(R.id.set_payment_tr).setVisibility(8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 120) {
            if (i3 == -1) {
                b(false);
            } else {
                b(true);
            }
        }
        if (i2 == 1002 && i3 == -1) {
            BankVpaCreationActivity.a((Activity) this, (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), this.G, 1003);
            finish();
        }
    }

    class a implements ah {
        public final String key() {
            return "circle";
        }

        private a() {
        }

        /* synthetic */ a(P2PLandingPageActivity p2PLandingPageActivity, byte b2) {
            this();
        }

        public final Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("shouldPlaySound", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent(this, b.a().getMainActivityClass());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        intent.putExtra("started_activity_from_recharge", true);
        startActivity(intent);
        finish();
    }

    static /* synthetic */ void a(P2PLandingPageActivity p2PLandingPageActivity, String str, String str2, String str3, String str4) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
            hashMap.put("event_category", str);
            hashMap.put("event_action", str2);
            hashMap.put("user_id", com.paytm.utility.b.n((Context) p2PLandingPageActivity));
            hashMap.put(d.cv, str4);
            b.a().sendCustomGTMEvent(p2PLandingPageActivity, GAUtil.CUSTOM_EVENT, hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.d(String.valueOf(e2));
            }
        }
    }
}
