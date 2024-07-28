package net.one97.paytm.wallet.newdesign.d;

import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class a extends RecyclerView.a<CLPBaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    List<? extends View> f70865a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    IGAHandlerListener f70866b;

    public a(IGAHandlerListener iGAHandlerListener) {
        this.f70866b = iGAHandlerListener;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
        k.c(cLPBaseViewHolder, "holder");
        View view = (View) this.f70865a.get(i2);
        HashMap hashMap = new HashMap();
        hashMap.put(CLPConstants.WIDGET_BIND_POSITION, Integer.valueOf(i2));
        view.setGaData(hashMap);
        cLPBaseViewHolder.bind(view, (CLPBaseViewHolder.IParentListProvider) null);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f70866b);
        k.a((Object) viewHolder, "ViewHolderFactory.getVie…Type)), null, gaListener)");
        return viewHolder;
    }

    public final int getItemCount() {
        return this.f70865a.size();
    }

    public final int getItemViewType(int i2) {
        return WidgetLayoutType.Companion.getLayoutTypeIndexfromName((View) this.f70865a.get(i2));
    }
}
