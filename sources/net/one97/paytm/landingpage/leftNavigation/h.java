package net.one97.paytm.landingpage.leftNavigation;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.common.b.d;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f52857a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final String f52858b = f52858b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f52859c = f52859c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f52860d;

    private h() {
    }

    public static String a(Context context) {
        k.c(context, "context");
        return d.b().a("home_banner_url") + c.a(context, true);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f52861a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f52862b;

        a(x.e eVar, String str) {
            this.f52861a = eVar;
            this.f52862b = str;
        }

        public final void run() {
            this.f52861a.element = (HomeResponse) new f().a(this.f52862b, HomeResponse.class);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x004e A[SYNTHETIC, Splitter:B:33:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0063 A[SYNTHETIC, Splitter:B:42:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006d A[SYNTHETIC, Splitter:B:48:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0072 A[Catch:{ Exception -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0045=Splitter:B:30:0x0045, B:39:0x005a=Splitter:B:39:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytmmall.clpartifact.view.viewmodel.HomeResponse b(android.content.Context r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            r0 = 0
            java.lang.String r1 = f52858b     // Catch:{ IOException -> 0x0057, ClassNotFoundException -> 0x0042, all -> 0x003d }
            java.io.FileInputStream r5 = r5.openFileInput(r1)     // Catch:{ IOException -> 0x0057, ClassNotFoundException -> 0x0042, all -> 0x003d }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, all -> 0x0032 }
            r2 = r5
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, all -> 0x0032 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x003a, ClassNotFoundException -> 0x0037, all -> 0x0032 }
            java.lang.Object r2 = r1.readObject()     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
            if (r2 == 0) goto L_0x0026
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r2 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r2     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
            r1.close()     // Catch:{ Exception -> 0x0024 }
            if (r5 == 0) goto L_0x0024
            r5.close()     // Catch:{ Exception -> 0x0024 }
        L_0x0024:
            r0 = r2
            goto L_0x0069
        L_0x0026:
            kotlin.u r2 = new kotlin.u     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
            java.lang.String r3 = "null cannot be cast to non-null type com.paytmmall.clpartifact.view.viewmodel.HomeResponse"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
            throw r2     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x002e }
        L_0x002e:
            r2 = move-exception
            goto L_0x0045
        L_0x0030:
            r2 = move-exception
            goto L_0x005a
        L_0x0032:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x006b
        L_0x0037:
            r2 = move-exception
            r1 = r0
            goto L_0x0045
        L_0x003a:
            r2 = move-exception
            r1 = r0
            goto L_0x005a
        L_0x003d:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L_0x006b
        L_0x0042:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L_0x0045:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x006a }
            com.paytm.utility.q.b(r2)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0051:
            if (r5 == 0) goto L_0x0069
        L_0x0053:
            r5.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x0069
        L_0x0057:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L_0x005a:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x006a }
            com.paytm.utility.q.b(r2)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0066:
            if (r5 == 0) goto L_0x0069
            goto L_0x0053
        L_0x0069:
            return r0
        L_0x006a:
            r0 = move-exception
        L_0x006b:
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0070:
            if (r5 == 0) goto L_0x0075
            r5.close()     // Catch:{ Exception -> 0x0075 }
        L_0x0075:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.leftNavigation.h.b(android.content.Context):com.paytmmall.clpartifact.view.viewmodel.HomeResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC, Splitter:B:20:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a A[SYNTHETIC, Splitter:B:29:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0061 A[SYNTHETIC, Splitter:B:34:0x0061] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0051=Splitter:B:26:0x0051, B:17:0x0039=Splitter:B:17:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytmmall.clpartifact.view.viewmodel.HomeResponse c(android.content.Context r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            r0 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x004f, Exception -> 0x0037, all -> 0x0032 }
            java.lang.String r1 = f52859c     // Catch:{ IOException -> 0x004f, Exception -> 0x0037, all -> 0x0032 }
            java.io.InputStream r5 = r5.open(r1)     // Catch:{ IOException -> 0x004f, Exception -> 0x0037, all -> 0x0032 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0030, Exception -> 0x002e }
            r1.<init>(r5)     // Catch:{ IOException -> 0x0030, Exception -> 0x002e }
            com.paytmmall.clpartifact.utils.SFGsonUtils r2 = com.paytmmall.clpartifact.utils.SFGsonUtils.INSTANCE     // Catch:{ IOException -> 0x0030, Exception -> 0x002e }
            java.lang.Class<com.paytmmall.clpartifact.view.viewmodel.HomeResponse> r3 = com.paytmmall.clpartifact.view.viewmodel.HomeResponse.class
            java.lang.Object r1 = r2.fromJson(r1, r3)     // Catch:{ IOException -> 0x0030, Exception -> 0x002e }
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r1 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r1     // Catch:{ IOException -> 0x0030, Exception -> 0x002e }
            if (r5 == 0) goto L_0x002d
            r5.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x002d
        L_0x0025:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x002d:
            return r1
        L_0x002e:
            r1 = move-exception
            goto L_0x0039
        L_0x0030:
            r1 = move-exception
            goto L_0x0051
        L_0x0032:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x005f
        L_0x0037:
            r1 = move-exception
            r5 = r0
        L_0x0039:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005e }
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005d
            r5.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x005d
        L_0x0046:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
            goto L_0x005d
        L_0x004f:
            r1 = move-exception
            r5 = r0
        L_0x0051:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x005e }
            com.paytm.utility.q.b(r1)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005d
            r5.close()     // Catch:{ IOException -> 0x0046 }
        L_0x005d:
            return r0
        L_0x005e:
            r0 = move-exception
        L_0x005f:
            if (r5 == 0) goto L_0x006d
            r5.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x006d
        L_0x0065:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.b(r5)
        L_0x006d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.leftNavigation.h.c(android.content.Context):com.paytmmall.clpartifact.view.viewmodel.HomeResponse");
    }

    static HomeResponse a(String str, Context context) {
        return (HomeResponse) SFGsonUtils.getPojo$default(SFGsonUtils.INSTANCE, com.paytm.network.f.a(str, context), HomeResponse.class, false, 4, (Object) null);
    }

    public static void a(boolean z) {
        f52860d = z;
    }

    public static boolean a() {
        return f52860d;
    }
}
