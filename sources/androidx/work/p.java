package androidx.work;

import android.os.Build;
import androidx.work.w;
import java.util.concurrent.TimeUnit;

public final class p extends w {
    p(a aVar) {
        super(aVar.f5520b, aVar.f5521c, aVar.f5522d);
    }

    public static final class a extends w.a<a, p> {
        /* access modifiers changed from: package-private */
        public final /* bridge */ /* synthetic */ w.a a() {
            return this;
        }

        public a(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit) {
            super(cls);
            androidx.work.impl.b.p pVar = this.f5521c;
            long millis = timeUnit.toMillis(j);
            if (millis < 900000) {
                l.a();
                String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{900000L});
                millis = 900000;
            }
            pVar.a(millis, millis);
        }

        public a(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit, TimeUnit timeUnit2) {
            super(cls);
            this.f5521c.a(timeUnit.toMillis(j), timeUnit2.toMillis(300000));
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ w b() {
            if (this.f5519a && Build.VERSION.SDK_INT >= 23 && this.f5521c.j.f5075d) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            } else if (!this.f5521c.q || Build.VERSION.SDK_INT < 23 || !this.f5521c.j.f5075d) {
                return new p(this);
            } else {
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
        }
    }
}
