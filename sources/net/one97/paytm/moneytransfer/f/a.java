package net.one97.paytm.moneytransfer.f;

import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.List;
import kotlin.g.b.k;

public final class a extends RecyclerView.a<CLPBaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f54021a;

    /* renamed from: b  reason: collision with root package name */
    private final j f54022b;

    /* renamed from: c  reason: collision with root package name */
    private final StoreFrontGAHandler f54023c;

    public a(List<? extends View> list, j jVar, StoreFrontGAHandler storeFrontGAHandler) {
        k.c(list, "list");
        k.c(jVar, "fragmentManager");
        k.c(storeFrontGAHandler, "gaListener");
        this.f54021a = list;
        this.f54022b = jVar;
        this.f54023c = storeFrontGAHandler;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
        k.c(cLPBaseViewHolder, "holder");
        cLPBaseViewHolder.bind(this.f54021a.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), this.f54022b, this.f54023c);
        k.a((Object) viewHolder, "ViewHolderFactory.getVie… gaListener\n            )");
        return viewHolder;
    }

    public final int getItemViewType(int i2) {
        return WidgetLayoutType.Companion.getLayoutTypeIndexfromName(this.f54021a.get(i2));
    }

    public final int getItemCount() {
        return this.f54021a.size();
    }
}
