package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.a;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryFiled;

public final class k extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30376a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30377b;

    /* renamed from: c  reason: collision with root package name */
    private View f30378c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(View view) {
        super(view);
        if (view == null) {
            kotlin.g.b.k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.detail_label);
        if (textView != null) {
            this.f30376a = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.detail_value);
            if (textView2 != null) {
                this.f30377b = textView2;
                View findViewById = view.findViewById(R.id.separator_view);
                if (findViewById != null) {
                    this.f30378c = findViewById;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.View");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        kotlin.g.b.k.c(aVar, "viewHolderModel");
        kotlin.g.b.k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryFiled)) {
            a2 = null;
        }
        OrderSummaryFiled orderSummaryFiled = (OrderSummaryFiled) a2;
        if (orderSummaryFiled != null) {
            this.f30376a.setText(orderSummaryFiled.getLabel());
            this.f30377b.setText(orderSummaryFiled.getValue());
            if (aVar.g()) {
                this.f30378c.setVisibility(0);
            } else {
                this.f30378c.setVisibility(8);
            }
        }
    }
}
