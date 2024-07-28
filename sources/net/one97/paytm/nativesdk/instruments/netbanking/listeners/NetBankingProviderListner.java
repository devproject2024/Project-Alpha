package net.one97.paytm.nativesdk.instruments.netbanking.listeners;

import android.view.View;
import net.one97.paytm.nativesdk.common.listeners.NetworkUnavailable;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;

public interface NetBankingProviderListner extends NetworkUnavailable {
    void onArrowClicked();

    void onEmptyList();

    void onNetBankingListReceived(NbPayOption nbPayOption);

    void onNonEmptyList();

    void onProccedClick(View view, PayChannelOptions payChannelOptions);
}
