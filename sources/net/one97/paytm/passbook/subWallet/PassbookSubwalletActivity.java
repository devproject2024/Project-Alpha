package net.one97.paytm.passbook.subWallet;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.utility.h;
import com.paytm.utility.k;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.AccountBalanceModel;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRHomePageItem;
import net.one97.paytm.passbook.beans.CJRP2BStatus;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.GiftVoucherResponseData;
import net.one97.paytm.passbook.beans.postpaid.CJRPPAccount;
import net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.customview.c;
import net.one97.paytm.passbook.main.entity.MultiSubWallet;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.savingAccount.b;
import net.one97.paytm.passbook.subWallet.b.f;
import net.one97.paytm.passbook.subWallet.c.a;
import net.one97.paytm.passbook.subWallet.c.d;
import net.one97.paytm.passbook.utility.CirclePageIndicator;
import net.one97.paytm.passbook.utility.d;
import net.one97.paytm.passbook.utility.g;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class PassbookSubwalletActivity extends BaseActivity implements View.OnClickListener, AppBarLayout.b, a.b {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private RelativeLayout H;
    private RelativeLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private RelativeLayout L;
    private RelativeLayout M;
    private RelativeLayout N;
    private RelativeLayout O;
    private RelativeLayout P;
    private RelativeLayout Q;
    private View R;
    private CJRSubWallet S = new CJRSubWallet();
    private CJRP2BStatus T;
    /* access modifiers changed from: private */
    public int U;
    private SeekBar V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    String[] f58761a = {AppConstants.FOR_ALL, "Paid", "Received", "Added", "On Hold"};
    private LinearLayout aA;
    private ViewPager aB;
    private CirclePageIndicator aC;
    private String aD;
    private boolean aE;
    private LinearLayout aF;
    private int aG;
    private UpiProfileDefaultBank aH;
    private boolean aI = false;
    private CJRPPUserProfileKycTnc aJ;
    private int aK = 0;
    private TextView aL;
    /* access modifiers changed from: private */
    public String aM;
    private Button aa;
    private LinearLayout ab;
    private LinearLayout ac;
    private ImageView ad;
    private ImageView ae;
    private LottieAnimationView af;
    private LottieAnimationView ag;
    private TextView ah;
    private TextView ai;
    private boolean aj = false;
    private RelativeLayout ak;
    /* access modifiers changed from: private */
    public TextView al;
    private View am;
    private View an;
    private LinearLayout ao;
    /* access modifiers changed from: private */
    public ArrayList<String> ap;
    /* access modifiers changed from: private */
    public ArrayList<String> aq;
    /* access modifiers changed from: private */
    public int ar = 0;
    /* access modifiers changed from: private */
    public ImageView as;
    private CJRPPAccount at;
    private CJRPPUserProfileKycTnc au;
    private TextView av;
    private TextView aw;
    private TextView ax;
    private g ay;
    private LinearLayout az;

    /* renamed from: b  reason: collision with root package name */
    public String f58762b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, Drawable> f58763c = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f58764d;

    /* renamed from: e  reason: collision with root package name */
    private d f58765e;

    /* renamed from: f  reason: collision with root package name */
    private Context f58766f;

    /* renamed from: g  reason: collision with root package name */
    private Menu f58767g;

    /* renamed from: h  reason: collision with root package name */
    private Toolbar f58768h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f58769i;
    private TextView j;
    private MenuItem k;
    private MenuItem l;
    private MenuItem m;
    private SearchView n;
    private String o = "";
    private String p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private String w;
    private String x;
    private LinearLayout y;
    private LinearLayout z;

    public void onCreate(Bundle bundle) {
        String[] strArr;
        String str;
        CJRHomePageItem cJRHomePageItem;
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_subwallet);
        this.f58764d = (LinearLayout) findViewById(R.id.tagSavedLl);
        findViewById(R.id.okTv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassbookSubwalletActivity.this.a(view);
            }
        });
        this.f58765e = new d(this, this);
        net.one97.paytm.passbook.d.b().s();
        this.U = getIntent().getIntExtra("sub_wallet_type", -1);
        this.w = getIntent().getStringExtra("display_name");
        this.x = getIntent().getStringExtra("display_amount");
        this.S = (CJRSubWallet) getIntent().getSerializableExtra("subwallet-list");
        if (this.S instanceof MultiSubWallet) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.S.getBalance());
            this.x = sb.toString();
        }
        this.au = this.aJ;
        this.f58762b = getIntent().getStringExtra("ACCOUNT_NUMBER");
        this.aE = getIntent().getBooleanExtra(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, false);
        this.aG = getIntent().getIntExtra(UpiConstants.FROM, 0);
        this.aH = (UpiProfileDefaultBank) getIntent().getSerializableExtra("upi_data");
        this.o = getString(R.string.paytm_balance);
        this.f58766f = this;
        this.aF = (LinearLayout) findViewById(R.id.topHeaderLayout);
        if (this.aE) {
            this.aF.setVisibility(8);
        }
        this.az = (LinearLayout) findViewById(R.id.single_sub_wallet_layout);
        this.aA = (LinearLayout) findViewById(R.id.multiple_sub_wallet_layout);
        this.aB = (ViewPager) findViewById(R.id.multiple_sub_wallet_pager);
        this.aC = (CirclePageIndicator) findViewById(R.id.page_indicator);
        this.as = (ImageView) findViewById(R.id.active_imv);
        this.ao = (LinearLayout) findViewById(R.id.filter_layout_ll);
        this.al = (TextView) findViewById(R.id.filter_title_tv);
        this.am = findViewById(R.id.wallet_filter_text);
        this.am.setOnClickListener(this);
        if (this.U == n.PAYTM_POSTPAID.getValue() || this.U == n.TOLL.getValue()) {
            this.ao.setVisibility(8);
        }
        this.F = (LinearLayout) findViewById(R.id.loader_ll);
        this.af = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.G = (LinearLayout) findViewById(R.id.send_money_loader_ll);
        this.ag = (LottieAnimationView) findViewById(R.id.send_money_loader);
        this.ae = (ImageView) findViewById(R.id.logo);
        this.q = (TextView) findViewById(R.id.tv_wallet_balance);
        if (!TextUtils.isEmpty(this.p)) {
            c.b(this.p, this.q);
        }
        this.aL = (TextView) findViewById(R.id.tvGiftVoucherCount);
        this.r = (TextView) findViewById(R.id.tv_title_text);
        this.s = (TextView) findViewById(R.id.tv_issued_by);
        this.ad = (ImageView) findViewById(R.id.iv_issuer_image);
        this.t = (TextView) findViewById(R.id.tv_request_expires);
        this.y = (LinearLayout) findViewById(R.id.sub_wallet_header_layout);
        this.z = (LinearLayout) findViewById(R.id.saving_account_header_layout);
        this.A = (LinearLayout) findViewById(R.id.foodwallet_header_layout);
        this.B = (LinearLayout) findViewById(R.id.gift_voucher_header_layout);
        this.C = (LinearLayout) findViewById(R.id.toll_header_layout);
        this.D = (LinearLayout) findViewById(R.id.gift_wallet_header_layout);
        this.E = (LinearLayout) findViewById(R.id.postpaid_header_layout);
        this.V = (SeekBar) findViewById(R.id.post_paid_seekbar);
        this.W = (TextView) findViewById(R.id.tv_used_amount);
        this.X = (TextView) findViewById(R.id.tv_total_amount);
        this.Y = (TextView) findViewById(R.id.tv_used_amount);
        this.ah = (TextView) findViewById(R.id.tv_amount_used);
        this.Z = (TextView) findViewById(R.id.tv_as_date);
        this.aa = (Button) findViewById(R.id.btn_pay_now);
        this.ai = (TextView) findViewById(R.id.tv_due_date);
        this.u = (TextView) findViewById(R.id.tv_next_toll_balance);
        this.Q = (RelativeLayout) findViewById(R.id.rl_view_spend_analytics);
        this.Q.setOnClickListener(this);
        this.R = findViewById(R.id.view_SA_divider);
        this.H = (RelativeLayout) findViewById(R.id.rl_download_statement);
        this.H.setOnClickListener(this);
        this.K = (RelativeLayout) findViewById(R.id.rl_send_money_layout);
        this.K.setOnClickListener(this);
        this.L = (RelativeLayout) findViewById(R.id.rl_add_money_layout);
        this.L.setOnClickListener(this);
        this.J = (RelativeLayout) findViewById(R.id.rl_buy_gift_voucher);
        this.J.setOnClickListener(this);
        this.an = findViewById(R.id.v_divider);
        if (b(c.v())) {
            this.J.setVisibility(0);
            this.an.setVisibility(0);
        } else {
            this.J.setVisibility(8);
            this.an.setVisibility(8);
        }
        this.P = (RelativeLayout) findViewById(R.id.rl_redeem_gv);
        this.P.setOnClickListener(this);
        this.M = (RelativeLayout) findViewById(R.id.rl_money_transfer_layout);
        this.M.setOnClickListener(this);
        this.ak = (RelativeLayout) findViewById(R.id.rl_download_saving_account_statement);
        this.ak.setOnClickListener(this);
        this.N = (RelativeLayout) findViewById(R.id.rl_add_money_saving_account_layout);
        this.N.setOnClickListener(this);
        this.O = (RelativeLayout) findViewById(R.id.rl_manage_toll_tags);
        this.O.setOnClickListener(this);
        this.I = (RelativeLayout) findViewById(R.id.rl_download_statement_toll_tags);
        this.I.setOnClickListener(this);
        this.av = (TextView) findViewById(R.id.tv_download_statement);
        this.aw = (TextView) findViewById(R.id.tv_saving_account_download);
        this.ax = (TextView) findViewById(R.id.tv_fastag_download_statement);
        net.one97.paytm.passbook.d.b().b();
        this.aD = c(c.v());
        ((AppBarLayout) findViewById(R.id.appbar)).a((AppBarLayout.b) this);
        a(this.au);
        if (this.U == n.GIFT_VOUCHER.getValue()) {
            strArr = getResources().getStringArray(R.array.passbook_tabs_gift_voucher);
        } else if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
            strArr = getResources().getStringArray(R.array.passbook_saving_account_tabs);
        } else {
            strArr = getResources().getStringArray(R.array.passbook_tabs);
        }
        net.one97.paytm.passbook.mapping.g.a();
        this.ap = net.one97.paytm.passbook.mapping.g.a(strArr);
        this.aq = new ArrayList<>(Arrays.asList(this.f58761a));
        this.al.setText(getString(R.string.recent));
        if (this.U != n.SAVINGS_ACCOUNT.getValue() && net.one97.paytm.passbook.subWallet.b.d.a() != null) {
            net.one97.paytm.passbook.subWallet.b.d.a();
            this.aq.get(this.ar);
        } else if (this.U == n.SAVINGS_ACCOUNT.getValue() && b.a() != null) {
            b.a().a(this.ar);
        }
        if (net.one97.paytm.passbook.d.b().j()) {
            this.N.setVisibility(0);
            findViewById(R.id.add_money_to_sa_divider).setVisibility(0);
        } else {
            this.N.setVisibility(8);
            findViewById(R.id.add_money_to_sa_divider).setVisibility(8);
        }
        o();
        if (net.one97.paytm.passbook.d.b().a("isSpendAnalyticsEnabledInPassbook8.6.5", true)) {
            this.R.setVisibility(0);
            this.Q.setVisibility(0);
        } else {
            this.R.setVisibility(8);
            this.Q.setVisibility(8);
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ((a.b) this.f58765e.f57072a).j();
        this.f58765e.a();
        if (this.U == n.GIFT_VOUCHER.getValue()) {
            this.f58765e.g();
        }
        net.one97.paytm.passbook.d.b();
        if (this.aG != 100) {
            if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
                net.one97.paytm.passbook.d.b().a("/passbook/savings-account", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, (Context) this);
            } else if (this.U == n.PAYTM_WALLET.getValue()) {
                net.one97.paytm.passbook.d.b().a("/passbook/wallet", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, (Context) this);
            }
        }
        try {
            if (!(getIntent().getSerializableExtra("extra_home_data") == null || (cJRHomePageItem = (CJRHomePageItem) q.a((Object) getIntent().getSerializableExtra("extra_home_data"), CJRHomePageItem.class)) == null || TextUtils.isEmpty(c.ab(cJRHomePageItem.getPushFeatureType())))) {
                Intent intent = getIntent();
                if (com.paytm.utility.b.c((Context) this) && this.T != null) {
                    net.one97.paytm.passbook.d.b().a((Activity) this, this.T, intent);
                } else if (!com.paytm.utility.b.c((Context) this)) {
                    Toast.makeText(this, getResources().getString(R.string.err_nonetwork_msg), 1).show();
                } else if (this.T == null) {
                    Toast.makeText(this, getResources().getString(R.string.please_wait_while_we_fetch_some_details), 1).show();
                    this.f58765e.b();
                }
            }
        } catch (Exception unused) {
        }
        if (this.U == n.PAYTM_WALLET.getValue() && getIntent().getBooleanExtra("extra_send_to_bank", false)) {
            this.K.performClick();
        }
        d dVar = this.f58765e;
        if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
            com.paytm.utility.b.e(dVar.f58894b);
        }
        if (this.w.equalsIgnoreCase("fastag")) {
            str = "/uth_passbook_myaccounts/fastag_wallet";
        } else {
            str = "/uth_passbook_myaccounts/" + this.w.replace(" ", "_").replace("-", "_").toLowerCase();
        }
        net.one97.paytm.passbook.d.b().b(str, "PASSBOOK", this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f58764d.setVisibility(8);
    }

    private void m() {
        if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
            this.f58765e.f();
        } else if (this.U == n.PAYTM_POSTPAID.getValue()) {
            if (this.au == null) {
                this.f58765e.e();
            } else {
                x();
            }
        } else if (!this.aE) {
            this.f58765e.c();
        }
    }

    public void onStart() {
        super.onStart();
        this.p = "---";
        findViewById(R.id.account_block_layout).setVisibility(8);
        if (!TextUtils.isEmpty(this.x)) {
            if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
                this.aI = true;
            }
            if (Double.parseDouble(this.x) > 0.0d || this.U != n.SAVINGS_ACCOUNT.getValue()) {
                c.Z(this.x);
                if (Double.parseDouble(this.x) >= 0.0d) {
                    this.p = this.x;
                    this.p = new DecimalFormat(q.a(Double.parseDouble(this.p)), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.p));
                }
                c.b(this.p, this.q);
                c.b(getString(R.string.rs) + " " + this.p, this.j);
                return;
            }
            m();
            return;
        }
        this.s.setVisibility(8);
        m();
    }

    public void onStop() {
        super.onStop();
    }

    public final void a(IJRDataModel iJRDataModel) {
        GiftVoucherResponseData giftVoucherResponseData;
        if (isFinishing() || (giftVoucherResponseData = (GiftVoucherResponseData) iJRDataModel) == null || giftVoucherResponseData.getStatusCode() == null || !giftVoucherResponseData.getStatusCode().equalsIgnoreCase("SUCCESS")) {
            return;
        }
        if (giftVoucherResponseData.getResponse() == null || giftVoucherResponseData.getResponse().getSubwalletStatusResponseList() == null) {
            this.aK = 0;
            n();
            return;
        }
        this.aK = giftVoucherResponseData.getResponse().getSubwalletStatusResponseList().size();
        n();
    }

    public final void a() {
        if (isFinishing()) {
        }
    }

    private void n() {
        if (this.aK > 0) {
            this.aL.setVisibility(0);
            TextView textView = this.aL;
            String string = getString(R.string.gv_count);
            StringBuilder sb = new StringBuilder();
            sb.append(this.aK);
            textView.setText(String.format(string, new Object[]{sb.toString()}));
            this.P.setVisibility(0);
            if (this.J.getVisibility() == 0) {
                this.an.setVisibility(0);
                return;
            }
            return;
        }
        this.aL.setVisibility(8);
        this.P.setVisibility(8);
        this.an.setVisibility(8);
    }

    public final void b(IJRDataModel iJRDataModel) {
        if (!isFinishing()) {
            CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRDataModel;
            if (cJRCashWallet.getResponse() != null) {
                this.S = a((ArrayList<CJRSubWallet>) new ArrayList(cJRCashWallet.getResponse().getSubWalletDetailList()), this.U);
                CJRSubWallet cJRSubWallet = this.S;
                if (cJRSubWallet != null) {
                    c.Z(net.one97.paytm.passbook.mapping.a.c(Double.valueOf(cJRSubWallet.getBalance())));
                    this.p = new DecimalFormat(q.a(this.S.getBalance()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(this.S.getBalance());
                }
                c.b(this.p, this.q);
                c.b(getString(R.string.rs) + " " + this.p, this.j);
                if (b(cJRCashWallet.getResponse().getWalletGrade())) {
                    this.J.setVisibility(0);
                    this.an.setVisibility(0);
                } else {
                    this.J.setVisibility(8);
                    this.an.setVisibility(8);
                }
                u();
            }
        }
    }

    public final void b() {
        if (!isFinishing()) {
            if (!TextUtils.isEmpty(this.x) && Double.parseDouble(this.x) >= 0.0d) {
                this.p = this.x;
                this.p = new DecimalFormat(q.a(Double.parseDouble(this.p)), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(Double.parseDouble(this.p));
            }
            c.b(this.p, this.q);
            c.b(getString(R.string.rs) + " " + this.p, this.j);
        }
    }

    private static CJRSubWallet a(ArrayList<CJRSubWallet> arrayList, int i2) {
        MultiSubWallet multiSubWallet;
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            CJRSubWallet cJRSubWallet = arrayList.get(i3);
            if (hashMap.containsKey(Integer.valueOf(cJRSubWallet.getSubWalletType()))) {
                multiSubWallet = (MultiSubWallet) hashMap.get(Integer.valueOf(cJRSubWallet.getSubWalletType()));
            } else {
                multiSubWallet = new MultiSubWallet(cJRSubWallet.getSubWalletType(), false);
            }
            multiSubWallet.addSubWallet(cJRSubWallet);
            hashMap.put(Integer.valueOf(cJRSubWallet.getSubWalletType()), multiSubWallet);
        }
        return (MultiSubWallet) hashMap.get(Integer.valueOf(i2));
    }

    public final void c(IJRDataModel iJRDataModel) {
        CJRAccountSummary cJRAccountSummary;
        if (!isFinishing() && (cJRAccountSummary = (CJRAccountSummary) iJRDataModel) != null && cJRAccountSummary.getStatus() != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
            AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
            if (accountBalanceModel.getEffectiveBalance() >= 0.0d) {
                this.p = new DecimalFormat(q.a(accountBalanceModel.getEffectiveBalance()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(accountBalanceModel.getEffectiveBalance());
            }
            c.b(this.p, this.q);
            c.b(getString(R.string.rs) + " " + this.p, this.j);
        }
    }

    public final void d(IJRDataModel iJRDataModel) {
        if (!isFinishing()) {
            CJRPPUserProfileKycTnc cJRPPUserProfileKycTnc = (CJRPPUserProfileKycTnc) iJRDataModel;
            if (cJRPPUserProfileKycTnc.getAccounts() != null && cJRPPUserProfileKycTnc.getAccounts().length > 0) {
                for (CJRPPAccount cJRPPAccount : cJRPPUserProfileKycTnc.getAccounts()) {
                    String applicationStatus = cJRPPAccount.getApplicationStatus();
                    if (!TextUtils.isEmpty(applicationStatus) && applicationStatus.equalsIgnoreCase("APPLICATION_CONFIRMED")) {
                        this.au = cJRPPUserProfileKycTnc;
                        a(this.au);
                        p();
                        this.p = new DecimalFormat(q.a(cJRPPAccount.getAvailableCreditLimit().doubleValue()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(cJRPPAccount.getAvailableCreditLimit());
                        c.b(this.p, this.q);
                        c.b(getString(R.string.rs) + " " + this.p, this.j);
                    }
                }
            }
        }
    }

    public final void c() {
        if (!isFinishing()) {
            c.b(this.p, this.q);
            c.b(getString(R.string.rs) + " " + this.p, this.j);
            if (!this.aE) {
                a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        PassbookSubwalletActivity.this.b(dialogInterface, i2);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        this.f58765e.d();
    }

    public final void d() {
        if (!isFinishing()) {
            a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PassbookSubwalletActivity.this.a(dialogInterface, i2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        this.f58765e.e();
    }

    public final void e() {
        this.F.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.af);
    }

    public final void f() {
        this.F.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.af);
    }

    public final void g() {
        this.G.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.ag);
    }

    public final void h() {
        this.G.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.ag);
    }

    public final void a(String str) {
        this.f58762b = str;
        if (this.aI) {
            this.f58765e.a();
            this.f58765e.d();
        } else if (!k.b()) {
            Intent intent = new Intent();
            intent.putExtra("ENTER_HEADER", "paytm_saving_account_confirm");
            net.one97.paytm.passbook.d.b().a((Activity) this, intent);
            startActivityForResult(intent, 101);
        } else {
            this.f58765e.a();
            this.f58765e.d();
            this.aI = true;
        }
    }

    public final void i() {
        if (!isFinishing()) {
            h hVar = new h(this);
            hVar.setTitle(getResources().getString(R.string.passbook_saving_acc_error));
            hVar.a(getResources().getString(R.string.passbook_saving_acc_issues));
            hVar.setCancelable(false);
            hVar.a(-3, getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    PassbookSubwalletActivity.this.finish();
                }
            });
            hVar.show();
        }
    }

    private static boolean b(String str) {
        String z2 = net.one97.paytm.passbook.d.b().z();
        if (v.a(z2)) {
            return false;
        }
        for (String equalsIgnoreCase : z2.split(AppConstants.COMMA)) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (net.one97.paytm.passbook.d.b().c((android.content.Context) r6) != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void o() {
        /*
            r6 = this;
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r0 = r0.k()
            boolean r1 = com.paytm.utility.v.a((java.lang.String) r0)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            r1 = 0
            r2 = 0
        L_0x0017:
            int r3 = r0.length
            r4 = 1
            if (r2 >= r3) goto L_0x0080
            r3 = r0[r2]
            java.lang.String r5 = "no_kyc"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x003a
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()
            int r3 = r3.b((android.content.Context) r6)
            if (r3 != 0) goto L_0x007d
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()
            boolean r3 = r3.c((android.content.Context) r6)
            if (r3 != 0) goto L_0x007d
            goto L_0x0081
        L_0x003a:
            java.lang.String r5 = "min_kyc"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0057
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            int r0 = r0.b((android.content.Context) r6)
            if (r0 != 0) goto L_0x0080
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            boolean r0 = r0.c((android.content.Context) r6)
            if (r0 == 0) goto L_0x0080
            goto L_0x0081
        L_0x0057:
            java.lang.String r5 = "no_kyc_expired"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x006a
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()
            int r3 = r3.d((android.content.Context) r6)
            if (r3 != r4) goto L_0x007d
            goto L_0x0081
        L_0x006a:
            java.lang.String r5 = "full_kyc"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x007d
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()
            int r3 = r3.b((android.content.Context) r6)
            if (r3 != r4) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x0080:
            r4 = 0
        L_0x0081:
            if (r4 == 0) goto L_0x008c
            android.widget.RelativeLayout r0 = r6.L
            if (r0 == 0) goto L_0x008c
            r1 = 8
            r0.setVisibility(r1)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity.o():void");
    }

    private void a(CJRPPUserProfileKycTnc cJRPPUserProfileKycTnc) {
        if (!(cJRPPUserProfileKycTnc == null || cJRPPUserProfileKycTnc.getAccounts() == null || cJRPPUserProfileKycTnc.getAccounts().length <= 0)) {
            for (int i2 = 0; i2 < cJRPPUserProfileKycTnc.getAccounts().length; i2++) {
                if (cJRPPUserProfileKycTnc.getAccounts()[i2].isUserEligible()) {
                    this.at = cJRPPUserProfileKycTnc.getAccounts()[i2];
                }
            }
        }
        if (this.at != null) {
            q();
            p();
        }
    }

    private void p() {
        if (this.at.getAuthorisedCreditLimit() != null && this.at.getAvailableCreditLimit() != null) {
            if (this.at.getAuthorisedCreditLimit().doubleValue() <= this.at.getAvailableCreditLimit().doubleValue()) {
                findViewById(R.id.postpaid_paynow_container_rl).setVisibility(8);
                return;
            }
            findViewById(R.id.postpaid_paynow_container_rl).setVisibility(0);
            CJRPPAccount cJRPPAccount = this.at;
            if (cJRPPAccount == null || cJRPPAccount.getBillingDetails() == null) {
                TextView textView = this.Z;
                textView.setText(getString(R.string.as_on) + " " + s());
                if (this.at.getAuthorisedCreditLimit() != null && this.at.getAvailableCreditLimit() != null) {
                    double doubleValue = this.at.getAuthorisedCreditLimit().doubleValue() - this.at.getAvailableCreditLimit().doubleValue();
                    String format = new DecimalFormat(q.a(doubleValue), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(doubleValue);
                    this.ah.setText(String.format(getString(R.string.pp_amount_used_rs), new Object[]{format}));
                }
            } else if (this.at.getBillingDetails().getBillTotalAmount().doubleValue() == 0.0d) {
                double doubleValue2 = this.at.getAuthorisedCreditLimit().doubleValue() - this.at.getAvailableCreditLimit().doubleValue();
                String format2 = new DecimalFormat(q.a(doubleValue2), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(doubleValue2);
                this.ah.setText(String.format(getString(R.string.pp_amount_used_rs), new Object[]{format2}));
                TextView textView2 = this.Z;
                textView2.setText(getString(R.string.as_on) + " " + s());
                this.ai.setVisibility(8);
            } else {
                double doubleValue3 = this.at.getBillingDetails().getBillTotalAmount().doubleValue();
                String format3 = new DecimalFormat(q.a(doubleValue3), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(doubleValue3);
                this.ah.setText(String.format(getString(R.string.pp_amount_due_rs), new Object[]{format3}));
                String j2 = c.j(this.at.getBillingDetails().getCutOffDate(), "dd MMM, yyyy");
                TextView textView3 = this.ai;
                textView3.setText(getString(R.string.due_date) + " " + j2);
                this.ai.setVisibility(0);
                this.Z.setText(c.j(this.at.getBillingDetails().getBillStartDate(), "dd/MM/yyyy") + " - " + c.j(this.at.getBillingDetails().getBillEndDate(), "dd/MM/yyyy"));
            }
        }
    }

    private void q() {
        TextView textView = this.W;
        textView.setText("₹ " + r());
        this.X.setText("₹ ".concat(String.valueOf(this.at.getAuthorisedCreditLimit() != null ? new DecimalFormat(q.a(this.at.getAuthorisedCreditLimit().doubleValue()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(this.at.getAuthorisedCreditLimit()) : "")));
        this.Y = (TextView) findViewById(R.id.tv_amount_used);
        TextView textView2 = this.Y;
        textView2.setText("₹ " + r());
        this.aa.setOnClickListener(this);
        if (this.at.getAuthorisedCreditLimit() != null) {
            this.V.setMax(this.at.getAuthorisedCreditLimit().intValue());
        }
        double d2 = 0.0d;
        if (!(this.at.getAuthorisedCreditLimit() == null || this.at.getAvailableCreditLimit() == null)) {
            d2 = this.at.getAuthorisedCreditLimit().doubleValue() - this.at.getAvailableCreditLimit().doubleValue();
        }
        this.V.setProgress((int) d2);
        this.V.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    private String r() {
        double d2;
        if (this.at.getAuthorisedCreditLimit() != null) {
            d2 = this.at.getAvailableCreditLimit() != null ? this.at.getAuthorisedCreditLimit().doubleValue() - this.at.getAvailableCreditLimit().doubleValue() : this.at.getAuthorisedCreditLimit().doubleValue();
        } else {
            d2 = 0.0d;
        }
        return new DecimalFormat(q.a(d2), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(d2);
    }

    private static String s() {
        return new SimpleDateFormat("dd MMM, yyyy").format(Calendar.getInstance().getTime());
    }

    public final void j() {
        this.f58768h = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.f58768h);
        this.f58768h.setNavigationIcon(net.one97.paytm.common.widgets.R.drawable.back_arrow);
        getSupportActionBar().c(false);
        this.f58769i = (TextView) this.f58768h.findViewById(R.id.toolbar_title);
        this.v = (TextView) this.f58768h.findViewById(R.id.toolbar_header_title);
        this.j = (TextView) this.f58768h.findViewById(R.id.tv_toolbar_total_balance);
        com.paytm.utility.b.d(this.f58769i);
        this.ab = (LinearLayout) this.f58768h.findViewById(R.id.ll_toolbar_balance);
        this.ac = (LinearLayout) this.f58768h.findViewById(R.id.ll_toolbar_header);
        this.f58769i.setTextSize(19.0f);
        this.f58768h.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PassbookSubwalletActivity.this.onBackPressed();
            }
        });
        this.ay = new g(this, this.ab, this.ac);
        this.f58769i.setText(this.o);
        if (TextUtils.isEmpty(this.x) || Double.parseDouble(this.x) < 0.0d) {
            this.p = "---";
        } else {
            this.p = this.x;
        }
        c.b(getString(R.string.rs) + " " + this.p, this.j);
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (i2 == 0 || i2 >= -270) {
            this.ab.setVisibility(8);
            if (this.ac.getVisibility() == 8) {
                this.ay.b();
                this.ay.d();
                this.ac.setVisibility(0);
                if (this.U == n.PAYTM_POSTPAID.getValue()) {
                    this.f58769i.setText(getString(R.string.pp_header));
                    return;
                }
                return;
            }
            return;
        }
        this.ac.setVisibility(8);
        if (this.ab.getVisibility() == 8) {
            this.ay.c();
            this.ay.a();
            this.ab.setVisibility(0);
            if (this.U == n.PAYTM_POSTPAID.getValue()) {
                this.f58769i.setText(getString(R.string.paytm_postpaid));
            }
        }
    }

    public final void k() {
        if (!isFinishing()) {
            j supportFragmentManager = getSupportFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putString(PayUtility.WALLET_TYPE, this.w);
            bundle.putInt("sub_wallet_type", this.U);
            if (!TextUtils.isEmpty(this.aM)) {
                bundle.putString("walletTransactiontype", this.aM);
            }
            if (this.U == n.PAYTM_WALLET.getValue()) {
                this.ae.setImageResource(R.drawable.pass_payments_bank_logo);
                this.v.setText(getString(R.string.paytm_balance));
                this.y.setVisibility(0);
                net.one97.paytm.passbook.subWallet.b.d dVar = new net.one97.paytm.passbook.subWallet.b.d();
                bundle.putSerializable("subwallet-list", this.S);
                bundle.putBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, this.aE);
                dVar.setArguments(bundle);
                supportFragmentManager.a().b(R.id.sub_wallet_container, dVar, (String) null).c();
            } else if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
                this.ae.setImageResource(R.drawable.pass_payments_bank_logo);
                this.z.setVisibility(0);
                this.o = getString(R.string.pass_available_for_payment);
                this.v.setText(this.w);
                ((ImageView) findViewById(R.id.logo)).setImageResource(R.drawable.pass_ic_payment_bank);
                this.f58769i.setText(this.o);
                this.r.setText(this.o);
                if (getIntent().getStringExtra("ppb_total_balance") != null) {
                    this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.pass_info, 0);
                    this.r.setCompoundDrawablePadding(10);
                    this.r.setOnClickListener(this);
                }
                b bVar = new b();
                bundle.putString(PayUtility.WALLET_TYPE, this.w);
                bundle.putSerializable("ACCOUNT_NUMBER", this.f58762b);
                bundle.putInt(UpiConstants.FROM, this.aG);
                bundle.putBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, this.aE);
                bVar.setArguments(bundle);
                supportFragmentManager.a().a(R.id.sub_wallet_container, (Fragment) bVar).c();
            } else if (this.U == n.FOOD_WALLET.getValue()) {
                this.A.setVisibility(0);
                this.o = String.format(getString(R.string.sub_wallet_balance), new Object[]{this.w});
                this.f58769i.setText(this.o);
                this.v.setText(this.w);
                net.one97.paytm.passbook.subWallet.b.d dVar2 = new net.one97.paytm.passbook.subWallet.b.d();
                bundle.putString(PayUtility.WALLET_TYPE, this.w);
                bundle.putSerializable("subwallet-list", this.S);
                dVar2.setArguments(bundle);
                supportFragmentManager.a().b(R.id.sub_wallet_container, dVar2, (String) null).c();
                net.one97.paytm.passbook.d.b().b("/passbook/food-wallet", "passbook", this);
            } else if (this.U == n.TOLL.getValue()) {
                this.u.setVisibility(0);
                this.C.setVisibility(0);
                this.f58769i.setText(getString(R.string.toll_title));
                this.v.setText(getString(R.string.fastag));
                this.v.setAllCaps(true);
                f fVar = new f();
                Bundle bundle2 = new Bundle();
                bundle2.putString("wallet card type", this.f58766f.getString(R.string.passbook_paytm_toll));
                fVar.setArguments(bundle2);
                supportFragmentManager.a().b(R.id.sub_wallet_container, fVar, (String) null).c();
            } else if (this.U == n.GIFT_CARDS.getValue()) {
                this.A.setVisibility(0);
                this.o = String.format(getString(R.string.sub_wallet_balance), new Object[]{this.w});
                this.f58769i.setText(this.o);
                this.v.setText(this.w);
                net.one97.paytm.passbook.subWallet.b.d dVar3 = new net.one97.paytm.passbook.subWallet.b.d();
                bundle.putString(PayUtility.WALLET_TYPE, this.w);
                bundle.putSerializable("subwallet-list", this.S);
                dVar3.setArguments(bundle);
                supportFragmentManager.a().b(R.id.sub_wallet_container, dVar3, (String) null).c();
                this.aj = true;
                net.one97.paytm.passbook.d.b().b("/passbook/gift-wallet", "passbook", this);
            } else if (this.U == n.LOYALTY_WALLET.getValue()) {
                this.A.setVisibility(0);
                this.o = String.format(getString(R.string.sub_wallet_balance), new Object[]{this.w});
                this.f58769i.setText(this.o);
                this.v.setText(this.w);
                net.one97.paytm.passbook.subWallet.b.d dVar4 = new net.one97.paytm.passbook.subWallet.b.d();
                bundle.putString(PayUtility.WALLET_TYPE, this.w);
                bundle.putSerializable("subwallet-list", this.S);
                dVar4.setArguments(bundle);
                supportFragmentManager.a().b(R.id.sub_wallet_container, dVar4, (String) null).c();
            } else if (this.U == n.GIFT_VOUCHER.getValue()) {
                this.ae.setImageResource(R.drawable.pass_payments_bank_logo);
                this.B.setVisibility(0);
                String string = getString(R.string.pass_gift_voucher);
                this.o = String.format(getString(R.string.sub_wallet_balance), new Object[]{string});
                this.f58769i.setText(this.o);
                this.v.setText(string);
                ((TextView) findViewById(R.id.gift_voucher_header_buy_title)).setText(getString(R.string.buy) + " " + string);
                ((TextView) findViewById(R.id.gift_voucher_header_redeem_title)).setText(getString(R.string.redeem_gv) + " " + string);
                net.one97.paytm.passbook.subWallet.b.d dVar5 = new net.one97.paytm.passbook.subWallet.b.d();
                bundle.putString(PayUtility.WALLET_TYPE, this.w);
                bundle.putSerializable("subwallet-list", this.S);
                dVar5.setArguments(bundle);
                supportFragmentManager.a().b(R.id.sub_wallet_container, dVar5, (String) null).c();
                net.one97.paytm.passbook.d.b().b("/passbook/gift-voucher", "passbook", this);
            } else {
                this.A.setVisibility(0);
                this.o = String.format(getString(R.string.sub_wallet_balance), new Object[]{this.w});
                this.f58769i.setText(this.o);
                this.v.setText(this.w);
                net.one97.paytm.passbook.subWallet.b.d dVar6 = new net.one97.paytm.passbook.subWallet.b.d();
                bundle.putString(PayUtility.WALLET_TYPE, this.w);
                bundle.putSerializable("subwallet-list", this.S);
                dVar6.setArguments(bundle);
                supportFragmentManager.a().b(R.id.sub_wallet_container, dVar6, (String) null).c();
                net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                b2.b("/passbook/" + this.w.replace(" ", "-").toLowerCase(), "passbook", this);
            }
            u();
        }
    }

    private void t() {
        if (((MultiSubWallet) this.S).getSubWalletList().get(0) == null || !(((MultiSubWallet) this.S).getSubWalletList().get(0) instanceof MultiSubWallet)) {
            this.az.setVisibility(0);
            this.aA.setVisibility(8);
            CJRSubWallet cJRSubWallet = this.S;
            if (cJRSubWallet == null || !(cJRSubWallet instanceof MultiSubWallet)) {
                this.s.setVisibility(8);
                return;
            }
            ArrayList<CJRSubWallet> subWalletList = ((MultiSubWallet) cJRSubWallet).getSubWalletList();
            if (subWalletList != null && subWalletList.size() > 0 && !v.a(subWalletList.get(0).getIssuerMetadata())) {
                this.s.setText(((MultiSubWallet) this.S).getSubWalletList().get(0).getIssuerMetadata());
                this.s.setVisibility(0);
            }
            if (subWalletList != null && subWalletList.size() > 0 && !v.a(subWalletList.get(0).getExpiry())) {
                this.t.setVisibility(0);
                this.t.setText(String.format(getResources().getString(R.string.food_wallet_expires), new Object[]{net.one97.paytm.passbook.mapping.a.Z(((MultiSubWallet) this.S).getSubWalletList().get(0).getExpiry())}));
                return;
            }
            return;
        }
        this.az.setVisibility(8);
        this.aA.setVisibility(0);
        ArrayList<CJRSubWallet> subWalletList2 = ((MultiSubWallet) ((MultiSubWallet) this.S).getSubWalletList().get(0)).getSubWalletList();
        a(subWalletList2);
        this.aB.setAdapter(new net.one97.paytm.passbook.subWallet.a.a(this, subWalletList2));
        this.aC.setViewPager(this.aB);
        this.aB.setCurrentItem(b(subWalletList2), true);
        this.p = new DecimalFormat(q.a(((MultiSubWallet) this.S).getBalance()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(((MultiSubWallet) this.S).getBalance());
        c.b(this.p, this.q);
        c.b(getString(R.string.rs) + " " + this.p, this.j);
    }

    private void u() {
        if (getIntent().getBooleanExtra("isOpenFromNewPassbook", false)) {
            t();
            return;
        }
        CJRSubWallet cJRSubWallet = this.S;
        if (!(cJRSubWallet instanceof MultiSubWallet) || ((MultiSubWallet) cJRSubWallet).getSubWalletList() == null || ((MultiSubWallet) this.S).getSubWalletList().size() <= 1) {
            this.az.setVisibility(0);
            this.aA.setVisibility(8);
            CJRSubWallet cJRSubWallet2 = this.S;
            if (cJRSubWallet2 == null || !(cJRSubWallet2 instanceof MultiSubWallet)) {
                this.s.setVisibility(8);
                return;
            }
            ArrayList<CJRSubWallet> subWalletList = ((MultiSubWallet) cJRSubWallet2).getSubWalletList();
            if (subWalletList != null && subWalletList.size() > 0 && !v.a(subWalletList.get(0).getIssuerMetadata())) {
                this.s.setText(((MultiSubWallet) this.S).getSubWalletList().get(0).getIssuerMetadata());
                this.s.setVisibility(0);
            }
            if (subWalletList != null && subWalletList.size() > 0 && !v.a(subWalletList.get(0).getExpiry())) {
                this.t.setVisibility(0);
                this.t.setText(String.format(getResources().getString(R.string.food_wallet_expires), new Object[]{net.one97.paytm.passbook.mapping.a.Z(((MultiSubWallet) this.S).getSubWalletList().get(0).getExpiry())}));
                return;
            }
            return;
        }
        this.az.setVisibility(8);
        this.aA.setVisibility(0);
        ArrayList<CJRSubWallet> subWalletList2 = ((MultiSubWallet) this.S).getSubWalletList();
        a(subWalletList2);
        this.aB.setAdapter(new net.one97.paytm.passbook.subWallet.a.a(this, subWalletList2));
        this.aC.setViewPager(this.aB);
        this.aB.setCurrentItem(b(subWalletList2), true);
        this.p = new DecimalFormat(q.a(((MultiSubWallet) this.S).getBalance()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(((MultiSubWallet) this.S).getBalance());
        c.b(this.p, this.q);
        c.b(getString(R.string.rs) + " " + this.p, this.j);
    }

    private static void a(ArrayList<CJRSubWallet> arrayList) {
        Collections.sort(arrayList, $$Lambda$PassbookSubwalletActivity$tUS4BTVXlOdZhQWJqpuNYX9KYg.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(CJRSubWallet cJRSubWallet, CJRSubWallet cJRSubWallet2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy", Locale.US);
        try {
            return (int) (simpleDateFormat.parse(cJRSubWallet2.getExpiry()).getTime() - simpleDateFormat.parse(cJRSubWallet.getExpiry()).getTime());
        } catch (Exception unused) {
            return 0;
        }
    }

    private int b(ArrayList<CJRSubWallet> arrayList) {
        int intExtra = getIntent().getIntExtra("clicked_wallet_id", -1);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).getId() == intExtra) {
                return i2;
            }
        }
        return 0;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0041 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r20) {
        /*
            r19 = this;
            r8 = r19
            r0 = r20
            int r1 = r20.getId()
            int r2 = net.one97.paytm.passbook.R.id.back_arrow
            if (r1 != r2) goto L_0x0010
            r19.onBackPressed()
            return
        L_0x0010:
            android.widget.RelativeLayout r1 = r8.H
            java.lang.String r9 = "screenName"
            r10 = 131(0x83, float:1.84E-43)
            java.lang.String r11 = "CallingFragment"
            java.lang.String r12 = "header_title"
            r2 = 100
            if (r0 != r1) goto L_0x006a
            int r0 = r8.aG
            if (r0 == r2) goto L_0x0037
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "wallet_passbook"
            java.lang.String r3 = "paytm_wallet_list_item_clicked"
            java.lang.String r4 = "request_statement"
            java.lang.String r5 = ""
            java.lang.String r6 = "/passbook/wallet"
            java.lang.String r7 = "banksavingsaccount"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x0037:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0041 }
            r0.<init>()     // Catch:{ Exception -> 0x0041 }
            java.lang.String r1 = "/net/one97/paytm/passbook"
            r0.put(r9, r1)     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x004d }
            r0.<init>()     // Catch:{ Exception -> 0x004d }
            java.lang.String r1 = "new_wallet_screen_type"
            java.lang.String r2 = "net/one97/paytm/passbook"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.statementDownload.StatementDownloadActivity> r1 = net.one97.paytm.passbook.statementDownload.StatementDownloadActivity.class
            r0.<init>(r8, r1)
            android.widget.TextView r1 = r8.av
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.putExtra(r12, r1)
            java.lang.String r1 = "PassbookWalletFragment"
            r0.putExtra(r11, r1)
            r8.startActivityForResult(r0, r10)
            return
        L_0x006a:
            android.widget.RelativeLayout r1 = r8.ak
            java.lang.String r13 = "/passbook/ppb"
            java.lang.String r14 = "passbook_ppb"
            r15 = 0
            if (r0 != r1) goto L_0x009c
            int r0 = r8.aG
            if (r0 == r2) goto L_0x008c
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "wallet_passbook"
            java.lang.String r3 = "savings_account_list_item_clicked"
            java.lang.String r4 = "account_statement"
            java.lang.String r5 = ""
            java.lang.String r6 = "/passbook/savings-account"
            java.lang.String r7 = "banksavingsaccount"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x008c:
            java.lang.String r0 = "account_statement_ppb_passbook_clicked"
            net.one97.paytm.passbook.utility.q.a(r8, r14, r0, r15, r13)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.statementDownload.StatementDownloadActivityForPPB> r1 = net.one97.paytm.passbook.statementDownload.StatementDownloadActivityForPPB.class
            r0.<init>(r8, r1)
            r8.startActivity(r0)
            return
        L_0x009c:
            android.widget.RelativeLayout r1 = r8.I
            if (r0 != r1) goto L_0x00bd
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.statementDownload.StatementDownloadActivity> r1 = net.one97.paytm.passbook.statementDownload.StatementDownloadActivity.class
            r0.<init>(r8, r1)
            android.widget.TextView r1 = r8.ax
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r0.putExtra(r12, r1)
            java.lang.String r1 = "TransactionTollPassageHistoryFragment"
            r0.putExtra(r11, r1)
            r8.startActivityForResult(r0, r10)
            return
        L_0x00bd:
            android.widget.RelativeLayout r1 = r8.P
            if (r0 != r1) goto L_0x00e0
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            r4 = 0
            java.lang.String r2 = "passbook"
            java.lang.String r3 = "redeem_gift_voucher"
            java.lang.String r5 = "/passbook/gift-voucher"
            java.lang.String r6 = "passbook"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.giftVoucher.GiftVoucherRedeemActivity> r1 = net.one97.paytm.passbook.giftVoucher.GiftVoucherRedeemActivity.class
            r0.<init>(r8, r1)
            r1 = 345(0x159, float:4.83E-43)
            r8.startActivityForResult(r0, r1)
            return
        L_0x00e0:
            android.widget.RelativeLayout r1 = r8.J
            if (r0 != r1) goto L_0x0115
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            r4 = 0
            java.lang.String r2 = "passbook"
            java.lang.String r3 = "buy_gift_voucher"
            java.lang.String r5 = "/passbook/gift-voucher"
            java.lang.String r6 = "passbook"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6)
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            java.lang.Class r1 = r1.y()
            r0.<init>(r8, r1)
            java.lang.String r1 = "add_money_tab"
            java.lang.String r2 = "giftVoucher"
            r0.putExtra(r1, r2)
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r0.addFlags(r1)
            r1 = 129(0x81, float:1.81E-43)
            r8.startActivityForResult(r0, r1)
            return
        L_0x0115:
            android.widget.RelativeLayout r1 = r8.K
            r10 = 0
            java.lang.String r11 = "/passbook/wallet/"
            java.lang.String r12 = "passbook_wallet"
            if (r0 != r1) goto L_0x0181
            int r0 = r8.aG
            if (r0 == r2) goto L_0x0137
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "wallet_passbook"
            java.lang.String r3 = "paytm_wallet_list_item_clicked"
            java.lang.String r4 = "send_money_to_bank"
            java.lang.String r5 = ""
            java.lang.String r6 = "/passbook/wallet"
            java.lang.String r7 = "banksavingsaccount"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x0137:
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r19)
            if (r0 == 0) goto L_0x017d
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r0 = r0.l()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0156
            java.lang.String r1 = "\\s*,\\s*"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            goto L_0x0157
        L_0x0156:
            r0 = r15
        L_0x0157:
            if (r0 == 0) goto L_0x0172
            java.lang.String r1 = r8.aD
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0172
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            java.lang.Class r1 = r1.d()
            r0.<init>(r8, r1)
            r8.startActivityForResult(r0, r10)
            return
        L_0x0172:
            net.one97.paytm.passbook.subWallet.c.d r0 = r8.f58765e
            r0.b()
            java.lang.String r0 = "passbook_wallet_send_money_clicked"
            net.one97.paytm.passbook.utility.q.a(r8, r12, r0, r15, r11)
            return
        L_0x017d:
            net.one97.paytm.passbook.mapping.c.g(r19)
            return
        L_0x0181:
            android.widget.RelativeLayout r1 = r8.L
            if (r0 != r1) goto L_0x01b0
            int r0 = r8.aG
            if (r0 == r2) goto L_0x019e
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "wallet_passbook"
            java.lang.String r3 = "paytm_wallet_list_item_clicked"
            java.lang.String r4 = "add_money_to_wallet"
            java.lang.String r5 = ""
            java.lang.String r6 = "/passbook/wallet"
            java.lang.String r7 = "banksavingsaccount"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x019e:
            net.one97.paytm.passbook.mapping.g.a()
            java.lang.String r0 = "wallet"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            net.one97.paytm.passbook.mapping.g.a(r8, r0)
            java.lang.String r0 = "passbook_wallet_add_money_clicked"
            net.one97.paytm.passbook.utility.q.a(r8, r12, r0, r15, r11)
            return
        L_0x01b0:
            android.widget.RelativeLayout r1 = r8.M
            if (r0 != r1) goto L_0x01f4
            int r0 = r8.aG
            if (r0 == r2) goto L_0x01cd
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "wallet_passbook"
            java.lang.String r3 = "savings_account_list_item_clicked"
            java.lang.String r4 = "bank_transfer"
            java.lang.String r5 = ""
            java.lang.String r6 = "/passbook/savings-account"
            java.lang.String r7 = "banksavingsaccount"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x01cd:
            java.lang.String r0 = "money_transfer_ppb_passbook_clicked"
            net.one97.paytm.passbook.utility.q.a(r8, r14, r0, r15, r13)
            boolean r0 = com.paytm.utility.b.r((android.content.Context) r19)
            if (r0 == 0) goto L_0x03db
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            java.lang.Class r1 = r1.n()
            r0.<init>(r8, r1)
            net.one97.paytm.passbook.d.b()
            r1 = 1
            java.lang.String r2 = "send money to bank from passbbok"
            r0.putExtra(r2, r1)
            r1 = 126(0x7e, float:1.77E-43)
            r8.startActivityForResult(r0, r1)
            return
        L_0x01f4:
            android.widget.RelativeLayout r1 = r8.N
            if (r0 != r1) goto L_0x0254
            int r0 = r8.aG
            if (r0 == r2) goto L_0x0211
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "wallet_passbook"
            java.lang.String r3 = "savings_account_list_item_clicked"
            java.lang.String r4 = "add_money_to_savings_account"
            java.lang.String r5 = ""
            java.lang.String r6 = "/passbook/savings-account"
            java.lang.String r7 = "banksavingsaccount"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x0211:
            java.lang.String r0 = "add_money_ppb_passbook_clicked"
            net.one97.paytm.passbook.utility.q.a(r8, r14, r0, r15, r13)
            boolean r0 = com.paytm.utility.k.b()
            if (r0 == 0) goto L_0x0236
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            android.content.Intent r0 = r0.e(r8)
            java.lang.String r1 = r8.f58762b
            java.lang.String r2 = "ACCOUNT_NUMBER"
            r0.putExtra(r2, r1)
            java.lang.String r1 = r8.p
            java.lang.String r2 = "extra_saving_balance"
            r0.putExtra(r2, r1)
            r8.startActivity(r0)
            return
        L_0x0236:
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            java.lang.Class r1 = r1.o()
            r0.<init>(r8, r1)
            net.one97.paytm.passbook.beans.PaymentDestinationType r1 = net.one97.paytm.passbook.beans.PaymentDestinationType.TO_PAYTM_BANK
            int r1 = r1.getNumVal()
            java.lang.String r2 = "destinationAddMoney"
            r0.putExtra(r2, r1)
            r1 = 203(0xcb, float:2.84E-43)
            r8.startActivityForResult(r0, r1)
            return
        L_0x0254:
            android.widget.RelativeLayout r1 = r8.O
            if (r0 != r1) goto L_0x02af
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "event_category"
            java.lang.String r2 = "wallet_passbook_toll"
            r0.put(r1, r2)
            java.lang.String r1 = "event_action"
            java.lang.String r2 = "manage_toll_tags_clicked"
            r0.put(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r19)
            boolean r1 = r1.add(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r2 = "user_id"
            r0.put(r2, r1)
            java.lang.String r1 = "passbook screen"
            r0.put(r9, r1)
            java.lang.String r1 = "vertical_name"
            java.lang.String r2 = "fastag"
            r0.put(r1, r2)
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            r19.getApplicationContext()
            r1.a((java.util.Map<java.lang.String, java.lang.Object>) r0)
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r1 = "passManageFastagDeeplink"
            java.lang.String r0 = r0.a((java.lang.String) r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x02ae
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            r1.a((java.lang.String) r0, (android.app.Activity) r8)
        L_0x02ae:
            return
        L_0x02af:
            android.view.View r1 = r8.am
            if (r0 != r1) goto L_0x036d
            int r0 = r8.U
            r1 = -1
            if (r0 == r1) goto L_0x034b
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.TOLL
            int r1 = r1.getValue()
            java.lang.String r2 = "filter_clicked"
            java.lang.String r3 = "passbook"
            if (r0 != r1) goto L_0x02d0
            java.lang.String r0 = "passbook_fastag_wallet"
            java.lang.String r1 = "_fastag_wallet_passbook_filter_clicked"
            java.lang.String r2 = "/passbook/fastag-wallet"
            r3 = r1
            r6 = r2
            r4 = r15
            r2 = r0
            goto L_0x033e
        L_0x02d0:
            int r0 = r8.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.FOOD_WALLET
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x02e7
            java.lang.String r0 = "/passbook/food-wallet"
            java.lang.String r1 = "food wallet"
        L_0x02de:
            r6 = r0
            r4 = r1
            r18 = r3
            r3 = r2
            r2 = r18
            goto L_0x033e
        L_0x02e7:
            int r0 = r8.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.GIFT_CARDS
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x02f9
            java.lang.String r0 = "/passbook/gift-wallet"
            java.lang.String r1 = "gift wallet"
            r6 = r0
            r4 = r1
            r2 = r3
            goto L_0x033e
        L_0x02f9:
            int r0 = r8.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.SAVINGS_ACCOUNT
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x030a
            java.lang.String r0 = "ppb_passbook_filter_clicked"
            r3 = r0
            r6 = r13
            r2 = r14
        L_0x0308:
            r4 = r15
            goto L_0x033e
        L_0x030a:
            int r0 = r8.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x031c
            java.lang.String r0 = "wallet_passbook_filter_clicked"
            java.lang.String r1 = "/passbook/wallet"
            r3 = r0
            r6 = r1
            r2 = r12
            goto L_0x0308
        L_0x031c:
            int r0 = r8.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x032b
            java.lang.String r0 = "/passbook/gift-voucher"
            java.lang.String r1 = "gift voucher"
            goto L_0x02de
        L_0x032b:
            int r0 = r8.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.ALLOWALANCE_WALLET
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x033a
            java.lang.String r0 = "/passbook/allowance-wallet"
            java.lang.String r1 = "allowance wallet"
            goto L_0x02de
        L_0x033a:
            r2 = r15
            r3 = r2
            r4 = r3
            r6 = r4
        L_0x033e:
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r5 = ""
            java.lang.String r7 = "passbook"
            r1 = r19
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x034b:
            net.one97.paytm.passbook.utility.i r0 = new net.one97.paytm.passbook.utility.i
            int r1 = net.one97.paytm.passbook.R.string.wallet_filter_tran
            java.lang.String r1 = r8.getString(r1)
            java.util.ArrayList<java.lang.String> r2 = r8.ap
            int r3 = r8.ar
            r0.<init>(r1, r2, r3)
            androidx.fragment.app.j r1 = r19.getSupportFragmentManager()
            java.lang.String r2 = r0.getTag()
            r0.show((androidx.fragment.app.j) r1, (java.lang.String) r2)
            net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$6 r1 = new net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$6
            r1.<init>()
            r0.f59241a = r1
            return
        L_0x036d:
            android.widget.RelativeLayout r1 = r8.Q
            if (r0 != r1) goto L_0x037c
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity> r1 = net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity.class
            r0.<init>(r8, r1)
            r8.startActivity(r0)
            return
        L_0x037c:
            android.widget.TextView r1 = r8.r
            if (r0 != r1) goto L_0x03db
            net.one97.paytm.passbook.beans.CJRSubWallet r0 = r8.S     // Catch:{ Exception -> 0x03d2 }
            r1 = 0
            if (r0 != 0) goto L_0x03a0
            java.lang.String r0 = r8.x     // Catch:{ Exception -> 0x039b }
            double r3 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x039b }
            android.content.Intent r0 = r19.getIntent()     // Catch:{ Exception -> 0x039c }
            java.lang.String r5 = "ppb_total_balance"
            java.lang.String r0 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x039c }
            double r1 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x039c }
            goto L_0x039c
        L_0x039b:
            r3 = r1
        L_0x039c:
            r16 = r1
            r12 = r3
            goto L_0x03b5
        L_0x03a0:
            net.one97.paytm.passbook.beans.CJRSubWallet r0 = r8.S     // Catch:{ Exception -> 0x03d2 }
            net.one97.paytm.passbook.beans.AccountBalanceModel r0 = (net.one97.paytm.passbook.beans.AccountBalanceModel) r0     // Catch:{ Exception -> 0x03d2 }
            double r3 = r0.getEffectiveBalance()     // Catch:{ Exception -> 0x03d2 }
            net.one97.paytm.passbook.beans.CJRSubWallet r0 = r8.S     // Catch:{ Exception -> 0x03d2 }
            net.one97.paytm.passbook.beans.AccountBalanceModel r0 = (net.one97.paytm.passbook.beans.AccountBalanceModel) r0     // Catch:{ Exception -> 0x03d2 }
            java.lang.String r0 = r0.getmTotalBalance()     // Catch:{ Exception -> 0x03d2 }
            double r1 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x03d2 }
            goto L_0x039c
        L_0x03b5:
            net.one97.paytm.passbook.beans.BalanceBreakupModel r0 = new net.one97.paytm.passbook.beans.BalanceBreakupModel     // Catch:{ Exception -> 0x03d2 }
            double r14 = r16 - r12
            r11 = r0
            r11.<init>(r12, r14, r16)     // Catch:{ Exception -> 0x03d2 }
            net.one97.paytm.passbook.main.a.a r1 = new net.one97.paytm.passbook.main.a.a     // Catch:{ Exception -> 0x03d2 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x03d2 }
            androidx.fragment.app.j r0 = r19.getSupportFragmentManager()     // Catch:{ Exception -> 0x03d2 }
            java.lang.Class r2 = r19.getClass()     // Catch:{ Exception -> 0x03d2 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x03d2 }
            r1.show((androidx.fragment.app.j) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x03d2 }
            return
        L_0x03d2:
            java.lang.String r0 = "Please wait"
            android.widget.Toast r0 = android.widget.Toast.makeText(r8, r0, r10)
            r0.show()
        L_0x03db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity.onClick(android.view.View):void");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 104) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("intent_extra_wallet_order_id");
                boolean booleanExtra = intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
                String stringExtra2 = intent.getStringExtra("pg_screen");
                if ((!booleanExtra || !"2".equalsIgnoreCase(stringExtra2)) && !booleanExtra) {
                    startActivityForResult(new Intent(this, net.one97.paytm.passbook.d.b().i()).putExtra("order_id", stringExtra).putExtra(UpiConstants.FROM, "Order_history"), 125);
                }
            }
        } else if (i2 == 125) {
            if (this.U == n.PAYTM_POSTPAID.getValue()) {
                if (this.au == null) {
                    this.f58765e.e();
                } else {
                    x();
                }
                Fragment c2 = getSupportFragmentManager().c(R.id.sub_wallet_container);
                if (c2 != null) {
                    c2.onActivityResult(i2, i3, intent);
                }
            }
        } else if (i2 == 126) {
            if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
                a(i2, i3, intent);
            }
        } else if (i2 == 127 || i2 == 128) {
            this.f58765e.c();
            Fragment c3 = getSupportFragmentManager().c(R.id.sub_wallet_container);
            if (c3 != null) {
                c3.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 129) {
            this.f58765e.c();
            Fragment c4 = getSupportFragmentManager().c(R.id.sub_wallet_container);
            if (c4 != null) {
                c4.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 130) {
            this.f58765e.c();
            Fragment c5 = getSupportFragmentManager().c(R.id.sub_wallet_container);
            if (c5 != null) {
                c5.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 203) {
            if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
                a(i2, i3, intent);
            }
        } else if (i2 == 345) {
            this.f58765e.c();
            this.f58765e.g();
            Fragment c6 = getSupportFragmentManager().c(R.id.sub_wallet_container);
            if (c6 != null) {
                c6.onActivityResult(i2, i3, intent);
            }
        } else if (i2 == 131 && intent != null && intent.getBooleanExtra("finish_activity", false)) {
            finish();
        }
        if (i2 == 0) {
            com.paytm.utility.b.c((Context) this);
        }
        if (i2 == 102) {
            if (i3 != -1) {
                finish();
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("ENTER_HEADER", "paytm_saving_account_confirm");
                net.one97.paytm.passbook.d.b().a((Activity) this, intent2);
                startActivityForResult(intent2, 101);
            }
        }
        if (i2 == 101 && com.paytm.utility.b.c((Context) this)) {
            if (i3 != -1) {
                finish();
                return;
            }
            this.f58765e.a();
            if (!this.aE) {
                this.f58765e.d();
            }
            this.aI = true;
        }
    }

    private void a(int i2, int i3, Intent intent) {
        if (this.aI) {
            if (TextUtils.isEmpty(this.f58762b)) {
                this.f58765e.f();
            } else {
                this.f58765e.d();
            }
        }
        Fragment c2 = getSupportFragmentManager().c(R.id.sub_wallet_container);
        if (c2 != null) {
            c2.onActivityResult(i2, i3, intent);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f58767g = menu;
        getMenuInflater().inflate(R.menu.pass_passbookmenu, menu);
        this.k = menu.findItem(R.id.action_passbook_search);
        this.l = menu.findItem(R.id.action_savingacc_help);
        this.m = menu.findItem(R.id.action_how_it_works_bs_info);
        if (this.U != n.PAYTM_POSTPAID.getValue()) {
            if (this.U == n.LOYALTY_WALLET.getValue()) {
                this.l.setVisible(false);
            } else if (this.U == n.GIFT_VOUCHER.getValue()) {
                this.l.setVisible(false);
            } else if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
                this.l.setVisible(false);
            }
        }
        this.n = (SearchView) this.k.getActionView();
        this.n.setQueryHint(getResources().getString(R.string.search));
        this.k.setVisible(false);
        if (this.U == n.PAYTM_WALLET.getValue()) {
            this.k.setVisible(true);
        }
        this.m.setVisible(false);
        if (this.S != null) {
            c.a aVar = net.one97.paytm.passbook.customview.c.f57211a;
            if (c.a.a(this.S)) {
                this.m.setVisible(true);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onOptionsItemSelected(android.view.MenuItem r14) {
        /*
            r13 = this;
            int r0 = r14.getItemId()
            r1 = 16908332(0x102002c, float:2.3877352E-38)
            if (r0 != r1) goto L_0x000e
            r13.onBackPressed()
            goto L_0x0320
        L_0x000e:
            int r0 = r14.getItemId()
            int r1 = net.one97.paytm.passbook.R.id.action_passbook_search
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x00b6
            androidx.appcompat.widget.SearchView r14 = r13.n
            if (r14 == 0) goto L_0x001f
            r14.setIconified(r3)
        L_0x001f:
            android.view.MenuItem r14 = r13.k
            r14.setActionView(r2)
            int r14 = r13.aG
            r0 = 100
            if (r14 == r0) goto L_0x008e
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x0036 }
            r14.<init>()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = "screenName"
            java.lang.String r1 = "/net/one97/paytm/passbook"
            r14.put(r0, r1)     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x0043 }
            r14.<init>()     // Catch:{ Exception -> 0x0043 }
            java.lang.String r0 = "new_wallet_screen_type"
            java.lang.String r1 = "net/one97/paytm/passbook"
            r14.put(r0, r1)     // Catch:{ Exception -> 0x0043 }
            goto L_0x0044
        L_0x0043:
        L_0x0044:
            int r14 = r13.U
            net.one97.paytm.passbook.utility.n r0 = net.one97.paytm.passbook.utility.n.TOLL
            int r0 = r0.getValue()
            if (r14 != r0) goto L_0x0055
            java.lang.String r14 = "passbook_fastag_wallet"
            java.lang.String r0 = "fastag_wallet_passbook_search_clicked"
            java.lang.String r1 = "/passbook/fastag-wallet"
            goto L_0x008b
        L_0x0055:
            int r14 = r13.U
            net.one97.paytm.passbook.utility.n r0 = net.one97.paytm.passbook.utility.n.FOOD_WALLET
            int r0 = r0.getValue()
            if (r14 != r0) goto L_0x0066
            java.lang.String r14 = "passbook_food_wallet"
            java.lang.String r0 = "food_wallet_passbook_search_clicked"
            java.lang.String r1 = "/passbook/food-wallet"
            goto L_0x008b
        L_0x0066:
            int r14 = r13.U
            net.one97.paytm.passbook.utility.n r0 = net.one97.paytm.passbook.utility.n.GIFT_CARDS
            int r0 = r0.getValue()
            if (r14 != r0) goto L_0x0077
            java.lang.String r14 = "passbook_gift_wallet"
            java.lang.String r0 = "gift_wallet_passbook_search_clicked"
            java.lang.String r1 = "/passbook/gift-wallet"
            goto L_0x008b
        L_0x0077:
            int r14 = r13.U
            net.one97.paytm.passbook.utility.n r0 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
            int r0 = r0.getValue()
            if (r14 != r0) goto L_0x0088
            java.lang.String r14 = "passbook_wallet"
            java.lang.String r0 = "wallet_passbook_search_clicked"
            java.lang.String r1 = "/passbook/wallet"
            goto L_0x008b
        L_0x0088:
            r14 = r2
            r0 = r14
            r1 = r0
        L_0x008b:
            net.one97.paytm.passbook.utility.q.a(r13, r14, r0, r2, r1)
        L_0x008e:
            android.content.Intent r14 = new android.content.Intent
            java.lang.Class<net.one97.paytm.passbook.search.PassbookSearchActivity> r0 = net.one97.paytm.passbook.search.PassbookSearchActivity.class
            r14.<init>(r13, r0)
            android.content.res.Resources r0 = r13.getResources()
            int r1 = net.one97.paytm.passbook.R.string.search
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "title"
            r14.putExtra(r1, r0)
            java.lang.String r0 = "issearch"
            r14.putExtra(r0, r3)
            int r0 = r13.U
            java.lang.String r1 = "sub_wallet_type"
            r14.putExtra(r1, r0)
            r0 = 10
            r13.startActivityForResult(r14, r0)
            return r3
        L_0x00b6:
            int r0 = r14.getItemId()
            int r1 = net.one97.paytm.passbook.R.id.action_savingacc_help
            if (r0 != r1) goto L_0x030d
            int r0 = r13.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
            int r1 = r1.getValue()
            if (r0 == r1) goto L_0x00ec
            int r0 = r13.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x00d3
            goto L_0x00ec
        L_0x00d3:
            int r0 = r13.U
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.SAVINGS_ACCOUNT
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x0320
            java.lang.String r0 = v()
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = ""
            r1.a((android.content.Context) r13, (java.lang.String) r0, (java.lang.String) r2)
            goto L_0x0320
        L_0x00ec:
            int r0 = r13.U
            java.lang.String r1 = r13.w
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r13)
            int r5 = net.one97.paytm.passbook.R.layout.pass_dialog_sub_wallet_know_more
            android.view.View r2 = r4.inflate(r5, r2)
            int r4 = net.one97.paytm.passbook.R.id.iv_know_more
            android.view.View r4 = r2.findViewById(r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            int r5 = net.one97.paytm.passbook.R.id.tv_know_more_title
            android.view.View r5 = r2.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = net.one97.paytm.passbook.R.id.tv_know_more_text
            android.view.View r6 = r2.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = net.one97.paytm.passbook.R.id.tv_know_more_info
            android.view.View r7 = r2.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = net.one97.paytm.passbook.R.id.tv_learn_more
            android.view.View r8 = r2.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r9 = 8
            r8.setVisibility(r9)
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.FIXED_DEPOSIT
            int r9 = r9.getValue()
            r10 = 3
            r11 = 0
            if (r0 != r9) goto L_0x015f
            int r1 = net.one97.paytm.passbook.R.drawable.pass_ic_fixed_deposit_graphic
            r4.setImageResource(r1)
            int r1 = net.one97.paytm.passbook.R.string.fixed_deposit_title_know_more
            java.lang.String r1 = r13.getString(r1)
            r5.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.fixed_deposit_text_know_more
            java.lang.String r1 = r13.getString(r1)
            r6.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.fixed_deposit_info_know_more
            java.lang.String r1 = r13.getString(r1)
            r7.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.fixed_deposit_learn_more
            java.lang.String r1 = r13.getString(r1)
            r8.setText(r1)
            r8.setVisibility(r11)
            goto L_0x02ce
        L_0x015f:
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.FOOD_WALLET
            int r9 = r9.getValue()
            if (r0 != r9) goto L_0x0195
            int r1 = net.one97.paytm.passbook.R.drawable.pass_ic_food_wallet_graphic
            r4.setImageResource(r1)
            int r1 = net.one97.paytm.passbook.R.string.food_wallet_title_know_more
            java.lang.String r1 = r13.getString(r1)
            r5.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.food_wallet_text_know_more
            java.lang.String r1 = r13.getString(r1)
            r6.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.food_wallet_info_know_more
            java.lang.String r1 = r13.getString(r1)
            r7.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.food_wallet_learn_more
            java.lang.String r1 = r13.getString(r1)
            r8.setText(r1)
            r8.setVisibility(r11)
            goto L_0x02ce
        L_0x0195:
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.GIFT_CARDS
            int r9 = r9.getValue()
            if (r0 != r9) goto L_0x01c8
            int r1 = net.one97.paytm.passbook.R.drawable.pass_ic_gift_wallet_graphic
            r4.setImageResource(r1)
            int r1 = net.one97.paytm.passbook.R.string.gift_wallet_title_know_more
            java.lang.String r1 = r13.getString(r1)
            r5.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.gift_wallet_text_know_more
            java.lang.String r1 = r13.getString(r1)
            r6.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.gift_wallet_info_know_more
            java.lang.String r1 = r13.getString(r1)
            r7.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.gift_wallet_learn_more
            java.lang.String r1 = r13.getString(r1)
            r8.setText(r1)
            goto L_0x02ce
        L_0x01c8:
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER
            int r9 = r9.getValue()
            r12 = 90
            if (r0 != r9) goto L_0x021c
            int r9 = net.one97.paytm.passbook.R.drawable.pass_ic_gift_voucher
            r4.setImageResource(r9)
            android.view.ViewGroup$LayoutParams r9 = r4.getLayoutParams()
            android.content.Context r4 = r4.getContext()
            int r4 = com.paytm.utility.b.a((int) r12, (android.content.Context) r4)
            r9.height = r4
            java.lang.String r4 = net.one97.paytm.passbook.mapping.a.v()
            r5.setText(r4)
            int r4 = net.one97.paytm.passbook.R.string.gift_voucher_issued
            java.lang.String r4 = r13.getString(r4)
            r6.setText(r4)
            int r4 = net.one97.paytm.passbook.R.string.gift_voucher_wallet_info_know_more
            java.lang.String r4 = r13.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r11] = r1
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r7.setText(r4)
            r8.setVisibility(r11)
            int r4 = net.one97.paytm.passbook.R.string.learn_more_paytm_gift_voucher
            java.lang.String r4 = r13.getString(r4)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r11] = r1
            java.lang.String r1 = java.lang.String.format(r4, r3)
            r8.setText(r1)
            goto L_0x02ce
        L_0x021c:
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
            int r9 = r9.getValue()
            if (r0 != r9) goto L_0x027d
            int r9 = net.one97.paytm.passbook.R.drawable.pass_ic_paytm_loyalty
            r4.setImageResource(r9)
            android.view.ViewGroup$LayoutParams r9 = r4.getLayoutParams()
            android.content.Context r4 = r4.getContext()
            int r4 = com.paytm.utility.b.a((int) r12, (android.content.Context) r4)
            r9.height = r4
            net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r4 = net.one97.paytm.passbook.mapping.e.e()
            r5.setText(r4)
            int r4 = net.one97.paytm.passbook.R.string.loyalty_wallet_text_know_more
            java.lang.String r4 = r13.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r11] = r1
            r5[r3] = r1
            r9 = 2
            r5[r9] = r1
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r6.setText(r4)
            int r4 = net.one97.paytm.passbook.R.string.loyalty_wallet_info_know_more
            java.lang.String r4 = r13.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r11] = r1
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r7.setText(r4)
            int r4 = net.one97.paytm.passbook.R.string.loyality_learn_more
            java.lang.String r4 = r13.getString(r4)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r11] = r1
            java.lang.String r1 = java.lang.String.format(r4, r3)
            r8.setText(r1)
            r8.setVisibility(r11)
            goto L_0x02ce
        L_0x027d:
            net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.TOLL
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x02ce
            int r1 = net.one97.paytm.passbook.R.drawable.pass_ic_toll_wallet_graphic
            r4.setImageResource(r1)
            int r1 = net.one97.paytm.passbook.R.string.toll_wallet_title_know_more
            java.lang.String r1 = r13.getString(r1)
            r5.setText(r1)
            int r1 = net.one97.paytm.passbook.R.string.toll_wallet_text_know_more
            java.lang.String r1 = r13.getString(r1)
            r6.setText(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r1 < r3) goto L_0x02b0
            int r1 = net.one97.paytm.passbook.R.string.toll_wallet_learn_more
            java.lang.String r1 = r13.getString(r1)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1, r11)
            r7.setText(r1)
            goto L_0x02bd
        L_0x02b0:
            int r1 = net.one97.paytm.passbook.R.string.toll_wallet_learn_more
            java.lang.String r1 = r13.getString(r1)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r7.setText(r1)
        L_0x02bd:
            java.lang.String r1 = "#00baf2"
            int r1 = android.graphics.Color.parseColor(r1)
            r7.setTextColor(r1)
            net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$9 r1 = new net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$9
            r1.<init>(r13)
            r7.setOnClickListener(r1)
        L_0x02ce:
            com.google.android.material.bottomsheet.a r1 = new com.google.android.material.bottomsheet.a
            r1.<init>(r13)
            r1.setContentView((android.view.View) r2)
            net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$10 r3 = new net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$10
            r3.<init>()
            r1.setOnShowListener(r3)
            android.view.ViewParent r3 = r2.getParent()
            android.view.View r3 = (android.view.View) r3
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.from(r3)
            net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$11 r4 = new net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$11
            r4.<init>(r3)
            r1.setOnDismissListener(r4)
            r3.setState(r10)
            r1.show()
            int r3 = net.one97.paytm.passbook.R.id.iv_close
            android.view.View r2 = r2.findViewById(r3)
            net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$2 r3 = new net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$2
            r3.<init>(r1)
            r2.setOnClickListener(r3)
            net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$3 r2 = new net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity$3
            r2.<init>(r1, r0, r13)
            r8.setOnClickListener(r2)
            goto L_0x0320
        L_0x030d:
            int r0 = r14.getItemId()
            int r1 = net.one97.paytm.passbook.R.id.action_how_it_works_bs_info
            if (r0 != r1) goto L_0x0320
            net.one97.paytm.passbook.customview.c$a r0 = net.one97.paytm.passbook.customview.c.f57211a
            net.one97.paytm.passbook.beans.CJRSubWallet r0 = r13.S
            androidx.fragment.app.j r1 = r13.getSupportFragmentManager()
            net.one97.paytm.passbook.customview.c.a.a(r0, r1)
        L_0x0320:
            boolean r14 = super.onOptionsItemSelected(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    private static String v() {
        try {
            return net.one97.paytm.passbook.d.b().p();
        } catch (Exception unused) {
            return "";
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f58763c = null;
        net.one97.paytm.passbook.d.b().r();
        System.gc();
    }

    public final void e(IJRDataModel iJRDataModel) {
        CJRHomePageItem cJRHomePageItem;
        if (!isFinishing()) {
            this.T = (CJRP2BStatus) iJRDataModel;
            if (!isFinishing()) {
                CJRP2BStatus cJRP2BStatus = this.T;
                if (cJRP2BStatus == null || cJRP2BStatus.getResponse() == null || !this.T.getResponse().isValidForTxn()) {
                    String q2 = net.one97.paytm.passbook.d.b().q();
                    if (TextUtils.isEmpty(q2)) {
                        q2 = "0120 3888 388";
                    }
                    Spanned fromHtml = Html.fromHtml(getString(R.string.help_text_send_to_bnk_err, new Object[]{q2.replace(" ", ""), q2}));
                    View inflate = getLayoutInflater().inflate(R.layout.pass_layout_passbook_preauth_overlay, (ViewGroup) null);
                    final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this);
                    aVar.setContentView(inflate);
                    final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
                    aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            from.setState(4);
                        }
                    });
                    from.setState(3);
                    aVar.show();
                    TextView textView = (TextView) inflate.findViewById(R.id.added_msg);
                    textView.setText(fromHtml);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    inflate.findViewById(R.id.passbooksendtobank_okgotit_tv).setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            aVar.dismiss();
                        }
                    });
                } else if (com.paytm.utility.b.c((Context) this)) {
                    try {
                        if (!(getIntent().getSerializableExtra("extra_home_data") == null || (cJRHomePageItem = (CJRHomePageItem) q.a((Object) getIntent().getSerializableExtra("extra_home_data"), CJRHomePageItem.class)) == null)) {
                            if ("wallet_to_ppb".equals(cJRHomePageItem.getPushFeatureType())) {
                                w();
                                return;
                            } else if ("cash_ledger".equals(cJRHomePageItem.getPushFeatureType())) {
                                return;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    w();
                } else {
                    Toast.makeText(this, getResources().getString(R.string.err_nonetwork_msg), 1).show();
                }
            }
        }
    }

    private void w() {
        Intent a2 = net.one97.paytm.passbook.d.b().a((Activity) this, this.T);
        if (!isFinishing()) {
            startActivityForResult(a2, 127);
        }
    }

    private static String c(String str) {
        String str2 = "";
        for (d.a aVar : d.a.values()) {
            if (str != null && str.equalsIgnoreCase(aVar.getWalletUserState())) {
                str2 = aVar.getv2UserState();
            }
        }
        return str2;
    }

    private void x() {
        if (this.au.getAccounts() != null && this.au.getAccounts().length > 0) {
            for (CJRPPAccount cJRPPAccount : this.au.getAccounts()) {
                String applicationStatus = cJRPPAccount.getApplicationStatus();
                if (!TextUtils.isEmpty(applicationStatus) && applicationStatus.equalsIgnoreCase("APPLICATION_CONFIRMED")) {
                    a(this.au);
                    p();
                    this.p = new DecimalFormat(q.a(cJRPPAccount.getAvailableCreditLimit().doubleValue()), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(cJRPPAccount.getAvailableCreditLimit());
                    net.one97.paytm.passbook.mapping.c.b(this.p, this.q);
                    net.one97.paytm.passbook.mapping.c.b(getString(R.string.rs) + " " + this.p, this.j);
                }
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public final void a(Throwable th) {
        if (!isFinishing()) {
            PassbookSubwalletActivity.class.getName();
            net.one97.paytm.passbook.utility.j.a((Activity) this, th);
        }
    }

    public final void a(CustProductList.FreezeDescription freezeDescription) {
        if (this.U == n.SAVINGS_ACCOUNT.getValue()) {
            try {
                JSONObject jSONObject = new JSONObject(freezeDescription.actionDescription);
                ((TextView) findViewById(R.id.sa_titleTv)).setText(jSONObject.optString(RequestConfirmationDialogFragment.KEY_DESCRIPTION));
                ((TextView) findViewById(R.id.sa_subtitleTv)).setText(jSONObject.optString(Item.KEY_REASON));
                ((TextView) findViewById(R.id.sa_actionBtn)).setText(jSONObject.optString("action_text"));
                findViewById(R.id.sa_actionBtn).setOnClickListener(new View.OnClickListener(jSONObject) {
                    private final /* synthetic */ JSONObject f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        PassbookSubwalletActivity.this.a(this.f$1, view);
                    }
                });
                findViewById(R.id.account_block_layout).setVisibility(0);
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(JSONObject jSONObject, View view) {
        net.one97.paytm.passbook.d.b().a(jSONObject.optString("deeplink"), (Activity) this);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.passbook.d.b().a(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    static /* synthetic */ void a(PassbookSubwalletActivity passbookSubwalletActivity, String str) {
        String str2;
        String str3;
        int i2 = passbookSubwalletActivity.U;
        if (i2 != -1) {
            String str4 = null;
            if (i2 == n.TOLL.getValue()) {
                str4 = "passbook_fastag_wallet";
                str3 = "fastag_wallet_passbook_filter_applied";
                str2 = "/passbook/fastag-wallet";
            } else if (passbookSubwalletActivity.U == n.FOOD_WALLET.getValue()) {
                str4 = "passbook_food_wallet";
                str3 = "food_wallet_passbook_filter_applied";
                str2 = "/passbook/food-wallet";
            } else if (passbookSubwalletActivity.U == n.GIFT_CARDS.getValue()) {
                str4 = "passbook_gift_wallet";
                str3 = "gift_wallet_passbook_filter_applied";
                str2 = "/passbook/gift-wallet";
            } else if (passbookSubwalletActivity.U == n.SAVINGS_ACCOUNT.getValue()) {
                str4 = "passbook_ppb";
                str3 = "ppb_passbook_filter_applied";
                str2 = "/passbook/ppb";
            } else if (passbookSubwalletActivity.U == n.PAYTM_WALLET.getValue()) {
                str4 = "passbook_wallet";
                str3 = "wallet_passbook_applied";
                str2 = "/passbook/wallet";
            } else {
                str3 = null;
                str2 = null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            q.a(passbookSubwalletActivity, str4, str3, arrayList, str2);
        }
    }

    static /* synthetic */ String[] b(PassbookSubwalletActivity passbookSubwalletActivity) {
        if (passbookSubwalletActivity.U == n.GIFT_VOUCHER.getValue()) {
            return passbookSubwalletActivity.getApplication().getResources().getStringArray(R.array.passbook_tabs_gift_voucher);
        }
        if (passbookSubwalletActivity.U == n.SAVINGS_ACCOUNT.getValue()) {
            return passbookSubwalletActivity.getApplication().getResources().getStringArray(R.array.passbook_saving_account_tabs);
        }
        return passbookSubwalletActivity.getApplication().getResources().getStringArray(R.array.passbook_tabs);
    }

    static /* synthetic */ void l() {
        try {
            new HashMap().put("new_wallet_screen_type", "net/one97/paytm/passbook");
        } catch (Exception unused) {
            boolean z2 = com.paytm.utility.b.v;
        }
    }
}
