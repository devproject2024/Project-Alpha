package com.arthurivanets.arvi.b.a;

public enum b {
    IN_MEMORY {
        /* access modifiers changed from: package-private */
        public final <K, V> a<K, V> create(boolean z) {
            d dVar = new d();
            return z ? new c(dVar) : dVar;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract <K, V> a<K, V> create(boolean z);
}
