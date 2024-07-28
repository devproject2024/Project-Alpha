package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class y extends RecyclerView.f {
    public boolean m = true;

    public abstract boolean a(RecyclerView.v vVar);

    public abstract boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5);

    public abstract boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5);

    public abstract boolean b(RecyclerView.v vVar);

    public final void f() {
        this.m = false;
    }

    public final boolean g(RecyclerView.v vVar) {
        return !this.m || vVar.isInvalid();
    }

    public final boolean a(RecyclerView.v vVar, RecyclerView.f.b bVar, RecyclerView.f.b bVar2) {
        int i2 = bVar.f4062a;
        int i3 = bVar.f4063b;
        View view = vVar.itemView;
        int left = bVar2 == null ? view.getLeft() : bVar2.f4062a;
        int top = bVar2 == null ? view.getTop() : bVar2.f4063b;
        if (vVar.isRemoved() || (i2 == left && i3 == top)) {
            return a(vVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(vVar, i2, i3, left, top);
    }

    public final boolean b(RecyclerView.v vVar, RecyclerView.f.b bVar, RecyclerView.f.b bVar2) {
        if (bVar == null || (bVar.f4062a == bVar2.f4062a && bVar.f4063b == bVar2.f4063b)) {
            return b(vVar);
        }
        return a(vVar, bVar.f4062a, bVar.f4063b, bVar2.f4062a, bVar2.f4063b);
    }

    public final boolean c(RecyclerView.v vVar, RecyclerView.f.b bVar, RecyclerView.f.b bVar2) {
        if (bVar.f4062a == bVar2.f4062a && bVar.f4063b == bVar2.f4063b) {
            f(vVar);
            return false;
        }
        return a(vVar, bVar.f4062a, bVar.f4063b, bVar2.f4062a, bVar2.f4063b);
    }

    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.f.b bVar, RecyclerView.f.b bVar2) {
        int i2;
        int i3;
        int i4 = bVar.f4062a;
        int i5 = bVar.f4063b;
        if (vVar2.shouldIgnore()) {
            int i6 = bVar.f4062a;
            i2 = bVar.f4063b;
            i3 = i6;
        } else {
            i3 = bVar2.f4062a;
            i2 = bVar2.f4063b;
        }
        return a(vVar, vVar2, i4, i5, i3, i2);
    }
}
