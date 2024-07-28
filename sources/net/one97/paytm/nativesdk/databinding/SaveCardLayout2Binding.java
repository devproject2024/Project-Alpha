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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.savedCard.viewmodel.SavedCardViewModel;
import net.one97.paytm.nativesdk.widget.RoboTextView;

public abstract class SaveCardLayout2Binding extends ViewDataBinding {
    public final RelativeLayout btnProceed;
    public final CheckBox cbOneClick;
    public final CheckBox cbUpiCheckbox;
    public final LinearLayout cvvLayout;
    public final RelativeLayout emiDetailsLayout;
    public final EditText etCvv;
    public final ImageView iconVscpInfo;
    public final ImageView imgEmiCross;
    public final ImageView ivPaysecurely;
    public final ImageView ivProceedUpiForward;
    public final ImageView ivSavedCard;
    public final LinearLayout llCheckOffer;
    public final RelativeLayout llOfferView;
    public final RelativeLayout llOfferViewBottom;
    public final LinearLayout llUpiCheckbox;
    public final LottieAnimationView ltvGetOffers;
    public final LottieAnimationView ltvLoading;
    protected SavedCardViewModel mSaveCardModel;
    protected View mView;
    public final RelativeLayout oneClickContainer;
    public final TextView paysecurely;
    public final ProgressBar pbSelectPlan;
    public final RadioButton rbCardNumber;
    public final TextView textViewLowSuccess;
    public final TextView tvAppliedOffers;
    public final TextView tvAppliedOffersBottom;
    public final RoboTextView tvBankName;
    public final TextView tvBankOffer;
    public final RoboTextView tvBankOfferApplicable;
    public final TextView tvBankOfferBottom;
    public final RoboTextView tvChangePlan;
    public final TextView tvCheckingOffers;
    public final TextView tvConvFee;
    public final RoboTextView tvEmiAvailbale;
    public final TextView tvOneClickDetail;
    public final TextView tvOneClickEnabled;
    public final TextView tvOneClickMsg;
    public final RoboTextView tvPromoMessage;
    public final TextView tvPromotion;
    public final TextView tvSubventionOffer;
    public final TextView tvSubventionOfferBottom;
    public final RoboTextView tvTotalAmount;
    public final TextView tvUpiCheckbox;
    public final RoboTextView txtEmiDetails;
    public final RoboTextView txtErrMsg;
    public final TextView txtamount;
    public final ImageView upiIcon;
    public final RelativeLayout upiPayOption;
    public final TextView upiPayText;

    public abstract void setSaveCardModel(SavedCardViewModel savedCardViewModel);

    public abstract void setView(View view);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected SaveCardLayout2Binding(Object obj, View view, int i2, RelativeLayout relativeLayout, CheckBox checkBox, CheckBox checkBox2, LinearLayout linearLayout, RelativeLayout relativeLayout2, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, LinearLayout linearLayout3, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, RelativeLayout relativeLayout5, TextView textView, ProgressBar progressBar, RadioButton radioButton, TextView textView2, TextView textView3, TextView textView4, RoboTextView roboTextView, TextView textView5, RoboTextView roboTextView2, TextView textView6, RoboTextView roboTextView3, TextView textView7, TextView textView8, RoboTextView roboTextView4, TextView textView9, TextView textView10, TextView textView11, RoboTextView roboTextView5, TextView textView12, TextView textView13, TextView textView14, RoboTextView roboTextView6, TextView textView15, RoboTextView roboTextView7, RoboTextView roboTextView8, TextView textView16, ImageView imageView6, RelativeLayout relativeLayout6, TextView textView17) {
        super(obj, view, i2);
        this.btnProceed = relativeLayout;
        this.cbOneClick = checkBox;
        this.cbUpiCheckbox = checkBox2;
        this.cvvLayout = linearLayout;
        this.emiDetailsLayout = relativeLayout2;
        this.etCvv = editText;
        this.iconVscpInfo = imageView;
        this.imgEmiCross = imageView2;
        this.ivPaysecurely = imageView3;
        this.ivProceedUpiForward = imageView4;
        this.ivSavedCard = imageView5;
        this.llCheckOffer = linearLayout2;
        this.llOfferView = relativeLayout3;
        this.llOfferViewBottom = relativeLayout4;
        this.llUpiCheckbox = linearLayout3;
        this.ltvGetOffers = lottieAnimationView;
        this.ltvLoading = lottieAnimationView2;
        this.oneClickContainer = relativeLayout5;
        this.paysecurely = textView;
        this.pbSelectPlan = progressBar;
        this.rbCardNumber = radioButton;
        this.textViewLowSuccess = textView2;
        this.tvAppliedOffers = textView3;
        this.tvAppliedOffersBottom = textView4;
        this.tvBankName = roboTextView;
        this.tvBankOffer = textView5;
        this.tvBankOfferApplicable = roboTextView2;
        this.tvBankOfferBottom = textView6;
        this.tvChangePlan = roboTextView3;
        this.tvCheckingOffers = textView7;
        this.tvConvFee = textView8;
        this.tvEmiAvailbale = roboTextView4;
        this.tvOneClickDetail = textView9;
        this.tvOneClickEnabled = textView10;
        this.tvOneClickMsg = textView11;
        this.tvPromoMessage = roboTextView5;
        this.tvPromotion = textView12;
        this.tvSubventionOffer = textView13;
        this.tvSubventionOfferBottom = textView14;
        this.tvTotalAmount = roboTextView6;
        this.tvUpiCheckbox = textView15;
        this.txtEmiDetails = roboTextView7;
        this.txtErrMsg = roboTextView8;
        this.txtamount = textView16;
        this.upiIcon = imageView6;
        this.upiPayOption = relativeLayout6;
        this.upiPayText = textView17;
    }

    public SavedCardViewModel getSaveCardModel() {
        return this.mSaveCardModel;
    }

    public View getView() {
        return this.mView;
    }

    public static SaveCardLayout2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static SaveCardLayout2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SaveCardLayout2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.save_card_layout_2, viewGroup, z, obj);
    }

    public static SaveCardLayout2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static SaveCardLayout2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SaveCardLayout2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.save_card_layout_2, (ViewGroup) null, false, obj);
    }

    public static SaveCardLayout2Binding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static SaveCardLayout2Binding bind(View view, Object obj) {
        return (SaveCardLayout2Binding) bind(obj, view, R.layout.save_card_layout_2);
    }
}
