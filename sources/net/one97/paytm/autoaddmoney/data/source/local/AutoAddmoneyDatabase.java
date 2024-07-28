package net.one97.paytm.autoaddmoney.data.source.local;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.k;

public abstract class AutoAddmoneyDatabase extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49243a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static AutoAddmoneyDatabase f49244b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Object f49245c = new Object();

    public abstract a a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static AutoAddmoneyDatabase a(Context context) {
            AutoAddmoneyDatabase c2;
            synchronized (AutoAddmoneyDatabase.f49245c) {
                if (AutoAddmoneyDatabase.f49244b == null) {
                    Context context2 = null;
                    if ((context != null ? context.getApplicationContext() : null) != null) {
                        if (context != null) {
                            context2 = context.getApplicationContext();
                        }
                        AutoAddmoneyDatabase.f49244b = i.a(context2, AutoAddmoneyDatabase.class, "autoaddmoney.db").c();
                    }
                }
                c2 = AutoAddmoneyDatabase.f49244b;
                if (c2 == null) {
                    k.a();
                }
            }
            return c2;
        }
    }
}
