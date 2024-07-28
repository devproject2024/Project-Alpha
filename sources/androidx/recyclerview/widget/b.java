package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public final class b implements s {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.a f4171a;

    public b(RecyclerView.a aVar) {
        this.f4171a = aVar;
    }

    public final void a(int i2, int i3) {
        this.f4171a.notifyItemRangeInserted(i2, i3);
    }

    public final void b(int i2, int i3) {
        this.f4171a.notifyItemRangeRemoved(i2, i3);
    }

    public final void c(int i2, int i3) {
        this.f4171a.notifyItemMoved(i2, i3);
    }

    public final void a(int i2, int i3, Object obj) {
        this.f4171a.notifyItemRangeChanged(i2, i3, obj);
    }
}
