package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class ih implements Iterator<fo> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<ic> f9992a;

    /* renamed from: b  reason: collision with root package name */
    private fo f9993b;

    private ih(fh fhVar) {
        if (fhVar instanceof ic) {
            ic icVar = (ic) fhVar;
            this.f9992a = new ArrayDeque<>(icVar.zztr());
            this.f9992a.push(icVar);
            this.f9993b = a(icVar.zzcoz);
            return;
        }
        this.f9992a = null;
        this.f9993b = (fo) fhVar;
    }

    private final fo a(fh fhVar) {
        while (fhVar instanceof ic) {
            ic icVar = (ic) fhVar;
            this.f9992a.push(icVar);
            fhVar = icVar.zzcoz;
        }
        return (fo) fhVar;
    }

    public final boolean hasNext() {
        return this.f9993b != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        fo foVar;
        boolean z;
        fo foVar2 = this.f9993b;
        if (foVar2 != null) {
            while (true) {
                ArrayDeque<ic> arrayDeque = this.f9992a;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    foVar = a(this.f9992a.pop().zzcpa);
                    if (foVar.size() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        break;
                    }
                } else {
                    foVar = null;
                }
            }
            foVar = null;
            this.f9993b = foVar;
            return foVar2;
        }
        throw new NoSuchElementException();
    }

    /* synthetic */ ih(fh fhVar, byte b2) {
        this(fhVar);
    }
}
