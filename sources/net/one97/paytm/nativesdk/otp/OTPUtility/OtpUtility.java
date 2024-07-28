package net.one97.paytm.nativesdk.otp.OTPUtility;

import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.model.ResultInfo;
import net.one97.paytm.nativesdk.otp.Model.Body;

public class OtpUtility {
    public static boolean isOTPSentSuccessfully(Body body) {
        ResultInfo resultInfo;
        if (body == null || (resultInfo = body.getResultInfo()) == null || !resultInfo.getResultCode().equalsIgnoreCase(SDKConstants.SUCCESS_RESULT_ID)) {
            return false;
        }
        return true;
    }

    public static String getMessageFromServerResponse(Body body) {
        ResultInfo resultInfo;
        if (body == null || (resultInfo = body.getResultInfo()) == null) {
            return "Unkhown";
        }
        return resultInfo.getResultMsg();
    }

    public static boolean isOTPValidatedSuccessfully(Body body) {
        ResultInfo resultInfo;
        if (body != null && (resultInfo = body.getResultInfo()) != null && resultInfo.getResultCode().equalsIgnoreCase(SDKConstants.SUCCESS_RESULT_ID) && body.getAuthenticated()) {
            return true;
        }
        return false;
    }
}
