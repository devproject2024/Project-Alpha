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

public final class h extends RecyclerView.v implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30369a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30370b;

    /* renamed from: c  reason: collision with root package name */
    private View f30371c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.detail_label);
        if (textView != null) {
            this.f30369a = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.detail_value);
            if (textView2 != null) {
                this.f30370b = textView2;
                View findViewById = view.findViewById(R.id.separator_view);
                if (findViewById != null) {
                    this.f30371c = findViewById;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.View");
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
            this.f30369a.setText(orderSummaryFiled.getLabel());
            this.f30370b.setText(orderSummaryFiled.getValue());
            if (aVar.d()) {
                this.f30371c.setVisibility(0);
                if (context != null) {
                    this.f30370b.setTextSize(0, context.getResources().getDimension(R.dimen.dimen_24sp));
                    return;
                }
                return;
            }
            this.f30371c.setVisibility(8);
            if (context != null) {
                this.f30370b.setTextSize(0, context.getResources().getDimension(R.dimen.dimen_18sp));
            }
        }
    }
}
