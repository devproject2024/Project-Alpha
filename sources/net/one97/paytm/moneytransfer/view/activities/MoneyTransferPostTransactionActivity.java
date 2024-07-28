package net.one97.paytm.moneytransfer.view.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import easypay.manager.Constants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.aa;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateExtraInfoDataModel;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.locale.storage.LocaleDBContract;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.f;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.LockableScrollView;
import net.one97.paytm.moneytransfer.utils.MoneyTransferShimmerAnimationLayout;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.view.fragments.MoneyTransferInviteFragment;
import net.one97.paytm.moneytransfer.view.fragments.p;
import net.one97.paytm.moneytransfer.view.fragments.q;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2mNewDesign.models.QrData;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiTransactionStatusModel;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.AnimationUtils;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.EnglishNumberToWords;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiContract;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UserActionEvent;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel;

public final class MoneyTransferPostTransactionActivity extends MoneyTransferBaseActivity implements View.OnClickListener, net.one97.paytm.common.a, n.c, net.one97.paytm.common.widgets.a.a, f.a, q.a, a.C1347a {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private MoneyTransferV3Activity.a G;
    private String H;
    /* access modifiers changed from: private */
    public boolean I;
    private String J = "retry_button_loaded_no";
    private Dialog K;
    private q L;
    /* access modifiers changed from: private */
    public net.one97.paytm.common.widgets.c M;
    private UpiGenerateCashbackDataModel N;
    private String O;
    private ThemeData P;
    private String Q;
    private CommonPayParams R;
    /* access modifiers changed from: private */
    public boolean S;
    private UPICheckBalanceHelper T;
    /* access modifiers changed from: private */
    public String U;
    private PPBCurrentAccountModel V;
    private long W = -1;
    private long X = -1;
    private long Y = -1;
    private long Z = -1;

    /* renamed from: a  reason: collision with root package name */
    private final int f54307a = 45;
    private String aa = "";
    private HashMap ab;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.moneytransfer.presenter.d f54308b;

    /* renamed from: c  reason: collision with root package name */
    private UpiBaseDataModel f54309c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public UpiTransactionStatusModel f54310d;

    /* renamed from: e  reason: collision with root package name */
    private String f54311e;

    /* renamed from: f  reason: collision with root package name */
    private String f54312f;

    /* renamed from: g  reason: collision with root package name */
    private String f54313g;

    /* renamed from: h  reason: collision with root package name */
    private String f54314h;

    /* renamed from: i  reason: collision with root package name */
    private String f54315i;
    private String j;
    private String k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public String n;
    private String o;
    private String p;
    private String q;
    private String r;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank s;
    private String t;
    private String u;
    private String v;
    private String w;
    private boolean x;
    /* access modifiers changed from: private */
    public boolean y;
    private boolean z;

    public final View a(int i2) {
        if (this.ab == null) {
            this.ab = new HashMap();
        }
        View view = (View) this.ab.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.ab.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onServiceConnected() {
    }

    public final void onServiceDisconnected() {
    }

    public final void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("common_pay_flag", this.D);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_money_transfer_post_transaction);
        Context context = this;
        net.one97.paytm.moneytransfer.utils.f.a(context, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME);
        net.one97.paytm.upi.passbook.b.a.b b2 = net.one97.paytm.upi.g.b();
        net.one97.paytm.moneytransfer.b.a.b a2 = net.one97.paytm.moneytransfer.b.a(context);
        net.one97.paytm.upi.g.c();
        this.f54308b = new net.one97.paytm.moneytransfer.presenter.d(this, b2, a2, net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null)), net.one97.paytm.upi.g.a(), net.one97.paytm.upi.g.a((a.C1347a) this));
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "getSupportFragmentManager()");
        b3.a(context, supportFragmentManager);
        Serializable serializableExtra = getIntent().getSerializableExtra("key_bundle");
        if (!(serializableExtra instanceof UpiBaseDataModel)) {
            serializableExtra = null;
        }
        this.f54309c = (UpiBaseDataModel) serializableExtra;
        this.f54314h = getIntent().getStringExtra("payee_mob_no");
        this.f54311e = getIntent().getStringExtra("key_amount");
        this.f54312f = getIntent().getStringExtra(LocaleDBContract.BaseTable.KEY);
        this.v = getIntent().getStringExtra("key_mpin");
        this.u = getIntent().getStringExtra("npci_trust");
        this.f54313g = getIntent().getStringExtra("key_comment");
        this.f54315i = getIntent().getStringExtra("key_account_number");
        this.r = getIntent().getStringExtra("key_ppb_account_number");
        this.k = getIntent().getStringExtra("key_bank_name");
        this.x = getIntent().getBooleanExtra("is_deeplink", false);
        this.B = getIntent().getBooleanExtra(UpiConstants.IS_FROM_SCAN, false);
        this.w = getIntent().getStringExtra("ref_id");
        this.q = getIntent().getStringExtra("key_account_number_selected");
        this.p = getIntent().getStringExtra("ifsc");
        this.y = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, false);
        this.z = getIntent().getBooleanExtra("upi_is_self", false);
        this.A = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, false);
        this.j = getIntent().getStringExtra("collect_request_txn_id");
        this.n = getIntent().getStringExtra("payee_address");
        this.l = getIntent().getStringExtra("mcc");
        this.m = getIntent().getStringExtra("ref_url");
        this.o = getIntent().getStringExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID);
        Serializable serializableExtra2 = getIntent().getSerializableExtra(UpiConstants.EXTRA_PAYER_VPA);
        if (!(serializableExtra2 instanceof UpiProfileDefaultBank)) {
            serializableExtra2 = null;
        }
        this.s = (UpiProfileDefaultBank) serializableExtra2;
        Serializable serializableExtra3 = getIntent().getSerializableExtra("ppb_ica");
        if (!(serializableExtra3 instanceof PPBCurrentAccountModel)) {
            serializableExtra3 = null;
        }
        this.V = (PPBCurrentAccountModel) serializableExtra3;
        Serializable serializableExtra4 = getIntent().getSerializableExtra("payee_acc_or_vpa");
        if (!(serializableExtra4 instanceof MoneyTransferV3Activity.a)) {
            serializableExtra4 = null;
        }
        this.G = (MoneyTransferV3Activity.a) serializableExtra4;
        this.H = getIntent().getStringExtra("min_amt_deep_link");
        this.t = getIntent().getStringExtra("global_address_type");
        this.I = getIntent().getBooleanExtra("is_from_upi_deep_link", false);
        Intent intent = getIntent();
        this.O = intent != null ? intent.getStringExtra("uni_p2p_landing_intent_extra_theme") : null;
        Intent intent2 = getIntent();
        this.Q = intent2 != null ? intent2.getStringExtra("key_payer_ppb_account_number") : null;
        Serializable serializableExtra5 = getIntent().getSerializableExtra(UpiConstants.KEY_INTENT_PARAMS);
        if (!(serializableExtra5 instanceof CommonPayParams)) {
            serializableExtra5 = null;
        }
        this.R = (CommonPayParams) serializableExtra5;
        Intent intent3 = getIntent();
        this.E = intent3 != null ? intent3.getBooleanExtra("from_app_evoke", false) : false;
        Intent intent4 = getIntent();
        this.F = intent4 != null ? intent4.getBooleanExtra("is_from_chat_flow", false) : false;
        Intent intent5 = getIntent();
        long j2 = -1;
        this.X = intent5 != null ? intent5.getLongExtra("process", -1) : -1;
        Intent intent6 = getIntent();
        this.Y = intent6 != null ? intent6.getLongExtra(UpiConstants.EVENT_START_TIME, -1) : -1;
        Intent intent7 = getIntent();
        if (intent7 != null) {
            j2 = intent7.getLongExtra(UpiConstants.EVENT_SCAN_TIME, -1);
        }
        this.Z = j2;
        if (this.A) {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.d.b(d.a.a()).d(context);
        }
        if (m.b()) {
            View findViewById = findViewById(R.id.light_blue_line);
            kotlin.g.b.k.a((Object) findViewById, "findViewById<View>(R.id.light_blue_line)");
            findViewById.setVisibility(4);
            View findViewById2 = findViewById(R.id.bottom_line);
            kotlin.g.b.k.a((Object) findViewById2, "findViewById<View>(R.id.bottom_line)");
            findViewById2.setVisibility(4);
        }
        TextView textView = (TextView) a(R.id.tv_amount);
        kotlin.g.b.k.a((Object) textView, "tv_amount");
        textView.setText(getString(R.string.mt_rupees) + UpiAppUtils.priceToString(this.f54311e));
        TextView textView2 = (TextView) a(R.id.tv_amount_in_words);
        kotlin.g.b.k.a((Object) textView2, "tv_amount_in_words");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.mt_amount_in_words_placeholder);
        kotlin.g.b.k.a((Object) string, "getString(R.string.mt_amount_in_words_placeholder)");
        String format = String.format(string, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(this.f54311e)}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        textView2.setText(format);
        c();
        TextView textView3 = (TextView) a(R.id.order_id_tv);
        if (textView3 != null) {
            textView3.setOnLongClickListener(new c(this));
        }
        ((ImageView) a(R.id.iv_close_top)).setOnClickListener(new b(this));
        if (bundle == null || !bundle.getBoolean("common_pay_flag", false) || TextUtils.isEmpty(this.j)) {
            g();
        } else {
            this.D = true;
            this.f54309c = new BaseUpiResponse();
            String str = this.j;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            c(str);
        }
        net.one97.paytm.moneytransfer.presenter.d dVar = this.f54308b;
        if (dVar != null) {
            dVar.b(this.f54315i);
        }
        c.a aVar3 = net.one97.paytm.moneytransfer.d.c.C;
        String str2 = net.one97.paytm.moneytransfer.d.c.a(c.a.a().x, "https://storefront.paytm.com/v2/h/ump-money-transfer-post-txn-page") + UpiAppUtils.getAuthDefaultParams(context);
        String str3 = com.paytm.utility.b.t(context, str2) + "&child_site_id=" + com.paytm.utility.a.b() + "&site_id=" + com.paytm.utility.a.a();
        d.a aVar4 = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b4 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        View findViewById3 = findViewById(R.id.ll_bottom_layout);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById<FrameLayout>(R.id.ll_bottom_layout)");
        View findViewById4 = findViewById(R.id.bannerRecyclerView);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.bannerRecyclerView)");
        b4.a(findViewById3, str3, this, (RecyclerView) findViewById4);
        if (this.y) {
            String str4 = this.f54311e;
            if (str4 == null) {
                str4 = "";
            }
            net.one97.paytm.moneytransfer.utils.e.a((Activity) this, Events.Category.COLLECT, "screen_open", Events.Screen.POST_TRANSACTION, "", "", str4);
        } else if (this.I) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getApplicationContext(), Events.Category.INTENT, "screen_open", "", "", "", this.n, this.f54311e, Events.Screen.POST_TRANSACTION, "");
        }
        if (this.y) {
            UserActionEvent userActionEvent = UserActionEvent.INSTANCE;
            String name = UserActionEvent.ActionType.PAY.name();
            String str5 = this.o;
            if (str5 == null) {
                kotlin.g.b.k.a();
            }
            userActionEvent.setAction(new UserActionEvent.Action(name, str5));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54318a;

        b(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54318a = moneyTransferPostTransactionActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
            r11 = (r11 = r11.getDetails()).getStatus();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r11) {
            /*
                r10 = this;
                net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity r11 = r10.f54318a
                boolean r11 = r11.y
                if (r11 == 0) goto L_0x0042
                net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity r11 = r10.f54318a
                r0 = r11
                android.content.Context r0 = (android.content.Context) r0
                net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r11 = r11.f54310d
                java.lang.String r1 = ""
                if (r11 == 0) goto L_0x0024
                net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r11 = r11.getDetails()
                if (r11 == 0) goto L_0x0024
                java.lang.String r11 = r11.getStatus()
                if (r11 != 0) goto L_0x0022
                goto L_0x0024
            L_0x0022:
                r3 = r11
                goto L_0x0025
            L_0x0024:
                r3 = r1
            L_0x0025:
                net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity r11 = r10.f54318a
                java.lang.String r11 = r11.n
                if (r11 != 0) goto L_0x002f
                r6 = r1
                goto L_0x0030
            L_0x002f:
                r6 = r11
            L_0x0030:
                java.lang.String r1 = "upi_collect_pay_v1"
                java.lang.String r2 = "back_arrow_clicked"
                java.lang.String r4 = ""
                java.lang.String r5 = ""
                java.lang.String r7 = ""
                java.lang.String r8 = "/mt_post-transaction"
                java.lang.String r9 = ""
                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            L_0x0042:
                net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity r11 = r10.f54318a
                r11.onBackPressed()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.b.onClick(android.view.View):void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean f() {
        /*
            r2 = this;
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r2.f54310d
            r1 = 0
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x0010
            java.util.ArrayList r0 = r0.getTimeline()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0038
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r2.f54310d
            if (r0 == 0) goto L_0x002b
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x002b
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x002b
            int r0 = r0.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
        L_0x002b:
            if (r1 != 0) goto L_0x0030
            kotlin.g.b.k.a()
        L_0x0030:
            int r0 = r1.intValue()
            if (r0 <= 0) goto L_0x0038
            r0 = 1
            return r0
        L_0x0038:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.f():boolean");
    }

    private final void g() {
        if (this.f54309c != null || TextUtils.isEmpty(this.v)) {
            UpiBaseDataModel upiBaseDataModel = this.f54309c;
            if (upiBaseDataModel == null || !(upiBaseDataModel instanceof BaseUpiResponse)) {
                UpiBaseDataModel upiBaseDataModel2 = this.f54309c;
                if (upiBaseDataModel2 != null && (upiBaseDataModel2 instanceof CJRMoneyTransferIMPSInitiateDataModel)) {
                    if (upiBaseDataModel2 != null) {
                        CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel2;
                        o();
                        UpiBaseDataModel upiBaseDataModel3 = this.f54309c;
                        if (upiBaseDataModel3 == null) {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
                        } else if (p.a("PENDING", ((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel3).getmStatus(), true)) {
                            f((UpiBaseDataModel) cJRMoneyTransferIMPSInitiateDataModel);
                        } else {
                            UpiBaseDataModel upiBaseDataModel4 = this.f54309c;
                            if (upiBaseDataModel4 != null) {
                                if (!p.a("FAILED", ((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel4).getmStatus(), true)) {
                                    UpiBaseDataModel upiBaseDataModel5 = this.f54309c;
                                    if (upiBaseDataModel5 == null) {
                                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
                                    } else if (!p.a("FAILURE", ((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel5).getmStatus(), true)) {
                                        d((UpiBaseDataModel) cJRMoneyTransferIMPSInitiateDataModel);
                                        e(Constants.DEFAULT_BANK);
                                    }
                                }
                                g((UpiBaseDataModel) cJRMoneyTransferIMPSInitiateDataModel);
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
                    }
                } else {
                    return;
                }
            } else if (upiBaseDataModel != null) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (kotlin.g.b.k.a((Object) baseUpiResponse.getResponse(), (Object) "92") || kotlin.g.b.k.a((Object) baseUpiResponse.getResponse(), (Object) "91") || kotlin.g.b.k.a((Object) baseUpiResponse.getResponse(), (Object) "RB")) {
                    c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
                    if (c.a.a().a() && !TextUtils.isEmpty(this.j)) {
                        String str = this.j;
                        if (str == null) {
                            kotlin.g.b.k.a();
                        }
                        c(str);
                        return;
                    }
                    return;
                } else if (!baseUpiResponse.isSuccess()) {
                    c(baseUpiResponse);
                    o();
                    g((UpiBaseDataModel) baseUpiResponse);
                } else {
                    o();
                    l();
                    if (f()) {
                        d(baseUpiResponse);
                        return;
                    }
                    if (q()) {
                        p();
                    } else {
                        d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
                        net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                        String str2 = this.j;
                        if (str2 == null) {
                            kotlin.g.b.k.a();
                        }
                        View findViewById = findViewById(R.id.cashback_offer_view);
                        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.cashback_offer_view)");
                        b2.a(str2, findViewById);
                        View findViewById2 = findViewById(R.id.bannerRecyclerView);
                        kotlin.g.b.k.a((Object) findViewById2, "findViewById<RecyclerVie…(R.id.bannerRecyclerView)");
                        net.one97.paytm.upi.f.b(findViewById2);
                    }
                    d((UpiBaseDataModel) baseUpiResponse);
                    e("UPI");
                    C();
                    return;
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
            }
            l();
            return;
        }
        b(this.v);
    }

    private final void c(String str) {
        if (this.f54308b == null) {
            net.one97.paytm.upi.passbook.b.a.b b2 = net.one97.paytm.upi.g.b();
            net.one97.paytm.moneytransfer.b.a.b a2 = net.one97.paytm.moneytransfer.b.a(this);
            net.one97.paytm.upi.g.c();
            this.f54308b = new net.one97.paytm.moneytransfer.presenter.d(this, b2, a2, net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null)), net.one97.paytm.upi.g.a(), net.one97.paytm.upi.g.a((a.C1347a) this));
        }
        net.one97.paytm.moneytransfer.presenter.d dVar = this.f54308b;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    private final void c(BaseUpiResponse baseUpiResponse) {
        if ((p.a(baseUpiResponse.getResponse(), "U66", true) || p.a(baseUpiResponse.getResponse(), "U54", true)) && this.s != null) {
            net.one97.paytm.moneytransfer.presenter.d dVar = this.f54308b;
            if (dVar != null) {
                String str = this.j;
                String response = baseUpiResponse.getResponse();
                String str2 = this.u;
                String str3 = this.f54311e;
                UpiProfileDefaultBank upiProfileDefaultBank = this.s;
                if (upiProfileDefaultBank == null) {
                    kotlin.g.b.k.a();
                }
                dVar.a(str, response, str2, str3, upiProfileDefaultBank.getVirtualAddress(), this.n);
            }
            m.a((Context) this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.upi.common.upi.BaseUpiResponse r5) {
        /*
            r4 = this;
            net.one97.paytm.upi.common.UpiBaseDataModel r0 = r4.f54309c
            if (r0 == 0) goto L_0x00e8
            boolean r0 = r0 instanceof net.one97.paytm.upi.common.upi.BaseUpiResponse
            if (r0 == 0) goto L_0x00e8
            if (r5 == 0) goto L_0x00e5
            java.lang.Object r0 = r5.getMobileAppData()
            boolean r0 = r0 instanceof net.one97.paytm.upi.common.upi.UpiTransactionStatusModel
            if (r0 == 0) goto L_0x00e1
            java.lang.Object r0 = r5.getMobileAppData()
            if (r0 == 0) goto L_0x00d9
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = (net.one97.paytm.upi.common.upi.UpiTransactionStatusModel) r0
            r4.f54310d = r0
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r4.f54310d
            if (r0 == 0) goto L_0x00e1
            r1 = 0
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r0 == 0) goto L_0x00e1
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r4.f54310d
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = r0.getStatus()
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            r2 = 1
            java.lang.String r3 = "SUCCESS"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r2)
            if (r3 != 0) goto L_0x00c4
            java.lang.String r3 = "DEEMED"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r0, (boolean) r2)
            if (r3 == 0) goto L_0x004e
            goto L_0x00c4
        L_0x004e:
            java.lang.String r5 = "FAILURE"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r0, (boolean) r2)
            if (r5 == 0) goto L_0x00e1
            net.one97.paytm.upi.common.UpiBaseDataModel r5 = r4.f54309c
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse"
            if (r5 == 0) goto L_0x00be
            net.one97.paytm.upi.common.upi.BaseUpiResponse r5 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r5
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r2 = r4.f54310d
            if (r2 == 0) goto L_0x006d
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r2 = r2.getDetails()
            if (r2 == 0) goto L_0x006d
            java.lang.String r2 = r2.getRc()
            goto L_0x006e
        L_0x006d:
            r2 = r1
        L_0x006e:
            r5.setResponse(r2)
            net.one97.paytm.upi.common.UpiBaseDataModel r5 = r4.f54309c
            if (r5 == 0) goto L_0x00b8
            net.one97.paytm.upi.common.upi.BaseUpiResponse r5 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r5
            r2 = 0
            r5.setSuccess(r2)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r5 = r4.f54310d
            if (r5 == 0) goto L_0x0089
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r5 = r5.getDetails()
            if (r5 == 0) goto L_0x0089
            java.lang.String r1 = r5.getMessage()
        L_0x0089:
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00a8
            net.one97.paytm.upi.common.UpiBaseDataModel r5 = r4.f54309c
            if (r5 == 0) goto L_0x00a2
            net.one97.paytm.upi.common.upi.BaseUpiResponse r5 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r5
            int r0 = net.one97.paytm.moneytransfer.R.string.mt_default_failure_message_for_polling
            java.lang.String r0 = r4.getString(r0)
            r5.setMessage(r0)
            goto L_0x00e1
        L_0x00a2:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r0)
            throw r5
        L_0x00a8:
            net.one97.paytm.upi.common.UpiBaseDataModel r5 = r4.f54309c
            if (r5 == 0) goto L_0x00b2
            net.one97.paytm.upi.common.upi.BaseUpiResponse r5 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r5
            r5.setMessage(r1)
            goto L_0x00e1
        L_0x00b2:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r0)
            throw r5
        L_0x00b8:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r0)
            throw r5
        L_0x00be:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r0)
            throw r5
        L_0x00c4:
            net.one97.paytm.upi.common.UpiBaseDataModel r5 = (net.one97.paytm.upi.common.UpiBaseDataModel) r5
            r4.f54309c = r5
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r5 = r4.f54310d
            if (r5 == 0) goto L_0x00d6
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r5 = r5.getDetails()
            if (r5 == 0) goto L_0x00d6
            net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel r1 = r5.getUpiGenerateCashbackDataModel()
        L_0x00d6:
            r4.N = r1
            goto L_0x00e1
        L_0x00d9:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiTransactionStatusModel"
            r5.<init>(r0)
            throw r5
        L_0x00e1:
            r4.g()
            return
        L_0x00e5:
            r4.z()
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.a(net.one97.paytm.upi.common.upi.BaseUpiResponse):void");
    }

    private final void h() {
        UpiTransactionStatusModel upiTransactionStatusModel = new UpiTransactionStatusModel();
        UpiTransactionStatusModel.TransactionStatus transactionStatus = new UpiTransactionStatusModel.TransactionStatus();
        String str = this.f54311e;
        transactionStatus.setmAmount(str != null ? Double.parseDouble(str) : 0.0d);
        transactionStatus.setmStatus("PENDING");
        transactionStatus.setTxnId(this.j);
        upiTransactionStatusModel.setmDetails(transactionStatus);
        a(c((UpiBaseDataModel) upiTransactionStatusModel));
    }

    private final void a(UpiTransactionStatusModel upiTransactionStatusModel, BaseUpiResponse baseUpiResponse) {
        if (upiTransactionStatusModel == null) {
            UpiTransactionStatusModel upiTransactionStatusModel2 = new UpiTransactionStatusModel();
            UpiTransactionStatusModel.TransactionStatus transactionStatus = new UpiTransactionStatusModel.TransactionStatus();
            String str = this.f54311e;
            transactionStatus.setmAmount(str != null ? Double.parseDouble(str) : 0.0d);
            transactionStatus.setmStatus(!baseUpiResponse.isSuccess() ? "FAILURE" : "SUCCESS");
            transactionStatus.setmRc(baseUpiResponse.getResponse());
            transactionStatus.setmMessage(baseUpiResponse.getMessage());
            transactionStatus.setmRrn(baseUpiResponse.getBankRRN());
            transactionStatus.setTxnId(this.j);
            upiTransactionStatusModel2.setmDetails(transactionStatus);
            a(c((UpiBaseDataModel) upiTransactionStatusModel2));
            return;
        }
        UpiTransactionStatusModel.TransactionStatus details = upiTransactionStatusModel.getDetails();
        if (details != null) {
            details.setTxnId(this.j);
        }
        a(c((UpiBaseDataModel) upiTransactionStatusModel));
    }

    private final void a(CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel) {
        a(c((UpiBaseDataModel) cJRMoneyTransferIMPSInitiateDataModel));
    }

    private final void b(UpiBaseDataModel upiBaseDataModel) {
        Intent intent = new Intent();
        if (upiBaseDataModel instanceof BaseUpiResponse) {
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
            intent.putExtra("resultdata", baseUpiResponse.getBankRRN());
            intent.putExtra("response title", baseUpiResponse.isSuccess() ? "SUCCESS" : "FAILURE");
            kotlin.g.b.k.a((Object) intent.putExtra("response Message", baseUpiResponse.getMessage()), "intent.putExtra(\"respons…sage\", dataModel.message)");
        } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel;
            intent.putExtra("resultdata", cJRMoneyTransferIMPSInitiateDataModel.getRrn());
            intent.putExtra("response title", cJRMoneyTransferIMPSInitiateDataModel.getmStatus());
            intent.putExtra("response Message", cJRMoneyTransferIMPSInitiateDataModel.getMessage());
        }
        a(intent);
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54327a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f54328b;

        e(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity, Intent intent) {
            this.f54327a = moneyTransferPostTransactionActivity;
            this.f54328b = intent;
        }

        public final void run() {
            this.f54327a.setResult(-1, this.f54328b);
            this.f54327a.finish();
        }
    }

    private final void a(Intent intent) {
        new Handler().postDelayed(new e(this, intent), 2000);
    }

    private final Intent c(UpiBaseDataModel upiBaseDataModel) {
        ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel;
        String str;
        String str2;
        BankAccountDetails.BankAccount debitBank;
        UpiBaseDataModel upiBaseDataModel2 = upiBaseDataModel;
        String str3 = null;
        if (upiBaseDataModel2 instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            String str4 = this.f54315i;
            String str5 = this.Q;
            CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel2;
            String amount = cJRMoneyTransferIMPSInitiateDataModel.getAmount();
            kotlin.g.b.k.a((Object) amount, "dataModel.amount");
            long currentTimeMillis = System.currentTimeMillis();
            String str6 = cJRMoneyTransferIMPSInitiateDataModel.getmStatus();
            kotlin.g.b.k.a((Object) str6, "dataModel.getmStatus()");
            chatPaymentIntegrationResponseModel = new ChatPaymentIntegrationResponseModel("IMPS", "", str4, "", str5, amount, currentTimeMillis, str6, "", cJRMoneyTransferIMPSInitiateDataModel.getRrn(), this.O, cJRMoneyTransferIMPSInitiateDataModel.getMessage());
        } else if (upiBaseDataModel2 instanceof UpiTransactionStatusModel) {
            if (UpiAppUtils.checkIsVpa(this.f54315i)) {
                str2 = this.f54315i;
                str = "";
            } else {
                str = this.f54315i;
                str2 = "";
            }
            UpiProfileDefaultBank upiProfileDefaultBank = this.s;
            String virtualAddress = upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : null;
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.s;
            if (!(upiProfileDefaultBank2 == null || (debitBank = upiProfileDefaultBank2.getDebitBank()) == null)) {
                str3 = debitBank.getAccount();
            }
            String str7 = str3;
            UpiTransactionStatusModel upiTransactionStatusModel = (UpiTransactionStatusModel) upiBaseDataModel2;
            UpiTransactionStatusModel.TransactionStatus details = upiTransactionStatusModel.getDetails();
            kotlin.g.b.k.a((Object) details, "dataModel.details");
            String valueOf = String.valueOf(details.getAmount());
            long currentTimeMillis2 = System.currentTimeMillis();
            UpiTransactionStatusModel.TransactionStatus details2 = upiTransactionStatusModel.getDetails();
            kotlin.g.b.k.a((Object) details2, "dataModel.details");
            String status = details2.getStatus();
            kotlin.g.b.k.a((Object) status, "dataModel.details.status");
            UpiTransactionStatusModel.TransactionStatus details3 = upiTransactionStatusModel.getDetails();
            kotlin.g.b.k.a((Object) details3, "dataModel.details");
            String txnId = details3.getTxnId();
            String str8 = this.O;
            UpiTransactionStatusModel.TransactionStatus details4 = upiTransactionStatusModel.getDetails();
            kotlin.g.b.k.a((Object) details4, "dataModel.details");
            chatPaymentIntegrationResponseModel = new ChatPaymentIntegrationResponseModel("UPI", str2, str, virtualAddress, str7, valueOf, currentTimeMillis2, status, "", txnId, str8, details4.getMessage());
        } else {
            chatPaymentIntegrationResponseModel = null;
        }
        Intent intent = new Intent();
        intent.putExtra("chat_txn_response", chatPaymentIntegrationResponseModel);
        return intent;
    }

    private final void d(UpiBaseDataModel upiBaseDataModel) {
        String a2 = com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy");
        kotlin.g.b.k.a((Object) a2, "CJRAppCommonUtility.getD…ESS__CURRENT_TIME_FORMAT)");
        this.aa = a2;
        g("success");
        x();
        if (!TextUtils.isEmpty(this.O)) {
            w();
        }
        u();
        LinearLayout linearLayout = (LinearLayout) a(R.id.actions_group);
        kotlin.g.b.k.a((Object) linearLayout, "actions_group");
        linearLayout.setVisibility(0);
        ImageView imageView = (ImageView) a(R.id.iv_share);
        kotlin.g.b.k.a((Object) imageView, "iv_share");
        imageView.setVisibility(0);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.timeline_layout);
        kotlin.g.b.k.a((Object) constraintLayout, "timeline_layout");
        constraintLayout.setVisibility(8);
        ((TextView) a(R.id.tv_view_details)).setOnClickListener(new f(this));
        ((TextView) a(R.id.tv_repeat_payment)).setOnClickListener(new g(this));
        ((ImageView) a(R.id.iv_share)).setOnClickListener(new h(this));
        v();
        e(upiBaseDataModel);
        A();
        if (this.B) {
            B();
        }
        Context context = this;
        Context context2 = context;
        net.one97.paytm.moneytransfer.utils.f.a(context2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_TXN_COMPLETED, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        net.one97.paytm.moneytransfer.utils.f.a(context2, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_TXN_STATUS, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "success", "");
        Intent intent = getIntent();
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("hide_isa_fd", false)) : null;
        if (valueOf == null || !valueOf.booleanValue()) {
            m.f(context);
        } else {
            b(1);
        }
        f("success");
        if (this.E) {
            b(upiBaseDataModel);
        }
        if (!this.F) {
            return;
        }
        if (upiBaseDataModel instanceof BaseUpiResponse) {
            a(this.f54310d, (BaseUpiResponse) upiBaseDataModel);
        } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            a((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54329a;

        f(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54329a = moneyTransferPostTransactionActivity;
        }

        public final void onClick(View view) {
            if (this.f54329a.y) {
                MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this.f54329a;
                Context context = moneyTransferPostTransactionActivity;
                String c2 = moneyTransferPostTransactionActivity.n;
                if (c2 == null) {
                    c2 = "";
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, Events.Category.COLLECT, "view_txn_details", "", "", "", c2, "", Events.Screen.POST_TRANSACTION, "");
            }
            if (this.f54329a.I) {
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f54329a.getApplicationContext(), Events.Category.INTENT, "view_txn_details", "", "", "", this.f54329a.n, "", Events.Screen.POST_TRANSACTION, "");
            }
            MoneyTransferPostTransactionActivity.e(this.f54329a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54330a;

        g(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54330a = moneyTransferPostTransactionActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransfer.utils.f.a(this.f54330a.getApplicationContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_REPEAT_PAYMENT_CLICKED, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
            this.f54330a.j();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54331a;

        h(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54331a = moneyTransferPostTransactionActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransfer.utils.f.a(this.f54331a.getApplicationContext(), "mt_p2p_new_v1", "share_clicked", CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
            if (this.f54331a.y) {
                MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this.f54331a;
                Context context = moneyTransferPostTransactionActivity;
                String c2 = moneyTransferPostTransactionActivity.n;
                if (c2 == null) {
                    c2 = "";
                }
                CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, Events.Category.COLLECT, "share_clicked", "", "", "", c2, "", Events.Screen.POST_TRANSACTION, "");
            }
            this.f54331a.e();
        }
    }

    private final void e(UpiBaseDataModel upiBaseDataModel) {
        if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel;
            CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
            kotlin.g.b.k.a((Object) extraInfoDataModel, "dataModel.extraInfoDataModel");
            if (p.a(extraInfoDataModel.getTransferType(), "neft", true)) {
                TextView textView = (TextView) a(R.id.tv_failure_msg);
                kotlin.g.b.k.a((Object) textView, "tv_failure_msg");
                textView.setText(cJRMoneyTransferIMPSInitiateDataModel.getMessage());
                if (!TextUtils.isEmpty(cJRMoneyTransferIMPSInitiateDataModel.getRrn()) && cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel() != null) {
                    this.U = cJRMoneyTransferIMPSInitiateDataModel.getRrn();
                    TextView textView2 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView2, "order_id_tv");
                    textView2.setText(getString(R.string.mt_neft_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                    TextView textView3 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView3, "order_id_tv");
                    textView3.setVisibility(0);
                }
                TextView textView4 = (TextView) a(R.id.date_time_tv);
                kotlin.g.b.k.a((Object) textView4, "date_time_tv");
                textView4.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
                ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.error_layout);
                kotlin.g.b.k.a((Object) constraintLayout, "error_layout");
                constraintLayout.setVisibility(0);
                return;
            }
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.error_layout);
        kotlin.g.b.k.a((Object) constraintLayout2, "error_layout");
        constraintLayout2.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void f(net.one97.paytm.upi.common.UpiBaseDataModel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "pending"
            r8.g((java.lang.String) r0)
            r1 = r8
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = r8
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.moneytransfer.R.color.color_ffa400
            int r3 = androidx.core.content.b.c(r2, r3)
            com.paytm.utility.b.a((android.app.Activity) r1, (int) r3)
            int r1 = net.one97.paytm.moneytransfer.R.id.status_shimmer_layout
            android.view.View r1 = r8.a((int) r1)
            net.one97.paytm.moneytransfer.utils.MoneyTransferShimmerAnimationLayout r1 = (net.one97.paytm.moneytransfer.utils.MoneyTransferShimmerAnimationLayout) r1
            int r3 = net.one97.paytm.moneytransfer.R.color.color_ffa400
            int r3 = androidx.core.content.b.c(r2, r3)
            r1.setBackgroundColor(r3)
            r8.s()
            int r1 = net.one97.paytm.moneytransfer.R.id.status_image
            android.view.View r1 = r8.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r3 = "status_image"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r3 = 0
            r1.setVisibility(r3)
            int r1 = net.one97.paytm.moneytransfer.R.id.status_image_anim_view
            android.view.View r1 = r8.a((int) r1)
            com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
            java.lang.String r4 = "status_image_anim_view"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r4 = 8
            r1.setVisibility(r4)
            int r1 = net.one97.paytm.moneytransfer.R.id.status_image
            android.view.View r1 = r8.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r5 = net.one97.paytm.moneytransfer.R.drawable.mt_pending_new
            android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r2, (int) r5)
            r1.setImageDrawable(r5)
            int r1 = net.one97.paytm.moneytransfer.R.id.actions_group
            android.view.View r1 = r8.a((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            java.lang.String r5 = "actions_group"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setVisibility(r4)
            int r1 = net.one97.paytm.moneytransfer.R.id.iv_share
            android.view.View r1 = r8.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r5 = "iv_share"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setVisibility(r4)
            int r1 = net.one97.paytm.moneytransfer.R.id.error_layout
            android.view.View r1 = r8.a((int) r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            java.lang.String r5 = "error_layout"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setVisibility(r3)
            int r1 = net.one97.paytm.moneytransfer.R.id.timeline_layout
            android.view.View r1 = r8.a((int) r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            java.lang.String r5 = "timeline_layout"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setVisibility(r4)
            boolean r1 = r9 instanceof net.one97.paytm.upi.common.upi.BaseUpiResponse
            java.lang.String r5 = "tv_failure_msg"
            java.lang.String r6 = "order_id_tv"
            if (r1 == 0) goto L_0x0123
            int r7 = net.one97.paytm.moneytransfer.R.id.tv_failure_msg
            android.view.View r7 = r8.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            int r5 = net.one97.paytm.moneytransfer.R.string.mt_post_paymnt_pending_text
            java.lang.String r5 = r8.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7.setText(r5)
            r5 = r9
            net.one97.paytm.upi.common.upi.BaseUpiResponse r5 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r5
            java.lang.String r7 = r5.getBankRRN()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0110
            int r4 = net.one97.paytm.moneytransfer.R.id.order_id_tv
            android.view.View r4 = r8.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r4.setVisibility(r3)
            java.lang.String r3 = r5.getBankRRN()
            r8.U = r3
            int r3 = net.one97.paytm.moneytransfer.R.id.order_id_tv
            android.view.View r3 = r8.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r6 = net.one97.paytm.moneytransfer.R.string.money_transfer_upi_ref_no
            java.lang.String r6 = r8.getString(r6)
            r4.append(r6)
            java.lang.String r6 = " "
            r4.append(r6)
            java.lang.String r5 = r5.getBankRRN()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x011e
        L_0x0110:
            int r3 = net.one97.paytm.moneytransfer.R.id.order_id_tv
            android.view.View r3 = r8.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            r3.setVisibility(r4)
        L_0x011e:
            r3 = 2
            r8.b((int) r3)
            goto L_0x0175
        L_0x0123:
            boolean r4 = r9 instanceof net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel
            if (r4 == 0) goto L_0x0183
            int r4 = net.one97.paytm.moneytransfer.R.id.tv_failure_msg
            android.view.View r4 = r8.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = r9
            net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel r5 = (net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel) r5
            java.lang.String r7 = r5.getMessage()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r4.setText(r7)
            java.lang.String r4 = r5.getRrn()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0175
            net.one97.paytm.common.entity.wallet.CJRIMPSInitiateExtraInfoDataModel r4 = r5.getExtraInfoDataModel()
            if (r4 == 0) goto L_0x0175
            java.lang.String r4 = r5.getRrn()
            r8.U = r4
            int r4 = net.one97.paytm.moneytransfer.R.id.order_id_tv
            android.view.View r4 = r8.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            int r6 = net.one97.paytm.moneytransfer.R.string.mt_reference_id
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r5 = r5.getRrn()
            r7[r3] = r5
            java.lang.String r3 = r8.getString(r6, r7)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4.setText(r3)
        L_0x0175:
            java.lang.String r3 = "mt_p2p_new_v1"
            java.lang.String r4 = "txn_status"
            java.lang.String r5 = "/mt_p2p_post-transaction"
            java.lang.String r6 = "pending"
            java.lang.String r7 = ""
            net.one97.paytm.moneytransfer.utils.f.a(r2, r3, r4, r5, r6, r7)
        L_0x0183:
            int r2 = net.one97.paytm.moneytransfer.R.id.date_time_tv
            android.view.View r2 = r8.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "date_time_tv"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "hh:mm a, dd MMM yyyy"
            java.lang.String r3 = com.paytm.utility.b.a((java.lang.Long) r3, (java.lang.String) r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            r8.f((java.lang.String) r0)
            boolean r0 = r8.E
            if (r0 == 0) goto L_0x01ad
            r8.b((net.one97.paytm.upi.common.UpiBaseDataModel) r9)
        L_0x01ad:
            boolean r0 = r8.F
            if (r0 == 0) goto L_0x01c0
            if (r1 == 0) goto L_0x01b7
            r8.h()
            return
        L_0x01b7:
            boolean r0 = r9 instanceof net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel
            if (r0 == 0) goto L_0x01c0
            net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel r9 = (net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel) r9
            r8.a((net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel) r9)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.f(net.one97.paytm.upi.common.UpiBaseDataModel):void");
    }

    private final void g(UpiBaseDataModel upiBaseDataModel) {
        g(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
        Context context = this;
        com.paytm.utility.b.a((Activity) this, androidx.core.content.b.c(context, R.color.color_fd5c5c));
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).setBackgroundColor(androidx.core.content.b.c(context, R.color.color_fd5c5c));
        t();
        ImageView imageView = (ImageView) a(R.id.status_image);
        kotlin.g.b.k.a((Object) imageView, "status_image");
        imageView.setVisibility(0);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.status_image_anim_view);
        kotlin.g.b.k.a((Object) lottieAnimationView, "status_image_anim_view");
        lottieAnimationView.setVisibility(8);
        ((ImageView) a(R.id.status_image)).setImageDrawable(androidx.core.content.b.a(context, R.drawable.mt_failed_new));
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.timeline_layout);
        kotlin.g.b.k.a((Object) constraintLayout, "timeline_layout");
        constraintLayout.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) a(R.id.actions_group);
        kotlin.g.b.k.a((Object) linearLayout, "actions_group");
        linearLayout.setVisibility(8);
        ImageView imageView2 = (ImageView) a(R.id.iv_share);
        kotlin.g.b.k.a((Object) imageView2, "iv_share");
        imageView2.setVisibility(8);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.error_layout);
        kotlin.g.b.k.a((Object) constraintLayout2, "error_layout");
        constraintLayout2.setVisibility(0);
        boolean z2 = upiBaseDataModel instanceof BaseUpiResponse;
        if (z2) {
            if (this.f54310d == null || !f()) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                e(baseUpiResponse);
                TextView textView = (TextView) a(R.id.tv_failure_msg);
                kotlin.g.b.k.a((Object) textView, "tv_failure_msg");
                textView.setText(baseUpiResponse.getMessage());
                if (!TextUtils.isEmpty(baseUpiResponse.getBankRRN())) {
                    TextView textView2 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView2, "order_id_tv");
                    textView2.setVisibility(0);
                    this.U = baseUpiResponse.getBankRRN();
                    TextView textView3 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView3, "order_id_tv");
                    textView3.setText(getString(R.string.money_transfer_upi_ref_no) + " " + baseUpiResponse.getBankRRN());
                } else {
                    TextView textView4 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView4, "order_id_tv");
                    textView4.setVisibility(8);
                }
            } else {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.error_layout);
                kotlin.g.b.k.a((Object) constraintLayout3, "error_layout");
                constraintLayout3.setVisibility(8);
                ConstraintLayout constraintLayout4 = (ConstraintLayout) a(R.id.timeline_layout);
                kotlin.g.b.k.a((Object) constraintLayout4, "timeline_layout");
                constraintLayout4.setVisibility(0);
                i();
            }
            b(3);
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_TXN_STATUS, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, "");
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_MESSSAGE, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, ((BaseUpiResponse) upiBaseDataModel).getResponse(), "");
        } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            TextView textView5 = (TextView) a(R.id.tv_failure_msg);
            kotlin.g.b.k.a((Object) textView5, "tv_failure_msg");
            CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel;
            textView5.setText(cJRMoneyTransferIMPSInitiateDataModel.getMessage());
            if (!TextUtils.isEmpty(cJRMoneyTransferIMPSInitiateDataModel.getRrn())) {
                this.U = cJRMoneyTransferIMPSInitiateDataModel.getRrn();
                CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
                kotlin.g.b.k.a((Object) extraInfoDataModel, "dataModel.extraInfoDataModel");
                if (p.a(extraInfoDataModel.getTransferType(), "neft", true)) {
                    TextView textView6 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView6, "order_id_tv");
                    textView6.setText(getString(R.string.mt_neft_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                } else {
                    TextView textView7 = (TextView) a(R.id.order_id_tv);
                    kotlin.g.b.k.a((Object) textView7, "order_id_tv");
                    textView7.setText(getString(R.string.mt_imps_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                }
            }
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_TXN_STATUS, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE, "");
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_MESSSAGE, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, String.valueOf(cJRMoneyTransferIMPSInitiateDataModel.getResponse_code()), "");
        }
        f(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
        TextView textView8 = (TextView) a(R.id.date_time_tv);
        kotlin.g.b.k.a((Object) textView8, "date_time_tv");
        textView8.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
        if (!this.F) {
            return;
        }
        if (z2) {
            a(this.f54310d, (BaseUpiResponse) upiBaseDataModel);
        } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            a((CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel);
        }
    }

    private final void d(BaseUpiResponse baseUpiResponse) {
        Context context = this;
        com.paytm.utility.b.a((Activity) this, androidx.core.content.b.c(context, R.color.color_ffa400));
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).setBackgroundColor(androidx.core.content.b.c(context, R.color.color_ffa400));
        s();
        ImageView imageView = (ImageView) a(R.id.status_image);
        kotlin.g.b.k.a((Object) imageView, "status_image");
        imageView.setVisibility(0);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.status_image_anim_view);
        kotlin.g.b.k.a((Object) lottieAnimationView, "status_image_anim_view");
        lottieAnimationView.setVisibility(8);
        ((ImageView) a(R.id.status_image)).setImageDrawable(androidx.core.content.b.a(context, R.drawable.mt_pending_new));
        LinearLayout linearLayout = (LinearLayout) a(R.id.actions_group);
        kotlin.g.b.k.a((Object) linearLayout, "actions_group");
        linearLayout.setVisibility(8);
        ImageView imageView2 = (ImageView) a(R.id.iv_share);
        kotlin.g.b.k.a((Object) imageView2, "iv_share");
        imageView2.setVisibility(8);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.error_layout);
        kotlin.g.b.k.a((Object) constraintLayout, "error_layout");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.timeline_layout);
        kotlin.g.b.k.a((Object) constraintLayout2, "timeline_layout");
        constraintLayout2.setVisibility(0);
        i();
        b(4);
        net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_TXN_STATUS, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "deemed", "");
        f("deemed");
        if (this.F) {
            a(this.f54310d, baseUpiResponse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i() {
        /*
            r11 = this;
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            r1 = 0
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getImportantNote()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 != 0) goto L_0x0073
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_message_text
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "tv_message_text"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r3 = net.one97.paytm.moneytransfer.R.string.upi_important
            java.lang.String r3 = r11.getString(r3)
            r0.append(r3)
            java.lang.String r3 = " "
            r0.append(r3)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x004d
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = r3.getImportantNote()
            goto L_0x004e
        L_0x004d:
            r3 = r1
        L_0x004e:
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            int r3 = d((java.lang.String) r0)
            r4 = r11
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.moneytransfer.R.color.color_ffa400
            int r4 = androidx.core.content.b.c(r4, r5)
            android.text.Spannable r0 = a((java.lang.String) r0, (int) r3, (int) r4)
            int r3 = net.one97.paytm.moneytransfer.R.id.tv_message_text
            android.view.View r3 = r11.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
        L_0x0073:
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x008c
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x008c
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x008c
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x008d
        L_0x008c:
            r0 = r1
        L_0x008d:
            java.lang.String r3 = "tv_timeline_2"
            java.lang.String r4 = "timeline_group_2"
            java.lang.String r5 = "tv_timeline_1"
            java.lang.String r6 = "timeline_group_1"
            r7 = 2
            r8 = 1
            if (r0 != 0) goto L_0x009f
            goto L_0x0288
        L_0x009f:
            int r9 = r0.intValue()
            r10 = 3
            if (r9 != r10) goto L_0x0288
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x00c3
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x00c3
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x00c3
            java.lang.Object r0 = r0.get(r7)
            net.one97.paytm.upi.common.upi.PassbookTimeline r0 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r0
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = r0.getMessage()
            goto L_0x00c4
        L_0x00c3:
            r0 = r1
        L_0x00c4:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x014b
            int r0 = net.one97.paytm.moneytransfer.R.id.timeline_group_3
            android.view.View r0 = r11.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            java.lang.String r9 = "timeline_group_3"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_timeline_3
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r9 = "tv_timeline_3"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r9 = r11.f54310d
            if (r9 == 0) goto L_0x0108
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r9 = r9.getDetails()
            if (r9 == 0) goto L_0x0108
            java.util.ArrayList r9 = r9.getTimeline()
            if (r9 == 0) goto L_0x0108
            java.lang.Object r9 = r9.get(r7)
            net.one97.paytm.upi.common.upi.PassbookTimeline r9 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r9
            if (r9 == 0) goto L_0x0108
            java.lang.String r9 = r9.getMessage()
            goto L_0x0109
        L_0x0108:
            r9 = r1
        L_0x0109:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r9 = r11.f54310d
            if (r9 == 0) goto L_0x012f
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r9 = r9.getDetails()
            if (r9 == 0) goto L_0x012f
            java.util.ArrayList r9 = r9.getTimeline()
            if (r9 == 0) goto L_0x012f
            java.lang.Object r7 = r9.get(r7)
            net.one97.paytm.upi.common.upi.PassbookTimeline r7 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r7
            if (r7 == 0) goto L_0x012f
            java.lang.String r7 = r7.getImageurl()
            goto L_0x0130
        L_0x012f:
            r7 = r1
        L_0x0130:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r7)
            int r7 = net.one97.paytm.moneytransfer.R.drawable.ic_pending_copy
            com.squareup.picasso.aa r0 = r0.b((int) r7)
            int r7 = net.one97.paytm.moneytransfer.R.drawable.ic_pending_copy
            com.squareup.picasso.aa r0 = r0.a((int) r7)
            int r7 = net.one97.paytm.moneytransfer.R.id.iv_timeline_3
            android.view.View r7 = r11.a((int) r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r0.a((android.widget.ImageView) r7)
        L_0x014b:
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x0168
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x0168
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x0168
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.upi.common.upi.PassbookTimeline r0 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r0
            if (r0 == 0) goto L_0x0168
            java.lang.String r0 = r0.getMessage()
            goto L_0x0169
        L_0x0168:
            r0 = r1
        L_0x0169:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01ea
            int r0 = net.one97.paytm.moneytransfer.R.id.timeline_group_2
            android.view.View r0 = r11.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_timeline_2
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x01a7
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x01a7
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x01a7
            java.lang.Object r3 = r3.get(r8)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x01a7
            java.lang.String r3 = r3.getMessage()
            goto L_0x01a8
        L_0x01a7:
            r3 = r1
        L_0x01a8:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x01ce
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x01ce
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x01ce
            java.lang.Object r3 = r3.get(r8)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x01ce
            java.lang.String r3 = r3.getImageurl()
            goto L_0x01cf
        L_0x01ce:
            r3 = r1
        L_0x01cf:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r3)
            int r3 = net.one97.paytm.moneytransfer.R.drawable.ic_pending_copy
            com.squareup.picasso.aa r0 = r0.b((int) r3)
            int r3 = net.one97.paytm.moneytransfer.R.drawable.ic_pending_copy
            com.squareup.picasso.aa r0 = r0.a((int) r3)
            int r3 = net.one97.paytm.moneytransfer.R.id.iv_timeline_2
            android.view.View r3 = r11.a((int) r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0.a((android.widget.ImageView) r3)
        L_0x01ea:
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x0207
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x0207
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x0207
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r0 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r0
            if (r0 == 0) goto L_0x0207
            java.lang.String r0 = r0.getMessage()
            goto L_0x0208
        L_0x0207:
            r0 = r1
        L_0x0208:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0475
            int r0 = net.one97.paytm.moneytransfer.R.id.timeline_group_1
            android.view.View r0 = r11.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_timeline_1
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x0246
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x0246
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x0246
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x0246
            java.lang.String r3 = r3.getMessage()
            goto L_0x0247
        L_0x0246:
            r3 = r1
        L_0x0247:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x026c
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x026c
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x026c
            java.lang.Object r2 = r3.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r2 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r2
            if (r2 == 0) goto L_0x026c
            java.lang.String r1 = r2.getImageurl()
        L_0x026c:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_tick
            com.squareup.picasso.aa r0 = r0.b((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_tick
            com.squareup.picasso.aa r0 = r0.a((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.id.iv_timeline_1
            android.view.View r1 = r11.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a((android.widget.ImageView) r1)
            return
        L_0x0288:
            if (r0 != 0) goto L_0x028c
            goto L_0x03cf
        L_0x028c:
            int r9 = r0.intValue()
            if (r9 != r7) goto L_0x03cf
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x02af
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x02af
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x02af
            java.lang.Object r0 = r0.get(r8)
            net.one97.paytm.upi.common.upi.PassbookTimeline r0 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r0
            if (r0 == 0) goto L_0x02af
            java.lang.String r0 = r0.getMessage()
            goto L_0x02b0
        L_0x02af:
            r0 = r1
        L_0x02b0:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0331
            int r0 = net.one97.paytm.moneytransfer.R.id.timeline_group_2
            android.view.View r0 = r11.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_timeline_2
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x02ee
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x02ee
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x02ee
            java.lang.Object r3 = r3.get(r8)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x02ee
            java.lang.String r3 = r3.getMessage()
            goto L_0x02ef
        L_0x02ee:
            r3 = r1
        L_0x02ef:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x0315
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x0315
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x0315
            java.lang.Object r3 = r3.get(r8)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x0315
            java.lang.String r3 = r3.getImageurl()
            goto L_0x0316
        L_0x0315:
            r3 = r1
        L_0x0316:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r3)
            int r3 = net.one97.paytm.moneytransfer.R.drawable.ic_pending_copy
            com.squareup.picasso.aa r0 = r0.b((int) r3)
            int r3 = net.one97.paytm.moneytransfer.R.drawable.ic_pending_copy
            com.squareup.picasso.aa r0 = r0.a((int) r3)
            int r3 = net.one97.paytm.moneytransfer.R.id.iv_timeline_2
            android.view.View r3 = r11.a((int) r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0.a((android.widget.ImageView) r3)
        L_0x0331:
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x034e
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x034e
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x034e
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r0 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r0
            if (r0 == 0) goto L_0x034e
            java.lang.String r0 = r0.getMessage()
            goto L_0x034f
        L_0x034e:
            r0 = r1
        L_0x034f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0475
            int r0 = net.one97.paytm.moneytransfer.R.id.timeline_group_1
            android.view.View r0 = r11.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_timeline_1
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x038d
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x038d
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x038d
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x038d
            java.lang.String r3 = r3.getMessage()
            goto L_0x038e
        L_0x038d:
            r3 = r1
        L_0x038e:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x03b3
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x03b3
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x03b3
            java.lang.Object r2 = r3.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r2 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r2
            if (r2 == 0) goto L_0x03b3
            java.lang.String r1 = r2.getImageurl()
        L_0x03b3:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_tick
            com.squareup.picasso.aa r0 = r0.b((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_tick
            com.squareup.picasso.aa r0 = r0.a((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.id.iv_timeline_1
            android.view.View r1 = r11.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a((android.widget.ImageView) r1)
            return
        L_0x03cf:
            if (r0 != 0) goto L_0x03d2
            return
        L_0x03d2:
            int r0 = r0.intValue()
            if (r0 != r8) goto L_0x0475
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r0 = r11.f54310d
            if (r0 == 0) goto L_0x03f5
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r0 = r0.getDetails()
            if (r0 == 0) goto L_0x03f5
            java.util.ArrayList r0 = r0.getTimeline()
            if (r0 == 0) goto L_0x03f5
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r0 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r0
            if (r0 == 0) goto L_0x03f5
            java.lang.String r0 = r0.getMessage()
            goto L_0x03f6
        L_0x03f5:
            r0 = r1
        L_0x03f6:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0475
            int r0 = net.one97.paytm.moneytransfer.R.id.timeline_group_1
            android.view.View r0 = r11.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.moneytransfer.R.id.tv_timeline_1
            android.view.View r0 = r11.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x0434
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x0434
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x0434
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r3 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r3
            if (r3 == 0) goto L_0x0434
            java.lang.String r3 = r3.getMessage()
            goto L_0x0435
        L_0x0434:
            r3 = r1
        L_0x0435:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel r3 = r11.f54310d
            if (r3 == 0) goto L_0x045a
            net.one97.paytm.upi.common.upi.UpiTransactionStatusModel$TransactionStatus r3 = r3.getDetails()
            if (r3 == 0) goto L_0x045a
            java.util.ArrayList r3 = r3.getTimeline()
            if (r3 == 0) goto L_0x045a
            java.lang.Object r2 = r3.get(r2)
            net.one97.paytm.upi.common.upi.PassbookTimeline r2 = (net.one97.paytm.upi.common.upi.PassbookTimeline) r2
            if (r2 == 0) goto L_0x045a
            java.lang.String r1 = r2.getImageurl()
        L_0x045a:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_tick
            com.squareup.picasso.aa r0 = r0.b((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.drawable.ic_tick
            com.squareup.picasso.aa r0 = r0.a((int) r1)
            int r1 = net.one97.paytm.moneytransfer.R.id.iv_timeline_1
            android.view.View r1 = r11.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.a((android.widget.ImageView) r1)
        L_0x0475:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.i():void");
    }

    private final void e(BaseUpiResponse baseUpiResponse) {
        View.OnClickListener onClickListener = this;
        ((TextView) a(R.id.tvReenterMpin)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.tvForgotMpin)).setOnClickListener(onClickListener);
        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
        String a2 = net.one97.paytm.moneytransfer.d.c.a(c.a.a().f53988c);
        if (!TextUtils.isEmpty(baseUpiResponse.getResponse())) {
            CharSequence charSequence = a2;
            if (!TextUtils.isEmpty(charSequence)) {
                String response = baseUpiResponse.getResponse();
                kotlin.g.b.k.a((Object) response, "baseUpiResponse.getResponse()");
                if (!p.a(charSequence, (CharSequence) response, false)) {
                    TextView textView = (TextView) a(R.id.tvReenterMpin);
                    kotlin.g.b.k.a((Object) textView, "tvReenterMpin");
                    textView.setVisibility(0);
                    TextView textView2 = (TextView) a(R.id.tvReenterMpin);
                    kotlin.g.b.k.a((Object) textView2, "tvReenterMpin");
                    textView2.setText(getString(R.string.retry));
                    this.J = "retry_button_loaded_yes";
                }
            }
            if (baseUpiResponse.getResponse().equals(H5BridgeContext.INVALID_ID) || baseUpiResponse.getResponse().equals(UpiConstants.NETWORK_ERROR_CODE)) {
                TextView textView3 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView3, "tvReenterMpin");
                textView3.setVisibility(0);
                TextView textView4 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView4, "tvReenterMpin");
                textView4.setText(getString(R.string.retry));
                this.J = "retry_button_loaded_yes";
            }
            String response2 = baseUpiResponse.getResponse();
            kotlin.g.b.k.a((Object) response2, "baseUpiResponse.getResponse()");
            if (p.a((CharSequence) response2, (CharSequence) "ZM", false) && !this.y && !this.A) {
                TextView textView5 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView5, "tvReenterMpin");
                textView5.setVisibility(0);
                TextView textView6 = (TextView) a(R.id.tvForgotMpin);
                kotlin.g.b.k.a((Object) textView6, "tvForgotMpin");
                textView6.setVisibility(0);
            }
            String response3 = baseUpiResponse.getResponse();
            kotlin.g.b.k.a((Object) response3, "baseUpiResponse.getResponse()");
            if ((p.a((CharSequence) response3, (CharSequence) "Z9", false) || p.a(baseUpiResponse.getResponse(), "U30-51", true)) && !this.y && !this.A) {
                TextView textView7 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView7, "tvReenterMpin");
                textView7.setVisibility(0);
                TextView textView8 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView8, "tvReenterMpin");
                textView8.setText(getString(R.string.money_transfer_check_acc_bal));
                TextView textView9 = (TextView) a(R.id.tvForgotMpin);
                kotlin.g.b.k.a((Object) textView9, "tvForgotMpin");
                textView9.setVisibility(0);
                TextView textView10 = (TextView) a(R.id.tvForgotMpin);
                kotlin.g.b.k.a((Object) textView10, "tvForgotMpin");
                textView10.setText(getString(R.string.money_transfer_use_other_bank));
            }
            String response4 = baseUpiResponse.getResponse();
            kotlin.g.b.k.a((Object) response4, "baseUpiResponse.getResponse()");
            if (p.a((CharSequence) response4, (CharSequence) "AM", false) && !this.y && !this.A) {
                TextView textView11 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView11, "tvReenterMpin");
                textView11.setVisibility(0);
                TextView textView12 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView12, "tvReenterMpin");
                textView12.setText(getString(R.string.upi_set_mpin));
            }
            String response5 = baseUpiResponse.getResponse();
            kotlin.g.b.k.a((Object) response5, "baseUpiResponse.getResponse()");
            if (p.a((CharSequence) response5, (CharSequence) "Z6", false) && !this.y && !this.A) {
                TextView textView13 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView13, "tvReenterMpin");
                textView13.setVisibility(0);
                TextView textView14 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView14, "tvReenterMpin");
                textView14.setText(getString(R.string.money_transfer_dont_know_your_upi_pin));
            }
            if (!p.a(baseUpiResponse.getResponse(), "INT-1460", true) && !p.a(baseUpiResponse.getResponse(), "INT-1461", true) && !p.a(baseUpiResponse.getResponse(), "INT-1204", true)) {
                String response6 = baseUpiResponse.getResponse();
                kotlin.g.b.k.a((Object) response6, "baseUpiResponse.getResponse()");
                if (!p.a((CharSequence) response6, (CharSequence) "U16", false)) {
                    return;
                }
            }
            UpiProfileDefaultBank upiProfileDefaultBank = this.s;
            if (upiProfileDefaultBank != null) {
                if (upiProfileDefaultBank == null) {
                    kotlin.g.b.k.a();
                }
                BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
                kotlin.g.b.k.a((Object) debitBank, "mSelectedVpaSource!!.getDebitBank()");
                if (p.a("PYTM0123456", debitBank.getIfsc(), true) && this.G == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
                    TextView textView15 = (TextView) a(R.id.tvReenterMpin);
                    kotlin.g.b.k.a((Object) textView15, "tvReenterMpin");
                    textView15.setVisibility(0);
                    TextView textView16 = (TextView) a(R.id.tvReenterMpin);
                    kotlin.g.b.k.a((Object) textView16, "tvReenterMpin");
                    textView16.setText(getString(R.string.money_transfer_send_money_using_imps));
                    TextView textView17 = (TextView) a(R.id.tv_failure_msg);
                    kotlin.g.b.k.a((Object) textView17, "tv_failure_msg");
                    StringBuilder sb = new StringBuilder();
                    TextView textView18 = (TextView) a(R.id.tv_failure_msg);
                    kotlin.g.b.k.a((Object) textView18, "tv_failure_msg");
                    sb.append(textView18.getText().toString());
                    sb.append("\n\n");
                    sb.append(getString(R.string.money_transfer_still_transfer_at_0_percent));
                    textView17.setText(sb.toString());
                    return;
                }
            }
            TextView textView19 = (TextView) a(R.id.tvReenterMpin);
            kotlin.g.b.k.a((Object) textView19, "tvReenterMpin");
            textView19.setVisibility(0);
            TextView textView20 = (TextView) a(R.id.tvReenterMpin);
            kotlin.g.b.k.a((Object) textView20, "tvReenterMpin");
            textView20.setText(getString(R.string.money_transfer_add_bank_account));
        }
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.tvForgotMpin) {
            TextView textView = (TextView) a(R.id.tvForgotMpin);
            kotlin.g.b.k.a((Object) textView, "tvForgotMpin");
            if (p.a(textView.getText().toString(), getString(R.string.money_transfer_use_other_bank), true)) {
                net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_ACTION, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "try_with_lower_amount", "");
                j();
                return;
            }
            UpiProfileDefaultBank upiProfileDefaultBank = this.s;
            if (upiProfileDefaultBank == null) {
                kotlin.g.b.k.a();
            }
            a(upiProfileDefaultBank, false);
            Context context = this;
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_ACTION, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, CJRGTMConstants.MT_V4_RESET_UPI_PIN, "");
            net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        } else if (view != null && view.getId() == R.id.tvReenterMpin) {
            TextView textView2 = (TextView) a(R.id.tvReenterMpin);
            kotlin.g.b.k.a((Object) textView2, "tvReenterMpin");
            if (p.a(textView2.getText().toString(), getString(R.string.money_transfer_check_acc_bal), true)) {
                net.one97.paytm.moneytransfer.presenter.d dVar = this.f54308b;
                if (dVar != null) {
                    dVar.a(this.s);
                    return;
                }
                return;
            }
            TextView textView3 = (TextView) a(R.id.tvReenterMpin);
            kotlin.g.b.k.a((Object) textView3, "tvReenterMpin");
            if (!p.a(textView3.getText().toString(), getString(R.string.retry), true)) {
                TextView textView4 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView4, "tvReenterMpin");
                if (p.a(textView4.getText().toString(), getString(R.string.upi_set_mpin), true)) {
                    UpiProfileDefaultBank upiProfileDefaultBank2 = this.s;
                    if (upiProfileDefaultBank2 == null) {
                        kotlin.g.b.k.a();
                    }
                    a(upiProfileDefaultBank2, false);
                    net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_ACTION, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, CJRGTMConstants.MT_V4_SET_UPI_PIN, "");
                    return;
                }
                TextView textView5 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView5, "tvReenterMpin");
                if (p.a(textView5.getText().toString(), getString(R.string.money_transfer_dont_know_your_upi_pin), true)) {
                    UpiProfileDefaultBank upiProfileDefaultBank3 = this.s;
                    if (upiProfileDefaultBank3 == null) {
                        kotlin.g.b.k.a();
                    }
                    a(upiProfileDefaultBank3, false);
                    net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_ACTION, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, CJRGTMConstants.MT_V4_RESET_UPI_PIN, "");
                    return;
                }
                TextView textView6 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView6, "tvReenterMpin");
                if (p.a(textView6.getText().toString(), getString(R.string.money_transfer_send_money_using_imps), true)) {
                    m();
                    return;
                }
                TextView textView7 = (TextView) a(R.id.tvReenterMpin);
                kotlin.g.b.k.a((Object) textView7, "tvReenterMpin");
                if (!p.a(textView7.getText().toString(), getString(R.string.money_transfer_add_bank_account), true)) {
                    TextView textView8 = (TextView) a(R.id.tvReenterMpin);
                    kotlin.g.b.k.a((Object) textView8, "tvReenterMpin");
                    if (p.a(textView8.getText().toString(), getString(R.string.money_transfer_re_enter_upi_pin), true)) {
                        net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_ACTION, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "UPI_pin_reentered", "");
                        k();
                        net.one97.paytm.moneytransfer.presenter.d dVar2 = this.f54308b;
                        if (dVar2 != null) {
                            dVar2.a();
                        }
                    }
                } else if (this.s != null) {
                    net.one97.paytm.moneytransfer.presenter.d dVar3 = this.f54308b;
                    if (dVar3 != null ? dVar3.b() : false) {
                        AccountProviderActivity.a((Activity) this, 31);
                    } else {
                        b_(0);
                    }
                }
            } else if (!this.C || TextUtils.isEmpty(this.j)) {
                j();
            } else {
                c();
                String str = this.j;
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                c(str);
            }
        } else if (view != null && view.getId() == R.id.check_balance_tv) {
            D();
            net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_POST_TRANSACTION_ERROR_ACTION, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "check_balance_clicked", "");
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10) {
            MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this;
            if (i3 == -1) {
                moneyTransferPostTransactionActivity.k();
                net.one97.paytm.moneytransfer.presenter.d dVar = moneyTransferPostTransactionActivity.f54308b;
                if (dVar != null) {
                    dVar.a();
                }
            }
        } else if (i2 == 31) {
            MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity2 = this;
            if (i3 == -1 && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
                if (serializableExtra != null) {
                    AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                    net.one97.paytm.moneytransfer.presenter.d dVar2 = moneyTransferPostTransactionActivity2.f54308b;
                    if (dVar2 != null) {
                        dVar2.a(accountProvider);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
            }
        } else if (i2 == 34) {
            MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity3 = this;
            if (i3 == -1) {
                moneyTransferPostTransactionActivity3.j();
            }
        } else if (i2 == 3333) {
            if (i3 == -1 && intent != null) {
                Serializable serializableExtra2 = intent.getSerializableExtra("imps_data");
                if (serializableExtra2 != null) {
                    this.f54309c = (CJRMoneyTransferIMPSInitiateDataModel) serializableExtra2;
                    g();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
            }
        } else if (i2 == 4444) {
            if (i3 == -1) {
                m();
            }
        } else if (i2 == 1004) {
            if (i3 == -1) {
                finish();
            }
        } else if (i2 == 80) {
            if (i3 == -1) {
                b(this.v);
            } else {
                j();
            }
        } else if (i2 == 2020 && i3 != 0 && i3 == -1 && intent != null && intent.hasExtra("verifier_imps_data")) {
            Serializable serializableExtra3 = intent.getSerializableExtra("verifier_imps_data");
            if (serializableExtra3 != null) {
                this.f54309c = (CJRMoneyTransferIMPSInitiateDataModel) serializableExtra3;
                g();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        String str;
        if (UpiAppUtils.checkIsVpa(this.f54315i)) {
            StringBuilder sb = new StringBuilder();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            sb.append(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b());
            sb.append("&pa=");
            sb.append(this.f54315i);
            sb.append("&pn=");
            sb.append(this.f54312f);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            sb2.append(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b());
            sb2.append("&account=");
            sb2.append(this.f54315i);
            sb2.append("&pn=");
            sb2.append(this.f54312f);
            sb2.append("&ifsc=");
            sb2.append(this.p);
            str = sb2.toString();
            if (!TextUtils.isEmpty(this.k)) {
                str = str + "&bank_name=" + this.k;
            }
        }
        d.a aVar3 = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Context) this, str);
        finish();
    }

    private final void k() {
        this.f54311e = UpiUtils.convertToTwoPlaces(this.f54311e);
        if (!this.y) {
            this.j = UpiUtils.getUpiSequenceNo();
        }
    }

    private final void l() {
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        androidx.fragment.app.q qVar = null;
        androidx.fragment.app.q a2 = supportFragmentManager != null ? supportFragmentManager.a() : null;
        kotlin.g.b.k.a((Object) a2, "supportFragmentManager?.beginTransaction()");
        androidx.fragment.app.j supportFragmentManager2 = getSupportFragmentManager();
        if (supportFragmentManager2 != null) {
            qVar = supportFragmentManager2.a();
        }
        kotlin.g.b.k.a((Object) qVar, "supportFragmentManager?.beginTransaction()");
        if (a2 != null) {
            int i2 = R.id.fragment_cta_actions;
            p.a aVar = net.one97.paytm.moneytransfer.view.fragments.p.f54593a;
            androidx.fragment.app.q b2 = a2.b(i2, p.a.a(this.f54309c, this.p, this.f54315i, this.I, this.y, this.V));
            if (b2 != null) {
                b2.c();
            }
        }
        if (qVar != null) {
            int i3 = R.id.fragment_invite_now;
            MoneyTransferInviteFragment.a aVar2 = MoneyTransferInviteFragment.f54386a;
            boolean z2 = this.y;
            boolean z3 = this.I;
            String str = this.n;
            if (str == null) {
                str = "";
            }
            androidx.fragment.app.q b3 = qVar.b(i3, MoneyTransferInviteFragment.a.a(z2, z3, str));
            if (b3 != null) {
                b3.c();
            }
        }
    }

    public final void a(String str) {
        String str2;
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.CredsAllowed credsAllowed;
        BankAccountDetails.BankAccount debitBank3;
        String virtualAddress;
        BankAccountDetails.BankAccount debitBank4;
        BankAccountDetails.BankAccount debitBank5;
        BankAccountDetails.CredsAllowed credsAllowed2;
        BankAccountDetails.BankAccount debitBank6;
        boolean z2 = this.y;
        if (z2) {
            net.one97.paytm.moneytransfer.presenter.d dVar = this.f54308b;
            if (dVar != null) {
                boolean z3 = this.A;
                String str3 = this.f54311e;
                String str4 = this.n;
                UpiProfileDefaultBank upiProfileDefaultBank = this.s;
                String virtualAddress2 = upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : null;
                String str5 = this.f54312f;
                String str6 = this.f54313g;
                UpiProfileDefaultBank upiProfileDefaultBank2 = this.s;
                String maskNumber = UpiUtils.maskNumber((upiProfileDefaultBank2 == null || (debitBank6 = upiProfileDefaultBank2.getDebitBank()) == null) ? null : debitBank6.getAccount());
                String str7 = this.j;
                String str8 = this.l;
                String str9 = this.w;
                String str10 = this.m;
                UpiProfileDefaultBank upiProfileDefaultBank3 = this.s;
                List<BankAccountDetails.BankAccountCredentials> child = (upiProfileDefaultBank3 == null || (debitBank5 = upiProfileDefaultBank3.getDebitBank()) == null || (credsAllowed2 = debitBank5.getCredsAllowed()) == null) ? null : credsAllowed2.getChild();
                UpiProfileDefaultBank upiProfileDefaultBank4 = this.s;
                dVar.a(z3, z2, str3, str4, virtualAddress2, str5, str6, maskNumber, str7, str8, str9, str10, str, child, (upiProfileDefaultBank4 == null || (debitBank4 = upiProfileDefaultBank4.getDebitBank()) == null) ? null : debitBank4.getBankName());
                return;
            }
            return;
        }
        net.one97.paytm.moneytransfer.presenter.d dVar2 = this.f54308b;
        if (dVar2 != null) {
            boolean z4 = this.A;
            String str11 = this.f54311e;
            String str12 = this.n;
            UpiProfileDefaultBank upiProfileDefaultBank5 = this.s;
            if (upiProfileDefaultBank5 == null || (virtualAddress = upiProfileDefaultBank5.getVirtualAddress()) == null) {
                str2 = null;
            } else if (virtualAddress != null) {
                str2 = virtualAddress.toLowerCase();
                kotlin.g.b.k.a((Object) str2, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            String str13 = this.f54312f;
            String str14 = this.f54313g;
            UpiProfileDefaultBank upiProfileDefaultBank6 = this.s;
            String maskNumber2 = UpiUtils.maskNumber((upiProfileDefaultBank6 == null || (debitBank3 = upiProfileDefaultBank6.getDebitBank()) == null) ? null : debitBank3.getAccount());
            String str15 = this.j;
            String str16 = this.l;
            String str17 = this.w;
            String str18 = this.m;
            UpiProfileDefaultBank upiProfileDefaultBank7 = this.s;
            List<BankAccountDetails.BankAccountCredentials> child2 = (upiProfileDefaultBank7 == null || (debitBank2 = upiProfileDefaultBank7.getDebitBank()) == null || (credsAllowed = debitBank2.getCredsAllowed()) == null) ? null : credsAllowed.getChild();
            UpiProfileDefaultBank upiProfileDefaultBank8 = this.s;
            dVar2.a(z4, z2, str11, str12, str2, str13, str14, maskNumber2, str15, str16, str17, str18, str, child2, (upiProfileDefaultBank8 == null || (debitBank = upiProfileDefaultBank8.getDebitBank()) == null) ? null : debitBank.getBankName());
        }
    }

    public final void a(MoneyTransferV3Activity.b bVar) {
        String str;
        if (bVar == MoneyTransferV3Activity.b.PLEASE_ADD_BANK) {
            str = getString(R.string.please_add_a_bank_account);
            kotlin.g.b.k.a((Object) str, "getString(R.string.please_add_a_bank_account)");
        } else if (bVar == MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG) {
            str = getString(R.string.upi_oops_something_went_wrong);
            kotlin.g.b.k.a((Object) str, "getString(R.string.upi_oops_something_went_wrong)");
        } else if (bVar == MoneyTransferV3Activity.b.CANNOT_TRANSFER_TO_SAME_ACC) {
            str = getString(R.string.you_cannot_transfer_money_to_same_account);
            kotlin.g.b.k.a((Object) str, "getString(R.string.you_c…er_money_to_same_account)");
        } else if (bVar == MoneyTransferV3Activity.b.NO_SIM) {
            str = getString(R.string.no_sim_attached);
            kotlin.g.b.k.a((Object) str, "getString(R.string.no_sim_attached)");
        } else {
            str = "";
        }
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str);
            builder.setNegativeButton(17039370, l.f54336a);
            builder.show();
        }
    }

    static final class l implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final l f54336a = new l();

        l() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
        }
    }

    public final void a(boolean z2) {
        Dialog dialog;
        Dialog dialog2;
        if (z2) {
            try {
                if (this.K == null) {
                    this.K = UpiAppUtils.getWalletStyleProgressDialog(this);
                }
                if (this.K != null) {
                    Dialog dialog3 = this.K;
                    if (dialog3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!dialog3.isShowing() && (dialog2 = this.K) != null) {
                        dialog2.show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        } else {
            com.paytm.utility.b.p();
            if (this.K != null) {
                Dialog dialog4 = this.K;
                if (dialog4 == null) {
                    kotlin.g.b.k.a();
                }
                if (dialog4.isShowing() && (dialog = this.K) != null) {
                    dialog.dismiss();
                }
            }
        }
    }

    public final void b(BaseUpiResponse baseUpiResponse) {
        if (this.z) {
            finish();
            return;
        }
        if (kotlin.g.b.k.a((Object) "1006", (Object) baseUpiResponse != null ? baseUpiResponse.getResponse() : null)) {
            b_(80);
            return;
        }
        this.f54309c = baseUpiResponse;
        g();
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        kotlin.g.b.k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        this.L = q.a(this.j);
        int i2 = R.id.fragment_scratch;
        q qVar = this.L;
        if (qVar == null) {
            kotlin.g.b.k.a();
        }
        a2.b(i2, qVar);
        a2.c();
    }

    public final void b(String str) {
        String str2;
        net.one97.paytm.moneytransfer.presenter.d dVar;
        String virtualAddress;
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence) && this.y) {
            UpiProfileDefaultBank upiProfileDefaultBank = this.s;
            String virtualAddress2 = upiProfileDefaultBank != null ? upiProfileDefaultBank.getVirtualAddress() : null;
            net.one97.paytm.moneytransfer.presenter.d dVar2 = this.f54308b;
            if (dVar2 != null) {
                dVar2.a(str, UpiUtils.getUpiSequenceNo(), this.f54315i, virtualAddress2, this.f54311e, this.f54313g, this.f54312f, this.s, this.o);
            }
        } else if (!TextUtils.isEmpty(charSequence) && !this.y) {
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.s;
            if (upiProfileDefaultBank2 == null || (virtualAddress = upiProfileDefaultBank2.getVirtualAddress()) == null) {
                str2 = null;
            } else if (virtualAddress != null) {
                String lowerCase = virtualAddress.toLowerCase();
                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                str2 = lowerCase;
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            if (this.G == MoneyTransferV3Activity.a.ACCOUNT_NUMBER) {
                net.one97.paytm.moneytransfer.presenter.d dVar3 = this.f54308b;
                if (dVar3 != null) {
                    dVar3.a(this.p, this.j, this.f54315i, str, this.n, str2, this.f54311e, this.f54313g, this.f54312f, this.s, this.l, this.R, this.f54314h, this.O);
                }
            } else if (this.G == MoneyTransferV3Activity.a.VPA && (dVar = this.f54308b) != null) {
                dVar.a(str, this.j, this.n, str2, this.f54311e, this.f54313g, this.f54312f, this.l, this.w, this.m, this.s, this.H, this.I, this.R, this.f54314h, this.O);
            }
        }
        this.D = true;
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (kotlin.m.p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || kotlin.m.p.a("410", upiCustomVolleyError.getmErrorCode(), true) || kotlin.m.p.a("403", upiCustomVolleyError.getmErrorCode(), true)) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            new NetworkCustomError();
            net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Activity) this, (String) null, false);
            return;
        }
        BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
        baseUpiResponse.setSuccess(false);
        baseUpiResponse.setMessage(getString(R.string.mt_something_went_wrong_post_txn) + " (" + upiCustomVolleyError.getmErrorCode() + ")");
        baseUpiResponse.setResponse("");
        this.f54309c = baseUpiResponse;
        g();
    }

    public final void a(String str, String str2) {
        a(false);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) a(R.id.tvReenterMpin)).setPadding(0, 0, 0, 0);
            Context context = this;
            ((TextView) a(R.id.tvReenterMpin)).setBackground(androidx.core.content.b.a(context, R.drawable.money_transfer_white_rounded_bg));
            TextView textView = (TextView) a(R.id.tvReenterMpin);
            kotlin.g.b.k.a((Object) textView, "tvReenterMpin");
            aa aaVar = aa.f47921a;
            String string = getString(R.string.money_tranfer_balance_with_placeholder);
            kotlin.g.b.k.a((Object) string, "getString(R.string.money…balance_with_placeholder)");
            String format = String.format(string, Arrays.copyOf(new Object[]{UpiAppUtils.priceToString(str)}, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            ((TextView) a(R.id.tvReenterMpin)).setTextColor(androidx.core.content.b.c(context, R.color.color_222222));
        } else if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this, R.string.upi_check_balance_error, 1).show();
        } else if (kotlin.g.b.k.a((Object) "ZM", (Object) str2)) {
            Toast.makeText(this, R.string.upi_incorrect_mpin, 1).show();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        kotlin.g.b.k.c(accountProvider, UpiContract.UPI_ACCOUNT_PROVIDER.ACCOUNT_PROVIDER);
        UpiProfileDefaultBank upiProfileDefaultBank = this.s;
        if (upiProfileDefaultBank != null) {
            Activity activity = this;
            if (upiProfileDefaultBank == null) {
                kotlin.g.b.k.a();
            }
            BankVpaCreationActivity.a(activity, accountProvider, upiProfileDefaultBank.getVirtualAddress(), 34);
        }
    }

    private final void m() {
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        Context context = this;
        if (!net.one97.paytm.moneytransfer.d.d.b(d.a.a()).c(context)) {
            n();
            return;
        }
        String str = this.f54312f;
        a(str, str, this.k, this.p, this.f54315i, com.paytm.utility.a.b(context), this.f54311e, this.f54313g);
    }

    private final void n() {
        Intent intent;
        try {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            intent = net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Activity) this);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            intent = null;
        }
        startActivityForResult(intent, 4444);
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        String str10;
        String str11 = str5;
        net.one97.paytm.moneytransfer.utils.k kVar = new net.one97.paytm.moneytransfer.utils.k((Activity) this, (net.one97.paytm.common.a) this, this.R);
        kVar.b();
        if (E()) {
            kVar.a();
        }
        if (str11 != null) {
            str9 = kotlin.m.p.a(str11, "\\n", "", false);
        } else {
            str9 = null;
        }
        if (str9 != null) {
            str10 = kotlin.m.p.a(str9, "\\r", "", false);
        } else {
            str10 = null;
        }
        kVar.a(str, str2, str3, str4, str10, str6, str7, str8, this.Q);
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        if (upiBaseDataModel != null) {
            this.f54309c = upiBaseDataModel;
            g();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.UpiBaseDataModel");
    }

    public final void c() {
        ImageView imageView = (ImageView) a(R.id.status_image);
        kotlin.g.b.k.a((Object) imageView, "status_image");
        imageView.setVisibility(8);
        Context context = this;
        com.paytm.utility.b.a((Activity) this, androidx.core.content.b.c(context, R.color.color_ffa400));
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).setBackgroundColor(androidx.core.content.b.c(context, R.color.color_ffa400));
        r();
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).a();
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.processing_layout);
        kotlin.g.b.k.a((Object) relativeLayout, "processing_layout");
        relativeLayout.setVisibility(0);
        ((ShimmerFrameLayout) findViewById(R.id.progress_shimmer_layout)).a();
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.timeline_layout);
        kotlin.g.b.k.a((Object) constraintLayout, "timeline_layout");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.error_layout);
        kotlin.g.b.k.a((Object) constraintLayout2, "error_layout");
        constraintLayout2.setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) a(R.id.fragment_cta_actions);
        kotlin.g.b.k.a((Object) frameLayout, "fragment_cta_actions");
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) a(R.id.fragment_invite_now);
        kotlin.g.b.k.a((Object) frameLayout2, "fragment_invite_now");
        frameLayout2.setVisibility(8);
    }

    private final void o() {
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).b();
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.processing_layout);
        kotlin.g.b.k.a((Object) relativeLayout, "processing_layout");
        relativeLayout.setVisibility(8);
        ((ShimmerFrameLayout) a(R.id.progress_shimmer_layout)).b();
        FrameLayout frameLayout = (FrameLayout) a(R.id.fragment_cta_actions);
        kotlin.g.b.k.a((Object) frameLayout, "fragment_cta_actions");
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = (FrameLayout) a(R.id.fragment_invite_now);
        kotlin.g.b.k.a((Object) frameLayout2, "fragment_invite_now");
        frameLayout2.setVisibility(0);
        y();
    }

    /* access modifiers changed from: private */
    public final void a(UpiProfileDefaultBank upiProfileDefaultBank, boolean z2) {
        Intent intent = new Intent(this, SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build();
        intent.putExtra("user_upi_details", build);
        kotlin.g.b.k.a((Object) build, "userUpiDetails");
        if (build.getBankAccountList() != null) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            b2.b("MoneyTransferV3PostPaymentActivity", String.valueOf(build.getBankAccountList().size()) + "_" + build.getSelectedBankIdx());
        } else {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b3 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            b3.b("MoneyTransferV3PostPaymentActivity", "null_" + build.getSelectedBankIdx());
        }
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, z2);
        startActivityForResult(intent, 10);
    }

    public final void onDestroy() {
        net.one97.paytm.moneytransfer.presenter.d dVar = this.f54308b;
        if (!(dVar == null || dVar == null)) {
            dVar.f();
        }
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        if (b2 != null) {
            b2.h();
        }
        super.onDestroy();
    }

    public final void onBackPressed() {
        String str;
        UpiTransactionStatusModel.TransactionStatus details;
        Intent intent = getIntent();
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("hide_isa_fd", false)) : null;
        if (valueOf == null || !valueOf.booleanValue()) {
            try {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                Intent intent2 = new Intent(this, Class.forName(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).g()));
                intent2.addFlags(67108864);
                intent2.addFlags(268435456);
                intent2.setFlags(536870912);
                startActivity(intent2);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            finish();
        } else {
            b(0);
        }
        if (this.I) {
            Context applicationContext = getApplicationContext();
            UpiTransactionStatusModel upiTransactionStatusModel = this.f54310d;
            if (upiTransactionStatusModel == null || (details = upiTransactionStatusModel.getDetails()) == null || (str = details.getStatus()) == null) {
                str = "";
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(applicationContext, Events.Category.INTENT, Events.Action.BACK_ARROW_CLICKED, str, "", "", this.n, this.f54311e, Events.Screen.POST_TRANSACTION, "");
        }
    }

    public final void b_(int i2) {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, i2);
    }

    private final void a(ImageView imageView, int i2) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.status_image_anim_view);
        kotlin.g.b.k.a((Object) lottieAnimationView, "status_image_anim_view");
        lottieAnimationView.setVisibility(0);
        ((LottieAnimationView) a(R.id.status_image_anim_view)).setAnimation(i2);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a(R.id.status_image_anim_view);
        kotlin.g.b.k.a((Object) lottieAnimationView2, "status_image_anim_view");
        lottieAnimationView2.setRepeatCount(-1);
        new Handler().postDelayed(new a(this, imageView), 300);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54316a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageView f54317b;

        a(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity, ImageView imageView) {
            this.f54316a = moneyTransferPostTransactionActivity;
            this.f54317b = imageView;
        }

        public final void run() {
            this.f54317b.setVisibility(8);
            ((LottieAnimationView) this.f54316a.a(R.id.status_image_anim_view)).playAnimation();
        }
    }

    public final void b(boolean z2) {
        ((LockableScrollView) a(R.id.scroll_layout)).setScrollingEnabled(z2);
    }

    public final void e() {
        if (Build.VERSION.SDK_INT < 23 || !s.a() || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.mt_success_share_layout);
            kotlin.g.b.k.a((Object) constraintLayout, "mt_success_share_layout");
            setShareImageData(constraintLayout);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.mt_success_share_layout);
            kotlin.g.b.k.a((Object) constraintLayout2, "mt_success_share_layout");
            net.one97.paytm.upi.f.b((View) constraintLayout2);
            ((ConstraintLayout) a(R.id.mt_success_share_layout)).invalidate();
            UpiUtils.shareSuccessfulTransaction(this, (ConstraintLayout) a(R.id.mt_success_share_layout), getString(R.string.post_payment_share_subject), m.a(), getString(R.string.post_payment_share_title), 8);
            return;
        }
        s.b((Activity) this);
        Toast.makeText(this, getString(R.string.mt_permission_not_granted), 0).show();
    }

    public final void setShareImageData(View view) {
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.BankAccount debitBank3;
        View view2 = view;
        kotlin.g.b.k.c(view2, "view");
        View findViewById = view2.findViewById(R.id.amount_tv);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById<TextView>(R.id.amount_tv)");
        ((TextView) findViewById).setText(getString(R.string.mt_rupees) + UpiAppUtils.priceToString(this.f54311e));
        View findViewById2 = view2.findViewById(R.id.amount_in_words_tv);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById<TextVi…(R.id.amount_in_words_tv)");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.mt_amount_in_words_placeholder);
        kotlin.g.b.k.a((Object) string, "getString(R.string.mt_amount_in_words_placeholder)");
        String format = String.format(string, Arrays.copyOf(new Object[]{EnglishNumberToWords.convert(this.f54311e)}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        ((TextView) findViewById2).setText(format);
        View findViewById3 = view2.findViewById(R.id.name_tv);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById<TextView>(R.id.name_tv)");
        ((TextView) findViewById3).setText(this.f54312f);
        if (TextUtils.isEmpty(this.aa)) {
            String a2 = com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy");
            kotlin.g.b.k.a((Object) a2, "CJRAppCommonUtility.getD…TIME_FORMAT\n            )");
            this.aa = a2;
        }
        View findViewById4 = view2.findViewById(R.id.date_tv);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById<TextView>(R.id.date_tv)");
        ((TextView) findViewById4).setText(this.aa);
        UpiBaseDataModel upiBaseDataModel = this.f54309c;
        String str = null;
        if (upiBaseDataModel instanceof BaseUpiResponse) {
            if (upiBaseDataModel != null) {
                BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                if (!TextUtils.isEmpty(baseUpiResponse.getBankRRN())) {
                    View findViewById5 = view2.findViewById(R.id.mt_order_id_tv);
                    kotlin.g.b.k.a((Object) findViewById5, "view.findViewById<TextView>(R.id.mt_order_id_tv)");
                    ((TextView) findViewById5).setText(getString(R.string.money_transfer_upi_ref_no) + " " + baseUpiResponse.getBankRRN());
                }
                if (UpiAppUtils.checkIsVpa(this.f54315i)) {
                    View findViewById6 = view2.findViewById(R.id.bank_name_tv);
                    kotlin.g.b.k.a((Object) findViewById6, "view.findViewById<TextView>(R.id.bank_name_tv)");
                    aa aaVar2 = aa.f47921a;
                    String string2 = getString(R.string.money_transfer_upi_without_bold);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.money…ransfer_upi_without_bold)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.f54315i}, 1));
                    kotlin.g.b.k.a((Object) format2, "java.lang.String.format(format, *args)");
                    ((TextView) findViewById6).setText(format2);
                    View findViewById7 = view2.findViewById(R.id.ifsc_tv);
                    kotlin.g.b.k.a((Object) findViewById7, "view.findViewById<TextView>(R.id.ifsc_tv)");
                    ((TextView) findViewById7).setVisibility(8);
                    View findViewById8 = view2.findViewById(R.id.account_tv);
                    kotlin.g.b.k.a((Object) findViewById8, "view.findViewById<TextView>(R.id.account_tv)");
                    ((TextView) findViewById8).setVisibility(8);
                    Intent intent = getIntent();
                    CharSequence stringExtra = intent != null ? intent.getStringExtra("picture") : null;
                    if (!(stringExtra == null || stringExtra.length() == 0)) {
                        ((ImageView) view2.findViewById(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                        w a3 = w.a();
                        Intent intent2 = getIntent();
                        a3.a(intent2 != null ? intent2.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) view2.findViewById(R.id.bank_icon_iv));
                    } else if (!TextUtils.isEmpty(this.p)) {
                        m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), this.p, (Context) this);
                    } else {
                        m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), "UPI", (Context) this);
                    }
                } else {
                    if (!TextUtils.isEmpty(this.k)) {
                        View findViewById9 = view2.findViewById(R.id.bank_name_tv);
                        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById<TextView>(R.id.bank_name_tv)");
                        ((TextView) findViewById9).setText(this.k);
                    } else {
                        View findViewById10 = view2.findViewById(R.id.bank_name_tv);
                        kotlin.g.b.k.a((Object) findViewById10, "view.findViewById<TextView>(R.id.bank_name_tv)");
                        ((TextView) findViewById10).setVisibility(8);
                    }
                    View findViewById11 = view2.findViewById(R.id.ifsc_tv);
                    kotlin.g.b.k.a((Object) findViewById11, "view.findViewById<TextView>(R.id.ifsc_tv)");
                    aa aaVar3 = aa.f47921a;
                    String string3 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                    kotlin.g.b.k.a((Object) string3, "getString(R.string.money…placeholder_without_bold)");
                    String format3 = String.format(string3, Arrays.copyOf(new Object[]{this.p}, 1));
                    kotlin.g.b.k.a((Object) format3, "java.lang.String.format(format, *args)");
                    ((TextView) findViewById11).setText(format3);
                    View findViewById12 = view2.findViewById(R.id.account_tv);
                    kotlin.g.b.k.a((Object) findViewById12, "view.findViewById<TextView>(R.id.account_tv)");
                    aa aaVar4 = aa.f47921a;
                    String string4 = getString(R.string.money_transfer_account_no);
                    kotlin.g.b.k.a((Object) string4, "getString(R.string.money_transfer_account_no)");
                    String format4 = String.format(string4, Arrays.copyOf(new Object[]{UpiAppUtils.getAccountNoV4Format(this.f54315i)}, 1));
                    kotlin.g.b.k.a((Object) format4, "java.lang.String.format(format, *args)");
                    ((TextView) findViewById12).setText(format4);
                    Intent intent3 = getIntent();
                    CharSequence stringExtra2 = intent3 != null ? intent3.getStringExtra("picture") : null;
                    if (stringExtra2 == null || stringExtra2.length() == 0) {
                        m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), this.p, (Context) this);
                    } else {
                        ((ImageView) view2.findViewById(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                        w a4 = w.a();
                        Intent intent4 = getIntent();
                        a4.a(intent4 != null ? intent4.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) view2.findViewById(R.id.bank_icon_iv));
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
            }
        } else if (upiBaseDataModel instanceof CJRMoneyTransferIMPSInitiateDataModel) {
            if (upiBaseDataModel != null) {
                CJRMoneyTransferIMPSInitiateDataModel cJRMoneyTransferIMPSInitiateDataModel = (CJRMoneyTransferIMPSInitiateDataModel) upiBaseDataModel;
                if (!TextUtils.isEmpty(cJRMoneyTransferIMPSInitiateDataModel.getRrn())) {
                    CJRIMPSInitiateExtraInfoDataModel extraInfoDataModel = cJRMoneyTransferIMPSInitiateDataModel.getExtraInfoDataModel();
                    kotlin.g.b.k.a((Object) extraInfoDataModel, "cjrMoneyTransferIMPSInit…aModel.extraInfoDataModel");
                    if (kotlin.m.p.a(extraInfoDataModel.getTransferType(), "neft", true)) {
                        View findViewById13 = view2.findViewById(R.id.mt_order_id_tv);
                        kotlin.g.b.k.a((Object) findViewById13, "view.findViewById<TextView>(R.id.mt_order_id_tv)");
                        ((TextView) findViewById13).setText(getString(R.string.mt_neft_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                    } else {
                        View findViewById14 = view2.findViewById(R.id.mt_order_id_tv);
                        kotlin.g.b.k.a((Object) findViewById14, "view.findViewById<TextView>(R.id.mt_order_id_tv)");
                        ((TextView) findViewById14).setText(getString(R.string.mt_imps_ref_id) + " " + cJRMoneyTransferIMPSInitiateDataModel.getRrn());
                    }
                }
                if (!TextUtils.isEmpty(this.k)) {
                    View findViewById15 = view2.findViewById(R.id.bank_name_tv);
                    kotlin.g.b.k.a((Object) findViewById15, "view.findViewById<TextView>(R.id.bank_name_tv)");
                    ((TextView) findViewById15).setText(this.k);
                } else {
                    View findViewById16 = view2.findViewById(R.id.bank_name_tv);
                    kotlin.g.b.k.a((Object) findViewById16, "view.findViewById<TextView>(R.id.bank_name_tv)");
                    ((TextView) findViewById16).setVisibility(8);
                }
                View findViewById17 = view2.findViewById(R.id.ifsc_tv);
                kotlin.g.b.k.a((Object) findViewById17, "view.findViewById<TextView>(R.id.ifsc_tv)");
                aa aaVar5 = aa.f47921a;
                String string5 = getString(R.string.money_transfer_ifsc_with_placeholder_without_bold);
                kotlin.g.b.k.a((Object) string5, "getString(R.string.money…placeholder_without_bold)");
                String format5 = String.format(string5, Arrays.copyOf(new Object[]{this.p}, 1));
                kotlin.g.b.k.a((Object) format5, "java.lang.String.format(format, *args)");
                ((TextView) findViewById17).setText(format5);
                View findViewById18 = view2.findViewById(R.id.account_tv);
                kotlin.g.b.k.a((Object) findViewById18, "view.findViewById<TextView>(R.id.account_tv)");
                aa aaVar6 = aa.f47921a;
                String string6 = getString(R.string.money_transfer_account_no);
                kotlin.g.b.k.a((Object) string6, "getString(R.string.money_transfer_account_no)");
                String format6 = String.format(string6, Arrays.copyOf(new Object[]{UpiAppUtils.getAccountNoV4Format(this.f54315i)}, 1));
                kotlin.g.b.k.a((Object) format6, "java.lang.String.format(format, *args)");
                ((TextView) findViewById18).setText(format6);
                Intent intent5 = getIntent();
                CharSequence stringExtra3 = intent5 != null ? intent5.getStringExtra("picture") : null;
                if (stringExtra3 == null || stringExtra3.length() == 0) {
                    m.a((ImageView) view2.findViewById(R.id.bank_icon_iv), this.p, (Context) this);
                } else {
                    ((ImageView) view2.findViewById(R.id.bank_icon_iv)).setPadding(0, 0, 0, 0);
                    w a5 = w.a();
                    Intent intent6 = getIntent();
                    a5.a(intent6 != null ? intent6.getStringExtra("picture") : null).a((ah) new CircleTransform()).a(R.drawable.profile_logout).b(R.drawable.profile_logout).a((ImageView) view2.findViewById(R.id.bank_icon_iv));
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRMoneyTransferIMPSInitiateDataModel");
            }
        }
        if (!TextUtils.isEmpty(this.f54313g) && !kotlin.m.p.a(this.f54313g, "NA", true)) {
            View findViewById19 = view2.findViewById(R.id.comment_tv);
            kotlin.g.b.k.a((Object) findViewById19, "view.findViewById<TextView>(R.id.comment_tv)");
            ((TextView) findViewById19).setText("\" " + this.f54313g + " \"");
            ((TextView) view2.findViewById(R.id.comment_tv)).setVisibility(0);
        }
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.payer_name_tv) : null;
        TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.payer_bank_name_tv) : null;
        ImageView imageView = view2 != null ? (ImageView) view2.findViewById(R.id.payer_bank_icon_iv) : null;
        UpiProfileDefaultBank upiProfileDefaultBank = this.s;
        if (upiProfileDefaultBank != null) {
            if (textView != null) {
                textView.setText(net.one97.paytm.upi.f.a((upiProfileDefaultBank == null || (debitBank3 = upiProfileDefaultBank.getDebitBank()) == null) ? null : debitBank3.getCustomerName()));
            }
            if (textView2 != null) {
                UpiProfileDefaultBank upiProfileDefaultBank2 = this.s;
                textView2.setText((upiProfileDefaultBank2 == null || (debitBank2 = upiProfileDefaultBank2.getDebitBank()) == null) ? null : debitBank2.getBankName());
            }
            UpiProfileDefaultBank upiProfileDefaultBank3 = this.s;
            if (!(upiProfileDefaultBank3 == null || (debitBank = upiProfileDefaultBank3.getDebitBank()) == null)) {
                str = debitBank.getIfsc();
            }
            m.a(imageView, str, (Context) this);
            return;
        }
        if (textView != null) {
            Intent intent7 = getIntent();
            if (intent7 != null) {
                str = intent7.getStringExtra(UpiConstants.EXTRA_PAYER_NAME);
            }
            textView.setText(net.one97.paytm.upi.f.a(str));
        }
        if (textView2 != null) {
            textView2.setText(getString(R.string.money_tranfer_balance_paytm_bank_string));
        }
        m.a(imageView, "PYTM0123456", (Context) this);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 56 && s.a(iArr)) {
            e();
        }
    }

    static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54335a;

        k(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54335a = moneyTransferPostTransactionActivity;
        }

        public final void run() {
            net.one97.paytm.common.widgets.c g2 = this.f54335a.M;
            if (g2 != null) {
                g2.dismissAllowingStateLoss();
            }
        }
    }

    public final void a(float f2) {
        Context context = this;
        com.paytm.utility.b.x(context, "is_app_rated");
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a(context, "app_rating", String.valueOf(Math.round(f2)), "UPI", (String) null, (String) null, (String) null, "app_rating");
        if (f2 < 5.0f) {
            com.paytm.utility.b.a(context, "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(context, "app_rating_5_star_timestamp", 0);
            net.one97.paytm.common.widgets.c cVar = this.M;
            View view = null;
            if ((cVar != null ? cVar.getView() : null) != null) {
                net.one97.paytm.common.widgets.c cVar2 = this.M;
                View view2 = cVar2 != null ? cVar2.getView() : null;
                if (view2 == null) {
                    kotlin.g.b.k.a();
                }
                View findViewById = view2.findViewById(R.id.tv_msg);
                if (findViewById != null) {
                    ((TextView) findViewById).setText(getString(net.one97.paytm.common.widgets.R.string.feedback_thanks_msg));
                    net.one97.paytm.common.widgets.c cVar3 = this.M;
                    View view3 = cVar3 != null ? cVar3.getView() : null;
                    if (view3 == null) {
                        kotlin.g.b.k.a();
                    }
                    View findViewById2 = view3.findViewById(R.id.tv_sub_msg);
                    if (findViewById2 != null) {
                        ((TextView) findViewById2).setVisibility(8);
                        net.one97.paytm.common.widgets.c cVar4 = this.M;
                        View view4 = cVar4 != null ? cVar4.getView() : null;
                        if (view4 == null) {
                            kotlin.g.b.k.a();
                        }
                        View findViewById3 = view4.findViewById(R.id.iv_close_icon);
                        if (findViewById3 != null) {
                            ((ImageView) findViewById3).setVisibility(8);
                            net.one97.paytm.common.widgets.c cVar5 = this.M;
                            if (cVar5 != null) {
                                view = cVar5.getView();
                            }
                            if (view == null) {
                                kotlin.g.b.k.a();
                            }
                            View findViewById4 = view.findViewById(R.id.ratingBar);
                            if (findViewById4 != null) {
                                ((AppCompatRatingBar) findViewById4).setRating(f2);
                            } else {
                                throw new u("null cannot be cast to non-null type androidx.appcompat.widget.AppCompatRatingBar");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type android.widget.ImageView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
            }
            c.a aVar2 = net.one97.paytm.moneytransfer.d.c.C;
            c.a.a();
            new Handler().postDelayed(new k(this), Long.parseLong(net.one97.paytm.moneytransfer.d.c.a("app_rating_thank_you_expire_time", com.alipay.iap.android.webapp.sdk.api.Constants.RESULT_STATUS_SUCCESS)));
        } else {
            com.paytm.utility.b.a(context, "app_rating_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(context, "app_rating_less_than_5_star_timestamp", 0);
            com.paytm.utility.b.ai(context);
            net.one97.paytm.common.widgets.c cVar6 = this.M;
            if (!(cVar6 == null || cVar6 == null)) {
                cVar6.dismissAllowingStateLoss();
            }
        }
        com.paytm.utility.b.a(context, "app_rating_not_now_timestamp", 0);
    }

    public final void a() {
        net.one97.paytm.common.widgets.c cVar;
        Context context = this;
        com.paytm.utility.b.a(context, "app_rating_not_now_timestamp", System.currentTimeMillis());
        com.paytm.utility.b.a(context, "app_rating_5_star_timestamp", 0);
        com.paytm.utility.b.a(context, "app_rating_less_than_5_star_timestamp", 0);
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a(context, "app_rating", "cross_button_clicked", "UPI", (String) null, (String) null, (String) null, "app_rating");
        net.one97.paytm.common.widgets.c cVar2 = this.M;
        boolean z2 = false;
        if (cVar2 != null ? cVar2.isAdded() : false) {
            net.one97.paytm.common.widgets.c cVar3 = this.M;
            if (cVar3 != null) {
                z2 = cVar3.isVisible();
            }
            if (z2 && (cVar = this.M) != null) {
                cVar.dismissAllowingStateLoss();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = r1.getScratchCards();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void p() {
        /*
            r3 = this;
            net.one97.paytm.moneytransfer.view.fragments.q r0 = r3.L
            if (r0 == 0) goto L_0x001a
            net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel r1 = r3.N
            if (r1 == 0) goto L_0x0016
            java.util.ArrayList r1 = r1.getScratchCards()
            if (r1 == 0) goto L_0x0016
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel$CJRScratchCard r1 = (net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel.CJRScratchCard) r1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            r0.a((net.one97.paytm.upi.common.upi.UpiGenerateCashbackDataModel.CJRScratchCard) r1)
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.p():void");
    }

    private final boolean q() {
        UpiGenerateCashbackDataModel upiGenerateCashbackDataModel = this.N;
        if (upiGenerateCashbackDataModel == null) {
            return false;
        }
        ArrayList<UpiGenerateCashbackDataModel.CJRScratchCard> arrayList = null;
        if (!kotlin.m.p.a(upiGenerateCashbackDataModel != null ? upiGenerateCashbackDataModel.getCode() : null, "0000", true)) {
            return false;
        }
        UpiGenerateCashbackDataModel upiGenerateCashbackDataModel2 = this.N;
        if (!kotlin.m.p.a(upiGenerateCashbackDataModel2 != null ? upiGenerateCashbackDataModel2.getStatus() : null, "UNCLAIMED", true)) {
            return false;
        }
        UpiGenerateCashbackDataModel upiGenerateCashbackDataModel3 = this.N;
        if ((upiGenerateCashbackDataModel3 != null ? upiGenerateCashbackDataModel3.getScratchCards() : null) == null) {
            return false;
        }
        UpiGenerateCashbackDataModel upiGenerateCashbackDataModel4 = this.N;
        if (upiGenerateCashbackDataModel4 != null) {
            arrayList = upiGenerateCashbackDataModel4.getScratchCards();
        }
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        if (arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public final void b(UpiCustomVolleyError upiCustomVolleyError) {
        kotlin.g.b.k.c(upiCustomVolleyError, "error");
        BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
        baseUpiResponse.setSuccess(false);
        baseUpiResponse.setMessage(getString(R.string.mt_network_error_for_txn));
        baseUpiResponse.setResponse(upiCustomVolleyError.getmErrorCode());
        this.f54309c = baseUpiResponse;
        g();
    }

    public final void c(UpiCustomVolleyError upiCustomVolleyError) {
        String str;
        this.C = true;
        BaseUpiResponse baseUpiResponse = new BaseUpiResponse();
        baseUpiResponse.setSuccess(false);
        baseUpiResponse.setMessage(getString(R.string.mt_network_error_for_txn_polling));
        baseUpiResponse.setResponse(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null);
        UpiBaseDataModel upiBaseDataModel = this.f54309c;
        if (!(upiBaseDataModel instanceof BaseUpiResponse)) {
            upiBaseDataModel = null;
        }
        BaseUpiResponse baseUpiResponse2 = (BaseUpiResponse) upiBaseDataModel;
        if (baseUpiResponse2 == null || (str = baseUpiResponse2.getBankRRN()) == null) {
            str = "";
        }
        baseUpiResponse.setBankRRN(str);
        this.f54309c = baseUpiResponse;
        g();
        Context context = this;
        com.paytm.utility.b.a((Activity) this, androidx.core.content.b.c(context, R.color.color_ffa400));
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).setBackgroundColor(androidx.core.content.b.c(context, R.color.color_ffa400));
        s();
    }

    private static Spannable a(String str, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), 0, i2, 33);
        return spannableString;
    }

    private static int d(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            return kotlin.m.p.a(charSequence, " ", 0, false, 6);
        }
        return 0;
    }

    private final void r() {
        if (this.I || this.y) {
            TextView textView = (TextView) a(R.id.tv_txn_status);
            kotlin.g.b.k.a((Object) textView, "tv_txn_status");
            textView.setText(getString(R.string.upi_processing_payment));
            return;
        }
        TextView textView2 = (TextView) a(R.id.tv_txn_status);
        kotlin.g.b.k.a((Object) textView2, "tv_txn_status");
        textView2.setText(getString(R.string.mt_processing_payment));
    }

    private final void s() {
        if (this.I || this.y) {
            TextView textView = (TextView) a(R.id.tv_txn_status);
            kotlin.g.b.k.a((Object) textView, "tv_txn_status");
            textView.setText(getString(R.string.upi_payment_pending));
            return;
        }
        TextView textView2 = (TextView) a(R.id.tv_txn_status);
        kotlin.g.b.k.a((Object) textView2, "tv_txn_status");
        textView2.setText(getString(R.string.money_transfer_pending));
    }

    private final void t() {
        if (this.I || this.y) {
            TextView textView = (TextView) a(R.id.tv_txn_status);
            kotlin.g.b.k.a((Object) textView, "tv_txn_status");
            textView.setText(getString(R.string.upi_payment_failed));
            return;
        }
        TextView textView2 = (TextView) a(R.id.tv_txn_status);
        kotlin.g.b.k.a((Object) textView2, "tv_txn_status");
        textView2.setText(getString(R.string.money_transfer_failed));
    }

    private final void u() {
        if (this.I || this.y) {
            TextView textView = (TextView) a(R.id.tv_txn_status);
            kotlin.g.b.k.a((Object) textView, "tv_txn_status");
            textView.setText(getString(R.string.upi_paid_successfully));
            return;
        }
        TextView textView2 = (TextView) a(R.id.tv_txn_status);
        kotlin.g.b.k.a((Object) textView2, "tv_txn_status");
        textView2.setText(getString(R.string.mt_money_transfer_successfully));
    }

    private final void v() {
        if (this.I || this.y) {
            TextView textView = (TextView) a(R.id.tv_repeat_payment);
            kotlin.g.b.k.a((Object) textView, "tv_repeat_payment");
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = (TextView) a(R.id.tv_repeat_payment);
        kotlin.g.b.k.a((Object) textView2, "tv_repeat_payment");
        textView2.setVisibility(0);
    }

    private final void w() {
        net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
        kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        net.one97.paytm.upi.f.a g2 = a2.g();
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        this.P = g2.a(applicationContext, this.O);
        ThemeData themeData = this.P;
        if (themeData != null) {
            Drawable drawable = null;
            String bgcolor = themeData != null ? themeData.getBgcolor() : null;
            String color = themeData != null ? themeData.getColor() : null;
            x.e eVar = new x.e();
            eVar.element = themeData != null ? themeData.getJsonData() : null;
            if (bgcolor != null) {
                try {
                    int parseColor = Color.parseColor(bgcolor);
                    com.paytm.utility.b.a((Activity) this, parseColor);
                    ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).setBackgroundColor(parseColor);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (color != null) {
                int parseColor2 = Color.parseColor(color);
                ((TextView) a(R.id.tv_txn_status)).setTextColor(parseColor2);
                TextView textView = (TextView) a(R.id.tv_view_details);
                if ((textView != null ? textView.getBackground() : null) instanceof GradientDrawable) {
                    TextView textView2 = (TextView) a(R.id.tv_view_details);
                    Drawable background = textView2 != null ? textView2.getBackground() : null;
                    if (background != null) {
                        ((GradientDrawable) background).setStroke(1, parseColor2);
                        TextView textView3 = (TextView) a(R.id.tv_view_details);
                        if (textView3 != null) {
                            textView3.setTextColor(parseColor2);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                }
                TextView textView4 = (TextView) a(R.id.tv_repeat_payment);
                if ((textView4 != null ? textView4.getBackground() : null) instanceof GradientDrawable) {
                    TextView textView5 = (TextView) a(R.id.tv_repeat_payment);
                    if (textView5 != null) {
                        drawable = textView5.getBackground();
                    }
                    if (drawable != null) {
                        ((GradientDrawable) drawable).setStroke(1, parseColor2);
                        ((TextView) a(R.id.tv_repeat_payment)).setTextColor(parseColor2);
                    } else {
                        throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                }
                TextView textView6 = (TextView) a(R.id.tv_amount_in_words);
                if (textView6 != null) {
                    textView6.setTextColor(parseColor2);
                }
                ((TextView) a(R.id.tv_amount)).setTextColor(parseColor2);
            }
            if (((String) eVar.element) != null) {
                AnimationUtils.setJsonLottieAnimation((LottieAnimationView) a(R.id.lav_theme_animation), (String) eVar.element);
                new Handler().postDelayed(new i(eVar, this), 300);
            }
            ((ImageView) a(R.id.status_image)).setImageResource(R.drawable.mt_success_greenbg_white_tick);
            ImageView imageView = (ImageView) a(R.id.status_image);
            kotlin.g.b.k.a((Object) imageView, "status_image");
            a(imageView, R.raw.payment_success_green_bg);
        }
    }

    public static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f54332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54333b;

        i(x.e eVar, MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54332a = eVar;
            this.f54333b = moneyTransferPostTransactionActivity;
        }

        public final void run() {
            ((LottieAnimationView) this.f54333b.a(R.id.lav_theme_animation)).playAnimation();
        }
    }

    private final void x() {
        Context context = this;
        com.paytm.utility.b.a((Activity) this, androidx.core.content.b.c(context, R.color.upi_pin_green));
        ((MoneyTransferShimmerAnimationLayout) a(R.id.status_shimmer_layout)).setBackgroundColor(androidx.core.content.b.c(context, R.color.upi_pin_green));
        ((ImageView) a(R.id.status_image)).setImageResource(R.drawable.mt_new_success);
        ImageView imageView = (ImageView) a(R.id.status_image);
        kotlin.g.b.k.a((Object) imageView, "status_image");
        a(imageView, R.raw.payment_success_white_bg);
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54320a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f54321b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Handler f54322c;

        d(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity, int i2, Handler handler) {
            this.f54320a = moneyTransferPostTransactionActivity;
            this.f54321b = i2;
            this.f54322c = handler;
        }

        public final void run() {
            MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this.f54320a;
            x.c cVar = new x.c();
            cVar.element = this.f54321b;
            while (cVar.element > 0 && moneyTransferPostTransactionActivity.S) {
                this.f54322c.post(new a(moneyTransferPostTransactionActivity, cVar, this));
                cVar.element--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (moneyTransferPostTransactionActivity.S) {
                this.f54322c.post(new b(moneyTransferPostTransactionActivity));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MoneyTransferPostTransactionActivity f54323a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ x.c f54324b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d f54325c;

            a(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity, x.c cVar, d dVar) {
                this.f54323a = moneyTransferPostTransactionActivity;
                this.f54324b = cVar;
                this.f54325c = dVar;
            }

            public final void run() {
                MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this.f54323a;
                ProgressBar progressBar = (ProgressBar) moneyTransferPostTransactionActivity.a(R.id.timerProgressBar);
                if (progressBar != null) {
                    progressBar.setProgress(this.f54325c.f54321b - this.f54324b.element);
                }
                TextView textView = (TextView) moneyTransferPostTransactionActivity.a(R.id.timerCountTextView);
                if (textView != null) {
                    textView.setText(String.valueOf(this.f54324b.element));
                }
            }
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MoneyTransferPostTransactionActivity f54326a;

            b(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
                this.f54326a = moneyTransferPostTransactionActivity;
            }

            public final void run() {
                MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this.f54326a;
                moneyTransferPostTransactionActivity.z();
                net.one97.paytm.moneytransfer.presenter.d j = moneyTransferPostTransactionActivity.f54308b;
                if (j != null) {
                    j.f();
                }
            }
        }
    }

    private final void y() {
        this.S = false;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.polling_timer_container);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void z() {
        UpiBaseDataModel upiBaseDataModel = this.f54309c;
        if (upiBaseDataModel != null) {
            o();
            f((UpiBaseDataModel) (BaseUpiResponse) upiBaseDataModel);
            l();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
    }

    public final void d() {
        if (!this.S) {
            this.S = true;
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.polling_timer_container);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            int i2 = this.f54307a;
            Handler handler = new Handler();
            ProgressBar progressBar = (ProgressBar) a(R.id.timerProgressBar);
            if (progressBar != null) {
                progressBar.setMax(i2);
            }
            if (this.I || this.y) {
                TextView textView = (TextView) a(R.id.pollingTextMessage);
                kotlin.g.b.k.a((Object) textView, "pollingTextMessage");
                textView.setText(getString(R.string.mt_polling_payment_request_text));
            } else {
                TextView textView2 = (TextView) a(R.id.pollingTextMessage);
                kotlin.g.b.k.a((Object) textView2, "pollingTextMessage");
                textView2.setText(getString(R.string.mt_polling_payment_text));
            }
            new Thread(new d(this, i2, handler)).start();
        }
    }

    private final void A() {
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("split_bill_data") : null;
        if (serializableExtra != null) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            if (b2 != null) {
                b2.a((Activity) this, (SBMarkAsPaid) serializableExtra);
            }
        }
    }

    private final void B() {
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
        Context applicationContext = getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
        b2.e(applicationContext);
    }

    private final void C() {
        UpiProfileDefaultBank upiProfileDefaultBank = this.s;
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank != null ? upiProfileDefaultBank.getDebitBank() : null;
        if (debitBank != null) {
            TextView textView = (TextView) a(R.id.bank_name);
            kotlin.g.b.k.a((Object) textView, PayUtility.BANK_NAME);
            textView.setText(m.a(debitBank.getBankName(), debitBank.getAccount()));
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.mt_success_bank_card_parent);
            kotlin.g.b.k.a((Object) constraintLayout, "mt_success_bank_card_parent");
            constraintLayout.setVisibility(0);
            m.a((ImageView) a(R.id.iv_bank), debitBank.getIfsc(), getApplicationContext());
            ((TextView) a(R.id.check_balance_tv)).setOnClickListener(this);
        }
    }

    /* access modifiers changed from: private */
    public final void D() {
        TextView textView = (TextView) a(R.id.check_balance_tv);
        kotlin.g.b.k.a((Object) textView, "check_balance_tv");
        if (textView.getText().equals(getString(R.string.check_balance))) {
            if (this.T == null) {
                Context applicationContext = getApplicationContext();
                if (applicationContext == null) {
                    kotlin.g.b.k.a();
                }
                this.T = new UPICheckBalanceHelper.UPICheckBalanceBuilder(applicationContext, this).setScreenName(getClass().getName()).setTag(getClass().getName()).build();
            }
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            UpiProfileDefaultBank upiProfileDefaultBank2 = this.s;
            String str = null;
            upiProfileDefaultBank.setDebitBank(upiProfileDefaultBank2 != null ? upiProfileDefaultBank2.getDebitBank() : null);
            UpiProfileDefaultBank upiProfileDefaultBank3 = this.s;
            if (upiProfileDefaultBank3 != null) {
                str = upiProfileDefaultBank3.getVirtualAddress();
            }
            upiProfileDefaultBank.setVirtualAddress(str);
            UPICheckBalanceHelper uPICheckBalanceHelper = this.T;
            if (uPICheckBalanceHelper != null) {
                uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
            }
            net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", "check_balance_clicked", CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        }
    }

    public final void a(n.b bVar) {
        kotlin.g.b.k.c(bVar, "errorUPI");
        if (bVar == n.b.INCORRECT_MPIN) {
            c(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            c(true);
        } else {
            UpiUtils.handleCheckBalanceError(this, bVar);
        }
        net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_ERROR, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, bVar.name(), "");
    }

    public static final class j implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54334a;

        j(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54334a = moneyTransferPostTransactionActivity;
        }

        public final void onReEnterClicked() {
            this.f54334a.D();
            net.one97.paytm.moneytransfer.utils.f.a(this.f54334a, "mt_p2p_new_v1", "UPI_pin_reentered", CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        }

        public final void onCreateNewPinClicked() {
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            UpiProfileDefaultBank l = this.f54334a.s;
            String str = null;
            upiProfileDefaultBank.setDebitBank(l != null ? l.getDebitBank() : null);
            UpiProfileDefaultBank l2 = this.f54334a.s;
            if (l2 != null) {
                str = l2.getVirtualAddress();
            }
            upiProfileDefaultBank.setVirtualAddress(str);
            this.f54334a.a(upiProfileDefaultBank, true);
            net.one97.paytm.moneytransfer.utils.f.a(this.f54334a, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_RESET_UPI_PIN, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        }
    }

    private final void c(boolean z2) {
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        IncorrectUpiPinBottomSheet.Companion.show(new j(this), supportFragmentManager, z2);
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        kotlin.g.b.k.c(str3, "accountType");
        if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
            str4 = getString(R.string.upi_balance_credit_limit, new Object[]{UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2)});
            kotlin.g.b.k.a((Object) str4, "getString(R.string.upi_b…String(availableBalance))");
        } else {
            str4 = getString(R.string.upi_new_balance, new Object[]{UpiAppUtils.priceToString(str2)});
            kotlin.g.b.k.a((Object) str4, "getString(R.string.upi_n…String(availableBalance))");
        }
        TextView textView = (TextView) a(R.id.check_balance_tv);
        if (textView != null) {
            textView.setText(str4);
        }
        TextView textView2 = (TextView) a(R.id.check_balance_tv);
        if (textView2 != null) {
            textView2.setTextColor(androidx.core.content.b.c(getApplicationContext(), R.color.color_666666));
        }
        TextView textView3 = (TextView) a(R.id.check_balance_tv);
        kotlin.g.b.k.a((Object) textView3, "check_balance_tv");
        textView3.setVisibility(0);
        net.one97.paytm.moneytransfer.utils.f.a(this, "mt_p2p_new_v1", CJRGTMConstants.MT_V4_CHECK_BALANCE_COMPLETED, CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
    }

    static final class c implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferPostTransactionActivity f54319a;

        c(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
            this.f54319a = moneyTransferPostTransactionActivity;
        }

        public final boolean onLongClick(View view) {
            if (TextUtils.isEmpty(this.f54319a.U)) {
                return true;
            }
            MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity = this.f54319a;
            m.a((Activity) moneyTransferPostTransactionActivity, "reference_id", moneyTransferPostTransactionActivity.U);
            MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity2 = this.f54319a;
            Toast.makeText(moneyTransferPostTransactionActivity2, moneyTransferPostTransactionActivity2.getString(R.string.ref_id_copy_msg), 0).show();
            return true;
        }
    }

    private final void b(int i2) {
        Intent intent = getIntent();
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("hide_isa_fd", false)) : null;
        if (valueOf != null && valueOf.booleanValue()) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            if (b2 != null) {
                b2.a((Activity) this, i2);
            }
            finish();
        }
    }

    private final boolean E() {
        return this.V != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = r1.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = r2.A
            if (r0 == 0) goto L_0x001d
            net.one97.paytm.moneytransfer.utils.g$a r0 = net.one97.paytm.moneytransfer.utils.g.f54162a
            android.content.Context r0 = r2.getApplicationContext()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = r2.s
            if (r1 == 0) goto L_0x0019
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r1.getDebitBank()
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = r1.getAccount()
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            net.one97.paytm.moneytransfer.utils.g.a.a(r0, r3, r1)
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity.e(java.lang.String):void");
    }

    private final void f(String str) {
        String str2;
        String str3;
        net.one97.paytm.moneytransfer.utils.f.a(getApplicationContext(), CJRGTMConstants.MONEY_TRANSFER_UPI, CJRGTMConstants.MT_V4_POST_TXN, CJRGTMConstants.MT_V4_SCREEN_NAME, str, "");
        if (this.y) {
            Context context = this;
            String str4 = this.n;
            String str5 = str4 == null ? "" : str4;
            String str6 = this.f54311e;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, Events.Category.COLLECT, "screen_open", str, "", "", str5, str2, Events.Screen.POST_TRANSACTION, "");
            String str7 = this.f54311e;
            if (str7 == null) {
                str3 = "";
            } else {
                str3 = str7;
            }
            net.one97.paytm.moneytransfer.utils.e.a((Activity) this, Events.Category.COLLECT, "screen_open", Events.Screen.POST_TRANSACTION, str, "", str3);
        } else if (this.I) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getApplicationContext(), Events.Category.INTENT, "screen_open", str, "", "", this.n, this.f54311e, Events.Screen.POST_TRANSACTION, "");
        }
    }

    private final void g(String str) {
        long j2;
        this.W = System.currentTimeMillis();
        long j3 = this.X;
        if (j3 != -1) {
            j2 = this.W - j3;
            QrData qrData = r7;
            QrData qrData2 = new QrData("Tprocess", Long.valueOf(j3), this.W, j2, str, "p2p");
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Context) this, qrData);
            new StringBuilder("Event ::").append(qrData.toString());
        } else {
            j2 = -1;
        }
        long j4 = this.Y;
        if (j4 != -1) {
            long j5 = this.W - j4;
            QrData qrData3 = r7;
            QrData qrData4 = new QrData("Tpayment", Long.valueOf(j4), this.W, j5, str, "p2p");
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            Context context = this;
            net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a(context, qrData3);
            QrData qrData5 = new QrData();
            qrData5.setFlow("p2p");
            qrData5.setStatus(str);
            qrData5.setTscan(Long.valueOf(this.Z));
            qrData5.setTprocess(Long.valueOf(j2));
            qrData5.setTpayment(Long.valueOf(j5));
            qrData5.setEventName("ScanPaySessionData");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
            qrData5.setScanPaySessionStartTime(simpleDateFormat.format(new Date(this.Y)));
            qrData5.setScanPaySessionEndTime(simpleDateFormat.format(new Date(this.W)));
            d.a aVar3 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a(context, qrData5);
            new StringBuilder("Event  :: ").append(qrData5.toString());
        }
    }

    public final void b() {
        AnimationFactory.stopWalletLoader((LottieAnimationView) a(R.id.check_balance_loader));
        TextView textView = (TextView) a(R.id.check_balance_tv);
        kotlin.g.b.k.a((Object) textView, "check_balance_tv");
        textView.setVisibility(0);
    }

    public final void Z_() {
        AnimationFactory.startWalletLoader((LottieAnimationView) a(R.id.check_balance_loader));
        TextView textView = (TextView) a(R.id.check_balance_tv);
        kotlin.g.b.k.a((Object) textView, "check_balance_tv");
        textView.setVisibility(8);
    }

    public static final /* synthetic */ void e(MoneyTransferPostTransactionActivity moneyTransferPostTransactionActivity) {
        UpiTransactionStatusModel.TransactionStatus details;
        UpiTransactionStatusModel.TransactionStatus.PayeeDetails payeeDetails;
        Context context = moneyTransferPostTransactionActivity;
        net.one97.paytm.moneytransfer.utils.f.a(context, "mt_p2p_new_v1", "view_txn_details", CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
        Intent intent = new Intent(context, MoneyTransferTxnDetailActivity.class);
        intent.putExtra("key_bundle", moneyTransferPostTransactionActivity.f54309c);
        intent.putExtra("key_amount", moneyTransferPostTransactionActivity.f54311e);
        intent.putExtra(LocaleDBContract.BaseTable.KEY, moneyTransferPostTransactionActivity.f54312f);
        intent.putExtra("key_comment", moneyTransferPostTransactionActivity.f54313g);
        intent.putExtra("key_account_number", moneyTransferPostTransactionActivity.f54315i);
        intent.putExtra("key_bank_name", moneyTransferPostTransactionActivity.k);
        intent.putExtra("key_account_number_selected", moneyTransferPostTransactionActivity.q);
        intent.putExtra("ifsc", moneyTransferPostTransactionActivity.p);
        intent.putExtra("payee_acc_or_vpa", moneyTransferPostTransactionActivity.G);
        intent.putExtra("is_from_upi_deep_link", moneyTransferPostTransactionActivity.I);
        intent.putExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, moneyTransferPostTransactionActivity.y);
        Intent intent2 = moneyTransferPostTransactionActivity.getIntent();
        String str = null;
        intent.putExtra("picture", intent2 != null ? intent2.getStringExtra("picture") : null);
        Intent intent3 = moneyTransferPostTransactionActivity.getIntent();
        if (intent3 != null) {
            str = intent3.getStringExtra(UpiConstants.EXTRA_PAYER_NAME);
        }
        intent.putExtra(UpiConstants.EXTRA_PAYER_NAME, str);
        intent.putExtra("date_time", moneyTransferPostTransactionActivity.aa);
        intent.putExtra("PAYER", moneyTransferPostTransactionActivity.s);
        UpiTransactionStatusModel upiTransactionStatusModel = moneyTransferPostTransactionActivity.f54310d;
        if (!(upiTransactionStatusModel == null || (details = upiTransactionStatusModel.getDetails()) == null || (payeeDetails = details.getPayeeDetails()) == null)) {
            intent.putExtra("payee_account_number", payeeDetails.getBankAccount());
            intent.putExtra("payee_ifsc", payeeDetails.getIfsc());
        }
        if (moneyTransferPostTransactionActivity.E()) {
            intent.putExtra("ppb_ica", moneyTransferPostTransactionActivity.V);
        }
        moneyTransferPostTransactionActivity.startActivityForResult(intent, 1004);
    }
}
