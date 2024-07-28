package easypay.actions;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;
import easypay.utils.AssistLogs;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.upi.util.UpiContract;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static OkHttpClient f46060a;

    public static void a(String str, String str2, String str3, String str4, String str5, Context context, JSONObject jSONObject, easypay.listeners.b bVar) {
        Class<a> cls = a.class;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String string = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
                jSONObject.put(Constants.RISK_EVENT_LINK_ID, str);
                jSONObject.put("orderId", str5);
                jSONObject.put(Constants.RISK_TRANSACTION_ID, str3);
                jSONObject3.put("deviceId", string);
                jSONObject4.put("appVersion", str2);
                jSONObject4.put(Constants.RISK_WEBSITE_LANGUAGE, Locale.getDefault().getLanguage());
                jSONObject4.put(Constants.RISK_CLIENT_IP, easypay.utils.b.e());
                jSONObject4.put(Constants.RISK_EXTENDED_INFO, jSONObject3.toString());
                jSONObject4.put(Constants.RISK_OS_TYPE, "ANDROID");
                jSONObject4.put(Constants.RISK_TERMINAL_TYPE, "APP");
                jSONObject4.put(Constants.RISK_MERCHANT_APP_VERSION, str2);
                jSONObject4.put(Constants.RISK_SDK_VERSION, "");
                jSONObject2.put(Constants.RISK_ENV_INFO, jSONObject4);
                jSONObject2.put(Constants.RISK_OCCURRENCE_TIME, easypay.utils.b.c());
                jSONObject2.put(Constants.RISK_USER_ID, str4);
                jSONObject2.put(Constants.RISK_BIZ_SCENE, "ASSIST_DATA_ANALYZE");
                jSONObject2.put(Constants.RISK_EXTENDED_INFO, jSONObject.toString());
                AssistLogs.printLog("Risk API Url:https://riskengine.paytm.com/risk/policy/nonstandard/asyncConsult", cls.getSimpleName());
                AssistLogs.printLog("Risk API Request:" + jSONObject2.toString(), cls.getSimpleName());
                a(Constants.RISK_ASYNC_API_URL, RequestBody.create(Constants.JSON, jSONObject2.toString()), new Headers.Builder().add("Authorization", "Basic cGF5dG0tYXNzaXN0LXByb2Q6Q3VzWVBoQTJzOGdLSzFTYk55OWpGdlFlVUo5NDZHV1c=").build(), bVar);
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    public static void a(String str, String str2, easypay.listeners.b bVar) {
        Constants.setBaseUrl(str, str2);
        AssistLogs.printLog("Calling access check API: " + Constants.WelcomeApi, a.class.getSimpleName());
        new Thread(new C0771a(bVar)).start();
    }

    /* renamed from: easypay.actions.a$a  reason: collision with other inner class name */
    static class C0771a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ easypay.listeners.b f46061a;

        C0771a(easypay.listeners.b bVar) {
            this.f46061a = bVar;
        }

        public final void run() {
            if (AssistMerchantDetails.getInstance().getMid() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mid", AssistMerchantDetails.getInstance().getMid());
                    a.a(Constants.WelcomeApi, RequestBody.create(Constants.JSON, new f().b(jSONObject)), a.d(), this.f46061a);
                } catch (Exception e2) {
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
        }
    }

    public static void a(easypay.listeners.b bVar) {
        if (!AssistMerchantDetails.getInstance().isNativeOtpEnabled()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deviceType", "android");
                jSONObject.put("version", "8.2.2");
                jSONObject.put("mid", AssistMerchantDetails.getInstance().getMid());
                jSONObject.put("orderId", AssistMerchantDetails.getInstance().getOrderId());
                jSONObject.put("deviceType", "ANDROID");
                RequestBody create = RequestBody.create(Constants.JSON, jSONObject.toString());
                AssistLogs.printLog("Calling FetchApiByAppVersion:" + Constants.FETCH_URL_API, a.class.getSimpleName());
                a(Constants.FETCH_URL_API, create, d(), bVar);
            } catch (Exception e2) {
                AssistLogs.printLog("EXCEPTION", e2);
            }
        }
    }

    public static void a(String str, easypay.listeners.b bVar, String str2) {
        Class<a> cls = a.class;
        try {
            AssistLogs.printLog("Get Unique Assist API:" + str, cls.getSimpleName());
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bankName", jSONObject.getString(Constants.EXTRA_BANK_CODE));
            jSONObject2.put("payMode", jSONObject.getString(Constants.EXTRA_BANK_PAYTYPE));
            if (jSONObject.getString(Constants.EXTRA_BANK_PAYTYPE).equals("NB")) {
                jSONObject2.put(Constants.EXTRA_BANK_SCHEME, (Object) null);
            } else {
                jSONObject2.put(Constants.EXTRA_BANK_SCHEME, jSONObject.getString(Constants.EXTRA_BANK_SCHEME));
            }
            jSONObject2.put("orderId", AssistMerchantDetails.getInstance().getOrderId());
            jSONObject2.put("mid", AssistMerchantDetails.getInstance().getMid());
            jSONObject2.put("deviceType", "ANDROID");
            AssistLogs.printLog("requestBody:" + jSONObject2.toString(), cls.getSimpleName());
            a(str, RequestBody.create(Constants.JSON, jSONObject2.toString()), d(), bVar);
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
            AssistMerchantDetails.getInstance().getConfigDownloadListener().OnJsonDownLoadFailure(AppConstants.TRANSACTION_STATUS_ERROR);
        }
    }

    public static void a(ConcurrentHashMap<String, Object> concurrentHashMap, easypay.listeners.b bVar) {
        Class<a> cls = a.class;
        String b2 = new f().b(concurrentHashMap);
        AssistLogs.printLog("analytics log map-json:".concat(String.valueOf(b2)), cls.getSimpleName());
        AssistLogs.printLog("Events Log API:" + Constants.EventUrl, cls.getSimpleName());
        a(Constants.EventUrl, RequestBody.create(Constants.JSON, b2), d(), bVar);
    }

    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46062a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Headers f46063b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RequestBody f46064c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ easypay.listeners.b f46065d;

        b(String str, Headers headers, RequestBody requestBody, easypay.listeners.b bVar) {
            this.f46062a = str;
            this.f46063b = headers;
            this.f46064c = requestBody;
            this.f46065d = bVar;
        }

        public final void run() {
            AssistLogs.printLog(" URL: " + this.f46062a, this);
            a.a(new Request.Builder().url(this.f46062a).headers(this.f46063b).post(this.f46064c).build(), this.f46065d);
        }
    }

    public static void a(String str, RequestBody requestBody, Headers headers, easypay.listeners.b bVar) {
        new Thread(new b(str, headers, requestBody, bVar)).start();
    }

    static class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ easypay.listeners.b f46066a;

        c(easypay.listeners.b bVar) {
            this.f46066a = bVar;
        }

        public final void onFailure(Call call, IOException iOException) {
            this.f46066a.onFailure(iOException.getMessage());
            if (AssistMerchantDetails.getInstance().getListener() != null) {
                AssistMerchantDetails.getInstance().getListener().onApiError(iOException.getMessage());
            }
        }

        public final void onResponse(Call call, Response response) {
            if (response.body() != null) {
                try {
                    this.f46066a.onSuccess(response.body().string());
                } catch (IOException e2) {
                    AssistLogs.printLog("EXCEPTION", e2);
                }
            }
        }
    }

    public static void a() {
        OkHttpClient okHttpClient = f46060a;
        if (okHttpClient != null && okHttpClient.dispatcher().queuedCalls().size() == 0) {
            f46060a = null;
        } else if (f46060a != null) {
            new Handler().postDelayed(new d(), 5000);
        }
    }

    static class d implements Runnable {
        d() {
        }

        public final void run() {
            OkHttpClient unused = a.f46060a = null;
        }
    }

    /* access modifiers changed from: private */
    public static Headers d() {
        String str = "";
        String packageName = AssistMerchantDetails.getInstance().getActivity() != null ? AssistMerchantDetails.getInstance().getActivity().getPackageName() : str;
        if (AssistMerchantDetails.getInstance().getMid() != null) {
            str = AssistMerchantDetails.getInstance().getMid();
        }
        return new Headers.Builder().add("midParam", str).add("pkgName", packageName).add("encryptMsg", easypay.utils.b.a(str, packageName)).build();
    }

    static /* synthetic */ void a(Request request, easypay.listeners.b bVar) {
        if (f46060a == null) {
            f46060a = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();
        }
        try {
            FirebasePerfOkHttpClient.enqueue(f46060a.newCall(request), new c(bVar));
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }
}
