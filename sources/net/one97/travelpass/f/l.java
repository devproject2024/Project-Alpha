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
import net.one97.travelpass.ordersummary.model.OrderSummaryFiled;

public final class l extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30379a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30380b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30381c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.detail_label);
        if (textView != null) {
            this.f30379a = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.detail_value);
            if (textView2 != null) {
                this.f30380b = textView2;
                TextView textView3 = (TextView) view.findViewById(R.id.sub_value);
                if (textView3 != null) {
                    this.f30381c = textView3;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void a(Context context, int i2, net.one97.travelpass.ordersummary.g.a aVar, b bVar) {
        k.c(aVar, "viewHolderModel");
        k.c(bVar, "itemClickListener");
        IJRPaytmDataModel a2 = aVar.a();
        if (!(a2 instanceof OrderSummaryFiled)) {
            a2 = null;
        }
        OrderSummaryFiled orderSummaryFiled = (OrderSummaryFiled) a2;
        if (orderSummaryFiled != null) {
            this.f30379a.setText(orderSummaryFiled.getLabel());
            this.f30380b.setText(orderSummaryFiled.getValue());
            this.f30381c.setText(orderSummaryFiled.getSubContent());
        }
    }
}
