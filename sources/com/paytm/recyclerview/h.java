package com.paytm.recyclerview;

import android.view.View;
import com.paytm.recyclerview.RecyclerView;

public abstract class h extends RecyclerView.e {
    boolean m = true;

    public abstract boolean a(RecyclerView.q qVar);

    public abstract boolean a(RecyclerView.q qVar, int i2, int i3, int i4, int i5);

    public abstract boolean a(RecyclerView.q qVar, RecyclerView.q qVar2, int i2, int i3, int i4, int i5);

    public abstract boolean b(RecyclerView.q qVar);

    public final boolean g(RecyclerView.q qVar) {
        return !this.m || qVar.k();
    }

    public final boolean a(RecyclerView.q qVar, RecyclerView.e.b bVar, RecyclerView.e.b bVar2) {
        int i2 = bVar.f15235a;
        int i3 = bVar.f15236b;
        View view = qVar.f15282a;
        int left = bVar2 == null ? view.getLeft() : bVar2.f15235a;
        int top = bVar2 == null ? view.getTop() : bVar2.f15236b;
        if (qVar.n() || (i2 == left && i3 == top)) {
            return a(qVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(qVar, i2, i3, left, top);
    }

    public final boolean b(RecyclerView.q qVar, RecyclerView.e.b bVar, RecyclerView.e.b bVar2) {
        if (bVar == null || (bVar.f15235a == bVar2.f15235a && bVar.f15236b == bVar2.f15236b)) {
            return b(qVar);
        }
        return a(qVar, bVar.f15235a, bVar.f15236b, bVar2.f15235a, bVar2.f15236b);
    }

    public final boolean c(RecyclerView.q qVar, RecyclerView.e.b bVar, RecyclerView.e.b bVar2) {
        if (bVar.f15235a == bVar2.f15235a && bVar.f15236b == bVar2.f15236b) {
            f(qVar);
            return false;
        }
        return a(qVar, bVar.f15235a, bVar.f15236b, bVar2.f15235a, bVar2.f15236b);
    }

    public final boolean a(RecyclerView.q qVar, RecyclerView.q qVar2, RecyclerView.e.b bVar, RecyclerView.e.b bVar2) {
        int i2;
        int i3;
        int i4 = bVar.f15235a;
        int i5 = bVar.f15236b;
        if (qVar2.c()) {
            int i6 = bVar.f15235a;
            i2 = bVar.f15236b;
            i3 = i6;
        } else {
            i3 = bVar2.f15235a;
            i2 = bVar2.f15236b;
        }
        return a(qVar, qVar2, i4, i5, i3, i2);
    }
}
