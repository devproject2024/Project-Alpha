package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.a;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class i extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30372a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f30373b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.header_tv);
        if (textView != null) {
            this.f30372a = textView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_payment_details);
            if (recyclerView != null) {
                this.f30373b = recyclerView;
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        if (orderSummaryBodyItem != null) {
            this.f30372a.setText(orderSummaryBodyItem.getHeading());
            ArrayList<net.one97.travelpass.ordersummary.g.a> c2 = aVar.c();
            k.a((Object) c2, "viewHolderModel.viewHolderData");
            net.one97.travelpass.ordersummary.a.b bVar2 = new net.one97.travelpass.ordersummary.a.b(context, c2, bVar);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
            RecyclerView recyclerView = this.f30373b;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            RecyclerView recyclerView2 = this.f30373b;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(bVar2);
            }
        }
    }
}
