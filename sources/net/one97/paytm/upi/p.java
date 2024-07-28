package net.one97.paytm.upi;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.IClientListener;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.List;
import kotlin.g.b.k;

public final class p extends RecyclerView.a<CLPBaseViewHolder> implements IGAHandlerListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f67614a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends View> f67615b;

    /* renamed from: c  reason: collision with root package name */
    private final j f67616c;

    /* renamed from: d  reason: collision with root package name */
    private final StoreFrontGAHandler f67617d;

    public final boolean IsClickEnable() {
        return true;
    }

    public /* synthetic */ void OnItemClick(Item item, int i2) {
        IGAClickListener.CC.$default$OnItemClick(this, item, i2);
    }

    public final void OnItemClick(Item item, int i2, boolean z) {
    }

    public final void fireImpression(View view, int i2) {
    }

    public /* synthetic */ void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        IGAHandlerListener.CC.$default$fireInfiniteGridProductImpression(this, cJRGridProduct, i2);
    }

    public /* synthetic */ int getClient() {
        return IClientListener.CC.$default$getClient(this);
    }

    public /* synthetic */ String getClientRequestID() {
        return IAdListener.CC.$default$getClientRequestID(this);
    }

    public p(List<? extends View> list, j jVar, StoreFrontGAHandler storeFrontGAHandler) {
        k.c(list, "list");
        k.c(jVar, "fragmentManager");
        k.c(storeFrontGAHandler, "gaListener");
        this.f67615b = list;
        this.f67616c = jVar;
        this.f67617d = storeFrontGAHandler;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
        k.c(cLPBaseViewHolder, "holder");
        cLPBaseViewHolder.bind((View) this.f67615b.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        this.f67614a = viewGroup.getContext();
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), this.f67616c, this);
        k.a((Object) viewHolder, "ViewHolderFactory.getVie…er,\n                this)");
        return viewHolder;
    }

    public final int getItemViewType(int i2) {
        return WidgetLayoutType.Companion.getLayoutTypeIndexfromName((View) this.f67615b.get(i2));
    }

    public final int getItemCount() {
        return this.f67615b.size();
    }

    public final void fireImpression(Item item, int i2) {
        this.f67617d.fireImpression(item, i2);
    }
}
