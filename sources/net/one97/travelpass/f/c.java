package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.a;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryBodyItem;

public final class c extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30349a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30350b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.cashback);
        if (textView != null) {
            this.f30349a = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.cashback_detail);
            if (textView2 != null) {
                this.f30350b = textView2;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
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
            this.f30349a.setText(orderSummaryBodyItem.getHeading());
            this.f30350b.setText(orderSummaryBodyItem.getBody());
        }
    }
}
