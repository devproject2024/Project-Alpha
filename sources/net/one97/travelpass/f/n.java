package net.one97.travelpass.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.one97.travelpass.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.travelpass.R;
import net.one97.travelpass.ordersummary.model.OrderSummaryFiled;

public final class n extends RecyclerView.v implements com.one97.travelpass.a.a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f30386a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f30387b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30388c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30389d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(View view) {
        super(view);
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.detail_label);
        if (textView != null) {
            this.f30386a = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.detail_value);
            if (textView2 != null) {
                this.f30387b = textView2;
                TextView textView3 = (TextView) view.findViewById(R.id.sub_value);
                if (textView3 != null) {
                    this.f30388c = textView3;
                    TextView textView4 = (TextView) view.findViewById(R.id.wallet_details);
                    if (textView4 != null) {
                        this.f30389d = textView4;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
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
            this.f30386a.setText(orderSummaryFiled.getLabel());
            this.f30387b.setText(orderSummaryFiled.getValue());
            this.f30388c.setText(orderSummaryFiled.getSubContent());
            this.f30389d.setText(orderSummaryFiled.getDeepLinkText());
            this.f30389d.setOnClickListener(new a(bVar, aVar));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f30390a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.travelpass.ordersummary.g.a f30391b;

        a(b bVar, net.one97.travelpass.ordersummary.g.a aVar) {
            this.f30390a = bVar;
            this.f30391b = aVar;
        }

        public final void onClick(View view) {
            b bVar = this.f30390a;
            if (bVar != null) {
                b.a.a(bVar, this.f30391b, (Integer) null, 6);
            }
        }
    }
}
