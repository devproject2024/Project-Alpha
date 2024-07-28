package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ConvenienceFeeController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.view.BankOffersBottomSheet;
import net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar;
import net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener;
import net.one97.paytm.nativesdk.paymethods.listeners.SetOnCashierSheetListener;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;
import net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel;
import net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar;

public final class InstrumentsSheet extends BaseInstrumentSheet implements CashierInstrumentListner, OnBottomSheetChangeListener {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BankOffersBottomSheet bankOffersBottomSheet;
    /* access modifiers changed from: private */
    public NativeInstrumentCashierSheetBinding mCashierSheetBinding;
    private ConstraintLayout mClBankOfferStrip;
    private Context mContext;
    private String mInstrumentPrimaryInfo;
    private String mInstrumentSecondaryInfo;
    public InstrumentSheetViewModel mInstrumentSheetViewModel;
    private ImageView mIvBankOfferLogo;
    /* access modifiers changed from: private */
    public ImageView mIvShowOfferArrow;
    private OnPayMethodSelectedListener mPayMethodSelectedListener;
    private TextView mTvExclusiveOfferSubHeading;
    private TextView mTvExclusiveOfferText;
    private int merchantLogo;
    public CustomInstrumentsToolbar merchantToolbar;
    private PopupWindow popupWindow;
    private boolean removeAllViews;
    private SetOnCashierSheetListener setOnCashierSheetListener;
    public StickyToolbar stickyToolbar;

    private final void dismiss() {
    }

    public static final InstrumentsSheet getInstance(String str, String str2, int i2) {
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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onFetchBalance(String str) {
        k.c(str, "secondaryInfo");
    }

    public final void onNetworkUnavailable(Request<?> request) {
        k.c(request, "request");
    }

    public final void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
    }

    public final void refreshUpiView() {
    }

    public final void showHiddenInstruments() {
    }

    public static final /* synthetic */ NativeInstrumentCashierSheetBinding access$getMCashierSheetBinding$p(InstrumentsSheet instrumentsSheet) {
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = instrumentsSheet.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding == null) {
            k.a("mCashierSheetBinding");
        }
        return nativeInstrumentCashierSheetBinding;
    }

    public static final /* synthetic */ ImageView access$getMIvShowOfferArrow$p(InstrumentsSheet instrumentsSheet) {
        ImageView imageView = instrumentsSheet.mIvShowOfferArrow;
        if (imageView == null) {
            k.a("mIvShowOfferArrow");
        }
        return imageView;
    }

    public final CustomInstrumentsToolbar getMerchantToolbar() {
        CustomInstrumentsToolbar customInstrumentsToolbar = this.merchantToolbar;
        if (customInstrumentsToolbar == null) {
            k.a("merchantToolbar");
        }
        return customInstrumentsToolbar;
    }

    public final void setMerchantToolbar(CustomInstrumentsToolbar customInstrumentsToolbar) {
        k.c(customInstrumentsToolbar, "<set-?>");
        this.merchantToolbar = customInstrumentsToolbar;
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

    public final InstrumentSheetViewModel getMInstrumentSheetViewModel() {
        InstrumentSheetViewModel instrumentSheetViewModel = this.mInstrumentSheetViewModel;
        if (instrumentSheetViewModel == null) {
            k.a("mInstrumentSheetViewModel");
        }
        return instrumentSheetViewModel;
    }

    public final void setMInstrumentSheetViewModel(InstrumentSheetViewModel instrumentSheetViewModel) {
        k.c(instrumentSheetViewModel, "<set-?>");
        this.mInstrumentSheetViewModel = instrumentSheetViewModel;
    }

    private final boolean isOffersAvailable() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.getCjPayMethodResponse() != null) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance2.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            if (cjPayMethodResponse.getBody() != null) {
                DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                CJPayMethodResponse cjPayMethodResponse2 = instance3.getCjPayMethodResponse();
                k.a((Object) cjPayMethodResponse2, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                Body body = cjPayMethodResponse2.getBody();
                k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                if (body.getPaymentOffers() != null) {
                    DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                    k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                    CJPayMethodResponse cjPayMethodResponse3 = instance4.getCjPayMethodResponse();
                    k.a((Object) cjPayMethodResponse3, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                    Body body2 = cjPayMethodResponse3.getBody();
                    k.a((Object) body2, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                    if (body2.getPaymentOffers().size() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean isOrderPopupShowing() {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 == null) {
            return false;
        }
        if (popupWindow2 == null) {
            k.a();
        }
        return popupWindow2.isShowing();
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        this.mContext = context;
        if (context instanceof SetOnCashierSheetListener) {
            this.setOnCashierSheetListener = (SetOnCashierSheetListener) context;
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        SetOnCashierSheetListener setOnCashierSheetListener2 = this.setOnCashierSheetListener;
        if (setOnCashierSheetListener2 != null) {
            if (setOnCashierSheetListener2 == null) {
                k.a();
            }
            setOnCashierSheetListener2.onCashierSheetDismiss();
        }
    }

    public final void onAttach(Activity activity) {
        k.c(activity, "activity");
        super.onAttach(activity);
        this.mPayMethodSelectedListener = (OnPayMethodSelectedListener) activity;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, "")) == null) {
            str = "";
        }
        this.mInstrumentPrimaryInfo = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            k.a();
        }
        this.mInstrumentSecondaryInfo = arguments2.getString(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, "");
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            k.a();
        }
        this.merchantLogo = arguments3.getInt(SDKConstants.MERCHANT_LOGO);
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            activity.getWindow().setSoftInputMode(3);
        }
        this.bankOffersBottomSheet = new BankOffersBottomSheet();
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        instance.setBankOffersAvailable(isOffersAvailable());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04fd, code lost:
        r14 = r14.getBody();
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0508  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r12, android.view.ViewGroup r13, android.os.Bundle r14) {
        /*
            r11 = this;
            java.lang.String r14 = "inflater"
            kotlin.g.b.k.c(r12, r14)
            r12 = r11
            androidx.lifecycle.ao r12 = (androidx.lifecycle.ao) r12
            net.one97.paytm.nativesdk.paymethods.factory.InstrumentViewModelFactory r14 = new net.one97.paytm.nativesdk.paymethods.factory.InstrumentViewModelFactory
            java.lang.String r1 = r11.mInstrumentPrimaryInfo
            if (r1 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            java.lang.String r2 = r11.mInstrumentSecondaryInfo
            if (r2 != 0) goto L_0x0018
            kotlin.g.b.k.a()
        L_0x0018:
            net.one97.paytm.nativesdk.paymethods.listeners.OnPayMethodSelectedListener r3 = r11.mPayMethodSelectedListener
            r4 = r11
            net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener r4 = (net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener) r4
            r5 = 0
            r7 = r11
            net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner r7 = (net.one97.paytm.nativesdk.paymethods.listeners.CashierInstrumentListner) r7
            android.content.Context r0 = r11.getContext()
            if (r0 != 0) goto L_0x002a
            kotlin.g.b.k.a()
        L_0x002a:
            java.lang.String r9 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r9)
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x051b
            r8 = r0
            android.app.Application r8 = (android.app.Application) r8
            java.lang.String r6 = ""
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.lifecycle.al$b r14 = (androidx.lifecycle.al.b) r14
            androidx.lifecycle.al r0 = new androidx.lifecycle.al
            r0.<init>((androidx.lifecycle.ao) r12, (androidx.lifecycle.al.b) r14)
            java.lang.Class<net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel> r12 = net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel.class
            androidx.lifecycle.ai r12 = r0.a(r12)
            java.lang.String r14 = "ViewModelProvider(this, …elFactory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel r12 = (net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel) r12
            r12.addPaymentViews()
            r11.mInstrumentSheetViewModel = r12
            android.view.LayoutInflater r12 = r11.getLayoutInflater()
            int r14 = net.one97.paytm.nativesdk.R.layout.native_instrument_cashier_sheet
            r0 = 0
            androidx.databinding.ViewDataBinding r12 = androidx.databinding.f.a((android.view.LayoutInflater) r12, (int) r14, (android.view.ViewGroup) r13, (boolean) r0)
            java.lang.String r13 = "DataBindingUtil.inflate(…_sheet, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r12 = (net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding) r12
            r11.mCashierSheetBinding = r12
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r12 = r11.mCashierSheetBinding
            java.lang.String r13 = "mCashierSheetBinding"
            if (r12 != 0) goto L_0x0074
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0074:
            android.widget.ImageView r12 = r12.ivBackArrow
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$2 r14 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$2
            r14.<init>(r11)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r12.setOnClickListener(r14)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r12 = r11.mCashierSheetBinding
            if (r12 != 0) goto L_0x0087
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0087:
            android.view.View r12 = r12.getRoot()
            java.lang.String r14 = "mCashierSheetBinding.root"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x0097
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0097:
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r14.stickyToolbar
            java.lang.String r1 = "mCashierSheetBinding.stickyToolbar"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            r11.stickyToolbar = r14
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x00a7
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x00a7:
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r14.customHeaderToolbar
            java.lang.String r1 = "mCashierSheetBinding.customHeaderToolbar"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            r11.merchantToolbar = r14
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            java.lang.String r1 = "merchantToolbar"
            if (r14 != 0) goto L_0x00b9
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00b9:
            r14.setBackButtonVisibility(r0)
            android.content.Context r14 = r11.getContext()
            if (r14 != 0) goto L_0x00c3
            return r12
        L_0x00c3:
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x00ca
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x00ca:
            net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel r2 = r11.mInstrumentSheetViewModel
            java.lang.String r3 = "mInstrumentSheetViewModel"
            if (r2 != 0) goto L_0x00d3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00d3:
            r14.setInstrumentSheetViewModel(r2)
            int r14 = r11.merchantLogo
            java.lang.String r2 = "MerchantBL.getMerchantInstance()"
            if (r14 == 0) goto L_0x0115
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding     // Catch:{ Exception -> 0x00eb }
            if (r14 != 0) goto L_0x00e3
            kotlin.g.b.k.a((java.lang.String) r13)     // Catch:{ Exception -> 0x00eb }
        L_0x00e3:
            android.widget.ImageView r14 = r14.ivMerchantLogo     // Catch:{ Exception -> 0x00eb }
            int r4 = r11.merchantLogo     // Catch:{ Exception -> 0x00eb }
            r14.setImageResource(r4)     // Catch:{ Exception -> 0x00eb }
            goto L_0x0150
        L_0x00eb:
            android.content.Context r14 = r11.getContext()
            if (r14 != 0) goto L_0x00f5
            kotlin.g.b.k.a()
        L_0x00f5:
            com.bumptech.glide.i r14 = com.bumptech.glide.b.b(r14)
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            java.lang.String r4 = r4.getMerchantLogoUrl()
            com.bumptech.glide.h r14 = r14.a((java.lang.String) r4)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r4 = r11.mCashierSheetBinding
            if (r4 != 0) goto L_0x010f
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x010f:
            android.widget.ImageView r4 = r4.ivMerchantLogo
            r14.a((android.widget.ImageView) r4)
            goto L_0x0150
        L_0x0115:
            net.one97.paytm.nativesdk.MerchantBL r14 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.String r14 = r14.getMerchantLogoUrl()
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0150
            android.content.Context r14 = r11.getContext()
            if (r14 != 0) goto L_0x0131
            kotlin.g.b.k.a()
        L_0x0131:
            com.bumptech.glide.i r14 = com.bumptech.glide.b.b(r14)
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            java.lang.String r4 = r4.getMerchantLogoUrl()
            com.bumptech.glide.h r14 = r14.a((java.lang.String) r4)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r4 = r11.mCashierSheetBinding
            if (r4 != 0) goto L_0x014b
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x014b:
            android.widget.ImageView r4 = r4.ivMerchantLogo
            r14.a((android.widget.ImageView) r4)
        L_0x0150:
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            java.lang.String r4 = "stickyToolbar"
            if (r14 != 0) goto L_0x0159
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0159:
            android.content.Context r5 = r11.getContext()
            if (r5 != 0) goto L_0x0162
            kotlin.g.b.k.a()
        L_0x0162:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            android.content.res.Resources r5 = r5.getResources()
            int r6 = net.one97.paytm.nativesdk.R.color.title_color
            int r5 = r5.getColor(r6)
            r14.setToolbarColor(r5)
            net.one97.paytm.nativesdk.ConvenienceFeeController$Companion r14 = net.one97.paytm.nativesdk.ConvenienceFeeController.Companion
            net.one97.paytm.nativesdk.ConvenienceFeeController r14 = r14.getInstance()
            boolean r14 = r14.isConvenienceFeeEnabled()
            java.lang.String r5 = "mCashierSheetBinding.ivDownArrow"
            java.lang.String r6 = "mCashierSheetBinding.txtOrderDetail"
            r7 = 1
            java.lang.String r8 = "DirectPaymentBL.getInstance()"
            if (r14 == 0) goto L_0x01cc
            boolean r14 = net.one97.paytm.nativesdk.Utils.SDKUtility.isAppInvokeFlow()
            if (r14 != 0) goto L_0x01cc
            net.one97.paytm.nativesdk.DirectPaymentBL r14 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            boolean r14 = r14.isAddMoney()
            if (r14 != 0) goto L_0x01cc
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x019f
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x019f:
            android.widget.TextView r14 = r14.txtOrderDetail
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            r14.setVisibility(r0)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x01ae
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01ae:
            r14.showOrderDetailToolbarVisibility(r7)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x01b8
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x01b8:
            android.widget.ImageView r14 = r14.ivDownArrow
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r0)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x01c7
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01c7:
            r14.setdownArrowVisibility(r7)
            goto L_0x0319
        L_0x01cc:
            net.one97.paytm.nativesdk.DirectPaymentBL r14 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            boolean r14 = r14.isSubsCriptionFlow()
            r9 = 8
            if (r14 != 0) goto L_0x021d
            net.one97.paytm.nativesdk.MerchantBL r14 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            boolean r14 = r14.isAppInvoke()
            if (r14 == 0) goto L_0x01e9
            goto L_0x021d
        L_0x01e9:
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x01f0
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x01f0:
            android.widget.TextView r14 = r14.txtOrderDetail
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            r14.setVisibility(r9)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x01ff
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01ff:
            r14.showOrderDetailToolbarVisibility(r0)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x0209
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0209:
            android.widget.ImageView r14 = r14.ivDownArrow
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r9)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x0218
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0218:
            r14.setdownArrowVisibility(r0)
            goto L_0x0319
        L_0x021d:
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x0224
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0224:
            r14.setVisibility(r0)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x022e
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x022e:
            android.widget.RelativeLayout r14 = r14.mainToolbar
            java.lang.String r5 = "mCashierSheetBinding.mainToolbar"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r9)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x023f
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x023f:
            android.widget.ImageView r14 = r14.ivMerchantLogo
            java.lang.String r5 = "mCashierSheetBinding.ivMerchantLogo"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r9)
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x0250
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0250:
            int r5 = net.one97.paytm.nativesdk.R.id.order_id
            android.view.View r14 = r14._$_findCachedViewById(r5)
            net.one97.paytm.nativesdk.widget.CharacterWrapTextView r14 = (net.one97.paytm.nativesdk.widget.CharacterWrapTextView) r14
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$3 r5 = net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$3.INSTANCE
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r14.setOnClickListener(r5)
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x0266
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0266:
            r14.setToolbarValues()
            net.one97.paytm.nativesdk.DirectPaymentBL r14 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            boolean r14 = r14.isSubsCriptionFlow()
            if (r14 == 0) goto L_0x0319
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x027d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x027d:
            r14.setdownArrowVisibility(r7)
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x0287
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0287:
            int r5 = net.one97.paytm.nativesdk.R.id.sub_detail
            android.view.View r14 = r14._$_findCachedViewById(r5)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r5 = "merchantToolbar.sub_detail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            android.content.Context r6 = r11.getContext()
            if (r6 != 0) goto L_0x029d
            kotlin.g.b.k.a()
        L_0x029d:
            int r10 = net.one97.paytm.nativesdk.R.string.view_subs_details
            java.lang.String r6 = r6.getString(r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r14.setText(r6)
            boolean r14 = net.one97.paytm.nativesdk.Utils.SDKUtility.isSubscriptionAmountZero()
            if (r14 == 0) goto L_0x02c5
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x02b5
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02b5:
            int r6 = net.one97.paytm.nativesdk.R.id.tv_subs_zero_amount_label
            android.view.View r14 = r14._$_findCachedViewById(r6)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r6 = "merchantToolbar.tv_subs_zero_amount_label"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            r14.setVisibility(r0)
        L_0x02c5:
            boolean r14 = net.one97.paytm.nativesdk.PaytmSDK.isSubsDetailAvailable()
            if (r14 == 0) goto L_0x02eb
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x02d2
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x02d2:
            r14.showOrderDetailToolbarVisibility(r7)
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x02dc
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02dc:
            int r6 = net.one97.paytm.nativesdk.R.id.sub_detail
            android.view.View r14 = r14._$_findCachedViewById(r6)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r0)
            goto L_0x0300
        L_0x02eb:
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x02f2
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x02f2:
            int r6 = net.one97.paytm.nativesdk.R.id.sub_detail
            android.view.View r14 = r14._$_findCachedViewById(r6)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r14.setVisibility(r9)
        L_0x0300:
            net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar r14 = r11.merchantToolbar
            if (r14 != 0) goto L_0x0307
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0307:
            int r1 = net.one97.paytm.nativesdk.R.id.sub_detail
            android.view.View r14 = r14._$_findCachedViewById(r1)
            android.widget.TextView r14 = (android.widget.TextView) r14
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$4 r1 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$4
            r1.<init>(r11)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r14.setOnClickListener(r1)
        L_0x0319:
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x0320
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0320:
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$5 r1 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$5
            r1.<init>(r11)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            r14.setOrderDetailOnClickListener(r1)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x0331
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0331:
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$6 r1 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$6
            r1.<init>(r11)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            r14.setdownArrowOnClickListener(r1)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x0342
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0342:
            android.widget.TextView r14 = r14.txtOrderDetail
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$7 r1 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$7
            r1.<init>(r11)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r14.setOnClickListener(r1)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x0355
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0355:
            android.widget.ImageView r14 = r14.ivDownArrow
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$8 r1 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$8
            r1.<init>(r11)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r14.setOnClickListener(r1)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x0368
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0368:
            android.widget.TextView r14 = r14.txtAmount
            java.lang.String r1 = "mCashierSheetBinding.txtAmount"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            android.content.Context r1 = r11.getContext()
            if (r1 != 0) goto L_0x0378
            kotlin.g.b.k.a()
        L_0x0378:
            int r5 = net.one97.paytm.nativesdk.R.string.nativesdk_amount
            java.lang.Object[] r6 = new java.lang.Object[r7]
            net.one97.paytm.nativesdk.MerchantBL r9 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r2)
            java.lang.String r9 = r9.getWithoutDoubleAmount()
            java.lang.String r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.priceWithoutDecimal((java.lang.String) r9)
            r6[r0] = r9
            java.lang.String r1 = r1.getString(r5, r6)
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r11.getToolbarAmount(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x03a9
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x03a9:
            android.widget.TextView r14 = r14.txtTitle
            java.lang.String r1 = "mCashierSheetBinding.txtTitle"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            android.content.Context r5 = r11.getContext()
            if (r5 != 0) goto L_0x03b9
            kotlin.g.b.k.a()
        L_0x03b9:
            int r6 = net.one97.paytm.nativesdk.R.string.select_an_option_to_pay
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r14.setText(r5)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x03cb
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03cb:
            android.content.Context r5 = r11.getContext()
            if (r5 != 0) goto L_0x03d4
            kotlin.g.b.k.a()
        L_0x03d4:
            int r6 = net.one97.paytm.nativesdk.R.string.select_an_option_to_pay
            java.lang.String r5 = r5.getString(r6)
            java.lang.String r6 = "context!!.getString(R.st….select_an_option_to_pay)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r14.setToolbarTitle(r5)
            net.one97.paytm.nativesdk.DirectPaymentBL r14 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            java.lang.String r14 = r14.getHeaderLabelText()
            r5 = r14
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0414
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r6 = r11.mCashierSheetBinding
            if (r6 != 0) goto L_0x03fd
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x03fd:
            android.widget.TextView r6 = r6.txtTitle
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            r6.setText(r5)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r5 = r11.stickyToolbar
            if (r5 != 0) goto L_0x040c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x040c:
            java.lang.String r6 = "headerLabelText"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            r5.setToolbarTitle(r14)
        L_0x0414:
            net.one97.paytm.nativesdk.DirectPaymentBL r14 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            boolean r14 = r14.isSubsCriptionFlow()
            if (r14 == 0) goto L_0x0441
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x0428
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x0428:
            android.widget.TextView r14 = r14.txtTitle
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)
            android.content.Context r1 = r11.getContext()
            if (r1 != 0) goto L_0x0436
            kotlin.g.b.k.a()
        L_0x0436:
            int r5 = net.one97.paytm.nativesdk.R.string.amount_to_be_paid
            java.lang.String r1 = r1.getString(r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r14.setText(r1)
        L_0x0441:
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x0448
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0448:
            int r1 = net.one97.paytm.nativesdk.R.string.nativesdk_amount
            java.lang.Object[] r5 = new java.lang.Object[r7]
            net.one97.paytm.nativesdk.MerchantBL r6 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            java.lang.String r2 = r6.getWithoutDoubleAmount()
            java.lang.String r2 = net.one97.paytm.nativesdk.Utils.SDKUtility.priceWithoutDecimal((java.lang.String) r2)
            r5[r0] = r2
            java.lang.String r0 = r11.getString(r1, r5)
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            java.lang.String r0 = r0.toString()
            r14.setToolbarAmount(r0)
            net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar r14 = r11.stickyToolbar
            if (r14 != 0) goto L_0x0473
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0473:
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$9 r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$9
            r0.<init>(r11)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            r14.setOnBackPressListener(r0)
            int r14 = net.one97.paytm.nativesdk.R.id.tv_exclusive_offer_text
            android.view.View r14 = r12.findViewById(r14)
            java.lang.String r0 = "mRootView.findViewById(R….tv_exclusive_offer_text)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r11.mTvExclusiveOfferText = r14
            int r14 = net.one97.paytm.nativesdk.R.id.tv_exclusive_offer_text_subheading
            android.view.View r14 = r12.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r11.mTvExclusiveOfferSubHeading = r14
            int r14 = net.one97.paytm.nativesdk.R.id.cl_bank_offers
            android.view.View r14 = r12.findViewById(r14)
            java.lang.String r0 = "mRootView.findViewById(R.id.cl_bank_offers)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r11.mClBankOfferStrip = r14
            int r14 = net.one97.paytm.nativesdk.R.id.iv_show_all_bank_offers
            android.view.View r14 = r12.findViewById(r14)
            java.lang.String r0 = "mRootView.findViewById(R….iv_show_all_bank_offers)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r11.mIvShowOfferArrow = r14
            int r14 = net.one97.paytm.nativesdk.R.id.iv_offer_image_bank_offer
            android.view.View r14 = r12.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r11.mIvBankOfferLogo = r14
            net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel r14 = r11.mInstrumentSheetViewModel
            if (r14 != 0) goto L_0x04c5
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x04c5:
            androidx.lifecycle.LiveData r14 = r14.getInstrumentViewList()
            androidx.lifecycle.q r0 = r11.getViewLifecycleOwner()
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$10 r1 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$onCreateView$10
            r1.<init>(r11)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r14.observe(r0, r1)
            net.one97.paytm.nativesdk.databinding.NativeInstrumentCashierSheetBinding r14 = r11.mCashierSheetBinding
            if (r14 != 0) goto L_0x04de
            kotlin.g.b.k.a((java.lang.String) r13)
        L_0x04de:
            if (r14 == 0) goto L_0x04e9
            com.airbnb.lottie.LottieAnimationView r13 = r14.dotProgressBar
            if (r13 == 0) goto L_0x04e9
            net.one97.paytm.nativesdk.ExtensionsKt.startLoaderAnimation(r13)
            kotlin.x r13 = kotlin.x.f47997a
        L_0x04e9:
            net.one97.paytm.nativesdk.DirectPaymentBL r13 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r8)
            net.one97.paytm.nativesdk.DirectPaymentBL r14 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r8)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r14 = r14.getCjPayMethodResponse()
            if (r14 == 0) goto L_0x0508
            net.one97.paytm.nativesdk.common.model.Body r14 = r14.getBody()
            if (r14 == 0) goto L_0x0508
            java.lang.String r14 = r14.getPaymentFlow()
            goto L_0x0509
        L_0x0508:
            r14 = 0
        L_0x0509:
            r13.setPaymentFlowBankOffer(r14)
            net.one97.paytm.nativesdk.DirectPaymentBL r13 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r8)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r13 = r13.getCjPayMethodResponse()
            r11.handleFPOResponseBankOffers(r13)
            return r12
        L_0x051b:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type android.app.Application"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
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
            if (r1 == 0) goto L_0x002e
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
        L_0x002e:
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            r2 = 0
            if (r9 == 0) goto L_0x0133
            int r3 = r9.size()
            if (r3 <= 0) goto L_0x0133
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.mClBankOfferStrip
            if (r3 != 0) goto L_0x0042
            java.lang.String r4 = "mClBankOfferStrip"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0042:
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
            if (r3 != r4) goto L_0x00d7
            android.widget.TextView r3 = r8.mTvExclusiveOfferSubHeading
            if (r3 == 0) goto L_0x0066
            r3.setVisibility(r2)
        L_0x0066:
            android.widget.TextView r3 = r8.mTvExclusiveOfferSubHeading
            if (r3 == 0) goto L_0x0083
            java.lang.Object r6 = r9.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentOffer r6 = (net.one97.paytm.nativesdk.common.model.PaymentOffer) r6
            if (r6 == 0) goto L_0x007d
            net.one97.paytm.nativesdk.common.model.PaymentOffer$Offer r6 = r6.getOffer()
            if (r6 == 0) goto L_0x007d
            java.lang.String r6 = r6.getText()
            goto L_0x007e
        L_0x007d:
            r6 = r0
        L_0x007e:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
        L_0x0083:
            android.widget.TextView r3 = r8.mTvExclusiveOfferText
            if (r3 != 0) goto L_0x008a
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x008a:
            java.lang.Object r6 = r9.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentOffer r6 = (net.one97.paytm.nativesdk.common.model.PaymentOffer) r6
            if (r6 == 0) goto L_0x009d
            net.one97.paytm.nativesdk.common.model.PaymentOffer$Offer r6 = r6.getOffer()
            if (r6 == 0) goto L_0x009d
            java.lang.String r6 = r6.getTitle()
            goto L_0x009e
        L_0x009d:
            r6 = r0
        L_0x009e:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            android.content.Context r3 = r8.getContext()
            if (r3 != 0) goto L_0x00ac
            kotlin.g.b.k.a()
        L_0x00ac:
            com.bumptech.glide.i r3 = com.bumptech.glide.b.b(r3)
            java.lang.Object r9 = r9.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentOffer r9 = (net.one97.paytm.nativesdk.common.model.PaymentOffer) r9
            if (r9 == 0) goto L_0x00c2
            net.one97.paytm.nativesdk.common.model.PaymentOffer$Offer r9 = r9.getOffer()
            if (r9 == 0) goto L_0x00c2
            java.lang.String r0 = r9.getIcon()
        L_0x00c2:
            com.bumptech.glide.h r9 = r3.a((java.lang.String) r0)
            android.widget.ImageView r0 = r8.mIvBankOfferLogo
            if (r0 != 0) goto L_0x00cd
            kotlin.g.b.k.a()
        L_0x00cd:
            com.bumptech.glide.e.a.k r9 = r9.a((android.widget.ImageView) r0)
            java.lang.String r0 = "Glide.with(context!!).lo….into(mIvBankOfferLogo!!)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            goto L_0x0104
        L_0x00d7:
            android.widget.TextView r3 = r8.mTvExclusiveOfferSubHeading
            if (r3 == 0) goto L_0x00e0
            r6 = 8
            r3.setVisibility(r6)
        L_0x00e0:
            android.widget.TextView r3 = r8.mTvExclusiveOfferText
            if (r3 != 0) goto L_0x00e7
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x00e7:
            android.content.Context r6 = r8.getContext()
            if (r6 == 0) goto L_0x00ff
            int r0 = net.one97.paytm.nativesdk.R.string.exclusive_offer_text
            java.lang.Object[] r7 = new java.lang.Object[r4]
            int r9 = r9.size()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r7[r2] = r9
            java.lang.String r0 = r6.getString(r0, r7)
        L_0x00ff:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
        L_0x0104:
            net.one97.paytm.nativesdk.DirectPaymentBL r9 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setBankOffersAvailable(r4)
            android.widget.ImageView r9 = r8.mIvShowOfferArrow
            if (r9 != 0) goto L_0x0117
            java.lang.String r0 = "mIvShowOfferArrow"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0117:
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$fetchAllPaymentOffers$1 r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$fetchAllPaymentOffers$1
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            android.widget.TextView r9 = r8.mTvExclusiveOfferText
            if (r9 != 0) goto L_0x0128
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0128:
            net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$fetchAllPaymentOffers$2 r0 = new net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet$fetchAllPaymentOffers$2
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            return
        L_0x0133:
            net.one97.paytm.nativesdk.DirectPaymentBL r9 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setBankOffersAvailable(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.InstrumentsSheet.fetchAllPaymentOffers(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse):void");
    }

    public final void hideBankOfferStrip() {
        ConstraintLayout constraintLayout = this.mClBankOfferStrip;
        if (constraintLayout == null) {
            k.a("mClBankOfferStrip");
        }
        constraintLayout.setVisibility(8);
    }

    private final String getToolbarAmount(String str) {
        return MerchantBL.getMerchantInstance().isZeroSubscriptionFlow ? "0" : str;
    }

    /* access modifiers changed from: private */
    public final void inflatesubsDetailSheet() {
        SubsCriptionDetailsBsheet subsCriptionDetailsBsheet = new SubsCriptionDetailsBsheet();
        subsCriptionDetailsBsheet.setArguments(new Bundle());
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        subsCriptionDetailsBsheet.show(childFragmentManager, SubsCriptionDetailsBsheet.class.getSimpleName());
    }

    public final void inflatePaymentInstruments(List<? extends PaymentInstrumentView> list) {
        LinearLayout linearLayout;
        LottieAnimationView lottieAnimationView;
        k.c(list, "pgInstruments");
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding == null) {
            k.a("mCashierSheetBinding");
        }
        if (!(nativeInstrumentCashierSheetBinding == null || (lottieAnimationView = nativeInstrumentCashierSheetBinding.dotProgressBar) == null)) {
            ExtensionsKt.stopLoaderAnimation(lottieAnimationView);
        }
        if (this.removeAllViews) {
            NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding2 = this.mCashierSheetBinding;
            if (nativeInstrumentCashierSheetBinding2 == null) {
                k.a("mCashierSheetBinding");
            }
            if (!(nativeInstrumentCashierSheetBinding2 == null || (linearLayout = nativeInstrumentCashierSheetBinding2.llPgInstruments) == null)) {
                linearLayout.removeAllViews();
            }
            this.removeAllViews = false;
        }
        super.inflatePaymentInstruments(list);
        showOrderInfoPopup();
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding3 = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding3 == null) {
            k.a("mCashierSheetBinding");
        }
        LinearLayout linearLayout2 = nativeInstrumentCashierSheetBinding3.lytBottomLines;
        k.a((Object) linearLayout2, "mCashierSheetBinding.lytBottomLines");
        ExtensionsKt.visible(linearLayout2);
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding4 = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding4 == null) {
            k.a("mCashierSheetBinding");
        }
        nativeInstrumentCashierSheetBinding4.llMainView.post(new InstrumentsSheet$inflatePaymentInstruments$1(this));
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding5 = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding5 == null) {
            k.a("mCashierSheetBinding");
        }
        LinearLayout linearLayout3 = nativeInstrumentCashierSheetBinding5.llPgInstruments;
        k.a((Object) linearLayout3, "mCashierSheetBinding.llPgInstruments");
        linearLayout3.getViewTreeObserver().addOnGlobalLayoutListener(new InstrumentsSheet$inflatePaymentInstruments$2(this));
    }

    /* access modifiers changed from: private */
    public final void setScrollViewToolbarVisibility(int i2) {
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding == null) {
            k.a("mCashierSheetBinding");
        }
        nativeInstrumentCashierSheetBinding.scrollView.setOnScrollChangeListener(new InstrumentsSheet$setScrollViewToolbarVisibility$1(this, i2));
    }

    /* access modifiers changed from: private */
    public final void showOrderDetails() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isDefferedCheckoutEnabled()) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            PaytmBaseView paytmBaseView = instance2.getPaytmBaseView();
            Object obj = null;
            if (paytmBaseView != null) {
                obj = paytmBaseView.getVerifyResponseModel();
            }
            DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
            k.a((Object) instance3, "DirectPaymentBL.getInstance()");
            instance3.getRequestClient().createOrderInfoFragment(new InstrumentsSheet$showOrderDetails$1(this), obj);
        }
    }

    private final void showOrderInfoPopup() {
        if (ConvenienceFeeController.Companion.getInstance().isConvenienceFeeEnabled() && !SDKUtility.isAppInvokeFlow()) {
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            if (!instance.isAddMoney() && PaytmSDK.isShowOrderInfoPopup()) {
                PaytmSDK.setShowOrderInfoPopup(false);
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 != null) {
                    if (popupWindow2 == null) {
                        k.a();
                    }
                    if (popupWindow2.isShowing()) {
                        return;
                    }
                }
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                Object systemService = context.getSystemService("layout_inflater");
                if (systemService != null) {
                    LayoutInflater layoutInflater = (LayoutInflater) systemService;
                    if (layoutInflater == null) {
                        k.a();
                    }
                    View inflate = layoutInflater.inflate(R.layout.order_info_layout, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.tvDone);
                    if (findViewById != null) {
                        findViewById.setOnClickListener(new InstrumentsSheet$showOrderInfoPopup$1(this));
                    }
                    this.popupWindow = new PopupWindow(inflate, -1, -2);
                    if (Build.VERSION.SDK_INT >= 21) {
                        PopupWindow popupWindow3 = this.popupWindow;
                        if (popupWindow3 == null) {
                            k.a();
                        }
                        popupWindow3.setElevation(5.0f);
                    }
                    PopupWindow popupWindow4 = this.popupWindow;
                    if (popupWindow4 == null) {
                        k.a();
                    }
                    popupWindow4.setOutsideTouchable(true);
                    PopupWindow popupWindow5 = this.popupWindow;
                    if (popupWindow5 == null) {
                        k.a();
                    }
                    NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = this.mCashierSheetBinding;
                    if (nativeInstrumentCashierSheetBinding == null) {
                        k.a("mCashierSheetBinding");
                    }
                    popupWindow5.showAsDropDown(nativeInstrumentCashierSheetBinding.ivDownArrow);
                    new Handler().postDelayed(new InstrumentsSheet$showOrderInfoPopup$2(this), 5000);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
            }
        }
    }

    public final void dismissPopupWindow() {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            if (popupWindow2 == null) {
                k.a();
            }
            if (popupWindow2.isShowing()) {
                PopupWindow popupWindow3 = this.popupWindow;
                if (popupWindow3 == null) {
                    k.a();
                }
                popupWindow3.dismiss();
            }
        }
    }

    public final void addViewInScrollView(View view, boolean z) {
        k.c(view, "view");
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding == null) {
            k.a("mCashierSheetBinding");
        }
        nativeInstrumentCashierSheetBinding.llPgInstruments.addView(view);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            if (z) {
                NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding2 = this.mCashierSheetBinding;
                if (nativeInstrumentCashierSheetBinding2 == null) {
                    k.a("mCashierSheetBinding");
                }
                LinearLayout linearLayout = nativeInstrumentCashierSheetBinding2.llPgInstruments;
                if (layoutInflater == null) {
                    k.a();
                }
                linearLayout.addView(layoutInflater.inflate(R.layout.line_xml, (ViewGroup) null, false));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final void onStart() {
        super.onStart();
    }

    public final void onChangeBottomSheet(String str, boolean z) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        dismiss();
    }

    public final void dismissCashier() {
        dismiss();
    }

    public final void onStop() {
        super.onStop();
        dismissPopupWindow();
    }

    public final void sendGAEvent() {
        InstrumentSheetViewModel instrumentSheetViewModel = this.mInstrumentSheetViewModel;
        if (instrumentSheetViewModel == null) {
            k.a("mInstrumentSheetViewModel");
        }
        instrumentSheetViewModel.sendGAEvent();
    }

    public final void updateTotalAmount(String str) {
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding == null) {
            k.a("mCashierSheetBinding");
        }
        TextView textView = nativeInstrumentCashierSheetBinding.txtAmount;
        k.a((Object) textView, "mCashierSheetBinding.txtAmount");
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        textView.setText(getToolbarAmount(Html.fromHtml(context.getString(R.string.nativesdk_amount, new Object[]{str})).toString()));
        StickyToolbar stickyToolbar2 = this.stickyToolbar;
        if (stickyToolbar2 == null) {
            k.a("stickyToolbar");
        }
        stickyToolbar2.setToolbarAmount(Html.fromHtml(getString(R.string.nativesdk_amount, str)).toString());
    }

    public final void removeAllViews() {
        this.removeAllViews = true;
    }

    public final void addPaymentInstruments(boolean z) {
        InstrumentSheetViewModel instrumentSheetViewModel = this.mInstrumentSheetViewModel;
        if (instrumentSheetViewModel == null) {
            k.a("mInstrumentSheetViewModel");
        }
        instrumentSheetViewModel.addPaymentViews(z);
    }

    public final NestedScrollView provideScrollView() {
        NativeInstrumentCashierSheetBinding nativeInstrumentCashierSheetBinding = this.mCashierSheetBinding;
        if (nativeInstrumentCashierSheetBinding == null) {
            k.a("mCashierSheetBinding");
        }
        NestedScrollView nestedScrollView = nativeInstrumentCashierSheetBinding.scrollView;
        k.a((Object) nestedScrollView, "mCashierSheetBinding.scrollView");
        return nestedScrollView;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final InstrumentsSheet getInstance(String str, String str2, int i2) {
            k.c(str, "primaryInfo");
            k.c(str2, "secondInfo");
            InstrumentsSheet instrumentsSheet = new InstrumentsSheet();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, str);
            bundle.putString(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, str2);
            bundle.putInt(SDKConstants.MERCHANT_LOGO, i2);
            instrumentsSheet.setArguments(bundle);
            return instrumentsSheet;
        }
    }
}
