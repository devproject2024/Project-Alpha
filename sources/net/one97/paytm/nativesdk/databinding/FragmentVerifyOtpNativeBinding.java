package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;
import net.one97.paytm.nativesdk.otp.viewmodel.OtpViewModel;

public abstract class FragmentVerifyOtpNativeBinding extends ViewDataBinding {
    public final TextView btnLogin;
    public final LottieAnimationView dotProgressBar;
    public final LinearLayout lytErrorOtpMsg;
    public final RelativeLayout lytSignInButton;
    public final LinearLayout lytValidatingOtp;
    protected OtpViewModel mOtpViewholder;
    public final ProgressBar pbProgress;
    public final TextView tvPhoneNumber;
    public final TextView tvResendOtp;
    public final TextView txtErrorMsg;
    public final PinEntryEditText txtPinEntry;

    public abstract void setOtpViewholder(OtpViewModel otpViewModel);

    protected FragmentVerifyOtpNativeBinding(Object obj, View view, int i2, TextView textView, LottieAnimationView lottieAnimationView, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, ProgressBar progressBar, TextView textView2, TextView textView3, TextView textView4, PinEntryEditText pinEntryEditText) {
        super(obj, view, i2);
        this.btnLogin = textView;
        this.dotProgressBar = lottieAnimationView;
        this.lytErrorOtpMsg = linearLayout;
        this.lytSignInButton = relativeLayout;
        this.lytValidatingOtp = linearLayout2;
        this.pbProgress = progressBar;
        this.tvPhoneNumber = textView2;
        this.tvResendOtp = textView3;
        this.txtErrorMsg = textView4;
        this.txtPinEntry = pinEntryEditText;
    }

    public OtpViewModel getOtpViewholder() {
        return this.mOtpViewholder;
    }

    public static FragmentVerifyOtpNativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static FragmentVerifyOtpNativeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentVerifyOtpNativeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_verify_otp_native, viewGroup, z, obj);
    }

    public static FragmentVerifyOtpNativeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static FragmentVerifyOtpNativeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentVerifyOtpNativeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_verify_otp_native, (ViewGroup) null, false, obj);
    }

    public static FragmentVerifyOtpNativeBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static FragmentVerifyOtpNativeBinding bind(View view, Object obj) {
        return (FragmentVerifyOtpNativeBinding) bind(obj, view, R.layout.fragment_verify_otp_native);
    }
}
