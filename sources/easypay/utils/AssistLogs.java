package easypay.utils;

import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;

public class AssistLogs {
    public static void printLog(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            str = Constants.UNKNOWN_ERROR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getSimpleName());
        sb.append(AppConstants.COLON);
        sb.append(str);
    }
}
