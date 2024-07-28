package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.paymethods.viewmodel.LoadingInstrumentSheetViewModel;

public abstract class NativeInstrumentLoadingSheetBinding extends ViewDataBinding {
    public final LottieAnimationView dotProgressBar;
    protected LoadingInstrumentSheetViewModel mSelectedInstrumentSheetViewModel;
    public final RelativeLayout rlLoading;
    public final TextView tvFetchPaymentMethods;
    public final TextView tvPleaseWait;
    public final View vDarkBlueStrip;
    public final View vLightBlueStrip;

    public abstract void setSelectedInstrumentSheetViewModel(LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel);

    protected NativeInstrumentLoadingSheetBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout, TextView textView, TextView textView2, View view2, View view3) {
        super(obj, view, i2);
        this.dotProgressBar = lottieAnimationView;
        this.rlLoading = relativeLayout;
        this.tvFetchPaymentMethods = textView;
        this.tvPleaseWait = textView2;
        this.vDarkBlueStrip = view2;
        this.vLightBlueStrip = view3;
    }

    public LoadingInstrumentSheetViewModel getSelectedInstrumentSheetViewModel() {
        return this.mSelectedInstrumentSheetViewModel;
    }

    public static NativeInstrumentLoadingSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativeInstrumentLoadingSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativeInstrumentLoadingSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_instrument_loading_sheet, viewGroup, z, obj);
    }

    public static NativeInstrumentLoadingSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativeInstrumentLoadingSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativeInstrumentLoadingSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_instrument_loading_sheet, (ViewGroup) null, false, obj);
    }

    public static NativeInstrumentLoadingSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativeInstrumentLoadingSheetBinding bind(View view, Object obj) {
        return (NativeInstrumentLoadingSheetBinding) bind(obj, view, R.layout.native_instrument_loading_sheet);
    }
}
