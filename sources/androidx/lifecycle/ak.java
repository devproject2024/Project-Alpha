package androidx.lifecycle;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.k.c;

public final class ak<VM extends ai> implements g<VM> {

    /* renamed from: a  reason: collision with root package name */
    private VM f3639a;

    /* renamed from: b  reason: collision with root package name */
    private final c<VM> f3640b;

    /* renamed from: c  reason: collision with root package name */
    private final a<an> f3641c;

    /* renamed from: d  reason: collision with root package name */
    private final a<al.b> f3642d;

    public ak(c<VM> cVar, a<? extends an> aVar, a<? extends al.b> aVar2) {
        k.c(cVar, "viewModelClass");
        k.c(aVar, "storeProducer");
        k.c(aVar2, "factoryProducer");
        this.f3640b = cVar;
        this.f3641c = aVar;
        this.f3642d = aVar2;
    }

    public final /* synthetic */ Object getValue() {
        VM vm = this.f3639a;
        if (vm != null) {
            return vm;
        }
        VM a2 = new al(this.f3641c.invoke(), this.f3642d.invoke()).a(kotlin.g.a.a(this.f3640b));
        this.f3639a = a2;
        k.a((Object) a2, "ViewModelProvider(store,…ed = it\n                }");
        return a2;
    }
}
