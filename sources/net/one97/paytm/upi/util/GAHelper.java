package net.one97.paytm.upi.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.paytm.utility.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.UpiConstants;

public final class GAHelper {
    public static final Companion Companion = new Companion((g) null);
    private static final String DELIMITER = "_";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void sendIntentFlowGAEvent(Context context, Integer num, Uri uri, UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
            fireGAEvent(context, num, uri, upiAvailabilityResponse);
        }

        private final void fireGAEvent(Context context, Integer num, Uri uri, UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
            String str = null;
            String queryParameter = uri != null ? uri.getQueryParameter("am") : null;
            String queryParameter2 = uri != null ? uri.getQueryParameter("pa") : null;
            String queryParameter3 = uri != null ? uri.getQueryParameter("tr") : null;
            String queryParameter4 = uri != null ? uri.getQueryParameter("tid") : null;
            if (uri != null) {
                str = uri.getQueryParameter("mc");
            }
            StringBuilder sb = new StringBuilder();
            Companion companion = this;
            sb.append(companion.getSource(num));
            sb.append(GAHelper.DELIMITER);
            sb.append(companion.getUserState(context, upiAvailabilityResponse));
            sb.append(GAHelper.DELIMITER);
            sb.append(queryParameter2);
            sb.append(GAHelper.DELIMITER);
            sb.append(str);
            sb.append(GAHelper.DELIMITER);
            sb.append(queryParameter3);
            sb.append(GAHelper.DELIMITER);
            sb.append(queryParameter4);
            sb.append(GAHelper.DELIMITER);
            sb.append(queryParameter);
            sb.append(GAHelper.DELIMITER);
            sb.append(a.a(context));
            CJRSendGTMTag.sendNewCustomGTMEvents(context, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "intent_qr_code_scan_user_tracking", sb.toString(), "", "", "/bank/bhim-upi/profile", "wallet");
        }

        private final String getUserState(Context context, UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
            if (upiAvailabilityResponse == null) {
                String userStateFromPref = context != null ? GAHelper.Companion.getUserStateFromPref(context) : null;
                if (userStateFromPref == null) {
                    k.a();
                }
                return userStateFromPref;
            } else if (!upiAvailabilityResponse.isUpiUser() && !upiAvailabilityResponse.isUpiProfileExist()) {
                return UpiConstants.UPI_GA_CONSTANTS.USER_NOT_ONBOARDED;
            } else {
                if (!upiAvailabilityResponse.isUpiUser() && upiAvailabilityResponse.isUpiProfileExist()) {
                    return UpiConstants.UPI_GA_CONSTANTS.INACTIVE_USER;
                }
                if (upiAvailabilityResponse.isUpiUser() && !upiAvailabilityResponse.isSameDevice() && !upiAvailabilityResponse.ismBankAccountAdded()) {
                    return UpiConstants.UPI_GA_CONSTANTS.NO_BANK_AND_DEVICE_BINDING_FOUND;
                }
                if (upiAvailabilityResponse.isUpiUser() && upiAvailabilityResponse.isSameDevice() && !upiAvailabilityResponse.ismBankAccountAdded()) {
                    return UpiConstants.UPI_GA_CONSTANTS.NO_BANK_FOUND;
                }
                if (upiAvailabilityResponse.isUpiUser() && !upiAvailabilityResponse.isSameDevice() && upiAvailabilityResponse.ismBankAccountAdded() && !upiAvailabilityResponse.ismPinSet()) {
                    return UpiConstants.UPI_GA_CONSTANTS.MPIN_AND_DEVICE_BINDING_NOT_FOUND;
                }
                if (upiAvailabilityResponse.isUpiUser() && upiAvailabilityResponse.isSameDevice() && upiAvailabilityResponse.ismBankAccountAdded() && !upiAvailabilityResponse.ismPinSet()) {
                    return UpiConstants.UPI_GA_CONSTANTS.MPIN_NOT_FOUND;
                }
                if (!upiAvailabilityResponse.isUpiUser() || !upiAvailabilityResponse.isSameDevice() || !upiAvailabilityResponse.ismBankAccountAdded() || !upiAvailabilityResponse.ismPinSet()) {
                    return (!upiAvailabilityResponse.isUpiUser() || upiAvailabilityResponse.isSameDevice() || !upiAvailabilityResponse.ismBankAccountAdded() || !upiAvailabilityResponse.ismPinSet()) ? UpiConstants.UPI_GA_CONSTANTS.USER_STATE_DEFAULT : UpiConstants.UPI_GA_CONSTANTS.DEVICE_NOT_REGISTERED;
                }
                return UpiConstants.UPI_GA_CONSTANTS.ACTIVE_USER;
            }
        }

        private final String getUserStateFromPref(Context context) {
            b a2 = net.one97.paytm.upi.g.a(net.one97.paytm.upi.g.a((a.C1347a) null));
            k.a((Object) a2, "upi");
            boolean e2 = a2.e();
            boolean h2 = a2.h();
            boolean i2 = a2.i();
            boolean f2 = a2.f();
            boolean g2 = a2.g();
            if (!e2 && !f2) {
                return UpiConstants.UPI_GA_CONSTANTS.USER_NOT_ONBOARDED;
            }
            if (!e2 && f2) {
                return UpiConstants.UPI_GA_CONSTANTS.INACTIVE_USER;
            }
            if (e2 && !g2 && !h2) {
                return UpiConstants.UPI_GA_CONSTANTS.NO_BANK_AND_DEVICE_BINDING_FOUND;
            }
            if (e2 && g2 && !h2) {
                return UpiConstants.UPI_GA_CONSTANTS.NO_BANK_FOUND;
            }
            if (e2 && !g2 && h2 && !i2) {
                return UpiConstants.UPI_GA_CONSTANTS.MPIN_AND_DEVICE_BINDING_NOT_FOUND;
            }
            if (e2 && g2 && h2 && !i2) {
                return UpiConstants.UPI_GA_CONSTANTS.MPIN_NOT_FOUND;
            }
            if (!e2 || !g2 || !h2 || !i2) {
                return (!e2 || g2 || !h2 || !i2) ? UpiConstants.UPI_GA_CONSTANTS.USER_STATE_DEFAULT : UpiConstants.UPI_GA_CONSTANTS.DEVICE_NOT_REGISTERED;
            }
            return UpiConstants.UPI_GA_CONSTANTS.ACTIVE_USER;
        }

        private final String getSource(Integer num) {
            if (num != null && num.intValue() == 0) {
                return "intent";
            }
            if (num != null && num.intValue() == 1) {
                return UpiConstants.UPI_SOURCE_MAPPING.PAYTM_QR_SCAN_SOURCE;
            }
            if (num != null && num.intValue() == 2) {
                return UpiConstants.UPI_SOURCE_MAPPING.BHARAT_QR_SCAN_SOURCE;
            }
            return (num != null && num.intValue() == 3) ? UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE : UpiConstants.UPI_SOURCE_MAPPING.DEFAULT_SOURCE;
        }

        public final void sendCaptureEventRequestForIntentFlow(Context context, Uri uri) {
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("am");
                String queryParameter2 = uri.getQueryParameter("pa");
                String queryParameter3 = uri.getQueryParameter("tr");
                String queryParameter4 = uri.getQueryParameter("tid");
                String queryParameter5 = uri.getQueryParameter("mc");
                HashMap hashMap = new HashMap();
                if (TextUtils.isEmpty(queryParameter4)) {
                    queryParameter4 = !TextUtils.isEmpty(queryParameter3) ? queryParameter3 : "NA";
                }
                Map map = hashMap;
                map.put("user_paytm_app_version", UpiAppUtils.getAppVersionName(context));
                map.put("device_os", String.valueOf(UpiAppUtils.getOSVersion()));
                map.put(UpiConstants.EXTRA_PAYER_VPA, "");
                map.put("payee_vpa", queryParameter2);
                map.put("user_phone_number", UpiUtils.getMobile(context));
                map.put("user_cust_id", com.paytm.utility.a.a(context));
                map.put("amount", queryParameter);
                map.put(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, queryParameter4);
                map.put("mcc_code", queryParameter5);
                map.put("reference_id", queryParameter3);
                map.put("network_type", UpiAppUtils.getNetworkType(context));
                map.put("device_name", UpiAppUtils.getDeviceName());
                net.one97.paytm.upi.profile.b.b.a.a(context).a(queryParameter4, (HashMap<String, String>) hashMap);
            }
        }

        public final void sendGA(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
            k.c(str6, "value");
            try {
                i.a();
                i.a(context, str, str2, str4, str5, str6, str3, "wallet");
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
