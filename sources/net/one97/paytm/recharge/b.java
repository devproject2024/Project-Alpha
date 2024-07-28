package net.one97.paytm.recharge;

import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.List;

public final class b extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    List<View> f60304a;

    /* renamed from: b  reason: collision with root package name */
    StoreFrontGAHandler f60305b;

    public b(List<View> list, StoreFrontGAHandler storeFrontGAHandler) {
        this.f60304a = list;
        this.f60305b = storeFrontGAHandler;
    }

    public final int getItemCount() {
        List<View> list = this.f60304a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemViewType(int i2) {
        return ViewHolderFactory.getViewType(this.f60304a.get(i2).getType());
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f60305b);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((CLPBaseViewHolder) vVar).bind(this.f60304a.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
    }
}
