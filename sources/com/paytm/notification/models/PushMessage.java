package com.paytm.notification.models;

import android.os.Bundle;
import com.google.gson.a.c;
import com.paytm.notification.c.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PushMessage {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final String FLASH = FLASH;
    /* access modifiers changed from: private */
    public static final String INBOX = INBOX;
    /* access modifiers changed from: private */
    public static final String PUSH = "push";
    /* access modifiers changed from: private */
    public static final String PUSH_INAPP = PUSH_INAPP;
    /* access modifiers changed from: private */
    public static final String SILENT = SILENT;
    private ArrayList<e.a> actions;
    private String audience;
    private String audience_type;
    private String badge;
    private String bigText;
    private Bundle bundle;
    private String campaignId;
    @c(a = "campaigns")
    private List<String> campaigns = new ArrayList();
    private String channelId;
    @c(a = "context")
    private Context context;
    private long expiry;
    private HashMap<String, String> extras;
    private boolean isRichPush;
    private Map<String, String> map;
    private String messageId;
    @c(a = "notification")
    private Notification notification;
    private int notificationIcon = -1;
    private Integer notificationId;
    private String pushId;
    private Long receiveTime = 0L;
    private Long sendTime;
    private String senderId;
    private String url;
    private String urlType;
    @c(a = "userId")
    private String userId;
    @c(a = "version")
    private int version;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getPUSH() {
            return PushMessage.PUSH;
        }

        public final String getFLASH() {
            return PushMessage.FLASH;
        }

        public final String getPUSH_INAPP() {
            return PushMessage.PUSH_INAPP;
        }

        public final String getINBOX() {
            return PushMessage.INBOX;
        }

        public final String getSILENT() {
            return PushMessage.SILENT;
        }
    }

    public final List<String> getCampaigns() {
        return this.campaigns;
    }

    public final void setCampaigns(List<String> list) {
        k.c(list, "<set-?>");
        this.campaigns = list;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setVersion(int i2) {
        this.version = i2;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public final void setNotification(Notification notification2) {
        this.notification = notification2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final Long getReceiveTime() {
        return this.receiveTime;
    }

    public final void setReceiveTime(Long l) {
        this.receiveTime = l;
    }

    public final long getExpiry() {
        return this.expiry;
    }

    public final void setExpiry(long j) {
        this.expiry = j;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public final String getBigText() {
        return this.bigText;
    }

    public final void setBigText(String str) {
        this.bigText = str;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final void setCampaignId(String str) {
        this.campaignId = str;
    }

    public final ArrayList<e.a> getActions() {
        return this.actions;
    }

    public final void setActions(ArrayList<e.a> arrayList) {
        this.actions = arrayList;
    }

    public final boolean isRichPush() {
        return this.isRichPush;
    }

    public final void setRichPush(boolean z) {
        this.isRichPush = z;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final int getNotificationIcon() {
        return this.notificationIcon;
    }

    public final void setNotificationIcon(int i2) {
        this.notificationIcon = i2;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final void setBadge(String str) {
        this.badge = str;
    }

    public final String getAudience() {
        return this.audience;
    }

    public final void setAudience(String str) {
        this.audience = str;
    }

    public final String getAudience_type() {
        return this.audience_type;
    }

    public final void setAudience_type(String str) {
        this.audience_type = str;
    }

    public final HashMap<String, String> getExtras() {
        return this.extras;
    }

    public final void setExtras(HashMap<String, String> hashMap) {
        this.extras = hashMap;
    }

    public final String getPushId() {
        return this.pushId;
    }

    public final void setPushId(String str) {
        this.pushId = str;
    }

    public final Map<String, String> getMap() {
        return this.map;
    }

    public final void setMap(Map<String, String> map2) {
        this.map = map2;
    }

    public final Integer getNotificationId() {
        return this.notificationId;
    }

    public final void setNotificationId(Integer num) {
        this.notificationId = num;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final void setSenderId(String str) {
        this.senderId = str;
    }

    public final Long getSendTime() {
        return this.sendTime;
    }

    public final void setSendTime(Long l) {
        this.sendTime = l;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getUrlType() {
        return this.urlType;
    }

    public final void setUrlType(String str) {
        this.urlType = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isSilent() {
        /*
            r2 = this;
            com.paytm.notification.models.Notification r0 = r2.notification
            if (r0 == 0) goto L_0x000f
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getType()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = SILENT
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.models.PushMessage.isSilent():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isPush() {
        /*
            r2 = this;
            com.paytm.notification.models.Notification r0 = r2.notification
            if (r0 == 0) goto L_0x000f
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getType()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = PUSH
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.models.PushMessage.isPush():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isFlash() {
        /*
            r2 = this;
            com.paytm.notification.models.Notification r0 = r2.notification
            if (r0 == 0) goto L_0x000f
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getType()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = FLASH
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.models.PushMessage.isFlash():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getContent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isInBox() {
        /*
            r2 = this;
            com.paytm.notification.models.Notification r0 = r2.notification
            if (r0 == 0) goto L_0x000f
            com.paytm.notification.models.Content r0 = r0.getContent()
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = r0.getType()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            java.lang.String r1 = INBOX
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.models.PushMessage.isInBox():boolean");
    }

    public final boolean isExpired$paytmnotification_paytmRelease() {
        long j = this.expiry;
        return j != 0 && j < new Date().getTime();
    }

    public final Bundle getPushBundle$paytmnotification_paytmRelease() {
        if (this.bundle == null) {
            this.bundle = new Bundle();
            Notification notification2 = this.notification;
            HashMap<String, String> hashMap = null;
            if ((notification2 != null ? notification2.getExtras() : null) != null) {
                Notification notification3 = this.notification;
                if (notification3 != null) {
                    hashMap = notification3.getExtras();
                }
                if (hashMap == null) {
                    k.a();
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    Bundle bundle2 = this.bundle;
                    if (bundle2 == null) {
                        k.a();
                    }
                    bundle2.putString(str, str2);
                }
            }
        }
        Bundle bundle3 = this.bundle;
        if (bundle3 == null) {
            k.a();
        }
        return bundle3;
    }

    public final String toString() {
        return "PushMessage(campaigns=" + this.campaigns + ", context=" + this.context + ", version=" + this.version + ", notification=" + this.notification + ", userId=" + this.userId + ", receiveTime=" + this.receiveTime + ", expiry=" + this.expiry + ", bundle=" + this.bundle + ", bigText=" + this.bigText + ", campaignId=" + this.campaignId + ", actions=" + this.actions + ", isRichPush=" + this.isRichPush + ", channelId=" + this.channelId + ", notificationIcon=" + this.notificationIcon + ", badge=" + this.badge + ", audience=" + this.audience + ", audience_type=" + this.audience_type + ", extras=" + this.extras + ", pushId=" + this.pushId + ", map=" + this.map + ", notificationId=" + this.notificationId + ", messageId=" + this.messageId + ", senderId=" + this.senderId + ", sendTime=" + this.sendTime + ", url=" + this.url + ", urlType=" + this.urlType + ')';
    }
}
