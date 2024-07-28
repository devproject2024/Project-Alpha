package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.moneytransfer.view.b.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.a.b;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.mandate.view.MandateListActivity;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.ProfileCreateVpaActivity;
import net.one97.paytm.upi.registration.a.f;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CirclePageIndicator;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomSnackbar;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiLandingPageActivity extends PaytmActivity implements View.OnClickListener, f.b {
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C;
    private RelativeLayout D;
    private BroadcastReceiver E = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("refresh_upi_landing_receiver")) {
                boolean unused = UpiLandingPageActivity.this.z = intent.getBooleanExtra("refresh_upi_landing", false);
            }
        }
    };
    private String F = "";
    private Boolean G = Boolean.FALSE;

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f68747a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (UpiConstants.EXTRA_ACTION_RELOAD_UPI.equalsIgnoreCase(intent.getAction())) {
                boolean unused = UpiLandingPageActivity.this.A = intent.getBooleanExtra(UpiConstants.EXTRA_RELOAD_UPI_TRANSACTIONS, false);
                boolean unused2 = UpiLandingPageActivity.this.B = intent.getBooleanExtra(UpiConstants.EXTRA_RELOAD_UPI_PENDING_REQUESTS, false);
                UpiLandingPageActivity.this.i();
                UpiLandingPageActivity.this.j();
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    int f68748b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68749c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68750d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68751e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68752f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager f68753g;

    /* renamed from: h  reason: collision with root package name */
    private TabLayout f68754h;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout f68755i;
    private FrameLayout j;
    private LottieAnimationView k;
    private LinearLayout l;
    private LinearLayout m;
    private RelativeLayout n;
    private TextView o;
    /* access modifiers changed from: private */
    public f.a p;
    private CirclePageIndicator q;
    private ConstraintLayout r;
    private ProgressDialog s;
    private View t;
    private boolean u;
    private String v;
    private boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private BankAccountDetails.BankAccount y;
    /* access modifiers changed from: private */
    public boolean z;

    public final /* synthetic */ void a(Object obj) {
        this.p = (f.a) obj;
        this.p.e();
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, UPISettingsActivity.class);
        intent.putExtra("invokedFromPaytmHome", true);
        context.startActivity(intent);
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_landing);
        CJRSendGTMTag.sendNewCustomGTMEvents(this, GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_LANDING_PAGE, "wallet");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiLandingPageActivity.this.onBackPressed();
            }
        });
        setSupportActionBar(toolbar);
        this.A = false;
        this.B = false;
        this.f68748b = getIntent().getIntExtra("redirect", -1);
        this.v = getIntent().getStringExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL);
        this.x = getIntent().getBooleanExtra(UpiConstants.INACTIVE_USER, false);
        this.C = getIntent().getBooleanExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, false);
        this.f68754h = (TabLayout) findViewById(R.id.tl_upi_tabs);
        this.f68750d = (TextView) findViewById(R.id.tv_money_transfer);
        this.f68751e = (TextView) findViewById(R.id.tv_request_money);
        this.f68752f = (TextView) findViewById(R.id.tv_re_activate_account);
        this.f68755i = (FrameLayout) findViewById(R.id.fl_qr_container);
        this.j = (FrameLayout) findViewById(R.id.fl_bank_container_surface);
        this.f68753g = (ViewPager) findViewById(R.id.vp_qr_fragment);
        this.k = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.l = (LinearLayout) findViewById(R.id.ll_error_container);
        this.l.findViewById(R.id.iv_error_image).setVisibility(8);
        this.o = (TextView) findViewById(R.id.tv_retry);
        this.q = (CirclePageIndicator) findViewById(R.id.cpi_qr_pager);
        this.n = (RelativeLayout) findViewById(R.id.re_activate_container);
        this.m = (LinearLayout) findViewById(R.id.ll_action_content);
        this.r = (ConstraintLayout) findViewById(R.id.cl_need_help);
        this.t = findViewById(R.id.layout_security_pin);
        this.D = (RelativeLayout) findViewById(R.id.rl_savedbank_header);
        ((LinearLayout) findViewById(R.id.ll_upi_item)).setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.ll_umt_item)).setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.ll_request_money_item)).setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.ll_payment_request_item)).setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.ll_schedule_payment_item)).setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.ll_help_item)).setOnClickListener(this);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.a().m.a((Activity) UpiLandingPageActivity.this, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000520");
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
            }
        });
        f();
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = new a();
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_upi_landing", true);
                aVar.setArguments(bundle);
                aVar.a((a.d) new a.d() {
                    public final void onDismiss() {
                        UpiLandingPageActivity.AnonymousClass8.this.a();
                    }
                });
                aVar.show(UpiLandingPageActivity.this.getSupportFragmentManager(), "");
                CJRSendGTMTag.sendCustomGTMEvents(UpiLandingPageActivity.this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "upi_profile_security_know_more_clicked", "", "", "", "");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a() {
                UpiLandingPageActivity.this.f();
            }
        });
        if (getSupportFragmentManager().c("referral_strip") == null) {
            getSupportFragmentManager().a().b(R.id.fl_referral_strip, i.a().m.d(), "referral_strip").c();
        }
        if (this.C) {
            findViewById(R.id.fl_pending_container).setVisibility(8);
            findViewById(R.id.fl_recent_payment_container).setVisibility(8);
            b.a(getSupportFragmentManager());
        }
        this.f68750d.setOnClickListener(this);
        this.f68751e.setOnClickListener(this);
        this.f68752f.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiLandingPageActivity.this.p != null) {
                    UpiLandingPageActivity.this.p.e();
                    boolean unused = UpiLandingPageActivity.this.x;
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("refresh_upi_landing_receiver");
        intentFilter.addAction(UpiConstants.EXTRA_ACTION_UPI_LANDING_SHOW_PENDING);
        androidx.localbroadcastmanager.a.a.a((Context) this).a(this.E, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(UpiConstants.EXTRA_ACTION_RELOAD_UPI);
        androidx.localbroadcastmanager.a.a.a((Context) this).a(this.f68747a, intentFilter2);
        new net.one97.paytm.upi.registration.presenter.f(g.a(), g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), this, this.x);
        if (!PaytmUpiPrefUtil.getPref(getApplicationContext()).b("is_upi_user", false, true) && !PaytmUpiPrefUtil.getPref(getApplicationContext()).b(UpiConstants.PREF_KEY_IS_PROFILE_EXIST, false, true)) {
            startActivity(new Intent(this, UpiSelectBankActivity.class));
            finish();
        }
        if (getIntent().getIntExtra(UpiConstants.FROM, 0) == 100) {
            CJRSendGTMTag.sendOpenScreenWithDeviceInfo("/bank/bhim-upi/profile", "wallet", this);
        } else {
            CJRSendGTMTag.sendOpenScreenWithDeviceInfo("/bhim-upi/profile", "wallet", this);
        }
        if (this.x) {
            getSupportFragmentManager().a().a(R.id.fragment_reactivate_container, x.a(), "upi_reactivate").a("upi_reactivate").c();
            this.n.setVisibility(0);
            this.j.setVisibility(0);
            this.f68751e.setVisibility(8);
            this.f68750d.setVisibility(8);
        } else if (UpiUtils.isInActiveProfileExist(this)) {
            getSupportFragmentManager().a().a(R.id.fragment_reactivate_container, x.a(), "upi_reactivate").a("upi_reactivate").c();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        this.t.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        i();
        j();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upi_landing_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.x) {
            return false;
        }
        menu.findItem(R.id.menu_edit_upi_id).setVisible(!this.F.isEmpty());
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_link_account) {
            if (PaytmUpiPrefUtil.getPref(getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true)) {
                AccountProviderActivity.a((Activity) this, 31);
            } else {
                b(32);
            }
        } else if (itemId == R.id.menu_add_vpa) {
            this.p.a(UpiGTMLoader.getInstance().getMaxVpaAllowed());
        } else if (itemId == R.id.menu_dynamic_qr) {
            Intent intent = new Intent(this, RequestMoneyV2Activity.class);
            intent.putExtra(UpiConstants.EXTRA_SOURCE_DYNAMIC_QR, true);
            startActivity(intent);
        } else if (itemId == R.id.menu_spam_folder) {
            Intent intent2 = new Intent(this, UpiPassbookActivity.class);
            intent2.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal());
            startActivityForResult(intent2, 38);
        } else if (itemId == R.id.menu_deregister_upi) {
            if (UpiAppUtils.isNetworkAvailable(this)) {
                c.a aVar = new c.a(this);
                aVar.a(true);
                aVar.b(R.string.upi_deregister_msg);
                aVar.a(R.string.upi_deregister_profile);
                aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        UpiLandingPageActivity.this.p.a();
                        dialogInterface.dismiss();
                    }
                });
                aVar.b(R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                aVar.b();
            } else {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet_new_message));
            }
        } else if (itemId == R.id.menu_edit_upi_id) {
            Intent intent3 = new Intent(this, EditVpaActivity.class);
            intent3.putExtra("current vpa", this.F);
            startActivityForResult(intent3, 37);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_money_transfer) {
            CJRSendGTMTag.sendCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "send_money_clicked", "", "", "/bhim-upi/profile", "wallet");
            g();
        } else if (id == R.id.tv_request_money) {
            CJRSendGTMTag.sendCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, "", "", "/bhim-upi/profile", "wallet");
            h();
        } else if (id == R.id.tv_re_activate_account) {
            Intent intent = new Intent(this, UpiRegistrationActivity.class);
            intent.putExtra("redirect", 36);
            startActivityForResult(intent, 36);
        } else if (id == R.id.fl_bank_container_surface) {
        } else {
            if (id == R.id.ll_upi_item) {
                CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "recent_payments_clicked", "", "", "", "/bhim-upi/landing-screen", "wallet");
                Intent intent2 = new Intent(this, UpiPassbookActivity.class);
                intent2.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.TRANSACTIONS.ordinal());
                startActivity(intent2);
            } else if (id == R.id.ll_umt_item) {
                CJRSendGTMTag.sendCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "send_money_clicked", "", "", "/bhim-upi/profile", "wallet");
                g();
            } else if (id == R.id.ll_request_money_item) {
                CJRSendGTMTag.sendCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, CJRGTMConstants.MT_V4_REQUEST_MONEY_CLICKED, "", "", "/bhim-upi/profile", "wallet");
                h();
            } else if (id == R.id.ll_payment_request_item) {
                Intent intent3 = new Intent(this, UpiPassbookActivity.class);
                intent3.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
                intent3.putExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB, "getpendingrequestssent");
                startActivity(intent3);
            } else if (id == R.id.ll_schedule_payment_item) {
                startActivity(new Intent(this, MandateListActivity.class));
            } else if (id == R.id.ll_help_item) {
                i.a().m.a((Activity) this, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000520");
            }
        }
    }

    private void g() {
        if (l() == UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal()) {
            Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
            intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
            androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
            finish();
            return;
        }
        i.a();
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.MONEY_TRANSFER_HEADER, getResources().getString(R.string.send_money));
        i.a().m.a((Context) this, bundle);
    }

    public void onPostResume() {
        super.onPostResume();
        if (this.z) {
            this.z = false;
            f.a aVar = this.p;
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    private void h() {
        i.a();
        startActivity(new Intent(this, RequestMoneyV2Activity.class));
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        AnimationFactory.stopWalletLoader(this.k);
        this.l.setVisibility(0);
        this.f68753g.setVisibility(8);
        this.q.setVisibility(8);
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || "410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
            k kVar = i.a().k;
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getName();
            kVar.e(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank> r8, java.util.List<net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount> r9) {
        /*
            r7 = this;
            java.util.Iterator r0 = r8.iterator()
        L_0x0004:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r1 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r1
            boolean r2 = r1.isPrimary()
            if (r2 == 0) goto L_0x0004
            java.lang.String r1 = r1.getVirtualAddress()
            r7.F = r1
            r7.invalidateOptionsMenu()
            goto L_0x0004
        L_0x0020:
            com.airbnb.lottie.LottieAnimationView r0 = r7.k
            net.one97.paytm.upi.util.AnimationFactory.stopWalletLoader(r0)
            android.widget.LinearLayout r0 = r7.l
            r1 = 8
            r0.setVisibility(r1)
            r0 = 0
            if (r8 == 0) goto L_0x0113
            int r2 = r8.size()
            if (r2 > 0) goto L_0x0037
            goto L_0x0113
        L_0x0037:
            r2 = 0
            android.widget.FrameLayout r3 = r7.f68755i     // Catch:{ Exception -> 0x00dc }
            r3.setVisibility(r2)     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.registration.view.w r3 = new net.one97.paytm.upi.registration.view.w     // Catch:{ Exception -> 0x00dc }
            androidx.fragment.app.j r4 = r7.getSupportFragmentManager()     // Catch:{ Exception -> 0x00dc }
            boolean r5 = r7.f68749c     // Catch:{ Exception -> 0x00dc }
            r3.<init>(r4, r8, r5)     // Catch:{ Exception -> 0x00dc }
            androidx.viewpager.widget.ViewPager r4 = r7.f68753g     // Catch:{ Exception -> 0x00dc }
            r4.setAdapter(r3)     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.util.CirclePageIndicator r4 = r7.q     // Catch:{ Exception -> 0x00dc }
            androidx.viewpager.widget.ViewPager r5 = r7.f68753g     // Catch:{ Exception -> 0x00dc }
            r4.setViewPager(r5)     // Catch:{ Exception -> 0x00dc }
            androidx.viewpager.widget.ViewPager r4 = r7.f68753g     // Catch:{ Exception -> 0x00dc }
            r4.setVisibility(r2)     // Catch:{ Exception -> 0x00dc }
            int r4 = r8.size()     // Catch:{ Exception -> 0x00dc }
            r5 = 2
            if (r4 >= r5) goto L_0x0066
            net.one97.paytm.upi.util.CirclePageIndicator r4 = r7.q     // Catch:{ Exception -> 0x00dc }
            r4.setVisibility(r1)     // Catch:{ Exception -> 0x00dc }
            goto L_0x006b
        L_0x0066:
            net.one97.paytm.upi.util.CirclePageIndicator r4 = r7.q     // Catch:{ Exception -> 0x00dc }
            r4.setVisibility(r2)     // Catch:{ Exception -> 0x00dc }
        L_0x006b:
            r7.f68749c = r2     // Catch:{ Exception -> 0x00dc }
            r3.f69083a = r2     // Catch:{ Exception -> 0x00dc }
            boolean r3 = r7.u     // Catch:{ Exception -> 0x00dc }
            if (r3 == 0) goto L_0x00c9
            if (r9 == 0) goto L_0x00c9
            int r3 = r9.size()     // Catch:{ Exception -> 0x00dc }
            if (r3 <= 0) goto L_0x00c9
            r7.u = r2     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r7.y     // Catch:{ Exception -> 0x00dc }
            if (r3 != 0) goto L_0x009b
            int r3 = r9.size()     // Catch:{ Exception -> 0x00dc }
            int r3 = r3 + -1
            java.lang.Object r3 = r9.get(r3)     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r3     // Catch:{ Exception -> 0x00dc }
            java.lang.Object r4 = r8.get(r2)     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r4 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r4     // Catch:{ Exception -> 0x00dc }
            java.lang.String r4 = r4.getVirtualAddress()     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.profile.view.UpiProfileAccountDetailActivity.a(r7, r3, r4)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00df
        L_0x009b:
            java.util.Iterator r3 = r9.iterator()     // Catch:{ Exception -> 0x00dc }
        L_0x009f:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00dc }
            if (r4 == 0) goto L_0x00df
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r4 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r4     // Catch:{ Exception -> 0x00dc }
            java.lang.String r5 = r4.getAccRefNumber()     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r6 = r7.y     // Catch:{ Exception -> 0x00dc }
            java.lang.String r6 = r6.getAccRefNumber()     // Catch:{ Exception -> 0x00dc }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x00dc }
            if (r5 == 0) goto L_0x009f
            java.lang.Object r3 = r8.get(r2)     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r3 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r3     // Catch:{ Exception -> 0x00dc }
            java.lang.String r3 = r3.getVirtualAddress()     // Catch:{ Exception -> 0x00dc }
            net.one97.paytm.upi.profile.view.UpiProfileAccountDetailActivity.a(r7, r4, r3)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00df
        L_0x00c9:
            boolean r3 = r7.w     // Catch:{ Exception -> 0x00dc }
            if (r3 == 0) goto L_0x00df
            r7.w = r2     // Catch:{ Exception -> 0x00dc }
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x00dc }
            java.lang.Class<net.one97.paytm.upi.profile.view.UpiProfileActivity> r4 = net.one97.paytm.upi.profile.view.UpiProfileActivity.class
            r3.<init>(r7, r4)     // Catch:{ Exception -> 0x00dc }
            r4 = 30
            r7.startActivityForResult(r3, r4)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00df
        L_0x00dc:
            r7.a((net.one97.paytm.upi.common.UpiCustomVolleyError) r0)
        L_0x00df:
            if (r9 == 0) goto L_0x0112
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x0112
            android.widget.RelativeLayout r9 = r7.D
            r9.setVisibility(r1)
            r8.get(r2)
            androidx.fragment.app.j r8 = r7.getSupportFragmentManager()
            java.lang.String r9 = "bankCard"
            androidx.fragment.app.Fragment r8 = r8.c((java.lang.String) r9)
            if (r8 != 0) goto L_0x0112
            java.lang.String r8 = "UpiLanding"
            net.one97.paytm.upi.registration.view.v r8 = net.one97.paytm.upi.registration.view.v.a((java.lang.String) r8, (boolean) r2)
            androidx.fragment.app.j r0 = r7.getSupportFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            int r1 = net.one97.paytm.upi.R.id.fl_bank_container
            androidx.fragment.app.q r8 = r0.b(r1, r8, r9)
            r8.c()
        L_0x0112:
            return
        L_0x0113:
            r7.a((net.one97.paytm.upi.common.UpiCustomVolleyError) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.view.UpiLandingPageActivity.a(java.util.List, java.util.List):void");
    }

    public final void a() {
        AnimationFactory.startWalletLoader(this.k);
        this.l.setVisibility(8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 30) {
            if (i3 == -1) {
                finish();
            }
        } else if (i2 == 5001) {
            if (i3 == -1) {
                this.p.a();
            }
        } else if (i2 == 31) {
            if (i3 == -1) {
                this.p.a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
            }
        } else if (i2 == 33) {
            if (i3 == -1) {
                this.w = true;
                e();
            }
        } else if (i2 == 34) {
            if (i3 == -1) {
                this.u = true;
                e();
            }
        } else if (i2 == 35) {
            if (i3 == -1) {
                if (intent != null) {
                    this.u = intent.getBooleanExtra("launch_account_detail", false);
                    this.y = (BankAccountDetails.BankAccount) intent.getSerializableExtra(UpiConstants.EXTRA_SELECTED_BANK);
                }
                e();
            }
        } else if (i2 == 36) {
            if (i3 == -1) {
                getSupportFragmentManager().a("upi_reactivate");
                this.x = false;
                invalidateOptionsMenu();
                this.p.a(this.x);
                this.p.e();
                this.n.setVisibility(8);
                this.j.setVisibility(8);
                this.f68751e.setVisibility(0);
                this.f68750d.setVisibility(0);
                if (!TextUtils.isEmpty(this.v)) {
                    i.a().m.a((Activity) this, this.v);
                    finish();
                } else if (this.f68748b != -1) {
                    Intent intent2 = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
                    intent2.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
                    androidx.localbroadcastmanager.a.a.a((Context) this).a(intent2);
                    androidx.localbroadcastmanager.a.a.a((Context) this).a(new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_UPI_ACCOUNTS));
                    setResult(-1, getIntent());
                    finish();
                }
            }
        } else if (i2 == 37 && i3 == -1) {
            e();
            this.G = Boolean.TRUE;
            Boolean bool = Boolean.FALSE;
            final CustomSnackbar build = CustomSnackbar.Builder(this).layout(R.layout.layout_upi_snack_bar).background(R.color.upi_pin_green).swipe(true).build(findViewById(R.id.main_content));
            if (bool.booleanValue()) {
                build.duration(CustomSnackbar.LENGTH.INDEFINITE);
            } else {
                build.duration(CustomSnackbar.LENGTH.SHORT);
            }
            build.show();
            boolean booleanExtra = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_MPIN_SET, false);
            String stringExtra = getIntent().getStringExtra(UpiConstants.EXTRA_ACCOUNT_TYPE_LINKED);
            TextView textView = (TextView) build.getContentView().findViewById(R.id.tv_snack_bar_title);
            TextView textView2 = (TextView) build.getContentView().findViewById(R.id.tv_snack_bar_message);
            Button button = (Button) build.getContentView().findViewById(R.id.btn_action);
            if (!TextUtils.isEmpty(stringExtra) && UpiConstants.BANK_ACCOUNT_TYPE.valueOf(stringExtra) == UpiConstants.BANK_ACCOUNT_TYPE.UOD) {
                textView.setText(getString(R.string.upi_uod_bank_link_title));
                textView2.setText(Html.fromHtml(getString(R.string.upi_uod_bank_link_message)));
                button.setText(getString(R.string.upi_ok));
            } else if (booleanExtra) {
                textView.setText(getString(R.string.upi_congratulations_text));
                textView2.setText(getString(R.string.upi_success_add_bank_mpin));
                button.setText(getString(R.string.upi_ok));
            } else if (this.G.booleanValue()) {
                textView.setText(getString(R.string.upi_congratulations_text));
                textView2.setText(getString(R.string.upi_vpa_updated_success));
                button.setText(getString(R.string.upi_ok));
                this.G = Boolean.FALSE;
            } else {
                build.getContentView().setBackgroundColor(androidx.core.content.b.c(getApplicationContext(), R.color.anchor_tag_bg));
                textView.setTextColor(androidx.core.content.b.c(getApplicationContext(), R.color.color_222222));
                textView.setText(getString(R.string.upi_pin_not_set_title));
                textView2.setTextColor(androidx.core.content.b.c(getApplicationContext(), R.color.color_222222));
                textView2.setText(getString(R.string.upi_pin_not_set_message));
                button.setBackground(androidx.core.content.b.a(getApplicationContext(), R.drawable.border_upi_black_pale_yellow));
                button.setTextColor(androidx.core.content.b.c(getApplicationContext(), R.color.color_222222));
                button.setText(getString(R.string.upi_ok));
            }
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    build.dismiss();
                }
            });
        } else if (i2 == 38 && i3 == -1) {
            net.one97.paytm.upi.passbook.view.a aVar = new net.one97.paytm.upi.passbook.view.a();
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, (Serializable) null);
            bundle.putInt(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal());
            aVar.setArguments(bundle);
            getSupportFragmentManager().a().a((Fragment) (net.one97.paytm.upi.passbook.view.a) getSupportFragmentManager().c(R.id.fl_pending_container)).a(R.id.fl_pending_container, aVar, SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING).c();
            findViewById(R.id.fl_pending_container).setVisibility(4);
        }
    }

    public final void a(int i2) {
        c.a aVar = new c.a(this);
        aVar.b((CharSequence) getString(R.string.upi_vpa_limit_error, new Object[]{Integer.valueOf(i2)}));
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        aVar.b();
    }

    public final void b() {
        ProfileCreateVpaActivity.a((Activity) this);
    }

    public final void e() {
        f.a aVar = this.p;
        if (aVar != null) {
            aVar.e();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.A) {
            this.A = false;
            Intent intent = new Intent();
            intent.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_TAB_CHANGED);
            intent.putExtra(UpiConstants.EXTRA_RELOAD_UPI_TRANSACTIONS, true);
            androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.B) {
            this.B = false;
            Intent intent = new Intent();
            intent.setAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_TAB_CHANGED);
            intent.putExtra(UpiConstants.EXTRA_RELOAD_UPI_PENDING_REQUESTS, true);
            androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
        }
    }

    public final void c() {
        String string = getString(R.string.upi_deleting_profile);
        this.s = new ProgressDialog(this);
        this.s.setMessage(string);
        this.s.setCancelable(false);
        this.s.show();
    }

    public final void d() {
        androidx.localbroadcastmanager.a.a.a((Context) this).a(new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_UPI_ACCOUNTS));
        Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
        intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, false);
        androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
        k();
        c.a aVar = new c.a(this);
        aVar.a(false);
        aVar.b(R.string.upi_post_deregister_msg);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                UpiLandingPageActivity.this.finish();
            }
        });
        aVar.b();
    }

    public final void a(String str, String str2) {
        k();
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(str2) || "410".equalsIgnoreCase(str2)) {
            k kVar = i.a().k;
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getName();
            kVar.e(this);
        } else if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
        } else if (TextUtils.isEmpty(str2) || !"1006".equals(str2)) {
            Toast.makeText(this, str, 1).show();
        } else {
            b(5001);
        }
    }

    private void k() {
        ProgressDialog progressDialog = this.s;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.s.dismiss();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        BankVpaCreationActivity.a((Activity) this, accountProvider, str, 34);
    }

    private void b(int i2) {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", i2);
        startActivityForResult(intent, i2);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.E != null) {
            androidx.localbroadcastmanager.a.a.a((Context) this).a(this.E);
            this.E = null;
        }
        if (this.f68747a != null) {
            androidx.localbroadcastmanager.a.a.a((Context) this).a(this.f68747a);
            this.f68747a = null;
        }
    }

    private int l() {
        return getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0);
    }

    public void onBackPressed() {
        if (l() == UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal()) {
            Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
            intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
            androidx.localbroadcastmanager.a.a.a((Context) this).a(intent);
        }
        finish();
    }
}
