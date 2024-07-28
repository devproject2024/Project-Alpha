package net.one97.paytm.nativesdk.common.viewmodel;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.b;
import androidx.databinding.ObservableInt;
import androidx.databinding.a;
import androidx.databinding.i;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public abstract class BaseViewModel extends a {
    public boolean applyPromoFailed;
    public i<SpannableString> bankOfferBottomText = new i<>(new SpannableString(""));
    public ObservableInt bankOfferBottomVisibility = new ObservableInt(8);
    public i<SpannableString> bankOfferText = new i<>(new SpannableString(""));
    public ObservableInt bankOfferVisibility = new ObservableInt(8);
    private Context context;
    private BaseViewActions listener;

    public @interface PaymentType {
        public static final String CARD = "card";
        public static final String COD = "cod";
        public static final String GIFT_VOUCHER = "Gift Voucher";
        public static final String NB = "Net banking";
        public static final String NEW_BANK_MANDATE = "BANK_MANDATE ";
        public static final String POSTPAID = "postpaid";
        public static final String PPB = "ppb";
        public static final String SAVED_BANK_MANDATE = "SAVED_BANK_MANDATE";
        public static final String UPI_COLLECT = "upi_collect";
        public static final String UPI_INTENT = "upi_intent";
        public static final String UPI_PUSH = "upi_push";
        public static final String WALLET = "wallet";
    }

    public abstract void completeTransaction(AppCompatActivity appCompatActivity);

    public abstract void deselectView();

    public boolean isEmiHybridDisabled() {
        return false;
    }

    public boolean isHybridDisabled() {
        return false;
    }

    public BaseViewModel(Context context2, BaseViewActions baseViewActions) {
        this.context = context2;
        this.listener = baseViewActions;
    }

    /* access modifiers changed from: protected */
    public boolean isNativeJsonFlowEnabled() {
        return DirectPaymentBL.getInstance().isNativeJsonRequestSupported();
    }

    public void showPaymentProgressbar(View view) {
        if (view == null) {
            return;
        }
        if (view.findViewById(R.id.ltv_loading) != null || view.findViewById(R.id.ltv_loading1) != null) {
            view.setBackgroundResource(R.drawable.native_button_onloading);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading);
            if (lottieAnimationView == null) {
                lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading1);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.playAnimation();
            }
            if (view.findViewById(R.id.ivPaysecurely) != null) {
                view.findViewById(R.id.ivPaysecurely).setVisibility(8);
            }
            if (view.findViewById(R.id.paysecurely) != null) {
                view.findViewById(R.id.paysecurely).setVisibility(4);
            }
            if (view.findViewById(R.id.tv_proceed_securely) != null) {
                view.findViewById(R.id.tv_proceed_securely).setVisibility(4);
            }
            if (view.findViewById(R.id.paysecurely2) != null) {
                view.findViewById(R.id.paysecurely2).setVisibility(4);
            }
        }
    }

    public void hidePaymentProgressbar(View view) {
        if (view == null) {
            return;
        }
        if (view.findViewById(R.id.ltv_loading) != null || view.findViewById(R.id.ltv_loading1) != null) {
            view.setBackgroundResource(R.drawable.nativesdk_button_click);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading);
            if (lottieAnimationView == null) {
                lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading1);
            }
            if (lottieAnimationView != null) {
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.loop(true);
                lottieAnimationView.pauseAnimation();
                lottieAnimationView.setVisibility(8);
            }
            if (view.findViewById(R.id.paysecurely) != null) {
                view.findViewById(R.id.paysecurely).setVisibility(0);
            }
            if (view.findViewById(R.id.tv_proceed_securely) != null) {
                view.findViewById(R.id.tv_proceed_securely).setVisibility(0);
            }
            if (view.findViewById(R.id.paysecurely2) != null) {
                view.findViewById(R.id.paysecurely2).setVisibility(0);
            }
        }
    }

    public void setValidatePromoText() {
        if (SDKUtility.shouldShowValidatePromoError()) {
            if (SDKUtility.isBankOfferBottom().booleanValue()) {
                this.bankOfferBottomVisibility.set(0);
                this.bankOfferBottomText.set(new SpannableString(this.context.getString(R.string.applied_promocode_not_valid)));
            } else {
                this.bankOfferVisibility.set(0);
                this.bankOfferText.set(new SpannableString(this.context.getString(R.string.applied_promocode_not_valid)));
            }
            this.applyPromoFailed = true;
            BaseViewActions baseViewActions = this.listener;
            if (baseViewActions != null) {
                baseViewActions.changeOfferTextBgColor(b.c(this.context, R.color.white), b.c(this.context, R.color.color_fd5c5c), true);
            }
        }
    }
}
