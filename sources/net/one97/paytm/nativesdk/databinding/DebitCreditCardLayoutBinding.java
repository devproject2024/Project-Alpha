package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.viewmodel.DebitCreditCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class DebitCreditCardLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final LinearLayout cardContainer;
    public final RelativeLayout cardTextLayout;
    public final CheckBox cbOneClick;
    public final CheckBox cbUpiCheckbox;
    public final LinearLayout emiSavedCardsContainer;
    public final LinearLayout emiSavedCardsTopLayout;
    public final EditText etCardNumber;
    public final EditText etCvv;
    public final EditText etExpiryValidity;
    public final EditText etOtpCVV;
    public final ImageView iconVscpInfo;
    public final ImageView ivCardLogo;
    public final ImageView ivCross;
    public final ImageView ivRightArrow;
    public final LinearLayout llCheckOffer;
    public final LinearLayout llNewCardLayout;
    public final LinearLayout llSaveCard;
    public final LinearLayout llUpiCheckbox;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    protected DebitCreditCardViewModel mDebitCardModel;
    protected View mView;
    public final LinearLayout newCardContainer;
    public final RelativeLayout oneClickContainer;
    public final LinearLayout otpCvvLayout;
    public final RelativeLayout otpTopLayout;
    public final TextView paysecurely;
    public final RadioButton radioButton;
    public final RelativeLayout selectBankLayout;
    public final RelativeLayout selectEmiPlanLayout;
    public final LinearLayout toplayout;
    public final RoboTextView tvBankOffer;
    public final RoboTextView tvBankOfferBottom;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final RoboTextView tvCvv;
    public final RoboTextView tvCvvHelp;
    public final RoboTextView tvEnterCardNumber;
    public final RoboTextView tvExipary;
    public final TextView tvOneClickEnabled;
    public final TextView tvOneClickMsg;
    public final TextView tvOneClickViewDetails;
    public final RoboTextView tvOtpCvvHelp;
    public final RoboTextView tvPayWithNewDebitCard;
    public final RoboTextView tvPromoMessage;
    public final TextView tvPromotion;
    public final TextView tvUpiCheckbox;
    public final RoboTextView txtDebitCreditCard;
    public final RoboTextView txtEmiSelectBank;
    public final RoboTextView txtErrMsg;
    public final RoboTextView txtSelectEmiPlan;
    public final TextView txtamount;
    public final ImageView upiIcon;
    public final RelativeLayout upiPayOption;
    public final TextView upiPayText;

    public abstract void setDebitCardModel(DebitCreditCardViewModel debitCreditCardViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected DebitCreditCardLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, CheckBox checkBox, CheckBox checkBox2, LinearLayout linearLayout2, LinearLayout linearLayout3, EditText editText, EditText editText2, EditText editText3, EditText editText4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LinearLayout linearLayout8, RelativeLayout relativeLayout3, LinearLayout linearLayout9, RelativeLayout relativeLayout4, TextView textView, RadioButton radioButton2, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, LinearLayout linearLayout10, RoboTextView roboTextView, RoboTextView roboTextView2, TextView textView2, TextView textView3, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, RoboTextView roboTextView6, TextView textView4, TextView textView5, TextView textView6, RoboTextView roboTextView7, RoboTextView roboTextView8, RoboTextView roboTextView9, TextView textView7, TextView textView8, RoboTextView roboTextView10, RoboTextView roboTextView11, RoboTextView roboTextView12, RoboTextView roboTextView13, TextView textView9, ImageView imageView5, RelativeLayout relativeLayout7, TextView textView10) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.cardContainer = linearLayout;
        this.cardTextLayout = relativeLayout2;
        this.cbOneClick = checkBox;
        this.cbUpiCheckbox = checkBox2;
        this.emiSavedCardsContainer = linearLayout2;
        this.emiSavedCardsTopLayout = linearLayout3;
        this.etCardNumber = editText;
        this.etCvv = editText2;
        this.etExpiryValidity = editText3;
        this.etOtpCVV = editText4;
        this.iconVscpInfo = imageView;
        this.ivCardLogo = imageView2;
        this.ivCross = imageView3;
        this.ivRightArrow = imageView4;
        this.llCheckOffer = linearLayout4;
        this.llNewCardLayout = linearLayout5;
        this.llSaveCard = linearLayout6;
        this.llUpiCheckbox = linearLayout7;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.newCardContainer = linearLayout8;
        this.oneClickContainer = relativeLayout3;
        this.otpCvvLayout = linearLayout9;
        this.otpTopLayout = relativeLayout4;
        this.paysecurely = textView;
        this.radioButton = radioButton2;
        this.selectBankLayout = relativeLayout5;
        this.selectEmiPlanLayout = relativeLayout6;
        this.toplayout = linearLayout10;
        this.tvBankOffer = roboTextView;
        this.tvBankOfferBottom = roboTextView2;
        this.tvCheckingOffers = textView2;
        this.tvConvFee = textView3;
        this.tvCvv = roboTextView3;
        this.tvCvvHelp = roboTextView4;
        this.tvEnterCardNumber = roboTextView5;
        this.tvExipary = roboTextView6;
        this.tvOneClickEnabled = textView4;
        this.tvOneClickMsg = textView5;
        this.tvOneClickViewDetails = textView6;
        this.tvOtpCvvHelp = roboTextView7;
        this.tvPayWithNewDebitCard = roboTextView8;
        this.tvPromoMessage = roboTextView9;
        this.tvPromotion = textView7;
        this.tvUpiCheckbox = textView8;
        this.txtDebitCreditCard = roboTextView10;
        this.txtEmiSelectBank = roboTextView11;
        this.txtErrMsg = roboTextView12;
        this.txtSelectEmiPlan = roboTextView13;
        this.txtamount = textView9;
        this.upiIcon = imageView5;
        this.upiPayOption = relativeLayout7;
        this.upiPayText = textView10;
    }

    public DebitCreditCardViewModel getDebitCardModel() {
        return this.mDebitCardModel;
    }

    public View getView() {
        return this.mView;
    }

    public static DebitCreditCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static DebitCreditCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DebitCreditCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.debit_credit_card_layout, viewGroup, z, obj);
    }

    public static DebitCreditCardLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static DebitCreditCardLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DebitCreditCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.debit_credit_card_layout, (ViewGroup) null, false, obj);
    }

    public static DebitCreditCardLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static DebitCreditCardLayoutBinding bind(View view, Object obj) {
        return (DebitCreditCardLayoutBinding) bind(obj, view, R.layout.debit_credit_card_layout);
    }
}
