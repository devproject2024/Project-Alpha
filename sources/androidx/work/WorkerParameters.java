package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    UUID f5042a;

    /* renamed from: b  reason: collision with root package name */
    e f5043b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f5044c;

    /* renamed from: d  reason: collision with root package name */
    a f5045d;

    /* renamed from: e  reason: collision with root package name */
    int f5046e;

    /* renamed from: f  reason: collision with root package name */
    Executor f5047f;

    /* renamed from: g  reason: collision with root package name */
    androidx.work.impl.utils.b.a f5048g;

    /* renamed from: h  reason: collision with root package name */
    x f5049h;

    /* renamed from: i  reason: collision with root package name */
    q f5050i;
    i j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f5051a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f5052b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f5053c;
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i2, Executor executor, androidx.work.impl.utils.b.a aVar2, x xVar, q qVar, i iVar) {
        this.f5042a = uuid;
        this.f5043b = eVar;
        this.f5044c = new HashSet(collection);
        this.f5045d = aVar;
        this.f5046e = i2;
        this.f5047f = executor;
        this.f5048g = aVar2;
        this.f5049h = xVar;
        this.f5050i = qVar;
        this.j = iVar;
    }
}
