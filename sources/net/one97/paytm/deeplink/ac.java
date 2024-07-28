package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import net.one97.paytm.passbook.PassbookInitActivity;
import net.one97.paytm.upi.util.UpiConstants;

public final class ac {

    public static class a {
        public static final String a(String str) {
            return "paytmmp://transaction_detail?id=" + str + "&system=wallet";
        }
    }

    public static boolean a(String str, String str2) {
        if ("transaction_detail".equalsIgnoreCase(str)) {
            return true;
        }
        if ((!UpiConstants.URL_TYPE_CASH_WALLET.equalsIgnoreCase(str) || str2 == null || (!str2.equalsIgnoreCase("myorder") && !str2.equalsIgnoreCase("send_money_bank") && !str2.equalsIgnoreCase("wallet_to_ppb") && !str2.equalsIgnoreCase("cash_ledger"))) && !"passbook".equalsIgnoreCase(str) && !"redeem_gv".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    static void a(Context context, DeepLinkData deepLinkData) {
        Intent intent = new Intent(context, PassbookInitActivity.class);
        intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        return a(deepLinkData.f50284b, deepLinkData.f50288f);
    }
}
