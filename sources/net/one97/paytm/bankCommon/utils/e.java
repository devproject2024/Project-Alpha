package net.one97.paytm.bankCommon.utils;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.bankOpen.d.c;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16328a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String a(Context context) {
            k.c(context, "context");
            c.a aVar = c.f16425a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            String b2 = c.a.a(applicationContext).b("bank_user_token", "", false);
            if (b2 == null) {
                k.a();
            }
            return b2;
        }
    }
}
