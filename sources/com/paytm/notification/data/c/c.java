package com.paytm.notification.data.c;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.notification.b.e;
import com.paytm.notification.data.datasource.dao.g;
import com.paytm.notification.data.datasource.dao.i;
import com.paytm.notification.models.Content;
import com.paytm.notification.models.Notification;
import com.paytm.notification.models.PaytmInbox;
import com.paytm.notification.models.PushMessage;
import com.paytm.signal.b;
import com.paytm.signal.models.SignalEvent;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43062a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final g f43063b;

    public c(g gVar) {
        k.c(gVar, "notificationDao");
        this.f43063b = gVar;
    }

    public final void g(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationExpired", a.a(str, str2), 100));
    }

    public final void f(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationDisplayed", a.a(str, str2), 100));
    }

    public final void c(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationClicked", a.a(str, str2), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void d(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        com.paytm.notification.b.a.d("[Flash Received][p:" + str + " c:" + str2 + ']');
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationReceived", a.a(str, str2), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void e(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationDismissed", a.a(str, str2), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void b(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationPulled", a.a(str, str2), 100));
    }

    public final void a(String str, String str2, String str3) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        k.c(str3, Item.KEY_REASON);
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("flashNotificationIgnored", a.a(str, str2, str3), 100));
    }

    public final void a(int i2) {
        i a2 = this.f43063b.a(i2);
        if (a2 != null) {
            com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
            StringBuilder sb = new StringBuilder("[Push Opened][p:");
            String str = a2.f43161g;
            if (str == null) {
                str = H5BridgeContext.INVALID_ID;
            }
            sb.append(str);
            sb.append(" m:");
            String str2 = a2.v;
            if (str2 == null) {
                str2 = H5BridgeContext.INVALID_ID;
            }
            sb.append(str2);
            sb.append(" n:");
            sb.append(Integer.valueOf(i2));
            sb.append("] ");
            String str3 = a2.f43163i;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            com.paytm.notification.b.a.d(sb.toString());
            b.C0745b bVar = b.f43594e;
            a aVar2 = a.f43061a;
            b.C0745b.a(new SignalEvent("pushNotificationClicked", a.a(a2), 100));
            b.C0745b bVar2 = b.f43594e;
            b.C0745b.a();
            this.f43063b.b(i2);
            return;
        }
        com.paytm.notification.b.a aVar3 = com.paytm.notification.b.a.f42999a;
        com.paytm.notification.b.a.d("[Push Opened] Fail! Notification id (" + i2 + ") not found in local db");
        e.f43014a.b("pushNotificationClicked action ignored notification not found in local db", new Object[0]);
    }

    public final void b(int i2) {
        i a2 = this.f43063b.a(i2);
        if (a2 != null) {
            com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
            StringBuilder sb = new StringBuilder("[Push Dismissed][p:");
            String str = a2.f43161g;
            if (str == null) {
                str = H5BridgeContext.INVALID_ID;
            }
            sb.append(str);
            sb.append(" m:");
            String str2 = a2.v;
            if (str2 == null) {
                str2 = H5BridgeContext.INVALID_ID;
            }
            sb.append(str2);
            sb.append(" n:");
            sb.append(Integer.valueOf(i2));
            sb.append("] ");
            String str3 = a2.f43163i;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            com.paytm.notification.b.a.d(sb.toString());
            b.C0745b bVar = b.f43594e;
            a aVar2 = a.f43061a;
            b.C0745b.a(new SignalEvent("pushNotificationDismissed", a.a(a2), 100));
            b.C0745b bVar2 = b.f43594e;
            b.C0745b.a();
            this.f43063b.b(i2);
            return;
        }
        com.paytm.notification.b.a aVar3 = com.paytm.notification.b.a.f42999a;
        com.paytm.notification.b.a.d("[Push Dismissed] Fail! Notification id (" + i2 + ") not found in local db");
        e.f43014a.b("pushNotificationDismissed action ignored notification not found in local db", new Object[0]);
    }

    public final void c(PushMessage pushMessage) {
        String str;
        Content content;
        k.c(pushMessage, "pushMessage");
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Push Displayed][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str = content.getTitle()) == null) {
            str = "";
        }
        sb.append(str);
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("pushNotificationDisplayed", a.a(pushMessage), 100));
    }

    public final void d(PushMessage pushMessage) {
        String str;
        Content content;
        k.c(pushMessage, "pushMessage");
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Push image failed to display][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str = content.getTitle()) == null) {
            str = "";
        }
        sb.append(str);
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("pushNotificationImageDisplayFailed", a.a(pushMessage), 100));
    }

    public final void a(PushMessage pushMessage, String str) {
        String str2;
        Content content;
        k.c(pushMessage, "pushMessage");
        k.c(str, Item.KEY_REASON);
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Push Display Failed][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str2 = content.getTitle()) == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(" Reason: ");
        sb.append(str);
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("pushNotificationDisplayFailed", a.a(pushMessage, str), 100));
    }

    public final void b(PushMessage pushMessage, String str) {
        String str2;
        Content content;
        k.c(pushMessage, "pushMessage");
        k.c(str, Item.KEY_REASON);
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Push Refused][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str2 = content.getTitle()) == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(" Reason: ");
        sb.append(str);
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("pushNotificationRefused", a.a(pushMessage, str), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void a(PushMessage pushMessage) {
        String str;
        Content content;
        k.c(pushMessage, "pushMessage");
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Push Received][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str = content.getTitle()) == null) {
            str = "";
        }
        sb.append(str);
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("pushNotificationReceived", a.a(pushMessage), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void a(PushMessage pushMessage, boolean z) {
        String str;
        Content content;
        k.c(pushMessage, "pushMessage");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        k.c(pushMessage, "pushMessage");
        HashMap<String, Object> a2 = a.a(pushMessage);
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str = content.getSound()) == null) {
            str = "";
        }
        a2.put("sound", str);
        a2.put("isCustomSoundFound", Boolean.valueOf(z));
        b.C0745b.a(new SignalEvent("pushNotificationSoundPlayed", a2, 100));
    }

    public final void b(PushMessage pushMessage) {
        k.c(pushMessage, "pushMessage");
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Silent Push Received][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("silentPushReceived", a.a(pushMessage), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void b() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        g gVar = this.f43063b;
        k.a((Object) instance, "cal");
        Date time = instance.getTime();
        k.a((Object) time, "cal.time");
        gVar.a(time.getTime());
    }

    public final void c(PushMessage pushMessage, String str) {
        String str2;
        Content content;
        k.c(pushMessage, "pushMessage");
        k.c(str, Item.KEY_REASON);
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Push disabled][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str2 = content.getTitle()) == null) {
            str2 = "";
        }
        sb.append(str2);
        com.paytm.notification.b.a.d(sb.toString());
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("pushNotificationDisabled", a.a(pushMessage, str), 100));
    }

    public final void a(PaytmInbox paytmInbox) {
        k.c(paytmInbox, "paytmInbox");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("inboxNotificationImpression", a.a(paytmInbox), 100));
    }

    public final void b(PaytmInbox paytmInbox) {
        k.c(paytmInbox, "paytmInbox");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("inboxNotificationClicked", a.a(paytmInbox), 100));
    }

    public final void a(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("inboxNotificationPulled", a.a(str, str2), 100));
    }

    public final void a() {
        b.C0745b bVar = b.f43594e;
        b.C0745b.a();
    }

    public final void e(PushMessage pushMessage) {
        String str;
        Content content;
        k.c(pushMessage, "pushMessage");
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        StringBuilder sb = new StringBuilder("[Duplicate Push Received][p:");
        String pushId = pushMessage.getPushId();
        if (pushId == null) {
            pushId = H5BridgeContext.INVALID_ID;
        }
        sb.append(pushId);
        sb.append(" m:");
        String messageId = pushMessage.getMessageId();
        if (messageId == null) {
            messageId = H5BridgeContext.INVALID_ID;
        }
        sb.append(messageId);
        sb.append(" n:");
        Integer notificationId = pushMessage.getNotificationId();
        if (notificationId == null) {
            notificationId = H5BridgeContext.INVALID_ID;
        }
        sb.append(notificationId);
        sb.append("] ");
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str = content.getTitle()) == null) {
            str = "";
        }
        sb.append(str);
        com.paytm.notification.b.a.d(sb.toString());
        e.f43014a.b("DUPLICATE PUSH was found and ignored - sending analytic event duplicatePushNotificationReceived", new Object[0]);
        b.C0745b bVar = b.f43594e;
        a aVar2 = a.f43061a;
        b.C0745b.a(new SignalEvent("duplicatePushNotificationReceived", a.a(pushMessage), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void a(String str, ArrayList<String> arrayList) {
        k.c(str, "pushId");
        k.c(arrayList, "log");
        b.C0745b bVar = b.f43594e;
        a aVar = a.f43061a;
        b.C0745b.a(new SignalEvent("activityLog", a.a(str, arrayList), 100));
        b.C0745b bVar2 = b.f43594e;
        b.C0745b.a();
    }

    public final void a(i iVar) {
        k.c(iVar, "notificationData");
        this.f43063b.a(iVar);
    }

    public final List<i> c() {
        return this.f43063b.a();
    }

    public final void a(int i2, int i3) {
        e.f43014a.a("Notification status changed to ".concat(String.valueOf(i3)), new Object[0]);
        this.f43063b.a(i2, i3);
    }

    public final int d() {
        return com.paytm.notification.data.datasource.b.f43089a.a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
