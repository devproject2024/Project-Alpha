package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.k;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    final t f3627a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3628b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private a f3629c;

    public af(q qVar) {
        this.f3627a = new t(qVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(k.a aVar) {
        a aVar2 = this.f3629c;
        if (aVar2 != null) {
            aVar2.run();
        }
        this.f3629c = new a(this.f3627a, aVar);
        this.f3628b.postAtFrontOfQueue(this.f3629c);
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final k.a f3630a;

        /* renamed from: b  reason: collision with root package name */
        private final t f3631b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3632c = false;

        a(t tVar, k.a aVar) {
            this.f3631b = tVar;
            this.f3630a = aVar;
        }

        public final void run() {
            if (!this.f3632c) {
                this.f3631b.a(this.f3630a);
                this.f3632c = true;
            }
        }
    }
}
