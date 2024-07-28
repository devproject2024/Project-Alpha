package com.google.android.play.core.splitcompat;

import java.util.Set;

final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Set f37523a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f37524b;

    q(a aVar, Set set) {
        this.f37524b = aVar;
        this.f37523a = set;
    }

    public final void run() {
        try {
            for (String f2 : this.f37523a) {
                this.f37524b.f37495b.f(f2);
            }
        } catch (Exception unused) {
        }
    }
}
