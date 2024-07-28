package net.one97.paytm.passbook.caching.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.x;

public abstract class PassbookCacheDB extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f57107a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile PassbookCacheDB f57108b;

    public abstract b a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static PassbookCacheDB a(Context context) {
            k.c(context, "context");
            if (PassbookCacheDB.f57108b == null) {
                synchronized (y.b(PassbookCacheDB.class)) {
                    PassbookCacheDB.f57108b = i.a(context.getApplicationContext(), PassbookCacheDB.class, "passbook.db").c();
                    x xVar = x.f47997a;
                }
            }
            return PassbookCacheDB.f57108b;
        }
    }
}
