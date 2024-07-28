package net.one97.paytm.feed.repository.a;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f34361a = {y.a((v) new w(y.b(a.class), "requestQueue", "getRequestQueue()Lcom/android/volley/RequestQueue;"))};

    /* renamed from: b  reason: collision with root package name */
    public static final C0562a f34362b = new C0562a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f34363d;

    /* renamed from: c  reason: collision with root package name */
    private final g f34364c;

    public final RequestQueue a() {
        return (RequestQueue) this.f34364c.getValue();
    }

    /* renamed from: net.one97.paytm.feed.repository.a.a$a  reason: collision with other inner class name */
    public static final class C0562a {
        private C0562a() {
        }

        public /* synthetic */ C0562a(byte b2) {
            this();
        }

        public final a a(Context context) {
            a b2;
            k.c(context, "context");
            a b3 = a.f34363d;
            if (b3 != null) {
                return b3;
            }
            synchronized (this) {
                b2 = a.f34363d;
                if (b2 == null) {
                    b2 = new a(context);
                }
            }
            return b2;
        }
    }

    public a(Context context) {
        k.c(context, "context");
        this.f34364c = h.a(new b(context));
    }

    static final class b extends l implements kotlin.g.a.a<RequestQueue> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.$context = context;
        }

        public final RequestQueue invoke() {
            return Volley.newRequestQueue(this.$context.getApplicationContext());
        }
    }

    public final <T> void a(Request<T> request) {
        k.c(request, "req");
        a().add(request);
    }

    public final <T> void a(Request<T> request, String str) {
        k.c(request, "req");
        k.c(str, "tag");
        request.setTag(str);
        a().add(request);
    }
}
