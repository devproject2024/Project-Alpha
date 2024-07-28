package net.one97.paytm.chat;

import android.content.BroadcastReceiver;

public final class SendBirdNotificationReceiver extends BroadcastReceiver {
    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|(3:18|19|(2:21|(2:25|(2:27|(2:29|(1:31)))(1:44)))(2:32|33))|34|35|37) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00db */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x00e0
            if (r7 == 0) goto L_0x00e0
            java.lang.String r0 = "remote_message"
            android.os.Parcelable r7 = r7.getParcelableExtra(r0)
            com.google.firebase.messaging.RemoteMessage r7 = (com.google.firebase.messaging.RemoteMessage) r7
            if (r7 == 0) goto L_0x00e0
            android.content.Context r0 = r6.getApplicationContext()     // Catch:{ Exception -> 0x00e0 }
            boolean r1 = r0 instanceof android.app.Application     // Catch:{ Exception -> 0x00e0 }
            if (r1 != 0) goto L_0x0017
            r0 = 0
        L_0x0017:
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ Exception -> 0x00e0 }
            if (r0 == 0) goto L_0x0020
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x00e0 }
            com.paytm.android.chat.utils.AppUtilKt.reInitializeChatManager(r0)     // Catch:{ Exception -> 0x00e0 }
        L_0x0020:
            com.google.gson.f r0 = new com.google.gson.f     // Catch:{ Exception -> 0x00e0 }
            r0.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.util.Map r7 = r7.b()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = "sendbird"
            java.lang.Object r7 = r7.get(r1)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00e0 }
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.PushBean> r1 = com.paytm.android.chat.bean.jsonbean.PushBean.class
            java.lang.Object r7 = r0.a((java.lang.String) r7, r1)     // Catch:{ Exception -> 0x00e0 }
            com.paytm.android.chat.bean.jsonbean.PushBean r7 = (com.paytm.android.chat.bean.jsonbean.PushBean) r7     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = "pushBean"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)     // Catch:{ Exception -> 0x00e0 }
            com.paytm.android.chat.bean.jsonbean.PushBean$ChannelBean r1 = r7.getChannel()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r2 = "pushBean.channel"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = r1.getChannel_url()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r2 = r7.getType()     // Catch:{ Exception -> 0x00e0 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00e0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00e0 }
            if (r1 != 0) goto L_0x00e0
            com.paytm.android.chat.bean.jsonbean.PushBean$SenderBean r1 = r7.getSender()     // Catch:{ Exception -> 0x00e0 }
            if (r1 != 0) goto L_0x005f
            goto L_0x00e0
        L_0x005f:
            java.lang.String r1 = "MESG"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)     // Catch:{ Exception -> 0x00e0 }
            if (r1 == 0) goto L_0x00db
            java.lang.String r1 = r7.getMessage()     // Catch:{ Exception -> 0x00db }
            java.lang.Class<com.sendbird.android.BaseMessage> r2 = com.sendbird.android.BaseMessage.class
            java.lang.Object r1 = r0.a((java.lang.String) r1, r2)     // Catch:{ Exception -> 0x00db }
            java.lang.String r2 = "gson.fromJson<BaseMessag… BaseMessage::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x00db }
            com.sendbird.android.BaseMessage r1 = (com.sendbird.android.BaseMessage) r1     // Catch:{ Exception -> 0x00db }
            java.lang.String r2 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()     // Catch:{ Exception -> 0x00db }
            if (r1 == 0) goto L_0x00d3
            r3 = r1
            com.sendbird.android.UserMessage r3 = (com.sendbird.android.UserMessage) r3     // Catch:{ Exception -> 0x00db }
            com.sendbird.android.Sender r3 = r3.getSender()     // Catch:{ Exception -> 0x00db }
            java.lang.String r4 = "(baseMessage as UserMessage).sender"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r3.getUserId()     // Catch:{ Exception -> 0x00db }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x00db }
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x00db
            java.lang.String r2 = "TRANSFER"
            java.lang.String r3 = r1.getCustomType()     // Catch:{ Exception -> 0x00db }
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x00db }
            if (r2 == 0) goto L_0x00db
            r2 = r1
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2     // Catch:{ Exception -> 0x00db }
            com.sendbird.android.UserMessage$RequestState r2 = r2.getRequestState()     // Catch:{ Exception -> 0x00db }
            com.sendbird.android.UserMessage$RequestState r3 = com.sendbird.android.UserMessage.RequestState.SUCCEEDED     // Catch:{ Exception -> 0x00db }
            if (r2 != r3) goto L_0x00e0
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r2 = new com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel     // Catch:{ Exception -> 0x00db }
            r2.<init>()     // Catch:{ Exception -> 0x00db }
            java.lang.String r1 = r1.getData()     // Catch:{ Exception -> 0x00db }
            java.lang.Class<com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean> r3 = com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean.class
            java.lang.Object r0 = r0.a((java.lang.String) r1, r3)     // Catch:{ Exception -> 0x00db }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r0 = (com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean) r0     // Catch:{ Exception -> 0x00db }
            r2.bean = r0     // Catch:{ Exception -> 0x00db }
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r0 = r2.bean     // Catch:{ Exception -> 0x00db }
            if (r0 == 0) goto L_0x00db
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r0 = r2.bean     // Catch:{ Exception -> 0x00db }
            java.lang.String r1 = "uiBean.bean"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x00db }
            int r0 = r0.getStatus()     // Catch:{ Exception -> 0x00db }
            if (r0 == 0) goto L_0x00db
            return
        L_0x00d3:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x00db }
            java.lang.String r1 = "null cannot be cast to non-null type com.sendbird.android.UserMessage"
            r0.<init>(r1)     // Catch:{ Exception -> 0x00db }
            throw r0     // Catch:{ Exception -> 0x00db }
        L_0x00db:
            com.paytm.android.chat.utils.ChatNotificationHelper r0 = com.paytm.android.chat.utils.ChatNotificationHelper.INSTANCE     // Catch:{ Exception -> 0x00e0 }
            r0.postNotification(r6, r7)     // Catch:{ Exception -> 0x00e0 }
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.chat.SendBirdNotificationReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
