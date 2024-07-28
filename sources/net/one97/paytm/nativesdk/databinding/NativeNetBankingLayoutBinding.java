package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.viewmodel.NetBankingViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NativeNetBankingLayoutBinding extends ViewDataBinding {
    public final LinearLayout animationLayout;
    public final RelativeLayout btnProceed;
    public final CheckBox cbUpiCheckbox;
    public final ImageView imgBank;
    public final AppCompatImageView imgCross;
    public final ImageView imgTick;
    public final ImageView ivProceedUpiForwardNb;
    public final AppCompatImageView ivRightArrow;
    public final LinearLayout llCheckOffer;
    public final LinearLayout llUpiCheckbox;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    protected NetBankingViewModel mNetBankingViewModel;
    protected View mView;
    public final LinearLayout otherBankLayout;
    public final RadioButton radioButton;
    public final RecyclerView recyclerBankList;
    public final RoboTextView tvBankOffer;
    public final TextView tvCheckingOffers;
    public final TextView tvOtherBankConvFee;
    public final TextView tvProceedSecurely;
    public final TextView tvPromotion;
    public final TextView tvUpiCheckbox;
    public final RoboTextView txtAmount;
    public final RoboTextView txtHeaderInstrunmentName;
    public final TextView txtSelectOtherBank;
    public final TextView txtamount;
    public final ImageView upiIcon;
    public final RelativeLayout upiPayOption;
    public final TextView upiPayText;

    public abstract void setNetBankingViewModel(NetBankingViewModel netBankingViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected NativeNetBankingLayoutBinding(Object obj, View view, int i2, LinearLayout linearLayout, RelativeLayout relativeLayout, CheckBox checkBox, ImageView imageView, AppCompatImageView appCompatImageView, ImageView imageView2, ImageView imageView3, AppCompatImageView appCompatImageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LinearLayout linearLayout4, RadioButton radioButton2, RecyclerView recyclerView, RoboTextView roboTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoboTextView roboTextView2, RoboTextView roboTextView3, TextView textView6, TextView textView7, ImageView imageView4, RelativeLayout relativeLayout2, TextView textView8) {
        super(obj, view, i2);
        this.animationLayout = linearLayout;
        this.btnProceed = relativeLayout;
        this.cbUpiCheckbox = checkBox;
        this.imgBank = imageView;
        this.imgCross = appCompatImageView;
        this.imgTick = imageView2;
        this.ivProceedUpiForwardNb = imageView3;
        this.ivRightArrow = appCompatImageView2;
        this.llCheckOffer = linearLayout2;
        this.llUpiCheckbox = linearLayout3;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.otherBankLayout = linearLayout4;
        this.radioButton = radioButton2;
        this.recyclerBankList = recyclerView;
        this.tvBankOffer = roboTextView;
        this.tvCheckingOffers = textView;
        this.tvOtherBankConvFee = textView2;
        this.tvProceedSecurely = textView3;
        this.tvPromotion = textView4;
        this.tvUpiCheckbox = textView5;
        this.txtAmount = roboTextView2;
        this.txtHeaderInstrunmentName = roboTextView3;
        this.txtSelectOtherBank = textView6;
        this.txtamount = textView7;
        this.upiIcon = imageView4;
        this.upiPayOption = relativeLayout2;
        this.upiPayText = textView8;
    }

    public NetBankingViewModel getNetBankingViewModel() {
        return this.mNetBankingViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static NativeNetBankingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NativeNetBankingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NativeNetBankingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_net_banking_layout, viewGroup, z, obj);
    }

    public static NativeNetBankingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NativeNetBankingLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NativeNetBankingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.native_net_banking_layout, (ViewGroup) null, false, obj);
    }

    public static NativeNetBankingLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NativeNetBankingLayoutBinding bind(View view, Object obj) {
        return (NativeNetBankingLayoutBinding) bind(obj, view, R.layout.native_net_banking_layout);
    }
}
