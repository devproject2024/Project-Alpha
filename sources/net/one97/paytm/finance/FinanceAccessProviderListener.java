package net.one97.paytm.finance;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public interface FinanceAccessProviderListener {
    Intent getAJRPPNoAccountExistIntent(Context context);

    Intent getAJRPPNotEligibleIntent(Context context);

    Intent getAJRPPSavedCardsIntent(Context context);

    Fragment getFJRGoldSubscriptionListFragment();

    Fragment getForexComingSoonPageFragment();

    Intent getForexOrderSummaryIntent(Context context);

    Intent getGoldNewOrderSummary(Context context);

    Intent getNewOrderSummaryIntent(Context context);

    String getPPIntentExtraFromScreenTag();

    Class getWXGoldCallbackUtilityClassName();

    Class getWXPostpaidCallbackUtilityClassName();

    Class getWxCallBackUtilityModuleClassName();

    Class getWxForexCallbackClassName();

    void handleCardChecked(Context context, int i2);

    void handleCreateCardChecked(Context context, int i2);

    void handleSipEditCardChecked(Context context, int i2);

    boolean isAJRGoldPlanDetailsInstance(Context context);

    boolean isAJRGoldSipEditInstance(Context context);

    boolean isAJRGoldSipHomeInstance(Context context);

    boolean isAJRPPSavedCardsInstance(Context context);

    void sendGoldEvent(Context context, CJROrderSummary cJROrderSummary, String str, String str2, String str3);

    void startNewOrderSummary(Context context, Intent intent);
}
