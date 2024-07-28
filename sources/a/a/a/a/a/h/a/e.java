package a.a.a.a.a.h.a;

import a.a.a.a.a.c.d;
import a.a.a.a.a.g.a;
import a.a.a.a.a.h.a.b;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public final class e extends a {
    public e(b.C0004b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        a.C0002a aVar;
        a.a.a.a.a.c.a a2 = a.a.a.a.a.c.a.a();
        if (a2 != null) {
            for (T t : Collections.unmodifiableCollection(a2.f711a)) {
                if (this.f762a.contains(t.f705e)) {
                    a aVar2 = t.f703c;
                    if (this.f764c >= aVar2.f742d && aVar2.f741c != (aVar = a.C0002a.AD_STATE_HIDDEN)) {
                        aVar2.f741c = aVar;
                        d.a();
                        d.b(aVar2.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.f763b.toString();
    }
}
