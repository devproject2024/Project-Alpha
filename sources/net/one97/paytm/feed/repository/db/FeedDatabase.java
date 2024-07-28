package net.one97.paytm.feed.repository.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.k;

public abstract class FeedDatabase extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34610a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static FeedDatabase f34611b;

    public abstract net.one97.paytm.feed.repository.db.a.a a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final synchronized FeedDatabase a(Context context) {
            FeedDatabase b2;
            k.c(context, "context");
            if (FeedDatabase.f34611b == null) {
                FeedDatabase.f34611b = i.a(context.getApplicationContext(), FeedDatabase.class, "feed_db").b().c();
            }
            b2 = FeedDatabase.f34611b;
            if (b2 == null) {
                k.a();
            }
            return b2;
        }
    }
}
