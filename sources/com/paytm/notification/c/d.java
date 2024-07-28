package com.paytm.notification.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f43025a = new d();

    private d() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r1.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytm.notification.data.datasource.dao.i a(com.paytm.notification.models.PushMessage r5) {
        /*
            java.lang.String r0 = "pushMessage"
            kotlin.g.b.k.c(r5, r0)
            com.paytm.notification.data.datasource.dao.i r0 = new com.paytm.notification.data.datasource.dao.i
            r0.<init>()
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            r2 = 0
            if (r1 == 0) goto L_0x001c
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.getTitle()
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            r0.f43163i = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x0030
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.getBody()
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            r0.j = r1
            java.lang.String r1 = r5.getChannelId()
            r0.m = r1
            java.lang.String r1 = r5.getCampaignId()
            r0.f43160f = r1
            com.paytm.notification.models.Context r1 = r5.getContext()
            if (r1 == 0) goto L_0x004a
            java.lang.String r1 = r1.getPushId()
            goto L_0x004b
        L_0x004a:
            r1 = r2
        L_0x004b:
            r0.f43161g = r1
            java.lang.Long r1 = r5.getReceiveTime()
            r0.n = r1
            long r3 = r5.getExpiry()
            r0.o = r3
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.f43156b = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x0072
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = r1.getType()
            if (r1 != 0) goto L_0x0074
        L_0x0072:
            java.lang.String r1 = ""
        L_0x0074:
            r0.a(r1)
            java.lang.Integer r1 = r5.getNotificationId()
            if (r1 == 0) goto L_0x0082
            int r1 = r1.intValue()
            goto L_0x0083
        L_0x0082:
            r1 = -1
        L_0x0083:
            r0.p = r1
            java.lang.String r1 = r5.getChannelId()
            r0.m = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x009c
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x009c
            java.lang.String r1 = r1.getSubText()
            goto L_0x009d
        L_0x009c:
            r1 = r2
        L_0x009d:
            r0.q = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x00b0
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x00b0
            java.lang.String r1 = r1.getIconSource()
            goto L_0x00b1
        L_0x00b0:
            r1 = r2
        L_0x00b1:
            r0.r = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x00ca
            com.paytm.notification.models.Interactive r1 = r1.getInteractive()
            if (r1 == 0) goto L_0x00ca
            com.paytm.notification.models.Click r1 = r1.getClick()
            if (r1 == 0) goto L_0x00ca
            java.lang.String r1 = r1.getValue()
            goto L_0x00cb
        L_0x00ca:
            r1 = r2
        L_0x00cb:
            r0.k = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x00e3
            com.paytm.notification.models.Interactive r1 = r1.getInteractive()
            if (r1 == 0) goto L_0x00e3
            com.paytm.notification.models.Click r1 = r1.getClick()
            if (r1 == 0) goto L_0x00e3
            java.lang.String r2 = r1.getType()
        L_0x00e3:
            r0.s = r2
            boolean r1 = r5.isRichPush()
            r0.t = r1
            com.paytm.notification.models.Notification r1 = r5.getNotification()
            if (r1 == 0) goto L_0x00fc
            com.paytm.notification.models.Content r1 = r1.getContent()
            if (r1 == 0) goto L_0x00fc
            long r1 = r1.getReceived()
            goto L_0x00fe
        L_0x00fc:
            r1 = 0
        L_0x00fe:
            r0.u = r1
            java.lang.String r1 = r5.getMessageId()
            r0.v = r1
            java.lang.Long r1 = r5.getSendTime()
            r0.x = r1
            java.lang.String r5 = r5.getSenderId()
            r0.w = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.c.d.a(com.paytm.notification.models.PushMessage):com.paytm.notification.data.datasource.dao.i");
    }
}
