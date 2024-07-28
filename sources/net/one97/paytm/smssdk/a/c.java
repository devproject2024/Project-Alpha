package net.one97.paytm.smssdk.a;

import android.content.Context;
import com.paytm.b.a.a;
import com.paytm.network.a;
import com.paytm.utility.f;
import kotlin.g.b.k;
import kotlin.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65060a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static com.paytm.b.a.a f65061b;

    private c() {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static com.paytm.b.a.a a(Context context) {
            k.c(context, "context");
            if (c.f65061b == null) {
                synchronized (c.class) {
                    a aVar = c.f65060a;
                    if (c.f65061b == null) {
                        a.C0708a aVar2 = com.paytm.b.a.a.f42641a;
                        Context applicationContext = context.getApplicationContext();
                        k.a((Object) applicationContext, "context.applicationContext");
                        c.f65061b = a.C0708a.a(applicationContext, a.c.SMS, f.a.SMS_SDK_PREF);
                    }
                    x xVar = x.f47997a;
                }
            }
            com.paytm.b.a.a a2 = c.f65061b;
            if (a2 == null) {
                k.a("sharedPreferences");
            }
            return a2;
        }
    }
}
