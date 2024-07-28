package androidx.viewpager2.adapter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.u;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.k;
import androidx.lifecycle.o;
import androidx.lifecycle.q;

class FragmentStateAdapter$2 implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4969a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f4970b;

    private FragmentStateAdapter$2(a aVar, b bVar) {
        this.f4970b = aVar;
        this.f4969a = bVar;
    }

    public final void a(q qVar, k.a aVar) {
        if (!this.f4970b.f4975b.i()) {
            qVar.getLifecycle().b(this);
            if (u.M((FrameLayout) this.f4969a.itemView)) {
                a aVar2 = this.f4970b;
                b bVar = this.f4969a;
                Fragment a2 = aVar2.f4976c.a(bVar.getItemId(), null);
                if (a2 != null) {
                    FrameLayout frameLayout = (FrameLayout) bVar.itemView;
                    View view = a2.getView();
                    if (!a2.isAdded() && view != null) {
                        throw new IllegalStateException("Design assumption violated.");
                    } else if (a2.isAdded() && view == null) {
                        aVar2.a(a2, frameLayout);
                    } else if (!a2.isAdded() || view.getParent() == null) {
                        if (a2.isAdded()) {
                            a.a(view, frameLayout);
                        } else if (!aVar2.f4975b.i()) {
                            aVar2.a(a2, frameLayout);
                            androidx.fragment.app.q a3 = aVar2.f4975b.a();
                            a3.a(a2, "f" + bVar.getItemId()).a(a2, k.b.STARTED).d();
                            aVar2.f4977d.a();
                        } else if (!aVar2.f4975b.o) {
                            aVar2.f4974a.a(new FragmentStateAdapter$2(aVar2, bVar));
                        }
                    } else if (view.getParent() != frameLayout) {
                        a.a(view, frameLayout);
                    }
                } else {
                    throw new IllegalStateException("Design assumption violated.");
                }
            }
        }
    }
}
