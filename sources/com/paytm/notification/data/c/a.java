package com.paytm.notification.data.c;

import com.paytm.notification.data.datasource.dao.i;
import com.paytm.notification.models.Content;
import com.paytm.notification.models.Context;
import com.paytm.notification.models.Notification;
import com.paytm.notification.models.PaytmInbox;
import com.paytm.notification.models.PushMessage;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43061a = new a();

    private a() {
    }

    public static Map<String, Object> a(String str, ArrayList<String> arrayList) {
        k.c(str, "pushId");
        k.c(arrayList, "log");
        HashMap hashMap = new HashMap();
        hashMap.put("pushId", str);
        hashMap.put("log", arrayList);
        return hashMap;
    }

    public static Map<String, Object> a(PushMessage pushMessage, String str) {
        k.c(pushMessage, "pushMessage");
        k.c(str, Item.KEY_REASON);
        HashMap<String, Object> a2 = a(pushMessage);
        a2.put(Item.KEY_REASON, str);
        return a2;
    }

    public static HashMap<String, Object> a(PushMessage pushMessage) {
        Object obj;
        String str;
        Content content;
        k.c(pushMessage, "pushMessage");
        HashMap<String, Object> hashMap = new HashMap<>();
        String campaignId = pushMessage.getCampaignId();
        if (campaignId == null) {
            campaignId = -1;
        }
        hashMap.put("campaignId", campaignId);
        Context context = pushMessage.getContext();
        if (context == null || (obj = context.getPushId()) == null) {
            obj = -1;
        }
        hashMap.put("pushId", obj);
        Notification notification = pushMessage.getNotification();
        if (notification == null || (content = notification.getContent()) == null || (str = content.getType()) == null) {
            str = "";
        }
        hashMap.put("pushType", str);
        if (pushMessage.isSilent()) {
            hashMap.put("isSilent", Boolean.valueOf(pushMessage.isSilent()));
        }
        if (pushMessage.getMessageId() != null) {
            String messageId = pushMessage.getMessageId();
            if (messageId == null) {
                k.a();
            }
            hashMap.put("msgId", messageId);
        }
        if (pushMessage.getSenderId() != null) {
            String senderId = pushMessage.getSenderId();
            if (senderId == null) {
                k.a();
            }
            hashMap.put("senderId", senderId);
        }
        if (pushMessage.getSendTime() != null) {
            Long sendTime = pushMessage.getSendTime();
            if (sendTime == null) {
                k.a();
            }
            hashMap.put("sendTime", sendTime);
        }
        return hashMap;
    }

    public static HashMap<String, Object> a(i iVar) {
        k.c(iVar, "notificationData");
        HashMap<String, Object> hashMap = new HashMap<>();
        Object obj = iVar.f43160f;
        if (obj == null) {
            obj = -1;
        }
        hashMap.put("campaignId", obj);
        Object obj2 = iVar.f43161g;
        if (obj2 == null) {
            obj2 = -1;
        }
        hashMap.put("pushId", obj2);
        String str = iVar.f43162h;
        if (str == null) {
            str = "";
        }
        hashMap.put("pushType", str);
        if (iVar.v != null) {
            String str2 = iVar.v;
            if (str2 == null) {
                k.a();
            }
            hashMap.put("msgId", str2);
        }
        if (iVar.w != null) {
            String str3 = iVar.w;
            if (str3 == null) {
                k.a();
            }
            hashMap.put("senderId", str3);
        }
        if (iVar.x != null) {
            Long l = iVar.x;
            if (l == null) {
                k.a();
            }
            hashMap.put("sendTime", l);
        }
        return hashMap;
    }

    public static Map<String, Object> a(PaytmInbox paytmInbox) {
        k.c(paytmInbox, "paytmInbox");
        HashMap hashMap = new HashMap();
        String pushId = paytmInbox.getPushId();
        if (pushId == null) {
            pushId = "";
        }
        hashMap.put("pushId", pushId);
        String campaignId = paytmInbox.getCampaignId();
        if (campaignId == null) {
            campaignId = "";
        }
        hashMap.put("campaignId", campaignId);
        return hashMap;
    }

    public static Map<String, Object> a(String str, String str2) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        HashMap hashMap = new HashMap();
        hashMap.put("pushId", str);
        hashMap.put("campaignId", str2);
        return hashMap;
    }

    public static Map<String, Object> a(String str, String str2, String str3) {
        k.c(str, "pushId");
        k.c(str2, "campaignId");
        k.c(str3, Item.KEY_REASON);
        HashMap hashMap = new HashMap();
        hashMap.put("pushId", str);
        hashMap.put("campaignId", str2);
        hashMap.put(Item.KEY_REASON, str3);
        return hashMap;
    }
}
