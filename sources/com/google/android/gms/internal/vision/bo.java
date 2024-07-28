package com.google.android.gms.internal.vision;

import java.util.List;

final class bo extends bn {

    /* renamed from: a  reason: collision with root package name */
    private final bm f11002a = new bm();

    bo() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f11002a.a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }

    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> a2 = this.f11002a.a(th, false);
        if (a2 != null) {
            synchronized (a2) {
                for (Throwable printStackTrace : a2) {
                    System.err.print("Suppressed: ");
                    printStackTrace.printStackTrace();
                }
            }
        }
    }
}
