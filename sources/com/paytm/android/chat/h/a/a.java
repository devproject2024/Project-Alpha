package com.paytm.android.chat.h.a;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.h.c;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;

public final class a implements al.b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0701a f42178a = new C0701a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static a f42179e;

    /* renamed from: b  reason: collision with root package name */
    private final g f42180b = h.a(b.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    private final Application f42181c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42182d;

    private ChatRepository b() {
        return (ChatRepository) this.f42180b.getValue();
    }

    public a(Application application, String str) {
        k.c(application, "application");
        k.c(str, "appID");
        this.f42181c = application;
        this.f42182d = str;
    }

    static final class b extends l implements kotlin.g.a.a<ChatRepository> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        public final ChatRepository invoke() {
            ChatManager b2 = ChatManager.b();
            k.a((Object) b2, "ChatManager.getInstance()");
            return b2.a();
        }
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (k.a((Object) cls, (Object) com.paytm.android.chat.h.a.class)) {
            return (ai) new com.paytm.android.chat.h.a(b());
        }
        if (k.a((Object) cls, (Object) c.class)) {
            return (ai) new c(b());
        }
        throw new UnsupportedOperationException("Can't create ViewModel of type " + cls.getCanonicalName());
    }

    /* renamed from: com.paytm.android.chat.h.a.a$a  reason: collision with other inner class name */
    public static final class C0701a {
        private C0701a() {
        }

        public /* synthetic */ C0701a(byte b2) {
            this();
        }

        public static a a(Application application, String str) {
            k.c(application, "application");
            k.c(str, "appID");
            if (a.f42179e == null) {
                a.f42179e = new a(application, str);
            }
            a a2 = a.f42179e;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
