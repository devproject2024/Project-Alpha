package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.transcation.viewmodel.TranscationStatusViewmodel;

public abstract class LytPaymentStatusSheetBinding extends ViewDataBinding {
    public final LottieAnimationView dotProgressBar;
    public final ImageView iconTranscationStatus;
    public final LinearLayout lytBottomLines;
    protected TranscationStatusViewmodel mTranscationViewModel;
    public final TextView txtAmount;
    public final TextView txtDecimalAmt;
    public final TextView txtTranscationStatus;

    public abstract void setTranscationViewModel(TranscationStatusViewmodel transcationStatusViewmodel);

    protected LytPaymentStatusSheetBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.dotProgressBar = lottieAnimationView;
        this.iconTranscationStatus = imageView;
        this.lytBottomLines = linearLayout;
        this.txtAmount = textView;
        this.txtDecimalAmt = textView2;
        this.txtTranscationStatus = textView3;
    }

    public TranscationStatusViewmodel getTranscationViewModel() {
        return this.mTranscationViewModel;
    }

    public static LytPaymentStatusSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static LytPaymentStatusSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LytPaymentStatusSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lyt_payment_status_sheet, viewGroup, z, obj);
    }

    public static LytPaymentStatusSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static LytPaymentStatusSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LytPaymentStatusSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lyt_payment_status_sheet, (ViewGroup) null, false, obj);
    }

    public static LytPaymentStatusSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static LytPaymentStatusSheetBinding bind(View view, Object obj) {
        return (LytPaymentStatusSheetBinding) bind(obj, view, R.layout.lyt_payment_status_sheet);
    }
}
