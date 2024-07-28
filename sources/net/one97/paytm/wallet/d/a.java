package net.one97.paytm.wallet.d;

import android.app.Activity;

public interface a {
    void addMoneyForInsufficientBalanceError(String str, boolean z, String str2);

    void addMoneyForInsufficientBalanceError(String str, boolean z, String str2, String str3, String str4);

    void addMoneyForInsufficientBalanceError(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    void onAttachToFragment(Activity activity, b bVar);

    void setIsForGiftVoucher(boolean z);
}
