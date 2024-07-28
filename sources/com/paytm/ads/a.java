package com.paytm.ads;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.ads.a.b;
import com.paytm.pai.network.d;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0679a f40863a = new C0679a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static a f40864b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static d f40865c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f40866d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40867e;

    private a(Context context, String str) {
        this.f40866d = context;
        this.f40867e = str;
    }

    public /* synthetic */ a(Context context, String str, byte b2) {
        this(context, str);
    }

    /* renamed from: com.paytm.ads.a$a  reason: collision with other inner class name */
    public static final class C0679a {
        private C0679a() {
        }

        public /* synthetic */ C0679a(byte b2) {
            this();
        }

        /* renamed from: com.paytm.ads.a$a$a  reason: collision with other inner class name */
        static final class C0680a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f40868a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f40869b;

            C0680a(Context context, String str) {
                this.f40868a = context;
                this.f40869b = str;
            }

            public final void run() {
                try {
                    C0679a aVar = a.f40863a;
                    Context applicationContext = this.f40868a.getApplicationContext();
                    k.a((Object) applicationContext, "context.applicationContext");
                    a.f40864b = new a(applicationContext, this.f40869b, (byte) 0);
                    C0679a aVar2 = a.f40863a;
                    a.f40865c = new d(false);
                    b.C0681b bVar = b.f40870a;
                    Context context = this.f40868a;
                    String str = this.f40869b;
                    k.c(context, "context");
                    k.c(str, AppConstants.VERSION_NAME);
                    b.a(new b(new com.paytm.ads.c.a(context, "Paytm", str), (byte) 0));
                    b a2 = b.a();
                    if (a2 != null) {
                        b.b(a2);
                    }
                } catch (com.paytm.ads.b.b unused) {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static final void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, AppConstants.VERSION_NAME);
        try {
            a.a.a.a.a.a.a();
            a.a.a.a.a.a.a(context.getApplicationContext());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        new Thread(new C0679a.C0680a(context, str)).start();
    }
}
