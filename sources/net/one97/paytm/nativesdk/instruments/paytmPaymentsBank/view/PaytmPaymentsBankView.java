package net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.view;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.f;
import androidx.fragment.app.q;
import androidx.localbroadcastmanager.a.a;
import androidx.vectordrawable.a.a.i;
import com.alipay.mobile.h5container.api.H5Param;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.databinding.NativesdkPaymentsBankInfoBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.listeners.PaytmPaymentsBankListener;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.viewmodel.PaytmPaymentsBankViewModel;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public class PaytmPaymentsBankView extends PaytmBaseView implements PaytmPaymentsBankListener {
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.UNREGISTER_BROADCAST_PBP.equalsIgnoreCase(intent.getAction())) {
                PaytmPaymentsBankView.this.unregisterBroadCast(context);
            } else if (SDKConstants.REFRESH_PPB_POSTPAID_FILTER.equalsIgnoreCase(intent.getAction())) {
                PaytmPaymentsBankView.this.paymentsBankViewModel.nextInstrumentOpenRequired = false;
                PaytmPaymentsBankView.this.paymentsBankViewModel.updateBalanceAndErrorView();
            }
        }
    };
    private boolean isPostPaid;
    private boolean isValid;
    /* access modifiers changed from: private */
    public PaytmPaymentsBankViewModel paymentsBankViewModel;
    private NativesdkPaymentsBankInfoBinding paytmPaymentsBankInfoLytBinding;
    private PaymentModes wallet;

    public void refreshLayout() {
        this.paymentsBankViewModel.refreshLayout();
    }

    /* access modifiers changed from: private */
    public void unregisterBroadCast(Context context) {
        try {
            a.a(context).a(this.broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void hidePaymentsLoader() {
        NativesdkPaymentsBankInfoBinding nativesdkPaymentsBankInfoBinding;
        PaytmPaymentsBankViewModel paytmPaymentsBankViewModel = this.paymentsBankViewModel;
        if (paytmPaymentsBankViewModel != null && (nativesdkPaymentsBankInfoBinding = this.paytmPaymentsBankInfoLytBinding) != null) {
            paytmPaymentsBankViewModel.hidePaymentProgressbar(nativesdkPaymentsBankInfoBinding.btnProceed);
        }
    }

    public void registerReciever(Context context, BroadcastReceiver broadcastReceiver2) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.UNREGISTER_BROADCAST);
        a.a(context.getApplicationContext()).a(broadcastReceiver2, intentFilter);
    }

    public PaytmPaymentsBankView(Context context, Instruments instruments, boolean z) {
        super(instruments);
        this.context = context;
        this.isValid = z;
        registerReciever(context, this.broadcastReceiver);
    }

    public PaytmBaseView getBankView(PaymentModes paymentModes, boolean z) {
        this.paytmPaymentsBankInfoLytBinding = (NativesdkPaymentsBankInfoBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.nativesdk_payments_bank_info, (ViewGroup) null, false);
        this.wallet = paymentModes;
        this.isPostPaid = z;
        this.paymentsBankViewModel = new PaytmPaymentsBankViewModel(this.context, paymentModes, this, this.isValid, z);
        this.paytmPaymentsBankInfoLytBinding.setBankViewModel(this.paymentsBankViewModel);
        this.paymentsBankViewModel.setProceedButtonView(this.paytmPaymentsBankInfoLytBinding.btnProceed);
        if (SDKUtility.isPayModeDisabled(paymentModes)) {
            enableDisableView(false);
        } else {
            enableDisableView(this.isValid);
        }
        setTSecondaryTextColor();
        this.view = this.paytmPaymentsBankInfoLytBinding.getRoot();
        if (paymentModes.getOnboarding()) {
            this.paytmPaymentsBankInfoLytBinding.paysecurely.setText(this.context.getString(R.string.native_accept_and_proceed));
        } else {
            this.paymentsBankViewModel.setPaySecurelyText();
        }
        this.paytmPaymentsBankInfoLytBinding.tvNewTxt.setBackground(setVectorForPreLollipop(R.drawable.native_ic_new, this.context));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.REFRESH_PPB_POSTPAID_FILTER);
        a.a(this.context.getApplicationContext()).a(this.broadcastReceiver, intentFilter);
        return this;
    }

    private Drawable setVectorForPreLollipop(int i2, Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return i.a(context.getResources(), i2, context.getTheme());
        }
        return context.getResources().getDrawable(i2, context.getTheme());
    }

    public void addOnBoardingData(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        if (cJRFetchBalanceResponse == null || cJRFetchBalanceResponse.getBody() == null || cJRFetchBalanceResponse.getBody().getMictLines() == null) {
            this.paymentsBankViewModel.mictLinesVisibility.set(8);
            return;
        }
        this.paytmPaymentsBankInfoLytBinding.llMictLines.removeAllViews();
        for (int i2 = 0; i2 < cJRFetchBalanceResponse.getBody().getMictLines().size(); i2++) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.item_mict_lines, this.paytmPaymentsBankInfoLytBinding.llMictLines, false);
            textView.setText(cJRFetchBalanceResponse.getBody().getMictLines().get(i2));
            this.paytmPaymentsBankInfoLytBinding.llMictLines.addView(textView);
        }
        this.paymentsBankViewModel.mictLinesVisibility.set(0);
        if (!TextUtils.isEmpty(cJRFetchBalanceResponse.getBody().getDisplayMessage())) {
            this.paymentsBankViewModel.paybackVisibility.set(0);
            this.paymentsBankViewModel.displayTextPostPaid.set(cJRFetchBalanceResponse.getBody().getDisplayMessage());
        } else {
            this.paymentsBankViewModel.paybackVisibility.set(8);
        }
        this.paymentsBankViewModel.termVisibility.set(0);
        String string = this.context.getString(R.string.native_terms_postpaid);
        if (cJRFetchBalanceResponse.getBody().getFullTnCDetails() == null || TextUtils.isEmpty(cJRFetchBalanceResponse.getBody().getFullTnCDetails().getLink())) {
            this.paymentsBankViewModel.termsNConditionPostPaid.set(new SpannableString(string));
            return;
        }
        this.paymentsBankViewModel.termsNConditionPostPaid.set(getTermsSpannableString(string, this.context.getString(R.string.native_terms_n_condition), cJRFetchBalanceResponse.getBody().getFullTnCDetails().getLink()));
    }

    public void toggleProceed(boolean z) {
        if (z) {
            this.paytmPaymentsBankInfoLytBinding.btnProceed.setBackgroundResource(R.drawable.nativesdk_button_click);
        } else {
            this.paytmPaymentsBankInfoLytBinding.btnProceed.setBackgroundResource(R.drawable.nativesdk_button_gray);
        }
    }

    public void disablePostPaid() {
        disableView(true);
    }

    public void setViewSelected() {
        if (SDKUtility.isAppInvokeFlow()) {
            boolean z = this.isPostPaid;
            String str = SDKConstants.AI_KEY_POSTPAID;
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, z ? str : SDKConstants.AI_KEY_PPBL, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            if (SDKConstants.ADDANDPAY.equals(DirectPaymentBL.getInstance().getPaymentFlowAvailable()) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                if (!this.isPostPaid) {
                    str = SDKConstants.AI_KEY_PPBL;
                }
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, str));
            }
        }
        SDKUtility.handlePromotionVisibility(this.paytmPaymentsBankInfoLytBinding.tvPromotion, 8);
        setSelected(true);
    }

    public void setViewDeselected() {
        SDKUtility.handlePromotionVisibility(this.paytmPaymentsBankInfoLytBinding.tvPromotion, 0);
        setSelected(false);
    }

    private String replaceTextMsg(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return "";
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str.replace(str2, str3);
    }

    private SpannableString getTermsSpannableString(String str, String str2, final String str3) {
        this.paytmPaymentsBankInfoLytBinding.tvTerms.setMovementMethod(LinkMovementMethod.getInstance());
        this.paytmPaymentsBankInfoLytBinding.tvConvFee.setMovementMethod(LinkMovementMethod.getInstance());
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return new SpannableString(str);
        }
        if (TextUtils.isEmpty(str)) {
            return new SpannableString(str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return new SpannableString(str);
        }
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(str2);
        spannableString.setSpan(new ClickableSpan() {
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }

            public void onClick(View view) {
                PaytmPaymentsBankView.this.openTermsAndConditionBottomSheet(str3);
            }
        }, indexOf, str2.length() + indexOf, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00baf2")), indexOf, str2.length() + indexOf, 33);
        return spannableString;
    }

    /* access modifiers changed from: private */
    public void openTermsAndConditionBottomSheet(String str) {
        PostPaidTCBottomSheet instance = PostPaidTCBottomSheet.getInstance(str, false);
        q a2 = ((AppCompatActivity) this.context).getSupportFragmentManager().a();
        a2.a("tAndCSheet");
        instance.show(a2, (String) null);
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_POSTPAID, SDKConstants.GA_KEY_T_N_C, "true", ""));
    }

    public void openAutoInstrument() {
        this.paymentsBankViewModel.payMethodSelected((View) null);
        isOnceClicked = true;
    }

    private void setSelectedViewBold(Boolean bool) {
        if (!this.isValid || DirectPaymentBL.getInstance().getSelectedInstrument() == null || !DirectPaymentBL.getInstance().getSelectedInstrument().getPrimaryName().equalsIgnoreCase(this.wallet.getDisplayName())) {
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 0);
            this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setChecked(false);
        } else {
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 1);
            this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setChecked(true);
            this.paymentsBankViewModel.setSelectedInstrument(false);
            DirectPaymentBL.getInstance().setPaytmBaseView(this);
            if (bool == null || bool.booleanValue()) {
                this.paytmPaymentsBankInfoLytBinding.bankPinLayout.setVisibility(0);
                this.paytmPaymentsBankInfoLytBinding.btnProceed.setVisibility(0);
            } else if (bool != null && !bool.booleanValue()) {
                this.paytmPaymentsBankInfoLytBinding.btnProceed.setVisibility(0);
                this.paytmPaymentsBankInfoLytBinding.bankPinLayout.setVisibility(8);
            }
        }
        this.paymentsBankViewModel.setSelected(true);
    }

    public void closeCachierSheet() {
        this.instruments.closeCashierSheet();
    }

    public void closeView() {
        setSelected(false);
        deselectView();
    }

    private void enableDisableView(boolean z) {
        PaymentModes paymentModes;
        if (z) {
            setDisabled(false);
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.txtSecondaryInfo.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.btnProceed.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setEnabled(true);
        } else {
            setDisabled(true);
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setAlpha(0.4f);
            this.paytmPaymentsBankInfoLytBinding.txtSecondaryInfo.setAlpha(0.4f);
            this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setAlpha(0.4f);
            this.paytmPaymentsBankInfoLytBinding.btnProceed.setAlpha(0.4f);
            this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setEnabled(false);
            if (!(this.paymentsBankViewModel == null || (paymentModes = this.wallet) == null || !paymentModes.getOnboarding())) {
                this.paymentsBankViewModel.mictLinesVisibility.set(8);
                this.paymentsBankViewModel.paybackVisibility.set(8);
                this.paymentsBankViewModel.termVisibility.set(8);
            }
        }
        this.paytmPaymentsBankInfoLytBinding.btnProceed.setEnabled(z);
    }

    public void setTSecondaryTextColor() {
        if (this.paymentsBankViewModel.mSecondaryInformation.get().equalsIgnoreCase(this.context.getString(R.string.check_balance))) {
            this.paytmPaymentsBankInfoLytBinding.txtSecondaryInfo.setTextColor(this.context.getResources().getColor(R.color.color_00b9f5));
        } else {
            this.paytmPaymentsBankInfoLytBinding.txtSecondaryInfo.setTextColor(this.context.getResources().getColor(R.color.color_666666));
        }
    }

    public void onFetchBalance(Boolean bool) {
        setTSecondaryTextColor();
        setSelectedViewBold(bool);
    }

    public void disableView(boolean z) {
        enableDisableView(!z);
    }

    public void deselectView() {
        this.paymentsBankViewModel.setSelected(false);
        this.paymentsBankViewModel.alreadyOpened = false;
        this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 0);
        this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setChecked(false);
        this.paytmPaymentsBankInfoLytBinding.bankPinLayout.setVisibility(8);
        this.paytmPaymentsBankInfoLytBinding.btnProceed.setVisibility(8);
        this.paymentsBankViewModel.convFeeTextVisibility.set(8);
        this.paymentsBankViewModel.mictLinesVisibility.set(8);
        this.paymentsBankViewModel.paybackVisibility.set(8);
        this.paymentsBankViewModel.termVisibility.set(8);
        SDKUtility.hideKeyboard(this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode, this.context);
        this.paymentsBankViewModel.hideAmount();
        this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setText("");
        SDKUtility.collapse(this.paytmPaymentsBankInfoLytBinding.bankPinLayout);
        SDKUtility.handlePromotionVisibility(this.paytmPaymentsBankInfoLytBinding.tvPromotion, 0);
        this.paymentsBankViewModel.bankOfferText.set(new SpannableString(""));
        this.paymentsBankViewModel.bankOfferVisibility.set(8);
        this.paymentsBankViewModel.cashBackTextVisibility.set(8);
        this.paymentsBankViewModel.hideLoading();
        this.paymentsBankViewModel.cashBackText.set("");
    }

    public void hideKeyboard() {
        SDKUtility.hideKeyboard(this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode, this.context);
    }

    public void changePasscodeUi(boolean z) {
        if (z) {
            this.paytmPaymentsBankInfoLytBinding.txtErrorMsg.setTextColor(Color.parseColor("#fd5c5c"));
            this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setBackgroundResource(R.drawable.edit_text_error_bg);
            return;
        }
        this.paytmPaymentsBankInfoLytBinding.txtErrorMsg.setTextColor(this.context.getResources().getColor(R.color.light_black));
        this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setBackgroundResource(R.drawable.white_background_with_border);
    }

    public void markViewSelected() {
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
    }

    public void enableProceedButton() {
        this.paytmPaymentsBankInfoLytBinding.btnProceed.setClickable(true);
        this.paytmPaymentsBankInfoLytBinding.btnProceed.setEnabled(true);
    }

    public void disableProceedButton() {
        this.paytmPaymentsBankInfoLytBinding.btnProceed.setClickable(false);
        this.paytmPaymentsBankInfoLytBinding.btnProceed.setEnabled(false);
    }

    public void startCheckingOfferAnimation() {
        SDKUtility.startAnimation(this.paytmPaymentsBankInfoLytBinding.ltvGetOffers);
    }

    public void stopCheckingOfferAnimation() {
        SDKUtility.stopAnimation(this.paytmPaymentsBankInfoLytBinding.ltvGetOffers);
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
        this.paytmPaymentsBankInfoLytBinding.tvBankOffer.setBackgroundColor(i2);
        this.paytmPaymentsBankInfoLytBinding.tvBankOffer.setTextColor(i3);
        SDKUtility.setPaddingBankOffer(this.paytmPaymentsBankInfoLytBinding.tvBankOffer, z, this.context, 15, 26, 10, 10);
    }

    public void showAnimation(boolean z) {
        if (!z && isOnceClicked) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ObjectAnimator.ofInt(PaytmPaymentsBankView.this.instruments.getScrollView(), "scrollY", new int[]{(int) PaytmPaymentsBankView.this.getView().getY()}).setDuration(500).start();
                }
            }, 100);
            SDKUtility.expand(this.paytmPaymentsBankInfoLytBinding.bankPinLayout, 100);
        }
        this.paytmPaymentsBankInfoLytBinding.cbTermsAndCondition.setChecked(true);
    }

    public Object getVerifyResponseModel() {
        return this.paymentsBankViewModel.getVerifyResponseModel();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.context != null) {
                a.a(this.context).a(this.broadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }
}
