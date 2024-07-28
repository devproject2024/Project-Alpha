package net.one97.paytm.nativesdk.emiSubvention.views;

import android.content.Context;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;

public interface IBankDataProvider {
    Context getContext();

    void handleOnClick(BankData bankData);
}
