package net.one97.paytm.nativesdk.instruments.cod.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.alipay.mobile.h5container.api.H5Param;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.cod.listeners.CodClickListener;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class CodViewModel extends BaseViewModel {
    public i<String> amount = new i<>("");
    public i<String> codDisplayName;
    private Context context;
    private CodClickListener listener;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    public ObservableInt vpaInputLayoutVisiblity;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public CodViewModel(Context context2, CodClickListener codClickListener) {
        super(context2, codClickListener);
        this.listener = codClickListener;
        this.context = context2;
        this.vpaInputLayoutVisiblity = new ObservableInt(8);
        this.codDisplayName = new i<>(DirectPaymentBL.getInstance().getInstrument(PayMethodType.COD).getDisplayName());
    }

    public void refreshLayout() {
        setAmountIfNeeded();
    }

    public void proceedToPay(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_COD, SDKConstants.GA_KEY_NEW, sb.toString(), ""));
        if (SDKUtility.shouldShowValidatePromoError()) {
            this.listener.showBankOfferText();
            return;
        }
        PaymentInstrument paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), PayUtility.getCashOnDeliveryParams());
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_COD);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_NEW);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, "COD"));
        }
        if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated()) {
            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
            new TransactionProcessor(this.context, BaseViewModel.PaymentType.COD, paymentInstrument).startTransaction(view);
            return;
        }
        Context context2 = this.context;
        if (context2 != null) {
            Toast.makeText(this.context, context2.getString(R.string.otp_not_validated), 0).show();
        }
    }

    public void codClicked(View view) {
        if (DirectPaymentBL.getInstance().lastInsufficuentAmountError != null) {
            DirectPaymentBL.getInstance().lastInsufficuentAmountError.set("");
        }
        if (this.vpaInputLayoutVisiblity.get() == 0) {
            hideBhimUpi();
            this.listener.closeKeyboard();
        } else {
            setAmountIfNeeded();
            this.radioChecked.set(true);
            this.vpaInputLayoutVisiblity.set(0);
            this.listener.showAnimation(false);
            this.listener.changeArrowIcon(true);
        }
        if (!DirectPaymentBL.getInstance().isOpeningAuto()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_COD, SDKConstants.GA_KEY_NEW));
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, "COD", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            if (DirectPaymentBL.getInstance().getPaymentFlowAvailable().equals(SDKConstants.ADDANDPAY) && DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_ADDANDPAY_CLICKED, "COD"));
            }
        }
    }

    private void setAmountIfNeeded() {
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            this.listener.changeRemainingAmt(MerchantBL.getMerchantInstance().getAmount());
        } else {
            this.listener.changeRemainingAmt(DirectPaymentBL.getInstance().getDifferentialAmount());
        }
        this.amount.set("");
    }

    public void hideBhimUpi() {
        this.amount.set("");
        this.radioChecked.set(false);
        this.vpaInputLayoutVisiblity.set(8);
        this.listener.changeArrowIcon(false);
    }
}
