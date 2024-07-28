package net.one97.paytm.acceptPayment.home;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.z;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.business.common_module.utilities.LogUtility;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.DateUtility;
import com.business.merchant_payments.common.utility.DialogUtility;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.MpSharedPreferences;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.business.merchant_payments.common.view.CommonOverlayDialogFragment;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.business.merchant_payments.event.AcceptPaymentSettingsChangedEvent;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.model.kyc.Kyc;
import com.business.merchant_payments.model.kyc.KycBankInfoModel;
import com.business.merchant_payments.model.user.UserDetails;
import com.business.merchant_payments.newhome.AcceptPaymentViewModel;
import com.business.merchant_payments.newhome.FetchKycBankInfoViewModel;
import com.business.merchant_payments.newhome.FetchUserViewModel;
import com.business.merchant_payments.newhome.HomeRVListener;
import com.business.merchant_payments.newhome.QrBottomSheet;
import com.business.merchant_payments.newhome.QrViewModel;
import com.business.merchant_payments.newhome.listener.IAcceptPaymentMainActivityListener;
import com.business.merchant_payments.payment.model.QRGridItemClickEvent;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.ups.UPSDataProvider;
import com.business.merchant_payments.ups.UPSManager;
import com.business.merchant_payments.utility.ScreenShotDetectorUtil;
import com.business.merchant_payments.utility.UIUtilityMPKt;
import com.business.merchant_payments.whatsappconsent.UpsUtility;
import com.business.merchant_payments.whatsappconsent.WhatsAppConsentBottomSheetFragment;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.PaymentAcceptanceHoldBottomSheet;
import com.paytm.business.merchantprofile.view.ProfileBusinessDetailsActivity;
import com.squareup.picasso.aa;
import com.squareup.picasso.w;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.home.b;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.greenrobot.eventbus.ThreadMode;

public final class AcceptPaymentMainActivity extends BaseActivity implements CommonOverlayDialogFragment.CommonOverlayDialogListener, IAcceptPaymentMainActivityListener, ScreenShotDetectorUtil.ScreenshotDetectionListener, PaymentAcceptanceHoldBottomSheet.PaymentAcceptanceHoldBottomSheetListener {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.acceptPayment.a.e f52066a;

    /* renamed from: b  reason: collision with root package name */
    private AcceptPaymentViewModel f52067b;

    /* renamed from: c  reason: collision with root package name */
    private Snackbar f52068c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.acceptPayment.a.g f52069d;

    /* renamed from: e  reason: collision with root package name */
    private FetchKycBankInfoViewModel f52070e;

    /* renamed from: f  reason: collision with root package name */
    private BottomsheetManager f52071f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f52072g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52073h;

    /* renamed from: i  reason: collision with root package name */
    private QrViewModel f52074i;
    private InactiveMerchantListener j;
    private final z<com.business.common_module.utilities.a.b<UserDetails>> k = new h(this);
    private final z<com.business.common_module.utilities.a.b<KycBankInfoModel>> l = new f(this);

    public final void closeDrawer() {
    }

    static final class f<T> implements z<com.business.common_module.utilities.a.b<KycBankInfoModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52080a;

        f(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52080a = acceptPaymentMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.business.common_module.utilities.a.b bVar = (com.business.common_module.utilities.a.b) obj;
            AcceptPaymentMainActivity acceptPaymentMainActivity = this.f52080a;
            k.b(bVar, "it");
            AcceptPaymentMainActivity.a(acceptPaymentMainActivity, bVar);
        }
    }

    static final class h<T> implements z<com.business.common_module.utilities.a.b<UserDetails>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52082a;

        h(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52082a = acceptPaymentMainActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.business.common_module.utilities.a.b bVar = (com.business.common_module.utilities.a.b) obj;
            if (bVar.f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
                String userPicture = ((UserDetails) bVar.f7358c).getDefaultInfo().getUserPicture();
                net.one97.paytm.acceptPayment.d.a aVar = net.one97.paytm.acceptPayment.d.a.f52050a;
                net.one97.paytm.acceptPayment.d.a.b(((UserDetails) bVar.f7358c).getDefaultInfo().getDisplayName());
                if (!TextUtils.isEmpty(userPicture)) {
                    w.a().a(userPicture).a().a((ImageView) AcceptPaymentMainActivity.c(this.f52082a).f51990d);
                    net.one97.paytm.acceptPayment.d.a aVar2 = net.one97.paytm.acceptPayment.d.a.f52050a;
                    net.one97.paytm.acceptPayment.d.a.c(userPicture);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.acceptPayment.a.g c(AcceptPaymentMainActivity acceptPaymentMainActivity) {
        net.one97.paytm.acceptPayment.a.g gVar = acceptPaymentMainActivity.f52069d;
        if (gVar == null) {
            k.a("actionBarLytBinding");
        }
        return gVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.ap_accept_payment_main);
        k.b(a2, "DataBindingUtil.setConte…t.ap_accept_payment_main)");
        this.f52066a = (net.one97.paytm.acceptPayment.a.e) a2;
        ai a3 = new al(this).a(AcceptPaymentViewModel.class);
        k.b(a3, "ViewModelProvider(this).…entViewModel::class.java)");
        this.f52067b = (AcceptPaymentViewModel) a3;
        ai a4 = new al(this).a(QrViewModel.class);
        k.b(a4, "ViewModelProvider(this).…(QrViewModel::class.java)");
        this.f52074i = (QrViewModel) a4;
        this.f52071f = new BottomsheetManager(getLifecycle(), new WeakReference(this));
        org.greenrobot.eventbus.c.a().a((Object) this);
        if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
            BottomsheetManager bottomsheetManager = this.f52071f;
            if (bottomsheetManager == null) {
                k.a("homeDialogsManager");
            }
            Intent intent = getIntent();
            if (!net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
                bottomsheetManager.f52083a.handleBusinessDialogOnOtherBottomsheets();
                bottomsheetManager.f52083a.showAccountDeactivateBottomSheet();
            } else if (intent != null && intent.hasExtra("featuretype") && p.a(intent.getStringExtra("featuretype"), "verify_qr", true)) {
                bottomsheetManager.f52083a.handleBusinessDialogOnOtherBottomsheets();
                org.greenrobot.eventbus.c.a().c(new d(true));
            } else if (intent != null && intent.hasExtra("featuretype") && p.a(intent.getStringExtra("featuretype"), "view_qr", true)) {
                bottomsheetManager.f52083a.handleBusinessDialogOnOtherBottomsheets();
                org.greenrobot.eventbus.c.a().c(new d(false));
            } else if (intent != null && intent.hasExtra("featuretype") && p.a(intent.getStringExtra("featuretype"), DeepLinkConstant.FEATURES.KEY_WHATSAPP_BOTTOM_SHEET_LAUNCH, true)) {
                bottomsheetManager.f52083a.handleBusinessDialogOnOtherBottomsheets();
                bottomsheetManager.f52083a.launchWhatsAppConsentBottomSheet();
            } else if (intent == null || !intent.hasExtra("featuretype") || !p.a(intent.getStringExtra("featuretype"), DeepLinkConstant.FEATURES.KEY_WHATSAPP_CONSENT_ACTIVATE, true)) {
                bottomsheetManager.f52083a.showOptionDialogToGrowBusiness();
            } else {
                bottomsheetManager.f52083a.handleBusinessDialogOnOtherBottomsheets();
                FragmentActivity fragmentActivity = (FragmentActivity) bottomsheetManager.f52084b.get();
                if (fragmentActivity != null) {
                    UpsUtility.statusRecieved(fragmentActivity);
                }
            }
        }
        androidx.lifecycle.k lifecycle = getLifecycle();
        k.b(lifecycle, "lifecycle");
        new ScreenShotDetectorUtil(this, this, lifecycle);
        ViewDataBinding a5 = androidx.databinding.f.a(getLayoutInflater(), R.layout.ap_action_bar_lyt, (ViewGroup) null, false);
        k.b(a5, "DataBindingUtil.inflate(…ion_bar_lyt, null, false)");
        this.f52069d = (net.one97.paytm.acceptPayment.a.g) a5;
        net.one97.paytm.acceptPayment.a.e eVar = this.f52066a;
        if (eVar == null) {
            k.a("mBinding");
        }
        setSupportActionBar(eVar.f51983d);
        net.one97.paytm.acceptPayment.a.g gVar = this.f52069d;
        if (gVar == null) {
            k.a("actionBarLytBinding");
        }
        TextView textView = gVar.f51994h;
        k.b(textView, "actionBarLytBinding.headerName");
        textView.setText(APSharedPreferences.getInstance().getMerchantDisplayName(this));
        net.one97.paytm.acceptPayment.a.g gVar2 = this.f52069d;
        if (gVar2 == null) {
            k.a("actionBarLytBinding");
        }
        gVar2.f51990d.setOnClickListener(new a(this));
        net.one97.paytm.acceptPayment.a.g gVar3 = this.f52069d;
        if (gVar3 == null) {
            k.a("actionBarLytBinding");
        }
        gVar3.f51989c.setOnClickListener(new b(this));
        net.one97.paytm.acceptPayment.a.e eVar2 = this.f52066a;
        if (eVar2 == null) {
            k.a("mBinding");
        }
        eVar2.f51983d.setContentInsetsAbsolute(0, 0);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b();
            supportActionBar.a();
            net.one97.paytm.acceptPayment.a.g gVar4 = this.f52069d;
            if (gVar4 == null) {
                k.a("actionBarLytBinding");
            }
            supportActionBar.a(gVar4.getRoot(), new ActionBar.LayoutParams());
        }
        APSharedPreferences instance = APSharedPreferences.getInstance();
        k.b(instance, "APSharedPreferences.getInstance()");
        if (instance.isMerchantMigrated()) {
            net.one97.paytm.acceptPayment.a.g gVar5 = this.f52069d;
            if (gVar5 == null) {
                k.a("actionBarLytBinding");
            }
            ShimmerFrameLayout shimmerFrameLayout = gVar5.k;
            k.b(shimmerFrameLayout, "actionBarLytBinding.rewardPointsShimmer");
            shimmerFrameLayout.setVisibility(0);
            net.one97.paytm.acceptPayment.a.g gVar6 = this.f52069d;
            if (gVar6 == null) {
                k.a("actionBarLytBinding");
            }
            gVar6.k.startShimmer();
        }
        net.one97.paytm.acceptPayment.a.g gVar7 = this.f52069d;
        if (gVar7 == null) {
            k.a("actionBarLytBinding");
        }
        gVar7.f51987a.setOnClickListener(new c(this));
        net.one97.paytm.acceptPayment.a.g gVar8 = this.f52069d;
        if (gVar8 == null) {
            k.a("actionBarLytBinding");
        }
        gVar8.f51994h.setOnClickListener(d.f52078a);
        net.one97.paytm.acceptPayment.a.g gVar9 = this.f52069d;
        if (gVar9 == null) {
            k.a("actionBarLytBinding");
        }
        gVar9.j.setOnClickListener(new e(this));
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            k.b(window, "window");
            if (Build.VERSION.SDK_INT >= 23) {
                View decorView = window.getDecorView();
                k.b(decorView, "window.decorView");
                decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                window.setStatusBarColor(androidx.core.content.b.c(this, R.color.ap_color_0762c0));
            } else {
                window.setStatusBarColor(androidx.core.content.b.c(this, R.color.ap_color_0762c0));
                View decorView2 = window.getDecorView();
                k.b(decorView2, "window.decorView");
                decorView2.setSystemUiVisibility(0);
            }
        }
        APSharedPreferences instance2 = APSharedPreferences.getInstance();
        k.b(instance2, "APSharedPreferences.getInstance()");
        APSharedPreferences instance3 = APSharedPreferences.getInstance();
        k.b(instance3, "APSharedPreferences.getInstance()");
        instance2.setAppOpenCount(instance3.getAppOpenCount() + 1);
        APSharedPreferences instance4 = APSharedPreferences.getInstance();
        k.b(instance4, "APSharedPreferences.getInstance()");
        long appOpeningTime = instance4.getAppOpeningTime();
        long currentTimeMillis = System.currentTimeMillis();
        APSharedPreferences.getInstance().saveAppOpeningTime(currentTimeMillis);
        int daysBetweenDates = DateUtility.getDaysBetweenDates(appOpeningTime, currentTimeMillis);
        APSharedPreferences instance5 = APSharedPreferences.getInstance();
        APSharedPreferences instance6 = APSharedPreferences.getInstance();
        k.b(instance6, "APSharedPreferences.getInstance()");
        instance5.setLastSeenDialogCount(instance6.getLastSeenDialogcount() + daysBetweenDates);
        if (!MpSharedPreferences.getWhatAppConsent(getApplication())) {
            Application application = getApplication();
            k.b(application, "application");
            if (UpsUtility.shouldShowRateUsBottomSheet(application)) {
                APSharedPreferences instance7 = APSharedPreferences.getInstance();
                k.b(instance7, "APSharedPreferences.getInstance()");
                instance7.setAppOpenCount(0);
                APSharedPreferences.getInstance().setLastSeenDialogCount(0);
                APSharedPreferences instance8 = APSharedPreferences.getInstance();
                k.b(instance8, "APSharedPreferences.getInstance()");
                instance8.setUserSeenDialog(true);
                WhatsAppConsentBottomSheetFragment whatsAppConsentBottomSheetFragment = new WhatsAppConsentBottomSheetFragment();
                whatsAppConsentBottomSheetFragment.setCancelable(true);
                j supportFragmentManager = getSupportFragmentManager();
                k.b(supportFragmentManager, "supportFragmentManager");
                whatsAppConsentBottomSheetFragment.show(supportFragmentManager, "whatsup_consent_bottomsheet");
            }
        }
        com.business.common_module.utilities.a.c provideViewModel = provideViewModel(FetchKycBankInfoViewModel.class, (Fragment) null);
        k.b(provideViewModel, "provideViewModel(FetchKy…wModel::class.java, null)");
        FetchKycBankInfoViewModel fetchKycBankInfoViewModel = (FetchKycBankInfoViewModel) provideViewModel;
        this.f52070e = fetchKycBankInfoViewModel;
        if (fetchKycBankInfoViewModel == null) {
            k.a("kycBankInfoViewModel");
        }
        fetchKycBankInfoViewModel.getKycBanInfoLiveData().observe(this, this.l);
        UPSManager instance9 = UPSManager.Companion.getInstance();
        Application application2 = getApplication();
        k.b(application2, "application");
        instance9.init(application2, (UPSDataProvider.UPSResponseListener) null);
        b.a aVar = b.f52094b;
        Intent intent2 = getIntent();
        k.b(intent2, "intent");
        Bundle extras = intent2.getExtras();
        b bVar = new b();
        if (extras != null) {
            bVar.setArguments(extras);
        }
        int i2 = R.id.fragment_container;
        String simpleName = b.class.getSimpleName();
        k.b(simpleName, "AcceptPaymentFragment::class.java.simpleName");
        changeFragment(i2, bVar, simpleName);
        if (i.a(getApplication())) {
            ai a6 = new al(this).a(FetchUserViewModel.class);
            k.b(a6, "ViewModelProvider(this).…serViewModel::class.java)");
            FetchUserViewModel fetchUserViewModel = (FetchUserViewModel) a6;
            fetchUserViewModel.getUserDataObserver().observe(this, this.k);
            fetchUserViewModel.fetchUserDetails();
        }
        a(false);
        PaymentsConfig.getInstance();
    }

    public final void changeFragment(int i2, Fragment fragment, String str) {
        k.d(fragment, "fragment");
        k.d(str, "tag");
        getSupportFragmentManager().a().b(i2, fragment, str).a(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).c();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52075a;

        a(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52075a = acceptPaymentMainActivity;
        }

        public final void onClick(View view) {
            this.f52075a.startActivity(new Intent(this.f52075a, ProfileBusinessDetailsActivity.class));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52076a;

        b(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52076a = acceptPaymentMainActivity;
        }

        public final void onClick(View view) {
            this.f52076a.onBackPressed();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52077a;

        c(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52077a = acceptPaymentMainActivity;
        }

        public final void onClick(View view) {
            GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            singleInstance.sendEvent(instance.getAppContext(), "HomePage", "SettlementAccountClicked", "", net.one97.paytm.acceptPayment.d.a.f52050a.F() ? P4BSettlementsDataHelperMP.MERCHANT_TYPE_BW_GA : "OS");
            AcceptPaymentMainActivity.b(this.f52077a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f52078a = new d();

        d() {
        }

        public final void onClick(View view) {
            GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            singleInstance.sendEvent(instance.getAppContext(), "HomePage", "UserNameClicked", "", "");
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52079a;

        e(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52079a = acceptPaymentMainActivity;
        }

        public final void onClick(View view) {
            GAGTMTagAnalytics singleInstance = GAGTMTagAnalytics.getSingleInstance();
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            singleInstance.sendEvent(instance.getAppContext(), "HomePage", "RewardPointClicked", "", "");
            PaymentsConfig.getInstance().deepLinkUtils.a(this.f52079a, GTMDataProviderImpl.Companion.getMInstance().getString(PaymentsGTMConstants.KEY_MERCHANT_POINTS_DEEPLINK, ""));
        }
    }

    public static final class g implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AcceptPaymentMainActivity f52081a;

        public final void onError(Exception exc) {
        }

        g(AcceptPaymentMainActivity acceptPaymentMainActivity) {
            this.f52081a = acceptPaymentMainActivity;
        }

        public final void onSuccess() {
            ImageView imageView = AcceptPaymentMainActivity.c(this.f52081a).f51992f;
            k.b(imageView, "actionBarLytBinding.headerBankIcon");
            imageView.setBackground((Drawable) null);
        }
    }

    private final void a() {
        Fragment c2 = getSupportFragmentManager().c(QrBottomSheet.class.getSimpleName());
        if (!(c2 instanceof QrBottomSheet)) {
            c2 = null;
        }
        QrBottomSheet qrBottomSheet = (QrBottomSheet) c2;
        if (qrBottomSheet != null && qrBottomSheet.isVisible()) {
            qrBottomSheet.showVerifyQrPopup();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
    }

    @org.greenrobot.eventbus.j(a = ThreadMode.MAIN)
    public final void onAcceptPaymentSettingsChangedEvent(AcceptPaymentSettingsChangedEvent acceptPaymentSettingsChangedEvent) {
        k.d(acceptPaymentSettingsChangedEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        this.f52072g = true;
        this.f52073h = acceptPaymentSettingsChangedEvent.isContextRequired;
    }

    private final void a(boolean z) {
        if (i.a(PaymentsConfig.getInstance().application)) {
            net.one97.paytm.acceptPayment.a.g gVar = this.f52069d;
            if (gVar == null) {
                k.a("actionBarLytBinding");
            }
            LinearLayout linearLayout = gVar.f51987a;
            k.b(linearLayout, "actionBarLytBinding.accountArea");
            linearLayout.setVisibility(8);
            net.one97.paytm.acceptPayment.a.g gVar2 = this.f52069d;
            if (gVar2 == null) {
                k.a("actionBarLytBinding");
            }
            ShimmerFrameLayout shimmerFrameLayout = gVar2.f51988b;
            k.b(shimmerFrameLayout, "actionBarLytBinding.accountAreaShimmer");
            shimmerFrameLayout.setVisibility(0);
            net.one97.paytm.acceptPayment.a.g gVar3 = this.f52069d;
            if (gVar3 == null) {
                k.a("actionBarLytBinding");
            }
            gVar3.f51988b.startShimmer();
            FetchKycBankInfoViewModel fetchKycBankInfoViewModel = this.f52070e;
            if (fetchKycBankInfoViewModel == null) {
                k.a("kycBankInfoViewModel");
            }
            fetchKycBankInfoViewModel.fetchKycBankInfo(z);
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.f52072g) {
            a(this.f52073h);
            this.f52072g = false;
            this.f52073h = false;
        }
    }

    public final void updateRewardPoints(String str) {
        k.d(str, "points");
        net.one97.paytm.acceptPayment.a.g gVar = this.f52069d;
        if (gVar == null) {
            k.a("actionBarLytBinding");
        }
        gVar.k.stopShimmer();
        ShimmerFrameLayout shimmerFrameLayout = gVar.k;
        k.b(shimmerFrameLayout, "rewardPointsShimmer");
        shimmerFrameLayout.setVisibility(8);
        TextView textView = gVar.j;
        k.b(textView, "rewardPoints");
        textView.setVisibility(0);
        TextView textView2 = gVar.j;
        k.b(textView2, "rewardPoints");
        textView2.setText(str);
    }

    public final void onRefresh() {
        Snackbar snackbar = this.f52068c;
        if (snackbar != null) {
            snackbar.d();
        }
        this.f52068c = null;
    }

    public final void showQR(boolean z) {
        QrViewModel qrViewModel = this.f52074i;
        if (qrViewModel == null) {
            k.a("qrViewModel");
        }
        QrBottomSheet qrBottomSheet = new QrBottomSheet(qrViewModel);
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(QrBottomSheet.SHOW_VERIFY_QR, z);
            qrBottomSheet.setArguments(bundle);
        }
        qrBottomSheet.show(getSupportFragmentManager(), QrBottomSheet.class.getSimpleName());
    }

    @org.greenrobot.eventbus.j(a = ThreadMode.MAIN, b = true)
    public final void onQRGridItemClickEvent(QRGridItemClickEvent qRGridItemClickEvent) {
        k.d(qRGridItemClickEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        if (p.a((CharSequence) qRGridItemClickEvent.getDeeplink(), (CharSequence) "view_qr", false)) {
            showQR(false);
            return;
        }
        net.one97.paytm.acceptPayment.configs.a a2 = net.one97.paytm.acceptPayment.configs.a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        a2.b().a((Context) this, qRGridItemClickEvent.getDeeplink());
    }

    public final void initialiseInactiveMerchantListener(InactiveMerchantListener inactiveMerchantListener) {
        k.d(inactiveMerchantListener, "listener");
        this.j = inactiveMerchantListener;
    }

    public final void removeBasicInfoObserver(z<com.business.common_module.utilities.a.b<KycBankInfoModel>> zVar) {
        k.d(zVar, "observer");
        FetchKycBankInfoViewModel fetchKycBankInfoViewModel = this.f52070e;
        if (fetchKycBankInfoViewModel == null) {
            k.a("kycBankInfoViewModel");
        }
        fetchKycBankInfoViewModel.getKycBanInfoLiveData().removeObserver(zVar);
    }

    public final void addBasicInfoObserver(z<com.business.common_module.utilities.a.b<KycBankInfoModel>> zVar) {
        k.d(zVar, "observer");
        FetchKycBankInfoViewModel fetchKycBankInfoViewModel = this.f52070e;
        if (fetchKycBankInfoViewModel == null) {
            k.a("kycBankInfoViewModel");
        }
        fetchKycBankInfoViewModel.getKycBanInfoLiveData().observe(this, zVar);
    }

    public final void onScreenCaptured(String str) {
        k.d(str, H5TabbarUtils.MATCH_TYPE_PATH);
        if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
            a();
        }
    }

    public final void onScreenCapturedWithDeniedPermission() {
        if (net.one97.paytm.acceptPayment.d.a.f52050a.c()) {
            a();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.d(strArr, "permissions");
        k.d(iArr, "grantResults");
        if ((!(iArr.length == 0)) && iArr[0] == 0) {
            QrBottomSheet qrBottomSheet = null;
            if (i2 == 201) {
                Fragment c2 = getSupportFragmentManager().c(QrBottomSheet.class.getSimpleName());
                if (c2 instanceof QrBottomSheet) {
                    qrBottomSheet = c2;
                }
                if (((QrBottomSheet) qrBottomSheet) != null) {
                    ((QrBottomSheet) c2).onQRPermissionGranted(true);
                }
            } else if (i2 == 202) {
                Fragment c3 = getSupportFragmentManager().c(QrBottomSheet.class.getSimpleName());
                if (c3 instanceof QrBottomSheet) {
                    qrBottomSheet = c3;
                }
                if (qrBottomSheet != null) {
                    ((QrBottomSheet) c3).onQRPermissionGranted(false);
                }
            }
        } else if (i2 == 201 || i2 == 202) {
            DialogUtility.showAlert(this, "", getString(R.string.mp_go_to_settings_storage));
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void onDialogButtonClick() {
        PaymentsConfig.getInstance().deepLinkUtils.a(this, "paytmba://business-app/h/limits-and-charges/upgrade-limits");
    }

    public final void showInactiveMerchantBottomSheet() {
        if (getSupportFragmentManager().c(PaymentAcceptanceHoldBottomSheet.TAG) == null) {
            PaymentAcceptanceHoldBottomSheet paymentAcceptanceHoldBottomSheet = new PaymentAcceptanceHoldBottomSheet();
            paymentAcceptanceHoldBottomSheet.setCancelable(false);
            paymentAcceptanceHoldBottomSheet.show(getSupportFragmentManager(), PaymentAcceptanceHoldBottomSheet.TAG);
        }
    }

    public final void closeInactiveMerchantBottomSheet() {
        try {
            Fragment c2 = getSupportFragmentManager().c(PaymentAcceptanceHoldBottomSheet.TAG);
            if (c2 != null && (c2 instanceof PaymentAcceptanceHoldBottomSheet)) {
                ((PaymentAcceptanceHoldBottomSheet) c2).dismiss();
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public final InactiveMerchantListener getInactiveMerchantListener() {
        InactiveMerchantListener inactiveMerchantListener = this.j;
        if (inactiveMerchantListener == null) {
            k.a("inactiveMerchantListener");
        }
        return inactiveMerchantListener;
    }

    public static final /* synthetic */ void b(AcceptPaymentMainActivity acceptPaymentMainActivity) {
        acceptPaymentMainActivity.f52072g = true;
        PaymentsConfig.getInstance().deepLinkUtils.a(acceptPaymentMainActivity, "paytmba://business-app/ump-web?url=" + GTMDataProviderImpl.Companion.getMInstance().getUMPBaseUrl() + GTMDataProviderImpl.Companion.getMInstance().getString(PaymentsGTMConstants.SETTLEMENT_SETTINGS_URL, ""));
    }

    public static final /* synthetic */ void a(AcceptPaymentMainActivity acceptPaymentMainActivity, com.business.common_module.utilities.a.b bVar) {
        T t;
        if (bVar.f7357b != com.business.common_module.utilities.a.e.LOADING) {
            net.one97.paytm.acceptPayment.a.g gVar = acceptPaymentMainActivity.f52069d;
            if (gVar == null) {
                k.a("actionBarLytBinding");
            }
            ShimmerFrameLayout shimmerFrameLayout = gVar.f51988b;
            k.b(shimmerFrameLayout, "actionBarLytBinding.accountAreaShimmer");
            shimmerFrameLayout.setVisibility(8);
            net.one97.paytm.acceptPayment.a.g gVar2 = acceptPaymentMainActivity.f52069d;
            if (gVar2 == null) {
                k.a("actionBarLytBinding");
            }
            gVar2.f51988b.stopShimmer();
            if (bVar.f7357b == com.business.common_module.utilities.a.e.SUCCESS && (t = bVar.f7358c) != null && (!((KycBankInfoModel) t).getResults().getKyc().isEmpty())) {
                if (!(((KycBankInfoModel) bVar.f7358c).getResults().getUpdatedContext() == null || ((KycBankInfoModel) bVar.f7358c).getResults().getUpdatedContext().getRoles() == null)) {
                    com.business.common_module.e.b updatedContext = ((KycBankInfoModel) bVar.f7358c).getResults().getUpdatedContext();
                    net.one97.paytm.acceptPayment.d.a aVar = net.one97.paytm.acceptPayment.d.a.f52050a;
                    net.one97.paytm.acceptPayment.d.a.b(updatedContext);
                    net.one97.paytm.acceptPayment.d.a.f52050a.a(updatedContext);
                    Fragment c2 = acceptPaymentMainActivity.getSupportFragmentManager().c(b.class.getSimpleName());
                    if (c2 != null) {
                        b bVar2 = (b) c2;
                        a aVar2 = bVar2.f52096d;
                        if (aVar2 == null) {
                            k.a("mViewModel");
                        }
                        if (!aVar2.isPaymentsTabSelected().get()) {
                            HomeRVListener homeRVListener = bVar2.f52097e;
                            if (homeRVListener == null) {
                                k.a("mHomeRvListener");
                            }
                            homeRVListener.onSettlementTabClick();
                        }
                    }
                }
                Kyc kyc = ((KycBankInfoModel) bVar.f7358c).getResults().getKyc().get(0);
                net.one97.paytm.acceptPayment.a.g gVar3 = acceptPaymentMainActivity.f52069d;
                if (gVar3 == null) {
                    k.a("actionBarLytBinding");
                }
                LinearLayout linearLayout = gVar3.f51987a;
                k.b(linearLayout, "actionBarLytBinding.accountArea");
                linearLayout.setVisibility(0);
                net.one97.paytm.acceptPayment.a.g gVar4 = acceptPaymentMainActivity.f52069d;
                if (gVar4 == null) {
                    k.a("actionBarLytBinding");
                }
                TextView textView = gVar4.f51991e;
                k.b(textView, "actionBarLytBinding.headerAccount");
                textView.setText(UIUtilityMPKt.getDisplayBankAccountNumberMP(kyc.getBankAccountNumber(), 8, 4));
                net.one97.paytm.acceptPayment.a.g gVar5 = acceptPaymentMainActivity.f52069d;
                if (gVar5 == null) {
                    k.a("actionBarLytBinding");
                }
                TextView textView2 = gVar5.f51993g;
                k.b(textView2, "actionBarLytBinding.headerBankName");
                textView2.setText(kyc.getBankName());
                aa a2 = w.a().a(kyc.getBankIconUrl()).a();
                net.one97.paytm.acceptPayment.a.g gVar6 = acceptPaymentMainActivity.f52069d;
                if (gVar6 == null) {
                    k.a("actionBarLytBinding");
                }
                a2.a(gVar6.f51992f, (com.squareup.picasso.e) new g(acceptPaymentMainActivity));
            }
        }
    }

    @org.greenrobot.eventbus.j(a = ThreadMode.MAIN)
    public final void onShowQR(d dVar) {
        k.d(dVar, AppConstants.NOTIFICATION_DETAILS.EVENT);
        showQR(dVar.f52123a);
    }
}
