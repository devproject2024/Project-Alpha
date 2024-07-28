package net.one97.paytm.nativesdk.databinding;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.netbanking.adapter.NetBankingAdapter;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class RowNetBankingLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final CheckBox cbUpiCheckbox;
    public final FrameLayout flLoader;
    public final ImageView imgBank;
    public final ImageView imgTick;
    public final ImageView ivProceedUpi;
    public final LinearLayout llCheckOffer;
    public final LinearLayout llUpiCheckbox;
    public final LottieAnimationView ltvCheckingOffer;
    public final LottieAnimationView ltvLoading;
    public final LottieAnimationView ltvLoading1;
    protected NetBankingAdapter.NBItemViewModel mNetbanking;
    protected Typeface mTypeface;
    protected View mView;
    public final TextView paysecurely;
    public final LinearLayout procced;
    public final RoboTextView tvBankOffer;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final TextView tvDisableErrorMessage;
    public final TextView tvProceedSecurely;
    public final RoboTextView tvPromoMessage;
    public final TextView tvUpiCheckbox;
    public final RoboTextView txtAmount;
    public final RoboTextView txtBankName;
    public final TextView txtSuccessrate;
    public final ImageView upiIcon;
    public final RelativeLayout upiPayOption;
    public final TextView upiPayText;

    public abstract void setNetbanking(NetBankingAdapter.NBItemViewModel nBItemViewModel);

    public abstract void setTypeface(Typeface typeface);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected RowNetBankingLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, CheckBox checkBox, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, TextView textView, LinearLayout linearLayout3, RoboTextView roboTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoboTextView roboTextView2, TextView textView6, RoboTextView roboTextView3, RoboTextView roboTextView4, TextView textView7, ImageView imageView4, RelativeLayout relativeLayout2, TextView textView8) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.cbUpiCheckbox = checkBox;
        this.flLoader = frameLayout;
        this.imgBank = imageView;
        this.imgTick = imageView2;
        this.ivProceedUpi = imageView3;
        this.llCheckOffer = linearLayout;
        this.llUpiCheckbox = linearLayout2;
        this.ltvCheckingOffer = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.ltvLoading1 = lottieAnimationView3;
        this.paysecurely = textView;
        this.procced = linearLayout3;
        this.tvBankOffer = roboTextView;
        this.tvCheckingOffers = textView2;
        this.tvConvFee = textView3;
        this.tvDisableErrorMessage = textView4;
        this.tvProceedSecurely = textView5;
        this.tvPromoMessage = roboTextView2;
        this.tvUpiCheckbox = textView6;
        this.txtAmount = roboTextView3;
        this.txtBankName = roboTextView4;
        this.txtSuccessrate = textView7;
        this.upiIcon = imageView4;
        this.upiPayOption = relativeLayout2;
        this.upiPayText = textView8;
    }

    public NetBankingAdapter.NBItemViewModel getNetbanking() {
        return this.mNetbanking;
    }

    public View getView() {
        return this.mView;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public static RowNetBankingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static RowNetBankingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RowNetBankingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.row_net_banking_layout, viewGroup, z, obj);
    }

    public static RowNetBankingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static RowNetBankingLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RowNetBankingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.row_net_banking_layout, (ViewGroup) null, false, obj);
    }

    public static RowNetBankingLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static RowNetBankingLayoutBinding bind(View view, Object obj) {
        return (RowNetBankingLayoutBinding) bind(obj, view, R.layout.row_net_banking_layout);
    }
}
