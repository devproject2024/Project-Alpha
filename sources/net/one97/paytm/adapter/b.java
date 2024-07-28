package net.one97.paytm.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;

public final class b extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    int f52308a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f52309b = 1;

    /* renamed from: c  reason: collision with root package name */
    int f52310c = 2;

    /* renamed from: d  reason: collision with root package name */
    int f52311d = 3;

    /* renamed from: e  reason: collision with root package name */
    int f52312e = 4;

    /* renamed from: f  reason: collision with root package name */
    List<View> f52313f;

    /* renamed from: g  reason: collision with root package name */
    StoreFrontGAHandler f52314g;

    /* renamed from: h  reason: collision with root package name */
    private CJRHomePageV2 f52315h = new CJRHomePageV2();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<CJRHomePageLayoutV2> f52316i = new ArrayList<>();
    private Context j;

    public b(Context context, List<View> list, StoreFrontGAHandler storeFrontGAHandler) {
        this.j = context;
        this.f52313f = list;
        this.f52314g = storeFrontGAHandler;
    }

    public final int getItemCount() {
        List<View> list = this.f52313f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemViewType(int i2) {
        return ViewHolderFactory.getViewType(this.f52313f.get(i2).getType());
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f52314g);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((CLPBaseViewHolder) vVar).bind(this.f52313f.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
    }
}
