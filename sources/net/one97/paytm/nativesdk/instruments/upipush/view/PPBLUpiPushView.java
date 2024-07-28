package net.one97.paytm.nativesdk.instruments.upipush.view;

import android.content.Context;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public class PPBLUpiPushView extends UpiPushView {
    public PPBLUpiPushView(Context context, VpaBankAccountDetail vpaBankAccountDetail, PaymentModes paymentModes, Instruments instruments) {
        super(context, vpaBankAccountDetail, paymentModes, instruments);
        this.context = context;
    }

    public PaytmBaseView getUpiPushView() {
        PaytmBaseView upiPushView = super.getUpiPushView();
        this.singleVpaLayoutBinding.btnProceed.setVisibility(8);
        return upiPushView;
    }

    public void refreshLayout() {
        this.model.invalidatePaymentIntent();
        this.model.setPaySecurelyText();
        updateCheckBalanceLayout();
    }

    public void selectedView() {
        super.selectedView();
        if (this.availableBalance == 0.0d) {
            callBalanceAPI();
            this.singleVpaLayoutBinding.btnProceed.setVisibility(8);
            return;
        }
        this.singleVpaLayoutBinding.btnProceed.setVisibility(0);
    }

    private void callBalanceAPI() {
        if (this.singleVpaLayoutBinding.tvFetchingBalance.getVisibility() != 0) {
            this.singleVpaLayoutBinding.tvInsufficientBalance.setText("");
            this.singleVpaLayoutBinding.tvCheckBalance.setVisibility(8);
            this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(0);
            this.singleVpaLayoutBinding.tvFetchingBalance.setVisibility(0);
            NativeSDKRepository.getInstance().fetchBalance(SDKConstants.AI_KEY_PPBL, new PaymentMethodDataSource.Callback<CJRFetchBalanceResponse>() {
                public void onResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                    PPBLUpiPushView.this.handleFetchBalanceResponse(cJRFetchBalanceResponse);
                }

                public void onErrorResponse(VolleyError volleyError, CJRFetchBalanceResponse cJRFetchBalanceResponse) {
                    PPBLUpiPushView.this.handleFetchBalanceError();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleFetchBalanceError() {
        this.singleVpaLayoutBinding.tvFetchingBalance.setVisibility(8);
        this.singleVpaLayoutBinding.llCheckBalanceContainer.setVisibility(8);
        openNextInstrument();
    }

    /* access modifiers changed from: private */
    public void handleFetchBalanceResponse(CJRFetchBalanceResponse cJRFetchBalanceResponse) {
        this.singleVpaLayoutBinding.tvFetchingBalance.setVisibility(4);
        this.model.isBalanceFetchHit = true;
        if (cJRFetchBalanceResponse == null || cJRFetchBalanceResponse.getBody() == null || cJRFetchBalanceResponse.getBody().getBalanceInfo() == null) {
            this.singleVpaLayoutBinding.tvInsufficientBalance.setVisibility(0);
            this.singleVpaLayoutBinding.tvInsufficientBalance.setText("Error in fetching balance. Retry");
            handleFetchBalanceError();
            return;
        }
        try {
            this.availableBalance = Double.parseDouble(cJRFetchBalanceResponse.getBody().getBalanceInfo().getValue());
            this.singleVpaLayoutBinding.tvCheckBalance.setVisibility(0);
            updateCheckBalanceLayout();
            if (!this.model.checkIfAmountSufficient(Double.toString(this.availableBalance))) {
                openNextInstrument();
            }
        } catch (Exception unused) {
            handleFetchBalanceError();
        }
    }
}
