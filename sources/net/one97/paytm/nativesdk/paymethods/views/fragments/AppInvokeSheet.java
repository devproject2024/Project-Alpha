package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.animation.LayoutTransition;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.android.volley.Request;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.common.view.BankOffersBottomSheet;
import net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar;
import net.one97.paytm.nativesdk.paymethods.factory.InstrumentViewModelFactory;
import net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner;
import net.one97.paytm.nativesdk.paymethods.listeners.FetchPayInstrumentsListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;
import net.one97.paytm.nativesdk.paymethods.viewmodel.AppInvokeViewModel;
import net.one97.paytm.nativesdk.paymethods.viewmodel.LoadingInstrumentSheetViewModel;
import net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar;
import net.one97.paytm.nativesdk.widget.CharacterWrapTextView;

public final class AppInvokeSheet extends BaseInstrumentSheet implements CashierInstrumentListner, FetchPayInstrumentsListener, OnBottomSheetChangeListener {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "AppInvokeSheet";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean allInstrumentsVisible;
    /* access modifiers changed from: private */
    public BankOffersBottomSheet bankOffersBottomSheet;
    private ImageView imgCancelSubSheet;
    public LinearLayout instrumentViews;
    private ConstraintLayout mClBankOfferStrip;
    private String mInstrumentPrimaryInfo;
    private String mInstrumentSecondaryInfo;
    public AppInvokeViewModel mInstrumentsViewModel;
    private ImageView mIvBankOfferLogo;
    /* access modifiers changed from: private */
    public ImageView mIvShowOfferArrow;
    public LoadingInstrumentSheetViewModel mLoadingInstrument;
    private OnPayMethodSelectedListener mPayMethodSelectedListener;
    private TextView mTvExclusiveOfferSubHeading;
    private TextView mTvExclusiveOfferText;
    public CustomInstrumentsToolbar mainToolbar;
    private int merchantLogo;
    /* access modifiers changed from: private */
    public List<PaymentInstrumentView> otherInstruments = new ArrayList();
    /* access modifiers changed from: private */
    public View otherPayments;
    public View parentContainer;
    private boolean removeAllViews;
    public NestedScrollView scrollView;
    public ShimmerFrameLayout shimmerLayout;
    public StickyToolbar stickyToolbar;
    private TextView subDetailTitleCustomtbar;
    private TextView subsDetailTitle;
    private TextView subsZeroAmountTitle;

    public static final AppInvokeSheet getInstance(String str, String str2, int i2) {
        return Companion.getInstance(str, str2, i2);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onChangeBottomSheet(String str, boolean z) {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onFetchBalance(String str) {
    }

    public final void onNetworkUnavailable(Request<?> request) {
    }

    public static final /* synthetic */ ImageView access$getMIvShowOfferArrow$p(AppInvokeSheet appInvokeSheet) {
        ImageView imageView = appInvokeSheet.mIvShowOfferArrow;
        if (imageView == null) {
            k.a("mIvShowOfferArrow");
        }
        return imageView;
    }

    public final AppInvokeViewModel getMInstrumentsViewModel() {
        AppInvokeViewModel appInvokeViewModel = this.mInstrumentsViewModel;
        if (appInvokeViewModel == null) {
            k.a("mInstrumentsViewModel");
        }
        return appInvokeViewModel;
    }

    public final void setMInstrumentsViewModel(AppInvokeViewModel appInvokeViewModel) {
        k.c(appInvokeViewModel, "<set-?>");
        this.mInstrumentsViewModel = appInvokeViewModel;
    }

    public final LoadingInstrumentSheetViewModel getMLoadingInstrument() {
        LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel = this.mLoadingInstrument;
        if (loadingInstrumentSheetViewModel == null) {
            k.a("mLoadingInstrument");
        }
        return loadingInstrumentSheetViewModel;
    }

    public final void setMLoadingInstrument(LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel) {
        k.c(loadingInstrumentSheetViewModel, "<set-?>");
        this.mLoadingInstrument = loadingInstrumentSheetViewModel;
    }

    public final CustomInstrumentsToolbar getMainToolbar() {
        CustomInstrumentsToolbar customInstrumentsToolbar = this.mainToolbar;
        if (customInstrumentsToolbar == null) {
            k.a("mainToolbar");
        }
        return customInstrumentsToolbar;
    }

    public final void setMainToolbar(CustomInstrumentsToolbar customInstrumentsToolbar) {
        k.c(customInstrumentsToolbar, "<set-?>");
        this.mainToolbar = customInstrumentsToolbar;
    }

    public final LinearLayout getInstrumentViews() {
        LinearLayout linearLayout = this.instrumentViews;
        if (linearLayout == null) {
            k.a("instrumentViews");
        }
        return linearLayout;
    }

    public final void setInstrumentViews(LinearLayout linearLayout) {
        k.c(linearLayout, "<set-?>");
        this.instrumentViews = linearLayout;
    }

    public final StickyToolbar getStickyToolbar() {
        StickyToolbar stickyToolbar2 = this.stickyToolbar;
        if (stickyToolbar2 == null) {
            k.a("stickyToolbar");
        }
        return stickyToolbar2;
    }

    public final void setStickyToolbar(StickyToolbar stickyToolbar2) {
        k.c(stickyToolbar2, "<set-?>");
        this.stickyToolbar = stickyToolbar2;
    }

    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            k.a("scrollView");
        }
        return nestedScrollView;
    }

    public final void setScrollView(NestedScrollView nestedScrollView) {
        k.c(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final ShimmerFrameLayout getShimmerLayout() {
        ShimmerFrameLayout shimmerFrameLayout = this.shimmerLayout;
        if (shimmerFrameLayout == null) {
            k.a("shimmerLayout");
        }
        return shimmerFrameLayout;
    }

    public final void setShimmerLayout(ShimmerFrameLayout shimmerFrameLayout) {
        k.c(shimmerFrameLayout, "<set-?>");
        this.shimmerLayout = shimmerFrameLayout;
    }

    public final View getParentContainer() {
        View view = this.parentContainer;
        if (view == null) {
            k.a("parentContainer");
        }
        return view;
    }

    public final void setParentContainer(View view) {
        k.c(view, "<set-?>");
        this.parentContainer = view;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        k.c(layoutInflater, "inflater");
        int i2 = 0;
        View inflate = layoutInflater.inflate(R.layout.app_invoke_sheet, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, "")) == null) {
            str = "";
        }
        this.mInstrumentPrimaryInfo = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, "")) == null) {
            str2 = "";
        }
        this.mInstrumentSecondaryInfo = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i2 = arguments3.getInt(SDKConstants.MERCHANT_LOGO, 0);
        }
        this.merchantLogo = i2;
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        setUpUI(view);
        ao aoVar = this;
        String str = this.mInstrumentPrimaryInfo;
        if (str == null) {
            k.a("mInstrumentPrimaryInfo");
        }
        String str2 = this.mInstrumentSecondaryInfo;
        if (str2 == null) {
            k.a("mInstrumentSecondaryInfo");
        }
        OnPayMethodSelectedListener onPayMethodSelectedListener = this.mPayMethodSelectedListener;
        OnBottomSheetChangeListener onBottomSheetChangeListener = this;
        CashierInstrumentListner cashierInstrumentListner = this;
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ai a2 = new al(aoVar, (al.b) new InstrumentViewModelFactory(str, str2, onPayMethodSelectedListener, onBottomSheetChangeListener, false, "", cashierInstrumentListner, (Application) applicationContext)).a(AppInvokeViewModel.class);
            k.a((Object) a2, "ViewModelProvider(this, …elFactory)[T::class.java]");
            this.mInstrumentsViewModel = (AppInvokeViewModel) a2;
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            if (instance.isFetchPayCallRequired()) {
                this.mLoadingInstrument = new LoadingInstrumentSheetViewModel(getContext(), this);
                if (getActivity() != null) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "activity!!");
                    activity.getWindow().setSoftInputMode(3);
                }
                startProgress();
            } else {
                stopProgress();
                setToolbarValues();
                AppInvokeViewModel appInvokeViewModel = this.mInstrumentsViewModel;
                if (appInvokeViewModel == null) {
                    k.a("mInstrumentsViewModel");
                }
                appInvokeViewModel.addPaymentViews();
            }
            AppInvokeViewModel appInvokeViewModel2 = this.mInstrumentsViewModel;
            if (appInvokeViewModel2 == null) {
                k.a("mInstrumentsViewModel");
            }
            appInvokeViewModel2.getInstrumentViewList().observe(this, new AppInvokeSheet$onViewCreated$2(this));
            setBottomSheetHeight();
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Application");
    }

    private final void setToolbarValues() {
        CustomInstrumentsToolbar customInstrumentsToolbar = this.mainToolbar;
        if (customInstrumentsToolbar == null) {
            k.a("mainToolbar");
        }
        customInstrumentsToolbar.setToolbarValues();
        StickyToolbar stickyToolbar2 = this.stickyToolbar;
        if (stickyToolbar2 == null) {
            k.a("stickyToolbar");
        }
        CustomInstrumentsToolbar customInstrumentsToolbar2 = this.mainToolbar;
        if (customInstrumentsToolbar2 == null) {
            k.a("mainToolbar");
        }
        stickyToolbar2.setToolbarTitle(customInstrumentsToolbar2.getMerchantName().toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void inflatePaymentInstruments(java.util.List<? extends net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "pgInstruments"
            kotlin.g.b.k.c(r7, r0)
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x000c
            return
        L_0x000c:
            boolean r0 = r6.allInstrumentsVisible
            java.lang.String r1 = "mainToolbar"
            r2 = 1
            r3 = 2
            r4 = 0
            if (r0 != 0) goto L_0x0088
            java.util.List<net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView> r0 = r6.otherInstruments
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            if (r0 == 0) goto L_0x0088
            int r0 = r7.size()
            if (r0 <= r3) goto L_0x0088
            java.lang.Object r0 = r7.get(r2)
            boolean r0 = r0 instanceof net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView.WalletView
            if (r0 == 0) goto L_0x0088
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r5 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            boolean r0 = r0.isWalletEnabledOnMerchant()
            if (r0 == 0) goto L_0x0088
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            boolean r0 = r0.isWalletAmountSufficientToPay()
            if (r0 != 0) goto L_0x0088
            int r0 = r7.size()
            r3 = 3
            if (r0 <= r3) goto L_0x007d
            android.view.View r0 = r6.otherPayments
            if (r0 == 0) goto L_0x005f
            r0.setVisibility(r4)
        L_0x005f:
            java.util.List r0 = r7.subList(r4, r3)
            java.util.List<net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView> r2 = r6.otherInstruments
            int r5 = r7.size()
            java.util.List r7 = r7.subList(r3, r5)
            java.util.Collection r7 = (java.util.Collection) r7
            r2.addAll(r7)
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r7 = r6.mainToolbar
            if (r7 != 0) goto L_0x0079
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0079:
            r7.setBackButtonVisibility(r4)
            goto L_0x00da
        L_0x007d:
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r0 = r6.mainToolbar
            if (r0 != 0) goto L_0x0084
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0084:
            r0.setBackButtonVisibility(r2)
            goto L_0x00d9
        L_0x0088:
            boolean r0 = r6.allInstrumentsVisible
            if (r0 != 0) goto L_0x00c9
            java.util.List<net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView> r0 = r6.otherInstruments
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x009b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r0 = 0
            goto L_0x009c
        L_0x009b:
            r0 = 1
        L_0x009c:
            if (r0 == 0) goto L_0x00c9
            int r0 = r7.size()
            if (r0 <= r3) goto L_0x00c9
            android.view.View r0 = r6.otherPayments
            if (r0 == 0) goto L_0x00ab
            r0.setVisibility(r4)
        L_0x00ab:
            java.util.List r0 = r7.subList(r4, r3)
            java.util.List<net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView> r2 = r6.otherInstruments
            int r5 = r7.size()
            java.util.List r7 = r7.subList(r3, r5)
            java.util.Collection r7 = (java.util.Collection) r7
            r2.addAll(r7)
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r7 = r6.mainToolbar
            if (r7 != 0) goto L_0x00c5
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00c5:
            r7.setBackButtonVisibility(r4)
            goto L_0x00da
        L_0x00c9:
            int r0 = r7.size()
            if (r0 <= r3) goto L_0x00d9
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r0 = r6.mainToolbar
            if (r0 != 0) goto L_0x00d6
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00d6:
            r0.setBackButtonVisibility(r2)
        L_0x00d9:
            r0 = r7
        L_0x00da:
            boolean r7 = r6.removeAllViews
            java.lang.String r1 = "instrumentViews"
            if (r7 == 0) goto L_0x00ee
            android.widget.LinearLayout r7 = r6.instrumentViews
            if (r7 != 0) goto L_0x00e7
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e7:
            if (r7 == 0) goto L_0x00ec
            r7.removeAllViews()
        L_0x00ec:
            r6.removeAllViews = r4
        L_0x00ee:
            super.inflatePaymentInstruments(r0)
            r6.stopProgress()
            android.widget.LinearLayout r7 = r6.instrumentViews
            if (r7 != 0) goto L_0x00fb
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00fb:
            android.view.ViewTreeObserver r7 = r7.getViewTreeObserver()
            net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet$inflatePaymentInstruments$1 r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet$inflatePaymentInstruments$1
            r0.<init>(r6)
            android.view.ViewTreeObserver$OnGlobalLayoutListener r0 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r0
            r7.addOnGlobalLayoutListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet.inflatePaymentInstruments(java.util.List):void");
    }

    public final void showHiddenInstruments() {
        View view = this.otherPayments;
        if (view != null && view.getVisibility() == 0) {
            setPendingInstrumentSelection(true);
            View view2 = this.otherPayments;
            if (view2 != null) {
                view2.callOnClick();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setScrollViewToolbarVisibility(int i2) {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            k.a("scrollView");
        }
        nestedScrollView.setOnScrollChangeListener(new AppInvokeSheet$setScrollViewToolbarVisibility$1(this, i2));
    }

    private final void setBottomSheetHeight() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            k.a("scrollView");
        }
        BottomSheetBehavior from = BottomSheetBehavior.from(nestedScrollView);
        k.a((Object) from, "BottomSheetBehavior.from(scrollView)");
        from.setState(3);
    }

    private final void startProgress() {
        ShimmerFrameLayout shimmerFrameLayout = this.shimmerLayout;
        if (shimmerFrameLayout == null) {
            k.a("shimmerLayout");
        }
        ExtensionsKt.startAnimation(shimmerFrameLayout);
    }

    private final void stopProgress() {
        ShimmerFrameLayout shimmerFrameLayout = this.shimmerLayout;
        if (shimmerFrameLayout == null) {
            k.a("shimmerLayout");
        }
        ExtensionsKt.stopAnimation(shimmerFrameLayout);
    }

    private final void setUpUI(View view) {
        View findViewById = view.findViewById(R.id.main_toolbar);
        k.a((Object) findViewById, "view.findViewById(R.id.main_toolbar)");
        this.mainToolbar = (CustomInstrumentsToolbar) findViewById;
        View findViewById2 = view.findViewById(R.id.custom_toolbar);
        k.a((Object) findViewById2, "view.findViewById(R.id.custom_toolbar)");
        this.stickyToolbar = (StickyToolbar) findViewById2;
        this.otherPayments = view.findViewById(R.id.other_payments);
        View findViewById3 = view.findViewById(R.id.payment_instruments);
        k.a((Object) findViewById3, "view.findViewById(R.id.payment_instruments)");
        this.instrumentViews = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.scroll_view);
        k.a((Object) findViewById4, "view.findViewById(R.id.scroll_view)");
        this.scrollView = (NestedScrollView) findViewById4;
        View findViewById5 = view.findViewById(R.id.shimmer_layout);
        k.a((Object) findViewById5, "view.findViewById(R.id.shimmer_layout)");
        this.shimmerLayout = (ShimmerFrameLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.parent_container);
        k.a((Object) findViewById6, "view.findViewById(R.id.parent_container)");
        this.parentContainer = findViewById6;
        View findViewById7 = view.findViewById(R.id.txt_order_detail_toolbar);
        k.a((Object) findViewById7, "view.findViewById(R.id.txt_order_detail_toolbar)");
        this.subsDetailTitle = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.sub_detail);
        k.a((Object) findViewById8, "view.findViewById(R.id.sub_detail)");
        this.subDetailTitleCustomtbar = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.tv_subs_zero_amount_label);
        k.a((Object) findViewById9, "view.findViewById(R.id.tv_subs_zero_amount_label)");
        this.subsZeroAmountTitle = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.tv_exclusive_offer_text);
        k.a((Object) findViewById10, "view.findViewById(R.id.tv_exclusive_offer_text)");
        this.mTvExclusiveOfferText = (TextView) findViewById10;
        this.mTvExclusiveOfferSubHeading = (TextView) view.findViewById(R.id.tv_exclusive_offer_text_subheading);
        View findViewById11 = view.findViewById(R.id.inc_bank_offer_strip);
        k.a((Object) findViewById11, "view.findViewById(R.id.inc_bank_offer_strip)");
        this.mClBankOfferStrip = (ConstraintLayout) findViewById11;
        View findViewById12 = view.findViewById(R.id.iv_show_all_bank_offers);
        k.a((Object) findViewById12, "view.findViewById(R.id.iv_show_all_bank_offers)");
        this.mIvShowOfferArrow = (ImageView) findViewById12;
        this.mIvBankOfferLogo = (ImageView) view.findViewById(R.id.iv_offer_image_bank_offer);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isSubsCriptionFlow()) {
            if (SDKUtility.isSubscriptionAmountZero()) {
                TextView textView = this.subsZeroAmountTitle;
                if (textView == null) {
                    k.a("subsZeroAmountTitle");
                }
                textView.setVisibility(0);
            }
            if (PaytmSDK.isSubsDetailAvailable()) {
                TextView textView2 = this.subsDetailTitle;
                if (textView2 == null) {
                    k.a("subsDetailTitle");
                }
                textView2.setVisibility(0);
            } else {
                TextView textView3 = this.subsDetailTitle;
                if (textView3 == null) {
                    k.a("subsDetailTitle");
                }
                textView3.setVisibility(8);
                ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivDownArrow_toolbar);
                k.a((Object) imageView, "ivDownArrow_toolbar");
                imageView.setVisibility(8);
            }
        } else {
            TextView textView4 = this.subsDetailTitle;
            if (textView4 == null) {
                k.a("subsDetailTitle");
            }
            textView4.setVisibility(8);
        }
        View view2 = this.otherPayments;
        if (view2 != null) {
            view2.setOnClickListener(new AppInvokeSheet$setUpUI$1(this));
        }
        TextView textView5 = this.subsDetailTitle;
        if (textView5 == null) {
            k.a("subsDetailTitle");
        }
        textView5.setOnClickListener(new AppInvokeSheet$setUpUI$2(this));
        TextView textView6 = this.subDetailTitleCustomtbar;
        if (textView6 == null) {
            k.a("subDetailTitleCustomtbar");
        }
        textView6.setOnClickListener(new AppInvokeSheet$setUpUI$3(this));
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimateParentHierarchy(false);
        LinearLayout linearLayout = this.instrumentViews;
        if (linearLayout == null) {
            k.a("instrumentViews");
        }
        linearLayout.setLayoutTransition(layoutTransition);
        CustomInstrumentsToolbar customInstrumentsToolbar = this.mainToolbar;
        if (customInstrumentsToolbar == null) {
            k.a("mainToolbar");
        }
        customInstrumentsToolbar.setBackOnClickListener(new AppInvokeSheet$setUpUI$4(this));
        CustomInstrumentsToolbar customInstrumentsToolbar2 = this.mainToolbar;
        if (customInstrumentsToolbar2 == null) {
            k.a("mainToolbar");
        }
        ((CharacterWrapTextView) customInstrumentsToolbar2._$_findCachedViewById(R.id.order_id)).setOnClickListener(new AppInvokeSheet$setUpUI$5(this));
        StickyToolbar stickyToolbar2 = this.stickyToolbar;
        if (stickyToolbar2 == null) {
            k.a("stickyToolbar");
        }
        Context context = stickyToolbar2.getContext();
        k.a((Object) context, "context");
        stickyToolbar2.setToolbarColor(context.getResources().getColor(R.color.title_color));
        CustomInstrumentsToolbar customInstrumentsToolbar3 = this.mainToolbar;
        if (customInstrumentsToolbar3 == null) {
            k.a("mainToolbar");
        }
        stickyToolbar2.setToolbarTitle(customInstrumentsToolbar3.getMerchantName().toString());
        CustomInstrumentsToolbar customInstrumentsToolbar4 = this.mainToolbar;
        if (customInstrumentsToolbar4 == null) {
            k.a("mainToolbar");
        }
        stickyToolbar2.setToolbarAmount(customInstrumentsToolbar4.getTotalAmount().toString());
        stickyToolbar2.setOnBackPressListener(new AppInvokeSheet$setUpUI$$inlined$apply$lambda$1(this));
    }

    private final void removeSubsDetailBottomSheet() {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) _$_findCachedViewById(R.id.parent_container);
        k.a((Object) coordinatorLayout, "parent_container");
        coordinatorLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void inflatesubsDetailSheet() {
        SubsCriptionDetailsBsheet subsCriptionDetailsBsheet = new SubsCriptionDetailsBsheet();
        subsCriptionDetailsBsheet.setArguments(new Bundle());
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        subsCriptionDetailsBsheet.show(childFragmentManager, SubsCriptionDetailsBsheet.class.getSimpleName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if ((r2 == null || r2.isEmpty()) == true) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponseReceived(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x001e
            net.one97.paytm.nativesdk.common.model.Body r2 = r5.getBody()
            if (r2 == 0) goto L_0x001e
            net.one97.paytm.nativesdk.common.model.ResultInfo r2 = r2.getResultInfo()
            if (r2 == 0) goto L_0x001e
            java.lang.String r2 = r2.getResultStatus()
            if (r2 == 0) goto L_0x001e
            java.lang.String r3 = "F"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            if (r2 == r1) goto L_0x0042
        L_0x001e:
            if (r5 == 0) goto L_0x00a0
            net.one97.paytm.nativesdk.common.model.Body r2 = r5.getBody()
            if (r2 == 0) goto L_0x00a0
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r2 = r2.getMerchantPayOption()
            if (r2 == 0) goto L_0x00a0
            java.util.ArrayList r2 = r2.getPaymentModes()
            if (r2 == 0) goto L_0x00a0
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x003f
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r2 = 0
            goto L_0x0040
        L_0x003f:
            r2 = 1
        L_0x0040:
            if (r2 != r1) goto L_0x00a0
        L_0x0042:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "kill"
            r1.<init>(r2)
            java.lang.String r2 = "save_activity"
            java.lang.String r3 = "none"
            r1.putExtra(r2, r3)
            android.content.Context r2 = r4.getContext()
            if (r2 == 0) goto L_0x0066
            java.lang.String r3 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.content.Context r2 = r2.getApplicationContext()
            androidx.localbroadcastmanager.a.a r2 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r2)
            r2.a((android.content.Intent) r1)
        L_0x0066:
            boolean r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.isAppInvokeFlow()
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = "api_error_response"
            java.lang.String r2 = "Fetch Pay Option"
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r1, r2)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
            net.one97.paytm.nativesdk.common.model.Body r5 = r5.getBody()
            if (r5 == 0) goto L_0x0087
            net.one97.paytm.nativesdk.common.model.ResultInfo r5 = r5.getResultInfo()
            if (r5 == 0) goto L_0x0087
            java.lang.String r0 = r5.getResultCode()
        L_0x0087:
            java.lang.String r5 = "error_message_response"
            java.util.Map r5 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParams(r5, r0)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r5)
        L_0x0090:
            net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener r5 = net.one97.paytm.nativesdk.PaytmSDK.getCallbackListener()
            if (r5 == 0) goto L_0x009f
            net.one97.paytm.nativesdk.app.PaytmSDKCallbackListener r5 = net.one97.paytm.nativesdk.PaytmSDK.getCallbackListener()
            java.lang.String r0 = "Failed to initiate Paytm SDK. Please check transaction JSON."
            r5.onTransactionCancel(r0)
        L_0x009f:
            return
        L_0x00a0:
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            r1.setResponse(r5)
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r2 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            if (r5 == 0) goto L_0x00bc
            net.one97.paytm.nativesdk.common.model.Body r2 = r5.getBody()
            if (r2 == 0) goto L_0x00bc
            java.lang.String r0 = r2.getPaymentFlow()
        L_0x00bc:
            r1.setPaymentFlowBankOffer(r0)
            r4.handleFPOResponseBankOffers(r5)
            r4.setToolbarValues()
            net.one97.paytm.nativesdk.paymethods.viewmodel.AppInvokeViewModel r5 = r4.mInstrumentsViewModel
            if (r5 != 0) goto L_0x00ce
            java.lang.String r0 = "mInstrumentsViewModel"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00ce:
            net.one97.paytm.nativesdk.Utils.SDKUtils r0 = net.one97.paytm.nativesdk.Utils.SDKUtils.INSTANCE
            boolean r0 = r0.isAddMoneyPaymentFlow()
            r5.addPaymentViews(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet.onResponseReceived(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r9 = r9.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fetchAllPaymentOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.common.model.Body r9 = r9.getBody()
            if (r9 == 0) goto L_0x000e
            java.util.ArrayList r9 = r9.getPaymentOffers()
            goto L_0x000f
        L_0x000e:
            r9 = r0
        L_0x000f:
            boolean r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.isAppInvokeFlow()
            if (r1 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x0020
            int r1 = r9.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0021
        L_0x0020:
            r1 = r0
        L_0x0021:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "strip_loaded"
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getAllInOneEventParamsBO(r2, r1)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
        L_0x002f:
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            r2 = 0
            if (r9 == 0) goto L_0x0134
            int r3 = r9.size()
            if (r3 <= 0) goto L_0x0134
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.mClBankOfferStrip
            if (r3 != 0) goto L_0x0043
            java.lang.String r4 = "mClBankOfferStrip"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0043:
            r3.setVisibility(r2)
            net.one97.paytm.nativesdk.common.view.BankOffersBottomSheet r3 = new net.one97.paytm.nativesdk.common.view.BankOffersBottomSheet
            r3.<init>()
            r8.bankOffersBottomSheet = r3
            net.one97.paytm.nativesdk.DirectPaymentBL r3 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            r4 = 1
            r3.setBankOffersAvailable(r4)
            int r3 = r9.size()
            java.lang.String r5 = "mTvExclusiveOfferText"
            if (r3 != r4) goto L_0x00d8
            android.widget.TextView r3 = r8.mTvExclusiveOfferSubHeading
            if (r3 == 0) goto L_0x0067
            r3.setVisibility(r2)
        L_0x0067:
            android.widget.TextView r3 = r8.mTvExclusiveOfferSubHeading
            if (r3 == 0) goto L_0x0084
            java.lang.Object r6 = r9.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentOffer r6 = (net.one97.paytm.nativesdk.common.model.PaymentOffer) r6
            if (r6 == 0) goto L_0x007e
            net.one97.paytm.nativesdk.common.model.PaymentOffer$Offer r6 = r6.getOffer()
            if (r6 == 0) goto L_0x007e
            java.lang.String r6 = r6.getText()
            goto L_0x007f
        L_0x007e:
            r6 = r0
        L_0x007f:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x0084:
            android.widget.TextView r3 = r8.mTvExclusiveOfferText
            if (r3 != 0) goto L_0x008b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x008b:
            java.lang.Object r6 = r9.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentOffer r6 = (net.one97.paytm.nativesdk.common.model.PaymentOffer) r6
            if (r6 == 0) goto L_0x009e
            net.one97.paytm.nativesdk.common.model.PaymentOffer$Offer r6 = r6.getOffer()
            if (r6 == 0) goto L_0x009e
            java.lang.String r6 = r6.getTitle()
            goto L_0x009f
        L_0x009e:
            r6 = r0
        L_0x009f:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            android.content.Context r3 = r8.getContext()
            if (r3 != 0) goto L_0x00ad
            kotlin.g.b.k.a()
        L_0x00ad:
            com.bumptech.glide.i r3 = com.bumptech.glide.b.b(r3)
            java.lang.Object r9 = r9.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentOffer r9 = (net.one97.paytm.nativesdk.common.model.PaymentOffer) r9
            if (r9 == 0) goto L_0x00c3
            net.one97.paytm.nativesdk.common.model.PaymentOffer$Offer r9 = r9.getOffer()
            if (r9 == 0) goto L_0x00c3
            java.lang.String r0 = r9.getIcon()
        L_0x00c3:
            com.bumptech.glide.h r9 = r3.a((java.lang.String) r0)
            android.widget.ImageView r0 = r8.mIvBankOfferLogo
            if (r0 != 0) goto L_0x00ce
            kotlin.g.b.k.a()
        L_0x00ce:
            com.bumptech.glide.e.a.k r9 = r9.a((android.widget.ImageView) r0)
            java.lang.String r0 = "Glide.with(context!!).lo….into(mIvBankOfferLogo!!)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            goto L_0x0105
        L_0x00d8:
            android.widget.TextView r3 = r8.mTvExclusiveOfferSubHeading
            if (r3 == 0) goto L_0x00e1
            r6 = 8
            r3.setVisibility(r6)
        L_0x00e1:
            android.widget.TextView r3 = r8.mTvExclusiveOfferText
            if (r3 != 0) goto L_0x00e8
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00e8:
            android.content.Context r6 = r8.getContext()
            if (r6 == 0) goto L_0x0100
            int r0 = net.one97.paytm.nativesdk.R.string.exclusive_offer_text
            java.lang.Object[] r7 = new java.lang.Object[r4]
            int r9 = r9.size()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7[r2] = r9
            java.lang.String r0 = r6.getString(r0, r7)
        L_0x0100:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
        L_0x0105:
            net.one97.paytm.nativesdk.DirectPaymentBL r9 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setBankOffersAvailable(r4)
            android.widget.ImageView r9 = r8.mIvShowOfferArrow
            if (r9 != 0) goto L_0x0118
            java.lang.String r0 = "mIvShowOfferArrow"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0118:
            net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet$fetchAllPaymentOffers$1 r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet$fetchAllPaymentOffers$1
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            android.widget.TextView r9 = r8.mTvExclusiveOfferText
            if (r9 != 0) goto L_0x0129
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0129:
            net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet$fetchAllPaymentOffers$2 r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet$fetchAllPaymentOffers$2
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            return
        L_0x0134:
            net.one97.paytm.nativesdk.DirectPaymentBL r9 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setBankOffersAvailable(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.AppInvokeSheet.fetchAllPaymentOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse):void");
    }

    public final void hideBankOfferStrip() {
        ConstraintLayout constraintLayout = this.mClBankOfferStrip;
        if (constraintLayout == null) {
            k.a("mClBankOfferStrip");
        }
        constraintLayout.setVisibility(8);
    }

    public final void addViewInScrollView(View view, boolean z) {
        k.c(view, "view");
        if (getContext() != null || isAdded()) {
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                } else {
                    throw new u("null cannot be cast to non-null type android.view.ViewGroup");
                }
            }
            LinearLayout linearLayout = this.instrumentViews;
            if (linearLayout == null) {
                k.a("instrumentViews");
            }
            if (linearLayout != null) {
                linearLayout.addView(view);
            }
            Context context = getContext();
            Object systemService = context != null ? context.getSystemService("layout_inflater") : null;
            if (systemService != null) {
                LayoutInflater layoutInflater = (LayoutInflater) systemService;
                if (z) {
                    LinearLayout linearLayout2 = this.instrumentViews;
                    if (linearLayout2 == null) {
                        k.a("instrumentViews");
                    }
                    if (linearLayout2 != null) {
                        linearLayout2.addView(layoutInflater.inflate(R.layout.line_xml, (ViewGroup) null, false));
                        return;
                    }
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }

    public final void sendGAEvent() {
        AppInvokeViewModel appInvokeViewModel = this.mInstrumentsViewModel;
        if (appInvokeViewModel == null) {
            k.a("mInstrumentsViewModel");
        }
        appInvokeViewModel.sendGAEvent();
    }

    public final void updateTotalAmount(String str) {
        CustomInstrumentsToolbar customInstrumentsToolbar = this.mainToolbar;
        if (customInstrumentsToolbar == null) {
            k.a("mainToolbar");
        }
        CharSequence text = getResources().getText(R.string.nativesdk_amount_pay, str);
        k.a((Object) text, "resources.getText(R.stri…vesdk_amount_pay, amount)");
        customInstrumentsToolbar.setTotalAmount(text);
    }

    public final void removeAllViews() {
        this.removeAllViews = true;
    }

    public final void addPaymentInstruments(boolean z) {
        this.otherInstruments.clear();
        AppInvokeViewModel appInvokeViewModel = this.mInstrumentsViewModel;
        if (appInvokeViewModel == null) {
            k.a("mInstrumentsViewModel");
        }
        appInvokeViewModel.addPaymentViews(z);
    }

    public final NestedScrollView provideScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            k.a("scrollView");
        }
        return nestedScrollView;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final AppInvokeSheet getInstance(String str, String str2, int i2) {
            k.c(str, "primaryInfo");
            k.c(str2, "secondInfo");
            AppInvokeSheet appInvokeSheet = new AppInvokeSheet();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, str);
            bundle.putString(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, str2);
            bundle.putInt(SDKConstants.MERCHANT_LOGO, i2);
            appInvokeSheet.setArguments(bundle);
            return appInvokeSheet;
        }
    }
}
