package net.one97.paytm.acceptPayment.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.business.common_module.b.d;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.common.utility.DialogUtility;
import net.one97.paytm.acceptPayment.R;
import retrofit2.Response;

public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public final String f52056a = "WsErrorImpl";

    public final boolean a(Context context, Response<?> response) {
        if (response != null) {
            String parseError = ErrorUtil.parseError(response);
            if (TextUtils.isEmpty(parseError) || !parseError.equalsIgnoreCase("parsing_error")) {
                DialogUtility.showDialog(context, PaymentsConfig.getInstance().getAppContext().getResources().getString(R.string.ap_error), parseError);
                return false;
            } else if (!(context instanceof Activity)) {
                return false;
            }
        }
        DialogUtility.showDialog(context, PaymentsConfig.getInstance().getAppContext().getResources().getString(R.string.ap_error), PaymentsConfig.getInstance().getAppContext().getResources().getString(R.string.ap_something_went_wrong));
        return false;
    }
}
