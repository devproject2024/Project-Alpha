package net.one97.paytm.o2o.movies.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.widgets.callback.ActivityListener;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;
import kotlin.u;

public final class aa extends RecyclerView.a<CLPBaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends View> f74244a = w.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final IGAHandlerListener f74245b;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentActivity f74246c;

    public aa(IGAHandlerListener iGAHandlerListener, FragmentActivity fragmentActivity) {
        k.c(iGAHandlerListener, "mCarouselClickedListener");
        k.c(fragmentActivity, "fragmentActivity");
        this.f74245b = iGAHandlerListener;
        this.f74246c = fragmentActivity;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CLPBaseViewHolder cLPBaseViewHolder = (CLPBaseViewHolder) vVar;
        k.c(cLPBaseViewHolder, "holder");
        cLPBaseViewHolder.bind((View) this.f74244a.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        int parseViewType = ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2));
        j supportFragmentManager = this.f74246c.getSupportFragmentManager();
        IGAHandlerListener iGAHandlerListener = this.f74245b;
        CustomAction.Builder builder = new CustomAction.Builder();
        FragmentActivity fragmentActivity = this.f74246c;
        if (fragmentActivity != null) {
            CLPBaseViewHolder viewHolder = ViewHolderFactory.getViewHolder(viewGroup, parseViewType, supportFragmentManager, iGAHandlerListener, builder.hostActivityListener((ActivityListener) fragmentActivity).build());
            k.a((Object) viewHolder, "ViewHolderFactory.getVie…ctivityListener).build())");
            return viewHolder;
        }
        throw new u("null cannot be cast to non-null type com.paytmmall.clpartifact.widgets.callback.ActivityListener");
    }

    public final int getItemViewType(int i2) {
        return WidgetLayoutType.Companion.getLayoutTypeIndexfromName((View) this.f74244a.get(i2));
    }

    public final int getItemCount() {
        return this.f74244a.size();
    }
}
