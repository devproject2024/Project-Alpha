package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.datatransport.b;
import com.google.android.datatransport.f;
import com.google.android.datatransport.g;
import com.google.firebase.iid.aq;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public Intent getStartCommandIntent(Intent intent) {
        return aq.a().f38826c.poll();
    }

    public boolean handleIntentOnMainThread(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        handleNotificationOpen(intent);
        return true;
    }

    private void handleNotificationOpen(Intent intent) {
        if (m.d(intent)) {
            m.a(intent);
        }
    }

    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
        } else if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
            if (m.d(intent)) {
                m.b(intent);
            }
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra(StringSet.token));
        } else {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown intent action: ".concat(valueOf);
            } else {
                new String("Unknown intent action: ");
            }
        }
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            passMessageIntentToSdk(intent);
        }
    }

    private void passMessageIntentToSdk(Intent intent) {
        g a2;
        String stringExtra = intent.getStringExtra(StringSet.message_type);
        if (stringExtra == null) {
            stringExtra = StringSet.gcm;
        }
        char c2 = 65535;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    c2 = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals(StringSet.gcm)) {
                    c2 = 0;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    c2 = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            if (m.d(intent)) {
                m.a(intent, (f<String>) null);
            }
            if (m.e(intent) && (a2 = FirebaseMessaging.a()) != null) {
                Class<String> cls = String.class;
                m.a(intent, (f<String>) a2.a("FCM_CLIENT_EVENT_LOGGING", b.a("json"), i.f39011a));
            }
            dispatchMessage(intent);
        } else if (c2 == 1) {
            onDeletedMessages();
        } else if (c2 == 2) {
            onMessageSent(intent.getStringExtra("google.message_id"));
        } else if (c2 != 3) {
            String valueOf = String.valueOf(stringExtra);
            if (valueOf.length() != 0) {
                "Received message with unknown type: ".concat(valueOf);
            } else {
                new String("Received message with unknown type: ");
            }
        } else {
            onSendError(getMessageId(intent), new p(intent.getStringExtra("error")));
        }
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (n.a(extras)) {
            n nVar = new n(extras);
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new com.google.android.gms.common.util.a.b("Firebase-Messaging-Network-Io"));
            try {
                if (!new c(this, nVar, newSingleThreadExecutor).a()) {
                    newSingleThreadExecutor.shutdown();
                    if (m.d(intent)) {
                        m.c(intent);
                    }
                } else {
                    return;
                }
            } finally {
                newSingleThreadExecutor.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!recentlyReceivedMessageIds.contains(str)) {
            if (recentlyReceivedMessageIds.size() >= 10) {
                recentlyReceivedMessageIds.remove();
            }
            recentlyReceivedMessageIds.add(str);
            return false;
        } else if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        } else {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Received duplicate message: ".concat(valueOf);
                return true;
            }
            new String("Received duplicate message: ");
            return true;
        }
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra(StringSet.message_id) : stringExtra;
    }
}
