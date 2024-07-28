package com.sendbird.android;

import android.content.Context;
import android.text.TextUtils;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class SendBirdPushHelper {
    /* access modifiers changed from: private */
    public static final Map<Long, Long> delieverdMessageCache = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static e handler;
    private static final AtomicReference<String> registerdToken = new AtomicReference<>();
    private static final AtomicReference<a> tokenStatus = new AtomicReference<>(a.Empty);

    public interface OnPushRequestCompleteListener {
        void onComplete(boolean z, String str);

        void onError(SendBirdException sendBirdException);
    }

    enum a {
        Empty,
        PushTokenRegistered,
        NeedToRegisterPushToken
    }

    static void retryPendingAction() {
        Logger.d(">> SendBirdPushHelper::retryPendingAction() tokenStatus : " + tokenStatus);
        if (tokenStatus.get() == a.NeedToRegisterPushToken) {
            registerPushToken();
        }
    }

    private static void registerPushToken() {
        e eVar = handler;
        if (eVar != null) {
            eVar.getToken(new OnPushTokenReceiveListener() {
                public final void onReceived(String str, SendBirdException sendBirdException) {
                    SendBirdPushHelper.registerPushToken(str, SendBirdPushHelper.handler.isUniquePushToken(), (OnPushRequestCompleteListener) null);
                }
            });
        }
    }

    static void registerPushToken(final String str, boolean z, final OnPushRequestCompleteListener onPushRequestCompleteListener) {
        changeTokenStatus(a.NeedToRegisterPushToken, str);
        if (!SendBird.isInitialized() || SendBird.getCurrentUser() == null) {
            Logger.d("SendBird is initialized : " + SendBird.isInitialized());
            Logger.d(">> SendBirdPushHelper::registerPushToken(). Connection must be made");
            if (onPushRequestCompleteListener != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                        if (onPushRequestCompleteListener != null) {
                            onPushRequestCompleteListener.onError(new SendBirdException("Connection must be made.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        }
                    }
                });
                return;
            }
            return;
        }
        Logger.d(">> SendBirdPushHelper::registerPushToken()");
        if (TextUtils.isEmpty(str) || str.equals(registerdToken.get())) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    if (onPushRequestCompleteListener == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        onPushRequestCompleteListener.onError(new SendBirdException("token is null. you have to fill token value."));
                    } else {
                        onPushRequestCompleteListener.onComplete(false, str);
                    }
                }
            });
            return;
        }
        Logger.d("++ requested token : " + str + ", unique : " + z);
        e eVar = handler;
        if (eVar != null) {
            eVar.registerPushToken(str, z, new SendBird.RegisterPushTokenWithStatusHandler() {
                public final void onRegistered(SendBird.PushTokenRegistrationStatus pushTokenRegistrationStatus, SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        Logger.e((Throwable) sendBirdException);
                        if (sendBirdException.getCode() == 400111) {
                            SendBirdPushHelper.changeTokenStatus(a.Empty, str);
                        }
                        OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                        if (onPushRequestCompleteListener != null) {
                            onPushRequestCompleteListener.onError(sendBirdException);
                            return;
                        }
                        return;
                    }
                    SendBirdPushHelper.changeTokenStatus(a.PushTokenRegistered, str);
                    OnPushRequestCompleteListener onPushRequestCompleteListener2 = onPushRequestCompleteListener;
                    if (onPushRequestCompleteListener2 != null) {
                        onPushRequestCompleteListener2.onComplete(true, str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void unregisterPushToken(boolean z, final String str, final OnPushRequestCompleteListener onPushRequestCompleteListener) {
        Logger.d(">> SendBirdPushHelper::unregisterPushToken(). unregisterAll : " + z + ", token : " + str);
        Logger.d("++ token : ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                    if (onPushRequestCompleteListener != null) {
                        onPushRequestCompleteListener.onError(new SendBirdException("token is null. you have to fill token value."));
                    }
                }
            });
        } else if (SendBird.getCurrentUser() == null) {
            if (onPushRequestCompleteListener != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                        if (onPushRequestCompleteListener != null) {
                            onPushRequestCompleteListener.onError(new SendBirdException("Connection must be made.", SendBirdError.ERR_CONNECTION_REQUIRED));
                        }
                    }
                });
            }
        } else if (z) {
            d.a(new s<Boolean>() {
                /* access modifiers changed from: private */
                /* renamed from: a */
                public Boolean call() {
                    try {
                        APIClient.a().f();
                    } catch (SendBirdException e2) {
                        SendBirdPushHelper.processUnRegisterPushToken(str, onPushRequestCompleteListener, e2);
                    }
                    return Boolean.TRUE;
                }
            });
        } else {
            e eVar = handler;
            if (eVar != null) {
                eVar.unregisterPushToken(str, new SendBird.UnregisterPushTokenHandler() {
                    public final void onUnregistered(SendBirdException sendBirdException) {
                        SendBirdPushHelper.processUnRegisterPushToken(str, onPushRequestCompleteListener, sendBirdException);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public static void processUnRegisterPushToken(final String str, final OnPushRequestCompleteListener onPushRequestCompleteListener, final SendBirdException sendBirdException) {
        SendBird.runOnUIThread(new Runnable() {
            public final void run() {
                SendBirdException sendBirdException = sendBirdException;
                if (sendBirdException != null) {
                    Logger.e((Throwable) sendBirdException);
                    if (sendBirdException.getCode() == 400111) {
                        SendBirdPushHelper.changeTokenStatus(a.Empty, str);
                    }
                    OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                    if (onPushRequestCompleteListener != null) {
                        onPushRequestCompleteListener.onError(sendBirdException);
                        return;
                    }
                    return;
                }
                SendBirdPushHelper.changeTokenStatus(a.Empty, str);
                OnPushRequestCompleteListener onPushRequestCompleteListener2 = onPushRequestCompleteListener;
                if (onPushRequestCompleteListener2 != null) {
                    onPushRequestCompleteListener2.onComplete(false, (String) null);
                }
            }
        });
    }

    public static <T extends e> void registerPushHandler(T t) {
        Logger.d(">> SendBirdPushHelper::registerPushHandler()");
        handler = t;
        delieverdMessageCache.clear();
        registerPushToken();
    }

    public static void unregisterPushHandler(OnPushRequestCompleteListener onPushRequestCompleteListener) {
        unregisterPushHandler(false, onPushRequestCompleteListener);
    }

    public static void unregisterPushHandler(final boolean z, final OnPushRequestCompleteListener onPushRequestCompleteListener) {
        Logger.d(">> SendBirdPushHelper::unregisterPushHandler()");
        if (handler == null) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                    if (onPushRequestCompleteListener != null) {
                        onPushRequestCompleteListener.onError(new SendBirdException("Already unregistered", SendBirdError.ERR_INVALID_PARAMETER));
                    }
                }
            });
            return;
        }
        final AnonymousClass3 r0 = new OnPushRequestCompleteListener() {
            public final void onComplete(boolean z, String str) {
                e unused = SendBirdPushHelper.handler = null;
                SendBirdPushHelper.delieverdMessageCache.clear();
                OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                if (onPushRequestCompleteListener != null) {
                    onPushRequestCompleteListener.onComplete(z, str);
                }
            }

            public final void onError(SendBirdException sendBirdException) {
                if (sendBirdException.getCode() == 400111) {
                    OnPushRequestCompleteListener onPushRequestCompleteListener = onPushRequestCompleteListener;
                    if (onPushRequestCompleteListener != null) {
                        onPushRequestCompleteListener.onComplete(false, (String) null);
                        return;
                    }
                    return;
                }
                OnPushRequestCompleteListener onPushRequestCompleteListener2 = onPushRequestCompleteListener;
                if (onPushRequestCompleteListener2 != null) {
                    onPushRequestCompleteListener2.onError(sendBirdException);
                }
            }
        };
        String str = registerdToken.get();
        if (!TextUtils.isEmpty(str)) {
            unregisterPushToken(z, str, r0);
        } else {
            handler.getToken(new OnPushTokenReceiveListener() {
                public final void onReceived(String str, final SendBirdException sendBirdException) {
                    if (sendBirdException != null) {
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                r0.onError(sendBirdException);
                            }
                        });
                    } else {
                        SendBirdPushHelper.unregisterPushToken(z, str, r0);
                    }
                }
            });
        }
    }

    public static boolean isDuplicateMessage(Object obj) {
        JSONObject payload;
        try {
            if (handler == null || (payload = handler.getPayload(obj)) == null) {
                return false;
            }
            Long valueOf = Long.valueOf(payload.optLong(StringSet.message_id));
            if (delieverdMessageCache.get(valueOf) == null) {
                return false;
            }
            Logger.d("__duplicated sendbird message. [" + valueOf + "]");
            return true;
        } catch (Exception e2) {
            Logger.e((Throwable) e2);
            return false;
        }
    }

    static void messageDelivered(BaseMessage baseMessage) {
        Logger.d(">> SendBirdPushHelper::messageDeleivered()");
        Logger.d("++ MsgId : " + baseMessage.getMessageId());
        long messageId = baseMessage.getMessageId();
        delieverdMessageCache.put(Long.valueOf(messageId), Long.valueOf(messageId));
    }

    static void onNewToken(String str) {
        Logger.d("onNewToken: " + str + ", handler : " + handler);
        e eVar = handler;
        if (eVar != null) {
            eVar.onTokenUpdated(str);
        }
    }

    static void onMessageReceived(Context context, Object obj) {
        Logger.d(">> SendBirdPushHelper::onMessageReceived(). remoteMessage : " + obj.getClass().getName());
        if (isSendBirdMessage(obj)) {
            Logger.d("Sendbird message.");
            if (isDuplicateMessage(obj)) {
                Logger.d("duplicate message");
                return;
            } else if (SendBird.getConnectionState() == SendBird.ConnectionState.OPEN) {
                Logger.d("app is in connected. SendBird.isAppBackground() : " + SendBird.isAppBackground());
                return;
            }
        }
        e eVar = handler;
        if (eVar != null) {
            eVar.onMessageReceived(context, obj);
        }
    }

    private static boolean isSendBirdMessage(Object obj) {
        e eVar = handler;
        if (eVar != null) {
            return eVar.isSendBirdMessage(obj);
        }
        return false;
    }

    public static void getPushToken(OnPushTokenReceiveListener onPushTokenReceiveListener) {
        e eVar = handler;
        if (eVar != null) {
            eVar.getToken(onPushTokenReceiveListener);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void changeTokenStatus(com.sendbird.android.SendBirdPushHelper.a r3, java.lang.String r4) {
        /*
            java.lang.Class<com.sendbird.android.SendBirdPushHelper> r0 = com.sendbird.android.SendBirdPushHelper.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "changeTokenStatus to : "
            r1.<init>(r2)     // Catch:{ all -> 0x0045 }
            r1.append(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = ", currentToken : "
            r1.append(r2)     // Catch:{ all -> 0x0045 }
            r1.append(r4)     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0045 }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0045 }
            com.sendbird.android.log.Logger.i((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0045 }
            java.util.concurrent.atomic.AtomicReference<com.sendbird.android.SendBirdPushHelper$a> r1 = tokenStatus     // Catch:{ all -> 0x0045 }
            r1.set(r3)     // Catch:{ all -> 0x0045 }
            int[] r1 = com.sendbird.android.SendBirdPushHelper.AnonymousClass5.f44665a     // Catch:{ all -> 0x0045 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0045 }
            r3 = r1[r3]     // Catch:{ all -> 0x0045 }
            r1 = 1
            if (r3 == r1) goto L_0x003e
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r4 = 3
            if (r3 == r4) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r3 = registerdToken     // Catch:{ all -> 0x0045 }
            r4 = 0
            r3.set(r4)     // Catch:{ all -> 0x0045 }
        L_0x003c:
            monitor-exit(r0)
            return
        L_0x003e:
            java.util.concurrent.atomic.AtomicReference<java.lang.String> r3 = registerdToken     // Catch:{ all -> 0x0045 }
            r3.set(r4)     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)
            return
        L_0x0045:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBirdPushHelper.changeTokenStatus(com.sendbird.android.SendBirdPushHelper$a, java.lang.String):void");
    }

    /* renamed from: com.sendbird.android.SendBirdPushHelper$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44665a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.sendbird.android.SendBirdPushHelper$a[] r0 = com.sendbird.android.SendBirdPushHelper.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44665a = r0
                int[] r0 = f44665a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.SendBirdPushHelper$a r1 = com.sendbird.android.SendBirdPushHelper.a.PushTokenRegistered     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f44665a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.SendBirdPushHelper$a r1 = com.sendbird.android.SendBirdPushHelper.a.NeedToRegisterPushToken     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f44665a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.sendbird.android.SendBirdPushHelper$a r1 = com.sendbird.android.SendBirdPushHelper.a.Empty     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.SendBirdPushHelper.AnonymousClass5.<clinit>():void");
        }
    }
}
