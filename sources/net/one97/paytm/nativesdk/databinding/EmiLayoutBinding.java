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
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.emi.viewmodel.EmiViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class EmiLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final EditText etCardNumber;
    public final EditText etCvv;
    public final EditText etExpiryValidity;
    public final FrameLayout flLoader;
    public final ImageView imgEmiCross;
    public final ImageView ivArrow;
    public final ImageView ivCardLogo;
    public final ImageView ivCross;
    public final ImageView ivSavedCard;
    public final ImageView ivSelectEmiArrow;
    public final LinearLayout llCheckOffer;
    public final LinearLayout llCvvLayout;
    public final LinearLayout llSavedCardContainer;
    public final LinearLayout llUseAnotherCard;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    protected EmiViewModel mEmiViewModel;
    protected View mView;
    public final TextView paysecurely;
    public final ProgressBar pbSelectBank;
    public final ProgressBar pbSelectEmiPlan;
    public final RadioButton radioButton;
    public final RadioButton rbAnotherCard;
    public final RelativeLayout rlAllOffers;
    public final RelativeLayout rlCardNumber;
    public final RelativeLayout rlCardView;
    public final RelativeLayout rlCreditCardNumber;
    public final RelativeLayout rlNameLayout;
    public final RelativeLayout rlSelectBank;
    public final RelativeLayout rlSelectEMIPlan;
    public final TextView tnc;
    public final TextView tvAddedBankName;
    public final RelativeLayout tvAddedEmiDetails;
    public final RoboTextView tvAddedEmiInfo;
    public final RoboTextView tvAddedTotalAmount;
    public final TextView tvAppliedOffers;
    public final RoboTextView tvBankName;
    public final TextView tvBankOffer;
    public final TextView tvChangeBankCard;
    public final RoboTextView tvChangePlan;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final RoboTextView tvCvvHelp;
    public final TextView tvSubventionOffer;
    public final TextView tvUseAnother;
    public final RoboTextView txtDebitCreditCard;
    public final RoboTextView txtEmiSelectBank;
    public final RoboTextView txtSelectEmiPlan;
    public final TextView txtamount;

    public abstract void setEmiViewModel(EmiViewModel emiViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected EmiLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, EditText editText, EditText editText2, EditText editText3, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView, ProgressBar progressBar, ProgressBar progressBar2, RadioButton radioButton2, RadioButton radioButton3, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, TextView textView2, TextView textView3, RelativeLayout relativeLayout9, RoboTextView roboTextView, RoboTextView roboTextView2, TextView textView4, RoboTextView roboTextView3, TextView textView5, TextView textView6, RoboTextView roboTextView4, TextView textView7, TextView textView8, RoboTextView roboTextView5, TextView textView9, TextView textView10, RoboTextView roboTextView6, RoboTextView roboTextView7, RoboTextView roboTextView8, TextView textView11) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.etCardNumber = editText;
        this.etCvv = editText2;
        this.etExpiryValidity = editText3;
        this.flLoader = frameLayout;
        this.imgEmiCross = imageView;
        this.ivArrow = imageView2;
        this.ivCardLogo = imageView3;
        this.ivCross = imageView4;
        this.ivSavedCard = imageView5;
        this.ivSelectEmiArrow = imageView6;
        this.llCheckOffer = linearLayout;
        this.llCvvLayout = linearLayout2;
        this.llSavedCardContainer = linearLayout3;
        this.llUseAnotherCard = linearLayout4;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.paysecurely = textView;
        this.pbSelectBank = progressBar;
        this.pbSelectEmiPlan = progressBar2;
        this.radioButton = radioButton2;
        this.rbAnotherCard = radioButton3;
        this.rlAllOffers = relativeLayout2;
        this.rlCardNumber = relativeLayout3;
        this.rlCardView = relativeLayout4;
        this.rlCreditCardNumber = relativeLayout5;
        this.rlNameLayout = relativeLayout6;
        this.rlSelectBank = relativeLayout7;
        this.rlSelectEMIPlan = relativeLayout8;
        this.tnc = textView2;
        this.tvAddedBankName = textView3;
        this.tvAddedEmiDetails = relativeLayout9;
        this.tvAddedEmiInfo = roboTextView;
        this.tvAddedTotalAmount = roboTextView2;
        this.tvAppliedOffers = textView4;
        this.tvBankName = roboTextView3;
        this.tvBankOffer = textView5;
        this.tvChangeBankCard = textView6;
        this.tvChangePlan = roboTextView4;
        this.tvCheckingOffers = textView7;
        this.tvConvFee = textView8;
        this.tvCvvHelp = roboTextView5;
        this.tvSubventionOffer = textView9;
        this.tvUseAnother = textView10;
        this.txtDebitCreditCard = roboTextView6;
        this.txtEmiSelectBank = roboTextView7;
        this.txtSelectEmiPlan = roboTextView8;
        this.txtamount = textView11;
    }

    public EmiViewModel getEmiViewModel() {
        return this.mEmiViewModel;
    }

    public View getView() {
        return this.mView;
    }

    public static EmiLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static EmiLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EmiLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.emi_layout, viewGroup, z, obj);
    }

    public static EmiLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static EmiLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EmiLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.emi_layout, (ViewGroup) null, false, obj);
    }

    public static EmiLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static EmiLayoutBinding bind(View view, Object obj) {
        return (EmiLayoutBinding) bind(obj, view, R.layout.emi_layout);
    }
}
