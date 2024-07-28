package net.one97.paytm.dynamic.module.creditcard;

import android.content.Context;
import com.paytmmall.clpartifact.utils.CLPConstants;
import net.one97.paytm.utils.ag;

public class CreditCardConstant {
    public static final String CREDIT_CARD_2FA = "creditCardAuth2FA";
    public static final String CREDIT_CARD_2FA_URL = "oauth2/token";
    public static final String CREDIT_CARD_VERTICAL_NAME = "Paytm First Card";
    public static final String H5_CreditCard_Id = "dc2925db07c7f6e68d1a91baad4335dc4928f392";

    public static String getProductId(Context context) {
        return ag.a(context.getApplicationContext()).b(CLPConstants.PRODUCT_ID, "", true);
    }

    public static void saveProductId(Context context, String str) {
        ag.a(context.getApplicationContext()).a(CLPConstants.PRODUCT_ID, str, true);
    }
}
