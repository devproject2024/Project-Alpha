package com.paytm.notification.schedulers.b;

import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.notification.data.c.h;
import com.paytm.notification.j;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.pai.network.model.EventResponse;
import com.paytm.signal.b;
import com.paytm.signal.models.Config;
import easypay.manager.Constants;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final h f43252a;

    public a(h hVar) {
        k.c(hVar, "pushConfigRepo");
        this.f43252a = hVar;
    }

    public final boolean a() throws com.paytm.notification.schedulers.a.a {
        String str;
        HashMap response;
        try {
            h c2 = j.f43241a.c();
            String configEndPoints$paytmnotification_paytmRelease = c2.a().getConfigEndPoints$paytmnotification_paytmRelease();
            if (configEndPoints$paytmnotification_paytmRelease != null) {
                String j = c2.j();
                if (j != null) {
                    String clientName$paytmnotification_paytmRelease = c2.a().getClientName$paytmnotification_paytmRelease();
                    if (clientName$paytmnotification_paytmRelease != null) {
                        EventResponse<HashMap<String, String>> a2 = a(configEndPoints$paytmnotification_paytmRelease, j, clientName$paytmnotification_paytmRelease);
                        if (a2 != null) {
                            if (!k.a((Object) a2.isSuccess(), (Object) Boolean.FALSE) || !k.a((Object) a2.isDoNotRetry(), (Object) Boolean.TRUE)) {
                                if (k.a((Object) a2.isSuccess(), (Object) Boolean.FALSE)) {
                                    return false;
                                }
                                if (!(a2.getResponse() == null || (response = a2.getResponse()) == null || !(!response.isEmpty()))) {
                                    NotificationUserConfig a3 = c2.a();
                                    HashMap<String, String> response2 = a2.getResponse();
                                    if (response2 == null) {
                                        k.a();
                                    }
                                    HashMap hashMap = response2;
                                    k.c(a3, "$this$mapRemoteConfig");
                                    k.c(hashMap, "configMap");
                                    NotificationUserConfig.Builder builder = new NotificationUserConfig.Builder();
                                    builder.setSecret$paytmnotification_paytmRelease(a3.getSecret$paytmnotification_paytmRelease());
                                    builder.setClientName$paytmnotification_paytmRelease(a3.getClientName$paytmnotification_paytmRelease());
                                    builder.setCustomerId$paytmnotification_paytmRelease(a3.getCustomerId$paytmnotification_paytmRelease());
                                    builder.setAppVersion$paytmnotification_paytmRelease(a3.getAppVersion$paytmnotification_paytmRelease());
                                    builder.setDeviceId$paytmnotification_paytmRelease(a3.getDeviceId$paytmnotification_paytmRelease());
                                    Boolean staging$paytmnotification_paytmRelease = a3.getStaging$paytmnotification_paytmRelease();
                                    builder.setStaging$paytmnotification_paytmRelease(staging$paytmnotification_paytmRelease != null ? staging$paytmnotification_paytmRelease.booleanValue() : false);
                                    builder.setMsgIcon$paytmnotification_paytmRelease(a3.getMsgIcon$paytmnotification_paytmRelease());
                                    builder.setLoginState$paytmnotification_paytmRelease(a3.getLoginState$paytmnotification_paytmRelease());
                                    builder.setConfigEndPoints$paytmnotification_paytmRelease(a3.getConfigEndPoints$paytmnotification_paytmRelease());
                                    builder.setServerEndPoints$paytmnotification_paytmRelease((String) hashMap.get("androidPushRegistryEndPoint"));
                                    builder.setInboxEndPoints$paytmnotification_paytmRelease((String) hashMap.get("androidInboxEndPoint"));
                                    builder.setEventBatchEndPoint$paytmnotification_paytmRelease((String) hashMap.get("androidEventEndPoint"));
                                    builder.setFlashEndPoint$paytmnotification_paytmRelease((String) hashMap.get("androidFlashEndPoint"));
                                    String str2 = (String) hashMap.get("androidSignalBatchFrequency");
                                    builder.setEventBatchFrequency$paytmnotification_paytmRelease(Integer.valueOf(str2 != null ? Integer.parseInt(str2) : 0));
                                    String str3 = (String) hashMap.get("androidEventBatchSize");
                                    builder.setEventBatchSize$paytmnotification_paytmRelease(Integer.valueOf(str3 != null ? Integer.parseInt(str3) : 0));
                                    String str4 = (String) hashMap.get("androidIsInboxEnabled");
                                    builder.setInboxDisabled$paytmnotification_paytmRelease(Boolean.valueOf(!(str4 != null ? Boolean.parseBoolean(str4) : false)));
                                    String str5 = (String) hashMap.get("androidIsFlashEnabled");
                                    builder.setFlashDisabled$paytmnotification_paytmRelease(Boolean.valueOf(!(str5 != null ? Boolean.parseBoolean(str5) : false)));
                                    String str6 = (String) hashMap.get("androidIsPushEnabled");
                                    builder.setPushDisabled$paytmnotification_paytmRelease(Boolean.valueOf(!(str6 != null ? Boolean.parseBoolean(str6) : false)));
                                    c2.a(builder.build());
                                    NotificationUserConfig a4 = c2.a();
                                    b.C0745b bVar = b.f43594e;
                                    Config.Builder deviceId = new Config.Builder().serverEndPoints(a4.getEventBatchEndPoint$paytmnotification_paytmRelease()).appVersion(a4.getAppVersion$paytmnotification_paytmRelease()).clientName(a4.getClientName$paytmnotification_paytmRelease()).deviceId(a4.getDeviceId$paytmnotification_paytmRelease());
                                    int eventBatchFrequency$paytmnotification_paytmRelease = a4.getEventBatchFrequency$paytmnotification_paytmRelease();
                                    if (eventBatchFrequency$paytmnotification_paytmRelease == null) {
                                        eventBatchFrequency$paytmnotification_paytmRelease = 0;
                                    }
                                    Config build = deviceId.uploadFrequency(eventBatchFrequency$paytmnotification_paytmRelease).secret(a4.getSecret$paytmnotification_paytmRelease()).messageVersion(1).uploadFrequency(10).appLanguage(a4.getAppLanguage$paytmnotification_paytmRelease()).timeSyncFrequency(Integer.valueOf((int) TimeUnit.MINUTES.toSeconds(15))).build();
                                    k.c(build, Constants.EASY_PAY_CONFIG_PREF_KEY);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new b.C0745b.e(build, currentTimeMillis, (d) null), 2, (Object) null);
                                    StringBuilder sb = new StringBuilder("***** updateConfig() UI thread took [");
                                    sb.append(System.currentTimeMillis() - currentTimeMillis);
                                    sb.append("] ms ***** ");
                                }
                                return true;
                            }
                        }
                        if (a2 != null) {
                            str = a2.getErrorMessage();
                            if (a2.getResponse() != null) {
                                str = str + ": " + new f().b(a2.getResponse());
                            }
                        } else {
                            str = "response is null";
                        }
                        throw new com.paytm.notification.schedulers.a.a(str);
                    }
                    throw new com.paytm.notification.schedulers.a.a("clientName not found");
                }
                throw new com.paytm.notification.schedulers.a.a("App secret not found");
            }
            throw new com.paytm.notification.schedulers.a.a("configEndPoints not found");
        } catch (com.paytm.notification.schedulers.a.a e2) {
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (Exception e3) {
            e.f43014a.b(e3);
            return false;
        }
    }

    private final EventResponse<HashMap<String, String>> a(String str, String str2, String str3) throws com.paytm.notification.schedulers.a.a {
        try {
            return this.f43252a.a(str, str2, str3);
        } catch (MalformedURLException e2) {
            throw new com.paytm.notification.schedulers.a.a(e2.getMessage());
        } catch (com.paytm.notification.data.a.a e3) {
            throw new com.paytm.notification.schedulers.a.a(e3.getMessage());
        }
    }
}
