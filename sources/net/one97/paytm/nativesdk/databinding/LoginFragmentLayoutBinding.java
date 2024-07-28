package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.textfield.TextInputEditText;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.login.viewmodel.LoginViewModel;

public abstract class LoginFragmentLayoutBinding extends ViewDataBinding {
    public final TextView btnLogin;
    public final TextInputEditText etMobileNumber;
    public final ImageView ivCross;
    public final ImageView ivMerchantLogo;
    public final ImageView ivPaytmLogo;
    public final LinearLayout llLogin;
    public final LinearLayout lytPaymethods;
    public final LinearLayout lytSelectOtherOption;
    public final RelativeLayout lytSignInButton;
    protected LoginViewModel mLandingPageViewModel;
    public final FrameLayout otpFragmentContainer;
    public final ProgressBar pbProgress;
    public final RadioButton rbPaytmPayOption;
    public final RelativeLayout rlMerchantInfo;
    public final RelativeLayout rlPaytmPayOption;
    public final NestedScrollView scrollView;
    public final TextView tvAmount;
    public final TextView tvAmtTobePaid;
    public final TextView tvDecimalAmt;
    public final TextView tvErrMobileNumber;

    public abstract void setLandingPageViewModel(LoginViewModel loginViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected LoginFragmentLayoutBinding(Object obj, View view, int i2, TextView textView, TextInputEditText textInputEditText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, FrameLayout frameLayout, ProgressBar progressBar, RadioButton radioButton, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, NestedScrollView nestedScrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i2);
        this.btnLogin = textView;
        this.etMobileNumber = textInputEditText;
        this.ivCross = imageView;
        this.ivMerchantLogo = imageView2;
        this.ivPaytmLogo = imageView3;
        this.llLogin = linearLayout;
        this.lytPaymethods = linearLayout2;
        this.lytSelectOtherOption = linearLayout3;
        this.lytSignInButton = relativeLayout;
        this.otpFragmentContainer = frameLayout;
        this.pbProgress = progressBar;
        this.rbPaytmPayOption = radioButton;
        this.rlMerchantInfo = relativeLayout2;
        this.rlPaytmPayOption = relativeLayout3;
        this.scrollView = nestedScrollView;
        this.tvAmount = textView2;
        this.tvAmtTobePaid = textView3;
        this.tvDecimalAmt = textView4;
        this.tvErrMobileNumber = textView5;
    }

    public LoginViewModel getLandingPageViewModel() {
        return this.mLandingPageViewModel;
    }

    public static LoginFragmentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static LoginFragmentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LoginFragmentLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_fragment_layout, viewGroup, z, obj);
    }

    public static LoginFragmentLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static LoginFragmentLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LoginFragmentLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_fragment_layout, (ViewGroup) null, false, obj);
    }

    public static LoginFragmentLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static LoginFragmentLayoutBinding bind(View view, Object obj) {
        return (LoginFragmentLayoutBinding) bind(obj, view, R.layout.login_fragment_layout);
    }
}
