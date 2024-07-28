package com.paytm.notification.c;

import com.google.gson.internal.g;
import com.paytm.notification.b.e;
import com.paytm.notification.c.e;
import com.paytm.notification.data.datasource.dao.f;
import com.paytm.notification.models.Buttons;
import com.paytm.notification.models.FlashFetchResponse;
import com.paytm.notification.models.FlashMessage;
import com.paytm.notification.models.InboxMessageResponse;
import com.paytm.notification.models.Interactive;
import com.paytm.notification.models.Notification;
import com.paytm.notification.models.PushMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;

public final class c {

    public static final class a extends com.google.gson.b.a<HashMap<String, String>> {
    }

    public static final f a(InboxMessageResponse inboxMessageResponse, String str) {
        k.c(inboxMessageResponse, "$this$mapToInboxData");
        k.c(str, "customerId");
        f fVar = new f();
        fVar.a(str);
        fVar.f43138f = inboxMessageResponse.getContent();
        String pushId = inboxMessageResponse.getPushId();
        if (pushId == null) {
            pushId = "";
        }
        fVar.b(pushId);
        if (inboxMessageResponse.getTag() != null) {
            String tag = inboxMessageResponse.getTag();
            if (tag == null) {
                k.a();
            }
            if (k.a((Object) tag, (Object) "READ")) {
                fVar.f43133a = 1;
                fVar.f43134b = inboxMessageResponse.getReceivedDate();
                fVar.o = new Date().getTime();
                return a(inboxMessageResponse.getContent(), fVar);
            }
        }
        if (inboxMessageResponse.getTag() != null) {
            String tag2 = inboxMessageResponse.getTag();
            if (tag2 == null) {
                k.a();
            }
            if (k.a((Object) tag2, (Object) "UNREAD")) {
                fVar.f43133a = 2;
                fVar.f43134b = inboxMessageResponse.getReceivedDate();
                fVar.o = new Date().getTime();
                return a(inboxMessageResponse.getContent(), fVar);
            }
        }
        fVar.f43133a = 3;
        fVar.f43134b = inboxMessageResponse.getReceivedDate();
        fVar.o = new Date().getTime();
        return a(inboxMessageResponse.getContent(), fVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0062, code lost:
        r0 = r0.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final com.paytm.notification.data.datasource.dao.f a(java.lang.String r4, com.paytm.notification.data.datasource.dao.f r5) {
        /*
            com.google.gson.f r0 = new com.google.gson.f     // Catch:{ Exception -> 0x00ca }
            r0.<init>()     // Catch:{ Exception -> 0x00ca }
            java.lang.Class<com.paytm.notification.models.PushMessage> r1 = com.paytm.notification.models.PushMessage.class
            java.lang.Object r4 = r0.a((java.lang.String) r4, r1)     // Catch:{ Exception -> 0x00ca }
            com.paytm.notification.models.PushMessage r4 = (com.paytm.notification.models.PushMessage) r4     // Catch:{ Exception -> 0x00ca }
            if (r4 != 0) goto L_0x0014
            com.paytm.notification.models.PushMessage r4 = new com.paytm.notification.models.PushMessage     // Catch:{ Exception -> 0x00ca }
            r4.<init>()     // Catch:{ Exception -> 0x00ca }
        L_0x0014:
            if (r4 != 0) goto L_0x0017
            return r5
        L_0x0017:
            com.paytm.notification.models.Notification r0 = r4.getNotification()     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x002b
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x002b
            java.lang.String r0 = r0.getInboxTitle()     // Catch:{ Exception -> 0x00ca }
            if (r0 != 0) goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            r5.c(r0)     // Catch:{ Exception -> 0x00ca }
            com.paytm.notification.models.Notification r0 = r4.getNotification()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x0041
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.getBody()     // Catch:{ Exception -> 0x00ca }
            if (r0 != 0) goto L_0x0042
        L_0x0041:
            r0 = r1
        L_0x0042:
            r5.d(r0)     // Catch:{ Exception -> 0x00ca }
            com.paytm.notification.models.Notification r0 = r4.getNotification()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x0057
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x00ca }
            if (r0 != 0) goto L_0x0058
        L_0x0057:
            r0 = r1
        L_0x0058:
            r5.e(r0)     // Catch:{ Exception -> 0x00ca }
            com.paytm.notification.models.Notification r0 = r4.getNotification()     // Catch:{ Exception -> 0x00ca }
            r1 = 0
            if (r0 == 0) goto L_0x006d
            com.paytm.notification.models.Content r0 = r0.getContent()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = r0.getIconSource()     // Catch:{ Exception -> 0x00ca }
            goto L_0x006e
        L_0x006d:
            r0 = r1
        L_0x006e:
            r5.m = r0     // Catch:{ Exception -> 0x00ca }
            com.paytm.notification.models.Notification r0 = r4.getNotification()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x007b
            java.util.HashMap r0 = r0.getExtras()     // Catch:{ Exception -> 0x00ca }
            goto L_0x007c
        L_0x007b:
            r0 = r1
        L_0x007c:
            if (r0 == 0) goto L_0x0093
            com.google.gson.f r0 = new com.google.gson.f     // Catch:{ Exception -> 0x00ca }
            r0.<init>()     // Catch:{ Exception -> 0x00ca }
            com.paytm.notification.models.Notification r2 = r4.getNotification()     // Catch:{ Exception -> 0x00ca }
            if (r2 == 0) goto L_0x008d
            java.util.HashMap r1 = r2.getExtras()     // Catch:{ Exception -> 0x00ca }
        L_0x008d:
            java.lang.String r0 = r0.b(r1)     // Catch:{ Exception -> 0x00ca }
            r5.f43139g = r0     // Catch:{ Exception -> 0x00ca }
        L_0x0093:
            java.util.List r4 = r4.getCampaigns()     // Catch:{ Exception -> 0x00ca }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ Exception -> 0x00ca }
            r0 = 0
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00ca }
        L_0x009e:
            boolean r1 = r4.hasNext()     // Catch:{ Exception -> 0x00ca }
            if (r1 == 0) goto L_0x00d2
            java.lang.Object r1 = r4.next()     // Catch:{ Exception -> 0x00ca }
            int r2 = r0 + 1
            if (r0 >= 0) goto L_0x00af
            kotlin.a.k.a()     // Catch:{ Exception -> 0x00ca }
        L_0x00af:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00ca }
            if (r0 != 0) goto L_0x00b6
            r5.p = r1     // Catch:{ Exception -> 0x00ca }
            goto L_0x00c8
        L_0x00b6:
            java.lang.String r0 = r5.p     // Catch:{ Exception -> 0x00ca }
            java.lang.String r3 = ":"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r1 = r3.concat(r1)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = kotlin.g.b.k.a((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x00ca }
            r5.p = r0     // Catch:{ Exception -> 0x00ca }
        L_0x00c8:
            r0 = r2
            goto L_0x009e
        L_0x00ca:
            r4 = move-exception
            com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r0.b(r4)
        L_0x00d2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.c.c.a(java.lang.String, com.paytm.notification.data.datasource.dao.f):com.paytm.notification.data.datasource.dao.f");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r1.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.paytm.notification.data.datasource.dao.c a(com.paytm.notification.models.PushMessage r6) throws java.lang.Exception {
        /*
            java.lang.String r0 = "$this$mapToFlashData"
            kotlin.g.b.k.c(r6, r0)
            com.paytm.notification.data.datasource.dao.c r0 = new com.paytm.notification.data.datasource.dao.c
            r0.<init>()
            com.paytm.notification.models.Notification r1 = r6.getNotification()
            r2 = 0
            if (r1 == 0) goto L_0x001c
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.getTitle()
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            r0.f43118h = r1
            com.paytm.notification.models.Notification r1 = r6.getNotification()
            if (r1 == 0) goto L_0x0030
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.getBody()
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            r0.f43119i = r1
            java.lang.String r1 = r6.getCampaignId()
            r0.f43115e = r1
            com.paytm.notification.models.Context r1 = r6.getContext()
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r1.getPushId()
            if (r1 != 0) goto L_0x0048
        L_0x0047:
            r1 = r3
        L_0x0048:
            r0.a(r1)
            java.lang.Long r1 = r6.getReceiveTime()
            r0.l = r1
            long r4 = r6.getExpiry()
            r0.m = r4
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.f43112b = r1
            com.paytm.notification.models.PushMessage$Companion r1 = com.paytm.notification.models.PushMessage.Companion
            java.lang.String r1 = r1.getFLASH()
            r0.b(r1)
            java.lang.Integer r1 = r6.getNotificationId()
            r4 = -1
            if (r1 == 0) goto L_0x0073
            int r1 = r1.intValue()
            goto L_0x0074
        L_0x0073:
            r1 = -1
        L_0x0074:
            r0.n = r1
            java.lang.String r1 = r6.getUserId()
            if (r1 != 0) goto L_0x007d
            r1 = r3
        L_0x007d:
            r0.c(r1)
            r1 = 1
            r0.f43113c = r1
            com.paytm.notification.models.Notification r1 = r6.getNotification()
            if (r1 == 0) goto L_0x0093
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x0093
            int r4 = r1.getDuration()
        L_0x0093:
            r0.r = r4
            com.google.gson.f r1 = new com.google.gson.f
            r1.<init>()
            com.paytm.notification.models.Notification r3 = r6.getNotification()
            if (r3 == 0) goto L_0x00a5
            java.util.HashMap r3 = r3.getExtras()
            goto L_0x00a6
        L_0x00a5:
            r3 = r2
        L_0x00a6:
            java.lang.String r1 = r1.b(r3)
            r0.k = r1
            com.google.gson.f r1 = new com.google.gson.f
            r1.<init>()
            java.util.ArrayList r3 = r6.getActions()
            java.lang.String r1 = r1.b(r3)
            r0.t = r1
            com.paytm.notification.models.Notification r6 = r6.getNotification()
            if (r6 == 0) goto L_0x00cb
            com.paytm.notification.models.Content r6 = r6.getContent()
            if (r6 == 0) goto L_0x00cb
            java.lang.String r2 = r6.getPosition()
        L_0x00cb:
            r0.v = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.c.c.a(com.paytm.notification.models.PushMessage):com.paytm.notification.data.datasource.dao.c");
    }

    public static final FlashMessage a(com.paytm.notification.data.datasource.dao.c cVar) {
        k.c(cVar, "$this$mapToFlashMessage");
        FlashMessage flashMessage = new FlashMessage();
        flashMessage.setNotificationType(cVar.f43117g);
        flashMessage.setCampaignId(cVar.f43115e);
        flashMessage.setTitle(cVar.f43118h);
        flashMessage.setMessage(cVar.f43119i);
        flashMessage.setPushId(cVar.f43116f);
        flashMessage.setExpiry(cVar.m);
        flashMessage.setPriority(cVar.f43112b);
        flashMessage.setNotificationId(Integer.valueOf(cVar.n));
        flashMessage.setCustomerId(cVar.s);
        flashMessage.setPosition(cVar.v);
        flashMessage.setDisplayTime(Long.valueOf(new Date().getTime()));
        flashMessage.setReceiveTime(cVar.l);
        if (cVar.k != null) {
            Object a2 = new com.google.gson.f().a(cVar.k, HashMap.class);
            if (!(a2 instanceof HashMap)) {
                a2 = null;
            }
            flashMessage.setExtras((HashMap) a2);
        }
        try {
            if (cVar.t != null) {
                Object a3 = new com.google.gson.f().a(cVar.t, HashMap.class);
                if (!(a3 instanceof HashMap)) {
                    a3 = null;
                }
                HashMap hashMap = (HashMap) a3;
                if (hashMap != null) {
                    flashMessage.setActions(new HashMap());
                    for (Map.Entry entry : hashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        g gVar = (g) entry.getValue();
                        HashMap<String, String> actions = flashMessage.getActions();
                        if (actions != null) {
                            actions.put(str, ae.b(gVar, "url"));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
        flashMessage.setDisplayPeriodInSecs(cVar.r);
        return flashMessage;
    }

    public static final com.paytm.notification.data.datasource.dao.c a(FlashFetchResponse flashFetchResponse) {
        PushMessage pushMessage;
        PushMessage b2;
        k.c(flashFetchResponse, "$this$mapToFlash");
        if (flashFetchResponse.getContent() == null || (pushMessage = (PushMessage) new com.google.gson.f().a(flashFetchResponse.getContent(), PushMessage.class)) == null || (b2 = b(pushMessage)) == null) {
            return null;
        }
        return a(b2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.paytm.notification.models.PushMessage b(com.paytm.notification.models.PushMessage r6) {
        /*
            java.lang.String r0 = "$this$setDefaultValue"
            kotlin.g.b.k.c(r6, r0)
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x0016
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x0016
            long r0 = r0.getReceived()
            goto L_0x001f
        L_0x0016:
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            long r0 = r0.getTime()
        L_0x001f:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r6.setReceiveTime(r0)
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x004a
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x004a
            com.paytm.notification.models.Notification r2 = r6.getNotification()
            if (r2 == 0) goto L_0x0046
            com.paytm.notification.models.Content r2 = r2.getContent()
            if (r2 == 0) goto L_0x0046
            java.lang.String r2 = r2.getTitle()
            if (r2 != 0) goto L_0x0047
        L_0x0046:
            r2 = r1
        L_0x0047:
            r0.setTitle(r2)
        L_0x004a:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x006c
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x006c
            com.paytm.notification.models.Notification r2 = r6.getNotification()
            if (r2 == 0) goto L_0x0068
            com.paytm.notification.models.Content r2 = r2.getContent()
            if (r2 == 0) goto L_0x0068
            java.lang.String r2 = r2.getBody()
            if (r2 != 0) goto L_0x0069
        L_0x0068:
            r2 = r1
        L_0x0069:
            r0.setBody(r2)
        L_0x006c:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x008f
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x008f
            com.paytm.notification.models.Notification r2 = r6.getNotification()
            if (r2 == 0) goto L_0x008c
            com.paytm.notification.models.Content r2 = r2.getContent()
            if (r2 == 0) goto L_0x008c
            java.lang.String r2 = r2.getType()
            if (r2 != 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r1 = r2
        L_0x008c:
            r0.setType(r1)
        L_0x008f:
            com.paytm.notification.models.Context r0 = r6.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x009b
            java.lang.Boolean r0 = r0.getSilent()
            goto L_0x009c
        L_0x009b:
            r0 = r1
        L_0x009c:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x00aa
            java.lang.String r0 = r6.getBadge()
            if (r0 == 0) goto L_0x00e9
        L_0x00aa:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 != 0) goto L_0x00b8
            com.paytm.notification.models.Notification r0 = new com.paytm.notification.models.Notification
            r0.<init>()
            r6.setNotification(r0)
        L_0x00b8:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 != 0) goto L_0x00c1
            kotlin.g.b.k.a()
        L_0x00c1:
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 != 0) goto L_0x00d8
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 != 0) goto L_0x00d0
            kotlin.g.b.k.a()
        L_0x00d0:
            com.paytm.notification.models.Content r2 = new com.paytm.notification.models.Content
            r2.<init>()
            r0.setContent(r2)
        L_0x00d8:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x00e9
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x00e9
            java.lang.String r2 = "silent"
            r0.setType(r2)
        L_0x00e9:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x010a
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x010a
            com.paytm.notification.models.Notification r2 = r6.getNotification()
            if (r2 == 0) goto L_0x0106
            com.paytm.notification.models.Content r2 = r2.getContent()
            if (r2 == 0) goto L_0x0106
            int r2 = r2.getDuration()
            goto L_0x0107
        L_0x0106:
            r2 = -1
        L_0x0107:
            r0.setDuration(r2)
        L_0x010a:
            com.paytm.notification.c.a r0 = com.paytm.notification.c.a.f43021a
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x011d
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x011d
            java.lang.String r0 = r0.getExpiry()
            goto L_0x011e
        L_0x011d:
            r0 = r1
        L_0x011e:
            long r2 = com.paytm.notification.c.a.a((java.lang.String) r0)
            r6.setExpiry(r2)
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x0130
            java.util.HashMap r0 = r0.getExtras()
            goto L_0x0131
        L_0x0130:
            r0 = r1
        L_0x0131:
            if (r0 == 0) goto L_0x0142
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x013e
            java.util.HashMap r0 = r0.getExtras()
            goto L_0x013f
        L_0x013e:
            r0 = r1
        L_0x013f:
            r6.setExtras(r0)
        L_0x0142:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x0164
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x0164
            com.paytm.notification.models.Notification r2 = r6.getNotification()
            if (r2 == 0) goto L_0x015f
            com.paytm.notification.models.Content r2 = r2.getContent()
            if (r2 == 0) goto L_0x015f
            long r2 = r2.getReceived()
            goto L_0x0161
        L_0x015f:
            r2 = 0
        L_0x0161:
            r0.setReceived(r2)
        L_0x0164:
            com.paytm.notification.models.Context r0 = r6.getContext()
            if (r0 == 0) goto L_0x016f
            java.lang.String r0 = r0.getPushId()
            goto L_0x0170
        L_0x016f:
            r0 = r1
        L_0x0170:
            r6.setPushId(r0)
            java.util.List r0 = r6.getCampaigns()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            java.util.Iterator r0 = r0.iterator()
        L_0x017e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01ae
            java.lang.Object r3 = r0.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x018f
            kotlin.a.k.a()
        L_0x018f:
            java.lang.String r3 = (java.lang.String) r3
            if (r2 != 0) goto L_0x0197
            r6.setCampaignId(r3)
            goto L_0x01ac
        L_0x0197:
            java.lang.String r2 = r6.getCampaignId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = ":"
            java.lang.String r3 = r5.concat(r3)
            java.lang.String r2 = kotlin.g.b.k.a((java.lang.String) r2, (java.lang.Object) r3)
            r6.setCampaignId(r2)
        L_0x01ac:
            r2 = r4
            goto L_0x017e
        L_0x01ae:
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x01c5
            com.paytm.notification.models.Interactive r0 = r0.getInteractive()
            if (r0 == 0) goto L_0x01c5
            com.paytm.notification.models.Click r0 = r0.getClick()
            if (r0 == 0) goto L_0x01c5
            java.lang.String r0 = r0.getValue()
            goto L_0x01c6
        L_0x01c5:
            r0 = r1
        L_0x01c6:
            r6.setUrl(r0)
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x01e0
            com.paytm.notification.models.Interactive r0 = r0.getInteractive()
            if (r0 == 0) goto L_0x01e0
            com.paytm.notification.models.Click r0 = r0.getClick()
            if (r0 == 0) goto L_0x01e0
            java.lang.String r0 = r0.getType()
            goto L_0x01e1
        L_0x01e0:
            r0 = r1
        L_0x01e1:
            r6.setUrlType(r0)
            java.util.ArrayList r0 = c(r6)
            r6.setActions(r0)
            com.paytm.notification.models.Notification r0 = r6.getNotification()
            if (r0 == 0) goto L_0x01fb
            com.paytm.notification.models.Interactive r0 = r0.getInteractive()
            if (r0 == 0) goto L_0x01fb
            java.util.List r1 = r0.getButtons()
        L_0x01fb:
            if (r1 == 0) goto L_0x0201
            r0 = 1
            r6.setRichPush(r0)
        L_0x0201:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.c.c.b(com.paytm.notification.models.PushMessage):com.paytm.notification.models.PushMessage");
    }

    private static final ArrayList<e.a> c(PushMessage pushMessage) {
        Interactive interactive;
        List<Buttons> buttons;
        ArrayList<e.a> arrayList = new ArrayList<>();
        Notification notification = pushMessage.getNotification();
        if (!(notification == null || (interactive = notification.getInteractive()) == null || (buttons = interactive.getButtons()) == null)) {
            for (Buttons buttons2 : buttons) {
                arrayList.add(new e.a(buttons2.getDisplay(), buttons2.getValue(), buttons2.getType()));
            }
        }
        return arrayList;
    }
}
