package net.one97.paytm.addmoney.status.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.AddMoneyStatusResponse;
import net.one97.paytm.addmoney.common.model.CJRAccountSummary;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.addmoney.status.a.a;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.addmoney.utils.n;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.newaddmoney.utils.e;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.utility.f;

public class AddMoneyStatusActivity extends PaytmActivity implements b, h, a.b {
    /* access modifiers changed from: private */
    public int A;
    private String B;
    private String C;
    private String D;
    private String E;
    /* access modifiers changed from: private */
    public int F;
    private String G;
    private String H;
    private String I;
    private ProgressDialog J;
    private ViewGroup K;
    private TextView L;
    /* access modifiers changed from: private */
    public int M;
    private String N;
    private NestedScrollView O;
    /* access modifiers changed from: private */
    public ImageView P;
    private ImageView Q;
    private a.C0854a R;

    /* renamed from: a  reason: collision with root package name */
    public SFWidget f48650a;

    /* renamed from: b  reason: collision with root package name */
    private final int f48651b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f48652c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f48653d = 3;

    /* renamed from: e  reason: collision with root package name */
    private TextView f48654e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f48655f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f48656g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f48657h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f48658i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private RelativeLayout r;
    private RelativeLayout s;
    /* access modifiers changed from: private */
    public LottieAnimationView t;
    private TextView u;
    private double v;
    private String w;
    private String x;
    private IJRDataModel y;
    private HashMap<String, View> z = new HashMap<>();

    public final void a(boolean z2) {
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.helper.a.b().a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context applicationContext = getApplicationContext();
        this.R = new net.one97.paytm.addmoney.status.c.a(this, net.one97.paytm.addmoney.status.b.a.b.a(net.one97.paytm.addmoney.status.b.a.a.a.a(applicationContext), net.one97.paytm.addmoney.status.b.a.b.a.a(applicationContext)));
        d.a(this, "/summary");
        setContentView(R.layout.uam_activity_status);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.Q = (ImageView) findViewById(R.id.paytm_logo);
        this.f48654e = (TextView) findViewById(R.id.tv_amount);
        this.q = (ImageView) findViewById(R.id.status_iv);
        this.f48655f = (TextView) findViewById(R.id.desc1_tv);
        this.f48656g = (TextView) findViewById(R.id.desc2_tv);
        this.s = (RelativeLayout) findViewById(R.id.rl_promo_view);
        this.f48657h = (TextView) findViewById(R.id.tv_promo_code_badge);
        this.f48658i = (TextView) findViewById(R.id.tv_promo_text);
        this.o = (TextView) findViewById(R.id.tv_error_msg);
        this.j = (TextView) findViewById(R.id.tv_bank_name);
        this.k = (TextView) findViewById(R.id.tv_acc_no);
        this.l = (TextView) findViewById(R.id.tv_upi_address);
        this.n = (TextView) findViewById(R.id.updated_bal_tv);
        this.m = (TextView) findViewById(R.id.tv_date);
        this.p = (ImageView) findViewById(R.id.iv_bank_logo);
        this.t = (LottieAnimationView) findViewById(R.id.success_status_lav);
        this.r = (RelativeLayout) findViewById(R.id.current_balance_layout);
        this.K = (ViewGroup) findViewById(R.id.sourceIconLayout);
        this.u = (TextView) findViewById(R.id.tv_added_from);
        this.P = (ImageView) findViewById(R.id.motifIV);
        this.L = (TextView) findViewById(R.id.more_details_tv);
        this.L.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMoneyStatusActivity.b(AddMoneyStatusActivity.this);
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AddMoneyStatusActivity.this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                    if (AddMoneyStatusActivity.this.M == 1) {
                        AddMoneyStatusActivity.e(AddMoneyStatusActivity.this);
                    } else if (AddMoneyStatusActivity.this.M != 2 && AddMoneyStatusActivity.this.M != 3) {
                    } else {
                        if (AddMoneyStatusActivity.this.F == SourceCardType.DEBIT_CARD.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.CREDIT_CARD.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                            AddMoneyStatusActivity.g(AddMoneyStatusActivity.this);
                        } else if (AddMoneyStatusActivity.this.F == SourceCardType.BHIM_UPI.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
                            AddMoneyStatusActivity.h(AddMoneyStatusActivity.this);
                        } else if (AddMoneyStatusActivity.this.F == SourceCardType.WALLET.getNumVal()) {
                            AddMoneyStatusActivity.g(AddMoneyStatusActivity.this);
                        }
                    }
                } else if (AddMoneyStatusActivity.this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    net.one97.paytm.helper.a.b().a((Context) AddMoneyStatusActivity.this, "passbook_landing_page", "add_money_wallet_passbook_clicked", (ArrayList<String>) null, (String) null, "summary screen - /wallet/add-money/summary", "passbook");
                    if (AddMoneyStatusActivity.this.M == 1) {
                        AddMoneyStatusActivity.j(AddMoneyStatusActivity.this);
                    } else if (AddMoneyStatusActivity.this.M != 2 && AddMoneyStatusActivity.this.M != 3) {
                    } else {
                        if (AddMoneyStatusActivity.this.F == SourceCardType.DEBIT_CARD.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.CREDIT_CARD.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                            AddMoneyStatusActivity.g(AddMoneyStatusActivity.this);
                        } else if (AddMoneyStatusActivity.this.F == SourceCardType.BHIM_UPI.getNumVal() || AddMoneyStatusActivity.this.F == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
                            AddMoneyStatusActivity.h(AddMoneyStatusActivity.this);
                        } else if (AddMoneyStatusActivity.this.F == SourceCardType.WALLET.getNumVal()) {
                            AddMoneyStatusActivity.g(AddMoneyStatusActivity.this);
                        }
                    }
                }
            }
        });
        this.m.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddMoneyStatusActivity.this.onBackPressed();
            }
        });
        this.O = (NestedScrollView) findViewById(R.id.scroll_view_parent);
        this.O.setOnScrollChangeListener(new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                if (i3 == 0) {
                    AddMoneyStatusActivity.this.P.setVisibility(0);
                } else {
                    AddMoneyStatusActivity.this.P.setVisibility(8);
                }
            }
        });
        Intent intent = getIntent();
        this.F = intent.getIntExtra("sourceAddMoney", 0);
        this.A = intent.getIntExtra("destinationAddMoney", 0);
        this.D = intent.getStringExtra("sourceImage");
        this.C = intent.getStringExtra("sourceName");
        this.B = intent.getStringExtra("sourceDesc");
        this.v = getIntent().getDoubleExtra("Amount", 0.0d);
        this.E = getIntent().getStringExtra("sourceUpiAddress");
        if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            this.Q.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.ic_paytm_logo));
        }
        if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            this.w = getIntent().getStringExtra("account_no");
            this.x = getIntent().getStringExtra("available_balance");
            if (TextUtils.isEmpty(this.C)) {
                this.j.setVisibility(8);
            } else {
                this.j.setText(this.C);
            }
            if (TextUtils.isEmpty(this.B)) {
                this.k.setVisibility(8);
            } else {
                this.k.setText(this.B);
            }
            if (this.F == SourceCardType.DEBIT_CARD.getNumVal() || this.F == SourceCardType.CREDIT_CARD.getNumVal() || this.F == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || this.F == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                this.H = intent.getStringExtra("orderId");
                this.G = intent.getStringExtra("mid");
                a(this.H);
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, AddMoneyUtils.a(this.D)));
            } else if (this.F == SourceCardType.BHIM_UPI.getNumVal() || this.F == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
                a();
                this.l.setVisibility(0);
                this.l.setText(getString(R.string.uam_upi_address, new Object[]{this.E}));
                this.k.setText(getString(R.string.uam_acc_no, new Object[]{this.B}));
            } else if (this.F == SourceCardType.WALLET.getNumVal()) {
                this.K.setVisibility(0);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
            }
        } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            if (com.paytm.utility.b.c((Context) this)) {
                this.R.c();
            }
            if (TextUtils.isEmpty(this.C)) {
                this.j.setVisibility(8);
            } else {
                this.j.setText(this.C);
            }
            if (TextUtils.isEmpty(this.B)) {
                this.k.setVisibility(8);
            } else {
                this.k.setText(this.B);
            }
            this.H = intent.getStringExtra("orderId");
            this.G = intent.getStringExtra("mid");
            a(this.H);
            if (this.F == SourceCardType.DEBIT_CARD.getNumVal() || this.F == SourceCardType.CREDIT_CARD.getNumVal() || this.F == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || this.F == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, AddMoneyUtils.a(this.D)));
            } else if (this.F == SourceCardType.BHIM_UPI.getNumVal() || this.F == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) {
                a();
                this.l.setVisibility(0);
                this.l.setText(getString(R.string.uam_upi_address, new Object[]{this.E}));
                this.j.setText(this.C);
                this.k.setText(getString(R.string.uam_acc_no, new Object[]{this.B}));
            } else if (this.F == SourceCardType.NET_BANKING.getNumVal()) {
                a();
            } else if (this.F == SourceCardType.PPB.getNumVal()) {
                this.p.setImageDrawable(androidx.core.content.b.a((Context) this, R.drawable.paytm_logo_money_transfer));
            }
        }
        this.y = (IJRDataModel) getIntent().getSerializableExtra("payment_response_object");
        IJRDataModel iJRDataModel = this.y;
        String str = "";
        if (iJRDataModel == null || !(iJRDataModel instanceof CJRSendMoney)) {
            IJRDataModel iJRDataModel2 = this.y;
            if (iJRDataModel2 == null || !(iJRDataModel2 instanceof CJRValidateTransaction)) {
                IJRDataModel iJRDataModel3 = this.y;
                if (iJRDataModel3 != null && (iJRDataModel3 instanceof BaseUpiResponse)) {
                    this.f48654e.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.b(Double.valueOf(this.v))}));
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) this.y;
                    if (!TextUtils.isEmpty(baseUpiResponse.getUpiTranlogId())) {
                        str = baseUpiResponse.getUpiTranlogId();
                    }
                    if ("0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        b();
                        this.f48655f.setText(getString(R.string.uam_added_successfully));
                        this.M = 1;
                        if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                            this.f48656g.setText(String.format(getString(R.string.uam_to_savings_acc), new Object[]{this.w}));
                            this.f48656g.setVisibility(0);
                            d();
                        } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                            this.f48655f.setText(getString(R.string.uam_money_added_successfully));
                            if (!TextUtils.isEmpty(this.H)) {
                                this.f48656g.setText(getString(R.string.uam_order_id, new Object[]{this.H}));
                                this.f48656g.setTextSize(2, 15.0f);
                                this.f48656g.setTypeface((Typeface) null, 0);
                                this.f48656g.setVisibility(0);
                            }
                        }
                        a("SUCCESS", str);
                    } else if ("91".equalsIgnoreCase(baseUpiResponse.getResponse()) || "92".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        this.q.setImageResource(R.drawable.group_3_copy_addmoney);
                        this.f48655f.setText(getString(R.string.uam_pending_status));
                        this.u.setText(R.string.uam_from_normal);
                        this.o.setText(baseUpiResponse.getMessage());
                        this.o.setVisibility(0);
                        this.n.setText(R.string.uam_view_transaction);
                        this.M = 2;
                        a("PENDING", str);
                    } else {
                        this.q.setImageResource(R.drawable.ic_failed_addmoney);
                        this.f48655f.setText(getString(R.string.uam_failed_status));
                        this.u.setText(R.string.uam_from_normal);
                        this.o.setText(baseUpiResponse.getMessage());
                        this.o.setVisibility(0);
                        this.n.setText(R.string.uam_view_transaction);
                        this.M = 3;
                        a("FAILURE", str);
                    }
                }
            } else {
                this.f48654e.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.b(Double.valueOf(this.v))}));
                this.p.setImageDrawable(getResources().getDrawable(R.drawable.uni_p2p_wallet_addmoney));
                CJRValidateTransaction cJRValidateTransaction = (CJRValidateTransaction) this.y;
                if (cJRValidateTransaction.getResponse() != null && !TextUtils.isEmpty(cJRValidateTransaction.getResponse().getBankTransactionId())) {
                    str = cJRValidateTransaction.getResponse().getBankTransactionId();
                }
                if ("PENDING".equalsIgnoreCase(cJRValidateTransaction.getStatus())) {
                    this.q.setImageResource(R.drawable.group_3_copy_addmoney);
                    this.f48655f.setText(getString(R.string.uam_pending_status));
                    this.u.setText(R.string.uam_from_normal);
                    this.o.setText(((CJRValidateTransaction) this.y).getStatusMessage());
                    this.o.setVisibility(0);
                    this.n.setText(R.string.uam_view_transaction);
                    this.M = 2;
                    a("PENDING", str);
                } else if ("FAILURE".equalsIgnoreCase(cJRValidateTransaction.getStatus())) {
                    this.q.setImageResource(R.drawable.ic_failed_addmoney);
                    this.f48655f.setText(getString(R.string.uam_failed_status));
                    this.u.setText(R.string.uam_from_normal);
                    this.o.setText(((CJRValidateTransaction) this.y).getStatusMessage());
                    this.o.setVisibility(0);
                    this.n.setText(R.string.uam_view_transaction);
                    this.M = 3;
                    a("FAILURE", str);
                } else {
                    b();
                    this.f48655f.setText(getString(R.string.uam_added_successfully));
                    this.j.setText(getString(R.string.paytm_wallet));
                    this.M = 1;
                    if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                        this.f48656g.setText(String.format(getString(R.string.uam_to_savings_acc), new Object[]{this.w}));
                        this.f48656g.setVisibility(0);
                        d();
                    } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                        this.f48655f.setText(getString(R.string.uam_money_added_successfully));
                        if (!TextUtils.isEmpty(this.H)) {
                            this.f48656g.setText(getString(R.string.uam_order_id, new Object[]{this.H}));
                            this.f48656g.setTextSize(2, 15.0f);
                            this.f48656g.setTypeface((Typeface) null, 0);
                            this.f48656g.setVisibility(0);
                        }
                    }
                    a("SUCCESS", str);
                }
            }
        } else {
            this.f48654e.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.b(Double.valueOf(this.v))}));
            this.p.setImageDrawable(getResources().getDrawable(R.drawable.uni_p2p_wallet_addmoney));
            CJRSendMoney cJRSendMoney = (CJRSendMoney) this.y;
            if (cJRSendMoney.getResponse() != null && !TextUtils.isEmpty(cJRSendMoney.getResponse().getBankTransactionId())) {
                str = cJRSendMoney.getResponse().getBankTransactionId();
            }
            if ("PENDING".equalsIgnoreCase(cJRSendMoney.getStatus())) {
                this.q.setImageResource(R.drawable.group_3_copy_addmoney);
                this.f48655f.setText(getString(R.string.uam_pending_status));
                this.u.setText(R.string.uam_from_normal);
                this.o.setText(((CJRSendMoney) this.y).getStatusMessage());
                this.o.setVisibility(0);
                this.n.setText(R.string.uam_view_transaction);
                this.M = 2;
                a("PENDING", str);
            } else if ("FAILURE".equalsIgnoreCase(cJRSendMoney.getStatus())) {
                this.q.setImageResource(R.drawable.ic_failed_addmoney);
                this.f48655f.setText(getString(R.string.uam_failed_status));
                this.u.setText(R.string.uam_from_normal);
                this.o.setText(((CJRSendMoney) this.y).getStatusMessage());
                this.o.setVisibility(0);
                this.n.setText(R.string.uam_view_transaction);
                this.M = 3;
                a("FAILURE", str);
            } else {
                b();
                this.f48655f.setText(getString(R.string.uam_added_successfully));
                this.j.setText(getString(R.string.paytm_wallet));
                this.M = 1;
                if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                    this.f48656g.setText(String.format(getString(R.string.uam_to_savings_acc), new Object[]{this.w}));
                    this.f48656g.setVisibility(0);
                    d();
                } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    this.f48655f.setText(getString(R.string.uam_money_added_successfully));
                    if (!TextUtils.isEmpty(this.H)) {
                        this.f48656g.setText(getString(R.string.uam_order_id, new Object[]{this.H}));
                        this.f48656g.setTextSize(2, 15.0f);
                        this.f48656g.setTypeface((Typeface) null, 0);
                        this.f48656g.setVisibility(0);
                    }
                }
                this.M = 1;
                a("SUCCESS", str);
            }
        }
        findViewById(R.id.lln_more_details).setVisibility(0);
        c();
        e.a(this, net.one97.paytm.helper.a.b().a("bank_addmoney_home_url", "https://storefront.paytm.com/v2/h/post-txn-page-new"), new net.one97.paytm.helper.b() {
            public final void onWidgetLoaded(SanitizedResponseModel sanitizedResponseModel) {
                AddMoneyStatusActivity.this.a(sanitizedResponseModel);
            }
        }, "add_money_post_transaction_screen");
        final View findViewById = findViewById(R.id.lyt_bottom_tab_bar);
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.scroll_view_parent);
        if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() {
                public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                    if (i3 > i5) {
                        findViewById.setVisibility(8);
                    }
                    if (i3 < i5) {
                        findViewById.setVisibility(0);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
        LinkedHashMap<Integer, IWidgetProvider> sfWidgets = ((SanitizedResponseModel) Objects.requireNonNull(sanitizedResponseModel)).getSfWidgets();
        this.f48650a = sfWidgets.get(104).getWidget(this, sanitizedResponseModel.getGaListener());
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.lyt_bottom_tab_bar);
        SFWidget sFWidget = this.f48650a;
        if (sFWidget instanceof IStaticWidget) {
            frameLayout.addView(((IStaticWidget) sFWidget).getView());
        }
        List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
        StoreFrontGAHandler gaListener = sanitizedResponseModel.getGaListener();
        net.one97.paytm.newaddmoney.view.e eVar = net.one97.paytm.newaddmoney.view.e.f55944a;
        net.one97.paytm.newaddmoney.view.e.a(getSupportFragmentManager(), findViewById(R.id.fl_adv), rvWidgets, "add_money_post_transaction_screen", gaListener);
    }

    public void onBackPressed() {
        if (g.a().l) {
            e();
        } else {
            finish();
        }
    }

    private void a() {
        if (!TextUtils.isEmpty(this.D)) {
            w.a().a(this.D).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.p, (com.squareup.picasso.e) null);
        } else {
            this.K.setVisibility(8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "PENDING"
            boolean r0 = r9.equalsIgnoreCase(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.String r9 = "pending"
            goto L_0x0024
        L_0x000c:
            java.lang.String r0 = "FAILURE"
            boolean r0 = r9.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0017
            java.lang.String r9 = "failed"
            goto L_0x0024
        L_0x0017:
            java.lang.String r0 = "SUCCESS"
            boolean r9 = r9.equalsIgnoreCase(r0)
            if (r9 == 0) goto L_0x0023
            java.lang.String r9 = "success"
            goto L_0x0024
        L_0x0023:
            r9 = r1
        L_0x0024:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r9 = "/"
            r0.append(r9)
            r0.append(r10)
            java.lang.String r6 = r0.toString()
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.DEBIT_CARD
            int r10 = r10.getNumVal()
            if (r9 == r10) goto L_0x00c2
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.PAYMENT_ITEM_TYPE_DC
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x004e
            goto L_0x00c2
        L_0x004e:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.CREDIT_CARD
            int r10 = r10.getNumVal()
            if (r9 == r10) goto L_0x00bf
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.PAYMENT_ITEM_TYPE_CC
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x0063
            goto L_0x00bf
        L_0x0063:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.BHIM_UPI
            int r10 = r10.getNumVal()
            if (r9 == r10) goto L_0x00bb
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.PAYMENT_ITEM_TYPE_UPI
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x0078
            goto L_0x00bb
        L_0x0078:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.WALLET
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x0085
            java.lang.String r9 = "paytm_wallet"
            goto L_0x00c4
        L_0x0085:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.FD
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x0092
            java.lang.String r9 = "fixed_deposit"
            goto L_0x00c4
        L_0x0092:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.OTHER_BANKS
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x009f
            java.lang.String r9 = "other_bank"
            goto L_0x00c4
        L_0x009f:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.GOLD
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x00ac
            java.lang.String r9 = "paytm_gold"
            goto L_0x00c4
        L_0x00ac:
            int r9 = r8.F
            net.one97.paytm.addmoney.common.model.SourceCardType r10 = net.one97.paytm.addmoney.common.model.SourceCardType.PPB
            int r10 = r10.getNumVal()
            if (r9 != r10) goto L_0x00b9
            java.lang.String r9 = "paytm_bank"
            goto L_0x00c4
        L_0x00b9:
            r7 = r1
            goto L_0x00c5
        L_0x00bb:
            java.lang.String r9 = "upi"
            goto L_0x00c4
        L_0x00bf:
            java.lang.String r9 = "credit_card"
            goto L_0x00c4
        L_0x00c2:
            java.lang.String r9 = "debit_card"
        L_0x00c4:
            r7 = r9
        L_0x00c5:
            int r9 = r8.A
            net.one97.paytm.addmoney.common.model.PaymentDestinationType r10 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_WALLET
            int r10 = r10.ordinal()
            if (r9 != r10) goto L_0x00d2
            java.lang.String r1 = "add_money_wallet"
            goto L_0x00de
        L_0x00d2:
            int r9 = r8.A
            net.one97.paytm.addmoney.common.model.PaymentDestinationType r10 = net.one97.paytm.addmoney.common.model.PaymentDestinationType.TO_PAYTM_BANK
            int r10 = r10.ordinal()
            if (r9 != r10) goto L_0x00de
            java.lang.String r1 = "add_money_bank"
        L_0x00de:
            r3 = r1
            java.lang.String r4 = "summary_screen_loaded"
            java.lang.String r5 = "/summary"
            r2 = r8
            net.one97.paytm.addmoney.utils.d.a((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.addmoney.status.view.AddMoneyStatusActivity.a(java.lang.String, java.lang.String):void");
    }

    private void b() {
        this.q.setVisibility(8);
        this.t.setVisibility(0);
        this.t.setAnimation("payment-success.json");
        this.t.loop(true);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AddMoneyStatusActivity.this.t.playAnimation();
            }
        }, 1000);
    }

    public void onDestroy() {
        super.onDestroy();
        this.R.b();
    }

    private void c() {
        net.one97.paytm.helper.a.b().a(getSupportFragmentManager(), R.id.deals_fragment_container);
    }

    private void a(String str) {
        new HashMap().put("screen_name", getClass().getSimpleName());
        String str2 = net.one97.paytm.helper.a.b().f("orderdetail") + str;
        f fVar = f.f72321a;
        String a2 = f.a(com.paytm.utility.b.b((Context) this, str2) + "&actions=1");
        f fVar2 = f.f72321a;
        String b2 = f.b(a2);
        com.paytm.network.b a3 = net.one97.paytm.addmoney.common.a.a();
        a3.f42877a = getApplicationContext();
        a3.o = getClass().getSimpleName();
        a3.f42880d = b2;
        a3.f42885i = new CJROrderSummary();
        a3.j = this;
        a3.l().a();
    }

    private void d() {
        if (com.paytm.utility.b.c((Context) this)) {
            new HashMap().put("screen_name", getClass().getSimpleName());
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization".toLowerCase(), com.paytm.utility.a.q(this));
            hashMap.put("Content-Type", "application/json");
            hashMap.put("channel", UpiConstants.B2C_ANDROID);
            String f2 = net.one97.paytm.helper.a.b().f(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW);
            com.paytm.network.b a2 = net.one97.paytm.addmoney.common.a.a();
            a2.f42877a = getApplicationContext();
            a2.o = getClass().getSimpleName();
            a2.f42880d = f2;
            a2.f42882f = hashMap;
            a2.f42885i = new CJRAccountSummary();
            a2.j = this;
            a2.l().a();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof AddMoneyStatusResponse) {
            try {
                if (this.J != null && this.J.isShowing()) {
                    this.J.dismiss();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
            AddMoneyStatusResponse addMoneyStatusResponse = (AddMoneyStatusResponse) iJRPaytmDataModel;
            this.f48654e.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.b(Double.valueOf(this.v))}));
            if (addMoneyStatusResponse.getResponse().getSTATUS().equals("TXN_SUCCESS")) {
                a("SUCCESS", addMoneyStatusResponse.getResponse().getTXNID());
                b();
                this.f48655f.setText(getString(R.string.uam_added_successfully));
                this.M = 1;
                if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                    this.f48656g.setText(String.format(getString(R.string.uam_to_savings_acc), new Object[]{this.w}));
                    this.f48656g.setVisibility(0);
                    d();
                } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    this.f48655f.setText(getString(R.string.uam_money_added_successfully));
                    if (!TextUtils.isEmpty(this.H)) {
                        this.f48656g.setText(getString(R.string.uam_order_id, new Object[]{this.H}));
                        this.f48656g.setTextSize(2, 15.0f);
                        this.f48656g.setTypeface((Typeface) null, 0);
                        this.f48656g.setVisibility(0);
                    }
                }
                this.m.setText(addMoneyStatusResponse.getResponse().getTXNDATE());
            } else if (addMoneyStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("TXN_FAILURE")) {
                a("FAILURE", addMoneyStatusResponse.getResponse().getTXNID());
                this.q.setImageResource(R.drawable.ic_failed_addmoney);
                this.f48655f.setText(getString(R.string.uam_failed_status));
                this.u.setText(R.string.uam_from_normal);
                this.M = 3;
                this.m.setText(addMoneyStatusResponse.getResponse().getTXNDATE());
                this.r.setVisibility(0);
                this.n.setText(R.string.uam_view_transaction);
            } else {
                a("PENDING", addMoneyStatusResponse.getResponse().getTXNID());
                this.q.setImageResource(R.drawable.group_3_copy_addmoney);
                this.f48655f.setText(getString(R.string.uam_pending_status));
                this.u.setText(R.string.uam_from_normal);
                this.M = 2;
                this.r.setVisibility(0);
                this.n.setText(R.string.uam_view_transaction);
            }
        } else if (iJRPaytmDataModel instanceof CJRAccountSummary) {
            CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) iJRPaytmDataModel;
            if (cJRAccountSummary != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                this.N = String.valueOf(cJRAccountSummary.getAccounts().get(0).getEffectiveBalance());
                if (this.F == SourceCardType.DEBIT_CARD.getNumVal() && this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                    this.r.setVisibility(8);
                } else {
                    this.r.setVisibility(0);
                    String T = com.paytm.utility.b.T(this.N);
                    if (Build.VERSION.SDK_INT <= 23) {
                        this.n.setText(Html.fromHtml(getString(R.string.uam_updated_savings_account_balance, new Object[]{T})));
                    } else {
                        this.n.setText(Html.fromHtml(getString(R.string.uam_updated_savings_account_balance, new Object[]{T}), 0));
                    }
                }
            }
        } else if (iJRPaytmDataModel instanceof CJROrderSummary) {
            this.f48654e.setText(String.format(getString(R.string.rupee), new Object[]{com.paytm.utility.b.b(Double.valueOf(this.v))}));
            CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
            try {
                Iterator<CJROrderSummaryPayment> it2 = cJROrderSummary.getPaymentInfo().iterator();
                while (it2.hasNext()) {
                    CJROrderSummaryPayment next = it2.next();
                    if (!TextUtils.isEmpty(next.getBankTransactionId()) && !next.getBankTransactionId().equalsIgnoreCase("NA")) {
                        this.I = next.getBankTransactionId();
                    }
                }
                if (this.A == PaymentDestinationType.TO_WALLET.getNumVal() && !TextUtils.isEmpty(this.I)) {
                    findViewById(R.id.post_txn_view).setVisibility(0);
                    View a2 = net.one97.paytm.helper.a.b().a((Context) this, getSupportFragmentManager(), this.I);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_20dp);
                    ((ViewGroup) findViewById(R.id.post_txn_view)).addView(a2, layoutParams);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            String paymentStatus = cJROrderSummary.getPaymentStatus();
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            if (paymentStatus.equalsIgnoreCase("SUCCESS")) {
                a("SUCCESS", cJROrderSummary.getId());
                b();
                this.f48655f.setText(getString(R.string.uam_added_successfully));
                this.M = 1;
                if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                    this.f48656g.setText(String.format(getString(R.string.uam_to_savings_acc), new Object[]{this.w}));
                    this.f48656g.setVisibility(0);
                    d();
                } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                    this.f48655f.setText(getString(R.string.uam_money_added_successfully));
                    if (!TextUtils.isEmpty(this.H)) {
                        this.f48656g.setText(getString(R.string.uam_order_id, new Object[]{this.H}));
                        this.f48656g.setTextSize(2, 15.0f);
                        this.f48656g.setTypeface((Typeface) null, 0);
                        this.f48656g.setVisibility(0);
                    }
                }
            } else {
                String str = "";
                if (paymentStatus.equalsIgnoreCase("FAILED")) {
                    a("FAILURE", cJROrderSummary.getId());
                    this.q.setImageResource(R.drawable.ic_failed_addmoney);
                    this.f48655f.setText(getString(R.string.uam_failed_status));
                    this.u.setText(R.string.uam_from_normal);
                    TextView textView = this.o;
                    if (!TextUtils.isEmpty(cJROrderSummary.getPaymentText())) {
                        str = cJROrderSummary.getPaymentText();
                    }
                    textView.setText(str);
                    this.o.setVisibility(0);
                    this.r.setVisibility(0);
                    this.n.setText(R.string.uam_view_transaction);
                    this.M = 3;
                } else {
                    a("PENDING", cJROrderSummary.getId());
                    this.q.setImageResource(R.drawable.group_3_copy_addmoney);
                    this.f48655f.setText(getString(R.string.uam_pending_status));
                    this.u.setText(R.string.uam_from_normal);
                    TextView textView2 = this.o;
                    if (!TextUtils.isEmpty(cJROrderSummary.getPaymentText())) {
                        str = cJROrderSummary.getPaymentText();
                    }
                    textView2.setText(str);
                    this.o.setVisibility(0);
                    this.r.setVisibility(0);
                    this.n.setText(R.string.uam_view_transaction);
                    this.M = 2;
                }
            }
            String promoCode = cJROrderedCart.getPromoCode();
            if (!TextUtils.isEmpty(promoCode)) {
                String promoText = cJROrderedCart.getPromoText();
                if (!TextUtils.isEmpty(promoText)) {
                    this.s.setVisibility(0);
                    this.f48657h.setText(promoCode);
                    this.f48658i.setText(promoText);
                }
            }
        }
        e();
    }

    private static void a(ViewGroup viewGroup, ViewParent viewParent, View view, Point point) {
        while (true) {
            ViewGroup viewGroup2 = (ViewGroup) viewParent;
            point.x += view.getLeft();
            point.y += view.getTop();
            if (!viewGroup2.equals(viewGroup)) {
                view = viewGroup2;
                viewParent = viewGroup2.getParent();
            } else {
                return;
            }
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRCashWallet) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
            if (cJRCashWallet.getResponse() != null) {
                double paytmWalletBalance = cJRCashWallet.getResponse().getPaytmWalletBalance();
                this.r.setVisibility(0);
                String T = com.paytm.utility.b.T(String.valueOf(paytmWalletBalance));
                if (Build.VERSION.SDK_INT <= 23) {
                    this.n.setText(Html.fromHtml(getString(R.string.uam_updated_wallet_balance, new Object[]{T})));
                    return;
                }
                this.n.setText(Html.fromHtml(getString(R.string.uam_updated_wallet_balance, new Object[]{T}), 0));
            }
        }
    }

    public final void b(IJRPaytmDataModel iJRPaytmDataModel) {
        a(iJRPaytmDataModel);
    }

    public final void b(NetworkCustomError networkCustomError) {
        a(networkCustomError);
    }

    public final void a(NetworkCustomError networkCustomError) {
        if ("401,403,410".contains(networkCustomError.getMessage())) {
            net.one97.paytm.helper.a.b().a((Activity) this, AddMoneyStatusActivity.class.getCanonicalName(), (Bundle) null);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        AddMoneyUtils.a(this, networkCustomError, (String) null, Boolean.FALSE);
    }

    private void e() {
        if (g.a().l) {
            if (!isFinishing()) {
                net.one97.paytm.helper.a.b().a((Context) this, this.M);
            }
            g.a().l = false;
            finish();
        }
    }

    static /* synthetic */ void b(AddMoneyStatusActivity addMoneyStatusActivity) {
        addMoneyStatusActivity.L.setVisibility(8);
        addMoneyStatusActivity.findViewById(R.id.lln_more_details).setVisibility(0);
        addMoneyStatusActivity.c();
        ScrollView scrollView = (ScrollView) addMoneyStatusActivity.findViewById(R.id.scroll_view_parent);
        View findViewById = addMoneyStatusActivity.findViewById(R.id.lln_more_details);
        Point point = new Point();
        a(scrollView, findViewById.getParent(), findViewById, point);
        scrollView.smoothScrollTo(0, point.y);
    }

    static /* synthetic */ void e(AddMoneyStatusActivity addMoneyStatusActivity) {
        Bundle bundle = new Bundle();
        bundle.putString("display_name", addMoneyStatusActivity.getString(R.string.savings_account));
        bundle.putInt("sub_wallet_type", n.SAVINGS_ACCOUNT.getValue());
        net.one97.paytm.helper.a.b().a((Context) addMoneyStatusActivity, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=savings", bundle);
        addMoneyStatusActivity.finish();
    }

    static /* synthetic */ void g(AddMoneyStatusActivity addMoneyStatusActivity) {
        Bundle bundle = new Bundle();
        bundle.putInt(net.one97.paytm.addmoney.utils.b.f48954f, net.one97.paytm.addmoney.utils.b.f48953e);
        net.one97.paytm.helper.a.b().a((Context) addMoneyStatusActivity, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet", bundle);
        addMoneyStatusActivity.finish();
    }

    static /* synthetic */ void h(AddMoneyStatusActivity addMoneyStatusActivity) {
        addMoneyStatusActivity.startActivity(new Intent(addMoneyStatusActivity, UpiLandingPageActivity.class));
        addMoneyStatusActivity.finish();
    }

    static /* synthetic */ void j(AddMoneyStatusActivity addMoneyStatusActivity) {
        Bundle bundle = new Bundle();
        bundle.putString("display_name", addMoneyStatusActivity.getString(R.string.savings_account));
        bundle.putInt("sub_wallet_type", n.PAYTM_WALLET.getValue());
        net.one97.paytm.helper.a.b().a((Context) addMoneyStatusActivity, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet", bundle);
        addMoneyStatusActivity.finish();
    }
}
