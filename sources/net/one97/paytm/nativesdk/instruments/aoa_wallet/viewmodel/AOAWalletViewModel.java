package net.one97.paytm.nativesdk.instruments.aoa_wallet.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.i;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.aoa_wallet.listeners.AOAWalletClickListeners;
import net.one97.paytm.nativesdk.transcation.PayActivityNew;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public class AOAWalletViewModel extends BaseViewModel {
    public i<String> amount = new i<>("");
    public i<String> aoaWalletDisplayName;
    private Context context;
    private AOAWalletClickListeners listener;
    public ObservableBoolean radioChecked = new ObservableBoolean(false);
    public ObservableInt vpaInputLayoutVisiblity;

    public void completeTransaction(AppCompatActivity appCompatActivity) {
    }

    public void deselectView() {
    }

    public AOAWalletViewModel(Context context2, AOAWalletClickListeners aOAWalletClickListeners) {
        super(context2, (BaseViewActions) null);
        this.listener = aOAWalletClickListeners;
        this.context = context2;
        this.vpaInputLayoutVisiblity = new ObservableInt(8);
        this.aoaWalletDisplayName = new i<>(DirectPaymentBL.getInstance().getInstrument(PayMethodType.WALLET).getDisplayName());
    }

    public void refreshLayout() {
        setAmountIfNeeded();
    }

    public void proceedToPay(View view) {
        Context context2;
        if (SDKUtility.isHybridCase()) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_AOA_WALLET, SDKConstants.GA_KEY_HYBRID, sb.toString(), ""));
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_AOA_WALLET, SDKConstants.GA_KEY_NEW, sb2.toString(), ""));
        }
        if (SDKUtility.shouldShowValidatePromoError()) {
            this.listener.showBankOfferErrorText();
            return;
        }
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_AOA_WALLET));
        }
        if (!DirectPaymentBL.getInstance().isSubsCriptionFlow() || !DirectPaymentBL.getInstance().isWalletChecked() || DirectPaymentBL.getInstance().isWalletOtpValidated() || (context2 = this.context) == null) {
            DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
            AppCompatActivity appCompatActivity = (AppCompatActivity) this.context;
            HashMap<String, String> aoaWalletParams = PayUtility.getAoaWalletParams(PayMethodType.WALLET.name());
            Intent intent = new Intent(appCompatActivity, PayActivityNew.class);
            intent.putExtra(SDKConstants.PAYMENT_INFO, new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, aoaWalletParams));
            intent.putExtra(SDKConstants.KEY_PAYMODE, "wallet");
            appCompatActivity.startActivityForResult(intent, InstrumentActivity.PAYACTIVITY_REQUEST_CODE);
            return;
        }
        Toast.makeText(this.context, context2.getString(R.string.otp_not_validated), 0).show();
    }

    public void aoaWalletClicked(View view) {
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
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", SDKConstants.NATIVESDK_USER_CHANGES, SDKConstants.GA_KEY_AOA_WALLET, SDKConstants.GA_KEY_NEW));
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAYMODE_CLICKED, SDKConstants.AI_KEY_AOA_WALLET, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        }
    }

    private void setAmountIfNeeded() {
        if (!DirectPaymentBL.getInstance().isWalletEnabledOnMerchant() || DirectPaymentBL.getInstance().isWalletAmountSufficientToPay() || !DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            this.amount.set("");
            return;
        }
        this.amount.set(this.context.getResources().getString(R.string.nativesdk_amount, new Object[]{DirectPaymentBL.getInstance().getDifferentialAmount()}));
    }

    public void hideBhimUpi() {
        this.amount.set("");
        this.radioChecked.set(false);
        this.vpaInputLayoutVisiblity.set(8);
        this.listener.changeArrowIcon(false);
    }
}
