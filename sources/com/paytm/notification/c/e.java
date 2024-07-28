package com.paytm.notification.c;

import com.google.gson.f;
import com.paytm.notification.models.PushMessage;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Map;
import kotlin.g.b.k;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f43026a = new e();

    private e() {
    }

    public static PushMessage a(Map<String, String> map) throws Exception {
        k.c(map, Item.CTA_URL_TYPE_MAP);
        PushMessage pushMessage = (PushMessage) new f().a(String.valueOf(map.get("payload")), PushMessage.class);
        if (pushMessage == null) {
            pushMessage = new PushMessage();
        }
        pushMessage.setBadge(map.get("badge"));
        pushMessage.setAudience(map.get("audience"));
        pushMessage.setAudience_type(map.get("audience_type"));
        PushMessage b2 = c.b(pushMessage);
        pushMessage.setMap(map);
        return b2;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f43027a;

        /* renamed from: b  reason: collision with root package name */
        private String f43028b;

        /* renamed from: c  reason: collision with root package name */
        private String f43029c;

        public a(String str, String str2, String str3) {
            k.c(str, "display");
            this.f43027a = str;
            this.f43028b = str2;
            this.f43029c = str3;
        }
    }
}
