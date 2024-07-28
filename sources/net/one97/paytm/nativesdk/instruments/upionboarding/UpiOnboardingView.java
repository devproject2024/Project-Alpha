package net.one97.paytm.nativesdk.instruments.upionboarding;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.vectordrawable.a.a.i;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.databinding.UpiOnboardingLayoutBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;

public class UpiOnboardingView extends PaytmBaseView {
    private UpiOnboardingViewModel model;
    /* access modifiers changed from: private */
    public UpiOnboardingLayoutBinding upiOnboardingLayoutBinding;

    public UpiOnboardingView(Context context, Instruments instruments) {
        super(instruments);
        this.context = context;
    }

    public PaytmBaseView getUpiOnBoardingView() {
        this.upiOnboardingLayoutBinding = (UpiOnboardingLayoutBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.upi_onboarding_layout, (ViewGroup) null, false);
        this.model = new UpiOnboardingViewModel(this.context);
        this.upiOnboardingLayoutBinding.setModel(this.model);
        this.view = this.upiOnboardingLayoutBinding.getRoot();
        this.upiOnboardingLayoutBinding.tvNewTxt.setBackground(setVectorForPreLollipop(R.drawable.native_ic_new, this.context));
        this.upiOnboardingLayoutBinding.parentLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UpiOnboardingView.this.selectInstrument();
            }
        });
        if (SDKUtility.isAddMoneyConvFeeFlow()) {
            this.upiOnboardingLayoutBinding.rbBankName.setText(R.string.add_money_onboarding_payment_heading);
            this.upiOnboardingLayoutBinding.txtAccount.setText(R.string.add_money_onboarding_payment_text);
            this.upiOnboardingLayoutBinding.tvNewTxt.setVisibility(8);
            this.upiOnboardingLayoutBinding.upiImage.setVisibility(8);
        } else {
            this.upiOnboardingLayoutBinding.rbBankName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.upiOnboardingLayoutBinding.upiImage.setVisibility(0);
        }
        this.upiOnboardingLayoutBinding.btnProceed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PaytmSDK.getUpiCallBackListener() != null) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.UPI_ADD_ACCOUNT_AND_PAY, MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getAmount(), MerchantBL.getMerchantInstance().getMid()));
                    int i2 = 352;
                    if (SDKUtils.isUpiProfileCreated()) {
                        i2 = SDKConstants.REQUEST_CODE_SELECT_BANK_ACCOUNT;
                    }
                    PaytmSDK.getUpiCallBackListener().startUpiOnBoarding((Activity) UpiOnboardingView.this.context, i2);
                }
            }
        });
        if (DirectPaymentBL.getInstance().getGtmStringValues() == null || TextUtils.isEmpty((String) DirectPaymentBL.getInstance().getGtmStringValues().get("offlineUpiPromotionalText"))) {
            this.upiOnboardingLayoutBinding.tvOfferText.setVisibility(8);
        } else {
            this.upiOnboardingLayoutBinding.tvOfferText.setVisibility(0);
            this.upiOnboardingLayoutBinding.tvOfferText.setText((String) DirectPaymentBL.getInstance().getGtmStringValues().get("offlineUpiPromotionalText"));
        }
        configurePromotionView();
        return this;
    }

    private Drawable setVectorForPreLollipop(int i2, Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return i.a(context.getResources(), i2, context.getTheme());
        }
        return context.getResources().getDrawable(i2, context.getTheme());
    }

    /* access modifiers changed from: private */
    public void selectInstrument() {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventUPI(SDKConstants.GA_UPI_ONBOARDING, SDKConstants.UPI_PAY_FROM_ANY_BANK, MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getAmount(), MerchantBL.getMerchantInstance().getMid()));
        SDKUtility.handlePromotionVisibility(this.upiOnboardingLayoutBinding.tvPromotion, 8);
        setSelected(true);
        DirectPaymentBL.getInstance().closeOpnedView();
        this.model.proceedButtonVisibility.set(0);
        this.upiOnboardingLayoutBinding.rbBankName.setChecked(true);
        this.upiOnboardingLayoutBinding.rbBankName.setTypeface((Typeface) null, 1);
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
        if (isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(UpiOnboardingView.this.instruments.getScrollView(), "scrollY", new int[]{(int) UpiOnboardingView.this.upiOnboardingLayoutBinding.getRoot().getY()}).setDuration(500).start();
                }
            }, 200);
        }
        isOnceClicked = true;
    }

    public void closeView() {
        setSelected(false);
        configurePromotionView();
        this.model.proceedButtonVisibility.set(8);
        this.upiOnboardingLayoutBinding.rbBankName.setChecked(false);
        this.upiOnboardingLayoutBinding.rbBankName.setTypeface((Typeface) null, 0);
    }

    public void refreshLayout() {
        this.model.setPaySecurelyText();
    }

    public void openAutoInstrument() {
        this.upiOnboardingLayoutBinding.parentLayout.performClick();
    }

    public void hideView() {
        this.upiOnboardingLayoutBinding.parentLayout.setVisibility(8);
    }

    public void showPaymentLoader() {
        this.model.showPaymentProgressbar(this.upiOnboardingLayoutBinding.btnProceed);
    }

    private void configurePromotionView() {
        if (DirectPaymentBL.getInstance().isAddMoney()) {
            this.upiOnboardingLayoutBinding.tvNewTxt.setVisibility(8);
            SDKUtility.handlePromotionVisibility(this.upiOnboardingLayoutBinding.tvPromotion, 0);
            return;
        }
        this.upiOnboardingLayoutBinding.tvNewTxt.setVisibility(0);
        SDKUtility.handlePromotionVisibility(this.upiOnboardingLayoutBinding.tvPromotion, 8);
    }
}
