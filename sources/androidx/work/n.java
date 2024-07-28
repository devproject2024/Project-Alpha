package androidx.work;

import android.os.Build;
import androidx.work.w;

public final class n extends w {
    n(a aVar) {
        super(aVar.f5520b, aVar.f5521c, aVar.f5522d);
    }

    public static final class a extends w.a<a, n> {
        /* access modifiers changed from: package-private */
        public final /* bridge */ /* synthetic */ w.a a() {
            return this;
        }

        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f5521c.f5183d = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ w b() {
            if (this.f5519a && Build.VERSION.SDK_INT >= 23 && this.f5521c.j.f5075d) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            } else if (!this.f5521c.q || Build.VERSION.SDK_INT < 23 || !this.f5521c.j.f5075d) {
                return new n(this);
            } else {
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
        }
    }
}
