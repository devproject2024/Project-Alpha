package net.one97.paytm.nativesdk.orflow.transaction.ppb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.localbroadcastmanager.a.a;
import androidx.vectordrawable.a.a.i;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.databinding.PaytmBankInfoBankofferBinding;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.listeners.PaytmPaymentsBankListener;
import net.one97.paytm.nativesdk.orflow.transaction.BankOfferCardView;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public class BankOfferPaytmBankView extends PaytmBaseView implements PaytmPaymentsBankListener, BankOfferCardView {
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (SDKConstants.UNREGISTER_BROADCAST_PBP.equalsIgnoreCase(intent.getAction())) {
                BankOfferPaytmBankView.this.unregisterBroadCast(context);
            } else if (SDKConstants.REFRESH_PPB_POSTPAID_FILTER.equalsIgnoreCase(intent.getAction())) {
                BankOfferPaytmBankView.this.paymentsBankViewModel.updateBalanceAndErrorView();
            }
        }
    };
    private boolean isValid;
    /* access modifiers changed from: private */
    public BankOfferPaytmBankViewModel paymentsBankViewModel;
    private PaytmBankInfoBankofferBinding paytmPaymentsBankInfoLytBinding;
    private PaymentModes wallet;

    /* access modifiers changed from: private */
    public void openTermsAndConditionBottomSheet(String str) {
    }

    public void changeOfferTextBgColor(int i2, int i3, boolean z) {
    }

    public void disablePostPaid() {
    }

    public void disableProceedButton() {
    }

    public void enableProceedButton() {
    }

    public void hidePaymentsLoader() {
    }

    public void setTSecondaryTextColor() {
    }

    public void setTransactionDialogListener(TransactionDialogListener transactionDialogListener) {
    }

    public void setViewDeselected() {
    }

    public void setViewSelected() {
    }

    public void showAnimation(boolean z) {
    }

    public void startCheckingOfferAnimation() {
    }

    public void stopCheckingOfferAnimation() {
    }

    public void toggleProceed(boolean z) {
    }

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

    public void onProceedClick(View view) {
        this.paymentsBankViewModel.setProceedButtonView(view);
        this.paymentsBankViewModel.proceedClicked(view);
    }

    public void registerReciever(Context context, BroadcastReceiver broadcastReceiver2) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.UNREGISTER_BROADCAST);
        a.a(context.getApplicationContext()).a(broadcastReceiver2, intentFilter);
    }

    public BankOfferPaytmBankView(Context context, Instruments instruments, boolean z) {
        super(instruments);
        this.context = context;
        this.isValid = z;
        registerReciever(context, this.broadcastReceiver);
    }

    public PaytmBaseView getBankView(PaymentModes paymentModes, boolean z) {
        this.paytmPaymentsBankInfoLytBinding = (PaytmBankInfoBankofferBinding) f.a((LayoutInflater) this.context.getSystemService("layout_inflater"), R.layout.paytm_bank_info_bankoffer, (ViewGroup) null, false);
        this.wallet = paymentModes;
        this.paymentsBankViewModel = new BankOfferPaytmBankViewModel(this.context, paymentModes, this, this.isValid, z);
        this.paytmPaymentsBankInfoLytBinding.setBankViewModel(this.paymentsBankViewModel);
        enableDisableView(this.isValid);
        setTSecondaryTextColor();
        this.view = this.paytmPaymentsBankInfoLytBinding.getRoot();
        this.paytmPaymentsBankInfoLytBinding.tvNewTxt.setBackground(setVectorForPreLollipop(R.drawable.native_ic_new, this.context));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SDKConstants.REFRESH_PPB_POSTPAID_FILTER);
        a.a(this.context.getApplicationContext()).a(this.broadcastReceiver, intentFilter);
        setSelectedViewBold(Boolean.TRUE);
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

    private SpannableString getTermsSpannableString(String str, String str2, final String str3) {
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
                BankOfferPaytmBankView.this.openTermsAndConditionBottomSheet(str3);
            }
        }, indexOf, str2.length() + indexOf, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00baf2")), indexOf, str2.length() + indexOf, 33);
        return spannableString;
    }

    public void openAutoInstrument() {
        this.paymentsBankViewModel.payMethodSelected((View) null);
        isOnceClicked = true;
    }

    private void setSelectedViewBold(Boolean bool) {
        if (this.isValid && DirectPaymentBL.getInstance().getSelectedInstrument() != null && DirectPaymentBL.getInstance().getSelectedInstrument().getPrimaryName().equalsIgnoreCase(this.wallet.getDisplayName())) {
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setTypeface((Typeface) null, 1);
            this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setChecked(true);
            this.paymentsBankViewModel.setSelectedInstrument(false);
            DirectPaymentBL.getInstance().setPaytmBaseView(this);
            if (bool == null || bool.booleanValue()) {
                this.paytmPaymentsBankInfoLytBinding.bankPinLayout.setVisibility(0);
            } else if (bool != null && !bool.booleanValue()) {
                this.paytmPaymentsBankInfoLytBinding.bankPinLayout.setVisibility(8);
            }
        }
    }

    public void closeCachierSheet() {
        this.instruments.closeCashierSheet();
    }

    public void closeView() {
        deselectView();
    }

    private void enableDisableView(boolean z) {
        PaymentModes paymentModes;
        if (z) {
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setAlpha(1.0f);
            this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setEnabled(true);
            this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setFocusable(true);
            return;
        }
        this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setAlpha(0.4f);
        this.paytmPaymentsBankInfoLytBinding.txtPrimaryInfo.setAlpha(0.4f);
        this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setAlpha(0.4f);
        this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setEnabled(false);
        this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setFocusable(false);
        if (this.paymentsBankViewModel != null && (paymentModes = this.wallet) != null && paymentModes.getOnboarding()) {
            this.paymentsBankViewModel.mictLinesVisibility.set(8);
            this.paymentsBankViewModel.paybackVisibility.set(8);
            this.paymentsBankViewModel.termVisibility.set(8);
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
        this.paymentsBankViewModel.alreadyOpened = false;
        this.paytmPaymentsBankInfoLytBinding.rbCardNumber.setChecked(false);
        this.paytmPaymentsBankInfoLytBinding.bankPinLayout.setVisibility(8);
        this.paymentsBankViewModel.mictLinesVisibility.set(8);
        this.paymentsBankViewModel.paybackVisibility.set(8);
        this.paymentsBankViewModel.termVisibility.set(8);
        SDKUtility.hideKeyboard(this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode, this.context);
        this.paymentsBankViewModel.hideAmount();
        this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setText("");
        SDKUtility.collapse(this.paytmPaymentsBankInfoLytBinding.bankPinLayout);
        this.paymentsBankViewModel.bankOfferText.set("");
        this.paymentsBankViewModel.bankOfferVisibility.set(8);
        this.paymentsBankViewModel.cashBackTextVisibility.set(8);
        this.paymentsBankViewModel.cashBackText.set("");
    }

    public void hideKeyboard() {
        SDKUtility.hideKeyboard(this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode, this.context);
    }

    public void changePasscodeUi(boolean z) {
        if (z) {
            this.paytmPaymentsBankInfoLytBinding.txtErrorMsg.setTextColor(-65536);
            this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setBackgroundResource(R.drawable.edit_text_error_bg);
            return;
        }
        this.paytmPaymentsBankInfoLytBinding.txtErrorMsg.setTextColor(this.context.getResources().getColor(R.color.light_black));
        this.paytmPaymentsBankInfoLytBinding.etPaytmPasscode.setBackgroundResource(R.drawable.white_background_with_border);
    }

    public void markViewSelected() {
        DirectPaymentBL.getInstance().setPaytmBaseView(this);
    }
}
