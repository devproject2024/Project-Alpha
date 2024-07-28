package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upipush.viewmodel.UpiPushViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class SingleVpaLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final LinearLayout llCheckBalanceContainer;
    public final LinearLayout llCheckOffer;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    public final LottieAnimationView ltvLoadingCheckbalance;
    protected UpiPushViewModel mModel;
    protected View mView;
    public final TextView paysecurely;
    public final RadioButton rbBankName;
    public final RoboTextView tvBankOffer;
    public final RoboTextView tvCheckBalance;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final TextView tvFetchingBalance;
    public final TextView tvInsufficientBalance;
    public final TextView tvPromotion;
    public final RoboTextView txtAccount;
    public final RoboTextView txtVpa;
    public final RoboTextView txtamount;
    public final LinearLayout vpaTopLayout;

    public abstract void setModel(UpiPushViewModel upiPushViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected SingleVpaLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, TextView textView, RadioButton radioButton, RoboTextView roboTextView, RoboTextView roboTextView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, LinearLayout linearLayout3) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.llCheckBalanceContainer = linearLayout;
        this.llCheckOffer = linearLayout2;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.ltvLoadingCheckbalance = lottieAnimationView3;
        this.paysecurely = textView;
        this.rbBankName = radioButton;
        this.tvBankOffer = roboTextView;
        this.tvCheckBalance = roboTextView2;
        this.tvCheckingOffers = textView2;
        this.tvConvFee = textView3;
        this.tvFetchingBalance = textView4;
        this.tvInsufficientBalance = textView5;
        this.tvPromotion = textView6;
        this.txtAccount = roboTextView3;
        this.txtVpa = roboTextView4;
        this.txtamount = roboTextView5;
        this.vpaTopLayout = linearLayout3;
    }

    public UpiPushViewModel getModel() {
        return this.mModel;
    }

    public View getView() {
        return this.mView;
    }

    public static SingleVpaLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static SingleVpaLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SingleVpaLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.single_vpa_layout, viewGroup, z, obj);
    }

    public static SingleVpaLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static SingleVpaLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SingleVpaLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.single_vpa_layout, (ViewGroup) null, false, obj);
    }

    public static SingleVpaLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static SingleVpaLayoutBinding bind(View view, Object obj) {
        return (SingleVpaLayoutBinding) bind(obj, view, R.layout.single_vpa_layout);
    }
}
