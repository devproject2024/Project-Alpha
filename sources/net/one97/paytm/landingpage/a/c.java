package net.one97.paytm.landingpage.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public IGAHandlerListener f52658a;

    /* renamed from: b  reason: collision with root package name */
    private Context f52659b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends View> f52660c;

    public c(Context context, List<? extends View> list, IGAHandlerListener iGAHandlerListener) {
        k.c(context, "context");
        k.c(list, "sfWidgetList");
        this.f52659b = context;
        this.f52660c = list;
        this.f52658a = iGAHandlerListener;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f52658a);
        k.a((Object) viewHolder, "ViewHolderFactory.getVie…Type)), null, gaListener)");
        return viewHolder;
    }

    public final int getItemCount() {
        return this.f52660c.size();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        List<? extends View> list = this.f52660c;
        if (list != null && i2 < list.size() && (vVar instanceof CLPBaseViewHolder)) {
            View view = (View) list.get(i2);
            HashMap hashMap = new HashMap();
            hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(i2));
            view.setGaData(hashMap);
            ((CLPBaseViewHolder) vVar).bind(view, (CLPBaseViewHolder.IParentListProvider) null);
        }
    }

    public final int getItemViewType(int i2) {
        View view;
        if (this.f52660c == null) {
            return super.getItemViewType(i2);
        }
        WidgetLayoutType.Companion companion = WidgetLayoutType.Companion;
        List<? extends View> list = this.f52660c;
        if (list == null || (view = (View) list.get(i2)) == null) {
            view = new View();
        }
        return companion.getLayoutTypeIndexfromName(view);
    }

    public final void onViewAttachedToWindow(RecyclerView.v vVar) {
        k.c(vVar, "holder");
        super.onViewAttachedToWindow(vVar);
        if (vVar instanceof CLPBaseViewHolder) {
            CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
            cLPBaseViewHolder.onViewAttachedToWindow(cLPBaseViewHolder, (View) kotlin.a.k.a(this.f52660c, cLPBaseViewHolder.getAdapterPosition()));
        }
    }

    public final void onViewDetachedFromWindow(RecyclerView.v vVar) {
        k.c(vVar, "holder");
        super.onViewDetachedFromWindow(vVar);
        if (vVar instanceof CLPBaseViewHolder) {
            CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
            cLPBaseViewHolder.onViewDetachedFromWindow(cLPBaseViewHolder, (View) kotlin.a.k.a(this.f52660c, cLPBaseViewHolder.getAdapterPosition()));
        }
    }
}
