package com.google.android.gms.internal.firebase_ml;

import java.util.ArrayDeque;
import java.util.Arrays;

final class ie {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<fh> f9988a;

    private ie() {
        this.f9988a = new ArrayDeque<>();
    }

    /* access modifiers changed from: package-private */
    public final void a(fh fhVar) {
        while (!fhVar.zzts()) {
            if (fhVar instanceof ic) {
                ic icVar = (ic) fhVar;
                a(icVar.zzcoz);
                fhVar = icVar.zzcpa;
            } else {
                String valueOf = String.valueOf(fhVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int a2 = a(fhVar.size());
        int zzdz = ic.zzdz(a2 + 1);
        if (this.f9988a.isEmpty() || this.f9988a.peek().size() >= zzdz) {
            this.f9988a.push(fhVar);
            return;
        }
        int zzdz2 = ic.zzdz(a2);
        fh pop = this.f9988a.pop();
        while (!this.f9988a.isEmpty() && this.f9988a.peek().size() < zzdz2) {
            pop = new ic(this.f9988a.pop(), pop, (Cif) null);
        }
        ic icVar2 = new ic(pop, fhVar, (Cif) null);
        while (!this.f9988a.isEmpty() && this.f9988a.peek().size() < ic.zzdz(a(icVar2.size()) + 1)) {
            icVar2 = new ic(this.f9988a.pop(), icVar2, (Cif) null);
        }
        this.f9988a.push(icVar2);
    }

    private static int a(int i2) {
        int binarySearch = Arrays.binarySearch(ic.zzcox, i2);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ ie(byte b2) {
        this();
    }
}
