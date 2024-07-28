package net.one97.paytm.payments.visascp;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.one97.paytm.payments.visascp.VisaSCPImpl;
import net.one97.paytm.payments.visascp.customAsync.CustomCallable;
import net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager;
import net.one97.paytm.payments.visascp.keygen.KeyGeneratorCustomAsync;
import net.one97.paytm.payments.visascp.network.CheckEnrollmentStatus;
import net.one97.paytm.payments.visascp.network.DeEnrollCard;
import net.one97.paytm.payments.visascp.network.GetAuthCode;
import net.one97.paytm.payments.visascp.network.GetVisaCertificate;
import net.one97.paytm.payments.visascp.network.HawkEyeEvent;
import net.one97.paytm.payments.visascp.network.VerifyDevice;
import net.one97.paytm.payments.visascp.network.model.AccountStatusDataModel;
import net.one97.paytm.payments.visascp.network.model.ApiStatusModel;
import net.one97.paytm.payments.visascp.network.model.AuthCodeJwsResponseModel;
import net.one97.paytm.payments.visascp.network.model.AuthCodeResponseModel;
import net.one97.paytm.payments.visascp.network.model.BaseModel;
import net.one97.paytm.payments.visascp.network.model.BodyModel;
import net.one97.paytm.payments.visascp.network.model.DeEnrollResponseModel;
import net.one97.paytm.payments.visascp.network.model.EnrollmentStatusModel;
import net.one97.paytm.payments.visascp.nonce.NonceGenerator;
import net.one97.paytm.payments.visascp.safetynet.GoogleSafetyNet;
import net.one97.paytm.payments.visascp.safetynet.SafetyNetResponseListener;
import net.one97.paytm.payments.visascp.security.Decrypter;
import net.one97.paytm.payments.visascp.security.Encrypter;
import net.one97.paytm.payments.visascp.storage.SecureSharedPref;
import net.one97.paytm.payments.visascp.util.CountDownLatchWrapper;
import net.one97.paytm.payments.visascp.util.TimeLogger;
import net.one97.paytm.payments.visascp.util.TokenStatus;
import net.one97.paytm.payments.visascp.util.Utils;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class VisaSCPMain implements VisaSCP {
    /* access modifiers changed from: private */

    /* renamed from: ˊ  reason: contains not printable characters */
    public CountDownLatchWrapper f383;
    /* access modifiers changed from: private */

    /* renamed from: ˋ  reason: contains not printable characters */
    public CustomThreadPoolExecutorManager f384;
    /* access modifiers changed from: private */

    /* renamed from: ˎ  reason: contains not printable characters */
    public CountDownLatchWrapper f385;
    /* access modifiers changed from: private */

    /* renamed from: ˏ  reason: contains not printable characters */
    public long f386;
    /* access modifiers changed from: private */

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Context f387;

    /* synthetic */ VisaSCPMain(VisaSCPBuilder visaSCPBuilder, byte b2) {
        this(visaSCPBuilder);
    }

    private VisaSCPMain(VisaSCPBuilder visaSCPBuilder) {
        this.f385 = null;
        this.f383 = null;
        this.f387 = visaSCPBuilder.getApplicationContext();
        this.f384 = CustomThreadPoolExecutorManager.getsInstance();
    }

    public void createOneClickInfoObject(String str, String str2, String str3, String str4) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        final String str8 = str4;
        if (isEnrollmentSuccess(str, str2, str3, str4)) {
            CountDownLatchWrapper countDownLatchWrapper = this.f383;
            if (countDownLatchWrapper == null || !countDownLatchWrapper.isSameCard(str5, str6, str7, str8)) {
                this.f383 = new CountDownLatchWrapper(this.f387, str, str2, str3, str4, 1);
                String str9 = VisaSCPConstants.LOG_TAG;
                final TimeLogger instance = TimeLogger.getInstance("Starting Get Card Enrollment Data");
                instance.reset("Starting Get Card Enrollment Data");
                SecureSharedPref instance2 = SecureSharedPref.getInstance(this.f387);
                String cardAlias = Utils.getCardAlias(this.f387, str5, str6, str7, str8);
                if (Utils.isOneClickInfoPayResponseValid(this.f387, cardAlias)) {
                    String str10 = VisaSCPConstants.LOG_TAG;
                    this.f383.countDown(cardAlias);
                    instance.addSplit("Time taken to provide one click pay object from cache");
                    instance.dumpToLog();
                } else if (Utils.isSafetyNetResponseValid(this.f387)) {
                    String str11 = VisaSCPConstants.LOG_TAG;
                    String data = instance2.getData(this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                    instance.addSplit("Time Taken to provide safety net response from cache");
                    this.f384.executeAsyncTask(new GetEnrollmentDataCustomAsync(str, str2, str3, str4, data, (VisaSCPImpl.GetOneClickInfoListener) null));
                    instance2.clearData(this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                    instance2.clearData(this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                } else {
                    final String str12 = str;
                    final String str13 = str2;
                    final String str14 = str3;
                    final String str15 = str4;
                    final AnonymousClass2 r0 = new VisaSCPImpl.SafetyNetListener() {
                        public final void onSuccess(String str) {
                            String str2 = VisaSCPConstants.LOG_TAG;
                            instance.addSplit("Time taken by GoogleSafetyNet API (Success)");
                            VisaSCPMain.this.f384.executeAsyncTask(new GetEnrollmentDataCustomAsync(str12, str13, str14, str15, str, (VisaSCPImpl.GetOneClickInfoListener) null));
                        }

                        public final void onError() {
                            String str = VisaSCPConstants.LOG_TAG;
                            if (VisaSCPMain.this.f383 != null) {
                                VisaSCPMain.this.f383.countDown(Utils.getCardAlias(VisaSCPMain.this.f387, str12, str13, str14, str15));
                            }
                            instance.addSplit("Time taken by GoogleSafetyNet API (Error)");
                            instance.dumpToLog();
                        }
                    };
                    this.f384.getExecutorService().submit(new Runnable() {
                        public final void run() {
                            GoogleSafetyNet.getInstance(VisaSCPMain.this.f387).attest(r14, NonceGenerator.generateNonce(), new SafetyNetResponseListener() {
                                public final void onSafetyNetResponseSuccess(final String str) {
                                    VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                        public final void run() {
                                            if (null != null) {
                                                SecureSharedPref instance = SecureSharedPref.getInstance(VisaSCPMain.this.f387);
                                                instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                                                instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                                                null.onSuccess(str);
                                            }
                                        }
                                    });
                                }

                                public final void onSafetyNetResponseFailure(Exception exc) {
                                    VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                        public final void run() {
                                            if (null != null) {
                                                null.onError();
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            }
        } else {
            CountDownLatchWrapper countDownLatchWrapper2 = this.f385;
            if (countDownLatchWrapper2 == null || !countDownLatchWrapper2.isSameCard(str5, str6, str7, str8)) {
                this.f385 = new CountDownLatchWrapper(this.f387, str, str2, str3, str4, 1);
                final TimeLogger instance3 = TimeLogger.getInstance("Starting Card Enrollment");
                instance3.reset("Starting Card Enrollment");
                String str16 = VisaSCPConstants.LOG_TAG;
                final SecureSharedPref instance4 = SecureSharedPref.getInstance(this.f387);
                final String cardAlias2 = Utils.getCardAlias(this.f387, str5, str6, str7, str8);
                if (Utils.isOneClickInfoEnrollResponseValid(this.f387, cardAlias2)) {
                    this.f385.countDown(cardAlias2);
                    String str17 = VisaSCPConstants.LOG_TAG;
                    instance3.addSplit("Time taken to fetching OneClickEnroll object from cache");
                    instance3.dumpToLog();
                    return;
                }
                if (Utils.isSafetyNetResponseValid(this.f387)) {
                    String str18 = VisaSCPConstants.LOG_TAG;
                    instance3.addSplit("Time taken for fetching GoogleSafetyNet from cache (Success)");
                    m676(cardAlias2, str8);
                } else {
                    final TimeLogger timeLogger = instance3;
                    final String str19 = cardAlias2;
                    final String str20 = str4;
                    final AnonymousClass14 r02 = new VisaSCPImpl.SafetyNetListener() {
                        public final void onSuccess(String str) {
                            String str2 = VisaSCPConstants.LOG_TAG;
                            timeLogger.addSplit("Time taken by GoogleSafetyNet (Success)");
                            instance4.saveDataSynchronously(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY, str);
                            instance4.saveDataSynchronously(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY, System.currentTimeMillis());
                            VisaSCPMain.this.m676(str19, str20);
                        }

                        public final void onError() {
                            String str = VisaSCPConstants.LOG_TAG;
                            if (VisaSCPMain.this.f385 != null) {
                                String str2 = VisaSCPConstants.LOG_TAG;
                                VisaSCPMain.this.f385.countDown(str19);
                            }
                            timeLogger.addSplit("Time taken by GoogleSafetyNet (Failure)");
                            timeLogger.dumpToLog();
                        }
                    };
                    this.f384.getExecutorService().submit(new Runnable() {
                        public final void run() {
                            GoogleSafetyNet.getInstance(VisaSCPMain.this.f387).attest(r14, NonceGenerator.generateNonce(), new SafetyNetResponseListener() {
                                public final void onSafetyNetResponseSuccess(final String str) {
                                    VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                        public final void run() {
                                            if (null != null) {
                                                SecureSharedPref instance = SecureSharedPref.getInstance(VisaSCPMain.this.f387);
                                                instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                                                instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                                                null.onSuccess(str);
                                            }
                                        }
                                    });
                                }

                                public final void onSafetyNetResponseFailure(Exception exc) {
                                    VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                        public final void run() {
                                            if (null != null) {
                                                null.onError();
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
                this.f384.executeAsyncTask(new KeyGeneratorCustomAsync(this.f387, cardAlias2, str8, new VisaSCPImpl.KeyGenerationListener() {
                    public final void onKeyGenerated() {
                        String str = VisaSCPConstants.LOG_TAG;
                        instance3.addSplit("Time taken for Generating Key Pair (Success)");
                        VisaSCPMain.this.m676(cardAlias2, str8);
                    }

                    public final void onKeyNotGenerated() {
                        String str = VisaSCPConstants.LOG_TAG;
                        if (VisaSCPMain.this.f385 != null) {
                            String str2 = VisaSCPConstants.LOG_TAG;
                            VisaSCPMain.this.f385.countDown(cardAlias2);
                        }
                        instance3.addSplit("Time taken for Generating Key Pair (Failure)");
                        instance3.dumpToLog();
                    }
                }));
            }
        }
    }

    public void getOneClickInfo(String str, String str2, String str3, String str4, VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener) {
        getOneClickInfoListener.onRequestStart();
        if (isEnrollmentSuccess(str, str2, str3, str4)) {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            final VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener2 = getOneClickInfoListener;
            new Thread() {
                public final void run() {
                    String str = VisaSCPConstants.LOG_TAG;
                    if (VisaSCPMain.this.f383 != null) {
                        try {
                            String str2 = VisaSCPConstants.LOG_TAG;
                            VisaSCPMain.this.f383.await();
                            String str3 = VisaSCPConstants.LOG_TAG;
                        } catch (InterruptedException unused) {
                            String str4 = VisaSCPConstants.LOG_TAG;
                            String str5 = VisaSCPConstants.EXCEPTION_MESSAGE;
                        }
                    }
                    CountDownLatchWrapper unused2 = VisaSCPMain.this.f383 = null;
                    String str6 = VisaSCPConstants.LOG_TAG;
                    VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                        public final void run() {
                            VisaSCPMain.m680(VisaSCPMain.this, str5, str6, str7, str8, getOneClickInfoListener2);
                        }
                    });
                }
            }.start();
            return;
        }
        final String str9 = str;
        final String str10 = str2;
        final String str11 = str3;
        final String str12 = str4;
        final VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener3 = getOneClickInfoListener;
        new Thread() {
            public final void run() {
                String str = VisaSCPConstants.LOG_TAG;
                if (VisaSCPMain.this.f385 != null) {
                    try {
                        String str2 = VisaSCPConstants.LOG_TAG;
                        VisaSCPMain.this.f385.await();
                        String str3 = VisaSCPConstants.LOG_TAG;
                    } catch (InterruptedException unused) {
                        String str4 = VisaSCPConstants.LOG_TAG;
                        String str5 = VisaSCPConstants.EXCEPTION_MESSAGE;
                    }
                }
                CountDownLatchWrapper unused2 = VisaSCPMain.this.f385 = null;
                String str6 = VisaSCPConstants.LOG_TAG;
                VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                    public final void run() {
                        VisaSCPMain.m677(VisaSCPMain.this, str9, str10, str11, str12, getOneClickInfoListener3);
                    }
                });
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009c, code lost:
        return;
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m676(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r9 = r16
            monitor-enter(r16)
            java.lang.String r0 = "Starting PreInitEnrollment"
            net.one97.paytm.payments.visascp.util.TimeLogger r0 = net.one97.paytm.payments.visascp.util.TimeLogger.getInstance(r0)     // Catch:{ all -> 0x009d }
            android.content.Context r1 = r9.f387     // Catch:{ all -> 0x009d }
            net.one97.paytm.payments.visascp.storage.SecureSharedPref r7 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r1)     // Catch:{ all -> 0x009d }
            android.content.Context r1 = r9.f387     // Catch:{ all -> 0x009d }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_PREF_KEY     // Catch:{ all -> 0x009d }
            java.lang.String r15 = r7.getData(r1, r2)     // Catch:{ all -> 0x009d }
            boolean r1 = net.one97.paytm.payments.visascp.keygen.KeyGenerator.isKeyPairAlreadyGenerated(r17)     // Catch:{ all -> 0x009d }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x009d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "Calling Auth Code API -- isKeyPairGenerated = "
            r2.<init>(r3)     // Catch:{ all -> 0x009d }
            r2.append(r1)     // Catch:{ all -> 0x009d }
            java.lang.String r3 = " isJwsEmpty = "
            r2.append(r3)     // Catch:{ all -> 0x009d }
            boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x009d }
            r2.append(r3)     // Catch:{ all -> 0x009d }
            if (r1 == 0) goto L_0x009b
            boolean r1 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x009d }
            if (r1 != 0) goto L_0x009b
            android.content.Context r1 = r9.f387     // Catch:{ all -> 0x009d }
            boolean r1 = net.one97.paytm.payments.visascp.util.Utils.isSafetyNetResponseValid(r1)     // Catch:{ all -> 0x009d }
            if (r1 != 0) goto L_0x0060
            android.content.Context r0 = r9.f387     // Catch:{ all -> 0x009d }
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_PREF_KEY     // Catch:{ all -> 0x009d }
            r7.clearData(r0, r1)     // Catch:{ all -> 0x009d }
            android.content.Context r0 = r9.f387     // Catch:{ all -> 0x009d }
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY     // Catch:{ all -> 0x009d }
            r7.clearData(r0, r1)     // Catch:{ all -> 0x009d }
            net.one97.paytm.payments.visascp.util.CountDownLatchWrapper r0 = r9.f385     // Catch:{ all -> 0x009d }
            if (r0 == 0) goto L_0x005e
            java.lang.String r0 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ all -> 0x009d }
            net.one97.paytm.payments.visascp.util.CountDownLatchWrapper r0 = r9.f385     // Catch:{ all -> 0x009d }
            r11 = r17
            r0.countDown(r11)     // Catch:{ all -> 0x009d }
        L_0x005e:
            monitor-exit(r16)
            return
        L_0x0060:
            r11 = r17
            android.content.Context r1 = r9.f387     // Catch:{ all -> 0x009d }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_PREF_KEY     // Catch:{ all -> 0x009d }
            r7.clearData(r1, r2)     // Catch:{ all -> 0x009d }
            android.content.Context r1 = r9.f387     // Catch:{ all -> 0x009d }
            java.lang.String r2 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY     // Catch:{ all -> 0x009d }
            r7.clearData(r1, r2)     // Catch:{ all -> 0x009d }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009d }
            android.content.Context r10 = r9.f387     // Catch:{ all -> 0x009d }
            net.one97.paytm.payments.visascp.VisaSCPMain$19 r14 = new net.one97.paytm.payments.visascp.VisaSCPMain$19     // Catch:{ all -> 0x009d }
            r1 = r14
            r2 = r16
            r3 = r12
            r5 = r0
            r6 = r17
            r8 = r18
            r1.<init>(r3, r5, r6, r7, r8)     // Catch:{ all -> 0x009d }
            net.one97.paytm.payments.visascp.VisaSCPMain$17 r8 = new net.one97.paytm.payments.visascp.VisaSCPMain$17     // Catch:{ all -> 0x009d }
            r1 = r8
            r2 = r16
            r3 = r12
            r5 = r18
            r6 = r17
            r7 = r0
            r1.<init>(r3, r5, r6, r7)     // Catch:{ all -> 0x009d }
            r11 = r17
            r12 = r18
            r13 = r14
            r14 = r8
            net.one97.paytm.payments.visascp.network.GetAuthCode.callAuthCodeAPI(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x009d }
        L_0x009b:
            monitor-exit(r16)
            return
        L_0x009d:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.VisaSCPMain.m676(java.lang.String, java.lang.String):void");
    }

    public void verifyDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7, VisaSCPImpl.DeviceVerificationListener deviceVerificationListener) {
        deviceVerificationListener.onRequestStart();
        TimeLogger instance = TimeLogger.getInstance("Starting VerifyDevice");
        instance.reset("Starting VerifyDevice");
        String cardAlias = Utils.getCardAlias(this.f387, str, str2, str3, str6);
        SecureSharedPref instance2 = SecureSharedPref.getInstance(this.f387);
        Context context = this.f387;
        StringBuilder sb = new StringBuilder();
        sb.append(cardAlias);
        sb.append(VisaSCPConstants.D_ID);
        String data = instance2.getData(context, sb.toString());
        final long currentTimeMillis = System.currentTimeMillis();
        final TimeLogger timeLogger = instance;
        final String str8 = data;
        final String str9 = str6;
        final String str10 = cardAlias;
        Context context2 = this.f387;
        final VisaSCPImpl.DeviceVerificationListener deviceVerificationListener2 = deviceVerificationListener;
        AnonymousClass3 r0 = new Response.Listener<BaseModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                int i2;
                BaseModel baseModel = (BaseModel) obj;
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                timeLogger.addSplit("Time taken by VerifyDevice API (Success)");
                String str = baseModel.getResponse().headers.containsKey(VisaSCPConstants.HEADER_KEY_ID) ? baseModel.getResponse().headers.get(VisaSCPConstants.HEADER_KEY_ID) : null;
                ApiStatusModel apiStatusModel = (ApiStatusModel) baseModel;
                if ("200".equals(apiStatusModel.getRespCode())) {
                    try {
                        i2 = Integer.valueOf(apiStatusModel.getRespCode()).intValue();
                    } catch (NumberFormatException unused) {
                        String str2 = VisaSCPConstants.LOG_TAG;
                        String str3 = VisaSCPConstants.EXCEPTION_MESSAGE;
                        i2 = 200;
                    }
                    HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(false, Utils.getVerifyDeviceUrl(str8), str9, new Timestamp(currentTimeMillis).toString(), String.valueOf(currentTimeMillis), i2, apiStatusModel.getRespDesc(), str, (String) null, str8, str10);
                    deviceVerificationListener2.onRequestEnd(true, str);
                    timeLogger.addSplit("Time taken to provide verify device API result to client (Success)");
                } else {
                    deviceVerificationListener2.onRequestEnd(false, str);
                    timeLogger.addSplit("Time taken to provide verify device API result to client (Failure)");
                    HawkEyeEvent instance = HawkEyeEvent.getInstance(VisaSCPMain.this.f387);
                    String verifyDeviceUrl = Utils.getVerifyDeviceUrl(str8);
                    String str4 = str9;
                    String obj2 = new Timestamp(currentTimeMillis).toString();
                    String valueOf = String.valueOf(currentTimeMillis);
                    StringBuilder sb = new StringBuilder("visa-status-code=");
                    sb.append(apiStatusModel.getRespCode());
                    instance.logApiEvent(true, verifyDeviceUrl, str4, obj2, valueOf, 200, "Failure", str, sb.toString(), str8, str10);
                }
                timeLogger.dumpToLog();
            }
        };
        final String str11 = str6;
        final String str12 = data;
        VerifyDevice.callDeviceVerificationApi(context2, cardAlias, str6, str4, str5, str7, r0, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                VolleyError volleyError2 = volleyError;
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                timeLogger.addSplit("Time taken by VerifyDevice API (Failure)");
                timeLogger.dumpToLog();
                if (volleyError.getMessage() != null && volleyError.getMessage().contains(VisaSCPConstants.VISA_SSL_HANDSHAKE_EXCEPTION_MESSAGE)) {
                    GetVisaCertificate.executeGetCertificateApi(VisaSCPMain.this.f387, true, str11);
                }
                String str = null;
                if (!(volleyError2.networkResponse == null || volleyError2.networkResponse.headers == null || !volleyError2.networkResponse.headers.containsKey(VisaSCPConstants.HEADER_KEY_ID))) {
                    str = volleyError2.networkResponse.headers.get(VisaSCPConstants.HEADER_KEY_ID);
                }
                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, Utils.getVerifyDeviceUrl(str12), str11, new Timestamp(currentTimeMillis).toString(), String.valueOf(currentTimeMillis), volleyError2.networkResponse != null ? volleyError2.networkResponse.statusCode : 0, volleyError.getMessage(), str, (String) null, str12, str10);
                deviceVerificationListener2.onRequestError("E002", "Device Verification Failed", str);
            }
        });
    }

    public String setEnrollmentData(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        long currentTimeMillis = System.currentTimeMillis();
        String cardAlias = Utils.getCardAlias(this.f387, str, str2, str3, str4);
        String str11 = null;
        try {
            boolean isEnrollmentSuccess = isEnrollmentSuccess(str, str2, str3, str4);
            JSONObject jSONObject = new JSONObject(str5);
            if (jSONObject.has(VisaSCPConstants.KEY_OC_TOKEN)) {
                String string = jSONObject.getString(VisaSCPConstants.KEY_OC_TOKEN);
                if (TextUtils.isEmpty(string)) {
                    clearEnrollment(str, str2, str3, str4);
                    if (isEnrollmentSuccess) {
                        str9 = TokenStatus.REMOVED;
                    } else {
                        str10 = null;
                    }
                } else {
                    Decrypter decrypter = new Decrypter();
                    String parseIdTokenJws = decrypter.parseIdTokenJws(this.f387, decrypter.parseTokenJwe(string, cardAlias), cardAlias);
                    String str12 = VisaSCPConstants.LOG_TAG;
                    "Token received = ".concat(String.valueOf(parseIdTokenJws));
                    str10 = TokenStatus.ENROLLED;
                    if (isEnrollmentSuccess) {
                        str10 = TokenStatus.REPLACED;
                    }
                    try {
                        if (!TextUtils.isEmpty(parseIdTokenJws)) {
                            SecureSharedPref instance = SecureSharedPref.getInstance(this.f387);
                            Context context = this.f387;
                            StringBuilder sb = new StringBuilder();
                            sb.append(cardAlias);
                            sb.append(VisaSCPConstants.KEY_TOKEN);
                            instance.saveData(context, sb.toString(), string);
                        }
                        int length = parseIdTokenJws.length();
                        if (length > 10) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(parseIdTokenJws.substring(0, 10));
                            sb2.append(AppConstants.DOTS);
                            sb2.append(parseIdTokenJws.substring(length - 10));
                            str11 = sb2.toString();
                        }
                    } catch (JSONException unused) {
                        str6 = str10;
                        str7 = null;
                        String str13 = VisaSCPConstants.LOG_TAG;
                        String str14 = VisaSCPConstants.EXCEPTION_MESSAGE;
                        HawkEyeEvent.getInstance(this.f387).logLocalEvent(true, "set-enrollment-data", str4, new Timestamp(currentTimeMillis).toString(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), 400, str6, cardAlias, str7);
                        return str6;
                    }
                }
                str6 = str10;
                str8 = str11;
                HawkEyeEvent.getInstance(this.f387).logLocalEvent(false, "set-enrollment-data", str4, new Timestamp(currentTimeMillis).toString(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), 200, str6, cardAlias, str8);
                return str6;
            } else if (isEnrollmentSuccess) {
                str9 = TokenStatus.RETAINED;
            } else {
                str6 = null;
                str8 = null;
                HawkEyeEvent.getInstance(this.f387).logLocalEvent(false, "set-enrollment-data", str4, new Timestamp(currentTimeMillis).toString(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), 200, str6, cardAlias, str8);
                return str6;
            }
            str6 = str9;
            str8 = str11;
            try {
                HawkEyeEvent.getInstance(this.f387).logLocalEvent(false, "set-enrollment-data", str4, new Timestamp(currentTimeMillis).toString(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), 200, str6, cardAlias, str8);
            } catch (JSONException unused2) {
                str7 = str8;
            }
        } catch (JSONException unused3) {
            str7 = null;
            str6 = null;
            String str132 = VisaSCPConstants.LOG_TAG;
            String str142 = VisaSCPConstants.EXCEPTION_MESSAGE;
            HawkEyeEvent.getInstance(this.f387).logLocalEvent(true, "set-enrollment-data", str4, new Timestamp(currentTimeMillis).toString(), String.valueOf(System.currentTimeMillis() - currentTimeMillis), 400, str6, cardAlias, str7);
            return str6;
        }
        return str6;
    }

    public void isEnrolled(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, VisaSCPImpl.IsEnrolledListener isEnrolledListener) {
        final String str9 = str4;
        VisaSCPImpl.IsEnrolledListener isEnrolledListener2 = isEnrolledListener;
        isEnrolledListener.onRequestStart();
        TimeLogger instance = TimeLogger.getInstance("Starting isEnrolled");
        instance.reset("Starting isEnrolled");
        if (!Utils.isSafetyNetResponseValid(this.f387)) {
            this.f384.getExecutorService().submit(new Runnable((VisaSCPImpl.SafetyNetListener) null) {
                public final void run() {
                    GoogleSafetyNet.getInstance(VisaSCPMain.this.f387).attest(str9, NonceGenerator.generateNonce(), new SafetyNetResponseListener() {
                        public final void onSafetyNetResponseSuccess(final String str) {
                            VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                public final void run() {
                                    if (null != null) {
                                        SecureSharedPref instance = SecureSharedPref.getInstance(VisaSCPMain.this.f387);
                                        instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                                        instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                                        null.onSuccess(str);
                                    }
                                }
                            });
                        }

                        public final void onSafetyNetResponseFailure(Exception exc) {
                            VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                public final void run() {
                                    if (null != null) {
                                        null.onError();
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }
        if (GetVisaCertificate.isCertificateApiCallNeeded(this.f387)) {
            GetVisaCertificate.executeGetCertificateApi(this.f387, false, str9);
        }
        final SecureSharedPref instance2 = SecureSharedPref.getInstance(this.f387);
        String cardAlias = Utils.getCardAlias(this.f387, str, str2, str3, str9);
        final boolean isEnrollmentSuccess = isEnrollmentSuccess(str, str2, str3, str4);
        if (Utils.isEnrollmentStatusResponseValid(this.f387, cardAlias)) {
            Context context = this.f387;
            StringBuilder sb = new StringBuilder();
            sb.append(cardAlias);
            sb.append(VisaSCPConstants.ENROLL_STATUS_ELIGIBILITY_TIMESTAMP);
            String data = instance2.getData(context, sb.toString());
            Context context2 = this.f387;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cardAlias);
            sb2.append(VisaSCPConstants.ENROLL_STATUS);
            boolean equalsIgnoreCase = "Eligible".equalsIgnoreCase(instance2.getData(context2, sb2.toString()));
            isEnrolledListener2.onRequestEnd(isEnrollmentSuccess, equalsIgnoreCase, data);
            instance.addSplit("Time taken to provide isEnroll response from cache");
            instance.dumpToLog();
            HawkEyeEvent instance3 = HawkEyeEvent.getInstance(this.f387);
            String checkEnrollmentStatusUrl = CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str6, str7, str8);
            String obj = new Timestamp(System.currentTimeMillis()).toString();
            StringBuilder sb3 = new StringBuilder("isEligible = ");
            sb3.append(equalsIgnoreCase);
            sb3.append(": isEnrolled = ");
            sb3.append(isEnrollmentSuccess);
            instance3.logLocalEvent(false, checkEnrollmentStatusUrl, str4, obj, "0", 200, "From cache", cardAlias, sb3.toString());
            return;
        }
        isEnrolledListener2.onRequestEnd(isEnrollmentSuccess, true, (String) null);
        String validateQueryParams = Utils.validateQueryParams(str6, str7, str8);
        if (!TextUtils.isEmpty(validateQueryParams)) {
            String str10 = VisaSCPConstants.LOG_TAG;
            isEnrolledListener2.onRequestError("1001", validateQueryParams);
            instance.addSplit("isEnrolled error = ".concat(String.valueOf(validateQueryParams)));
            instance.dumpToLog();
            HawkEyeEvent.getInstance(this.f387).logLocalEvent(true, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str6, str7, str8), str4, new Timestamp(System.currentTimeMillis()).toString(), "0", 450, validateQueryParams, cardAlias, "tokenType = ".concat(String.valueOf(str6)));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        hashSet.add(cardAlias);
        final TimeLogger timeLogger = instance;
        final long j = currentTimeMillis;
        final VisaSCPImpl.IsEnrolledListener isEnrolledListener3 = isEnrolledListener;
        final String str11 = str6;
        Context context3 = this.f387;
        final String str12 = str7;
        HashSet hashSet2 = hashSet;
        final String str13 = str8;
        String str14 = cardAlias;
        final String str15 = str4;
        TimeLogger timeLogger2 = instance;
        final String str16 = str14;
        AnonymousClass7 r0 = new Response.Listener<BaseModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                String str;
                boolean z;
                BaseModel baseModel = (BaseModel) obj;
                timeLogger.addSplit("Time take to get check status response (success)");
                long currentTimeMillis = System.currentTimeMillis() - j;
                EnrollmentStatusModel enrollmentStatusModel = (EnrollmentStatusModel) baseModel;
                String str2 = "Something went wrong";
                String str3 = "9999";
                if (enrollmentStatusModel.getBody() == null) {
                    isEnrolledListener3.onRequestError(str3, str2);
                } else if (enrollmentStatusModel.getBody().getResultInfo() == null || !"0000".equalsIgnoreCase(enrollmentStatusModel.getBody().getResultInfo().getResultCode())) {
                    try {
                        str3 = enrollmentStatusModel.getBody().getResultInfo().getResultCode();
                        str2 = enrollmentStatusModel.getBody().getResultInfo().getResultMsg();
                    } catch (Exception unused) {
                        String str4 = VisaSCPConstants.LOG_TAG;
                        String str5 = VisaSCPConstants.EXCEPTION_MESSAGE;
                    }
                    isEnrolledListener3.onRequestError(str3, str2);
                } else {
                    ArrayList<AccountStatusDataModel> accountStatusDataList = enrollmentStatusModel.getBody().getAccountStatusDataList();
                    if (accountStatusDataList == null || accountStatusDataList.size() <= 0) {
                        isEnrolledListener3.onRequestEnd(false, false, (String) null);
                    } else {
                        String status = accountStatusDataList.get(0).getStatus();
                        SecureSharedPref secureSharedPref = instance2;
                        Context r7 = VisaSCPMain.this.f387;
                        StringBuilder sb = new StringBuilder();
                        sb.append(accountStatusDataList.get(0).getCardAlias());
                        sb.append(VisaSCPConstants.ENROLL_STATUS);
                        secureSharedPref.saveData(r7, sb.toString(), status);
                        if (!TextUtils.isEmpty(accountStatusDataList.get(0).getEligibleTimeStamp())) {
                            SecureSharedPref secureSharedPref2 = instance2;
                            Context r72 = VisaSCPMain.this.f387;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(accountStatusDataList.get(0).getCardAlias());
                            sb2.append(VisaSCPConstants.ENROLL_STATUS_ELIGIBILITY_TIMESTAMP);
                            secureSharedPref2.saveData(r72, sb2.toString(), accountStatusDataList.get(0).getEligibleTimeStamp());
                        }
                        SecureSharedPref secureSharedPref3 = instance2;
                        Context r73 = VisaSCPMain.this.f387;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(accountStatusDataList.get(0).getCardAlias());
                        sb3.append(VisaSCPConstants.ENROLL_STATUS_API_TIMESTAMP);
                        secureSharedPref3.saveData(r73, sb3.toString(), System.currentTimeMillis());
                        if ("Eligible".equalsIgnoreCase(status)) {
                            isEnrolledListener3.onRequestEnd(isEnrollmentSuccess, true, accountStatusDataList.get(0).getEligibleTimeStamp());
                        } else {
                            isEnrolledListener3.onRequestEnd(false, false, accountStatusDataList.get(0).getEligibleTimeStamp());
                        }
                        str = status;
                        z = false;
                        timeLogger.dumpToLog();
                        HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(z, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str11, str12, str13), str15, new Timestamp(j).toString(), String.valueOf(currentTimeMillis), baseModel.getResponse().statusCode, str, "check-is-eligible", new f().a((Object) enrollmentStatusModel.getBody(), (Type) BodyModel.class), (String) null, str16);
                    }
                }
                str = null;
                z = true;
                timeLogger.dumpToLog();
                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(z, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str11, str12, str13), str15, new Timestamp(j).toString(), String.valueOf(currentTimeMillis), baseModel.getResponse().statusCode, str, "check-is-eligible", new f().a((Object) enrollmentStatusModel.getBody(), (Type) BodyModel.class), (String) null, str16);
            }
        };
        final TimeLogger timeLogger3 = timeLogger2;
        final VisaSCPImpl.IsEnrolledListener isEnrolledListener4 = isEnrolledListener;
        final String str17 = str6;
        final String str18 = str7;
        final String str19 = str8;
        final String str20 = str4;
        final long j2 = currentTimeMillis;
        final String str21 = str14;
        CheckEnrollmentStatus.checkAllEnrolledCards(context3, str5, str6, str4, hashSet2, str18, str19, r0, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                timeLogger3.addSplit("Time take to get check status response (failure)");
                timeLogger3.dumpToLog();
                int i2 = volleyError.networkResponse != null ? volleyError.networkResponse.statusCode : 0;
                isEnrolledListener4.onRequestError(String.valueOf(i2), volleyError.getMessage());
                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str17, str18, str19), str20, new Timestamp(j2).toString(), String.valueOf(System.currentTimeMillis() - j2), i2, volleyError.getMessage(), "check-is-eligible", (String) null, (String) null, str21);
            }
        });
    }

    public boolean isEnrollmentSuccess(String str, String str2, String str3, String str4) {
        String cardAlias = Utils.getCardAlias(this.f387, str, str2, str3, str4);
        try {
            SecureSharedPref instance = SecureSharedPref.getInstance(this.f387);
            Context context = this.f387;
            StringBuilder sb = new StringBuilder();
            sb.append(cardAlias);
            sb.append(VisaSCPConstants.KEY_TOKEN);
            if (!TextUtils.isEmpty(instance.getData(context, sb.toString()))) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return false;
        }
    }

    public void checkAllEnrolledCards(String str, String str2, String str3, String str4, String str5) {
        String str6 = str2;
        String str7 = str4;
        String str8 = str5;
        TimeLogger instance = TimeLogger.getInstance("Starting checkAllEnrolledCards");
        instance.reset("Starting checkAllEnrolledCards");
        String validateQueryParams = Utils.validateQueryParams(str6, str7, str8);
        if (!TextUtils.isEmpty(validateQueryParams)) {
            String str9 = VisaSCPConstants.LOG_TAG;
            instance.addSplit("checkAllEnrolledCards error = ".concat(String.valueOf(validateQueryParams)));
            instance.dumpToLog();
            HawkEyeEvent.getInstance(this.f387).logLocalEvent(true, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str6, str7, str8), str3, new Timestamp(System.currentTimeMillis()).toString(), "0", 450, validateQueryParams, (String) null, "tokenType = ".concat(String.valueOf(str2)));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Set<String> keySet = SecureSharedPref.getInstance(this.f387).getAllPrefs(this.f387).keySet();
        HashSet hashSet = new HashSet();
        for (String next : keySet) {
            if (next.endsWith(VisaSCPConstants.KEY_TOKEN)) {
                String replace = next.replace(VisaSCPConstants.KEY_TOKEN, "");
                if (!Utils.isEnrollmentStatusResponseValid(this.f387, replace)) {
                    hashSet.add(replace);
                }
            }
        }
        if (hashSet.size() != 0) {
            final long j = currentTimeMillis;
            final TimeLogger timeLogger = instance;
            final String str10 = str2;
            final String str11 = str4;
            Context context = this.f387;
            final String str12 = str5;
            HashSet hashSet2 = hashSet;
            final String str13 = str3;
            AnonymousClass6 r0 = new Response.Listener<BaseModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    BaseModel baseModel = (BaseModel) obj;
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    timeLogger.addSplit("Time taken to get check enrollment status response {success");
                    EnrollmentStatusModel enrollmentStatusModel = (EnrollmentStatusModel) baseModel;
                    if (!(enrollmentStatusModel.getBody() == null || enrollmentStatusModel.getBody().getResultInfo() == null || !"0000".equalsIgnoreCase(enrollmentStatusModel.getBody().getResultInfo().getResultCode()))) {
                        SecureSharedPref instance = SecureSharedPref.getInstance(VisaSCPMain.this.f387);
                        Iterator<AccountStatusDataModel> it2 = enrollmentStatusModel.getBody().getAccountStatusDataList().iterator();
                        while (it2.hasNext()) {
                            AccountStatusDataModel next = it2.next();
                            Context r8 = VisaSCPMain.this.f387;
                            StringBuilder sb = new StringBuilder();
                            sb.append(next.getCardAlias());
                            sb.append(VisaSCPConstants.ENROLL_STATUS);
                            instance.saveData(r8, sb.toString(), next.getStatus());
                            if (!TextUtils.isEmpty(next.getEligibleTimeStamp())) {
                                Context r82 = VisaSCPMain.this.f387;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(next.getCardAlias());
                                sb2.append(VisaSCPConstants.ENROLL_STATUS_ELIGIBILITY_TIMESTAMP);
                                instance.saveData(r82, sb2.toString(), next.getEligibleTimeStamp());
                            }
                            Context r83 = VisaSCPMain.this.f387;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(next.getCardAlias());
                            sb3.append(VisaSCPConstants.ENROLL_STATUS_API_TIMESTAMP);
                            instance.saveData(r83, sb3.toString(), System.currentTimeMillis());
                        }
                    }
                    timeLogger.dumpToLog();
                    HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(false, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str10, str11, str12), str13, new Timestamp(j).toString(), String.valueOf(currentTimeMillis), baseModel.getResponse().statusCode, "API Success", "check-all-eligible", new f().a((Object) enrollmentStatusModel.getBody(), (Type) BodyModel.class), (String) null, (String) null);
                }
            };
            final TimeLogger timeLogger2 = instance;
            final long j2 = currentTimeMillis;
            CheckEnrollmentStatus.checkAllEnrolledCards(context, str, str2, str3, hashSet2, str4, str5, r0, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    VolleyError volleyError2 = volleyError;
                    timeLogger2.addSplit("Time taken to get check enrollment status response (failure)");
                    timeLogger2.dumpToLog();
                    HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, CheckEnrollmentStatus.getCheckEnrollmentStatusUrl(str10, str11, str12), str13, new Timestamp(j2).toString(), String.valueOf(System.currentTimeMillis() - j2), volleyError2.networkResponse != null ? volleyError2.networkResponse.statusCode : 0, volleyError.getMessage(), "check-all-eligible", (String) null, (String) null, (String) null);
                }
            });
        }
    }

    public boolean clearEnrollment(String str, String str2, String str3, String str4) {
        String cardAlias = Utils.getCardAlias(this.f387, str, str2, str3, str4);
        SecureSharedPref instance = SecureSharedPref.getInstance(this.f387);
        Context context = this.f387;
        StringBuilder sb = new StringBuilder();
        sb.append(cardAlias);
        sb.append(VisaSCPConstants.VPUB);
        instance.clearData(context, sb.toString());
        Context context2 = this.f387;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cardAlias);
        sb2.append(VisaSCPConstants.D_ID);
        instance.clearData(context2, sb2.toString());
        Context context3 = this.f387;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cardAlias);
        sb3.append(VisaSCPConstants.KEY_TOKEN);
        instance.clearData(context3, sb3.toString());
        Context context4 = this.f387;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(cardAlias);
        sb4.append("_");
        sb4.append(VisaSCPConstants.ONE_CLICK_INFO_ENROLL_JSON_PREF_KEY);
        instance.clearData(context4, sb4.toString());
        Context context5 = this.f387;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cardAlias);
        sb5.append("_");
        sb5.append(VisaSCPConstants.ONE_CLICK_INFO_ENROLL_TIME_PREF_KEY);
        instance.clearData(context5, sb5.toString());
        Context context6 = this.f387;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(cardAlias);
        sb6.append("_");
        sb6.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_JSON_PREF_KEY);
        instance.clearData(context6, sb6.toString());
        Context context7 = this.f387;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(cardAlias);
        sb7.append("_");
        sb7.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_TIME_PREF_KEY);
        instance.clearData(context7, sb7.toString());
        Context context8 = this.f387;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(cardAlias);
        sb8.append(VisaSCPConstants.ENROLL_STATUS);
        instance.clearData(context8, sb8.toString());
        Context context9 = this.f387;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(cardAlias);
        sb9.append(VisaSCPConstants.ENROLL_STATUS_ELIGIBILITY_TIMESTAMP);
        instance.clearData(context9, sb9.toString());
        Context context10 = this.f387;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(cardAlias);
        sb10.append(VisaSCPConstants.ENROLL_STATUS_API_TIMESTAMP);
        instance.clearData(context10, sb10.toString());
        instance.clearData(this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
        instance.clearData(this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
        try {
            KeyStore instance2 = KeyStore.getInstance(VisaSCPConstants.ANDROID_KEY_STORE);
            instance2.load((KeyStore.LoadStoreParameter) null);
            instance2.deleteEntry(cardAlias);
            return true;
        } catch (KeyStoreException unused) {
            String str5 = VisaSCPConstants.LOG_TAG;
            String str6 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return false;
        } catch (CertificateException unused2) {
            String str7 = VisaSCPConstants.LOG_TAG;
            String str8 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return false;
        } catch (NoSuchAlgorithmException unused3) {
            String str9 = VisaSCPConstants.LOG_TAG;
            String str10 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return false;
        } catch (IOException unused4) {
            String str11 = VisaSCPConstants.LOG_TAG;
            String str12 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return false;
        }
    }

    public void deEnrollCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, VisaSCPImpl.DeEnrollCardListener deEnrollCardListener) {
        String str9 = str2;
        String str10 = str7;
        String str11 = str8;
        deEnrollCardListener.onRequestStart();
        TimeLogger instance = TimeLogger.getInstance("Starting deEnrollCard");
        instance.reset("Starting deEnrollCard");
        String validateQueryParams = Utils.validateQueryParams(str9, str10, str11);
        if (!TextUtils.isEmpty(validateQueryParams)) {
            String str12 = VisaSCPConstants.LOG_TAG;
            deEnrollCardListener.onRequestError("0001", validateQueryParams);
            instance.addSplit("deEnrollCard error = ".concat(String.valueOf(validateQueryParams)));
            instance.dumpToLog();
            HawkEyeEvent.getInstance(this.f387).logLocalEvent(true, DeEnrollCard.getDeEnrollmentUrl(str9, str10, str11), str6, new Timestamp(System.currentTimeMillis()).toString(), "0", 450, validateQueryParams, (String) null, "tokenType = ".concat(String.valueOf(str2)));
            return;
        }
        VisaSCPImpl.DeEnrollCardListener deEnrollCardListener2 = deEnrollCardListener;
        long currentTimeMillis = System.currentTimeMillis();
        final String str13 = str4;
        final String str14 = str5;
        String cardAlias = Utils.getCardAlias(this.f387, str3, str13, str14, str6);
        final TimeLogger timeLogger = instance;
        final long j = currentTimeMillis;
        Context context = this.f387;
        final VisaSCPImpl.DeEnrollCardListener deEnrollCardListener3 = deEnrollCardListener;
        final String str15 = str3;
        final String str16 = str6;
        final String str17 = str2;
        TimeLogger timeLogger2 = instance;
        final String str18 = str7;
        final String str19 = str8;
        final String str20 = cardAlias;
        AnonymousClass11 r0 = new Response.Listener<BaseModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                BaseModel baseModel = (BaseModel) obj;
                timeLogger.addSplit("Time taken to get deEnroll API response (success)");
                long currentTimeMillis = System.currentTimeMillis() - j;
                DeEnrollResponseModel deEnrollResponseModel = (DeEnrollResponseModel) baseModel;
                if (!(deEnrollResponseModel.getBody() == null || deEnrollResponseModel.getBody().getResultInfo() == null)) {
                    String resultCode = deEnrollResponseModel.getBody().getResultInfo().getResultCode();
                    if ("0000".equalsIgnoreCase(resultCode)) {
                        deEnrollCardListener3.onRequestEnd(true, deEnrollResponseModel.getBody().getResultInfo().getResultMsg());
                        VisaSCPMain.this.clearEnrollment(str15, str13, str14, str16);
                    } else {
                        deEnrollCardListener3.onRequestError(resultCode, deEnrollResponseModel.getBody().getResultInfo().getResultMsg());
                    }
                }
                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(false, DeEnrollCard.getDeEnrollmentUrl(str17, str18, str19), str16, new Timestamp(j).toString(), String.valueOf(currentTimeMillis), baseModel.getResponse().statusCode, deEnrollResponseModel.getBody().getResultInfo().getResultMsg(), (String) null, (String) null, (String) null, str20);
                timeLogger.dumpToLog();
            }
        };
        final TimeLogger timeLogger3 = timeLogger2;
        final String str21 = str2;
        final String str22 = str7;
        final String str23 = str8;
        final String str24 = cardAlias;
        DeEnrollCard.deEnrollCard(context, str, str2, str3, cardAlias, str6, str7, str8, r0, new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                VolleyError volleyError2 = volleyError;
                timeLogger3.addSplit("Time taken to get deEnroll API response (failure)");
                long currentTimeMillis = System.currentTimeMillis() - j;
                int i2 = volleyError2.networkResponse != null ? volleyError2.networkResponse.statusCode : 0;
                deEnrollCardListener3.onRequestError(String.valueOf(i2), volleyError.getMessage());
                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, DeEnrollCard.getDeEnrollmentUrl(str21, str22, str23), str16, new Timestamp(j).toString(), String.valueOf(currentTimeMillis), i2, volleyError.getMessage(), (String) null, (String) null, (String) null, str24);
                timeLogger3.dumpToLog();
            }
        });
    }

    public String getDeEnrollmentData(String str, String str2, String str3, String str4, String str5) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(VisaSCPConstants.KEY_CUST_ID, str4);
            jSONObject2.put(VisaSCPConstants.KEY_CARD_ALIAS, Utils.getCardAlias(this.f387, str, str2, str3, str4));
            jSONObject2.put(VisaSCPConstants.KEY_APP_ID, Utils.getMerchantAppId(this.f387));
            jSONObject2.put(VisaSCPConstants.KEY_CARD_TYPE, str5);
            jSONObject.put(VisaSCPConstants.KEY_DENROLL_CONTENT, jSONObject2);
            return jSONObject.toString().replace("\\", "");
        } catch (JSONException unused) {
            String str6 = VisaSCPConstants.LOG_TAG;
            String str7 = VisaSCPConstants.EXCEPTION_MESSAGE;
            return null;
        }
    }

    public static class VisaSCPBuilder {

        /* renamed from: ॱ  reason: contains not printable characters */
        private Context f549;

        VisaSCPBuilder() {
        }

        public VisaSCPBuilder setApplicationContext(Context context) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
            } catch (Exception unused) {
                String str = VisaSCPConstants.LOG_TAG;
                String str2 = VisaSCPConstants.EXCEPTION_MESSAGE;
            }
            this.f549 = context;
            return this;
        }

        public Context getApplicationContext() {
            return this.f549;
        }

        public VisaSCP build() {
            VisaSCPMain visaSCPMain = new VisaSCPMain(this, (byte) 0);
            validate();
            return visaSCPMain;
        }

        public void validate() {
            if (Build.VERSION.SDK_INT < 19) {
                throw new UnsupportedOperationException("Visa Single Click is not supported below API Level 19");
            } else if (getApplicationContext() == null) {
                throw new IllegalArgumentException("Application Context cannot be null");
            }
        }
    }

    public class GetEnrollmentDataCustomAsync implements CustomCallable<String> {

        /* renamed from: ʽ  reason: contains not printable characters */
        private String f543;

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f544;

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f545;

        /* renamed from: ˎ  reason: contains not printable characters */
        private VisaSCPImpl.GetOneClickInfoListener f546;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f547;

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f548;

        public void onPreExecuteData() {
        }

        public GetEnrollmentDataCustomAsync(String str, String str2, String str3, String str4, String str5, VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener) {
            this.f546 = getOneClickInfoListener;
            this.f547 = str;
            this.f548 = str2;
            this.f545 = str3;
            this.f544 = str4;
            this.f543 = str5;
        }

        public void onPostExecuteData(String str) {
            TimeLogger instance = TimeLogger.getInstance("Starting Get Card Enrollment Data");
            if (str == null) {
                if (this.f546 != null) {
                    String str2 = VisaSCPConstants.LOG_TAG;
                    this.f546.onRequestError("E003", "Cannot fetch Enrollment Data", (String) null);
                    instance.addSplit("Time taken to provide enrollment data (Failure)");
                }
            } else if (this.f546 != null) {
                String str3 = VisaSCPConstants.LOG_TAG;
                this.f546.onRequestEnd(str);
                instance.addSplit("Time taken to provide enrollment data (Success)");
            }
            instance.dumpToLog();
        }

        public String call() {
            return m685(this.f547, this.f548, this.f545, this.f544, this.f543);
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x028c  */
        /* renamed from: ˎ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String m685(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31) {
            /*
                r26 = this;
                r0 = r26
                r1 = r27
                r2 = r28
                r3 = r29
                r14 = r30
                java.lang.String r4 = "_"
                java.lang.String r15 = "Starting Get Card Enrollment Data"
                java.lang.String r13 = ""
                java.lang.String r12 = "\\"
                java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
                long r10 = java.lang.System.currentTimeMillis()
                org.json.JSONObject r5 = new org.json.JSONObject
                r5.<init>()
                net.one97.paytm.payments.visascp.VisaSCPMain r6 = net.one97.paytm.payments.visascp.VisaSCPMain.this
                android.content.Context r6 = r6.f387
                java.lang.String r9 = net.one97.paytm.payments.visascp.util.Utils.getCardAlias(r6, r1, r2, r3, r14)
                r16 = 0
                boolean r6 = android.text.TextUtils.isEmpty(r30)     // Catch:{ JSONException -> 0x0273 }
                if (r6 != 0) goto L_0x0265
                net.one97.paytm.payments.visascp.VisaSCPMain r6 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0273 }
                android.content.Context r6 = r6.f387     // Catch:{ JSONException -> 0x0273 }
                net.one97.paytm.payments.visascp.storage.SecureSharedPref r6 = net.one97.paytm.payments.visascp.storage.SecureSharedPref.getInstance(r6)     // Catch:{ JSONException -> 0x0273 }
                net.one97.paytm.payments.visascp.VisaSCPMain r7 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0273 }
                android.content.Context r7 = r7.f387     // Catch:{ JSONException -> 0x0273 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0273 }
                r8.<init>()     // Catch:{ JSONException -> 0x0273 }
                r8.append(r9)     // Catch:{ JSONException -> 0x0273 }
                r17 = r10
                java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_TOKEN     // Catch:{ JSONException -> 0x0260 }
                r8.append(r10)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r7 = r6.getData(r7, r8)     // Catch:{ JSONException -> 0x0260 }
                boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r10 = "id token is empty"
                if (r8 != 0) goto L_0x0256
                net.one97.paytm.payments.visascp.security.Decrypter r8 = new net.one97.paytm.payments.visascp.security.Decrypter     // Catch:{ JSONException -> 0x0260 }
                r8.<init>()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r7 = r8.parseTokenJwe(r7, r9)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.VisaSCPMain r11 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r11 = r11.f387     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r7 = r8.parseIdTokenJws(r11, r7, r9)     // Catch:{ JSONException -> 0x0260 }
                boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0260 }
                if (r8 != 0) goto L_0x024c
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = "Token used = "
                java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ JSONException -> 0x0260 }
                r8.concat(r10)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ID_TOKEN     // Catch:{ JSONException -> 0x0260 }
                r5.put(r8, r7)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_TIME_STAMP     // Catch:{ JSONException -> 0x0260 }
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r10 = java.lang.Long.toString(r10)     // Catch:{ JSONException -> 0x0260 }
                r5.put(r8, r10)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_SAFETY_DATA     // Catch:{ JSONException -> 0x0260 }
                r10 = r31
                r5.put(r8, r10)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.security.Encrypter r8 = new net.one97.paytm.payments.visascp.security.Encrypter     // Catch:{ JSONException -> 0x0260 }
                r8.<init>()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ JSONException -> 0x0260 }
                byte[] r5 = r8.signData(r9, r5)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.VisaSCPMain r10 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r10 = r10.f387     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = r8.encryptWithVisaPublicKey(r10, r9, r5)     // Catch:{ JSONException -> 0x0260 }
                boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0260 }
                if (r8 != 0) goto L_0x0240
                net.one97.paytm.payments.visascp.VisaSCPMain r8 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r8 = r8.f387     // Catch:{ JSONException -> 0x0260 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0260 }
                r10.<init>()     // Catch:{ JSONException -> 0x0260 }
                r10.append(r9)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r11 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.D_ID     // Catch:{ JSONException -> 0x0260 }
                r10.append(r11)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = r6.getData(r8, r10)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.security.Encrypter r10 = new net.one97.paytm.payments.visascp.security.Encrypter     // Catch:{ JSONException -> 0x0260 }
                r10.<init>()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = r10.getDeviceIdJws(r9, r8)     // Catch:{ JSONException -> 0x0260 }
                boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0260 }
                if (r10 != 0) goto L_0x0234
                org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0260 }
                r11.<init>()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_REQ_TYPE     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.TYPE_PAY     // Catch:{ JSONException -> 0x0260 }
                r11.put(r10, r1)     // Catch:{ JSONException -> 0x0260 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0260 }
                r1.<init>()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r10 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_SIGN_DEV_ID     // Catch:{ JSONException -> 0x0260 }
                r1.put(r10, r8)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_CARD_ALIAS     // Catch:{ JSONException -> 0x0260 }
                r1.put(r8, r9)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_APP_ID     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.VisaSCPMain r10 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r10 = r10.f387     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r10 = net.one97.paytm.payments.visascp.util.Utils.getMerchantAppId(r10)     // Catch:{ JSONException -> 0x0260 }
                r1.put(r8, r10)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_CUSTOMER_ID     // Catch:{ JSONException -> 0x0260 }
                r1.put(r8, r14)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r8 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_OC_TOKEN     // Catch:{ JSONException -> 0x0260 }
                r1.put(r8, r5)     // Catch:{ JSONException -> 0x0260 }
                int r5 = r7.length()     // Catch:{ JSONException -> 0x0260 }
                r8 = 10
                if (r5 <= r8) goto L_0x0141
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0260 }
                r10.<init>()     // Catch:{ JSONException -> 0x0260 }
                r2 = 0
                java.lang.String r2 = r7.substring(r2, r8)     // Catch:{ JSONException -> 0x0260 }
                r10.append(r2)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r2 = "..."
                r10.append(r2)     // Catch:{ JSONException -> 0x0260 }
                int r5 = r5 - r8
                java.lang.String r2 = r7.substring(r5)     // Catch:{ JSONException -> 0x0260 }
                r10.append(r2)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r2 = r10.toString()     // Catch:{ JSONException -> 0x0260 }
                goto L_0x0143
            L_0x0141:
                r2 = r16
            L_0x0143:
                java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_ORIGINAL_TOKEN     // Catch:{ JSONException -> 0x0260 }
                r1.put(r5, r2)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.KEY_CONTENT     // Catch:{ JSONException -> 0x0260 }
                r11.put(r5, r1)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.util.TimeLogger r1 = net.one97.paytm.payments.visascp.util.TimeLogger.getInstance(r15)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = "Time Taken to create OneClickPay Object (Success)"
                r1.addSplit(r5)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.VisaSCPImpl$GetOneClickInfoListener r1 = r0.f546     // Catch:{ JSONException -> 0x0260 }
                if (r1 != 0) goto L_0x01b6
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r1 = r1.f387     // Catch:{ JSONException -> 0x0260 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0260 }
                r5.<init>()     // Catch:{ JSONException -> 0x0260 }
                r5.append(r9)     // Catch:{ JSONException -> 0x0260 }
                r5.append(r4)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r7 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_PAY_JSON_PREF_KEY     // Catch:{ JSONException -> 0x0260 }
                r5.append(r7)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r7 = r11.toString()     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r7 = r7.replace(r12, r13)     // Catch:{ JSONException -> 0x0260 }
                boolean r1 = r6.saveDataSynchronously((android.content.Context) r1, (java.lang.String) r5, (java.lang.String) r7)     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.VisaSCPMain r5 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r5 = r5.f387     // Catch:{ JSONException -> 0x0260 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0260 }
                r7.<init>()     // Catch:{ JSONException -> 0x0260 }
                r7.append(r9)     // Catch:{ JSONException -> 0x0260 }
                r7.append(r4)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r4 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ONE_CLICK_INFO_PAY_TIME_PREF_KEY     // Catch:{ JSONException -> 0x0260 }
                r7.append(r4)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r4 = r7.toString()     // Catch:{ JSONException -> 0x0260 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0260 }
                boolean r4 = r6.saveDataSynchronously((android.content.Context) r5, (java.lang.String) r4, (long) r7)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r5 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG     // Catch:{ JSONException -> 0x0260 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r6 = "createEnrollmentData - saving object in cache. isDataSave = "
                r5.<init>(r6)     // Catch:{ JSONException -> 0x0260 }
                r5.append(r1)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r1 = " ; isTimeSaved = "
                r5.append(r1)     // Catch:{ JSONException -> 0x0260 }
                r5.append(r4)     // Catch:{ JSONException -> 0x0260 }
            L_0x01b6:
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.util.CountDownLatchWrapper r1 = r1.f383     // Catch:{ JSONException -> 0x0260 }
                if (r1 == 0) goto L_0x01dc
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x01d6 }
                net.one97.paytm.payments.visascp.util.CountDownLatchWrapper r1 = r1.f383     // Catch:{ JSONException -> 0x01d6 }
                net.one97.paytm.payments.visascp.VisaSCPMain r4 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x01d6 }
                android.content.Context r4 = r4.f387     // Catch:{ JSONException -> 0x01d6 }
                r10 = r27
                r8 = r28
                java.lang.String r4 = net.one97.paytm.payments.visascp.util.Utils.getCardAlias(r4, r10, r8, r3, r14)     // Catch:{ JSONException -> 0x0260 }
                r1.countDown(r4)     // Catch:{ JSONException -> 0x0260 }
                goto L_0x01e0
            L_0x01d6:
                r10 = r27
                r8 = r28
                goto L_0x0260
            L_0x01dc:
                r10 = r27
                r8 = r28
            L_0x01e0:
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this     // Catch:{ JSONException -> 0x0260 }
                android.content.Context r1 = r1.f387     // Catch:{ JSONException -> 0x0260 }
                net.one97.paytm.payments.visascp.network.HawkEyeEvent r4 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r1)     // Catch:{ JSONException -> 0x0260 }
                java.lang.String r6 = "get-enrollment-data"
                java.sql.Timestamp r1 = new java.sql.Timestamp     // Catch:{ JSONException -> 0x0260 }
                r7 = r6
                r5 = r17
                r1.<init>(r5)     // Catch:{ JSONException -> 0x022f }
                java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x022f }
                long r17 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x022f }
                long r17 = r17 - r5
                java.lang.String r17 = java.lang.String.valueOf(r17)     // Catch:{ JSONException -> 0x022f }
                r18 = 200(0xc8, float:2.8E-43)
                java.lang.String r19 = "success"
                r20 = r5
                r5 = 0
                r6 = r7
                r7 = r30
                r8 = r1
                r22 = r9
                r9 = r17
                r1 = r10
                r23 = r20
                r10 = r18
                r17 = r11
                r11 = r19
                r25 = r12
                r12 = r22
                r1 = r13
                r13 = r2
                r4.logLocalEvent(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ JSONException -> 0x0271 }
                java.lang.String r2 = r17.toString()     // Catch:{ JSONException -> 0x0271 }
                r4 = r25
                java.lang.String r1 = r2.replace(r4, r1)     // Catch:{ JSONException -> 0x0271 }
                return r1
            L_0x022f:
                r23 = r5
                r22 = r9
                goto L_0x0277
            L_0x0234:
                r22 = r9
                r23 = r17
                org.json.JSONException r1 = new org.json.JSONException     // Catch:{ JSONException -> 0x0271 }
                java.lang.String r2 = "Device ID is empty"
                r1.<init>(r2)     // Catch:{ JSONException -> 0x0271 }
                throw r1     // Catch:{ JSONException -> 0x0271 }
            L_0x0240:
                r22 = r9
                r23 = r17
                org.json.JSONException r1 = new org.json.JSONException     // Catch:{ JSONException -> 0x0271 }
                java.lang.String r2 = "Cannot encrypt id token"
                r1.<init>(r2)     // Catch:{ JSONException -> 0x0271 }
                throw r1     // Catch:{ JSONException -> 0x0271 }
            L_0x024c:
                r22 = r9
                r23 = r17
                org.json.JSONException r1 = new org.json.JSONException     // Catch:{ JSONException -> 0x0271 }
                r1.<init>(r10)     // Catch:{ JSONException -> 0x0271 }
                throw r1     // Catch:{ JSONException -> 0x0271 }
            L_0x0256:
                r22 = r9
                r23 = r17
                org.json.JSONException r1 = new org.json.JSONException     // Catch:{ JSONException -> 0x0271 }
                r1.<init>(r10)     // Catch:{ JSONException -> 0x0271 }
                throw r1     // Catch:{ JSONException -> 0x0271 }
            L_0x0260:
                r22 = r9
                r23 = r17
                goto L_0x0277
            L_0x0265:
                r22 = r9
                r23 = r10
                org.json.JSONException r1 = new org.json.JSONException     // Catch:{ JSONException -> 0x0271 }
                java.lang.String r2 = "customer id is empty"
                r1.<init>(r2)     // Catch:{ JSONException -> 0x0271 }
                throw r1     // Catch:{ JSONException -> 0x0271 }
            L_0x0271:
                goto L_0x0277
            L_0x0273:
                r22 = r9
                r23 = r10
            L_0x0277:
                java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
                java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
                net.one97.paytm.payments.visascp.util.TimeLogger r1 = net.one97.paytm.payments.visascp.util.TimeLogger.getInstance(r15)
                java.lang.String r2 = "Time Taken to create OneClickPay Object (Failure)"
                r1.addSplit(r2)
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this
                net.one97.paytm.payments.visascp.util.CountDownLatchWrapper r1 = r1.f383
                if (r1 == 0) goto L_0x02a3
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this
                net.one97.paytm.payments.visascp.util.CountDownLatchWrapper r1 = r1.f383
                net.one97.paytm.payments.visascp.VisaSCPMain r2 = net.one97.paytm.payments.visascp.VisaSCPMain.this
                android.content.Context r2 = r2.f387
                r4 = r27
                r5 = r28
                java.lang.String r2 = net.one97.paytm.payments.visascp.util.Utils.getCardAlias(r2, r4, r5, r3, r14)
                r1.countDown(r2)
            L_0x02a3:
                net.one97.paytm.payments.visascp.VisaSCPMain r1 = net.one97.paytm.payments.visascp.VisaSCPMain.this
                android.content.Context r1 = r1.f387
                net.one97.paytm.payments.visascp.network.HawkEyeEvent r1 = net.one97.paytm.payments.visascp.network.HawkEyeEvent.getInstance(r1)
                r2 = 1
                java.sql.Timestamp r3 = new java.sql.Timestamp
                r4 = r23
                r3.<init>(r4)
                java.lang.String r6 = r3.toString()
                long r7 = java.lang.System.currentTimeMillis()
                long r7 = r7 - r4
                java.lang.String r7 = java.lang.String.valueOf(r7)
                r8 = 400(0x190, float:5.6E-43)
                r10 = 0
                java.lang.String r3 = "get-enrollment-data"
                java.lang.String r9 = "failure"
                r4 = r30
                r5 = r6
                r6 = r7
                r7 = r8
                r8 = r9
                r9 = r22
                r1.logLocalEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r16
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.VisaSCPMain.GetEnrollmentDataCustomAsync.m685(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static /* synthetic */ void m680(VisaSCPMain visaSCPMain, String str, String str2, String str3, String str4, VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener) {
        VisaSCPMain visaSCPMain2 = visaSCPMain;
        final String str5 = str4;
        String str6 = VisaSCPConstants.LOG_TAG;
        final TimeLogger instance = TimeLogger.getInstance("Starting getEnrollmentData");
        instance.reset("Starting getEnrollmentData");
        String str7 = str;
        String str8 = str2;
        String cardAlias = Utils.getCardAlias(visaSCPMain2.f387, str, str2, str3, str5);
        SecureSharedPref instance2 = SecureSharedPref.getInstance(visaSCPMain2.f387);
        if (Utils.isOneClickInfoPayResponseValid(visaSCPMain2.f387, cardAlias)) {
            String str9 = VisaSCPConstants.LOG_TAG;
            Context context = visaSCPMain2.f387;
            StringBuilder sb = new StringBuilder();
            sb.append(cardAlias);
            sb.append("_");
            sb.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_JSON_PREF_KEY);
            getOneClickInfoListener.onRequestEnd(instance2.getData(context, sb.toString()));
            instance.addSplit("Time taken to provide OneClickPay from cache");
            instance.dumpToLog();
            Context context2 = visaSCPMain2.f387;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cardAlias);
            sb2.append("_");
            sb2.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_JSON_PREF_KEY);
            instance2.clearData(context2, sb2.toString());
            Context context3 = visaSCPMain2.f387;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cardAlias);
            sb3.append("_");
            sb3.append(VisaSCPConstants.ONE_CLICK_INFO_PAY_TIME_PREF_KEY);
            instance2.clearData(context3, sb3.toString());
            return;
        }
        VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener2 = getOneClickInfoListener;
        if (Utils.isSafetyNetResponseValid(visaSCPMain2.f387)) {
            String str10 = VisaSCPConstants.LOG_TAG;
            String data = instance2.getData(visaSCPMain2.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
            instance.addSplit("Time Taken to provide safety net response from cache");
            visaSCPMain2.f384.executeAsyncTask(new GetEnrollmentDataCustomAsync(str, str2, str3, str4, data, (VisaSCPImpl.GetOneClickInfoListener) null));
            instance2.clearData(visaSCPMain2.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
            instance2.clearData(visaSCPMain2.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
            return;
        }
        final String str11 = str;
        final String str12 = str2;
        final String str13 = str3;
        final String str14 = str4;
        final VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener3 = getOneClickInfoListener;
        final AnonymousClass1 r0 = new VisaSCPImpl.SafetyNetListener() {
            public final void onSuccess(String str) {
                String str2 = VisaSCPConstants.LOG_TAG;
                instance.addSplit("Time taken by GoogleSafetyNet API (Success)");
                VisaSCPMain.this.f384.executeAsyncTask(new GetEnrollmentDataCustomAsync(str11, str12, str13, str14, str, (VisaSCPImpl.GetOneClickInfoListener) null));
            }

            public final void onError() {
                String str = VisaSCPConstants.LOG_TAG;
                instance.addSplit("Time taken by GoogleSafetyNet API (Error)");
                instance.dumpToLog();
                getOneClickInfoListener3.onRequestError("E005", "Safety Net API Error", (String) null);
            }
        };
        visaSCPMain2.f384.getExecutorService().submit(new Runnable() {
            public final void run() {
                GoogleSafetyNet.getInstance(VisaSCPMain.this.f387).attest(str9, NonceGenerator.generateNonce(), new SafetyNetResponseListener() {
                    public final void onSafetyNetResponseSuccess(final String str) {
                        VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                            public final void run() {
                                if (null != null) {
                                    SecureSharedPref instance = SecureSharedPref.getInstance(VisaSCPMain.this.f387);
                                    instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                                    instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                                    null.onSuccess(str);
                                }
                            }
                        });
                    }

                    public final void onSafetyNetResponseFailure(Exception exc) {
                        VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                            public final void run() {
                                if (null != null) {
                                    null.onError();
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static /* synthetic */ void m677(VisaSCPMain visaSCPMain, String str, String str2, String str3, String str4, VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener) {
        VisaSCPMain visaSCPMain2 = visaSCPMain;
        String str5 = str4;
        String cardAlias = Utils.getCardAlias(visaSCPMain2.f387, str, str2, str3, str5);
        TimeLogger instance = TimeLogger.getInstance("Starting Get One Click Info");
        instance.reset("Starting Get One Click Info");
        String str6 = VisaSCPConstants.LOG_TAG;
        SecureSharedPref instance2 = SecureSharedPref.getInstance(visaSCPMain2.f387);
        if (Utils.isOneClickInfoEnrollResponseValid(visaSCPMain2.f387, cardAlias)) {
            Context context = visaSCPMain2.f387;
            StringBuilder sb = new StringBuilder();
            sb.append(cardAlias);
            sb.append("_");
            sb.append(VisaSCPConstants.ONE_CLICK_INFO_ENROLL_JSON_PREF_KEY);
            getOneClickInfoListener.onRequestEnd(instance2.getData(context, sb.toString()));
            String str7 = VisaSCPConstants.LOG_TAG;
            instance.addSplit("Time taken to provide cached oneClickInfoObject");
            instance.dumpToLog();
            Context context2 = visaSCPMain2.f387;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cardAlias);
            sb2.append("_");
            sb2.append(VisaSCPConstants.ONE_CLICK_INFO_ENROLL_JSON_PREF_KEY);
            instance2.clearData(context2, sb2.toString());
            Context context3 = visaSCPMain2.f387;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cardAlias);
            sb3.append("_");
            sb3.append(VisaSCPConstants.ONE_CLICK_INFO_ENROLL_TIME_PREF_KEY);
            instance2.clearData(context3, sb3.toString());
            return;
        }
        VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener2 = getOneClickInfoListener;
        VisaSCPMain visaSCPMain3 = visaSCPMain;
        final TimeLogger timeLogger = instance;
        final String str8 = cardAlias;
        final SecureSharedPref secureSharedPref = instance2;
        final String str9 = str4;
        final VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener3 = getOneClickInfoListener;
        AnonymousClass18 r0 = new Response.Listener<BaseModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                final BaseModel baseModel = (BaseModel) obj;
                VisaSCPMain.this.f384.getExecutorService().submit(new Runnable() {
                    public final void run() {
                        int i2;
                        long currentTimeMillis = System.currentTimeMillis() - VisaSCPMain.this.f386;
                        String str = VisaSCPConstants.LOG_TAG;
                        timeLogger.addSplit("Time taken by AuthCode API (Success)");
                        final String str2 = baseModel.getResponse().headers.containsKey(VisaSCPConstants.HEADER_KEY_ID) ? baseModel.getResponse().headers.get(VisaSCPConstants.HEADER_KEY_ID) : null;
                        AuthCodeResponseModel authCodeResponseModel = (AuthCodeResponseModel) baseModel;
                        String respCode = authCodeResponseModel.getStatus().getRespCode();
                        try {
                            i2 = Integer.valueOf(respCode).intValue();
                        } catch (NumberFormatException unused) {
                            String str3 = VisaSCPConstants.LOG_TAG;
                            String str4 = VisaSCPConstants.EXCEPTION_MESSAGE;
                            i2 = 200;
                        }
                        if ("200".equals(respCode)) {
                            AuthCodeJwsResponseModel decryptAuthCodeResponse = new Decrypter().decryptAuthCodeResponse(str8, authCodeResponseModel.getData());
                            if (decryptAuthCodeResponse != null) {
                                SecureSharedPref secureSharedPref = secureSharedPref;
                                Context r6 = VisaSCPMain.this.f387;
                                StringBuilder sb = new StringBuilder();
                                sb.append(str8);
                                sb.append(VisaSCPConstants.VPUB);
                                secureSharedPref.saveData(r6, sb.toString(), decryptAuthCodeResponse.getPublicKey().getPublicKey());
                                SecureSharedPref secureSharedPref2 = secureSharedPref;
                                Context r62 = VisaSCPMain.this.f387;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str8);
                                sb2.append(VisaSCPConstants.D_ID);
                                secureSharedPref2.saveData(r62, sb2.toString(), decryptAuthCodeResponse.getDeviceId());
                                String str5 = "Time taken to create OneClickInfo object (Failure)";
                                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(false, Utils.getAuthCodeUrl(), str9, new Timestamp(VisaSCPMain.this.f386).toString(), String.valueOf(currentTimeMillis), i2, authCodeResponseModel.getStatus().getRespDesc(), str2, (String) null, decryptAuthCodeResponse.getDeviceId(), str8);
                                String deviceIdJws = new Encrypter().getDeviceIdJws(str8, decryptAuthCodeResponse.getDeviceId());
                                String authCodeJwe = new Encrypter().getAuthCodeJwe(VisaSCPMain.this.f387, str8, decryptAuthCodeResponse.getAuthCode());
                                final JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(VisaSCPConstants.KEY_REQ_TYPE, VisaSCPConstants.TYPE_ENROLL);
                                    JSONObject jSONObject2 = new JSONObject();
                                    if (!TextUtils.isEmpty(deviceIdJws)) {
                                        jSONObject2.put(VisaSCPConstants.KEY_SIGN_DEV_ID, deviceIdJws);
                                        jSONObject2.put(VisaSCPConstants.KEY_AUTH_CODE, authCodeJwe);
                                        jSONObject2.put(VisaSCPConstants.KEY_CARD_ALIAS, str8);
                                        jSONObject2.put(VisaSCPConstants.KEY_APP_ID, Utils.getMerchantAppId(VisaSCPMain.this.f387));
                                        jSONObject2.put(VisaSCPConstants.KEY_CUSTOMER_ID, str9);
                                        jSONObject2.put(VisaSCPConstants.KEY_PARTNER_TRANSACTION_ID, str2);
                                        jSONObject2.put(VisaSCPConstants.KEY_PUBLIC_KEY, new Encrypter().getDevicePublicKeyString(str8));
                                        if (Build.VERSION.SDK_INT < 23) {
                                            jSONObject2.put(VisaSCPConstants.KEY_ENCRYPTION_ALGO, VisaSCPConstants.ALGORITHM_RSA_ECB_PKCS1);
                                        } else {
                                            jSONObject2.put(VisaSCPConstants.KEY_ENCRYPTION_ALGO, VisaSCPConstants.ALGORITHM_PARES);
                                        }
                                        jSONObject.put(VisaSCPConstants.KEY_CONTENT, jSONObject2);
                                        VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                            public final void run() {
                                                getOneClickInfoListener3.onRequestEnd(jSONObject.toString().replace("\\", ""));
                                            }
                                        });
                                        timeLogger.addSplit("Time taken to create OneClickInfo object (Success)");
                                    } else {
                                        throw new JSONException("Device ID is empty");
                                    }
                                } catch (JSONException unused2) {
                                    String str6 = VisaSCPConstants.LOG_TAG;
                                    String str7 = VisaSCPConstants.EXCEPTION_MESSAGE;
                                    VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                        public final void run() {
                                            getOneClickInfoListener3.onRequestError("D001", "Decryption Failed", str2);
                                        }
                                    });
                                    timeLogger.addSplit(str5);
                                    return;
                                }
                            } else {
                                VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                    public final void run() {
                                        getOneClickInfoListener3.onRequestError("D001", "Decryption Failed", str2);
                                    }
                                });
                                timeLogger.addSplit("Time taken to create OneClickInfo object (Failure)");
                                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, Utils.getAuthCodeUrl(), str9, new Timestamp(VisaSCPMain.this.f386).toString(), String.valueOf(currentTimeMillis), i2, "Decryption Failed", str2, (String) null, (String) null, str8);
                            }
                        } else {
                            timeLogger.addSplit("Time taken to create OneClickInfo object (Failure)");
                            VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                public final void run() {
                                    getOneClickInfoListener3.onRequestError("D004", "Failed to get response", str2);
                                }
                            });
                            HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, Utils.getAuthCodeUrl(), str9, new Timestamp(VisaSCPMain.this.f386).toString(), String.valueOf(currentTimeMillis), i2, "Failed to get response", str2, "visa-status-code=".concat(String.valueOf(respCode)), (String) null, str8);
                        }
                        timeLogger.dumpToLog();
                    }
                });
            }
        };
        final String str10 = str4;
        final String str11 = cardAlias;
        final VisaSCPImpl.GetOneClickInfoListener getOneClickInfoListener4 = getOneClickInfoListener;
        AnonymousClass20 r02 = new Response.ErrorListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                VolleyError volleyError2 = volleyError;
                long currentTimeMillis = System.currentTimeMillis() - VisaSCPMain.this.f386;
                String str = VisaSCPConstants.LOG_TAG;
                timeLogger.addSplit("Time taken by AuthCode API (Failure)");
                timeLogger.dumpToLog();
                String str2 = (volleyError2.networkResponse == null || volleyError2.networkResponse.headers == null || !volleyError2.networkResponse.headers.containsKey(VisaSCPConstants.HEADER_KEY_ID)) ? null : volleyError2.networkResponse.headers.get(VisaSCPConstants.HEADER_KEY_ID);
                HawkEyeEvent.getInstance(VisaSCPMain.this.f387).logApiEvent(true, Utils.getAuthCodeUrl(), str10, new Timestamp(VisaSCPMain.this.f386).toString(), String.valueOf(currentTimeMillis), volleyError2.networkResponse != null ? volleyError2.networkResponse.statusCode : 0, volleyError.getMessage(), str2, (String) null, (String) null, str11);
                getOneClickInfoListener4.onRequestError("E001", volleyError.getMessage(), str2);
            }
        };
        CustomThreadPoolExecutorManager customThreadPoolExecutorManager = visaSCPMain2.f384;
        final SecureSharedPref secureSharedPref2 = instance2;
        AnonymousClass4 r10 = r0;
        final String str12 = str4;
        Context context4 = visaSCPMain2.f387;
        final AnonymousClass18 r6 = r0;
        final AnonymousClass20 r7 = r02;
        AnonymousClass4 r03 = new VisaSCPImpl.KeyGenerationListener() {
            public final void onKeyGenerated() {
                String str = VisaSCPConstants.LOG_TAG;
                timeLogger.addSplit("Time taken for Generating Key Pair (Success)");
                if (Utils.isSafetyNetResponseValid(VisaSCPMain.this.f387)) {
                    String data = secureSharedPref2.getData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                    secureSharedPref2.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                    secureSharedPref2.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                    String str2 = VisaSCPConstants.LOG_TAG;
                    timeLogger.addSplit("Time taken for fetching GoogleSafetyNet from cache (Success)");
                    long unused = VisaSCPMain.this.f386 = System.currentTimeMillis();
                    GetAuthCode.callAuthCodeAPI(VisaSCPMain.this.f387, str11, str12, r6, r7, data);
                    return;
                }
                VisaSCPMain.this.f384.getExecutorService().submit(new Runnable(str12, new VisaSCPImpl.SafetyNetListener() {
                    public final void onSuccess(String str) {
                        String str2 = VisaSCPConstants.LOG_TAG;
                        timeLogger.addSplit("Time taken by GoogleSafetyNet (Success)");
                        long unused = VisaSCPMain.this.f386 = System.currentTimeMillis();
                        GetAuthCode.callAuthCodeAPI(VisaSCPMain.this.f387, str11, str12, r6, r7, str);
                    }

                    public final void onError() {
                        String str = VisaSCPConstants.LOG_TAG;
                        timeLogger.addSplit("Time taken by GoogleSafetyNet (Failure)");
                        r7.onErrorResponse(new VolleyError("Cannot fetch SafetyNet Response"));
                    }
                }) {
                    public final void run() {
                        GoogleSafetyNet.getInstance(VisaSCPMain.this.f387).attest(str9, NonceGenerator.generateNonce(), new SafetyNetResponseListener() {
                            public final void onSafetyNetResponseSuccess(final String str) {
                                VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                    public final void run() {
                                        if (null != null) {
                                            SecureSharedPref instance = SecureSharedPref.getInstance(VisaSCPMain.this.f387);
                                            instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_PREF_KEY);
                                            instance.clearData(VisaSCPMain.this.f387, VisaSCPConstants.SAFETY_DATA_TIME_PREF_KEY);
                                            null.onSuccess(str);
                                        }
                                    }
                                });
                            }

                            public final void onSafetyNetResponseFailure(Exception exc) {
                                VisaSCPMain.this.f384.postOnUIThread(new Runnable() {
                                    public final void run() {
                                        if (null != null) {
                                            null.onError();
                                        }
                                    }
                                });
                            }
                        });
                    }
                });
            }

            public final void onKeyNotGenerated() {
                String str = VisaSCPConstants.LOG_TAG;
                timeLogger.addSplit("Time taken for Generating Key Pair (Failure)");
                r7.onErrorResponse(new VolleyError("Cannot generate key pair"));
            }
        };
        customThreadPoolExecutorManager.executeAsyncTask(new KeyGeneratorCustomAsync(context4, cardAlias, str5, r10));
    }
}
