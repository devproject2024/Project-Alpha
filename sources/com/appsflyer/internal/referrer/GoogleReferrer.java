package com.appsflyer.internal.referrer;

import android.content.Context;
import com.android.installreferrer.a.a;
import com.android.installreferrer.a.c;
import com.android.installreferrer.a.d;
import com.appsflyer.AFLogger;
import com.appsflyer.AndroidUtils;
import com.appsflyer.AppsFlyerLibCore;
import java.util.HashMap;
import java.util.Map;

public class GoogleReferrer {
    public final Map<String, Object> newMap = new HashMap();
    public final Map<String, Object> oldMap = new HashMap();

    public static boolean allow(AppsFlyerLibCore appsFlyerLibCore, Context context) {
        if (appsFlyerLibCore.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(context), false) > 2) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (AndroidUtils.isPermissionAvailable(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.android.installreferrer.api.InstallReferrerClient");
            sb.append(" not found");
            AFLogger.afRDLog(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : ".concat("com.android.installreferrer.api.InstallReferrerClient"), th);
            return false;
        }
    }

    public void start(Context context, final Runnable runnable) {
        try {
            final a a2 = a.a(context).a();
            AFLogger.afDebugLog("Connecting to Install Referrer Library...");
            a2.a((c) new c() {
                public final void onInstallReferrerSetupFinished(int i2) {
                    GoogleReferrer.this.oldMap.put("code", String.valueOf(i2));
                    GoogleReferrer.this.newMap.put("source", Payload.SOURCE_GOOGLE);
                    GoogleReferrer.this.newMap.putAll(new MandatoryFields());
                    if (i2 == -1) {
                        AFLogger.afWarnLog("InstallReferrer SERVICE_DISCONNECTED");
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_SERVICE_DISCONNECTED);
                    } else if (i2 == 0) {
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_OK);
                        try {
                            AFLogger.afDebugLog("InstallReferrer connected");
                            if (a2.a()) {
                                d c2 = a2.c();
                                String a2 = c2.a();
                                if (a2 != null) {
                                    GoogleReferrer.this.oldMap.put("val", a2);
                                    GoogleReferrer.this.newMap.put(Payload.REFERRER, a2);
                                }
                                long b2 = c2.b();
                                GoogleReferrer.this.oldMap.put("clk", Long.toString(b2));
                                GoogleReferrer.this.newMap.put(Payload.CLICK_TS, Long.valueOf(b2));
                                long c3 = c2.c();
                                GoogleReferrer.this.oldMap.put("install", Long.toString(c3));
                                GoogleReferrer.this.newMap.put(Payload.INSTALL_BEGIN_TS, Long.valueOf(c3));
                                try {
                                    GoogleReferrer.this.oldMap.put(Payload.INSTANT, Boolean.valueOf(c2.f6387a.getBoolean("google_play_instant")));
                                } catch (NoSuchMethodError unused) {
                                }
                            } else {
                                AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                                GoogleReferrer.this.oldMap.put("err", "ReferrerClient: InstallReferrer is not ready");
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                            sb.append(th.getMessage());
                            AFLogger.afWarnLog(sb.toString());
                            GoogleReferrer.this.oldMap.put("err", th.getMessage());
                        }
                    } else if (i2 == 1) {
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_SERVICE_UNAVAILABLE);
                        AFLogger.afWarnLog("InstallReferrer not supported");
                    } else if (i2 == 2) {
                        AFLogger.afWarnLog("InstallReferrer FEATURE_NOT_SUPPORTED");
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_FEATURE_NOT_SUPPORTED);
                    } else if (i2 != 3) {
                        AFLogger.afWarnLog("responseCode not found.");
                    } else {
                        AFLogger.afWarnLog("InstallReferrer DEVELOPER_ERROR");
                        GoogleReferrer.this.newMap.put(Payload.RESPONSE, Payload.RESPONSE_DEVELOPER_ERROR);
                    }
                    AFLogger.afDebugLog("Install Referrer collected locally");
                    runnable.run();
                    a2.b();
                }

                public final void onInstallReferrerServiceDisconnected() {
                    AFLogger.afDebugLog("Install Referrer service disconnected");
                }
            });
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }
}
