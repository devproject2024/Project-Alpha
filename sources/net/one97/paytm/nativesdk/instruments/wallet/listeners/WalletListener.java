package net.one97.paytm.nativesdk.instruments.wallet.listeners;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;
import net.one97.paytm.nativesdk.common.model.SubWalletDetail;

public interface WalletListener extends BaseViewActions {
    void changeBehaviour(boolean z);

    void changeOutsidePaytmWallet(boolean z);

    void closeCachierSheet();

    void deselectView();

    void disableView(boolean z);

    void inflateBalanceViews(ArrayList<SubWalletDetail> arrayList);

    void loadInstruments(boolean z);

    void setSelectedView();

    void shouldEnableProceed(boolean z);
}
