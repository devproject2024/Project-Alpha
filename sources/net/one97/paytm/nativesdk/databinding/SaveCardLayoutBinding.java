package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.SaveDebitCreditCardModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class SaveCardLayoutBinding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final LinearLayout cvvLayout;
    public final RelativeLayout emiDetailsLayout;
    public final EditText etCvv;
    public final ImageView imgEmiCross;
    public final ImageView ivSavedCard;
    public final LottieAnimationView ltvLoading;
    protected SaveDebitCreditCardModel mSaveCardModel;
    protected View mView;
    public final TextView paysecurely;
    public final RadioButton rbCardNumber;
    public final RadioButton rbSavedCardAtmPin;
    public final RadioButton rbSavedCardOtp;
    public final TextView textViewLowSuccess;
    public final RoboTextView tvBankName;
    public final RoboTextView tvChangePlan;
    public final RoboTextView tvEmiAvailbale;
    public final TextView tvOfferText;
    public final RoboTextView tvPromoMessage;
    public final RoboTextView tvTotalAmount;
    public final RadioGroup twoModeAuthLayout;
    public final RoboTextView txtAtmPinText;
    public final RoboTextView txtEmiDetails;
    public final RoboTextView txtErrMsg;
    public final RoboTextView txtOtpText;
    public final TextView txtamount;

    public abstract void setSaveCardModel(SaveDebitCreditCardModel saveDebitCreditCardModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected SaveCardLayoutBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, LinearLayout linearLayout, RelativeLayout relativeLayout2, EditText editText, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView2, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, TextView textView3, RoboTextView roboTextView4, RoboTextView roboTextView5, RadioGroup radioGroup, RoboTextView roboTextView6, RoboTextView roboTextView7, RoboTextView roboTextView8, RoboTextView roboTextView9, TextView textView4) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.cvvLayout = linearLayout;
        this.emiDetailsLayout = relativeLayout2;
        this.etCvv = editText;
        this.imgEmiCross = imageView;
        this.ivSavedCard = imageView2;
        this.ltvLoading = lottieAnimationView;
        this.paysecurely = textView;
        this.rbCardNumber = radioButton;
        this.rbSavedCardAtmPin = radioButton2;
        this.rbSavedCardOtp = radioButton3;
        this.textViewLowSuccess = textView2;
        this.tvBankName = roboTextView;
        this.tvChangePlan = roboTextView2;
        this.tvEmiAvailbale = roboTextView3;
        this.tvOfferText = textView3;
        this.tvPromoMessage = roboTextView4;
        this.tvTotalAmount = roboTextView5;
        this.twoModeAuthLayout = radioGroup;
        this.txtAtmPinText = roboTextView6;
        this.txtEmiDetails = roboTextView7;
        this.txtErrMsg = roboTextView8;
        this.txtOtpText = roboTextView9;
        this.txtamount = textView4;
    }

    public SaveDebitCreditCardModel getSaveCardModel() {
        return this.mSaveCardModel;
    }

    public View getView() {
        return this.mView;
    }

    public static SaveCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static SaveCardLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SaveCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.save_card_layout, viewGroup, z, obj);
    }

    public static SaveCardLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static SaveCardLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SaveCardLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.save_card_layout, (ViewGroup) null, false, obj);
    }

    public static SaveCardLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static SaveCardLayoutBinding bind(View view, Object obj) {
        return (SaveCardLayoutBinding) bind(obj, view, R.layout.save_card_layout);
    }
}
