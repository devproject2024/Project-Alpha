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
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class e extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f30357a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30358b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_pass_details);
        this.f30357a = !(recyclerView instanceof RecyclerView) ? null : recyclerView;
        TextView textView = (TextView) view.findViewById(R.id.section_header);
        this.f30358b = !(textView instanceof TextView) ? null : textView;
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        String str = null;
        if (!(a2 instanceof OrderSummaryBodyItem)) {
            a2 = null;
        }
        OrderSummaryBodyItem orderSummaryBodyItem = (OrderSummaryBodyItem) a2;
        ArrayList<net.one97.travelpass.ordersummary.g.a> c2 = aVar.c();
        k.a((Object) c2, "viewHolderModel.viewHolderData");
        net.one97.travelpass.ordersummary.a.b bVar2 = new net.one97.travelpass.ordersummary.a.b(context, c2, bVar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        RecyclerView recyclerView = this.f30357a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.f30357a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(bVar2);
        }
        TextView textView = this.f30358b;
        if (textView != null) {
            if (orderSummaryBodyItem != null) {
                str = orderSummaryBodyItem.getHeading();
            }
            textView.setText(str);
        }
    }
}
