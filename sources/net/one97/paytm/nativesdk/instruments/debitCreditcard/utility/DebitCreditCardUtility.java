package net.one97.paytm.nativesdk.instruments.debitCreditcard.utility;

import android.content.Context;
import com.google.gson.f;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public class DebitCreditCardUtility {
    public static String getFailureReponse(String str, Context context) {
        String string = context.getResources().getString(R.string.server_communication_failed);
        try {
            return ((CJPayMethodResponse) new f().a(str, CJPayMethodResponse.class)).getBody().getResultInfo().getResultMsg();
        } catch (Exception e2) {
            LogUtility.d("Prince", e2.getMessage());
            return string;
        }
    }
}
