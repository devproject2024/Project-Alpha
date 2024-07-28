package net.one97.paytm.base;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.a;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.g.b.k;
import kotlin.o;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public f f49511a = new f();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(LiveData<Object> liveData, z<Object> zVar) {
        k.c(liveData, "liveData");
        k.c(zVar, "observer");
        liveData.observeForever(zVar);
        f fVar = this.f49511a;
        k.c(liveData, "liveData");
        k.c(zVar, "observer");
        fVar.f49513b.add(new o(liveData, zVar));
    }

    public void onCleared() {
        f fVar = this.f49511a;
        Collection arrayList = new ArrayList();
        Iterator it2 = fVar.f49512a.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            Future future = (Future) next;
            if (future.isCancelled() || future.isDone()) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterable<Future> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
        for (Future cancel : iterable) {
            arrayList2.add(Boolean.valueOf(cancel.cancel(true)));
        }
        for (o oVar : fVar.f49513b) {
            ((LiveData) oVar.getFirst()).removeObserver((z) oVar.getSecond());
        }
        super.onCleared();
    }
}
