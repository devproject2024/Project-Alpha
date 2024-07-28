package easypay.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.app.JobIntentService;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import easypay.manager.AssistMerchantDetails;
import easypay.manager.Constants;

public class EasyPayConfigDownloader extends JobIntentService {
    private SharedPreferences j;
    private String k;

    public interface b {
        void OnJsonDownLoadFailure(String str);

        void OnJsonDownLoadSuccess(String str);
    }

    public static void a(Context context, Intent intent) {
        JobIntentService.a(context, (Class<?>) EasyPayConfigDownloader.class, 2321, intent);
    }

    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }

    public void onCreate() {
        super.onCreate();
    }

    public final void a(Intent intent) {
        this.j = getSharedPreferences(Constants.EASYPAY_NEW_PREFERENCE_FILE, 0);
        getSharedPreferences(Constants.EASY_PAY_ETAG_PREF, 0);
        this.k = intent.getStringExtra(Constants.EXTRA_BANK_REQ_JSON);
        try {
            long j2 = this.j.getLong("easypay_configuration_load_timestamp", 0);
            if (System.currentTimeMillis() - j2 > this.j.getLong("easypay_configuration_ttl", 0)) {
                String configUrlToHit = AssistMerchantDetails.getInstance().getConfigUrlToHit();
                AssistLogs.printLog("EasyPay Config requestURL:" + configUrlToHit, this);
                a aVar = new a();
                AssistLogs.printLog("Sending config download response to listener", this);
                easypay.actions.a.a(configUrlToHit, (easypay.listeners.b) aVar, this.k);
                SharedPreferences.Editor edit = this.j.edit();
                edit.putLong("easypay_configuration_load_timestamp", System.currentTimeMillis());
                edit.apply();
            }
        } catch (Exception e2) {
            AssistLogs.printLog("EXCEPTION", e2);
        }
    }

    class a implements easypay.listeners.b {
        a() {
        }

        public final void onSuccess(String str) {
            if (str != null) {
                if (!(AssistMerchantDetails.getInstance() == null || AssistMerchantDetails.getInstance().getConfigDownloadListener() == null)) {
                    AssistMerchantDetails.getInstance().getConfigDownloadListener().OnJsonDownLoadSuccess("SUCCESS");
                }
                b.a(AssistMerchantDetails.getInstance().getContext(), str);
            }
        }

        public final void onFailure(String str) {
            AssistLogs.printLog("Failure in executing getUniqueAssist API: ".concat(String.valueOf(str)), this);
            if (!(AssistMerchantDetails.getInstance() == null || AssistMerchantDetails.getInstance().getConfigDownloadListener() == null)) {
                AssistMerchantDetails.getInstance().getConfigDownloadListener().OnJsonDownLoadFailure(AppConstants.TRANSACTION_STATUS_ERROR);
            }
            if (str != null) {
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "getUniqueAssist $".concat(String.valueOf(str)));
            } else {
                AssistMerchantDetails.getInstance().setEventInEventMap(Constants.EVENTS_API_ERROR_RECEIVED, "getUniqueAssist $ API Failed while executing");
            }
        }
    }
}
