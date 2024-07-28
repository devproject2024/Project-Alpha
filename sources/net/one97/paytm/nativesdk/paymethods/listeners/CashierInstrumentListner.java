package net.one97.paytm.nativesdk.paymethods.listeners;

import net.one97.paytm.nativesdk.common.listeners.NetworkUnavailable;

public interface CashierInstrumentListner extends NetworkUnavailable {
    void onFetchBalance(String str);
}
