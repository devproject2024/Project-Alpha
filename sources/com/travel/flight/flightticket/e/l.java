package com.travel.flight.flightticket.e;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.m;
import androidx.recyclerview.widget.n;
import com.travel.flight.flightticket.a.e;

public final class l extends l.d {

    /* renamed from: a  reason: collision with root package name */
    private a f24908a;

    public interface a {
        void a(int i2);
    }

    public final boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
        return true;
    }

    public l(a aVar) {
        this.f24908a = aVar;
    }

    public final void c(RecyclerView.v vVar) {
        n.f4338a.a(((e.a) vVar).m);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z) {
        n.f4338a.a(recyclerView, ((e.a) vVar).m, f2, f3, z);
    }

    public final void a(RecyclerView.v vVar) {
        this.f24908a.a(vVar.getAdapterPosition());
    }

    public final void b(RecyclerView.v vVar) {
        if (vVar != null) {
            m mVar = n.f4338a;
        }
    }

    public final void a() {
        m mVar = n.f4338a;
    }
}
