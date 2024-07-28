package com.business.merchant_payments.notificationsettings.repository;

import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.a;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.common.utility.GTMDataProviderImpl;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.NotificationsSettingsDataModel;
import com.business.merchant_payments.utility.NetworkService;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import okhttp3.RequestBody;
import retrofit2.Call;

public final class NotificationsRepository {
    public static final NotificationsRepository INSTANCE = new NotificationsRepository();
    public static final NetworkService networkService;

    static {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        NetworkService networkService2 = instance.getNetworkService();
        k.b(networkService2, "PaymentsConfig.getInstance().networkService");
        networkService = networkService2;
    }

    public final NetworkService getNetworkService() {
        return networkService;
    }

    public final LiveData<b<NotificationsSettingsDataModel>> getNotificationSettings(String str) {
        k.d(str, "type");
        y yVar = new y();
        yVar.setValue(b.a());
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        HashMap<String, Object> headers = RequestParamUtil.getHeaders(instance.getAppContext());
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        Call<NotificationsSettingsDataModel> callNotificationSettingsApi = networkService.callNotificationSettingsApi(GTMDataProviderImpl.Companion.getMInstance().getUMPBaseUrl() + GTMDataProviderImpl.Companion.getMInstance().getNotificationSettingsUrl(), headers, hashMap);
        k.b(callNotificationSettingsApi, "networkService.callNotif…i(url, headers, queryMap)");
        callNotificationSettingsApi.enqueue(new NotificationsRepository$getNotificationSettings$1(yVar));
        return yVar;
    }

    public final LiveData<b<NotificationOnOffDataModel>> updateNotificationSettings(String str) {
        y yVar = new y();
        yVar.setValue(b.a());
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        HashMap<String, Object> headers = RequestParamUtil.getHeaders(instance.getAppContext());
        RequestBody requestBody = RequestParamUtil.getRequestBody(str);
        k.b(requestBody, "RequestParamUtil.getRequ…ody(notificationSettings)");
        networkService.updateNotificationSettings(GTMDataProviderImpl.Companion.getMInstance().getUMPBaseUrl() + GTMDataProviderImpl.Companion.getMInstance().getNotificationSettingsUrl(), requestBody, headers).enqueue(new NotificationsRepository$updateNotificationSettings$1(yVar));
        return yVar;
    }

    public static final LiveData<b<MerchantProfileResponse>> updateMerchantProfileSecondary(String str, String str2) {
        k.d(str, "body");
        k.d(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        String merchantProfileSecondaryUrlV2 = GTMDataProviderImpl.Companion.getMInstance().getMerchantProfileSecondaryUrlV2();
        if (!URLUtil.isValidUrl(merchantProfileSecondaryUrlV2)) {
            LiveData<b<MerchantProfileResponse>> a2 = a.a();
            k.b(a2, "AbsentLiveData.create()");
            return a2;
        }
        RequestBody requestBody = RequestParamUtil.getRequestBody(str);
        if (requestBody != null) {
            y yVar = new y();
            yVar.setValue(b.a());
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            HashMap<String, Object> requestHeaderMidParam = RequestParamUtil.getRequestHeaderMidParam(instance.getAppContext());
            long currentTimeMillis = System.currentTimeMillis();
            Call<MerchantProfileResponse> updateMerchantProfileSecondary = networkService.updateMerchantProfileSecondary(merchantProfileSecondaryUrlV2, requestHeaderMidParam, requestBody);
            k.b(updateMerchantProfileSecondary, "networkService.updateMer…rl, headers, requestBody)");
            updateMerchantProfileSecondary.enqueue(new NotificationsRepository$updateMerchantProfileSecondary$1(currentTimeMillis, str2, yVar));
            return yVar;
        }
        LiveData<b<MerchantProfileResponse>> a3 = a.a();
        k.b(a3, "AbsentLiveData.create()");
        return a3;
    }
}
