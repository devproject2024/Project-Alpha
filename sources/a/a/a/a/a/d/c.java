package a.a.a.a.a.d;

import a.a.a.a.a.d.a;
import a.a.a.a.a.e.b;
import a.a.a.a.a.e.d;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f732a;

    public c(a aVar) {
        this.f732a = aVar;
    }

    public final JSONObject a(View view) {
        return b.a(0, 0, 0, 0);
    }

    public final void a(View view, JSONObject jSONObject, a.C0001a aVar, boolean z) {
        View rootView;
        ArrayList arrayList = new ArrayList();
        a.a.a.a.a.c.a a2 = a.a.a.a.a.c.a.a();
        if (a2 != null) {
            Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(a2.f712b);
            IdentityHashMap identityHashMap = new IdentityHashMap((unmodifiableCollection.size() * 2) + 3);
            for (T d2 : unmodifiableCollection) {
                View d3 = d2.d();
                if (d3 != null && d.b(d3) && (rootView = d3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a3 = d.a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && d.a((View) arrayList.get(size - 1)) > a3) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVar.a((View) it2.next(), this.f732a, jSONObject);
        }
    }
}
