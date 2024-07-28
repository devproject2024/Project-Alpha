package net.one97.paytm.games.view.pfg.a;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import java.util.List;
import net.one97.paytm.games.view.pfg.pinnedheader.b;

public abstract class c<G, C, VH extends RecyclerView.v> extends b<VH> {

    /* renamed from: a  reason: collision with root package name */
    protected List<b<G, C>> f35727a;

    /* renamed from: b  reason: collision with root package name */
    protected SparseArray<a> f35728b;

    public c() {
        this((byte) 0);
    }

    private c(byte b2) {
        this.f35727a = null;
        this.f35728b = new SparseArray<>();
    }

    public final void a(List<b<G, C>> list) {
        this.f35727a = list;
        this.f35728b.clear();
        notifyDataSetChanged();
    }

    public final boolean b(int i2) {
        return getItemViewType(i2) == 0;
    }

    public int getItemViewType(int i2) {
        int i3 = 0;
        for (b next : this.f35727a) {
            i3++;
            if (i2 == i3 - 1) {
                return 0;
            }
            if (next.f35725b != null && next.f35726c) {
                i3 += next.f35725b.size();
                continue;
            }
            if (i2 < i3) {
                return 1;
            }
        }
        throw new IllegalArgumentException("getItemViewType exception");
    }

    public int getItemCount() {
        int i2;
        int i3;
        List<b<G, C>> list = this.f35727a;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.f35727a.size()) {
            b bVar = this.f35727a.get(i4);
            int i6 = i5 + 1;
            SparseArray<a> sparseArray = this.f35728b;
            int i7 = i6 - 1;
            if (bVar.f35725b == null) {
                i2 = 0;
            } else {
                i2 = bVar.f35725b.size();
            }
            sparseArray.put(i7, new a(i4, -1, i2));
            int size = (bVar.f35725b == null || !bVar.f35726c) ? i6 : bVar.f35725b.size() + i6;
            for (int i8 = i6; i8 < size; i8++) {
                SparseArray<a> sparseArray2 = this.f35728b;
                int i9 = i8 - i6;
                if (bVar.f35725b == null) {
                    i3 = 0;
                } else {
                    i3 = bVar.f35725b.size();
                }
                sparseArray2.put(i8, new a(i4, i9, i3));
            }
            i4++;
            i5 = size;
        }
        return i5;
    }
}
