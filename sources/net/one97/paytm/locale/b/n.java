package net.one97.paytm.locale.b;

import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class n {

    /* renamed from: a  reason: collision with root package name */
    private List<Pair<Class<? extends View>, a>> f53123a = new ArrayList();

    interface a {
        View a(View view, AttributeSet attributeSet);

        Class<? extends View> a();
    }

    n() {
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.f53123a.add(new Pair(aVar.a(), aVar));
    }

    /* access modifiers changed from: package-private */
    public final View a(View view, AttributeSet attributeSet) {
        if (view == null) {
            return null;
        }
        View view2 = view;
        for (Pair next : this.f53123a) {
            if (((Class) next.first).isInstance(view)) {
                view2 = ((a) next.second).a(view2, attributeSet);
            }
        }
        return view2;
    }
}
