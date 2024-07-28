package net.one97.paytm.nativesdk.emiSubvention.views;

import android.content.Context;

public interface ITenureClickHandler {
    Context getContext();

    void setSelectedPlan(int i2);

    void showBottomSheet(Context context, int i2);
}
