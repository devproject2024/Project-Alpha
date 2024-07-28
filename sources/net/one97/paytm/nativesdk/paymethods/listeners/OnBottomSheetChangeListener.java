package net.one97.paytm.nativesdk.paymethods.listeners;

import net.one97.paytm.nativesdk.common.listeners.NetworkUnavailable;

public interface OnBottomSheetChangeListener extends NetworkUnavailable {
    void onChangeBottomSheet(String str, boolean z);
}
