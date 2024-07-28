package net.one97.paytm.nativesdk.orflow.transaction.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.NativeOtpHelper;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.listeners.ActivityInteractor;
import net.one97.paytm.nativesdk.common.listeners.OtpListener;
import net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor;
import net.one97.paytm.nativesdk.common.view.activity.BaseActivity;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment;
import net.one97.paytm.nativesdk.orflow.transaction.fragment.BankOfferTransactionFragment;
import net.one97.paytm.nativesdk.orflow.transaction.fragment.DebitCardTransactionDialog;
import net.one97.paytm.nativesdk.orflow.transaction.fragment.TransactionErrorFragment;
import net.one97.paytm.nativesdk.transcation.PayFragment;
import net.one97.paytm.nativesdk.widget.RetryBottomSheet;

public class BankOfferTransactionActivity extends BaseActivity implements PaytmSDKRequestClient.OnCheckoutResponse, ActivityInteractor, PayFragmentInteractor {
    private boolean disableUiInteraction = false;

    public void addPageVisibleGAEvent() {
    }

    public void disableSelectedUpiPayOption(String str) {
    }

    public void onCheckoutSuccess(PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData) {
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    public void saveActivityFromFinish(String str) {
    }

    public boolean shouldKillActivity() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_offer_transaction);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        Utility.INSTANCE.updateTxnAmountPaymentIntent();
        addTransactionBottomSheet();
        NativeOtpHelper nativeOtpHelper = new NativeOtpHelper(this, (OtpListener) null);
        if (nativeOtpHelper.hasReadSmsPermission() && !nativeOtpHelper.hasOnlyReceiveSmsPermission()) {
            nativeOtpHelper.requestReceiveSmsPermission();
        }
        if (!nativeOtpHelper.hasReadSmsPermission() && nativeOtpHelper.hasOnlyReceiveSmsPermission()) {
            nativeOtpHelper.requestReadSmsPermission();
        }
    }

    private void addTransactionBottomSheet() {
        if (PromoHelper.Companion.getInstance().getSelectedPaymentInstrument() == null) {
            finish();
            return;
        }
        int viewtype = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getVIEWTYPE();
        if (viewtype == 0 || viewtype == 2) {
            PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().setTransactionType(PromoPayOptionAdapterParam.TransactionType.UserInput);
            DebitCardTransactionDialog.Companion.getInstance(PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getVIEWTYPE()).show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
        } else if (viewtype != 5 && viewtype != 6) {
            PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().setTransactionType(PromoPayOptionAdapterParam.TransactionType.NonUserInput);
            new BankOfferTransactionFragment().show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
        } else if (PromoHelper.Companion.getInstance().getSelectedPaymentInstrument() == null || PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getFetchBalanceResponse() == null || PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getFetchBalanceResponse().getBody() == null) {
            onPaymentFailed("", "", (TransactionProcessor) null);
        } else if (PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getFetchBalanceResponse().getBody().getPasscodeRequired() == null || PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getFetchBalanceResponse().getBody().getPasscodeRequired().booleanValue()) {
            PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().setTransactionType(PromoPayOptionAdapterParam.TransactionType.UserInput);
            DebitCardTransactionDialog.Companion.getInstance(PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getVIEWTYPE()).show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
        } else {
            PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().setTransactionType(PromoPayOptionAdapterParam.TransactionType.NonUserInput);
            new BankOfferTransactionFragment().show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
        }
    }

    public void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(PayFragment.class.getSimpleName());
        if (c2 instanceof PayFragment) {
            ((PayFragment) c2).onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        String str3;
        super.onActivityResult(i2, i3, intent);
        if (i2 == InstrumentActivity.PAYACTIVITY_REQUEST_CODE && i3 == InstrumentActivity.SHOW_ALERT) {
            if (intent != null) {
                onPaymentFailed(intent.getStringExtra("data"), "", (TransactionProcessor) null);
            }
        } else if (i2 == 1002) {
            if (i3 == -1) {
                str3 = intent.getStringExtra("upi_mpin");
                str2 = intent.getStringExtra("seq_no");
                str = intent.getStringExtra("device_id");
            } else {
                str3 = "";
                str2 = str3;
                str = str2;
            }
            if (TextUtils.isEmpty(str3)) {
                onPaymentFailed(getString(R.string.error_backpress_mpin_screen), "", (TransactionProcessor) null);
            } else if (getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName()) != null) {
                ((BaseBankOfferFragment) getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName())).makeUpiPushPayment(str3, str2, str);
            }
        } else if (getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName()) != null) {
            ((BaseBankOfferFragment) getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName())).onActivityResult(i2, i3, intent);
        }
    }

    public void addDebitCardTransactionFragment() {
        DebitCardTransactionDialog.Companion.getInstance(PromoHelper.Companion.getInstance().getSelectedPaymentInstrument().getVIEWTYPE()).show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
    }

    public void disableUiInteraction() {
        DirectPaymentBL.getInstance().setTransactionProcessing(true);
        setDisableUiInteraction(true);
        if (getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName()) != null) {
            ((BaseBankOfferFragment) getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName())).disableUiInteraction();
        }
    }

    private void setDisableUiInteraction(boolean z) {
        this.disableUiInteraction = z;
    }

    public void enableUiInteraction() {
        DirectPaymentBL.getInstance().setTransactionProcessing(false);
        setDisableUiInteraction(false);
        if (getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName()) != null) {
            ((BaseBankOfferFragment) getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName())).enableUiInteraction();
        }
    }

    public void onPaymentFailed(String str, String str2, TransactionProcessor transactionProcessor) {
        if (SDKConstants.VISA_GOOGLE_SAFTEY_NET_ERROR.equals(str2) && DirectPaymentBL.getInstance().getPaytmBaseView() != null) {
            DirectPaymentBL.getInstance().getPaytmBaseView().setIsVSCPEligible(false);
            DirectPaymentBL.getInstance().getPaytmBaseView().refreshLayout();
        }
        if (transactionProcessor != null && transactionProcessor.isOnClickFlow()) {
            RetryBottomSheet.getInstance(str).show(getSupportFragmentManager(), RetryBottomSheet.TAG);
        } else if (getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName()) != null) {
            Fragment c2 = getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName());
            if (c2 instanceof TransactionErrorFragment) {
                ((TransactionErrorFragment) c2).updateErrorMessage(str);
                return;
            }
            ((BaseBankOfferFragment) c2).dismiss(true);
            TransactionErrorFragment.Companion.getInstance(str).show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
        } else {
            TransactionErrorFragment.Companion.getInstance(str).show(getSupportFragmentManager(), BaseBankOfferFragment.class.getSimpleName());
        }
    }

    public void backToCashierPage(Fragment fragment, String str, boolean z) {
        q a2 = getSupportFragmentManager().a();
        a2.a(fragment);
        a2.c();
        if (z) {
            onPaymentFailed(str, "", (TransactionProcessor) null);
        }
    }

    public void addPayFragment(Bundle bundle) {
        PayFragment payFragment = new PayFragment();
        payFragment.setArguments(bundle);
        q a2 = getSupportFragmentManager().a();
        a2.a(R.id.fragment_container, payFragment, PayFragment.class.getSimpleName());
        a2.c();
    }

    public void onWebPageFinish() {
        if (getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName()) != null) {
            ((BaseBankOfferFragment) getSupportFragmentManager().c(BaseBankOfferFragment.class.getSimpleName())).dismiss(true);
        }
        SDKUtils.dismissLoadingSheet(this);
    }

    public String getChildClassName() {
        return BankOfferTransactionActivity.class.getSimpleName();
    }

    public void onDestroy() {
        super.onDestroy();
        DirectPaymentBL.getInstance().setTransactionProcessing(false);
        PaytmSDK.setCheckoutCallbackListener((PaytmSDKRequestClient) null);
    }

    public void onCheckoutError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        for (Fragment next : getSupportFragmentManager().f3424a.d()) {
            if (next instanceof BaseBankOfferFragment) {
                ((BaseBankOfferFragment) next).dismiss(true);
            }
        }
        SDKUtility.onTransactionDialogDismiss(this);
    }

    public boolean isUIEnable() {
        return !this.disableUiInteraction;
    }
}
