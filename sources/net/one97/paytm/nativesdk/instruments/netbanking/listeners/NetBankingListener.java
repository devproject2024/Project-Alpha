package net.one97.paytm.nativesdk.instruments.netbanking.listeners;

import android.view.View;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;

public interface NetBankingListener extends BaseViewActions {
    void bankSelected(PayChannelOptions payChannelOptions);

    void changeArrowIcon(boolean z);

    void closeCachierSheet();

    void getBankOffer(PayChannelOptions payChannelOptions);

    void getConvenienceFee(PayChannelOptions payChannelOptions);

    int getSelectedItem();

    void hideCashBackVisibility();

    void hideProceedButtonLoading(View view);

    void onBankListVisible();

    void onProceedClick(View view, PayChannelOptions payChannelOptions, boolean z, boolean z2);

    void onUpiPayClick(View view, VpaBankAccountDetail vpaBankAccountDetail);

    void selectItemOnAdapter(int i2);

    void updateAdapter();

    void updateBankIcon(String str);
}
