package net.one97.paytm.moneytransfer.utils;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.utils.l;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54162a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String str) {
            com.paytm.b.a.a aVar;
            Context applicationContext;
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar2 = l.f54175a;
                aVar = l.a.a(applicationContext);
            }
            if (str != null && aVar != null) {
                aVar.a("selected_account_number", str, false);
            }
        }

        public static void b(Context context, String str) {
            com.paytm.b.a.a aVar;
            Context applicationContext;
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar2 = l.f54175a;
                aVar = l.a.a(applicationContext);
            }
            if (str != null && aVar != null) {
                aVar.a("selected_account_ifsc", str, false);
            }
        }

        public static String a(Context context) {
            com.paytm.b.a.a aVar;
            Context applicationContext;
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar2 = l.f54175a;
                aVar = l.a.a(applicationContext);
            }
            if (aVar != null) {
                return aVar.b("selected_account_number", "", false);
            }
            return null;
        }

        public static String b(Context context) {
            com.paytm.b.a.a aVar;
            Context applicationContext;
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar2 = l.f54175a;
                aVar = l.a.a(applicationContext);
            }
            if (aVar != null) {
                return aVar.b("selected_account_ifsc", "", false);
            }
            return null;
        }

        public static void a(Context context, String str, String str2) {
            com.paytm.b.a.a aVar;
            Context applicationContext;
            k.c(str, "paymentMode");
            if (context == null || (applicationContext = context.getApplicationContext()) == null) {
                aVar = null;
            } else {
                l.a aVar2 = l.f54175a;
                aVar = l.a.a(applicationContext);
            }
            if (!(!"UPI".equals(str) || str2 == null || aVar == null)) {
                aVar.a("p2p-last-used-bank-account-number", str2, false);
            }
            if (aVar != null) {
                aVar.a("p2p-last-used-paymode", str, true);
            }
        }
    }
}
