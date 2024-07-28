package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

final class h implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Set f37509a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ s f37510b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m f37511c;

    h(m mVar, Set set, s sVar) {
        this.f37511c = mVar;
        this.f37509a = set;
        this.f37510b = sVar;
    }

    public final void a(ZipFile zipFile, Set<l> set) throws IOException {
        this.f37509a.addAll(m.a(this.f37511c, (Set) set, this.f37510b, zipFile));
    }
}
