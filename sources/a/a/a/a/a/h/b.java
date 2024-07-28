package a.a.a.a.a.h;

import a.a.a.a.a.b.i;
import a.a.a.a.a.f.a;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final HashMap<View, String> f771a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    final HashMap<View, ArrayList<String>> f772b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final HashSet<View> f773c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    final HashSet<String> f774d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    final HashSet<String> f775e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    boolean f776f;

    /* access modifiers changed from: package-private */
    public final void a(i iVar) {
        for (a aVar : iVar.f702b) {
            View view = (View) aVar.get();
            if (view != null) {
                ArrayList arrayList = this.f772b.get(view);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f772b.put(view, arrayList);
                }
                arrayList.add(iVar.f705e);
            }
        }
    }
}
