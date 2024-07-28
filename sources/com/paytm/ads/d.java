package com.paytm.ads;

import com.paytm.ads.a;
import com.paytm.pai.network.model.EventResponse;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f40887a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadPoolExecutor f40888b = new ThreadPoolExecutor(2, 3, 300, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    private d() {
    }

    public static void a(String str) {
        k.c(str, "url");
        f40888b.execute(new a(str));
    }

    public static void b(String str) {
        k.c(str, "url");
        f40888b.execute(new b(str));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40889a;

        a(String str) {
            this.f40889a = str;
        }

        public final void run() {
            try {
                timber.log.a.a("[AdEvent] sendClick() url: " + this.f40889a, new Object[0]);
                a.C0679a aVar = a.f40863a;
                com.paytm.pai.network.d a2 = a.f40865c;
                String str = null;
                EventResponse<String> a3 = a2 != null ? a2.a(this.f40889a, (String) null, "", (String) null, (String) null, false) : null;
                StringBuilder sb = new StringBuilder("[AdEvent] sendClick() success: ");
                sb.append(a3 != null ? a3.isSuccess() : null);
                sb.append("  result: ");
                if (a3 != null) {
                    str = a3.getResponse();
                }
                sb.append(str);
                timber.log.a.a(sb.toString(), new Object[0]);
            } catch (com.paytm.ads.b.b e2) {
                e2.printStackTrace();
                timber.log.a.a(e2);
            } catch (Exception e3) {
                timber.log.a.a(e3);
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f40893a;

        b(String str) {
            this.f40893a = str;
        }

        public final void run() {
            try {
                timber.log.a.a("[AdEvent] sendImpression() url: " + this.f40893a, new Object[0]);
                a.C0679a aVar = a.f40863a;
                com.paytm.pai.network.d a2 = a.f40865c;
                String str = null;
                EventResponse<String> a3 = a2 != null ? a2.a(this.f40893a, (String) null, "", (String) null, (String) null, false) : null;
                StringBuilder sb = new StringBuilder("[AdEvent] sendImpression() success: ");
                sb.append(a3 != null ? a3.isSuccess() : null);
                sb.append("  result: ");
                if (a3 != null) {
                    str = a3.getResponse();
                }
                sb.append(str);
                timber.log.a.a(sb.toString(), new Object[0]);
            } catch (com.paytm.ads.b.b e2) {
                e2.printStackTrace();
                timber.log.a.a(e2);
            } catch (Exception e3) {
                timber.log.a.a(e3);
            }
        }
    }
}
