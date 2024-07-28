package com.paytm.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.y;
import com.google.gson.f;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.models.FlashMessage;
import com.paytm.notification.models.PushMessage;
import com.paytm.notification.models.callback.InboxHandlerReadyCallback;
import kotlin.g.b.k;

public class PaytmNotificationReceiver extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    public void a(Context context, PushMessage pushMessage) {
        k.c(pushMessage, "pushMessage");
    }

    /* access modifiers changed from: protected */
    public void a(PushMessage pushMessage) {
        k.c(pushMessage, "pushMessage");
    }

    /* access modifiers changed from: protected */
    public void b(Context context, PushMessage pushMessage) {
        k.c(pushMessage, "pushMessage");
    }

    /* access modifiers changed from: protected */
    public void c(Context context, PushMessage pushMessage) {
        k.c(pushMessage, "pushMessage");
    }

    public void onReceive(Context context, Intent intent) {
        Class<PaytmNotificationReceiver> cls = PaytmNotificationReceiver.class;
        e.b bVar = e.f43014a;
        StringBuilder sb = new StringBuilder("Received Intent ");
        if (intent == null) {
            k.a();
        }
        sb.append(intent.getAction());
        bVar.a(sb.toString(), new Object[0]);
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -514446726:
                    if (action.equals("com.paytm.notification.flash.DISPLAYED")) {
                        e.f43014a.a("flash Received", new Object[0]);
                        k.c(b(intent), "flashMessage");
                        return;
                    }
                    return;
                case 962536986:
                    if (!action.equals("com.paytm.notification.COUNT_RECEIVED")) {
                        return;
                    }
                    if (intent == null || !intent.hasExtra("MSG_COUNT")) {
                        cls.getCanonicalName();
                        return;
                    }
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        k.a();
                    }
                    extras.getInt("PREV_MSG_COUNT");
                    Bundle extras2 = intent.getExtras();
                    if (extras2 == null) {
                        k.a();
                    }
                    int i2 = extras2.getInt("MSG_COUNT");
                    cls.getCanonicalName();
                    g.c cVar = g.f43191a;
                    g.c.a((InboxHandlerReadyCallback) new a(i2));
                    return;
                case 1081937920:
                    if (action.equals("com.paytm.notification.DISMISSED")) {
                        e.f43014a.a("Notification Dismissed", new Object[0]);
                        a(a(intent));
                        return;
                    }
                    return;
                case 1553370194:
                    if (action.equals("com.paytm.notification.OPENED")) {
                        e.f43014a.a("Notification Opened", new Object[0]);
                        b(context, a(intent));
                        return;
                    }
                    return;
                case 1661622334:
                    if (action.equals("com.paytm.notification.SILENT")) {
                        e.f43014a.a("Notification Silent", new Object[0]);
                        c(context, a(intent));
                        return;
                    }
                    return;
                case 2130531210:
                    if (action.equals("com.paytm.notification.RECEIVED")) {
                        e.f43014a.a("Notification Received", new Object[0]);
                        a(context, a(intent));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static final class a implements InboxHandlerReadyCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f42996a;

        a(int i2) {
            this.f42996a = i2;
        }

        public final void onCallbackReady(c cVar) {
            k.c(cVar, "inboxHandler");
            y<Integer> e2 = cVar.e();
            if (e2 != null) {
                e2.postValue(Integer.valueOf(this.f42996a));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.paytm.notification.models.PushMessage a(android.content.Intent r3) {
        /*
            r0 = 0
            android.os.Bundle r1 = r3.getExtras()     // Catch:{ Exception -> 0x000e }
            if (r1 == 0) goto L_0x000e
            java.lang.String r2 = "MESSAGE_BUNDLE"
            android.os.Bundle r1 = r1.getBundle(r2)     // Catch:{ Exception -> 0x000e }
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            android.os.Bundle r3 = r3.getExtras()     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "EXTRA_PUSH_SERIALIZED"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x0045 }
        L_0x001b:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0045 }
            if (r3 == 0) goto L_0x0029
            int r3 = r3.length()     // Catch:{ Exception -> 0x0045 }
            if (r3 != 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            goto L_0x002a
        L_0x0029:
            r3 = 1
        L_0x002a:
            if (r3 == 0) goto L_0x0032
            com.paytm.notification.models.PushMessage r3 = new com.paytm.notification.models.PushMessage     // Catch:{ Exception -> 0x0045 }
            r3.<init>()     // Catch:{ Exception -> 0x0045 }
            goto L_0x0052
        L_0x0032:
            com.google.gson.f r3 = new com.google.gson.f     // Catch:{ Exception -> 0x0045 }
            r3.<init>()     // Catch:{ Exception -> 0x0045 }
            java.lang.Class<com.paytm.notification.models.PushMessage> r2 = com.paytm.notification.models.PushMessage.class
            java.lang.Object r3 = r3.a((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r0 = "Gson().fromJson(serializ… PushMessage::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x0045 }
            com.paytm.notification.models.PushMessage r3 = (com.paytm.notification.models.PushMessage) r3     // Catch:{ Exception -> 0x0045 }
            goto L_0x0052
        L_0x0045:
            r3 = move-exception
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r0.b(r3)
            com.paytm.notification.models.PushMessage r3 = new com.paytm.notification.models.PushMessage
            r3.<init>()
        L_0x0052:
            if (r1 == 0) goto L_0x0058
            r3.setBundle(r1)
            goto L_0x005f
        L_0x0058:
            android.os.Bundle r0 = r3.getPushBundle$paytmnotification_paytmRelease()
            r3.setBundle(r0)
        L_0x005f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.PaytmNotificationReceiver.a(android.content.Intent):com.paytm.notification.models.PushMessage");
    }

    private static FlashMessage b(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            Object a2 = new f().a(extras != null ? extras.getString("EXTRA_FLASH_SERIALIZED") : null, FlashMessage.class);
            k.a(a2, "Gson().fromJson(serializ…FlashMessage::class.java)");
            FlashMessage flashMessage = (FlashMessage) a2;
            flashMessage.setBundle(flashMessage.getPushBundle());
            return flashMessage;
        } catch (Exception e2) {
            e.f43014a.b(e2);
            return new FlashMessage();
        }
    }
}
