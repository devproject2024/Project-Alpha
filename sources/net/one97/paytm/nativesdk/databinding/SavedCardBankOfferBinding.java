package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.transaction.savedcard.BankOfferSavedCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class SavedCardBankOfferBinding extends ViewDataBinding {
    public final CheckBox cbOneClick;
    public final LinearLayout cvvLayout;
    public final RelativeLayout emiDetailsLayout;
    public final EditText etCvv;
    public final ImageView iconVscpInfo;
    public final ImageView imgEmiCross;
    public final ImageView ivSavedCard;
    public final LinearLayout llEmiView;
    protected BankOfferSavedCardViewModel mSaveCardModel;
    protected View mView;
    public final RelativeLayout oneClickContainer;
    public final ProgressBar pbSelectPlan;
    public final RadioButton rbCardNumber;
    public final RadioButton rbSavedCardAtmPin;
    public final RadioButton rbSavedCardOtp;
    public final TextView textViewLowSuccess;
    public final RoboTextView tvBankName;
    public final RoboTextView tvBankOffer;
    public final RoboTextView tvBankOfferApplicable;
    public final RoboTextView tvChangePlan;
    public final RoboTextView tvEmiAvailbale;
    public final TextView tvEmiBankName;
    public final TextView tvEmiPlanDetail;
    public final TextView tvOneClickDetail;
    public final TextView tvOneClickEnabled;
    public final TextView tvOneClickMsg;
    public final TextView tvPlanTotalAmount;
    public final RoboTextView tvPromoMessage;
    public final TextView tvSubventionOffer;
    public final RoboTextView tvTotalAmount;
    public final RadioGroup twoModeAuthLayout;
    public final RoboTextView txtAtmPinText;
    public final RoboTextView txtEmiDetails;
    public final RoboTextView txtErrMsg;
    public final RoboTextView txtOtpText;
    public final TextView txtamount;

    public abstract void setSaveCardModel(BankOfferSavedCardViewModel bankOfferSavedCardViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected SavedCardBankOfferBinding(Object obj, View view, int i2, CheckBox checkBox, LinearLayout linearLayout, RelativeLayout relativeLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, RelativeLayout relativeLayout2, ProgressBar progressBar, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RoboTextView roboTextView6, TextView textView8, RoboTextView roboTextView7, RadioGroup radioGroup, RoboTextView roboTextView8, RoboTextView roboTextView9, RoboTextView roboTextView10, RoboTextView roboTextView11, TextView textView9) {
        super(obj, view, i2);
        this.cbOneClick = checkBox;
        this.cvvLayout = linearLayout;
        this.emiDetailsLayout = relativeLayout;
        this.etCvv = editText;
        this.iconVscpInfo = imageView;
        this.imgEmiCross = imageView2;
        this.ivSavedCard = imageView3;
        this.llEmiView = linearLayout2;
        this.oneClickContainer = relativeLayout2;
        this.pbSelectPlan = progressBar;
        this.rbCardNumber = radioButton;
        this.rbSavedCardAtmPin = radioButton2;
        this.rbSavedCardOtp = radioButton3;
        this.textViewLowSuccess = textView;
        this.tvBankName = roboTextView;
        this.tvBankOffer = roboTextView2;
        this.tvBankOfferApplicable = roboTextView3;
        this.tvChangePlan = roboTextView4;
        this.tvEmiAvailbale = roboTextView5;
        this.tvEmiBankName = textView2;
        this.tvEmiPlanDetail = textView3;
        this.tvOneClickDetail = textView4;
        this.tvOneClickEnabled = textView5;
        this.tvOneClickMsg = textView6;
        this.tvPlanTotalAmount = textView7;
        this.tvPromoMessage = roboTextView6;
        this.tvSubventionOffer = textView8;
        this.tvTotalAmount = roboTextView7;
        this.twoModeAuthLayout = radioGroup;
        this.txtAtmPinText = roboTextView8;
        this.txtEmiDetails = roboTextView9;
        this.txtErrMsg = roboTextView10;
        this.txtOtpText = roboTextView11;
        this.txtamount = textView9;
    }

    public BankOfferSavedCardViewModel getSaveCardModel() {
        return this.mSaveCardModel;
    }

    public View getView() {
        return this.mView;
    }

    public static SavedCardBankOfferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static SavedCardBankOfferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SavedCardBankOfferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.saved_card_bank_offer, viewGroup, z, obj);
    }

    public static SavedCardBankOfferBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static SavedCardBankOfferBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SavedCardBankOfferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.saved_card_bank_offer, (ViewGroup) null, false, obj);
    }

    public static SavedCardBankOfferBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static SavedCardBankOfferBinding bind(View view, Object obj) {
        return (SavedCardBankOfferBinding) bind(obj, view, R.layout.saved_card_bank_offer);
    }
}
