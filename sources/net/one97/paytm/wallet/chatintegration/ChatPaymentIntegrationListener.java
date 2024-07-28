package net.one97.paytm.wallet.chatintegration;

import net.one97.paytm.common.entity.IJRDataModel;

public interface ChatPaymentIntegrationListener extends IJRDataModel {
    void onTransactionResponse(ChatPaymentIntegrationResponseModel chatPaymentIntegrationResponseModel);
}
