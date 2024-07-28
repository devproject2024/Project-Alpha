package net.one97.paytm.o2o.movies.one_pager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.one_pager.holders.OpHorizontalListHolder;
import net.one97.paytm.o2o.movies.one_pager.holders.b;

public final class c extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.m f75652a = new RecyclerView.m();

    /* renamed from: b  reason: collision with root package name */
    private List<d> f75653b;

    /* renamed from: c  reason: collision with root package name */
    private g f75654c;

    /* renamed from: d  reason: collision with root package name */
    private a f75655d;

    /* renamed from: e  reason: collision with root package name */
    private Context f75656e;

    public interface a {
        void a(int i2);

        void a(CJRHomePageItem cJRHomePageItem);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        if (bVar != null) {
            bVar.a(this.f75653b.get(i2), this.f75656e);
        }
    }

    public c(List<d> list, Context context, a aVar) {
        this.f75653b = list;
        this.f75656e = context;
        this.f75655d = aVar;
    }

    public final int getItemViewType(int i2) {
        return this.f75653b.get(i2).f75657a;
    }

    public final int getItemCount() {
        List<d> list = this.f75653b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.f75654c = new g();
        Context context = this.f75656e;
        a aVar = this.f75655d;
        RecyclerView.m mVar = this.f75652a;
        if (i2 != 1) {
            return null;
        }
        OpHorizontalListHolder opHorizontalListHolder = new OpHorizontalListHolder(LayoutInflater.from(context).inflate(R.layout.op_horizontal_list_item, viewGroup, false), aVar);
        opHorizontalListHolder.f75672a.setRecycledViewPool(mVar);
        return opHorizontalListHolder;
    }
}
