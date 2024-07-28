package net.one97.paytm.trustlogin;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.google.gson.f;
import com.google.gson.q;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.one97.paytm.common.entity.trustLogin.RequestorPermission;
import net.one97.paytm.common.entity.trustLogin.TrustLoginObject;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean a(Context context, final String str) {
        RequestFuture newFuture = RequestFuture.newFuture();
        Volley.newRequestQueue(context).add(new JsonObjectRequest(b.e(context, b.a()), newFuture, newFuture) {
            public final /* synthetic */ Map getHeaders() throws AuthFailureError {
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", b.m());
                hashMap.put("requestorclientid", str);
                return hashMap;
            }
        });
        try {
            f fVar = new f();
            new q();
            RequestorPermission requestorPermission = (RequestorPermission) fVar.a(q.a(((JSONObject) newFuture.get(10, TimeUnit.SECONDS)).toString()), RequestorPermission.class);
            if (requestorPermission == null || !requestorPermission.isRequestorClient()) {
                return false;
            }
            return true;
        } catch (InterruptedException e2) {
            com.paytm.utility.q.b(e2.getMessage());
            return false;
        } catch (ExecutionException e3) {
            com.paytm.utility.q.b(e3.getMessage());
            return false;
        } catch (TimeoutException e4) {
            com.paytm.utility.q.b(e4.getMessage());
            return false;
        }
    }

    public static TrustLoginObject b(Context context, String str) {
        RequestFuture newFuture = RequestFuture.newFuture();
        final Context context2 = context;
        final String str2 = str;
        Volley.newRequestQueue(context).add(new JsonObjectRequest(b.e(context, b.b()), newFuture, newFuture) {
            public final /* synthetic */ Map getHeaders() throws AuthFailureError {
                HashMap hashMap = new HashMap();
                hashMap.put("sessionToken", t.b(context2));
                hashMap.put("Authorization", b.m());
                hashMap.put("reqClientId", str2);
                return hashMap;
            }
        });
        try {
            f fVar = new f();
            new q();
            TrustLoginObject trustLoginObject = (TrustLoginObject) fVar.a(q.a(((JSONObject) newFuture.get(10, TimeUnit.SECONDS)).toString()), TrustLoginObject.class);
            com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
            a2.a(com.paytm.utility.a.a(context) + str + "-AuthCode", trustLoginObject.getData(), true);
            return trustLoginObject;
        } catch (InterruptedException e2) {
            com.paytm.utility.q.b(e2.getMessage());
            return null;
        } catch (ExecutionException e3) {
            com.paytm.utility.q.b(e3.getMessage());
            return null;
        } catch (TimeoutException e4) {
            com.paytm.utility.q.b(e4.getMessage());
            return null;
        }
    }

    public static HashMap<String, Boolean> a(Context context, String str, boolean z, boolean z2, boolean z3) {
        String str2 = str;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        String b2 = t.b(context);
        if (TextUtils.isEmpty(b2)) {
            hashMap.put("wallet", Boolean.FALSE);
            hashMap.put("saved_card", Boolean.FALSE);
            hashMap.put("saved_vpa", Boolean.FALSE);
        }
        RequestFuture newFuture = RequestFuture.newFuture();
        String e2 = b.e(context, "https://securegw.paytm.in/theia/api/v2/fetchPaymentOptions" + "?mid=" + str2);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("tokenType", SDKConstants.SSO);
            jSONObject2.put(StringSet.token, b2);
            jSONObject2.put("version", "v2");
            jSONObject2.put("channelId", SDKConstants.WAP);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("mid", str2);
            jSONObject3.put("appVersion", "Android_" + b.Q(context));
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
            Volley.newRequestQueue(context).add(new JsonObjectRequest(1, e2, jSONObject, newFuture, newFuture));
            CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) new f().a(((JSONObject) newFuture.get(10, TimeUnit.SECONDS)).toString(), CJPayMethodResponse.class);
            if (cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getMerchantPayOption() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments() == null) {
                hashMap.put("wallet", Boolean.FALSE);
                hashMap.put("saved_card", Boolean.FALSE);
                hashMap.put("saved_vpa", Boolean.FALSE);
            }
            if (z) {
                hashMap.put("wallet", Boolean.valueOf(a(cJPayMethodResponse.getBody().getMerchantPayOption())));
            }
            if (z2) {
                if (cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getMerchantPayOption() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments() == null) {
                    hashMap.put("saved_card", Boolean.FALSE);
                } else {
                    hashMap.put("saved_card", Boolean.valueOf(cJPayMethodResponse.getBody().getMerchantPayOption().getSavedInstruments().size() > 0));
                }
            }
            if (z3) {
                if (cJPayMethodResponse.getBody() == null || cJPayMethodResponse.getBody().getMerchantPayOption() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts() == null || cJPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails().getProfileDetail().getBankAccounts().size() <= 0) {
                    hashMap.put("saved_vpa", Boolean.FALSE);
                } else {
                    hashMap.put("saved_vpa", Boolean.TRUE);
                }
            }
        } catch (JSONException e3) {
            com.paytm.utility.q.b(e3.getMessage());
            r.a("TrustLogin", "userHasSavedPaymentInstruments", (Throwable) e3);
        } catch (InterruptedException e4) {
            com.paytm.utility.q.b(e4.getMessage());
            r.a("TrustLogin", "userHasSavedPaymentInstruments", (Throwable) e4);
        } catch (ExecutionException e5) {
            com.paytm.utility.q.b(e5.getMessage());
            r.a("TrustLogin", "userHasSavedPaymentInstruments", (Throwable) e5);
        } catch (TimeoutException e6) {
            com.paytm.utility.q.b(e6.getMessage());
            r.a("TrustLogin", "userHasSavedPaymentInstruments", (Throwable) e6);
        }
        return hashMap;
    }

    private static boolean a(MerchantPayOption merchantPayOption) {
        ArrayList<PaymentModes> paymentModes = merchantPayOption.getPaymentModes();
        if (paymentModes == null) {
            return false;
        }
        Iterator<PaymentModes> it2 = paymentModes.iterator();
        while (it2.hasNext()) {
            PaymentModes next = it2.next();
            if (next.getPaymentMode().equalsIgnoreCase(PayMethodType.BALANCE.name()) && (next.getIsDisabled() == null || !next.getIsDisabled().getStatus())) {
                return true;
            }
        }
        return false;
    }
}
