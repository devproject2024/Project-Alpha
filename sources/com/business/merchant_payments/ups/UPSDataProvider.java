package com.business.merchant_payments.ups;

import android.content.Context;
import android.text.TextUtils;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.RequestParamUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a.ae;
import kotlin.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.q;
import kotlin.g.b.ab;
import kotlin.g.b.g;
import kotlin.g.b.x;
import kotlin.k.e;
import kotlin.m.p;
import kotlin.t;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

public final class UPSDataProvider {
    public static final String APP_LOCALE = "ocl.notification.merchant.app_locale";
    public static final Companion Companion = new Companion((g) null);
    public static final String LOCK_SCREEN_NOTIFICATION_FLAG = "ocl.notification.merchant.display_notification_flag";
    public static final String VOICE_NOTIFICATION_FLAG = "ocl.notification.merchant.voice_notification_enabled";
    public static final String VOICE_NOTIFICATION_LANG = "ocl.notification.merchant.voice_notification_lang";
    public static final String WHATS_APP_NOTIFICATION_CONSENT_PREFS = "ocl.notification.merchant.whatsapp";
    public final List<String> allPreferencesList = k.b((T[]) new String[]{VOICE_NOTIFICATION_FLAG, VOICE_NOTIFICATION_LANG, APP_LOCALE, "ocl.notification.merchant.whatsapp", LOCK_SCREEN_NOTIFICATION_FLAG});
    public final Context applicationContext;
    public final CoroutineExceptionHandler handler = new UPSDataProvider$$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);

    public interface UPSResponseListener {
        void receivedDataFromUPS(String str);
    }

    public UPSDataProvider(Context context) {
        kotlin.g.b.k.d(context, "applicationContext");
        this.applicationContext = context;
    }

    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public final CoroutineExceptionHandler getHandler() {
        return this.handler;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static /* synthetic */ void fetchPrefsFromUPS$default(UPSDataProvider uPSDataProvider, boolean z, ArrayList arrayList, UPSResponseListener uPSResponseListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            arrayList = new ArrayList();
        }
        if ((i2 & 4) != 0) {
            uPSResponseListener = null;
        }
        uPSDataProvider.fetchPrefsFromUPS(z, arrayList, uPSResponseListener);
    }

    public final void fetchPrefsFromUPS(boolean z, ArrayList<String> arrayList, UPSResponseListener uPSResponseListener) {
        kotlin.g.b.k.d(arrayList, "preferencesList");
        x.e eVar = new x.e();
        eVar.element = z ? getQueryParams(this.allPreferencesList) : getQueryParams(arrayList);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.handler)), (f) null, (CoroutineStart) null, new UPSDataProvider$fetchPrefsFromUPS$1(this, eVar, uPSResponseListener, (d) null), 3, (Object) null);
    }

    public final void savePrefsToUPS(String str, String str2) {
        kotlin.g.b.k.d(str, "key");
        kotlin.g.b.k.d(str2, "value");
        APSharedPreferences.getInstance().saveUPSSyncTimestamp(0);
        JSONObject jSONObject = new JSONObject();
        UUID randomUUID = UUID.randomUUID();
        jSONObject.put("requestId", randomUUID);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(AppConstants.PREFERENCE_KEY, str);
        jSONObject2.put(AppConstants.PREFERENCE_VALUE, str2);
        jSONObject.put("request", jSONObject2);
        x.e eVar = new x.e();
        eVar.element = RequestParamUtil.getRequestBody(jSONObject.toString());
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(this.handler)), (f) null, (CoroutineStart) null, new UPSDataProvider$savePrefsToUPS$1(this, eVar, randomUUID, (d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleUPSResponse(UPSResponse uPSResponse, UPSResponseListener uPSResponseListener) {
        if (uPSResponse != null) {
            StatusInfo statusInfo = uPSResponse.getStatusInfo();
            List<Preferences> list = null;
            if (p.a(statusInfo != null ? statusInfo.getStatus() : null, "SUCCESS", true)) {
                Response response = uPSResponse.getResponse();
                if (response != null) {
                    list = response.getPreferences();
                }
                if (list != null && (!list.isEmpty())) {
                    APSharedPreferences instance = APSharedPreferences.getInstance();
                    kotlin.g.b.k.b(instance, "APSharedPreferences.getInstance()");
                    List c2 = ab.c(instance.getUPSData());
                    if (c2 == null || !(!c2.isEmpty())) {
                        APSharedPreferences.getInstance().saveUPSData(list);
                        updatePreferencesFromUPS(uPSResponseListener);
                        return;
                    }
                    updateSavedData(c2, list);
                    updatePreferencesFromUPS(uPSResponseListener);
                }
            }
        }
    }

    private final void updatePreferencesFromUPS(UPSResponseListener uPSResponseListener) {
        APSharedPreferences instance = APSharedPreferences.getInstance();
        kotlin.g.b.k.b(instance, "APSharedPreferences.getInstance()");
        List<Preferences> uPSData = instance.getUPSData();
        if (uPSData != null && uPSData.size() > 0) {
            for (Preferences next : uPSData) {
                String component1 = next.component1();
                String component2 = next.component2();
                Boolean component3 = next.component3();
                if (component1 == null || !p.a(component1, VOICE_NOTIFICATION_FLAG, true)) {
                    if (component1 == null || !p.a(component1, VOICE_NOTIFICATION_LANG, true)) {
                        if (component1 == null || !p.a(component1, APP_LOCALE, true)) {
                            if (component1 != null && p.a(component1, LOCK_SCREEN_NOTIFICATION_FLAG, true)) {
                                if (component3 == null || kotlin.g.b.k.a((Object) component3, (Object) Boolean.TRUE)) {
                                    APSharedPreferences instance2 = APSharedPreferences.getInstance();
                                    kotlin.g.b.k.b(instance2, "APSharedPreferences.getInstance()");
                                    String isLockScreenNotificationEnabled = instance2.getIsLockScreenNotificationEnabled();
                                    kotlin.g.b.k.b(isLockScreenNotificationEnabled, "APSharedPreferences.getI…ScreenNotificationEnabled");
                                    savePrefsToUPS(LOCK_SCREEN_NOTIFICATION_FLAG, isLockScreenNotificationEnabled);
                                } else if (component2 != null) {
                                    APSharedPreferences.getInstance().setIsLockScreenNotificationEnabled(p.a(component2, "true", true));
                                }
                            }
                        } else if (component3 == null || kotlin.g.b.k.a((Object) component3, (Object) Boolean.TRUE)) {
                            PaymentsConfig instance3 = PaymentsConfig.getInstance();
                            kotlin.g.b.k.b(instance3, "PaymentsConfig.getInstance()");
                            savePrefsToUPS(APP_LOCALE, instance3.getCommonUtils().b(this.applicationContext));
                        } else {
                            PaymentsConfig instance4 = PaymentsConfig.getInstance();
                            kotlin.g.b.k.b(instance4, "PaymentsConfig.getInstance()");
                            if (!(p.a(instance4.getCommonUtils().b(this.applicationContext), component2, true) || component2 == null || uPSResponseListener == null)) {
                                uPSResponseListener.receivedDataFromUPS(component2);
                            }
                        }
                    } else if (component3 == null || kotlin.g.b.k.a((Object) component3, (Object) Boolean.TRUE)) {
                        APSharedPreferences instance5 = APSharedPreferences.getInstance();
                        kotlin.g.b.k.b(instance5, "APSharedPreferences.getInstance()");
                        String voiceLocale = instance5.getVoiceLocale();
                        kotlin.g.b.k.b(voiceLocale, "APSharedPreferences.getInstance().voiceLocale");
                        savePrefsToUPS(VOICE_NOTIFICATION_LANG, voiceLocale);
                    } else {
                        APSharedPreferences instance6 = APSharedPreferences.getInstance();
                        kotlin.g.b.k.b(instance6, "APSharedPreferences.getInstance()");
                        instance6.setVoiceLocale(component2);
                    }
                } else if (component3 == null || kotlin.g.b.k.a((Object) component3, (Object) Boolean.TRUE)) {
                    APSharedPreferences instance7 = APSharedPreferences.getInstance();
                    kotlin.g.b.k.b(instance7, "APSharedPreferences.getInstance()");
                    String isVoiceNotificationEnabled = instance7.getIsVoiceNotificationEnabled();
                    kotlin.g.b.k.b(isVoiceNotificationEnabled, "APSharedPreferences.getI…sVoiceNotificationEnabled");
                    savePrefsToUPS(VOICE_NOTIFICATION_FLAG, isVoiceNotificationEnabled);
                } else if (component2 != null) {
                    APSharedPreferences.getInstance().setIsVoiceNotificationEnabled(p.a(component2, "true", true));
                }
            }
        }
    }

    private final String getQueryParams(List<String> list) {
        String str = "";
        for (String next : list) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ',' + next;
            } else {
                str = next;
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateWhatsConsentStatusAPI(java.lang.String r5, kotlin.k.e<kotlin.x> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "statusRecieved"
            kotlin.g.b.k.d(r6, r0)
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r1 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r0, r1)
            android.app.Application r0 = r0.getApplication()
            boolean r0 = com.business.common_module.utilities.i.a((android.app.Application) r0)
            if (r0 != 0) goto L_0x0030
            kotlin.g.a.q r6 = (kotlin.g.a.q) r6
            android.content.Context r5 = r4.applicationContext
            int r0 = com.business.merchant_payments.R.string.mp_network_error_message
            java.lang.String r5 = r5.getString(r0)
            java.lang.String r0 = "applicationContext.getSt…mp_network_error_message)"
            kotlin.g.b.k.b(r5, r0)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            android.content.Context r1 = r4.applicationContext
            r6.invoke(r5, r0, r1)
            return
        L_0x0030:
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r0 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r0 = r0.getMInstance()
            java.lang.String r0 = r0.getUPSBaseUrl()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r2 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r2 = r2.getMInstance()
            java.lang.String r2 = r2.getUPSPrefsUrl()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r2 = 0
            java.util.HashMap r2 = com.business.merchant_payments.common.utility.RequestParamUtil.getUPSHeaders(r2)
            com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r3, r1)
            com.business.common_module.b.i r3 = r3.getMerchantDataProvider()
            java.lang.String r3 = r3.B()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0080
            com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r3, r1)
            com.business.common_module.b.i r3 = r3.getMerchantDataProvider()
            com.business.common_module.e.a r3 = r3.b()
            if (r3 == 0) goto L_0x0080
            r3 = 1
            goto L_0x0081
        L_0x0080:
            r3 = 0
        L_0x0081:
            if (r3 != 0) goto L_0x009a
            kotlin.g.a.q r6 = (kotlin.g.a.q) r6
            android.content.Context r5 = r4.applicationContext
            int r0 = com.business.merchant_payments.R.string.mp_relogin_error_message
            java.lang.String r5 = r5.getString(r0)
            java.lang.String r0 = "applicationContext.getSt…mp_relogin_error_message)"
            kotlin.g.b.k.b(r5, r0)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            android.content.Context r1 = r4.applicationContext
            r6.invoke(r5, r0, r1)
            return
        L_0x009a:
            com.business.merchant_payments.PaymentsConfig r3 = com.business.merchant_payments.PaymentsConfig.getInstance()
            kotlin.g.b.k.b(r3, r1)
            com.business.merchant_payments.utility.NetworkService r1 = r3.getNetworkService()
            java.lang.String r5 = r4.requestBodyForSetPref(r5)
            okhttp3.RequestBody r5 = com.business.merchant_payments.common.utility.RequestParamUtil.getRequestBody(r5)
            retrofit2.Call r5 = r1.savePrefsToUPS(r0, r2, r5)
            java.lang.String r0 = "PaymentsConfig.getInstan…consentStatus)\n        ))"
            kotlin.g.b.k.b(r5, r0)
            com.business.merchant_payments.ups.UPSDataProvider$updateWhatsConsentStatusAPI$1 r0 = new com.business.merchant_payments.ups.UPSDataProvider$updateWhatsConsentStatusAPI$1
            r0.<init>(r4, r6)
            r5.enqueue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.ups.UPSDataProvider.updateWhatsConsentStatusAPI(java.lang.String, kotlin.k.e):void");
    }

    /* access modifiers changed from: private */
    public final void handleWhatappSetPrefResponse(UPSResponse uPSResponse, e<kotlin.x> eVar) {
        if (uPSResponse != null) {
            StatusInfo statusInfo = uPSResponse.getStatusInfo();
            if (p.a(statusInfo != null ? statusInfo.getStatus() : null, "SUCCESS", true)) {
                ((q) eVar).invoke("SUCCESS", Boolean.TRUE, this.applicationContext);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Preferences("ocl.notification.merchant.whatsapp", "true", Boolean.FALSE));
                Response response = uPSResponse.getResponse();
                kotlin.g.b.k.a((Object) response);
                response.setPreferences(arrayList);
                handleUPSResponse(uPSResponse, (UPSResponseListener) null);
                return;
            }
            String string = this.applicationContext.getString(R.string.mp_whatapp_consent_fail_msg);
            kotlin.g.b.k.b(string, "applicationContext.getSt…whatapp_consent_fail_msg)");
            ((q) eVar).invoke(string, Boolean.FALSE, this.applicationContext);
            return;
        }
        String string2 = this.applicationContext.getString(R.string.mp_whatapp_consent_fail_msg);
        kotlin.g.b.k.b(string2, "applicationContext.getSt…whatapp_consent_fail_msg)");
        ((q) eVar).invoke(string2, Boolean.FALSE, this.applicationContext);
    }

    private final String requestBodyForSetPref(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", UUID.randomUUID().toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AppConstants.PREFERENCE_KEY, "ocl.notification.merchant.whatsapp");
            jSONObject2.put(AppConstants.PREFERENCE_VALUE, str);
            jSONObject.put("request", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            kotlin.g.b.k.b(jSONObject3, "jsonObject.toString()");
            return jSONObject3;
        } catch (Exception unused) {
            return "";
        }
    }

    private final void updateSavedData(List<Preferences> list, List<Preferences> list2) {
        ArrayList arrayList = new ArrayList(k.a(list));
        for (Preferences preferences : list) {
            arrayList.add(t.a(preferences.getKey(), preferences));
        }
        Map a2 = ae.a(arrayList);
        ArrayList arrayList2 = new ArrayList(k.a(list2));
        for (Preferences preferences2 : list2) {
            arrayList2.add(t.a(preferences2.getKey(), preferences2));
        }
        Map b2 = ae.b(ae.a(arrayList2));
        for (Map.Entry entry : a2.entrySet()) {
            if (!b2.containsKey(entry.getKey())) {
                b2.put(entry.getKey(), entry.getValue());
            }
        }
        APSharedPreferences.getInstance().saveUPSData(k.e(b2.values()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object getPrefsFromUPSApi(java.lang.String r10, kotlin.d.d<? super com.business.merchant_payments.ups.UPSResponse> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.business.merchant_payments.ups.UPSDataProvider$getPrefsFromUPSApi$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.business.merchant_payments.ups.UPSDataProvider$getPrefsFromUPSApi$1 r0 = (com.business.merchant_payments.ups.UPSDataProvider$getPrefsFromUPSApi$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.ups.UPSDataProvider$getPrefsFromUPSApi$1 r0 = new com.business.merchant_payments.ups.UPSDataProvider$getPrefsFromUPSApi$1
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0030
            if (r2 != r3) goto L_0x0028
            kotlin.ResultKt.a((java.lang.Object) r11)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x009b
        L_0x0028:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0030:
            kotlin.ResultKt.a((java.lang.Object) r11)
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r11 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r11 = r11.getMInstance()
            java.lang.String r11 = r11.getUPSBaseUrl()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r2 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r2 = r2.getMInstance()
            java.lang.String r2 = r2.getUPSPrefsUrl()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r5.append(r2)
            java.lang.String r6 = "?preferenceKeys="
            r5.append(r6)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.util.HashMap r6 = com.business.merchant_payments.common.utility.RequestParamUtil.getUPSHeaders(r4)
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r8 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r7, r8)
            android.app.Application r7 = r7.getApplication()
            boolean r7 = com.business.common_module.utilities.i.a((android.app.Application) r7)
            if (r7 != 0) goto L_0x0076
            return r4
        L_0x0076:
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00b0 }
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x00b0 }
            com.business.merchant_payments.utility.APKotlinNetworkService r7 = r7.getKotlinNetworkService()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r8 = "headers"
            kotlin.g.b.k.b(r6, r8)     // Catch:{ Exception -> 0x00b0 }
            r0.L$0 = r9     // Catch:{ Exception -> 0x00b0 }
            r0.L$1 = r10     // Catch:{ Exception -> 0x00b0 }
            r0.L$2 = r11     // Catch:{ Exception -> 0x00b0 }
            r0.L$3 = r2     // Catch:{ Exception -> 0x00b0 }
            r0.L$4 = r5     // Catch:{ Exception -> 0x00b0 }
            r0.L$5 = r6     // Catch:{ Exception -> 0x00b0 }
            r0.label = r3     // Catch:{ Exception -> 0x00b0 }
            java.lang.Object r11 = r7.getPrefsFromUPS(r5, r6, r0)     // Catch:{ Exception -> 0x00b0 }
            if (r11 != r1) goto L_0x009b
            return r1
        L_0x009b:
            retrofit2.Response r11 = (retrofit2.Response) r11     // Catch:{ Exception -> 0x00b0 }
            boolean r10 = r11.isSuccessful()     // Catch:{ Exception -> 0x00b0 }
            if (r10 == 0) goto L_0x00b0
            java.lang.Object r10 = r11.body()     // Catch:{ Exception -> 0x00b0 }
            if (r10 == 0) goto L_0x00b0
            java.lang.Object r10 = r11.body()     // Catch:{ Exception -> 0x00b0 }
            com.business.merchant_payments.ups.UPSResponse r10 = (com.business.merchant_payments.ups.UPSResponse) r10     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00b1
        L_0x00b0:
            r10 = r4
        L_0x00b1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.ups.UPSDataProvider.getPrefsFromUPSApi(java.lang.String, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object savePrefsToUPS(okhttp3.RequestBody r10, java.util.UUID r11, kotlin.d.d<? super com.business.merchant_payments.ups.UPSResponse> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$2
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$2 r0 = (com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$2 r0 = new com.business.merchant_payments.ups.UPSDataProvider$savePrefsToUPS$2
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0030
            if (r2 != r4) goto L_0x0028
            kotlin.ResultKt.a((java.lang.Object) r12)     // Catch:{ Exception -> 0x00aa }
            goto L_0x0095
        L_0x0028:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0030:
            kotlin.ResultKt.a((java.lang.Object) r12)
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r12 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r12 = r12.getMInstance()
            java.lang.String r12 = r12.getUPSBaseUrl()
            com.business.merchant_payments.common.utility.GTMDataProviderImpl$Companion r2 = com.business.merchant_payments.common.utility.GTMDataProviderImpl.Companion
            com.business.merchant_payments.common.utility.GTMDataProviderImpl r2 = r2.getMInstance()
            java.lang.String r2 = r2.getUPSPrefsUrl()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r12)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.util.HashMap r6 = com.business.merchant_payments.common.utility.RequestParamUtil.getUPSHeaders(r11)
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r8 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r7, r8)
            android.app.Application r7 = r7.getApplication()
            boolean r7 = com.business.common_module.utilities.i.a((android.app.Application) r7)
            if (r7 != 0) goto L_0x006e
            return r3
        L_0x006e:
            com.business.merchant_payments.PaymentsConfig r7 = com.business.merchant_payments.PaymentsConfig.getInstance()     // Catch:{ Exception -> 0x00aa }
            kotlin.g.b.k.b(r7, r8)     // Catch:{ Exception -> 0x00aa }
            com.business.merchant_payments.utility.APKotlinNetworkService r7 = r7.getKotlinNetworkService()     // Catch:{ Exception -> 0x00aa }
            java.lang.String r8 = "headers"
            kotlin.g.b.k.b(r6, r8)     // Catch:{ Exception -> 0x00aa }
            r0.L$0 = r9     // Catch:{ Exception -> 0x00aa }
            r0.L$1 = r10     // Catch:{ Exception -> 0x00aa }
            r0.L$2 = r11     // Catch:{ Exception -> 0x00aa }
            r0.L$3 = r12     // Catch:{ Exception -> 0x00aa }
            r0.L$4 = r2     // Catch:{ Exception -> 0x00aa }
            r0.L$5 = r5     // Catch:{ Exception -> 0x00aa }
            r0.L$6 = r6     // Catch:{ Exception -> 0x00aa }
            r0.label = r4     // Catch:{ Exception -> 0x00aa }
            java.lang.Object r12 = r7.savePrefsToUPS(r5, r6, r10, r0)     // Catch:{ Exception -> 0x00aa }
            if (r12 != r1) goto L_0x0095
            return r1
        L_0x0095:
            retrofit2.Response r12 = (retrofit2.Response) r12     // Catch:{ Exception -> 0x00aa }
            boolean r10 = r12.isSuccessful()     // Catch:{ Exception -> 0x00aa }
            if (r10 == 0) goto L_0x00aa
            java.lang.Object r10 = r12.body()     // Catch:{ Exception -> 0x00aa }
            if (r10 == 0) goto L_0x00aa
            java.lang.Object r10 = r12.body()     // Catch:{ Exception -> 0x00aa }
            com.business.merchant_payments.ups.UPSResponse r10 = (com.business.merchant_payments.ups.UPSResponse) r10     // Catch:{ Exception -> 0x00aa }
            goto L_0x00ab
        L_0x00aa:
            r10 = r3
        L_0x00ab:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.ups.UPSDataProvider.savePrefsToUPS(okhttp3.RequestBody, java.util.UUID, kotlin.d.d):java.lang.Object");
    }
}
