package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

final class g implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f37505a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Set f37506b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f37507c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ m f37508d;

    g(m mVar, s sVar, Set set, AtomicBoolean atomicBoolean) {
        this.f37508d = mVar;
        this.f37505a = sVar;
        this.f37506b = set;
        this.f37507c = atomicBoolean;
    }

    public final void a(ZipFile zipFile, Set<l> set) throws IOException {
        this.f37508d.a(this.f37505a, set, new f(this));
    }
}
