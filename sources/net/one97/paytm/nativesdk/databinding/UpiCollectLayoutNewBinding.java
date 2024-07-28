package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.upicollect.viewmodel.UpiCollectViewModelNew;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class UpiCollectLayoutNewBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final RelativeLayout btnProceed2;
    public final RelativeLayout cardTextLayout;
    public final FrameLayout disableClickViewUpi;
    public final EditText etDummy;
    public final EditText etUpiAddress;
    public final FrameLayout flLoader;
    public final FrameLayout flLoader1;
    public final ImageView ivRightArrow;
    public final ImageView ivVerified;
    public final LinearLayout llCheckForOffers;
    public final LinearLayout llCheckOffer;
    public final LinearLayout llCheckOffer1;
    public final LinearLayout llUpiIntent;
    public final LinearLayout llVerifyVpaContainer;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvGetOffers1;
    public final LottieAnimationView ltvLoading;
    public final LottieAnimationView ltvLoading1;
    protected UpiCollectViewModelNew mUpiCollectModel;
    protected View mView;
    public final TextView paysecurely;
    public final TextView paysecurely2;
    public final RadioButton radioButton;
    public final RecyclerView rvUpiApps;
    public final RelativeLayout topLayout;
    public final RoboTextView tvBankOffer;
    public final TextView tvCheckForOffers;
    public final TextView tvCheckingOffers;
    public final TextView tvCheckingOffers1;
    public final TextView tvConvFee;
    public final TextView tvConvFee1;
    public final TextView tvDisableErrorMessageCollect;
    public final TextView tvDisableErrorMessageIntent;
    public final RoboTextView tvEnterUpiVpa;
    public final TextView tvError;
    public final TextView tvOr;
    public final TextView tvPromotion;
    public final TextView tvSelectUpiApp;
    public final TextView tvVerifyVpa;
    public final TextView tvVpaDesc;
    public final RoboTextView txtBhimUpi;
    public final RoboTextView txtErrorMsg;
    public final RoboTextView txtHowItWorks;
    public final TextView txtamount;
    public final ProgressBar verifyProgressbar;

    public abstract void setUpiCollectModel(UpiCollectViewModelNew upiCollectViewModelNew);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected UpiCollectLayoutNewBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, FrameLayout frameLayout, EditText editText, EditText editText2, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, LottieAnimationView lottieAnimationView4, TextView textView, TextView textView2, RadioButton radioButton2, RecyclerView recyclerView, RelativeLayout relativeLayout4, RoboTextView roboTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, RoboTextView roboTextView2, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, TextView textView16, ProgressBar progressBar) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.btnProceed2 = relativeLayout2;
        this.cardTextLayout = relativeLayout3;
        this.disableClickViewUpi = frameLayout;
        this.etDummy = editText;
        this.etUpiAddress = editText2;
        this.flLoader = frameLayout2;
        this.flLoader1 = frameLayout3;
        this.ivRightArrow = imageView;
        this.ivVerified = imageView2;
        this.llCheckForOffers = linearLayout;
        this.llCheckOffer = linearLayout2;
        this.llCheckOffer1 = linearLayout3;
        this.llUpiIntent = linearLayout4;
        this.llVerifyVpaContainer = linearLayout5;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvGetOffers1 = lottieAnimationView2;
        this.ltvLoading = lottieAnimationView3;
        this.ltvLoading1 = lottieAnimationView4;
        this.paysecurely = textView;
        this.paysecurely2 = textView2;
        this.radioButton = radioButton2;
        this.rvUpiApps = recyclerView;
        this.topLayout = relativeLayout4;
        this.tvBankOffer = roboTextView;
        this.tvCheckForOffers = textView3;
        this.tvCheckingOffers = textView4;
        this.tvCheckingOffers1 = textView5;
        this.tvConvFee = textView6;
        this.tvConvFee1 = textView7;
        this.tvDisableErrorMessageCollect = textView8;
        this.tvDisableErrorMessageIntent = textView9;
        this.tvEnterUpiVpa = roboTextView2;
        this.tvError = textView10;
        this.tvOr = textView11;
        this.tvPromotion = textView12;
        this.tvSelectUpiApp = textView13;
        this.tvVerifyVpa = textView14;
        this.tvVpaDesc = textView15;
        this.txtBhimUpi = roboTextView3;
        this.txtErrorMsg = roboTextView4;
        this.txtHowItWorks = roboTextView5;
        this.txtamount = textView16;
        this.verifyProgressbar = progressBar;
    }

    public UpiCollectViewModelNew getUpiCollectModel() {
        return this.mUpiCollectModel;
    }

    public View getView() {
        return this.mView;
    }

    public static UpiCollectLayoutNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static UpiCollectLayoutNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UpiCollectLayoutNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_collect_layout_new, viewGroup, z, obj);
    }

    public static UpiCollectLayoutNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static UpiCollectLayoutNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UpiCollectLayoutNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.upi_collect_layout_new, (ViewGroup) null, false, obj);
    }

    public static UpiCollectLayoutNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static UpiCollectLayoutNewBinding bind(View view, Object obj) {
        return (UpiCollectLayoutNewBinding) bind(obj, view, R.layout.upi_collect_layout_new);
    }
}
