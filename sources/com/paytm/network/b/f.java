package com.paytm.network.b;

import android.content.Context;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.networkmodule.R;

public final class f {
    public static CJRError a(Context context, NetworkCustomError networkCustomError) {
        String str;
        String str2;
        CJRError cJRError = new CJRError();
        switch (networkCustomError.mErrorType) {
            case AuthFailureError:
                str2 = context.getString(R.string.error_title_auth_failure);
                str = context.getString(R.string.error_msg_auth_failure);
                break;
            case TimeOutError:
                str2 = context.getString(R.string.network_error_heading);
                str = context.getString(R.string.network_error_message);
                break;
            case ServerError:
            case NoConnectionError:
            case NetworkError:
                str2 = context.getString(R.string.error_title_inconvenience);
                str = context.getString(R.string.error_msg_default);
                break;
            case ParsingError:
                str2 = context.getString(R.string.error_data_display);
                str = context.getString(R.string.parse_error);
                break;
            case ApiCallLimitExceededError:
                str2 = context.getString(R.string.error_title_api_limit_exceeded);
                str = context.getString(R.string.error_msg_api_limit_exceeded);
                break;
            case InvalidArgumentError:
                str2 = context.getString(R.string.error_title_invalid_arg);
                str = context.getString(R.string.error_msg_invalid_arg);
                break;
            default:
                str2 = context.getString(R.string.error_title_inconvenience);
                str = context.getString(R.string.error_msg_default);
                break;
        }
        int statusCode = networkCustomError.getStatusCode();
        if (statusCode == 400) {
            str2 = context.getString(R.string.error_title_inconvenience);
            str = context.getString(R.string.error_msg_400);
        } else if (statusCode == 404) {
            str2 = context.getString(R.string.error_title_inconvenience);
            str = context.getString(R.string.error_msg_404);
        } else if (statusCode == 408) {
            str2 = context.getString(R.string.error_title_inconvenience);
            str = context.getString(R.string.error_msg_408);
        } else if (statusCode == 429) {
            str2 = context.getString(R.string.error_title_inconvenience);
            str = context.getString(R.string.error_msg_429);
        } else if (statusCode == 500) {
            str2 = context.getString(R.string.error_title_inconvenience);
            str = context.getString(R.string.error_msg_500);
        } else if (statusCode == 503) {
            str2 = context.getString(R.string.error_title_inconvenience);
            str = context.getString(R.string.error_msg_503);
        }
        cJRError.setTitle(str2);
        cJRError.setMessage(str);
        return cJRError;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.network.model.CJRError a(java.lang.String r6, android.content.Context r7) {
        /*
            com.paytm.network.model.CJRError r0 = new com.paytm.network.model.CJRError
            r0.<init>()
            int r1 = r6.hashCode()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1311914055: goto L_0x0031;
                case -617237321: goto L_0x0027;
                case 1700738474: goto L_0x001c;
                case 2038628819: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x003b
        L_0x0011:
            java.lang.String r1 = "unknown_error"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003b
            r1 = 3
            goto L_0x003c
        L_0x001c:
            java.lang.String r1 = "timeout_error"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x0027:
            java.lang.String r1 = "network_error"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003b
            r1 = 0
            goto L_0x003c
        L_0x0031:
            java.lang.String r1 = "parsing_error"
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x003b
            r1 = 2
            goto L_0x003c
        L_0x003b:
            r1 = -1
        L_0x003c:
            if (r1 == 0) goto L_0x00b5
            if (r1 == r5) goto L_0x00b5
            if (r1 == r4) goto L_0x00a8
            if (r1 == r3) goto L_0x009b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x004c }
            int r2 = r6.intValue()     // Catch:{ NumberFormatException -> 0x004c }
        L_0x004c:
            int r6 = com.paytm.networkmodule.R.string.error_title_inconvenience
            java.lang.String r6 = r7.getString(r6)
            r1 = 400(0x190, float:5.6E-43)
            if (r2 == r1) goto L_0x0094
            r1 = 404(0x194, float:5.66E-43)
            if (r2 == r1) goto L_0x008d
            r1 = 408(0x198, float:5.72E-43)
            if (r2 == r1) goto L_0x0086
            r1 = 429(0x1ad, float:6.01E-43)
            if (r2 == r1) goto L_0x007f
            r1 = 500(0x1f4, float:7.0E-43)
            if (r2 == r1) goto L_0x0078
            r1 = 503(0x1f7, float:7.05E-43)
            if (r2 == r1) goto L_0x0071
            int r1 = com.paytm.networkmodule.R.string.error_msg_default
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x0071:
            int r1 = com.paytm.networkmodule.R.string.error_msg_503
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x0078:
            int r1 = com.paytm.networkmodule.R.string.error_msg_500
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x007f:
            int r1 = com.paytm.networkmodule.R.string.error_msg_429
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x0086:
            int r1 = com.paytm.networkmodule.R.string.error_msg_408
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x008d:
            int r1 = com.paytm.networkmodule.R.string.error_msg_404
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x0094:
            int r1 = com.paytm.networkmodule.R.string.error_msg_400
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x009b:
            int r6 = com.paytm.networkmodule.R.string.error_title_inconvenience
            java.lang.String r6 = r7.getString(r6)
            int r1 = com.paytm.networkmodule.R.string.error_msg_default
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x00a8:
            int r6 = com.paytm.networkmodule.R.string.error_data_display
            java.lang.String r6 = r7.getString(r6)
            int r1 = com.paytm.networkmodule.R.string.parse_error
            java.lang.String r7 = r7.getString(r1)
            goto L_0x00c1
        L_0x00b5:
            int r6 = com.paytm.networkmodule.R.string.network_error_heading
            java.lang.String r6 = r7.getString(r6)
            int r1 = com.paytm.networkmodule.R.string.network_error_message
            java.lang.String r7 = r7.getString(r1)
        L_0x00c1:
            r0.setTitle(r6)
            r0.setMessage(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.network.b.f.a(java.lang.String, android.content.Context):com.paytm.network.model.CJRError");
    }
}
