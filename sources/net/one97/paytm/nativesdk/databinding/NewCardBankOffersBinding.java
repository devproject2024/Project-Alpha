package net.one97.paytm.nativesdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.transaction.newcard.BankOffersNewCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class NewCardBankOffersBinding extends ViewDataBinding {
    public final CheckBox cbOneClick;
    public final RelativeLayout emiDetailsLayout;
    public final EditText etCardNumber;
    public final EditText etCvv;
    public final EditText etExpiryValidity;
    public final EditText etOtpCVV;
    public final ImageView iconVscpInfo;
    public final ImageView imgEmiCross;
    public final ImageView ivCardLogo;
    public final ImageView ivCross;
    protected BankOffersNewCardViewModel mDebitCardModel;
    protected View mView;
    public final LinearLayout newCardContainer;
    public final RelativeLayout oneClickContainer;
    public final LinearLayout otpCvvLayout;
    public final RelativeLayout otpTopLayout;
    public final ProgressBar pbSelectPlan;
    public final LinearLayout toplayout;
    public final RoboTextView tvBankOffer;
    public final RoboTextView tvChangePlan;
    public final RoboTextView tvCvv;
    public final RoboTextView tvCvvHelp;
    public final RoboTextView tvEmiAvailbale;
    public final RoboTextView tvEnterCardNumber;
    public final RoboTextView tvExipary;
    public final TextView tvOneClickEnabled;
    public final TextView tvOneClickMsg;
    public final TextView tvOneClickViewDetails;
    public final RoboTextView tvOtpCvvHelp;
    public final RoboTextView tvPromoMessage;
    public final TextView tvSubventionOffer;
    public final RoboTextView tvTotalAmount;
    public final RoboTextView txtEmiDetails;
    public final RoboTextView txtErrMsg;

    public abstract void setDebitCardModel(BankOffersNewCardViewModel bankOffersNewCardViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected NewCardBankOffersBinding(Object obj, View view, int i2, CheckBox checkBox, RelativeLayout relativeLayout, EditText editText, EditText editText2, EditText editText3, EditText editText4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout2, RelativeLayout relativeLayout3, ProgressBar progressBar, LinearLayout linearLayout3, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, RoboTextView roboTextView6, RoboTextView roboTextView7, TextView textView, TextView textView2, TextView textView3, RoboTextView roboTextView8, RoboTextView roboTextView9, TextView textView4, RoboTextView roboTextView10, RoboTextView roboTextView11, RoboTextView roboTextView12) {
        super(obj, view, i2);
        this.cbOneClick = checkBox;
        this.emiDetailsLayout = relativeLayout;
        this.etCardNumber = editText;
        this.etCvv = editText2;
        this.etExpiryValidity = editText3;
        this.etOtpCVV = editText4;
        this.iconVscpInfo = imageView;
        this.imgEmiCross = imageView2;
        this.ivCardLogo = imageView3;
        this.ivCross = imageView4;
        this.newCardContainer = linearLayout;
        this.oneClickContainer = relativeLayout2;
        this.otpCvvLayout = linearLayout2;
        this.otpTopLayout = relativeLayout3;
        this.pbSelectPlan = progressBar;
        this.toplayout = linearLayout3;
        this.tvBankOffer = roboTextView;
        this.tvChangePlan = roboTextView2;
        this.tvCvv = roboTextView3;
        this.tvCvvHelp = roboTextView4;
        this.tvEmiAvailbale = roboTextView5;
        this.tvEnterCardNumber = roboTextView6;
        this.tvExipary = roboTextView7;
        this.tvOneClickEnabled = textView;
        this.tvOneClickMsg = textView2;
        this.tvOneClickViewDetails = textView3;
        this.tvOtpCvvHelp = roboTextView8;
        this.tvPromoMessage = roboTextView9;
        this.tvSubventionOffer = textView4;
        this.tvTotalAmount = roboTextView10;
        this.txtEmiDetails = roboTextView11;
        this.txtErrMsg = roboTextView12;
    }

    public BankOffersNewCardViewModel getDebitCardModel() {
        return this.mDebitCardModel;
    }

    public View getView() {
        return this.mView;
    }

    public static NewCardBankOffersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static NewCardBankOffersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (NewCardBankOffersBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_card_bank_offers, viewGroup, z, obj);
    }

    public static NewCardBankOffersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static NewCardBankOffersBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (NewCardBankOffersBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_card_bank_offers, (ViewGroup) null, false, obj);
    }

    public static NewCardBankOffersBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static NewCardBankOffersBinding bind(View view, Object obj) {
        return (NewCardBankOffersBinding) bind(obj, view, R.layout.new_card_bank_offers);
    }
}
