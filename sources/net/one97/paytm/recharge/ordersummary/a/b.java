package net.one97.paytm.recharge.ordersummary.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.shopping.LayoutType;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.d.g;
import net.one97.paytm.recharge.common.widget.f;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f63974a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView.a f63975b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Object> f63976c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private List<View> f63977d;

    public b(Context context, RecyclerView.a aVar, List<View> list) {
        this.f63974a = context;
        this.f63975b = aVar;
        this.f63977d = list;
        this.f63976c.addAll(list);
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                View view = list.get(i2);
                if (view.getType().equalsIgnoreCase(ViewHolderFactory.TYPE_SMART_ICON_GRID) || view.getType().equalsIgnoreCase(ViewHolderFactory.TYPE_CAROUSEL_1)) {
                    LayoutType layoutType = view.getType().equalsIgnoreCase(ViewHolderFactory.TYPE_CAROUSEL_1) ? LayoutType.LAYOUT_CAROUSEL1 : LayoutType.LAYOUT_SMART_ICON_GRID;
                    f fVar = new f();
                    if (!(layoutType == null || context == null)) {
                        if (layoutType == LayoutType.LAYOUT_SMART_ICON_GRID) {
                            fVar.f62156a = context.getString(R.string.v8_os_do_more_with_paytm);
                        } else if (layoutType == LayoutType.LAYOUT_CAROUSEL1) {
                            fVar.f62156a = context.getString(R.string.v8_os_deals_for_you);
                        }
                    }
                    this.f63976c.add(i2, fVar);
                }
            }
        }
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutType fromIndex = LayoutType.fromIndex(i2);
        if (fromIndex == null || fromIndex != LayoutType.LAYOUT_RECHARGE_HEADER_WIDGET) {
            return this.f63975b.onCreateViewHolder(viewGroup, i2);
        }
        return new g(LayoutInflater.from(this.f63974a).inflate(R.layout.storefront_header_view, viewGroup, false));
    }

    public final int getItemCount() {
        return this.f63976c.size();
    }

    public final int getItemViewType(int i2) {
        if (this.f63976c.get(i2) instanceof f) {
            return LayoutType.LAYOUT_RECHARGE_HEADER_WIDGET.getIndex();
        }
        return ViewHolderFactory.getViewType(this.f63977d.get(this.f63977d.indexOf(this.f63976c.get(i2))).getType());
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        LayoutType layoutType;
        if (this.f63976c.get(i2) instanceof f) {
            layoutType = LayoutType.LAYOUT_RECHARGE_HEADER_WIDGET;
        } else {
            layoutType = LayoutType.LAYOUT_IGNORE_TYPE;
        }
        if (layoutType == null || layoutType != LayoutType.LAYOUT_RECHARGE_HEADER_WIDGET) {
            this.f63975b.onBindViewHolder(vVar, this.f63977d.indexOf(this.f63976c.get(i2)));
            return;
        }
        ArrayList<Object> arrayList = this.f63976c;
        if (arrayList != null && arrayList.size() > 0) {
            Object obj = this.f63976c.get(i2);
            if (obj instanceof f) {
                ((TextView) vVar.itemView).setText(((f) obj).f62156a);
            }
        }
    }
}
