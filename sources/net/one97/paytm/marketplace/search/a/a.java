package net.one97.paytm.marketplace.search.a;

import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class a extends RecyclerView.a<CLPBaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends View> f53335a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final C0956a f53336b;

    /* renamed from: net.one97.paytm.marketplace.search.a.a$a  reason: collision with other inner class name */
    public interface C0956a extends IGAHandlerListener {
    }

    public a(C0956a aVar) {
        k.d(aVar, "listener");
        this.f53336b = aVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
        k.d(cLPBaseViewHolder, "holder");
        cLPBaseViewHolder.bind((View) this.f53335a.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.d(viewGroup, "parent");
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f53336b);
        k.b(viewHolder, "ViewHolderFactory.getVie…ewType)), null, listener)");
        return viewHolder;
    }

    public final int getItemCount() {
        return this.f53335a.size();
    }

    public final int getItemViewType(int i2) {
        return WidgetLayoutType.Companion.getLayoutTypeIndexfromName((View) this.f53335a.get(i2));
    }
}
