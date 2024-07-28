package com.bumptech.glide.e;

public interface e {
    boolean b(d dVar);

    boolean c(d dVar);

    boolean d(d dVar);

    void e(d dVar);

    void f(d dVar);

    boolean g();

    e h();

    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean isComplete;

        private a(boolean z) {
            this.isComplete = z;
        }

        /* access modifiers changed from: package-private */
        public final boolean isComplete() {
            return this.isComplete;
        }
    }
}
