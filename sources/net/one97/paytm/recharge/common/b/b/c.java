package net.one97.paytm.recharge.common.b.b;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.utility.n;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.bf;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.widgets.c.d;

public final class c implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60889b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final Context f60890a;

    public c(Context context) {
        k.c(context, "context");
        this.f60890a = context;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f60891a;

            {
                this.f60891a = r1;
            }

            public final void run() {
                net.one97.paytm.recharge.common.b.a.a.a aVar = net.one97.paytm.recharge.common.b.a.a.a.f60878a;
                net.one97.paytm.recharge.common.b.a.a.a.a(this.f60891a.f60890a);
            }
        });
    }

    public static final class a extends bf<c, Context> {
        private a() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String a(String str) {
        k.c(str, "categoryId");
        ax.a aVar = ax.f61521a;
        Context applicationContext = this.f60890a.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        String b2 = ax.a.a(applicationContext).b(str, "", true);
        if (k.a((Object) b2, (Object) "")) {
            return null;
        }
        return b2;
    }

    public final void a(String str, String str2) {
        k.c(str, "categoryId");
        k.c(str2, "location");
        ax.a aVar = ax.f61521a;
        Context applicationContext = this.f60890a.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = ax.a.a(applicationContext);
        String b2 = a2.b(str, "", true);
        if (k.a((Object) b2, (Object) "") || !p.a(b2, str2, true)) {
            a2.a(str, str2, true);
        }
    }

    public final boolean a() {
        ax.a aVar = ax.f61521a;
        Context applicationContext = this.f60890a.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        String b2 = ax.a.a(applicationContext).b("sso_token=", "", true);
        if (!k.a((Object) b2, (Object) "")) {
            if (b2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public final void b(String str, String str2) {
        k.c(str, "categoryId");
        if (!TextUtils.isEmpty(str2)) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new C1174c(this, str2, str));
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.b.b.c$c  reason: collision with other inner class name */
    static final class C1174c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60900a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60901b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f60902c;

        C1174c(c cVar, String str, String str2) {
            this.f60900a = cVar;
            this.f60901b = str;
            this.f60902c = str2;
        }

        public final void run() {
            try {
                String str = this.f60901b;
                if (str != null) {
                    net.one97.paytm.recharge.common.b.a.a.a aVar = net.one97.paytm.recharge.common.b.a.a.a.f60878a;
                    Context applicationContext = this.f60900a.f60890a.getApplicationContext();
                    k.a((Object) applicationContext, "context.applicationContext");
                    net.one97.paytm.recharge.common.b.a.a.a.b(applicationContext, this.f60902c, str);
                }
                d dVar = d.f64967a;
                d.a(c.class.getSimpleName() + " updated Successfully: " + this.f60902c);
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    public final void a(String str, ai aiVar, String str2, String str3, a aVar, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new b(this, str2, aVar, str, obj));
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f60892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f60893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f60894c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f60895d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f60896e;

        b(c cVar, String str, a aVar, String str2, Object obj) {
            this.f60892a = cVar;
            this.f60893b = str;
            this.f60894c = aVar;
            this.f60895d = str2;
            this.f60896e = obj;
        }

        public final void run() {
            net.one97.paytm.recharge.common.b.a.a.a aVar = net.one97.paytm.recharge.common.b.a.a.a.f60878a;
            Context applicationContext = this.f60892a.f60890a.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            String a2 = net.one97.paytm.recharge.common.b.a.a.a.a(applicationContext, this.f60893b);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    final CJRCategoryData cJRCategoryData = (CJRCategoryData) new f().a(a2, CJRCategoryData.class);
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f60897a;

                        {
                            this.f60897a = r1;
                        }

                        public final void run() {
                            c cVar = this.f60897a.f60892a;
                            Long categoryId = cJRCategoryData.getCategoryId();
                            if (az.b(cVar.f60890a, String.valueOf(categoryId != null ? categoryId.longValue() : 0))) {
                                CJRCategoryData cJRCategoryData = cJRCategoryData;
                                k.a((Object) cJRCategoryData, "categoryData");
                                if (c.a(cJRCategoryData)) {
                                    a aVar = this.f60897a.f60894c;
                                    if (aVar != null) {
                                        String str = this.f60897a.f60895d;
                                        CJRCategoryData cJRCategoryData2 = cJRCategoryData;
                                        k.a((Object) cJRCategoryData2, "categoryData");
                                        aVar.a(str, true, cJRCategoryData2, this.f60897a.f60896e);
                                    }
                                    d dVar = d.f64967a;
                                    d.a(c.class.getSimpleName() + " retrieved successfully: " + this.f60897a.f60893b);
                                }
                            }
                            a aVar2 = this.f60897a.f60894c;
                            if (aVar2 != null) {
                                aVar2.a();
                            }
                            d dVar2 = d.f64967a;
                            d.a(c.class.getSimpleName() + " Skipped local-cached response as language has changed category:" + this.f60897a.f60893b + " previous:" + cJRCategoryData.getCachedLangId() + " current:" + n.b());
                            d dVar3 = d.f64967a;
                            d.a(c.class.getSimpleName() + " retrieved successfully: " + this.f60897a.f60893b);
                        }
                    });
                } catch (Exception unused) {
                    a aVar2 = this.f60894c;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f60899a;

                    {
                        this.f60899a = r1;
                    }

                    public final void run() {
                        a aVar = this.f60899a.f60894c;
                        if (aVar != null) {
                            aVar.a();
                        }
                        d dVar = d.f64967a;
                        d.a(c.class.getSimpleName() + " retrieved EMPTY: " + this.f60899a.f60893b);
                    }
                });
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = r5.getCategoryId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = r5.getCategoryId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0 = r5.getCategoryId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean a(net.one97.paytm.recharge.model.v4.CJRCategoryData r5) {
        /*
            java.lang.Long r0 = r5.getCategoryId()
            if (r0 != 0) goto L_0x0007
            goto L_0x0011
        L_0x0007:
            long r0 = r0.longValue()
            r2 = 17
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0044
        L_0x0011:
            java.lang.Long r0 = r5.getCategoryId()
            if (r0 != 0) goto L_0x0018
            goto L_0x0022
        L_0x0018:
            long r0 = r0.longValue()
            r2 = 21
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0044
        L_0x0022:
            java.lang.Long r0 = r5.getCategoryId()
            if (r0 != 0) goto L_0x0029
            goto L_0x0033
        L_0x0029:
            long r0 = r0.longValue()
            r2 = 19
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0044
        L_0x0033:
            java.lang.Long r0 = r5.getCategoryId()
            if (r0 != 0) goto L_0x003a
            goto L_0x004e
        L_0x003a:
            long r0 = r0.longValue()
            r2 = 23
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x004e
        L_0x0044:
            int r5 = r5.getCachedLangId()
            int r0 = com.paytm.utility.n.b()
            if (r5 != r0) goto L_0x0050
        L_0x004e:
            r5 = 1
            return r5
        L_0x0050:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.b.c.a(net.one97.paytm.recharge.model.v4.CJRCategoryData):boolean");
    }
}
