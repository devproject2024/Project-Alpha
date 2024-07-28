package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.wallet.widgets.StickyToolbar;
import net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel;
import net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar;

public abstract class NativeInstrumentCashierSheetBinding extends ViewDataBinding {
    public final View clBankOffers;
    public final CustomInstrumentsToolbar customHeaderToolbar;
    public final LottieAnimationView dotProgressBar;
    public final LinearLayout instrumentsContainer;
    public final ImageView ivBackArrow;
    public final ImageView ivDownArrow;
    public final ImageView ivFooterLogos;
    public final ImageView ivMerchantLogo;
    public final LinearLayout llMainView;
    public final LinearLayout llPgInstruments;
    public final LinearLayout logoToolbar;
    public final LinearLayout lytBottomLines;
    protected InstrumentSheetViewModel mInstrumentSheetViewModel;
    public final RelativeLayout mainToolbar;
    public final NestedScrollView scrollView;
    public final StickyToolbar stickyToolbar;
    public final TextView tvSubsZeroAmountLabel;
    public final TextView txtAmount;
    public final TextView txtOrderDetail;
    public final TextView txtTitle;
    public final View vEmptyView;

    public abstract void setInstrumentSheetViewModel(InstrumentSheetViewModel instrumentSheetViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected NativeInstrumentCashierSheetBinding(Object obj, View view, int i2, View view2, CustomInstrumentsToolbar customInstrumentsToolbar, LottieAnimationView lottieAnimationView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, RelativeLayout relativeLayout, NestedScrollView nestedScrollView, StickyToolbar stickyToolbar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view3) {
        super(obj, view, i2);
        this.clBankOffers = view2;
        this.customHeaderToolbar = customInstrumentsToolbar;
        this.dotProgressBar = lottieAnimationView;
        this.instrumentsContainer = linearLayout;
        this.ivBackArrow = imageView;
        this.ivDownArrow = imageView2;
        this.ivFooterLogos = imageView3;
        this.ivMerchantLogo = imageView4;
        this.llMainView = linearLayout2;
        this.llPgInstruments = linearLayout3;
        this.logoToolbar = linearLayout4;
        this.lytBottomLines = linearLayout5;
        this.mainToolbar = relativeLayout;
        this.scrollView = nestedScrollView;
        this.stickyToolbar = stickyToolbar2;
        this.tvSubsZeroAmountLabel = textView;
        this.txtAmount = textView2;
        this.txtOrderDetail = textView3;
        this.txtTitle = textView4;
        this.vEmptyView = view3;
    }

    public InstrumentSheetViewModel getInstrumentSheetViewModel() {
        return this.mInstrumentSheetViewModel;
    }

    public static NativeInstrumentCashierSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativeInstrumentCashierSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativeInstrumentCashierSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_instrument_cashier_sheet, viewGroup, z, obj);
    }

    public static NativeInstrumentCashierSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativeInstrumentCashierSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativeInstrumentCashierSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_instrument_cashier_sheet, (ViewGroup) null, false, obj);
    }

    public static NativeInstrumentCashierSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativeInstrumentCashierSheetBinding bind(View view, Object obj) {
        return (NativeInstrumentCashierSheetBinding) bind(obj, view, R.layout.native_instrument_cashier_sheet);
    }
}
