package com.google.android.datatransport.runtime;

import com.google.android.datatransport.b;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.g;
import java.util.Set;

final class m implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f7791a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7792b;

    /* renamed from: c  reason: collision with root package name */
    private final p f7793c;

    m(Set<b> set, l lVar, p pVar) {
        this.f7791a = set;
        this.f7792b = lVar;
        this.f7793c = pVar;
    }

    public final <T> f<T> a(String str, b bVar, e<T, byte[]> eVar) {
        if (this.f7791a.contains(bVar)) {
            return new n(this.f7792b, str, bVar, eVar, this.f7793c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.f7791a}));
    }
}
