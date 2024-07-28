package net.one97.paytm.nativesdk.instruments.upipush.callbacks;

import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public interface SetOnUpiPushListener extends BaseViewActions {
    void clearAllSelection();

    void selectedView();

    void setAmount(String str);

    void updateCheckBalanceLayout();
}
