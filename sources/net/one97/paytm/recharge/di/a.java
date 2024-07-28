package net.one97.paytm.recharge.di;

import android.app.Activity;
import java.util.Map;

public interface a {

    /* renamed from: net.one97.paytm.recharge.di.a$a  reason: collision with other inner class name */
    public enum C1212a {
        AuthActivity,
        WebViewActivity,
        ORDER_SUMMARY,
        AJRAutoAddMoneyCreate,
        AJRUpdateMessage,
        AJRRechargePaymentActivity,
        AJRMainActivity,
        AJRCSTOrderIssues,
        ActiveSubscriptionActivity,
        AddNewAddress,
        AJRAutoAddMoney,
        AddDebitOrCreditCard,
        AJRYoutubeVideoPlay,
        ORDER_HISTORY
    }

    Map<C1212a, Class<? extends Activity>> getActivityMap();
}
