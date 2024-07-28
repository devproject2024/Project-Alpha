package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.j;

public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private j f5456a;

    /* renamed from: b  reason: collision with root package name */
    private String f5457b;

    /* renamed from: c  reason: collision with root package name */
    private WorkerParameters.a f5458c;

    public h(j jVar, String str, WorkerParameters.a aVar) {
        this.f5456a = jVar;
        this.f5457b = str;
        this.f5458c = aVar;
    }

    public final void run() {
        this.f5456a.f5364f.a(this.f5457b, this.f5458c);
    }
}
