package com.paytm.business.merchantprofile.common;

import android.content.Context;
import android.text.TextUtils;
import com.business.common_module.events.ErrorDisplayEvent;
import com.business.common_module.events.e;
import com.business.common_module.utilities.a.b;
import com.google.gson.f;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.model.PostResponse;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.greenrobot.eventbus.c;
import org.json.JSONObject;
import retrofit2.Response;

public class ErrorUtil {
    public static final int ERROR_CODE_400 = 400;
    public static final int ERROR_CODE_401 = 401;
    public static final int ERROR_CODE_403 = 403;
    public static final int ERROR_CODE_410 = 410;
    public static final int ERROR_TYPE_API_FAILURE = 12;
    public static final String ERROR_TYPE_INVALID_URL = "INVALID URL";
    public static final String ERROR_TYPE_NO_INTERNET = "NO NETWORK";
    public static final int ERROR_TYPE_NO_NETWORK = 11;
    public static final int ERROR_TYPE_RESPONSE = 13;

    public static String parseError(Response<?> response) {
        if (response != null) {
            try {
                if (response.errorBody() != null) {
                    JSONObject jSONObject = new JSONObject(response.errorBody().string());
                    String optString = jSONObject.optString(AppConstants.TRANSACTION_STATUS_ERROR);
                    if (TextUtils.isEmpty(optString)) {
                        optString = jSONObject.optString("INVALID_OTP");
                        if (!TextUtils.isEmpty(optString)) {
                            optString = "INVALID_OTP";
                        }
                    }
                    if (TextUtils.isEmpty(optString)) {
                        return jSONObject.optString("displayMessage");
                    }
                    return optString;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return "parsing_error";
            }
        }
        return null;
    }

    public static PostResponse getPostResponse(Response<?> response) {
        PostResponse postResponse = null;
        if (response != null) {
            try {
                if (response.body() instanceof PostResponse) {
                    postResponse = (PostResponse) response.body();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        if (postResponse != null || response.errorBody() == null) {
            return postResponse;
        }
        return (PostResponse) new f().a(response.errorBody().string(), PostResponse.class);
    }

    public static String getErrorDisplayMessage(Response<?> response) {
        PostResponse postResponse = getPostResponse(response);
        if (postResponse != null) {
            return postResponse.getDisplayMessage();
        }
        return null;
    }

    public static void handleNoNetworkError(String str) {
        c.a().c(new ErrorDisplayEvent(str));
    }

    public static void handleAPIError(String str, String str2, Response<?> response, boolean z) {
        handleAPIError(str, str2, response, (String) null, (Throwable) null, z);
    }

    public static void handleAPIError(String str, String str2, b bVar) {
        if (bVar != null) {
            handleAPIError(str, str2, bVar.f7356a, bVar.f7359d, bVar.f7360e, true);
            return;
        }
        handleAPIError(str, str2, (Response<?>) null, (String) null, (Throwable) null, true);
    }

    public static void handleAPIError(String str, Throwable th) {
        handleAPIError(str, (String) null, (Response<?>) null, (String) null, th, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r0.equalsIgnoreCase(com.paytm.business.merchantprofile.common.utility.AppConstants.INVALID_TOKEN) != false) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void handleAPIError(java.lang.String r5, java.lang.String r6, retrofit2.Response<?> r7, java.lang.String r8, java.lang.Throwable r9, boolean r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = "GG"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0065
            if (r7 == 0) goto L_0x0065
            int r0 = r7.code()
            r4 = 401(0x191, float:5.62E-43)
            if (r0 != r4) goto L_0x0015
            goto L_0x0043
        L_0x0015:
            java.lang.String r0 = "UMP"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0034
            int r0 = r7.code()
            r4 = 400(0x190, float:5.6E-43)
            if (r0 != r4) goto L_0x0034
            java.lang.String r0 = parseError(r7)
            if (r0 == 0) goto L_0x0052
            java.lang.String r4 = com.paytm.business.merchantprofile.common.utility.AppConstants.INVALID_TOKEN
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x0052
            goto L_0x0043
        L_0x0034:
            boolean r0 = r6.equals(r1)
            if (r0 == 0) goto L_0x0046
            int r0 = r7.code()
            r4 = 410(0x19a, float:5.75E-43)
            if (r0 == r4) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r0 = r8
            r8 = 1
            goto L_0x0054
        L_0x0046:
            int r0 = r7.code()
            r4 = 403(0x193, float:5.65E-43)
            if (r0 != r4) goto L_0x0052
            java.lang.String r8 = getErrorMessage((retrofit2.Response<?>) r7)
        L_0x0052:
            r0 = r8
            r8 = 0
        L_0x0054:
            if (r8 == 0) goto L_0x0064
            org.greenrobot.eventbus.c r5 = org.greenrobot.eventbus.c.a()
            com.business.common_module.events.e r6 = new com.business.common_module.events.e
            r7 = 0
            r6.<init>(r7)
            r5.c(r6)
            return
        L_0x0064:
            r8 = r0
        L_0x0065:
            if (r10 == 0) goto L_0x00bf
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 != 0) goto L_0x009c
            if (r7 == 0) goto L_0x009c
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 == 0) goto L_0x009c
            r10 = -1
            int r0 = r6.hashCode()
            r4 = 2272(0x8e0, float:3.184E-42)
            if (r0 == r4) goto L_0x008d
            r1 = 83768(0x14738, float:1.17384E-40)
            if (r0 != r1) goto L_0x0094
            java.lang.String r0 = "UAD"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0094
            r10 = 1
            goto L_0x0094
        L_0x008d:
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0094
            r10 = 0
        L_0x0094:
            if (r10 == 0) goto L_0x0098
            if (r10 != r3) goto L_0x009c
        L_0x0098:
            java.lang.String r8 = getErrorDisplayMessage(r7)
        L_0x009c:
            if (r7 == 0) goto L_0x00a7
            boolean r6 = android.text.TextUtils.isEmpty(r8)
            if (r6 != 0) goto L_0x00a7
            r6 = 13
            goto L_0x00a9
        L_0x00a7:
            r6 = 12
        L_0x00a9:
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 == 0) goto L_0x00b3
            java.lang.String r8 = getErrorMessage(r7, r9)
        L_0x00b3:
            org.greenrobot.eventbus.c r7 = org.greenrobot.eventbus.c.a()
            com.business.common_module.events.ErrorDisplayEvent r9 = new com.business.common_module.events.ErrorDisplayEvent
            r9.<init>(r5, r6, r8)
            r7.c(r9)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.common.ErrorUtil.handleAPIError(java.lang.String, java.lang.String, retrofit2.Response, java.lang.String, java.lang.Throwable, boolean):void");
    }

    public static String getErrorMessage(Response<?> response) {
        return getErrorMessage(response, (Throwable) null);
    }

    public static String getErrorMessage(Throwable th) {
        return getErrorMessage((Response<?>) null, th);
    }

    public static String getErrorMessage(Response<?> response, Throwable th) {
        String str;
        Context appContext = ProfileConfig.getInstance().getAppContext();
        if (response != null) {
            int code = response.code();
            if (code != 400) {
                if (code != 401) {
                    if (code == 403) {
                        str = appContext.getString(R.string.pr_error_msg_403);
                    } else if (code == 404) {
                        str = appContext.getString(R.string.pr_error_msg_404);
                    } else if (code == 408) {
                        str = appContext.getString(R.string.pr_error_msg_408);
                    } else if (code != 410) {
                        if (code == 429) {
                            str = appContext.getString(R.string.pr_error_msg_429);
                        } else if (code == 500) {
                            str = appContext.getString(R.string.pr_error_msg_500);
                        } else if (code != 503) {
                            str = appContext.getString(R.string.pr_something_went_wrong);
                        } else {
                            str = appContext.getString(R.string.pr_error_msg_503);
                        }
                    }
                }
                str = appContext.getString(R.string.pr_error_msg_401);
            } else {
                str = appContext.getString(R.string.pr_error_msg_400);
            }
            return str + " " + appContext.getString(R.string.pr_lbl_please_try_again_later);
        } else if (th instanceof UnknownHostException) {
            return appContext.getString(R.string.pr_error_msg_unknown_host);
        } else {
            if (th instanceof SocketTimeoutException) {
                return appContext.getString(R.string.pr_error_msg_socket_timeout);
            }
            return appContext.getString(R.string.pr_error_msg_default);
        }
    }

    public static boolean handleInvalidToken(Response<?> response) {
        String parseError;
        boolean z = false;
        if (response != null) {
            if (response.code() == 401 || (response.code() == 400 && (parseError = parseError(response)) != null && parseError.equalsIgnoreCase(AppConstants.INVALID_TOKEN))) {
                z = true;
            }
            if (z) {
                c.a().c(new e((String) null));
            }
        }
        return z;
    }

    public static boolean handleInvalidToken(String str, Response<?> response) {
        String parseError;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && response != null) {
            if (response.code() == 401 || (!str.equals("UMP") || response.code() != 400 ? !(!str.equals("GG") || response.code() != 410) : !((parseError = parseError(response)) == null || !parseError.equalsIgnoreCase(AppConstants.INVALID_TOKEN)))) {
                z = true;
            }
            if (z) {
                c.a().c(new e((String) null));
            }
        }
        return z;
    }
}
