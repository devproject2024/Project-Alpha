package com.paytm.android.chat.utils;

import com.paytm.android.chat.b.c;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.m.p;

public final class ChatConfigUtil {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final kotlin.g instance$delegate = h.a(a.INSTANCE);
    private final String TYPE_CONSUMER = "CONSUMER";
    private final String TYPE_P4B = "P4B";
    private final com.paytm.android.chat.b.b activeChatFilterConfig = new com.paytm.android.chat.b.b("");
    public com.paytm.android.chat.b.a chatConfig;

    public final String getActiveSiteID() {
        return "1";
    }

    public final String getTYPE_P4B() {
        return this.TYPE_P4B;
    }

    public final String getTYPE_CONSUMER() {
        return this.TYPE_CONSUMER;
    }

    public final com.paytm.android.chat.b.b getActiveChatFilterConfig() {
        return this.activeChatFilterConfig;
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f42315a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final ChatConfigUtil f42316b = new ChatConfigUtil();

        private b() {
        }

        public static ChatConfigUtil a() {
            return f42316b;
        }
    }

    public final com.paytm.android.chat.b.a getChatConfig() {
        com.paytm.android.chat.b.a aVar = this.chatConfig;
        if (aVar == null) {
            k.a("chatConfig");
        }
        return aVar;
    }

    public final void setChatConfig(com.paytm.android.chat.b.a aVar) {
        k.c(aVar, "<set-?>");
        this.chatConfig = aVar;
    }

    public static final class Companion {
        public final ChatConfigUtil getInstance() {
            kotlin.g access$getInstance$cp = ChatConfigUtil.instance$delegate;
            Companion companion = ChatConfigUtil.Companion;
            return (ChatConfigUtil) access$getInstance$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static final class a extends l implements kotlin.g.a.a<ChatConfigUtil> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final ChatConfigUtil invoke() {
            b bVar = b.f42315a;
            return b.a();
        }
    }

    public final boolean isP4B() {
        com.paytm.android.chat.b.a aVar = this.chatConfig;
        if (aVar == null) {
            k.a("chatConfig");
        }
        return p.a(aVar.f41774b, this.TYPE_P4B, true);
    }

    public final boolean isConsumer() {
        com.paytm.android.chat.b.a aVar = this.chatConfig;
        if (aVar == null) {
            k.a("chatConfig");
        }
        return p.a(aVar.f41774b, this.TYPE_CONSUMER, true);
    }

    public final c getActiveUIConfig() {
        com.paytm.android.chat.b.a aVar = this.chatConfig;
        if (aVar == null) {
            k.a("chatConfig");
        }
        return aVar.f41773a;
    }

    public final void setActiveStoreFilter(String str) {
        k.c(str, "userId");
        com.paytm.android.chat.b.b bVar = this.activeChatFilterConfig;
        bVar.f41775a = true;
        bVar.a(str);
    }

    public final String getActiveFilterFromRegister() {
        return SharedPreferencesUtil.getString(SharedPreferencesUtil.Key.site_id_filter, "NO_FILTER");
    }

    public final boolean isChannelFilter() {
        return k.a((Object) SharedPreferencesUtil.getString(SharedPreferencesUtil.Key.site_id_filter, "NO_FILTER"), (Object) "CHANNEL_SITE_ID_FILTER");
    }

    public final boolean isCustomerFilter() {
        return k.a((Object) SharedPreferencesUtil.getString(SharedPreferencesUtil.Key.site_id_filter, "NO_FILTER"), (Object) "CUSTOMER_SITE_ID_FILTER");
    }
}
