package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.wallet.view.OtpView;
import net.one97.paytm.nativesdk.instruments.wallet.viewmodel.WalletViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class WalletLytInstrumentInfoBinding extends ViewDataBinding {
    public final RelativeLayout addPayHybridLayout;
    public final RelativeLayout btnProceed;
    public final FrameLayout flLoader;
    public final LinearLayout llCheckOffer;
    public final RelativeLayout llInstrumentInfo;
    public final LinearLayout llWalletBalance;
    public final LinearLayout llWalletSelectContainer;
    public final LinearLayout llWalletView;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    protected View mView;
    protected WalletViewModel mWalletViewModel;
    public final TextView paysecurely;
    public final CheckBox rbCardNumber;
    public final RoboTextView tvBankOffer;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final TextView tvSendOtp;
    public final TextView tvWalletBalance;
    public final TextView tvWalletOtpTc;
    public final RoboTextView txtAmount;
    public final TextView txtPrimaryInfo;
    public final RoboTextView txtSecondaryInfo;
    public final TextView txtamount;
    public final OtpView walletOtpView;

    public abstract void setView(View view);

    public abstract void setWalletViewModel(WalletViewModel walletViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected WalletLytInstrumentInfoBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, FrameLayout frameLayout, LinearLayout linearLayout, RelativeLayout relativeLayout3, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView, CheckBox checkBox, RoboTextView roboTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, RoboTextView roboTextView2, TextView textView7, RoboTextView roboTextView3, TextView textView8, OtpView otpView) {
        super(obj, view, i2);
        this.addPayHybridLayout = relativeLayout;
        this.btnProceed = relativeLayout2;
        this.flLoader = frameLayout;
        this.llCheckOffer = linearLayout;
        this.llInstrumentInfo = relativeLayout3;
        this.llWalletBalance = linearLayout2;
        this.llWalletSelectContainer = linearLayout3;
        this.llWalletView = linearLayout4;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.paysecurely = textView;
        this.rbCardNumber = checkBox;
        this.tvBankOffer = roboTextView;
        this.tvCheckingOffers = textView2;
        this.tvConvFee = textView3;
        this.tvSendOtp = textView4;
        this.tvWalletBalance = textView5;
        this.tvWalletOtpTc = textView6;
        this.txtAmount = roboTextView2;
        this.txtPrimaryInfo = textView7;
        this.txtSecondaryInfo = roboTextView3;
        this.txtamount = textView8;
        this.walletOtpView = otpView;
    }

    public WalletViewModel getWalletViewModel() {
        return this.mWalletViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static WalletLytInstrumentInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static WalletLytInstrumentInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (WalletLytInstrumentInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.wallet_lyt_instrument_info, viewGroup, z, obj);
    }

    public static WalletLytInstrumentInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static WalletLytInstrumentInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (WalletLytInstrumentInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.wallet_lyt_instrument_info, (ViewGroup) null, false, obj);
    }

    public static WalletLytInstrumentInfoBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static WalletLytInstrumentInfoBinding bind(View view, Object obj) {
        return (WalletLytInstrumentInfoBinding) bind(obj, view, R.layout.wallet_lyt_instrument_info);
    }
}
