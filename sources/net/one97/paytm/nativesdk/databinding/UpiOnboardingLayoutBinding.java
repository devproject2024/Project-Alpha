package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upionboarding.UpiOnboardingViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class UpiOnboardingLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final LottieAnimationView ltvLoading;
    protected UpiOnboardingViewModel mModel;
    protected View mView;
    public final LinearLayout parentLayout;
    public final TextView paysecurely;
    public final RadioButton rbBankName;
    public final TextView tvNewTxt;
    public final RoboTextView tvOfferText;
    public final TextView tvPromotion;
    public final RoboTextView txtAccount;
    public final ImageView upiImage;

    public abstract void setModel(UpiOnboardingViewModel upiOnboardingViewModel);

    public abstract void setView(View view);

    protected UpiOnboardingLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, LottieAnimationView lottieAnimationView, LinearLayout linearLayout, TextView textView, RadioButton radioButton, TextView textView2, RoboTextView roboTextView, TextView textView3, RoboTextView roboTextView2, ImageView imageView) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.ltvLoading = lottieAnimationView;
        this.parentLayout = linearLayout;
        this.paysecurely = textView;
        this.rbBankName = radioButton;
        this.tvNewTxt = textView2;
        this.tvOfferText = roboTextView;
        this.tvPromotion = textView3;
        this.txtAccount = roboTextView2;
        this.upiImage = imageView;
    }

    public UpiOnboardingViewModel getModel() {
        return this.mModel;
    }

    public View getView() {
        return this.mView;
    }

    public static UpiOnboardingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static UpiOnboardingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpiOnboardingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_onboarding_layout, viewGroup, z, obj);
    }

    public static UpiOnboardingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static UpiOnboardingLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpiOnboardingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_onboarding_layout, (ViewGroup) null, false, obj);
    }

    public static UpiOnboardingLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static UpiOnboardingLayoutBinding bind(View view, Object obj) {
        return (UpiOnboardingLayoutBinding) bind(obj, view, R.layout.upi_onboarding_layout);
    }
}
