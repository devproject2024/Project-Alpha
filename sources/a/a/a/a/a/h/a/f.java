package a.a.a.a.a.h.a;

import a.a.a.a.a.c.a;
import a.a.a.a.a.c.d;
import a.a.a.a.a.g.a;
import a.a.a.a.a.h.a.b;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import org.json.JSONObject;

public final class f extends a {
    public f(b.C0004b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void onPostExecute(String str) {
        a a2;
        if (!TextUtils.isEmpty(str) && (a2 = a.a()) != null) {
            for (T t : Collections.unmodifiableCollection(a2.f711a)) {
                if (this.f762a.contains(t.f705e)) {
                    a.a.a.a.a.g.a aVar = t.f703c;
                    if (this.f764c >= aVar.f742d) {
                        aVar.f741c = a.C0002a.AD_STATE_VISIBLE;
                        d.a();
                        d.b(aVar.c(), str);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        if (a.a.a.a.a.e.b.b(this.f763b, this.f766e.a())) {
            return null;
        }
        this.f766e.a(this.f763b);
        return this.f763b.toString();
    }
}
