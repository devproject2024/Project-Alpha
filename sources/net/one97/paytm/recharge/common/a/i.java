package net.one97.paytm.recharge.common.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import net.one97.paytm.recharge.common.e.g;

public final class i<T extends RecyclerView.v> extends RecyclerView.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private g<T> f60545a;

    public i(g<T> gVar) {
        this.f60545a = gVar;
    }

    public final T onCreateViewHolder(ViewGroup viewGroup, int i2) {
        g<T> gVar = this.f60545a;
        if (gVar != null) {
            return gVar.a(viewGroup);
        }
        return null;
    }

    public final void onBindViewHolder(T t, int i2) {
        g<T> gVar = this.f60545a;
        if (gVar != null) {
            gVar.a(t, i2);
        }
    }

    public final int getItemCount() {
        g<T> gVar = this.f60545a;
        if (gVar != null) {
            return gVar.getItemCount();
        }
        return 0;
    }

    public final long getItemId(int i2) {
        g<T> gVar = this.f60545a;
        if (gVar != null) {
            return gVar.c_(i2);
        }
        return -1;
    }
}
