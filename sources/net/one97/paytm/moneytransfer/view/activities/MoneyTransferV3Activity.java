package net.one97.paytm.moneytransfer.view.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.d;
import net.one97.paytm.moneytransfer.e.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.i;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.a.e;
import net.one97.paytm.moneytransfer.view.fragments.h;
import net.one97.paytm.moneytransfer.view.fragments.l;
import net.one97.paytm.moneytransfer.view.fragments.n;
import net.one97.paytm.moneytransfer.view.fragments.s;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.UpiAddBankHelperActivity;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class MoneyTransferV3Activity extends MoneyTransferBaseActivity implements View.OnClickListener, d.b, net.one97.paytm.moneytransfer.d.b, a.C1347a {
    private static final String H = MoneyTransferV3Activity.class.getSimpleName();
    private FrameLayout A;
    private List<UpiProfileDefaultBank> B;
    private BankAccountDetails.BankAccount C;
    private ViewPager D;
    private e E;
    private UpiConstants.MoneyTransferPaymentOption F = UpiConstants.MoneyTransferPaymentOption.ALL;
    private CustomWalletLoaderDialog G;
    private net.one97.paytm.moneytransfer.viewmodel.b I;
    private BroadcastReceiver J = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE.equalsIgnoreCase(intent.getAction()) && MoneyTransferV3Activity.this.l != null) {
                MoneyTransferV3Activity.this.a(intent.getBooleanExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, false));
                MoneyTransferV3Activity.this.l.a();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f54363a = 1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f54364b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f54365c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f54366d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f54367e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f54368f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f54369g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f54370h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f54371i;
    private boolean j;
    private String k = "";
    /* access modifiers changed from: private */
    public d.a l;
    private RelativeLayout m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private View r;
    private View s;
    private View t;
    private View u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private Dialog z;

    public enum a {
        ACCOUNT_NUMBER,
        VPA,
        WALLET
    }

    public enum b {
        SOMETHING_WENT_WRONG,
        PLEASE_ADD_BANK,
        CANNOT_TRANSFER_TO_SAME_ACC,
        NO_SIM
    }

    public enum d {
        VPA,
        SAVINGS_ACCOUNT,
        WALLET
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.l = (d.a) obj;
    }

    public void onCreate(Bundle bundle) {
        String str;
        net.one97.paytm.upi.f.a aVar;
        String str2;
        DeepLinkData deepLinkData;
        super.onCreate(bundle);
        setContentView(R.layout.universal_money_tranfer_layout);
        this.I = (net.one97.paytm.moneytransfer.viewmodel.b) am.a((FragmentActivity) this).a(net.one97.paytm.moneytransfer.viewmodel.b.class);
        f.a(this, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "bank_user_status", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, String.valueOf(Boolean.valueOf(net.one97.paytm.moneytransfer.d.d.c().b((Context) this))), "");
        if (getIntent().getIntExtra(UpiConstants.FROM, 0) == i.f54163a) {
            f.a(this, "/bank/money-transfer");
        } else {
            f.a(this, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME);
        }
        androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.J, new IntentFilter(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.f();
        }
        if (getIntent().getSerializableExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION) != null) {
            this.F = (UpiConstants.MoneyTransferPaymentOption) getIntent().getSerializableExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION);
        }
        this.f54366d = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, false);
        this.f54367e = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, false);
        this.f54368f = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FOR_IMPS_FROM_UNIV_P2P, false);
        this.f54369g = getIntent().getBooleanExtra("add_money_to_ppb", false);
        this.f54370h = getIntent().getBooleanExtra("intent_extra_is_offline_pg", false);
        this.f54371i = getIntent().getBooleanExtra("upi_push", false);
        this.j = getIntent().getBooleanExtra("do_open_contacts", false);
        boolean z2 = true;
        if (getIntent() != null && getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            this.f54365c = true;
        }
        m.a(getResources().getColor(R.color.white), (Activity) this);
        if (!(getIntent() == null || getIntent().getData() == null)) {
            this.f54364b = true;
            this.F = UpiConstants.MoneyTransferPaymentOption.UPI;
            m.a(new Bundle(), getSupportFragmentManager(), R.id.fragmentContainer, false);
        }
        this.m = (RelativeLayout) findViewById(R.id.rl_offers);
        this.p = (TextView) findViewById(R.id.tv_title);
        this.n = (TextView) findViewById(R.id.tv_heading);
        this.n.setText(getResources().getString(R.string.money_transfer));
        this.s = findViewById(R.id.noHeadingLayout);
        this.D = (ViewPager) findViewById(R.id.mt_offers_view_pager);
        this.r = findViewById(R.id.root_layout);
        this.x = (ImageView) findViewById(R.id.offer_left_arrow);
        this.y = (ImageView) findViewById(R.id.offer_right_arrow);
        this.w = (ImageView) findViewById(R.id.iv_back_button);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.o = (TextView) findViewById(R.id.bankAccountOrVPA);
        this.o.setOnClickListener(this);
        this.v = (ImageView) findViewById(R.id.phonebook_iv);
        this.q = (TextView) findViewById(R.id.menu_tv);
        this.q.setOnClickListener(this);
        this.v.setOnClickListener(this);
        net.one97.paytm.moneytransfer.d.d.c();
        this.q.setVisibility(0);
        this.A = (FrameLayout) findViewById(R.id.recent_fragment_container);
        this.u = findViewById(R.id.accountContainer);
        this.t = findViewById(R.id.contactContainer);
        this.t.setOnClickListener(this);
        findViewById(R.id.contact_bank_account_vpa).setOnClickListener(this);
        findViewById(R.id.contact_enter_contact_detail).setOnClickListener(this);
        if (net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().j, true)) {
            this.u.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
            this.u.setVisibility(0);
        }
        if (this.f54366d && getIntent().getSerializableExtra("user_upi_details") != null) {
            if (com.paytm.utility.b.X(getIntent().getStringExtra("payee_vpa"))) {
                Bundle a2 = a(true, getIntent().getStringExtra("payee_vpa"), getIntent().getStringExtra("payee_name"), "", "", getIntent().getStringExtra("amount"), "", (UpiProfileDefaultBank) getIntent().getSerializableExtra("user_upi_details"));
                a2.putString(UpiConstants.EXTRA_PAYER_VPA, getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA));
                a2.putString("txn_id", getIntent().getStringExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID));
                a2.putString(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, getIntent().getStringExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID));
                m.a(a2, getSupportFragmentManager(), R.id.fragmentContainer);
            } else {
                a(b.SOMETHING_WENT_WRONG);
            }
        }
        UpiConstants.MoneyTransferPaymentOption moneyTransferPaymentOption = this.F;
        net.one97.paytm.moneytransfer.b.a.b a3 = net.one97.paytm.moneytransfer.b.a(getApplicationContext());
        getApplicationContext();
        getApplicationContext();
        net.one97.paytm.upi.registration.b.a.b a4 = g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null));
        getApplicationContext();
        String str3 = "user_upi_details";
        String str4 = "payee_vpa";
        this.l = new net.one97.paytm.moneytransfer.presenter.e(moneyTransferPaymentOption, a3, a4, g.a(), this);
        this.l.e();
        if (this.f54369g) {
            this.r.setVisibility(4);
            a(true, true);
            this.C = (BankAccountDetails.BankAccount) getIntent().getSerializableExtra("bank_item_object");
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            upiProfileDefaultBank.setDebitBank(this.C);
            upiProfileDefaultBank.setVirtualAddress(getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA));
            if (getIntent().getSerializableExtra("bank_item_object") != null) {
                m.a(a(false, getIntent().getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER), getIntent().getStringExtra("payee_name"), getIntent().getStringExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P), "", getIntent().getStringExtra("amount"), getIntent().getStringExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P), upiProfileDefaultBank), getSupportFragmentManager(), R.id.fragmentContainer);
            } else {
                a(b.SOMETHING_WENT_WRONG);
            }
        }
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, false)) {
            this.r.setVisibility(4);
            if (!this.f54368f) {
                a(true, true);
            }
            if (getIntent().getSerializableExtra(str3) == null && getIntent().getStringExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P) == null) {
                a(b.SOMETHING_WENT_WRONG);
            } else {
                Bundle a5 = a(com.paytm.utility.b.X(getIntent().getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER)), getIntent().getStringExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER), getIntent().getStringExtra("payee_name"), getIntent().getStringExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P), "", getIntent().getStringExtra("amount"), getIntent().getStringExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P), (UpiProfileDefaultBank) getIntent().getSerializableExtra(str3));
                a5.putString(UpiConstants.EXTRA_UPI_P2P_PAYMENT_ROUTE, getIntent().getStringExtra(UpiConstants.EXTRA_UPI_P2P_PAYMENT_ROUTE));
                a5.putString(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, getIntent().getStringExtra(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P));
                a5.putSerializable("upi_p2p_theme", getIntent().getStringExtra("uni_p2p_landing_intent_extra_theme"));
                String stringExtra = getIntent().getStringExtra("key_payer_ppb_account_number");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.I.a(stringExtra);
                }
                m.a(a5, getSupportFragmentManager(), R.id.fragmentContainer);
            }
        }
        if (this.f54370h) {
            this.r.setVisibility(4);
            if (getIntent().getSerializableExtra(str3) != null) {
                str = str4;
                if (com.paytm.utility.b.X(getIntent().getStringExtra(str))) {
                    a(true, true);
                    Bundle a6 = a(true, getIntent().getStringExtra(str), getIntent().getStringExtra("payee_name"), "", "", getIntent().getStringExtra("amount"), getIntent().getStringExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P), (UpiProfileDefaultBank) getIntent().getSerializableExtra(str3));
                    a6.putString(UpiConstants.EXTRA_KEY_MCC, getIntent().getStringExtra("merchant_code"));
                    a6.putString("txn_id", getIntent().getStringExtra("seq_no"));
                    m.a(a6, getSupportFragmentManager(), R.id.fragmentContainer);
                } else {
                    a(b.SOMETHING_WENT_WRONG);
                }
            } else {
                str = str4;
                a(b.SOMETHING_WENT_WRONG);
            }
        } else {
            str = str4;
        }
        if (this.f54365c && (deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA")) != null) {
            try {
                if (UpiConstants.WALLET_TYPE_MONEY_TRANSFER.equalsIgnoreCase(deepLinkData.f50288f)) {
                    Uri build = Uri.parse(deepLinkData.f50283a).buildUpon().build();
                    if (a(deepLinkData)) {
                        String queryParameter = build.getQueryParameter("pn");
                        String queryParameter2 = build.getQueryParameter("pa");
                        String queryParameter3 = build.getQueryParameter("account");
                        String queryParameter4 = build.getQueryParameter("ifsc");
                        String queryParameter5 = build.getQueryParameter(PayUtility.BANK_NAME);
                        String queryParameter6 = build.getQueryParameter("am");
                        String queryParameter7 = build.getQueryParameter("tn");
                        Bundle bundle2 = new Bundle();
                        if (!TextUtils.isEmpty(queryParameter3)) {
                            bundle2.putString("vpa", queryParameter3);
                            bundle2.putString("ifsc", queryParameter4);
                            bundle2.putString("bankname", queryParameter5);
                            bundle2.putBoolean("isVPA", false);
                        } else if (!TextUtils.isEmpty(queryParameter2)) {
                            bundle2.putString("vpa", queryParameter2);
                            bundle2.putBoolean("isVPA", true);
                        }
                        bundle2.putString("username", queryParameter);
                        bundle2.putString("amount", queryParameter6);
                        bundle2.putString("comments", queryParameter7);
                        m.a(bundle2, getSupportFragmentManager(), R.id.fragmentContainer, false);
                    }
                } else if ("money_transfer_bankaccount".equalsIgnoreCase(deepLinkData.f50288f)) {
                    s();
                } else if ("money_transfer_contact".equalsIgnoreCase(deepLinkData.f50288f)) {
                    b(false);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            if (!TextUtils.isEmpty(net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().f53986a))) {
                this.p.setVisibility(0);
                this.p.setMovementMethod(LinkMovementMethod.getInstance());
                String a7 = net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().f53986a);
                if (a7.contains("https")) {
                    final String substring = a7.substring(a7.indexOf("https"), a7.indexOf("'>"));
                    String substring2 = a7.substring(a7.indexOf("'>") + 2, a7.indexOf("</"));
                    if (Build.VERSION.SDK_INT >= 24) {
                        str2 = Html.fromHtml(a7, 0).toString();
                    } else {
                        str2 = Html.fromHtml(a7).toString();
                    }
                    SpannableString spannableString = new SpannableString(str2);
                    AnonymousClass2 r5 = new ClickableSpan() {
                        public final void onClick(View view) {
                            MoneyTransferV3Activity.a(MoneyTransferV3Activity.this, substring);
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(Color.parseColor("#00b9f5"));
                        }
                    };
                    int indexOf = str2.indexOf(substring2);
                    int length = substring2.length() + indexOf;
                    if (indexOf >= 0 && length >= 0) {
                        spannableString.setSpan(r5, indexOf, length, 33);
                    }
                    this.p.setText(spannableString);
                } else {
                    this.p.setText(a7);
                }
            } else {
                this.s.setVisibility(0);
                this.p.setVisibility(8);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            this.p.setText(getString(R.string.univ_money_trnsfr_zero_fees_from_any_bank));
        }
        if (!TextUtils.isEmpty(net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().f53987b))) {
            this.m.setVisibility(0);
            String[] split = net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().f53987b).split("\\|");
            this.E = new e(getSupportFragmentManager(), split);
            this.D.setAdapter(this.E);
            if (split.length < 2) {
                this.x.setVisibility(8);
            }
        }
        if (this.f54371i) {
            this.r.setVisibility(4);
            if (getIntent().getSerializableExtra(str3) == null) {
                a(b.SOMETHING_WENT_WRONG);
            } else if (com.paytm.utility.b.X(getIntent().getStringExtra(str))) {
                a(true, true);
                Bundle a8 = a(true, getIntent().getStringExtra(str), getIntent().getStringExtra("payee_name"), "", "", getIntent().getStringExtra("amount"), "", (UpiProfileDefaultBank) getIntent().getSerializableExtra(str3));
                a8.putString("txn_id", getIntent().getStringExtra(UpiConstants.EXTRA_UPI_SEQ_NO));
                m.a(a8, getSupportFragmentManager(), R.id.fragmentContainer);
            } else {
                a(b.SOMETHING_WENT_WRONG);
            }
        }
        try {
            d.a.a.c.a().a((Object) this, false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (androidx.core.app.a.a((Context) this, "android.permission.READ_CONTACTS") == 0) {
            this.I.a();
        }
        if (this.j) {
            b(false);
        }
        if (!net.one97.paytm.moneytransfer.d.d.c().c(this)) {
            new net.one97.paytm.moneytransfer.e.d().a(this, "", (d.a) null);
        }
        if (o() && (aVar = net.one97.paytm.upi.i.a().l) != null) {
            aVar.a(getApplicationContext());
        }
        if (this.f54371i || this.f54370h || this.f54368f || this.f54369g || this.f54367e) {
            z2 = false;
        }
        if (z2 && net.one97.paytm.moneytransfer.d.c.a(net.one97.paytm.moneytransfer.d.c.g().r, false)) {
            Intent intent = new Intent(this, MoneyTransferV4Activity.class);
            intent.addFlags(33554432);
            intent.setData(getIntent().getData());
            intent.putExtras(getIntent());
            startActivity(intent);
            finish();
        }
    }

    public final boolean o() {
        return !this.f54371i && !this.f54370h && !this.f54364b && !this.f54366d && !this.f54369g;
    }

    private static Bundle a(boolean z2, String str, String str2, String str3, String str4, String str5, String str6, UpiProfileDefaultBank upiProfileDefaultBank) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isVPA", z2);
        bundle.putString("vpa", str);
        bundle.putString("username", str2);
        bundle.putString("amount", str5);
        bundle.putString("comments", str6);
        bundle.putSerializable("user_upi_details", upiProfileDefaultBank);
        if (!z2) {
            bundle.putString("ifsc", str3);
            bundle.putString("bankname", str4);
        }
        return bundle;
    }

    public final boolean g() {
        return this.f54365c;
    }

    public final boolean h() {
        return this.f54364b;
    }

    public void onBackPressed() {
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false) || getIntent().getBooleanExtra("do_open_contacts", false)) {
            finish();
            return;
        }
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.f() > 0) {
            Fragment c2 = supportFragmentManager.c(n.class.getSimpleName());
            if (c2 instanceof n) {
                ((n) c2).e();
            } else {
                supportFragmentManager.d();
            }
        } else {
            finish();
        }
        com.paytm.utility.b.c((Activity) this);
    }

    public final void a(boolean z2) {
        this.I.a(z2);
        f.a(this, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "upi_user_status", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, String.valueOf(z2), "");
        if (z2) {
            ((TextView) findViewById(R.id.contact_bank_account_vpa)).setText(getString(R.string.univ_money_trnsfr_upi_bank_acc_adhaar));
            this.o.setText(getString(R.string.mt_or_enter_bank_account_upi));
            return;
        }
        ((TextView) findViewById(R.id.contact_bank_account_vpa)).setText(getString(R.string.mt_enter_bank_account));
        this.o.setText(getString(R.string.mt_or_enter_bank_account));
    }

    public final void a(Double d2, Double d3, Double d4) {
        this.I.j = d2.doubleValue();
        this.I.k = d3.doubleValue();
        this.I.l = d4.doubleValue();
    }

    private void b(int i2) {
        ViewPager viewPager = this.D;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2, true);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back_button) {
            onBackPressed();
        } else if (id == R.id.offer_left_arrow) {
            if (this.D.getCurrentItem() - 1 >= 0) {
                b(this.D.getCurrentItem() - 1);
            }
        } else if (id == R.id.offer_right_arrow) {
            if (this.D.getCurrentItem() + 1 < this.E.getCount()) {
                b(this.D.getCurrentItem() + 1);
            }
        } else if (id == R.id.menu_tv) {
            if (r()) {
                if (net.one97.paytm.upi.registration.b.a.a.a.a(getApplicationContext()).h()) {
                    Intent intent = new Intent(this, UpiLandingPageActivity.class);
                    intent.setFlags(67108864);
                    startActivityForResult(intent, 1);
                } else if (!TextUtils.isEmpty(this.I.b().getValue())) {
                    UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                    UpiAddBankHelperActivity.a.a(this, this.I.b().getValue());
                }
            } else if (UpiUtils.isInActiveProfileExist(getApplicationContext())) {
                startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(this), 1);
            } else {
                startActivity(new Intent(this, UpiSelectBankActivity.class));
            }
        } else if (id == R.id.bankAccountOrVPA || id == R.id.contact_bank_account_vpa) {
            s();
        } else if (id == R.id.phonebook_iv || id == R.id.contactContainer || id == R.id.account_number_et || id == R.id.contact_enter_contact_detail) {
            b(true);
        }
    }

    public final void j() {
        l lVar = new l();
        lVar.f54509c = this;
        this.A.setVisibility(0);
        if (getSupportFragmentManager().c("beneficiary_fragment") == null) {
            getSupportFragmentManager().a().a(0, 0).b(R.id.recent_fragment_container, lVar, "beneficiary_fragment").c();
        }
        h hVar = new h();
        k.c(this, H5Event.TYPE_CALL_BACK);
        hVar.f54481a = this;
        getSupportFragmentManager().a().a(R.id.bottomFragmentContainer, hVar, h.class.getName()).c();
    }

    public final void a(ArrayList<UpiProfileDefaultBank> arrayList, ArrayList<UpiProfileDefaultBank> arrayList2) {
        this.I.a(true);
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.I;
        k.c(arrayList, "list");
        y<ArrayList<UpiProfileDefaultBank>> yVar = bVar.f54683h;
        if (yVar != null) {
            yVar.setValue(arrayList);
        }
        net.one97.paytm.moneytransfer.viewmodel.b bVar2 = this.I;
        k.c(arrayList2, "list");
        y<ArrayList<UpiProfileDefaultBank>> yVar2 = bVar2.f54684i;
        if (yVar2 != null) {
            yVar2.setValue(arrayList2);
        }
        this.B = arrayList;
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        this.B = list;
        this.B.clear();
    }

    private void a(boolean z2, boolean z3, String str) {
        try {
            if (this.G == null) {
                this.G = new CustomWalletLoaderDialog(this);
            }
            if (z2) {
                CustomWalletLoaderDialog customWalletLoaderDialog = this.G;
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.money_transfer_processing_money_transfer);
                }
                customWalletLoaderDialog.setTitle(str);
                this.G.showLoader();
            } else {
                this.G.dismissLoader();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z3) {
            this.r.setVisibility(8);
        } else if (!z3 && !this.f54367e && !this.f54368f && !this.f54366d && !this.f54369g && !this.f54370h && !this.f54371i) {
            this.r.setVisibility(0);
        }
    }

    public final void a(boolean z2, boolean z3) {
        a(z2, z3, "");
    }

    public final void a() {
        try {
            com.paytm.utility.b.p();
            if (this.z != null && this.z.isShowing()) {
                this.z.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public void onResume() {
        super.onResume();
        try {
            if (!d.a.a.c.a().a((Object) this)) {
                d.a.a.c.a().a((Object) this, false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        a(false, false);
        if (this.J != null) {
            androidx.localbroadcastmanager.a.a.a(getApplicationContext()).a(this.J);
            this.J = null;
        }
        try {
            d.a.a.c.a().b(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.l.f();
    }

    public final void a(String str) {
        this.I.a(str);
        this.k = str;
        this.l.a(this.k);
    }

    public final void b(String str) {
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.I;
        k.c(str, "balance");
        y<String> yVar = bVar.f54681f;
        if (yVar != null) {
            yVar.setValue(str);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 301) {
            if (!this.f54364b || i3 != -1 || !com.paytm.utility.a.p(getApplicationContext())) {
                finish();
            } else {
                this.l.a();
                this.l.c();
            }
        } else if (i2 == 1004) {
            if (i3 == -1) {
                this.l.a();
            }
        } else if (i2 == 1 && i3 == -1) {
            this.l.a();
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (this.f54367e || this.f54366d || this.f54369g) {
            a(b.SOMETHING_WENT_WRONG);
        } else if (upiCustomVolleyError == null) {
        } else {
            if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || "410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                net.one97.paytm.moneytransfer.d.a c2 = net.one97.paytm.moneytransfer.d.d.c();
                new NetworkCustomError();
                c2.a((Activity) this, (String) null, false);
            } else if (upiCustomVolleyError.getAlertMessage() != null) {
                String trim = upiCustomVolleyError.getAlertMessage().trim();
                if (TextUtils.isEmpty(trim)) {
                    trim = getString(R.string.upi_oops_something_went_wrong);
                }
                com.paytm.utility.b.b((Context) this, "Error", trim);
            } else {
                com.paytm.utility.b.b((Context) this, "Error", getString(R.string.upi_oops_something_went_wrong));
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        com.paytm.utility.h hVar = new com.paytm.utility.h(this);
        hVar.setTitle(str);
        hVar.setCanceledOnTouchOutside(false);
        hVar.setCancelable(false);
        hVar.a(str2);
        hVar.a(-1, str3, new View.OnClickListener(hVar) {
            private final /* synthetic */ com.paytm.utility.h f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                MoneyTransferV3Activity.this.a(this.f$1, view);
            }
        });
        hVar.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.paytm.utility.h hVar, View view) {
        hVar.dismiss();
        if (this.f54371i || this.f54367e || this.f54370h || this.f54369g) {
            finish();
        }
    }

    private void a(b bVar) {
        String str;
        if (bVar == b.PLEASE_ADD_BANK) {
            str = getString(R.string.please_add_a_bank_account);
        } else if (bVar == b.SOMETHING_WENT_WRONG) {
            str = getString(R.string.upi_oops_something_went_wrong);
        } else if (bVar == b.CANNOT_TRANSFER_TO_SAME_ACC) {
            str = getString(R.string.you_cannot_transfer_money_to_same_account);
        } else {
            str = bVar == b.NO_SIM ? getString(R.string.no_sim_attached) : "";
        }
        f(str);
    }

    public final void f(String str) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str);
            builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (MoneyTransferV3Activity.this.f54367e || MoneyTransferV3Activity.this.f54366d || MoneyTransferV3Activity.this.f54369g || MoneyTransferV3Activity.this.f54370h || MoneyTransferV3Activity.this.f54371i) {
                        MoneyTransferV3Activity.this.a(false, false);
                        MoneyTransferV3Activity.this.finish();
                    }
                }
            });
            builder.show();
        }
    }

    public void onServiceConnected() {
        q.d("onServiceConnected");
    }

    public void onServiceDisconnected() {
        q.d("onServiceDisconnected");
    }

    private boolean r() {
        return net.one97.paytm.moneytransfer.utils.l.a(getApplicationContext()).b("is_upi_user", false, true);
    }

    public final boolean b() {
        return this.f54369g;
    }

    public final boolean c() {
        return this.j;
    }

    public final boolean d() {
        return this.f54370h;
    }

    public final boolean f() {
        return this.f54366d;
    }

    public final boolean e() {
        return this.f54371i;
    }

    public final boolean i() {
        return this.f54367e;
    }

    public final void d(String str) {
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.I;
        k.c(str, "vpa");
        y<String> yVar = bVar.f54679d;
        if (yVar != null) {
            yVar.setValue(str);
        }
    }

    public enum c {
        NEW_ACCOUNT(0),
        RECENT_LIST(1),
        BENEFICIARY_LIST(2),
        PHONEBOOK(4);
        
        private int getVal;

        private c(int i2) {
            this.getVal = i2;
        }

        public final int getVal() {
            return this.getVal;
        }
    }

    private void s() {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        net.one97.paytm.moneytransfer.view.fragments.e eVar = new net.one97.paytm.moneytransfer.view.fragments.e();
        eVar.f54453a = this;
        a2.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
        a2.a(R.id.fragmentContainer, eVar, net.one97.paytm.moneytransfer.view.fragments.e.class.getName()).a(net.one97.paytm.moneytransfer.view.fragments.e.class.getName());
        a2.c();
    }

    private void b(boolean z2) {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        net.one97.paytm.moneytransfer.contacts.a aVar = new net.one97.paytm.moneytransfer.contacts.a();
        if (z2) {
            a2.a(R.anim.fragment_bottom_up, R.anim.money_transfer_fade_out, R.anim.fragment_bottom_up, R.anim.money_transfer_fade_out);
        }
        a2.a(R.id.fragmentContainer, aVar, net.one97.paytm.moneytransfer.contacts.a.class.getName()).a(net.one97.paytm.moneytransfer.contacts.a.class.getName());
        a2.c();
    }

    public final void m() {
        if (r()) {
            if (net.one97.paytm.upi.registration.b.a.a.a.a(getApplicationContext()).h()) {
                Intent intent = new Intent(this, UpiPassbookActivity.class);
                intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
                startActivity(intent);
            } else if (!TextUtils.isEmpty(this.I.b().getValue())) {
                UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                UpiAddBankHelperActivity.a.a(this, this.I.b().getValue());
            }
        } else if (UpiUtils.isInActiveProfileExist(getApplicationContext())) {
            startActivity(UpiUtils.getUpiLandingPageActivityIntent(this));
        } else {
            startActivity(new Intent(this, UpiSelectBankActivity.class));
        }
    }

    public final void n() {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        net.one97.paytm.moneytransfer.view.fragments.f fVar = new net.one97.paytm.moneytransfer.view.fragments.f();
        k.c(this, "moneyTransferActivityCallback");
        fVar.f54466a = this;
        a2.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
        a2.a(R.id.fragmentContainer, fVar, net.one97.paytm.moneytransfer.view.fragments.f.class.getName()).a(net.one97.paytm.moneytransfer.view.fragments.f.class.getName());
        a2.c();
    }

    public final void e(String str) {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        net.one97.paytm.moneytransfer.view.fragments.e eVar = new net.one97.paytm.moneytransfer.view.fragments.e();
        Bundle bundle = new Bundle();
        bundle.putString(ContactColumn.PHONE_NUMBER, str);
        eVar.setArguments(bundle);
        eVar.f54453a = this;
        a2.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
        a2.a(R.id.fragmentContainer, eVar, net.one97.paytm.moneytransfer.view.fragments.e.class.getName()).a(net.one97.paytm.moneytransfer.view.fragments.e.class.getName());
        a2.c();
    }

    public final void p() {
        this.l.b();
    }

    public final void q() {
        this.l.a();
    }

    public final void a(int i2, int i3, ArrayList<BeneficiaryEntity> arrayList) {
        androidx.fragment.app.q a2 = getSupportFragmentManager().a();
        s sVar = new s();
        Bundle bundle = new Bundle();
        bundle.putInt("beneficiary_offset", i2);
        bundle.putInt("beneficiary_total_count", i3);
        bundle.putSerializable("beneficiary_list_page_1", arrayList);
        sVar.setArguments(bundle);
        a2.a(R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out, R.anim.money_transfer_fade_in, R.anim.money_transfer_fade_out);
        a2.a(R.id.fragmentContainer, sVar, s.class.getName()).a(s.class.getName());
        a2.c();
    }

    public final boolean k() {
        return UpiAppUtils.isNetworkAvailable(getApplicationContext());
    }

    public final void l() {
        m.d((Activity) this);
    }

    public final void a(PPBCurrentAccountModel pPBCurrentAccountModel) {
        y<PPBCurrentAccountModel> yVar = this.I.q;
        if (yVar != null) {
            yVar.setValue(pPBCurrentAccountModel);
        }
    }

    public final void c(String str) {
        net.one97.paytm.moneytransfer.viewmodel.b bVar = this.I;
        k.c(str, "balance");
        y<String> yVar = bVar.f54682g;
        if (yVar != null) {
            yVar.setValue(str);
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        Uri build = Uri.parse(deepLinkData.f50283a).buildUpon().build();
        return !TextUtils.isEmpty(build.getQueryParameter("account")) || !TextUtils.isEmpty(build.getQueryParameter("pa"));
    }

    public void onEvent(UpiDBTransactionModel upiDBTransactionModel) {
        String str;
        Bundle bundle = new Bundle();
        if (com.paytm.utility.b.X(upiDBTransactionModel.getTxn_mode())) {
            bundle.putBoolean("isVPA", true);
            bundle.putString("vpa", upiDBTransactionModel.getTxn_mode());
            bundle.putString("username", upiDBTransactionModel.getBeneficiary_name());
            str = "upi";
        } else {
            bundle.putBoolean("isVPA", false);
            bundle.putString("vpa", upiDBTransactionModel.getTxn_mode());
            bundle.putString("username", upiDBTransactionModel.getBeneficiary_name());
            bundle.putString("ifsc", upiDBTransactionModel.getIfsc());
            bundle.putString("bankname", upiDBTransactionModel.getBank_name());
            str = "bank_account";
        }
        String str2 = str;
        bundle.putInt("source_of_initiation", c.BENEFICIARY_LIST.ordinal());
        m.a(bundle, getSupportFragmentManager(), R.id.fragmentContainer);
        f.a(this, CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, Events.Action.PROCEED_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, str2, upiDBTransactionModel.isSelf() ? "transfer_to_your_own_account" : "saved_account");
    }

    static /* synthetic */ void a(MoneyTransferV3Activity moneyTransferV3Activity, String str) {
        Intent intent;
        try {
            intent = new Intent(moneyTransferV3Activity, Class.forName(net.one97.paytm.moneytransfer.d.d.c().f()));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            intent = null;
        }
        intent.putExtra("url", str);
        moneyTransferV3Activity.startActivity(intent);
    }
}
