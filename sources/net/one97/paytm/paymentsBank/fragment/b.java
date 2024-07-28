package net.one97.paytm.paymentsBank.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.f;
import net.one97.paytm.bankCommon.model.CJRP2BStatus;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.bankCommon.model.PBCardDetailModel;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.bankOpen.ica.model.ICAStatusResponse;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.dynamic.module.bank.DbtUtilsKt;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.activity.AJREnterPasscode;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.b;
import net.one97.paytm.paymentsBank.activity.AJRNomineeDetails;
import net.one97.paytm.paymentsBank.activity.ChequeBookDDActivity;
import net.one97.paytm.paymentsBank.activity.ManageDebitCardActivity;
import net.one97.paytm.paymentsBank.activity.ReceiveMoneyActivity;
import net.one97.paytm.paymentsBank.apy.view.AtalPensionMainActivity;
import net.one97.paytm.paymentsBank.biometricAuthWall.b;
import net.one97.paytm.paymentsBank.chequebook.landing.view.ChequeBookLandingPageActivity;
import net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.RequestCBActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout;
import net.one97.paytm.paymentsBank.createfd.prefrence.b.a;
import net.one97.paytm.paymentsBank.createfd.prefrence.b.b;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.customView.BankDebitCardView;
import net.one97.paytm.paymentsBank.customView.c;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity.CashFromNearestPaytmActivity;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.nach.landing.PBNachRequestListActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;
import net.one97.paytm.paymentsBank.si.c.f;
import net.one97.paytm.paymentsBank.slfd.interestprojection.FixedDepositOfferingActivity;
import net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse;
import net.one97.paytm.paymentsBank.storefront.a.a;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontPage;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontRootResponse;
import net.one97.paytm.paymentsBank.updateInfo.a.e;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.l;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.paymentsBank.utils.r;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends p implements View.OnClickListener, com.paytm.network.listener.b, g.a, g.b<IJRPaytmDataModel>, b.a, a, b.C0303b, f.a {
    private final int A = 1245;
    private final int B = 6734;
    private final int C = 6982;
    private final String D;
    private String E;
    private String F;
    /* access modifiers changed from: private */
    public Context G;
    private CustProductList H;
    private String I;
    private String J;
    private IsaDetailsModel K;
    private LottieAnimationView L;
    private LottieAnimationView M;
    private LottieAnimationView N;
    private LottieAnimationView O;
    private LottieAnimationView P;
    private LottieAnimationView Q;
    private PBCardDetailModel R;
    private TextView S;
    private NomineeModel T;
    private ChequeBookFinResponse U;
    private TextView V;
    private LinearLayout W;
    private CirclePageIndicator X;
    private String Y;
    /* access modifiers changed from: private */
    public Handler Z;

    /* renamed from: a  reason: collision with root package name */
    String f18467a;
    private RelativeLayout aA;
    private RelativeLayout aB;
    private Button aC;
    private TextView aD;
    private LinearLayout aE;
    private TextView aF;
    private net.one97.paytm.paymentsBank.storefront.model.b aG;
    private FDStatusResponse aH;
    private boolean aI;
    private b.a aJ;
    private CreateFdPrefrenceLayout aK;
    private View aL;
    private BroadcastReceiver aM;
    private String aN;
    private boolean aO;
    private TextView aP;
    private DrawerLayout aQ;
    /* access modifiers changed from: private */
    public net.one97.paytm.paymentsBank.f.a.a aR;
    private double aS;
    private SharedPreferences aT;
    private FrameLayout aU;
    /* access modifiers changed from: private */
    public net.one97.paytm.paymentsBank.utils.b aV;
    private boolean aW;
    private ViewGroup aX;
    private TextView aY;
    private FrameLayout aZ;
    private LinearLayout aa;
    private LinearLayout ab;
    private double ac;
    private double ad;
    private double ae;
    private int af;
    private double ag;
    private double ah;
    private String ai;
    private View aj;
    private TimerTask ak;
    private Timer al;
    /* access modifiers changed from: private */
    public BankDebitCardView am;
    /* access modifiers changed from: private */
    public boolean an;
    private CJRCashWallet ao;
    /* access modifiers changed from: private */
    public boolean ap;
    private NestedScrollView aq;
    private TextView ar;
    private TextView as;
    private View at;
    private RecyclerView au;
    private h av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private CashFromNearestPaytmActivity.a az;

    /* renamed from: b  reason: collision with root package name */
    int f18468b;
    private r ba;
    private boolean bb;
    private Bundle bc;
    private d bd;
    private e.b be;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18469c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f18470d;

    /* renamed from: e  reason: collision with root package name */
    public RoboTextView f18471e;

    /* renamed from: f  reason: collision with root package name */
    public RoboTextView f18472f;

    /* renamed from: g  reason: collision with root package name */
    public RoboTextView f18473g;

    /* renamed from: h  reason: collision with root package name */
    public RoboTextView f18474h;

    /* renamed from: i  reason: collision with root package name */
    public RoboTextView f18475i;
    public RoboTextView j;
    public RoboTextView k;
    public RoboTextView l;
    public boolean m;
    public ViewPager n;
    public View o;
    public View p;
    public boolean q;
    public boolean r;
    public LinearLayout s;
    public CustProductStatus t;
    public View u;
    public TextView v;
    public TextView w;
    public net.one97.paytm.paymentsBank.a.b x;
    BroadcastReceiver y;
    public boolean z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public b() {
        Class<b> cls = b.class;
        this.D = cls.getName();
        this.f18467a = "";
        this.f18468b = 0;
        this.f18469c = false;
        this.E = "4%";
        this.F = "7.03%";
        this.ac = -1.0d;
        this.ad = -1.0d;
        this.ae = -1.0d;
        this.af = 0;
        this.ag = -1.0d;
        this.ah = -1.0d;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.aM = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                boolean unused = b.this.ap = true;
            }
        };
        this.y = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if ("card_changed".equalsIgnoreCase(intent.getAction()) && b.this.am != null) {
                    int intExtra = intent.getIntExtra("cardState", -1);
                    if (intExtra == c.BLOCK_CARD.ordinal()) {
                        b.this.am.a(c.BLOCK_CARD);
                    } else if (intExtra == c.MASKED_CARD.ordinal()) {
                        b.this.am.a(c.MASKED_CARD);
                    } else if (intExtra == c.FULL_CARD.ordinal()) {
                        b.this.am.a(c.FULL_CARD);
                    }
                } else if ("PENDING".equalsIgnoreCase(intent.getAction())) {
                    boolean unused = b.this.an = intent.getBooleanExtra("PENDING", false);
                    if (b.this.an && b.this.aV != null) {
                        net.one97.paytm.paymentsBank.utils.b d2 = b.this.aV;
                        Context context2 = b.this.getContext();
                        if (d2.f19495a != null) {
                            net.one97.paytm.paymentsBank.f.b bVar = d2.f19495a;
                            new net.one97.paytm.paymentsBank.f.b.b();
                            net.one97.paytm.paymentsBank.f.b.b bVar2 = new net.one97.paytm.paymentsBank.f.b.b();
                            bVar2.f18350a = 2;
                            bVar2.f18351b = 115;
                            bVar2.f18352c = context2.getString(R.string.pb_nach_payment_request);
                            bVar2.f18353d = context2.getString(R.string.pb_nach_mandate_row_desc);
                            bVar2.f18355f = R.drawable.pb_ic_pending_req_blue_svg;
                            bVar.a(bVar2, bVar.f18332a.size() - 1);
                            bVar.notifyDataSetChanged();
                        }
                    }
                }
            }
        };
        this.aN = cls.getSimpleName();
        this.bb = false;
        this.bd = new d() {
            public final void onFragmentAction(int i2, Object obj) {
                b.this.a(i2, obj);
            }
        };
        this.be = new e.b() {
            public final void onProceedClicked(String str) {
                b.this.g(str);
            }
        };
    }

    public static b c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("xCode", str);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.G = getActivity();
        net.one97.paytm.bankCommon.mapping.c.a("/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, this.G);
        View inflate = layoutInflater.inflate(R.layout.fragment_bank_tab, viewGroup, false);
        this.aZ = (FrameLayout) inflate.findViewById(R.id.bank_kyc_banner);
        this.aT = getContext().getSharedPreferences("LAUNCH_COUNT_PREF", 0);
        a("bank_cersai_launch_count", false);
        a("bank_nominee_launch_count", false);
        this.p = inflate;
        this.aL = this.p.findViewById(R.id.fd_seek_divider_view);
        this.aK = (CreateFdPrefrenceLayout) this.p.findViewById(R.id.fd_sweep_view);
        this.aK.setCallBackListener(this);
        this.aj = this.p.findViewById(R.id.new_label_debit_card);
        this.f18470d = (RelativeLayout) this.p.findViewById(R.id.lyt_cheque_demand_draft);
        ((TextView) this.p.findViewById(R.id.tv_digital_debit)).setText(R.string.rupay_platinum_debit_card);
        this.aq = (NestedScrollView) this.p.findViewById(R.id.fragment_bank_tab_scroll_view);
        this.aq.setNestedScrollingEnabled(false);
        this.p.findViewById(R.id.fragment_bank_tab_tv_paytm_wallet).setOnClickListener(this);
        this.p.findViewById(R.id.fragment_bank_tab_tv_fd).setOnClickListener(this);
        this.aD = (TextView) this.p.findViewById(R.id.fragment_bank_tab_tv_savings_acc);
        this.aD.setOnClickListener(this);
        this.p.findViewById(R.id.tv_digital_debit).setOnClickListener(this);
        this.p.findViewById(R.id.lyt_acc_nominee).setOnClickListener(this);
        this.p.findViewById(R.id.lyt_debit_card).setOnClickListener(this);
        this.p.findViewById(R.id.lyt_cheque_demand_draft).setOnClickListener(this);
        this.p.findViewById(R.id.lyt_atal_pension).setOnClickListener(this);
        this.at = this.p.findViewById(R.id.lyt_rates_and_charges);
        this.at.setOnClickListener(this);
        this.p.findViewById(R.id.lyt_faq).setOnClickListener(this);
        this.p.findViewById(R.id.network_retry_btn).setOnClickListener(this);
        this.p.findViewById(R.id.lyt_contact_us).setOnClickListener(this);
        this.p.findViewById(R.id.fragment_bank_tab_lyt_savings_acc).setOnClickListener(this);
        this.p.findViewById(R.id.fragment_bank_tab_lyt_paytm_wallet).setOnClickListener(this);
        this.p.findViewById(R.id.linked_ac_layout_wallet).setOnClickListener(this);
        this.s = (LinearLayout) this.p.findViewById(R.id.total_layout);
        this.s.setOnClickListener(this);
        this.aA = (RelativeLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt_fd);
        this.aA.setOnClickListener(this);
        this.aB = (RelativeLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt_fd_not_opened);
        this.aC = (Button) this.p.findViewById(R.id.btn_fd_proceed);
        this.aC.setOnClickListener(this);
        this.aB.setOnClickListener(this);
        ((TextView) this.p.findViewById(R.id.p2b_tv)).setOnClickListener(this);
        this.W = (LinearLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt_acc);
        this.V = (TextView) this.p.findViewById(R.id.tv_savings_share_details);
        this.V.setOnClickListener(this);
        this.aa = (LinearLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt_main);
        this.ab = (LinearLayout) this.p.findViewById(R.id.no_network);
        this.f18474h = (RoboTextView) this.p.findViewById(R.id.tv_savings_name);
        this.f18475i = (RoboTextView) this.p.findViewById(R.id.tv_savings_acc_details);
        this.S = (TextView) this.p.findViewById(R.id.tv_nominee);
        this.P = (LottieAnimationView) this.p.findViewById(R.id.card_dot_progress_bar);
        this.M = (LottieAnimationView) this.p.findViewById(R.id.saving_data_dot_progress_bar);
        this.L = (LottieAnimationView) this.p.findViewById(R.id.saving_balance_dot_progress_bar);
        this.N = (LottieAnimationView) this.p.findViewById(R.id.fd_dot_progress_bar);
        this.O = (LottieAnimationView) this.p.findViewById(R.id.wallet_dot_progress_bar);
        this.Q = (LottieAnimationView) this.p.findViewById(R.id.total_dot_progress_bar);
        this.f18471e = (RoboTextView) this.p.findViewById(R.id.tv_wallet_balance);
        this.f18472f = (RoboTextView) this.p.findViewById(R.id.tv_savings_balance);
        this.f18473g = (RoboTextView) this.p.findViewById(R.id.tv_fd_balance);
        this.f18473g.setVisibility(0);
        this.j = (RoboTextView) this.p.findViewById(R.id.tv_wallet_balance_details);
        this.l = (RoboTextView) this.p.findViewById(R.id.tv_total_balance);
        View findViewById = this.p.findViewById(R.id.logout_tv);
        this.n = (ViewPager) this.p.findViewById(R.id.payments_bank_intro_pager);
        this.X = (CirclePageIndicator) this.p.findViewById(R.id.page_indicator);
        this.k = (RoboTextView) this.p.findViewById(R.id.tv_fd_balance_details);
        this.u = this.p.findViewById(R.id.saving_ac_layout);
        this.v = (TextView) this.u.findViewById(R.id.sub_heading);
        this.aU = (FrameLayout) this.p.findViewById(R.id.container_ica);
        this.u.findViewById(R.id.show_more).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.f(view);
            }
        });
        this.o = this.p.findViewById(R.id.linked_ac_layout);
        this.w = (TextView) this.o.findViewById(R.id.sub_heading);
        this.as = (TextView) this.o.findViewById(R.id.fragment_bank_tab_tv_fd1);
        this.ar = (TextView) this.o.findViewById(R.id.tv_fd_pending);
        this.o.findViewById(R.id.show_more).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.e(view);
            }
        });
        this.aX = (ViewGroup) inflate.findViewById(R.id.indicator_layout);
        this.au = (RecyclerView) inflate.findViewById(R.id.bank_option_list);
        new v().attachToRecyclerView(this.au);
        findViewById.setOnClickListener(this);
        this.aP = (TextView) this.p.findViewById(R.id.bas_debit_card_title);
        this.aQ = (DrawerLayout) this.p.findViewById(R.id.drawer_layout);
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.p.findViewById(R.id.hamburger);
        try {
            String al2 = com.paytm.utility.b.al(getActivity());
            if (!TextUtils.isEmpty(al2)) {
                w.a().a(al2).a((ah) new net.one97.paytm.paymentsBank.utils.c()).a((ImageView) appCompatImageView, (com.squareup.picasso.e) null);
            } else {
                appCompatImageView.setImageResource(R.drawable.pb_ic_default_user);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.d(view);
            }
        });
        this.p.findViewById(R.id.fl_bank_offer);
        this.p.findViewById(R.id.fl_whats_new);
        this.aE = (LinearLayout) this.p.findViewById(R.id.ll_upi_view);
        this.aF = (TextView) this.p.findViewById(R.id.upi_heading);
        ((AppCompatImageView) this.p.findViewById(R.id.back_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.c(view);
            }
        });
        f();
        this.aR = new net.one97.paytm.paymentsBank.f.a.a(this, inflate);
        this.aR.a();
        this.aQ.a((DrawerLayout.c) new DrawerLayout.c() {
            public final void a(float f2) {
            }

            public final void onDrawerClosed(View view) {
            }

            public final void onDrawerOpened(View view) {
                net.one97.paytm.paymentsBank.f.a.a e2 = b.this.aR;
                boolean G = net.one97.paytm.bankCommon.h.b.G(e2.f18317a.getContext());
                if (n.g() && !G) {
                    net.one97.paytm.bankCommon.h.b.H(e2.f18317a.getContext());
                }
            }
        });
        if (this.aV == null) {
            this.aV = new net.one97.paytm.paymentsBank.utils.b();
            net.one97.paytm.paymentsBank.utils.b bVar = this.aV;
            int i2 = R.id.rv_menu_item;
            boolean z2 = this.aW;
            if (isAdded()) {
                bVar.f19496b = (RecyclerView) inflate.findViewById(i2);
                bVar.f19496b.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
                bVar.f19496b.setNestedScrollingEnabled(false);
                FragmentActivity activity = getActivity();
                ArrayList arrayList = new ArrayList();
                new net.one97.paytm.paymentsBank.f.b.b();
                net.one97.paytm.paymentsBank.f.b.b bVar2 = new net.one97.paytm.paymentsBank.f.b.b();
                bVar2.f18350a = 4;
                bVar2.f18351b = 100;
                arrayList.add(bVar2);
                net.one97.paytm.paymentsBank.f.b.b bVar3 = new net.one97.paytm.paymentsBank.f.b.b();
                bVar3.f18350a = 1;
                bVar3.f18351b = 0;
                bVar3.f18352c = getString(R.string.pb_bank_services).toUpperCase();
                bVar3.f18356g = R.color.color_506d85;
                arrayList.add(bVar3);
                if (z2) {
                    net.one97.paytm.paymentsBank.f.b.b bVar4 = new net.one97.paytm.paymentsBank.f.b.b();
                    bVar4.f18350a = 2;
                    bVar4.f18351b = 101;
                    bVar4.f18352c = getString(R.string.drawer_heading_manage_debit_atm_card);
                    bVar4.f18353d = getString(R.string.drawer_sub_heading_manage_debit_atm_card);
                    bVar4.f18355f = R.drawable.drawer_manage_debit_card;
                    arrayList.add(bVar4);
                }
                if (j.b()) {
                    net.one97.paytm.paymentsBank.f.b.b bVar5 = new net.one97.paytm.paymentsBank.f.b.b();
                    bVar5.f18350a = 2;
                    bVar5.f18351b = 102;
                    bVar5.f18352c = getString(R.string.drawer_heading_downloads);
                    bVar5.f18353d = getString(R.string.drawer_sub_heading_downloads);
                    bVar5.f18355f = R.drawable.drawer_downloads;
                    arrayList.add(bVar5);
                    net.one97.paytm.paymentsBank.f.b.b bVar6 = new net.one97.paytm.paymentsBank.f.b.b();
                    bVar6.f18350a = 2;
                    bVar6.f18351b = 103;
                    bVar6.f18352c = getString(R.string.drawer_heading_recurring_payments);
                    bVar6.f18353d = getString(R.string.drawer_sub_heading_recurring_payments);
                    bVar6.f18355f = R.drawable.drawer_recurring_payments;
                    arrayList.add(bVar6);
                }
                net.one97.paytm.paymentsBank.f.b.b bVar7 = new net.one97.paytm.paymentsBank.f.b.b();
                bVar7.f18350a = 2;
                bVar7.f18351b = 106;
                bVar7.f18352c = getString(R.string.drawer_heading_cheque_book);
                bVar7.f18353d = getString(R.string.drawer_sub_heading_cheque_book);
                bVar7.f18355f = R.drawable.drawer_cheque_book;
                arrayList.add(bVar7);
                net.one97.paytm.paymentsBank.f.b.b bVar8 = new net.one97.paytm.paymentsBank.f.b.b();
                bVar8.f18350a = 4;
                bVar8.f18351b = 123;
                arrayList.add(bVar8);
                bVar.f19495a = new net.one97.paytm.paymentsBank.f.b(activity, arrayList);
                bVar.f19496b.setAdapter(bVar.f19495a);
                bVar.f19495a.f18333b = new net.one97.paytm.paymentsBank.h.b<net.one97.paytm.paymentsBank.f.b.b>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ net.one97.paytm.paymentsBank.fragment.b f19497a;

                    {
                        this.f19497a = r2;
                    }

                    public final /* synthetic */ void onClick(View view, int i2, Object obj) {
                        int i3 = ((net.one97.paytm.paymentsBank.f.b.b) obj).f18351b;
                        if (i3 == 106) {
                            View findViewById = this.f19497a.getView().findViewById(R.id.lyt_cheque_demand_draft);
                            if (findViewById != null) {
                                findViewById.performClick();
                            }
                        } else if (i3 == 115) {
                            this.f19497a.a(6);
                        } else if (i3 != 116) {
                            switch (i3) {
                                case 101:
                                    this.f19497a.m();
                                    return;
                                case 102:
                                    net.one97.paytm.paymentsBank.fragment.b bVar = this.f19497a;
                                    net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                                    if (net.one97.paytm.payments.c.c.b.f()) {
                                        net.one97.paytm.payments.c.c.b bVar3 = net.one97.paytm.payments.c.c.b.f17264a;
                                        net.one97.paytm.payments.c.c.b.e(bVar.getContext(), new Bundle());
                                        return;
                                    } else if (bVar.t == null) {
                                        bVar.z = true;
                                        bVar.k();
                                        return;
                                    } else {
                                        bVar.a(bVar.t);
                                        return;
                                    }
                                case 103:
                                    this.f19497a.a(7);
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.f19497a.d("paytmmp://payment_bank?featuretype=dbt");
                        }
                    }
                };
            }
        }
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        this.aJ = new net.one97.paytm.paymentsBank.createfd.prefrence.c.a(net.one97.paytm.paymentsBank.slfd.c.a(getContext()), this);
        this.aG = (net.one97.paytm.paymentsBank.storefront.model.b) am.a((Fragment) this).a(net.one97.paytm.paymentsBank.storefront.model.b.class);
        if (o.a().getBooleanFromGTM("pbStoreFrontBannerShow", false)) {
            net.one97.paytm.paymentsBank.storefront.model.b bVar9 = this.aG;
            if (com.paytm.utility.b.c((Context) bVar9.f19426g)) {
                HashMap hashMap = new HashMap();
                String simpleName = bVar9.getClass().getSimpleName();
                k.a((Object) simpleName, "javaClass.simpleName");
                hashMap.put("screen_name", simpleName);
                Context context = bVar9.f19426g;
                g.b bVar10 = bVar9;
                g.a aVar = bVar9;
                a.c cVar2 = a.c.PAYMENTSBANK;
                a.b bVar11 = a.b.SILENT;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Content-Type", "application/json");
                hashMap2.put("channel", UpiConstants.B2C_ANDROID);
                net.one97.paytm.bankCommon.mapping.g.a();
                String a2 = net.one97.paytm.bankCommon.utils.d.a("ppbStoreFrontUrl");
                if (!URLUtil.isValidUrl(a2)) {
                    a2 = net.one97.paytm.bankOpen.f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://storefront-staging.paytm.com/v2/h/paytm-payment-bank" : "https://storefront.paytm.com/v2/h/paytm-payment-bank";
                }
                net.one97.paytm.bankCommon.g.b bVar12 = new net.one97.paytm.bankCommon.g.b(com.paytm.utility.b.e(context, a2), bVar10, aVar, new StoreFrontRootResponse(), hashMap2, (String) null, cVar2, bVar11, hashMap);
                bVar12.f16270b = bVar9.f19420a;
                bVar9.f19426g.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(bVar12);
            }
        }
        net.one97.paytm.paymentsBank.storefront.model.b bVar13 = this.aG;
        StringBuilder sb = new StringBuilder();
        k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(applicationContext)");
        sb.append(net.one97.paytm.bankCommon.utils.d.a(PaymentsGTMConstants.USER_DETAILS));
        sb.append(net.one97.paytm.bankCommon.mapping.e.v());
        String b2 = com.paytm.utility.b.b((Context) bVar13.f19426g, sb.toString());
        k.a((Object) b2, "CJRAppCommonUtility.addS…ionContext, kycStatusURL)");
        if (URLUtil.isValidUrl(b2)) {
            Map<String, String> d2 = net.one97.paytm.bankCommon.mapping.d.d(bVar13.f19426g.getApplicationContext());
            if (com.paytm.utility.b.c((Context) bVar13.f19426g)) {
                HashMap hashMap3 = new HashMap();
                String simpleName2 = bVar13.getClass().getSimpleName();
                k.a((Object) simpleName2, "javaClass.simpleName");
                hashMap3.put("screen_name", simpleName2);
                net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(b2, bVar13, bVar13, new CJRUserInfoV2(), d2, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap3);
                bVar13.f19426g.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(aVar2);
            }
        }
        net.one97.paytm.paymentsBank.storefront.model.b bVar14 = this.aG;
        k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String a3 = net.one97.paytm.bankCommon.utils.d.a("kycFetchProfileInfoV2");
        k.a((Object) a3, "PBGTMHelper.getInstance().kycProfileFetchV2URL");
        if (URLUtil.isValidUrl(a3) && !TextUtils.isEmpty(com.paytm.utility.a.q(bVar14.f19426g))) {
            String e3 = com.paytm.utility.b.e((Context) bVar14.f19426g, a3);
            k.a((Object) e3, "CJRAppCommonUtility.addA…(applicationContext, url)");
            String str = e3 + "&fields=cersai";
            Map hashMap4 = new HashMap();
            String q2 = com.paytm.utility.a.q(bVar14.f19426g);
            k.a((Object) q2, "CJRNetUtility.getSSOToken(applicationContext)");
            hashMap4.put("session_token", q2);
            HashMap hashMap5 = new HashMap();
            String simpleName3 = bVar14.getClass().getSimpleName();
            k.a((Object) simpleName3, "javaClass.simpleName");
            hashMap5.put("screen_name", simpleName3);
            net.one97.paytm.bankCommon.g.a aVar3 = new net.one97.paytm.bankCommon.g.a(str, bVar14, bVar14, new CJRAadharPanGet(), hashMap4, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap5);
            bVar14.f19426g.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(aVar3);
        }
        this.aG.f19421b.observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                b.this.a((StoreFrontRootResponse) obj);
            }
        });
        if (this.aG.f19423d != null) {
            this.aG.f19423d.observe(getViewLifecycleOwner(), new z() {
                public final void onChanged(Object obj) {
                    b.this.a((Boolean) obj);
                }
            });
        }
        if (this.aG.f19424e != null) {
            this.aG.f19424e.observe(getViewLifecycleOwner(), new z() {
                public final void onChanged(Object obj) {
                    b.this.b((net.one97.paytm.bankCommon.b.c) obj);
                }
            });
        }
        this.aG.f19425f.observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                b.this.a((net.one97.paytm.bankCommon.b.c) obj);
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.aY = (TextView) view.findViewById(R.id.tv_biometric_success_view);
        this.ba = new r(this.G, this.aZ, this.bd);
        if (getActivity() != null && getArguments() != null && getArguments().containsKey("xCode") && getArguments().getString("xCode") != null) {
            String string = getArguments().getString("xCode");
            if (getActivity() != null) {
                b.a aVar = net.one97.paytm.paymentsBank.biometricAuthWall.b.f17445a;
                b.a.a(string).show(getActivity().getSupportFragmentManager(), net.one97.paytm.paymentsBank.biometricAuthWall.b.class.getName());
            }
            if (getActivity() != null) {
                ((net.one97.paytm.paymentsBank.biometricAuthWall.f) am.a(getActivity()).a(net.one97.paytm.paymentsBank.biometricAuthWall.f.class)).f17468b.observe(getViewLifecycleOwner(), new z() {
                    public final void onChanged(Object obj) {
                        b.this.a((net.one97.paytm.paymentsBank.biometricAuthWall.d) obj);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.paymentsBank.biometricAuthWall.d dVar) {
        String string = getString(R.string.some_went_wrong);
        if (dVar.f17451a == 7 || dVar.f17451a == 9) {
            string = dVar.f17452b;
        }
        com.paytm.utility.g.b(getActivity(), getString(R.string.pb_auth_error), string, $$Lambda$KbWrXdjYtSIc0tZRxxjKz3Agpk.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_first_setup", "biometric_login_enable_success", "", "", "/bank/biometric_first_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        this.aY.setVisibility(0);
        this.aY.postDelayed(new Runnable() {
            public final void run() {
                b.this.Q();
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.aY.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(StoreFrontRootResponse storeFrontRootResponse) {
        androidx.fragment.app.j childFragmentManager;
        if (storeFrontRootResponse != null && storeFrontRootResponse.getPage() != null && storeFrontRootResponse.getPage().size() > 0) {
            for (StoreFrontPage next : storeFrontRootResponse.getPage()) {
                if (next != null) {
                    if (next.getViewId() == 34663) {
                        if (next.getViews() != null && next.getViews().size() > 0) {
                            this.aG.f19422c.append(34663, next.getViews());
                            androidx.fragment.app.j childFragmentManager2 = getChildFragmentManager();
                            if (childFragmentManager2 != null) {
                                q a2 = childFragmentManager2.a();
                                int i2 = R.id.fl_bank_offer;
                                a.C0346a aVar = net.one97.paytm.paymentsBank.storefront.a.a.f19414a;
                                a2.b(i2, a.C0346a.a(true, next.getViews()), (String) null).c();
                            }
                        }
                    } else if (next.getViewId() == 39645 && (childFragmentManager = getChildFragmentManager()) != null) {
                        q a3 = childFragmentManager.a();
                        int i3 = R.id.fl_whats_new;
                        a.C0346a aVar2 = net.one97.paytm.paymentsBank.storefront.a.a.f19414a;
                        a3.b(i3, a.C0346a.a(false, next.getViews()), (String) null).c();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (bool != null && bool.booleanValue() && getContext() != null) {
            int i2 = this.aT.getInt("LAUNCH_COUNT", 0);
            if (n.d() == 0) {
                return;
            }
            if (i2 == n.d()) {
                if (!this.bb) {
                    net.one97.paytm.paymentsBank.updateInfo.a.f fVar = new net.one97.paytm.paymentsBank.updateInfo.a.f();
                    if (getActivity() != null) {
                        fVar.show(getActivity().getSupportFragmentManager(), "Update Info BottomSheet");
                        this.bb = true;
                        SharedPreferences.Editor edit = this.aT.edit();
                        edit.putInt("LAUNCH_COUNT", 0);
                        edit.apply();
                    }
                }
            } else if (i2 < n.d()) {
                SharedPreferences.Editor edit2 = this.aT.edit();
                edit2.putInt("LAUNCH_COUNT", i2 + 1);
                edit2.apply();
            }
        }
    }

    private void a(String str, boolean z2) {
        int i2 = this.aT.getInt(str, 0) + 1;
        SharedPreferences.Editor edit = this.aT.edit();
        if (z2) {
            i2 = 0;
        }
        edit.putInt(str, i2);
        edit.apply();
    }

    private void s() {
        if (!this.bb) {
            e a2 = e.a("addNominee");
            a2.a(this.be);
            if (getActivity() != null) {
                a2.show(getActivity().getSupportFragmentManager(), e.class.getName());
                this.bb = true;
                a("bank_nominee_launch_count", true);
            }
        }
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && isResumed()) {
            onResume();
        }
    }

    public void onResume() {
        super.onResume();
        try {
            FragmentActivity activity = getActivity();
            View findViewById = activity.findViewById(16908290);
            if (findViewById != null) {
                ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(findViewById.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
        com.paytm.utility.b.c((Activity) getActivity());
        if (getUserVisibleHint()) {
            this.ai = l.a().f19524a;
            if (!TextUtils.isEmpty(this.ai)) {
                if (UpiConstants.WALLET_TYPE_MONEY_TRANSFER.equals(this.ai)) {
                    O();
                    J();
                } else {
                    a(getActivity(), getString(R.string.pb_please_wait));
                }
            }
            G();
            h();
        }
    }

    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "savings_account_show_more_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        this.v.setText(getString(R.string.saving_acc_show_more_new, this.E));
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "linked_account_show_more_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        o.a().openWebViewActivity(this.G, n.n(), getString(R.string.paytm_payments_bank));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (this.aQ.e(8388613)) {
            this.aQ.d(8388613);
        } else {
            this.aQ.c(8388613);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public final void f() {
        this.aI = !TextUtils.isEmpty(com.paytm.utility.a.q(getContext()));
        net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (!TextUtils.isEmpty(net.one97.paytm.paymentsBank.utils.a.a())) {
            net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            String[] split = net.one97.paytm.paymentsBank.utils.a.a().split("##");
            if (split.length > 1) {
                this.E = split[0];
                this.F = split[1];
            }
        }
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.au.setLayoutManager(linearLayoutManager);
        this.x = new net.one97.paytm.paymentsBank.a.b(getContext(), this, this.aX);
        this.au.setAdapter(this.x);
        this.au.addOnScrollListener(new RecyclerView.l() {
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                int findFirstCompletelyVisibleItemPosition;
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && (findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition()) < b.this.x.f17288b) {
                    b.this.x.f17289c.setIndicator(findFirstCompletelyVisibleItemPosition);
                }
            }

            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        });
        net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (!net.one97.paytm.paymentsBank.utils.a.b()) {
            this.aP.setText(R.string.pb_rupay_platinum_debit_card);
        } else {
            this.aP.setText(R.string.debit_atm_card);
        }
        net.one97.paytm.paymentsBank.utils.a aVar4 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (net.one97.paytm.paymentsBank.utils.a.c()) {
            this.p.findViewById(R.id.lyt_faq).setVisibility(0);
        } else {
            this.p.findViewById(R.id.lyt_faq).setVisibility(8);
        }
        if (!o.a().showUPILinkingFragment(this, R.id.ll_upi_view)) {
            this.aE.setVisibility(8);
            this.aF.setVisibility(8);
        } else {
            this.aE.setVisibility(0);
            this.aF.setVisibility(0);
        }
        this.az = new CashFromNearestPaytmActivity.a(getActivity());
        if (j.a().equals("ISA")) {
            this.aD.setText(R.string.pb_saving_acc_bal);
            n();
            return;
        }
        this.aD.setText(R.string.pb_current_acc_bal);
        o();
    }

    public final void h() {
        String str;
        this.k.setText(String.format(getString(R.string.pb_fd_balance_details), new Object[]{this.F}));
        if (this.ap) {
            K();
        }
        this.aI = !TextUtils.isEmpty(com.paytm.utility.a.q(getContext()));
        w();
        x();
        k();
        if (j.b()) {
            y();
        } else {
            t();
        }
        TextView textView = (TextView) this.p.findViewById(R.id.total_balance_sub_heading);
        net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (!TextUtils.isEmpty(net.one97.paytm.paymentsBank.utils.a.d())) {
            net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            str = net.one97.paytm.paymentsBank.utils.a.d();
        } else {
            str = getString(R.string.total_bal_sub_heading);
        }
        textView.setText(str);
        net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (!TextUtils.isEmpty(net.one97.paytm.paymentsBank.utils.a.e())) {
            net.one97.paytm.paymentsBank.utils.a aVar4 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            ((TextView) this.p.findViewById(R.id.heading)).setText(net.one97.paytm.paymentsBank.utils.a.e());
        } else {
            ((TextView) this.p.findViewById(R.id.heading)).setText(getString(R.string.bank_wallet_heading));
        }
        this.v.setText(getString(R.string.pb_bank_interest_desc, this.E));
        this.u.findViewById(R.id.show_more).setVisibility(8);
        this.p.findViewById(R.id.card_read_more).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        this.as.setText(getString(R.string.fd_show_less_explicit, this.F));
        A();
        if (com.paytm.utility.b.c((Context) getActivity())) {
            this.aa.setVisibility(0);
            this.ab.setVisibility(8);
        } else {
            this.aa.setVisibility(8);
            this.ab.setVisibility(0);
        }
        net.one97.paytm.paymentsBank.utils.a aVar5 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (net.one97.paytm.paymentsBank.utils.a.f()) {
            this.at.setVisibility(0);
        } else {
            this.at.setVisibility(8);
        }
        net.one97.paytm.paymentsBank.utils.a aVar6 = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (net.one97.paytm.paymentsBank.utils.a.g()) {
            getChildFragmentManager().a().b(R.id.nachPendingLayout, new net.one97.paytm.paymentsBank.nach.a.a(), net.one97.paytm.paymentsBank.nach.a.a.class.getSimpleName()).c();
        }
        if (j.a().equals("ISA")) {
            n();
        } else {
            o();
        }
        net.one97.paytm.bankCommon.mapping.c.a("/bank/saving-account", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, this.G);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        ((TextView) this.p.findViewById(R.id.card_sub_heading)).setText(getString(R.string.use_card_online_more_payments_new));
        view.setVisibility(8);
    }

    private void t() {
        A();
        this.f18473g.setVisibility(0);
        this.aB.setVisibility(8);
        this.ar.setVisibility(8);
        this.o.setVisibility(0);
        this.aA.setVisibility(0);
    }

    private void a(c cVar) {
        if (isResumed() && this.H != null) {
            b(this.P);
            this.am = new BankDebitCardView(this.G);
            this.am.setDebitCardState(cVar);
            this.am.setForgotPasswordCallback(new BankDebitCardView.b() {
                public final void onClickForgotPassword() {
                    b.this.P();
                }
            });
            this.am.setBankCardListener(new BankDebitCardView.a() {
                public final void h() {
                }

                public final void a(c cVar) {
                    if (cVar == c.MASKED_CARD) {
                        b.this.x();
                    }
                }

                public final void g() {
                    b bVar = b.this;
                    bVar.p.findViewById(R.id.fragment_bank_tab_lyt).post(new Runnable(bVar.p.findViewById(R.id.fragment_bank_tab_lyt)) {
                        private final /* synthetic */ View f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            b.this.a(this.f$1);
                        }
                    });
                }

                public final void a(String str) {
                    if (b.this.getView() != null && b.this.isResumed()) {
                        b.this.f18474h.setText(str);
                    }
                }
            });
            this.am.a(this.H);
            this.am.setCardDetails(this.R);
            View findViewById = this.p.findViewById(R.id.fragment_bank_tab_lyt);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
            this.p.findViewById(R.id.tv_digital_debit).setVisibility(0);
            this.p.findViewById(R.id.card_sub_heading).setVisibility(8);
            this.p.findViewById(R.id.card_read_more).setVisibility(8);
            this.aW = true;
            net.one97.paytm.paymentsBank.utils.b bVar = this.aV;
            boolean z2 = this.aW;
            Context context = getContext();
            if (z2 && bVar.f19495a != null) {
                net.one97.paytm.paymentsBank.f.b bVar2 = bVar.f19495a;
                net.one97.paytm.paymentsBank.f.b.b bVar3 = new net.one97.paytm.paymentsBank.f.b.b();
                bVar3.f18350a = 2;
                bVar3.f18351b = 101;
                bVar3.f18352c = context.getString(R.string.drawer_heading_manage_debit_atm_card);
                bVar3.f18353d = context.getString(R.string.drawer_sub_heading_manage_debit_atm_card);
                bVar3.f18355f = R.drawable.drawer_manage_debit_card;
                bVar2.a(bVar3, 2);
            }
            ((FrameLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt)).removeAllViews();
            ((FrameLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt)).addView(this.am);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P() {
        net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
        if (net.one97.paytm.payments.c.c.b.b()) {
            net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
            net.one97.paytm.payments.c.c.b.d(getContext(), new Bundle());
        } else if (net.one97.paytm.bankCommon.mapping.a.c((Context) getActivity())) {
            ForgotPasscodeChallengesActivity.a((Context) getActivity());
        } else {
            r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ProgressDialog progressDialog, int i2, Object obj) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (i2 == 2) {
            Toast.makeText(this.G, R.string.some_went_wrong, 1).show();
        }
    }

    public final void a(int i2) {
        if (i2 == 10) {
            u();
        } else if (i2 != 10000) {
            switch (i2) {
                case 1:
                    if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "pay_icon_clicked", "", "", "/bank/pay-send", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        Intent intent = new Intent(getActivity(), o.a().getPaySendActivityClass());
                        intent.putExtra(UpiConstants.FROM, 100);
                        startActivity(intent);
                        return;
                    }
                    r();
                    return;
                case 2:
                    if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "money_transfer_icon_clicked", "", "", "/bank/money-transfer", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        J();
                        return;
                    }
                    r();
                    return;
                case 3:
                    if (getActivity() == null || !com.paytm.utility.b.c((Context) getActivity())) {
                        r();
                        return;
                    } else if (TextUtils.isEmpty(this.I) || this.K == null) {
                        Toast.makeText(getActivity(), getString(R.string.pb_please_wait), 0).show();
                        return;
                    } else {
                        Intent intent2 = new Intent(getActivity(), o.a().getAddMoneyToPPBActivityClass());
                        intent2.putExtra("add_money_source", "PPB");
                        o.a().putConvertedCustProductListonIntent(intent2, "cust_product_list", this.H);
                        o.a().putConvertedISADetailsonIntent(intent2, "ISA_DETAILS", this.K);
                        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "add_money_icon_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        intent2.putExtra("extra_account_number", this.I);
                        intent2.putExtra("extra_saving_balance", this.J);
                        intent2.putExtra("add_money_source", "PPB");
                        startActivity(intent2);
                        return;
                    }
                case 4:
                    if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "bhim_upi_icon_clicked", "", "", "/bank/bhim-upi/profile", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
                        if (!net.one97.paytm.paymentsBank.utils.a.h()) {
                            return;
                        }
                        if (com.paytm.utility.b.r(this.G)) {
                            ProgressDialog progressDialog = new ProgressDialog(this.G);
                            progressDialog.setMessage(getString(R.string.pb_please_wait));
                            progressDialog.setIndeterminate(true);
                            progressDialog.show();
                            o.a().openUPIActivity(this.G, this.D, this.aN, new d(progressDialog) {
                                private final /* synthetic */ ProgressDialog f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onFragmentAction(int i2, Object obj) {
                                    b.this.a(this.f$1, i2, obj);
                                }
                            });
                            return;
                        }
                        Intent intent3 = new Intent(this.G, o.a().getInfoActivityClass());
                        intent3.putExtra(UpiConstants.FROM, 100);
                        intent3.putExtra("resultant_activity", "upi");
                        startActivity(intent3);
                        return;
                    }
                    r();
                    return;
                case 5:
                    if (getActivity() == null || !com.paytm.utility.b.c((Context) getActivity())) {
                        r();
                        return;
                    }
                    net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "passbook_icon_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    if (!TextUtils.isEmpty(this.J)) {
                        o.a().openSavingPassbookWithBalance(getActivity(), this.J, this.I);
                        return;
                    } else {
                        Toast.makeText(getActivity(), getString(R.string.pb_please_wait), 0).show();
                        return;
                    }
                case 6:
                    if (getActivity() == null || !com.paytm.utility.b.c((Context) getActivity())) {
                        r();
                        return;
                    }
                    net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "pending_req_icon_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                    startActivity(new Intent(getActivity(), PBNachRequestListActivity.class));
                    return;
                case 7:
                    if (TextUtils.isEmpty(this.I)) {
                        com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_please_wait));
                        return;
                    } else if (getActivity() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("screen_name", getClass().getSimpleName());
                        net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.si.d.a.a(this.G, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                        if (!com.paytm.utility.b.c((Context) getActivity())) {
                            r();
                            return;
                        }
                        a(getActivity(), getString(R.string.pb_please_wait));
                        getActivity();
                        new net.one97.paytm.bankCommon.g.c();
                        net.one97.paytm.bankCommon.g.c.a(a2);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        } else {
            net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
            if (net.one97.paytm.payments.c.c.b.g()) {
                net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                net.one97.paytm.payments.c.c.b.f(getContext(), new Bundle());
                return;
            }
            startActivity(new Intent(getActivity(), CashFromNearestPaytmActivity.class));
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.network_retry_btn) {
            h();
        } else if (id == R.id.fragment_bank_tab_tv_paytm_wallet || id == R.id.fragment_bank_tab_lyt_paytm_wallet || id == R.id.linked_ac_layout_wallet) {
            if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                o.a().checkDeepLink(getActivity(), "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "wallet_tab_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                return;
            }
            r();
        } else if (id == R.id.total_layout) {
            if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                Intent intent = new Intent(getActivity(), o.a().getPassbookMainActivityClass());
                intent.putExtra("passbook_show_balance_default", true);
                startActivity(intent);
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "total_balance_strip_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                return;
            }
            r();
        } else if (id == R.id.fragment_bank_tab_tv_fd || id == R.id.fragment_bank_tab_lyt_fd || id == R.id.fragment_bank_tab_lyt_fd_not_opened || id == R.id.btn_fd_proceed) {
            if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                u();
            } else {
                r();
            }
        } else if (id == R.id.fragment_bank_tab_lyt || id == R.id.lyt_debit_card) {
            if (getActivity() != null && !com.paytm.utility.b.c((Context) getActivity())) {
                r();
            } else if (j.a().equals("ICA")) {
                Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
            } else if (this.H != null) {
                if (view.getId() == R.id.fragment_bank_tab_lyt) {
                    net.one97.paytm.bankCommon.mapping.c.a(this.G, "bank_saving_account", "personalized_atm_card_strip_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                } else {
                    net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "debit_and_atm_card_service_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                }
                Intent intent2 = new Intent(getActivity(), ManageDebitCardActivity.class);
                intent2.putExtra("CARD_DETAILS", this.R);
                intent2.putExtra("CUST_PRODUCT", this.H);
                net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
                if (net.one97.paytm.payments.c.c.b.d()) {
                    a((Bundle) null);
                } else if (view.getId() == R.id.fragment_bank_tab_lyt) {
                    intent2.putExtra("showasdialog", true);
                    startActivityForResult(intent2, 1245, androidx.core.app.b.a(getActivity(), view, getString(R.string.bank_pdc_transition_name)).a());
                } else {
                    startActivityForResult(intent2, 1245);
                }
            } else {
                Toast.makeText(getActivity(), getString(R.string.pb_please_wait), 0).show();
            }
        } else if (id == R.id.fragment_bank_tab_tv_savings_acc || id == R.id.fragment_bank_tab_lyt_savings_acc || id == R.id.lyt_passbook) {
            if (view.getId() == R.id.lyt_passbook) {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "passbook_account_statement_service_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            }
            if (view.getId() == R.id.fragment_bank_tab_tv_savings_acc || view.getId() == R.id.fragment_bank_tab_tv_savings_acc) {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "savings_account_tab_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            }
            if (getActivity() != null && !com.paytm.utility.b.c((Context) getActivity())) {
                r();
            } else if (!TextUtils.isEmpty(this.J)) {
                net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                if (net.one97.paytm.payments.c.c.b.e()) {
                    net.one97.paytm.payments.c.c.b bVar3 = net.one97.paytm.payments.c.c.b.f17264a;
                    net.one97.paytm.payments.c.c.b.c(getContext(), new Bundle());
                    return;
                }
                net.one97.paytm.paymentsBank.h.a a2 = o.a();
                FragmentActivity activity = getActivity();
                String str = this.J;
                String str2 = this.I;
                StringBuilder sb = new StringBuilder();
                sb.append(this.aS);
                a2.openInnerSavingAccPasscodeActivity(activity, str, str2, sb.toString(), j.a());
            } else {
                Toast.makeText(getActivity(), getString(R.string.please_wait), 0).show();
            }
        } else if (id == R.id.lyt_acc_nominee) {
            i();
        } else if (id == R.id.lyt_receive_money) {
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "recieve_money_icon_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            Intent intent3 = new Intent(getActivity(), ReceiveMoneyActivity.class);
            intent3.putExtra("ISA_DETAILS", this.K);
            startActivity(intent3);
        } else if (id == R.id.lyt_cheque_demand_draft) {
            p();
        } else if (id == R.id.tv_savings_share_details) {
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "share_account_details_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            l();
        } else if (id == R.id.lyt_faq) {
            if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "faq_tab_clicked", "", "", "/bank/savings-account", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                Intent intent4 = new Intent(getActivity(), o.a().getEmbeddedWebViewActivityClass());
                getActivity();
                net.one97.paytm.bankCommon.mapping.g.a();
                intent4.putExtra("url", net.one97.paytm.bankCommon.utils.d.a("bankPageFaq"));
                intent4.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "Frequently Asked Questions");
                startActivity(intent4);
                net.one97.paytm.bankCommon.mapping.c.a("/bank/faq", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, this.G);
                return;
            }
            r();
        } else if (id == R.id.lyt_contact_us) {
            if (getActivity() == null || com.paytm.utility.b.c((Context) getActivity())) {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", CJRGTMConstants.MT_V4_HELP_SUPPORT_CLICKED, "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                o.a().openHelpAndSupport(this.G, true);
                return;
            }
            r();
        } else if (id == R.id.p2b_tv) {
            if (getActivity() != null && !com.paytm.utility.b.c((Context) getActivity())) {
                r();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            a(getActivity(), getString(R.string.pb_please_wait));
            FragmentActivity activity2 = getActivity();
            a.c cVar = a.c.PAYMENTSBANK;
            a.b bVar4 = a.b.SILENT;
            if (activity2 != null) {
                activity2.getApplicationContext();
                net.one97.paytm.bankCommon.mapping.g.a();
                String a3 = net.one97.paytm.bankCommon.utils.d.a("p2bStatus");
                if (URLUtil.isValidUrl(a3)) {
                    String a4 = j.a(com.paytm.utility.b.e((Context) activity2, a3), new boolean[0]);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("ssotoken", com.paytm.utility.a.q(activity2));
                    hashMap2.put("Content-Type", "application/json");
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(SDKConstants.TXN_TYPE, "PAYER_TO_BANK_TRANSFER");
                        jSONObject2.put("ssoId", com.paytm.utility.b.n((Context) activity2));
                        jSONObject.put("request", jSONObject2);
                        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                        jSONObject.put("channel", UpiConstants.MP_ANDROID);
                        String Q2 = com.paytm.utility.b.Q((Context) activity2);
                        if (Q2 != null) {
                            jSONObject.put("version", Q2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    activity2.getApplicationContext();
                    new net.one97.paytm.bankCommon.g.c();
                    net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.b(a4, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new CJRP2BStatus(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar4, (HashMap<String, String>) hashMap));
                }
            }
        } else if (id == R.id.lyt_rates_and_charges) {
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "rates_and_charges_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            getActivity();
            net.one97.paytm.bankCommon.mapping.g.a();
            o.a().openWebViewActivity(getActivity(), net.one97.paytm.bankCommon.utils.d.a("ratesAndChargesUrl"), getString(R.string.pb_pdc_rate_and_charges));
            net.one97.paytm.bankCommon.mapping.c.a("/bank/rates-charges", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, this.G);
        } else if (id == R.id.lyt_atal_pension) {
            startActivity(new Intent(getActivity(), AtalPensionMainActivity.class));
        } else if (id == R.id.logout_tv) {
            j();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0175, code lost:
        if (r1.equals("NOT_APPLIED") != false) goto L_0x018d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u() {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r0.aO
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r1 = r0.I
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0022
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_please_wait
            java.lang.String r3 = r0.getString(r3)
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r3, r2)
            r1.show()
            return
        L_0x0022:
            boolean r1 = net.one97.paytm.paymentsBank.utils.j.b()
            if (r1 != 0) goto L_0x004b
            androidx.fragment.app.FragmentActivity r3 = r17.getActivity()
            double r4 = r0.ah
            java.lang.String r6 = r0.I
            double r7 = r0.ag
            android.os.Bundle r9 = r0.bc
            net.one97.paytm.paymentsBank.slfd.d.a((android.app.Activity) r3, (double) r4, (java.lang.String) r6, (double) r7, (android.os.Bundle) r9)
            androidx.fragment.app.FragmentActivity r10 = r17.getActivity()
            java.lang.String r11 = "bank_saving_account"
            java.lang.String r12 = "fixed_deposit_tab_clicked"
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            java.lang.String r15 = "/bank/savings-account/landing"
            java.lang.String r16 = "banksavingsaccount"
            net.one97.paytm.bankCommon.mapping.c.a(r10, r11, r12, r13, r14, r15, r16)
            return
        L_0x004b:
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r1 = r0.aH
            if (r1 == 0) goto L_0x020a
            java.lang.Object r1 = r1.getCifErrorMessage()
            if (r1 != 0) goto L_0x020a
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r1 = r0.aH
            java.lang.Integer r1 = r1.getCifStatusCode()
            if (r1 == 0) goto L_0x020a
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r1 = r0.aH
            java.lang.Integer r1 = r1.getCifStatusCode()
            int r1 = r1.intValue()
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 == r3) goto L_0x006d
            goto L_0x020a
        L_0x006d:
            androidx.fragment.app.FragmentActivity r4 = r17.getActivity()
            java.lang.String r5 = "bank_saving_account"
            java.lang.String r6 = "fixed_deposit_tab_clicked"
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = "/bank/savings-account/landing"
            java.lang.String r10 = "banksavingsaccount"
            net.one97.paytm.bankCommon.mapping.c.a(r4, r5, r6, r7, r8, r9, r10)
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r1 = r0.aH
            java.lang.String r1 = r1.getUserType()
            int r3 = r1.hashCode()
            java.lang.String r4 = "NOT_APPLIED"
            r5 = 4
            r6 = -1
            r7 = 3
            r8 = 2
            r9 = 1
            switch(r3) {
                case -287297839: goto L_0x00bd;
                case -75252643: goto L_0x00b3;
                case 539760169: goto L_0x00a9;
                case 1502863890: goto L_0x009f;
                case 1925346054: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x00c5
        L_0x0095:
            java.lang.String r3 = "ACTIVE"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c5
            r1 = 4
            goto L_0x00c6
        L_0x009f:
            java.lang.String r3 = "NOT_ACTIVE"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c5
            r1 = 3
            goto L_0x00c6
        L_0x00a9:
            java.lang.String r3 = "CIF_CREATED"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c5
            r1 = 2
            goto L_0x00c6
        L_0x00b3:
            java.lang.String r3 = "APPLIED"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c5
            r1 = 1
            goto L_0x00c6
        L_0x00bd:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00c5
            r1 = 0
            goto L_0x00c6
        L_0x00c5:
            r1 = -1
        L_0x00c6:
            if (r1 == 0) goto L_0x01d8
            if (r1 == r9) goto L_0x0153
            java.lang.String r2 = "home"
            if (r1 == r8) goto L_0x0123
            if (r1 == r7) goto L_0x00fa
            if (r1 == r5) goto L_0x00d3
            goto L_0x00f9
        L_0x00d3:
            net.one97.paytm.payments.c.c.b r1 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r1 = net.one97.paytm.payments.c.c.b.a()
            if (r1 == 0) goto L_0x00ea
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            net.one97.paytm.payments.c.c.b r3 = net.one97.paytm.payments.c.c.b.f17264a
            android.content.Context r3 = r17.getContext()
            net.one97.paytm.payments.c.c.b.a(r3, r1, r2)
            return
        L_0x00ea:
            androidx.fragment.app.FragmentActivity r4 = r17.getActivity()
            java.lang.String r5 = r0.I
            double r6 = r0.ag
            double r8 = r0.ah
            android.os.Bundle r10 = r0.bc
            net.one97.paytm.paymentsBank.slfd.d.a((android.app.Activity) r4, (java.lang.String) r5, (double) r6, (double) r8, (android.os.Bundle) r10)
        L_0x00f9:
            return
        L_0x00fa:
            net.one97.paytm.payments.c.c.b r1 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r1 = net.one97.paytm.payments.c.c.b.a()
            if (r1 == 0) goto L_0x0111
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            net.one97.paytm.payments.c.c.b r3 = net.one97.paytm.payments.c.c.b.f17264a
            android.content.Context r3 = r17.getContext()
            net.one97.paytm.payments.c.c.b.a(r3, r1, r2)
            return
        L_0x0111:
            androidx.fragment.app.FragmentActivity r4 = r17.getActivity()
            java.lang.String r5 = r0.I
            double r6 = r0.ag
            double r8 = r0.ah
            android.os.Bundle r11 = r0.bc
            java.lang.String r10 = "NOT_ACTIVE"
            net.one97.paytm.paymentsBank.slfd.d.a(r4, r5, r6, r8, r10, r11)
            return
        L_0x0123:
            net.one97.paytm.payments.c.c.b r1 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r1 = net.one97.paytm.payments.c.c.b.a()
            if (r1 == 0) goto L_0x013a
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            net.one97.paytm.payments.c.c.b r3 = net.one97.paytm.payments.c.c.b.f17264a
            android.content.Context r3 = r17.getContext()
            net.one97.paytm.payments.c.c.b.a(r3, r1, r2)
            return
        L_0x013a:
            boolean r1 = net.one97.paytm.paymentsBank.utils.n.e()
            if (r1 == 0) goto L_0x014f
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            java.lang.Class<net.one97.paytm.paymentsBank.cifCreation.view.activity.PostCIFCreatedActivity> r3 = net.one97.paytm.paymentsBank.cifCreation.view.activity.PostCIFCreatedActivity.class
            r1.<init>(r2, r3)
            r0.startActivity(r1)
            return
        L_0x014f:
            r17.v()
            return
        L_0x0153:
            boolean r1 = net.one97.paytm.paymentsBank.utils.n.e()
            if (r1 == 0) goto L_0x01d4
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r1 = r0.aH
            java.lang.String r1 = r1.getOnBoardingStatus()
            int r3 = r1.hashCode()
            switch(r3) {
                case -2125830485: goto L_0x0182;
                case -604548089: goto L_0x0178;
                case -287297839: goto L_0x0171;
                case 35394935: goto L_0x0167;
                default: goto L_0x0166;
            }
        L_0x0166:
            goto L_0x018c
        L_0x0167:
            java.lang.String r2 = "PENDING"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x018c
            r2 = 3
            goto L_0x018d
        L_0x0171:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x018c
            goto L_0x018d
        L_0x0178:
            java.lang.String r2 = "IN_PROGRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x018c
            r2 = 2
            goto L_0x018d
        L_0x0182:
            java.lang.String r2 = "ISSUED"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x018c
            r2 = 1
            goto L_0x018d
        L_0x018c:
            r2 = -1
        L_0x018d:
            if (r2 == 0) goto L_0x01c5
            if (r2 == r9) goto L_0x01b6
            if (r2 == r8) goto L_0x0196
            if (r2 == r7) goto L_0x0196
            goto L_0x01b5
        L_0x0196:
            net.one97.paytm.paymentsBank.createfd.utils.b$a r1 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r1 = r0.aH
            java.lang.String r1 = r1.getOnBoardedOn()
            long r1 = net.one97.paytm.paymentsBank.createfd.utils.b.a.a(r1)
            net.one97.paytm.paymentsBank.cifCreation.view.a.d$a r3 = net.one97.paytm.paymentsBank.cifCreation.view.a.d.f18033a
            net.one97.paytm.paymentsBank.cifCreation.view.a.d r1 = net.one97.paytm.paymentsBank.cifCreation.view.a.d.a.a(r1)
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            java.lang.String r3 = ""
            r1.show((androidx.fragment.app.j) r2, (java.lang.String) r3)
        L_0x01b5:
            return
        L_0x01b6:
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            java.lang.Class<net.one97.paytm.paymentsBank.cifCreation.view.activity.PostCIFCreatedActivity> r3 = net.one97.paytm.paymentsBank.cifCreation.view.activity.PostCIFCreatedActivity.class
            r1.<init>(r2, r3)
            r0.startActivity(r1)
            return
        L_0x01c5:
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            java.lang.Class<net.one97.paytm.paymentsBank.cifCreation.view.activity.CIFCreateActivity> r3 = net.one97.paytm.paymentsBank.cifCreation.view.activity.CIFCreateActivity.class
            r1.<init>(r2, r3)
            r0.startActivity(r1)
            return
        L_0x01d4:
            r17.v()
            return
        L_0x01d8:
            net.one97.paytm.payments.c.c.b r1 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r1 = net.one97.paytm.payments.c.c.b.a()
            if (r1 == 0) goto L_0x01f1
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            net.one97.paytm.payments.c.c.b r2 = net.one97.paytm.payments.c.c.b.f17264a
            android.content.Context r2 = r17.getContext()
            java.lang.String r3 = "offerings"
            net.one97.paytm.payments.c.c.b.a(r2, r1, r3)
            return
        L_0x01f1:
            boolean r1 = net.one97.paytm.paymentsBank.utils.n.e()
            if (r1 == 0) goto L_0x0206
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r17.getActivity()
            java.lang.Class<net.one97.paytm.paymentsBank.cifCreation.view.activity.CIFCreateActivity> r3 = net.one97.paytm.paymentsBank.cifCreation.view.activity.CIFCreateActivity.class
            r1.<init>(r2, r3)
            r0.startActivity(r1)
            return
        L_0x0206:
            r17.v()
            return
        L_0x020a:
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_please_wait
            java.lang.String r3 = r0.getString(r3)
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r3, r2)
            r1.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.fragment.b.u():void");
    }

    private void v() {
        startActivity(new Intent(getActivity(), FixedDepositOfferingActivity.class));
    }

    public final void i() {
        if (getActivity() != null && !com.paytm.utility.b.c((Context) getActivity())) {
            r();
        } else if (this.m) {
            if (!TextUtils.isEmpty(this.I)) {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "account_nominee_service_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                Intent intent = new Intent(getActivity(), AJRNomineeDetails.class);
                intent.putExtra("NOMINEE_ITEM", this.T);
                intent.putExtra("extra_account_number", this.I);
                intent.putExtra("isEditable", true);
                startActivityForResult(intent, 110);
                return;
            }
            com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_please_wait));
        } else if (j.a().equals("ICA")) {
            Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
        } else if (this.H != null) {
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "add_nominee_service_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            if (net.one97.paytm.bankCommon.h.b.a(getActivity())) {
                Intent intent2 = new Intent(this.G, AJREnterPasscode.class);
                intent2.putExtra("ENTER_HEADER", "ADD_NOMINEE");
                intent2.putExtra("CUST_PRODUCT", this.H);
                intent2.putExtra("REDIRECT_TO", f.a.ADD_NOMINEE.ordinal());
                startActivityForResult(intent2, 6734);
                return;
            }
            startActivityForResult(new Intent(this.G, AJREnterPasscode.class), 6982);
        } else {
            Toast.makeText(getActivity(), getString(R.string.pb_please_wait), 0).show();
        }
    }

    public final void j() {
        c.a aVar = new c.a(getActivity());
        aVar.b((CharSequence) getString(R.string.pb_are_sure_logout_desc));
        aVar.a(true);
        aVar.a(R.string.pb_home_logout_from_bank_btn_txt, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                b.this.c(dialogInterface, i2);
            }
        });
        aVar.b(R.string.pb_home_cancel_from_bank_btn_txt, (DialogInterface.OnClickListener) $$Lambda$b$JMCvT1sVY0M8fhdOWUZ42EZnxWo.INSTANCE);
        aVar.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i2) {
        net.one97.paytm.paymentsBank.customView.a.a(net.one97.paytm.paymentsBank.customView.c.MASKED_CARD);
        net.one97.paytm.paymentsBank.customView.a.c();
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(new Intent("templogout"));
        dialogInterface.dismiss();
    }

    public final void k() {
        try {
            if (this.aI && com.paytm.utility.b.c(this.G)) {
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                j.a();
                net.one97.paytm.bankCommon.g.f b2 = net.one97.paytm.paymentsBank.b.a.b(this.G, "ISA", (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
                this.G.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(b2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1245 && i3 == -1) {
            x();
        } else if (i2 == 6982 && i3 == -1) {
            View view = this.p;
            if (view != null) {
                view.findViewById(R.id.lyt_acc_nominee).performClick();
            }
        } else if (i2 == 6734 && i3 == -1) {
            if (!TextUtils.isEmpty(this.I)) {
                Intent intent2 = new Intent(this.G, PaymentsBankBaseActivity.class);
                intent2.putExtra("extraDefaultFrame", 2);
                intent2.putExtra("DO_CREATE_ACCOUNT", false);
                intent2.putExtra("ACCOUNT_NUMBER", this.I);
                startActivityForResult(intent2, 6534);
            }
        } else if (i2 == 6534 && i3 == -1) {
            H();
        } else if (i2 == 110 && i3 == -1) {
            this.T = (NomineeModel) intent.getSerializableExtra("NOMINEE_ITEM");
        } else if (i2 == 7 && i3 == -1) {
            if (intent != null && intent.hasExtra("forgot_passcode_access")) {
                Intent intent3 = new Intent(getActivity(), AJRForgotPasscode.class);
                intent3.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
                startActivityForResult(intent3, 6982);
            }
        } else if (i2 == 1205 && intent != null && intent.hasExtra("biometric_setting") && getParentFragment() != null && (getParentFragment() instanceof BankTabPasscodeFragment)) {
            BankTabPasscodeFragment bankTabPasscodeFragment = (BankTabPasscodeFragment) getParentFragment();
            boolean booleanExtra = intent.getBooleanExtra("biometric_setting", false);
            if (bankTabPasscodeFragment.isAdded() && bankTabPasscodeFragment.getActivity() != null && !bankTabPasscodeFragment.getActivity().isFinishing() && !bankTabPasscodeFragment.getActivity().isDestroyed()) {
                bankTabPasscodeFragment.f18450c.setText("");
                int i4 = 8;
                bankTabPasscodeFragment.f18450c.setVisibility(booleanExtra ? 0 : 8);
                View view2 = bankTabPasscodeFragment.f18449b;
                if (booleanExtra) {
                    i4 = 0;
                }
                view2.setVisibility(i4);
                if (booleanExtra) {
                    bankTabPasscodeFragment.b();
                }
            }
        }
    }

    private void w() {
        try {
            this.ac = -1.0d;
            this.G.getApplicationContext();
            net.one97.paytm.bankCommon.mapping.g.a();
            String a2 = net.one97.paytm.bankCommon.utils.d.a("check_user_balance_service");
            if (a2 != null && URLUtil.isValidUrl(a2)) {
                if (this.aI) {
                    String a3 = j.a(com.paytm.utility.b.e(this.G, a2), new boolean[0]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.paytm.utility.a.q(this.G));
                    hashMap.put("Accept-Encoding", "gzip");
                    new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(this.G));
                    com.paytm.utility.b.j();
                    if (com.paytm.utility.b.c(this.G)) {
                        if (!this.q) {
                            a(this.O);
                        }
                        if (!this.q && !this.r) {
                            a(this.Q);
                        }
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("screen_name", getClass().getSimpleName());
                        net.one97.paytm.bankCommon.g.b bVar = new net.one97.paytm.bankCommon.g.b(a3, (g.b<IJRPaytmDataModel>) this, (g.a) this, (IJRPaytmDataModel) new CJRCashWallet(), (Map<String, String>) null, (Map<String, String>) hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
                        bVar.f16270b = "cashWalletApi";
                        this.G.getApplicationContext();
                        new net.one97.paytm.bankCommon.g.c();
                        net.one97.paytm.bankCommon.g.c.a(bVar);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        if (this.aI && com.paytm.utility.b.c(this.G)) {
            if (!this.r) {
                a(this.N);
                a(this.L);
                a(this.M);
                a(this.P);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.b.a.a(this.G, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            a2.f16270b = "custProductListApi";
            this.G.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
        }
    }

    private void y() {
        if (this.aI && com.paytm.utility.b.c(this.G)) {
            String str = !j.b() ? "ica" : "isa";
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.b.a.a(this.G, str, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            a2.f16270b = "fixedDepositStatusApi";
            this.G.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
        }
    }

    private void z() {
        if (this.aK != null) {
            CustProductStatus custProductStatus = this.t;
            if (custProductStatus == null || custProductStatus.getKycDetailsResponse() == null || TextUtils.isEmpty(this.t.getKycDetailsResponse().getSeniorCitizen())) {
                this.aK.setFdSubheadingText(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, this.F);
            } else {
                this.aK.setFdSubheadingText(this.t.getKycDetailsResponse().getSeniorCitizen(), this.F);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x07f2  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x07fc  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0806  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0810  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x081a  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0822 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0825  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x08e9  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0903  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x090f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(com.paytm.network.model.IJRPaytmDataModel r21) {
        /*
            r20 = this;
            r9 = r20
            r0 = r21
            boolean r1 = r20.isAdded()
            if (r1 != 0) goto L_0x000b
            return
        L_0x000b:
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            if (r1 == 0) goto L_0x002c
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            boolean r1 = r1.isDestroyed()
            if (r1 != 0) goto L_0x002c
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            boolean r1 = r1.isFinishing()
            if (r1 != 0) goto L_0x002c
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            com.google.android.play.core.splitcompat.a.a((android.content.Context) r1)
        L_0x002c:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRCashWallet
            r10 = 2
            r11 = 1
            r12 = 0
            if (r1 == 0) goto L_0x00d5
            r9.q = r11
            net.one97.paytm.common.entity.wallet.CJRCashWallet r0 = (net.one97.paytm.common.entity.wallet.CJRCashWallet) r0
            r9.ao = r0
            com.airbnb.lottie.LottieAnimationView r0 = r9.O
            b((com.airbnb.lottie.LottieAnimationView) r0)
            net.one97.paytm.common.entity.wallet.CJRCashWallet r0 = r9.ao
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r0 = r0.getResponse()
            if (r0 == 0) goto L_0x091d
            net.one97.paytm.common.entity.wallet.CJRCashWallet r0 = r9.ao
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r0 = r0.getResponse()
            double r0 = r0.getTotalBalance()
            r9.ac = r0
            double r0 = r9.ac
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r0 = net.one97.paytm.bankCommon.mapping.a.c(r0)
            android.content.Context r1 = r9.G
            double r2 = r9.ac
            net.one97.paytm.bankCommon.mapping.e.a(r1, r2)
            net.one97.paytm.common.entity.wallet.CJRCashWallet r1 = r9.ao
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r1 = r1.getResponse()
            java.util.List r1 = r1.getSubWalletDetailList()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            if (r1 == 0) goto L_0x00a6
            java.util.Iterator r1 = r1.iterator()
        L_0x0078:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0091
            java.lang.Object r3 = r1.next()
            net.one97.paytm.common.entity.wallet.CJRSubWallet r3 = (net.one97.paytm.common.entity.wallet.CJRSubWallet) r3
            java.lang.String r3 = r3.getDisplayName()
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            goto L_0x0078
        L_0x0091:
            int r1 = r2.length()
            if (r1 <= r10) goto L_0x00a6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r2.length()
            int r3 = r3 - r10
            java.lang.String r2 = r2.substring(r12, r3)
            r1.<init>(r2)
            goto L_0x00a7
        L_0x00a6:
            r1 = r2
        L_0x00a7:
            com.paytm.utility.RoboTextView r2 = r9.j
            int r3 = net.one97.paytm.paymentsBank.R.string.pb_includes_balance
            java.lang.String r3 = r9.getString(r3)
            java.lang.Object[] r4 = new java.lang.Object[r11]
            java.lang.String r1 = r1.toString()
            r4[r12] = r1
            java.lang.String r1 = java.lang.String.format(r3, r4)
            r2.setText(r1)
            int r1 = net.one97.paytm.common.assets.R.string.rs_str
            java.lang.String r1 = r9.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r12] = r0
            java.lang.String r0 = java.lang.String.format(r1, r2)
            com.paytm.utility.RoboTextView r1 = r9.f18471e
            net.one97.paytm.bankCommon.mapping.e.a((java.lang.String) r0, (android.widget.TextView) r1)
            r20.I()
            return
        L_0x00d5:
            boolean r1 = r0 instanceof net.one97.paytm.bankCommon.model.CustProductList
            java.lang.String r13 = "ISSUED"
            java.lang.String r14 = "NOT_APPLIED"
            r15 = 0
            r8 = 8
            if (r1 == 0) goto L_0x03ca
            net.one97.paytm.bankCommon.model.CustProductList r0 = (net.one97.paytm.bankCommon.model.CustProductList) r0
            r9.H = r0
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getErrorMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x03b8
            d.a.a.c r0 = d.a.a.c.a()
            net.one97.paytm.bankCommon.model.CustProductList r1 = r9.H
            r0.c(r1)
            net.one97.paytm.paymentsBank.utils.a r0 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            net.one97.paytm.paymentsBank.utils.a.j(r0)
            net.one97.paytm.paymentsBank.utils.a r0 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            boolean r0 = net.one97.paytm.paymentsBank.utils.a.a(r0)
            if (r0 == 0) goto L_0x0367
            net.one97.paytm.paymentsBank.utils.a r0 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = net.one97.paytm.paymentsBank.utils.a.a(r0, true)
            r9.I = r0
            net.one97.paytm.paymentsBank.utils.a r0 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r16 = net.one97.paytm.paymentsBank.utils.a.h(r0)
            java.lang.String r0 = r9.I
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0366
            java.lang.String r1 = r9.I
            java.lang.String r7 = net.one97.paytm.paymentsBank.utils.j.a()
            android.content.Context r0 = r9.G
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            java.lang.String r6 = "screen_name"
            if (r0 == 0) goto L_0x0176
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r9.ad = r2
            r9.ae = r2
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.Class r0 = r20.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r5.put(r6, r0)
            android.content.Context r0 = r9.G
            com.paytm.network.a$c r4 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r17 = com.paytm.network.a.b.SILENT
            r2 = r20
            r3 = r20
            r18 = r5
            r5 = r17
            r19 = r6
            r6 = r18
            r10 = 8
            r8 = r16
            net.one97.paytm.bankCommon.g.f r0 = net.one97.paytm.paymentsBank.b.a.a((android.content.Context) r0, (java.lang.String) r1, (net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel>) r2, (net.one97.paytm.bankCommon.g.g.a) r3, (com.paytm.network.a.c) r4, (com.paytm.network.a.b) r5, (java.util.HashMap<java.lang.String, java.lang.String>) r6, (java.lang.String) r7, (java.lang.String) r8)
            java.lang.String r1 = "bankSummaryApi"
            r0.f16270b = r1
            android.content.Context r1 = r9.G
            r1.getApplicationContext()
            net.one97.paytm.bankCommon.g.c r1 = new net.one97.paytm.bankCommon.g.c
            r1.<init>()
            net.one97.paytm.bankCommon.g.c.a(r0)
            goto L_0x017a
        L_0x0176:
            r19 = r6
            r10 = 8
        L_0x017a:
            java.lang.String r0 = net.one97.paytm.paymentsBank.utils.j.a()
            java.lang.String r1 = "ISA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x018a
            r20.H()
            goto L_0x01e5
        L_0x018a:
            java.lang.String r0 = net.one97.paytm.paymentsBank.utils.j.a()
            java.lang.String r1 = "ICA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01e0
            com.airbnb.lottie.LottieAnimationView r0 = r9.M
            b((com.airbnb.lottie.LottieAnimationView) r0)
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            net.one97.paytm.bankCommon.model.CustProductList$Ica r0 = r0.getIca()
            if (r0 == 0) goto L_0x01d9
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            net.one97.paytm.bankCommon.model.CustProductList$Ica r0 = r0.getIca()
            java.lang.String r0 = r0.getCaId()
            android.content.Context r1 = r20.getContext()
            net.one97.paytm.bankCommon.h.c.a(r0, r1)
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            net.one97.paytm.bankCommon.model.CustProductList$Ica r0 = r0.getIca()
            java.util.List r0 = r0.getNominees()
            r9.a((java.util.List<net.one97.paytm.bankCommon.model.NomineeModel>) r0)
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            net.one97.paytm.bankCommon.model.CustProductList$Ica r0 = r0.getIca()
            java.lang.String r0 = r0.getAccountNumber()
            net.one97.paytm.bankCommon.model.CustProductList r1 = r9.H
            net.one97.paytm.bankCommon.model.CustProductList$Ica r1 = r1.getIca()
            java.lang.String r1 = r1.getIfscCode()
            r9.b((java.lang.String) r0, (java.lang.String) r1)
            goto L_0x01e5
        L_0x01d9:
            r9.a((java.util.List<net.one97.paytm.bankCommon.model.NomineeModel>) r15)
            r9.b((java.lang.String) r15, (java.lang.String) r15)
            goto L_0x01e5
        L_0x01e0:
            com.airbnb.lottie.LottieAnimationView r0 = r9.M
            b((com.airbnb.lottie.LottieAnimationView) r0)
        L_0x01e5:
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getVdcStatus()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0252
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getVdcStatus()
            boolean r0 = r0.equalsIgnoreCase(r13)
            if (r0 == 0) goto L_0x0252
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getVdcCardStatus()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x024e
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getVdcCardStatus()
            java.lang.String r1 = "NORMAL"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0227
            net.one97.paytm.bankCommon.model.PBCardDetailModel r0 = r9.R
            if (r0 == 0) goto L_0x0221
            net.one97.paytm.paymentsBank.customView.c r0 = net.one97.paytm.paymentsBank.customView.c.FULL_CARD
            r9.a((net.one97.paytm.paymentsBank.customView.c) r0)
            goto L_0x0240
        L_0x0221:
            net.one97.paytm.paymentsBank.customView.c r0 = net.one97.paytm.paymentsBank.customView.c.MASKED_CARD
            r9.a((net.one97.paytm.paymentsBank.customView.c) r0)
            goto L_0x0240
        L_0x0227:
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getVdcCardStatus()
            java.lang.String r1 = "RESTRICTED_BLOCK"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x023b
            net.one97.paytm.paymentsBank.customView.c r0 = net.one97.paytm.paymentsBank.customView.c.RESTRICTED_BLOCK
            r9.a((net.one97.paytm.paymentsBank.customView.c) r0)
            goto L_0x0240
        L_0x023b:
            net.one97.paytm.paymentsBank.customView.c r0 = net.one97.paytm.paymentsBank.customView.c.BLOCK_CARD
            r9.a((net.one97.paytm.paymentsBank.customView.c) r0)
        L_0x0240:
            net.one97.paytm.paymentsBank.f.a.a r0 = r9.aR
            net.one97.paytm.paymentsBank.f.b r1 = r0.f18318b
            net.one97.paytm.paymentsBank.fragment.b r0 = r0.f18317a
            java.util.List r0 = net.one97.paytm.paymentsBank.f.c.a.a(r0, r11)
            r1.a(r0)
            goto L_0x0255
        L_0x024e:
            r20.B()
            goto L_0x0255
        L_0x0252:
            r20.B()
        L_0x0255:
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            java.lang.String r0 = r0.getPdcStatus()
            boolean r1 = r14.equals(r0)
            if (r1 != 0) goto L_0x0270
            java.lang.String r1 = "LEAD"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x026a
            goto L_0x0270
        L_0x026a:
            android.view.View r0 = r9.aj
            r0.setVisibility(r10)
            goto L_0x0275
        L_0x0270:
            android.view.View r0 = r9.aj
            r0.setVisibility(r12)
        L_0x0275:
            net.one97.paytm.paymentsBank.accntfreeze.a r0 = net.one97.paytm.paymentsBank.accntfreeze.a.a()
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            int r2 = net.one97.paytm.paymentsBank.R.id.freezeContainer
            r3 = 2
            int[] r3 = new int[r3]
            int r4 = net.one97.paytm.paymentsBank.R.id.svblockedacc
            r3[r12] = r4
            int r4 = net.one97.paytm.paymentsBank.R.id.fdblockedacc
            r3[r11] = r4
            net.one97.paytm.paymentsBank.accntfreeze.a r0 = r0.a(r1, r2, r3)
            net.one97.paytm.bankCommon.model.CustProductList r1 = r9.H
            r0.f17337a = r1
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            r0.a(r1)
            r20.G()
            boolean r0 = net.one97.paytm.paymentsBank.utils.n.F()
            boolean r1 = net.one97.paytm.paymentsBank.utils.n.G()
            if (r0 != 0) goto L_0x02ac
            if (r1 == 0) goto L_0x0366
        L_0x02ac:
            net.one97.paytm.paymentsBank.storefront.model.b r0 = r9.aG
            android.content.Context r1 = r20.getContext()
            java.lang.String r2 = "context"
            kotlin.g.b.k.c(r1, r2)
            net.one97.paytm.paymentsBank.h.a r2 = net.one97.paytm.paymentsBank.utils.o.a()
            java.lang.String r3 = "kycFetchProfileInfoV2"
            java.lang.String r2 = r2.getStringFromGTM(r3)
            java.lang.String r3 = com.paytm.utility.a.q(r1)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0366
            java.lang.String r2 = com.paytm.utility.b.e((android.content.Context) r1, (java.lang.String) r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            if (r2 != 0) goto L_0x02db
            kotlin.g.b.k.a()
        L_0x02db:
            r3.append(r2)
            java.lang.String r2 = "&fields=profileStatus"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = "&profileParams=MINKYC,FULLKYC,VERIFIEDAADHAR,VERIFIEDPAN"
            r3.append(r2)
            java.lang.String r11 = r3.toString()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r15 = r2
            java.util.Map r15 = (java.util.Map) r15
            android.content.Context r2 = r1.getApplicationContext()
            java.lang.String r2 = com.paytm.utility.a.q(r2)
            java.lang.String r3 = "CJRNetUtility.getSSOToke…ntext.applicationContext)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = "session_token"
            r15.put(r3, r2)
            net.one97.paytm.common.entity.CJRAadharPanGet r2 = new net.one97.paytm.common.entity.CJRAadharPanGet
            r2.<init>()
            java.util.HashMap r18 = new java.util.HashMap
            r18.<init>()
            r3 = r18
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.String r5 = "javaClass.simpleName"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = r19
            r3.put(r5, r4)
            net.one97.paytm.bankCommon.g.a r3 = new net.one97.paytm.bankCommon.g.a
            net.one97.paytm.paymentsBank.storefront.model.b$a r4 = new net.one97.paytm.paymentsBank.storefront.model.b$a
            r4.<init>(r0)
            r12 = r4
            net.one97.paytm.bankCommon.g.g$b r12 = (net.one97.paytm.bankCommon.g.g.b) r12
            net.one97.paytm.paymentsBank.storefront.model.b$b r0 = new net.one97.paytm.paymentsBank.storefront.model.b$b
            r0.<init>()
            r13 = r0
            net.one97.paytm.bankCommon.g.g$a r13 = (net.one97.paytm.bankCommon.g.g.a) r13
            r14 = r2
            com.paytm.network.model.IJRPaytmDataModel r14 = (com.paytm.network.model.IJRPaytmDataModel) r14
            com.paytm.network.a$c r16 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r17 = com.paytm.network.a.b.USER_FACING
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            android.content.Context r0 = r1.getApplicationContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0366
            r1.getApplicationContext()
            net.one97.paytm.bankCommon.g.c r0 = new net.one97.paytm.bankCommon.g.c
            r0.<init>()
            net.one97.paytm.bankCommon.g.f r3 = (net.one97.paytm.bankCommon.g.f) r3
            net.one97.paytm.bankCommon.g.c.a(r3)
        L_0x0366:
            return
        L_0x0367:
            r20.B()
            com.airbnb.lottie.LottieAnimationView r0 = r9.M
            b((com.airbnb.lottie.LottieAnimationView) r0)
            com.airbnb.lottie.LottieAnimationView r0 = r9.O
            b((com.airbnb.lottie.LottieAnimationView) r0)
            com.airbnb.lottie.LottieAnimationView r0 = r9.N
            b((com.airbnb.lottie.LottieAnimationView) r0)
            com.airbnb.lottie.LottieAnimationView r0 = r9.L
            b((com.airbnb.lottie.LottieAnimationView) r0)
            net.one97.paytm.paymentsBank.utils.a r0 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            boolean r0 = net.one97.paytm.paymentsBank.utils.a.b(r0)
            if (r0 != 0) goto L_0x0392
            net.one97.paytm.paymentsBank.utils.a r0 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r0 = r9.H
            boolean r0 = net.one97.paytm.paymentsBank.utils.a.c(r0)
            if (r0 == 0) goto L_0x091d
        L_0x0392:
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            net.one97.paytm.paymentsBank.h.a r2 = net.one97.paytm.paymentsBank.utils.o.a()
            java.lang.Class r2 = r2.getMainActivityClass()
            r0.<init>(r1, r2)
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r0.addFlags(r1)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)
            java.lang.String r1 = "resultant fragment type"
            java.lang.String r2 = "main"
            r0.putExtra(r1, r2)
            r9.startActivity(r0)
            return
        L_0x03b8:
            android.content.Context r0 = r9.G
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r9.getString(r1)
            net.one97.paytm.bankCommon.model.CustProductList r2 = r9.H
            java.lang.String r2 = r2.getErrorMessage()
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)
            return
        L_0x03ca:
            r10 = 8
            boolean r1 = r0 instanceof net.one97.paytm.bankCommon.model.PBCJRAccountSummary
            if (r1 == 0) goto L_0x04c2
            net.one97.paytm.bankCommon.model.PBCJRAccountSummary r0 = (net.one97.paytm.bankCommon.model.PBCJRAccountSummary) r0
            r9.r = r11
            com.airbnb.lottie.LottieAnimationView r1 = r9.N
            b((com.airbnb.lottie.LottieAnimationView) r1)
            com.airbnb.lottie.LottieAnimationView r1 = r9.L
            b((com.airbnb.lottie.LottieAnimationView) r1)
            java.lang.String r1 = "-----"
            if (r0 == 0) goto L_0x04a9
            java.lang.String r2 = r0.getStatus()
            if (r2 == 0) goto L_0x04a9
            java.lang.String r2 = r0.getStatus()
            java.lang.String r3 = "success"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x04a9
            java.util.ArrayList r2 = r0.getAccounts()
            if (r2 == 0) goto L_0x04c1
            java.util.ArrayList r2 = r0.getAccounts()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x04c1
            double r2 = r0.getSlfdBalance()
            r9.ad = r2
            double r2 = r0.getEffectiveBalance()
            r9.ae = r2
            double r2 = r9.ad
            r9.ah = r2
            double r2 = r9.ae
            r9.ag = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.ArrayList r3 = r0.getAccounts()
            java.lang.Object r3 = r3.get(r12)
            net.one97.paytm.bankCommon.model.PBAccountBalanceModel r3 = (net.one97.paytm.bankCommon.model.PBAccountBalanceModel) r3
            double r3 = r3.getEffectiveBalance()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r9.J = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.util.ArrayList r0 = r0.getAccounts()
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.bankCommon.model.PBAccountBalanceModel r0 = (net.one97.paytm.bankCommon.model.PBAccountBalanceModel) r0
            double r3 = r0.getSlfdBalance()
            r2.append(r3)
            java.lang.String r0 = r2.toString()
            int r2 = net.one97.paytm.common.assets.R.string.rs_str
            java.lang.String r2 = r9.getString(r2)
            java.lang.Object[] r3 = new java.lang.Object[r11]
            java.lang.String r4 = r9.J
            java.lang.String r4 = net.one97.paytm.bankCommon.mapping.a.ac(r4)
            r3[r12] = r4
            java.lang.String r2 = java.lang.String.format(r2, r3)
            com.paytm.utility.RoboTextView r3 = r9.f18472f
            net.one97.paytm.bankCommon.mapping.e.a((java.lang.String) r2, (android.widget.TextView) r3)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0487
            int r1 = net.one97.paytm.common.assets.R.string.rs_str
            java.lang.String r1 = r9.getString(r1)
            java.lang.Object[] r2 = new java.lang.Object[r11]
            java.lang.String r0 = net.one97.paytm.bankCommon.mapping.a.ac(r0)
            r2[r12] = r0
            java.lang.String r0 = java.lang.String.format(r1, r2)
            com.paytm.utility.RoboTextView r1 = r9.f18473g
            net.one97.paytm.bankCommon.mapping.e.a((java.lang.String) r0, (android.widget.TextView) r1)
            r9.aO = r11
            goto L_0x049f
        L_0x0487:
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setText(r1)
            androidx.fragment.app.FragmentActivity r0 = r20.getActivity()
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r9.getString(r1)
            int r2 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r2 = r9.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x049f:
            r20.I()
            r20.D()
            r20.E()
            return
        L_0x04a9:
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setText(r1)
            androidx.fragment.app.FragmentActivity r0 = r20.getActivity()
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r9.getString(r1)
            int r2 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r2 = r9.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x04c1:
            return
        L_0x04c2:
            boolean r1 = r0 instanceof net.one97.paytm.bankCommon.model.IsaDetailsModel
            if (r1 == 0) goto L_0x04fc
            net.one97.paytm.bankCommon.model.IsaDetailsModel r0 = (net.one97.paytm.bankCommon.model.IsaDetailsModel) r0
            r9.K = r0
            d.a.a.c r0 = d.a.a.c.a()
            net.one97.paytm.bankCommon.model.IsaDetailsModel r1 = r9.K
            r0.c(r1)
            com.airbnb.lottie.LottieAnimationView r0 = r9.M
            b((com.airbnb.lottie.LottieAnimationView) r0)
            boolean r0 = r20.isResumed()
            if (r0 != 0) goto L_0x04df
            return
        L_0x04df:
            net.one97.paytm.bankCommon.model.IsaDetailsModel r0 = r9.K
            if (r0 == 0) goto L_0x04e7
            java.util.ArrayList r15 = r0.getNomineeList()
        L_0x04e7:
            r9.a((java.util.List<net.one97.paytm.bankCommon.model.NomineeModel>) r15)
            net.one97.paytm.bankCommon.model.IsaDetailsModel r0 = r9.K
            if (r0 == 0) goto L_0x091d
            java.lang.String r0 = r0.getAccountNumber()
            net.one97.paytm.bankCommon.model.IsaDetailsModel r1 = r9.K
            java.lang.String r1 = r1.getIfscCode()
            r9.b((java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x04fc:
            boolean r1 = r0 instanceof net.one97.paytm.bankCommon.model.PBCardDetailModel
            if (r1 == 0) goto L_0x0513
            net.one97.paytm.bankCommon.model.PBCardDetailModel r0 = (net.one97.paytm.bankCommon.model.PBCardDetailModel) r0
            r9.R = r0
            net.one97.paytm.paymentsBank.customView.c r0 = net.one97.paytm.paymentsBank.customView.c.FULL_CARD
            r9.a((net.one97.paytm.paymentsBank.customView.c) r0)
            d.a.a.c r0 = d.a.a.c.a()
            net.one97.paytm.bankCommon.model.PBCardDetailModel r1 = r9.R
            r0.c(r1)
            return
        L_0x0513:
            boolean r1 = r0 instanceof net.one97.paytm.bankCommon.model.PBBankStoreFrontModel
            if (r1 == 0) goto L_0x0644
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel r0 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel) r0
            if (r0 == 0) goto L_0x0643
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r2 = r0.getPage()
            if (r2 == 0) goto L_0x05e0
            java.util.List r2 = r0.getPage()
            java.lang.Object r2 = r2.get(r12)
            if (r2 == 0) goto L_0x05e0
            java.util.List r2 = r0.getPage()
            java.lang.Object r2 = r2.get(r12)
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel$Page r2 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel.Page) r2
            java.util.List r2 = r2.getViews()
            if (r2 == 0) goto L_0x05e0
            java.util.List r2 = r0.getPage()
            java.lang.Object r2 = r2.get(r12)
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel$Page r2 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel.Page) r2
            java.util.List r2 = r2.getViews()
            java.lang.Object r2 = r2.get(r12)
            if (r2 == 0) goto L_0x05e0
            java.util.List r2 = r0.getPage()
            java.lang.Object r2 = r2.get(r12)
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel$Page r2 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel.Page) r2
            java.util.List r2 = r2.getViews()
            java.lang.Object r2 = r2.get(r12)
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel$View r2 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel.View) r2
            java.util.List r2 = r2.getItems()
            if (r2 == 0) goto L_0x05e0
            java.util.List r0 = r0.getPage()
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel$Page r0 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel.Page) r0
            java.util.List r0 = r0.getViews()
            java.lang.Object r0 = r0.get(r12)
            net.one97.paytm.bankCommon.model.PBBankStoreFrontModel$View r0 = (net.one97.paytm.bankCommon.model.PBBankStoreFrontModel.View) r0
            java.util.List r0 = r0.getItems()
            r1.addAll(r0)
            net.one97.paytm.paymentsBank.a.f r0 = new net.one97.paytm.paymentsBank.a.f
            androidx.fragment.app.FragmentActivity r2 = r20.getActivity()
            r0.<init>(r2, r1)
            androidx.viewpager.widget.ViewPager r2 = r9.n
            r2.setAdapter(r0)
            net.one97.paytm.common.widgets.CirclePageIndicator r2 = r9.X
            androidx.viewpager.widget.ViewPager r3 = r9.n
            r2.setViewPager(r3)
            r0.notifyDataSetChanged()
            int r0 = r1.size()
            r2 = 2
            if (r0 <= r2) goto L_0x05e0
            int r0 = r1.size()
            android.os.Handler r2 = new android.os.Handler
            r2.<init>()
            r9.Z = r2
            net.one97.paytm.paymentsBank.fragment.b$7 r2 = new net.one97.paytm.paymentsBank.fragment.b$7
            r2.<init>(r0)
            java.util.Timer r3 = r9.al
            if (r3 == 0) goto L_0x05bf
            r3.cancel()
        L_0x05bf:
            java.util.TimerTask r3 = r9.ak
            if (r3 == 0) goto L_0x05c6
            r3.cancel()
        L_0x05c6:
            net.one97.paytm.paymentsBank.fragment.b$8 r3 = new net.one97.paytm.paymentsBank.fragment.b$8
            r3.<init>(r2)
            r9.ak = r3
            java.util.Timer r2 = new java.util.Timer
            r2.<init>()
            r9.al = r2
            java.util.Timer r3 = r9.al
            java.util.TimerTask r4 = r9.ak
            r5 = 1000(0x3e8, double:4.94E-321)
            int r0 = r0 * 1000
            long r7 = (long) r0
            r3.schedule(r4, r5, r7)
        L_0x05e0:
            int r0 = r1.size()
            if (r0 != 0) goto L_0x0600
            androidx.viewpager.widget.ViewPager r0 = r9.n
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r0.height = r12
            androidx.viewpager.widget.ViewPager r1 = r9.n
            r1.setLayoutParams(r0)
            androidx.viewpager.widget.ViewPager r0 = r9.n
            r0.setVisibility(r10)
            net.one97.paytm.common.widgets.CirclePageIndicator r0 = r9.X
            r0.setVisibility(r10)
            return
        L_0x0600:
            int r0 = r1.size()
            r1 = 225(0xe1, float:3.15E-43)
            if (r0 != r11) goto L_0x0626
            androidx.viewpager.widget.ViewPager r0 = r9.n
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r1 = com.paytm.utility.b.c((int) r1)
            r0.height = r1
            androidx.viewpager.widget.ViewPager r1 = r9.n
            r1.setLayoutParams(r0)
            androidx.viewpager.widget.ViewPager r0 = r9.n
            r0.setVisibility(r12)
            net.one97.paytm.common.widgets.CirclePageIndicator r0 = r9.X
            r0.setVisibility(r10)
            return
        L_0x0626:
            androidx.viewpager.widget.ViewPager r0 = r9.n
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r1 = com.paytm.utility.b.c((int) r1)
            r0.height = r1
            androidx.viewpager.widget.ViewPager r1 = r9.n
            r1.setLayoutParams(r0)
            androidx.viewpager.widget.ViewPager r0 = r9.n
            r0.setVisibility(r12)
            net.one97.paytm.common.widgets.CirclePageIndicator r0 = r9.X
            r0.setVisibility(r12)
        L_0x0643:
            return
        L_0x0644:
            boolean r1 = r0 instanceof net.one97.paytm.bankCommon.model.CustProductStatus
            if (r1 == 0) goto L_0x0674
            net.one97.paytm.bankCommon.model.CustProductStatus r0 = (net.one97.paytm.bankCommon.model.CustProductStatus) r0
            r9.t = r0
            r20.z()
            net.one97.paytm.bankCommon.model.CustProductStatus r0 = r9.t
            java.lang.String r0 = r0.getPanRec()
            java.lang.String r1 = "Y"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x0663
            net.one97.paytm.paymentsBank.utils.r r0 = r9.ba
            r0.b(r11)
            goto L_0x0668
        L_0x0663:
            net.one97.paytm.paymentsBank.utils.r r0 = r9.ba
            r0.a(r11)
        L_0x0668:
            boolean r0 = r9.z
            if (r0 == 0) goto L_0x091d
            r9.z = r12
            net.one97.paytm.bankCommon.model.CustProductStatus r0 = r9.t
            r9.a((net.one97.paytm.bankCommon.model.CustProductStatus) r0)
            return
        L_0x0674:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRP2BStatus
            if (r1 == 0) goto L_0x06b7
            boolean r1 = r20.isResumed()
            if (r1 != 0) goto L_0x067f
            return
        L_0x067f:
            net.one97.paytm.common.entity.wallet.CJRP2BStatus r0 = (net.one97.paytm.common.entity.wallet.CJRP2BStatus) r0
            if (r0 == 0) goto L_0x06b6
            net.one97.paytm.common.entity.wallet.CJRP2BStatusResponse r1 = r0.getResponse()
            if (r1 == 0) goto L_0x06b6
            net.one97.paytm.common.entity.wallet.CJRP2BStatusResponse r1 = r0.getResponse()
            boolean r1 = r1.isValidForTxn()
            if (r1 == 0) goto L_0x06b6
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r20.getActivity()
            net.one97.paytm.paymentsBank.h.a r3 = net.one97.paytm.paymentsBank.utils.o.a()
            java.lang.Class r3 = r3.getTransferToBankActivityClass()
            r1.<init>(r2, r3)
            java.lang.String r2 = net.one97.paytm.bankCommon.mapping.b.aP
            r1.putExtra(r2, r0)
            java.lang.String r0 = "is_from_passbook"
            r1.putExtra(r0, r12)
            java.lang.String r0 = "isFrom"
            r1.putExtra(r0, r11)
            r9.startActivity(r1)
        L_0x06b6:
            return
        L_0x06b7:
            boolean r1 = r0 instanceof net.one97.paytm.paymentsBank.si.response.AllSIResponse
            if (r1 == 0) goto L_0x075a
            r20.q()
            net.one97.paytm.paymentsBank.si.response.AllSIResponse r0 = (net.one97.paytm.paymentsBank.si.response.AllSIResponse) r0
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r1 = r0.getPayload()
            if (r1 == 0) goto L_0x0759
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r1 = r0.getPayload()
            java.lang.String r1 = r1.getErrorMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0744
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r1 = r0.getPayload()
            java.util.List r1 = r1.getStandingInstructionList()
            java.lang.String r2 = "acc_no"
            if (r1 == 0) goto L_0x072c
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r1 = r0.getPayload()
            java.util.List r1 = r1.getStandingInstructionList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x072c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r0 = r0.getPayload()
            java.util.List r0 = r0.getStandingInstructionList()
            java.util.Iterator r0 = r0.iterator()
        L_0x06ff:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x070f
            java.lang.Object r3 = r0.next()
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$StandingInstructions r3 = (net.one97.paytm.paymentsBank.si.response.AllSIResponse.StandingInstructions) r3
            r1.add(r3)
            goto L_0x06ff
        L_0x070f:
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r3 = r20.getActivity()
            java.lang.Class<net.one97.paytm.paymentsBank.si.activity.RecurringPaymentListActivity> r4 = net.one97.paytm.paymentsBank.si.activity.RecurringPaymentListActivity.class
            r0.<init>(r3, r4)
            java.lang.String r3 = "extra_list"
            r0.putExtra(r3, r1)
            net.one97.paytm.bankCommon.model.CustProductList r1 = r9.H
            java.lang.String r1 = r1.getIsaAccNum()
            r0.putExtra(r2, r1)
            r9.startActivity(r0)
            return
        L_0x072c:
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            java.lang.Class<net.one97.paytm.paymentsBank.si.activity.RecurringPaymentAddActivity> r3 = net.one97.paytm.paymentsBank.si.activity.RecurringPaymentAddActivity.class
            r0.<init>(r1, r3)
            net.one97.paytm.bankCommon.model.CustProductList r1 = r9.H
            java.lang.String r1 = r1.getIsaAccNum()
            r0.putExtra(r2, r1)
            r9.startActivity(r0)
            return
        L_0x0744:
            androidx.fragment.app.FragmentActivity r1 = r20.getActivity()
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r2 = r9.getString(r2)
            net.one97.paytm.paymentsBank.si.response.AllSIResponse$Payload r0 = r0.getPayload()
            java.lang.String r0 = r0.getErrorMessage()
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r0)
        L_0x0759:
            return
        L_0x075a:
            boolean r1 = r0 instanceof net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse
            if (r1 == 0) goto L_0x091d
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r0 = (net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse) r0
            r9.aH = r0
            net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse r0 = r9.aH
            if (r0 == 0) goto L_0x091a
            java.lang.String r1 = r0.getUserType()
            if (r1 == 0) goto L_0x091a
            java.lang.String r1 = r0.getOnBoardingStatus()
            if (r1 == 0) goto L_0x091a
            r1 = -1
            java.lang.Integer r2 = r0.getPreferenceSiId()     // Catch:{ Exception -> 0x07e3 }
            if (r2 == 0) goto L_0x07b6
            java.lang.Integer r2 = r0.getPreferenceSiId()     // Catch:{ Exception -> 0x07e3 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x07e3 }
            if (r2 != r1) goto L_0x0784
            goto L_0x07b6
        L_0x0784:
            java.lang.String r2 = r0.getUserType()     // Catch:{ Exception -> 0x07e3 }
            java.lang.String r3 = r0.getOnBoardingStatus()     // Catch:{ Exception -> 0x07e3 }
            if (r2 == 0) goto L_0x07af
            java.lang.String r4 = "APPLIED"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x07e3 }
            if (r2 == 0) goto L_0x07af
            if (r3 == 0) goto L_0x07af
            java.lang.String r2 = "IN_PROGRESS"
            boolean r2 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x07e3 }
            if (r2 != 0) goto L_0x07a8
            java.lang.String r2 = "PENDING"
            boolean r2 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x07e3 }
            if (r2 == 0) goto L_0x07af
        L_0x07a8:
            net.one97.paytm.paymentsBank.createfd.utils.b$a r2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x07e3 }
            java.lang.String r2 = net.one97.paytm.paymentsBank.createfd.utils.b.F     // Catch:{ Exception -> 0x07e3 }
            goto L_0x07bc
        L_0x07af:
            net.one97.paytm.paymentsBank.createfd.utils.b$a r2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x07e3 }
            java.lang.String r2 = net.one97.paytm.paymentsBank.createfd.utils.b.G     // Catch:{ Exception -> 0x07e3 }
            goto L_0x07bc
        L_0x07b6:
            net.one97.paytm.paymentsBank.createfd.utils.b$a r2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x07e3 }
            java.lang.String r2 = net.one97.paytm.paymentsBank.createfd.utils.b.H     // Catch:{ Exception -> 0x07e3 }
        L_0x07bc:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x07e3 }
            if (r3 != 0) goto L_0x07df
            net.one97.paytm.paymentsBank.h.a r3 = net.one97.paytm.paymentsBank.utils.o.a()     // Catch:{ Exception -> 0x07e3 }
            java.lang.String r4 = "fdseekEnabled"
            boolean r3 = r3.getBooleanFromGTM(r4, r12)     // Catch:{ Exception -> 0x07e3 }
            if (r3 == 0) goto L_0x07df
            android.view.View r3 = r9.aL     // Catch:{ Exception -> 0x07e3 }
            r3.setVisibility(r12)     // Catch:{ Exception -> 0x07e3 }
            net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r3 = r9.aK     // Catch:{ Exception -> 0x07e3 }
            r3.setVisibility(r12)     // Catch:{ Exception -> 0x07e3 }
            net.one97.paytm.paymentsBank.createfd.prefrence.CreateFdPrefrenceLayout r3 = r9.aK     // Catch:{ Exception -> 0x07e3 }
            net.one97.paytm.paymentsBank.createfd.prefrence.b.b$a r4 = r9.aJ     // Catch:{ Exception -> 0x07e3 }
            r3.setFdUserPrefrenceLayout(r2, r0, r4)     // Catch:{ Exception -> 0x07e3 }
        L_0x07df:
            r20.z()     // Catch:{ Exception -> 0x07e3 }
            goto L_0x07e4
        L_0x07e3:
        L_0x07e4:
            java.lang.String r2 = r0.getUserType()
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 4
            switch(r3) {
                case -287297839: goto L_0x081a;
                case -75252643: goto L_0x0810;
                case 539760169: goto L_0x0806;
                case 1502863890: goto L_0x07fc;
                case 1925346054: goto L_0x07f2;
                default: goto L_0x07f1;
            }
        L_0x07f1:
            goto L_0x0822
        L_0x07f2:
            java.lang.String r3 = "ACTIVE"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0822
            r2 = 3
            goto L_0x0823
        L_0x07fc:
            java.lang.String r3 = "NOT_ACTIVE"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0822
            r2 = 4
            goto L_0x0823
        L_0x0806:
            java.lang.String r3 = "CIF_CREATED"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0822
            r2 = 2
            goto L_0x0823
        L_0x0810:
            java.lang.String r3 = "APPLIED"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0822
            r2 = 1
            goto L_0x0823
        L_0x081a:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0822
            r2 = 0
            goto L_0x0823
        L_0x0822:
            r2 = -1
        L_0x0823:
            if (r2 == 0) goto L_0x08e9
            if (r2 == r11) goto L_0x0853
            r3 = 2
            if (r2 == r3) goto L_0x084e
            if (r2 == r4) goto L_0x084e
            if (r2 == r5) goto L_0x0830
            goto L_0x08fd
        L_0x0830:
            r20.A()
            android.widget.RelativeLayout r0 = r9.aB
            r0.setVisibility(r10)
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setVisibility(r12)
            android.widget.TextView r0 = r9.ar
            r0.setVisibility(r10)
            android.view.View r0 = r9.o
            r0.setVisibility(r12)
            android.widget.RelativeLayout r0 = r9.aA
            r0.setVisibility(r12)
            goto L_0x08fd
        L_0x084e:
            r20.t()
            goto L_0x08fd
        L_0x0853:
            java.lang.String r0 = r0.getOnBoardingStatus()
            int r2 = r0.hashCode()
            switch(r2) {
                case -2125830485: goto L_0x087b;
                case -604548089: goto L_0x0871;
                case -287297839: goto L_0x0869;
                case 35394935: goto L_0x085f;
                default: goto L_0x085e;
            }
        L_0x085e:
            goto L_0x0882
        L_0x085f:
            java.lang.String r2 = "PENDING"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0882
            r1 = 3
            goto L_0x0882
        L_0x0869:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0882
            r1 = 0
            goto L_0x0882
        L_0x0871:
            java.lang.String r2 = "IN_PROGRESS"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0882
            r1 = 2
            goto L_0x0882
        L_0x087b:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0882
            r1 = 1
        L_0x0882:
            if (r1 == 0) goto L_0x08d4
            if (r1 == r11) goto L_0x08a9
            r0 = 2
            if (r1 == r0) goto L_0x088c
            if (r1 == r4) goto L_0x088c
            goto L_0x08fd
        L_0x088c:
            r20.A()
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setVisibility(r5)
            android.widget.TextView r0 = r9.ar
            r0.setVisibility(r12)
            android.view.View r0 = r9.o
            r0.setVisibility(r12)
            android.widget.RelativeLayout r0 = r9.aB
            r0.setVisibility(r10)
            android.widget.RelativeLayout r0 = r9.aA
            r0.setVisibility(r12)
            goto L_0x08fd
        L_0x08a9:
            int r0 = net.one97.paytm.paymentsBank.R.string.pb_fd_show_less_cif_created
            java.lang.Object[] r1 = new java.lang.Object[r11]
            java.lang.String r2 = r9.F
            r1[r12] = r2
            java.lang.String r0 = r9.getString(r0, r1)
            android.widget.TextView r1 = r9.w
            r1.setText(r0)
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setVisibility(r12)
            android.widget.RelativeLayout r0 = r9.aB
            r0.setVisibility(r10)
            android.widget.TextView r0 = r9.ar
            r0.setVisibility(r10)
            android.view.View r0 = r9.o
            r0.setVisibility(r12)
            android.widget.RelativeLayout r0 = r9.aA
            r0.setVisibility(r12)
            goto L_0x08fd
        L_0x08d4:
            android.widget.RelativeLayout r0 = r9.aA
            r0.setVisibility(r10)
            android.widget.RelativeLayout r0 = r9.aB
            r0.setVisibility(r12)
            android.view.View r0 = r9.o
            r0.setVisibility(r12)
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setVisibility(r5)
            goto L_0x08fd
        L_0x08e9:
            android.widget.RelativeLayout r0 = r9.aA
            r0.setVisibility(r10)
            android.widget.RelativeLayout r0 = r9.aB
            r0.setVisibility(r12)
            android.view.View r0 = r9.o
            r0.setVisibility(r12)
            com.paytm.utility.RoboTextView r0 = r9.f18473g
            r0.setVisibility(r5)
        L_0x08fd:
            boolean r0 = net.one97.paytm.paymentsBank.utils.n.e()
            if (r0 == 0) goto L_0x090f
            android.widget.Button r0 = r9.aC
            int r1 = net.one97.paytm.paymentsBank.R.string.open_fixed_deposit_account
            java.lang.String r1 = r9.getString(r1)
            r0.setText(r1)
            goto L_0x091a
        L_0x090f:
            android.widget.Button r0 = r9.aC
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_view_benefits
            java.lang.String r1 = r9.getString(r1)
            r0.setText(r1)
        L_0x091a:
            r20.D()
        L_0x091d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.fragment.b.onResponse(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    private void A() {
        this.w.setMovementMethod(net.one97.paytm.paymentsBank.customView.b.a());
        this.w.setClickable(false);
        this.w.setLongClickable(false);
        this.o.findViewById(R.id.show_more).setVisibility(8);
        SpannableString spannableString = new SpannableString(getString(R.string.pb_fd_show_less_cif_created, this.F));
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getContext(), R.color.color_506d85)), 0, spannableString.length(), 33);
        SpannableString spannableString2 = new SpannableString(getString(R.string.pb_know_more));
        spannableString2.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                net.one97.paytm.bankCommon.mapping.c.a(b.this.getActivity(), "bank_saving_account", "linked_account_show_more_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                o.a().openWebViewActivity(b.this.G, n.n(), b.this.getString(R.string.paytm_payments_bank));
            }

            public final void updateDrawState(TextPaint textPaint) {
                if (b.this.getActivity() != null && !b.this.getActivity().isDestroyed() && !b.this.getActivity().isFinishing()) {
                    com.google.android.play.core.splitcompat.a.a((Context) b.this.getActivity());
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(androidx.core.content.b.c(b.this.getActivity(), R.color.color_00b9f5));
                }
            }
        }, 0, spannableString2.length(), 33);
        this.w.setText(new SpannableStringBuilder().append(spannableString).append(" ").append(spannableString2));
    }

    public final void a(CustProductStatus custProductStatus) {
        Intent intent = new Intent(getActivity(), DownloadActivity.class);
        if (!TextUtils.isEmpty(custProductStatus.getPanRec()) && custProductStatus.getPanRec().equals("Y")) {
            intent.putExtra("SHOW_TDS", true);
        }
        startActivity(intent);
    }

    private void a(List<NomineeModel> list) {
        if (list == null || list.size() <= 0) {
            this.ba.b(2);
            if (this.aT.getInt("bank_nominee_launch_count", 0) >= n.r()) {
                s();
            }
            this.m = false;
            this.S.setText(getString(R.string.pb_add_nominee));
        } else {
            this.S.setText(getString(R.string.acc_nominee));
            this.m = true;
            this.T = list.get(0);
            this.ba.a(2);
        }
        F();
    }

    private void b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(getString(R.string.pb_acc_no));
            sb.append(" ");
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(StringUtility.NEW_LINE);
            sb.append(getString(R.string.pb_bank_ifsc_code));
            sb.append(" ");
            sb.append(str2);
        }
        net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
        if (net.one97.paytm.paymentsBank.utils.a.i()) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        this.Y = sb.toString();
        this.f18475i.setText(this.Y);
        this.W.setBackgroundColor(-1);
        this.W.setDrawingCacheEnabled(true);
    }

    private void B() {
        this.p.findViewById(R.id.card_sub_heading).setVisibility(8);
        this.p.findViewById(R.id.card_read_more).setVisibility(8);
        this.p.findViewById(R.id.tv_digital_debit).setVisibility(8);
        this.p.findViewById(R.id.fragment_bank_tab_lyt).setVisibility(8);
        this.p.findViewById(R.id.lyt_debit_card_bottom_divider).setVisibility(8);
        this.p.findViewById(R.id.lyt_debit_card).setVisibility(8);
    }

    private String e(String str) {
        if (TextUtils.isEmpty(this.f18474h.getText())) {
            return str;
        }
        return this.f18474h.getText().toString() + StringUtility.NEW_LINE + str;
    }

    private void C() {
        q();
        if ("dc_payment_settings".equals(this.ai)) {
            Bundle bundle = new Bundle();
            bundle.putString("goToScreen", this.ai);
            a(bundle);
        } else if ("verifyPassAndActivatePin".equals(this.ai)) {
            net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
            if (!net.one97.paytm.paymentsBank.utils.a.b() || this.H == null) {
                return;
            }
            if (j.a().equals("ICA")) {
                Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                return;
            }
            String str = l.a().f19526c;
            net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
            if (net.one97.paytm.payments.c.c.b.d()) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("goToScreen", this.ai);
                bundle2.putString("pdc_qrcode_id", str);
                a(bundle2);
            } else {
                Intent intent = new Intent(getActivity(), PDCPasscodePinActivity.class);
                intent.putExtra("pdc_qrcode_id", str);
                intent.putExtra("CUST_PRODUCT", this.H);
                intent.putExtra("ENTER_HEADER", "verifyPassAndActivatePin");
                intent.setFlags(67108864);
                getActivity().startActivity(intent);
            }
        } else if ("add_money".equals(this.ai)) {
            a(3);
        } else if ("request_atm".equals(this.ai)) {
            net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
            if (!net.one97.paytm.paymentsBank.utils.a.b() || this.H == null) {
                return;
            }
            if (j.a().equals("ICA")) {
                Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                O();
                return;
            } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                if (net.one97.paytm.payments.c.c.b.d()) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("goToScreen", this.ai);
                    a(bundle3);
                } else {
                    Intent intent2 = new Intent(getActivity(), ManageDebitCardActivity.class);
                    intent2.putExtra("CUST_PRODUCT", this.H);
                    intent2.putExtra("goToScreen", this.ai);
                    startActivity(intent2);
                }
            }
        } else if ("track_atm_order".equals(this.ai)) {
            if (this.H != null) {
                String str2 = l.a().f19525b;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(this.H.getPDCOrderId())) {
                    str2 = this.H.getPDCOrderId();
                }
                l.a().f19525b = null;
                net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
                if (!net.one97.paytm.paymentsBank.utils.a.b() || TextUtils.isEmpty(str2)) {
                    O();
                    return;
                } else if (j.a().equals("ICA")) {
                    Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                    O();
                    return;
                } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                    net.one97.paytm.payments.c.c.b bVar3 = net.one97.paytm.payments.c.c.b.f17264a;
                    if (net.one97.paytm.payments.c.c.b.d()) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("order_id", str2);
                        bundle4.putString("goToScreen", this.ai);
                        a(bundle4);
                    } else {
                        Intent intent3 = new Intent(getActivity(), ManageDebitCardActivity.class);
                        intent3.putExtra("CUST_PRODUCT", this.H);
                        intent3.putExtra("goToScreen", this.ai);
                        intent3.putExtra("order_id", str2);
                        startActivity(intent3);
                    }
                }
            } else {
                return;
            }
        } else if ("manage_debit".equals(this.ai)) {
            if (this.H != null) {
                if (j.a().equals("ICA")) {
                    Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                    O();
                    return;
                } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                    net.one97.paytm.payments.c.c.b bVar4 = net.one97.paytm.payments.c.c.b.f17264a;
                    if (net.one97.paytm.payments.c.c.b.d()) {
                        a((Bundle) null);
                    } else {
                        Intent intent4 = new Intent(getActivity(), ManageDebitCardActivity.class);
                        intent4.putExtra("CUST_PRODUCT", this.H);
                        intent4.putExtra("goToScreen", this.ai);
                        startActivity(intent4);
                    }
                }
            } else {
                return;
            }
        } else if ("cheque_book".equals(this.ai)) {
            this.p.findViewById(R.id.lyt_cheque_demand_draft).performClick();
        } else if ("block_card".equals(this.ai)) {
            if (this.H != null) {
                if (j.a().equals("ICA")) {
                    Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                    O();
                    return;
                } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                    net.one97.paytm.payments.c.c.b bVar5 = net.one97.paytm.payments.c.c.b.f17264a;
                    if (net.one97.paytm.payments.c.c.b.d()) {
                        Bundle bundle5 = new Bundle();
                        bundle5.putString("goToScreen", this.ai);
                        a(bundle5);
                    } else {
                        Intent intent5 = new Intent(getActivity(), ManageDebitCardActivity.class);
                        intent5.putExtra("CUST_PRODUCT", this.H);
                        intent5.putExtra("goToScreen", this.ai);
                        startActivity(intent5);
                    }
                }
            } else {
                return;
            }
        } else if (net.one97.paytm.paymentsBank.d.a.ALTER_NOMINEE.getFeatureType().equals(this.ai)) {
            if (this.H != null) {
                i();
            } else {
                return;
            }
        } else if (net.one97.paytm.paymentsBank.d.a.NACH_MANDATE.getFeatureType().equals(this.ai)) {
            startActivity(new Intent(getActivity(), PBNachRequestListActivity.class));
        } else if (net.one97.paytm.paymentsBank.d.a.FORGOT_ATM_PIN.getFeatureType().equals(this.ai)) {
            if (this.H != null) {
                if (j.a().equals("ICA")) {
                    Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                    O();
                    return;
                } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                    net.one97.paytm.payments.c.c.b bVar6 = net.one97.paytm.payments.c.c.b.f17264a;
                    if (net.one97.paytm.payments.c.c.b.d()) {
                        Bundle bundle6 = new Bundle();
                        bundle6.putString("goToScreen", this.ai);
                        a(bundle6);
                    } else {
                        Intent intent6 = new Intent(getActivity(), ManageDebitCardActivity.class);
                        intent6.putExtra("CUST_PRODUCT", this.H);
                        intent6.putExtra("goToScreen", this.ai);
                        startActivity(intent6);
                    }
                }
            } else {
                return;
            }
        } else if ("automatic_payments".equalsIgnoreCase(this.ai)) {
            if (!TextUtils.isEmpty(this.I)) {
                a(7);
            } else {
                return;
            }
        } else if ("retry_request_atm".equalsIgnoreCase(this.ai)) {
            if (this.H != null) {
                if (j.a().equals("ICA")) {
                    Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                    O();
                    return;
                } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                    Intent intent7 = new Intent(getActivity(), ManageDebitCardActivity.class);
                    intent7.putExtra("CUST_PRODUCT", this.H);
                    intent7.putExtra("goToScreen", this.ai);
                    startActivity(intent7);
                }
            } else {
                return;
            }
        } else if ("change_atm_pin".equalsIgnoreCase(this.ai)) {
            if (this.H != null) {
                if (j.a().equals("ICA")) {
                    Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
                    O();
                    return;
                } else if ("ISSUED".equalsIgnoreCase(this.H.getVdcStatus())) {
                    Intent intent8 = new Intent(getActivity(), ManageDebitCardActivity.class);
                    intent8.putExtra("CUST_PRODUCT", this.H);
                    intent8.putExtra("goToScreen", this.ai);
                    startActivity(intent8);
                }
            } else {
                return;
            }
        } else if ("savings_account_passbook_tab".equalsIgnoreCase(this.ai)) {
            if (!TextUtils.isEmpty(this.J)) {
                net.one97.paytm.payments.c.c.b bVar7 = net.one97.paytm.payments.c.c.b.f17264a;
                if (net.one97.paytm.payments.c.c.b.e()) {
                    net.one97.paytm.payments.c.c.b bVar8 = net.one97.paytm.payments.c.c.b.f17264a;
                    net.one97.paytm.payments.c.c.b.c(getContext(), new Bundle());
                } else {
                    net.one97.paytm.paymentsBank.h.a a2 = o.a();
                    FragmentActivity activity = getActivity();
                    String str3 = this.J;
                    String str4 = this.I;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.aS);
                    a2.openInnerSavingAccPasscodeActivity(activity, str3, str4, sb.toString(), j.a());
                }
            } else {
                return;
            }
        } else if ("withdraw_cash_nearby".equalsIgnoreCase(this.ai)) {
            if (this.H != null) {
                net.one97.paytm.payments.c.c.b bVar9 = net.one97.paytm.payments.c.c.b.f17264a;
                if (net.one97.paytm.payments.c.c.b.g()) {
                    net.one97.paytm.payments.c.c.b bVar10 = net.one97.paytm.payments.c.c.b.f17264a;
                    net.one97.paytm.payments.c.c.b.f(getContext(), new Bundle());
                } else {
                    startActivity(new Intent(getActivity(), CashFromNearestPaytmActivity.class));
                }
            } else {
                return;
            }
        }
        O();
    }

    private void D() {
        String[] strArr = {"fixed_deposit", "fd_projection", "fd_projection", "fd_interest_certificate", "fd_tds_certificate", "acc_open", "bank_landing", "fd_form_15", "fd_interest_table", "fd_benefits", "fd_passbook", "create_fd", "create_cif"};
        if (this.aH != null && this.aO) {
            for (int i2 = 0; i2 < 13; i2++) {
                String str = strArr[i2];
                if (str.equals(this.ai)) {
                    net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
                    if (net.one97.paytm.payments.c.c.b.a()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("goToScreen", this.ai);
                        if (!com.paytm.utility.v.a(l.a().f19527d)) {
                            bundle.putString("fd_id", l.a().f19527d);
                        }
                        net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                        net.one97.paytm.payments.c.c.b.a(getContext(), bundle, ViewHolderFactory.CLASS_HOME);
                    } else if (str.equals("fd_benefits")) {
                        o.a().openWebViewActivity(this.G, n.n(), getString(R.string.paytm_payments_bank));
                    } else {
                        this.bc = new Bundle();
                        this.bc.putString("deeplink", l.a().f19528e);
                        q();
                        getView().findViewById(R.id.fragment_bank_tab_tv_fd).performClick();
                    }
                    O();
                    l.a().f19528e = null;
                }
            }
        }
    }

    private void E() {
        String[] strArr = {"savings_account_passbook_tab"};
        for (int i2 = 0; i2 <= 0; i2++) {
            if (strArr[0].equals(this.ai)) {
                C();
                return;
            }
        }
    }

    private void F() {
        String[] strArr = {net.one97.paytm.paymentsBank.d.a.ALTER_NOMINEE.getFeatureType()};
        for (int i2 = 0; i2 <= 0; i2++) {
            if (strArr[0].equals(this.ai)) {
                C();
                return;
            }
        }
    }

    private void G() {
        String[] strArr = {"request_atm", "track_atm_order", "manage_debit", net.one97.paytm.paymentsBank.d.a.FORGOT_ATM_PIN.getFeatureType(), "verifyPassAndActivatePin", "block_card", net.one97.paytm.paymentsBank.d.a.NACH_MANDATE.getFeatureType(), "add_money", "automatic_payments", "cheque_book", "retry_request_atm", "change_atm_pin", "withdraw_cash_nearby", "dc_payment_settings"};
        for (int i2 = 0; i2 < 14; i2++) {
            if (strArr[i2].equals(this.ai)) {
                C();
                return;
            }
        }
    }

    private void H() {
        if (com.paytm.utility.b.c(this.G)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            Context context = this.G;
            net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.b.a.a(context, com.paytm.utility.a.q(context), this.I, this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
            a2.f16270b = "isaDetailsApi";
            this.G.getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
        }
    }

    public final void l() {
        if (!TextUtils.isEmpty(this.Y)) {
            try {
                this.V.setVisibility(8);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.pb_subject_share));
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", getString(R.string.pb_body_share, e(this.Y)));
                Intent createChooser = Intent.createChooser(intent, getString(R.string.share_payments_bank_acc_details));
                if (createChooser.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.pb_no_app_found), 1).show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                this.V.setVisibility(0);
                throw th;
            }
            this.V.setVisibility(0);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 100) {
            if (iArr.length > 0 && iArr[0] == 0) {
                return;
            }
            if (androidx.core.app.a.a((Activity) getActivity(), "android.permission.ACCESS_COARSE_LOCATION")) {
                $$Lambda$b$r_xIXVznM5zUTe85ADKVNSq_8c r1 = $$Lambda$b$r_xIXVznM5zUTe85ADKVNSq_8c.INSTANCE;
                new AlertDialog.Builder(getActivity()).setMessage("Permission is required for register").setPositiveButton(Payload.RESPONSE_OK, r1).setNegativeButton("Cancel", r1).create().show();
                return;
            }
            Toast.makeText(getActivity().getApplicationContext(), "Go to settings and enable External storage permissions", 1).show();
        }
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    private void I() {
        double d2 = this.ac;
        if (d2 >= 0.0d) {
            double d3 = this.ad;
            if (d3 >= 0.0d) {
                double d4 = this.ae;
                if (d4 >= 0.0d) {
                    net.one97.paytm.bankCommon.mapping.e.a(String.format(getString(net.one97.paytm.common.assets.R.string.rs_str), new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(d2 + d3 + d4))}), (TextView) this.l);
                }
            }
        }
        this.af++;
        if (this.af == 2) {
            this.af = 0;
            b(this.Q);
        }
    }

    private void J() {
        Intent intent = new Intent(this.G, o.a().getMoneyTransferActivityV3Class());
        intent.putExtra(UpiConstants.FROM, 100);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter("card_changed");
        intentFilter.addAction("PENDING");
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.y, intentFilter);
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.aM, new IntentFilter("paytm_app_logout"));
        Context context = this.G;
        if (context != null) {
            this.av = h.a(context);
        }
    }

    private void K() {
        if (this.am != null) {
            ((FrameLayout) this.p.findViewById(R.id.fragment_bank_tab_lyt)).removeAllViews();
        }
        this.ao = null;
        this.H = null;
        this.R = null;
        this.q = false;
        this.r = false;
        this.aO = false;
        this.ac = -1.0d;
        this.af = 0;
        this.ad = -1.0d;
        this.ae = -1.0d;
        this.f18471e.setText("");
        this.f18472f.setText("");
        this.f18473g.setText("");
        this.j.setText("");
        this.l.setText("");
        this.I = null;
        this.f18475i.setText("");
        this.f18474h.setText("");
        this.m = false;
        this.W.setBackgroundColor(0);
        this.V.setVisibility(8);
        B();
        this.ap = false;
        Intent intent = new Intent(getActivity(), o.a().getMainActivityClass());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        int i2 = getResources().getDisplayMetrics().heightPixels;
        int height = view.getHeight();
        int height2 = ((ViewGroup) view).getChildAt(0).getHeight();
        if (height2 != 0) {
            this.aq.a(0, ((height - (height2 * (i2 / height2))) / 2) * -1, false);
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isAdded()) {
            q();
            if (iJRPaytmDataModel != null) {
                if (iJRPaytmDataModel instanceof CJRCashWallet) {
                    b(this.O);
                } else if (iJRPaytmDataModel instanceof PBCJRAccountSummary) {
                    b(this.N);
                    b(this.L);
                    this.f18473g.setText("-----");
                } else if ((iJRPaytmDataModel instanceof IsaDetailsModel) || (iJRPaytmDataModel instanceof CustProductList)) {
                    b(this.M);
                } else if (iJRPaytmDataModel instanceof CustProductStatus) {
                    this.z = false;
                } else if (iJRPaytmDataModel instanceof FDStatusResponse) {
                    this.f18473g.setVisibility(0);
                    this.ar.setVisibility(8);
                    this.o.setVisibility(0);
                }
                j.a((Context) getActivity(), networkCustomError, i2);
            }
            super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    private void L() {
        if (com.paytm.utility.b.c(this.G)) {
            a(this.G, getString(R.string.please_wait));
            net.one97.paytm.paymentsBank.chequebook.utils.g a2 = net.one97.paytm.paymentsBank.chequebook.utils.g.a((Context) getActivity());
            if (a2 != null) {
                a2.a((Context) getActivity(), "0", (com.paytm.network.listener.b) this, getClass().getSimpleName()).a();
                return;
            }
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.pb_title_connection_problem), getResources().getString(R.string.pb_msg_connection_problem));
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        if (iJRPaytmDataModel instanceof CBChequeStatusDetailResponse) {
            this.f18470d.setClickable(true);
            q();
            CBChequeStatusDetailResponse cBChequeStatusDetailResponse = (CBChequeStatusDetailResponse) iJRPaytmDataModel;
            if (cBChequeStatusDetailResponse.getChqListForInwrdOutwrd() != null && cBChequeStatusDetailResponse.getChqListForInwrdOutwrd().size() > 0) {
                this.aw = true;
            }
            ChequeBookFinResponse chequeBookFinResponse = this.U;
            if (chequeBookFinResponse != null) {
                chequeBookFinResponse.getResponse();
                if (this.U.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                    q();
                    if (this.f18469c || (((str = this.f18467a) != null && !str.equalsIgnoreCase("UPLOADED") && !this.f18467a.equalsIgnoreCase("REJECTED")) || this.f18468b != 0)) {
                        N();
                    } else if (getActivity() != null) {
                        Intent intent = new Intent(getActivity(), RequestCBActivity.class);
                        intent.putExtra("CB_FIN_PRODUCT_RESPONSE", this.U);
                        intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", false);
                        getActivity().startActivity(intent);
                    }
                }
            } else {
                N();
            }
        } else if (iJRPaytmDataModel instanceof ChequeBookFinResponse) {
            this.U = (ChequeBookFinResponse) iJRPaytmDataModel;
            if (this.U != null) {
                Context context = this.G;
                if (context != null) {
                    this.av = h.a(context);
                    h.b("CB_KEY_FIN_RESPONSE");
                }
                h.a("CB_KEY_FIN_RESPONSE", new com.google.gsonhtcfix.f().a((Object) this.U), this.G);
                ChequeBookResponse response = this.U.getResponse();
                if (response != null) {
                    this.f18468b = response.getPendingChequeBooks().size();
                    ChequeBookSignature signature = response.getSignature();
                    if (signature != null) {
                        this.f18467a = signature.getStatus();
                        if (this.U.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                            CustProductList custProductList = this.H;
                            if (custProductList != null && !TextUtils.isEmpty(custProductList.getIsaAccNum())) {
                                M();
                                return;
                            }
                            return;
                        }
                        N();
                        this.f18470d.setClickable(true);
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof ChequeBookDetailResponse) {
            ChequeBookDetailResponse chequeBookDetailResponse = (ChequeBookDetailResponse) iJRPaytmDataModel;
            Context context2 = this.G;
            if (context2 != null) {
                this.av = h.a(context2);
            }
            h.a("CB_KEY_CB_LIST_RESPONSE", new com.google.gsonhtcfix.f().a((Object) chequeBookDetailResponse), this.G);
            if (chequeBookDetailResponse != null && chequeBookDetailResponse.getCbList().size() > 0) {
                this.f18469c = true;
            }
            net.one97.paytm.paymentsBank.chequebook.utils.g a2 = net.one97.paytm.paymentsBank.chequebook.utils.g.a((Context) getActivity());
            if (a2 != null) {
                com.paytm.network.a b2 = a2.b(getActivity(), this, getClass().getSimpleName());
                if (!com.paytm.utility.b.c((Context) getActivity())) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.pb_title_connection_problem), getString(R.string.pb_msg_connection_problem));
                } else if (b2 != null) {
                    b2.a();
                } else {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
                }
            }
        }
    }

    private void M() {
        net.one97.paytm.paymentsBank.chequebook.utils.g a2;
        if (getContext() != null && getContext().getApplicationContext() != null && (a2 = net.one97.paytm.paymentsBank.chequebook.utils.g.a(getContext().getApplicationContext())) != null) {
            com.paytm.network.a a3 = a2.a(this.H.getIsaAccNum(), "outward", "", (com.paytm.network.listener.b) this, getClass().getSimpleName());
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.pb_title_connection_problem), getString(R.string.pb_msg_connection_problem));
            } else if (a3 != null) {
                a3.a();
            } else {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f18470d.setClickable(true);
        if (iJRPaytmDataModel instanceof ChequeBookFinResponse) {
            if (this.f18469c) {
                M();
                return;
            }
            q();
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
        } else if (isAdded()) {
            q();
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
        }
    }

    private void N() {
        Intent intent = new Intent(getActivity(), ChequeBookLandingPageActivity.class);
        intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", this.f18467a);
        intent.putExtra("showDepositedView", this.aw);
        intent.putExtra("pendingOrders", this.f18468b);
        intent.putExtra("cb_list_flow", this.f18469c);
        if (getActivity() != null) {
            getActivity().startActivity(intent);
        }
    }

    public final void m() {
        if (getActivity() != null && !com.paytm.utility.b.c((Context) getActivity())) {
            r();
        } else if (j.a().equals("ICA")) {
            Toast.makeText(getActivity(), getString(R.string.pb_feature_not_available), 0).show();
        } else if (this.H != null) {
            net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
            if (net.one97.paytm.payments.c.c.b.d()) {
                a((Bundle) null);
                return;
            }
            Intent intent = new Intent(getActivity(), ManageDebitCardActivity.class);
            intent.putExtra("CARD_DETAILS", this.R);
            intent.putExtra("CUST_PRODUCT", this.H);
            startActivityForResult(intent, 1245);
        } else {
            Toast.makeText(getActivity(), getString(R.string.pb_please_wait), 0).show();
        }
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
        net.one97.paytm.payments.c.c.b.a(getContext(), bundle);
    }

    public final void n() {
        if (!n.g() || !this.aI) {
            this.aU.setVisibility(8);
            return;
        }
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        net.one97.paytm.bankOpen.ica.a.c(new g.b() {
            public final void onResponse(Object obj) {
                b.this.b((IJRPaytmDataModel) obj);
            }
        }, $$Lambda$b$X9ca9YatRsxIDk20zW8sIXGOtOQ.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof ICAStatusResponse) {
            ICAStatusResponse iCAStatusResponse = (ICAStatusResponse) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(iCAStatusResponse.getLeadStatus())) {
                String upperCase = iCAStatusResponse.getLeadStatus().toUpperCase();
                char c2 = 65535;
                int hashCode = upperCase.hashCode();
                if (hashCode != -287297839) {
                    if (hashCode != 2332508) {
                        if (hashCode == 80083243 && upperCase.equals("TRACK")) {
                            c2 = 2;
                        }
                    } else if (upperCase.equals("LEAD")) {
                        c2 = 1;
                    }
                } else if (upperCase.equals("NOT_APPLIED")) {
                    c2 = 0;
                }
                if (c2 == 0 || c2 == 1) {
                    f("NOT_APPLIED");
                } else if (c2 == 2) {
                    f("TRACK");
                }
            }
        }
    }

    private void f(String str) {
        if (isAdded()) {
            getChildFragmentManager().a().b(R.id.container_ica, d.a(str), (String) null).c();
            if (n.g()) {
                this.aU.setVisibility(0);
            } else {
                this.aU.setVisibility(8);
            }
        }
    }

    public final void o() {
        try {
            this.aU.setVisibility(8);
            Fragment c2 = getChildFragmentManager().c(R.id.container_ica);
            if (c2 != null) {
                getChildFragmentManager().a().a(c2).c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void p() {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "bank_saving_account", "cheque_book_service_clicked", "", "", "/bank/savings-account/landing", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        if (j.a().equals("ICA")) {
            startActivity(new Intent(getActivity(), ChequeBookDDActivity.class));
            return;
        }
        this.f18470d.setClickable(false);
        if (n.a()) {
            L();
        } else {
            startActivity(new Intent(getActivity(), ChequeBookDDActivity.class));
        }
    }

    public final void a() {
        if (this.aJ != null) {
            a(false);
            this.aJ.e();
        }
    }

    public final void a(boolean z2) {
        if (d()) {
            if (z2 && getActivity() != null) {
                a(getActivity(), getActivity().getString(R.string.pb_please_wait));
            } else if (getActivity() != null) {
                q();
            }
        }
    }

    public final void c() {
        a(false);
        if (j.b()) {
            y();
        }
    }

    public final void a(Integer num, NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing() && !getActivity().isDestroyed()) {
            a(false);
            int intValue = num.intValue();
            b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (intValue == net.one97.paytm.paymentsBank.createfd.utils.b.p) {
                String string = getString(R.string.no_internet);
                com.paytm.utility.b.b(getContext(), getString(R.string.no_connection), string);
                return;
            }
            j.a((Activity) getActivity(), (Exception) networkCustomError, (String) null, (Bundle) null);
        }
    }

    public final void b(String str) {
        this.aK.setPogress((String) null);
        a(false);
        if (!TextUtils.isEmpty(str)) {
            com.paytm.utility.b.b(getContext(), "", str);
        }
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        if (!net.one97.paytm.bankCommon.mapping.a.c(getContext())) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
        } else if (arrayList != null && arrayList.size() > 0) {
            net.one97.paytm.paymentsBank.si.c.f a2 = net.one97.paytm.paymentsBank.si.c.f.a(arrayList);
            a2.f18886a = this;
            a2.show(getChildFragmentManager(), "tncFragment");
        }
    }

    public final void a(String str, String str2) {
        com.paytm.utility.b.b(getContext(), str, str2);
    }

    public final void g() {
        b.a aVar = this.aJ;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    public final void b() {
        b.a aVar = this.aJ;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            b.a aVar = this.aJ;
            if (aVar != null) {
                String f2 = aVar.f();
                try {
                    if (this.aJ != null) {
                        a(true);
                        if (this.aJ.d() != null) {
                            if (this.aJ.d().intValue() != -1) {
                                this.aJ.b(String.valueOf(this.aJ.d()), f2);
                                return;
                            }
                        }
                        b.a aVar2 = this.aJ;
                        net.one97.paytm.paymentsBank.utils.a aVar3 = net.one97.paytm.paymentsBank.utils.a.f19494a;
                        aVar2.a(f2, net.one97.paytm.paymentsBank.utils.a.a(this.H, true));
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            com.paytm.utility.b.a((Context) getActivity(), getString(R.string.pb_fd_tnc_saved));
        }
    }

    public final void a(String str) {
        b.a aVar = this.aJ;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        if (i2 == 1) {
            o.a().openPanCardDeeplink(getActivity(), false);
        } else if (i2 == 2) {
            i();
        } else if (i2 == 3) {
            d("paytmmp://payment_bank?featuretype=dbt");
        }
    }

    private void O() {
        this.ai = null;
        l.a().f19524a = null;
        q();
    }

    public final void d(String str) {
        boolean F2 = n.F();
        boolean G2 = n.G();
        if (F2 || G2) {
            o.a().openDbt(getActivity(), str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(String str) {
        if (str != null) {
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1363895925) {
                if (hashCode == -263839376 && str.equals("addNominee")) {
                    c2 = 1;
                }
            } else if (str.equals("cersai")) {
                c2 = 0;
            }
            if (c2 == 0) {
                o.a().checkDeepLink(getContext(), "paytmmp://edit_cersai");
            } else if (c2 == 1) {
                i();
            }
        }
    }

    public final boolean d() {
        return getContext() != null && isAdded();
    }

    public void onDestroy() {
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.y);
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.aM);
        if (this.av != null) {
            h.b();
        }
        h.a();
        net.one97.paytm.paymentsBank.accntfreeze.a.a().b();
        q();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.bankCommon.b.c cVar) {
        net.one97.paytm.paymentsBank.utils.b bVar;
        r rVar;
        if (cVar != null && cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS && ((net.one97.paytm.paymentsBank.storefront.model.a) cVar.f16217b).f19419a && isAdded()) {
            if (n.F() && (rVar = this.ba) != null) {
                rVar.b(3);
            }
            if (n.G() && (bVar = this.aV) != null) {
                Context context = getContext();
                net.one97.paytm.paymentsBank.f.b.b bVar2 = new net.one97.paytm.paymentsBank.f.b.b();
                bVar2.f18350a = 2;
                bVar2.f18351b = 116;
                bVar2.f18352c = context.getString(R.string.pb_dbt_cta_title);
                bVar2.f18354e = true;
                bVar2.f18353d = context.getString(R.string.pb_dbt_cta_subtitle);
                bVar2.f18355f = R.drawable.pb_ic_dbt_icon_svg;
                if (bVar.f19495a != null) {
                    bVar.f19495a.a(bVar2, 2);
                }
            }
            if (DbtUtilsKt.DBT_VERTICAL_NAME.equalsIgnoreCase(this.ai) && this.H != null) {
                String str = l.a().f19528e;
                O();
                d(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.bankCommon.b.c cVar) {
        if (cVar != null) {
            int intFromGTM = o.a().getIntFromGTM("cersaiRequiredPopupFrequencyNew");
            if (intFromGTM < 0) {
                intFromGTM = 7;
            }
            if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                if (intFromGTM != 0 && this.aT.getInt("bank_cersai_launch_count", 0) >= intFromGTM && !this.bb) {
                    e a2 = e.a("cersai");
                    a2.a(this.be);
                    if (getActivity() != null) {
                        a2.show(getActivity().getSupportFragmentManager(), e.class.getName());
                        this.bb = true;
                        a("bank_cersai_launch_count", true);
                    }
                }
            } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                NetworkCustomError networkCustomError = (NetworkCustomError) cVar.f16218c;
                j.a((Context) getActivity(), networkCustomError, networkCustomError.getStatusCode());
            }
        }
    }
}
